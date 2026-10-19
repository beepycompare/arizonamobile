package com.arizona.launcher;

import android.app.ActivityManager;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.game.BuildConfig;
import com.arizona.game.GTASA;
import com.arizona.game.R;
import com.arizona.launcher.ArchiveForegroundPromotion;
import com.arizona.launcher.UpdateAnalyticsReporter;
import com.arizona.launcher.UpdateOperationBeginResult;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.apk.LauncherApkLocalStorageFailure;
import com.arizona.launcher.updater.apk.LauncherApkProgress;
import com.arizona.launcher.updater.apk.LauncherUpdateConfig;
import com.arizona.launcher.updater.archive.adoption.ArchiveInstallAdopter;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadGuardTaggingInterceptor;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadNetworkGuardInterceptor;
import com.arizona.launcher.updater.archive.download.SafeArchiveDns;
import com.arizona.launcher.updater.archive.manifest.OriginalTzViceCityManifestSectionException;
import com.arizona.launcher.updater.archive.manifest.OriginalTzViceCityManifestSectionExtractor;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveContentCollisionGuard;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadRootResolver;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveInstallerPhase;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveLaneDownloadSequence;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveLaneOwnership;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMetadataFinalizationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageArtifactCleaner;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditUnavailableReason;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveDownloadEstimator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStartupGuard;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStartupInspection;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageRequirementsSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceCheckResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckBlockCode;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateTransactionLock;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterStorageRoots;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterStorageScope;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceCleanupRequest;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationAction;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationController;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationControllerKt;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationEvaluation;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationMigration;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationStore;
import com.arizona.launcher.updater.archive.planner.ArchivePlanReason;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditor;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadMismatch;
import com.arizona.launcher.updater.http.UpdateMetadataFetcher;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import com.arizona.launcher.util.FileServers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.miami.game.core.settings.SettingsMenuDefaults;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000¼\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 è\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0010è\u0002é\u0002ê\u0002ë\u0002ì\u0002í\u0002î\u0002ï\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020.H\u0002J\u0012\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020BH\u0002J\b\u0010V\u001a\u00020WH\u0002J\u000e\u0010X\u001a\u00020YH\u0082@¢\u0006\u0002\u0010ZJ\u0016\u0010[\u001a\u00020Y2\u0006\u0010\\\u001a\u00020.H\u0082@¢\u0006\u0002\u0010]J\u0018\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020Y2\u0006\u0010`\u001a\u00020YH\u0002J\b\u0010a\u001a\u00020.H\u0002J&\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020I2\u0006\u0010e\u001a\u00020?2\u0006\u0010U\u001a\u00020BH\u0082@¢\u0006\u0002\u0010fJ\u0018\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020jH\u0082@¢\u0006\u0002\u0010kJ.\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020r2\u0006\u0010i\u001a\u00020jH\u0082@¢\u0006\u0002\u0010sJ(\u0010t\u001a\u00020u2\u0006\u0010d\u001a\u00020I2\u0006\u0010q\u001a\u00020r2\u0006\u0010i\u001a\u00020j2\u0006\u0010p\u001a\u00020oH\u0002J \u0010v\u001a\u00020w2\u0006\u0010q\u001a\u00020r2\u0006\u0010i\u001a\u00020j2\u0006\u0010p\u001a\u00020oH\u0002J\u001c\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020{2\b\u0010|\u001a\u0004\u0018\u00010{H\u0002J\b\u0010}\u001a\u00020.H\u0002J\b\u0010~\u001a\u00020.H\u0002J\u0013\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010d\u001a\u00020IH\u0002J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u00010oH\u0002J\t\u0010\u0082\u0001\u001a\u00020.H\u0002J\u001d\u0010\u0083\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020j2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u0086\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020j2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u0087\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020j2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u0088\u0001\u001a\u00020Q2\u0007\u0010\u0084\u0001\u001a\u00020j2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002JP\u0010\u0089\u0001\u001a\u00020Q2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0084\u0001\u001a\u00020j2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000e2!\u0010\u008c\u0001\u001a\u001c\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0090\u00010\u008d\u0001H\u0002¢\u0006\u0003\u0010\u0091\u0001J)\u0010\u0092\u0001\u001a\u0003H\u0093\u0001\"\u0005\b\u0000\u0010\u0093\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0093\u00010\u0095\u0001H\u0082@¢\u0006\u0003\u0010\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020.2\u0007\u0010\u0098\u0001\u001a\u00020.H\u0002J\t\u0010\u0099\u0001\u001a\u00020QH\u0002J\t\u0010\u009a\u0001\u001a\u00020QH\u0002JH\u0010\u009b\u0001\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0084\u0001\u001a\u00020j2\u0007\u0010\u009c\u0001\u001a\u00020.2\t\b\u0002\u0010\u009d\u0001\u001a\u00020j2\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010oH\u0002J\u001c\u0010\u009f\u0001\u001a\u00020Q2\u0007\u0010 \u0001\u001a\u00020m2\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0002J\u0019\u0010£\u0001\u001a\u0004\u0018\u00010j2\u0006\u0010q\u001a\u00020rH\u0002¢\u0006\u0003\u0010¤\u0001J\u001a\u0010¥\u0001\u001a\u00020.2\u0006\u0010q\u001a\u00020r2\u0007\u0010¦\u0001\u001a\u00020jH\u0002J\u001a\u0010§\u0001\u001a\u00020.2\u0006\u0010q\u001a\u00020r2\u0007\u0010¦\u0001\u001a\u00020jH\u0002J\t\u0010¨\u0001\u001a\u00020QH\u0002J*\u0010©\u0001\u001a\u00030\u008b\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\b\u0010¬\u0001\u001a\u00030\u008b\u00012\b\u0010\u00ad\u0001\u001a\u00030\u008b\u0001H\u0016J\u0015\u0010®\u0001\u001a\u00030¯\u00012\t\b\u0002\u0010°\u0001\u001a\u00020.H\u0002J\t\u0010±\u0001\u001a\u00020.H\u0002J\t\u0010²\u0001\u001a\u00020.H\u0002J\f\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0002J\t\u0010µ\u0001\u001a\u00020.H\u0002J\u0013\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020.H\u0002J\t\u0010¹\u0001\u001a\u00020QH\u0002J\u0016\u0010º\u0001\u001a\u0005\u0018\u00010»\u00012\b\u0010ª\u0001\u001a\u00030«\u0001H\u0016J\u0013\u0010¼\u0001\u001a\u00020.2\b\u0010ª\u0001\u001a\u00030«\u0001H\u0016J\u0013\u0010½\u0001\u001a\u00020Q2\b\u0010ª\u0001\u001a\u00030«\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020QH\u0016J\u0015\u0010¿\u0001\u001a\u00020Q2\n\u0010À\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\t\u0010Á\u0001\u001a\u00020QH\u0002J\t\u0010Â\u0001\u001a\u00020.H\u0002J\u001a\u0010Ã\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010Ä\u0001\u001a\u00020.H\u0016¢\u0006\u0003\u0010Å\u0001J\u001b\u0010Æ\u0001\u001a\u00020.2\u0007\u0010Ä\u0001\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u001b\u0010Ç\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u0012\u0010È\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.H\u0016J\u001a\u0010É\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.2\u0006\u0010n\u001a\u00020oH\u0016J\u001a\u0010Ê\u0001\u001a\u00020Q2\u0006\u0010p\u001a\u00020o2\u0007\u0010Ë\u0001\u001a\u00020oH\u0016J\u0012\u0010Ì\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.H\u0016J%\u0010Í\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.2\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0007\u0010Ð\u0001\u001a\u00020oH\u0016J&\u0010Ñ\u0001\u001a\u00020Q2\u0007\u0010Ä\u0001\u001a\u00020.2\u0007\u0010Ò\u0001\u001a\u00020.2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010Ô\u0001\u001a\u00020r2\u0007\u0010Ä\u0001\u001a\u00020.H\u0002J\u0012\u0010Õ\u0001\u001a\u00020Q2\u0007\u0010Ö\u0001\u001a\u00020.H\u0002JO\u0010×\u0001\u001a\u00020Q2\b\u0010Ø\u0001\u001a\u00030Ù\u00012\u0007\u0010Ú\u0001\u001a\u00020.2\t\b\u0002\u0010Û\u0001\u001a\u00020.2\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010o2\f\b\u0002\u0010Ü\u0001\u001a\u0005\u0018\u00010Ï\u00012\u000b\b\u0002\u0010Ð\u0001\u001a\u0004\u0018\u00010oH\u0002J\t\u0010Ý\u0001\u001a\u00020.H\u0002J\t\u0010Þ\u0001\u001a\u00020QH\u0002J\u0007\u0010ß\u0001\u001a\u00020QJ\t\u0010à\u0001\u001a\u00020.H\u0002J\t\u0010á\u0001\u001a\u00020jH\u0002J\t\u0010â\u0001\u001a\u00020jH\u0002J\n\u0010ã\u0001\u001a\u00030ä\u0001H\u0002J\u001b\u0010å\u0001\u001a\u00020j2\u0007\u0010æ\u0001\u001a\u00020j2\u0007\u0010ç\u0001\u001a\u00020jH\u0002J\t\u0010è\u0001\u001a\u00020.H\u0016J\f\u0010é\u0001\u001a\u0005\u0018\u00010ê\u0001H\u0016J\u0011\u0010ë\u0001\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0003\u0010ì\u0001J\u0012\u0010í\u0001\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u0012\u0010î\u0001\u001a\u00020Q2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u001d\u0010ï\u0001\u001a\u00020Q2\u0007\u0010ð\u0001\u001a\u00020.2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010rH\u0016J\t\u0010ò\u0001\u001a\u00020QH\u0016J\u001b\u0010ó\u0001\u001a\u00020Q2\u0007\u0010ô\u0001\u001a\u00020o2\u0007\u0010õ\u0001\u001a\u00020.H\u0016J\u0012\u0010ö\u0001\u001a\u00020Q2\u0007\u0010÷\u0001\u001a\u00020oH\u0016J\t\u0010ø\u0001\u001a\u00020QH\u0016J\t\u0010ù\u0001\u001a\u00020QH\u0016J\t\u0010ú\u0001\u001a\u00020QH\u0002J\u0014\u0010û\u0001\u001a\u00030ü\u00012\b\u0010ý\u0001\u001a\u00030ä\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0016J\u001b\u0010\u0080\u0002\u001a\u00020Q2\u0007\u0010\u0081\u0002\u001a\u00020j2\u0007\u0010\u0082\u0002\u001a\u00020.H\u0016J\f\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0084\u0002H\u0016J\u0012\u0010\u0085\u0002\u001a\u00030\u0086\u00022\u0006\u0010i\u001a\u00020jH\u0016J\u001c\u0010\u0087\u0002\u001a\u00030\u0088\u00022\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010{H\u0096@¢\u0006\u0003\u0010\u008a\u0002J\t\u0010\u008b\u0002\u001a\u00020QH\u0002J\u0013\u0010\u008c\u0002\u001a\u00020Q2\b\u0010ý\u0001\u001a\u00030ä\u0001H\u0016J\u0018\u0010\u008d\u0002\u001a\u00020Q2\r\u0010Ø\u0001\u001a\b0\u008e\u0002j\u0003`\u008f\u0002H\u0016J\u0018\u0010\u0090\u0002\u001a\u00020Q2\r\u0010Ø\u0001\u001a\b0\u008e\u0002j\u0003`\u008f\u0002H\u0016J\t\u0010\u0091\u0002\u001a\u00020QH\u0016J\t\u0010\u0092\u0002\u001a\u00020QH\u0002J\u0013\u0010\u0093\u0002\u001a\u00020Q2\b\u0010Î\u0001\u001a\u00030\u0094\u0002H\u0016J\f\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0002J-\u0010\u0097\u0002\u001a\u0004\u0018\u00010.2\f\b\u0002\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0096\u00022\f\b\u0002\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0002¢\u0006\u0003\u0010\u009a\u0002J\u0012\u0010\u009b\u0002\u001a\u00030\u0086\u00022\u0006\u0010i\u001a\u00020jH\u0002J\t\u0010\u009c\u0002\u001a\u00020\u0015H\u0002J\t\u0010\u009d\u0002\u001a\u00020?H\u0002J\t\u0010\u009e\u0002\u001a\u00020BH\u0002JJ\u0010\u009f\u0002\u001a\u00020Q2\u0007\u0010\u009e\u0001\u001a\u00020o2\t\b\u0002\u0010 \u0002\u001a\u00020'2\f\b\u0002\u0010¡\u0002\u001a\u0005\u0018\u00010¢\u00022\u000b\b\u0002\u0010£\u0002\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jH\u0002¢\u0006\u0003\u0010¤\u0002J\u0012\u0010¥\u0002\u001a\u00020Q2\u0007\u0010¸\u0001\u001a\u00020.H\u0002J1\u0010¦\u0002\u001a\u00020Q2\b\u0010§\u0002\u001a\u00030¨\u00022\t\b\u0002\u0010©\u0002\u001a\u00020\n2\u000b\b\u0002\u0010ª\u0002\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0003\u0010«\u0002J\u000b\u0010¬\u0002\u001a\u0004\u0018\u00010#H\u0002J\t\u0010\u00ad\u0002\u001a\u00020.H\u0002J\t\u0010®\u0002\u001a\u00020oH\u0002J\u0013\u0010®\u0002\u001a\u00020o2\b\u0010¯\u0002\u001a\u00030°\u0002H\u0002J\u0012\u0010±\u0002\u001a\u00020Q2\u0007\u0010©\u0002\u001a\u00020\nH\u0002J\u0013\u0010²\u0002\u001a\u00020Q2\b\u0010³\u0002\u001a\u00030´\u0002H\u0002J0\u0010µ\u0002\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010³\u0002\u001a\u00030´\u00022\u0010\b\u0002\u0010¶\u0002\u001a\t\u0012\u0004\u0012\u00020Q0\u0095\u0001H\u0002J\u0014\u0010·\u0002\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u001f\u0010¸\u0002\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0002\u0010¹\u0002\u001a\u00020.H\u0002J\t\u0010º\u0002\u001a\u00020QH\u0002J\u0014\u0010»\u0002\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\t\u0010¼\u0002\u001a\u00020QH\u0002J\t\u0010½\u0002\u001a\u00020.H\u0002J\t\u0010¾\u0002\u001a\u00020QH\u0002J\t\u0010¿\u0002\u001a\u00020QH\u0002J\f\u0010À\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0002J\u0011\u0010Á\u0002\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0003\u0010ì\u0001J\u0011\u0010Â\u0002\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0003\u0010ì\u0001J\u0012\u0010Ã\u0002\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u0012\u0010Ä\u0002\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\t\u0010Å\u0002\u001a\u00020QH\u0016J#\u0010Æ\u0002\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\u0007\u0010Ç\u0002\u001a\u00020.2\u0007\u0010\u009c\u0001\u001a\u00020.H\u0016J\t\u0010È\u0002\u001a\u00020.H\u0016J\f\u0010É\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0016J\t\u0010Ê\u0002\u001a\u00020QH\u0016J6\u0010Ë\u0002\u001a\u00020Q2\u0007\u0010Ì\u0002\u001a\u00020j2\t\u0010Í\u0002\u001a\u0004\u0018\u00010j2\b\u0010Î\u0002\u001a\u00030\u008b\u00012\u0007\u0010Ï\u0002\u001a\u00020.H\u0016¢\u0006\u0003\u0010Ð\u0002J\u0012\u0010Ñ\u0002\u001a\u00020Q2\u0007\u0010Í\u0002\u001a\u00020jH\u0016JC\u0010Ò\u0002\u001a\u00020Q2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u009c\u0001\u001a\u00020.2\u0007\u0010Ó\u0002\u001a\u00020.2\u0007\u0010Ô\u0002\u001a\u00020.2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010o2\n\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u0002H\u0016J\u0013\u0010×\u0002\u001a\u00020Q2\b\u0010Ø\u0001\u001a\u00030Ø\u0002H\u0016J\t\u0010Ù\u0002\u001a\u00020QH\u0002J\u0011\u0010Ú\u0002\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0003\u0010ì\u0001J\u0012\u0010Û\u0002\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\u0012\u0010Ü\u0002\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020jH\u0016J\"\u0010Ý\u0002\u001a\u00020Q2\r\u0010Ø\u0001\u001a\b0\u008e\u0002j\u0003`\u008f\u00022\b\u0010Þ\u0002\u001a\u00030ß\u0002H\u0016J\u0013\u0010à\u0002\u001a\u00020Q2\b\u0010Ü\u0001\u001a\u00030á\u0002H\u0016J\t\u0010â\u0002\u001a\u00020QH\u0016J\t\u0010ã\u0002\u001a\u00020QH\u0016J\u0012\u0010ä\u0002\u001a\u00020Q2\u0007\u0010©\u0002\u001a\u00020.H\u0016J\u0014\u0010å\u0002\u001a\u00020Q2\t\b\u0002\u0010æ\u0002\u001a\u00020.H\u0002J.\u0010ç\u0002\u001a\u00020Q2\b\u0010Ø\u0001\u001a\u00030Ù\u00012\f\b\u0002\u0010Ü\u0001\u001a\u0005\u0018\u00010Ï\u00012\u000b\b\u0002\u0010Ð\u0001\u001a\u0004\u0018\u00010oH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0003\bñ\u0002Ê\u0001\u000e\bò\u0002\u0012\t\bó\u0002\u0012\u0004\b\u0003\u0010\u0000¨\u0006ð\u0002"}, d2 = {"Lcom/arizona/launcher/UpdateService;", "Landroid/app/Service;", "Lcom/arizona/launcher/LauncherUpdateServiceHost;", "Lcom/arizona/launcher/GameUpdateServiceHost;", "Lcom/arizona/launcher/ArchiveUpdateServiceHost;", "Lcom/arizona/launcher/FileCheckServiceHost;", "<init>", "()V", "mUpdateStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/arizona/launcher/UpdateService$UpdateStatus;", "mGameStatus", "Lcom/arizona/launcher/UpdateService$GameStatus;", "mMessenger", "Landroid/os/Messenger;", "mActivityMessenger", "mInHandler", "Lcom/arizona/launcher/UpdateService$IncomingHandler;", "serviceHandlerThread", "Landroid/os/HandlerThread;", "archiveSession", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "viceArchiveSession", "archiveStorageSpaceChecker", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker;", "transferProgress", "Lcom/arizona/launcher/UpdateTransferProgress;", "launcherReadyPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getLauncherReadyPreferences", "()Landroid/content/SharedPreferences;", "launcherReadyPreferences$delegate", "Lkotlin/Lazy;", "archiveInstallerPhase", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "archiveNetworkPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLastOperationStatus", "Lcom/arizona/launcher/UpdateService$Errno;", "mainHandler", "Landroid/os/Handler;", "serviceAlive", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "foregroundServiceActive", "", "updateOperationCoordinator", "Lcom/arizona/launcher/UpdateOperationCoordinator;", "analyticsReporter", "Lcom/arizona/launcher/UpdateAnalyticsReporter;", "metadataFetcher", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "gameUpdateFlow", "Lcom/arizona/launcher/GameUpdateServiceFlow;", "archiveUpdateFlow", "Lcom/arizona/launcher/ArchiveUpdateServiceFlow;", "viceArchiveUpdateFlow", "fileCheckFlow", "Lcom/arizona/launcher/FileCheckServiceFlow;", "launcherUpdateFlow", "Lcom/arizona/launcher/LauncherUpdateServiceFlow;", "archiveStateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "viceArchiveStateStore", "archiveStateMaintenance", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStateMaintenance;", "viceArchiveStateMaintenance", "resourceGeneration", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationController;", "viceCityManifestExtractor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzViceCityManifestSectionExtractor;", "activeArchiveScope", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "continueWithViceAfterBase", "viceContentAvailable", "combinedArchiveProgress", "Lcom/arizona/launcher/CombinedArchiveTransferProgress;", "viceCityMutationActive", "refreshAfterViceCityMutation", "onCreate", "", "isGameDownloadRetryEnabled", "detectArchiveStartupGuard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "maintenance", "selectedArchiveGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "auditEnabledArchiveContent", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auditArchiveContent", "fullIntegrity", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "combineArchiveAudits", TtmlNode.RUBY_BASE, "vice", "shouldAuditViceContent", "auditFinalizationMetadataIfNeeded", "Lcom/arizona/launcher/UpdateService$ArchiveFinalizationAudit;", "scope", "stateStore", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStateMaintenance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPrimaryGameCheckPreflight", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "operationToken", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareGameUpdateCheck", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "server", "kind", "Lcom/arizona/launcher/UpdateOperationKind;", "(Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/UpdateOperationKind;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "archiveCheckCoordinator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;", "archiveIndexRetryListener", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "resourceCleanupRequest", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupRequest;", "baseRemote", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "viceRemote", "resourceLanesReady", "gameActivityExists", "archiveStorageRoots", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "currentArchiveLaneCollisionDetail", "isViceCityEnabled", "queryViceCityContent", UpdateServiceContract.BundleKey.REQUEST_ID, "recipient", "retainViceCityContent", "deleteViceCityContent", "activateViceCityContent", "launchViceCityRequest", "messageCode", "", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/UpdateService$ViceCityRequestResult;", "", "(IJLandroid/os/Messenger;Lkotlin/jvm/functions/Function1;)V", "withViceCityArchiveLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistViceCityPreference", "enabled", "recoverPendingViceCityDelete", "dispatchPendingViceCityRefresh", "sendViceCityContentResult", FirebaseAnalytics.Param.SUCCESS, "sizeBytes", UpdateServiceContract.BundleKey.DETAIL, "onPreparedGameUpdateCheck", "decision", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "beginUpdateOperation", "(Lcom/arizona/launcher/UpdateOperationKind;)Ljava/lang/Long;", "isCurrentUpdateOperation", "token", "finishUpdateOperation", "createNotificationChannel", "onStartCommand", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "flags", "startId", "startForegroundService", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult;", "allowAcceptedStartFromBackground", "isDeviceOnline", "isDeviceNetworkValidated", "activeNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "isAppInForeground", "createNotification", "Landroid/app/Notification;", "indeterminate", "stopForegroundService", "onBind", "Landroid/os/IBinder;", "onUnbind", "onRebind", "onDestroy", "onTaskRemoved", "rootIntent", "releaseServiceResources", "requestCheckUpdate", "beginGameCheckOperation", "combined", "(Z)Ljava/lang/Long;", "isCurrentGameCheckOperation", "finishGameCheckOperation", "onGameCheckStarted", "onGameMetadataLoaded", "onGameCheckMirrorRetry", "source", "completeGameCheckServerEmpty", "completeGameCheckMetadataFailed", "failure", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "failedServer", "completePreparedGameCheck", "successfully", "blockedCheck", "gameCheckOperationKind", "notifyGameUpdateCheckCompleted", "preparedSuccessfully", "notifyGameUpdateCheckUnreachable", "error", "Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "includeStatus", "resetUpdateStatus", "result", UpdateServiceContract.BundleKey.IS_GAME_DATA_UPDATE_EXISTS, "resetGameStatus", "updateGameData", "hasPendingViceArchiveWork", "plannedArchiveDownloadBytes", "remainingLaterArchiveLaneBytes", "combinedArchiveStorageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "saturatedAdd", "first", "second", "isArchiveServiceAlive", "activeUpdateOperation", "Lcom/arizona/launcher/UpdateOperationSnapshot;", "beginArchiveOperation", "()Ljava/lang/Long;", "isCurrentArchiveOperation", "finishArchiveOperation", "onArchiveRequestCoalesced", "activeDownload", "activeOperationKind", "onArchiveStartupCorrupt", "requestArchiveManifestRefresh", "reason", "warning", "setArchiveBenchmarkMode", UpdateActivity.UPDATE_MODE, "onArchiveDownloadSelected", "onArchiveNoWork", "reportArchiveDataReady", "checkArchiveStorageSpace", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceCheckResult;", DownloadService.KEY_REQUIREMENTS, "promoteArchiveForeground", "Lcom/arizona/launcher/ArchiveForegroundPromotion;", "beginArchiveProgress", "downloadBytes", "finalizationOnly", "createArchivePackageUpdater", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater;", "createArchiveMirrorCoordinator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator;", "finalizeArchiveMetadata", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "manifest", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMapCacheBestEffort", "expandArchiveRuntimeRequirements", "recordArchiveExecutionException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "recordArchiveFinalizationException", "completeArchiveSuccess", "completeArchiveSuccessTerminal", "completeArchiveFailure", "Lcom/arizona/launcher/ArchiveServiceFailure;", "archiveCacheAnchor", "Ljava/io/File;", "archiveStorageUsesSingleDevice", "gameRoot", "downloadStorageRoot", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/Boolean;", "archiveMirrorExecutionCoordinator", "activeArchiveSession", "activeArchiveStateStore", "activeArchiveStateMaintenance", "notifyArchiveUpdateFailure", "errno", "failureDetails", "Lcom/arizona/launcher/DownloadFailureDetails;", "requiredFreeSpaceBytes", "(Ljava/lang/String;Lcom/arizona/launcher/UpdateService$Errno;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)V", "updateStatusInfoAndProgress", "populateUpdateStatusSnapshot", "bundle", "Landroid/os/Bundle;", "status", "archiveIndeterminate", "(Landroid/os/Bundle;Lcom/arizona/launcher/UpdateService$UpdateStatus;Ljava/lang/Boolean;)V", "visibleArchiveInstallerPhase", "isArchiveProgressIndeterminate", UpdateServiceContract.BundleKey.TIME_LEFT, "progress", "Lcom/arizona/launcher/UpdateTransferProgressSnapshot;", "setUpdateStatus", "sendToActivity", "message", "Landroid/os/Message;", "sendToRecipient", "onFailure", "requestLauncherUpdateCheck", "requestLauncherApkDownload", "forceRedownload", "replayLauncherProgress", "sendLauncherUpdateRequired", "replayReadyLauncherApk", "hasReadyLauncherApk", "markReadyLauncherApk", "clearReadyLauncherApk", "launcherApkFile", "beginLauncherCheckOperation", "beginLauncherApkOperation", "isCurrentLauncherCheckOperation", "isCurrentLauncherApkOperation", "setLauncherOperationHealthy", "completeLauncherCheck", "needsUpdate", "promoteLauncherForeground", "externalFilesRoot", "beginLauncherProgress", "updateLauncherProgress", "downloadedBytes", "totalBytes", "attempt", "resumed", "(JLjava/lang/Long;IZ)V", "completeLauncherProgress", "completeLauncherApk", "markServerUnreachable", "deferResult", "localStorageFailure", "Lcom/arizona/launcher/updater/apk/LauncherApkLocalStorageFailure;", "recordLauncherException", "", "requestFullFileCheck", "beginFileCheckOperation", "isCurrentFileCheckOperation", "finishFileCheckOperation", "onFileCheckAuditFailure", "fallback", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Unavailable;", "onFileCheckRepairScheduled", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$RepairScheduled;", "markFileCheckRecoveryRequired", "markGameUpdateRequiredAfterFileCheck", "completeFullFileCheck", "requestCheckUpdateAndDownload", "restartMirrorCycle", "notifyCheckUpdateAndDownloadUnreachable", "Companion", "Errno", "UpdateStatus", "GameStatus", "ForegroundPromotionResult", "ArchiveFinalizationAudit", "ViceCityRequestResult", "IncomingHandler", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateService extends Hilt_UpdateService implements LauncherUpdateServiceHost, GameUpdateServiceHost, ArchiveUpdateServiceHost, FileCheckServiceHost {
    public static final String ACTION_START_FOREGROUND_SERVICE = "Start foreground";
    public static final String ACTION_STOP_FOREGROUND_SERVICE = "Stop foreground";
    public static final int ACTIVATE_VICE_CITY_CONTENT = 14;
    public static final String ARCHIVE_STORAGE_SAME_DEVICE_MSG = "archiveStorageSameDevice";
    private static final int BYTE_TO_KILOBYTE_DIVIDER = 1024;
    public static final int CHECK_AND_UPDATE = 10;
    public static final int CHECK_LAUNCHER_UPDATE = 3;
    public static final int CHECK_STATE_ERROR = 9;
    public static final int CHECK_UPDATE = 0;
    public static final int DELETE_VICE_CITY_CONTENT = 13;
    public static final String ERRNO_MSG = "errno";
    private static final int FOREGROUND_NOTIFICATION_ID = 1;
    public static final int FULL_CHECK = 8;
    public static final int GAME_STATUS = 5;
    private static final String LAUNCHER_READY_BYTES = "bytes";
    private static final String LAUNCHER_READY_FLAG = "ready";
    private static final String LAUNCHER_READY_PREFERENCES = "launcher_apk_ready";
    private static final String LAUNCHER_READY_SOURCE_VERSION_CODE = "source_version_code";
    private static final long LAUNCHER_RESULT_DELAY_MS = 3750;
    public static final String NEED_DOWNLOAD_FREE_SPACE_SIZE_MSG = "needDownloadFreeSpaceSize";
    public static final String NEED_FREE_SPACE_SIZE_MSG = "needFreeSpaceSize";
    public static final String NEED_GAME_FREE_SPACE_SIZE_MSG = "needGameFreeSpaceSize";
    public static final String NEED_UPDATE_MSG = "needUpdateMsg";
    public static final int QUERY_VICE_CITY_CONTENT = 11;
    public static final int RETAIN_VICE_CITY_CONTENT = 12;
    private static final String RETRY_FLAG_ARIZONA = "launcher_download_retry_arizona_enabled";
    private static final String RETRY_FLAG_BRAZIL = "launcher_download_retry_brazil_enabled";
    private static final String RETRY_FLAG_RODINA = "launcher_download_retry_rodina_enabled";
    private static final String TAG = "UPDATE_SERVICE";
    public static final int UPDATE_GAME_DATA = 2;
    public static final int UPDATE_INFO = 7;
    public static final int UPDATE_LAUNCHER = 6;
    private static final String UPDATE_SERVICE_CHANNEL_ID = "UpdateServiceChannelID";
    public static final int UPDATE_STATUS = 4;
    private static volatile String benchmarkObservedDownloadMode;
    private static volatile Boolean benchmarkRetryEnabledOverride;
    private UpdateAnalyticsReporter analyticsReporter;
    private ArchiveStateMaintenance archiveStateMaintenance;
    private DurableArchiveStateStore archiveStateStore;
    private ArchiveUpdateServiceFlow archiveUpdateFlow;
    private boolean continueWithViceAfterBase;
    private FileCheckServiceFlow fileCheckFlow;
    private volatile boolean foregroundServiceActive;
    private GameUpdateServiceFlow gameUpdateFlow;
    private LauncherUpdateServiceFlow launcherUpdateFlow;
    private volatile Messenger mActivityMessenger;
    private IncomingHandler mInHandler;
    private Messenger mMessenger;
    private UpdateMetadataFetcher metadataFetcher;
    private EngineResourceGenerationController resourceGeneration;
    private HandlerThread serviceHandlerThread;
    private ArchiveStateMaintenance viceArchiveStateMaintenance;
    private DurableArchiveStateStore viceArchiveStateStore;
    private ArchiveUpdateServiceFlow viceArchiveUpdateFlow;
    private volatile boolean viceContentAvailable;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private AtomicReference<UpdateStatus> mUpdateStatus = new AtomicReference<>(UpdateStatus.Undefined);
    private AtomicReference<GameStatus> mGameStatus = new AtomicReference<>(GameStatus.Undefined);
    private final ArchiveUpdateSessionState archiveSession = new ArchiveUpdateSessionState(null, null, 3, null);
    private final ArchiveUpdateSessionState viceArchiveSession = new ArchiveUpdateSessionState(null, null, 3, null);
    private final ArchiveStorageSpaceChecker archiveStorageSpaceChecker = ArchiveStorageSpaceChecker.Companion.android(new Function2() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return UpdateService.archiveStorageSpaceChecker$lambda$0((String) obj, (Exception) obj2);
        }
    });
    private final UpdateTransferProgress transferProgress = new UpdateTransferProgress(null, 1, null);
    private final Lazy launcherReadyPreferences$delegate = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SharedPreferences sharedPreferences;
            sharedPreferences = UpdateService.this.getSharedPreferences(UpdateService.LAUNCHER_READY_PREFERENCES, 0);
            return sharedPreferences;
        }
    });
    private final AtomicReference<ArchiveInstallerPhase> archiveInstallerPhase = new AtomicReference<>(null);
    private final AtomicBoolean archiveNetworkPending = new AtomicBoolean(false);
    private volatile Errno mLastOperationStatus = Errno.NoError;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean serviceAlive = new AtomicBoolean(false);
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    private final UpdateOperationCoordinator updateOperationCoordinator = new UpdateOperationCoordinator(0, 1, null);
    private final OriginalTzViceCityManifestSectionExtractor viceCityManifestExtractor = new OriginalTzViceCityManifestSectionExtractor();
    private volatile ArchiveUpdaterStorageScope activeArchiveScope = ArchiveUpdaterStorageScope.BASE;
    private final CombinedArchiveTransferProgress combinedArchiveProgress = new CombinedArchiveTransferProgress();
    private final AtomicBoolean viceCityMutationActive = new AtomicBoolean(false);
    private final AtomicBoolean refreshAfterViceCityMutation = new AtomicBoolean(false);

    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ArchiveUpdaterStorageScope.values().length];
            try {
                iArr[ArchiveUpdaterStorageScope.BASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveUpdaterStorageScope.VICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArchiveInstallerPhase.values().length];
            try {
                iArr2[ArchiveInstallerPhase.WAITING_FOR_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ArchiveInstallerPhase.VERIFYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ArchiveInstallerPhase.EXTRACTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ArchiveInstallerPhase.COMMITTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ArchiveInstallerPhase.RETIRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ArchiveInstallerPhase.DOWNLOADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ArchiveServiceFailureKind.values().length];
            try {
                iArr3[ArchiveServiceFailureKind.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ArchiveServiceFailureKind.CORRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ArchiveServiceFailureKind.INSUFFICIENT_STORAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ArchiveServiceFailureKind.STORAGE_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ArchiveServiceFailureKind.FOREGROUND_UNAVAILABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ArchiveServiceFailureKind.RECOVERY_BLOCKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[Errno.values().length];
            try {
                iArr4[Errno.ConnectionRefused.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[Errno.InsufficientStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[Errno.ForegroundServiceUnavailable.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[Errno.ArchiveRecoveryBlocked.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[Errno.UpdateServerUnreachable.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[Errno.StorageUnavailable.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[LauncherCheckRequestDisposition.values().length];
            try {
                iArr5[LauncherCheckRequestDisposition.ROUTE_TO_ACTIVE_APK.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[LauncherCheckRequestDisposition.REATTACH_ACTIVE_CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[LauncherCheckRequestDisposition.REPLAY_READY_APK.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[LauncherCheckRequestDisposition.START_CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[LauncherApkRequestDisposition.values().length];
            try {
                iArr6[LauncherApkRequestDisposition.REATTACH_ACTIVE_APK.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr6[LauncherApkRequestDisposition.REPLAY_READY_APK.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr6[LauncherApkRequestDisposition.START_APK.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[LauncherApkLocalStorageFailure.values().length];
            try {
                iArr7[LauncherApkLocalStorageFailure.INSUFFICIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr7[LauncherApkLocalStorageFailure.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    private final boolean isGameDownloadRetryEnabled() {
        return true;
    }

    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010*2\b\u00100\u001a\u0004\u0018\u00010*¢\u0006\u0002\u00101J\b\u00102\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/arizona/launcher/UpdateService$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_START_FOREGROUND_SERVICE", "ACTION_STOP_FOREGROUND_SERVICE", "CHECK_UPDATE", "", "UPDATE_GAME_DATA", "CHECK_LAUNCHER_UPDATE", "UPDATE_STATUS", "GAME_STATUS", "UPDATE_LAUNCHER", "UPDATE_INFO", "FULL_CHECK", "CHECK_STATE_ERROR", "CHECK_AND_UPDATE", "QUERY_VICE_CITY_CONTENT", "RETAIN_VICE_CITY_CONTENT", "DELETE_VICE_CITY_CONTENT", "ACTIVATE_VICE_CITY_CONTENT", "BYTE_TO_KILOBYTE_DIVIDER", "LAUNCHER_RESULT_DELAY_MS", "", "LAUNCHER_READY_PREFERENCES", "LAUNCHER_READY_FLAG", "LAUNCHER_READY_BYTES", "LAUNCHER_READY_SOURCE_VERSION_CODE", "NEED_UPDATE_MSG", "ERRNO_MSG", "NEED_FREE_SPACE_SIZE_MSG", "NEED_GAME_FREE_SPACE_SIZE_MSG", "NEED_DOWNLOAD_FREE_SPACE_SIZE_MSG", "ARCHIVE_STORAGE_SAME_DEVICE_MSG", "UPDATE_SERVICE_CHANNEL_ID", "FOREGROUND_NOTIFICATION_ID", "RETRY_FLAG_ARIZONA", "RETRY_FLAG_RODINA", "RETRY_FLAG_BRAZIL", "benchmarkRetryEnabledOverride", "", "Ljava/lang/Boolean;", "benchmarkObservedDownloadMode", "setBenchmarkDownloadModesForTests", "", "retryEnabled", "archiveEnabled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBenchmarkObservedDownloadModeForTests", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setBenchmarkDownloadModesForTests(Boolean bool, Boolean bool2) {
            throw new IllegalStateException("Benchmark download-mode overrides are disabled in this build".toString());
        }

        public final String getBenchmarkObservedDownloadModeForTests() {
            throw new IllegalStateException("Benchmark download-mode observation is disabled in this build".toString());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/UpdateService$Errno;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "NoError", "UpdateServerUnreachable", "ConnectionRefused", "CorruptedFilesFound", "InsufficientStorage", "ForegroundServiceUnavailable", "ArchiveRecoveryBlocked", "StorageUnavailable", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Errno {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Errno[] $VALUES;
        private final int code;
        private final String description;
        public static final Errno NoError = new Errno("NoError", 0, 0, "Ошибки нет");
        public static final Errno UpdateServerUnreachable = new Errno("UpdateServerUnreachable", 1, 1, "Сервер обновления недоступен или не найден");
        public static final Errno ConnectionRefused = new Errno("ConnectionRefused", 2, 2, "Соединение с сервером было прервано во время загрузки");
        public static final Errno CorruptedFilesFound = new Errno("CorruptedFilesFound", 3, 3, "Найдены поврежденные или неудаляемые игровые файлы");
        public static final Errno InsufficientStorage = new Errno("InsufficientStorage", 4, 4, "Недостаточно места для установки игровых файлов");
        public static final Errno ForegroundServiceUnavailable = new Errno("ForegroundServiceUnavailable", 5, 5, "Не удалось безопасно продолжить фоновое обновление");
        public static final Errno ArchiveRecoveryBlocked = new Errno("ArchiveRecoveryBlocked", 6, 6, "Архивную установку нельзя безопасно восстановить автоматически");
        public static final Errno StorageUnavailable = new Errno("StorageUnavailable", 7, 7, "Не удалось проверить свободное место для установки игровых файлов");

        private static final /* synthetic */ Errno[] $values() {
            return new Errno[]{NoError, UpdateServerUnreachable, ConnectionRefused, CorruptedFilesFound, InsufficientStorage, ForegroundServiceUnavailable, ArchiveRecoveryBlocked, StorageUnavailable};
        }

        public static EnumEntries<Errno> getEntries() {
            return $ENTRIES;
        }

        public static Errno valueOf(String str) {
            return (Errno) Enum.valueOf(Errno.class, str);
        }

        public static Errno[] values() {
            return (Errno[]) $VALUES.clone();
        }

        private Errno(String str, int i, int i2, String str2) {
            this.code = i2;
            this.description = str2;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        static {
            Errno[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/UpdateService$UpdateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "CheckUpdate", "CheckFiles", "DownloadGame", "DownloadGameData", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UpdateStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UpdateStatus[] $VALUES;
        public static final UpdateStatus Undefined = new UpdateStatus("Undefined", 0);
        public static final UpdateStatus CheckUpdate = new UpdateStatus("CheckUpdate", 1);
        public static final UpdateStatus CheckFiles = new UpdateStatus("CheckFiles", 2);
        public static final UpdateStatus DownloadGame = new UpdateStatus("DownloadGame", 3);
        public static final UpdateStatus DownloadGameData = new UpdateStatus("DownloadGameData", 4);

        private static final /* synthetic */ UpdateStatus[] $values() {
            return new UpdateStatus[]{Undefined, CheckUpdate, CheckFiles, DownloadGame, DownloadGameData};
        }

        public static EnumEntries<UpdateStatus> getEntries() {
            return $ENTRIES;
        }

        public static UpdateStatus valueOf(String str) {
            return (UpdateStatus) Enum.valueOf(UpdateStatus.class, str);
        }

        public static UpdateStatus[] values() {
            return (UpdateStatus[]) $VALUES.clone();
        }

        private UpdateStatus(String str, int i) {
        }

        static {
            UpdateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateService$GameStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "UnsupportedVersion", "UpdateRequired", "Updated", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GameStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GameStatus[] $VALUES;
        public static final GameStatus Undefined = new GameStatus("Undefined", 0);
        public static final GameStatus UnsupportedVersion = new GameStatus("UnsupportedVersion", 1);
        public static final GameStatus UpdateRequired = new GameStatus("UpdateRequired", 2);
        public static final GameStatus Updated = new GameStatus("Updated", 3);

        private static final /* synthetic */ GameStatus[] $values() {
            return new GameStatus[]{Undefined, UnsupportedVersion, UpdateRequired, Updated};
        }

        public static EnumEntries<GameStatus> getEntries() {
            return $ENTRIES;
        }

        public static GameStatus valueOf(String str) {
            return (GameStatus) Enum.valueOf(GameStatus.class, str);
        }

        public static GameStatus[] values() {
            return (GameStatus[]) $VALUES.clone();
        }

        private GameStatus(String str, int i) {
        }

        static {
            GameStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit archiveStorageSpaceChecker$lambda$0(String message, Exception error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e(TAG, message, error);
        return Unit.INSTANCE;
    }

    private final SharedPreferences getLauncherReadyPreferences() {
        return (SharedPreferences) this.launcherReadyPreferences$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult;", "", "Ready", "Rejected", "Reason", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Ready;", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Rejected;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ForegroundPromotionResult {

        /* compiled from: UpdateService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Ready;", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements ForegroundPromotionResult {
            public static final int $stable = 0;
            public static final Ready INSTANCE = new Ready();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Ready) {
                    Ready ready = (Ready) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1261397347;
            }

            public String toString() {
                return "Ready";
            }

            private Ready() {
            }
        }

        /* compiled from: UpdateService.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Rejected;", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult;", "reason", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Reason;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Reason;Ljava/lang/Exception;)V", "getReason", "()Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Reason;", "getCause", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Rejected implements ForegroundPromotionResult {
            public static final int $stable = 8;
            private final Exception cause;
            private final Reason reason;

            public static /* synthetic */ Rejected copy$default(Rejected rejected, Reason reason, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    reason = rejected.reason;
                }
                if ((i & 2) != 0) {
                    exc = rejected.cause;
                }
                return rejected.copy(reason, exc);
            }

            public final Reason component1() {
                return this.reason;
            }

            public final Exception component2() {
                return this.cause;
            }

            public final Rejected copy(Reason reason, Exception exc) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Rejected(reason, exc);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Rejected) {
                    Rejected rejected = (Rejected) obj;
                    return this.reason == rejected.reason && Intrinsics.areEqual(this.cause, rejected.cause);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.reason.hashCode() * 31;
                Exception exc = this.cause;
                return hashCode + (exc == null ? 0 : exc.hashCode());
            }

            public String toString() {
                Reason reason = this.reason;
                return "Rejected(reason=" + reason + ", cause=" + this.cause + ")";
            }

            public Rejected(Reason reason, Exception exc) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
                this.cause = exc;
            }

            public /* synthetic */ Rejected(Reason reason, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(reason, (i & 2) != 0 ? null : exc);
            }

            public final Reason getReason() {
                return this.reason;
            }

            public final Exception getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: UpdateService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "APP_IN_BACKGROUND", "SYSTEM_REJECTED", "UNEXPECTED_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Reason {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Reason[] $VALUES;
            public static final Reason APP_IN_BACKGROUND = new Reason("APP_IN_BACKGROUND", 0);
            public static final Reason SYSTEM_REJECTED = new Reason("SYSTEM_REJECTED", 1);
            public static final Reason UNEXPECTED_ERROR = new Reason("UNEXPECTED_ERROR", 2);

            private static final /* synthetic */ Reason[] $values() {
                return new Reason[]{APP_IN_BACKGROUND, SYSTEM_REJECTED, UNEXPECTED_ERROR};
            }

            public static EnumEntries<Reason> getEntries() {
                return $ENTRIES;
            }

            public static Reason valueOf(String str) {
                return (Reason) Enum.valueOf(Reason.class, str);
            }

            public static Reason[] values() {
                return (Reason[]) $VALUES.clone();
            }

            private Reason(String str, int i) {
            }

            static {
                Reason[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/UpdateService$ArchiveFinalizationAudit;", "", "validated", "", "block", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "<init>", "(ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;)V", "getValidated", "()Z", "getBlock", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ArchiveFinalizationAudit {
        private final ArchiveUpdateCheckDecision.Block block;
        private final boolean validated;

        public ArchiveFinalizationAudit() {
            this(false, null, 3, null);
        }

        public static /* synthetic */ ArchiveFinalizationAudit copy$default(ArchiveFinalizationAudit archiveFinalizationAudit, boolean z, ArchiveUpdateCheckDecision.Block block, int i, Object obj) {
            if ((i & 1) != 0) {
                z = archiveFinalizationAudit.validated;
            }
            if ((i & 2) != 0) {
                block = archiveFinalizationAudit.block;
            }
            return archiveFinalizationAudit.copy(z, block);
        }

        public final boolean component1() {
            return this.validated;
        }

        public final ArchiveUpdateCheckDecision.Block component2() {
            return this.block;
        }

        public final ArchiveFinalizationAudit copy(boolean z, ArchiveUpdateCheckDecision.Block block) {
            return new ArchiveFinalizationAudit(z, block);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ArchiveFinalizationAudit) {
                ArchiveFinalizationAudit archiveFinalizationAudit = (ArchiveFinalizationAudit) obj;
                return this.validated == archiveFinalizationAudit.validated && Intrinsics.areEqual(this.block, archiveFinalizationAudit.block);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.validated) * 31;
            ArchiveUpdateCheckDecision.Block block = this.block;
            return hashCode + (block == null ? 0 : block.hashCode());
        }

        public String toString() {
            boolean z = this.validated;
            return "ArchiveFinalizationAudit(validated=" + z + ", block=" + this.block + ")";
        }

        public ArchiveFinalizationAudit(boolean z, ArchiveUpdateCheckDecision.Block block) {
            this.validated = z;
            this.block = block;
        }

        public /* synthetic */ ArchiveFinalizationAudit(boolean z, ArchiveUpdateCheckDecision.Block block, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : block);
        }

        public final boolean getValidated() {
            return this.validated;
        }

        public final ArchiveUpdateCheckDecision.Block getBlock() {
            return this.block;
        }
    }

    @Override // com.arizona.launcher.Hilt_UpdateService, android.app.Service
    public void onCreate() {
        DurableArchiveStateStore durableArchiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore2;
        UpdateMetadataFetcher updateMetadataFetcher;
        UpdateAnalyticsReporter updateAnalyticsReporter;
        super.onCreate();
        this.serviceAlive.set(true);
        ArchiveStateMaintenance archiveStateMaintenance = null;
        this.analyticsReporter = UpdateAnalyticsReporter.Companion.createAndroid$default(UpdateAnalyticsReporter.Companion, this, null, 2, null);
        this.archiveStateStore = DurableArchiveStateStore.Companion.forAndroid(new File(getNoBackupFilesDir(), "archive-updater"));
        this.viceArchiveStateStore = DurableArchiveStateStore.Companion.forAndroid(new File(getNoBackupFilesDir(), "archive-updater/vice"));
        Function0 function0 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                File externalFilesDir;
                externalFilesDir = UpdateService.this.getExternalFilesDir(null);
                return externalFilesDir;
            }
        };
        DurableArchiveStateStore durableArchiveStateStore3 = this.archiveStateStore;
        if (durableArchiveStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore = null;
        } else {
            durableArchiveStateStore = durableArchiveStateStore3;
        }
        this.archiveStateMaintenance = new ArchiveStateMaintenance(function0, durableArchiveStateStore, ArchiveInstalledPayloadAuditor.Companion.forAndroid(), null, 8, null);
        Function0 function02 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                File externalFilesDir;
                externalFilesDir = UpdateService.this.getExternalFilesDir(null);
                return externalFilesDir;
            }
        };
        DurableArchiveStateStore durableArchiveStateStore4 = this.viceArchiveStateStore;
        if (durableArchiveStateStore4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
            durableArchiveStateStore2 = null;
        } else {
            durableArchiveStateStore2 = durableArchiveStateStore4;
        }
        this.viceArchiveStateMaintenance = new ArchiveStateMaintenance(function02, durableArchiveStateStore2, ArchiveInstalledPayloadAuditor.Companion.forAndroid(), null, 8, null);
        this.resourceGeneration = new EngineResourceGenerationController(EngineResourceGenerationStore.Companion.forAndroid(new File(getNoBackupFilesDir(), EngineResourceGenerationStore.DIRECTORY_NAME)), EngineResourceGenerationMigration.Companion.forAndroid(), new UpdateService$onCreate$3(FirebaseConfigHelper.INSTANCE), new UpdateService$onCreate$4(this));
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true).connectionPool(new ConnectionPool(5, 10L, TimeUnit.SECONDS)).dns(new SafeArchiveDns(Dns.SYSTEM, false)).addInterceptor(new ArchiveDownloadGuardTaggingInterceptor()).addNetworkInterceptor(new ArchiveDownloadNetworkGuardInterceptor(false)).build();
        this.metadataFetcher = UpdateMetadataFetcher.Companion.create(build);
        UpdateMetadataFetcher updateMetadataFetcher2 = this.metadataFetcher;
        if (updateMetadataFetcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataFetcher");
            updateMetadataFetcher2 = null;
        }
        this.gameUpdateFlow = new GameUpdateServiceFlow(this.serviceScope, new GameUpdateCheckRunner(updateMetadataFetcher2, new UpdateService$onCreate$gameUpdateCheckRunner$1(this), new UpdateService$onCreate$gameUpdateCheckRunner$2(this), new UpdateService$onCreate$gameUpdateCheckRunner$3(FileServers.INSTANCE), new UpdateService$onCreate$gameUpdateCheckRunner$4(FileServers.INSTANCE)), this.archiveSession, this, new UpdateService$onCreate$5(FileServers.INSTANCE), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(UpdateService.onCreate$lambda$2());
            }
        }, new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String jsonName;
                jsonName = UpdateJsonProvider.INSTANCE.getJsonName(UpdateService.this);
                return jsonName;
            }
        }, new UpdateService$onCreate$8(this), new UpdateService$onCreate$9(this), new UpdateService$onCreate$10(this));
        UpdateService updateService = this;
        this.archiveUpdateFlow = new ArchiveUpdateServiceFlow(this.serviceScope, this.archiveSession, updateService, null, null, 24, null);
        this.viceArchiveUpdateFlow = new ArchiveUpdateServiceFlow(this.serviceScope, this.viceArchiveSession, updateService, null, null, 24, null);
        this.fileCheckFlow = new FileCheckServiceFlow(this.serviceScope, this, new UpdateService$onCreate$11(this, null), null, 8, null);
        LauncherApkDownloader launcherApkDownloader = new LauncherApkDownloader(build, null, null, null, false, 0, 0L, 0L, null, null, 1006, null);
        CoroutineScope coroutineScope = this.serviceScope;
        UpdateMetadataFetcher updateMetadataFetcher3 = this.metadataFetcher;
        if (updateMetadataFetcher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataFetcher");
            updateMetadataFetcher = null;
        } else {
            updateMetadataFetcher = updateMetadataFetcher3;
        }
        LauncherUpdateConfig launcherUpdateConfig = new LauncherUpdateConfig(BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME, "release", BuildConfig.FLAVOR);
        UpdateAnalyticsReporter updateAnalyticsReporter2 = this.analyticsReporter;
        if (updateAnalyticsReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            updateAnalyticsReporter = null;
        } else {
            updateAnalyticsReporter = updateAnalyticsReporter2;
        }
        this.launcherUpdateFlow = new LauncherUpdateServiceFlow(coroutineScope, updateMetadataFetcher, launcherApkDownloader, launcherUpdateConfig, updateAnalyticsReporter, this, new UpdateService$onCreate$12(FileServers.INSTANCE), new UpdateService$onCreate$13(FileServers.INSTANCE), new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdateService.onCreate$lambda$4(UpdateService.this, (Function0) obj);
            }
        }, new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(UpdateService.onCreate$lambda$5());
            }
        }, new UpdateService$onCreate$16(this));
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.serviceHandlerThread = handlerThread;
        createNotificationChannel();
        this.archiveSession.initializeStartupGuard(detectArchiveStartupGuard$default(this, null, 1, null));
        ArchiveUpdateSessionState archiveUpdateSessionState = this.viceArchiveSession;
        ArchiveStateMaintenance archiveStateMaintenance2 = this.viceArchiveStateMaintenance;
        if (archiveStateMaintenance2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateMaintenance");
        } else {
            archiveStateMaintenance = archiveStateMaintenance2;
        }
        archiveUpdateSessionState.initializeStartupGuard(detectArchiveStartupGuard(archiveStateMaintenance));
        this.viceContentAvailable = shouldAuditViceContent();
        resetGameStatus();
        HandlerThread handlerThread2 = this.serviceHandlerThread;
        if (handlerThread2 != null) {
            Looper looper = handlerThread2.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            this.mInHandler = new IncomingHandler(this, looper);
            this.mMessenger = new Messenger(this.mInHandler);
            recoverPendingViceCityDelete();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int onCreate$lambda$2() {
        return FileServers.INSTANCE.getGame_servers().length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$4(UpdateService updateService, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int onCreate$lambda$5() {
        return FileServers.INSTANCE.getLauncher_servers().length;
    }

    static /* synthetic */ ArchiveStartupGuard detectArchiveStartupGuard$default(UpdateService updateService, ArchiveStateMaintenance archiveStateMaintenance, int i, Object obj) {
        if ((i & 1) != 0 && (archiveStateMaintenance = updateService.archiveStateMaintenance) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
            archiveStateMaintenance = null;
        }
        return updateService.detectArchiveStartupGuard(archiveStateMaintenance);
    }

    private final ArchiveStartupGuard detectArchiveStartupGuard(ArchiveStateMaintenance archiveStateMaintenance) {
        try {
            ArchiveStartupInspection inspectStartup = archiveStateMaintenance.inspectStartup(ArchiveUpdateTransactionLock.INSTANCE.isLocked());
            String corruptReason = inspectStartup.getCorruptReason();
            if (corruptReason != null) {
                Log.e(TAG, "Archive journal is corrupt at service startup: " + corruptReason);
            }
            return inspectStartup.getGuard();
        } catch (Exception e) {
            Log.e(TAG, "Unable to inspect archive journal at service startup", e);
            return ArchiveStartupGuard.CORRUPT_STATE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveGpu selectedArchiveGpu() {
        String jsonName = UpdateJsonProvider.INSTANCE.getJsonName(this);
        return Intrinsics.areEqual(jsonName, "dxt.game.json") ? ArchiveGpu.ADRENO : Intrinsics.areEqual(jsonName, "pvr.game.json") ? ArchiveGpu.POWERVR : ArchiveGpu.MALI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object auditEnabledArchiveContent(Continuation<? super ArchivePayloadAuditResult> continuation) {
        return auditArchiveContent(true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (r11 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
        if (r11 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
        if (r11 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
        if (r11 == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object auditArchiveContent(boolean z, Continuation<? super ArchivePayloadAuditResult> continuation) {
        UpdateService$auditArchiveContent$1 updateService$auditArchiveContent$1;
        int i;
        ArchivePayloadAuditResult archivePayloadAuditResult;
        ArchivePayloadAuditResult archivePayloadAuditResult2;
        ArchivePayloadAuditResult archivePayloadAuditResult3;
        if (continuation instanceof UpdateService$auditArchiveContent$1) {
            updateService$auditArchiveContent$1 = (UpdateService$auditArchiveContent$1) continuation;
            if ((updateService$auditArchiveContent$1.label & Integer.MIN_VALUE) != 0) {
                updateService$auditArchiveContent$1.label -= Integer.MIN_VALUE;
                Object obj = updateService$auditArchiveContent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateService$auditArchiveContent$1.label;
                ArchiveStateMaintenance archiveStateMaintenance = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArchiveStateMaintenance archiveStateMaintenance2 = this.archiveStateMaintenance;
                    if (z) {
                        if (archiveStateMaintenance2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                            archiveStateMaintenance2 = null;
                        }
                        updateService$auditArchiveContent$1.Z$0 = z;
                        updateService$auditArchiveContent$1.label = 1;
                        obj = archiveStateMaintenance2.auditAndPrepareRepair(updateService$auditArchiveContent$1);
                    } else {
                        if (archiveStateMaintenance2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                            archiveStateMaintenance2 = null;
                        }
                        updateService$auditArchiveContent$1.Z$0 = z;
                        updateService$auditArchiveContent$1.label = 2;
                        obj = archiveStateMaintenance2.auditMetadataAndPrepareRepair(updateService$auditArchiveContent$1);
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    z = updateService$auditArchiveContent$1.Z$0;
                    ResultKt.throwOnFailure(obj);
                    archivePayloadAuditResult = (ArchivePayloadAuditResult) obj;
                } else if (i != 2) {
                    if (i == 3) {
                        boolean z2 = updateService$auditArchiveContent$1.Z$0;
                        archivePayloadAuditResult2 = (ArchivePayloadAuditResult) updateService$auditArchiveContent$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        archivePayloadAuditResult3 = (ArchivePayloadAuditResult) obj;
                        return combineArchiveAudits(archivePayloadAuditResult2, archivePayloadAuditResult3);
                    } else if (i == 4) {
                        boolean z3 = updateService$auditArchiveContent$1.Z$0;
                        archivePayloadAuditResult2 = (ArchivePayloadAuditResult) updateService$auditArchiveContent$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        archivePayloadAuditResult3 = (ArchivePayloadAuditResult) obj;
                        return combineArchiveAudits(archivePayloadAuditResult2, archivePayloadAuditResult3);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    z = updateService$auditArchiveContent$1.Z$0;
                    ResultKt.throwOnFailure(obj);
                    archivePayloadAuditResult = (ArchivePayloadAuditResult) obj;
                }
                ArchivePayloadAuditResult archivePayloadAuditResult4 = archivePayloadAuditResult;
                boolean z4 = z;
                archivePayloadAuditResult2 = archivePayloadAuditResult4;
                if (shouldAuditViceContent()) {
                    return archivePayloadAuditResult2;
                }
                ArchiveStateMaintenance archiveStateMaintenance3 = this.viceArchiveStateMaintenance;
                if (z4) {
                    if (archiveStateMaintenance3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateMaintenance");
                    } else {
                        archiveStateMaintenance = archiveStateMaintenance3;
                    }
                    updateService$auditArchiveContent$1.L$0 = archivePayloadAuditResult2;
                    updateService$auditArchiveContent$1.Z$0 = z4;
                    updateService$auditArchiveContent$1.label = 3;
                    obj = archiveStateMaintenance.auditAndPrepareRepair(updateService$auditArchiveContent$1);
                } else {
                    if (archiveStateMaintenance3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateMaintenance");
                    } else {
                        archiveStateMaintenance = archiveStateMaintenance3;
                    }
                    updateService$auditArchiveContent$1.L$0 = archivePayloadAuditResult2;
                    updateService$auditArchiveContent$1.Z$0 = z4;
                    updateService$auditArchiveContent$1.label = 4;
                    obj = archiveStateMaintenance.auditMetadataAndPrepareRepair(updateService$auditArchiveContent$1);
                }
                return coroutine_suspended;
            }
        }
        updateService$auditArchiveContent$1 = new UpdateService$auditArchiveContent$1(this, continuation);
        Object obj2 = updateService$auditArchiveContent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$auditArchiveContent$1.label;
        ArchiveStateMaintenance archiveStateMaintenance4 = null;
        if (i != 0) {
        }
        ArchivePayloadAuditResult archivePayloadAuditResult42 = archivePayloadAuditResult;
        boolean z42 = z;
        archivePayloadAuditResult2 = archivePayloadAuditResult42;
        if (shouldAuditViceContent()) {
        }
    }

    private final ArchivePayloadAuditResult combineArchiveAudits(ArchivePayloadAuditResult archivePayloadAuditResult, ArchivePayloadAuditResult archivePayloadAuditResult2) {
        ArchiveInstalledPayloadMismatch firstMismatch;
        if (archivePayloadAuditResult instanceof ArchivePayloadAuditResult.Unavailable) {
            return archivePayloadAuditResult;
        }
        if (archivePayloadAuditResult2 instanceof ArchivePayloadAuditResult.Unavailable) {
            return archivePayloadAuditResult2;
        }
        if ((archivePayloadAuditResult instanceof ArchivePayloadAuditResult.Valid) && (archivePayloadAuditResult2 instanceof ArchivePayloadAuditResult.Valid)) {
            return ArchivePayloadAuditResult.Valid.INSTANCE;
        }
        ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch = null;
        ArchivePayloadAuditResult.RepairScheduled repairScheduled = archivePayloadAuditResult instanceof ArchivePayloadAuditResult.RepairScheduled ? (ArchivePayloadAuditResult.RepairScheduled) archivePayloadAuditResult : null;
        ArchivePayloadAuditResult.RepairScheduled repairScheduled2 = archivePayloadAuditResult2 instanceof ArchivePayloadAuditResult.RepairScheduled ? (ArchivePayloadAuditResult.RepairScheduled) archivePayloadAuditResult2 : null;
        List createListBuilder = CollectionsKt.createListBuilder();
        List<String> mismatchedPackageIds = repairScheduled != null ? repairScheduled.getMismatchedPackageIds() : null;
        if (mismatchedPackageIds == null) {
            mismatchedPackageIds = CollectionsKt.emptyList();
        }
        createListBuilder.addAll(mismatchedPackageIds);
        List<String> mismatchedPackageIds2 = repairScheduled2 != null ? repairScheduled2.getMismatchedPackageIds() : null;
        if (mismatchedPackageIds2 == null) {
            mismatchedPackageIds2 = CollectionsKt.emptyList();
        }
        createListBuilder.addAll(mismatchedPackageIds2);
        List distinct = CollectionsKt.distinct(CollectionsKt.build(createListBuilder));
        if (repairScheduled != null && (firstMismatch = repairScheduled.getFirstMismatch()) != null) {
            archiveInstalledPayloadMismatch = firstMismatch;
        } else if (repairScheduled2 != null) {
            archiveInstalledPayloadMismatch = repairScheduled2.getFirstMismatch();
        }
        return new ArchivePayloadAuditResult.RepairScheduled(distinct, archiveInstalledPayloadMismatch);
    }

    private final boolean shouldAuditViceContent() {
        if (isViceCityEnabled()) {
            if (this.viceContentAvailable) {
                return true;
            }
            DurableArchiveStateStore durableArchiveStateStore = this.viceArchiveStateStore;
            if (durableArchiveStateStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                durableArchiveStateStore = null;
            }
            return !(durableArchiveStateStore.load() instanceof ArchiveStateLoadResult.Missing);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object auditFinalizationMetadataIfNeeded(ArchiveUpdaterStorageScope archiveUpdaterStorageScope, DurableArchiveStateStore durableArchiveStateStore, ArchiveStateMaintenance archiveStateMaintenance, Continuation<? super ArchiveFinalizationAudit> continuation) {
        UpdateService$auditFinalizationMetadataIfNeeded$1 updateService$auditFinalizationMetadataIfNeeded$1;
        int i;
        ArchivePayloadAuditResult archivePayloadAuditResult;
        ArchivePayloadAuditResult.Unavailable unavailable;
        ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode;
        if (continuation instanceof UpdateService$auditFinalizationMetadataIfNeeded$1) {
            updateService$auditFinalizationMetadataIfNeeded$1 = (UpdateService$auditFinalizationMetadataIfNeeded$1) continuation;
            if ((updateService$auditFinalizationMetadataIfNeeded$1.label & Integer.MIN_VALUE) != 0) {
                updateService$auditFinalizationMetadataIfNeeded$1.label -= Integer.MIN_VALUE;
                Object obj = updateService$auditFinalizationMetadataIfNeeded$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateService$auditFinalizationMetadataIfNeeded$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ArchiveStateLoadResult load = durableArchiveStateStore.load();
                        ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
                        ArchiveUpdaterState state = loaded != null ? loaded.getState() : null;
                        if (state == null || !state.isPayloadCommitted() || state.isInstallReady()) {
                            return new ArchiveFinalizationAudit(false, null, 3, null);
                        }
                        updateService$auditFinalizationMetadataIfNeeded$1.L$0 = archiveUpdaterStorageScope;
                        updateService$auditFinalizationMetadataIfNeeded$1.L$1 = SpillingKt.nullOutSpilledVariable(durableArchiveStateStore);
                        updateService$auditFinalizationMetadataIfNeeded$1.L$2 = SpillingKt.nullOutSpilledVariable(archiveStateMaintenance);
                        updateService$auditFinalizationMetadataIfNeeded$1.L$3 = SpillingKt.nullOutSpilledVariable(state);
                        updateService$auditFinalizationMetadataIfNeeded$1.label = 1;
                        obj = archiveStateMaintenance.auditMetadataAndPrepareRepair(updateService$auditFinalizationMetadataIfNeeded$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e) {
                        return new ArchiveFinalizationAudit(false, new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, archiveUpdaterStorageScope + " pre-finalization state read failed: " + e.getMessage()), 1, null);
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ArchiveUpdaterState archiveUpdaterState = (ArchiveUpdaterState) updateService$auditFinalizationMetadataIfNeeded$1.L$3;
                    ArchiveStateMaintenance archiveStateMaintenance2 = (ArchiveStateMaintenance) updateService$auditFinalizationMetadataIfNeeded$1.L$2;
                    DurableArchiveStateStore durableArchiveStateStore2 = (DurableArchiveStateStore) updateService$auditFinalizationMetadataIfNeeded$1.L$1;
                    archiveUpdaterStorageScope = (ArchiveUpdaterStorageScope) updateService$auditFinalizationMetadataIfNeeded$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archivePayloadAuditResult = (ArchivePayloadAuditResult) obj;
                if (Intrinsics.areEqual(archivePayloadAuditResult, ArchivePayloadAuditResult.Valid.INSTANCE)) {
                    if (archivePayloadAuditResult instanceof ArchivePayloadAuditResult.RepairScheduled) {
                        ArchivePayloadAuditResult.RepairScheduled repairScheduled = (ArchivePayloadAuditResult.RepairScheduled) archivePayloadAuditResult;
                        Log.w(TAG, archiveUpdaterStorageScope + " pre-finalization metadata audit scheduled repair for packages=" + repairScheduled.getMismatchedPackageIds() + " first=" + repairScheduled.getFirstMismatch());
                        return new ArchiveFinalizationAudit(false, null, 3, null);
                    } else if (!(archivePayloadAuditResult instanceof ArchivePayloadAuditResult.Unavailable)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        if (((ArchivePayloadAuditResult.Unavailable) archivePayloadAuditResult).getReason() == ArchivePayloadAuditUnavailableReason.GAME_ROOT_MISSING) {
                            archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.GAME_ROOT_UNAVAILABLE;
                        } else {
                            archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.STATE_INVALID;
                        }
                        return new ArchiveFinalizationAudit(false, new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode, archiveUpdaterStorageScope + " pre-finalization metadata audit unavailable: " + unavailable.getReason()), 1, null);
                    }
                }
                return new ArchiveFinalizationAudit(true, null, 2, null);
            }
        }
        updateService$auditFinalizationMetadataIfNeeded$1 = new UpdateService$auditFinalizationMetadataIfNeeded$1(this, continuation);
        Object obj2 = updateService$auditFinalizationMetadataIfNeeded$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$auditFinalizationMetadataIfNeeded$1.label;
        if (i != 0) {
        }
        archivePayloadAuditResult = (ArchivePayloadAuditResult) obj2;
        if (Intrinsics.areEqual(archivePayloadAuditResult, ArchivePayloadAuditResult.Valid.INSTANCE)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1 A[Catch: all -> 0x003b, Exception -> 0x003e, CancellationException -> 0x0041, TryCatch #3 {all -> 0x003b, blocks: (B:12:0x0036, B:43:0x00b7, B:45:0x00c1, B:46:0x00c4, B:48:0x00c8, B:49:0x00f4, B:51:0x00f8, B:54:0x0128, B:55:0x012d, B:60:0x0133, B:65:0x016b), top: B:70:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[Catch: all -> 0x003b, Exception -> 0x003e, CancellationException -> 0x0041, TryCatch #3 {all -> 0x003b, blocks: (B:12:0x0036, B:43:0x00b7, B:45:0x00c1, B:46:0x00c4, B:48:0x00c8, B:49:0x00f4, B:51:0x00f8, B:54:0x0128, B:55:0x012d, B:60:0x0133, B:65:0x016b), top: B:70:0x002e }] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runPrimaryGameCheckPreflight(long j, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        UpdateService$runPrimaryGameCheckPreflight$1 updateService$runPrimaryGameCheckPreflight$1;
        int i;
        EngineResourceGenerationEvaluation.Ready ready;
        long j2;
        ArchivePayloadAuditResult archivePayloadAuditResult;
        try {
            if (continuation instanceof UpdateService$runPrimaryGameCheckPreflight$1) {
                updateService$runPrimaryGameCheckPreflight$1 = (UpdateService$runPrimaryGameCheckPreflight$1) continuation;
                if ((updateService$runPrimaryGameCheckPreflight$1.label & Integer.MIN_VALUE) != 0) {
                    updateService$runPrimaryGameCheckPreflight$1.label -= Integer.MIN_VALUE;
                    Object obj = updateService$runPrimaryGameCheckPreflight$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = updateService$runPrimaryGameCheckPreflight$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!isCurrentUpdateOperation(UpdateOperationKind.CHECK_UPDATE, j)) {
                            return null;
                        }
                        EngineResourceGenerationController engineResourceGenerationController = this.resourceGeneration;
                        if (engineResourceGenerationController == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
                            engineResourceGenerationController = null;
                        }
                        EngineResourceGenerationEvaluation evaluationFor = engineResourceGenerationController.evaluationFor(j);
                        if (evaluationFor instanceof EngineResourceGenerationEvaluation.Corrupt) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, ((EngineResourceGenerationEvaluation.Corrupt) evaluationFor).getReason());
                        }
                        if (!(evaluationFor instanceof EngineResourceGenerationEvaluation.Ready)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (((EngineResourceGenerationEvaluation.Ready) evaluationFor).getAction() == EngineResourceGenerationAction.MIGRATE) {
                            Log.i(TAG, "Skipping archive metadata audit while resource generation " + ready.getTarget() + " is pending");
                            return null;
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        try {
                            updateService$runPrimaryGameCheckPreflight$1.J$0 = j;
                            updateService$runPrimaryGameCheckPreflight$1.J$1 = elapsedRealtime;
                            updateService$runPrimaryGameCheckPreflight$1.label = 1;
                            obj = auditArchiveContent(false, updateService$runPrimaryGameCheckPreflight$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j2 = elapsedRealtime;
                        } catch (CancellationException e) {
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            j2 = elapsedRealtime;
                            Log.e(TAG, "Primary archive metadata audit failed", e);
                            ArchiveUpdateCheckDecision.Block block = new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "primary archive metadata audit failed: " + e.getMessage());
                            Log.i(TAG, "Primary archive metadata audit durationMs=" + (SystemClock.elapsedRealtime() - j2));
                            return block;
                        } catch (Throwable th) {
                            th = th;
                            this = elapsedRealtime;
                            Log.i(TAG, "Primary archive metadata audit durationMs=" + (SystemClock.elapsedRealtime() - this));
                            throw th;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j2 = updateService$runPrimaryGameCheckPreflight$1.J$1;
                        long j3 = updateService$runPrimaryGameCheckPreflight$1.J$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (CancellationException e3) {
                            throw e3;
                        } catch (Exception e4) {
                            e = e4;
                            Log.e(TAG, "Primary archive metadata audit failed", e);
                            ArchiveUpdateCheckDecision.Block block2 = new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "primary archive metadata audit failed: " + e.getMessage());
                            Log.i(TAG, "Primary archive metadata audit durationMs=" + (SystemClock.elapsedRealtime() - j2));
                            return block2;
                        }
                    }
                    archivePayloadAuditResult = (ArchivePayloadAuditResult) obj;
                    if (!Intrinsics.areEqual(archivePayloadAuditResult, ArchivePayloadAuditResult.Valid.INSTANCE)) {
                        Unit unit = Unit.INSTANCE;
                    } else if (archivePayloadAuditResult instanceof ArchivePayloadAuditResult.RepairScheduled) {
                        Boxing.boxInt(Log.w(TAG, "Archive metadata audit scheduled repair for packages=" + ((ArchivePayloadAuditResult.RepairScheduled) archivePayloadAuditResult).getMismatchedPackageIds() + " first=" + ((ArchivePayloadAuditResult.RepairScheduled) archivePayloadAuditResult).getFirstMismatch()));
                    } else if (!(archivePayloadAuditResult instanceof ArchivePayloadAuditResult.Unavailable)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Boxing.boxInt(Log.d(TAG, "Archive metadata audit unavailable: " + ((ArchivePayloadAuditResult.Unavailable) archivePayloadAuditResult).getReason()));
                    }
                    Log.i(TAG, "Primary archive metadata audit durationMs=" + (SystemClock.elapsedRealtime() - j2));
                    return null;
                }
            }
            if (i != 0) {
            }
            archivePayloadAuditResult = (ArchivePayloadAuditResult) obj;
            if (!Intrinsics.areEqual(archivePayloadAuditResult, ArchivePayloadAuditResult.Valid.INSTANCE)) {
            }
            Log.i(TAG, "Primary archive metadata audit durationMs=" + (SystemClock.elapsedRealtime() - j2));
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
        updateService$runPrimaryGameCheckPreflight$1 = new UpdateService$runPrimaryGameCheckPreflight$1(this, continuation);
        Object obj2 = updateService$runPrimaryGameCheckPreflight$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$runPrimaryGameCheckPreflight$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepareGameUpdateCheck(String str, String str2, UpdateOperationKind updateOperationKind, long j, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        UpdateService$prepareGameUpdateCheck$1 updateService$prepareGameUpdateCheck$1;
        int i;
        String str3;
        ?? r1;
        String str4;
        try {
            if (continuation instanceof UpdateService$prepareGameUpdateCheck$1) {
                updateService$prepareGameUpdateCheck$1 = (UpdateService$prepareGameUpdateCheck$1) continuation;
                if ((updateService$prepareGameUpdateCheck$1.label & Integer.MIN_VALUE) != 0) {
                    updateService$prepareGameUpdateCheck$1.label -= Integer.MIN_VALUE;
                    UpdateService$prepareGameUpdateCheck$1 updateService$prepareGameUpdateCheck$12 = updateService$prepareGameUpdateCheck$1;
                    Object obj = updateService$prepareGameUpdateCheck$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = updateService$prepareGameUpdateCheck$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        EngineResourceGenerationController engineResourceGenerationController = this.resourceGeneration;
                        if (engineResourceGenerationController == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
                            engineResourceGenerationController = null;
                        }
                        EngineResourceGenerationEvaluation evaluationFor = engineResourceGenerationController.evaluationFor(j);
                        if (evaluationFor instanceof EngineResourceGenerationEvaluation.Corrupt) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, ((EngineResourceGenerationEvaluation.Corrupt) evaluationFor).getReason());
                        }
                        if ((evaluationFor instanceof EngineResourceGenerationEvaluation.Ready) && ((EngineResourceGenerationEvaluation.Ready) evaluationFor).getAction() == EngineResourceGenerationAction.MIGRATE) {
                            str3 = null;
                            r1 = 1;
                        } else {
                            str3 = null;
                            r1 = 0;
                        }
                        ?? r10 = (!(evaluationFor instanceof EngineResourceGenerationEvaluation.Ready) || ((EngineResourceGenerationEvaluation.Ready) evaluationFor).getAction() == EngineResourceGenerationAction.UP_TO_DATE) ? 0 : 1;
                        boolean isViceCityEnabled = isViceCityEnabled();
                        if (isViceCityEnabled) {
                            try {
                                str4 = str;
                                str3 = this.viceCityManifestExtractor.extractOrNull(str4);
                            } catch (OriginalTzViceCityManifestSectionException e) {
                                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_INVALID, e.getMessage());
                            }
                        } else {
                            str4 = str;
                        }
                        String str5 = str3;
                        updateService$prepareGameUpdateCheck$12.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        updateService$prepareGameUpdateCheck$12.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        updateService$prepareGameUpdateCheck$12.L$2 = SpillingKt.nullOutSpilledVariable(updateOperationKind);
                        updateService$prepareGameUpdateCheck$12.L$3 = SpillingKt.nullOutSpilledVariable(evaluationFor);
                        updateService$prepareGameUpdateCheck$12.L$4 = SpillingKt.nullOutSpilledVariable(str5);
                        updateService$prepareGameUpdateCheck$12.J$0 = j;
                        updateService$prepareGameUpdateCheck$12.I$0 = r1;
                        updateService$prepareGameUpdateCheck$12.I$1 = r10;
                        updateService$prepareGameUpdateCheck$12.Z$0 = isViceCityEnabled;
                        updateService$prepareGameUpdateCheck$12.label = 1;
                        obj = ArchiveUpdateTransactionLock.INSTANCE.withLock(new UpdateService$prepareGameUpdateCheck$2(r1, this, isViceCityEnabled, str5, updateOperationKind, j, str2, str4, r10, null), updateService$prepareGameUpdateCheck$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        boolean z = updateService$prepareGameUpdateCheck$12.Z$0;
                        int i2 = updateService$prepareGameUpdateCheck$12.I$1;
                        int i3 = updateService$prepareGameUpdateCheck$12.I$0;
                        long j2 = updateService$prepareGameUpdateCheck$12.J$0;
                        String str6 = (String) updateService$prepareGameUpdateCheck$12.L$4;
                        EngineResourceGenerationEvaluation engineResourceGenerationEvaluation = (EngineResourceGenerationEvaluation) updateService$prepareGameUpdateCheck$12.L$3;
                        UpdateOperationKind updateOperationKind2 = (UpdateOperationKind) updateService$prepareGameUpdateCheck$12.L$2;
                        String str7 = (String) updateService$prepareGameUpdateCheck$12.L$1;
                        String str8 = (String) updateService$prepareGameUpdateCheck$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return (ArchiveUpdateCheckDecision) obj;
                }
            }
            if (i != 0) {
            }
            return (ArchiveUpdateCheckDecision) obj;
        } catch (CancellationException e2) {
            throw e2;
        } catch (Exception e3) {
            Log.e(TAG, "Archive update check failed", e3);
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e3.getMessage());
        }
        updateService$prepareGameUpdateCheck$1 = new UpdateService$prepareGameUpdateCheck$1(this, continuation);
        UpdateService$prepareGameUpdateCheck$1 updateService$prepareGameUpdateCheck$122 = updateService$prepareGameUpdateCheck$1;
        Object obj2 = updateService$prepareGameUpdateCheck$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$prepareGameUpdateCheck$122.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveUpdateCheckCoordinator archiveCheckCoordinator(ArchiveUpdaterStorageScope archiveUpdaterStorageScope, UpdateOperationKind updateOperationKind, long j, String str) {
        DurableArchiveStateStore durableArchiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore2;
        ArchiveUpdaterStorageRoots archiveStorageRoots = archiveStorageRoots(archiveUpdaterStorageScope);
        File gameRoot = archiveStorageRoots != null ? archiveStorageRoots.getGameRoot() : null;
        ArchiveInstallAdopter forAndroid = ArchiveInstallAdopter.Companion.forAndroid();
        ArchivePackageArtifactCleaner forAndroid2 = ArchivePackageArtifactCleaner.Companion.forAndroid();
        File downloadRoot = archiveStorageRoots != null ? archiveStorageRoots.getDownloadRoot() : null;
        File workRoot = archiveStorageRoots != null ? archiveStorageRoots.getWorkRoot() : null;
        int i = WhenMappings.$EnumSwitchMapping$0[archiveUpdaterStorageScope.ordinal()];
        if (i == 1) {
            durableArchiveStateStore = this.archiveStateStore;
            if (durableArchiveStateStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
                durableArchiveStateStore2 = null;
            }
            durableArchiveStateStore2 = durableArchiveStateStore;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            durableArchiveStateStore = this.viceArchiveStateStore;
            if (durableArchiveStateStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                durableArchiveStateStore2 = null;
            }
            durableArchiveStateStore2 = durableArchiveStateStore;
        }
        return new ArchiveUpdateCheckCoordinator(gameRoot, durableArchiveStateStore2, forAndroid, forAndroid2, downloadRoot, workRoot, null, ArchiveManifestResolver.Companion.create(this, isGameDownloadRetryEnabled(), archiveIndexRetryListener(updateOperationKind, j, str)), null, null, new ArchiveSelectiveDownloadEstimator(), 832, null);
    }

    private final ArchiveRangeRetryListener archiveIndexRetryListener(UpdateOperationKind updateOperationKind, long j, String str) {
        return new UpdateService$archiveIndexRetryListener$1(this, updateOperationKind, j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EngineResourceCleanupRequest resourceCleanupRequest(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2) {
        File archiveCacheAnchor;
        ArchiveUpdaterStorageRoots archiveStorageRoots;
        ArchiveUpdaterStorageRoots archiveStorageRoots2;
        DurableArchiveStateStore durableArchiveStateStore;
        File externalFilesDir = getExternalFilesDir(null);
        if (externalFilesDir == null || (archiveCacheAnchor = archiveCacheAnchor()) == null || (archiveStorageRoots = archiveStorageRoots(ArchiveUpdaterStorageScope.BASE)) == null || (archiveStorageRoots2 = archiveStorageRoots(ArchiveUpdaterStorageScope.VICE)) == null) {
            return null;
        }
        File noBackupFilesDir = getNoBackupFilesDir();
        Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "getNoBackupFilesDir(...)");
        File downloadRoot = archiveStorageRoots.getDownloadRoot();
        File downloadRoot2 = archiveStorageRoots2.getDownloadRoot();
        File workRoot = archiveStorageRoots.getWorkRoot();
        DurableArchiveStateStore durableArchiveStateStore2 = this.archiveStateStore;
        if (durableArchiveStateStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore2 = null;
        }
        DurableArchiveStateStore durableArchiveStateStore3 = this.viceArchiveStateStore;
        if (durableArchiveStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
            durableArchiveStateStore = null;
        } else {
            durableArchiveStateStore = durableArchiveStateStore3;
        }
        return new EngineResourceCleanupRequest(externalFilesDir, archiveCacheAnchor, noBackupFilesDir, downloadRoot, downloadRoot2, workRoot, durableArchiveStateStore2, durableArchiveStateStore, archiveManifest, archiveManifest2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resourceLanesReady() {
        DurableArchiveStateStore durableArchiveStateStore = this.archiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore2 = null;
        if (durableArchiveStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore = null;
        }
        DurableArchiveStateStore durableArchiveStateStore3 = this.viceArchiveStateStore;
        if (durableArchiveStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
        } else {
            durableArchiveStateStore2 = durableArchiveStateStore3;
        }
        return EngineResourceGenerationControllerKt.engineResourceGenerationLanesReady(durableArchiveStateStore, durableArchiveStateStore2, isViceCityEnabled() && this.viceContentAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean gameActivityExists() {
        GTASA gtasa = GTASA.getInstance();
        if (gtasa == null) {
            return false;
        }
        return !gtasa.isDestroyed();
    }

    private final ArchiveUpdaterStorageRoots archiveStorageRoots(ArchiveUpdaterStorageScope archiveUpdaterStorageScope) {
        return ArchiveDownloadRootResolver.Companion.getProcess().resolve(this, archiveUpdaterStorageScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String currentArchiveLaneCollisionDetail() {
        try {
            ArchiveContentCollisionGuard archiveContentCollisionGuard = ArchiveContentCollisionGuard.INSTANCE;
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            ArchiveLaneOwnership archiveLaneOwnership = ArchiveLaneOwnership.INSTANCE;
            DurableArchiveStateStore durableArchiveStateStore = this.archiveStateStore;
            if (durableArchiveStateStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
                durableArchiveStateStore = null;
            }
            List<ArchiveOwnedPath> fromLoaded = archiveLaneOwnership.fromLoaded(durableArchiveStateStore.load());
            ArchiveLaneOwnership archiveLaneOwnership2 = ArchiveLaneOwnership.INSTANCE;
            DurableArchiveStateStore durableArchiveStateStore2 = this.viceArchiveStateStore;
            if (durableArchiveStateStore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                durableArchiveStateStore2 = null;
            }
            archiveContentCollisionGuard.validate(emptyList, emptyList2, fromLoaded, archiveLaneOwnership2.fromLoaded(durableArchiveStateStore2.load())).requireValid();
            return null;
        } catch (Exception e) {
            String message = e.getMessage();
            return message == null ? e.getClass().getSimpleName() : message;
        }
    }

    private final boolean isViceCityEnabled() {
        return SettingsMenuDefaults.prefs(this).getBoolean(SettingsMenuDefaults.KEY_VICE_CITY_ENABLED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/arizona/launcher/UpdateService$ViceCityRequestResult;", "", FirebaseAnalytics.Param.SUCCESS, "", "sizeBytes", "", UpdateServiceContract.BundleKey.DETAIL, "", "enabled", "refresh", "<init>", "(ZJLjava/lang/String;Ljava/lang/Boolean;Z)V", "getSuccess", "()Z", "getSizeBytes", "()J", "getDetail", "()Ljava/lang/String;", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRefresh", "component1", "component2", "component3", "component4", "component5", "copy", "(ZJLjava/lang/String;Ljava/lang/Boolean;Z)Lcom/arizona/launcher/UpdateService$ViceCityRequestResult;", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ViceCityRequestResult {
        private final String detail;
        private final Boolean enabled;
        private final boolean refresh;
        private final long sizeBytes;
        private final boolean success;

        public static /* synthetic */ ViceCityRequestResult copy$default(ViceCityRequestResult viceCityRequestResult, boolean z, long j, String str, Boolean bool, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = viceCityRequestResult.success;
            }
            if ((i & 2) != 0) {
                j = viceCityRequestResult.sizeBytes;
            }
            if ((i & 4) != 0) {
                str = viceCityRequestResult.detail;
            }
            if ((i & 8) != 0) {
                bool = viceCityRequestResult.enabled;
            }
            if ((i & 16) != 0) {
                z2 = viceCityRequestResult.refresh;
            }
            boolean z3 = z2;
            String str2 = str;
            return viceCityRequestResult.copy(z, j, str2, bool, z3);
        }

        public final boolean component1() {
            return this.success;
        }

        public final long component2() {
            return this.sizeBytes;
        }

        public final String component3() {
            return this.detail;
        }

        public final Boolean component4() {
            return this.enabled;
        }

        public final boolean component5() {
            return this.refresh;
        }

        public final ViceCityRequestResult copy(boolean z, long j, String str, Boolean bool, boolean z2) {
            return new ViceCityRequestResult(z, j, str, bool, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViceCityRequestResult) {
                ViceCityRequestResult viceCityRequestResult = (ViceCityRequestResult) obj;
                return this.success == viceCityRequestResult.success && this.sizeBytes == viceCityRequestResult.sizeBytes && Intrinsics.areEqual(this.detail, viceCityRequestResult.detail) && Intrinsics.areEqual(this.enabled, viceCityRequestResult.enabled) && this.refresh == viceCityRequestResult.refresh;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.success) * 31) + Long.hashCode(this.sizeBytes)) * 31;
            String str = this.detail;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.enabled;
            return ((hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + Boolean.hashCode(this.refresh);
        }

        public String toString() {
            boolean z = this.success;
            long j = this.sizeBytes;
            String str = this.detail;
            Boolean bool = this.enabled;
            return "ViceCityRequestResult(success=" + z + ", sizeBytes=" + j + ", detail=" + str + ", enabled=" + bool + ", refresh=" + this.refresh + ")";
        }

        public ViceCityRequestResult(boolean z, long j, String str, Boolean bool, boolean z2) {
            this.success = z;
            this.sizeBytes = j;
            this.detail = str;
            this.enabled = bool;
            this.refresh = z2;
        }

        public /* synthetic */ ViceCityRequestResult(boolean z, long j, String str, Boolean bool, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? false : z2);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public final boolean getRefresh() {
            return this.refresh;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryViceCityContent(long j, Messenger messenger) {
        launchViceCityRequest(11, j, messenger, new UpdateService$queryViceCityContent$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retainViceCityContent(long j, Messenger messenger) {
        launchViceCityRequest(12, j, messenger, new UpdateService$retainViceCityContent$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteViceCityContent(long j, Messenger messenger) {
        launchViceCityRequest(13, j, messenger, new UpdateService$deleteViceCityContent$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void activateViceCityContent(long j, Messenger messenger) {
        launchViceCityRequest(14, j, messenger, new UpdateService$activateViceCityContent$1(this, null));
    }

    private final void launchViceCityRequest(int i, long j, Messenger messenger, Function1<? super Continuation<? super ViceCityRequestResult>, ? extends Object> function1) {
        if (this.updateOperationCoordinator.current() == null && this.viceCityMutationActive.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new UpdateService$launchViceCityRequest$1(function1, this, messenger, i, j, null), 3, null);
        } else {
            sendViceCityContentResult$default(this, messenger, i, j, false, 0L, "Another update operation is active", 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object withViceCityArchiveLock(Function0<? extends T> function0, Continuation<? super T> continuation) {
        return ArchiveUpdateTransactionLock.INSTANCE.withLock(new UpdateService$withViceCityArchiveLock$2(function0, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean persistViceCityPreference(boolean z) {
        return SettingsMenuDefaults.prefs(this).edit().putBoolean(SettingsMenuDefaults.KEY_VICE_CITY_ENABLED, z).commit();
    }

    private final void recoverPendingViceCityDelete() {
        if (this.viceCityMutationActive.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new UpdateService$recoverPendingViceCityDelete$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPendingViceCityRefresh() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateService.dispatchPendingViceCityRefresh$dispatchPendingViceCityRefresh(UpdateService.this);
                }
            });
        } else if (this.serviceAlive.get() && !this.viceCityMutationActive.get() && this.updateOperationCoordinator.current() == null) {
            boolean z = false;
            if (this.refreshAfterViceCityMutation.compareAndSet(true, false)) {
                try {
                    z = requestCheckUpdate();
                } catch (CancellationException e) {
                    this.refreshAfterViceCityMutation.set(true);
                    throw e;
                } catch (Exception e2) {
                    Log.e(TAG, "Unable to request update check after Vice-City mutation", e2);
                }
                if (z) {
                    return;
                }
                this.refreshAfterViceCityMutation.set(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchPendingViceCityRefresh$dispatchPendingViceCityRefresh(UpdateService updateService) {
        Intrinsics.checkNotNullParameter(updateService, "<this>");
        updateService.dispatchPendingViceCityRefresh();
    }

    static /* synthetic */ void sendViceCityContentResult$default(UpdateService updateService, Messenger messenger, int i, long j, boolean z, long j2, String str, int i2, Object obj) {
        updateService.sendViceCityContentResult(messenger, i, j, z, (i2 & 16) != 0 ? 0L : j2, (i2 & 32) != 0 ? null : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendViceCityContentResult(Messenger messenger, int i, long j, boolean z, long j2, String str) {
        Message obtain = Message.obtain(this.mInHandler, i);
        obtain.getData().putLong(UpdateServiceContract.BundleKey.REQUEST_ID, j);
        obtain.getData().putBoolean("status", z);
        obtain.getData().putLong(UpdateServiceContract.BundleKey.TOTAL_SIZE, j2);
        if (str != null) {
            obtain.getData().putString(UpdateServiceContract.BundleKey.DETAIL, str);
        }
        obtain.replyTo = this.mMessenger;
        if (messenger != null) {
            try {
                messenger.send(obtain);
            } catch (Exception e) {
                Log.w(TAG, "Unable to publish Vice-City content result", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPreparedGameUpdateCheck(ArchiveUpdateCheckDecision archiveUpdateCheckDecision, ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot) {
        if (archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.UseArchive) {
            ArchiveUpdateCheckDecision.UseArchive useArchive = (ArchiveUpdateCheckDecision.UseArchive) archiveUpdateCheckDecision;
            ArchivePlanType type = useArchive.getPlan().getType();
            ArchivePlanReason reason = useArchive.getPlan().getReason();
            Log.i(TAG, "Archive plan=" + type + " reason=" + reason + " downloadBytes=" + archiveUpdateSessionSnapshot.getStorageRequirements().getDownloadBytes());
            resetGameStatus();
        } else if (archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.Bootstrap) {
            Log.i(TAG, "Archive clean bootstrap pending downloadBytes=" + ((ArchiveUpdateCheckDecision.Bootstrap) archiveUpdateCheckDecision).getPending().getDownloadBytes());
            resetGameStatus();
        } else if (!(archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.Block)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ArchiveUpdateCheckDecision.Block block = (ArchiveUpdateCheckDecision.Block) archiveUpdateCheckDecision;
            this.mLastOperationStatus = UpdateServiceKt.archiveCheckBlockErrno(block.getCode());
            ArchiveUpdateCheckBlockCode code = block.getCode();
            String detail = block.getDetail();
            if (detail == null) {
                detail = "";
            }
            Log.e(TAG, "Archive updater blocked: " + code + ": " + detail);
            this.mGameStatus.set(GameStatus.UpdateRequired);
        }
        setUpdateStatus(UpdateStatus.Undefined);
    }

    private final Long beginUpdateOperation(UpdateOperationKind updateOperationKind) {
        boolean isViceCityStateSensitive;
        if (!this.serviceAlive.get()) {
            Log.i(TAG, "Ignore " + updateOperationKind + " after service destruction");
            return null;
        }
        if (this.viceCityMutationActive.get()) {
            isViceCityStateSensitive = UpdateServiceKt.isViceCityStateSensitive(updateOperationKind);
            if (isViceCityStateSensitive) {
                if (updateOperationKind == UpdateOperationKind.CHECK_UPDATE || updateOperationKind == UpdateOperationKind.CHECK_AND_DOWNLOAD) {
                    this.refreshAfterViceCityMutation.set(true);
                }
                Log.i(TAG, "Coalesce " + updateOperationKind + " while Vice-City content is being changed");
                return null;
            }
        }
        UpdateOperationBeginResult begin = this.updateOperationCoordinator.begin(updateOperationKind);
        if (begin instanceof UpdateOperationBeginResult.Started) {
            return Long.valueOf(((UpdateOperationBeginResult.Started) begin).getOperation().getToken());
        }
        if (!(begin instanceof UpdateOperationBeginResult.Busy)) {
            throw new NoWhenBranchMatchedException();
        }
        UpdateOperationBeginResult.Busy busy = (UpdateOperationBeginResult.Busy) begin;
        Log.i(TAG, "Coalesce " + updateOperationKind + " while " + busy.getActive().getKind() + " is active");
        if (busy.getActive().getKind() == UpdateOperationKind.ARCHIVE_UPDATE) {
            updateStatusInfoAndProgress(isArchiveProgressIndeterminate());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCurrentUpdateOperation(UpdateOperationKind updateOperationKind, long j) {
        return this.serviceAlive.get() && this.updateOperationCoordinator.isCurrent(updateOperationKind, j);
    }

    private final boolean finishUpdateOperation(UpdateOperationKind updateOperationKind, long j) {
        boolean finish = this.updateOperationCoordinator.finish(updateOperationKind, j);
        if (finish) {
            dispatchPendingViceCityRefresh();
        }
        return finish;
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(UPDATE_SERVICE_CHANNEL_ID, "Update Service", 2);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(TAG, "onStartCommand");
        int onStartCommand = super.onStartCommand(intent, i, i2);
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != 880218081) {
                if (hashCode == 1443478529 && action.equals(ACTION_STOP_FOREGROUND_SERVICE)) {
                    Log.d(TAG, "Receive ACTION_STOP_FOREGROUND_SERVICE");
                    stopForegroundService();
                    return onStartCommand;
                }
            } else if (action.equals(ACTION_START_FOREGROUND_SERVICE)) {
                Log.d(TAG, "Receive ACTION_START_FOREGROUND_SERVICE");
                if (startForegroundService(true) instanceof ForegroundPromotionResult.Rejected) {
                    stopSelf(i2);
                    return 2;
                }
                return 2;
            }
        }
        return onStartCommand;
    }

    static /* synthetic */ ForegroundPromotionResult startForegroundService$default(UpdateService updateService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return updateService.startForegroundService(z);
    }

    private final ForegroundPromotionResult startForegroundService(boolean z) {
        ForegroundPromotionResult.Reason reason;
        if (Build.VERSION.SDK_INT < 26 || this.foregroundServiceActive) {
            return ForegroundPromotionResult.Ready.INSTANCE;
        }
        if (z || isAppInForeground()) {
            try {
                Log.i(TAG, "startForegroundService");
                Notification createNotification = createNotification(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    startForeground(1, createNotification, 1);
                } else {
                    startForeground(1, createNotification);
                }
                this.foregroundServiceActive = true;
                return ForegroundPromotionResult.Ready.INSTANCE;
            } catch (Exception e) {
                Exception exc = e;
                FirebaseCrashlytics.getInstance().recordException(exc);
                if (Build.VERSION.SDK_INT >= 31 && (e instanceof ForegroundServiceStartNotAllowedException)) {
                    reason = ForegroundPromotionResult.Reason.SYSTEM_REJECTED;
                } else {
                    reason = ForegroundPromotionResult.Reason.UNEXPECTED_ERROR;
                }
                Log.e(TAG, "Foreground service cannot be started: " + e.getMessage(), exc);
                return new ForegroundPromotionResult.Rejected(reason, e);
            }
        }
        Log.w(TAG, "Foreground promotion rejected because the app is in background");
        return new ForegroundPromotionResult.Rejected(ForegroundPromotionResult.Reason.APP_IN_BACKGROUND, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeviceOnline() {
        NetworkCapabilities activeNetworkCapabilities = activeNetworkCapabilities();
        return activeNetworkCapabilities != null && activeNetworkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeviceNetworkValidated() {
        NetworkCapabilities activeNetworkCapabilities = activeNetworkCapabilities();
        return activeNetworkCapabilities != null && activeNetworkCapabilities.hasCapability(16);
    }

    private final NetworkCapabilities activeNetworkCapabilities() {
        Network activeNetwork;
        Object systemService = getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null) {
            return null;
        }
        return connectivityManager.getNetworkCapabilities(activeNetwork);
    }

    private final boolean isAppInForeground() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Intrinsics.areEqual(runningAppProcessInfo.processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    private final Notification createNotification(boolean z) {
        String str;
        Intent intent;
        UpdateTransferProgressSnapshot snapshot = this.transferProgress.snapshot();
        ArchiveInstallerPhase visibleArchiveInstallerPhase = visibleArchiveInstallerPhase();
        switch (visibleArchiveInstallerPhase == null ? -1 : WhenMappings.$EnumSwitchMapping$1[visibleArchiveInstallerPhase.ordinal()]) {
            case -1:
            case 6:
                str = "Осталось времени: " + timeLeft();
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                str = getString(R.string.archive_phase_waiting_for_network);
                break;
            case 2:
                str = getString(R.string.archive_phase_verifying);
                break;
            case 3:
                str = getString(R.string.archive_phase_extracting);
                break;
            case 4:
            case 5:
                str = getString(R.string.archive_phase_installing);
                break;
        }
        Intrinsics.checkNotNull(str);
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        Intent intent2 = null;
        if (launchIntentForPackage != null && (intent = launchIntentForPackage.setPackage(null)) != null) {
            intent2 = intent.setFlags(270532608);
        }
        UpdateService updateService = this;
        Notification build = new NotificationCompat.Builder(updateService, UPDATE_SERVICE_CHANNEL_ID).setContentTitle(getString(R.string.update)).setContentText(str).setSmallIcon(R.mipmap.ic_launcher_foreground).setContentIntent(PendingIntent.getActivity(updateService, 0, intent2, 67108864)).setProgress((int) (snapshot.getTotalBytes() / 1024), (int) (snapshot.getDisplayedDownloadedBytes() / 1024), z).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final void stopForegroundService() {
        Log.i(TAG, "stopForegroundService");
        this.foregroundServiceActive = false;
        stopForeground(true);
        stopForeground(1);
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.v(TAG, "onBind");
        Messenger messenger = this.mMessenger;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.i(TAG, "onUnbind");
        return false;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.i(TAG, "onRebind");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        releaseServiceResources();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        Log.i(TAG, "onTaskRemoved");
        if (LauncherUpdateLifecyclePolicy.INSTANCE.keepRunningAfterTaskRemoved(activeUpdateOperation())) {
            this.mActivityMessenger = null;
            super.onTaskRemoved(intent);
            return;
        }
        releaseServiceResources();
        stopSelf();
        super.onTaskRemoved(intent);
    }

    private final void releaseServiceResources() {
        this.foregroundServiceActive = false;
        this.serviceAlive.set(false);
        this.archiveNetworkPending.set(false);
        this.archiveInstallerPhase.set(null);
        this.updateOperationCoordinator.invalidate();
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow = this.archiveUpdateFlow;
        if (archiveUpdateServiceFlow != null) {
            if (archiveUpdateServiceFlow == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveUpdateFlow");
                archiveUpdateServiceFlow = null;
            }
            archiveUpdateServiceFlow.cancel();
        }
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow2 = this.viceArchiveUpdateFlow;
        if (archiveUpdateServiceFlow2 != null) {
            if (archiveUpdateServiceFlow2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveUpdateFlow");
                archiveUpdateServiceFlow2 = null;
            }
            archiveUpdateServiceFlow2.cancel();
        }
        LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.launcherUpdateFlow;
        if (launcherUpdateServiceFlow != null) {
            if (launcherUpdateServiceFlow == null) {
                Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
                launcherUpdateServiceFlow = null;
            }
            launcherUpdateServiceFlow.cancelApkDownload();
        }
        CoroutineScopeKt.cancel$default(this.serviceScope, null, 1, null);
        this.mainHandler.removeCallbacksAndMessages(null);
        IncomingHandler incomingHandler = this.mInHandler;
        if (incomingHandler != null) {
            incomingHandler.removeCallbacksAndMessages(null);
        }
        this.mInHandler = null;
        this.mMessenger = null;
        this.mActivityMessenger = null;
        HandlerThread handlerThread = this.serviceHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.serviceHandlerThread = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean requestCheckUpdate() {
        FileServers.INSTANCE.refreshGameServers();
        GameUpdateServiceFlow gameUpdateServiceFlow = this.gameUpdateFlow;
        if (gameUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameUpdateFlow");
            gameUpdateServiceFlow = null;
        }
        return gameUpdateServiceFlow.requestCheck();
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public Long beginGameCheckOperation(boolean z) {
        return beginUpdateOperation(gameCheckOperationKind(z));
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public boolean isCurrentGameCheckOperation(boolean z, long j) {
        return isCurrentUpdateOperation(gameCheckOperationKind(z), j);
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void finishGameCheckOperation(boolean z, long j) {
        finishUpdateOperation(gameCheckOperationKind(z), j);
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void onGameCheckStarted(boolean z) {
        Log.i(TAG, "checkUpdate: requesting server for update json");
        boolean isViceCityEnabled = isViceCityEnabled();
        ArchiveUpdateSessionState archiveUpdateSessionState = this.viceArchiveSession;
        if (isViceCityEnabled) {
            archiveUpdateSessionState.invalidateForManifestRefresh();
        } else {
            archiveUpdateSessionState.markCommitted();
        }
        startForegroundService$default(this, false, 1, null);
        setUpdateStatus(UpdateStatus.CheckUpdate);
        this.mLastOperationStatus = Errno.NoError;
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void onGameMetadataLoaded(boolean z, String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (isViceCityEnabled()) {
            this.viceArchiveSession.beginMetadataEvaluation();
        }
        if (z) {
            return;
        }
        setUpdateStatus(UpdateStatus.CheckFiles);
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void onGameCheckMirrorRetry(String server, String source) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(source, "source");
        setUpdateStatus(UpdateStatus.CheckUpdate);
        Log.w(TAG, "Retry " + source + " from mirror: " + server);
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void completeGameCheckServerEmpty(boolean z) {
        if (z) {
            notifyCheckUpdateAndDownloadUnreachable$default(this, UpdateAnalyticsErrorEvent.CHECK_AND_DOWNLOAD_SERVER_EMPTY, null, null, 6, null);
        } else {
            notifyGameUpdateCheckUnreachable$default(this, UpdateAnalyticsErrorEvent.GAME_UPDATE_SERVER_EMPTY, false, false, null, null, null, 56, null);
        }
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void completeGameCheckMetadataFailed(boolean z, UpdateMetadataHttpResult failure, String failedServer) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(failedServer, "failedServer");
        Log.w(TAG, "Game metadata request failed: " + failure);
        if (z) {
            notifyCheckUpdateAndDownloadUnreachable(UpdateAnalyticsErrorEvent.CHECK_AND_DOWNLOAD_REQUEST_FAILED, failure, failedServer);
        } else {
            notifyGameUpdateCheckUnreachable$default(this, UpdateAnalyticsErrorEvent.GAME_UPDATE_REQUEST_FAILED, true, false, failure.toString(), failure, failedServer, 4, null);
        }
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void completePreparedGameCheck(boolean z, boolean z2, ArchiveUpdateCheckDecision.Block block) {
        DownloadFailureDetails downloadFailureDetails;
        if (!z) {
            notifyGameUpdateCheckCompleted(z2);
        } else if (z2) {
            updateGameData();
        } else {
            Errno errno = this.mLastOperationStatus;
            if (block != null) {
                downloadFailureDetails = new DownloadFailureDetails("CHECK_" + block.getCode().name(), null, null, 6, null);
            } else {
                downloadFailureDetails = null;
            }
            notifyArchiveUpdateFailure$default(this, "archive update check is blocked", errno, downloadFailureDetails, null, null, 24, null);
        }
    }

    private final UpdateOperationKind gameCheckOperationKind(boolean z) {
        if (z) {
            return UpdateOperationKind.CHECK_AND_DOWNLOAD;
        }
        return UpdateOperationKind.CHECK_UPDATE;
    }

    private final void notifyGameUpdateCheckCompleted(boolean z) {
        Message obtain = Message.obtain(this.mInHandler, 0);
        obtain.getData().putBoolean("status", z);
        obtain.getData().putBoolean(UpdateServiceContract.BundleKey.IS_GAME_DATA_UPDATE_EXISTS, isGameDataUpdateExists());
        obtain.getData().putLong(UpdateServiceContract.BundleKey.TOTAL_SIZE, plannedArchiveDownloadBytes());
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        Log.i(TAG, "Send message check update " + obtain);
        stopForegroundService();
    }

    static /* synthetic */ void notifyGameUpdateCheckUnreachable$default(UpdateService updateService, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, boolean z, boolean z2, String str, UpdateMetadataHttpResult updateMetadataHttpResult, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        updateService.notifyGameUpdateCheckUnreachable(updateAnalyticsErrorEvent, z, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : updateMetadataHttpResult, (i & 32) != 0 ? null : str2);
    }

    private final void notifyGameUpdateCheckUnreachable(UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, boolean z, boolean z2, String str, UpdateMetadataHttpResult updateMetadataHttpResult, String str2) {
        UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
        UpdateAnalyticsReporter updateAnalyticsReporter2 = null;
        if (updateMetadataHttpResult != null) {
            if (updateAnalyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                updateAnalyticsReporter = null;
            }
            updateAnalyticsReporter.reportMetadataError(updateAnalyticsErrorEvent, updateMetadataHttpResult, str2);
        } else {
            if (updateAnalyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            } else {
                updateAnalyticsReporter2 = updateAnalyticsReporter;
            }
            UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter2, updateAnalyticsErrorEvent, null, null, null, 14, null);
        }
        this.mLastOperationStatus = Errno.UpdateServerUnreachable;
        if (z2) {
            setUpdateStatus(UpdateStatus.Undefined);
        }
        Message obtain = Message.obtain(this.mInHandler, 0);
        if (z) {
            obtain.getData().putBoolean("status", false);
        }
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        if (str == null) {
            str = "";
        }
        Log.w(TAG, "Send message server unreachable " + obtain + " " + str);
        stopForegroundService();
    }

    private final boolean isGameDataUpdateExists() {
        return this.archiveSession.snapshot().getHasPendingWork() || hasPendingViceArchiveWork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGameStatus() {
        Log.i(TAG, "resetGameStatus");
        this.mGameStatus.set(isGameDataUpdateExists() ? GameStatus.UpdateRequired : GameStatus.Updated);
        Log.d(TAG, "Installed game status: " + this.mGameStatus.get());
    }

    public final void updateGameData() {
        boolean z;
        UpdateOperationSnapshot current;
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow = this.archiveUpdateFlow;
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow2 = null;
        if (archiveUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveUpdateFlow");
            archiveUpdateServiceFlow = null;
        }
        if (!archiveUpdateServiceFlow.isDownloadActive()) {
            ArchiveUpdateServiceFlow archiveUpdateServiceFlow3 = this.viceArchiveUpdateFlow;
            if (archiveUpdateServiceFlow3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveUpdateFlow");
                archiveUpdateServiceFlow3 = null;
            }
            if (!archiveUpdateServiceFlow3.isDownloadActive()) {
                z = false;
                current = this.updateOperationCoordinator.current();
                if (!z || current != null) {
                    if (current != null || (r1 = current.getKind()) == null) {
                        UpdateOperationKind updateOperationKind = UpdateOperationKind.ARCHIVE_UPDATE;
                    }
                    onArchiveRequestCoalesced(z, updateOperationKind);
                }
                this.continueWithViceAfterBase = false;
                this.combinedArchiveProgress.reset();
                ArchiveUpdaterStorageScope first = ArchiveLaneDownloadSequence.INSTANCE.first(this.archiveSession.snapshot().getHasPendingWork(), hasPendingViceArchiveWork());
                int i = first == null ? -1 : WhenMappings.$EnumSwitchMapping$0[first.ordinal()];
                if (i == -1) {
                    this.activeArchiveScope = ArchiveUpdaterStorageScope.BASE;
                    ArchiveUpdateServiceFlow archiveUpdateServiceFlow4 = this.archiveUpdateFlow;
                    if (archiveUpdateServiceFlow4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("archiveUpdateFlow");
                    } else {
                        archiveUpdateServiceFlow2 = archiveUpdateServiceFlow4;
                    }
                    archiveUpdateServiceFlow2.requestDownload();
                    return;
                } else if (i == 1) {
                    this.activeArchiveScope = ArchiveUpdaterStorageScope.BASE;
                    ArchiveUpdateServiceFlow archiveUpdateServiceFlow5 = this.archiveUpdateFlow;
                    if (archiveUpdateServiceFlow5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("archiveUpdateFlow");
                    } else {
                        archiveUpdateServiceFlow2 = archiveUpdateServiceFlow5;
                    }
                    archiveUpdateServiceFlow2.requestDownload();
                    return;
                } else if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    this.activeArchiveScope = ArchiveUpdaterStorageScope.VICE;
                    ArchiveUpdateServiceFlow archiveUpdateServiceFlow6 = this.viceArchiveUpdateFlow;
                    if (archiveUpdateServiceFlow6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viceArchiveUpdateFlow");
                    } else {
                        archiveUpdateServiceFlow2 = archiveUpdateServiceFlow6;
                    }
                    archiveUpdateServiceFlow2.requestDownload();
                    return;
                }
            }
        }
        z = true;
        current = this.updateOperationCoordinator.current();
        if (!z) {
        }
        if (current != null) {
        }
        UpdateOperationKind updateOperationKind2 = UpdateOperationKind.ARCHIVE_UPDATE;
        onArchiveRequestCoalesced(z, updateOperationKind2);
    }

    private final boolean hasPendingViceArchiveWork() {
        return isViceCityEnabled() && this.viceContentAvailable && this.viceArchiveSession.snapshot().getHasPendingWork();
    }

    private final long plannedArchiveDownloadBytes() {
        return saturatedAdd(this.archiveSession.snapshot().getStorageRequirements().getDownloadBytes(), hasPendingViceArchiveWork() ? this.viceArchiveSession.snapshot().getStorageRequirements().getDownloadBytes() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingLaterArchiveLaneBytes() {
        if (this.activeArchiveScope == ArchiveUpdaterStorageScope.BASE && hasPendingViceArchiveWork()) {
            return this.viceArchiveSession.snapshot().getStorageRequirements().getDownloadBytes();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveStorageRequirementsSnapshot combinedArchiveStorageRequirements() {
        ArchiveStorageRequirementsSnapshot archiveStorageRequirementsSnapshot;
        ArchiveStorageRequirementsSnapshot storageRequirements = this.archiveSession.snapshot().getStorageRequirements();
        if (hasPendingViceArchiveWork()) {
            archiveStorageRequirementsSnapshot = this.viceArchiveSession.snapshot().getStorageRequirements();
        } else {
            archiveStorageRequirementsSnapshot = new ArchiveStorageRequirementsSnapshot(0L, 0L, 0L, 0L);
        }
        return new ArchiveStorageRequirementsSnapshot(saturatedAdd(storageRequirements.getDownloadBytes(), archiveStorageRequirementsSnapshot.getDownloadBytes()), saturatedAdd(storageRequirements.getRequiredFreeSpaceBytes(), archiveStorageRequirementsSnapshot.getRequiredFreeSpaceBytes()), saturatedAdd(storageRequirements.getGameStorageBytes(), archiveStorageRequirementsSnapshot.getGameStorageBytes()), saturatedAdd(storageRequirements.getDownloadStorageBytes(), archiveStorageRequirementsSnapshot.getDownloadStorageBytes()));
    }

    private final long saturatedAdd(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        long coerceAtLeast2 = RangesKt.coerceAtLeast(j2, 0L);
        if (Long.MAX_VALUE - coerceAtLeast < coerceAtLeast2) {
            return Long.MAX_VALUE;
        }
        return coerceAtLeast + coerceAtLeast2;
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public boolean isArchiveServiceAlive() {
        return this.serviceAlive.get();
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public UpdateOperationSnapshot activeUpdateOperation() {
        return this.updateOperationCoordinator.current();
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public Long beginArchiveOperation() {
        return beginUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public boolean isCurrentArchiveOperation(long j) {
        return isCurrentUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE, j);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void finishArchiveOperation(long j) {
        boolean finish = this.updateOperationCoordinator.finish(UpdateOperationKind.ARCHIVE_UPDATE, j);
        if (!finish || !this.continueWithViceAfterBase) {
            if (finish) {
                dispatchPendingViceCityRefresh();
                return;
            }
            return;
        }
        this.continueWithViceAfterBase = false;
        if (!this.serviceAlive.get() || !hasPendingViceArchiveWork()) {
            completeArchiveSuccessTerminal();
            return;
        }
        this.activeArchiveScope = ArchiveUpdaterStorageScope.VICE;
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow = this.viceArchiveUpdateFlow;
        if (archiveUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viceArchiveUpdateFlow");
            archiveUpdateServiceFlow = null;
        }
        archiveUpdateServiceFlow.requestDownload();
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void onArchiveRequestCoalesced(boolean z, UpdateOperationKind updateOperationKind) {
        if (z) {
            Log.i(TAG, "Archive game-data update already active; coalescing duplicate request");
            updateStatusInfoAndProgress(isArchiveProgressIndeterminate());
            return;
        }
        Log.i(TAG, "Coalesce game-data request while " + updateOperationKind + " is active");
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void onArchiveStartupCorrupt() {
        notifyArchiveUpdateFailure$default(this, "archive journal is corrupt", Errno.ArchiveRecoveryBlocked, null, null, null, 28, null);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void requestArchiveManifestRefresh(String reason, boolean z) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (z) {
            Log.w(TAG, reason);
        } else {
            Log.i(TAG, reason);
        }
        requestCheckUpdateAndDownload$default(this, false, 1, null);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void setArchiveBenchmarkMode(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        benchmarkObservedDownloadMode = mode;
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void onArchiveDownloadSelected() {
        Log.d(TAG, "updateGameData: game data update exists, downloading game data...");
        setUpdateStatus(UpdateStatus.DownloadGameData);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void onArchiveNoWork() {
        EngineResourceGenerationController engineResourceGenerationController = this.resourceGeneration;
        if (engineResourceGenerationController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
            engineResourceGenerationController = null;
        }
        engineResourceGenerationController.onNoWork(new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateService.onArchiveNoWork$lambda$0(UpdateService.this);
            }
        }, new UpdateService$onArchiveNoWork$2(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onArchiveNoWork$lambda$0(UpdateService updateService) {
        updateService.requestArchiveManifestRefresh("Resource generation is incomplete or corrupt; starting a fresh archive check", false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportArchiveDataReady() {
        Log.d(TAG, "updateGameData: game update status: undefined");
        this.archiveNetworkPending.set(false);
        UpdateAnalyticsReporter updateAnalyticsReporter = null;
        this.archiveInstallerPhase.set(null);
        setUpdateStatus(UpdateStatus.Undefined);
        UpdateAnalyticsReporter updateAnalyticsReporter2 = this.analyticsReporter;
        if (updateAnalyticsReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            updateAnalyticsReporter = updateAnalyticsReporter2;
        }
        updateAnalyticsReporter.finishFirstLaunchSession();
        Message obtain = Message.obtain(this.mInHandler, 2);
        obtain.getData().putBoolean("status", true);
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        Log.v(TAG, "Send message game data updated " + obtain);
        if (this.mLastOperationStatus == Errno.NoError) {
            stopForegroundService();
        }
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public ArchiveStorageSpaceCheckResult checkArchiveStorageSpace(ArchiveStorageRequirementsSnapshot requirements) {
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        return this.archiveStorageSpaceChecker.check(getExternalFilesDir(null), archiveCacheAnchor(), requirements);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public ArchiveForegroundPromotion promoteArchiveForeground() {
        ForegroundPromotionResult startForegroundService$default = startForegroundService$default(this, false, 1, null);
        if (Intrinsics.areEqual(startForegroundService$default, ForegroundPromotionResult.Ready.INSTANCE)) {
            return ArchiveForegroundPromotion.Ready.INSTANCE;
        }
        if (!(startForegroundService$default instanceof ForegroundPromotionResult.Rejected)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ArchiveForegroundPromotion.Rejected(((ForegroundPromotionResult.Rejected) startForegroundService$default).getReason().name());
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void beginArchiveProgress(long j, boolean z) {
        ArchiveInstallerPhase archiveInstallerPhase;
        this.mLastOperationStatus = Errno.NoError;
        CombinedArchiveTransferSnapshot beginLane = this.combinedArchiveProgress.beginLane(RangesKt.coerceAtLeast(j, 0L), remainingLaterArchiveLaneBytes());
        if (this.activeArchiveScope == ArchiveUpdaterStorageScope.BASE || beginLane.getCompletedOffsetBytes() == 0) {
            this.transferProgress.beginArchive(beginLane.getCombinedTotalBytes());
        } else {
            this.transferProgress.beginArchiveSegment(beginLane.getCompletedOffsetBytes(), beginLane.getCombinedTotalBytes());
        }
        this.archiveNetworkPending.set(j > 0 && !z);
        AtomicReference<ArchiveInstallerPhase> atomicReference = this.archiveInstallerPhase;
        if (z) {
            archiveInstallerPhase = ArchiveInstallerPhase.COMMITTING;
        } else {
            archiveInstallerPhase = ArchiveInstallerPhase.DOWNLOADING;
        }
        atomicReference.set(archiveInstallerPhase);
        updateStatusInfoAndProgress(z);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public ArchivePackageUpdater createArchivePackageUpdater() {
        return ArchivePackageUpdater.Companion.create(this, isGameDownloadRetryEnabled(), archiveStorageRoots(this.activeArchiveScope), this.activeArchiveScope);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public ArchiveMirrorExecutionCoordinator createArchiveMirrorCoordinator(long j) {
        return archiveMirrorExecutionCoordinator(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f1 A[RETURN] */
    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object finalizeArchiveMetadata(ArchiveManifest archiveManifest, Continuation<? super ArchiveMetadataFinalizationResult> continuation) {
        UpdateService$finalizeArchiveMetadata$1 updateService$finalizeArchiveMetadata$1;
        int i;
        ArchiveStateMaintenance activeArchiveStateMaintenance;
        ArchiveManifest archiveManifest2;
        boolean z;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveMetadataFinalizationResult archiveMetadataFinalizationResult;
        ArchiveMetadataFinalizationResult archiveMetadataFinalizationResult2;
        ArchiveUpdateCheckDecision.Block block;
        if (continuation instanceof UpdateService$finalizeArchiveMetadata$1) {
            updateService$finalizeArchiveMetadata$1 = (UpdateService$finalizeArchiveMetadata$1) continuation;
            if ((updateService$finalizeArchiveMetadata$1.label & Integer.MIN_VALUE) != 0) {
                updateService$finalizeArchiveMetadata$1.label -= Integer.MIN_VALUE;
                Object obj = updateService$finalizeArchiveMetadata$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateService$finalizeArchiveMetadata$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArchiveUpdateSessionState activeArchiveSession = activeArchiveSession();
                    activeArchiveStateMaintenance = activeArchiveStateMaintenance();
                    boolean shouldPurgeMapCache = UpdateServiceKt.shouldPurgeMapCache(activeArchiveSession.snapshot());
                    Log.i(TAG, "Archive payload committed; reconciling archive entry metadata");
                    updateService$finalizeArchiveMetadata$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveManifest);
                    updateService$finalizeArchiveMetadata$1.L$1 = SpillingKt.nullOutSpilledVariable(activeArchiveSession);
                    updateService$finalizeArchiveMetadata$1.L$2 = SpillingKt.nullOutSpilledVariable(activeArchiveStateMaintenance);
                    updateService$finalizeArchiveMetadata$1.Z$0 = shouldPurgeMapCache;
                    updateService$finalizeArchiveMetadata$1.label = 1;
                    Object finalizePublishedMetadata = activeArchiveStateMaintenance.finalizePublishedMetadata(archiveManifest, updateService$finalizeArchiveMetadata$1);
                    if (finalizePublishedMetadata != coroutine_suspended) {
                        archiveManifest2 = archiveManifest;
                        z = shouldPurgeMapCache;
                        archiveUpdateSessionState = activeArchiveSession;
                        obj = finalizePublishedMetadata;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        boolean z2 = updateService$finalizeArchiveMetadata$1.Z$0;
                        archiveMetadataFinalizationResult2 = (ArchiveMetadataFinalizationResult) updateService$finalizeArchiveMetadata$1.L$3;
                        ArchiveStateMaintenance archiveStateMaintenance = (ArchiveStateMaintenance) updateService$finalizeArchiveMetadata$1.L$2;
                        ArchiveUpdateSessionState archiveUpdateSessionState2 = (ArchiveUpdateSessionState) updateService$finalizeArchiveMetadata$1.L$1;
                        ArchiveManifest archiveManifest3 = (ArchiveManifest) updateService$finalizeArchiveMetadata$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        block = (ArchiveUpdateCheckDecision.Block) obj;
                        if (block == null) {
                            String detail = block.getDetail();
                            if (detail == null) {
                                detail = "Unable to persist completed resource generation";
                            }
                            throw new IOException(detail);
                        }
                        return archiveMetadataFinalizationResult2;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z = updateService$finalizeArchiveMetadata$1.Z$0;
                    activeArchiveStateMaintenance = (ArchiveStateMaintenance) updateService$finalizeArchiveMetadata$1.L$2;
                    archiveUpdateSessionState = (ArchiveUpdateSessionState) updateService$finalizeArchiveMetadata$1.L$1;
                    archiveManifest2 = (ArchiveManifest) updateService$finalizeArchiveMetadata$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveMetadataFinalizationResult = (ArchiveMetadataFinalizationResult) obj;
                if (Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE) && z) {
                    deleteMapCacheBestEffort();
                }
                if (Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE)) {
                    return archiveMetadataFinalizationResult;
                }
                updateService$finalizeArchiveMetadata$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveManifest2);
                updateService$finalizeArchiveMetadata$1.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdateSessionState);
                updateService$finalizeArchiveMetadata$1.L$2 = SpillingKt.nullOutSpilledVariable(activeArchiveStateMaintenance);
                updateService$finalizeArchiveMetadata$1.L$3 = archiveMetadataFinalizationResult;
                updateService$finalizeArchiveMetadata$1.Z$0 = z;
                updateService$finalizeArchiveMetadata$1.label = 2;
                Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new UpdateService$finalizeArchiveMetadata$completion$1(this, null), updateService$finalizeArchiveMetadata$1);
                if (withContext != coroutine_suspended) {
                    obj = withContext;
                    archiveMetadataFinalizationResult2 = archiveMetadataFinalizationResult;
                    block = (ArchiveUpdateCheckDecision.Block) obj;
                    if (block == null) {
                    }
                }
                return coroutine_suspended;
            }
        }
        updateService$finalizeArchiveMetadata$1 = new UpdateService$finalizeArchiveMetadata$1(this, continuation);
        Object obj2 = updateService$finalizeArchiveMetadata$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$finalizeArchiveMetadata$1.label;
        if (i != 0) {
        }
        archiveMetadataFinalizationResult = (ArchiveMetadataFinalizationResult) obj2;
        if (Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE)) {
            deleteMapCacheBestEffort();
        }
        if (Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE)) {
        }
    }

    private final void deleteMapCacheBestEffort() {
        Object m9974constructorimpl;
        File resolve;
        try {
            Result.Companion companion = Result.Companion;
            UpdateService updateService = this;
            File externalFilesDir = getExternalFilesDir(null);
            if (externalFilesDir != null && (resolve = FilesKt.resolve(externalFilesDir, EngineResourceGenerationMigration.MAP_CACHE_FILE)) != null && resolve.exists() && resolve.isFile()) {
                if (resolve.delete()) {
                    Log.i(TAG, "Deleted MAPCACHE.BIN after data.pkg archive update");
                } else {
                    Log.w(TAG, "Failed to delete MAPCACHE.BIN after data.pkg archive update");
                }
            }
            m9974constructorimpl = Result.m9974constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9974constructorimpl = Result.m9974constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9977exceptionOrNullimpl = Result.m9977exceptionOrNullimpl(m9974constructorimpl);
        if (m9977exceptionOrNullimpl != null) {
            Log.w(TAG, "Unable to invalidate MAPCACHE.BIN after data.pkg archive update", m9977exceptionOrNullimpl);
        }
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void expandArchiveRuntimeRequirements(ArchiveStorageRequirementsSnapshot requirements) {
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        UpdateTransferProgressSnapshot expandTotalBytes = this.transferProgress.expandTotalBytes(this.combinedArchiveProgress.expandLane(requirements.getDownloadBytes(), remainingLaterArchiveLaneBytes()).getCombinedTotalBytes());
        if (expandTotalBytes.getTotalBytes() > expandTotalBytes.getDownloadedBytes()) {
            this.archiveNetworkPending.set(true);
        }
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void recordArchiveExecutionException(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Exception exc = error;
        Log.e(TAG, "Archive updater crashed", exc);
        FirebaseCrashlytics.getInstance().recordException(exc);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void recordArchiveFinalizationException(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e(TAG, "Unable to durably finalize archive install", error);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void completeArchiveSuccess() {
        Log.i(TAG, "Archive entry metadata reconciliation complete");
        if (ArchiveLaneDownloadSequence.INSTANCE.afterSuccess(this.activeArchiveScope, hasPendingViceArchiveWork()) == ArchiveUpdaterStorageScope.VICE) {
            this.combinedArchiveProgress.completeActiveLane();
            this.continueWithViceAfterBase = true;
            this.archiveNetworkPending.set(false);
            this.archiveInstallerPhase.set(null);
            Log.i(TAG, "Base archive lane committed; scheduling Vice-City archive lane");
            return;
        }
        completeArchiveSuccessTerminal();
    }

    private final void completeArchiveSuccessTerminal() {
        this.mLastOperationStatus = Errno.NoError;
        resetGameStatus();
        this.archiveNetworkPending.set(false);
        UpdateAnalyticsReporter updateAnalyticsReporter = null;
        this.archiveInstallerPhase.set(null);
        setUpdateStatus(UpdateStatus.Undefined);
        UpdateAnalyticsReporter updateAnalyticsReporter2 = this.analyticsReporter;
        if (updateAnalyticsReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            updateAnalyticsReporter = updateAnalyticsReporter2;
        }
        updateAnalyticsReporter.finishFirstLaunchSession();
        Message obtain = Message.obtain(this.mInHandler, 2);
        obtain.getData().putBoolean("status", true);
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        Log.i(TAG, "Archive game-data transaction committed");
        stopForegroundService();
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void completeArchiveFailure(ArchiveServiceFailure failure) {
        Errno errno;
        Intrinsics.checkNotNullParameter(failure, "failure");
        this.archiveNetworkPending.set(false);
        this.archiveInstallerPhase.set(null);
        String detail = failure.getDetail();
        switch (WhenMappings.$EnumSwitchMapping$2[failure.getKind().ordinal()]) {
            case 1:
                errno = Errno.ConnectionRefused;
                break;
            case 2:
                errno = Errno.CorruptedFilesFound;
                break;
            case 3:
                errno = Errno.InsufficientStorage;
                break;
            case 4:
                errno = Errno.StorageUnavailable;
                break;
            case 5:
                errno = Errno.ForegroundServiceUnavailable;
                break;
            case 6:
                errno = Errno.ArchiveRecoveryBlocked;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        notifyArchiveUpdateFailure(detail, errno, failure.getFailureDetails(), failure.getRequiredFreeSpaceBytes(), failure.getOperationToken());
    }

    private final File archiveCacheAnchor() {
        return ArchiveDownloadRootResolver.Companion.getProcess().resolveAnchor(this);
    }

    static /* synthetic */ Boolean archiveStorageUsesSingleDevice$default(UpdateService updateService, File file, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            file = updateService.getExternalFilesDir(null);
        }
        if ((i & 2) != 0) {
            file2 = updateService.archiveCacheAnchor();
        }
        return updateService.archiveStorageUsesSingleDevice(file, file2);
    }

    private final Boolean archiveStorageUsesSingleDevice(File file, File file2) {
        return this.archiveStorageSpaceChecker.usesSingleStorageDevice(file, file2);
    }

    private final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator(final long j) {
        return ArchiveMirrorExecutionCoordinator.Companion.create(activeArchiveStateStore(), activeArchiveSession(), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(UpdateService.archiveMirrorExecutionCoordinator$lambda$0());
            }
        }, new UpdateService$archiveMirrorExecutionCoordinator$2(this), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isCurrentUpdateOperation;
                isCurrentUpdateOperation = UpdateService.this.isCurrentUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE, j);
                return Boolean.valueOf(isCurrentUpdateOperation);
            }
        }, new UpdateService$archiveMirrorExecutionCoordinator$4(FileServers.INSTANCE), new UpdateService$archiveMirrorExecutionCoordinator$5(FileServers.INSTANCE), new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdateService.archiveMirrorExecutionCoordinator$lambda$2(UpdateService.this, (Function0) obj);
            }
        }, new Function2() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UpdateService.archiveMirrorExecutionCoordinator$lambda$3(UpdateService.this, ((Long) obj).longValue(), (Function0) obj2);
            }
        }, new ArchiveMirrorExecutionCallbacks() { // from class: com.arizona.launcher.UpdateService$archiveMirrorExecutionCoordinator$8
            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onRemainingBytesFallback(String str, Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (str == null) {
                    str = "";
                }
                Log.w("UPDATE_SERVICE", "Unable to recalculate archive bytes before mirror retry for package=" + str, error);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onMirrorProgressReset(long j2) {
                CombinedArchiveTransferProgress combinedArchiveTransferProgress;
                long remainingLaterArchiveLaneBytes;
                UpdateTransferProgress updateTransferProgress;
                AtomicBoolean atomicBoolean;
                AtomicReference atomicReference;
                combinedArchiveTransferProgress = UpdateService.this.combinedArchiveProgress;
                long coerceAtLeast = RangesKt.coerceAtLeast(j2, 0L);
                remainingLaterArchiveLaneBytes = UpdateService.this.remainingLaterArchiveLaneBytes();
                CombinedArchiveTransferSnapshot applyLaneTotal = combinedArchiveTransferProgress.applyLaneTotal(coerceAtLeast, remainingLaterArchiveLaneBytes);
                updateTransferProgress = UpdateService.this.transferProgress;
                updateTransferProgress.resetArchiveMirrorSegment(applyLaneTotal.getCompletedOffsetBytes(), j2, applyLaneTotal.getCombinedTotalBytes());
                atomicBoolean = UpdateService.this.archiveNetworkPending;
                atomicBoolean.set(j2 > 0);
                atomicReference = UpdateService.this.archiveInstallerPhase;
                atomicReference.set(ArchiveInstallerPhase.DOWNLOADING);
                UpdateService.this.updateStatusInfoAndProgress(false);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onMirrorSelected(String server) {
                Intrinsics.checkNotNullParameter(server, "server");
                Log.w("UPDATE_SERVICE", "Retry archive transaction from the next mirror: " + server);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onPhase(ArchiveInstallerPhase phase, String str) {
                AtomicReference atomicReference;
                boolean isArchiveProgressIndeterminate;
                Intrinsics.checkNotNullParameter(phase, "phase");
                if (str == null) {
                    str = "";
                }
                Log.i("UPDATE_SERVICE", "Archive phase=" + phase + " package=" + str);
                atomicReference = UpdateService.this.archiveInstallerPhase;
                atomicReference.set(phase);
                UpdateService updateService = UpdateService.this;
                isArchiveProgressIndeterminate = updateService.isArchiveProgressIndeterminate();
                updateService.updateStatusInfoAndProgress(isArchiveProgressIndeterminate);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onDownloadProgress(long j2, long j3) {
                AtomicBoolean atomicBoolean;
                CombinedArchiveTransferProgress combinedArchiveTransferProgress;
                long remainingLaterArchiveLaneBytes;
                UpdateTransferProgress updateTransferProgress;
                boolean isArchiveProgressIndeterminate;
                long coerceAtLeast = RangesKt.coerceAtLeast(j3, 0L);
                atomicBoolean = UpdateService.this.archiveNetworkPending;
                atomicBoolean.set(coerceAtLeast > 0 && RangesKt.coerceAtLeast(j2, 0L) < coerceAtLeast);
                combinedArchiveTransferProgress = UpdateService.this.combinedArchiveProgress;
                remainingLaterArchiveLaneBytes = UpdateService.this.remainingLaterArchiveLaneBytes();
                CombinedArchiveTransferSnapshot applyLaneTotal = combinedArchiveTransferProgress.applyLaneTotal(coerceAtLeast, remainingLaterArchiveLaneBytes);
                updateTransferProgress = UpdateService.this.transferProgress;
                updateTransferProgress.onArchiveSegmentProgress(applyLaneTotal.getCompletedOffsetBytes(), j2, j3, applyLaneTotal.getCombinedTotalBytes());
                UpdateService updateService = UpdateService.this;
                isArchiveProgressIndeterminate = updateService.isArchiveProgressIndeterminate();
                updateService.updateStatusInfoAndProgress(isArchiveProgressIndeterminate);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onRuntimeRequirementsChanged(ArchiveStorageRequirementsSnapshot requirements) {
                boolean isArchiveProgressIndeterminate;
                Intrinsics.checkNotNullParameter(requirements, "requirements");
                UpdateService.this.expandArchiveRuntimeRequirements(requirements);
                long downloadBytes = requirements.getDownloadBytes();
                Log.w("UPDATE_SERVICE", "Archive recovery expanded runtime requirements: download=" + downloadBytes + " required=" + requirements.getRequiredFreeSpaceBytes());
                UpdateService updateService = UpdateService.this;
                isArchiveProgressIndeterminate = updateService.isArchiveProgressIndeterminate();
                updateService.updateStatusInfoAndProgress(isArchiveProgressIndeterminate);
            }

            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks
            public void onRetry(String packageId, int i, long j2, String failureSubtype, String str) {
                UpdateAnalyticsReporter updateAnalyticsReporter;
                Intrinsics.checkNotNullParameter(packageId, "packageId");
                Intrinsics.checkNotNullParameter(failureSubtype, "failureSubtype");
                Log.w("UPDATE_SERVICE", "Archive retry package=" + packageId + " attempt=" + i + " delayMs=" + j2 + " subtype=" + failureSubtype);
                updateAnalyticsReporter = UpdateService.this.analyticsReporter;
                if (updateAnalyticsReporter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                    updateAnalyticsReporter = null;
                }
                updateAnalyticsReporter.reportArchivePackageRetry(packageId, i, j2, failureSubtype, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int archiveMirrorExecutionCoordinator$lambda$0() {
        return FileServers.INSTANCE.getGame_servers().length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit archiveMirrorExecutionCoordinator$lambda$2(UpdateService updateService, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit archiveMirrorExecutionCoordinator$lambda$3(UpdateService updateService, long j, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        updateService.mainHandler.postDelayed(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        }, j);
        return Unit.INSTANCE;
    }

    private final ArchiveUpdateSessionState activeArchiveSession() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.activeArchiveScope.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return this.viceArchiveSession;
        }
        return this.archiveSession;
    }

    private final DurableArchiveStateStore activeArchiveStateStore() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.activeArchiveScope.ordinal()];
        if (i == 1) {
            DurableArchiveStateStore durableArchiveStateStore = this.archiveStateStore;
            if (durableArchiveStateStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
                return null;
            }
            return durableArchiveStateStore;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            DurableArchiveStateStore durableArchiveStateStore2 = this.viceArchiveStateStore;
            if (durableArchiveStateStore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                return null;
            }
            return durableArchiveStateStore2;
        }
    }

    private final ArchiveStateMaintenance activeArchiveStateMaintenance() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.activeArchiveScope.ordinal()];
        if (i == 1) {
            ArchiveStateMaintenance archiveStateMaintenance = this.archiveStateMaintenance;
            if (archiveStateMaintenance == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                return null;
            }
            return archiveStateMaintenance;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            ArchiveStateMaintenance archiveStateMaintenance2 = this.viceArchiveStateMaintenance;
            if (archiveStateMaintenance2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateMaintenance");
                return null;
            }
            return archiveStateMaintenance2;
        }
    }

    static /* synthetic */ void notifyArchiveUpdateFailure$default(UpdateService updateService, String str, Errno errno, DownloadFailureDetails downloadFailureDetails, Long l, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            errno = Errno.CorruptedFilesFound;
        }
        updateService.notifyArchiveUpdateFailure(str, errno, (i & 4) != 0 ? null : downloadFailureDetails, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    private final void notifyArchiveUpdateFailure(String str, Errno errno, DownloadFailureDetails downloadFailureDetails, Long l, Long l2) {
        UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent;
        if (l2 == null || isCurrentUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE, l2.longValue())) {
            Log.e(TAG, "Archive updater failed: " + str);
            this.mLastOperationStatus = errno;
            this.mGameStatus.set(GameStatus.UpdateRequired);
            setUpdateStatus(UpdateStatus.Undefined);
            UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
            if (updateAnalyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                updateAnalyticsReporter = null;
            }
            UpdateAnalyticsReporter updateAnalyticsReporter2 = updateAnalyticsReporter;
            switch (WhenMappings.$EnumSwitchMapping$3[errno.ordinal()]) {
                case 1:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.GAME_DATA_DOWNLOAD_FAILED;
                    break;
                case 2:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_STORAGE_INSUFFICIENT;
                    break;
                case 3:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_FOREGROUND_UNAVAILABLE;
                    break;
                case 4:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_RECOVERY_BLOCKED;
                    break;
                case 5:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.CHECK_AND_DOWNLOAD_REQUEST_FAILED;
                    break;
                case 6:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.GAME_DATA_VALIDATION_FAILED;
                    break;
                default:
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.GAME_DATA_VALIDATION_FAILED;
                    break;
            }
            UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter2, updateAnalyticsErrorEvent, downloadFailureDetails, this.archiveSession.snapshot().getServer(), null, 8, null);
            Message obtain = Message.obtain(this.mInHandler, 2);
            obtain.getData().putBoolean("status", false);
            obtain.getData().putSerializable("errno", this.mLastOperationStatus);
            if (l != null) {
                obtain.getData().putLong("needFreeSpaceSize", l.longValue());
            }
            obtain.replyTo = this.mMessenger;
            Intrinsics.checkNotNull(obtain);
            sendToActivity(obtain);
            stopForegroundService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatusInfoAndProgress(boolean z) {
        NotificationManagerCompat from = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT >= 26 && ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
            from.notify(1, createNotification(z));
        }
        Message obtain = Message.obtain(this.mInHandler, 4);
        Bundle data = obtain.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        populateUpdateStatusSnapshot(data, UpdateStatus.DownloadGameData, Boolean.valueOf(z));
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
    }

    static /* synthetic */ void populateUpdateStatusSnapshot$default(UpdateService updateService, Bundle bundle, UpdateStatus updateStatus, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            UpdateStatus updateStatus2 = updateService.mUpdateStatus.get();
            Intrinsics.checkNotNullExpressionValue(updateStatus2, "get(...)");
            updateStatus = updateStatus2;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        updateService.populateUpdateStatusSnapshot(bundle, updateStatus, bool);
    }

    private final void populateUpdateStatusSnapshot(Bundle bundle, UpdateStatus updateStatus, Boolean bool) {
        bundle.putString("status", updateStatus.name());
        bundle.putSerializable("errno", this.mLastOperationStatus);
        if (updateStatus != UpdateStatus.DownloadGameData) {
            return;
        }
        boolean booleanValue = bool != null ? bool.booleanValue() : isArchiveProgressIndeterminate();
        UpdateTransferProgressSnapshot snapshot = this.transferProgress.snapshot();
        long coerceIn = RangesKt.coerceIn(snapshot.getDisplayedDownloadedBytes(), 0L, RangesKt.coerceAtLeast(snapshot.getTotalBytes(), 0L));
        bundle.putBoolean(UpdateServiceContract.BundleKey.WITH_PROGRESS, !booleanValue);
        ArchiveInstallerPhase visibleArchiveInstallerPhase = visibleArchiveInstallerPhase();
        if (visibleArchiveInstallerPhase != null) {
            bundle.putString(UpdateServiceContract.BundleKey.ARCHIVE_PHASE, visibleArchiveInstallerPhase.name());
        }
        bundle.putInt(UpdateServiceContract.BundleKey.CURRENT, ((int) (coerceIn / 1024)) + 1);
        bundle.putInt(UpdateServiceContract.BundleKey.TOTAL, (int) (snapshot.getTotalBytes() / 1024));
        bundle.putLong(UpdateServiceContract.BundleKey.TOTAL_ALL, RangesKt.coerceAtLeast(snapshot.getTotalBytes() - coerceIn, 0L));
        bundle.putLong(UpdateServiceContract.BundleKey.CURRENT_LENGTH, coerceIn);
        bundle.putString(UpdateServiceContract.BundleKey.TIME_LEFT, timeLeft(snapshot));
        bundle.putString(UpdateServiceContract.BundleKey.SPEED, snapshot.getSpeedLabel());
    }

    private final ArchiveInstallerPhase visibleArchiveInstallerPhase() {
        return ArchiveProgressPresentationPolicy.INSTANCE.selectInstallerPhase(this.archiveInstallerPhase.get(), this.archiveNetworkPending.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isArchiveProgressIndeterminate() {
        return visibleArchiveInstallerPhase() != ArchiveInstallerPhase.DOWNLOADING;
    }

    private final String timeLeft() {
        return timeLeft(this.transferProgress.snapshot());
    }

    private final String timeLeft(UpdateTransferProgressSnapshot updateTransferProgressSnapshot) {
        double d;
        String str;
        if (updateTransferProgressSnapshot.getSpeedLabel().length() == 0) {
            return "Расчет времени...";
        }
        Long estimatedRemainingMillis = updateTransferProgressSnapshot.getEstimatedRemainingMillis();
        if (estimatedRemainingMillis != null) {
            double longValue = estimatedRemainingMillis.longValue();
            double d2 = (longValue / 1000.0d) % 60.0d;
            double d3 = (longValue / 60000.0d) % 60.0d;
            String str2 = (longValue / 3600000.0d) % 24.0d >= 1.0d ? ((int) d) + " h, " : "";
            String str3 = d3 >= 1.0d ? ((int) d3) + " min, " : "";
            if (d2 < 1.0d) {
                str = "";
            } else {
                str = ((int) d2) + " sec";
            }
            String str4 = str2 + str3 + str;
            return Intrinsics.areEqual(str4, "") ? "0 sec" : str4;
        }
        return "0 sec";
    }

    private final void setUpdateStatus(UpdateStatus updateStatus) {
        Log.i(TAG, "setUpdateStatus");
        if (this.mUpdateStatus.get() == updateStatus) {
            return;
        }
        this.mUpdateStatus.set(updateStatus);
        Message obtain = Message.obtain(this.mInHandler, 4);
        obtain.getData().putString("status", this.mUpdateStatus.get().name());
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendToActivity(Message message) {
        final Messenger messenger = this.mActivityMessenger;
        if (messenger == null) {
            return;
        }
        sendToRecipient(messenger, message, new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateService.sendToActivity$lambda$0(UpdateService.this, messenger);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit sendToActivity$lambda$0(UpdateService updateService, Messenger messenger) {
        if (updateService.mActivityMessenger == messenger) {
            updateService.mActivityMessenger = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void sendToRecipient$default(UpdateService updateService, Messenger messenger, Message message, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        updateService.sendToRecipient(messenger, message, function0);
    }

    private final void sendToRecipient(Messenger messenger, Message message, Function0<Unit> function0) {
        if (messenger == null) {
            return;
        }
        try {
            messenger.send(message);
        } catch (RemoteException e) {
            function0.invoke();
            Log.w(TAG, "Unable to send updater message what=" + message.what, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLauncherUpdateCheck(Messenger messenger) {
        int i = WhenMappings.$EnumSwitchMapping$4[LauncherUpdateLifecyclePolicy.INSTANCE.checkRequest(activeUpdateOperation(), hasReadyLauncherApk()).ordinal()];
        if (i == 1) {
            sendLauncherUpdateRequired(messenger);
        } else if (i == 2) {
            if (messenger != null) {
                this.mActivityMessenger = messenger;
            }
        } else if (i == 3) {
            sendLauncherUpdateRequired(messenger);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (messenger != null) {
                this.mActivityMessenger = messenger;
            }
            FileServers.INSTANCE.refreshLauncherServers();
            LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.launcherUpdateFlow;
            if (launcherUpdateServiceFlow == null) {
                Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
                launcherUpdateServiceFlow = null;
            }
            launcherUpdateServiceFlow.requestCheck();
        }
    }

    static /* synthetic */ void requestLauncherApkDownload$default(UpdateService updateService, Messenger messenger, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        updateService.requestLauncherApkDownload(messenger, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLauncherApkDownload(Messenger messenger, boolean z) {
        UpdateOperationSnapshot activeUpdateOperation = activeUpdateOperation();
        LauncherUpdateServiceFlow launcherUpdateServiceFlow = null;
        if (z) {
            if ((activeUpdateOperation != null ? activeUpdateOperation.getKind() : null) != UpdateOperationKind.LAUNCHER_APK) {
                clearReadyLauncherApk();
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$5[LauncherUpdateLifecyclePolicy.INSTANCE.apkRequest(activeUpdateOperation, hasReadyLauncherApk()).ordinal()];
        if (i == 1) {
            if (messenger != null) {
                this.mActivityMessenger = messenger;
            }
            LauncherUpdateServiceFlow launcherUpdateServiceFlow2 = this.launcherUpdateFlow;
            if (launcherUpdateServiceFlow2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
            } else {
                launcherUpdateServiceFlow = launcherUpdateServiceFlow2;
            }
            if (launcherUpdateServiceFlow.replayLatestApkProgress()) {
                return;
            }
            replayLauncherProgress();
        } else if (i == 2) {
            if (messenger != null) {
                this.mActivityMessenger = messenger;
            }
            replayReadyLauncherApk();
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            clearReadyLauncherApk();
            if (messenger != null) {
                this.mActivityMessenger = messenger;
            }
            FileServers.INSTANCE.refreshLauncherServers();
            LauncherUpdateServiceFlow launcherUpdateServiceFlow3 = this.launcherUpdateFlow;
            if (launcherUpdateServiceFlow3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
            } else {
                launcherUpdateServiceFlow = launcherUpdateServiceFlow3;
            }
            launcherUpdateServiceFlow.requestApkDownload();
        }
    }

    private final void replayLauncherProgress() {
        updateStatusInfoAndProgress(this.transferProgress.snapshot().getTotalBytes() <= 0);
    }

    private final void sendLauncherUpdateRequired(Messenger messenger) {
        Message obtain = Message.obtain(this.mInHandler, 3);
        obtain.getData().putBoolean("needUpdateMsg", true);
        obtain.getData().putSerializable("errno", Errno.NoError);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToRecipient$default(this, messenger, obtain, null, 4, null);
    }

    private final void replayReadyLauncherApk() {
        Message obtain = Message.obtain(this.mInHandler, 6);
        obtain.getData().putSerializable("errno", Errno.NoError);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        this.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                UpdateService.replayReadyLauncherApk$stopForegroundService(UpdateService.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void replayReadyLauncherApk$stopForegroundService(UpdateService updateService) {
        Intrinsics.checkNotNullParameter(updateService, "<this>");
        updateService.stopForegroundService();
    }

    private final boolean hasReadyLauncherApk() {
        boolean z = false;
        if (getLauncherReadyPreferences().getBoolean(LAUNCHER_READY_FLAG, false)) {
            long j = getLauncherReadyPreferences().getLong(LAUNCHER_READY_BYTES, -1L);
            int i = getLauncherReadyPreferences().getInt(LAUNCHER_READY_SOURCE_VERSION_CODE, -1);
            File launcherApkFile = launcherApkFile();
            if (i == 1788 && j > 0 && launcherApkFile != null && launcherApkFile.isFile() && launcherApkFile.length() == j) {
                z = true;
            }
            if (!z) {
                clearReadyLauncherApk();
            }
            return z;
        }
        return false;
    }

    private final void markReadyLauncherApk() {
        File launcherApkFile = launcherApkFile();
        long totalBytes = this.transferProgress.snapshot().getTotalBytes();
        if (totalBytes <= 0 || launcherApkFile == null || !launcherApkFile.isFile() || launcherApkFile.length() != totalBytes) {
            Log.w(TAG, "Downloaded launcher APK is unavailable for terminal replay");
            clearReadyLauncherApk();
        } else if (getLauncherReadyPreferences().edit().putBoolean(LAUNCHER_READY_FLAG, true).putLong(LAUNCHER_READY_BYTES, totalBytes).putInt(LAUNCHER_READY_SOURCE_VERSION_CODE, BuildConfig.VERSION_CODE).commit()) {
        } else {
            Log.w(TAG, "Unable to persist downloaded launcher APK for terminal replay");
        }
    }

    private final void clearReadyLauncherApk() {
        getLauncherReadyPreferences().edit().remove(LAUNCHER_READY_FLAG).remove(LAUNCHER_READY_BYTES).remove(LAUNCHER_READY_SOURCE_VERSION_CODE).commit();
    }

    private final File launcherApkFile() {
        File externalFilesDir = getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return new File(externalFilesDir, "app-arizona-release.apk");
        }
        return null;
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public Long beginLauncherCheckOperation() {
        return beginUpdateOperation(UpdateOperationKind.LAUNCHER_CHECK);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public Long beginLauncherApkOperation() {
        return beginUpdateOperation(UpdateOperationKind.LAUNCHER_APK);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public boolean isCurrentLauncherCheckOperation(long j) {
        return isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_CHECK, j);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public boolean isCurrentLauncherApkOperation(long j) {
        return isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_APK, j);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void setLauncherOperationHealthy() {
        this.mLastOperationStatus = Errno.NoError;
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void completeLauncherCheck(long j, boolean z, boolean z2) {
        if (isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_CHECK, j)) {
            this.mLastOperationStatus = z2 ? Errno.NoError : Errno.UpdateServerUnreachable;
            finishUpdateOperation(UpdateOperationKind.LAUNCHER_CHECK, j);
            Message obtain = Message.obtain(this.mInHandler, 3);
            obtain.getData().putBoolean("needUpdateMsg", z);
            obtain.getData().putSerializable("errno", this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Intrinsics.checkNotNull(obtain);
            sendToActivity(obtain);
        }
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public boolean promoteLauncherForeground() {
        ForegroundPromotionResult startForegroundService$default = startForegroundService$default(this, false, 1, null);
        if (Intrinsics.areEqual(startForegroundService$default, ForegroundPromotionResult.Ready.INSTANCE)) {
            return true;
        }
        if (!(startForegroundService$default instanceof ForegroundPromotionResult.Rejected)) {
            throw new NoWhenBranchMatchedException();
        }
        Log.w(TAG, "Launcher APK foreground promotion rejected: " + ((ForegroundPromotionResult.Rejected) startForegroundService$default).getReason());
        return false;
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public File externalFilesRoot() {
        return getExternalFilesDir(null);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void beginLauncherProgress() {
        this.transferProgress.beginLauncher();
        updateStatusInfoAndProgress(true);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void updateLauncherProgress(long j, Long l, int i, boolean z) {
        updateStatusInfoAndProgress(this.transferProgress.onLauncherProgress(new LauncherApkProgress(j, l, i, z)).getTotalBytes() <= 0);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void completeLauncherProgress(long j) {
        this.transferProgress.complete(j);
        updateStatusInfoAndProgress(false);
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void completeLauncherApk(final long j, boolean z, boolean z2, boolean z3, String str, LauncherApkLocalStorageFailure launcherApkLocalStorageFailure) {
        Errno errno;
        if (isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_APK, j)) {
            if (!z) {
                int i = launcherApkLocalStorageFailure == null ? -1 : WhenMappings.$EnumSwitchMapping$6[launcherApkLocalStorageFailure.ordinal()];
                if (i == -1) {
                    errno = Errno.UpdateServerUnreachable;
                } else if (i == 1) {
                    errno = Errno.InsufficientStorage;
                } else if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    errno = Errno.StorageUnavailable;
                }
                this.mLastOperationStatus = errno;
                clearReadyLauncherApk();
                if (z2 && str != null) {
                    FileServers.INSTANCE.currentLauncherServerIsUnreachable(str);
                }
            } else {
                this.mLastOperationStatus = Errno.NoError;
                markReadyLauncherApk();
            }
            final Function0 function0 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(UpdateService.completeLauncherApk$lambda$0(UpdateService.this, j));
                }
            };
            if (!z3) {
                if (((Boolean) function0.invoke()).booleanValue()) {
                    stopForegroundService();
                    return;
                }
                return;
            }
            this.mainHandler.postDelayed(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateService.completeLauncherApk$lambda$1(Function0.this, this);
                }
            }, LAUNCHER_RESULT_DELAY_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean completeLauncherApk$lambda$0(UpdateService updateService, long j) {
        if (updateService.isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_APK, j)) {
            updateService.finishUpdateOperation(UpdateOperationKind.LAUNCHER_APK, j);
            Message obtain = Message.obtain(updateService.mInHandler, 6);
            obtain.getData().putSerializable("errno", updateService.mLastOperationStatus);
            obtain.replyTo = updateService.mMessenger;
            Intrinsics.checkNotNull(obtain);
            updateService.sendToActivity(obtain);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void completeLauncherApk$lambda$1(Function0 function0, UpdateService updateService) {
        if (((Boolean) function0.invoke()).booleanValue()) {
            updateService.stopForegroundService();
        }
    }

    @Override // com.arizona.launcher.LauncherUpdateServiceHost
    public void recordLauncherException(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        FirebaseCrashlytics.getInstance().recordException(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFullFileCheck() {
        FileCheckServiceFlow fileCheckServiceFlow = this.fileCheckFlow;
        if (fileCheckServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileCheckFlow");
            fileCheckServiceFlow = null;
        }
        fileCheckServiceFlow.requestFullCheck();
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public Long beginFileCheckOperation() {
        return beginUpdateOperation(UpdateOperationKind.FILE_CHECK);
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public boolean isCurrentFileCheckOperation(long j) {
        return isCurrentUpdateOperation(UpdateOperationKind.FILE_CHECK, j);
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public boolean finishFileCheckOperation(long j) {
        return finishUpdateOperation(UpdateOperationKind.FILE_CHECK, j);
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public void onFileCheckAuditFailure(Exception error, ArchivePayloadAuditResult.Unavailable fallback) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Log.w(TAG, "Archive payload full check failed", error);
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public void onFileCheckRepairScheduled(ArchivePayloadAuditResult.RepairScheduled result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String joinToString$default = CollectionsKt.joinToString$default(result.getMismatchedPackageIds(), null, null, null, 0, null, null, 63, null);
        Log.w(TAG, "Archive payload audit scheduled full-ZIP repair for " + joinToString$default + " first=" + result.getFirstMismatch());
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public void markFileCheckRecoveryRequired() {
        this.archiveSession.markRecoveryRequired();
        if (isViceCityEnabled() && this.viceContentAvailable) {
            this.viceArchiveSession.markRecoveryRequired();
        }
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public void markGameUpdateRequiredAfterFileCheck() {
        this.mGameStatus.set(GameStatus.UpdateRequired);
    }

    @Override // com.arizona.launcher.FileCheckServiceHost
    public void completeFullFileCheck(boolean z) {
        Message obtain = Message.obtain(this.mInHandler, 8);
        obtain.getData().putBoolean("status", z);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/UpdateService$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateService;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/arizona/launcher/UpdateService;Landroid/os/Looper;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class IncomingHandler extends Handler {
        private final WeakReference<UpdateService> activityRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomingHandler(UpdateService ref, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(ref, "ref");
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.activityRef = new WeakReference<>(ref);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            final UpdateService updateService = this.activityRef.get();
            final Messenger messenger = msg.replyTo;
            if (updateService == null) {
                Log.d("UpdateService", "activity is null");
                return;
            }
            if (messenger != null && LauncherUpdateLifecyclePolicy.INSTANCE.mayReplaceActivityRecipient(updateService.activeUpdateOperation(), msg.what)) {
                updateService.mActivityMessenger = messenger;
            }
            Log.i("UpdateService", String.valueOf(msg.what));
            int i = msg.what;
            if (i != 0) {
                switch (i) {
                    case 2:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda6
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.updateGameData();
                            }
                        });
                        return;
                    case 3:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.requestLauncherUpdateCheck(messenger);
                            }
                        });
                        return;
                    case 4:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.IncomingHandler.handleMessage$lambda$9(UpdateService.this);
                            }
                        });
                        return;
                    case 5:
                        updateService.resetGameStatus();
                        Message obtain = Message.obtain(updateService.mInHandler, 5);
                        obtain.getData().putString("status", ((GameStatus) updateService.mGameStatus.get()).name());
                        obtain.getData().putSerializable("errno", updateService.mLastOperationStatus);
                        obtain.replyTo = updateService.mMessenger;
                        Intrinsics.checkNotNull(obtain);
                        updateService.sendToActivity(obtain);
                        return;
                    case 6:
                        final boolean z = msg.getData().getBoolean(UpdateServiceContract.BundleKey.FORCE_LAUNCHER_APK_REDOWNLOAD, false);
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.requestLauncherApkDownload(messenger, z);
                            }
                        });
                        return;
                    case 7:
                        ArchiveStorageRequirementsSnapshot combinedArchiveStorageRequirements = updateService.combinedArchiveStorageRequirements();
                        UpdateOperationSnapshot activeUpdateOperation = updateService.activeUpdateOperation();
                        UpdateOperationKind kind = activeUpdateOperation != null ? activeUpdateOperation.getKind() : null;
                        Message obtain2 = Message.obtain(updateService.mInHandler, 7);
                        obtain2.getData().putBoolean(UpdateServiceContract.BundleKey.ARCHIVE_UPDATE_ACTIVE, kind == UpdateOperationKind.ARCHIVE_UPDATE || kind == UpdateOperationKind.CHECK_AND_DOWNLOAD);
                        obtain2.getData().putLong("needFreeSpaceSize", combinedArchiveStorageRequirements.getRequiredFreeSpaceBytes());
                        obtain2.getData().putLong("needGameFreeSpaceSize", combinedArchiveStorageRequirements.getGameStorageBytes());
                        obtain2.getData().putLong("needDownloadFreeSpaceSize", combinedArchiveStorageRequirements.getDownloadStorageBytes());
                        obtain2.getData().putBoolean("archiveStorageSameDevice", !Intrinsics.areEqual((Object) UpdateService.archiveStorageUsesSingleDevice$default(updateService, null, null, 3, null), (Object) false));
                        obtain2.replyTo = updateService.mMessenger;
                        Intrinsics.checkNotNull(obtain2);
                        updateService.sendToActivity(obtain2);
                        return;
                    case 8:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.requestFullFileCheck();
                            }
                        });
                        return;
                    case 9:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.requestFullFileCheck();
                            }
                        });
                        return;
                    case 10:
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.requestCheckUpdateAndDownload(true);
                            }
                        });
                        return;
                    case 11:
                        final long j = msg.getData().getLong(UpdateServiceContract.BundleKey.REQUEST_ID, -1L);
                        final Messenger messenger2 = msg.replyTo;
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.queryViceCityContent(j, messenger2);
                            }
                        });
                        return;
                    case 12:
                        final long j2 = msg.getData().getLong(UpdateServiceContract.BundleKey.REQUEST_ID, -1L);
                        final Messenger messenger3 = msg.replyTo;
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda9
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.retainViceCityContent(j2, messenger3);
                            }
                        });
                        return;
                    case 13:
                        final long j3 = msg.getData().getLong(UpdateServiceContract.BundleKey.REQUEST_ID, -1L);
                        final Messenger messenger4 = msg.replyTo;
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.deleteViceCityContent(j3, messenger4);
                            }
                        });
                        return;
                    case 14:
                        final long j4 = msg.getData().getLong(UpdateServiceContract.BundleKey.REQUEST_ID, -1L);
                        final Messenger messenger5 = msg.replyTo;
                        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda11
                            @Override // java.lang.Runnable
                            public final void run() {
                                UpdateService.this.activateViceCityContent(j4, messenger5);
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateService.this.requestCheckUpdate();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void handleMessage$lambda$9(UpdateService updateService) {
            Message obtain = Message.obtain(updateService.mInHandler, 4);
            Bundle data = obtain.getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            UpdateService.populateUpdateStatusSnapshot$default(updateService, data, null, null, 6, null);
            obtain.replyTo = updateService.mMessenger;
            Intrinsics.checkNotNull(obtain);
            updateService.sendToActivity(obtain);
        }
    }

    static /* synthetic */ void requestCheckUpdateAndDownload$default(UpdateService updateService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        updateService.requestCheckUpdateAndDownload(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestCheckUpdateAndDownload(boolean z) {
        Log.i(TAG, "Game-data combined download flow requested");
        FileServers.INSTANCE.refreshGameServers();
        if (z) {
            FileServers.INSTANCE.restartGameServersFromPrimary();
        }
        GameUpdateServiceFlow gameUpdateServiceFlow = this.gameUpdateFlow;
        if (gameUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameUpdateFlow");
            gameUpdateServiceFlow = null;
        }
        gameUpdateServiceFlow.requestCheckAndDownload();
    }

    static /* synthetic */ void notifyCheckUpdateAndDownloadUnreachable$default(UpdateService updateService, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, UpdateMetadataHttpResult updateMetadataHttpResult, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            updateMetadataHttpResult = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        updateService.notifyCheckUpdateAndDownloadUnreachable(updateAnalyticsErrorEvent, updateMetadataHttpResult, str);
    }

    private final void notifyCheckUpdateAndDownloadUnreachable(UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, UpdateMetadataHttpResult updateMetadataHttpResult, String str) {
        UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
        UpdateAnalyticsReporter updateAnalyticsReporter2 = null;
        if (updateMetadataHttpResult != null) {
            if (updateAnalyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                updateAnalyticsReporter = null;
            }
            updateAnalyticsReporter.reportMetadataError(updateAnalyticsErrorEvent, updateMetadataHttpResult, str);
        } else {
            if (updateAnalyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            } else {
                updateAnalyticsReporter2 = updateAnalyticsReporter;
            }
            UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter2, updateAnalyticsErrorEvent, null, null, null, 14, null);
        }
        this.mLastOperationStatus = Errno.UpdateServerUnreachable;
        setUpdateStatus(UpdateStatus.Undefined);
        Message obtain = Message.obtain(this.mInHandler, 2);
        obtain.getData().putBoolean("status", false);
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        Log.w(TAG, "Send message server unreachable " + obtain);
        stopForegroundService();
    }
}

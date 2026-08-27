package com.arizona.launcher;

import android.app.ActivityManager;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
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
import androidx.media3.exoplayer.offline.DownloadService;
import com.arizona.game.BuildConfig;
import com.arizona.game.R;
import com.arizona.launcher.ArchiveForegroundPromotion;
import com.arizona.launcher.UpdateAnalyticsReporter;
import com.arizona.launcher.UpdateOperationBeginResult;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.apk.LauncherApkProgress;
import com.arizona.launcher.updater.apk.LauncherUpdateConfig;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadGuardTaggingInterceptor;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadNetworkGuardInterceptor;
import com.arizona.launcher.updater.archive.download.SafeArchiveDns;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveInstallerPhase;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMetadataFinalizationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCallbacks;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStartupGuard;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStartupInspection;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageRequirementsSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckBlockCode;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateTransactionLock;
import com.arizona.launcher.updater.archive.planner.ArchivePlanReason;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditor;
import com.arizona.launcher.updater.http.UpdateMetadataFetcher;
import com.arizona.launcher.util.FileServers;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000²\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 ý\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\fý\u0001þ\u0001ÿ\u0001\u0080\u0002\u0081\u0002\u0082\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ.\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020K2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020PH\u0002J\u0017\u0010Q\u001a\u0004\u0018\u00010C2\u0006\u0010J\u001a\u00020KH\u0002¢\u0006\u0002\u0010RJ\u0018\u0010S\u001a\u00020&2\u0006\u0010J\u001a\u00020K2\u0006\u0010T\u001a\u00020CH\u0002J\u0018\u0010U\u001a\u00020:2\u0006\u0010J\u001a\u00020K2\u0006\u0010T\u001a\u00020CH\u0002J\b\u0010V\u001a\u00020:H\u0002J\"\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020XH\u0016J\u0012\u0010]\u001a\u00020^2\b\b\u0002\u0010_\u001a\u00020&H\u0002J\b\u0010`\u001a\u00020&H\u0002J\b\u0010a\u001a\u00020&H\u0002J\n\u0010b\u001a\u0004\u0018\u00010cH\u0002J\b\u0010d\u001a\u00020&H\u0002J\u0010\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020&H\u0002J\b\u0010h\u001a\u00020:H\u0002J\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010k\u001a\u00020&2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010l\u001a\u00020:2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010m\u001a\u00020:H\u0016J\u0012\u0010n\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010p\u001a\u00020:H\u0002J\b\u0010q\u001a\u00020:H\u0002J\u0017\u0010r\u001a\u0004\u0018\u00010C2\u0006\u0010s\u001a\u00020&H\u0016¢\u0006\u0002\u0010tJ\u0018\u0010u\u001a\u00020&2\u0006\u0010s\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\u0018\u0010v\u001a\u00020:2\u0006\u0010s\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\u0010\u0010w\u001a\u00020:2\u0006\u0010s\u001a\u00020&H\u0016J\u0018\u0010x\u001a\u00020:2\u0006\u0010s\u001a\u00020&2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010y\u001a\u00020:2\u0006\u0010I\u001a\u00020H2\u0006\u0010z\u001a\u00020HH\u0016J\u0010\u0010{\u001a\u00020:2\u0006\u0010s\u001a\u00020&H\u0016J\u0018\u0010|\u001a\u00020:2\u0006\u0010s\u001a\u00020&2\u0006\u0010}\u001a\u00020HH\u0016J\u0018\u0010~\u001a\u00020:2\u0006\u0010s\u001a\u00020&2\u0006\u0010\u007f\u001a\u00020&H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020K2\u0006\u0010s\u001a\u00020&H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020:2\u0007\u0010\u0082\u0001\u001a\u00020&H\u0002J3\u0010\u0083\u0001\u001a\u00020:2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020&2\t\b\u0002\u0010\u0087\u0001\u001a\u00020&2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010HH\u0002J\t\u0010\u0088\u0001\u001a\u00020&H\u0002J\t\u0010\u0089\u0001\u001a\u00020:H\u0002J\u0007\u0010\u008a\u0001\u001a\u00020:J\t\u0010\u008b\u0001\u001a\u00020&H\u0016J\f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0003\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\u0011\u0010\u0091\u0001\u001a\u00020:2\u0006\u0010T\u001a\u00020CH\u0016J\u001d\u0010\u0092\u0001\u001a\u00020:2\u0007\u0010\u0093\u0001\u001a\u00020&2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010KH\u0016J\t\u0010\u0095\u0001\u001a\u00020:H\u0016J\u001b\u0010\u0096\u0001\u001a\u00020:2\u0007\u0010\u0097\u0001\u001a\u00020H2\u0007\u0010\u0098\u0001\u001a\u00020&H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020:2\u0007\u0010\u009a\u0001\u001a\u00020HH\u0016J\t\u0010\u009b\u0001\u001a\u00020:H\u0016J\t\u0010\u009c\u0001\u001a\u00020:H\u0016J\u0013\u0010\u009d\u0001\u001a\u00020&2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\u001b\u0010¢\u0001\u001a\u00020:2\u0007\u0010£\u0001\u001a\u00020C2\u0007\u0010¤\u0001\u001a\u00020&H\u0016J\f\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0016J\u0012\u0010§\u0001\u001a\u00030¨\u00012\u0006\u0010B\u001a\u00020CH\u0016J\u001d\u0010©\u0001\u001a\u00030ª\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0096@¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010®\u0001\u001a\u00020:2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0018\u0010¯\u0001\u001a\u00020:2\r\u0010\u0084\u0001\u001a\b0°\u0001j\u0003`±\u0001H\u0016J\u0018\u0010²\u0001\u001a\u00020:2\r\u0010\u0084\u0001\u001a\b0°\u0001j\u0003`±\u0001H\u0016J\t\u0010³\u0001\u001a\u00020:H\u0016J\u0013\u0010´\u0001\u001a\u00020:2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0016J-\u0010·\u0001\u001a\u0004\u0018\u00010&2\f\b\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u00012\f\b\u0002\u0010º\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0002¢\u0006\u0003\u0010»\u0001J\u0012\u0010¼\u0001\u001a\u00030¨\u00012\u0006\u0010B\u001a\u00020CH\u0002JI\u0010½\u0001\u001a\u00020:2\u0006\u0010}\u001a\u00020H2\t\b\u0002\u0010¾\u0001\u001a\u00020\u001f2\f\b\u0002\u0010¿\u0001\u001a\u0005\u0018\u00010À\u00012\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0003\u0010Â\u0001J\u0011\u0010Ã\u0001\u001a\u00020:2\u0006\u0010g\u001a\u00020&H\u0002J1\u0010Ä\u0001\u001a\u00020:2\b\u0010Å\u0001\u001a\u00030Æ\u00012\t\b\u0002\u0010Ç\u0001\u001a\u00020\n2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0003\u0010É\u0001J\u000b\u0010Ê\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010Ë\u0001\u001a\u00020&H\u0002J\t\u0010Ì\u0001\u001a\u00020HH\u0002J\u0013\u0010Ì\u0001\u001a\u00020H2\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0002J\u0012\u0010Ï\u0001\u001a\u00020:2\u0007\u0010Ç\u0001\u001a\u00020\nH\u0002J\u0013\u0010Ð\u0001\u001a\u00020:2\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0002J\t\u0010Ó\u0001\u001a\u00020:H\u0002J\t\u0010Ô\u0001\u001a\u00020:H\u0002J\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0003\u0010\u008f\u0001J\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0003\u0010\u008f\u0001J\u0011\u0010×\u0001\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\u0011\u0010Ø\u0001\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\t\u0010Ù\u0001\u001a\u00020:H\u0016J#\u0010Ú\u0001\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0007\u0010Û\u0001\u001a\u00020&2\u0007\u0010Ü\u0001\u001a\u00020&H\u0016J\t\u0010Ý\u0001\u001a\u00020&H\u0016J\f\u0010Þ\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\t\u0010ß\u0001\u001a\u00020:H\u0016J5\u0010à\u0001\u001a\u00020:2\u0007\u0010á\u0001\u001a\u00020C2\t\u0010â\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010ã\u0001\u001a\u00020X2\u0007\u0010ä\u0001\u001a\u00020&H\u0016¢\u0006\u0003\u0010å\u0001J\u0012\u0010æ\u0001\u001a\u00020:2\u0007\u0010â\u0001\u001a\u00020CH\u0016J7\u0010ç\u0001\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0007\u0010Ü\u0001\u001a\u00020&2\u0007\u0010è\u0001\u001a\u00020&2\u0007\u0010é\u0001\u001a\u00020&2\t\u0010ê\u0001\u001a\u0004\u0018\u00010HH\u0016J\u0013\u0010ë\u0001\u001a\u00020:2\b\u0010\u0084\u0001\u001a\u00030ì\u0001H\u0016J\t\u0010í\u0001\u001a\u00020:H\u0002J\u0011\u0010î\u0001\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0003\u0010\u008f\u0001J\u0011\u0010ï\u0001\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\u0011\u0010ð\u0001\u001a\u00020&2\u0006\u0010T\u001a\u00020CH\u0016J\"\u0010ñ\u0001\u001a\u00020:2\r\u0010\u0084\u0001\u001a\b0°\u0001j\u0003`±\u00012\b\u0010ò\u0001\u001a\u00030ó\u0001H\u0016J\u0013\u0010ô\u0001\u001a\u00020:2\b\u0010õ\u0001\u001a\u00030ö\u0001H\u0016J\t\u0010÷\u0001\u001a\u00020:H\u0016J\t\u0010ø\u0001\u001a\u00020:H\u0016J\u0012\u0010ù\u0001\u001a\u00020:2\u0007\u0010Ç\u0001\u001a\u00020&H\u0016J\u0014\u0010ú\u0001\u001a\u00020:2\t\b\u0002\u0010û\u0001\u001a\u00020&H\u0002J\u0013\u0010ü\u0001\u001a\u00020:2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000Ê\u0001\u0003\b\u0084\u0002Ê\u0001\u000e\b\u0085\u0002\u0012\t\b\u0086\u0002\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0083\u0002"}, d2 = {"Lcom/arizona/launcher/UpdateService;", "Landroid/app/Service;", "Lcom/arizona/launcher/LauncherUpdateServiceHost;", "Lcom/arizona/launcher/GameUpdateServiceHost;", "Lcom/arizona/launcher/ArchiveUpdateServiceHost;", "Lcom/arizona/launcher/FileCheckServiceHost;", "<init>", "()V", "mUpdateStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/arizona/launcher/UpdateService$UpdateStatus;", "mGameStatus", "Lcom/arizona/launcher/UpdateService$GameStatus;", "mMessenger", "Landroid/os/Messenger;", "mActivityMessenger", "mInHandler", "Lcom/arizona/launcher/UpdateService$IncomingHandler;", "serviceHandlerThread", "Landroid/os/HandlerThread;", "archiveSession", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "archiveStorageSpaceChecker", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker;", "transferProgress", "Lcom/arizona/launcher/UpdateTransferProgress;", "archiveInstallerPhase", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "archiveNetworkPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLastOperationStatus", "Lcom/arizona/launcher/UpdateService$Errno;", "mainHandler", "Landroid/os/Handler;", "serviceAlive", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "foregroundServiceActive", "", "updateOperationCoordinator", "Lcom/arizona/launcher/UpdateOperationCoordinator;", "analyticsReporter", "Lcom/arizona/launcher/UpdateAnalyticsReporter;", "metadataFetcher", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "gameUpdateFlow", "Lcom/arizona/launcher/GameUpdateServiceFlow;", "archiveUpdateFlow", "Lcom/arizona/launcher/ArchiveUpdateServiceFlow;", "fileCheckFlow", "Lcom/arizona/launcher/FileCheckServiceFlow;", "launcherUpdateFlow", "Lcom/arizona/launcher/LauncherUpdateServiceFlow;", "archiveStateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "archiveStateMaintenance", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStateMaintenance;", "onCreate", "", "isGameDownloadRetryEnabled", "detectArchiveStartupGuard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "selectedArchiveGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "runPrimaryGameCheckPreflight", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "operationToken", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareGameUpdateCheck", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "server", "kind", "Lcom/arizona/launcher/UpdateOperationKind;", "(Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/UpdateOperationKind;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreparedGameUpdateCheck", "decision", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "beginUpdateOperation", "(Lcom/arizona/launcher/UpdateOperationKind;)Ljava/lang/Long;", "isCurrentUpdateOperation", "token", "finishUpdateOperation", "createNotificationChannel", "onStartCommand", "", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", DownloaderServiceMarshaller.PARAMS_FLAGS, "startId", "startForegroundService", "Lcom/arizona/launcher/UpdateService$ForegroundPromotionResult;", "allowAcceptedStartFromBackground", "isDeviceOnline", "isDeviceNetworkValidated", "activeNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "isAppInForeground", "createNotification", "Landroid/app/Notification;", "indeterminate", "stopForegroundService", "onBind", "Landroid/os/IBinder;", "onUnbind", "onRebind", "onDestroy", "onTaskRemoved", "rootIntent", "releaseServiceResources", "requestCheckUpdate", "beginGameCheckOperation", "combined", "(Z)Ljava/lang/Long;", "isCurrentGameCheckOperation", "finishGameCheckOperation", "onGameCheckStarted", "onGameMetadataLoaded", "onGameCheckMirrorRetry", "source", "completeGameCheckServerEmpty", "completeGameCheckMetadataFailed", "detail", "completePreparedGameCheck", "successfully", "gameCheckOperationKind", "notifyGameUpdateCheckCompleted", "preparedSuccessfully", "notifyGameUpdateCheckUnreachable", "error", "Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "includeStatus", "resetUpdateStatus", UpdateServiceContract.BundleKey.IS_GAME_DATA_UPDATE_EXISTS, "resetGameStatus", "updateGameData", "isArchiveServiceAlive", "activeUpdateOperation", "Lcom/arizona/launcher/UpdateOperationSnapshot;", "beginArchiveOperation", "()Ljava/lang/Long;", "isCurrentArchiveOperation", "finishArchiveOperation", "onArchiveRequestCoalesced", "activeDownload", "activeOperationKind", "onArchiveStartupCorrupt", "requestArchiveManifestRefresh", "reason", "warning", "setArchiveBenchmarkMode", UpdateActivity.UPDATE_MODE, "onArchiveDownloadSelected", "onArchiveNoWork", "hasEnoughSpaceForArchive", DownloadService.KEY_REQUIREMENTS, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirementsSnapshot;", "promoteArchiveForeground", "Lcom/arizona/launcher/ArchiveForegroundPromotion;", "beginArchiveProgress", "downloadBytes", "finalizationOnly", "createArchivePackageUpdater", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater;", "createArchiveMirrorCoordinator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator;", "finalizeArchiveMetadata", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expandArchiveRuntimeRequirements", "recordArchiveExecutionException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "recordArchiveFinalizationException", "completeArchiveSuccess", "completeArchiveFailure", "failure", "Lcom/arizona/launcher/ArchiveServiceFailure;", "archiveStorageUsesSingleDevice", "gameRoot", "Ljava/io/File;", "downloadStorageRoot", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/Boolean;", "archiveMirrorExecutionCoordinator", "notifyArchiveUpdateFailure", "errno", "failureDetails", "Lcom/arizona/launcher/DownloadFailureDetails;", "requiredFreeSpaceBytes", "(Ljava/lang/String;Lcom/arizona/launcher/UpdateService$Errno;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)V", "updateStatusInfoAndProgress", "populateUpdateStatusSnapshot", "bundle", "Landroid/os/Bundle;", "status", "archiveIndeterminate", "(Landroid/os/Bundle;Lcom/arizona/launcher/UpdateService$UpdateStatus;Ljava/lang/Boolean;)V", "visibleArchiveInstallerPhase", "isArchiveProgressIndeterminate", UpdateServiceContract.BundleKey.TIME_LEFT, "progress", "Lcom/arizona/launcher/UpdateTransferProgressSnapshot;", "setUpdateStatus", "sendToActivity", "message", "Landroid/os/Message;", "requestLauncherUpdateCheck", "requestLauncherApkDownload", "beginLauncherCheckOperation", "beginLauncherApkOperation", "isCurrentLauncherCheckOperation", "isCurrentLauncherApkOperation", "setLauncherOperationHealthy", "completeLauncherCheck", "needsUpdate", FirebaseAnalytics.Param.SUCCESS, "promoteLauncherForeground", "externalFilesRoot", "beginLauncherProgress", "updateLauncherProgress", "downloadedBytes", "totalBytes", "attempt", "resumed", "(JLjava/lang/Long;IZ)V", "completeLauncherProgress", "completeLauncherApk", "markServerUnreachable", "deferResult", "failedServer", "recordLauncherException", "", "requestFullFileCheck", "beginFileCheckOperation", "isCurrentFileCheckOperation", "finishFileCheckOperation", "onFileCheckAuditFailure", "fallback", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Unavailable;", "onFileCheckRepairScheduled", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$RepairScheduled;", "markFileCheckRecoveryRequired", "markGameUpdateRequiredAfterFileCheck", "completeFullFileCheck", "requestCheckUpdateAndDownload", "restartMirrorCycle", "notifyCheckUpdateAndDownloadUnreachable", "Companion", "Errno", "UpdateStatus", "GameStatus", "ForegroundPromotionResult", "IncomingHandler", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateService extends Hilt_UpdateService implements LauncherUpdateServiceHost, GameUpdateServiceHost, ArchiveUpdateServiceHost, FileCheckServiceHost {
    public static final String ACTION_START_FOREGROUND_SERVICE = "Start foreground";
    public static final String ACTION_STOP_FOREGROUND_SERVICE = "Stop foreground";
    public static final String ARCHIVE_STORAGE_SAME_DEVICE_MSG = "archiveStorageSameDevice";
    private static final int BYTE_TO_KILOBYTE_DIVIDER = 1024;
    public static final int CHECK_AND_UPDATE = 10;
    public static final int CHECK_LAUNCHER_UPDATE = 3;
    public static final int CHECK_STATE_ERROR = 9;
    public static final int CHECK_UPDATE = 0;
    public static final String ERRNO_MSG = "errno";
    private static final int FOREGROUND_NOTIFICATION_ID = 1;
    public static final int FULL_CHECK = 8;
    public static final int GAME_STATUS = 5;
    private static final long LAUNCHER_RESULT_DELAY_MS = 3750;
    public static final String NEED_DOWNLOAD_FREE_SPACE_SIZE_MSG = "needDownloadFreeSpaceSize";
    public static final String NEED_FREE_SPACE_SIZE_MSG = "needFreeSpaceSize";
    public static final String NEED_GAME_FREE_SPACE_SIZE_MSG = "needGameFreeSpaceSize";
    public static final String NEED_UPDATE_MSG = "needUpdateMsg";
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
    private FileCheckServiceFlow fileCheckFlow;
    private volatile boolean foregroundServiceActive;
    private GameUpdateServiceFlow gameUpdateFlow;
    private LauncherUpdateServiceFlow launcherUpdateFlow;
    private volatile Messenger mActivityMessenger;
    private IncomingHandler mInHandler;
    private Messenger mMessenger;
    private UpdateMetadataFetcher metadataFetcher;
    private HandlerThread serviceHandlerThread;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private AtomicReference<UpdateStatus> mUpdateStatus = new AtomicReference<>(UpdateStatus.Undefined);
    private AtomicReference<GameStatus> mGameStatus = new AtomicReference<>(GameStatus.Undefined);
    private final ArchiveUpdateSessionState archiveSession = new ArchiveUpdateSessionState(null, null, 3, null);
    private final ArchiveStorageSpaceChecker archiveStorageSpaceChecker = ArchiveStorageSpaceChecker.Companion.android(new Function2() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return UpdateService.archiveStorageSpaceChecker$lambda$0((String) obj, (Exception) obj2);
        }
    });
    private final UpdateTransferProgress transferProgress = new UpdateTransferProgress(null, 1, null);
    private final AtomicReference<ArchiveInstallerPhase> archiveInstallerPhase = new AtomicReference<>(null);
    private final AtomicBoolean archiveNetworkPending = new AtomicBoolean(false);
    private volatile Errno mLastOperationStatus = Errno.NoError;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean serviceAlive = new AtomicBoolean(false);
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    private final UpdateOperationCoordinator updateOperationCoordinator = new UpdateOperationCoordinator(0, 1, null);

    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ArchiveInstallerPhase.values().length];
            try {
                iArr[ArchiveInstallerPhase.WAITING_FOR_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveInstallerPhase.VERIFYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveInstallerPhase.EXTRACTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveInstallerPhase.COMMITTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveInstallerPhase.RETIRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArchiveInstallerPhase.DOWNLOADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArchiveServiceFailureKind.values().length];
            try {
                iArr2[ArchiveServiceFailureKind.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ArchiveServiceFailureKind.CORRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ArchiveServiceFailureKind.INSUFFICIENT_STORAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ArchiveServiceFailureKind.FOREGROUND_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ArchiveServiceFailureKind.RECOVERY_BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Errno.values().length];
            try {
                iArr3[Errno.ConnectionRefused.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[Errno.InsufficientStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[Errno.ForegroundServiceUnavailable.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[Errno.ArchiveRecoveryBlocked.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isGameDownloadRetryEnabled() {
        return true;
    }

    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\"2\b\u0010(\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010)J\b\u0010*\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/arizona/launcher/UpdateService$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_START_FOREGROUND_SERVICE", "ACTION_STOP_FOREGROUND_SERVICE", "CHECK_UPDATE", "", "UPDATE_GAME_DATA", "CHECK_LAUNCHER_UPDATE", "UPDATE_STATUS", "GAME_STATUS", "UPDATE_LAUNCHER", "UPDATE_INFO", "FULL_CHECK", "CHECK_STATE_ERROR", "CHECK_AND_UPDATE", "BYTE_TO_KILOBYTE_DIVIDER", "LAUNCHER_RESULT_DELAY_MS", "", "NEED_UPDATE_MSG", "ERRNO_MSG", "NEED_FREE_SPACE_SIZE_MSG", "NEED_GAME_FREE_SPACE_SIZE_MSG", "NEED_DOWNLOAD_FREE_SPACE_SIZE_MSG", "ARCHIVE_STORAGE_SAME_DEVICE_MSG", "UPDATE_SERVICE_CHANNEL_ID", "FOREGROUND_NOTIFICATION_ID", "RETRY_FLAG_ARIZONA", "RETRY_FLAG_RODINA", "RETRY_FLAG_BRAZIL", "benchmarkRetryEnabledOverride", "", "Ljava/lang/Boolean;", "benchmarkObservedDownloadMode", "setBenchmarkDownloadModesForTests", "", "retryEnabled", "archiveEnabled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBenchmarkObservedDownloadModeForTests", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/UpdateService$Errno;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "NoError", "UpdateServerUnreachable", "ConnectionRefused", "CorruptedFilesFound", "InsufficientStorage", "ForegroundServiceUnavailable", "ArchiveRecoveryBlocked", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        private static final /* synthetic */ Errno[] $values() {
            return new Errno[]{NoError, UpdateServerUnreachable, ConnectionRefused, CorruptedFilesFound, InsufficientStorage, ForegroundServiceUnavailable, ArchiveRecoveryBlocked};
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

    @Override // com.arizona.launcher.Hilt_UpdateService, android.app.Service
    public void onCreate() {
        DurableArchiveStateStore durableArchiveStateStore;
        UpdateMetadataFetcher updateMetadataFetcher;
        UpdateAnalyticsReporter updateAnalyticsReporter;
        super.onCreate();
        this.serviceAlive.set(true);
        this.analyticsReporter = UpdateAnalyticsReporter.Companion.createAndroid$default(UpdateAnalyticsReporter.Companion, this, null, 2, null);
        this.archiveStateStore = DurableArchiveStateStore.Companion.forAndroid(new File(getNoBackupFilesDir(), "archive-updater"));
        Function0 function0 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                File externalFilesDir;
                externalFilesDir = UpdateService.this.getExternalFilesDir(null);
                return externalFilesDir;
            }
        };
        DurableArchiveStateStore durableArchiveStateStore2 = this.archiveStateStore;
        if (durableArchiveStateStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore = null;
        } else {
            durableArchiveStateStore = durableArchiveStateStore2;
        }
        this.archiveStateMaintenance = new ArchiveStateMaintenance(function0, durableArchiveStateStore, ArchiveInstalledPayloadAuditor.Companion.forAndroid(), null, 8, null);
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true).connectionPool(new ConnectionPool(5, 10L, TimeUnit.SECONDS)).dns(new SafeArchiveDns(Dns.SYSTEM, false)).addInterceptor(new ArchiveDownloadGuardTaggingInterceptor()).addNetworkInterceptor(new ArchiveDownloadNetworkGuardInterceptor(false)).build();
        this.metadataFetcher = UpdateMetadataFetcher.Companion.create(build);
        UpdateMetadataFetcher updateMetadataFetcher2 = this.metadataFetcher;
        if (updateMetadataFetcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataFetcher");
            updateMetadataFetcher2 = null;
        }
        this.gameUpdateFlow = new GameUpdateServiceFlow(this.serviceScope, new GameUpdateCheckRunner(updateMetadataFetcher2, new UpdateService$onCreate$gameUpdateCheckRunner$1(this), new UpdateService$onCreate$gameUpdateCheckRunner$2(this), new UpdateService$onCreate$gameUpdateCheckRunner$3(FileServers.INSTANCE), new UpdateService$onCreate$gameUpdateCheckRunner$4(FileServers.INSTANCE)), this.archiveSession, this, new UpdateService$onCreate$2(FileServers.INSTANCE), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(UpdateService.onCreate$lambda$1());
            }
        }, new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String jsonName;
                jsonName = UpdateJsonProvider.INSTANCE.getJsonName(UpdateService.this);
                return jsonName;
            }
        }, new UpdateService$onCreate$5(this), new UpdateService$onCreate$6(this), new UpdateService$onCreate$7(this));
        this.archiveUpdateFlow = new ArchiveUpdateServiceFlow(this.serviceScope, this.archiveSession, this, null, 8, null);
        CoroutineScope coroutineScope = this.serviceScope;
        UpdateService updateService = this;
        ArchiveStateMaintenance archiveStateMaintenance = this.archiveStateMaintenance;
        if (archiveStateMaintenance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
            archiveStateMaintenance = null;
        }
        this.fileCheckFlow = new FileCheckServiceFlow(coroutineScope, updateService, new UpdateService$onCreate$8(archiveStateMaintenance), null, 8, null);
        LauncherApkDownloader launcherApkDownloader = new LauncherApkDownloader(build, null, null, null, false, 0, 0L, 0L, null, null, 1006, null);
        CoroutineScope coroutineScope2 = this.serviceScope;
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
        this.launcherUpdateFlow = new LauncherUpdateServiceFlow(coroutineScope2, updateMetadataFetcher, launcherApkDownloader, launcherUpdateConfig, updateAnalyticsReporter, this, new UpdateService$onCreate$9(FileServers.INSTANCE), new UpdateService$onCreate$10(FileServers.INSTANCE), new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdateService.onCreate$lambda$3(UpdateService.this, (Function0) obj);
            }
        });
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.serviceHandlerThread = handlerThread;
        createNotificationChannel();
        this.archiveSession.initializeStartupGuard(detectArchiveStartupGuard());
        resetGameStatus();
        HandlerThread handlerThread2 = this.serviceHandlerThread;
        if (handlerThread2 != null) {
            Looper looper = handlerThread2.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            this.mInHandler = new IncomingHandler(this, looper);
            this.mMessenger = new Messenger(this.mInHandler);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int onCreate$lambda$1() {
        return FileServers.INSTANCE.getGame_servers().length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$3(UpdateService updateService, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    private final ArchiveStartupGuard detectArchiveStartupGuard() {
        try {
            ArchiveStateMaintenance archiveStateMaintenance = this.archiveStateMaintenance;
            if (archiveStateMaintenance == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                archiveStateMaintenance = null;
            }
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: all -> 0x003a, Exception -> 0x003d, CancellationException -> 0x0040, TryCatch #4 {all -> 0x003a, blocks: (B:12:0x0036, B:33:0x0073, B:35:0x007d, B:36:0x0080, B:38:0x0084, B:39:0x00b0, B:41:0x00b4, B:44:0x00e4, B:45:0x00e9, B:50:0x00ef, B:55:0x0127), top: B:58:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[Catch: all -> 0x003a, Exception -> 0x003d, CancellationException -> 0x0040, TryCatch #4 {all -> 0x003a, blocks: (B:12:0x0036, B:33:0x0073, B:35:0x007d, B:36:0x0080, B:38:0x0084, B:39:0x00b0, B:41:0x00b4, B:44:0x00e4, B:45:0x00e9, B:50:0x00ef, B:55:0x0127), top: B:58:0x002e }] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runPrimaryGameCheckPreflight(long j, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        UpdateService$runPrimaryGameCheckPreflight$1 updateService$runPrimaryGameCheckPreflight$1;
        int i;
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
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        try {
                            ArchiveStateMaintenance archiveStateMaintenance = this.archiveStateMaintenance;
                            if (archiveStateMaintenance == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                                archiveStateMaintenance = null;
                            }
                            updateService$runPrimaryGameCheckPreflight$1.J$0 = j;
                            updateService$runPrimaryGameCheckPreflight$1.J$1 = elapsedRealtime;
                            updateService$runPrimaryGameCheckPreflight$1.label = 1;
                            obj = archiveStateMaintenance.auditMetadataAndPrepareRepair(updateService$runPrimaryGameCheckPreflight$1);
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepareGameUpdateCheck(String str, String str2, UpdateOperationKind updateOperationKind, long j, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        UpdateService$prepareGameUpdateCheck$1 updateService$prepareGameUpdateCheck$1;
        int i;
        try {
            if (continuation instanceof UpdateService$prepareGameUpdateCheck$1) {
                updateService$prepareGameUpdateCheck$1 = (UpdateService$prepareGameUpdateCheck$1) continuation;
                if ((updateService$prepareGameUpdateCheck$1.label & Integer.MIN_VALUE) != 0) {
                    updateService$prepareGameUpdateCheck$1.label -= Integer.MIN_VALUE;
                    Object obj = updateService$prepareGameUpdateCheck$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = updateService$prepareGameUpdateCheck$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        updateService$prepareGameUpdateCheck$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        updateService$prepareGameUpdateCheck$1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        updateService$prepareGameUpdateCheck$1.L$2 = SpillingKt.nullOutSpilledVariable(updateOperationKind);
                        updateService$prepareGameUpdateCheck$1.J$0 = j;
                        updateService$prepareGameUpdateCheck$1.label = 1;
                        obj = ArchiveUpdateTransactionLock.INSTANCE.withLock(new UpdateService$prepareGameUpdateCheck$decision$1(this, str, str2, updateOperationKind, j, null), updateService$prepareGameUpdateCheck$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        long j2 = updateService$prepareGameUpdateCheck$1.J$0;
                        UpdateOperationKind updateOperationKind2 = (UpdateOperationKind) updateService$prepareGameUpdateCheck$1.L$2;
                        String str3 = (String) updateService$prepareGameUpdateCheck$1.L$1;
                        String str4 = (String) updateService$prepareGameUpdateCheck$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return (ArchiveUpdateCheckDecision) obj;
                }
            }
            if (i != 0) {
            }
            return (ArchiveUpdateCheckDecision) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            Log.e(TAG, "Archive update check failed", e2);
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e2.getMessage());
        }
        updateService$prepareGameUpdateCheck$1 = new UpdateService$prepareGameUpdateCheck$1(this, continuation);
        Object obj2 = updateService$prepareGameUpdateCheck$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$prepareGameUpdateCheck$1.label;
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
            this.mLastOperationStatus = Errno.ArchiveRecoveryBlocked;
            ArchiveUpdateCheckDecision.Block block = (ArchiveUpdateCheckDecision.Block) archiveUpdateCheckDecision;
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
        if (!this.serviceAlive.get()) {
            Log.i(TAG, "Ignore " + updateOperationKind + " after service destruction");
            return null;
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

    private final void finishUpdateOperation(UpdateOperationKind updateOperationKind, long j) {
        this.updateOperationCoordinator.finish(updateOperationKind, j);
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
        switch (visibleArchiveInstallerPhase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[visibleArchiveInstallerPhase.ordinal()]) {
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
    public final void requestCheckUpdate() {
        FileServers.INSTANCE.refreshGameServers();
        GameUpdateServiceFlow gameUpdateServiceFlow = this.gameUpdateFlow;
        if (gameUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameUpdateFlow");
            gameUpdateServiceFlow = null;
        }
        gameUpdateServiceFlow.requestCheck();
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
        startForegroundService$default(this, false, 1, null);
        setUpdateStatus(UpdateStatus.CheckUpdate);
        this.mLastOperationStatus = Errno.NoError;
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void onGameMetadataLoaded(boolean z, String response) {
        Intrinsics.checkNotNullParameter(response, "response");
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
            notifyCheckUpdateAndDownloadUnreachable(UpdateAnalyticsErrorEvent.CHECK_AND_DOWNLOAD_SERVER_EMPTY);
        } else {
            notifyGameUpdateCheckUnreachable$default(this, UpdateAnalyticsErrorEvent.GAME_UPDATE_SERVER_EMPTY, false, false, null, 8, null);
        }
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void completeGameCheckMetadataFailed(boolean z, String detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Log.w(TAG, "Game metadata request failed: " + detail);
        if (z) {
            notifyCheckUpdateAndDownloadUnreachable(UpdateAnalyticsErrorEvent.CHECK_AND_DOWNLOAD_REQUEST_FAILED);
        } else {
            notifyGameUpdateCheckUnreachable$default(this, UpdateAnalyticsErrorEvent.GAME_UPDATE_REQUEST_FAILED, true, false, detail, 4, null);
        }
    }

    @Override // com.arizona.launcher.GameUpdateServiceHost
    public void completePreparedGameCheck(boolean z, boolean z2) {
        if (!z) {
            notifyGameUpdateCheckCompleted(z2);
        } else if (z2) {
            updateGameData();
        } else {
            notifyArchiveUpdateFailure$default(this, "archive update check is blocked", this.mLastOperationStatus, null, null, null, 28, null);
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
        obtain.getData().putLong(UpdateServiceContract.BundleKey.TOTAL_SIZE, this.archiveSession.snapshot().getStorageRequirements().getDownloadBytes());
        obtain.getData().putSerializable("errno", this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Intrinsics.checkNotNull(obtain);
        sendToActivity(obtain);
        Log.i(TAG, "Send message check update " + obtain);
        stopForegroundService();
    }

    static /* synthetic */ void notifyGameUpdateCheckUnreachable$default(UpdateService updateService, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        updateService.notifyGameUpdateCheckUnreachable(updateAnalyticsErrorEvent, z, z2, str);
    }

    private final void notifyGameUpdateCheckUnreachable(UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, boolean z, boolean z2, String str) {
        UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
        if (updateAnalyticsReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            updateAnalyticsReporter = null;
        }
        UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter, updateAnalyticsErrorEvent, null, null, 6, null);
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
        return this.archiveSession.snapshot().getHasPendingWork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGameStatus() {
        Log.i(TAG, "resetGameStatus");
        this.mGameStatus.set(isGameDataUpdateExists() ? GameStatus.UpdateRequired : GameStatus.Updated);
        Log.d(TAG, "Installed game status: " + this.mGameStatus.get());
    }

    public final void updateGameData() {
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow = this.archiveUpdateFlow;
        if (archiveUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveUpdateFlow");
            archiveUpdateServiceFlow = null;
        }
        archiveUpdateServiceFlow.requestDownload();
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
        finishUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE, j);
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
    public boolean hasEnoughSpaceForArchive(ArchiveStorageRequirementsSnapshot requirements) {
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        return this.archiveStorageSpaceChecker.hasEnoughSpace(getExternalFilesDir(null), getExternalCacheDir(), requirements);
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
        this.transferProgress.beginArchive(j);
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
        return ArchivePackageUpdater.Companion.create(this, isGameDownloadRetryEnabled());
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public ArchiveMirrorExecutionCoordinator createArchiveMirrorCoordinator(long j) {
        return archiveMirrorExecutionCoordinator(j);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public Object finalizeArchiveMetadata(ArchiveManifest archiveManifest, Continuation<? super ArchiveMetadataFinalizationResult> continuation) {
        Log.i(TAG, "Archive payload committed; reconciling archive entry metadata");
        ArchiveStateMaintenance archiveStateMaintenance = this.archiveStateMaintenance;
        if (archiveStateMaintenance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
            archiveStateMaintenance = null;
        }
        return archiveStateMaintenance.finalizePublishedMetadata(archiveManifest, continuation);
    }

    @Override // com.arizona.launcher.ArchiveUpdateServiceHost
    public void expandArchiveRuntimeRequirements(ArchiveStorageRequirementsSnapshot requirements) {
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        UpdateTransferProgressSnapshot expandTotalBytes = this.transferProgress.expandTotalBytes(requirements.getDownloadBytes());
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
        int i = WhenMappings.$EnumSwitchMapping$1[failure.getKind().ordinal()];
        if (i == 1) {
            errno = Errno.ConnectionRefused;
        } else if (i == 2) {
            errno = Errno.CorruptedFilesFound;
        } else if (i == 3) {
            errno = Errno.InsufficientStorage;
        } else if (i == 4) {
            errno = Errno.ForegroundServiceUnavailable;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            errno = Errno.ArchiveRecoveryBlocked;
        }
        notifyArchiveUpdateFailure(detail, errno, failure.getFailureDetails(), failure.getRequiredFreeSpaceBytes(), failure.getOperationToken());
    }

    static /* synthetic */ Boolean archiveStorageUsesSingleDevice$default(UpdateService updateService, File file, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            file = updateService.getExternalFilesDir(null);
        }
        if ((i & 2) != 0) {
            file2 = updateService.getExternalCacheDir();
        }
        return updateService.archiveStorageUsesSingleDevice(file, file2);
    }

    private final Boolean archiveStorageUsesSingleDevice(File file, File file2) {
        return this.archiveStorageSpaceChecker.usesSingleStorageDevice(file, file2);
    }

    private final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator(final long j) {
        ArchiveMirrorExecutionCoordinator.Companion companion = ArchiveMirrorExecutionCoordinator.Companion;
        DurableArchiveStateStore durableArchiveStateStore = this.archiveStateStore;
        if (durableArchiveStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore = null;
        }
        return companion.create(durableArchiveStateStore, this.archiveSession, new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(UpdateService.archiveMirrorExecutionCoordinator$lambda$0());
            }
        }, new UpdateService$archiveMirrorExecutionCoordinator$2(this), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isCurrentUpdateOperation;
                isCurrentUpdateOperation = UpdateService.this.isCurrentUpdateOperation(UpdateOperationKind.ARCHIVE_UPDATE, j);
                return Boolean.valueOf(isCurrentUpdateOperation);
            }
        }, new UpdateService$archiveMirrorExecutionCoordinator$4(FileServers.INSTANCE), new UpdateService$archiveMirrorExecutionCoordinator$5(FileServers.INSTANCE), new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdateService.archiveMirrorExecutionCoordinator$lambda$2(UpdateService.this, (Function0) obj);
            }
        }, new ArchiveMirrorExecutionCallbacks() { // from class: com.arizona.launcher.UpdateService$archiveMirrorExecutionCoordinator$7
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
                UpdateTransferProgress updateTransferProgress;
                AtomicBoolean atomicBoolean;
                AtomicReference atomicReference;
                updateTransferProgress = UpdateService.this.transferProgress;
                updateTransferProgress.resetArchiveMirror(j2);
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
                UpdateTransferProgress updateTransferProgress;
                boolean isArchiveProgressIndeterminate;
                long coerceAtLeast = RangesKt.coerceAtLeast(j3, 0L);
                atomicBoolean = UpdateService.this.archiveNetworkPending;
                atomicBoolean.set(coerceAtLeast > 0 && RangesKt.coerceAtLeast(j2, 0L) < coerceAtLeast);
                updateTransferProgress = UpdateService.this.transferProgress;
                updateTransferProgress.onArchiveProgress(j2, j3);
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
        updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
        return Unit.INSTANCE;
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
            int i = WhenMappings.$EnumSwitchMapping$2[errno.ordinal()];
            if (i == 1) {
                updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.GAME_DATA_DOWNLOAD_FAILED;
            } else if (i == 2) {
                updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_STORAGE_INSUFFICIENT;
            } else if (i == 3) {
                updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_FOREGROUND_UNAVAILABLE;
            } else if (i == 4) {
                updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.ARCHIVE_RECOVERY_BLOCKED;
            } else {
                updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.GAME_DATA_VALIDATION_FAILED;
            }
            updateAnalyticsReporter.reportError(updateAnalyticsErrorEvent, downloadFailureDetails, this.archiveSession.snapshot().getServer());
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
        Messenger messenger = this.mActivityMessenger;
        if (messenger == null) {
            return;
        }
        try {
            messenger.send(message);
        } catch (RemoteException e) {
            if (this.mActivityMessenger == messenger) {
                this.mActivityMessenger = null;
            }
            Log.w(TAG, "Unable to send updater message what=" + message.what, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLauncherUpdateCheck() {
        FileServers.INSTANCE.refreshLauncherServers();
        LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.launcherUpdateFlow;
        if (launcherUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
            launcherUpdateServiceFlow = null;
        }
        launcherUpdateServiceFlow.requestCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLauncherApkDownload() {
        FileServers.INSTANCE.refreshLauncherServers();
        LauncherUpdateServiceFlow launcherUpdateServiceFlow = this.launcherUpdateFlow;
        if (launcherUpdateServiceFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcherUpdateFlow");
            launcherUpdateServiceFlow = null;
        }
        launcherUpdateServiceFlow.requestApkDownload();
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
    public void completeLauncherApk(final long j, boolean z, boolean z2, boolean z3, String str) {
        if (isCurrentUpdateOperation(UpdateOperationKind.LAUNCHER_APK, j)) {
            if (!z) {
                this.mLastOperationStatus = Errno.UpdateServerUnreachable;
                if (z2 && str != null) {
                    FileServers.INSTANCE.currentLauncherServerIsUnreachable(str);
                }
            } else {
                this.mLastOperationStatus = Errno.NoError;
            }
            final Function0 function0 = new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda0
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
            this.mainHandler.postDelayed(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda3
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
        return this.updateOperationCoordinator.finish(UpdateOperationKind.FILE_CHECK, j);
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
            if (updateService != null) {
                updateService.mActivityMessenger = msg.replyTo;
                Log.i("UpdateService", String.valueOf(msg.what));
                int i = msg.what;
                if (i != 0) {
                    switch (i) {
                        case 2:
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda2
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
                                    UpdateService.this.requestLauncherUpdateCheck();
                                }
                            });
                            return;
                        case 4:
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UpdateService.IncomingHandler.handleMessage$lambda$4(UpdateService.this);
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
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UpdateService.this.requestLauncherApkDownload();
                                }
                            });
                            return;
                        case 7:
                            ArchiveStorageRequirementsSnapshot storageRequirements = updateService.archiveSession.snapshot().getStorageRequirements();
                            UpdateOperationSnapshot activeUpdateOperation = updateService.activeUpdateOperation();
                            UpdateOperationKind kind = activeUpdateOperation != null ? activeUpdateOperation.getKind() : null;
                            Message obtain2 = Message.obtain(updateService.mInHandler, 7);
                            obtain2.getData().putBoolean(UpdateServiceContract.BundleKey.ARCHIVE_UPDATE_ACTIVE, kind == UpdateOperationKind.ARCHIVE_UPDATE || kind == UpdateOperationKind.CHECK_AND_DOWNLOAD);
                            obtain2.getData().putLong("needFreeSpaceSize", storageRequirements.getRequiredFreeSpaceBytes());
                            obtain2.getData().putLong("needGameFreeSpaceSize", storageRequirements.getGameStorageBytes());
                            obtain2.getData().putLong("needDownloadFreeSpaceSize", storageRequirements.getDownloadStorageBytes());
                            obtain2.getData().putBoolean("archiveStorageSameDevice", !Intrinsics.areEqual((Object) UpdateService.archiveStorageUsesSingleDevice$default(updateService, null, null, 3, null), (Object) false));
                            obtain2.replyTo = updateService.mMessenger;
                            Intrinsics.checkNotNull(obtain2);
                            updateService.sendToActivity(obtain2);
                            return;
                        case 8:
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda6
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UpdateService.this.requestFullFileCheck();
                                }
                            });
                            return;
                        case 9:
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UpdateService.this.requestFullFileCheck();
                                }
                            });
                            return;
                        case 10:
                            updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UpdateService.this.requestCheckUpdateAndDownload(true);
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
                updateService.mainHandler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UpdateService.this.requestCheckUpdate();
                    }
                });
                return;
            }
            Log.d("UpdateService", "activity is null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void handleMessage$lambda$4(UpdateService updateService) {
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

    private final void notifyCheckUpdateAndDownloadUnreachable(UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent) {
        UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
        if (updateAnalyticsReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            updateAnalyticsReporter = null;
        }
        UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter, updateAnalyticsErrorEvent, null, null, 6, null);
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

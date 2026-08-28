package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.DownloadRetryConfig;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitErrorCode;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitResult;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadListener;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloader;
import com.arizona.launcher.updater.archive.download.FileArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.install.SafeZipExtractionErrorCode;
import com.arizona.launcher.updater.archive.install.SafeZipExtractionResult;
import com.arizona.launcher.updater.archive.install.SafeZipExtractor;
import com.arizona.launcher.updater.archive.install.SafeZipLimits;
import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadAheadPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchivePhaseTransitions;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiff;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiffPlanner;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipException;
import com.arizona.launcher.updater.archive.transaction.ArchiveTrashCleanupResult;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 x2\u00020\u0001:\u0007vwxyz{|B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020*¢\u0006\u0004\b+\u0010,J>\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001408H\u0086@¢\u0006\u0002\u00109JB\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001408H\u0082@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\u0006\u00105\u001a\u0002062\b\b\u0002\u0010B\u001a\u00020CH\u0002J$\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020H2\n\b\u0002\u0010I\u001a\u0004\u0018\u000104H\u0002J\f\u0010J\u001a\u00020\u0016*\u00020HH\u0002J\u0016\u0010K\u001a\u00020E*\u00020E2\b\u0010I\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002JF\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020\u00142\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0X2\n\b\u0002\u0010Z\u001a\u0004\u0018\u000104H\u0002J\u001a\u0010[\u001a\u0004\u0018\u0001042\u0006\u0010\\\u001a\u0002042\u0006\u0010]\u001a\u000204H\u0002J&\u0010^\u001a\u00020\u00162\f\u0010_\u001a\b\u0012\u0004\u0012\u00020Y0X2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010XH\u0002J\f\u0010b\u001a\u00020\u0016*\u00020cH\u0002J\f\u0010d\u001a\u00020\u0016*\u00020cH\u0002J \u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010Q\u001a\u00020!H\u0082@¢\u0006\u0002\u0010iJ\u0010\u0010j\u001a\u00020\u00162\u0006\u0010k\u001a\u00020\u0003H\u0002J\u001e\u0010l\u001a\u00020\u00162\u0006\u0010k\u001a\u00020\u00032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0002J.\u0010m\u001a\u00020n2\u0006\u0010F\u001a\u0002042\u0006\u0010o\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u00032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0002J\u0018\u0010p\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0002J\u0010\u0010q\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u0003H\u0002J\u0012\u0010r\u001a\u0004\u0018\u00010E2\u0006\u0010Q\u001a\u00020!H\u0002J\u0018\u0010s\u001a\u00020\"2\u0006\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b~\u0012\b\b\u007f\u0012\u0004\b\u0003\u0010\u0000¨\u0006}"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater;", "", "gameRoot", "Ljava/io/File;", "downloadRoot", "workRoot", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "downloadClient", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadClient;", "verifier", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveVerifier;", "extractor", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveExtractor;", "committer", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCommitter;", "retirementClient", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;", "nowEpochMs", "Lkotlin/Function0;", "", "allowInsecureLoopback", "", "runtimeCapacityPolicy", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy;", "downloadAheadPolicy", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy;", "downloadAheadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "archiveResumeStore", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;", "stateSaver", "Lkotlin/Function1;", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "", "byteRangeSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "byteRangeStreamer", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;", "livePathSafety", "Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadClient;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveVerifier;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveExtractor;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCommitter;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRetirementClient;Lkotlin/jvm/functions/Function0;ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "selectiveInstaller", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectivePackageInstaller;", "execute", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "serverBaseUrl", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", "plannedArchiveDownloadBytesByPackage", "", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeTransaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forwardingDownloadListener", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;", "packageBase", "totalDownloadBytes", "networkPhaseRelay", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadNetworkPhaseRelay;", "downloadFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "packageId", "result", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Failure;", "cleanupDetail", "isStorageFailure", "withCleanupDetail", "prepareState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState;", "prepareFullUpdate", UpdateServiceContract.BundleKey.CURRENT, "persistTransition", RemoteConfigConstants.ResponseFieldKey.STATE, "entry", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "bytesDownloaded", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "lastError", "resolvePackageUrl", "baseUrl", "packageUrl", "matchesPublishedEntries", "extracted", "published", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "requiresArchiveRedownload", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "canRetryEvictedCacheImmediately", "discardDisposableDownloadsAfterStorageFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$StoragePressureCleanup;", "slot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadAheadSlot;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadAheadSlot;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetOwnedStaging", "stagingRoot", "hasCompleteExtractedStaging", "verifyCommittedPackageAndCleanup", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck;", "archiveFile", "cleanupCommittedArtifacts", "deleteArchiveForRedownload", "cleanupRetirementTrashIfPresent", "deleteOwnedNode", "node", "deletionRoot", "CommittedPackageCheck", "PreparedState", "Companion", "DownloadAheadSlot", "StoragePressureCleanup", "CommittedArtifacts", "DownloadNetworkPhaseRelay", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageUpdater {
    private static final String COMMITTED_ARTIFACT_CLEANUP_FAILED = "COMMITTED_ARTIFACT_CLEANUP_FAILED";
    private static final String DISCARDED_AFTER_INSUFFICIENT_STORAGE = "DISCARDED_AFTER_INSUFFICIENT_STORAGE";
    private static final String DOWNLOAD_ARTIFACT_CLEANUP_FAILED = "DOWNLOAD_ARTIFACT_CLEANUP_FAILED";
    private static final String DOWNLOAD_STATE_SAVE_FAILED = "DOWNLOAD_STATE_SAVE_FAILED";
    private static final String INTERRUPTED_SELECTIVE_INSTALL = "INTERRUPTED_SELECTIVE_INSTALL";
    private static final String RECOVERY_STATE_SAVE_FAILED = "RECOVERY_STATE_SAVE_FAILED";
    private static final String STAGING_CLEANUP_FAILED = "STAGING_CLEANUP_FAILED";
    private static final String STAGING_INCOMPLETE_AFTER_EXTRACTION = "STAGING_INCOMPLETE_AFTER_EXTRACTION";
    private static final String STATE_SAVE_NO_SPACE_LEFT = "STATE_SAVE_NO_SPACE_LEFT";
    private final boolean allowInsecureLoopback;
    private final ArchiveDownloadResumeStore archiveResumeStore;
    private final ArchiveByteRangeSource byteRangeSource;
    private final ArchiveByteRangeStreamer byteRangeStreamer;
    private final ArchiveCommitter committer;
    private final ArchiveDirectoryCreator directoryCreator;
    private final CoroutineDispatcher downloadAheadDispatcher;
    private final ArchiveDownloadAheadPolicy downloadAheadPolicy;
    private final ArchiveDownloadClient downloadClient;
    private final File downloadRoot;
    private final ArchiveExtractor extractor;
    private final File gameRoot;
    private final ArchiveLivePathSafety livePathSafety;
    private final Function0<Long> nowEpochMs;
    private final ArchiveRetirementClient retirementClient;
    private final ArchiveRuntimeCapacityPolicy runtimeCapacityPolicy;
    private final ArchiveSelectivePackageInstaller selectiveInstaller;
    private final Function1<ArchiveUpdaterState, Unit> stateSaver;
    private final DurableArchiveStateStore stateStore;
    private final ArchiveVerifier verifier;
    private final File workRoot;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ArchivePackagePhase.values().length];
            try {
                iArr[ArchivePackagePhase.PLANNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SafeZipExtractionErrorCode.values().length];
            try {
                iArr2[SafeZipExtractionErrorCode.ARCHIVE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ARCHIVE_NOT_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ARCHIVE_NOT_READABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.EMPTY_ARCHIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.MALFORMED_ARCHIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ENTRY_SIZE_MISMATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.TOTAL_SIZE_MISMATCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ENTRY_CRC32_MISMATCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ENTRY_DATA_CORRUPT.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.ENTRY_IO_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[SafeZipExtractionErrorCode.IO_ERROR.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchivePackageUpdater(File gameRoot, File downloadRoot, File workRoot, DurableArchiveStateStore stateStore, ArchiveDownloadClient downloadClient, ArchiveVerifier verifier, ArchiveExtractor extractor, ArchiveCommitter committer, ArchiveRetirementClient retirementClient, Function0<Long> nowEpochMs, boolean z, ArchiveRuntimeCapacityPolicy runtimeCapacityPolicy, ArchiveDownloadAheadPolicy downloadAheadPolicy, CoroutineDispatcher downloadAheadDispatcher, ArchiveDownloadResumeStore archiveResumeStore, Function1<? super ArchiveUpdaterState, Unit> stateSaver, ArchiveByteRangeSource archiveByteRangeSource, ArchiveByteRangeStreamer archiveByteRangeStreamer, ArchiveLivePathSafety archiveLivePathSafety, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(downloadClient, "downloadClient");
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        Intrinsics.checkNotNullParameter(committer, "committer");
        Intrinsics.checkNotNullParameter(retirementClient, "retirementClient");
        Intrinsics.checkNotNullParameter(nowEpochMs, "nowEpochMs");
        Intrinsics.checkNotNullParameter(runtimeCapacityPolicy, "runtimeCapacityPolicy");
        Intrinsics.checkNotNullParameter(downloadAheadPolicy, "downloadAheadPolicy");
        Intrinsics.checkNotNullParameter(downloadAheadDispatcher, "downloadAheadDispatcher");
        Intrinsics.checkNotNullParameter(archiveResumeStore, "archiveResumeStore");
        Intrinsics.checkNotNullParameter(stateSaver, "stateSaver");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.gameRoot = gameRoot;
        this.downloadRoot = downloadRoot;
        this.workRoot = workRoot;
        this.stateStore = stateStore;
        this.downloadClient = downloadClient;
        this.verifier = verifier;
        this.extractor = extractor;
        this.committer = committer;
        this.retirementClient = retirementClient;
        this.nowEpochMs = nowEpochMs;
        this.allowInsecureLoopback = z;
        this.runtimeCapacityPolicy = runtimeCapacityPolicy;
        this.downloadAheadPolicy = downloadAheadPolicy;
        this.downloadAheadDispatcher = downloadAheadDispatcher;
        this.archiveResumeStore = archiveResumeStore;
        this.stateSaver = stateSaver;
        this.byteRangeSource = archiveByteRangeSource;
        ArchiveByteRangeStreamer archiveByteRangeStreamer2 = archiveByteRangeStreamer;
        this.byteRangeStreamer = archiveByteRangeStreamer2;
        this.livePathSafety = archiveLivePathSafety;
        this.directoryCreator = directoryCreator;
        ArchiveSelectivePackageInstaller archiveSelectivePackageInstaller = null;
        if (archiveByteRangeSource != null && archiveLivePathSafety != null) {
            archiveSelectivePackageInstaller = new ArchiveSelectivePackageInstaller(gameRoot, new RemoteZipIndexFetcher(archiveByteRangeSource, null, 2, null), new RemoteZipEntryRangeReader(archiveByteRangeSource, archiveByteRangeStreamer2 == null ? ArchiveManifestResolverKt.asBufferedStreamer(archiveByteRangeSource) : archiveByteRangeStreamer2, directoryCreator), archiveLivePathSafety, directoryCreator, new Function2() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ArchivePackageUpdater.selectiveInstaller$lambda$0(ArchivePackageUpdater.this, (String) obj, (String) obj2);
                }
            });
        }
        this.selectiveInstaller = archiveSelectivePackageInstaller;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ArchivePackageUpdater(File file, File file2, File file3, DurableArchiveStateStore durableArchiveStateStore, ArchiveDownloadClient archiveDownloadClient, ArchiveVerifier archiveVerifier, ArchiveExtractor archiveExtractor, ArchiveCommitter archiveCommitter, ArchiveRetirementClient archiveRetirementClient, Function0 function0, boolean z, ArchiveRuntimeCapacityPolicy archiveRuntimeCapacityPolicy, ArchiveDownloadAheadPolicy archiveDownloadAheadPolicy, CoroutineDispatcher coroutineDispatcher, ArchiveDownloadResumeStore archiveDownloadResumeStore, Function1 function1, ArchiveByteRangeSource archiveByteRangeSource, ArchiveByteRangeStreamer archiveByteRangeStreamer, ArchiveLivePathSafety archiveLivePathSafety, ArchiveDirectoryCreator archiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, file2, file3, r6, archiveDownloadClient, archiveVerifier, archiveExtractor, archiveCommitter, r11, r12, r13, r14, r15, r16, r17, r18, (65536 & i) != 0 ? null : archiveByteRangeSource, (131072 & i) != 0 ? null : archiveByteRangeStreamer, (262144 & i) != 0 ? null : archiveLivePathSafety, (i & 524288) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : archiveDirectoryCreator);
        ArchiveRetirementClient archiveRetirementClient2;
        DurableArchiveStateStore durableArchiveStateStore2;
        AnonymousClass2 anonymousClass2;
        ArchiveRetirementClient archiveRetirementClient3;
        if ((i & 256) != 0) {
            archiveRetirementClient3 = ArchivePackageUpdaterKt.archiveRetirementClient(file);
            archiveRetirementClient2 = archiveRetirementClient3;
        } else {
            archiveRetirementClient2 = archiveRetirementClient;
        }
        AnonymousClass1 anonymousClass1 = (i & 512) != 0 ? AnonymousClass1.INSTANCE : function0;
        boolean z2 = (i & 1024) != 0 ? false : z;
        ArchiveRuntimeCapacityPolicy.AssumeEnough assumeEnough = (i & 2048) != 0 ? ArchiveRuntimeCapacityPolicy.AssumeEnough.INSTANCE : archiveRuntimeCapacityPolicy;
        ArchiveDownloadAheadPolicy.Disabled disabled = (i & 4096) != 0 ? ArchiveDownloadAheadPolicy.Disabled.INSTANCE : archiveDownloadAheadPolicy;
        CoroutineDispatcher io2 = (i & 8192) != 0 ? Dispatchers.getIO() : coroutineDispatcher;
        FileArchiveDownloadResumeStore fileArchiveDownloadResumeStore = (i & 16384) != 0 ? new FileArchiveDownloadResumeStore(null, null, 3, null) : archiveDownloadResumeStore;
        if ((32768 & i) != 0) {
            durableArchiveStateStore2 = durableArchiveStateStore;
            anonymousClass2 = new AnonymousClass2(durableArchiveStateStore2);
        } else {
            durableArchiveStateStore2 = durableArchiveStateStore;
            anonymousClass2 = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ArchiveUpdaterState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, DurableArchiveStateStore.class, "save", "save(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ArchiveUpdaterState archiveUpdaterState) {
            invoke2(archiveUpdaterState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ArchiveUpdaterState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DurableArchiveStateStore) this.receiver).save(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String selectiveInstaller$lambda$0(ArchivePackageUpdater archivePackageUpdater, String baseUrl, String packageUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        return archivePackageUpdater.resolvePackageUrl(baseUrl, packageUrl);
    }

    public static /* synthetic */ Object execute$default(ArchivePackageUpdater archivePackageUpdater, ArchiveUpdatePlan archiveUpdatePlan, String str, ArchiveUpdaterListener archiveUpdaterListener, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            archiveUpdaterListener = ArchiveUpdaterListener.None.INSTANCE;
        }
        ArchiveUpdaterListener archiveUpdaterListener2 = archiveUpdaterListener;
        Map map2 = map;
        if ((i & 8) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return archivePackageUpdater.execute(archiveUpdatePlan, str, archiveUpdaterListener2, map2, continuation);
    }

    public final Object execute(ArchiveUpdatePlan archiveUpdatePlan, String str, ArchiveUpdaterListener archiveUpdaterListener, Map<String, Long> map, Continuation<? super ArchiveUpdaterResult> continuation) {
        return SupervisorKt.supervisorScope(new ArchivePackageUpdater$execute$2(this, archiveUpdatePlan, str, archiveUpdaterListener, map, null), continuation);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:389:0x273c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object executeTransaction(kotlinx.coroutines.CoroutineScope r107, com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan r108, java.lang.String r109, com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener r110, java.util.Map<java.lang.String, java.lang.Long> r111, kotlin.coroutines.Continuation<? super com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult> r112) {
        /*
            Method dump skipped, instructions count: 32760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater.executeTransaction(kotlinx.coroutines.CoroutineScope, com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan, java.lang.String, com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ ArchiveUpdaterResult.Failure executeTransaction$expandToWholeZip$default(LinkedHashMap linkedHashMap, Ref.LongRef longRef, Ref.LongRef longRef2, ArchiveUpdaterListener archiveUpdaterListener, ArchivePackage archivePackage, long j, int i, Object obj) {
        if ((i & 32) != 0) {
            j = 0;
        }
        return executeTransaction$expandToWholeZip(linkedHashMap, longRef, longRef2, archiveUpdaterListener, archivePackage, j);
    }

    private static final ArchiveUpdaterResult.Failure executeTransaction$expandToWholeZip(LinkedHashMap<String, Long> linkedHashMap, Ref.LongRef longRef, Ref.LongRef longRef2, ArchiveUpdaterListener archiveUpdaterListener, ArchivePackage archivePackage, long j) {
        Long l = linkedHashMap.get(archivePackage.getId());
        long longValue = l != null ? l.longValue() : 0L;
        long max = Math.max(longValue, archivePackage.getArchiveSize());
        linkedHashMap.put(archivePackage.getId(), Long.valueOf(max));
        long j2 = max - longValue;
        if (j2 > 0) {
            try {
                longRef.element = Math.addExact(longRef.element, j2);
            } catch (ArithmeticException unused) {
                return ArchivePackageUpdaterKt.failure$default(ArchiveUpdaterErrorCode.STATE_INVALID, archivePackage.getId(), "archive download total overflows Long", null, null, 24, null);
            }
        }
        if (j != 0) {
            longRef.element = Math.addExact(longRef.element, j);
        }
        if (longRef.element > longRef2.element) {
            archiveUpdaterListener.onRuntimeRequirementsChanged(longRef.element, null);
            longRef2.element = longRef.element;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit executeTransaction$lambda$9(ArchiveUpdaterListener archiveUpdaterListener, Ref.LongRef longRef, Ref.LongRef longRef2, long j) {
        archiveUpdaterListener.onDownloadProgress(RangesKt.coerceAtMost(longRef.element + j, longRef2.element), longRef2.element);
        return Unit.INSTANCE;
    }

    static /* synthetic */ ArchiveDownloadListener forwardingDownloadListener$default(ArchivePackageUpdater archivePackageUpdater, long j, long j2, ArchiveUpdaterListener archiveUpdaterListener, DownloadNetworkPhaseRelay downloadNetworkPhaseRelay, int i, Object obj) {
        ArchiveUpdaterListener archiveUpdaterListener2;
        DownloadNetworkPhaseRelay downloadNetworkPhaseRelay2;
        if ((i & 8) != 0) {
            archiveUpdaterListener2 = archiveUpdaterListener;
            downloadNetworkPhaseRelay2 = new DownloadNetworkPhaseRelay(archiveUpdaterListener2, false, 2, null);
        } else {
            archiveUpdaterListener2 = archiveUpdaterListener;
            downloadNetworkPhaseRelay2 = downloadNetworkPhaseRelay;
        }
        return archivePackageUpdater.forwardingDownloadListener(j, j2, archiveUpdaterListener2, downloadNetworkPhaseRelay2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveDownloadListener forwardingDownloadListener(final long j, final long j2, final ArchiveUpdaterListener archiveUpdaterListener, final DownloadNetworkPhaseRelay downloadNetworkPhaseRelay) {
        return new ArchiveDownloadListener() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$forwardingDownloadListener$1
            @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadListener
            public void onProgress(String packageId, long j3, long j4) {
                Intrinsics.checkNotNullParameter(packageId, "packageId");
                ArchivePackageUpdater.DownloadNetworkPhaseRelay.this.onProgress(packageId);
                archiveUpdaterListener.onDownloadProgress(RangesKt.coerceAtMost(j + j3, j2), j2);
            }

            @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadListener
            public void onRetry(String packageId, int i, long j3, DownloadFailureDetails failure) {
                Intrinsics.checkNotNullParameter(packageId, "packageId");
                Intrinsics.checkNotNullParameter(failure, "failure");
                archiveUpdaterListener.onRetry(packageId, i, j3, failure.getSubtypeSuffix());
            }

            @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadListener
            public void onWaitingForNetwork(String packageId, DownloadFailureDetails failure) {
                Intrinsics.checkNotNullParameter(packageId, "packageId");
                Intrinsics.checkNotNullParameter(failure, "failure");
                ArchivePackageUpdater.DownloadNetworkPhaseRelay.this.onWaitingForNetwork(packageId);
            }
        };
    }

    static /* synthetic */ ArchiveUpdaterResult.Failure downloadFailure$default(ArchivePackageUpdater archivePackageUpdater, String str, ArchivePackageDownloadResult.Failure failure, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return archivePackageUpdater.downloadFailure(str, failure, str2);
    }

    private final ArchiveUpdaterResult.Failure downloadFailure(String str, ArchivePackageDownloadResult.Failure failure, String str2) {
        ArchiveUpdaterErrorCode archiveUpdaterErrorCode;
        DownloadFailureDetails details = failure.getDetails();
        if (Intrinsics.areEqual(details != null ? details.getSubtypeSuffix() : null, "STORAGE")) {
            archiveUpdaterErrorCode = ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE;
        } else {
            archiveUpdaterErrorCode = ArchiveUpdaterErrorCode.DOWNLOAD_FAILED;
        }
        return new ArchiveUpdaterResult.Failure(archiveUpdaterErrorCode, str, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{failure.getCode().name(), str2}), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null), failure.getCode(), failure.getDetails(), null, null, 96, null);
    }

    private final boolean isStorageFailure(ArchivePackageDownloadResult.Failure failure) {
        DownloadFailureDetails details = failure.getDetails();
        return Intrinsics.areEqual(details != null ? details.getSubtypeSuffix() : null, "STORAGE");
    }

    private final ArchiveUpdaterResult.Failure withCleanupDetail(ArchiveUpdaterResult.Failure failure, String str) {
        return str == null ? failure : ArchiveUpdaterResult.Failure.copy$default(failure, null, null, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{failure.getDetail(), str}), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null), null, null, null, null, 123, null);
    }

    private final PreparedState prepareState(ArchiveUpdatePlan archiveUpdatePlan) {
        ArchiveStateLoadResult load = this.stateStore.load();
        if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
            if (archiveUpdatePlan.getType() != ArchivePlanType.FULL_BOOTSTRAP) {
                return new PreparedState.Failed(ArchiveUpdaterErrorCode.STATE_MISSING);
            }
            ArchiveUpdaterState createInitialState = ArchiveStateAdapter.INSTANCE.createInitialState(archiveUpdatePlan.getRemoteManifest(), this.nowEpochMs.invoke().longValue());
            this.stateSaver.invoke(createInitialState);
            return new PreparedState.Ready(createInitialState);
        } else if (load instanceof ArchiveStateLoadResult.Corrupt) {
            return new PreparedState.Failed(ArchiveUpdaterErrorCode.STATE_CORRUPT);
        } else {
            if (!(load instanceof ArchiveStateLoadResult.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ArchiveUpdaterState state = ((ArchiveStateLoadResult.Loaded) load).getState();
            if (ArchiveStateAdapter.INSTANCE.identitiesMatch(state, archiveUpdatePlan.getRemoteManifest())) {
                if (!state.isInstallReady()) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : state.getPackages()) {
                        if (((ArchivePackageJournalEntry) obj).getPhase() == ArchivePackagePhase.EXTRACTING) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<ArchivePackageJournalEntry> arrayList2 = arrayList;
                    if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                        for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList2) {
                            if (!resetOwnedStaging(ArchivePackagePaths.INSTANCE.stagingRoot(this.workRoot, archivePackageJournalEntry.getIdentity()))) {
                                return new PreparedState.Failed(ArchiveUpdaterErrorCode.STAGING_RESET_FAILED);
                            }
                        }
                    }
                    this.stateSaver.invoke(state);
                }
                return new PreparedState.Ready(state);
            } else if (!state.isInstallReady()) {
                return new PreparedState.Failed(ArchiveUpdaterErrorCode.STATE_MANIFEST_MISMATCH);
            } else {
                if (archiveUpdatePlan.getType() != ArchivePlanType.FULL_UPDATE) {
                    return new PreparedState.Failed(ArchiveUpdaterErrorCode.STATE_MANIFEST_MISMATCH);
                }
                return prepareFullUpdate(state, archiveUpdatePlan);
            }
        }
    }

    private final PreparedState prepareFullUpdate(ArchiveUpdaterState archiveUpdaterState, ArchiveUpdatePlan archiveUpdatePlan) {
        int i;
        ArchiveOwnershipDiff archiveOwnershipDiff;
        ArrayList arrayList;
        int i2;
        ArchivePackageJournalEntry beginUpdate;
        long longValue = this.nowEpochMs.invoke().longValue();
        List<ArchivePackage> packages = archiveUpdatePlan.getRemoteManifest().getPackages();
        if (!(packages instanceof Collection) || !packages.isEmpty()) {
            for (ArchivePackage archivePackage : packages) {
                if (archivePackage.getEntries() == null) {
                    return new PreparedState.Failed(ArchiveUpdaterErrorCode.ENTRY_METADATA_MISSING);
                }
            }
        }
        try {
            ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner = ArchiveOwnershipDiffPlanner.INSTANCE;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = archiveUpdaterState.getPackages().iterator();
            while (true) {
                i = 10;
                if (!it.hasNext()) {
                    break;
                }
                ArchivePackageJournalEntry archivePackageJournalEntry = (ArchivePackageJournalEntry) it.next();
                List<ArchivePackageFileRecord> files = archivePackageJournalEntry.getFiles();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(files, 10));
                for (ArchivePackageFileRecord archivePackageFileRecord : files) {
                    arrayList3.add(new ArchiveOwnedPath(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath()));
                }
                CollectionsKt.addAll(arrayList2, arrayList3);
            }
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList();
            for (ArchivePackage archivePackage2 : archiveUpdatePlan.getRemoteManifest().getPackages()) {
                List<ArchiveEntryMetadata> entries = archivePackage2.getEntries();
                if (entries == null) {
                    entries = CollectionsKt.emptyList();
                }
                List<ArchiveEntryMetadata> list = entries;
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ArchiveEntryMetadata archiveEntryMetadata : list) {
                    arrayList6.add(new ArchiveOwnedPath(archivePackage2.getId(), archiveEntryMetadata.getTargetRelativePath()));
                }
                CollectionsKt.addAll(arrayList5, arrayList6);
            }
            ArchiveOwnershipDiff diff = archiveOwnershipDiffPlanner.diff(arrayList4, arrayList5);
            List<ArchivePackage> packages2 = archiveUpdatePlan.getRemoteManifest().getPackages();
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages2, 10));
            for (ArchivePackage archivePackage3 : packages2) {
                ArchivePackageIdentity archivePackageIdentity = new ArchivePackageIdentity(archivePackage3.getId(), archivePackage3.getArchiveSize(), archivePackage3.getCrc32());
                List<ArchiveEntryMetadata> entries2 = archivePackage3.getEntries();
                if (entries2 == null) {
                    entries2 = CollectionsKt.emptyList();
                }
                List<ArchiveEntryMetadata> list2 = entries2;
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, i));
                for (ArchiveEntryMetadata archiveEntryMetadata2 : list2) {
                    arrayList8.add(new ArchivePackageFileRecord(archiveEntryMetadata2.getTargetRelativePath(), archiveEntryMetadata2.getSize(), archiveEntryMetadata2.getCrc32(), (String) null, 8, (DefaultConstructorMarker) null));
                }
                ArrayList arrayList9 = arrayList8;
                ArchivePackageJournalEntry packageById = archiveUpdaterState.packageById(archivePackage3.getId());
                if (packageById == null) {
                    archiveOwnershipDiff = diff;
                    arrayList = arrayList7;
                    i2 = i;
                    beginUpdate = new ArchivePackageJournalEntry(archivePackageIdentity, ArchivePackagePhase.PLANNED, 0L, (ArchivePackageIdentity) null, (List) null, arrayList9, (List) null, longValue, (String) null, 348, (DefaultConstructorMarker) null);
                } else {
                    archiveOwnershipDiff = diff;
                    arrayList = arrayList7;
                    i2 = i;
                    if (Intrinsics.areEqual(packageById.getIdentity(), archivePackageIdentity)) {
                        ArrayList arrayList10 = arrayList9;
                        if (arrayList10.isEmpty()) {
                            arrayList10 = packageById.getDesiredFiles();
                        }
                        beginUpdate = ArchivePackageJournalEntry.copy$default(packageById, null, null, 0L, null, null, arrayList10, null, 0L, null, 479, null);
                    } else {
                        beginUpdate = ArchivePhaseTransitions.INSTANCE.beginUpdate(packageById, archivePackageIdentity, arrayList9, ArchivePackagePhase.PLANNED, longValue);
                    }
                }
                arrayList.add(beginUpdate);
                i = i2;
                arrayList7 = arrayList;
                diff = archiveOwnershipDiff;
            }
            int i3 = i;
            ArrayList arrayList11 = arrayList7;
            String manifestId = ArchiveStateAdapter.INSTANCE.manifestId(archiveUpdatePlan.getRemoteManifest());
            String manifestVersion = archiveUpdatePlan.getRemoteManifest().getManifestVersion();
            int schemaVersion = archiveUpdatePlan.getRemoteManifest().getSchemaVersion();
            String wireName = archiveUpdatePlan.getRemoteManifest().getSelectedGpu().getWireName();
            List<ArchiveOwnedPath> retired = diff.getRetired();
            ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(retired, i3));
            for (ArchiveOwnedPath archiveOwnedPath : retired) {
                arrayList12.add(new ArchiveFileRetirementRecord(archiveOwnedPath.getPackageId(), archiveOwnedPath.getRelativePath()));
            }
            ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(archiveUpdaterState, 0, manifestId, manifestVersion, schemaVersion, wireName, arrayList11, arrayList12, false, longValue, 1, null);
            try {
                this.stateSaver.invoke(copy$default);
                this.stateSaver.invoke(copy$default);
                return new PreparedState.Ready(copy$default);
            } catch (IllegalStateException unused) {
                return new PreparedState.Failed(ArchiveUpdaterErrorCode.STATE_INVALID);
            }
        } catch (ArchiveOwnershipException unused2) {
            return new PreparedState.Failed(ArchiveUpdaterErrorCode.OWNERSHIP_INVALID);
        }
    }

    static /* synthetic */ ArchiveUpdaterState persistTransition$default(ArchivePackageUpdater archivePackageUpdater, ArchiveUpdaterState archiveUpdaterState, ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackagePhase archivePackagePhase, long j, List list, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            j = archivePackageJournalEntry.getBytesDownloaded();
        }
        return archivePackageUpdater.persistTransition(archiveUpdaterState, archivePackageJournalEntry, archivePackagePhase, j, (i & 16) != 0 ? archivePackageJournalEntry.getFiles() : list, (i & 32) != 0 ? null : str);
    }

    private final ArchiveUpdaterState persistTransition(ArchiveUpdaterState archiveUpdaterState, ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackagePhase archivePackagePhase, long j, List<ArchivePackageFileRecord> list, String str) {
        long longValue = this.nowEpochMs.invoke().longValue();
        ArchiveUpdaterState replacePackage = ArchiveStateAdapter.INSTANCE.replacePackage(archiveUpdaterState, ArchivePhaseTransitions.transition$default(ArchivePhaseTransitions.INSTANCE, archivePackageJournalEntry, archivePackagePhase, j, null, list, null, null, longValue, str, 104, null), longValue);
        this.stateSaver.invoke(replacePackage);
        return replacePackage;
    }

    private final String resolvePackageUrl(String str, String str2) {
        return ArchivePackageUrlResolver.INSTANCE.resolve(str, str2, this.allowInsecureLoopback);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean matchesPublishedEntries(List<ArchivePackageFileRecord> list, List<ArchiveEntryMetadata> list2) {
        if (list2 == null) {
            return true;
        }
        List<ArchivePackageFileRecord> list3 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
        for (Object obj : list3) {
            String relativePath = ((ArchivePackageFileRecord) obj).getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        List<ArchiveEntryMetadata> list4 = list2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list4, 10)), 16));
        for (Object obj2 : list4) {
            String targetRelativePath = ((ArchiveEntryMetadata) obj2).getTargetRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = targetRelativePath.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            linkedHashMap2.put(lowerCase2, obj2);
        }
        if (Intrinsics.areEqual(linkedHashMap.keySet(), linkedHashMap2.keySet())) {
            if (linkedHashMap.isEmpty()) {
                return true;
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) entry.getValue();
                ArchiveEntryMetadata archiveEntryMetadata = (ArchiveEntryMetadata) linkedHashMap2.get((String) entry.getKey());
                if (archiveEntryMetadata == null || archiveEntryMetadata.getSize() != archivePackageFileRecord.getSize() || archiveEntryMetadata.getCrc32() != archivePackageFileRecord.getCrc32()) {
                    return false;
                }
                while (r9.hasNext()) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean requiresArchiveRedownload(SafeZipExtractionErrorCode safeZipExtractionErrorCode) {
        switch (WhenMappings.$EnumSwitchMapping$1[safeZipExtractionErrorCode.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    private final boolean canRetryEvictedCacheImmediately(SafeZipExtractionErrorCode safeZipExtractionErrorCode) {
        int i = WhenMappings.$EnumSwitchMapping$1[safeZipExtractionErrorCode.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object discardDisposableDownloadsAfterStorageFailure(DownloadAheadSlot downloadAheadSlot, ArchiveUpdaterState archiveUpdaterState, Continuation<? super StoragePressureCleanup> continuation) {
        ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1 archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1;
        int i;
        ArchiveUpdaterState archiveUpdaterState2;
        Deferred<ArchivePackageDownloadResult> result;
        ArrayList arrayList;
        boolean z;
        if (continuation instanceof ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1) {
            archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1 = (ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1) continuation;
            if ((archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.label & Integer.MIN_VALUE) != 0) {
                archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.label -= Integer.MIN_VALUE;
                Object obj = archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (downloadAheadSlot == null || (result = downloadAheadSlot.getResult()) == null) {
                        archiveUpdaterState2 = archiveUpdaterState;
                        arrayList = new ArrayList();
                        ArrayList<ArchivePackageJournalEntry> arrayList2 = new ArrayList();
                        for (Object obj2 : archiveUpdaterState2.getPackages()) {
                            if (((ArchivePackageJournalEntry) obj2).getPhase() == ArchivePackagePhase.DOWNLOADING) {
                                arrayList2.add(obj2);
                            }
                        }
                        z = false;
                        for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList2) {
                            if (!deleteArchiveForRedownload(ArchivePackagePaths.INSTANCE.archiveFile(this.downloadRoot, archivePackageJournalEntry.getIdentity()))) {
                                arrayList.add("DOWNLOAD_ARTIFACT_CLEANUP_FAILED:" + archivePackageJournalEntry.getPackageId());
                            } else {
                                long longValue = this.nowEpochMs.invoke().longValue();
                                archiveUpdaterState2 = ArchiveStateAdapter.INSTANCE.replacePackage(archiveUpdaterState2, ArchivePhaseTransitions.transition$default(ArchivePhaseTransitions.INSTANCE, archivePackageJournalEntry, ArchivePackagePhase.PLANNED, 0L, null, null, null, null, longValue, DISCARDED_AFTER_INSUFFICIENT_STORAGE, 120, null), longValue);
                                z = true;
                            }
                        }
                        if (z) {
                            try {
                                this.stateSaver.invoke(archiveUpdaterState2);
                            } catch (IOException unused) {
                                arrayList.add(DOWNLOAD_STATE_SAVE_FAILED);
                            } catch (SecurityException unused2) {
                                arrayList.add(DOWNLOAD_STATE_SAVE_FAILED);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        return new StoragePressureCleanup(archiveUpdaterState2, arrayList != null ? CollectionsKt.joinToString$default(arrayList, StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null) : null);
                    }
                    archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.L$0 = SpillingKt.nullOutSpilledVariable(downloadAheadSlot);
                    archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.L$1 = archiveUpdaterState;
                    archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.label = 1;
                    obj = JobKt.cancelAndJoin(result, archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    archiveUpdaterState2 = archiveUpdaterState;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    archiveUpdaterState2 = (ArchiveUpdaterState) archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.L$1;
                    DownloadAheadSlot downloadAheadSlot2 = (DownloadAheadSlot) archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Unit unit = (Unit) obj;
                arrayList = new ArrayList();
                ArrayList<ArchivePackageJournalEntry> arrayList22 = new ArrayList();
                while (r3.hasNext()) {
                }
                z = false;
                while (r3.hasNext()) {
                }
                if (z) {
                }
                if (arrayList.isEmpty()) {
                }
                return new StoragePressureCleanup(archiveUpdaterState2, arrayList != null ? CollectionsKt.joinToString$default(arrayList, StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null) : null);
            }
        }
        archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1 = new ArchivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1(this, continuation);
        Object obj3 = archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archivePackageUpdater$discardDisposableDownloadsAfterStorageFailure$1.label;
        if (i != 0) {
        }
        Unit unit2 = (Unit) obj3;
        arrayList = new ArrayList();
        ArrayList<ArchivePackageJournalEntry> arrayList222 = new ArrayList();
        while (r3.hasNext()) {
        }
        z = false;
        while (r3.hasNext()) {
        }
        if (z) {
        }
        if (arrayList.isEmpty()) {
        }
        return new StoragePressureCleanup(archiveUpdaterState2, arrayList != null ? CollectionsKt.joinToString$default(arrayList, StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null) : null);
    }

    private final boolean resetOwnedStaging(File file) {
        try {
            if (file.exists()) {
                File canonicalFile = this.workRoot.getCanonicalFile();
                File canonicalFile2 = file.getCanonicalFile();
                String path = canonicalFile2.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                String path2 = canonicalFile.getPath();
                if (StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null)) {
                    Intrinsics.checkNotNull(canonicalFile2);
                    deleteOwnedNode(canonicalFile2, canonicalFile2);
                    return true;
                }
                return false;
            }
            return true;
        } catch (IOException | SecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: IOException | SecurityException -> 0x007d, TryCatch #0 {IOException | SecurityException -> 0x007d, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000e, B:10:0x0019, B:13:0x0023, B:14:0x0027, B:16:0x002d, B:18:0x0068, B:20:0x006e), top: B:28:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasCompleteExtractedStaging(File file, List<ArchivePackageFileRecord> list) {
        try {
            if (file.isDirectory() && !list.isEmpty()) {
                File canonicalFile = file.getCanonicalFile();
                List<ArchivePackageFileRecord> list2 = list;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    return true;
                }
                for (ArchivePackageFileRecord archivePackageFileRecord : list2) {
                    File canonicalFile2 = new File(canonicalFile, archivePackageFileRecord.getRelativePath()).getCanonicalFile();
                    String path = canonicalFile2.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    String path2 = canonicalFile.getPath();
                    if (!StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null) || !canonicalFile2.isFile() || canonicalFile2.length() != archivePackageFileRecord.getSize()) {
                        return false;
                    }
                    while (r9.hasNext()) {
                    }
                }
                return true;
            }
        } catch (IOException | SecurityException unused) {
        }
        return false;
    }

    private final CommittedPackageCheck verifyCommittedPackageAndCleanup(String str, File file, File file2, List<ArchivePackageFileRecord> list) {
        ArchivePackageCommitResult commit = this.committer.commit(str, file2, list);
        if (!(commit instanceof ArchivePackageCommitResult.Success)) {
            if (!(commit instanceof ArchivePackageCommitResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            ArchivePackageCommitResult.Failure failure = (ArchivePackageCommitResult.Failure) commit;
            if (failure.getCode() == ArchivePackageCommitErrorCode.NO_SPACE_LEFT) {
                return new CommittedPackageCheck.Failed(ArchivePackageUpdaterKt.failure$default(ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE, str, failure.getCode().name(), null, null, 24, null));
            }
            if (failure.getCode() == ArchivePackageCommitErrorCode.SOURCE_MISSING) {
                return CommittedPackageCheck.PayloadMismatch.INSTANCE;
            }
            return new CommittedPackageCheck.Failed(ArchivePackageUpdaterKt.failure$default(ArchiveUpdaterErrorCode.COMMIT_FAILED, str, failure.getCode().name(), null, null, 24, null));
        } else if (cleanupCommittedArtifacts(file, file2)) {
            return CommittedPackageCheck.Success.INSTANCE;
        } else {
            return new CommittedPackageCheck.Failed(ArchivePackageUpdaterKt.failure$default(ArchiveUpdaterErrorCode.ARTIFACT_CLEANUP_FAILED, str, null, null, null, 28, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck;", "", "Success", "PayloadMismatch", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$PayloadMismatch;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface CommittedPackageCheck {

        /* compiled from: ArchivePackageUpdater.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Success implements CommittedPackageCheck {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1643214006;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
            }
        }

        /* compiled from: ArchivePackageUpdater.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$PayloadMismatch;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class PayloadMismatch implements CommittedPackageCheck {
            public static final int $stable = 0;
            public static final PayloadMismatch INSTANCE = new PayloadMismatch();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PayloadMismatch) {
                    PayloadMismatch payloadMismatch = (PayloadMismatch) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1963818435;
            }

            public String toString() {
                return "PayloadMismatch";
            }

            private PayloadMismatch() {
            }
        }

        /* compiled from: ArchivePackageUpdater.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedPackageCheck;", "failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;)V", "getFailure", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements CommittedPackageCheck {
            public static final int $stable = DownloadFailureDetails.$stable;
            private final ArchiveUpdaterResult.Failure failure;

            public static /* synthetic */ Failed copy$default(Failed failed, ArchiveUpdaterResult.Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = failed.failure;
                }
                return failed.copy(failure);
            }

            public final ArchiveUpdaterResult.Failure component1() {
                return this.failure;
            }

            public final Failed copy(ArchiveUpdaterResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Failed(failure);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.failure, ((Failed) obj).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failed(failure=" + this.failure + ")";
            }

            public Failed(ArchiveUpdaterResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final ArchiveUpdaterResult.Failure getFailure() {
                return this.failure;
            }
        }
    }

    private final boolean cleanupCommittedArtifacts(File file, File file2) {
        return deleteArchiveForRedownload(file) && resetOwnedStaging(file2);
    }

    private final boolean deleteArchiveForRedownload(File file) {
        try {
            if (file.exists() && !file.delete() && file.exists()) {
                return false;
            }
            this.archiveResumeStore.delete(file);
            return true;
        } catch (IOException | SecurityException unused) {
            return false;
        }
    }

    private final ArchiveUpdaterResult.Failure cleanupRetirementTrashIfPresent(ArchiveUpdaterState archiveUpdaterState) {
        String transactionId = ArchiveStateAdapter.INSTANCE.transactionId(archiveUpdaterState.getManifestId());
        if (new File(this.workRoot, "transactions/" + transactionId + "/retired").exists()) {
            ArchiveTrashCleanupResult cleanup = this.retirementClient.cleanup(transactionId);
            if (cleanup instanceof ArchiveTrashCleanupResult.Success) {
                return null;
            }
            if (!(cleanup instanceof ArchiveTrashCleanupResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            return ArchivePackageUpdaterKt.failure$default(ArchiveUpdaterErrorCode.RETIREMENT_CLEANUP_FAILED, null, null, null, null, 30, null);
        }
        return null;
    }

    private final void deleteOwnedNode(File file, File file2) {
        File canonicalFile = file.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile, file2)) {
            String path = canonicalFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            if (!StringsKt.startsWith$default(path, file2.getPath() + File.separator, false, 2, (Object) null)) {
                throw new IOException("Refusing to follow staging path outside deletion root");
            }
        }
        if (canonicalFile.isDirectory()) {
            File[] listFiles = canonicalFile.listFiles();
            if (listFiles == null) {
                throw new IOException("Unable to list staging directory");
            }
            for (File file3 : listFiles) {
                Intrinsics.checkNotNull(file3);
                deleteOwnedNode(file3, file2);
            }
        }
        if (canonicalFile.exists() && !canonicalFile.delete()) {
            throw new IOException("Unable to delete staging path");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState;", "", "Ready", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface PreparedState {

        /* compiled from: ArchivePackageUpdater.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements PreparedState {
            public static final int $stable = ArchiveUpdaterState.$stable;
            private final ArchiveUpdaterState state;

            public static /* synthetic */ Ready copy$default(Ready ready, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveUpdaterState = ready.state;
                }
                return ready.copy(archiveUpdaterState);
            }

            public final ArchiveUpdaterState component1() {
                return this.state;
            }

            public final Ready copy(ArchiveUpdaterState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Ready(state);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ready) && Intrinsics.areEqual(this.state, ((Ready) obj).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Ready(state=" + this.state + ")";
            }

            public Ready(ArchiveUpdaterState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final ArchiveUpdaterState getState() {
                return this.state;
            }
        }

        /* compiled from: ArchivePackageUpdater.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$PreparedState;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements PreparedState {
            public static final int $stable = 0;
            private final ArchiveUpdaterErrorCode code;

            public static /* synthetic */ Failed copy$default(Failed failed, ArchiveUpdaterErrorCode archiveUpdaterErrorCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveUpdaterErrorCode = failed.code;
                }
                return failed.copy(archiveUpdaterErrorCode);
            }

            public final ArchiveUpdaterErrorCode component1() {
                return this.code;
            }

            public final Failed copy(ArchiveUpdaterErrorCode code) {
                Intrinsics.checkNotNullParameter(code, "code");
                return new Failed(code);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && this.code == ((Failed) obj).code;
            }

            public int hashCode() {
                return this.code.hashCode();
            }

            public String toString() {
                return "Failed(code=" + this.code + ")";
            }

            public Failed(ArchiveUpdaterErrorCode code) {
                Intrinsics.checkNotNullParameter(code, "code");
                this.code = code;
            }

            public final ArchiveUpdaterErrorCode getCode() {
                return this.code;
            }
        }
    }

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$Companion;", "", "<init>", "()V", "create", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater;", "context", "Landroid/content/Context;", "retryEnabled", "", ArchivePackageUpdater.DISCARDED_AFTER_INSUFFICIENT_STORAGE, "", ArchivePackageUpdater.STAGING_CLEANUP_FAILED, ArchivePackageUpdater.COMMITTED_ARTIFACT_CLEANUP_FAILED, ArchivePackageUpdater.STATE_SAVE_NO_SPACE_LEFT, ArchivePackageUpdater.DOWNLOAD_ARTIFACT_CLEANUP_FAILED, ArchivePackageUpdater.DOWNLOAD_STATE_SAVE_FAILED, ArchivePackageUpdater.RECOVERY_STATE_SAVE_FAILED, ArchivePackageUpdater.STAGING_INCOMPLETE_AFTER_EXTRACTION, ArchivePackageUpdater.INTERRUPTED_SELECTIVE_INSTALL, "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchivePackageUpdater create(Context context, boolean z) {
            File externalCacheDir;
            ArchiveRetirementClient archiveRetirementClient;
            Intrinsics.checkNotNullParameter(context, "context");
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
                return null;
            }
            File file = new File(externalCacheDir, "archive-updater/downloads");
            File file2 = new File(externalFilesDir, ".archive-installing");
            DurableArchiveStateStore forAndroid = DurableArchiveStateStore.Companion.forAndroid(new File(context.getNoBackupFilesDir(), "archive-updater"));
            FileArchiveDownloadResumeStore forAndroid2 = FileArchiveDownloadResumeStore.Companion.forAndroid();
            AndroidArchiveNetworkMonitor androidArchiveNetworkMonitor = new AndroidArchiveNetworkMonitor(context);
            OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource = new OkHttpArchiveByteRangeSource(new DownloadRetryPolicy(new DownloadRetryConfig(z, 0, 0L, 0L, 14, null), null, 2, null), androidArchiveNetworkMonitor, null, null, false, 12, null);
            FileArchiveDownloadResumeStore fileArchiveDownloadResumeStore = forAndroid2;
            ArchivePackageDownloader archivePackageDownloader = new ArchivePackageDownloader(new DownloadRetryPolicy(new DownloadRetryConfig(z, 0, 0L, 0L, 14, null), null, 2, null), androidArchiveNetworkMonitor, 0L, null, false, fileArchiveDownloadResumeStore, null, 0L, AndroidArchiveDirectoryCreator.INSTANCE, ComposerKt.providerMapsKey, null);
            ArchivePackageCommitter archivePackageCommitter = new ArchivePackageCommitter(externalFilesDir, file2, null, null, AndroidArchiveDirectoryCreator.INSTANCE, 12, null);
            final SafeZipLimits safeZipLimits = new SafeZipLimits(0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 15, null);
            archiveRetirementClient = ArchivePackageUpdaterKt.archiveRetirementClient(externalFilesDir);
            return new ArchivePackageUpdater(externalFilesDir, file, file2, forAndroid, new ArchivePackageUpdater$Companion$create$1(archivePackageDownloader), new ArchivePackageUpdater$Companion$create$2(WholeFileCrc32Verifier.INSTANCE), new ArchiveExtractor() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$Companion$$ExternalSyntheticLambda0
                @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveExtractor
                public final SafeZipExtractionResult extract(File file3, File file4, long j) {
                    return ArchivePackageUpdater.Companion.create$lambda$0(SafeZipLimits.this, file3, file4, j);
                }
            }, new ArchivePackageUpdater$Companion$create$4(archivePackageCommitter), archiveRetirementClient, null, false, new AndroidArchiveRuntimeCapacityPolicy(externalFilesDir, file), new AndroidArchiveDownloadAheadPolicy(externalFilesDir, file), null, fileArchiveDownloadResumeStore, null, okHttpArchiveByteRangeSource, okHttpArchiveByteRangeSource.asStreamer(), ArchiveLivePathSafety.Companion.forAndroid(), AndroidArchiveDirectoryCreator.INSTANCE, 41472, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final SafeZipExtractionResult create$lambda$0(SafeZipLimits safeZipLimits, File archive, File stagingRoot, long j) {
            Intrinsics.checkNotNullParameter(archive, "archive");
            Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
            return new SafeZipExtractor(SafeZipLimits.copy$default(safeZipLimits, 0, Math.min(safeZipLimits.getMaxEntryUncompressedBytes(), j), j, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 9, null), null, AndroidArchiveDirectoryCreator.INSTANCE, 2, null).extract(archive, stagingRoot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadAheadSlot;", "", "packageId", "", "result", "Lkotlinx/coroutines/Deferred;", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "networkPhaseRelay", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadNetworkPhaseRelay;", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/Deferred;Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadNetworkPhaseRelay;)V", "getPackageId", "()Ljava/lang/String;", "getResult", "()Lkotlinx/coroutines/Deferred;", "getNetworkPhaseRelay", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadNetworkPhaseRelay;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DownloadAheadSlot {
        private final DownloadNetworkPhaseRelay networkPhaseRelay;
        private final String packageId;
        private final Deferred<ArchivePackageDownloadResult> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DownloadAheadSlot copy$default(DownloadAheadSlot downloadAheadSlot, String str, Deferred deferred, DownloadNetworkPhaseRelay downloadNetworkPhaseRelay, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadAheadSlot.packageId;
            }
            if ((i & 2) != 0) {
                deferred = downloadAheadSlot.result;
            }
            if ((i & 4) != 0) {
                downloadNetworkPhaseRelay = downloadAheadSlot.networkPhaseRelay;
            }
            return downloadAheadSlot.copy(str, deferred, downloadNetworkPhaseRelay);
        }

        public final String component1() {
            return this.packageId;
        }

        public final Deferred<ArchivePackageDownloadResult> component2() {
            return this.result;
        }

        public final DownloadNetworkPhaseRelay component3() {
            return this.networkPhaseRelay;
        }

        public final DownloadAheadSlot copy(String packageId, Deferred<? extends ArchivePackageDownloadResult> result, DownloadNetworkPhaseRelay networkPhaseRelay) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(networkPhaseRelay, "networkPhaseRelay");
            return new DownloadAheadSlot(packageId, result, networkPhaseRelay);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadAheadSlot) {
                DownloadAheadSlot downloadAheadSlot = (DownloadAheadSlot) obj;
                return Intrinsics.areEqual(this.packageId, downloadAheadSlot.packageId) && Intrinsics.areEqual(this.result, downloadAheadSlot.result) && Intrinsics.areEqual(this.networkPhaseRelay, downloadAheadSlot.networkPhaseRelay);
            }
            return false;
        }

        public int hashCode() {
            return (((this.packageId.hashCode() * 31) + this.result.hashCode()) * 31) + this.networkPhaseRelay.hashCode();
        }

        public String toString() {
            String str = this.packageId;
            Deferred<ArchivePackageDownloadResult> deferred = this.result;
            return "DownloadAheadSlot(packageId=" + str + ", result=" + deferred + ", networkPhaseRelay=" + this.networkPhaseRelay + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DownloadAheadSlot(String packageId, Deferred<? extends ArchivePackageDownloadResult> result, DownloadNetworkPhaseRelay networkPhaseRelay) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(networkPhaseRelay, "networkPhaseRelay");
            this.packageId = packageId;
            this.result = result;
            this.networkPhaseRelay = networkPhaseRelay;
        }

        public final String getPackageId() {
            return this.packageId;
        }

        public final Deferred<ArchivePackageDownloadResult> getResult() {
            return this.result;
        }

        public final DownloadNetworkPhaseRelay getNetworkPhaseRelay() {
            return this.networkPhaseRelay;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$StoragePressureCleanup;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "detail", "", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Ljava/lang/String;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class StoragePressureCleanup {
        private final String detail;
        private final ArchiveUpdaterState state;

        public static /* synthetic */ StoragePressureCleanup copy$default(StoragePressureCleanup storagePressureCleanup, ArchiveUpdaterState archiveUpdaterState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdaterState = storagePressureCleanup.state;
            }
            if ((i & 2) != 0) {
                str = storagePressureCleanup.detail;
            }
            return storagePressureCleanup.copy(archiveUpdaterState, str);
        }

        public final ArchiveUpdaterState component1() {
            return this.state;
        }

        public final String component2() {
            return this.detail;
        }

        public final StoragePressureCleanup copy(ArchiveUpdaterState state, String str) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new StoragePressureCleanup(state, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StoragePressureCleanup) {
                StoragePressureCleanup storagePressureCleanup = (StoragePressureCleanup) obj;
                return Intrinsics.areEqual(this.state, storagePressureCleanup.state) && Intrinsics.areEqual(this.detail, storagePressureCleanup.detail);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.state.hashCode() * 31;
            String str = this.detail;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            ArchiveUpdaterState archiveUpdaterState = this.state;
            return "StoragePressureCleanup(state=" + archiveUpdaterState + ", detail=" + this.detail + ")";
        }

        public StoragePressureCleanup(ArchiveUpdaterState state, String str) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.detail = str;
        }

        public /* synthetic */ StoragePressureCleanup(ArchiveUpdaterState archiveUpdaterState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdaterState, (i & 2) != 0 ? null : str);
        }

        public final ArchiveUpdaterState getState() {
            return this.state;
        }

        public final String getDetail() {
            return this.detail;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$CommittedArtifacts;", "", "archiveFile", "Ljava/io/File;", "stagingRoot", "<init>", "(Ljava/io/File;Ljava/io/File;)V", "getArchiveFile", "()Ljava/io/File;", "getStagingRoot", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CommittedArtifacts {
        private final File archiveFile;
        private final File stagingRoot;

        public static /* synthetic */ CommittedArtifacts copy$default(CommittedArtifacts committedArtifacts, File file, File file2, int i, Object obj) {
            if ((i & 1) != 0) {
                file = committedArtifacts.archiveFile;
            }
            if ((i & 2) != 0) {
                file2 = committedArtifacts.stagingRoot;
            }
            return committedArtifacts.copy(file, file2);
        }

        public final File component1() {
            return this.archiveFile;
        }

        public final File component2() {
            return this.stagingRoot;
        }

        public final CommittedArtifacts copy(File archiveFile, File stagingRoot) {
            Intrinsics.checkNotNullParameter(archiveFile, "archiveFile");
            Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
            return new CommittedArtifacts(archiveFile, stagingRoot);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommittedArtifacts) {
                CommittedArtifacts committedArtifacts = (CommittedArtifacts) obj;
                return Intrinsics.areEqual(this.archiveFile, committedArtifacts.archiveFile) && Intrinsics.areEqual(this.stagingRoot, committedArtifacts.stagingRoot);
            }
            return false;
        }

        public int hashCode() {
            return (this.archiveFile.hashCode() * 31) + this.stagingRoot.hashCode();
        }

        public String toString() {
            File file = this.archiveFile;
            return "CommittedArtifacts(archiveFile=" + file + ", stagingRoot=" + this.stagingRoot + ")";
        }

        public CommittedArtifacts(File archiveFile, File stagingRoot) {
            Intrinsics.checkNotNullParameter(archiveFile, "archiveFile");
            Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
            this.archiveFile = archiveFile;
            this.stagingRoot = stagingRoot;
        }

        public final File getArchiveFile() {
            return this.archiveFile;
        }

        public final File getStagingRoot() {
            return this.stagingRoot;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUpdater$DownloadNetworkPhaseRelay;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", "reportingEnabled", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;Z)V", "waitingForNetwork", "onProgress", "", "packageId", "", "onWaitingForNetwork", "promote", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DownloadNetworkPhaseRelay {
        private final ArchiveUpdaterListener listener;
        private boolean reportingEnabled;
        private boolean waitingForNetwork;

        public DownloadNetworkPhaseRelay(ArchiveUpdaterListener listener, boolean z) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            this.reportingEnabled = z;
        }

        public /* synthetic */ DownloadNetworkPhaseRelay(ArchiveUpdaterListener archiveUpdaterListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdaterListener, (i & 2) != 0 ? true : z);
        }

        public final synchronized void onProgress(String packageId) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            if (this.waitingForNetwork) {
                this.waitingForNetwork = false;
                if (this.reportingEnabled) {
                    this.listener.onPhase(ArchiveInstallerPhase.DOWNLOADING, packageId);
                }
            }
        }

        public final synchronized void onWaitingForNetwork(String packageId) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            this.waitingForNetwork = true;
            if (this.reportingEnabled) {
                this.listener.onPhase(ArchiveInstallerPhase.WAITING_FOR_NETWORK, packageId);
            }
        }

        public final synchronized void promote(String packageId) {
            ArchiveInstallerPhase archiveInstallerPhase;
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            this.reportingEnabled = true;
            ArchiveUpdaterListener archiveUpdaterListener = this.listener;
            if (this.waitingForNetwork) {
                archiveInstallerPhase = ArchiveInstallerPhase.WAITING_FOR_NETWORK;
            } else {
                archiveInstallerPhase = ArchiveInstallerPhase.DOWNLOADING;
            }
            archiveUpdaterListener.onPhase(archiveInstallerPhase, packageId);
        }
    }
}

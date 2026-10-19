package com.arizona.launcher.updater.archive.orchestrator;

import coil3.disk.DiskLruCache;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.adoption.AdoptedArchivePackage;
import com.arizona.launcher.updater.archive.adoption.ArchiveInstallAdopter;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveLocalState;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestCandidate;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolutionResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckRemoteStage;
import com.arizona.launcher.updater.archive.planner.ArchivePlanReason;
import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlanner;
import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveStateValidation;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiff;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiffPlanner;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 _2\u00020\u0001:\u0004\\]^_B\u0089\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJH\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020#H\u0086@¢\u0006\u0002\u0010'JH\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010*\u001a\u00020#H\u0086@¢\u0006\u0002\u0010'J*\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020#H\u0086@¢\u0006\u0002\u0010.J8\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010!\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0002J&\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00160:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0012H\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010=\u001a\u000206H\u0002J\u0018\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0018\u0010D\u001a\u0002062\u0006\u0010C\u001a\u0002062\u0006\u0010,\u001a\u00020\u0012H\u0002J8\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020F0:2\u0006\u0010C\u001a\u0002062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001e0H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0JH\u0002J,\u0010K\u001a\b\u0012\u0004\u0012\u00020L0J2\u0006\u0010C\u001a\u0002062\u0006\u0010,\u001a\u00020\u00122\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0JH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010F2\u0006\u0010N\u001a\u00020OH\u0002J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010C\u001a\u000206H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010=\u001a\u000206H\u0002J\"\u0010U\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u0001062\u0006\u0010V\u001a\u00020#H\u0002J\u0010\u0010W\u001a\u00020#2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010X\u001a\u00020#2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010Y\u001a\u00020#2\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010Z\u001a\u00020#2\u0006\u0010=\u001a\u0002062\u0006\u0010,\u001a\u00020\u0012H\u0002J\u001e\u0010[\u001a\b\u0012\u0004\u0012\u00020L0Q2\u0006\u0010C\u001a\u0002062\u0006\u0010,\u001a\u00020\u0012H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\ba\u0012\b\bb\u0012\u0004\b\u0003\u0010\u0000¨\u0006`"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;", "", "gameRoot", "Ljava/io/File;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "installAdopter", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;", "artifactCleaner", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "downloadRoot", "workRoot", "candidateParser", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;", "manifestResolver", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "validateRemoteManifest", "Lkotlin/Function1;", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "nowEpochMs", "Lkotlin/Function0;", "", "selectiveDownloadEstimator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator;", "<init>", "(Ljava/io/File;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;Ljava/io/File;Ljava/io/File;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator;)V", "prepare", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "serverBaseUrl", "allowCleanBootstrap", "", "bootstrapPrefetcher", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;", "metadataAuditValidatedForFinalization", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/lang/String;ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRemoteCheck", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage;", "reuseLocalJournalIndex", "finishRemoteCheck", "remote", "disallowExistingAdoption", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveWithBootstrapPrefetch", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionResult;", "candidate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "descriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "loadedState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bootstrapDownloadBytes", "plannedSelectiveDownloadBytes", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "adoptExistingInstall", "root", "manifest", "isSafePreCommitRepairState", "rebasePreCommitRepairState", UpdateServiceContract.BundleKey.CURRENT, "recoverIncompleteTransactionByCrc", "filteredRecoveryBaselines", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator$LivePackageBaseline;", "remotePackageIds", "", "adoptedPackageIds", "", "crcRecoveryPreservedArchiveIdentities", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "recoveryBaseline", "entry", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "possibleLiveOwnership", "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "persistRecoveryState", "", "promoteRebasedIncompleteBootstrapPlan", "includeCrcAdoptedPackages", "isPromotableNonCommittedEntry", "hasValidLiveBaseline", "isGenuinelyNewPlannedPackage", "hasNewOrRemovedPackageEvidence", "supersededRepairIdentities", "ArchiveBootstrapPrefetchCleanupException", "ArchiveSupersededArtifactCleanupException", "LivePackageBaseline", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator {
    private final ArchivePackageArtifactCleaner artifactCleaner;
    private final ArchiveManifestCandidateParser candidateParser;
    private final File downloadRoot;
    private final File gameRoot;
    private final ArchiveInstallAdopter installAdopter;
    private final ArchiveManifestResolver manifestResolver;
    private final Function0<Long> nowEpochMs;
    private final ArchiveSelectiveDownloadEstimator selectiveDownloadEstimator;
    private final DurableArchiveStateStore stateStore;
    private final Function1<ArchiveManifest, ArchiveUpdateCheckDecision.Block> validateRemoteManifest;
    private final File workRoot;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<ArchivePackagePhase> SAFE_REPAIR_REBASE_PHASES = SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.PLANNED, ArchivePackagePhase.DOWNLOADING, ArchivePackagePhase.DOWNLOADED, ArchivePackagePhase.VERIFYING, ArchivePackagePhase.VERIFIED, ArchivePackagePhase.EXTRACTING, ArchivePackagePhase.EXTRACTED});

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ArchiveManifestResolutionErrorCode.values().length];
            try {
                iArr[ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArchiveFlowSelection.values().length];
            try {
                iArr2[ArchiveFlowSelection.BLOCK_CORRUPT_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ArchiveFlowSelection.BLOCK_ARCHIVE_MANIFEST_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ArchiveFlowSelection.USE_ARCHIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ArchivePackagePhase.values().length];
            try {
                iArr3[ArchivePackagePhase.COMMITTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ArchivePackagePhase.COMMITTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ArchiveUpdateCheckDecision.Block _init_$lambda$1(ArchiveManifest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore stateStore, ArchiveInstallAdopter installAdopter, ArchivePackageArtifactCleaner artifactCleaner, File file2, File file3, ArchiveManifestCandidateParser candidateParser, ArchiveManifestResolver manifestResolver, Function1<? super ArchiveManifest, ArchiveUpdateCheckDecision.Block> validateRemoteManifest, Function0<Long> nowEpochMs, ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator) {
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(installAdopter, "installAdopter");
        Intrinsics.checkNotNullParameter(artifactCleaner, "artifactCleaner");
        Intrinsics.checkNotNullParameter(candidateParser, "candidateParser");
        Intrinsics.checkNotNullParameter(manifestResolver, "manifestResolver");
        Intrinsics.checkNotNullParameter(validateRemoteManifest, "validateRemoteManifest");
        Intrinsics.checkNotNullParameter(nowEpochMs, "nowEpochMs");
        this.gameRoot = file;
        this.stateStore = stateStore;
        this.installAdopter = installAdopter;
        this.artifactCleaner = artifactCleaner;
        this.downloadRoot = file2;
        this.workRoot = file3;
        this.candidateParser = candidateParser;
        this.manifestResolver = manifestResolver;
        this.validateRemoteManifest = validateRemoteManifest;
        this.nowEpochMs = nowEpochMs;
        this.selectiveDownloadEstimator = archiveSelectiveDownloadEstimator;
    }

    public /* synthetic */ ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore durableArchiveStateStore, ArchiveInstallAdopter archiveInstallAdopter, ArchivePackageArtifactCleaner archivePackageArtifactCleaner, File file2, File file3, ArchiveManifestCandidateParser archiveManifestCandidateParser, ArchiveManifestResolver archiveManifestResolver, Function1 function1, Function0 function0, ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        File file4;
        ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator2;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator;
        DurableArchiveStateStore durableArchiveStateStore2;
        ArchiveInstallAdopter archiveInstallAdopter2;
        ArchivePackageArtifactCleaner archivePackageArtifactCleaner2;
        File file5 = (i & 16) != 0 ? null : file2;
        if ((i & 32) != 0) {
            file4 = file != null ? new File(file, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY) : null;
        } else {
            file4 = file3;
        }
        ArchiveManifestCandidateParser archiveManifestCandidateParser2 = (i & 64) != 0 ? new ArchiveManifestCandidateParser(null, null, 3, null) : archiveManifestCandidateParser;
        ArchiveManifestResolver archiveManifestResolver2 = (i & 128) != 0 ? new ArchiveManifestResolver(null, 0, 0L, 7, null) : archiveManifestResolver;
        Function1 function12 = (i & 256) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchiveUpdateCheckCoordinator._init_$lambda$1((ArchiveManifest) obj);
            }
        } : function1;
        AnonymousClass3 anonymousClass3 = (i & 512) != 0 ? AnonymousClass3.INSTANCE : function0;
        if ((i & 1024) != 0) {
            archiveSelectiveDownloadEstimator2 = null;
            archiveUpdateCheckCoordinator = this;
            durableArchiveStateStore2 = durableArchiveStateStore;
            archivePackageArtifactCleaner2 = archivePackageArtifactCleaner;
            archiveInstallAdopter2 = archiveInstallAdopter;
        } else {
            archiveSelectiveDownloadEstimator2 = archiveSelectiveDownloadEstimator;
            archiveUpdateCheckCoordinator = this;
            durableArchiveStateStore2 = durableArchiveStateStore;
            archiveInstallAdopter2 = archiveInstallAdopter;
            archivePackageArtifactCleaner2 = archivePackageArtifactCleaner;
        }
        new ArchiveUpdateCheckCoordinator(file, durableArchiveStateStore2, archiveInstallAdopter2, archivePackageArtifactCleaner2, file5, file4, archiveManifestCandidateParser2, archiveManifestResolver2, function12, anonymousClass3, archiveSelectiveDownloadEstimator2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, boolean z2, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$1;
        int i;
        Object resolveRemoteCheck$default;
        ArchiveGpu archiveGpu2;
        String str3;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2;
        boolean z3;
        boolean z4;
        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage;
        if (continuation instanceof ArchiveUpdateCheckCoordinator$prepare$1) {
            archiveUpdateCheckCoordinator$prepare$1 = (ArchiveUpdateCheckCoordinator$prepare$1) continuation;
            if ((archiveUpdateCheckCoordinator$prepare$1.label & Integer.MIN_VALUE) != 0) {
                archiveUpdateCheckCoordinator$prepare$1.label -= Integer.MIN_VALUE;
                ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$12 = archiveUpdateCheckCoordinator$prepare$1;
                Object obj = archiveUpdateCheckCoordinator$prepare$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveUpdateCheckCoordinator$prepare$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    archiveUpdateCheckCoordinator$prepare$12.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    archiveUpdateCheckCoordinator$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu);
                    archiveUpdateCheckCoordinator$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    archiveUpdateCheckCoordinator$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                    archiveUpdateCheckCoordinator$prepare$12.Z$0 = z;
                    archiveUpdateCheckCoordinator$prepare$12.Z$1 = z2;
                    archiveUpdateCheckCoordinator$prepare$12.label = 1;
                    resolveRemoteCheck$default = resolveRemoteCheck$default(this, str, archiveGpu, str2, z, archiveBootstrapPrefetcher, false, archiveUpdateCheckCoordinator$prepare$12, 32, null);
                    if (resolveRemoteCheck$default != coroutine_suspended) {
                        archiveGpu2 = archiveGpu;
                        str3 = str2;
                        archiveBootstrapPrefetcher2 = archiveBootstrapPrefetcher;
                        z3 = z2;
                        z4 = z;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        boolean z5 = archiveUpdateCheckCoordinator$prepare$12.Z$1;
                        boolean z6 = archiveUpdateCheckCoordinator$prepare$12.Z$0;
                        ArchiveUpdateCheckRemoteStage archiveUpdateCheckRemoteStage2 = (ArchiveUpdateCheckRemoteStage) archiveUpdateCheckCoordinator$prepare$12.L$4;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher3 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$prepare$12.L$3;
                        String str4 = (String) archiveUpdateCheckCoordinator$prepare$12.L$2;
                        ArchiveGpu archiveGpu3 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$12.L$1;
                        String str5 = (String) archiveUpdateCheckCoordinator$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    boolean z7 = archiveUpdateCheckCoordinator$prepare$12.Z$1;
                    boolean z8 = archiveUpdateCheckCoordinator$prepare$12.Z$0;
                    archiveBootstrapPrefetcher2 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$prepare$12.L$3;
                    str3 = (String) archiveUpdateCheckCoordinator$prepare$12.L$2;
                    archiveGpu2 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$12.L$1;
                    String str6 = (String) archiveUpdateCheckCoordinator$prepare$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    z3 = z7;
                    str = str6;
                    resolveRemoteCheck$default = obj;
                    z4 = z8;
                }
                archiveUpdateCheckRemoteStage = (ArchiveUpdateCheckRemoteStage) resolveRemoteCheck$default;
                if (archiveUpdateCheckRemoteStage instanceof ArchiveUpdateCheckRemoteStage.Completed) {
                    if (!(archiveUpdateCheckRemoteStage instanceof ArchiveUpdateCheckRemoteStage.Resolved)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ArchiveUpdateCheckRemoteStage.Resolved resolved = (ArchiveUpdateCheckRemoteStage.Resolved) archiveUpdateCheckRemoteStage;
                    ArchiveUpdateCheckDecision.Block invoke = this.validateRemoteManifest.invoke(resolved.getRemote());
                    if (invoke != null) {
                        return invoke;
                    }
                    ArchiveManifest remote = resolved.getRemote();
                    archiveUpdateCheckCoordinator$prepare$12.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    archiveUpdateCheckCoordinator$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu2);
                    archiveUpdateCheckCoordinator$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                    archiveUpdateCheckCoordinator$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher2);
                    archiveUpdateCheckCoordinator$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(archiveUpdateCheckRemoteStage);
                    archiveUpdateCheckCoordinator$prepare$12.Z$0 = z4;
                    archiveUpdateCheckCoordinator$prepare$12.Z$1 = z3;
                    archiveUpdateCheckCoordinator$prepare$12.label = 2;
                    Object finishRemoteCheck$default = finishRemoteCheck$default(this, remote, z3, false, archiveUpdateCheckCoordinator$prepare$12, 4, null);
                    return finishRemoteCheck$default == coroutine_suspended ? coroutine_suspended : finishRemoteCheck$default;
                }
                return ((ArchiveUpdateCheckRemoteStage.Completed) archiveUpdateCheckRemoteStage).getDecision();
            }
        }
        archiveUpdateCheckCoordinator$prepare$1 = new ArchiveUpdateCheckCoordinator$prepare$1(this, continuation);
        ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$122 = archiveUpdateCheckCoordinator$prepare$1;
        Object obj2 = archiveUpdateCheckCoordinator$prepare$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateCheckCoordinator$prepare$122.label;
        if (i != 0) {
        }
        archiveUpdateCheckRemoteStage = (ArchiveUpdateCheckRemoteStage) resolveRemoteCheck$default;
        if (archiveUpdateCheckRemoteStage instanceof ArchiveUpdateCheckRemoteStage.Completed) {
        }
    }

    public static /* synthetic */ Object prepare$default(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, boolean z2, Continuation continuation, int i, Object obj) {
        boolean z3;
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator2;
        String str3;
        ArchiveGpu archiveGpu2;
        Continuation continuation2;
        if ((i & 4) != 0) {
            str2 = "https://invalid.local/";
        }
        String str4 = str2;
        boolean z4 = (i & 8) != 0 ? false : z;
        if ((i & 16) != 0) {
            archiveBootstrapPrefetcher = null;
        }
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2 = archiveBootstrapPrefetcher;
        if ((i & 32) != 0) {
            z3 = false;
            str3 = str;
            archiveGpu2 = archiveGpu;
            continuation2 = continuation;
            archiveUpdateCheckCoordinator2 = archiveUpdateCheckCoordinator;
        } else {
            z3 = z2;
            archiveUpdateCheckCoordinator2 = archiveUpdateCheckCoordinator;
            str3 = str;
            archiveGpu2 = archiveGpu;
            continuation2 = continuation;
        }
        return archiveUpdateCheckCoordinator2.prepare(str3, archiveGpu2, str4, z4, archiveBootstrapPrefetcher2, z3, continuation2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ba, code lost:
        if (r3 == r7) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveRemoteCheck(String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, boolean z2, Continuation<? super ArchiveUpdateCheckRemoteStage> continuation) {
        ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1 archiveUpdateCheckCoordinator$resolveRemoteCheck$1;
        int i;
        ArchiveManifestResolutionResult archiveManifestResolutionResult;
        ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode;
        try {
            if (continuation instanceof ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1) {
                archiveUpdateCheckCoordinator$resolveRemoteCheck$1 = (ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1) continuation;
                if ((archiveUpdateCheckCoordinator$resolveRemoteCheck$1.label & Integer.MIN_VALUE) != 0) {
                    archiveUpdateCheckCoordinator$resolveRemoteCheck$1.label -= Integer.MIN_VALUE;
                    ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1 archiveUpdateCheckCoordinator$resolveRemoteCheck$12 = archiveUpdateCheckCoordinator$resolveRemoteCheck$1;
                    Object obj = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            ArchiveStateLoadResult load = this.stateStore.load();
                            try {
                                ArchiveManifestCandidate parse = this.candidateParser.parse(str, archiveGpu);
                                int i2 = WhenMappings.$EnumSwitchMapping$1[ArchiveFlowSelector.INSTANCE.select(true, load).ordinal()];
                                if (i2 == 1) {
                                    ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode2 = ArchiveUpdateCheckBlockCode.STATE_CORRUPT;
                                    ArchiveStateLoadResult.Corrupt corrupt = load instanceof ArchiveStateLoadResult.Corrupt ? (ArchiveStateLoadResult.Corrupt) load : null;
                                    return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode2, corrupt != null ? corrupt.getReason() : null));
                                } else if (i2 == 2) {
                                    return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_REQUIRED, "archive-only delivery requires an archive manifest on every mirror"));
                                } else {
                                    if (i2 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    if (this.gameRoot == null) {
                                        return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.GAME_ROOT_UNAVAILABLE, null, 2, null));
                                    }
                                    ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
                                    ArchiveUpdaterState state = loaded != null ? loaded.getState() : null;
                                    ArchiveManifestCandidate.OriginalTz originalTz = parse instanceof ArchiveManifestCandidate.OriginalTz ? (ArchiveManifestCandidate.OriginalTz) parse : null;
                                    OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor = (originalTz == null || (originalTzArchiveManifestDescriptor = originalTz.getDescriptor()) == null || !(load instanceof ArchiveStateLoadResult.Missing) || !LegacyGameTreeProbe.INSTANCE.isEmptyForArchiveBootstrap(this.gameRoot)) ? null : null;
                                    if (z && z2 && originalTzArchiveManifestDescriptor != null) {
                                        return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Bootstrap(new ArchiveBootstrapPending(bootstrapDownloadBytes(originalTzArchiveManifestDescriptor))));
                                    }
                                    ArchiveUpdaterState archiveUpdaterState = z2 ? state : null;
                                    if (z2 && originalTzArchiveManifestDescriptor != null && archiveBootstrapPrefetcher != null) {
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$4 = SpillingKt.nullOutSpilledVariable(load);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$5 = SpillingKt.nullOutSpilledVariable(parse);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$6 = SpillingKt.nullOutSpilledVariable(state);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$7 = SpillingKt.nullOutSpilledVariable(originalTzArchiveManifestDescriptor);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$0 = z;
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$1 = z2;
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.label = 1;
                                        obj = resolveWithBootstrapPrefetch(parse, originalTzArchiveManifestDescriptor, str2, archiveUpdaterState, archiveBootstrapPrefetcher, archiveUpdateCheckCoordinator$resolveRemoteCheck$12);
                                        if (obj == coroutine_suspended) {
                                        }
                                        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                                    } else {
                                        ArchiveManifestResolver archiveManifestResolver = this.manifestResolver;
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$4 = SpillingKt.nullOutSpilledVariable(load);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$5 = SpillingKt.nullOutSpilledVariable(parse);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$6 = SpillingKt.nullOutSpilledVariable(state);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$7 = SpillingKt.nullOutSpilledVariable(originalTzArchiveManifestDescriptor);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$0 = z;
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$1 = z2;
                                        archiveUpdateCheckCoordinator$resolveRemoteCheck$12.label = 2;
                                        obj = archiveManifestResolver.resolve(parse, str2, archiveUpdaterState, archiveUpdateCheckCoordinator$resolveRemoteCheck$12);
                                    }
                                    return coroutine_suspended;
                                }
                            } catch (IllegalArgumentException e) {
                                return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_INVALID, e.getMessage()));
                            }
                        } catch (Exception e2) {
                            return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e2.getMessage()));
                        }
                    } else if (i == 1) {
                        boolean z3 = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$1;
                        boolean z4 = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$0;
                        ArchiveUpdaterState archiveUpdaterState2 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$8;
                        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor2 = (OriginalTzArchiveManifestDescriptor) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$7;
                        ArchiveUpdaterState archiveUpdaterState3 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$6;
                        ArchiveManifestCandidate archiveManifestCandidate = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$5;
                        ArchiveStateLoadResult archiveStateLoadResult = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$4;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$3;
                        String str3 = (String) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$2;
                        ArchiveGpu archiveGpu2 = (ArchiveGpu) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$1;
                        String str4 = (String) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        boolean z5 = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$1;
                        boolean z6 = archiveUpdateCheckCoordinator$resolveRemoteCheck$12.Z$0;
                        ArchiveUpdaterState archiveUpdaterState4 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$8;
                        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor3 = (OriginalTzArchiveManifestDescriptor) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$7;
                        ArchiveUpdaterState archiveUpdaterState5 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$6;
                        ArchiveManifestCandidate archiveManifestCandidate2 = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$5;
                        ArchiveStateLoadResult archiveStateLoadResult2 = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$4;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher3 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$3;
                        String str5 = (String) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$2;
                        ArchiveGpu archiveGpu3 = (ArchiveGpu) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$1;
                        String str6 = (String) archiveUpdateCheckCoordinator$resolveRemoteCheck$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                    }
                    if (archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success) {
                        if (!(archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Failure)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ArchiveManifestResolutionResult.Failure failure = (ArchiveManifestResolutionResult.Failure) archiveManifestResolutionResult;
                        int i3 = WhenMappings.$EnumSwitchMapping$0[failure.getCode().ordinal()];
                        if (i3 == 1) {
                            archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.ARCHIVE_INDEX_UNAVAILABLE;
                        } else if (i3 == 2) {
                            archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.ARCHIVE_REPRESENTATION_CHANGED;
                        } else if (i3 != 3 && i3 != 4) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_INVALID;
                        }
                        return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{failure.getPackageId(), failure.getDetail()}), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null)));
                    }
                    ArchiveManifest manifest = ((ArchiveManifestResolutionResult.Success) archiveManifestResolutionResult).getManifest();
                    List<ArchivePackage> packages = manifest.getPackages();
                    if (!(packages instanceof Collection) || !packages.isEmpty()) {
                        for (ArchivePackage archivePackage : packages) {
                            if (archivePackage.getEntries() == null) {
                                return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_ENTRY_METADATA_REQUIRED, "archive-only delivery requires the complete ZIP entry inventory"));
                            }
                        }
                    }
                    return new ArchiveUpdateCheckRemoteStage.Resolved(manifest);
                }
            }
            if (i != 0) {
            }
            if (archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success) {
            }
        } catch (ArchiveBootstrapPrefetchCleanupException e3) {
            return new ArchiveUpdateCheckRemoteStage.Completed(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e3.getMessage()));
        }
        archiveUpdateCheckCoordinator$resolveRemoteCheck$1 = new ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1(this, continuation);
        ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1 archiveUpdateCheckCoordinator$resolveRemoteCheck$122 = archiveUpdateCheckCoordinator$resolveRemoteCheck$1;
        Object obj2 = archiveUpdateCheckCoordinator$resolveRemoteCheck$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateCheckCoordinator$resolveRemoteCheck$122.label;
    }

    public static /* synthetic */ Object resolveRemoteCheck$default(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "https://invalid.local/";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            archiveBootstrapPrefetcher = null;
        }
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2 = archiveBootstrapPrefetcher;
        if ((i & 32) != 0) {
            z2 = true;
        }
        return archiveUpdateCheckCoordinator.resolveRemoteCheck(str, archiveGpu, str3, z3, archiveBootstrapPrefetcher2, z2, continuation);
    }

    public static /* synthetic */ Object finishRemoteCheck$default(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, ArchiveManifest archiveManifest, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return archiveUpdateCheckCoordinator.finishRemoteCheck(archiveManifest, z, z2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object finishRemoteCheck(ArchiveManifest archiveManifest, boolean z, boolean z2, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        ArchiveUpdaterState state;
        boolean z3;
        ArchiveUpdaterState archiveUpdaterState;
        ArchiveLocalState plannerState;
        File file;
        boolean z4;
        boolean z5;
        List<String> list = null;
        if (this.gameRoot == null) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.GAME_ROOT_UNAVAILABLE, null, 2, null);
        }
        try {
            ArchiveStateLoadResult load = this.stateStore.load();
            if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
                state = null;
            } else if (!(load instanceof ArchiveStateLoadResult.Loaded)) {
                if (!(load instanceof ArchiveStateLoadResult.Corrupt)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, ((ArchiveStateLoadResult.Corrupt) load).getReason());
            } else {
                state = ((ArchiveStateLoadResult.Loaded) load).getState();
            }
            if (state != null) {
                try {
                    ArchivePackageArtifactCleaner archivePackageArtifactCleaner = this.artifactCleaner;
                    File file2 = this.gameRoot;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : state.getPackages()) {
                        if (((ArchivePackageJournalEntry) obj).getPhase() == ArchivePackagePhase.COMMITTING) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<ArchivePackageJournalEntry> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList2) {
                        arrayList3.add(archivePackageJournalEntry.getPackageId());
                    }
                    ArrayList arrayList4 = arrayList3;
                    File file3 = this.workRoot;
                    if (file3 == null) {
                        file3 = new File(this.gameRoot, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY);
                    }
                    archivePackageArtifactCleaner.cleanupAbandonedCommitBackups(file2, arrayList4, file3);
                } catch (Exception e) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to clean abandoned archive commit backup: " + e.getMessage());
                }
            }
            boolean z6 = true;
            if (state == null || state.isInstallReady() || ArchiveStateAdapter.INSTANCE.identitiesMatch(state, archiveManifest)) {
                z3 = false;
            } else {
                try {
                    if (isSafePreCommitRepairState(state)) {
                        ArchiveUpdaterState rebasePreCommitRepairState = rebasePreCommitRepairState(state, archiveManifest);
                        try {
                            ArchivePackageArtifactCleaner archivePackageArtifactCleaner2 = this.artifactCleaner;
                            File file4 = this.gameRoot;
                            File file5 = this.downloadRoot;
                            List<ArchivePackageIdentity> supersededRepairIdentities = supersededRepairIdentities(state, archiveManifest);
                            File file6 = this.workRoot;
                            if (file6 == null) {
                                file6 = new File(this.gameRoot, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY);
                            }
                            ArchivePackageArtifactCleaner.cleanup$default(archivePackageArtifactCleaner2, file4, file5, supersededRepairIdentities, file6, null, 16, null);
                            persistRecoveryState(rebasePreCommitRepairState);
                            state = rebasePreCommitRepairState;
                            z5 = false;
                        } catch (Exception e2) {
                            throw new ArchiveSupersededArtifactCleanupException(e2);
                        }
                    } else {
                        state = recoverIncompleteTransactionByCrc(state, archiveManifest);
                        z5 = true;
                    }
                    z3 = z5;
                } catch (ArchiveSupersededArtifactCleanupException e3) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e3.getMessage());
                } catch (ArchiveOwnershipException e4) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e4.getMessage());
                } catch (IllegalStateException e5) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e5.getMessage());
                } catch (Exception e6) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to recover changed archive transaction: " + e6.getMessage());
                }
            }
            if (state == null) {
                if (!z2) {
                    try {
                        if (!LegacyGameTreeProbe.INSTANCE.isEmptyForArchiveBootstrap(this.gameRoot)) {
                            state = adoptExistingInstall(this.gameRoot, archiveManifest);
                        }
                    } catch (Exception e7) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to persist archive adoption state: " + e7.getMessage());
                    }
                }
                archiveUpdaterState = null;
                if (archiveUpdaterState == null) {
                    try {
                        plannerState = ArchiveStateAdapter.INSTANCE.toPlannerState(archiveUpdaterState);
                    } catch (IllegalStateException e8) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e8.getMessage());
                    }
                } else {
                    plannerState = null;
                }
                if (archiveUpdaterState != null) {
                    try {
                        list = ArchiveStateAdapter.INSTANCE.sameIdentityRepairPackageIds(archiveUpdaterState);
                    } catch (IllegalStateException e9) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e9.getMessage());
                    }
                }
                ArchiveUpdatePlan promoteRebasedIncompleteBootstrapPlan = promoteRebasedIncompleteBootstrapPlan(ArchiveUpdatePlanner.plan$default(ArchiveUpdatePlanner.INSTANCE, archiveManifest, plannerState, null, list, 4, null), archiveUpdaterState, z3);
                ArchiveStagingUsage archiveStagingUsage = ArchiveStagingUsage.INSTANCE;
                File file7 = this.gameRoot;
                List<ArchivePackage> packages = promoteRebasedIncompleteBootstrapPlan.getPackages();
                file = this.workRoot;
                if (file == null) {
                    file = new File(this.gameRoot, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY);
                }
                ArchiveStorageRequirements storageRequirements = ArchiveStorageEstimator.INSTANCE.storageRequirements(promoteRebasedIncompleteBootstrapPlan, archiveUpdaterState, archiveStagingUsage.bytesByPackage(file7, packages, file), ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, promoteRebasedIncompleteBootstrapPlan.getPackages()));
                Map<String, Long> plannedSelectiveDownloadBytes = plannedSelectiveDownloadBytes(promoteRebasedIncompleteBootstrapPlan, archiveUpdaterState);
                long downloadBytes = ArchiveStorageEstimator.INSTANCE.downloadBytes(promoteRebasedIncompleteBootstrapPlan, archiveUpdaterState, plannedSelectiveDownloadBytes);
                z6 = (archiveUpdaterState == null && archiveUpdaterState.isPayloadCommitted() && !archiveUpdaterState.isInstallReady()) ? false : false;
                if (z6 || promoteRebasedIncompleteBootstrapPlan.getType() != ArchivePlanType.SKIP || downloadBytes != 0 || archiveUpdaterState == null || !z) {
                    z4 = z6;
                } else if (!ArchivePublishedPayloadReconciler.INSTANCE.matches(archiveManifest, archiveUpdaterState)) {
                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, "committed archive payload does not match published metadata");
                } else {
                    try {
                        this.stateStore.save(ArchiveStateAdapter.INSTANCE.markPayloadMetadataReconciled(archiveUpdaterState, this.nowEpochMs.invoke().longValue()));
                        z4 = false;
                    } catch (CancellationException e10) {
                        throw e10;
                    } catch (Exception e11) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to finalize archive metadata: " + e11.getMessage());
                    }
                }
                return new ArchiveUpdateCheckDecision.UseArchive(promoteRebasedIncompleteBootstrapPlan, downloadBytes, storageRequirements, z4, plannedSelectiveDownloadBytes);
            }
            archiveUpdaterState = state;
            if (archiveUpdaterState == null) {
            }
            if (archiveUpdaterState != null) {
            }
            ArchiveUpdatePlan promoteRebasedIncompleteBootstrapPlan2 = promoteRebasedIncompleteBootstrapPlan(ArchiveUpdatePlanner.plan$default(ArchiveUpdatePlanner.INSTANCE, archiveManifest, plannerState, null, list, 4, null), archiveUpdaterState, z3);
            ArchiveStagingUsage archiveStagingUsage2 = ArchiveStagingUsage.INSTANCE;
            File file72 = this.gameRoot;
            List<ArchivePackage> packages2 = promoteRebasedIncompleteBootstrapPlan2.getPackages();
            file = this.workRoot;
            if (file == null) {
            }
            ArchiveStorageRequirements storageRequirements2 = ArchiveStorageEstimator.INSTANCE.storageRequirements(promoteRebasedIncompleteBootstrapPlan2, archiveUpdaterState, archiveStagingUsage2.bytesByPackage(file72, packages2, file), ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, promoteRebasedIncompleteBootstrapPlan2.getPackages()));
            Map<String, Long> plannedSelectiveDownloadBytes2 = plannedSelectiveDownloadBytes(promoteRebasedIncompleteBootstrapPlan2, archiveUpdaterState);
            long downloadBytes2 = ArchiveStorageEstimator.INSTANCE.downloadBytes(promoteRebasedIncompleteBootstrapPlan2, archiveUpdaterState, plannedSelectiveDownloadBytes2);
            if (archiveUpdaterState == null) {
            }
            if (z6) {
            }
            z4 = z6;
            return new ArchiveUpdateCheckDecision.UseArchive(promoteRebasedIncompleteBootstrapPlan2, downloadBytes2, storageRequirements2, z4, plannedSelectiveDownloadBytes2);
        } catch (Exception e12) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e12.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resolveWithBootstrapPrefetch(ArchiveManifestCandidate archiveManifestCandidate, OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, ArchiveUpdaterState archiveUpdaterState, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new ArchiveUpdateCheckCoordinator$resolveWithBootstrapPrefetch$2(this, archiveManifestCandidate, str, archiveUpdaterState, originalTzArchiveManifestDescriptor, archiveBootstrapPrefetcher, null), continuation);
    }

    private final long bootstrapDownloadBytes(OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor) {
        long j = 0;
        for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor : originalTzArchiveManifestDescriptor.getPackages()) {
            j = Math.addExact(j, originalTzArchivePackageDescriptor.getArchiveSize());
        }
        return j;
    }

    private final Map<String, Long> plannedSelectiveDownloadBytes(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState) {
        ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator = this.selectiveDownloadEstimator;
        if (archiveSelectiveDownloadEstimator == null) {
            return MapsKt.emptyMap();
        }
        try {
            return archiveSelectiveDownloadEstimator.plannedNetworkBytesByPackage(archiveUpdatePlan, archiveUpdaterState);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator$ArchiveBootstrapPrefetchCleanupException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ArchiveBootstrapPrefetchCleanupException extends IllegalStateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArchiveBootstrapPrefetchCleanupException(Exception cause) {
            super("Unable to clean failed bootstrap prefetch", cause);
            Intrinsics.checkNotNullParameter(cause, "cause");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator$ArchiveSupersededArtifactCleanupException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ArchiveSupersededArtifactCleanupException extends IllegalStateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArchiveSupersededArtifactCleanupException(Exception cause) {
            super("unable to clean superseded archive artifacts: " + cause.getMessage(), cause);
            Intrinsics.checkNotNullParameter(cause, "cause");
        }
    }

    private final ArchiveUpdaterState adoptExistingInstall(File file, ArchiveManifest archiveManifest) {
        LinkedHashMap linkedHashMap;
        ArchiveUpdaterState archiveUpdaterState;
        ArrayList arrayList;
        long longValue = this.nowEpochMs.invoke().longValue();
        List<AdoptedArchivePackage> adoptedPackages = this.installAdopter.scan(file, archiveManifest).getAdoptedPackages();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(adoptedPackages, 10)), 16));
        for (Object obj : adoptedPackages) {
            linkedHashMap2.put(((AdoptedArchivePackage) obj).getArchivePackage().getId(), obj);
        }
        ArchiveUpdaterState createInitialState = ArchiveStateAdapter.INSTANCE.createInitialState(archiveManifest, longValue);
        List<ArchivePackageJournalEntry> packages = createInitialState.getPackages();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            AdoptedArchivePackage adoptedArchivePackage = (AdoptedArchivePackage) linkedHashMap2.get(archivePackageJournalEntry.getPackageId());
            if (adoptedArchivePackage == null) {
                archiveUpdaterState = createInitialState;
                linkedHashMap = linkedHashMap2;
                arrayList = arrayList2;
            } else {
                linkedHashMap = linkedHashMap2;
                archiveUpdaterState = createInitialState;
                arrayList = arrayList2;
                archivePackageJournalEntry = ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, ArchivePackagePhase.COMMITTED, archivePackageJournalEntry.getArchiveSize(), null, adoptedArchivePackage.getFiles(), null, null, longValue, null, 361, null);
            }
            arrayList.add(archivePackageJournalEntry);
            arrayList2 = arrayList;
            linkedHashMap2 = linkedHashMap;
            createInitialState = archiveUpdaterState;
        }
        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(createInitialState, 0, null, null, 0, null, arrayList2, null, false, longValue, 223, null);
        if (ArchivePublishedPayloadReconciler.INSTANCE.matches(archiveManifest, copy$default)) {
            copy$default = ArchiveStateAdapter.INSTANCE.markPayloadMetadataReconciled(copy$default, longValue);
        }
        this.stateStore.save(copy$default);
        return copy$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSafePreCommitRepairState(ArchiveUpdaterState archiveUpdaterState) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : archiveUpdaterState.getPackages()) {
            if (((ArchivePackageJournalEntry) obj).getPhase() != ArchivePackagePhase.COMMITTED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() || !archiveUpdaterState.getPendingRetirements().isEmpty()) {
            return false;
        }
        ArrayList<ArchivePackageJournalEntry> arrayList3 = arrayList2;
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            return true;
        }
        for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList3) {
            if (!SAFE_REPAIR_REBASE_PHASES.contains(archivePackageJournalEntry.getPhase()) || !Intrinsics.areEqual(archivePackageJournalEntry.getPreviousCommitted(), archivePackageJournalEntry.getIdentity()) || archivePackageJournalEntry.getPreviousFiles().isEmpty()) {
                return false;
            }
            while (r4.hasNext()) {
            }
        }
        return true;
    }

    private final ArchiveUpdaterState rebasePreCommitRepairState(ArchiveUpdaterState archiveUpdaterState, ArchiveManifest archiveManifest) {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList;
        ArchivePackageJournalEntry copy$default;
        ArchivePackageIdentity previousCommitted;
        List<ArchivePackageFileRecord> previousFiles;
        if (!isSafePreCommitRepairState(archiveUpdaterState)) {
            throw new IllegalStateException("archive repair state is not safe to rebase".toString());
        }
        long longValue = this.nowEpochMs.invoke().longValue();
        List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
        int i = 10;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED) {
                previousCommitted = archivePackageJournalEntry.getIdentity();
            } else {
                previousCommitted = archivePackageJournalEntry.getPreviousCommitted();
                if (previousCommitted == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED) {
                previousFiles = archivePackageJournalEntry.getFiles();
            } else {
                previousFiles = archivePackageJournalEntry.getPreviousFiles();
            }
            Pair pair = TuplesKt.to(archivePackageJournalEntry.getPackageId(), new LivePackageBaseline(previousCommitted, previousFiles, archivePackageJournalEntry));
            linkedHashMap2.put(pair.getFirst(), pair.getSecond());
        }
        ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner = ArchiveOwnershipDiffPlanner.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        for (LivePackageBaseline livePackageBaseline : linkedHashMap2.values()) {
            List<ArchivePackageFileRecord> files = livePackageBaseline.getFiles();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(files, 10));
            for (ArchivePackageFileRecord archivePackageFileRecord : files) {
                arrayList3.add(new ArchiveOwnedPath(livePackageBaseline.getIdentity().getPackageId(), archivePackageFileRecord.getRelativePath()));
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        ArrayList arrayList4 = arrayList2;
        ArrayList arrayList5 = new ArrayList();
        for (ArchivePackage archivePackage : archiveManifest.getPackages()) {
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries == null) {
                entries = CollectionsKt.emptyList();
            }
            List<ArchiveEntryMetadata> list = entries;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ArchiveEntryMetadata archiveEntryMetadata : list) {
                arrayList6.add(new ArchiveOwnedPath(archivePackage.getId(), archiveEntryMetadata.getTargetRelativePath()));
            }
            CollectionsKt.addAll(arrayList5, arrayList6);
        }
        ArchiveOwnershipDiff diff = archiveOwnershipDiffPlanner.diff(arrayList4, arrayList5);
        List<ArchivePackage> packages2 = archiveManifest.getPackages();
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages2, 10));
        for (ArchivePackage archivePackage2 : packages2) {
            ArchivePackageIdentity archivePackageIdentity = new ArchivePackageIdentity(archivePackage2.getId(), archivePackage2.getArchiveSize(), archivePackage2.getCrc32());
            List<ArchiveEntryMetadata> entries2 = archivePackage2.getEntries();
            if (entries2 == null) {
                entries2 = CollectionsKt.emptyList();
            }
            List<ArchiveEntryMetadata> list2 = entries2;
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, i));
            for (ArchiveEntryMetadata archiveEntryMetadata2 : list2) {
                arrayList8.add(new ArchivePackageFileRecord(archiveEntryMetadata2.getTargetRelativePath(), archiveEntryMetadata2.getSize(), archiveEntryMetadata2.getCrc32(), (String) null, 8, (DefaultConstructorMarker) null));
            }
            ArrayList arrayList9 = arrayList8;
            LivePackageBaseline livePackageBaseline2 = (LivePackageBaseline) linkedHashMap2.get(archivePackage2.getId());
            if (livePackageBaseline2 == null) {
                linkedHashMap = linkedHashMap2;
                arrayList = arrayList7;
                copy$default = new ArchivePackageJournalEntry(archivePackageIdentity, ArchivePackagePhase.PLANNED, 0L, (ArchivePackageIdentity) null, (List) null, arrayList9, (List) null, longValue, (String) null, 348, (DefaultConstructorMarker) null);
            } else {
                linkedHashMap = linkedHashMap2;
                arrayList = arrayList7;
                copy$default = (livePackageBaseline2.getJournal().getPhase() == ArchivePackagePhase.COMMITTED && Intrinsics.areEqual(livePackageBaseline2.getIdentity(), archivePackageIdentity)) ? ArchivePackageJournalEntry.copy$default(livePackageBaseline2.getJournal(), null, null, 0L, null, null, arrayList9, null, 0L, null, 479, null) : new ArchivePackageJournalEntry(archivePackageIdentity, ArchivePackagePhase.PLANNED, 0L, livePackageBaseline2.getIdentity(), (List) null, arrayList9, livePackageBaseline2.getFiles(), longValue, (String) null, 276, (DefaultConstructorMarker) null);
            }
            arrayList.add(copy$default);
            arrayList7 = arrayList;
            linkedHashMap2 = linkedHashMap;
            i = 10;
        }
        ArrayList arrayList10 = arrayList7;
        String manifestId = ArchiveStateAdapter.INSTANCE.manifestId(archiveManifest);
        String manifestVersion = archiveManifest.getManifestVersion();
        int schemaVersion = archiveManifest.getSchemaVersion();
        String wireName = archiveManifest.getSelectedGpu().getWireName();
        List<ArchiveOwnedPath> retired = diff.getRetired();
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(retired, 10));
        for (ArchiveOwnedPath archiveOwnedPath : retired) {
            arrayList11.add(new ArchiveFileRetirementRecord(archiveOwnedPath.getPackageId(), archiveOwnedPath.getRelativePath()));
        }
        ArchiveUpdaterState copy$default2 = ArchiveUpdaterState.copy$default(archiveUpdaterState, 0, manifestId, manifestVersion, schemaVersion, wireName, arrayList10, arrayList11, false, longValue, 1, null);
        ArchiveStateValidation.INSTANCE.requireValidState(copy$default2);
        return copy$default2;
    }

    private final ArchiveUpdaterState recoverIncompleteTransactionByCrc(ArchiveUpdaterState archiveUpdaterState, ArchiveManifest archiveManifest) {
        ArchiveOwnershipDiff archiveOwnershipDiff;
        Iterator it;
        ArrayList arrayList;
        int i;
        LinkedHashMap linkedHashMap;
        Map<String, LivePackageBaseline> map;
        Set<String> set;
        ArchivePackageJournalEntry copy$default;
        File file = this.gameRoot;
        if (file == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        long longValue = this.nowEpochMs.invoke().longValue();
        File file2 = this.workRoot;
        if (file2 == null) {
            file2 = new File(file, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY);
        }
        List<AdoptedArchivePackage> adoptedPackages = this.installAdopter.scan(file, archiveManifest).getAdoptedPackages();
        int i2 = 10;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(adoptedPackages, 10)), 16));
        for (Object obj : adoptedPackages) {
            linkedHashMap2.put(((AdoptedArchivePackage) obj).getArchivePackage().getId(), obj);
        }
        Set<String> keySet = linkedHashMap2.keySet();
        List<ArchivePackage> packages = archiveManifest.getPackages();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackage archivePackage : packages) {
            arrayList2.add(archivePackage.getId());
        }
        Map<String, LivePackageBaseline> filteredRecoveryBaselines = filteredRecoveryBaselines(archiveUpdaterState, arrayList2, keySet);
        ArchiveUpdaterState createInitialState = ArchiveStateAdapter.INSTANCE.createInitialState(archiveManifest, longValue);
        ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner = ArchiveOwnershipDiffPlanner.INSTANCE;
        List<ArchiveOwnedPath> possibleLiveOwnership = possibleLiveOwnership(archiveUpdaterState);
        ArrayList arrayList3 = new ArrayList();
        for (ArchivePackage archivePackage2 : archiveManifest.getPackages()) {
            List<ArchiveEntryMetadata> entries = archivePackage2.getEntries();
            if (entries == null) {
                entries = CollectionsKt.emptyList();
            }
            File file3 = file;
            List<ArchiveEntryMetadata> list = entries;
            File file4 = file2;
            Set<String> set2 = keySet;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, i2));
            for (Iterator it2 = list.iterator(); it2.hasNext(); it2 = it2) {
                arrayList4.add(new ArchiveOwnedPath(archivePackage2.getId(), ((ArchiveEntryMetadata) it2.next()).getTargetRelativePath()));
            }
            CollectionsKt.addAll(arrayList3, arrayList4);
            keySet = set2;
            file = file3;
            file2 = file4;
            i2 = 10;
        }
        File file5 = file;
        File file6 = file2;
        Set<String> set3 = keySet;
        ArchiveOwnershipDiff diff = archiveOwnershipDiffPlanner.diff(possibleLiveOwnership, arrayList3);
        List<ArchivePackageJournalEntry> packages2 = createInitialState.getPackages();
        int i3 = 10;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages2, 10));
        Iterator it3 = packages2.iterator();
        while (it3.hasNext()) {
            ArchivePackageJournalEntry archivePackageJournalEntry = (ArchivePackageJournalEntry) it3.next();
            AdoptedArchivePackage adoptedArchivePackage = (AdoptedArchivePackage) linkedHashMap2.get(archivePackageJournalEntry.getPackageId());
            LivePackageBaseline livePackageBaseline = filteredRecoveryBaselines.get(archivePackageJournalEntry.getPackageId());
            if (adoptedArchivePackage != null) {
                map = filteredRecoveryBaselines;
                linkedHashMap = linkedHashMap2;
                it = it3;
                arrayList = arrayList5;
                i = i3;
                archiveOwnershipDiff = diff;
                set = set3;
                copy$default = ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, ArchivePackagePhase.COMMITTED, archivePackageJournalEntry.getArchiveSize(), null, adoptedArchivePackage.getFiles(), null, null, longValue, null, 361, null);
            } else {
                archiveOwnershipDiff = diff;
                it = it3;
                arrayList = arrayList5;
                i = i3;
                linkedHashMap = linkedHashMap2;
                map = filteredRecoveryBaselines;
                set = set3;
                copy$default = livePackageBaseline != null ? ArchivePackageJournalEntry.copy$default(archivePackageJournalEntry, null, null, 0L, livePackageBaseline.getIdentity(), null, null, livePackageBaseline.getFiles(), longValue, null, 311, null) : archivePackageJournalEntry;
            }
            arrayList.add(copy$default);
            i3 = i;
            set3 = set;
            arrayList5 = arrayList;
            diff = archiveOwnershipDiff;
            filteredRecoveryBaselines = map;
            linkedHashMap2 = linkedHashMap;
            it3 = it;
        }
        ArchiveOwnershipDiff archiveOwnershipDiff2 = diff;
        int i4 = i3;
        Set<String> set4 = set3;
        ArrayList arrayList6 = arrayList5;
        List<ArchiveOwnedPath> retired = archiveOwnershipDiff2.getRetired();
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(retired, i4));
        for (ArchiveOwnedPath archiveOwnedPath : retired) {
            arrayList7.add(new ArchiveFileRetirementRecord(archiveOwnedPath.getPackageId(), archiveOwnedPath.getRelativePath()));
        }
        ArchiveUpdaterState copy$default2 = ArchiveUpdaterState.copy$default(createInitialState, 0, null, null, 0, null, arrayList6, arrayList7, false, longValue, 159, null);
        if (copy$default2.isPayloadCommitted() && ArchivePublishedPayloadReconciler.INSTANCE.matches(archiveManifest, copy$default2)) {
            copy$default2 = ArchiveStateAdapter.INSTANCE.markPayloadMetadataReconciled(copy$default2, longValue);
        } else {
            ArchiveStateValidation.INSTANCE.requireValidState(copy$default2);
        }
        ArchiveUpdaterState archiveUpdaterState2 = copy$default2;
        Set<ArchivePackageIdentity> crcRecoveryPreservedArchiveIdentities = crcRecoveryPreservedArchiveIdentities(archiveUpdaterState, archiveManifest, set4);
        ArchivePackageArtifactCleaner archivePackageArtifactCleaner = this.artifactCleaner;
        File file7 = this.downloadRoot;
        ArrayList arrayList8 = new ArrayList();
        for (Object obj2 : archiveUpdaterState.getPackages()) {
            if (((ArchivePackageJournalEntry) obj2).getPhase() != ArchivePackagePhase.COMMITTING) {
                arrayList8.add(obj2);
            }
        }
        ArrayList<ArchivePackageJournalEntry> arrayList9 = arrayList8;
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, i4));
        for (ArchivePackageJournalEntry archivePackageJournalEntry2 : arrayList9) {
            arrayList10.add(archivePackageJournalEntry2.getIdentity());
        }
        Set<ArchivePackageIdentity> set5 = crcRecoveryPreservedArchiveIdentities;
        archivePackageArtifactCleaner.cleanup(file5, file7, arrayList10, file6, set5);
        persistRecoveryState(archiveUpdaterState2);
        ArrayList arrayList11 = new ArrayList();
        for (Object obj3 : archiveUpdaterState.getPackages()) {
            if (((ArchivePackageJournalEntry) obj3).getPhase() == ArchivePackagePhase.COMMITTING) {
                arrayList11.add(obj3);
            }
        }
        this.artifactCleaner.cleanupAbandonedCommitBackups(file5, CollectionsKt.emptyList(), file6);
        ArchivePackageArtifactCleaner archivePackageArtifactCleaner2 = this.artifactCleaner;
        File file8 = this.downloadRoot;
        ArrayList<ArchivePackageJournalEntry> arrayList12 = arrayList11;
        ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, i4));
        for (ArchivePackageJournalEntry archivePackageJournalEntry3 : arrayList12) {
            arrayList13.add(archivePackageJournalEntry3.getIdentity());
        }
        archivePackageArtifactCleaner2.cleanup(file5, file8, arrayList13, file6, set5);
        return archiveUpdaterState2;
    }

    private final Map<String, LivePackageBaseline> filteredRecoveryBaselines(ArchiveUpdaterState archiveUpdaterState, Collection<String> collection, Set<String> set) {
        LivePackageBaseline livePackageBaseline;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = archiveUpdaterState.getPackages().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ArchivePackageJournalEntry archivePackageJournalEntry = (ArchivePackageJournalEntry) it.next();
            LivePackageBaseline recoveryBaseline = recoveryBaseline(archivePackageJournalEntry);
            Pair pair = recoveryBaseline != null ? TuplesKt.to(archivePackageJournalEntry.getPackageId(), recoveryBaseline) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Map map = MapsKt.toMap(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : collection) {
            Pair pair2 = (set.contains(str) || (livePackageBaseline = (LivePackageBaseline) map.get(str)) == null) ? null : TuplesKt.to(str, livePackageBaseline);
            if (pair2 != null) {
                arrayList2.add(pair2);
            }
        }
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        ArrayList<Pair> arrayList3 = arrayList2;
        for (Pair pair3 : arrayList3) {
            String str2 = (String) pair3.component1();
            for (ArchivePackageFileRecord archivePackageFileRecord : ((LivePackageBaseline) pair3.component2()).getFiles()) {
                String relativePath = archivePackageFileRecord.getRelativePath();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = relativePath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String str3 = (String) hashMap.putIfAbsent(lowerCase, str2);
                if (str3 != null && !Intrinsics.areEqual(str3, str2)) {
                    hashSet.add(lowerCase);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return MapsKt.toMap(arrayList3);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Pair pair4 : arrayList3) {
            String str4 = (String) pair4.component1();
            LivePackageBaseline livePackageBaseline2 = (LivePackageBaseline) pair4.component2();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : livePackageBaseline2.getFiles()) {
                String relativePath2 = ((ArchivePackageFileRecord) obj).getRelativePath();
                Locale ROOT2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                String lowerCase2 = relativePath2.toLowerCase(ROOT2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (!hashSet.contains(lowerCase2)) {
                    arrayList5.add(obj);
                }
            }
            ArrayList arrayList6 = arrayList5;
            Pair pair5 = arrayList6.isEmpty() ? null : TuplesKt.to(str4, LivePackageBaseline.copy$default(livePackageBaseline2, null, arrayList6, null, 5, null));
            if (pair5 != null) {
                arrayList4.add(pair5);
            }
        }
        return MapsKt.toMap(arrayList4);
    }

    private final Set<ArchivePackageIdentity> crcRecoveryPreservedArchiveIdentities(ArchiveUpdaterState archiveUpdaterState, ArchiveManifest archiveManifest, Set<String> set) {
        ArchivePackageJournalEntry archivePackageJournalEntry;
        List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
        for (Object obj : packages) {
            linkedHashMap.put(((ArchivePackageJournalEntry) obj).getPackageId(), obj);
        }
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (ArchivePackage archivePackage : archiveManifest.getPackages()) {
            if (!set.contains(archivePackage.getId()) && (archivePackageJournalEntry = (ArchivePackageJournalEntry) linkedHashMap.get(archivePackage.getId())) != null) {
                ArchivePackageIdentity archivePackageIdentity = new ArchivePackageIdentity(archivePackage.getId(), archivePackage.getArchiveSize(), archivePackage.getCrc32());
                if (Intrinsics.areEqual(archivePackageJournalEntry.getIdentity(), archivePackageIdentity)) {
                    createSetBuilder.add(archivePackageIdentity);
                }
            }
        }
        return SetsKt.build(createSetBuilder);
    }

    private final LivePackageBaseline recoveryBaseline(ArchivePackageJournalEntry archivePackageJournalEntry) {
        if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED && !archivePackageJournalEntry.getFiles().isEmpty()) {
            return new LivePackageBaseline(archivePackageJournalEntry.getIdentity(), archivePackageJournalEntry.getFiles(), archivePackageJournalEntry);
        }
        if (archivePackageJournalEntry.getPreviousCommitted() != null && !archivePackageJournalEntry.getPreviousFiles().isEmpty()) {
            return new LivePackageBaseline(archivePackageJournalEntry.getPreviousCommitted(), archivePackageJournalEntry.getPreviousFiles(), archivePackageJournalEntry);
        }
        if (archivePackageJournalEntry.getPhase() != ArchivePackagePhase.COMMITTING || archivePackageJournalEntry.getFiles().isEmpty()) {
            return null;
        }
        return new LivePackageBaseline(archivePackageJournalEntry.getIdentity(), archivePackageJournalEntry.getFiles(), archivePackageJournalEntry);
    }

    private final List<ArchiveOwnedPath> possibleLiveOwnership(ArchiveUpdaterState archiveUpdaterState) {
        List<ArchivePackageFileRecord> files;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (ArchivePackageJournalEntry archivePackageJournalEntry : archiveUpdaterState.getPackages()) {
            int i = WhenMappings.$EnumSwitchMapping$2[archivePackageJournalEntry.getPhase().ordinal()];
            if (i == 1) {
                files = archivePackageJournalEntry.getFiles();
            } else if (i == 2) {
                files = CollectionsKt.plus((Collection) archivePackageJournalEntry.getPreviousFiles(), (Iterable) archivePackageJournalEntry.getFiles());
            } else {
                files = archivePackageJournalEntry.getPreviousFiles();
            }
            for (ArchivePackageFileRecord archivePackageFileRecord : files) {
                String relativePath = archivePackageFileRecord.getRelativePath();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = relativePath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (hashSet.add(lowerCase)) {
                    arrayList.add(new ArchiveOwnedPath(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath()));
                }
            }
        }
        for (ArchiveFileRetirementRecord archiveFileRetirementRecord : archiveUpdaterState.getPendingRetirements()) {
            String relativePath2 = archiveFileRetirementRecord.getRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = relativePath2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (hashSet.add(lowerCase2)) {
                arrayList.add(new ArchiveOwnedPath(archiveFileRetirementRecord.getPackageId(), archiveFileRetirementRecord.getRelativePath()));
            }
        }
        return arrayList;
    }

    private final void persistRecoveryState(ArchiveUpdaterState archiveUpdaterState) {
        this.stateStore.save(archiveUpdaterState);
        this.stateStore.save(archiveUpdaterState);
    }

    private final ArchiveUpdatePlan promoteRebasedIncompleteBootstrapPlan(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, boolean z) {
        boolean z2;
        ArchivePlanReason archivePlanReason;
        if (archiveUpdaterState != null && archiveUpdatePlan.getType() == ArchivePlanType.FULL_BOOTSTRAP && archiveUpdatePlan.getReason() == ArchivePlanReason.BOOTSTRAP_INCOMPLETE) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : archiveUpdaterState.getPackages()) {
                if (((ArchivePackageJournalEntry) obj).getPhase() != ArchivePackagePhase.COMMITTED) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                ArrayList<ArchivePackageJournalEntry> arrayList3 = arrayList2;
                boolean z3 = arrayList3 instanceof Collection;
                if (!z3 || !arrayList3.isEmpty()) {
                    for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList3) {
                        if (!isPromotableNonCommittedEntry(archivePackageJournalEntry)) {
                            return archiveUpdatePlan;
                        }
                    }
                }
                if (z) {
                    List<ArchivePackageJournalEntry> packages = archiveUpdaterState.getPackages();
                    if (!(packages instanceof Collection) || !packages.isEmpty()) {
                        for (ArchivePackageJournalEntry archivePackageJournalEntry2 : packages) {
                            if (archivePackageJournalEntry2.getPhase() == ArchivePackagePhase.COMMITTED) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                }
                z2 = false;
                if (!z3 || !arrayList3.isEmpty()) {
                    for (ArchivePackageJournalEntry archivePackageJournalEntry3 : arrayList3) {
                        if (hasValidLiveBaseline(archivePackageJournalEntry3)) {
                            break;
                        }
                    }
                }
                if (z2) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : archiveUpdatePlan.getRemoteManifest().getPackages()) {
                        ArchivePackageJournalEntry packageById = archiveUpdaterState.packageById(((ArchivePackage) obj2).getId());
                        if ((packageById != null ? packageById.getPhase() : null) != ArchivePackagePhase.COMMITTED) {
                            arrayList4.add(obj2);
                        }
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (!arrayList5.isEmpty()) {
                        ArchivePlanType archivePlanType = ArchivePlanType.FULL_UPDATE;
                        if (hasNewOrRemovedPackageEvidence(archiveUpdaterState, archiveUpdatePlan.getRemoteManifest())) {
                            archivePlanReason = ArchivePlanReason.PACKAGE_SET_CHANGED;
                        } else {
                            archivePlanReason = ArchivePlanReason.PACKAGE_IDENTITY_CHANGED;
                        }
                        return ArchiveUpdatePlan.copy$default(archiveUpdatePlan, archivePlanType, archivePlanReason, null, arrayList5, null, 20, null);
                    }
                }
            }
        }
        return archiveUpdatePlan;
    }

    private final boolean isPromotableNonCommittedEntry(ArchivePackageJournalEntry archivePackageJournalEntry) {
        return hasValidLiveBaseline(archivePackageJournalEntry) || isGenuinelyNewPlannedPackage(archivePackageJournalEntry);
    }

    private final boolean hasValidLiveBaseline(ArchivePackageJournalEntry archivePackageJournalEntry) {
        return (!SAFE_REPAIR_REBASE_PHASES.contains(archivePackageJournalEntry.getPhase()) || archivePackageJournalEntry.getPreviousCommitted() == null || archivePackageJournalEntry.getPreviousFiles().isEmpty()) ? false : true;
    }

    private final boolean isGenuinelyNewPlannedPackage(ArchivePackageJournalEntry archivePackageJournalEntry) {
        return archivePackageJournalEntry.getPhase() == ArchivePackagePhase.PLANNED && archivePackageJournalEntry.getPreviousCommitted() == null && archivePackageJournalEntry.getPreviousFiles().isEmpty() && archivePackageJournalEntry.getFiles().isEmpty();
    }

    private final boolean hasNewOrRemovedPackageEvidence(ArchiveUpdaterState archiveUpdaterState, ArchiveManifest archiveManifest) {
        List<ArchivePackage> packages = archiveManifest.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackage archivePackage : packages) {
            arrayList.add(archivePackage.getId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ArchivePackageJournalEntry archivePackageJournalEntry : archiveUpdaterState.getPackages()) {
            if (archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED || archivePackageJournalEntry.getPreviousCommitted() != null) {
                linkedHashSet.add(archivePackageJournalEntry.getPackageId());
            }
        }
        for (ArchiveFileRetirementRecord archiveFileRetirementRecord : archiveUpdaterState.getPendingRetirements()) {
            if (!set.contains(archiveFileRetirementRecord.getPackageId())) {
                linkedHashSet.add(archiveFileRetirementRecord.getPackageId());
            }
        }
        return !Intrinsics.areEqual(linkedHashSet, set);
    }

    private final List<ArchivePackageIdentity> supersededRepairIdentities(ArchiveUpdaterState archiveUpdaterState, ArchiveManifest archiveManifest) {
        List<ArchivePackage> packages = archiveManifest.getPackages();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(packages, 10)), 16));
        for (ArchivePackage archivePackage : packages) {
            Pair pair = TuplesKt.to(archivePackage.getId(), new ArchivePackageIdentity(archivePackage.getId(), archivePackage.getArchiveSize(), archivePackage.getCrc32()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : archiveUpdaterState.getPackages()) {
            ArchivePackageJournalEntry archivePackageJournalEntry = (ArchivePackageJournalEntry) obj;
            if (SAFE_REPAIR_REBASE_PHASES.contains(archivePackageJournalEntry.getPhase()) && !Intrinsics.areEqual(linkedHashMap.get(archivePackageJournalEntry.getPackageId()), archivePackageJournalEntry.getIdentity())) {
                arrayList.add(obj);
            }
        }
        ArrayList<ArchivePackageJournalEntry> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry2 : arrayList2) {
            arrayList3.add(archivePackageJournalEntry2.getIdentity());
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator$LivePackageBaseline;", "", "identity", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", DiskLruCache.JOURNAL_FILE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;Ljava/util/List;Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;)V", "getIdentity", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "getFiles", "()Ljava/util/List;", "getJournal", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LivePackageBaseline {
        private final List<ArchivePackageFileRecord> files;
        private final ArchivePackageIdentity identity;
        private final ArchivePackageJournalEntry journal;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LivePackageBaseline copy$default(LivePackageBaseline livePackageBaseline, ArchivePackageIdentity archivePackageIdentity, List list, ArchivePackageJournalEntry archivePackageJournalEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                archivePackageIdentity = livePackageBaseline.identity;
            }
            if ((i & 2) != 0) {
                list = livePackageBaseline.files;
            }
            if ((i & 4) != 0) {
                archivePackageJournalEntry = livePackageBaseline.journal;
            }
            return livePackageBaseline.copy(archivePackageIdentity, list, archivePackageJournalEntry);
        }

        public final ArchivePackageIdentity component1() {
            return this.identity;
        }

        public final List<ArchivePackageFileRecord> component2() {
            return this.files;
        }

        public final ArchivePackageJournalEntry component3() {
            return this.journal;
        }

        public final LivePackageBaseline copy(ArchivePackageIdentity identity, List<ArchivePackageFileRecord> files, ArchivePackageJournalEntry journal) {
            Intrinsics.checkNotNullParameter(identity, "identity");
            Intrinsics.checkNotNullParameter(files, "files");
            Intrinsics.checkNotNullParameter(journal, "journal");
            return new LivePackageBaseline(identity, files, journal);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LivePackageBaseline) {
                LivePackageBaseline livePackageBaseline = (LivePackageBaseline) obj;
                return Intrinsics.areEqual(this.identity, livePackageBaseline.identity) && Intrinsics.areEqual(this.files, livePackageBaseline.files) && Intrinsics.areEqual(this.journal, livePackageBaseline.journal);
            }
            return false;
        }

        public int hashCode() {
            return (((this.identity.hashCode() * 31) + this.files.hashCode()) * 31) + this.journal.hashCode();
        }

        public String toString() {
            ArchivePackageIdentity archivePackageIdentity = this.identity;
            List<ArchivePackageFileRecord> list = this.files;
            return "LivePackageBaseline(identity=" + archivePackageIdentity + ", files=" + list + ", journal=" + this.journal + ")";
        }

        public LivePackageBaseline(ArchivePackageIdentity identity, List<ArchivePackageFileRecord> files, ArchivePackageJournalEntry journal) {
            Intrinsics.checkNotNullParameter(identity, "identity");
            Intrinsics.checkNotNullParameter(files, "files");
            Intrinsics.checkNotNullParameter(journal, "journal");
            this.identity = identity;
            this.files = files;
            this.journal = journal;
        }

        public final ArchivePackageIdentity getIdentity() {
            return this.identity;
        }

        public final List<ArchivePackageFileRecord> getFiles() {
            return this.files;
        }

        public final ArchivePackageJournalEntry getJournal() {
            return this.journal;
        }
    }

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator$Companion;", "", "<init>", "()V", "SAFE_REPAIR_REBASE_PHASES", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "getSAFE_REPAIR_REBASE_PHASES", "()Ljava/util/Set;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<ArchivePackagePhase> getSAFE_REPAIR_REBASE_PHASES() {
            return ArchiveUpdateCheckCoordinator.SAFE_REPAIR_REBASE_PHASES;
        }
    }
}

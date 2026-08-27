package com.arizona.launcher.updater.archive.orchestrator;

import coil3.disk.DiskLruCache;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.adoption.AdoptedArchivePackage;
import com.arizona.launcher.updater.archive.adoption.ArchiveInstallAdopter;
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
import java.util.LinkedHashMap;
import java.util.List;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 ?2\u00020\u0001:\u0003=>?Be\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086@¢\u0006\u0002\u0010!J8\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002J,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010)H\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00100\u001a\u00020)H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020)2\u0006\u00109\u001a\u000205H\u0002J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u00108\u001a\u00020)2\u0006\u00109\u001a\u000205H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000¨\u0006@"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;", "", "gameRoot", "Ljava/io/File;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "installAdopter", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;", "artifactCleaner", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "downloadRoot", "candidateParser", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;", "manifestResolver", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "nowEpochMs", "Lkotlin/Function0;", "", "selectiveDownloadEstimator", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator;", "<init>", "(Ljava/io/File;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;Ljava/io/File;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;Lkotlin/jvm/functions/Function0;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveDownloadEstimator;)V", "prepare", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "serverBaseUrl", "allowCleanBootstrap", "", "bootstrapPrefetcher", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/lang/String;ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveWithBootstrapPrefetch", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionResult;", "candidate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "descriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "loadedState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bootstrapDownloadBytes", "plannedSelectiveDownloadBytes", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adoptExistingInstall", "root", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "isSafePreCommitRepairState", "rebasePreCommitRepairState", UpdateServiceContract.BundleKey.CURRENT, "remote", "supersededRepairIdentities", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "ArchiveBootstrapPrefetchCleanupException", "LivePackageBaseline", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<ArchivePackagePhase> SAFE_REPAIR_REBASE_PHASES = SetsKt.setOf((Object[]) new ArchivePackagePhase[]{ArchivePackagePhase.PLANNED, ArchivePackagePhase.DOWNLOADING, ArchivePackagePhase.DOWNLOADED, ArchivePackagePhase.VERIFYING, ArchivePackagePhase.VERIFIED, ArchivePackagePhase.EXTRACTING, ArchivePackagePhase.EXTRACTED});

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
        }
    }

    public ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore stateStore, ArchiveInstallAdopter installAdopter, ArchivePackageArtifactCleaner artifactCleaner, File file2, ArchiveManifestCandidateParser candidateParser, ArchiveManifestResolver manifestResolver, Function0<Long> nowEpochMs, ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator) {
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(installAdopter, "installAdopter");
        Intrinsics.checkNotNullParameter(artifactCleaner, "artifactCleaner");
        Intrinsics.checkNotNullParameter(candidateParser, "candidateParser");
        Intrinsics.checkNotNullParameter(manifestResolver, "manifestResolver");
        Intrinsics.checkNotNullParameter(nowEpochMs, "nowEpochMs");
        this.gameRoot = file;
        this.stateStore = stateStore;
        this.installAdopter = installAdopter;
        this.artifactCleaner = artifactCleaner;
        this.downloadRoot = file2;
        this.candidateParser = candidateParser;
        this.manifestResolver = manifestResolver;
        this.nowEpochMs = nowEpochMs;
        this.selectiveDownloadEstimator = archiveSelectiveDownloadEstimator;
    }

    public /* synthetic */ ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore durableArchiveStateStore, ArchiveInstallAdopter archiveInstallAdopter, ArchivePackageArtifactCleaner archivePackageArtifactCleaner, File file2, ArchiveManifestCandidateParser archiveManifestCandidateParser, ArchiveManifestResolver archiveManifestResolver, AnonymousClass1 anonymousClass1, ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, durableArchiveStateStore, archiveInstallAdopter, archivePackageArtifactCleaner, (i & 16) != 0 ? null : file2, (i & 32) != 0 ? new ArchiveManifestCandidateParser(null, null, 3, null) : archiveManifestCandidateParser, (i & 64) != 0 ? new ArchiveManifestResolver(null, 1, null) : archiveManifestResolver, (i & 128) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1, (i & 256) != 0 ? null : archiveSelectiveDownloadEstimator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator$1  reason: invalid class name */
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$1;
        int i;
        boolean z2;
        ArchiveStateLoadResult load;
        String str3;
        ArchiveGpu archiveGpu2;
        ArchiveFlowSelection select;
        ArchiveUpdaterState state;
        String str4;
        ArchiveManifestCandidate archiveManifestCandidate;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor;
        boolean z3;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher2;
        Object resolveWithBootstrapPrefetch;
        ArchiveFlowSelection archiveFlowSelection;
        String str5;
        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher3;
        ArchiveManifestResolutionResult archiveManifestResolutionResult;
        ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor2;
        ArchiveUpdaterState archiveUpdaterState;
        ArchiveFlowSelection archiveFlowSelection2;
        ArchiveUpdaterState archiveUpdaterState2;
        ArchiveUpdaterState adoptExistingInstall;
        ArchiveLocalState plannerState;
        List<String> sameIdentityRepairPackageIds;
        ArchiveUpdatePlan archiveUpdatePlan;
        ArchiveStorageRequirements archiveStorageRequirements;
        try {
            if (continuation instanceof ArchiveUpdateCheckCoordinator$prepare$1) {
                archiveUpdateCheckCoordinator$prepare$1 = (ArchiveUpdateCheckCoordinator$prepare$1) continuation;
                if ((archiveUpdateCheckCoordinator$prepare$1.label & Integer.MIN_VALUE) != 0) {
                    archiveUpdateCheckCoordinator$prepare$1.label -= Integer.MIN_VALUE;
                    ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$12 = archiveUpdateCheckCoordinator$prepare$1;
                    Object obj = archiveUpdateCheckCoordinator$prepare$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = archiveUpdateCheckCoordinator$prepare$12.label;
                    if (i != 0) {
                        z2 = false;
                        z2 = false;
                        ResultKt.throwOnFailure(obj);
                        try {
                            load = this.stateStore.load();
                            try {
                                str3 = str;
                                archiveGpu2 = archiveGpu;
                                ArchiveManifestCandidate parse = this.candidateParser.parse(str3, archiveGpu2);
                                select = ArchiveFlowSelector.INSTANCE.select(true, load);
                                int i2 = WhenMappings.$EnumSwitchMapping$1[select.ordinal()];
                                if (i2 == 1) {
                                    ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode2 = ArchiveUpdateCheckBlockCode.STATE_CORRUPT;
                                    ArchiveStateLoadResult.Corrupt corrupt = load instanceof ArchiveStateLoadResult.Corrupt ? (ArchiveStateLoadResult.Corrupt) load : null;
                                    return new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode2, corrupt != null ? corrupt.getReason() : null);
                                } else if (i2 == 2) {
                                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_REQUIRED, "archive-only delivery requires an archive manifest on every mirror");
                                } else {
                                    if (i2 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    if (this.gameRoot == null) {
                                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.GAME_ROOT_UNAVAILABLE, null, 2, null);
                                    }
                                    ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
                                    state = loaded != null ? loaded.getState() : null;
                                    ArchiveManifestCandidate.OriginalTz originalTz = parse instanceof ArchiveManifestCandidate.OriginalTz ? (ArchiveManifestCandidate.OriginalTz) parse : null;
                                    OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor3 = (originalTz == null || (originalTzArchiveManifestDescriptor3 = originalTz.getDescriptor()) == null || !(load instanceof ArchiveStateLoadResult.Missing) || !LegacyGameTreeProbe.INSTANCE.isEmptyForArchiveBootstrap(this.gameRoot)) ? null : null;
                                    if (!z || originalTzArchiveManifestDescriptor3 == null) {
                                        if (originalTzArchiveManifestDescriptor3 != null && archiveBootstrapPrefetcher != null) {
                                            archiveUpdateCheckCoordinator$prepare$12.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                            archiveUpdateCheckCoordinator$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu2);
                                            archiveUpdateCheckCoordinator$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            archiveUpdateCheckCoordinator$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                                            archiveUpdateCheckCoordinator$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(load);
                                            archiveUpdateCheckCoordinator$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(parse);
                                            archiveUpdateCheckCoordinator$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(select);
                                            archiveUpdateCheckCoordinator$prepare$12.L$7 = state;
                                            archiveUpdateCheckCoordinator$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(originalTzArchiveManifestDescriptor3);
                                            archiveUpdateCheckCoordinator$prepare$12.Z$0 = z;
                                            archiveUpdateCheckCoordinator$prepare$12.label = 1;
                                            resolveWithBootstrapPrefetch = resolveWithBootstrapPrefetch(parse, originalTzArchiveManifestDescriptor3, str2, state, archiveBootstrapPrefetcher, archiveUpdateCheckCoordinator$prepare$12);
                                            if (resolveWithBootstrapPrefetch != coroutine_suspended) {
                                                originalTzArchiveManifestDescriptor = originalTzArchiveManifestDescriptor3;
                                                z3 = z;
                                                archiveFlowSelection = select;
                                                str5 = str2;
                                                archiveManifestCandidate = parse;
                                                archiveBootstrapPrefetcher3 = archiveBootstrapPrefetcher;
                                                archiveManifestResolutionResult = (ArchiveManifestResolutionResult) resolveWithBootstrapPrefetch;
                                            }
                                        } else {
                                            ArchiveManifestResolver archiveManifestResolver = this.manifestResolver;
                                            archiveUpdateCheckCoordinator$prepare$12.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                            archiveUpdateCheckCoordinator$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu2);
                                            archiveUpdateCheckCoordinator$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                            archiveUpdateCheckCoordinator$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher);
                                            archiveUpdateCheckCoordinator$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(load);
                                            archiveUpdateCheckCoordinator$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(parse);
                                            archiveUpdateCheckCoordinator$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(select);
                                            archiveUpdateCheckCoordinator$prepare$12.L$7 = state;
                                            archiveUpdateCheckCoordinator$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(originalTzArchiveManifestDescriptor3);
                                            archiveUpdateCheckCoordinator$prepare$12.Z$0 = z;
                                            archiveUpdateCheckCoordinator$prepare$12.label = 2;
                                            str4 = str2;
                                            Object resolve = archiveManifestResolver.resolve(parse, str4, state, archiveUpdateCheckCoordinator$prepare$12);
                                            if (resolve != coroutine_suspended) {
                                                archiveManifestCandidate = parse;
                                                obj = resolve;
                                                originalTzArchiveManifestDescriptor = originalTzArchiveManifestDescriptor3;
                                                z3 = z;
                                                archiveBootstrapPrefetcher2 = archiveBootstrapPrefetcher;
                                                ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher4 = archiveBootstrapPrefetcher2;
                                                archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                                                archiveBootstrapPrefetcher3 = archiveBootstrapPrefetcher4;
                                                ArchiveFlowSelection archiveFlowSelection3 = select;
                                                str5 = str4;
                                                archiveFlowSelection = archiveFlowSelection3;
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    return new ArchiveUpdateCheckDecision.Bootstrap(new ArchiveBootstrapPending(bootstrapDownloadBytes(originalTzArchiveManifestDescriptor3)));
                                }
                            } catch (IllegalArgumentException e) {
                                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_INVALID, e.getMessage());
                            }
                        } catch (Exception e2) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e2.getMessage());
                        }
                    } else if (i == 1) {
                        z2 = false;
                        z3 = archiveUpdateCheckCoordinator$prepare$12.Z$0;
                        originalTzArchiveManifestDescriptor = (OriginalTzArchiveManifestDescriptor) archiveUpdateCheckCoordinator$prepare$12.L$8;
                        state = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$12.L$7;
                        archiveFlowSelection = (ArchiveFlowSelection) archiveUpdateCheckCoordinator$prepare$12.L$6;
                        archiveManifestCandidate = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$prepare$12.L$5;
                        ArchiveStateLoadResult archiveStateLoadResult = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$prepare$12.L$4;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher5 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$prepare$12.L$3;
                        str5 = (String) archiveUpdateCheckCoordinator$prepare$12.L$2;
                        ArchiveGpu archiveGpu3 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$12.L$1;
                        String str6 = (String) archiveUpdateCheckCoordinator$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        resolveWithBootstrapPrefetch = obj;
                        archiveBootstrapPrefetcher3 = archiveBootstrapPrefetcher5;
                        archiveGpu2 = archiveGpu3;
                        load = archiveStateLoadResult;
                        str3 = str6;
                        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) resolveWithBootstrapPrefetch;
                    } else if (i != 2) {
                        if (i == 3) {
                            boolean z4 = archiveUpdateCheckCoordinator$prepare$12.Z$0;
                            archiveStorageRequirements = (ArchiveStorageRequirements) archiveUpdateCheckCoordinator$prepare$12.L$18;
                            Map map = (Map) archiveUpdateCheckCoordinator$prepare$12.L$17;
                            Map map2 = (Map) archiveUpdateCheckCoordinator$prepare$12.L$16;
                            archiveUpdatePlan = (ArchiveUpdatePlan) archiveUpdateCheckCoordinator$prepare$12.L$15;
                            List list = (List) archiveUpdateCheckCoordinator$prepare$12.L$14;
                            ArchiveLocalState archiveLocalState = (ArchiveLocalState) archiveUpdateCheckCoordinator$prepare$12.L$13;
                            adoptExistingInstall = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$12.L$12;
                            ArchiveUpdaterState archiveUpdaterState3 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$12.L$11;
                            ArchiveManifest archiveManifest = (ArchiveManifest) archiveUpdateCheckCoordinator$prepare$12.L$10;
                            ArchiveManifestResolutionResult archiveManifestResolutionResult2 = (ArchiveManifestResolutionResult) archiveUpdateCheckCoordinator$prepare$12.L$9;
                            OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor4 = (OriginalTzArchiveManifestDescriptor) archiveUpdateCheckCoordinator$prepare$12.L$8;
                            ArchiveUpdaterState archiveUpdaterState4 = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$12.L$7;
                            ArchiveFlowSelection archiveFlowSelection4 = (ArchiveFlowSelection) archiveUpdateCheckCoordinator$prepare$12.L$6;
                            ArchiveManifestCandidate archiveManifestCandidate2 = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$prepare$12.L$5;
                            ArchiveStateLoadResult archiveStateLoadResult2 = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$prepare$12.L$4;
                            ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher6 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$prepare$12.L$3;
                            String str7 = (String) archiveUpdateCheckCoordinator$prepare$12.L$2;
                            ArchiveGpu archiveGpu4 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$12.L$1;
                            String str8 = (String) archiveUpdateCheckCoordinator$prepare$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            z2 = false;
                            return new ArchiveUpdateCheckDecision.UseArchive(archiveUpdatePlan, ArchiveStorageEstimator.INSTANCE.downloadBytes(archiveUpdatePlan, adoptExistingInstall, (Map) obj), archiveStorageRequirements, (adoptExistingInstall == null && adoptExistingInstall.isPayloadCommitted() && !adoptExistingInstall.isInstallReady()) ? true : z2);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z3 = archiveUpdateCheckCoordinator$prepare$12.Z$0;
                        originalTzArchiveManifestDescriptor = (OriginalTzArchiveManifestDescriptor) archiveUpdateCheckCoordinator$prepare$12.L$8;
                        state = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$12.L$7;
                        ArchiveFlowSelection archiveFlowSelection5 = (ArchiveFlowSelection) archiveUpdateCheckCoordinator$prepare$12.L$6;
                        archiveManifestCandidate = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$prepare$12.L$5;
                        load = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$prepare$12.L$4;
                        archiveBootstrapPrefetcher2 = (ArchiveBootstrapPrefetcher) archiveUpdateCheckCoordinator$prepare$12.L$3;
                        z2 = false;
                        String str9 = (String) archiveUpdateCheckCoordinator$prepare$12.L$2;
                        ArchiveGpu archiveGpu5 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$12.L$1;
                        String str10 = (String) archiveUpdateCheckCoordinator$prepare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        select = archiveFlowSelection5;
                        str4 = str9;
                        str3 = str10;
                        archiveGpu2 = archiveGpu5;
                        ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher42 = archiveBootstrapPrefetcher2;
                        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                        archiveBootstrapPrefetcher3 = archiveBootstrapPrefetcher42;
                        ArchiveFlowSelection archiveFlowSelection32 = select;
                        str5 = str4;
                        archiveFlowSelection = archiveFlowSelection32;
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
                        String[] strArr = new String[2];
                        strArr[z2 ? 1 : 0] = failure.getPackageId();
                        strArr[1] = failure.getDetail();
                        return new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
                    }
                    ArchiveManifest manifest = ((ArchiveManifestResolutionResult.Success) archiveManifestResolutionResult).getManifest();
                    List<ArchivePackage> packages = manifest.getPackages();
                    ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher7 = archiveBootstrapPrefetcher3;
                    if (!(packages instanceof Collection) || !packages.isEmpty()) {
                        for (ArchivePackage archivePackage : packages) {
                            if (archivePackage.getEntries() == null) {
                                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_ENTRY_METADATA_REQUIRED, "archive-only delivery requires the complete ZIP entry inventory");
                            }
                        }
                    }
                    if (state == null || state.isInstallReady() || ArchiveStateAdapter.INSTANCE.identitiesMatch(state, manifest)) {
                        originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor;
                        archiveUpdaterState = state;
                        archiveFlowSelection2 = archiveFlowSelection;
                        archiveUpdaterState2 = archiveUpdaterState;
                    } else if (!isSafePreCommitRepairState(state)) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.INCOMPLETE_MANIFEST_MISMATCH, "remote archive identity changed during an incomplete transaction");
                    } else {
                        try {
                            archiveUpdaterState2 = rebasePreCommitRepairState(state, manifest);
                            try {
                                originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor;
                                archiveFlowSelection2 = archiveFlowSelection;
                                archiveUpdaterState = state;
                                this.artifactCleaner.cleanup(this.gameRoot, this.downloadRoot, supersededRepairIdentities(state, manifest));
                                try {
                                    this.stateStore.save(archiveUpdaterState2);
                                    this.stateStore.save(archiveUpdaterState2);
                                } catch (Exception e3) {
                                    return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to persist archive repair rebase: " + e3.getMessage());
                                }
                            } catch (Exception e4) {
                                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to clean superseded archive artifacts: " + e4.getMessage());
                            }
                        } catch (ArchiveOwnershipException e5) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e5.getMessage());
                        } catch (IllegalStateException e6) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e6.getMessage());
                        }
                    }
                    if (archiveUpdaterState2 == null) {
                        try {
                            adoptExistingInstall = LegacyGameTreeProbe.INSTANCE.isEmptyForArchiveBootstrap(this.gameRoot) ? null : adoptExistingInstall(this.gameRoot, manifest);
                        } catch (Exception e7) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to persist archive adoption state: " + e7.getMessage());
                        }
                    } else {
                        adoptExistingInstall = archiveUpdaterState2;
                    }
                    if (adoptExistingInstall != null) {
                        try {
                            plannerState = ArchiveStateAdapter.INSTANCE.toPlannerState(adoptExistingInstall);
                        } catch (IllegalStateException e8) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e8.getMessage());
                        }
                    } else {
                        plannerState = null;
                    }
                    if (adoptExistingInstall != null) {
                        try {
                            sameIdentityRepairPackageIds = ArchiveStateAdapter.INSTANCE.sameIdentityRepairPackageIds(adoptExistingInstall);
                        } catch (IllegalStateException e9) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e9.getMessage());
                        }
                    } else {
                        sameIdentityRepairPackageIds = null;
                    }
                    ArchiveUpdatePlan plan$default = ArchiveUpdatePlanner.plan$default(ArchiveUpdatePlanner.INSTANCE, manifest, plannerState, null, sameIdentityRepairPackageIds, 4, null);
                    Map<String, Long> bytesByPackage = ArchiveStagingUsage.INSTANCE.bytesByPackage(this.gameRoot, plan$default.getPackages());
                    ArchiveUpdaterState archiveUpdaterState5 = archiveUpdaterState2;
                    Map<String, Long> allocatedBytesByPackage = ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, plan$default.getPackages());
                    ArchiveStorageRequirements storageRequirements = ArchiveStorageEstimator.INSTANCE.storageRequirements(plan$default, adoptExistingInstall, bytesByPackage, allocatedBytesByPackage);
                    archiveUpdateCheckCoordinator$prepare$12.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    archiveUpdateCheckCoordinator$prepare$12.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu2);
                    archiveUpdateCheckCoordinator$prepare$12.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                    archiveUpdateCheckCoordinator$prepare$12.L$3 = SpillingKt.nullOutSpilledVariable(archiveBootstrapPrefetcher7);
                    archiveUpdateCheckCoordinator$prepare$12.L$4 = SpillingKt.nullOutSpilledVariable(load);
                    archiveUpdateCheckCoordinator$prepare$12.L$5 = SpillingKt.nullOutSpilledVariable(archiveManifestCandidate);
                    archiveUpdateCheckCoordinator$prepare$12.L$6 = SpillingKt.nullOutSpilledVariable(archiveFlowSelection2);
                    archiveUpdateCheckCoordinator$prepare$12.L$7 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                    archiveUpdateCheckCoordinator$prepare$12.L$8 = SpillingKt.nullOutSpilledVariable(originalTzArchiveManifestDescriptor2);
                    archiveUpdateCheckCoordinator$prepare$12.L$9 = SpillingKt.nullOutSpilledVariable(archiveManifestResolutionResult);
                    archiveUpdateCheckCoordinator$prepare$12.L$10 = SpillingKt.nullOutSpilledVariable(manifest);
                    archiveUpdateCheckCoordinator$prepare$12.L$11 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState5);
                    archiveUpdateCheckCoordinator$prepare$12.L$12 = adoptExistingInstall;
                    archiveUpdateCheckCoordinator$prepare$12.L$13 = SpillingKt.nullOutSpilledVariable(plannerState);
                    archiveUpdateCheckCoordinator$prepare$12.L$14 = SpillingKt.nullOutSpilledVariable(sameIdentityRepairPackageIds);
                    archiveUpdateCheckCoordinator$prepare$12.L$15 = plan$default;
                    archiveUpdateCheckCoordinator$prepare$12.L$16 = SpillingKt.nullOutSpilledVariable(bytesByPackage);
                    archiveUpdateCheckCoordinator$prepare$12.L$17 = SpillingKt.nullOutSpilledVariable(allocatedBytesByPackage);
                    archiveUpdateCheckCoordinator$prepare$12.L$18 = storageRequirements;
                    archiveUpdateCheckCoordinator$prepare$12.Z$0 = z3;
                    archiveUpdateCheckCoordinator$prepare$12.label = 3;
                    obj = plannedSelectiveDownloadBytes(plan$default, adoptExistingInstall, archiveUpdateCheckCoordinator$prepare$12);
                    if (obj != coroutine_suspended) {
                        archiveUpdatePlan = plan$default;
                        archiveStorageRequirements = storageRequirements;
                        return new ArchiveUpdateCheckDecision.UseArchive(archiveUpdatePlan, ArchiveStorageEstimator.INSTANCE.downloadBytes(archiveUpdatePlan, adoptExistingInstall, (Map) obj), archiveStorageRequirements, (adoptExistingInstall == null && adoptExistingInstall.isPayloadCommitted() && !adoptExistingInstall.isInstallReady()) ? true : z2);
                    }
                    return coroutine_suspended;
                }
            }
            if (i != 0) {
            }
            if (archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success) {
            }
        } catch (ArchiveBootstrapPrefetchCleanupException e10) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e10.getMessage());
        }
        archiveUpdateCheckCoordinator$prepare$1 = new ArchiveUpdateCheckCoordinator$prepare$1(this, continuation);
        ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$122 = archiveUpdateCheckCoordinator$prepare$1;
        Object obj2 = archiveUpdateCheckCoordinator$prepare$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateCheckCoordinator$prepare$122.label;
    }

    public static /* synthetic */ Object prepare$default(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, String str, ArchiveGpu archiveGpu, String str2, boolean z, ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "https://invalid.local/";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            archiveBootstrapPrefetcher = null;
        }
        return archiveUpdateCheckCoordinator.prepare(str, archiveGpu, str3, z2, archiveBootstrapPrefetcher, continuation);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object plannedSelectiveDownloadBytes(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, Continuation<? super Map<String, Long>> continuation) {
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

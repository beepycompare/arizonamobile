package com.arizona.launcher.updater.archive.orchestrator;

import coil3.disk.DiskLruCache;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.adoption.AdoptedArchivePackage;
import com.arizona.launcher.updater.archive.adoption.ArchiveInstallAdopter;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveLocalState;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
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
import java.util.Set;
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
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 )2\u00020\u0001:\u0002()BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0000¨\u0006*"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckCoordinator;", "", "gameRoot", "Ljava/io/File;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "downloadRoot", "candidateParser", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;", "manifestResolver", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "installAdopter", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;", "nowEpochMs", "Lkotlin/Function0;", "", "<init>", "(Ljava/io/File;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Ljava/io/File;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidateParser;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;Lkotlin/jvm/functions/Function0;)V", "prepare", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "serverBaseUrl", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adoptExistingInstall", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "root", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "isSafePreCommitRepairState", "", RemoteConfigConstants.ResponseFieldKey.STATE, "rebasePreCommitRepairState", UpdateServiceContract.BundleKey.CURRENT, "remote", "supersededRepairIdentities", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "LivePackageBaseline", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator {
    private final ArchiveManifestCandidateParser candidateParser;
    private final File downloadRoot;
    private final File gameRoot;
    private final ArchiveInstallAdopter installAdopter;
    private final ArchiveManifestResolver manifestResolver;
    private final Function0<Long> nowEpochMs;
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

    public ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore stateStore, File file2, ArchiveManifestCandidateParser candidateParser, ArchiveManifestResolver manifestResolver, ArchiveInstallAdopter installAdopter, Function0<Long> nowEpochMs) {
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(candidateParser, "candidateParser");
        Intrinsics.checkNotNullParameter(manifestResolver, "manifestResolver");
        Intrinsics.checkNotNullParameter(installAdopter, "installAdopter");
        Intrinsics.checkNotNullParameter(nowEpochMs, "nowEpochMs");
        this.gameRoot = file;
        this.stateStore = stateStore;
        this.downloadRoot = file2;
        this.candidateParser = candidateParser;
        this.manifestResolver = manifestResolver;
        this.installAdopter = installAdopter;
        this.nowEpochMs = nowEpochMs;
    }

    public /* synthetic */ ArchiveUpdateCheckCoordinator(File file, DurableArchiveStateStore durableArchiveStateStore, File file2, ArchiveManifestCandidateParser archiveManifestCandidateParser, ArchiveManifestResolver archiveManifestResolver, ArchiveInstallAdopter archiveInstallAdopter, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, durableArchiveStateStore, (i & 4) != 0 ? null : file2, (i & 8) != 0 ? new ArchiveManifestCandidateParser(null, null, 3, null) : archiveManifestCandidateParser, (i & 16) != 0 ? new ArchiveManifestResolver(null, 1, null) : archiveManifestResolver, (i & 32) != 0 ? new ArchiveInstallAdopter(null, 1, null) : archiveInstallAdopter, (i & 64) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1);
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

    /* JADX WARN: Removed duplicated region for block: B:107:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(String str, ArchiveGpu archiveGpu, String str2, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        ArchiveUpdateCheckCoordinator$prepare$1 archiveUpdateCheckCoordinator$prepare$1;
        int i;
        ArchiveUpdaterState archiveUpdaterState;
        ArchiveManifestResolutionResult archiveManifestResolutionResult;
        ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode;
        ArchiveLocalState plannerState;
        if (continuation instanceof ArchiveUpdateCheckCoordinator$prepare$1) {
            archiveUpdateCheckCoordinator$prepare$1 = (ArchiveUpdateCheckCoordinator$prepare$1) continuation;
            if ((archiveUpdateCheckCoordinator$prepare$1.label & Integer.MIN_VALUE) != 0) {
                archiveUpdateCheckCoordinator$prepare$1.label -= Integer.MIN_VALUE;
                Object obj = archiveUpdateCheckCoordinator$prepare$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveUpdateCheckCoordinator$prepare$1.label;
                List<String> sameIdentityRepairPackageIds = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ArchiveStateLoadResult load = this.stateStore.load();
                        try {
                            ArchiveManifestCandidate parse = this.candidateParser.parse(str, archiveGpu);
                            ArchiveFlowSelection select = ArchiveFlowSelector.INSTANCE.select(true, load);
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
                                ArchiveUpdaterState state = loaded != null ? loaded.getState() : null;
                                ArchiveManifestResolver archiveManifestResolver = this.manifestResolver;
                                archiveUpdateCheckCoordinator$prepare$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                archiveUpdateCheckCoordinator$prepare$1.L$1 = SpillingKt.nullOutSpilledVariable(archiveGpu);
                                archiveUpdateCheckCoordinator$prepare$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                                archiveUpdateCheckCoordinator$prepare$1.L$3 = SpillingKt.nullOutSpilledVariable(load);
                                archiveUpdateCheckCoordinator$prepare$1.L$4 = SpillingKt.nullOutSpilledVariable(parse);
                                archiveUpdateCheckCoordinator$prepare$1.L$5 = SpillingKt.nullOutSpilledVariable(select);
                                archiveUpdateCheckCoordinator$prepare$1.L$6 = state;
                                archiveUpdateCheckCoordinator$prepare$1.label = 1;
                                obj = archiveManifestResolver.resolve(parse, str2, state, archiveUpdateCheckCoordinator$prepare$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                archiveUpdaterState = state;
                            }
                        } catch (IllegalArgumentException e) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_MANIFEST_INVALID, e.getMessage());
                        }
                    } catch (Exception e2) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, e2.getMessage());
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    archiveUpdaterState = (ArchiveUpdaterState) archiveUpdateCheckCoordinator$prepare$1.L$6;
                    ArchiveFlowSelection archiveFlowSelection = (ArchiveFlowSelection) archiveUpdateCheckCoordinator$prepare$1.L$5;
                    ArchiveManifestCandidate archiveManifestCandidate = (ArchiveManifestCandidate) archiveUpdateCheckCoordinator$prepare$1.L$4;
                    ArchiveStateLoadResult archiveStateLoadResult = (ArchiveStateLoadResult) archiveUpdateCheckCoordinator$prepare$1.L$3;
                    String str3 = (String) archiveUpdateCheckCoordinator$prepare$1.L$2;
                    ArchiveGpu archiveGpu2 = (ArchiveGpu) archiveUpdateCheckCoordinator$prepare$1.L$1;
                    String str4 = (String) archiveUpdateCheckCoordinator$prepare$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
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
                    return new ArchiveUpdateCheckDecision.Block(archiveUpdateCheckBlockCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{failure.getPackageId(), failure.getDetail()}), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
                }
                ArchiveManifest manifest = ((ArchiveManifestResolutionResult.Success) archiveManifestResolutionResult).getManifest();
                List<ArchivePackage> packages = manifest.getPackages();
                if (!(packages instanceof Collection) || !packages.isEmpty()) {
                    for (ArchivePackage archivePackage : packages) {
                        if (archivePackage.getEntries() == null) {
                            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.ARCHIVE_ENTRY_METADATA_REQUIRED, "archive-only delivery requires the complete ZIP entry inventory");
                        }
                    }
                }
                if (archiveUpdaterState != null && !archiveUpdaterState.isInstallReady() && !ArchiveStateAdapter.INSTANCE.identitiesMatch(archiveUpdaterState, manifest)) {
                    if (!isSafePreCommitRepairState(archiveUpdaterState)) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.INCOMPLETE_MANIFEST_MISMATCH, "remote archive identity changed during an incomplete transaction");
                    }
                    try {
                        ArchiveUpdaterState rebasePreCommitRepairState = rebasePreCommitRepairState(archiveUpdaterState, manifest);
                        try {
                            ArchivePackageArtifactCleaner.INSTANCE.cleanup(this.gameRoot, this.downloadRoot, supersededRepairIdentities(archiveUpdaterState, manifest));
                            try {
                                this.stateStore.save(rebasePreCommitRepairState);
                                this.stateStore.save(rebasePreCommitRepairState);
                                archiveUpdaterState = rebasePreCommitRepairState;
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
                if (archiveUpdaterState == null) {
                    try {
                        archiveUpdaterState = LegacyGameTreeProbe.INSTANCE.isEmptyForArchiveBootstrap(this.gameRoot) ? null : adoptExistingInstall(this.gameRoot, manifest);
                    } catch (Exception e7) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "unable to persist archive adoption state: " + e7.getMessage());
                    }
                }
                if (archiveUpdaterState != null) {
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
                        sameIdentityRepairPackageIds = ArchiveStateAdapter.INSTANCE.sameIdentityRepairPackageIds(archiveUpdaterState);
                    } catch (IllegalStateException e9) {
                        return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, e9.getMessage());
                    }
                }
                ArchiveUpdatePlan plan$default = ArchiveUpdatePlanner.plan$default(ArchiveUpdatePlanner.INSTANCE, manifest, plannerState, null, sameIdentityRepairPackageIds, 4, null);
                return new ArchiveUpdateCheckDecision.UseArchive(plan$default, ArchiveStorageEstimator.INSTANCE.downloadBytes(plan$default, archiveUpdaterState), ArchiveStorageEstimator.INSTANCE.storageRequirements(plan$default, archiveUpdaterState, ArchiveStagingUsage.INSTANCE.bytesByPackage(this.gameRoot, plan$default.getPackages()), ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, plan$default.getPackages())), (archiveUpdaterState == null || !archiveUpdaterState.isPayloadCommitted() || archiveUpdaterState.isInstallReady()) ? false : true);
            }
        }
        archiveUpdateCheckCoordinator$prepare$1 = new ArchiveUpdateCheckCoordinator$prepare$1(this, continuation);
        Object obj2 = archiveUpdateCheckCoordinator$prepare$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateCheckCoordinator$prepare$1.label;
        List<String> sameIdentityRepairPackageIds2 = null;
        if (i != 0) {
        }
        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj2;
        if (archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success) {
        }
    }

    public static /* synthetic */ Object prepare$default(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, String str, ArchiveGpu archiveGpu, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "https://invalid.local/";
        }
        return archiveUpdateCheckCoordinator.prepare(str, archiveGpu, str2, continuation);
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

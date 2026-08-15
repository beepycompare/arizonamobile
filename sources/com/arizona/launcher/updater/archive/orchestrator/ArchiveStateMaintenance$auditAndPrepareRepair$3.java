package com.arizona.launcher.updater.archive.orchestrator;

import androidx.media3.extractor.ts.TsExtractor;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchivePhaseTransitions;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditMode;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditResult;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$auditAndPrepareRepair$3", f = "ArchiveStateMaintenance.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, nl = {TsExtractor.TS_STREAM_TYPE_DTS}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveStateMaintenance$auditAndPrepareRepair$3 extends SuspendLambda implements Function1<Continuation<? super ArchivePayloadAuditResult>, Object> {
    final /* synthetic */ ArchiveInstalledPayloadAuditMode $mode;
    int label;
    final /* synthetic */ ArchiveStateMaintenance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveStateMaintenance$auditAndPrepareRepair$3(ArchiveStateMaintenance archiveStateMaintenance, ArchiveInstalledPayloadAuditMode archiveInstalledPayloadAuditMode, Continuation<? super ArchiveStateMaintenance$auditAndPrepareRepair$3> continuation) {
        super(1, continuation);
        this.this$0 = archiveStateMaintenance;
        this.$mode = archiveInstalledPayloadAuditMode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ArchiveStateMaintenance$auditAndPrepareRepair$3(this.this$0, this.$mode, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchivePayloadAuditResult> continuation) {
        return ((ArchiveStateMaintenance$auditAndPrepareRepair$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$auditAndPrepareRepair$3$1", f = "ArchiveStateMaintenance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$auditAndPrepareRepair$3$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchivePayloadAuditResult>, Object> {
        final /* synthetic */ ArchiveInstalledPayloadAuditMode $mode;
        int label;
        final /* synthetic */ ArchiveStateMaintenance this$0;

        /* compiled from: ArchiveStateMaintenance.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$auditAndPrepareRepair$3$1$WhenMappings */
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ArchiveInstalledPayloadAuditMode.values().length];
                try {
                    iArr[ArchiveInstalledPayloadAuditMode.METADATA_ONLY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ArchiveInstalledPayloadAuditMode.FULL_INTEGRITY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArchiveStateMaintenance archiveStateMaintenance, ArchiveInstalledPayloadAuditMode archiveInstalledPayloadAuditMode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = archiveStateMaintenance;
            this.$mode = archiveInstalledPayloadAuditMode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$mode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchivePayloadAuditResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function0 function0;
            DurableArchiveStateStore durableArchiveStateStore;
            boolean isPayloadCommitted;
            ArchiveInstalledPayloadAuditor archiveInstalledPayloadAuditor;
            Function0 function02;
            DurableArchiveStateStore durableArchiveStateStore2;
            DurableArchiveStateStore durableArchiveStateStore3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                function0 = this.this$0.gameRoot;
                File file = (File) function0.invoke();
                if (file != null) {
                    durableArchiveStateStore = this.this$0.stateStore;
                    ArchiveStateLoadResult load = durableArchiveStateStore.load();
                    ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
                    if (loaded == null) {
                        return new ArchivePayloadAuditResult.Unavailable(ArchivePayloadAuditUnavailableReason.STATE_NOT_LOADED);
                    }
                    ArchiveUpdaterState state = loaded.getState();
                    int i = WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
                    if (i == 1) {
                        isPayloadCommitted = state.isPayloadCommitted();
                    } else if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        isPayloadCommitted = state.isInstallReady();
                    }
                    if (isPayloadCommitted) {
                        archiveInstalledPayloadAuditor = this.this$0.auditor;
                        ArchiveInstalledPayloadAuditResult audit = archiveInstalledPayloadAuditor.audit(file, state, this.$mode);
                        if (audit.isValid()) {
                            return ArchivePayloadAuditResult.Valid.INSTANCE;
                        }
                        HashSet hashSet = CollectionsKt.toHashSet(audit.getMismatchedPackageIds());
                        function02 = this.this$0.nowEpochMs;
                        long longValue = ((Number) function02.invoke()).longValue();
                        List<ArchivePackageJournalEntry> packages = state.getPackages();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
                        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
                            if (hashSet.contains(archivePackageJournalEntry.getPackageId()) && archivePackageJournalEntry.getPhase() == ArchivePackagePhase.COMMITTED) {
                                ArchivePhaseTransitions archivePhaseTransitions = ArchivePhaseTransitions.INSTANCE;
                                ArchivePackageIdentity identity = archivePackageJournalEntry.getIdentity();
                                List<ArchivePackageFileRecord> desiredFiles = archivePackageJournalEntry.getDesiredFiles();
                                if (desiredFiles.isEmpty()) {
                                    desiredFiles = archivePackageJournalEntry.getFiles();
                                }
                                archivePackageJournalEntry = archivePhaseTransitions.beginUpdate(archivePackageJournalEntry, identity, desiredFiles, ArchivePackagePhase.PLANNED, longValue);
                            }
                            arrayList.add(archivePackageJournalEntry);
                        }
                        ArchiveUpdaterState copy$default = ArchiveUpdaterState.copy$default(state, 0, null, null, 0, null, arrayList, null, false, longValue, 95, null);
                        durableArchiveStateStore2 = this.this$0.stateStore;
                        durableArchiveStateStore2.save(copy$default);
                        durableArchiveStateStore3 = this.this$0.stateStore;
                        durableArchiveStateStore3.save(copy$default);
                        return new ArchivePayloadAuditResult.RepairScheduled(audit.getMismatchedPackageIds(), audit.getFirstMismatch());
                    }
                    return new ArchivePayloadAuditResult.Unavailable(ArchivePayloadAuditUnavailableReason.INSTALL_NOT_READY);
                }
                return new ArchivePayloadAuditResult.Unavailable(ArchivePayloadAuditUnavailableReason.GAME_ROOT_MISSING);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$mode, null), this);
        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
    }
}

package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditMode;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadAuditor;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStateMaintenance;", "", "gameRoot", "Lkotlin/Function0;", "Ljava/io/File;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "auditor", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditor;", "nowEpochMs", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditor;Lkotlin/jvm/functions/Function0;)V", "inspectStartup", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupInspection;", "transactionActive", "", "finalizePublishedMetadata", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auditMetadataAndPrepareRepair", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auditAndPrepareRepair", UpdateActivity.UPDATE_MODE, "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditMode;", "(Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStateMaintenance {
    public static final int $stable = ArchiveInstalledPayloadAuditor.$stable | DurableArchiveStateStore.$stable;
    private final ArchiveInstalledPayloadAuditor auditor;
    private final Function0<File> gameRoot;
    private final Function0<Long> nowEpochMs;
    private final DurableArchiveStateStore stateStore;

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveStateMaintenance(Function0<? extends File> gameRoot, DurableArchiveStateStore stateStore, ArchiveInstalledPayloadAuditor auditor, Function0<Long> nowEpochMs) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(stateStore, "stateStore");
        Intrinsics.checkNotNullParameter(auditor, "auditor");
        Intrinsics.checkNotNullParameter(nowEpochMs, "nowEpochMs");
        this.gameRoot = gameRoot;
        this.stateStore = stateStore;
        this.auditor = auditor;
        this.nowEpochMs = nowEpochMs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$1  reason: invalid class name */
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

    public /* synthetic */ ArchiveStateMaintenance(Function0 function0, DurableArchiveStateStore durableArchiveStateStore, ArchiveInstalledPayloadAuditor archiveInstalledPayloadAuditor, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, durableArchiveStateStore, archiveInstalledPayloadAuditor, (i & 8) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1);
    }

    public final ArchiveStartupInspection inspectStartup(boolean z) {
        ArchiveStateLoadResult load = this.stateStore.load();
        ArchiveStartupGuard decide = ArchiveStartupGuardPolicy.INSTANCE.decide(load, z);
        ArchiveStateLoadResult.Corrupt corrupt = load instanceof ArchiveStateLoadResult.Corrupt ? (ArchiveStateLoadResult.Corrupt) load : null;
        return new ArchiveStartupInspection(decide, corrupt != null ? corrupt.getReason() : null);
    }

    public final Object finalizePublishedMetadata(ArchiveManifest archiveManifest, Continuation<? super ArchiveMetadataFinalizationResult> continuation) {
        return ArchiveUpdateTransactionLock.INSTANCE.withLock(new ArchiveStateMaintenance$finalizePublishedMetadata$2(this, archiveManifest, null), continuation);
    }

    public final Object auditMetadataAndPrepareRepair(Continuation<? super ArchivePayloadAuditResult> continuation) {
        return auditAndPrepareRepair(ArchiveInstalledPayloadAuditMode.METADATA_ONLY, continuation);
    }

    public final Object auditAndPrepareRepair(Continuation<? super ArchivePayloadAuditResult> continuation) {
        return auditAndPrepareRepair(ArchiveInstalledPayloadAuditMode.FULL_INTEGRITY, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object auditAndPrepareRepair(ArchiveInstalledPayloadAuditMode archiveInstalledPayloadAuditMode, Continuation<? super ArchivePayloadAuditResult> continuation) {
        return ArchiveUpdateTransactionLock.INSTANCE.withLock(new ArchiveStateMaintenance$auditAndPrepareRepair$3(this, archiveInstalledPayloadAuditMode, null), continuation);
    }
}

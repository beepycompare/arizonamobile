package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$8 extends FunctionReferenceImpl implements Function1<Continuation<? super ArchivePayloadAuditResult>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$8(Object obj) {
        super(1, obj, ArchiveStateMaintenance.class, "auditAndPrepareRepair", "auditAndPrepareRepair(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchivePayloadAuditResult> continuation) {
        return ((ArchiveStateMaintenance) this.receiver).auditAndPrepareRepair(continuation);
    }
}

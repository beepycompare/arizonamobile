package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class UpdateService$onCreate$7 extends FunctionReferenceImpl implements Function2<ArchiveUpdateCheckDecision, ArchiveUpdateSessionSnapshot, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$onCreate$7(Object obj) {
        super(2, obj, UpdateService.class, "onPreparedGameUpdateCheck", "onPreparedGameUpdateCheck(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ArchiveUpdateCheckDecision archiveUpdateCheckDecision, ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot) {
        invoke2(archiveUpdateCheckDecision, archiveUpdateSessionSnapshot);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ArchiveUpdateCheckDecision p0, ArchiveUpdateSessionSnapshot p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((UpdateService) this.receiver).onPreparedGameUpdateCheck(p0, p1);
    }
}

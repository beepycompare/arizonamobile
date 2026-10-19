package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheck", f = "ArchiveCrossLaneUpdateCheck.kt", i = {0, 0, 0, 0}, l = {244}, m = "migrationGate", n = {"migration", "baseRemote", "viceRemote", "viceContentAvailable"}, nl = {243}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneUpdateCheck$migrationGate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveCrossLaneUpdateCheck this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveCrossLaneUpdateCheck$migrationGate$1(ArchiveCrossLaneUpdateCheck archiveCrossLaneUpdateCheck, Continuation<? super ArchiveCrossLaneUpdateCheck$migrationGate$1> continuation) {
        super(continuation);
        this.this$0 = archiveCrossLaneUpdateCheck;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object migrationGate;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        migrationGate = this.this$0.migrationGate(null, null, null, false, this);
        return migrationGate;
    }
}

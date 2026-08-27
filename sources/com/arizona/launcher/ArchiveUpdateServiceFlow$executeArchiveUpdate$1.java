package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow", f = "ArchiveUpdateServiceFlow.kt", i = {0, 0, 0, 0}, l = {295}, m = "executeArchiveUpdate", n = {"plan", "server", "updater", "operationToken"}, nl = {302}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateServiceFlow$executeArchiveUpdate$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$executeArchiveUpdate$1(ArchiveUpdateServiceFlow archiveUpdateServiceFlow, Continuation<? super ArchiveUpdateServiceFlow$executeArchiveUpdate$1> continuation) {
        super(continuation);
        this.this$0 = archiveUpdateServiceFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeArchiveUpdate;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeArchiveUpdate = this.this$0.executeArchiveUpdate(null, null, 0L, this);
        return executeArchiveUpdate;
    }
}

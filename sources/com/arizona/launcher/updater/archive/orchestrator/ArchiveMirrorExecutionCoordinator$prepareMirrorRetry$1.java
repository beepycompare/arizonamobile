package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator", f = "ArchiveMirrorExecutionCoordinator.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {95, 102}, m = "prepareMirrorRetry", n = {"plan", "failure", "failedServer", "plan", "failure", "failedServer", "remainingBytes"}, nl = {96, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, Continuation<? super ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1> continuation) {
        super(continuation);
        this.this$0 = archiveMirrorExecutionCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object prepareMirrorRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prepareMirrorRetry = this.this$0.prepareMirrorRetry(null, null, null, this);
        return prepareMirrorRetry;
    }
}

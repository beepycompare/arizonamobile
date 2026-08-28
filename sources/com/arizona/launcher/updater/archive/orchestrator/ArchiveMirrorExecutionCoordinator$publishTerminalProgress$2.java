package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2", f = "ArchiveMirrorExecutionCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArchiveProgressSample $terminal;
    int label;
    final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, ArchiveProgressSample archiveProgressSample, Continuation<? super ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2> continuation) {
        super(2, continuation);
        this.this$0 = archiveMirrorExecutionCoordinator;
        this.$terminal = archiveProgressSample;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2(this.this$0, this.$terminal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArchiveMirrorExecutionCoordinator$publishTerminalProgress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function0 function0;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            function0 = this.this$0.isCurrentOperation;
            if (((Boolean) function0.invoke()).booleanValue()) {
                archiveMirrorExecutionCallbacks = this.this$0.callbacks;
                archiveMirrorExecutionCallbacks.onDownloadProgress(this.$terminal.getDownloadedBytes(), this.$terminal.getTotalBytes());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

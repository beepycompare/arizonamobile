package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2", f = "ArchiveMirrorExecutionCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $failedServer;
    final /* synthetic */ long $remainingBytes;
    int label;
    final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, long j, String str, Continuation<? super ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2> continuation) {
        super(2, continuation);
        this.this$0 = archiveMirrorExecutionCoordinator;
        this.$remainingBytes = j;
        this.$failedServer = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2(this.this$0, this.$remainingBytes, this.$failedServer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function0 function0;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        Function1 function1;
        Function0 function02;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            function0 = this.this$0.isCurrentOperation;
            if (((Boolean) function0.invoke()).booleanValue()) {
                archiveMirrorExecutionCallbacks = this.this$0.callbacks;
                archiveMirrorExecutionCallbacks.onMirrorProgressReset(this.$remainingBytes);
                function1 = this.this$0.markCurrentServerUnreachable;
                function1.invoke(this.$failedServer);
                function02 = this.this$0.currentServer;
                Object invoke = function02.invoke();
                ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
                String str = (String) invoke;
                archiveUpdateSessionState = archiveMirrorExecutionCoordinator.sessionState;
                archiveUpdateSessionState.updateMirrorServer(str);
                archiveMirrorExecutionCallbacks2 = archiveMirrorExecutionCoordinator.callbacks;
                archiveMirrorExecutionCallbacks2.onMirrorSelected(str);
                return invoke;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

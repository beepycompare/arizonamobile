package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveNetworkMonitor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3", f = "ArchiveNetworkMonitor.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ArchiveNetworkMonitor $this_awaitValidatedNetworkWithin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3(ArchiveNetworkMonitor archiveNetworkMonitor, Continuation<? super ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3> continuation) {
        super(2, continuation);
        this.$this_awaitValidatedNetworkWithin = archiveNetworkMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3(this.$this_awaitValidatedNetworkWithin, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object awaitValidatedNetwork = this.$this_awaitValidatedNetworkWithin.awaitValidatedNetwork(this);
        return awaitValidatedNetwork == coroutine_suspended ? coroutine_suspended : awaitValidatedNetwork;
    }
}

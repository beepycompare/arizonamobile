package com.miami.game.feature.download.screen.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1", f = "DownloadScreenComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadScreenComponent receiver$inlined;
    final /* synthetic */ DownloadScreenComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1(Continuation continuation, DownloadScreenComponent downloadScreenComponent, DownloadScreenComponent downloadScreenComponent2) {
        super(2, continuation);
        this.this$0 = downloadScreenComponent;
        this.receiver$inlined = downloadScreenComponent2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1 downloadScreenComponent$initVmState$$inlined$launchSafe$default$1 = new DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1(continuation, this.this$0, this.receiver$inlined);
        downloadScreenComponent$initVmState$$inlined$launchSafe$default$1.L$0 = obj;
        return downloadScreenComponent$initVmState$$inlined$launchSafe$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1 downloadScreenComponent$initVmState$$inlined$launchSafe$default$1 = this;
                this.this$0.observeExternal();
                BuildersKt__Builders_commonKt.launch$default(this.this$0.getScope(), null, null, new DownloadScreenComponent$initVmState$2$1(this.this$0, null), 3, null);
            } catch (Exception e) {
                this.receiver$inlined.handleError(e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

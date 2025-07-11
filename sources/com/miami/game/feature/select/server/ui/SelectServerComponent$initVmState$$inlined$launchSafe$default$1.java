package com.miami.game.feature.select.server.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/decompose/utils/CoroutineFeatureExtensionsKt$launchSafe$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.select.server.ui.SelectServerComponent$initVmState$$inlined$launchSafe$default$1", f = "SelectServerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SelectServerComponent$initVmState$$inlined$launchSafe$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SelectServerComponent receiver$inlined;
    final /* synthetic */ SelectServerComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectServerComponent$initVmState$$inlined$launchSafe$default$1(Continuation continuation, SelectServerComponent selectServerComponent, SelectServerComponent selectServerComponent2) {
        super(2, continuation);
        this.this$0 = selectServerComponent;
        this.receiver$inlined = selectServerComponent2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectServerComponent$initVmState$$inlined$launchSafe$default$1 selectServerComponent$initVmState$$inlined$launchSafe$default$1 = new SelectServerComponent$initVmState$$inlined$launchSafe$default$1(continuation, this.this$0, this.receiver$inlined);
        selectServerComponent$initVmState$$inlined$launchSafe$default$1.L$0 = obj;
        return selectServerComponent$initVmState$$inlined$launchSafe$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectServerComponent$initVmState$$inlined$launchSafe$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                SelectServerComponent$initVmState$$inlined$launchSafe$default$1 selectServerComponent$initVmState$$inlined$launchSafe$default$1 = this;
                this.this$0.observeServerState();
            } catch (Exception e) {
                this.receiver$inlined.handleError(e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.media3.extractor.ts.TsExtractor;
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation;
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
/* compiled from: PredictiveBackAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$Handler$onBack$1", f = "PredictiveBackAnimation.kt", i = {}, l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class PredictiveBackAnimation$Handler$onBack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PredictiveBackAnimation.Handler<C, T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredictiveBackAnimation$Handler$onBack$1(PredictiveBackAnimation.Handler<C, T> handler, Continuation<? super PredictiveBackAnimation$Handler$onBack$1> continuation) {
        super(2, continuation);
        this.this$0 = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PredictiveBackAnimation$Handler$onBack$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PredictiveBackAnimation$Handler$onBack$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PredictiveBackAnimatable predictiveBackAnimatable;
        Function0 function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            predictiveBackAnimatable = ((PredictiveBackAnimation.Handler) this.this$0).animatable;
            if (predictiveBackAnimatable != null) {
                this.label = 1;
                if (predictiveBackAnimatable.finish(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ((PredictiveBackAnimation.Handler) this.this$0).animatable = null;
        function0 = ((PredictiveBackAnimation.Handler) this.this$0).onBack;
        function0.invoke();
        return Unit.INSTANCE;
    }
}

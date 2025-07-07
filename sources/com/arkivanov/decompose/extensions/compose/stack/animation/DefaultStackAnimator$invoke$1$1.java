package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: DefaultStackAnimator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.stack.animation.DefaultStackAnimator$invoke$1$1", f = "DefaultStackAnimator.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class DefaultStackAnimator$invoke$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationState<Float, AnimationVector1D> $animationState;
    final /* synthetic */ Function0<Unit> $onFinished;
    int label;
    final /* synthetic */ DefaultStackAnimator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultStackAnimator$invoke$1$1(AnimationState<Float, AnimationVector1D> animationState, DefaultStackAnimator defaultStackAnimator, Function0<Unit> function0, Continuation<? super DefaultStackAnimator$invoke$1$1> continuation) {
        super(2, continuation);
        this.$animationState = animationState;
        this.this$0 = defaultStackAnimator;
        this.$onFinished = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultStackAnimator$invoke$1$1(this.$animationState, this.this$0, this.$onFinished, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultStackAnimator$invoke$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FiniteAnimationSpec finiteAnimationSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnimationState<Float, AnimationVector1D> animationState = this.$animationState;
            Float boxFloat = Boxing.boxFloat(0.0f);
            finiteAnimationSpec = this.this$0.animationSpec;
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, boxFloat, finiteAnimationSpec, !AnimationStateKt.isFinished(this.$animationState), null, this, 8, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.$onFinished.invoke();
        return Unit.INSTANCE;
    }
}

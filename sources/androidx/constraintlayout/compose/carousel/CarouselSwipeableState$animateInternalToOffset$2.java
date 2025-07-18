package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2", f = "CarouselSwipeable.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class CarouselSwipeableState$animateInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $spec;
    final /* synthetic */ float $target;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CarouselSwipeableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarouselSwipeableState$animateInternalToOffset$2(CarouselSwipeableState<T> carouselSwipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super CarouselSwipeableState$animateInternalToOffset$2> continuation) {
        super(2, continuation);
        this.this$0 = carouselSwipeableState;
        this.$target = f;
        this.$spec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CarouselSwipeableState$animateInternalToOffset$2 carouselSwipeableState$animateInternalToOffset$2 = new CarouselSwipeableState$animateInternalToOffset$2(this.this$0, this.$target, this.$spec, continuation);
        carouselSwipeableState$animateInternalToOffset$2.L$0 = obj;
        return carouselSwipeableState$animateInternalToOffset$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((CarouselSwipeableState$animateInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState mutableState;
        MutableFloatState mutableFloatState;
        MutableState mutableState2;
        MutableState mutableState3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                mutableFloatState = ((CarouselSwipeableState) this.this$0).absoluteOffset;
                floatRef.element = mutableFloatState.getFloatValue();
                mutableState2 = ((CarouselSwipeableState) this.this$0).animationTarget;
                mutableState2.setValue(Boxing.boxFloat(this.$target));
                this.this$0.setAnimationRunning(true);
                this.label = 1;
                if (Animatable.animateTo$default(AnimatableKt.Animatable$default(floatRef.element, 0.0f, 2, null), Boxing.boxFloat(this.$target), this.$spec, null, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                        invoke2(animatable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                        DragScope.this.dragBy(animatable.getValue().floatValue() - floatRef.element);
                        floatRef.element = animatable.getValue().floatValue();
                    }
                }, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            mutableState3 = ((CarouselSwipeableState) this.this$0).animationTarget;
            mutableState3.setValue(null);
            this.this$0.setAnimationRunning(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableState = ((CarouselSwipeableState) this.this$0).animationTarget;
            mutableState.setValue(null);
            this.this$0.setAnimationRunning(false);
            throw th;
        }
    }
}

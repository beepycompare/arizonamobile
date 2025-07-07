package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
/* compiled from: SnapFlingBehavior.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J:\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010!J.\u0010\"\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0096@¢\u0006\u0002\u0010!JQ\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*JB\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0,*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", TypedValues.CycleType.S_WAVE_OFFSET, "velocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "onRemainingDistanceUpdated", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "updateRemainingScrollOffset", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable = 0;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
    }

    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale motionDurationScale) {
        this.motionScaleDuration = motionDurationScale;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(ScrollScope scrollScope, float f, Function1<? super Float, Unit> function1, Continuation<? super Float> continuation) {
        SnapFlingBehavior$performFling$1 snapFlingBehavior$performFling$1;
        int i;
        if (continuation instanceof SnapFlingBehavior$performFling$1) {
            snapFlingBehavior$performFling$1 = (SnapFlingBehavior$performFling$1) continuation;
            if ((snapFlingBehavior$performFling$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$performFling$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$performFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    snapFlingBehavior$performFling$1.label = 1;
                    obj = fling(scrollScope, f, function1, snapFlingBehavior$performFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                AnimationResult animationResult = (AnimationResult) obj;
                return Boxing.boxFloat(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
            }
        }
        snapFlingBehavior$performFling$1 = new SnapFlingBehavior$performFling$1(this, continuation);
        Object obj2 = snapFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$performFling$1.label;
        if (i != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        return Boxing.boxFloat(((Number) animationResult2.component1()).floatValue() != 0.0f ? ((Number) animationResult2.component2().getVelocity()).floatValue() : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fling(ScrollScope scrollScope, float f, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$fling$1 snapFlingBehavior$fling$1;
        int i;
        Function1<? super Float, Unit> function12;
        if (continuation instanceof SnapFlingBehavior$fling$1) {
            snapFlingBehavior$fling$1 = (SnapFlingBehavior$fling$1) continuation;
            if ((snapFlingBehavior$fling$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$fling$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$fling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$fling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    snapFlingBehavior$fling$1.L$0 = function1;
                    snapFlingBehavior$fling$1.label = 1;
                    obj = BuildersKt.withContext(this.motionScaleDuration, new SnapFlingBehavior$fling$result$1(this, f, function1, scrollScope, null), snapFlingBehavior$fling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    function12 = (Function1) snapFlingBehavior$fling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AnimationResult animationResult = (AnimationResult) obj;
                function12.invoke(Boxing.boxFloat(0.0f));
                return animationResult;
            }
        }
        snapFlingBehavior$fling$1 = new SnapFlingBehavior$fling$1(this, continuation);
        Object obj2 = snapFlingBehavior$fling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$fling$1.label;
        if (i != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        function12.invoke(Boxing.boxFloat(0.0f));
        return animationResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryApproach(ScrollScope scrollScope, float f, float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$1;
        SnapFlingBehavior snapFlingBehavior;
        int i;
        if (continuation instanceof SnapFlingBehavior$tryApproach$1) {
            snapFlingBehavior$tryApproach$1 = (SnapFlingBehavior$tryApproach$1) continuation;
            if ((snapFlingBehavior$tryApproach$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$tryApproach$1.label -= Integer.MIN_VALUE;
                snapFlingBehavior = this;
                SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$12 = snapFlingBehavior$tryApproach$1;
                Object obj = snapFlingBehavior$tryApproach$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehavior$tryApproach$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Math.abs(f) == 0.0f || Math.abs(f2) == 0.0f) {
                        return AnimationStateKt.AnimationState$default(f, f2, 0L, 0L, false, 28, null);
                    }
                    snapFlingBehavior$tryApproach$12.label = 1;
                    obj = snapFlingBehavior.runApproach(scrollScope, f, f2, function1, snapFlingBehavior$tryApproach$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return ((AnimationResult) obj).getCurrentAnimationState();
            }
        }
        snapFlingBehavior = this;
        snapFlingBehavior$tryApproach$1 = new SnapFlingBehavior$tryApproach$1(snapFlingBehavior, continuation);
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$122 = snapFlingBehavior$tryApproach$1;
        Object obj2 = snapFlingBehavior$tryApproach$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehavior$tryApproach$122.label;
        if (i != 0) {
        }
        return ((AnimationResult) obj2).getCurrentAnimationState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runApproach(ScrollScope scrollScope, float f, float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        TargetApproachAnimation targetApproachAnimation;
        Object approach;
        if (isDecayApproachPossible(f, f2)) {
            targetApproachAnimation = new DecayApproachAnimation(this.decayAnimationSpec);
        } else {
            targetApproachAnimation = new TargetApproachAnimation(this.snapAnimationSpec);
        }
        approach = SnapFlingBehaviorKt.approach(scrollScope, f, f2, targetApproachAnimation, function1, continuation);
        return approach;
    }

    private final boolean isDecayApproachPossible(float f, float f2) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, f2)) >= Math.abs(f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            if (Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.snapAnimationSpec.hashCode() * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }
}

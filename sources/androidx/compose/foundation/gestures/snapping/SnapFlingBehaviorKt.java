package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
/* compiled from: SnapFlingBehavior.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082\b\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001f\u001ak\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0&2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u0010,\u001as\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0&2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u00100\u001ae\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"052!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00120(H\u0082@¢\u0006\u0002\u00106\u001a\u0014\u00107\u001a\u00020\b*\u00020\b2\u0006\u00108\u001a\u00020\bH\u0002\u001a(\u00109\u001a\u0002H:\"\u000e\b\u0000\u0010:*\b\u0012\u0004\u0012\u0002H:0;*\b\u0012\u0004\u0012\u0002H:0<H\u0082\u0002¢\u0006\u0002\u0010=\u001a(\u0010>\u001a\u0002H:\"\u000e\b\u0000\u0010:*\b\u0012\u0004\u0012\u0002H:0;*\b\u0012\u0004\u0012\u0002H:0<H\u0082\u0002¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DEBUG", "", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "", "NoVelocity", "calculateFinalOffset", "snappingOffset", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapFlingBehavior", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animateDecay", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateWithTarget", "cancelOffset", "animationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approach", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", TypedValues.AttributesType.S_TARGET, "component1", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = Dp.m6684constructorimpl(400);
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    public static final /* synthetic */ Object access$animateDecay(ScrollScope scrollScope, float f, AnimationState animationState, DecayAnimationSpec decayAnimationSpec, Function1 function1, Continuation continuation) {
        return animateDecay(scrollScope, f, animationState, decayAnimationSpec, function1, continuation);
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec) {
        return new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpec, animationSpec);
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1921733134, "C(rememberSnapFlingBehavior)232@10332L7,233@10402L26,234@10440L310:SnapFlingBehavior.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1921733134, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:231)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object obj = (Density) consume;
        DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 962715205, "CC(remember):SnapFlingBehavior.kt#9igjgp");
        boolean changed = composer.changed(rememberSplineBasedDecay) | ((((i & 14) ^ 6) > 4 && composer.changed(snapLayoutInfoProvider)) || (i & 6) == 4) | composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = snapFlingBehavior(snapLayoutInfoProvider, rememberSplineBasedDecay, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null));
            composer.updateRememberedValue(rememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehavior;
    }

    public static final Object approach(ScrollScope scrollScope, float f, float f2, ApproachAnimation<Float, AnimationVector1D> approachAnimation, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return approachAnimation.approachAnimation(scrollScope, Boxing.boxFloat(f), Boxing.boxFloat(f2), function1, continuation);
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        return closedFloatingPointRange.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        return closedFloatingPointRange.getEndInclusive();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateDecay(final ScrollScope scrollScope, final float f, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$1;
        int i;
        Ref.FloatRef floatRef;
        if (continuation instanceof SnapFlingBehaviorKt$animateDecay$1) {
            snapFlingBehaviorKt$animateDecay$1 = (SnapFlingBehaviorKt$animateDecay$1) continuation;
            if ((snapFlingBehaviorKt$animateDecay$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateDecay$1.label -= Integer.MIN_VALUE;
                Object obj = snapFlingBehaviorKt$animateDecay$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehaviorKt$animateDecay$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    boolean z = animationState.getVelocity().floatValue() == 0.0f;
                    snapFlingBehaviorKt$animateDecay$1.L$0 = animationState;
                    snapFlingBehaviorKt$animateDecay$1.L$1 = floatRef2;
                    snapFlingBehaviorKt$animateDecay$1.F$0 = f;
                    snapFlingBehaviorKt$animateDecay$1.label = 1;
                    if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float coerceToTarget;
                            if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(f)) {
                                coerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), f);
                                SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, coerceToTarget - floatRef2.element);
                                animationScope.cancelAnimation();
                                floatRef2.element = coerceToTarget;
                                return;
                            }
                            SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, animationScope.getValue().floatValue() - floatRef2.element);
                            floatRef2.element = animationScope.getValue().floatValue();
                        }
                    }, snapFlingBehaviorKt$animateDecay$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    floatRef = floatRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f = snapFlingBehaviorKt$animateDecay$1.F$0;
                    floatRef = (Ref.FloatRef) snapFlingBehaviorKt$animateDecay$1.L$1;
                    animationState = (AnimationState) snapFlingBehaviorKt$animateDecay$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return new AnimationResult(Boxing.boxFloat(f - floatRef.element), animationState);
            }
        }
        snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuation);
        Object obj2 = snapFlingBehaviorKt$animateDecay$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehaviorKt$animateDecay$1.label;
        if (i != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f - floatRef.element), animationState);
    }

    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, Function1<? super Float, Unit> function1, float f) {
        float f2;
        if (ComposeFoundationFlags.NewNestedFlingPropagationEnabled) {
            try {
                f2 = scrollScope.scrollBy(f);
            } catch (CancellationException unused) {
                animationScope.cancelAnimation();
                f2 = 0.0f;
            }
        } else {
            f2 = scrollScope.scrollBy(f);
        }
        function1.invoke(Float.valueOf(f2));
        if (Math.abs(f - f2) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateWithTarget(final ScrollScope scrollScope, float f, final float f2, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, final Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$1;
        int i;
        float f3;
        AnimationState<Float, AnimationVector1D> animationState2;
        Ref.FloatRef floatRef;
        float f4;
        if (continuation instanceof SnapFlingBehaviorKt$animateWithTarget$1) {
            snapFlingBehaviorKt$animateWithTarget$1 = (SnapFlingBehaviorKt$animateWithTarget$1) continuation;
            if ((snapFlingBehaviorKt$animateWithTarget$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateWithTarget$1.label -= Integer.MIN_VALUE;
                SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$12 = snapFlingBehaviorKt$animateWithTarget$1;
                Object obj = snapFlingBehaviorKt$animateWithTarget$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapFlingBehaviorKt$animateWithTarget$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    float floatValue = animationState.getVelocity().floatValue();
                    Float boxFloat = Boxing.boxFloat(f);
                    boolean z = animationState.getVelocity().floatValue() == 0.0f;
                    snapFlingBehaviorKt$animateWithTarget$12.L$0 = animationState;
                    snapFlingBehaviorKt$animateWithTarget$12.L$1 = floatRef2;
                    f3 = f;
                    snapFlingBehaviorKt$animateWithTarget$12.F$0 = f3;
                    snapFlingBehaviorKt$animateWithTarget$12.F$1 = floatValue;
                    snapFlingBehaviorKt$animateWithTarget$12.label = 1;
                    if (SuspendAnimationKt.animateTo(animationState, boxFloat, animationSpec, !z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float coerceToTarget;
                            float f5;
                            coerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), f2);
                            float f6 = coerceToTarget - floatRef2.element;
                            if (ComposeFoundationFlags.NewNestedFlingPropagationEnabled) {
                                try {
                                    f5 = scrollScope.scrollBy(f6);
                                } catch (CancellationException unused) {
                                    animationScope.cancelAnimation();
                                    f5 = 0.0f;
                                }
                            } else {
                                f5 = scrollScope.scrollBy(f6);
                            }
                            function1.invoke(Float.valueOf(f5));
                            if (Math.abs(f6 - f5) > 0.5f || coerceToTarget != animationScope.getValue().floatValue()) {
                                animationScope.cancelAnimation();
                            }
                            floatRef2.element += f5;
                        }
                    }, snapFlingBehaviorKt$animateWithTarget$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    animationState2 = animationState;
                    floatRef = floatRef2;
                    f4 = floatValue;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f4 = snapFlingBehaviorKt$animateWithTarget$12.F$1;
                    float f5 = snapFlingBehaviorKt$animateWithTarget$12.F$0;
                    floatRef = (Ref.FloatRef) snapFlingBehaviorKt$animateWithTarget$12.L$1;
                    ResultKt.throwOnFailure(obj);
                    f3 = f5;
                    animationState2 = (AnimationState) snapFlingBehaviorKt$animateWithTarget$12.L$0;
                }
                return new AnimationResult(Boxing.boxFloat(f3 - floatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
            }
        }
        snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuation);
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$122 = snapFlingBehaviorKt$animateWithTarget$1;
        Object obj2 = snapFlingBehaviorKt$animateWithTarget$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapFlingBehaviorKt$animateWithTarget$122.label;
        if (i != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f3 - floatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
    }

    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0017, code lost:
        if (java.lang.Math.abs(r4) <= java.lang.Math.abs(r3)) goto L10;
     */
    /* renamed from: calculateFinalOffset-Fhqu1e0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float m559calculateFinalOffsetFhqu1e0(int i, float f, float f2) {
        if (!FinalSnappingItem.m552equalsimpl0(i, FinalSnappingItem.Companion.m556getClosestItembbeMdSM())) {
            if (!FinalSnappingItem.m552equalsimpl0(i, FinalSnappingItem.Companion.m557getNextItembbeMdSM())) {
                if (!FinalSnappingItem.m552equalsimpl0(i, FinalSnappingItem.Companion.m558getPreviousItembbeMdSM())) {
                    f = 0.0f;
                }
            }
            f = f2;
        }
        if (calculateFinalOffset_Fhqu1e0$isValidDistance(f)) {
            return f;
        }
        return 0.0f;
    }
}

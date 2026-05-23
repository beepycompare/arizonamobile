package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007\u001ah\u0010\u0000\u001a\u00020\u00012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\f\u001aZ\u0010\u000e\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001ao\u0010\u000e\u001a\u00020\u00012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0002\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001a6\u0010\u0011\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001a6\u0010\u0018\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001a\u0010\u0017\u001a,\u0010\u001b\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0087@¢\u0006\u0004\b\u001d\u0010\u001e\u001a6\u0010\u001b\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001f\u0010 \u001a\\\u0010!\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0004\b'\u0010(\u001af\u0010!\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b)\u0010*\u001a\u001a\u0010-\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010.\u001a&\u0010-\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b/\u00100\u001a\u001a\u00101\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010.\u001a&\u00101\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b2\u00100\u001a\u001c\u00103\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\bH\u0087@¢\u0006\u0004\b4\u00105\u001a&\u00103\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b6\u00107\u001a\u001c\u00108\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;\"\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "Lkotlin/Function4;", "centroid", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animateZoomBy", "zoomFactor", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy-Fgt4K4Q", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "animateRotateBy-Fgt4K4Q", "animatePanBy", TypedValues.CycleType.S_WAVE_OFFSET, "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animatePanBy-umk_asQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy", "panOffset", "rotationDegrees", "zoomAnimationSpec", "panAnimationSpec", "rotationAnimationSpec", "animateBy-Su4bsnU", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy-jlnHOkQ", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ZeroAnimationVelocity", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy-Rg1IO4c", "(Landroidx/compose/foundation/gestures/TransformableState;FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "rotateBy-Rg1IO4c", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "panBy-DUneCvk", "(Landroidx/compose/foundation/gestures/TransformableState;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformableStateKt {
    private static final AnimationData ZeroAnimationVelocity = new AnimationData(0.0f, Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null);

    @Deprecated(message = "Prefer creating TransformableState with a onTransformation lambda that takes the centroid. This centroid (if specified) is the point at which zooming or rotation should happen around which allows for more natural transformations.")
    public static final TransformableState TransformableState(final Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        return TransformableState(new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TransformableStateKt.TransformableState$lambda$0(Function3.this, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TransformableState$lambda$0(Function3 function3, Offset offset, float f, Offset offset2, float f2) {
        function3.invoke(Float.valueOf(f), offset2, Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    public static final TransformableState TransformableState(Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit> function4) {
        return new DefaultTransformableState(function4);
    }

    @Deprecated(message = "Prefer remembering a TransformableState with a onTransformation lambda that takes the centroid. This centroid (if specified) is the point at which zooming or rotation should happen around which allows for more natural transformations.")
    public static final TransformableState rememberTransformableState(final Function3<? super Float, ? super Offset, ? super Float, Unit> function3, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1681419281, "C(rememberTransformableState)N(onTransformation)189@9448L43,189@9421L70:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:189)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 936231388, "CC(remember):TransformableState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(function3)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit rememberTransformableState$lambda$0$0;
                    rememberTransformableState$lambda$0$0 = TransformableStateKt.rememberTransformableState$lambda$0$0(Function3.this, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
                    return rememberTransformableState$lambda$0$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TransformableState rememberTransformableState = rememberTransformableState((Function4) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rememberTransformableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberTransformableState$lambda$0$0(Function3 function3, Offset offset, float f, Offset offset2, float f2) {
        function3.invoke(Float.valueOf(f), offset2, Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    public static final TransformableState rememberTransformableState(Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit> function4, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -963411216, "C(rememberTransformableState)N(onTransformation)211@10617L38,212@10667L86:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-963411216, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:210)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1874765318, "CC(remember):TransformableState.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TransformableState(new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit rememberTransformableState$lambda$1$0;
                    rememberTransformableState$lambda$1$0 = TransformableStateKt.rememberTransformableState$lambda$1$0(State.this, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
                    return rememberTransformableState$lambda$1$0;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        TransformableState transformableState = (TransformableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transformableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberTransformableState$lambda$1$0(State state, Offset offset, float f, Offset offset2, float f2) {
        ((Function4) state.getValue()).invoke(offset, Float.valueOf(f), offset2, Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object animateZoomBy(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation) {
        Object m663animateZoomByFgt4K4Q = m663animateZoomByFgt4K4Q(transformableState, f, animationSpec, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m663animateZoomByFgt4K4Q == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m663animateZoomByFgt4K4Q : Unit.INSTANCE;
    }

    /* renamed from: animateZoomBy-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ Object m664animateZoomByFgt4K4Q$default(TransformableState transformableState, float f, AnimationSpec animationSpec, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m663animateZoomByFgt4K4Q(transformableState, f, animationSpec2, j, continuation);
    }

    /* renamed from: animateZoomBy-Fgt4K4Q  reason: not valid java name */
    public static final Object m663animateZoomByFgt4K4Q(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, long j, Continuation<? super Unit> continuation) {
        if (!(f > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 1.0f;
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animateZoomBy$4(floatRef, f, animationSpec, j, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object animateRotateBy(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation) {
        Object m661animateRotateByFgt4K4Q = m661animateRotateByFgt4K4Q(transformableState, f, animationSpec, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m661animateRotateByFgt4K4Q == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m661animateRotateByFgt4K4Q : Unit.INSTANCE;
    }

    /* renamed from: animateRotateBy-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ Object m662animateRotateByFgt4K4Q$default(TransformableState transformableState, float f, AnimationSpec animationSpec, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m661animateRotateByFgt4K4Q(transformableState, f, animationSpec2, j, continuation);
    }

    /* renamed from: animateRotateBy-Fgt4K4Q  reason: not valid java name */
    public static final Object m661animateRotateByFgt4K4Q(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, long j, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animateRotateBy$3(new Ref.FloatRef(), f, animationSpec, j, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default  reason: not valid java name */
    public static /* synthetic */ Object m658animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m657animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: animatePanBy-ubNVwUQ  reason: not valid java name */
    public static final /* synthetic */ Object m657animatePanByubNVwUQ(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation) {
        Object m659animatePanByumk_asQ = m659animatePanByumk_asQ(transformableState, j, animationSpec, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m659animatePanByumk_asQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m659animatePanByumk_asQ : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-umk_asQ$default  reason: not valid java name */
    public static /* synthetic */ Object m660animatePanByumk_asQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j2 = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m659animatePanByumk_asQ(transformableState, j, animationSpec2, j2, continuation);
    }

    /* renamed from: animatePanBy-umk_asQ  reason: not valid java name */
    public static final Object m659animatePanByumk_asQ(TransformableState transformableState, long j, AnimationSpec<Offset> animationSpec, long j2, Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.Companion.m5119getZeroF1C5BW0();
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animatePanBy$3(longRef, j, animationSpec, j2, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: animateBy-Su4bsnU  reason: not valid java name */
    public static final /* synthetic */ Object m653animateBySu4bsnU(TransformableState transformableState, float f, long j, float f2, AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, Continuation continuation) {
        Object m655animateByjlnHOkQ = m655animateByjlnHOkQ(transformableState, f, j, f2, animationSpec, animationSpec2, animationSpec3, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m655animateByjlnHOkQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m655animateByjlnHOkQ : Unit.INSTANCE;
    }

    /* renamed from: animateBy-jlnHOkQ$default  reason: not valid java name */
    public static /* synthetic */ Object m656animateByjlnHOkQ$default(TransformableState transformableState, float f, long j, float f2, AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, long j2, Continuation continuation, int i, Object obj) {
        long j3;
        TransformableState transformableState2;
        float f3;
        long j4;
        float f4;
        Continuation continuation2;
        SpringSpec springSpec = (i & 8) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec;
        SpringSpec springSpec2 = (i & 16) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec2;
        SpringSpec springSpec3 = (i & 32) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec3;
        if ((i & 64) != 0) {
            j3 = Offset.Companion.m5118getUnspecifiedF1C5BW0();
            f3 = f;
            j4 = j;
            f4 = f2;
            continuation2 = continuation;
            transformableState2 = transformableState;
        } else {
            j3 = j2;
            transformableState2 = transformableState;
            f3 = f;
            j4 = j;
            f4 = f2;
            continuation2 = continuation;
        }
        return m655animateByjlnHOkQ(transformableState2, f3, j4, f4, springSpec, springSpec2, springSpec3, j3, continuation2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.foundation.gestures.AnimationData] */
    /* renamed from: animateBy-jlnHOkQ  reason: not valid java name */
    public static final Object m655animateByjlnHOkQ(TransformableState transformableState, float f, long j, float f2, AnimationSpec<Float> animationSpec, AnimationSpec<Offset> animationSpec2, AnimationSpec<Float> animationSpec3, long j2, Continuation<? super Unit> continuation) {
        if (!(f > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new AnimationData(1.0f, Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null);
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animateBy$4(objectRef, new AnimationData(f, j, f2, null), new DelegatingAnimationSpec(animationSpec, animationSpec2, animationSpec3), j2, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object zoomBy(TransformableState transformableState, float f, Continuation continuation) {
        Object m670zoomByRg1IO4c = m670zoomByRg1IO4c(transformableState, f, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m670zoomByRg1IO4c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m670zoomByRg1IO4c : Unit.INSTANCE;
    }

    /* renamed from: zoomBy-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ Object m671zoomByRg1IO4c$default(TransformableState transformableState, float f, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m670zoomByRg1IO4c(transformableState, f, j, continuation);
    }

    /* renamed from: zoomBy-Rg1IO4c  reason: not valid java name */
    public static final Object m670zoomByRg1IO4c(TransformableState transformableState, float f, long j, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$zoomBy$3(j, f, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object rotateBy(TransformableState transformableState, float f, Continuation continuation) {
        Object m668rotateByRg1IO4c = m668rotateByRg1IO4c(transformableState, f, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m668rotateByRg1IO4c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m668rotateByRg1IO4c : Unit.INSTANCE;
    }

    /* renamed from: rotateBy-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ Object m669rotateByRg1IO4c$default(TransformableState transformableState, float f, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m668rotateByRg1IO4c(transformableState, f, j, continuation);
    }

    /* renamed from: rotateBy-Rg1IO4c  reason: not valid java name */
    public static final Object m668rotateByRg1IO4c(TransformableState transformableState, float f, long j, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$rotateBy$3(j, f, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: panBy-d-4ec7I  reason: not valid java name */
    public static final /* synthetic */ Object m667panByd4ec7I(TransformableState transformableState, long j, Continuation continuation) {
        Object m665panByDUneCvk = m665panByDUneCvk(transformableState, j, Offset.Companion.m5118getUnspecifiedF1C5BW0(), continuation);
        return m665panByDUneCvk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m665panByDUneCvk : Unit.INSTANCE;
    }

    /* renamed from: panBy-DUneCvk$default  reason: not valid java name */
    public static /* synthetic */ Object m666panByDUneCvk$default(TransformableState transformableState, long j, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return m665panByDUneCvk(transformableState, j, j2, continuation);
    }

    /* renamed from: panBy-DUneCvk  reason: not valid java name */
    public static final Object m665panByDUneCvk(TransformableState transformableState, long j, long j2, Continuation<? super Unit> continuation) {
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$panBy$3(j2, j, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        Object transform = transformableState.transform(mutatePriority, new TransformableStateKt$stopTransformation$2(null), continuation);
        return transform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform : Unit.INSTANCE;
    }
}

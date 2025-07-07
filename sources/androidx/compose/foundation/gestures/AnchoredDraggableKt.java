package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aM\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002\u001a\u0093\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018\"\u0004\b\u0000\u0010\u00162\u0006\u0010 \u001a\u0002H\u00162!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112#\b\u0002\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010&\u001a¡\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018\"\u0004\b\u0000\u0010\u00162\u0006\u0010 \u001a\u0002H\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00160(2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112#\b\u0002\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010)\u001a5\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00160(\"\b\b\u0000\u0010\u0016*\u00020+2\u001d\u0010,\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160-\u0012\u0004\u0012\u00020.0\u0001¢\u0006\u0002\b/\u001aU\u00100\u001a\u000201\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u00102\u001a\u0002032!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0000\u001a\u0017\u00104\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH\u0082\b\u001a\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002H\u001607\"\u0004\b\u0000\u0010\u0016H\u0002\u001aF\u00108\u001a\u00020.\"\u0004\b\u0000\u001092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H90\u001e2\"\u0010;\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H9\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0=\u0012\u0006\u0012\u0004\u0018\u00010+0<H\u0082@¢\u0006\u0002\u0010>\u001aT\u0010?\u001a\u00020@\"\u0004\b\u0000\u0010\u0016*\u00020@2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u001a`\u0010?\u001a\u00020@\"\u0004\b\u0000\u0010\u0016*\u00020@2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010J\u001a\u00020\u00032\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IH\u0007\u001a\\\u0010?\u001a\u00020@\"\u0004\b\u0000\u0010\u0016*\u00020@2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010K\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u001ah\u0010?\u001a\u00020@\"\u0004\b\u0000\u0010\u0016*\u00020@2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010K\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010J\u001a\u00020\u00032\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IH\u0007\u001a6\u0010L\u001a\u00020.\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010M\u001a\u0002H\u00162\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0086@¢\u0006\u0002\u0010O\u001aR\u0010L\u001a\u00020.\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020R2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00160(2\u0006\u0010S\u001a\u0002H\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0082@¢\u0006\u0002\u0010T\u001aN\u0010U\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010M\u001a\u0002H\u00162\u0006\u0010P\u001a\u00020\u000f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086@¢\u0006\u0002\u0010V\u001a\u0014\u0010W\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010X\u001a\u00020\u000fH\u0002\u001a^\u0010Y\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160(2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002¢\u0006\u0002\u0010[\u001aQ\u0010\\\u001a\u00020.\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160(26\u0010;\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(]\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020.0<H\u0086\b\u001a&\u0010_\u001a\u00020.\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010M\u001a\u0002H\u0016H\u0086@¢\u0006\u0002\u0010`\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "AnchoredDraggableMinFlingVelocity", "Landroidx/compose/ui/unit/Dp;", "getAnchoredDraggableMinFlingVelocity", "()F", "F", "ConfigurationMovedToModifier", "", "ConfirmValueChangeDeprecated", "DEBUG", "GetOrNan", "", "", "NoOpDecayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "SettleWithVelocityDeprecated", "StartDragImmediatelyDeprecated", "AnchoredDraggableLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", ExifInterface.GPS_DIRECTION_TRUE, RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "positionalThreshold", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "AnchoredDraggableState", "initialValue", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "confirmValueChange", "newValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "DraggableAnchors", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "anchoredDraggableFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "density", "Landroidx/compose/ui/unit/Density;", "debugLog", "generateMsg", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "restartable", "I", "inputs", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "startDragImmediately", "reverseDirection", "animateTo", "targetValue", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", TypedValues.AttributesType.S_TARGET, "computeTarget", "currentOffset", "(Landroidx/compose/foundation/gestures/DraggableAnchors;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "forEach", "key", "position", "snapTo", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {
    private static final String ConfigurationMovedToModifier = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to anchoredDraggableFlingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.";
    private static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";
    private static final boolean DEBUG = false;
    private static final String SettleWithVelocityDeprecated = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSamples.kt for example usages.";
    private static final String StartDragImmediatelyDeprecated = "startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.";
    private static final Function1<PointerInputChange, Boolean> AlwaysDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AlwaysDrag$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return true;
        }
    };
    private static final Function1<Integer, Float> GetOrNan = new Function1<Integer, Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$GetOrNan$1
        public final Float invoke(int i) {
            return Float.valueOf(Float.NaN);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Integer num) {
            return invoke(num.intValue());
        }
    };
    private static final float AnchoredDraggableMinFlingVelocity = Dp.m6684constructorimpl(125);
    private static final DecayAnimationSpec<Float> NoOpDecayAnimationSpec = DecayAnimationSpecKt.generateDecayAnimationSpec(new FloatDecayAnimationSpec() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$NoOpDecayAnimationSpec$1
        private final float absVelocityThreshold;

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public long getDurationNanos(float f, float f2) {
            return 0L;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getTargetValue(float f, float f2) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getValueFromNanos(long j, float f, float f2) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getVelocityFromNanos(long j, float f, float f2) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getAbsVelocityThreshold() {
            return this.absVelocityThreshold;
        }
    });

    private static final void debugLog(Function0<String> function0) {
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        boolean z3;
        Orientation orientation2;
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        MutableInteractionSource mutableInteractionSource2 = (i & 16) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 32) != 0 ? null : overscrollEffect;
        if ((i & 64) != 0) {
            flingBehavior2 = null;
            anchoredDraggableState2 = anchoredDraggableState;
            z3 = z;
            orientation2 = orientation;
            modifier2 = modifier;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            z3 = z;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, z3, orientation2, z4, mutableInteractionSource2, overscrollEffect2, flingBehavior2);
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z2, Boolean.valueOf(z), mutableInteractionSource, null, overscrollEffect, flingBehavior, 32, null));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z3, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        boolean z4;
        Orientation orientation2;
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z5 = z2;
        MutableInteractionSource mutableInteractionSource2 = (i & 16) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 32) != 0 ? null : overscrollEffect;
        boolean isAnimationRunning = (i & 64) != 0 ? anchoredDraggableState.isAnimationRunning() : z3;
        if ((i & 128) != 0) {
            flingBehavior2 = null;
            modifier2 = modifier;
            z4 = z;
            orientation2 = orientation;
            anchoredDraggableState2 = anchoredDraggableState;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            z4 = z;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, z4, orientation2, z5, mutableInteractionSource2, overscrollEffect2, isAnimationRunning, flingBehavior2);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, boolean z, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z3, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z2, Boolean.valueOf(z), mutableInteractionSource, Boolean.valueOf(z3), overscrollEffect, flingBehavior));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z, (i & 8) != 0 ? null : mutableInteractionSource, (i & 16) != 0 ? null : overscrollEffect, (i & 32) != 0 ? null : flingBehavior);
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z, null, mutableInteractionSource, null, overscrollEffect, flingBehavior, 32, null));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z2, FlingBehavior flingBehavior, int i, Object obj) {
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        Orientation orientation2;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        MutableInteractionSource mutableInteractionSource2 = (i & 8) != 0 ? null : mutableInteractionSource;
        OverscrollEffect overscrollEffect2 = (i & 16) != 0 ? null : overscrollEffect;
        if ((i & 32) != 0) {
            z2 = anchoredDraggableState.isAnimationRunning();
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            flingBehavior2 = null;
            anchoredDraggableState2 = anchoredDraggableState;
            orientation2 = orientation;
            modifier2 = modifier;
        } else {
            flingBehavior2 = flingBehavior;
            modifier2 = modifier;
            anchoredDraggableState2 = anchoredDraggableState;
            orientation2 = orientation;
        }
        return anchoredDraggable(modifier2, anchoredDraggableState2, orientation2, z3, mutableInteractionSource2, overscrollEffect2, z4, flingBehavior2);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z2, FlingBehavior flingBehavior) {
        return modifier.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, z, null, mutableInteractionSource, Boolean.valueOf(z2), overscrollEffect, flingBehavior));
    }

    public static final <T> void forEach(DraggableAnchors<T> draggableAnchors, Function2<? super T, ? super Float, Unit> function2) {
        int size = draggableAnchors.getSize();
        for (int i = 0; i < size; i++) {
            T anchorAt = draggableAnchors.anchorAt(i);
            if (anchorAt == null) {
                throw new IllegalArgumentException(("There was no key at index " + i + ". Please report a bug.").toString());
            }
            function2.invoke(anchorAt, Float.valueOf(draggableAnchors.positionAt(i)));
        }
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new DefaultDraggableAnchors(draggableAnchorsConfig.buildKeys$foundation_release(), draggableAnchorsConfig.buildPositions$foundation_release());
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, int i, Object obj2) {
        if ((i & 32) != 0) {
            function12 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AnchoredDraggableState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj3) {
                    return invoke((AnchoredDraggableKt$AnchoredDraggableState$1<T>) obj3);
                }
            };
        }
        return AnchoredDraggableState(obj, function1, function0, animationSpec, decayAnimationSpec, function12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        AnchoredDraggableState<T> anchoredDraggableState = new AnchoredDraggableState<>(t, function12);
        anchoredDraggableState.setPositionalThreshold$foundation_release(function1);
        anchoredDraggableState.setVelocityThreshold$foundation_release(function0);
        anchoredDraggableState.setSnapAnimationSpec$foundation_release(animationSpec);
        anchoredDraggableState.setDecayAnimationSpec$foundation_release(decayAnimationSpec);
        return anchoredDraggableState;
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, int i, Object obj2) {
        if ((i & 64) != 0) {
            function12 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AnchoredDraggableState$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj3) {
                    return invoke((AnchoredDraggableKt$AnchoredDraggableState$3<T>) obj3);
                }
            };
        }
        return AnchoredDraggableState(obj, draggableAnchors, function1, function0, animationSpec, decayAnimationSpec, function12);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        AnchoredDraggableState<T> anchoredDraggableState = new AnchoredDraggableState<>(t, draggableAnchors, function12);
        anchoredDraggableState.setPositionalThreshold$foundation_release(function1);
        anchoredDraggableState.setVelocityThreshold$foundation_release(function0);
        anchoredDraggableState.setSnapAnimationSpec$foundation_release(animationSpec);
        anchoredDraggableState.setDecayAnimationSpec$foundation_release(decayAnimationSpec);
        return anchoredDraggableState;
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnchoredDraggableKt$snapTo$2(null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, float f, final AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object animate;
        float positionOf = draggableAnchors.positionOf(t);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.isNaN(anchoredDraggableState.getOffset()) ? 0.0f : anchoredDraggableState.getOffset();
        return (Float.isNaN(positionOf) || floatRef.element == positionOf || (animate = SuspendAnimationKt.animate(floatRef.element, positionOf, f, animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Float f2, Float f3) {
                invoke(f2.floatValue(), f3.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f2, float f3) {
                AnchoredDragScope.this.dragTo(f2, f3);
                floatRef.element = f2;
            }
        }, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : animate;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation_release()) {
                animationSpec = anchoredDraggableState.getSnapAnimationSpec();
            } else {
                animationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            }
        }
        return animateTo(anchoredDraggableState, obj, animationSpec, continuation);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnchoredDraggableKt$animateTo$4(anchoredDraggableState, animationSpec, null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object animateToWithDecay(AnchoredDraggableState<T> anchoredDraggableState, T t, float f, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super Float> continuation) {
        AnchoredDraggableKt$animateToWithDecay$1 anchoredDraggableKt$animateToWithDecay$1;
        int i;
        float f2;
        Ref.FloatRef floatRef;
        if (continuation instanceof AnchoredDraggableKt$animateToWithDecay$1) {
            anchoredDraggableKt$animateToWithDecay$1 = (AnchoredDraggableKt$animateToWithDecay$1) continuation;
            if ((anchoredDraggableKt$animateToWithDecay$1.label & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$animateToWithDecay$1.label -= Integer.MIN_VALUE;
                AnchoredDraggableKt$animateToWithDecay$1 anchoredDraggableKt$animateToWithDecay$12 = anchoredDraggableKt$animateToWithDecay$1;
                Object obj = anchoredDraggableKt$animateToWithDecay$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anchoredDraggableKt$animateToWithDecay$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    floatRef2.element = f;
                    anchoredDraggableKt$animateToWithDecay$12.L$0 = floatRef2;
                    anchoredDraggableKt$animateToWithDecay$12.F$0 = f;
                    anchoredDraggableKt$animateToWithDecay$12.label = 1;
                    if (AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnchoredDraggableKt$animateToWithDecay$2(anchoredDraggableState, f, animationSpec, floatRef2, decayAnimationSpec, null), anchoredDraggableKt$animateToWithDecay$12, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f2 = f;
                    floatRef = floatRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f2 = anchoredDraggableKt$animateToWithDecay$12.F$0;
                    floatRef = (Ref.FloatRef) anchoredDraggableKt$animateToWithDecay$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxFloat(f2 - floatRef.element);
            }
        }
        anchoredDraggableKt$animateToWithDecay$1 = new AnchoredDraggableKt$animateToWithDecay$1(continuation);
        AnchoredDraggableKt$animateToWithDecay$1 anchoredDraggableKt$animateToWithDecay$122 = anchoredDraggableKt$animateToWithDecay$1;
        Object obj2 = anchoredDraggableKt$animateToWithDecay$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anchoredDraggableKt$animateToWithDecay$122.label;
        if (i != 0) {
        }
        return Boxing.boxFloat(f2 - floatRef.element);
    }

    public static /* synthetic */ Object animateToWithDecay$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Continuation continuation, int i, Object obj2) {
        DecayAnimationSpec<Float> decayAnimationSpec2;
        if ((i & 4) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation_release()) {
                animationSpec = anchoredDraggableState.getSnapAnimationSpec();
            } else {
                animationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            }
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 8) != 0) {
            if (anchoredDraggableState.getUsePreModifierChangeBehavior$foundation_release()) {
                decayAnimationSpec2 = anchoredDraggableState.getDecayAnimationSpec();
            } else {
                decayAnimationSpec2 = AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
            }
            decayAnimationSpec = decayAnimationSpec2;
        }
        return animateToWithDecay(anchoredDraggableState, obj, f, animationSpec2, decayAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T computeTarget(DraggableAnchors<T> draggableAnchors, float f, float f2, Function1<? super Float, Float> function1, Function0<Float> function0) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("The offset provided to computeTarget must not be NaN.".toString());
        }
        boolean z = Math.abs(f2) > 0.0f;
        boolean z2 = z && f2 > 0.0f;
        if (!z) {
            T closestAnchor = draggableAnchors.closestAnchor(f);
            Intrinsics.checkNotNull(closestAnchor);
            return closestAnchor;
        } else if (Math.abs(f2) >= Math.abs(function0.invoke().floatValue())) {
            T closestAnchor2 = draggableAnchors.closestAnchor(f, z2);
            Intrinsics.checkNotNull(closestAnchor2);
            return closestAnchor2;
        } else {
            T closestAnchor3 = draggableAnchors.closestAnchor(f, false);
            Intrinsics.checkNotNull(closestAnchor3);
            float positionOf = draggableAnchors.positionOf(closestAnchor3);
            T closestAnchor4 = draggableAnchors.closestAnchor(f, true);
            Intrinsics.checkNotNull(closestAnchor4);
            float positionOf2 = draggableAnchors.positionOf(closestAnchor4);
            float abs = Math.abs(function1.invoke(Float.valueOf(Math.abs(positionOf - positionOf2))).floatValue());
            if (!z2) {
                positionOf = positionOf2;
            }
            boolean z3 = Math.abs(positionOf - f) >= abs;
            if (z3) {
                return z2 ? closestAnchor4 : closestAnchor3;
            } else if (z3) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (z2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? RangesKt.coerceAtMost(f, f2) : RangesKt.coerceAtLeast(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <I> Object restartable(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$restartable$1 anchoredDraggableKt$restartable$1;
        int i;
        if (continuation instanceof AnchoredDraggableKt$restartable$1) {
            anchoredDraggableKt$restartable$1 = (AnchoredDraggableKt$restartable$1) continuation;
            if ((anchoredDraggableKt$restartable$1.label & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$restartable$1.label -= Integer.MIN_VALUE;
                Object obj = anchoredDraggableKt$restartable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anchoredDraggableKt$restartable$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    anchoredDraggableKt$restartable$1.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnchoredDraggableKt$restartable$2(function0, function2, null), anchoredDraggableKt$restartable$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuation);
        Object obj2 = anchoredDraggableKt$restartable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anchoredDraggableKt$restartable$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> DefaultDraggableAnchors<T> emptyDraggableAnchors() {
        return new DefaultDraggableAnchors<>(CollectionsKt.emptyList(), new float[0]);
    }

    public static final float getAnchoredDraggableMinFlingVelocity() {
        return AnchoredDraggableMinFlingVelocity;
    }

    public static final <T> TargetedFlingBehavior anchoredDraggableFlingBehavior(AnchoredDraggableState<T> anchoredDraggableState, final Density density, Function1<? super Float, Float> function1, AnimationSpec<Float> animationSpec) {
        return SnapFlingBehaviorKt.snapFlingBehavior(AnchoredDraggableLayoutInfoProvider(anchoredDraggableState, function1, new Function0<Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$anchoredDraggableFlingBehavior$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(Density.this.mo389toPx0680j_4(Dp.m6684constructorimpl(125)));
            }
        }), NoOpDecayAnimationSpec, animationSpec);
    }

    private static final <T> SnapLayoutInfoProvider AnchoredDraggableLayoutInfoProvider(final AnchoredDraggableState<T> anchoredDraggableState, final Function1<? super Float, Float> function1, final Function0<Float> function0) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float f, float f2) {
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float f) {
                Object computeTarget;
                float requireOffset = anchoredDraggableState.requireOffset();
                computeTarget = AnchoredDraggableKt.computeTarget(anchoredDraggableState.getAnchors(), requireOffset, f, function1, function0);
                return anchoredDraggableState.getAnchors().positionOf(computeTarget) - requireOffset;
            }
        };
    }
}

package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoundsAnimation.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u001f\u001a\u00020 2\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\fJ\"\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017RW\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R;\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u00105\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010<\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u0010'¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/BoundsAnimation;", "", "transitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "", "animation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "momentumOffset", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function0;)V", "getTransitionScope", "()Landroidx/compose/animation/SharedTransitionScope;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getMomentumOffset", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "getAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "updateAnimation", "", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "boundsTransform$delegate", "isRunning", "()Z", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/runtime/State;", "animationState", "getAnimationState", "()Landroidx/compose/runtime/State;", "setAnimationState", "(Landroidx/compose/runtime/State;)V", "animationState$delegate", "value", "getValue", "()Landroidx/compose/ui/geometry/Rect;", "animate", "currentBounds", "targetBounds", "forcedBoundsTransform", TypedValues.AttributesType.S_TARGET, "getTarget"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BoundsAnimation {
    public static final int $stable = 8;
    private final MutableState animation$delegate;
    private FiniteAnimationSpec<Rect> animationSpec;
    private final MutableState animationState$delegate;
    private final MutableState boundsTransform$delegate;
    private final Function0<Offset> momentumOffset;
    private final Transition<Boolean> transition;
    private final SharedTransitionScope transitionScope;

    public BoundsAnimation(SharedTransitionScope sharedTransitionScope, Transition<Boolean> transition, Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimation, BoundsTransform boundsTransform, Function0<Offset> function0) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.transitionScope = sharedTransitionScope;
        this.transition = transition;
        this.momentumOffset = function0;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(deferredAnimation, null, 2, null);
        this.animation$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsTransform, null, 2, null);
        this.boundsTransform$delegate = mutableStateOf$default2;
        this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationState$delegate = mutableStateOf$default3;
    }

    public final SharedTransitionScope getTransitionScope() {
        return this.transitionScope;
    }

    public final Transition<Boolean> getTransition() {
        return this.transition;
    }

    public final Function0<Offset> getMomentumOffset() {
        return this.momentumOffset;
    }

    private final void setAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimation) {
        this.animation$delegate.setValue(deferredAnimation);
    }

    public final Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> getAnimation() {
        return (Transition.DeferredAnimation) this.animation$delegate.getValue();
    }

    public final void updateAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimation, BoundsTransform boundsTransform) {
        if (!Intrinsics.areEqual(getAnimation(), deferredAnimation)) {
            setAnimation(deferredAnimation);
            setAnimationState(null);
            this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        }
        setBoundsTransform(boundsTransform);
    }

    private final BoundsTransform getBoundsTransform() {
        return (BoundsTransform) this.boundsTransform$delegate.getValue();
    }

    private final void setBoundsTransform(BoundsTransform boundsTransform) {
        this.boundsTransform$delegate.setValue(boundsTransform);
    }

    public final boolean isRunning() {
        Transition<?> transition = this.transition;
        while (transition.getParentTransition() != null) {
            transition = transition.getParentTransition();
            Intrinsics.checkNotNull(transition);
        }
        return !Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState());
    }

    public final FiniteAnimationSpec<Rect> getAnimationSpec() {
        return this.animationSpec;
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Rect> finiteAnimationSpec) {
        this.animationSpec = finiteAnimationSpec;
    }

    public final State<Rect> getAnimationState() {
        return (State) this.animationState$delegate.getValue();
    }

    public final void setAnimationState(State<Rect> state) {
        this.animationState$delegate.setValue(state);
    }

    public final Rect getValue() {
        State<Rect> animationState;
        Rect value;
        if (!this.transitionScope.isTransitionActive() || (animationState = getAnimationState()) == null || (value = animationState.getValue()) == null) {
            return null;
        }
        long m4537unboximpl = this.momentumOffset.invoke().m4537unboximpl();
        return !Offset.m4524equalsimpl0(m4537unboximpl, Offset.Companion.m4543getZeroF1C5BW0()) ? value.m4564translatek4lQ0M(m4537unboximpl) : value;
    }

    public static /* synthetic */ void animate$default(BoundsAnimation boundsAnimation, Rect rect, Rect rect2, BoundsTransform boundsTransform, int i, Object obj) {
        if ((i & 4) != 0) {
            boundsTransform = null;
        }
        boundsAnimation.animate(rect, rect2, boundsTransform);
    }

    public final void animate(final Rect rect, final Rect rect2, BoundsTransform boundsTransform) {
        if (this.transitionScope.isTransitionActive()) {
            if (getAnimationState() == null) {
                if (boundsTransform == null) {
                    boundsTransform = getBoundsTransform();
                }
                this.animationSpec = boundsTransform.createAnimationSpec(rect, rect2);
            }
            setAnimationState(getAnimation().animate(new Function1<Transition.Segment<Boolean>, FiniteAnimationSpec<Rect>>() { // from class: androidx.compose.animation.BoundsAnimation$animate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<Rect> invoke(Transition.Segment<Boolean> segment) {
                    return BoundsAnimation.this.getAnimationSpec();
                }
            }, new Function1<Boolean, Rect>() { // from class: androidx.compose.animation.BoundsAnimation$animate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Rect invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }

                public final Rect invoke(boolean z) {
                    if (z == BoundsAnimation.this.getTransition().getTargetState().booleanValue()) {
                        return rect2;
                    }
                    return rect;
                }
            }));
        }
    }

    public final boolean getTarget() {
        return this.transition.getTargetState().booleanValue();
    }
}

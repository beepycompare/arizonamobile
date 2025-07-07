package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014J\u000e\u0010\u0015\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u0003*\u0004\u0018\u00010\rH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "F", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "animateElevation", "", TypedValues.TransitionType.S_TO, "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateElevation", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonElevationAnimatable {
    private final Animatable<Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
        this.animatable = new Animatable<>(Dp.m6682boximpl(this.defaultElevation), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
    }

    /* renamed from: calculateTarget-u2uoSUM  reason: not valid java name */
    private final float m1925calculateTargetu2uoSUM(Interaction interaction) {
        return interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction.Enter ? this.hoveredElevation : interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
    }

    /* renamed from: updateElevation-lDy3nrA  reason: not valid java name */
    public final Object m1926updateElevationlDy3nrA(float f, float f2, float f3, float f4, Continuation<? super Unit> continuation) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
        Object snapElevation = snapElevation(continuation);
        return snapElevation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapElevation : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object snapElevation(Continuation<? super Unit> continuation) {
        FloatingActionButtonElevationAnimatable$snapElevation$1 floatingActionButtonElevationAnimatable$snapElevation$1;
        int i;
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable;
        if (continuation instanceof FloatingActionButtonElevationAnimatable$snapElevation$1) {
            floatingActionButtonElevationAnimatable$snapElevation$1 = (FloatingActionButtonElevationAnimatable$snapElevation$1) continuation;
            if ((floatingActionButtonElevationAnimatable$snapElevation$1.label & Integer.MIN_VALUE) != 0) {
                floatingActionButtonElevationAnimatable$snapElevation$1.label -= Integer.MIN_VALUE;
                Object obj = floatingActionButtonElevationAnimatable$snapElevation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = floatingActionButtonElevationAnimatable$snapElevation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    float m1925calculateTargetu2uoSUM = m1925calculateTargetu2uoSUM(this.targetInteraction);
                    if (!Dp.m6689equalsimpl0(this.animatable.getTargetValue().m6698unboximpl(), m1925calculateTargetu2uoSUM)) {
                        try {
                            Animatable<Dp, AnimationVector1D> animatable = this.animatable;
                            Dp m6682boximpl = Dp.m6682boximpl(m1925calculateTargetu2uoSUM);
                            floatingActionButtonElevationAnimatable$snapElevation$1.L$0 = this;
                            floatingActionButtonElevationAnimatable$snapElevation$1.label = 1;
                            if (animatable.snapTo(m6682boximpl, floatingActionButtonElevationAnimatable$snapElevation$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            floatingActionButtonElevationAnimatable = this;
                        } catch (Throwable th) {
                            th = th;
                            floatingActionButtonElevationAnimatable = this;
                            floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                            throw th;
                        }
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) floatingActionButtonElevationAnimatable$snapElevation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                        throw th;
                    }
                }
                floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                return Unit.INSTANCE;
            }
        }
        floatingActionButtonElevationAnimatable$snapElevation$1 = new FloatingActionButtonElevationAnimatable$snapElevation$1(this, continuation);
        Object obj2 = floatingActionButtonElevationAnimatable$snapElevation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = floatingActionButtonElevationAnimatable$snapElevation$1.label;
        if (i != 0) {
        }
        floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateElevation(Interaction interaction, Continuation<? super Unit> continuation) {
        FloatingActionButtonElevationAnimatable$animateElevation$1 floatingActionButtonElevationAnimatable$animateElevation$1;
        int i;
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable;
        if (continuation instanceof FloatingActionButtonElevationAnimatable$animateElevation$1) {
            floatingActionButtonElevationAnimatable$animateElevation$1 = (FloatingActionButtonElevationAnimatable$animateElevation$1) continuation;
            if ((floatingActionButtonElevationAnimatable$animateElevation$1.label & Integer.MIN_VALUE) != 0) {
                floatingActionButtonElevationAnimatable$animateElevation$1.label -= Integer.MIN_VALUE;
                Object obj = floatingActionButtonElevationAnimatable$animateElevation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = floatingActionButtonElevationAnimatable$animateElevation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    float m1925calculateTargetu2uoSUM = m1925calculateTargetu2uoSUM(interaction);
                    this.targetInteraction = interaction;
                    try {
                        if (!Dp.m6689equalsimpl0(this.animatable.getTargetValue().m6698unboximpl(), m1925calculateTargetu2uoSUM)) {
                            Animatable<Dp, AnimationVector1D> animatable = this.animatable;
                            Interaction interaction2 = this.lastTargetInteraction;
                            floatingActionButtonElevationAnimatable$animateElevation$1.L$0 = this;
                            floatingActionButtonElevationAnimatable$animateElevation$1.L$1 = interaction;
                            floatingActionButtonElevationAnimatable$animateElevation$1.label = 1;
                            if (ElevationKt.m2705animateElevationrAjV9yQ(animatable, m1925calculateTargetu2uoSUM, interaction2, interaction, floatingActionButtonElevationAnimatable$animateElevation$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        floatingActionButtonElevationAnimatable = this;
                    } catch (Throwable th) {
                        th = th;
                        floatingActionButtonElevationAnimatable = this;
                        floatingActionButtonElevationAnimatable.lastTargetInteraction = interaction;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    interaction = (Interaction) floatingActionButtonElevationAnimatable$animateElevation$1.L$1;
                    floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) floatingActionButtonElevationAnimatable$animateElevation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        floatingActionButtonElevationAnimatable.lastTargetInteraction = interaction;
                        throw th;
                    }
                }
                floatingActionButtonElevationAnimatable.lastTargetInteraction = interaction;
                return Unit.INSTANCE;
            }
        }
        floatingActionButtonElevationAnimatable$animateElevation$1 = new FloatingActionButtonElevationAnimatable$animateElevation$1(this, continuation);
        Object obj2 = floatingActionButtonElevationAnimatable$animateElevation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = floatingActionButtonElevationAnimatable$animateElevation$1.label;
        if (i != 0) {
        }
        floatingActionButtonElevationAnimatable.lastTargetInteraction = interaction;
        return Unit.INSTANCE;
    }

    public final State<Dp> asState() {
        return this.animatable.asState();
    }
}

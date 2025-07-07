package androidx.constraintlayout.compose;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* compiled from: TransitionHandler.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/compose/TransitionHandler;", "", "motionMeasurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/MutableFloatState;)V", "transition", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "onAcceptFirstDownForOnSwipe", "", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "onAcceptFirstDownForOnSwipe-k-4lQ0M", "(J)Z", "onTouchUp", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onTouchUp-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendingProgressWhileTouchUp", "updateProgressOnDrag", "dragAmount", "updateProgressOnDrag-k-4lQ0M", "(J)V", "updateProgressWhileTouchUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransitionHandler {
    public static final int $stable = 8;
    private final MotionMeasurer motionMeasurer;
    private final MutableFloatState motionProgress;

    public TransitionHandler(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.motionMeasurer = motionMeasurer;
        this.motionProgress = mutableFloatState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.constraintlayout.core.state.Transition getTransition() {
        return this.motionMeasurer.getTransition();
    }

    /* renamed from: onAcceptFirstDownForOnSwipe-k-4lQ0M  reason: not valid java name */
    public final boolean m7154onAcceptFirstDownForOnSwipek4lQ0M(long j) {
        return getTransition().isFirstDownAccepted(Offset.m3837getXimpl(j), Offset.m3838getYimpl(j));
    }

    /* renamed from: updateProgressOnDrag-k-4lQ0M  reason: not valid java name */
    public final void m7156updateProgressOnDragk4lQ0M(long j) {
        this.motionProgress.setFloatValue(RangesKt.coerceIn(this.motionProgress.getFloatValue() + getTransition().dragToProgress(this.motionProgress.getFloatValue(), this.motionMeasurer.getLayoutCurrentWidth(), this.motionMeasurer.getLayoutCurrentHeight(), Offset.m3837getXimpl(j), Offset.m3838getYimpl(j)), 0.0f, 1.0f));
    }

    /* renamed from: onTouchUp-sF-c-tU  reason: not valid java name */
    public final Object m7155onTouchUpsFctU(final long j, Continuation<? super Unit> continuation) {
        Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.constraintlayout.compose.TransitionHandler$onTouchUp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j2) {
                androidx.constraintlayout.core.state.Transition transition;
                MutableFloatState mutableFloatState;
                transition = TransitionHandler.this.getTransition();
                mutableFloatState = TransitionHandler.this.motionProgress;
                transition.setTouchUp(mutableFloatState.getFloatValue(), j2, Velocity.m6922getXimpl(j), Velocity.m6923getYimpl(j));
            }
        }, continuation);
        return withFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withFrameNanos : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateProgressWhileTouchUp(Continuation<? super Unit> continuation) {
        TransitionHandler$updateProgressWhileTouchUp$1 transitionHandler$updateProgressWhileTouchUp$1;
        int i;
        TransitionHandler transitionHandler;
        if (continuation instanceof TransitionHandler$updateProgressWhileTouchUp$1) {
            transitionHandler$updateProgressWhileTouchUp$1 = (TransitionHandler$updateProgressWhileTouchUp$1) continuation;
            if ((transitionHandler$updateProgressWhileTouchUp$1.label & Integer.MIN_VALUE) != 0) {
                transitionHandler$updateProgressWhileTouchUp$1.label -= Integer.MIN_VALUE;
                Object obj = transitionHandler$updateProgressWhileTouchUp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transitionHandler$updateProgressWhileTouchUp$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    transitionHandler$updateProgressWhileTouchUp$1.L$0 = this;
                    transitionHandler$updateProgressWhileTouchUp$1.label = 1;
                    obj = MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Float>() { // from class: androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$newProgress$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        public final Float invoke(long j) {
                            androidx.constraintlayout.core.state.Transition transition;
                            transition = TransitionHandler.this.getTransition();
                            return Float.valueOf(transition.getTouchUpProgress(j));
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Float invoke(Long l) {
                            return invoke(l.longValue());
                        }
                    }, transitionHandler$updateProgressWhileTouchUp$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    transitionHandler = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    transitionHandler = (TransitionHandler) transitionHandler$updateProgressWhileTouchUp$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                transitionHandler.motionProgress.setFloatValue(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }
        }
        transitionHandler$updateProgressWhileTouchUp$1 = new TransitionHandler$updateProgressWhileTouchUp$1(this, continuation);
        Object obj2 = transitionHandler$updateProgressWhileTouchUp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transitionHandler$updateProgressWhileTouchUp$1.label;
        if (i != 0) {
        }
        transitionHandler.motionProgress.setFloatValue(((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final boolean pendingProgressWhileTouchUp() {
        return getTransition().isTouchNotDone(this.motionProgress.getFloatValue());
    }
}

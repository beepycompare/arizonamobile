package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
/* compiled from: UpdatableAnimationState.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JJ\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "getValue", "()F", "setValue", "(F)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpdatableAnimationState {
    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
        if (r12 != 0.0f) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00da, code lost:
        if (r14 == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a9 -> B:54:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToZero(Function1<? super Float, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$1;
        int i;
        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$12;
        Function0 function02;
        final Function1<? super Float, Unit> function12;
        final float f;
        final UpdatableAnimationState updatableAnimationState;
        Function0 function03;
        UpdatableAnimationState updatableAnimationState2;
        try {
            if (continuation instanceof UpdatableAnimationState$animateToZero$1) {
                updatableAnimationState$animateToZero$1 = (UpdatableAnimationState$animateToZero$1) continuation;
                if ((updatableAnimationState$animateToZero$1.label & Integer.MIN_VALUE) != 0) {
                    updatableAnimationState$animateToZero$1.label -= Integer.MIN_VALUE;
                    Object obj = updatableAnimationState$animateToZero$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = updatableAnimationState$animateToZero$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.isRunning) {
                            InlineClassHelperKt.throwIllegalStateException("animateToZero called while previous animation is running");
                        }
                        MotionDurationScale motionDurationScale = (MotionDurationScale) updatableAnimationState$animateToZero$1.getContext().get(MotionDurationScale.Key);
                        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
                        this.isRunning = true;
                        updatableAnimationState$animateToZero$12 = updatableAnimationState$animateToZero$1;
                        function02 = function0;
                        function12 = function1;
                        f = scaleFactor;
                        updatableAnimationState = this;
                        if (!Companion.isZeroish(updatableAnimationState.value)) {
                            updatableAnimationState$animateToZero$12.L$0 = updatableAnimationState;
                            updatableAnimationState$animateToZero$12.L$1 = function12;
                            updatableAnimationState$animateToZero$12.L$2 = function02;
                            updatableAnimationState$animateToZero$12.F$0 = f;
                            updatableAnimationState$animateToZero$12.label = 1;
                            if (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    long j2;
                                    long j3;
                                    long roundToLong;
                                    VectorizedAnimationSpec vectorizedAnimationSpec;
                                    UpdatableAnimationState.Companion companion;
                                    AnimationVector1D animationVector1D;
                                    VectorizedAnimationSpec vectorizedAnimationSpec2;
                                    UpdatableAnimationState.Companion companion2;
                                    AnimationVector1D animationVector1D2;
                                    VectorizedAnimationSpec vectorizedAnimationSpec3;
                                    UpdatableAnimationState.Companion companion3;
                                    AnimationVector1D animationVector1D3;
                                    j2 = UpdatableAnimationState.this.lastFrameTime;
                                    if (j2 == Long.MIN_VALUE) {
                                        UpdatableAnimationState.this.lastFrameTime = j;
                                    }
                                    AnimationVector1D animationVector1D4 = new AnimationVector1D(UpdatableAnimationState.this.getValue());
                                    if (f == 0.0f) {
                                        vectorizedAnimationSpec3 = UpdatableAnimationState.this.vectorizedSpec;
                                        companion3 = UpdatableAnimationState.Companion;
                                        animationVector1D3 = UpdatableAnimationState.this.lastVelocity;
                                        roundToLong = vectorizedAnimationSpec3.getDurationNanos(new AnimationVector1D(UpdatableAnimationState.this.getValue()), companion3.getZeroVector(), animationVector1D3);
                                    } else {
                                        j3 = UpdatableAnimationState.this.lastFrameTime;
                                        roundToLong = MathKt.roundToLong(((float) (j - j3)) / f);
                                    }
                                    long j4 = roundToLong;
                                    vectorizedAnimationSpec = UpdatableAnimationState.this.vectorizedSpec;
                                    AnimationVector1D animationVector1D5 = animationVector1D4;
                                    companion = UpdatableAnimationState.Companion;
                                    AnimationVector1D zeroVector = companion.getZeroVector();
                                    animationVector1D = UpdatableAnimationState.this.lastVelocity;
                                    float value = ((AnimationVector1D) vectorizedAnimationSpec.getValueFromNanos(j4, animationVector1D5, zeroVector, animationVector1D)).getValue();
                                    UpdatableAnimationState updatableAnimationState3 = UpdatableAnimationState.this;
                                    vectorizedAnimationSpec2 = updatableAnimationState3.vectorizedSpec;
                                    companion2 = UpdatableAnimationState.Companion;
                                    AnimationVector1D zeroVector2 = companion2.getZeroVector();
                                    animationVector1D2 = UpdatableAnimationState.this.lastVelocity;
                                    updatableAnimationState3.lastVelocity = (AnimationVector1D) vectorizedAnimationSpec2.getVelocityFromNanos(j4, animationVector1D5, zeroVector2, animationVector1D2);
                                    UpdatableAnimationState.this.lastFrameTime = j;
                                    UpdatableAnimationState.this.setValue(value);
                                    function12.invoke(Float.valueOf(UpdatableAnimationState.this.getValue() - value));
                                }
                            }, updatableAnimationState$animateToZero$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function02.invoke();
                        }
                        UpdatableAnimationState updatableAnimationState3 = updatableAnimationState;
                        final Function1<? super Float, Unit> function13 = function12;
                        final UpdatableAnimationState updatableAnimationState4 = updatableAnimationState3;
                        function03 = function02;
                        if (Math.abs(updatableAnimationState4.value) != 0.0f) {
                            updatableAnimationState$animateToZero$12.L$0 = updatableAnimationState4;
                            updatableAnimationState$animateToZero$12.L$1 = function03;
                            updatableAnimationState$animateToZero$12.L$2 = null;
                            updatableAnimationState$animateToZero$12.label = 2;
                            Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    float value = UpdatableAnimationState.this.getValue();
                                    UpdatableAnimationState.this.setValue(0.0f);
                                    function13.invoke(Float.valueOf(value));
                                }
                            }, updatableAnimationState$animateToZero$12);
                            function0 = updatableAnimationState4;
                        } else {
                            updatableAnimationState2 = updatableAnimationState4;
                            updatableAnimationState2.lastFrameTime = Long.MIN_VALUE;
                            updatableAnimationState2.lastVelocity = ZeroVector;
                            updatableAnimationState2.isRunning = false;
                            return Unit.INSTANCE;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            function03 = (Function0) updatableAnimationState$animateToZero$1.L$1;
                            UpdatableAnimationState updatableAnimationState5 = (UpdatableAnimationState) updatableAnimationState$animateToZero$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            function0 = updatableAnimationState5;
                            function03.invoke();
                            updatableAnimationState2 = function0;
                            updatableAnimationState2.lastFrameTime = Long.MIN_VALUE;
                            updatableAnimationState2.lastVelocity = ZeroVector;
                            updatableAnimationState2.isRunning = false;
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        f = updatableAnimationState$animateToZero$1.F$0;
                        Function0 function04 = (Function0) updatableAnimationState$animateToZero$1.L$2;
                        Function1<? super Float, Unit> function14 = (Function1) updatableAnimationState$animateToZero$1.L$1;
                        UpdatableAnimationState updatableAnimationState6 = (UpdatableAnimationState) updatableAnimationState$animateToZero$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$13 = updatableAnimationState$animateToZero$1;
                            function02 = function04;
                            function12 = function14;
                            updatableAnimationState$animateToZero$12 = updatableAnimationState$animateToZero$13;
                            updatableAnimationState = updatableAnimationState6;
                            try {
                                function02.invoke();
                            } catch (Throwable th) {
                                th = th;
                                function0 = updatableAnimationState;
                                function0.lastFrameTime = Long.MIN_VALUE;
                                function0.lastVelocity = ZeroVector;
                                function0.isRunning = false;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            function0 = updatableAnimationState6;
                            function0.lastFrameTime = Long.MIN_VALUE;
                            function0.lastVelocity = ZeroVector;
                            function0.isRunning = false;
                            throw th;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        updatableAnimationState$animateToZero$1 = new UpdatableAnimationState$animateToZero$1(this, continuation);
        Object obj2 = updatableAnimationState$animateToZero$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updatableAnimationState$animateToZero$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdatableAnimationState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }
    }
}

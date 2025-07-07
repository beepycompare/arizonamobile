package androidx.compose.animation.core;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: S
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", i = {}, l = {599}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class SeekableTransitionState$animateTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $transition;
    int label;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$animateTo$2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super SeekableTransitionState$animateTo$2> continuation) {
        super(1, continuation);
        this.$transition = transition;
        this.this$0 = seekableTransitionState;
        this.$targetState = s;
        this.$animationSpec = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SeekableTransitionState$animateTo$2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> continuation) {
        return invoke2(continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> continuation) {
        return ((SeekableTransitionState$animateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", i = {0}, l = {2147, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 614, 668, 670}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$transition = transition;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return invoke2(coroutineScope, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
            if (r2 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
            if (r2 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01f4, code lost:
            if (r2 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0209, code lost:
            if (r2 == r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            SeekableTransitionState seekableTransitionState;
            Object doOneFrame;
            Object waitForCompositionAfterTargetStateChange;
            Object runAnimations;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState;
            SeekableTransitionState.Companion companion;
            AnimationVector1D zeroVelocity;
            SeekableTransitionState.Companion companion2;
            long roundToLong;
            SeekableTransitionState.Companion companion3;
            SeekableTransitionState.Companion companion4;
            SeekableTransitionState.Companion companion5;
            Object waitForComposition;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object targetState = this.this$0.getTargetState();
                    if (!Intrinsics.areEqual(this.$targetState, targetState)) {
                        this.this$0.moveAnimationToInitialState();
                        this.this$0.setFraction(0.0f);
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setCurrentState$animation_core_release(targetState);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                    }
                    Mutex compositionContinuationMutex$animation_core_release = this.this$0.getCompositionContinuationMutex$animation_core_release();
                    SeekableTransitionState seekableTransitionState2 = this.this$0;
                    this.L$0 = compositionContinuationMutex$animation_core_release;
                    this.L$1 = seekableTransitionState2;
                    this.label = 1;
                    if (compositionContinuationMutex$animation_core_release.lock(null, this) != coroutine_suspended) {
                        mutex = compositionContinuationMutex$animation_core_release;
                        seekableTransitionState = seekableTransitionState2;
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    seekableTransitionState = (SeekableTransitionState) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 3;
                    waitForCompositionAfterTargetStateChange = this.this$0.waitForCompositionAfterTargetStateChange(this);
                } else if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                        if (this.this$0.getFraction() < 1.0f) {
                            seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                            FiniteAnimationSpec<Float> finiteAnimationSpec = this.$animationSpec;
                            VectorizedAnimationSpec vectorize = finiteAnimationSpec != null ? finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)) : null;
                            if (seekingAnimationState == null || !Intrinsics.areEqual(vectorize, seekingAnimationState.getAnimationSpec())) {
                                VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState != null ? seekingAnimationState.getAnimationSpec() : null;
                                if (animationSpec != null) {
                                    long progressNanos = seekingAnimationState.getProgressNanos();
                                    AnimationVector1D start = seekingAnimationState.getStart();
                                    companion4 = SeekableTransitionState.Companion;
                                    AnimationVector1D target1 = companion4.getTarget1();
                                    AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
                                    if (initialVelocity == null) {
                                        companion5 = SeekableTransitionState.Companion;
                                        initialVelocity = companion5.getZeroVelocity();
                                    }
                                    zeroVelocity = animationSpec.getVelocityFromNanos(progressNanos, start, target1, initialVelocity);
                                } else if (seekingAnimationState == null || seekingAnimationState.getProgressNanos() == 0) {
                                    companion = SeekableTransitionState.Companion;
                                    zeroVelocity = companion.getZeroVelocity();
                                } else {
                                    long durationNanos = seekingAnimationState.getDurationNanos();
                                    if (durationNanos == Long.MIN_VALUE) {
                                        durationNanos = this.this$0.getTotalDurationNanos$animation_core_release();
                                    }
                                    float f = ((float) durationNanos) / 1.0E9f;
                                    if (f <= 0.0f) {
                                        companion2 = SeekableTransitionState.Companion;
                                        zeroVelocity = companion2.getZeroVelocity();
                                    } else {
                                        zeroVelocity = new AnimationVector1D(1.0f / f);
                                    }
                                }
                                if (seekingAnimationState == null) {
                                    seekingAnimationState = new SeekableTransitionState.SeekingAnimationState();
                                }
                                seekingAnimationState.setAnimationSpec(vectorize);
                                seekingAnimationState.setComplete(false);
                                seekingAnimationState.setValue(this.this$0.getFraction());
                                seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
                                seekingAnimationState.setProgressNanos(0L);
                                seekingAnimationState.setInitialVelocity(zeroVelocity);
                                if (vectorize != null) {
                                    companion3 = SeekableTransitionState.Companion;
                                    roundToLong = vectorize.getDurationNanos(seekingAnimationState.getStart(), companion3.getTarget1(), zeroVelocity);
                                } else {
                                    roundToLong = MathKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core_release() * (1.0d - this.this$0.getFraction()));
                                }
                                seekingAnimationState.setAnimationSpecDuration(roundToLong);
                                ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                            }
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 4;
                        runAnimations = this.this$0.runAnimations(this);
                    }
                    return Unit.INSTANCE;
                } else if (i != 4) {
                    if (i == 5) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.setFraction(0.0f);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.setCurrentState$animation_core_release(this.$targetState);
                    this.label = 5;
                    waitForComposition = this.this$0.waitForComposition(this);
                }
                Object composedTargetState$animation_core_release = seekableTransitionState.getComposedTargetState$animation_core_release();
                mutex.unlock(null);
                if (!Intrinsics.areEqual(this.$targetState, composedTargetState$animation_core_release)) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    doOneFrame = this.this$0.doOneFrame(this);
                }
                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.$transition.onTransitionEnd$animation_core_release();
        return Unit.INSTANCE;
    }
}

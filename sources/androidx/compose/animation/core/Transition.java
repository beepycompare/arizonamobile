package androidx.compose.animation.core;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001B!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bB/\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ'\u0010S\u001a\u00020#2\u0018\u0010T\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bUJ\u0019\u0010V\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bXJ\u0017\u0010Y\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0001¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u00020\u0012H\u0002J\r\u0010^\u001a\u00020ZH\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020ZH\u0002J\r\u0010a\u001a\u00020ZH\u0000¢\u0006\u0002\bbJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020#H\u0000¢\u0006\u0002\bfJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020iH\u0000¢\u0006\u0002\bfJ\r\u0010j\u001a\u00020ZH\u0000¢\u0006\u0002\bkJ\u0015\u0010l\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u0012H\u0000¢\u0006\u0002\bmJ'\u0010n\u001a\u00020Z2\u0018\u0010o\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030pR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bqJ'\u0010n\u001a\u00020Z2\u0018\u0010T\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bqJ\u0019\u0010r\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bsJ\u0015\u0010t\u001a\u00020Z2\u0006\u0010u\u001a\u00020iH\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020Z2\u0006\u00106\u001a\u00020\u0012H\u0000¢\u0006\u0002\bxJ\u0015\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020{H\u0000¢\u0006\u0002\b|J'\u0010}\u001a\u00020Z2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010D\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u0012H\u0007¢\u0006\u0004\b~\u0010\u007fJ\t\u0010\u0080\u0001\u001a\u00020\u0006H\u0016J\u000f\u0010\u0081\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\b\u0082\u0001J\u0019\u0010\u0083\u0001\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0000¢\u0006\u0005\b\u0084\u0001\u0010GR&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#8GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010'R+\u0010)\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u0019\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R$\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R7\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000092\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u0000098F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0019\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R+\u0010D\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010-\u001a\u0004\bE\u0010!\"\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bJ\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u001c8F¢\u0006\u0006\u001a\u0004\bN\u0010\u001eR+\u0010O\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010-\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010+¨\u0006\u0089\u0001"}, d2 = {"Landroidx/compose/animation/core/Transition;", ExifInterface.LATITUDE_SOUTH, "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", Constants.ScionAnalytics.PARAM_LABEL, "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "parentTransition", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "<set-?>", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "hasInitialValueAnimations", "", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "()Z", "isRunning", "isSeeking", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core_release", "setLastSeekedTimeNanos$animation_core_release", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos$animation_core_release", "setStartTimeNanos$animation_core_release", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "(Ljava/lang/Object;)V", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "calculateTotalDurationNanos", "clearInitialAnimations", "clearInitialAnimations$animation_core_release", "onChildAnimationUpdated", "onDisposed", "onDisposed$animation_core_release", "onFrame", "scaledPlayTimeNanos", "scaleToEnd", "onFrame$animation_core_release", "frameTimeNanos", "durationScale", "", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core_release", "seekAnimations", "seekAnimations$animation_core_release", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "toString", "updateInitialValues", "updateInitialValues$animation_core_release", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Transition<S> {
    public static final int $stable = 0;
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    private final MutableLongState _playTimeNanos$delegate;
    private final SnapshotStateList<Transition<?>> _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition<?> parentTransition;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final TransitionState<S> transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    public static /* synthetic */ void getHasInitialValueAnimations$annotations() {
    }

    public Transition(TransitionState<S> transitionState, Transition<?> transition, String str) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        this.transitionState = transitionState;
        this.parentTransition = transition;
        this.label = str;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.targetState$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this.segment$delegate = mutableStateOf$default2;
        this._playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.updateChildrenNeeded$delegate = mutableStateOf$default3;
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isSeeking$delegate = mutableStateOf$default4;
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Function0<Long>(this) { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            final /* synthetic */ Transition<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                long calculateTotalDurationNanos;
                calculateTotalDurationNanos = this.this$0.calculateTotalDurationNanos();
                return Long.valueOf(calculateTotalDurationNanos);
            }
        });
        transitionState.transitionConfigured$animation_core_release(this);
    }

    public /* synthetic */ Transition(TransitionState transitionState, Transition transition, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, transition, (i & 4) != 0 ? null : str);
    }

    public final Transition<?> getParentTransition() {
        return this.parentTransition;
    }

    public final String getLabel() {
        return this.label;
    }

    public /* synthetic */ Transition(TransitionState transitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, (i & 2) != 0 ? null : str);
    }

    public Transition(TransitionState<S> transitionState, String str) {
        this(transitionState, null, str);
    }

    public Transition(S s, String str) {
        this(new MutableTransitionState(s), null, str);
    }

    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableTransitionState, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Transition(MutableTransitionState<S> mutableTransitionState, String str) {
        this(mutableTransitionState, null, str);
        Intrinsics.checkNotNull(mutableTransitionState, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final void setTargetState$animation_core_release(S s) {
        this.targetState$delegate.setValue(s);
    }

    private final void setSegment(Segment<S> segment) {
        this.segment$delegate.setValue(segment);
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos$animation_core_release() != Long.MIN_VALUE;
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos$delegate.getLongValue();
    }

    private final void set_playTimeNanos(long j) {
        this._playTimeNanos$delegate.setLongValue(j);
    }

    public final long getPlayTimeNanos() {
        Transition<?> transition = this.parentTransition;
        return transition != null ? transition.getPlayTimeNanos() : get_playTimeNanos();
    }

    public final void setPlayTimeNanos(long j) {
        if (this.parentTransition == null) {
            set_playTimeNanos(j);
        }
    }

    public final long getStartTimeNanos$animation_core_release() {
        return this.startTimeNanos$delegate.getLongValue();
    }

    public final void setStartTimeNanos$animation_core_release(long j) {
        this.startTimeNanos$delegate.setLongValue(j);
    }

    private final boolean getUpdateChildrenNeeded() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    private final void setUpdateChildrenNeeded(boolean z) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(z));
    }

    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void setSeeking$animation_core_release(boolean z) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(z));
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j) {
        this.lastSeekedTimeNanos = j;
    }

    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (snapshotStateList.get(i).getInitialValueState$animation_core_release() != null) {
                return true;
            }
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (snapshotStateList2.get(i2).getHasInitialValueAnimations()) {
                return true;
            }
        }
        return false;
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateTotalDurationNanos() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, snapshotStateList.get(i).getDurationNanos$animation_core_release());
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            j = Math.max(j, snapshotStateList2.get(i2).calculateTotalDurationNanos());
        }
        return j;
    }

    public final void onFrame$animation_core_release(long j, float f) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(j);
        }
        long startTimeNanos$animation_core_release = j - getStartTimeNanos$animation_core_release();
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i != 0) {
            startTimeNanos$animation_core_release = MathKt.roundToLong(startTimeNanos$animation_core_release / f);
        }
        setPlayTimeNanos(startTimeNanos$animation_core_release);
        onFrame$animation_core_release(startTimeNanos$animation_core_release, i == 0);
    }

    public final void onFrame$animation_core_release(long j, boolean z) {
        boolean z2 = true;
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(j);
        } else if (!this.transitionState.isRunning$animation_core_release()) {
            this.transitionState.setRunning$animation_core_release(true);
        }
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i);
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(j, z);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                z2 = false;
            }
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition<?> transition = snapshotStateList2.get(i2);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(j, z);
            }
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                z2 = false;
            }
        }
        if (z2) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long j) {
        setStartTimeNanos$animation_core_release(j);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void onDisposed$animation_core_release() {
        onTransitionEnd$animation_core_release();
        this.transitionState.transitionRemoved$animation_core_release();
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        TransitionState<S> transitionState = this.transitionState;
        if (transitionState instanceof MutableTransitionState) {
            transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).onTransitionEnd$animation_core_release();
        }
    }

    public final void seek(S s, S s2, long j) {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), s) || !Intrinsics.areEqual(getTargetState(), s2)) {
            if (!Intrinsics.areEqual(getCurrentState(), s)) {
                TransitionState<S> transitionState = this.transitionState;
                if (transitionState instanceof MutableTransitionState) {
                    transitionState.setCurrentState$animation_core_release(s);
                }
            }
            setTargetState$animation_core_release(s2);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(s, s2));
        }
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            Transition<?> transition = snapshotStateList.get(i);
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), j);
            }
        }
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList2 = this._animations;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).seekTo$animation_core_release(j);
        }
        this.lastSeekedTimeNanos = j;
    }

    public final boolean addTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.add(transition);
    }

    public final boolean removeTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.remove(transition);
    }

    public final boolean addAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState) {
        return this._animations.add(transitionAnimationState);
    }

    public final void removeAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState) {
        this._animations.remove(transitionAnimationState);
    }

    public final void updateTarget$animation_core_release(S s) {
        if (Intrinsics.areEqual(getTargetState(), s)) {
            return;
        }
        setSegment(new SegmentImpl(getTargetState(), s));
        if (!Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            this.transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setTargetState$animation_core_release(s);
        if (!isRunning()) {
            setUpdateChildrenNeeded(true);
        }
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).resetAnimation$animation_core_release();
        }
    }

    public final void animateTo$animation_core_release(final S s, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1493585151);
        ComposerKt.sourceInformation(startRestartGroup, "C(animateTo):Transition.kt#pdpnli");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(s) : startRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, i2, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1176)");
            }
            if (!isSeeking()) {
                startRestartGroup.startReplaceGroup(1822801203);
                ComposerKt.sourceInformation(startRestartGroup, "");
                updateTarget$animation_core_release(s);
                if (!Intrinsics.areEqual(s, getCurrentState()) || isRunning() || getUpdateChildrenNeeded()) {
                    startRestartGroup.startReplaceGroup(1823032494);
                    ComposerKt.sourceInformation(startRestartGroup, "1184@50127L24,1185@50207L1011,1185@50168L1050");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 335910458, "CC(remember):Transition.kt#9igjgp");
                    int i3 = i2 & 112;
                    boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | (i3 == 32);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: Transition.kt */
                            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", f = "Transition.kt", i = {0, 0}, l = {1192}, m = "invokeSuspend", n = {"$this$launch", "durationScale"}, s = {"L$0", "F$0"})
                            /* renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1  reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                float F$0;
                                private /* synthetic */ Object L$0;
                                int label;
                                final /* synthetic */ Transition<S> this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Transition<S> transition, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.this$0 = transition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                                    anonymousClass1.L$0 = obj;
                                    return anonymousClass1;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    final float durationScale;
                                    CoroutineScope coroutineScope;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                        durationScale = SuspendAnimationKt.getDurationScale(coroutineScope2.getCoroutineContext());
                                        coroutineScope = coroutineScope2;
                                    } else if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    } else {
                                        durationScale = this.F$0;
                                        coroutineScope = (CoroutineScope) this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    while (CoroutineScopeKt.isActive(coroutineScope)) {
                                        final Transition<S> transition = this.this$0;
                                        this.L$0 = coroutineScope;
                                        this.F$0 = durationScale;
                                        this.label = 1;
                                        if (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                invoke(l.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(long j) {
                                                if (transition.isSeeking()) {
                                                    return;
                                                }
                                                transition.onFrame$animation_core_release(j, durationScale);
                                            }
                                        }, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.DisposableEffect(coroutineScope, this, (Function1) rememberedValue2, startRestartGroup, i3);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1824275067);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1824284987);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.animation.core.Transition$animateTo$2
                final /* synthetic */ Transition<S> $tmp1_rcvr;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$tmp1_rcvr = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    this.$tmp1_rcvr.animateTo$animation_core_release(s, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void seekAnimations$animation_core_release(long j) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            setStartTimeNanos$animation_core_release(j);
        }
        setPlayTimeNanos(j);
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).seekTo$animation_core_release(j);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition<?> transition = snapshotStateList2.get(i2);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.seekAnimations$animation_core_release(j);
            }
        }
    }

    public final void setInitialAnimations$animation_core_release(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).setInitialValueAnimation$animation_core_release(seekingAnimationState);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).setInitialAnimations$animation_core_release(seekingAnimationState);
        }
    }

    public final void resetAnimationFraction$animation_core_release(float f) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).resetAnimationValue$animation_core_release(f);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).resetAnimationFraction$animation_core_release(f);
        }
    }

    public final void clearInitialAnimations$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).clearInitialAnimation$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).clearInitialAnimations$animation_core_release();
        }
    }

    public final void updateInitialValues$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList.get(i).updateInitialValue$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            snapshotStateList2.get(i2).updateInitialValues$animation_core_release();
        }
    }

    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> animations;
        String str = "Transition animation values: ";
        for (int i = 0; i < getAnimations().size(); i++) {
            str = str + animations.get(i) + ", ";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking()) {
            SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
            int size = snapshotStateList.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i);
                j = Math.max(j, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded(false);
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010O\u001a\u00020PH\u0000¢\u0006\u0002\bQJ\u001d\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020.H\u0000¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020PH\u0000¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u000208H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020P2\u0006\u0010^\u001a\u00020(H\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020\nH\u0016J!\u0010a\u001a\u00020P2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010b\u001a\u00020.H\u0002¢\u0006\u0002\u0010cJ-\u0010d\u001a\u00020P2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010@\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020PH\u0000¢\u0006\u0002\bhJ%\u0010i\u001a\u00020P2\u0006\u0010@\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bj\u0010kRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010/\u001a\u00020.2\u0006\u0010\f\u001a\u00020.8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00105\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R+\u00109\u001a\u0002082\u0006\u0010\f\u001a\u0002088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R+\u0010@\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0014\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\u0014\u001a\u0004\bJ\u0010B\"\u0004\bK\u0010DR\u0010\u0010M\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010N¨\u0006l"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", Constants.ScionAnalytics.PARAM_LABEL, "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "durationNanos", "getDurationNanos$animation_core_release", "()J", "setDurationNanos$animation_core_release", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "initialValueAnimation", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core_release", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "isSeeking", "getLabel", "()Ljava/lang/String;", "", "resetSnapValue", "getResetSnapValue$animation_core_release", "()F", "setResetSnapValue$animation_core_release", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "clearInitialAnimation", "", "clearInitialAnimation$animation_core_release", "onPlayTimeChanged", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core_release", "seekTo", "seekTo$animation_core_release", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core_release", "toString", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialValue", "updateInitialValue$animation_core_release", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final SpringSpec<T> defaultSpring;
        private final MutableLongState durationNanos$delegate;
        private TargetBasedAnimation<T, V> initialValueAnimation;
        private SeekableTransitionState.SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec<T> interruptionSpec;
        private final MutableState isFinished$delegate;
        private boolean isSeeking;
        private final String label;
        private final MutableFloatState resetSnapValue$delegate;
        private final MutableState targetValue$delegate;
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;
        private final MutableState value$delegate;
        private V velocityVector;

        public TransitionAnimationState(T t, V v, TwoWayConverter<T, V> twoWayConverter, String str) {
            MutableState mutableStateOf$default;
            MutableState mutableStateOf$default2;
            MutableState mutableStateOf$default3;
            MutableState mutableStateOf$default4;
            MutableState mutableStateOf$default5;
            T t2;
            this.typeConverter = twoWayConverter;
            this.label = str;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            this.targetValue$delegate = mutableStateOf$default;
            SpringSpec<T> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            this.defaultSpring = spring$default;
            mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(spring$default, null, 2, null);
            this.animationSpec$delegate = mutableStateOf$default2;
            mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), twoWayConverter, t, getTargetValue(), v), null, 2, null);
            this.animation$delegate = mutableStateOf$default3;
            mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
            this.isFinished$delegate = mutableStateOf$default4;
            this.resetSnapValue$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            this.value$delegate = mutableStateOf$default5;
            this.velocityVector = v;
            this.durationNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            Float f = VisibilityThresholdsKt.getVisibilityThresholdMap().get(twoWayConverter);
            if (f != null) {
                float floatValue = f.floatValue();
                V invoke = twoWayConverter.getConvertToVector().invoke(t);
                int size$animation_core_release = invoke.getSize$animation_core_release();
                for (int i = 0; i < size$animation_core_release; i++) {
                    invoke.set$animation_core_release(i, floatValue);
                }
                t2 = this.typeConverter.getConvertFromVector().invoke(invoke);
            } else {
                t2 = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, t2, 3, null);
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        private final T getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        private final void setTargetValue(T t) {
            this.targetValue$delegate.setValue(t);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation$delegate.setValue(targetBasedAnimation);
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final SeekableTransitionState.SeekingAnimationState getInitialValueState$animation_core_release() {
            return this.initialValueState;
        }

        public final void setInitialValueState$animation_core_release(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
            this.initialValueState = seekingAnimationState;
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void setFinished$animation_core_release(boolean z) {
            this.isFinished$delegate.setValue(Boolean.valueOf(z));
        }

        public final float getResetSnapValue$animation_core_release() {
            return this.resetSnapValue$delegate.getFloatValue();
        }

        public final void setResetSnapValue$animation_core_release(float f) {
            this.resetSnapValue$delegate.setFloatValue(f);
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            return this.value$delegate.getValue();
        }

        public void setValue$animation_core_release(T t) {
            this.value$delegate.setValue(t);
        }

        public final long getDurationNanos$animation_core_release() {
            return this.durationNanos$delegate.getLongValue();
        }

        public final void setDurationNanos$animation_core_release(long j) {
            this.durationNanos$delegate.setLongValue(j);
        }

        public final void onPlayTimeChanged$animation_core_release(long j, boolean z) {
            if (z) {
                j = getAnimation().getDurationNanos();
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(j));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(j);
            if (getAnimation().isFinishedFromNanos(j)) {
                setFinished$animation_core_release(true);
            }
        }

        public final void seekTo$animation_core_release(long j) {
            if (getResetSnapValue$animation_core_release() == -1.0f) {
                this.isSeeking = true;
                if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                    setValue$animation_core_release(getAnimation().getTargetValue());
                    return;
                }
                setValue$animation_core_release(getAnimation().getValueFromNanos(j));
                this.velocityVector = getAnimation().getVelocityVectorFromNanos(j);
            }
        }

        public final void updateInitialValue$animation_core_release() {
            TargetBasedAnimation<T, V> targetBasedAnimation;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState = this.initialValueState;
            if (seekingAnimationState == null || (targetBasedAnimation = this.initialValueAnimation) == null) {
                return;
            }
            long roundToLong = MathKt.roundToLong(seekingAnimationState.getDurationNanos() * seekingAnimationState.getValue());
            T valueFromNanos = targetBasedAnimation.getValueFromNanos(roundToLong);
            if (this.useOnlyInitialValue) {
                getAnimation().setMutableTargetValue$animation_core_release(valueFromNanos);
            }
            getAnimation().setMutableInitialValue$animation_core_release(valueFromNanos);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            if (getResetSnapValue$animation_core_release() == -2.0f || this.useOnlyInitialValue) {
                setValue$animation_core_release(valueFromNanos);
            } else {
                seekTo$animation_core_release(Transition.this.getPlayTimeNanos());
            }
            if (roundToLong >= seekingAnimationState.getDurationNanos()) {
                this.initialValueState = null;
                this.initialValueAnimation = null;
                return;
            }
            seekingAnimationState.setComplete(false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            transitionAnimationState.updateAnimation(obj, z);
        }

        private final void updateAnimation(T t, boolean z) {
            FiniteAnimationSpec<T> animationSpec;
            FiniteAnimationSpec<T> delayed;
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (Intrinsics.areEqual(targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null, getTargetValue())) {
                setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, t, t, AnimationVectorsKt.newInstance(this.velocityVector)));
                this.useOnlyInitialValue = true;
                setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
                return;
            }
            if (z && !this.isSeeking) {
                animationSpec = getAnimationSpec() instanceof SpringSpec ? getAnimationSpec() : this.interruptionSpec;
            } else {
                animationSpec = getAnimationSpec();
            }
            if (Transition.this.getPlayTimeNanos() <= 0) {
                delayed = animationSpec;
            } else {
                delayed = AnimationSpecKt.delayed(animationSpec, Transition.this.getPlayTimeNanos());
            }
            setAnimation(new TargetBasedAnimation<>(delayed, this.typeConverter, t, getTargetValue(), this.velocityVector));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.this.onChildAnimationUpdated();
        }

        public final void resetAnimation$animation_core_release() {
            setResetSnapValue$animation_core_release(-2.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core_release(float f) {
            Object targetValue;
            int i = (f > (-4.0f) ? 1 : (f == (-4.0f) ? 0 : -1));
            if (i == 0 || f == -5.0f) {
                TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
                if (targetBasedAnimation != null) {
                    getAnimation().setMutableInitialValue$animation_core_release(targetBasedAnimation.getTargetValue());
                    this.initialValueState = null;
                    this.initialValueAnimation = null;
                }
                if (i == 0) {
                    targetValue = getAnimation().getInitialValue();
                } else {
                    targetValue = getAnimation().getTargetValue();
                }
                getAnimation().setMutableInitialValue$animation_core_release(targetValue);
                getAnimation().setMutableTargetValue$animation_core_release(targetValue);
                setValue$animation_core_release(targetValue);
                setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
                return;
            }
            setResetSnapValue$animation_core_release(f);
        }

        public final void setInitialValueAnimation$animation_core_release(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
            if (!Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                this.initialValueAnimation = getAnimation();
                this.initialValueState = seekingAnimationState;
            }
            setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void clearInitialAnimation$animation_core_release() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateTargetValue$animation_core_release(T t, FiniteAnimationSpec<T> finiteAnimationSpec) {
            if (this.useOnlyInitialValue) {
                TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
                if (Intrinsics.areEqual(t, targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null)) {
                    return;
                }
            }
            if (Intrinsics.areEqual(getTargetValue(), t) && getResetSnapValue$animation_core_release() == -1.0f) {
                return;
            }
            setTargetValue(t);
            setAnimationSpec(finiteAnimationSpec);
            updateAnimation(getResetSnapValue$animation_core_release() == -3.0f ? t : getValue(), !isFinished$animation_core_release());
            setFinished$animation_core_release(getResetSnapValue$animation_core_release() == -3.0f);
            if (getResetSnapValue$animation_core_release() >= 0.0f) {
                setValue$animation_core_release(getAnimation().getValueFromNanos(((float) getAnimation().getDurationNanos()) * getResetSnapValue$animation_core_release()));
            } else if (getResetSnapValue$animation_core_release() == -3.0f) {
                setValue$animation_core_release(t);
            }
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core_release(-1.0f);
        }

        public final void updateInitialAndTargetValue$animation_core_release(T t, T t2, FiniteAnimationSpec<T> finiteAnimationSpec) {
            setTargetValue(t2);
            setAnimationSpec(finiteAnimationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), t) && Intrinsics.areEqual(getAnimation().getTargetValue(), t2)) {
                return;
            }
            updateAnimation$default(this, t, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S s, S s2) {
            this.initialState = s;
            this.targetState = s2;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                return Intrinsics.areEqual(getInitialState(), segment.getInitialState()) && Intrinsics.areEqual(getTargetState(), segment.getTargetState());
            }
            return false;
        }

        public int hashCode() {
            S initialState = getInitialState();
            int hashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            S targetState = getTargetState();
            return hashCode + (targetState != null ? targetState.hashCode() : 0);
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", ExifInterface.LATITUDE_SOUTH, "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Segment<S> {
        S getInitialState();

        S getTargetState();

        /* compiled from: Transition.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(Segment<S> segment, S s, S s2) {
                return Segment.super.isTransitioningTo(s, s2);
            }
        }

        default boolean isTransitioningTo(S s, S s2) {
            return Intrinsics.areEqual(s, getInitialState()) && Intrinsics.areEqual(s2, getTargetState());
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001&B#\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001b¢\u0006\u0002\b\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00028\u00010\u001bJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R{\u0010\r\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f2.\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", Constants.ScionAnalytics.PARAM_LABEL, "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.ResponseFieldKey.STATE, "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class DeferredAnimation<T, V extends AnimationVector> {
        private final MutableState data$delegate;
        private final String label;
        private final TwoWayConverter<T, V> typeConverter;

        public DeferredAnimation(TwoWayConverter<T, V> twoWayConverter, String str) {
            MutableState mutableStateOf$default;
            this.typeConverter = twoWayConverter;
            this.label = str;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.data$delegate = mutableStateOf$default;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return (DeferredAnimationData) this.data$delegate.getValue();
        }

        public final void setData$animation_core_release(Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data$delegate.setValue(deferredAnimationData);
        }

        /* compiled from: Transition.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bk\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.ResponseFieldKey.STATE, "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", "value", "getValue", "()Ljava/lang/Object;", "updateAnimationStates", "", "segment", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes.dex */
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function12) {
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = function12;
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return (Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>>) this.transitionSpec;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                this.transitionSpec = function1;
            }

            public final Function1<S, T> getTargetValueByState() {
                return (Function1<? super S, ? extends T>) this.targetValueByState;
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> function1) {
                this.targetValueByState = function1;
            }

            public final void updateAnimationStates(Segment<S> segment) {
                T invoke = this.targetValueByState.invoke(segment.getTargetState());
                if (Transition.this.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), invoke, this.transitionSpec.invoke(segment));
                    return;
                }
                this.animation.updateTargetValue$animation_core_release(invoke, this.transitionSpec.invoke(segment));
            }

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(Transition.this.getSegment());
                return this.animation.getValue();
            }
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function12) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release == null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release = new DeferredAnimationData<>(new TransitionAnimationState(function12.invoke((S) transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, function12.invoke((S) Transition.this.getCurrentState())), this.typeConverter, this.label), function1, function12);
                Transition<S> transition2 = Transition.this;
                setData$animation_core_release(data$animation_core_release);
                transition2.addAnimation$animation_core_release(data$animation_core_release.getAnimation());
            }
            Transition<S> transition3 = Transition.this;
            data$animation_core_release.setTargetValueByState(function12);
            data$animation_core_release.setTransitionSpec(function1);
            data$animation_core_release.updateAnimationStates(transition3.getSegment());
            return data$animation_core_release;
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getTargetState()), data$animation_core_release.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    public final void removeAnimation$animation_core_release(Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        Transition<S>.TransitionAnimationState<?, ?> animation;
        Transition<S>.DeferredAnimationData<?, V>.DeferredAnimationData<?, ?> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release == null || (animation = data$animation_core_release.getAnimation()) == null) {
            return;
        }
        removeAnimation$animation_core_release(animation);
    }
}

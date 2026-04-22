package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u00108\u001a\u00020\u0007H\u0016J\u001f\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J'\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020E2\u0006\u0010;\u001a\u00020EH\u0096@¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001a\u00020\u0007J\u0017\u0010I\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\bJ\u0010KJ\u0016\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&H\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020&H\u0002J\u000e\u0010P\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR+\u0010,\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u0014\u00100\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001d¨\u0006S"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "setRefreshing", "(Z)V", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "getEnabled", "setEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "()F", "setThreshold-0680j_4", "(F)V", "F", "shouldAutoInvalidate", "getShouldAutoInvalidate", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<set-?>", "", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "thresholdPx", "", "getThresholdPx", "()I", "progress", "getProgress", "onAttach", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "consumeAvailableOffset", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateVerticalOffset", "animateToThreshold", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToHidden", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshModifierNode extends DelegatingNode implements NestedScrollConnection {
    public static final int $stable = 8;
    private final MutableFloatState distancePulled$delegate;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0<Unit> onRefresh;
    private PullToRefreshState state;
    private float threshold;
    private final MutableFloatState verticalOffset$delegate;

    public /* synthetic */ PullToRefreshModifierNode(boolean z, Function0 function0, boolean z2, PullToRefreshState pullToRefreshState, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, z2, pullToRefreshState, f);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    public final void setOnRefresh(Function0<Unit> function0) {
        this.onRefresh = function0;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    public final void setState(PullToRefreshState pullToRefreshState) {
        this.state = pullToRefreshState;
    }

    /* renamed from: getThreshold-D9Ej5fM  reason: not valid java name */
    public final float m3110getThresholdD9Ej5fM() {
        return this.threshold;
    }

    /* renamed from: setThreshold-0680j_4  reason: not valid java name */
    public final void m3111setThreshold0680j_4(float f) {
        this.threshold = f;
    }

    private PullToRefreshModifierNode(boolean z, Function0<Unit> function0, boolean z2, PullToRefreshState pullToRefreshState, float f) {
        this.isRefreshing = z;
        this.onRefresh = function0;
        this.enabled = z2;
        this.state = pullToRefreshState;
        this.threshold = f;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, null);
        this.verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getVerticalOffset() {
        return this.verticalOffset$delegate.getFloatValue();
    }

    private final void setVerticalOffset(float f) {
        this.verticalOffset$delegate.setFloatValue(f);
    }

    private final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled$delegate.setFloatValue(f);
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled() * 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getThresholdPx() {
        return DelegatableNodeKt.requireDensity(this).mo399roundToPx0680j_4(this.threshold);
    }

    private final float getProgress() {
        return getAdjustedDistancePulled() / getThresholdPx();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        delegate(this.nestedScrollNode);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new PullToRefreshModifierNode$onAttach$1(this, null), 3, null);
        setVerticalOffset(this.isRefreshing ? getThresholdPx() : 0.0f);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo896onPreScrollOzD1aCk(long j, int i) {
        if (!this.state.isAnimating() && this.enabled) {
            if (NestedScrollSource.m5953equalsimpl0(i, NestedScrollSource.Companion.m5965getUserInputWNlRxjI()) && Float.intBitsToFloat((int) (4294967295L & j)) < 0.0f) {
                return m3109consumeAvailableOffsetMKHz9U(j);
            }
            return Offset.Companion.m4543getZeroF1C5BW0();
        }
        return Offset.Companion.m4543getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo573onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.state.isAnimating() && this.enabled) {
            if (NestedScrollSource.m5953equalsimpl0(i, NestedScrollSource.Companion.m5965getUserInputWNlRxjI())) {
                long m3109consumeAvailableOffsetMKHz9U = m3109consumeAvailableOffsetMKHz9U(j2);
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3, null);
                return m3109consumeAvailableOffsetMKHz9U;
            }
            return Offset.Companion.m4543getZeroF1C5BW0();
        }
        return Offset.Companion.m4543getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo895onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        PullToRefreshModifierNode$onPreFling$1 pullToRefreshModifierNode$onPreFling$1;
        int i;
        float f;
        if (continuation instanceof PullToRefreshModifierNode$onPreFling$1) {
            pullToRefreshModifierNode$onPreFling$1 = (PullToRefreshModifierNode$onPreFling$1) continuation;
            if ((pullToRefreshModifierNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshModifierNode$onPreFling$1.label -= Integer.MIN_VALUE;
                Object obj = pullToRefreshModifierNode$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pullToRefreshModifierNode$onPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    float m7794getYimpl = Velocity.m7794getYimpl(j);
                    pullToRefreshModifierNode$onPreFling$1.F$0 = 0.0f;
                    pullToRefreshModifierNode$onPreFling$1.label = 1;
                    obj = onRelease(m7794getYimpl, pullToRefreshModifierNode$onPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f = 0.0f;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f = pullToRefreshModifierNode$onPreFling$1.F$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Velocity.m7784boximpl(VelocityKt.Velocity(f, ((Number) obj).floatValue()));
            }
        }
        pullToRefreshModifierNode$onPreFling$1 = new PullToRefreshModifierNode$onPreFling$1(this, continuation);
        Object obj2 = pullToRefreshModifierNode$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pullToRefreshModifierNode$onPreFling$1.label;
        if (i != 0) {
        }
        return Velocity.m7784boximpl(VelocityKt.Velocity(f, ((Number) obj2).floatValue()));
    }

    public final void update() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new PullToRefreshModifierNode$update$1(this, null), 3, null);
    }

    /* renamed from: consumeAvailableOffset-MK-Hz9U  reason: not valid java name */
    private final long m3109consumeAvailableOffsetMKHz9U(long j) {
        float distancePulled;
        if (this.isRefreshing) {
            distancePulled = 0.0f;
        } else {
            float coerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + Float.intBitsToFloat((int) (j & 4294967295L)), 0.0f);
            distancePulled = coerceAtLeast - getDistancePulled();
            setDistancePulled(coerceAtLeast);
            setVerticalOffset(calculateVerticalOffset());
        }
        return Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(distancePulled) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onRelease(float f, Continuation<? super Float> continuation) {
        PullToRefreshModifierNode$onRelease$1 pullToRefreshModifierNode$onRelease$1;
        int i;
        if (continuation instanceof PullToRefreshModifierNode$onRelease$1) {
            pullToRefreshModifierNode$onRelease$1 = (PullToRefreshModifierNode$onRelease$1) continuation;
            if ((pullToRefreshModifierNode$onRelease$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshModifierNode$onRelease$1.label -= Integer.MIN_VALUE;
                Object obj = pullToRefreshModifierNode$onRelease$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pullToRefreshModifierNode$onRelease$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.isRefreshing) {
                        return Boxing.boxFloat(0.0f);
                    }
                    if (getAdjustedDistancePulled() > getThresholdPx()) {
                        this.onRefresh.invoke();
                    }
                    if (getDistancePulled() == 0.0f || f < 0.0f) {
                        f = 0.0f;
                    }
                    pullToRefreshModifierNode$onRelease$1.F$0 = f;
                    pullToRefreshModifierNode$onRelease$1.label = 1;
                    if (animateToHidden(pullToRefreshModifierNode$onRelease$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    f = pullToRefreshModifierNode$onRelease$1.F$0;
                    ResultKt.throwOnFailure(obj);
                }
                setDistancePulled(0.0f);
                return Boxing.boxFloat(f);
            }
        }
        pullToRefreshModifierNode$onRelease$1 = new PullToRefreshModifierNode$onRelease$1(this, continuation);
        Object obj2 = pullToRefreshModifierNode$onRelease$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pullToRefreshModifierNode$onRelease$1.label;
        if (i != 0) {
        }
        setDistancePulled(0.0f);
        return Boxing.boxFloat(f);
    }

    private final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= getThresholdPx()) {
            return getAdjustedDistancePulled();
        }
        float coerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        float pow = coerceIn - (((float) Math.pow(coerceIn, 2.0d)) / 4.0f);
        return getThresholdPx() + (getThresholdPx() * pow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToThreshold(Continuation<? super Unit> continuation) {
        PullToRefreshModifierNode$animateToThreshold$1 pullToRefreshModifierNode$animateToThreshold$1;
        int i;
        try {
            if (continuation instanceof PullToRefreshModifierNode$animateToThreshold$1) {
                pullToRefreshModifierNode$animateToThreshold$1 = (PullToRefreshModifierNode$animateToThreshold$1) continuation;
                if ((pullToRefreshModifierNode$animateToThreshold$1.label & Integer.MIN_VALUE) != 0) {
                    pullToRefreshModifierNode$animateToThreshold$1.label -= Integer.MIN_VALUE;
                    Object obj = pullToRefreshModifierNode$animateToThreshold$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pullToRefreshModifierNode$animateToThreshold$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        PullToRefreshState pullToRefreshState = this.state;
                        pullToRefreshModifierNode$animateToThreshold$1.label = 1;
                        if (pullToRefreshState.animateToThreshold(pullToRefreshModifierNode$animateToThreshold$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (isAttached()) {
                        setDistancePulled(getThresholdPx());
                        setVerticalOffset(getThresholdPx());
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            if (isAttached()) {
            }
            return Unit.INSTANCE;
        } finally {
            if (isAttached()) {
                setDistancePulled(getThresholdPx());
                setVerticalOffset(getThresholdPx());
            }
        }
        pullToRefreshModifierNode$animateToThreshold$1 = new PullToRefreshModifierNode$animateToThreshold$1(this, continuation);
        Object obj2 = pullToRefreshModifierNode$animateToThreshold$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pullToRefreshModifierNode$animateToThreshold$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.Unit, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToHidden(Continuation<? super Unit> continuation) {
        PullToRefreshModifierNode$animateToHidden$1 pullToRefreshModifierNode$animateToHidden$1;
        int i;
        try {
            if (continuation instanceof PullToRefreshModifierNode$animateToHidden$1) {
                pullToRefreshModifierNode$animateToHidden$1 = (PullToRefreshModifierNode$animateToHidden$1) continuation;
                if ((pullToRefreshModifierNode$animateToHidden$1.label & Integer.MIN_VALUE) != 0) {
                    pullToRefreshModifierNode$animateToHidden$1.label -= Integer.MIN_VALUE;
                    Object obj = pullToRefreshModifierNode$animateToHidden$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pullToRefreshModifierNode$animateToHidden$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        PullToRefreshState pullToRefreshState = this.state;
                        pullToRefreshModifierNode$animateToHidden$1.label = 1;
                        if (pullToRefreshState.animateToHidden(pullToRefreshModifierNode$animateToHidden$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    setDistancePulled(0.0f);
                    setVerticalOffset(0.0f);
                    this = Unit.INSTANCE;
                    return this;
                }
            }
            if (i != 0) {
            }
            setDistancePulled(0.0f);
            setVerticalOffset(0.0f);
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            this.setDistancePulled(0.0f);
            this.setVerticalOffset(0.0f);
            throw th;
        }
        pullToRefreshModifierNode$animateToHidden$1 = new PullToRefreshModifierNode$animateToHidden$1(this, continuation);
        Object obj2 = pullToRefreshModifierNode$animateToHidden$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pullToRefreshModifierNode$animateToHidden$1.label;
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
/* compiled from: TrackpadScrollingLogic.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u00010BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u001c*\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001b\u0010%\u001a\u00020#*\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u001a\u0010+\u001a\u00020\u000b*\u00020\u00032\u0006\u0010&\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010,J\u0014\u0010+\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u00020-H\u0002R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic;", "Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "receivingPanEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onPan", "", "sumOrNull", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "trackVelocity", "dispatchTrackpadScroll", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "delta", "TrackpadScrollDelta", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TrackpadScrollingLogic extends NonTouchScrollingLogic {
    public static final int $stable = 8;
    private final Channel<TrackpadScrollDelta> channel;
    private Job receivingPanEventsJob;

    public TrackpadScrollingLogic(ScrollingLogic scrollingLogic, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        super(scrollingLogic, function2, density);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo555onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            if (PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6634getPanStart7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6633getPanMove7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6632getPanEnd7fucELk())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (changes.get(i).isConsumed()) {
                        return;
                    }
                }
                if (pointerEventPass == PointerEventPass.Initial && isScrolling$foundation()) {
                    onPan(pointerEvent);
                    consume$foundation(pointerEvent);
                }
                if (pointerEventPass == PointerEventPass.Main && !isScrolling$foundation() && onPan(pointerEvent)) {
                    consume$foundation(pointerEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrackpadScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "isEnd", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "()Z", "plus", "other", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TrackpadScrollDelta {
        private final boolean isEnd;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ TrackpadScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        private TrackpadScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.isEnd = z;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* renamed from: getValue-F1C5BW0  reason: not valid java name */
        public final long m643getValueF1C5BW0() {
            return this.value;
        }

        public final boolean isEnd() {
            return this.isEnd;
        }

        public final TrackpadScrollDelta plus(TrackpadScrollDelta trackpadScrollDelta) {
            return new TrackpadScrollDelta(Offset.m5108plusMKHz9U(this.value, trackpadScrollDelta.value), Math.max(this.timeMillis, trackpadScrollDelta.timeMillis), this.isEnd || trackpadScrollDelta.isEnd, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    public void startReceivingEvents(CoroutineScope coroutineScope) {
        Job launch$default;
        if (this.receivingPanEventsJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TrackpadScrollingLogic$startReceivingEvents$1(this, null), 3, null);
            this.receivingPanEventsJob = launch$default;
        }
    }

    private final boolean onPan(PointerEvent pointerEvent) {
        boolean z;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            return false;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) pointerEvent.getChanges());
        if (pointerInputChange != null) {
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size = historical.size();
            z = false;
            for (int i = 0; i < size; i++) {
                HistoricalChange historicalChange = historical.get(i);
                long m5095constructorimpl = Offset.m5095constructorimpl((-9223372034707292160L) ^ historicalChange.m6585getPanOffsetF1C5BW0());
                if (m642canConsumeDeltaUv8p0NA(getScrollingLogic(), m5095constructorimpl)) {
                    z = ChannelResult.m11477isSuccessimpl(this.channel.mo9057trySendJP2dKIU(new TrackpadScrollDelta(m5095constructorimpl, historicalChange.getUptimeMillis(), false, null))) || z;
                }
            }
            long m5095constructorimpl2 = Offset.m5095constructorimpl(pointerInputChange.m6684getPanOffsetF1C5BW0() ^ (-9223372034707292160L));
            boolean m6625equalsimpl0 = PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6632getPanEnd7fucELk());
            if (m642canConsumeDeltaUv8p0NA(getScrollingLogic(), m5095constructorimpl2) || m6625equalsimpl0) {
                if (ChannelResult.m11477isSuccessimpl(this.channel.mo9057trySendJP2dKIU(new TrackpadScrollDelta(m5095constructorimpl2, pointerInputChange.getUptimeMillis(), m6625equalsimpl0, null))) || z) {
                    z = true;
                }
            }
            return !z || isScrolling$foundation();
        }
        z = false;
        if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrackpadScrollDelta sumOrNull(final Channel<TrackpadScrollDelta> channel) {
        TrackpadScrollDelta trackpadScrollDelta = null;
        for (TrackpadScrollDelta trackpadScrollDelta2 : NonTouchScrollingLogicKt.untilNull(new Function0() { // from class: androidx.compose.foundation.gestures.TrackpadScrollingLogic$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrackpadScrollingLogic.sumOrNull$lambda$0(Channel.this);
            }
        })) {
            trackpadScrollDelta = trackpadScrollDelta == null ? trackpadScrollDelta2 : trackpadScrollDelta.plus(trackpadScrollDelta2);
        }
        return trackpadScrollDelta;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TrackpadScrollDelta sumOrNull$lambda$0(Channel channel) {
        return (TrackpadScrollDelta) ChannelResult.m11472getOrNullimpl(channel.mo11461tryReceivePtdJZtk());
    }

    /* renamed from: canConsumeDelta-Uv8p0NA  reason: not valid java name */
    private final boolean m642canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        return !(scrollingLogic.m623toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m619reverseIfNeededMKHz9U(j)) == 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(TrackpadScrollDelta trackpadScrollDelta) {
        getVelocityTracker$foundation().m479addDeltaUv8p0NA(trackpadScrollDelta.getTimeMillis(), trackpadScrollDelta.m643getValueF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (userScroll$foundation(new androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3(r5, r6, r8, null), r0) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r6.invoke(r5, r0) != r1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchTrackpadScroll(ScrollingLogic scrollingLogic, TrackpadScrollDelta trackpadScrollDelta, Continuation<? super Unit> continuation) {
        TrackpadScrollingLogic$dispatchTrackpadScroll$1 trackpadScrollingLogic$dispatchTrackpadScroll$1;
        int i;
        if (continuation instanceof TrackpadScrollingLogic$dispatchTrackpadScroll$1) {
            trackpadScrollingLogic$dispatchTrackpadScroll$1 = (TrackpadScrollingLogic$dispatchTrackpadScroll$1) continuation;
            if ((trackpadScrollingLogic$dispatchTrackpadScroll$1.label & Integer.MIN_VALUE) != 0) {
                trackpadScrollingLogic$dispatchTrackpadScroll$1.label -= Integer.MIN_VALUE;
                Object obj = trackpadScrollingLogic$dispatchTrackpadScroll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = trackpadScrollingLogic$dispatchTrackpadScroll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = trackpadScrollDelta;
                    trackVelocity(trackpadScrollDelta);
                    TrackpadScrollDelta sumOrNull = sumOrNull(this.channel);
                    if (sumOrNull != null) {
                        trackVelocity(sumOrNull);
                        objectRef.element = ((TrackpadScrollDelta) objectRef.element).plus(sumOrNull);
                    }
                    trackpadScrollingLogic$dispatchTrackpadScroll$1.label = 1;
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped = getOnScrollStopped();
                Velocity m8389boximpl = Velocity.m8389boximpl(getVelocityTracker$foundation().m480calculateVelocity9UxMQ8M());
                trackpadScrollingLogic$dispatchTrackpadScroll$1.label = 2;
            }
        }
        trackpadScrollingLogic$dispatchTrackpadScroll$1 = new TrackpadScrollingLogic$dispatchTrackpadScroll$1(this, continuation);
        Object obj2 = trackpadScrollingLogic$dispatchTrackpadScroll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = trackpadScrollingLogic$dispatchTrackpadScroll$1.label;
        if (i != 0) {
        }
        Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped2 = getOnScrollStopped();
        Velocity m8389boximpl2 = Velocity.m8389boximpl(getVelocityTracker$foundation().m480calculateVelocity9UxMQ8M());
        trackpadScrollingLogic$dispatchTrackpadScroll$1.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchTrackpadScroll(NestedScrollScope nestedScrollScope, float f) {
        ScrollingLogic scrollingLogic = getScrollingLogic();
        return scrollingLogic.m621toFloatk4lQ0M(scrollingLogic.m619reverseIfNeededMKHz9U(nestedScrollScope.mo561scrollByWithOverscrollOzD1aCk(scrollingLogic.m622toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f)), NestedScrollSource.Companion.m6554getUserInputWNlRxjI())));
    }
}

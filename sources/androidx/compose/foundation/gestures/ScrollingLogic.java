package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001:\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b'\u0010%J\u0011\u0010(\u001a\u00020)*\u00020\u001d¢\u0006\u0004\b*\u0010\u001fJ\u0013\u0010#\u001a\u00020\u001d*\u00020)H\u0002¢\u0006\u0004\b+\u0010%J\u0013\u0010,\u001a\u00020)*\u00020)H\u0002¢\u0006\u0004\b-\u0010\"J\u001b\u0010.\u001a\u00020)*\u00020)2\u0006\u0010/\u001a\u00020\u001dH\u0002¢\u0006\u0004\b0\u00101J\n\u00102\u001a\u00020\u001d*\u00020\u001dJ\u0011\u00102\u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b3\u0010\"J#\u0010>\u001a\u00020\u001c*\u0002082\u0006\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u000205H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0016¢\u0006\u0004\bG\u0010\"J\u0017\u0010H\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001cH\u0002¢\u0006\u0004\bI\u0010\"J \u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)H\u0096@¢\u0006\u0004\bR\u0010SJ\u0006\u0010T\u001a\u00020\u000bJA\u0010F\u001a\u00020K2\b\b\u0002\u0010U\u001a\u00020V2'\u0010W\u001a#\b\u0001\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0Z\u0012\u0006\u0012\u0004\u0018\u00010[0X¢\u0006\u0002\b\\H\u0086@¢\u0006\u0002\u0010]J8\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010^\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u001a¨\u0006_"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "onScrollChangedDispatcher", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "value", "isFlinging", "()Z", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "", "toOffset-tuRUvjQ", "(F)J", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toSingleAxisDeltaFromAngle", "toSingleAxisDeltaFromAngle-k-4lQ0M", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat-TH1AsA0", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "update", "newValue", "update-QWom1Mo", "(JF)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLogic implements ScrollLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private OnScrollChangedDispatcher onScrollChangedDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.Companion.m6554getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollBy-OzD1aCk */
        public long mo560scrollByOzD1aCk(long j, int i) {
            ScrollScope scrollScope;
            long m614performScroll3eAAhYA;
            scrollScope = ScrollingLogic.this.outerStateScope;
            m614performScroll3eAAhYA = ScrollingLogic.this.m614performScroll3eAAhYA(scrollScope, j, i);
            return m614performScroll3eAAhYA;
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo561scrollByWithOverscrollOzD1aCk(long j, int i) {
            OverscrollEffect overscrollEffect;
            ScrollScope scrollScope;
            long m614performScroll3eAAhYA;
            boolean shouldDispatchOverscroll;
            int i2;
            Function1<? super Offset, Offset> function1;
            ScrollingLogic.this.latestScrollSource = i;
            overscrollEffect = ScrollingLogic.this.overscrollEffect;
            if (overscrollEffect != null) {
                shouldDispatchOverscroll = ScrollingLogic.this.getShouldDispatchOverscroll();
                if (shouldDispatchOverscroll) {
                    i2 = ScrollingLogic.this.latestScrollSource;
                    function1 = ScrollingLogic.this.performScrollForOverscroll;
                    return overscrollEffect.mo266applyToScrollRhakbz0(j, i2, function1);
                }
            }
            scrollScope = ScrollingLogic.this.outerStateScope;
            m614performScroll3eAAhYA = ScrollingLogic.this.m614performScroll3eAAhYA(scrollScope, j, i);
            return m614performScroll3eAAhYA;
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Offset m5092boximpl;
            m5092boximpl = Offset.m5092boximpl(r0.m614performScroll3eAAhYA(r0.outerStateScope, ((Offset) obj).m5113unboximpl(), ScrollingLogic.this.latestScrollSource));
            return m5092boximpl;
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher, OnScrollChangedDispatcher onScrollChangedDispatcher, Function0<Boolean> function0) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.onScrollChangedDispatcher = onScrollChangedDispatcher;
        this.isScrollableNodeAttached = function0;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m622toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m5119getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(f) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m620singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m5097copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m5097copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m621toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: toVelocity-adjELrA  reason: not valid java name */
    public final long m624toVelocityadjELrA(float f) {
        if (f == 0.0f) {
            return Velocity.Companion.m8409getZero9UxMQ8M();
        }
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m616toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m8398getXimpl(j) : Velocity.m8399getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    private final long m615singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m8394copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m8394copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m617updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m8394copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m8394copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1.0f) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m619reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m5110timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA  reason: not valid java name */
    public final long m614performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long m6538dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m6538dispatchPreScrollOzD1aCk(j, i);
        long m5107minusMKHz9U = Offset.m5107minusMKHz9U(j, m6538dispatchPreScrollOzD1aCk);
        long m619reverseIfNeededMKHz9U = m619reverseIfNeededMKHz9U(m622toOffsettuRUvjQ(scrollScope.scrollBy(m621toFloatk4lQ0M(m619reverseIfNeededMKHz9U(m620singleAxisOffsetMKHz9U(m5107minusMKHz9U))))));
        this.onScrollChangedDispatcher.mo563dispatchScrollDeltaInfok4lQ0M(m619reverseIfNeededMKHz9U);
        return Offset.m5108plusMKHz9U(Offset.m5108plusMKHz9U(m6538dispatchPreScrollOzD1aCk, m619reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m6536dispatchPostScrollDzOQY0M(m619reverseIfNeededMKHz9U, Offset.m5107minusMKHz9U(m5107minusMKHz9U, m619reverseIfNeededMKHz9U), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* renamed from: performRawScroll-MK-Hz9U */
    public long mo592performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m5119getZeroF1C5BW0();
        }
        return m613dispatchRawDeltaMKHz9U(j);
    }

    /* renamed from: dispatchRawDelta-MK-Hz9U  reason: not valid java name */
    private final long m613dispatchRawDeltaMKHz9U(long j) {
        return m622toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m621toFloatk4lQ0M(j)))));
    }

    /* renamed from: onScrollStopped-BMRW4eQ  reason: not valid java name */
    public final Object m618onScrollStoppedBMRW4eQ(long j, boolean z, Continuation<? super Unit> continuation) {
        if (z && !ScrollableKt.access$getShouldBeTriggeredByMouseWheel(this.flingBehavior)) {
            return Unit.INSTANCE;
        }
        long m615singleAxisVelocityAH228Gc = m615singleAxisVelocityAH228Gc(j);
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            Object mo265applyToFlingBMRW4eQ = overscrollEffect.mo265applyToFlingBMRW4eQ(m615singleAxisVelocityAH228Gc, scrollingLogic$onScrollStopped$performFling$1, continuation);
            return mo265applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo265applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object invoke = scrollingLogic$onScrollStopped$performFling$1.invoke(Velocity.m8389boximpl(m615singleAxisVelocityAH228Gc), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* renamed from: doFlingAnimation-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo591doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        int i;
        ScrollingLogic scrollingLogic;
        Throwable th;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
                Object obj = scrollingLogic$doFlingAnimation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollingLogic$doFlingAnimation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = j;
                    this.isFlinging = true;
                    try {
                        MutatePriority mutatePriority = MutatePriority.Default;
                        scrollingLogic = this;
                        try {
                            scrollingLogic$doFlingAnimation$1.L$0 = longRef2;
                            scrollingLogic$doFlingAnimation$1.label = 1;
                            if (scrollingLogic.scroll(mutatePriority, new ScrollingLogic$doFlingAnimation$2(scrollingLogic, longRef2, j, null), scrollingLogic$doFlingAnimation$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            longRef = longRef2;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            scrollingLogic.isFlinging = false;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        scrollingLogic = this;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    longRef = (Ref.LongRef) scrollingLogic$doFlingAnimation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        scrollingLogic = this;
                    } catch (Throwable th4) {
                        th = th4;
                        scrollingLogic = this;
                        scrollingLogic.isFlinging = false;
                        throw th;
                    }
                }
                scrollingLogic.isFlinging = false;
                return Velocity.m8389boximpl(longRef.element);
            }
        }
        scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        Object obj2 = scrollingLogic$doFlingAnimation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollingLogic$doFlingAnimation$1.label;
        if (i != 0) {
        }
        scrollingLogic.isFlinging = false;
        return Velocity.m8389boximpl(longRef.element);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic scrollingLogic, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic.scroll(mutatePriority, function2, continuation);
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z2;
        boolean z3 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z2 = false;
        } else {
            this.scrollableState = scrollableState;
            z2 = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z2 = true;
        }
        if (this.reverseDirection != z) {
            this.reverseDirection = z;
        } else {
            z3 = z2;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z3;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    /* renamed from: toSingleAxisDeltaFromAngle-k-4lQ0M  reason: not valid java name */
    public final float m623toSingleAxisDeltaFromAnglek4lQ0M(long j) {
        int i = (int) (4294967295L & j);
        int i2 = (int) (j >> 32);
        int i3 = (((float) Math.atan2(Math.abs(Float.intBitsToFloat(i)), Math.abs(Float.intBitsToFloat(i2)))) > 0.7853981633974483d ? 1 : (((float) Math.atan2(Math.abs(Float.intBitsToFloat(i)), Math.abs(Float.intBitsToFloat(i2)))) == 0.7853981633974483d ? 0 : -1));
        Orientation orientation = this.orientation;
        if (i3 >= 0) {
            if (orientation == Orientation.Vertical) {
                return Float.intBitsToFloat(i);
            }
            return 0.0f;
        } else if (orientation == Orientation.Horizontal) {
            return Float.intBitsToFloat(i2);
        } else {
            return 0.0f;
        }
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010!\u001a\u00020 *\u00020\u001a2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010&\u001a\u00020\f2\u0006\u0010*\u001a\u00020+¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00100J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+H\u0086@¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020+H\u0096@¢\u0006\u0004\b:\u00107J\u0006\u0010;\u001a\u00020\fJA\u0010.\u001a\u0002042\b\b\u0002\u0010<\u001a\u00020=2'\u0010>\u001a#\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002040A\u0012\u0006\u0012\u0004\u0018\u00010B0?¢\u0006\u0002\bCH\u0086@¢\u0006\u0002\u0010DJ(\u0010E\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/Scrollable2DState;)V", "value", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/Scroll2DScope;JI)J", "shouldDispatchOverscroll", TypedValues.CycleType.S_WAVE_OFFSET, "shouldDispatchOverscroll-k-4lQ0M", "(J)Z", "velocity", "Landroidx/compose/ui/unit/Velocity;", "shouldDispatchOverscroll-TH1AsA0", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "onScrollStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLogic2D implements ScrollLogic {
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private int latestScrollSource = NestedScrollSource.Companion.m5965getUserInputWNlRxjI();
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic2D$nestedScrollScope$1 nestedScrollScope;
    private Scroll2DScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private Scrollable2DState scrollableState;

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1] */
    public ScrollingLogic2D(Scrollable2DState scrollable2DState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher, Function0<Boolean> function0) {
        Scroll2DScope scroll2DScope;
        this.scrollableState = scrollable2DState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.isScrollableNodeAttached = function0;
        scroll2DScope = Scrollable2DKt.NoOpScrollScope;
        this.outerStateScope = scroll2DScope;
        this.nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1
            @Override // androidx.compose.foundation.gestures.NestedScrollScope
            /* renamed from: scrollBy-OzD1aCk */
            public long mo530scrollByOzD1aCk(long j, int i) {
                Scroll2DScope scroll2DScope2;
                long m596performScroll3eAAhYA;
                scroll2DScope2 = ScrollingLogic2D.this.outerStateScope;
                m596performScroll3eAAhYA = ScrollingLogic2D.this.m596performScroll3eAAhYA(scroll2DScope2, j, i);
                return m596performScroll3eAAhYA;
            }

            @Override // androidx.compose.foundation.gestures.NestedScrollScope
            /* renamed from: scrollByWithOverscroll-OzD1aCk */
            public long mo531scrollByWithOverscrollOzD1aCk(long j, int i) {
                OverscrollEffect overscrollEffect2;
                Scroll2DScope scroll2DScope2;
                long m596performScroll3eAAhYA;
                int i2;
                Function1<? super Offset, Offset> function1;
                ScrollingLogic2D.this.latestScrollSource = i;
                overscrollEffect2 = ScrollingLogic2D.this.overscrollEffect;
                if (overscrollEffect2 == null || !ScrollingLogic2D.this.m599shouldDispatchOverscrollk4lQ0M(j)) {
                    scroll2DScope2 = ScrollingLogic2D.this.outerStateScope;
                    m596performScroll3eAAhYA = ScrollingLogic2D.this.m596performScroll3eAAhYA(scroll2DScope2, j, i);
                    return m596performScroll3eAAhYA;
                }
                i2 = ScrollingLogic2D.this.latestScrollSource;
                function1 = ScrollingLogic2D.this.performScrollForOverscroll;
                return overscrollEffect2.mo242applyToScrollRhakbz0(j, i2, function1);
            }
        };
        this.performScrollForOverscroll = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Offset m4516boximpl;
                m4516boximpl = Offset.m4516boximpl(r0.m596performScroll3eAAhYA(r0.outerStateScope, ((Offset) obj).m4537unboximpl(), ScrollingLogic2D.this.latestScrollSource));
                return m4516boximpl;
            }
        };
    }

    public final Scrollable2DState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(Scrollable2DState scrollable2DState) {
        this.scrollableState = scrollable2DState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA  reason: not valid java name */
    public final long m596performScroll3eAAhYA(Scroll2DScope scroll2DScope, long j, int i) {
        long m5949dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m5949dispatchPreScrollOzD1aCk(j, i);
        long m4531minusMKHz9U = Offset.m4531minusMKHz9U(j, m5949dispatchPreScrollOzD1aCk);
        long mo446scrollByMKHz9U = scroll2DScope.mo446scrollByMKHz9U(m4531minusMKHz9U);
        return Offset.m4532plusMKHz9U(Offset.m4532plusMKHz9U(m5949dispatchPreScrollOzD1aCk, mo446scrollByMKHz9U), this.nestedScrollDispatcher.m5947dispatchPostScrollDzOQY0M(mo446scrollByMKHz9U, Offset.m4531minusMKHz9U(m4531minusMKHz9U, mo446scrollByMKHz9U), i));
    }

    /* renamed from: shouldDispatchOverscroll-k-4lQ0M  reason: not valid java name */
    public final boolean m599shouldDispatchOverscrollk4lQ0M(long j) {
        return this.scrollableState.mo444canScrollk4lQ0M(j);
    }

    /* renamed from: shouldDispatchOverscroll-TH1AsA0  reason: not valid java name */
    public final boolean m598shouldDispatchOverscrollTH1AsA0(long j) {
        Scrollable2DState scrollable2DState = this.scrollableState;
        float m7793getXimpl = Velocity.m7793getXimpl(j);
        return scrollable2DState.mo444canScrollk4lQ0M(Offset.m4519constructorimpl((Float.floatToRawIntBits(Velocity.m7794getYimpl(j)) & 4294967295L) | (Float.floatToRawIntBits(m7793getXimpl) << 32)));
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* renamed from: performRawScroll-MK-Hz9U */
    public long mo562performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m4543getZeroF1C5BW0();
        }
        return m595dispatchRawDeltaMKHz9U(j);
    }

    /* renamed from: dispatchRawDelta-MK-Hz9U  reason: not valid java name */
    private final long m595dispatchRawDeltaMKHz9U(long j) {
        return this.scrollableState.mo445dispatchRawDeltaMKHz9U(j);
    }

    /* renamed from: onScrollStopped-sF-c-tU  reason: not valid java name */
    public final Object m597onScrollStoppedsFctU(long j, Continuation<? super Unit> continuation) {
        ScrollingLogic2D$onScrollStopped$performFling$1 scrollingLogic2D$onScrollStopped$performFling$1 = new ScrollingLogic2D$onScrollStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && m598shouldDispatchOverscrollTH1AsA0(j)) {
            Object mo241applyToFlingBMRW4eQ = overscrollEffect.mo241applyToFlingBMRW4eQ(j, scrollingLogic2D$onScrollStopped$performFling$1, continuation);
            return mo241applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo241applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object invoke = scrollingLogic2D$onScrollStopped$performFling$1.invoke(Velocity.m7784boximpl(j), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* renamed from: doFlingAnimation-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo561doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        ScrollingLogic2D$doFlingAnimation$1 scrollingLogic2D$doFlingAnimation$1;
        int i;
        ScrollingLogic2D scrollingLogic2D;
        Throwable th;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic2D$doFlingAnimation$1) {
            scrollingLogic2D$doFlingAnimation$1 = (ScrollingLogic2D$doFlingAnimation$1) continuation;
            if ((scrollingLogic2D$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic2D$doFlingAnimation$1.label -= Integer.MIN_VALUE;
                Object obj = scrollingLogic2D$doFlingAnimation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollingLogic2D$doFlingAnimation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = j;
                    this.isFlinging = true;
                    try {
                        MutatePriority mutatePriority = MutatePriority.Default;
                        scrollingLogic2D = this;
                        try {
                            scrollingLogic2D$doFlingAnimation$1.L$0 = longRef2;
                            scrollingLogic2D$doFlingAnimation$1.label = 1;
                            if (scrollingLogic2D.scroll(mutatePriority, new ScrollingLogic2D$doFlingAnimation$2(scrollingLogic2D, j, longRef2, null), scrollingLogic2D$doFlingAnimation$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            longRef = longRef2;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            scrollingLogic2D.isFlinging = false;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        scrollingLogic2D = this;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    longRef = (Ref.LongRef) scrollingLogic2D$doFlingAnimation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        scrollingLogic2D = this;
                    } catch (Throwable th4) {
                        th = th4;
                        scrollingLogic2D = this;
                        scrollingLogic2D.isFlinging = false;
                        throw th;
                    }
                }
                scrollingLogic2D.isFlinging = false;
                return Velocity.m7784boximpl(longRef.element);
            }
        }
        scrollingLogic2D$doFlingAnimation$1 = new ScrollingLogic2D$doFlingAnimation$1(this, continuation);
        Object obj2 = scrollingLogic2D$doFlingAnimation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollingLogic2D$doFlingAnimation$1.label;
        if (i != 0) {
        }
        scrollingLogic2D.isFlinging = false;
        return Velocity.m7784boximpl(longRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long doFlingAnimation_QWom1Mo$toDecomposedOffset(float f, long j) {
        float m566getAngleTH1AsA0;
        float m566getAngleTH1AsA02;
        float m566getAngleTH1AsA03;
        m566getAngleTH1AsA0 = Scrollable2DKt.m566getAngleTH1AsA0(j);
        if (!Float.isNaN(m566getAngleTH1AsA0)) {
            m566getAngleTH1AsA02 = Scrollable2DKt.m566getAngleTH1AsA0(j);
            float abs = Math.abs(((float) Math.cos(m566getAngleTH1AsA02)) * f) * Math.signum(Velocity.m7793getXimpl(j));
            m566getAngleTH1AsA03 = Scrollable2DKt.m566getAngleTH1AsA0(j);
            return Offset.m4519constructorimpl((Float.floatToRawIntBits(abs) << 32) | (Float.floatToRawIntBits(Math.abs(((float) Math.sin(m566getAngleTH1AsA03)) * f) * Math.signum(Velocity.m7794getYimpl(j))) & 4294967295L));
        }
        return Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long doFlingAnimation_QWom1Mo$toDecomposedVelocity(float f, long j) {
        float m566getAngleTH1AsA0;
        float m566getAngleTH1AsA02;
        float m566getAngleTH1AsA03;
        m566getAngleTH1AsA0 = Scrollable2DKt.m566getAngleTH1AsA0(j);
        if (!Float.isNaN(m566getAngleTH1AsA0)) {
            m566getAngleTH1AsA02 = Scrollable2DKt.m566getAngleTH1AsA0(j);
            float abs = Math.abs(((float) Math.cos(m566getAngleTH1AsA02)) * f) * Math.signum(Velocity.m7793getXimpl(j));
            m566getAngleTH1AsA03 = Scrollable2DKt.m566getAngleTH1AsA0(j);
            return VelocityKt.Velocity(abs, Math.abs(((float) Math.sin(m566getAngleTH1AsA03)) * f) * Math.signum(Velocity.m7794getYimpl(j)));
        }
        return VelocityKt.Velocity(0.0f, f);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic2D scrollingLogic2D, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic2D.scroll(mutatePriority, function2, continuation);
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, new ScrollingLogic2D$scroll$2(this, function2, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final boolean update(Scrollable2DState scrollable2DState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        if (Intrinsics.areEqual(this.scrollableState, scrollable2DState)) {
            z = false;
        } else {
            this.scrollableState = scrollable2DState;
            z = true;
        }
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float doFlingAnimation_QWom1Mo$toMagnitudeFloat(long j) {
        return (float) Math.sqrt(((float) Math.pow(Float.intBitsToFloat((int) (j >> 32)), 2.0d)) + ((float) Math.pow(Float.intBitsToFloat((int) (j & 4294967295L)), 2.0d)));
    }
}

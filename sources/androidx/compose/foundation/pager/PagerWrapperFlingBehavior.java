package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutPager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    public PagerWrapperFlingBehavior(TargetedFlingBehavior targetedFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = targetedFlingBehavior;
        this.pagerState = pagerState;
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(final ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        PagerWrapperFlingBehavior$performFling$1 pagerWrapperFlingBehavior$performFling$1;
        int i;
        PagerWrapperFlingBehavior pagerWrapperFlingBehavior;
        if (continuation instanceof PagerWrapperFlingBehavior$performFling$1) {
            pagerWrapperFlingBehavior$performFling$1 = (PagerWrapperFlingBehavior$performFling$1) continuation;
            if ((pagerWrapperFlingBehavior$performFling$1.label & Integer.MIN_VALUE) != 0) {
                pagerWrapperFlingBehavior$performFling$1.label -= Integer.MIN_VALUE;
                Object obj = pagerWrapperFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pagerWrapperFlingBehavior$performFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    pagerWrapperFlingBehavior$performFling$1.L$0 = this;
                    pagerWrapperFlingBehavior$performFling$1.label = 1;
                    obj = this.originalFlingBehavior.performFling(scrollScope, f, new Function1<Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$resultVelocity$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                            invoke(f2.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2) {
                            PagerWrapperFlingBehavior.this.getPagerState().updateTargetPage(scrollScope, MathKt.roundToInt(PagerWrapperFlingBehavior.this.getPagerState().getPageSizeWithSpacing$foundation_release() != 0 ? f2 / PagerWrapperFlingBehavior.this.getPagerState().getPageSizeWithSpacing$foundation_release() : 0.0f) + PagerWrapperFlingBehavior.this.getPagerState().getCurrentPage());
                        }
                    }, pagerWrapperFlingBehavior$performFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pagerWrapperFlingBehavior = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) pagerWrapperFlingBehavior$performFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                float floatValue = ((Number) obj).floatValue();
                if (pagerWrapperFlingBehavior.pagerState.getCurrentPageOffsetFraction() != 0.0f && Math.abs(pagerWrapperFlingBehavior.pagerState.getCurrentPageOffsetFraction()) < 0.001d) {
                    PagerState pagerState = pagerWrapperFlingBehavior.pagerState;
                    PagerState.requestScrollToPage$default(pagerState, pagerState.getCurrentPage(), 0.0f, 2, null);
                } else {
                    pagerWrapperFlingBehavior.pagerState.getCurrentPageOffsetFraction();
                }
                return Boxing.boxFloat(floatValue);
            }
        }
        pagerWrapperFlingBehavior$performFling$1 = new PagerWrapperFlingBehavior$performFling$1(this, continuation);
        Object obj2 = pagerWrapperFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pagerWrapperFlingBehavior$performFling$1.label;
        if (i != 0) {
        }
        float floatValue2 = ((Number) obj2).floatValue();
        if (pagerWrapperFlingBehavior.pagerState.getCurrentPageOffsetFraction() != 0.0f) {
            PagerState pagerState2 = pagerWrapperFlingBehavior.pagerState;
            PagerState.requestScrollToPage$default(pagerState2, pagerState2.getCurrentPage(), 0.0f, 2, null);
            return Boxing.boxFloat(floatValue2);
        }
        pagerWrapperFlingBehavior.pagerState.getCurrentPageOffsetFraction();
        return Boxing.boxFloat(floatValue2);
    }
}

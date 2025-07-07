package androidx.compose.ui.scrollcapture;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeScrollCaptureCallback.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function2;)V", "<set-?>", "scrollAmount", "getScrollAmount", "()F", "Lkotlin/jvm/functions/Function2;", "mapOffsetToViewport", TypedValues.CycleType.S_WAVE_OFFSET, "reset", "", "delta", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollRangeIntoView", "min", "max", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RelativeScroller {
    private float scrollAmount;
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int i, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> function2) {
        this.viewportSize = i;
        this.scrollBy = function2;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    public final Object scrollRangeIntoView(int i, int i2, Continuation<? super Unit> continuation) {
        if (i > i2) {
            throw new IllegalArgumentException(("Expected min=" + i + " ≤ max=" + i2).toString());
        }
        int i3 = i2 - i;
        int i4 = this.viewportSize;
        if (i3 > i4) {
            throw new IllegalArgumentException(("Expected range (" + i3 + ") to be ≤ viewportSize=" + this.viewportSize).toString());
        }
        float f = i;
        float f2 = this.scrollAmount;
        if (f >= f2 && i2 <= i4 + f2) {
            return Unit.INSTANCE;
        }
        if (f >= f2) {
            i = i2 - i4;
        }
        Object scrollTo = scrollTo(i, continuation);
        return scrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollTo : Unit.INSTANCE;
    }

    public final int mapOffsetToViewport(int i) {
        return RangesKt.coerceIn(i - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    public final Object scrollTo(float f, Continuation<? super Unit> continuation) {
        Object scrollBy = scrollBy(f - this.scrollAmount, continuation);
        return scrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollBy : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollBy(float f, Continuation<? super Unit> continuation) {
        RelativeScroller$scrollBy$1 relativeScroller$scrollBy$1;
        int i;
        RelativeScroller relativeScroller;
        if (continuation instanceof RelativeScroller$scrollBy$1) {
            relativeScroller$scrollBy$1 = (RelativeScroller$scrollBy$1) continuation;
            if ((relativeScroller$scrollBy$1.label & Integer.MIN_VALUE) != 0) {
                relativeScroller$scrollBy$1.label -= Integer.MIN_VALUE;
                Object obj = relativeScroller$scrollBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = relativeScroller$scrollBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<Float, Continuation<? super Float>, Object> function2 = this.scrollBy;
                    Float boxFloat = Boxing.boxFloat(f);
                    relativeScroller$scrollBy$1.L$0 = this;
                    relativeScroller$scrollBy$1.label = 1;
                    obj = function2.invoke(boxFloat, relativeScroller$scrollBy$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    relativeScroller = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    relativeScroller = (RelativeScroller) relativeScroller$scrollBy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                relativeScroller.scrollAmount += ((Number) obj).floatValue();
                return Unit.INSTANCE;
            }
        }
        relativeScroller$scrollBy$1 = new RelativeScroller$scrollBy$1(this, continuation);
        Object obj2 = relativeScroller$scrollBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = relativeScroller$scrollBy$1.label;
        if (i != 0) {
        }
        relativeScroller.scrollAmount += ((Number) obj2).floatValue();
        return Unit.INSTANCE;
    }
}

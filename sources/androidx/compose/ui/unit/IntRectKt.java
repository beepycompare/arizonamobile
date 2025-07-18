package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: IntRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", TypedValues.CycleType.S_WAVE_OFFSET, "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", TtmlNode.CENTER, "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", TtmlNode.START, "stop", "fraction", "", "roundToIntRect", "Landroidx/compose/ui/geometry/Rect;", "toRect", "ui-unit_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IntRectKt {
    /* renamed from: IntRect-VbeCjmY  reason: not valid java name */
    public static final IntRect m6845IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m6812getXimpl(j), IntOffset.m6813getYimpl(j), IntOffset.m6812getXimpl(j) + ((int) (j2 >> 32)), IntOffset.m6813getYimpl(j) + ((int) (j2 & 4294967295L)));
    }

    /* renamed from: IntRect-E1MhUcY  reason: not valid java name */
    public static final IntRect m6844IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m6812getXimpl(j), IntOffset.m6813getYimpl(j), IntOffset.m6812getXimpl(j2), IntOffset.m6813getYimpl(j2));
    }

    /* renamed from: IntRect-ar5cAso  reason: not valid java name */
    public static final IntRect m6846IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m6812getXimpl(j) - i, IntOffset.m6813getYimpl(j) - i, IntOffset.m6812getXimpl(j) + i, IntOffset.m6813getYimpl(j) + i);
    }

    public static final IntRect lerp(IntRect intRect, IntRect intRect2, float f) {
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }

    public static final Rect toRect(IntRect intRect) {
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }

    public static final IntRect roundToIntRect(Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }
}

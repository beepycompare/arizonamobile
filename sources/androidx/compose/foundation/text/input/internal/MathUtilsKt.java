package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: MathUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"addExactOrElse", "", TtmlNode.RIGHT, "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "findClosestRect", "Landroidx/compose/ui/geometry/Offset;", "rect1", "Landroidx/compose/ui/geometry/Rect;", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "distanceSquaredToClosestCornerFromOutside", "", "rect", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, Function0<Integer> function0) {
        int i3 = i + i2;
        return ((i ^ i3) & (i2 ^ i3)) < 0 ? function0.invoke().intValue() : i3;
    }

    public static final int subtractExactOrElse(int i, int i2, Function0<Integer> function0) {
        int i3 = i - i2;
        return ((i ^ i3) & (i2 ^ i)) < 0 ? function0.invoke().intValue() : i3;
    }

    /* renamed from: findClosestRect-9KIMszo  reason: not valid java name */
    public static final int m1620findClosestRect9KIMszo(long j, Rect rect, Rect rect2) {
        int i = (m1619distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect) > m1619distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect2) ? 1 : (m1619distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect) == m1619distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect2) ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    /* renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k  reason: not valid java name */
    private static final float m1619distanceSquaredToClosestCornerFromOutside3MmeM6k(long j, Rect rect) {
        if (SelectionManagerKt.m1892containsInclusiveUv8p0NA(rect, j)) {
            return 0.0f;
        }
        float m5178getDistanceSquaredimpl = Offset.m5178getDistanceSquaredimpl(Offset.m5183minusMKHz9U(rect.m5214getTopLeftF1C5BW0(), j));
        if (m5178getDistanceSquaredimpl >= Float.MAX_VALUE) {
            m5178getDistanceSquaredimpl = Float.MAX_VALUE;
        }
        float m5178getDistanceSquaredimpl2 = Offset.m5178getDistanceSquaredimpl(Offset.m5183minusMKHz9U(rect.m5215getTopRightF1C5BW0(), j));
        if (m5178getDistanceSquaredimpl2 < m5178getDistanceSquaredimpl) {
            m5178getDistanceSquaredimpl = m5178getDistanceSquaredimpl2;
        }
        float m5178getDistanceSquaredimpl3 = Offset.m5178getDistanceSquaredimpl(Offset.m5183minusMKHz9U(rect.m5207getBottomLeftF1C5BW0(), j));
        if (m5178getDistanceSquaredimpl3 < m5178getDistanceSquaredimpl) {
            m5178getDistanceSquaredimpl = m5178getDistanceSquaredimpl3;
        }
        float m5178getDistanceSquaredimpl4 = Offset.m5178getDistanceSquaredimpl(Offset.m5183minusMKHz9U(rect.m5208getBottomRightF1C5BW0(), j));
        return m5178getDistanceSquaredimpl4 < m5178getDistanceSquaredimpl ? m5178getDistanceSquaredimpl4 : m5178getDistanceSquaredimpl;
    }
}

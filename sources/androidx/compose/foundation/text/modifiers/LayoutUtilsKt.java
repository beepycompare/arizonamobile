package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: LayoutUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxWidth", "", "finalMaxWidth-tfFHcEY", "(JZIF)I", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "isEllipsis", "isEllipsis-MW5-ApA", "(I)Z", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY  reason: not valid java name */
    public static final long m1546finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.Companion.m7517fitPrioritizingWidthZbe2FdA(0, m1548finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m7507getMaxHeightimpl(j));
    }

    /* renamed from: finalMaxWidth-tfFHcEY  reason: not valid java name */
    public static final int m1548finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int m7508getMaxWidthimpl = ((z || m1549isEllipsisMW5ApA(i)) && Constraints.m7504getHasBoundedWidthimpl(j)) ? Constraints.m7508getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m7510getMinWidthimpl(j) == m7508getMaxWidthimpl ? m7508getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m7510getMinWidthimpl(j), m7508getMaxWidthimpl);
    }

    /* renamed from: finalMaxLines-xdlQI24  reason: not valid java name */
    public static final int m1547finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !m1549isEllipsisMW5ApA(i)) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }

    /* renamed from: isEllipsis-MW5-ApA  reason: not valid java name */
    public static final boolean m1549isEllipsisMW5ApA(int i) {
        return TextOverflow.m7481equalsimpl0(i, TextOverflow.Companion.m7491getEllipsisgIe3tQ8()) || TextOverflow.m7481equalsimpl0(i, TextOverflow.Companion.m7493getStartEllipsisgIe3tQ8()) || TextOverflow.m7481equalsimpl0(i, TextOverflow.Companion.m7492getMiddleEllipsisgIe3tQ8());
    }
}

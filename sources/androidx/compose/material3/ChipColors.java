package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/material3/ChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getDisabledContainerColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconContentColor-0d7_KjU", "getDisabledTrailingIconContentColor-0d7_KjU", "getLabelColor-0d7_KjU", "getLeadingIconContentColor-0d7_KjU", "getTrailingIconContentColor-0d7_KjU", "enabled", "", "containerColor-vNxB06k$material3_release", "(Z)J", "copy", "copy-FD3wquc", "(JJJJJJJJ)Landroidx/compose/material3/ChipColors;", "equals", "other", "hashCode", "", "labelColor-vNxB06k$material3_release", "leadingIconContentColor-vNxB06k$material3_release", "trailingIconContentColor-vNxB06k$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconContentColor;
    private final long disabledTrailingIconContentColor;
    private final long labelColor;
    private final long leadingIconContentColor;
    private final long trailingIconContentColor;

    public /* synthetic */ ChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private ChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.containerColor = j;
        this.labelColor = j2;
        this.leadingIconContentColor = j3;
        this.trailingIconContentColor = j4;
        this.disabledContainerColor = j5;
        this.disabledLabelColor = j6;
        this.disabledLeadingIconContentColor = j7;
        this.disabledTrailingIconContentColor = j8;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1660getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getLabelColor-0d7_KjU  reason: not valid java name */
    public final long m1665getLabelColor0d7_KjU() {
        return this.labelColor;
    }

    /* renamed from: getLeadingIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m1666getLeadingIconContentColor0d7_KjU() {
        return this.leadingIconContentColor;
    }

    /* renamed from: getTrailingIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m1667getTrailingIconContentColor0d7_KjU() {
        return this.trailingIconContentColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1661getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledLabelColor-0d7_KjU  reason: not valid java name */
    public final long m1662getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* renamed from: getDisabledLeadingIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m1663getDisabledLeadingIconContentColor0d7_KjU() {
        return this.disabledLeadingIconContentColor;
    }

    /* renamed from: getDisabledTrailingIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m1664getDisabledTrailingIconContentColor0d7_KjU() {
        return this.disabledTrailingIconContentColor;
    }

    /* renamed from: copy-FD3wquc$default  reason: not valid java name */
    public static /* synthetic */ ChipColors m1657copyFD3wquc$default(ChipColors chipColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, Object obj) {
        long j9;
        long j10;
        long j11 = (i & 1) != 0 ? chipColors.containerColor : j;
        long j12 = (i & 2) != 0 ? chipColors.labelColor : j2;
        long j13 = (i & 4) != 0 ? chipColors.leadingIconContentColor : j3;
        long j14 = (i & 8) != 0 ? chipColors.trailingIconContentColor : j4;
        long j15 = (i & 16) != 0 ? chipColors.disabledContainerColor : j5;
        long j16 = (i & 32) != 0 ? chipColors.disabledLabelColor : j6;
        long j17 = (i & 64) != 0 ? chipColors.disabledLeadingIconContentColor : j7;
        if ((i & 128) != 0) {
            j9 = chipColors.disabledTrailingIconContentColor;
            j10 = j11;
        } else {
            j9 = j8;
            j10 = j11;
        }
        return chipColors.m1659copyFD3wquc(j10, j12, j13, j14, j15, j16, j17, j9);
    }

    /* renamed from: copy-FD3wquc  reason: not valid java name */
    public final ChipColors m1659copyFD3wquc(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        return new ChipColors(j != 16 ? j : this.containerColor, j2 != 16 ? j2 : this.labelColor, j3 != 16 ? j3 : this.leadingIconContentColor, j4 != 16 ? j4 : this.trailingIconContentColor, j5 != 16 ? j5 : this.disabledContainerColor, j6 != 16 ? j6 : this.disabledLabelColor, j7 != 16 ? j7 : this.disabledLeadingIconContentColor, j8 != 16 ? j8 : this.disabledTrailingIconContentColor, null);
    }

    /* renamed from: containerColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1658containerColorvNxB06k$material3_release(boolean z) {
        return z ? this.containerColor : this.disabledContainerColor;
    }

    /* renamed from: labelColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1668labelColorvNxB06k$material3_release(boolean z) {
        return z ? this.labelColor : this.disabledLabelColor;
    }

    /* renamed from: leadingIconContentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1669leadingIconContentColorvNxB06k$material3_release(boolean z) {
        return z ? this.leadingIconContentColor : this.disabledLeadingIconContentColor;
    }

    /* renamed from: trailingIconContentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1670trailingIconContentColorvNxB06k$material3_release(boolean z) {
        return z ? this.trailingIconContentColor : this.disabledTrailingIconContentColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) obj;
        return Color.m4079equalsimpl0(this.containerColor, chipColors.containerColor) && Color.m4079equalsimpl0(this.labelColor, chipColors.labelColor) && Color.m4079equalsimpl0(this.leadingIconContentColor, chipColors.leadingIconContentColor) && Color.m4079equalsimpl0(this.trailingIconContentColor, chipColors.trailingIconContentColor) && Color.m4079equalsimpl0(this.disabledContainerColor, chipColors.disabledContainerColor) && Color.m4079equalsimpl0(this.disabledLabelColor, chipColors.disabledLabelColor) && Color.m4079equalsimpl0(this.disabledLeadingIconContentColor, chipColors.disabledLeadingIconContentColor) && Color.m4079equalsimpl0(this.disabledTrailingIconContentColor, chipColors.disabledTrailingIconContentColor);
    }

    public int hashCode() {
        return (((((((((((((Color.m4085hashCodeimpl(this.containerColor) * 31) + Color.m4085hashCodeimpl(this.labelColor)) * 31) + Color.m4085hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m4085hashCodeimpl(this.trailingIconContentColor)) * 31) + Color.m4085hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4085hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m4085hashCodeimpl(this.disabledLeadingIconContentColor)) * 31) + Color.m4085hashCodeimpl(this.disabledTrailingIconContentColor);
    }
}

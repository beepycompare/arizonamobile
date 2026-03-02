package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0099\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b,\u0010*J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b.\u0010*J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b0\u0010*J\u0017\u00101\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0004\b2\u0010*J\u0013\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00105\u001a\u000206H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Landroidx/compose/material3/TimePickerColors;", "", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "selectorColor", "containerColor", "periodSelectorBorderColor", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "<init>", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClockDialColor-0d7_KjU", "()J", "J", "getSelectorColor-0d7_KjU", "getContainerColor-0d7_KjU", "getPeriodSelectorBorderColor-0d7_KjU", "getClockDialSelectedContentColor-0d7_KjU", "getClockDialUnselectedContentColor-0d7_KjU", "getPeriodSelectorSelectedContainerColor-0d7_KjU", "getPeriodSelectorUnselectedContainerColor-0d7_KjU", "getPeriodSelectorSelectedContentColor-0d7_KjU", "getPeriodSelectorUnselectedContentColor-0d7_KjU", "getTimeSelectorSelectedContainerColor-0d7_KjU", "getTimeSelectorUnselectedContainerColor-0d7_KjU", "getTimeSelectorSelectedContentColor-0d7_KjU", "getTimeSelectorUnselectedContentColor-0d7_KjU", "copy", "copy-dVHXu7A", "(JJJJJJJJJJJJJJ)Landroidx/compose/material3/TimePickerColors;", "periodSelectorContainerColor", "selected", "", "periodSelectorContainerColor-vNxB06k$material3", "(Z)J", "periodSelectorContentColor", "periodSelectorContentColor-vNxB06k$material3", "timeSelectorContainerColor", "timeSelectorContainerColor-vNxB06k$material3", "timeSelectorContentColor", "timeSelectorContentColor-vNxB06k$material3", "clockDialContentColor", "clockDialContentColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerColors {
    public static final int $stable = 0;
    private final long clockDialColor;
    private final long clockDialSelectedContentColor;
    private final long clockDialUnselectedContentColor;
    private final long containerColor;
    private final long periodSelectorBorderColor;
    private final long periodSelectorSelectedContainerColor;
    private final long periodSelectorSelectedContentColor;
    private final long periodSelectorUnselectedContainerColor;
    private final long periodSelectorUnselectedContentColor;
    private final long selectorColor;
    private final long timeSelectorSelectedContainerColor;
    private final long timeSelectorSelectedContentColor;
    private final long timeSelectorUnselectedContainerColor;
    private final long timeSelectorUnselectedContentColor;

    public /* synthetic */ TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    private TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.clockDialColor = j;
        this.selectorColor = j2;
        this.containerColor = j3;
        this.periodSelectorBorderColor = j4;
        this.clockDialSelectedContentColor = j5;
        this.clockDialUnselectedContentColor = j6;
        this.periodSelectorSelectedContainerColor = j7;
        this.periodSelectorUnselectedContainerColor = j8;
        this.periodSelectorSelectedContentColor = j9;
        this.periodSelectorUnselectedContentColor = j10;
        this.timeSelectorSelectedContainerColor = j11;
        this.timeSelectorUnselectedContainerColor = j12;
        this.timeSelectorSelectedContentColor = j13;
        this.timeSelectorUnselectedContentColor = j14;
    }

    /* renamed from: getClockDialColor-0d7_KjU  reason: not valid java name */
    public final long m2718getClockDialColor0d7_KjU() {
        return this.clockDialColor;
    }

    /* renamed from: getSelectorColor-0d7_KjU  reason: not valid java name */
    public final long m2727getSelectorColor0d7_KjU() {
        return this.selectorColor;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2721getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getPeriodSelectorBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2722getPeriodSelectorBorderColor0d7_KjU() {
        return this.periodSelectorBorderColor;
    }

    /* renamed from: getClockDialSelectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2719getClockDialSelectedContentColor0d7_KjU() {
        return this.clockDialSelectedContentColor;
    }

    /* renamed from: getClockDialUnselectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2720getClockDialUnselectedContentColor0d7_KjU() {
        return this.clockDialUnselectedContentColor;
    }

    /* renamed from: getPeriodSelectorSelectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2723getPeriodSelectorSelectedContainerColor0d7_KjU() {
        return this.periodSelectorSelectedContainerColor;
    }

    /* renamed from: getPeriodSelectorUnselectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2725getPeriodSelectorUnselectedContainerColor0d7_KjU() {
        return this.periodSelectorUnselectedContainerColor;
    }

    /* renamed from: getPeriodSelectorSelectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2724getPeriodSelectorSelectedContentColor0d7_KjU() {
        return this.periodSelectorSelectedContentColor;
    }

    /* renamed from: getPeriodSelectorUnselectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2726getPeriodSelectorUnselectedContentColor0d7_KjU() {
        return this.periodSelectorUnselectedContentColor;
    }

    /* renamed from: getTimeSelectorSelectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2728getTimeSelectorSelectedContainerColor0d7_KjU() {
        return this.timeSelectorSelectedContainerColor;
    }

    /* renamed from: getTimeSelectorUnselectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2730getTimeSelectorUnselectedContainerColor0d7_KjU() {
        return this.timeSelectorUnselectedContainerColor;
    }

    /* renamed from: getTimeSelectorSelectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2729getTimeSelectorSelectedContentColor0d7_KjU() {
        return this.timeSelectorSelectedContentColor;
    }

    /* renamed from: getTimeSelectorUnselectedContentColor-0d7_KjU  reason: not valid java name */
    public final long m2731getTimeSelectorUnselectedContentColor0d7_KjU() {
        return this.timeSelectorUnselectedContentColor;
    }

    /* renamed from: copy-dVHXu7A$default  reason: not valid java name */
    public static /* synthetic */ TimePickerColors m2715copydVHXu7A$default(TimePickerColors timePickerColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i, Object obj) {
        long j15;
        long j16;
        long j17 = (i & 1) != 0 ? timePickerColors.containerColor : j;
        long j18 = (i & 2) != 0 ? timePickerColors.selectorColor : j2;
        long j19 = (i & 4) != 0 ? timePickerColors.containerColor : j3;
        long j20 = (i & 8) != 0 ? timePickerColors.periodSelectorBorderColor : j4;
        long j21 = (i & 16) != 0 ? timePickerColors.clockDialSelectedContentColor : j5;
        long j22 = (i & 32) != 0 ? timePickerColors.clockDialUnselectedContentColor : j6;
        long j23 = (i & 64) != 0 ? timePickerColors.periodSelectorSelectedContainerColor : j7;
        long j24 = j17;
        long j25 = (i & 128) != 0 ? timePickerColors.periodSelectorUnselectedContainerColor : j8;
        long j26 = (i & 256) != 0 ? timePickerColors.periodSelectorSelectedContentColor : j9;
        long j27 = (i & 512) != 0 ? timePickerColors.periodSelectorUnselectedContentColor : j10;
        long j28 = (i & 1024) != 0 ? timePickerColors.timeSelectorSelectedContainerColor : j11;
        long j29 = (i & 2048) != 0 ? timePickerColors.timeSelectorUnselectedContainerColor : j12;
        long j30 = (i & 4096) != 0 ? timePickerColors.timeSelectorSelectedContentColor : j13;
        if ((i & 8192) != 0) {
            j16 = j30;
            j15 = timePickerColors.timeSelectorUnselectedContentColor;
        } else {
            j15 = j14;
            j16 = j30;
        }
        return timePickerColors.m2717copydVHXu7A(j24, j18, j19, j20, j21, j22, j23, j25, j26, j27, j28, j29, j16, j15);
    }

    /* renamed from: copy-dVHXu7A  reason: not valid java name */
    public final TimePickerColors m2717copydVHXu7A(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        return new TimePickerColors(j != 16 ? j : this.clockDialColor, j2 != 16 ? j2 : this.selectorColor, j3 != 16 ? j3 : this.containerColor, j4 != 16 ? j4 : this.periodSelectorBorderColor, j5 != 16 ? j5 : this.clockDialSelectedContentColor, j6 != 16 ? j6 : this.clockDialUnselectedContentColor, j7 != 16 ? j7 : this.periodSelectorSelectedContainerColor, j8 != 16 ? j8 : this.periodSelectorUnselectedContainerColor, j9 != 16 ? j9 : this.periodSelectorSelectedContentColor, j10 != 16 ? j10 : this.periodSelectorUnselectedContentColor, j11 != 16 ? j11 : this.timeSelectorSelectedContainerColor, j12 != 16 ? j12 : this.timeSelectorUnselectedContainerColor, j13 != 16 ? j13 : this.timeSelectorSelectedContentColor, j14 != 16 ? j14 : this.timeSelectorUnselectedContentColor, null);
    }

    /* renamed from: periodSelectorContainerColor-vNxB06k$material3  reason: not valid java name */
    public final long m2732periodSelectorContainerColorvNxB06k$material3(boolean z) {
        if (z) {
            return this.periodSelectorSelectedContainerColor;
        }
        return this.periodSelectorUnselectedContainerColor;
    }

    /* renamed from: periodSelectorContentColor-vNxB06k$material3  reason: not valid java name */
    public final long m2733periodSelectorContentColorvNxB06k$material3(boolean z) {
        if (z) {
            return this.periodSelectorSelectedContentColor;
        }
        return this.periodSelectorUnselectedContentColor;
    }

    /* renamed from: timeSelectorContainerColor-vNxB06k$material3  reason: not valid java name */
    public final long m2734timeSelectorContainerColorvNxB06k$material3(boolean z) {
        if (z) {
            return this.timeSelectorSelectedContainerColor;
        }
        return this.timeSelectorUnselectedContainerColor;
    }

    /* renamed from: timeSelectorContentColor-vNxB06k$material3  reason: not valid java name */
    public final long m2735timeSelectorContentColorvNxB06k$material3(boolean z) {
        if (z) {
            return this.timeSelectorSelectedContentColor;
        }
        return this.timeSelectorUnselectedContentColor;
    }

    /* renamed from: clockDialContentColor-vNxB06k$material3  reason: not valid java name */
    public final long m2716clockDialContentColorvNxB06k$material3(boolean z) {
        if (z) {
            return this.clockDialSelectedContentColor;
        }
        return this.clockDialUnselectedContentColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TimePickerColors timePickerColors = (TimePickerColors) obj;
            return Color.m4773equalsimpl0(this.clockDialColor, timePickerColors.clockDialColor) && Color.m4773equalsimpl0(this.selectorColor, timePickerColors.selectorColor) && Color.m4773equalsimpl0(this.containerColor, timePickerColors.containerColor) && Color.m4773equalsimpl0(this.periodSelectorBorderColor, timePickerColors.periodSelectorBorderColor) && Color.m4773equalsimpl0(this.periodSelectorSelectedContainerColor, timePickerColors.periodSelectorSelectedContainerColor) && Color.m4773equalsimpl0(this.periodSelectorUnselectedContainerColor, timePickerColors.periodSelectorUnselectedContainerColor) && Color.m4773equalsimpl0(this.periodSelectorSelectedContentColor, timePickerColors.periodSelectorSelectedContentColor) && Color.m4773equalsimpl0(this.periodSelectorUnselectedContentColor, timePickerColors.periodSelectorUnselectedContentColor) && Color.m4773equalsimpl0(this.timeSelectorSelectedContainerColor, timePickerColors.timeSelectorSelectedContainerColor) && Color.m4773equalsimpl0(this.timeSelectorUnselectedContainerColor, timePickerColors.timeSelectorUnselectedContainerColor) && Color.m4773equalsimpl0(this.timeSelectorSelectedContentColor, timePickerColors.timeSelectorSelectedContentColor) && Color.m4773equalsimpl0(this.timeSelectorUnselectedContentColor, timePickerColors.timeSelectorUnselectedContentColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4779hashCodeimpl(this.clockDialColor) * 31) + Color.m4779hashCodeimpl(this.selectorColor)) * 31) + Color.m4779hashCodeimpl(this.containerColor)) * 31) + Color.m4779hashCodeimpl(this.periodSelectorBorderColor)) * 31) + Color.m4779hashCodeimpl(this.periodSelectorSelectedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.periodSelectorUnselectedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.periodSelectorSelectedContentColor)) * 31) + Color.m4779hashCodeimpl(this.periodSelectorUnselectedContentColor)) * 31) + Color.m4779hashCodeimpl(this.timeSelectorSelectedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.timeSelectorUnselectedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.timeSelectorSelectedContentColor)) * 31) + Color.m4779hashCodeimpl(this.timeSelectorUnselectedContentColor);
    }
}

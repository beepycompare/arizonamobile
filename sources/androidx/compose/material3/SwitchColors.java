package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J%\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J°\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00101\u001a\u000202H\u0016J%\u00103\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010+J%\u00105\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010+J%\u00107\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010+R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedIconColor-0d7_KjU", "getCheckedThumbColor-0d7_KjU", "getCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "borderColor", "enabled", "", "checked", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "equals", "other", "hashCode", "", "iconColor", "iconColor-WaAFU9c$material3_release", "thumbColor", "thumbColor-WaAFU9c$material3_release", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
    }

    private SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.checkedBorderColor = j3;
        this.checkedIconColor = j4;
        this.uncheckedThumbColor = j5;
        this.uncheckedTrackColor = j6;
        this.uncheckedBorderColor = j7;
        this.uncheckedIconColor = j8;
        this.disabledCheckedThumbColor = j9;
        this.disabledCheckedTrackColor = j10;
        this.disabledCheckedBorderColor = j11;
        this.disabledCheckedIconColor = j12;
        this.disabledUncheckedThumbColor = j13;
        this.disabledUncheckedTrackColor = j14;
        this.disabledUncheckedBorderColor = j15;
        this.disabledUncheckedIconColor = j16;
    }

    /* renamed from: getCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2362getCheckedThumbColor0d7_KjU() {
        return this.checkedThumbColor;
    }

    /* renamed from: getCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2363getCheckedTrackColor0d7_KjU() {
        return this.checkedTrackColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2360getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2361getCheckedIconColor0d7_KjU() {
        return this.checkedIconColor;
    }

    /* renamed from: getUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2374getUncheckedThumbColor0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    /* renamed from: getUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2375getUncheckedTrackColor0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2372getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2373getUncheckedIconColor0d7_KjU() {
        return this.uncheckedIconColor;
    }

    /* renamed from: getDisabledCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2366getDisabledCheckedThumbColor0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    /* renamed from: getDisabledCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2367getDisabledCheckedTrackColor0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    /* renamed from: getDisabledCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2364getDisabledCheckedBorderColor0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    /* renamed from: getDisabledCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2365getDisabledCheckedIconColor0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    /* renamed from: getDisabledUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2370getDisabledUncheckedThumbColor0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    /* renamed from: getDisabledUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2371getDisabledUncheckedTrackColor0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2368getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2369getDisabledUncheckedIconColor0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    /* renamed from: copy-Q_H9qLU$default  reason: not valid java name */
    public static /* synthetic */ SwitchColors m2357copyQ_H9qLU$default(SwitchColors switchColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i, Object obj) {
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        SwitchColors switchColors2;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        long j32 = (i & 1) != 0 ? switchColors.checkedThumbColor : j;
        long j33 = (i & 2) != 0 ? switchColors.checkedTrackColor : j2;
        long j34 = (i & 4) != 0 ? switchColors.checkedBorderColor : j3;
        long j35 = (i & 8) != 0 ? switchColors.checkedIconColor : j4;
        long j36 = (i & 16) != 0 ? switchColors.uncheckedThumbColor : j5;
        long j37 = (i & 32) != 0 ? switchColors.uncheckedTrackColor : j6;
        long j38 = (i & 64) != 0 ? switchColors.uncheckedBorderColor : j7;
        long j39 = j32;
        long j40 = (i & 128) != 0 ? switchColors.uncheckedIconColor : j8;
        long j41 = (i & 256) != 0 ? switchColors.disabledCheckedThumbColor : j9;
        long j42 = (i & 512) != 0 ? switchColors.disabledCheckedTrackColor : j10;
        long j43 = (i & 1024) != 0 ? switchColors.disabledCheckedBorderColor : j11;
        long j44 = (i & 2048) != 0 ? switchColors.disabledCheckedIconColor : j12;
        long j45 = (i & 4096) != 0 ? switchColors.disabledUncheckedThumbColor : j13;
        long j46 = (i & 8192) != 0 ? switchColors.disabledUncheckedTrackColor : j14;
        long j47 = (i & 16384) != 0 ? switchColors.disabledUncheckedBorderColor : j15;
        if ((i & 32768) != 0) {
            j18 = j47;
            j17 = switchColors.disabledUncheckedIconColor;
            j20 = j41;
            j21 = j42;
            j22 = j43;
            j23 = j44;
            j24 = j45;
            j25 = j46;
            j26 = j33;
            j27 = j34;
            j28 = j35;
            j29 = j36;
            j30 = j37;
            j31 = j38;
            j19 = j40;
            switchColors2 = switchColors;
        } else {
            j17 = j16;
            j18 = j47;
            j19 = j40;
            j20 = j41;
            j21 = j42;
            j22 = j43;
            j23 = j44;
            j24 = j45;
            j25 = j46;
            switchColors2 = switchColors;
            j26 = j33;
            j27 = j34;
            j28 = j35;
            j29 = j36;
            j30 = j37;
            j31 = j38;
        }
        return switchColors2.m2359copyQ_H9qLU(j39, j26, j27, j28, j29, j30, j31, j19, j20, j21, j22, j23, j24, j25, j18, j17);
    }

    /* renamed from: copy-Q_H9qLU  reason: not valid java name */
    public final SwitchColors m2359copyQ_H9qLU(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        return new SwitchColors(j != 16 ? j : this.checkedThumbColor, j2 != 16 ? j2 : this.checkedTrackColor, j3 != 16 ? j3 : this.checkedBorderColor, j4 != 16 ? j4 : this.checkedIconColor, j5 != 16 ? j5 : this.uncheckedThumbColor, j6 != 16 ? j6 : this.uncheckedTrackColor, j7 != 16 ? j7 : this.uncheckedBorderColor, j8 != 16 ? j8 : this.uncheckedIconColor, j9 != 16 ? j9 : this.disabledCheckedThumbColor, j10 != 16 ? j10 : this.disabledCheckedTrackColor, j11 != 16 ? j11 : this.disabledCheckedBorderColor, j12 != 16 ? j12 : this.disabledCheckedIconColor, j13 != 16 ? j13 : this.disabledUncheckedThumbColor, j14 != 16 ? j14 : this.disabledUncheckedTrackColor, j15 != 16 ? j15 : this.disabledUncheckedBorderColor, j16 != 16 ? j16 : this.disabledUncheckedIconColor, null);
    }

    /* renamed from: thumbColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2377thumbColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedThumbColor : this.uncheckedThumbColor : z2 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    /* renamed from: trackColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2378trackColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedTrackColor : this.uncheckedTrackColor : z2 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }

    /* renamed from: borderColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2358borderColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedBorderColor : this.uncheckedBorderColor : z2 ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    /* renamed from: iconColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2376iconColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedIconColor : this.uncheckedIconColor : z2 ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Color.m4079equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m4079equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m4079equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m4079equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m4079equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m4079equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m4079equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m4079equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m4079equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m4079equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m4079equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m4079equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m4079equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m4079equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m4079equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m4079equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m4085hashCodeimpl(this.checkedThumbColor) * 31) + Color.m4085hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m4085hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m4085hashCodeimpl(this.checkedIconColor)) * 31) + Color.m4085hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m4085hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m4085hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m4085hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m4085hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m4085hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m4085hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m4085hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m4085hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m4085hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m4085hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m4085hashCodeimpl(this.disabledUncheckedIconColor);
    }
}

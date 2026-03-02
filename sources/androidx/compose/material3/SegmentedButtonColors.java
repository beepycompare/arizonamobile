package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SegmentedButton.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0085\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020$H\u0001¢\u0006\u0004\b*\u0010'J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b,\u0010'J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u000200H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Landroidx/compose/material3/SegmentedButtonColors;", "", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveContainerColor-0d7_KjU", "()J", "J", "getActiveContentColor-0d7_KjU", "getActiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "borderColor", "enabled", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "borderColor-WaAFU9c$material3", "(ZZ)J", "contentColor", "checked", "contentColor-WaAFU9c$material3", "containerColor", "containerColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonColors {
    public static final int $stable = 0;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;

    public /* synthetic */ SegmentedButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    private SegmentedButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.activeContainerColor = j;
        this.activeContentColor = j2;
        this.activeBorderColor = j3;
        this.inactiveContainerColor = j4;
        this.inactiveContentColor = j5;
        this.inactiveBorderColor = j6;
        this.disabledActiveContainerColor = j7;
        this.disabledActiveContentColor = j8;
        this.disabledActiveBorderColor = j9;
        this.disabledInactiveContainerColor = j10;
        this.disabledInactiveContentColor = j11;
        this.disabledInactiveBorderColor = j12;
    }

    /* renamed from: getActiveContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2446getActiveContainerColor0d7_KjU() {
        return this.activeContainerColor;
    }

    /* renamed from: getActiveContentColor-0d7_KjU  reason: not valid java name */
    public final long m2447getActiveContentColor0d7_KjU() {
        return this.activeContentColor;
    }

    /* renamed from: getActiveBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2445getActiveBorderColor0d7_KjU() {
        return this.activeBorderColor;
    }

    /* renamed from: getInactiveContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2455getInactiveContainerColor0d7_KjU() {
        return this.inactiveContainerColor;
    }

    /* renamed from: getInactiveContentColor-0d7_KjU  reason: not valid java name */
    public final long m2456getInactiveContentColor0d7_KjU() {
        return this.inactiveContentColor;
    }

    /* renamed from: getInactiveBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2454getInactiveBorderColor0d7_KjU() {
        return this.inactiveBorderColor;
    }

    /* renamed from: getDisabledActiveContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2449getDisabledActiveContainerColor0d7_KjU() {
        return this.disabledActiveContainerColor;
    }

    /* renamed from: getDisabledActiveContentColor-0d7_KjU  reason: not valid java name */
    public final long m2450getDisabledActiveContentColor0d7_KjU() {
        return this.disabledActiveContentColor;
    }

    /* renamed from: getDisabledActiveBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2448getDisabledActiveBorderColor0d7_KjU() {
        return this.disabledActiveBorderColor;
    }

    /* renamed from: getDisabledInactiveContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2452getDisabledInactiveContainerColor0d7_KjU() {
        return this.disabledInactiveContainerColor;
    }

    /* renamed from: getDisabledInactiveContentColor-0d7_KjU  reason: not valid java name */
    public final long m2453getDisabledInactiveContentColor0d7_KjU() {
        return this.disabledInactiveContentColor;
    }

    /* renamed from: getDisabledInactiveBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2451getDisabledInactiveBorderColor0d7_KjU() {
        return this.disabledInactiveBorderColor;
    }

    /* renamed from: copy-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ SegmentedButtonColors m2440copy2qZNXz8$default(SegmentedButtonColors segmentedButtonColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15 = (i & 1) != 0 ? segmentedButtonColors.activeContainerColor : j;
        long j16 = (i & 2) != 0 ? segmentedButtonColors.activeContentColor : j2;
        long j17 = (i & 4) != 0 ? segmentedButtonColors.activeBorderColor : j3;
        long j18 = (i & 8) != 0 ? segmentedButtonColors.inactiveContainerColor : j4;
        long j19 = (i & 16) != 0 ? segmentedButtonColors.inactiveContentColor : j5;
        long j20 = (i & 32) != 0 ? segmentedButtonColors.inactiveBorderColor : j6;
        long j21 = (i & 64) != 0 ? segmentedButtonColors.disabledActiveContainerColor : j7;
        long j22 = j15;
        long j23 = (i & 128) != 0 ? segmentedButtonColors.disabledActiveContentColor : j8;
        long j24 = (i & 256) != 0 ? segmentedButtonColors.disabledActiveBorderColor : j9;
        long j25 = (i & 512) != 0 ? segmentedButtonColors.disabledInactiveContainerColor : j10;
        long j26 = (i & 1024) != 0 ? segmentedButtonColors.disabledInactiveContentColor : j11;
        if ((i & 2048) != 0) {
            j14 = j26;
            j13 = segmentedButtonColors.disabledInactiveBorderColor;
        } else {
            j13 = j12;
            j14 = j26;
        }
        return segmentedButtonColors.m2444copy2qZNXz8(j22, j16, j17, j18, j19, j20, j21, j23, j24, j25, j14, j13);
    }

    /* renamed from: copy-2qZNXz8  reason: not valid java name */
    public final SegmentedButtonColors m2444copy2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new SegmentedButtonColors(j != 16 ? j : this.activeContainerColor, j2 != 16 ? j2 : this.activeContentColor, j3 != 16 ? j3 : this.activeBorderColor, j4 != 16 ? j4 : this.inactiveContainerColor, j5 != 16 ? j5 : this.inactiveContentColor, j6 != 16 ? j6 : this.inactiveBorderColor, j7 != 16 ? j7 : this.disabledActiveContainerColor, j8 != 16 ? j8 : this.disabledActiveContentColor, j9 != 16 ? j9 : this.disabledActiveBorderColor, j10 != 16 ? j10 : this.disabledInactiveContainerColor, j11 != 16 ? j11 : this.disabledInactiveContentColor, j12 != 16 ? j12 : this.disabledInactiveBorderColor, null);
    }

    /* renamed from: borderColor-WaAFU9c$material3  reason: not valid java name */
    public final long m2441borderColorWaAFU9c$material3(boolean z, boolean z2) {
        if (z && z2) {
            return this.activeBorderColor;
        }
        if (!z || z2) {
            if (!z && z2) {
                return this.disabledActiveBorderColor;
            }
            return this.disabledInactiveBorderColor;
        }
        return this.inactiveBorderColor;
    }

    /* renamed from: contentColor-WaAFU9c$material3  reason: not valid java name */
    public final long m2443contentColorWaAFU9c$material3(boolean z, boolean z2) {
        if (z && z2) {
            return this.activeContentColor;
        }
        if (!z || z2) {
            if (!z && z2) {
                return this.disabledActiveContentColor;
            }
            return this.disabledInactiveContentColor;
        }
        return this.inactiveContentColor;
    }

    /* renamed from: containerColor-WaAFU9c$material3  reason: not valid java name */
    public final long m2442containerColorWaAFU9c$material3(boolean z, boolean z2) {
        if (z && z2) {
            return this.activeContainerColor;
        }
        if (!z || z2) {
            if (!z && z2) {
                return this.disabledActiveContainerColor;
            }
            return this.disabledInactiveContainerColor;
        }
        return this.inactiveContainerColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SegmentedButtonColors segmentedButtonColors = (SegmentedButtonColors) obj;
            return Color.m4773equalsimpl0(this.activeBorderColor, segmentedButtonColors.activeBorderColor) && Color.m4773equalsimpl0(this.activeContentColor, segmentedButtonColors.activeContentColor) && Color.m4773equalsimpl0(this.activeContainerColor, segmentedButtonColors.activeContainerColor) && Color.m4773equalsimpl0(this.inactiveBorderColor, segmentedButtonColors.inactiveBorderColor) && Color.m4773equalsimpl0(this.inactiveContentColor, segmentedButtonColors.inactiveContentColor) && Color.m4773equalsimpl0(this.inactiveContainerColor, segmentedButtonColors.inactiveContainerColor) && Color.m4773equalsimpl0(this.disabledActiveBorderColor, segmentedButtonColors.disabledActiveBorderColor) && Color.m4773equalsimpl0(this.disabledActiveContentColor, segmentedButtonColors.disabledActiveContentColor) && Color.m4773equalsimpl0(this.disabledActiveContainerColor, segmentedButtonColors.disabledActiveContainerColor) && Color.m4773equalsimpl0(this.disabledInactiveBorderColor, segmentedButtonColors.disabledInactiveBorderColor) && Color.m4773equalsimpl0(this.disabledInactiveContentColor, segmentedButtonColors.disabledInactiveContentColor) && Color.m4773equalsimpl0(this.disabledInactiveContainerColor, segmentedButtonColors.disabledInactiveContainerColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4779hashCodeimpl(this.activeBorderColor) * 31) + Color.m4779hashCodeimpl(this.activeContentColor)) * 31) + Color.m4779hashCodeimpl(this.activeContainerColor)) * 31) + Color.m4779hashCodeimpl(this.inactiveBorderColor)) * 31) + Color.m4779hashCodeimpl(this.inactiveContentColor)) * 31) + Color.m4779hashCodeimpl(this.inactiveContainerColor)) * 31) + Color.m4779hashCodeimpl(this.disabledActiveBorderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledActiveContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledActiveContainerColor)) * 31) + Color.m4779hashCodeimpl(this.disabledInactiveBorderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledInactiveContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledInactiveContainerColor);
    }
}

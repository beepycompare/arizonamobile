package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJt\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010(R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveTickColor-0d7_KjU", "()J", "J", "getActiveTrackColor-0d7_KjU", "getDisabledActiveTickColor-0d7_KjU", "getDisabledActiveTrackColor-0d7_KjU", "getDisabledInactiveTickColor-0d7_KjU", "getDisabledInactiveTrackColor-0d7_KjU", "getDisabledThumbColor-0d7_KjU", "getInactiveTickColor-0d7_KjU", "getInactiveTrackColor-0d7_KjU", "getThumbColor-0d7_KjU", "copy", "copy--K518z4", "(JJJJJJJJJJ)Landroidx/compose/material3/SliderColors;", "equals", "", "other", "hashCode", "", "enabled", "thumbColor-vNxB06k$material3_release", "(Z)J", "tickColor", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "tickColor-WaAFU9c$material3_release", "(ZZ)J", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderColors {
    public static final int $stable = 0;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    private SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.thumbColor = j;
        this.activeTrackColor = j2;
        this.activeTickColor = j3;
        this.inactiveTrackColor = j4;
        this.inactiveTickColor = j5;
        this.disabledThumbColor = j6;
        this.disabledActiveTrackColor = j7;
        this.disabledActiveTickColor = j8;
        this.disabledInactiveTrackColor = j9;
        this.disabledInactiveTickColor = j10;
    }

    /* renamed from: getThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2287getThumbColor0d7_KjU() {
        return this.thumbColor;
    }

    /* renamed from: getActiveTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2279getActiveTrackColor0d7_KjU() {
        return this.activeTrackColor;
    }

    /* renamed from: getActiveTickColor-0d7_KjU  reason: not valid java name */
    public final long m2278getActiveTickColor0d7_KjU() {
        return this.activeTickColor;
    }

    /* renamed from: getInactiveTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2286getInactiveTrackColor0d7_KjU() {
        return this.inactiveTrackColor;
    }

    /* renamed from: getInactiveTickColor-0d7_KjU  reason: not valid java name */
    public final long m2285getInactiveTickColor0d7_KjU() {
        return this.inactiveTickColor;
    }

    /* renamed from: getDisabledThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2284getDisabledThumbColor0d7_KjU() {
        return this.disabledThumbColor;
    }

    /* renamed from: getDisabledActiveTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2281getDisabledActiveTrackColor0d7_KjU() {
        return this.disabledActiveTrackColor;
    }

    /* renamed from: getDisabledActiveTickColor-0d7_KjU  reason: not valid java name */
    public final long m2280getDisabledActiveTickColor0d7_KjU() {
        return this.disabledActiveTickColor;
    }

    /* renamed from: getDisabledInactiveTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2283getDisabledInactiveTrackColor0d7_KjU() {
        return this.disabledInactiveTrackColor;
    }

    /* renamed from: getDisabledInactiveTickColor-0d7_KjU  reason: not valid java name */
    public final long m2282getDisabledInactiveTickColor0d7_KjU() {
        return this.disabledInactiveTickColor;
    }

    /* renamed from: copy--K518z4$default  reason: not valid java name */
    public static /* synthetic */ SliderColors m2276copyK518z4$default(SliderColors sliderColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, Object obj) {
        long j11;
        long j12;
        long j13 = (i & 1) != 0 ? sliderColors.thumbColor : j;
        long j14 = (i & 2) != 0 ? sliderColors.activeTrackColor : j2;
        long j15 = (i & 4) != 0 ? sliderColors.activeTickColor : j3;
        long j16 = (i & 8) != 0 ? sliderColors.inactiveTrackColor : j4;
        long j17 = (i & 16) != 0 ? sliderColors.inactiveTickColor : j5;
        long j18 = (i & 32) != 0 ? sliderColors.disabledThumbColor : j6;
        long j19 = (i & 64) != 0 ? sliderColors.disabledActiveTrackColor : j7;
        long j20 = j13;
        long j21 = (i & 128) != 0 ? sliderColors.disabledActiveTickColor : j8;
        long j22 = (i & 256) != 0 ? sliderColors.disabledInactiveTrackColor : j9;
        if ((i & 512) != 0) {
            j12 = j22;
            j11 = sliderColors.disabledInactiveTickColor;
        } else {
            j11 = j10;
            j12 = j22;
        }
        return sliderColors.m2277copyK518z4(j20, j14, j15, j16, j17, j18, j19, j21, j12, j11);
    }

    /* renamed from: copy--K518z4  reason: not valid java name */
    public final SliderColors m2277copyK518z4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        return new SliderColors(j != 16 ? j : this.thumbColor, j2 != 16 ? j2 : this.activeTrackColor, j3 != 16 ? j3 : this.activeTickColor, j4 != 16 ? j4 : this.inactiveTrackColor, j5 != 16 ? j5 : this.inactiveTickColor, j6 != 16 ? j6 : this.disabledThumbColor, j7 != 16 ? j7 : this.disabledActiveTrackColor, j8 != 16 ? j8 : this.disabledActiveTickColor, j9 != 16 ? j9 : this.disabledInactiveTrackColor, j10 != 16 ? j10 : this.disabledInactiveTickColor, null);
    }

    /* renamed from: thumbColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2288thumbColorvNxB06k$material3_release(boolean z) {
        return z ? this.thumbColor : this.disabledThumbColor;
    }

    /* renamed from: trackColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2290trackColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.activeTrackColor : this.inactiveTrackColor : z2 ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
    }

    /* renamed from: tickColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2289tickColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.activeTickColor : this.inactiveTickColor : z2 ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SliderColors)) {
            return false;
        }
        SliderColors sliderColors = (SliderColors) obj;
        return Color.m4079equalsimpl0(this.thumbColor, sliderColors.thumbColor) && Color.m4079equalsimpl0(this.activeTrackColor, sliderColors.activeTrackColor) && Color.m4079equalsimpl0(this.activeTickColor, sliderColors.activeTickColor) && Color.m4079equalsimpl0(this.inactiveTrackColor, sliderColors.inactiveTrackColor) && Color.m4079equalsimpl0(this.inactiveTickColor, sliderColors.inactiveTickColor) && Color.m4079equalsimpl0(this.disabledThumbColor, sliderColors.disabledThumbColor) && Color.m4079equalsimpl0(this.disabledActiveTrackColor, sliderColors.disabledActiveTrackColor) && Color.m4079equalsimpl0(this.disabledActiveTickColor, sliderColors.disabledActiveTickColor) && Color.m4079equalsimpl0(this.disabledInactiveTrackColor, sliderColors.disabledInactiveTrackColor) && Color.m4079equalsimpl0(this.disabledInactiveTickColor, sliderColors.disabledInactiveTickColor);
    }

    public int hashCode() {
        return (((((((((((((((((Color.m4085hashCodeimpl(this.thumbColor) * 31) + Color.m4085hashCodeimpl(this.activeTrackColor)) * 31) + Color.m4085hashCodeimpl(this.activeTickColor)) * 31) + Color.m4085hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m4085hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m4085hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m4085hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m4085hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m4085hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m4085hashCodeimpl(this.disabledInactiveTickColor);
    }
}

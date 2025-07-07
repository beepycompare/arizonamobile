package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J%\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J%\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\"R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00038@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledIconColor-0d7_KjU", "()J", "J", "getDisabledTextColor-0d7_KjU", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "getSelectedIconColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationBarItemColors;", "equals", "", "other", "hashCode", "", "iconColor", "selected", "enabled", "iconColor-WaAFU9c$material3_release", "(ZZ)J", "textColor", "textColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    private NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2068getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2070getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* renamed from: getSelectedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2069getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2071getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2072getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    /* renamed from: getDisabledIconColor-0d7_KjU  reason: not valid java name */
    public final long m2065getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m2066getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: copy-4JmcsL4  reason: not valid java name */
    public final NavigationBarItemColors m2064copy4JmcsL4(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return new NavigationBarItemColors(j != 16 ? j : this.selectedIconColor, j2 != 16 ? j2 : this.selectedTextColor, j3 != 16 ? j3 : this.selectedIndicatorColor, j4 != 16 ? j4 : this.unselectedIconColor, j5 != 16 ? j5 : this.unselectedTextColor, j6 != 16 ? j6 : this.disabledIconColor, j7 != 16 ? j7 : this.disabledTextColor, null);
    }

    /* renamed from: iconColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2073iconColorWaAFU9c$material3_release(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                return this.selectedIconColor;
            }
            return this.unselectedIconColor;
        }
        return this.disabledIconColor;
    }

    /* renamed from: textColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2074textColorWaAFU9c$material3_release(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                return this.selectedTextColor;
            }
            return this.unselectedTextColor;
        }
        return this.disabledTextColor;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2067getIndicatorColor0d7_KjU$material3_release() {
        return this.selectedIndicatorColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) obj;
        return Color.m4079equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m4079equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m4079equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m4079equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m4079equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor) && Color.m4079equalsimpl0(this.disabledIconColor, navigationBarItemColors.disabledIconColor) && Color.m4079equalsimpl0(this.disabledTextColor, navigationBarItemColors.disabledTextColor);
    }

    public int hashCode() {
        return (((((((((((Color.m4085hashCodeimpl(this.selectedIconColor) * 31) + Color.m4085hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m4085hashCodeimpl(this.selectedTextColor)) * 31) + Color.m4085hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m4085hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m4085hashCodeimpl(this.disabledIconColor)) * 31) + Color.m4085hashCodeimpl(this.disabledTextColor);
    }
}

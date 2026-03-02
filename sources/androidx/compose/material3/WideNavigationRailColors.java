package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: WideNavigationRail.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/WideNavigationRailColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getModalContainerColor-0d7_KjU", "getModalScrimColor-0d7_KjU", "getModalContentColor-0d7_KjU", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WideNavigationRailColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long modalContainerColor;
    private final long modalContentColor;
    private final long modalScrimColor;

    public /* synthetic */ WideNavigationRailColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private WideNavigationRailColors(long j, long j2, long j3, long j4, long j5) {
        this.containerColor = j;
        this.contentColor = j2;
        this.modalContainerColor = j3;
        this.modalScrimColor = j4;
        this.modalContentColor = j5;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2943getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m2944getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: getModalContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2945getModalContainerColor0d7_KjU() {
        return this.modalContainerColor;
    }

    /* renamed from: getModalScrimColor-0d7_KjU  reason: not valid java name */
    public final long m2947getModalScrimColor0d7_KjU() {
        return this.modalScrimColor;
    }

    /* renamed from: getModalContentColor-0d7_KjU  reason: not valid java name */
    public final long m2946getModalContentColor0d7_KjU() {
        return this.modalContentColor;
    }

    /* renamed from: copy-t635Npw$default  reason: not valid java name */
    public static /* synthetic */ WideNavigationRailColors m2941copyt635Npw$default(WideNavigationRailColors wideNavigationRailColors, long j, long j2, long j3, long j4, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = wideNavigationRailColors.containerColor;
        }
        long j6 = j;
        if ((i & 2) != 0) {
            j2 = wideNavigationRailColors.contentColor;
        }
        return wideNavigationRailColors.m2942copyt635Npw(j6, j2, (i & 4) != 0 ? wideNavigationRailColors.modalContainerColor : j3, (i & 8) != 0 ? wideNavigationRailColors.modalScrimColor : j4, (i & 16) != 0 ? wideNavigationRailColors.modalContentColor : j5);
    }

    /* renamed from: copy-t635Npw  reason: not valid java name */
    public final WideNavigationRailColors m2942copyt635Npw(long j, long j2, long j3, long j4, long j5) {
        return new WideNavigationRailColors(j != 16 ? j : this.containerColor, j2 != 16 ? j2 : this.contentColor, j3 != 16 ? j3 : this.modalContainerColor, j4 != 16 ? j4 : this.modalScrimColor, j5 != 16 ? j5 : this.modalContentColor, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WideNavigationRailColors)) {
            return false;
        }
        WideNavigationRailColors wideNavigationRailColors = (WideNavigationRailColors) obj;
        return Color.m4773equalsimpl0(this.containerColor, wideNavigationRailColors.containerColor) && Color.m4773equalsimpl0(this.contentColor, wideNavigationRailColors.contentColor) && Color.m4773equalsimpl0(this.modalContainerColor, wideNavigationRailColors.modalContainerColor) && Color.m4773equalsimpl0(this.modalScrimColor, wideNavigationRailColors.modalScrimColor);
    }

    public int hashCode() {
        return (((((((Color.m4779hashCodeimpl(this.containerColor) * 31) + Color.m4779hashCodeimpl(this.contentColor)) * 31) + Color.m4779hashCodeimpl(this.modalContainerColor)) * 31) + Color.m4779hashCodeimpl(this.modalScrimColor)) * 31) + Color.m4779hashCodeimpl(this.modalContentColor);
    }
}

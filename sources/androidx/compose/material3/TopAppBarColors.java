package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bJI\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getScrolledContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionIconContentColor-0d7_KjU", "getSubtitleContentColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/TopAppBarColors;", "colorTransitionFraction", "", "containerColor-vNxB06k$material3", "(F)J", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TopAppBarColors {
    public static final int $stable = 0;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long subtitleContentColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the TopAppBarColors constructor with subtitleContentColor", replaceWith = @ReplaceWith(expression = "TopAppBarColors(containerColor, scrolledContainerColor,navigationIconContentColor, titleContentColor, actionIconContentColor, subtitleContentColor)", imports = {}))
    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private TopAppBarColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
        this.subtitleContentColor = j6;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2910getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getScrolledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2912getScrolledContainerColor0d7_KjU() {
        return this.scrolledContainerColor;
    }

    /* renamed from: getNavigationIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m2911getNavigationIconContentColor0d7_KjU() {
        return this.navigationIconContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m2914getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getActionIconContentColor-0d7_KjU  reason: not valid java name */
    public final long m2909getActionIconContentColor0d7_KjU() {
        return this.actionIconContentColor;
    }

    /* renamed from: getSubtitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m2913getSubtitleContentColor0d7_KjU() {
        return this.subtitleContentColor;
    }

    private TopAppBarColors(long j, long j2, long j3, long j4, long j5) {
        this(j, j2, j3, j4, j5, j4, null);
    }

    /* renamed from: copy-tNS2XkQ$default  reason: not valid java name */
    public static /* synthetic */ TopAppBarColors m2906copytNS2XkQ$default(TopAppBarColors topAppBarColors, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = topAppBarColors.containerColor;
        }
        return topAppBarColors.m2908copytNS2XkQ(j, (i & 2) != 0 ? topAppBarColors.scrolledContainerColor : j2, (i & 4) != 0 ? topAppBarColors.navigationIconContentColor : j3, (i & 8) != 0 ? topAppBarColors.titleContentColor : j4, (i & 16) != 0 ? topAppBarColors.actionIconContentColor : j5, (i & 32) != 0 ? topAppBarColors.subtitleContentColor : j6);
    }

    /* renamed from: copy-tNS2XkQ  reason: not valid java name */
    public final TopAppBarColors m2908copytNS2XkQ(long j, long j2, long j3, long j4, long j5, long j6) {
        return new TopAppBarColors(j != 16 ? j : this.containerColor, j2 != 16 ? j2 : this.scrolledContainerColor, j3 != 16 ? j3 : this.navigationIconContentColor, j4 != 16 ? j4 : this.titleContentColor, j5 != 16 ? j5 : this.actionIconContentColor, j6 != 16 ? j6 : this.subtitleContentColor, null);
    }

    /* renamed from: containerColor-vNxB06k$material3  reason: not valid java name */
    public final long m2907containerColorvNxB06k$material3(float f) {
        return ColorKt.m4823lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.m4773equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m4773equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m4773equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m4773equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m4773equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor) && Color.m4773equalsimpl0(this.subtitleContentColor, topAppBarColors.subtitleContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m4779hashCodeimpl(this.containerColor) * 31) + Color.m4779hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m4779hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m4779hashCodeimpl(this.titleContentColor)) * 31) + Color.m4779hashCodeimpl(this.actionIconContentColor)) * 31) + Color.m4779hashCodeimpl(this.subtitleContentColor);
    }
}

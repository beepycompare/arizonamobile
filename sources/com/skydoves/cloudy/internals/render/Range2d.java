package com.skydoves.cloudy.internals.render;

import kotlin.Metadata;
/* compiled from: RenderScriptToolkit.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0007\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/skydoves/cloudy/internals/render/Range2d;", "", "startX", "", "endX", "startY", "endY", "<init>", "(IIII)V", "()V", "getStartX", "()I", "getEndX", "getStartY", "getEndY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "cloudy_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Range2d {
    public static final int $stable = 0;
    private final int endX;
    private final int endY;
    private final int startX;
    private final int startY;

    public static /* synthetic */ Range2d copy$default(Range2d range2d, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = range2d.startX;
        }
        if ((i5 & 2) != 0) {
            i2 = range2d.endX;
        }
        if ((i5 & 4) != 0) {
            i3 = range2d.startY;
        }
        if ((i5 & 8) != 0) {
            i4 = range2d.endY;
        }
        return range2d.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.startX;
    }

    public final int component2() {
        return this.endX;
    }

    public final int component3() {
        return this.startY;
    }

    public final int component4() {
        return this.endY;
    }

    public final Range2d copy(int i, int i2, int i3, int i4) {
        return new Range2d(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Range2d) {
            Range2d range2d = (Range2d) obj;
            return this.startX == range2d.startX && this.endX == range2d.endX && this.startY == range2d.startY && this.endY == range2d.endY;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.startX) * 31) + Integer.hashCode(this.endX)) * 31) + Integer.hashCode(this.startY)) * 31) + Integer.hashCode(this.endY);
    }

    public String toString() {
        return "Range2d(startX=" + this.startX + ", endX=" + this.endX + ", startY=" + this.startY + ", endY=" + this.endY + ')';
    }

    public Range2d(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.endX = i2;
        this.startY = i3;
        this.endY = i4;
    }

    public final int getStartX() {
        return this.startX;
    }

    public final int getEndX() {
        return this.endX;
    }

    public final int getStartY() {
        return this.startY;
    }

    public final int getEndY() {
        return this.endY;
    }

    public Range2d() {
        this(0, 0, 0, 0);
    }
}

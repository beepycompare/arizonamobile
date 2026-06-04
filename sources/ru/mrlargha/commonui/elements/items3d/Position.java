package ru.mrlargha.commonui.elements.items3d;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
/* compiled from: listener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/Position;", "", CmcdData.STREAMING_FORMAT_HLS, "", "w", "x", "y", "<init>", "(IIII)V", "getH", "()I", "getW", "getX", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Position {
    private final int h;
    private final int w;
    private final int x;
    private final int y;

    public static /* synthetic */ Position copy$default(Position position, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = position.h;
        }
        if ((i5 & 2) != 0) {
            i2 = position.w;
        }
        if ((i5 & 4) != 0) {
            i3 = position.x;
        }
        if ((i5 & 8) != 0) {
            i4 = position.y;
        }
        return position.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.h;
    }

    public final int component2() {
        return this.w;
    }

    public final int component3() {
        return this.x;
    }

    public final int component4() {
        return this.y;
    }

    public final Position copy(int i, int i2, int i3, int i4) {
        return new Position(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return this.h == position.h && this.w == position.w && this.x == position.x && this.y == position.y;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.h) * 31) + Integer.hashCode(this.w)) * 31) + Integer.hashCode(this.x)) * 31) + Integer.hashCode(this.y);
    }

    public String toString() {
        int i = this.h;
        int i2 = this.w;
        int i3 = this.x;
        return "Position(h=" + i + ", w=" + i2 + ", x=" + i3 + ", y=" + this.y + ")";
    }

    public Position(int i, int i2, int i3, int i4) {
        this.h = i;
        this.w = i2;
        this.x = i3;
        this.y = i4;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}

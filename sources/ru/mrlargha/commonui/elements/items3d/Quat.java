package ru.mrlargha.commonui.elements.items3d;

import kotlin.Metadata;
/* compiled from: listener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/Quat;", "", "w", "", "x", "y", "z", "<init>", "(FFFF)V", "getW", "()F", "setW", "(F)V", "getX", "setX", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Quat {
    private float w;
    private float x;
    private float y;
    private float z;

    public static /* synthetic */ Quat copy$default(Quat quat, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = quat.w;
        }
        if ((i & 2) != 0) {
            f2 = quat.x;
        }
        if ((i & 4) != 0) {
            f3 = quat.y;
        }
        if ((i & 8) != 0) {
            f4 = quat.z;
        }
        return quat.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.w;
    }

    public final float component2() {
        return this.x;
    }

    public final float component3() {
        return this.y;
    }

    public final float component4() {
        return this.z;
    }

    public final Quat copy(float f, float f2, float f3, float f4) {
        return new Quat(f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Quat) {
            Quat quat = (Quat) obj;
            return Float.compare(this.w, quat.w) == 0 && Float.compare(this.x, quat.x) == 0 && Float.compare(this.y, quat.y) == 0 && Float.compare(this.z, quat.z) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.w) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.z);
    }

    public String toString() {
        float f = this.w;
        float f2 = this.x;
        float f3 = this.y;
        return "Quat(w=" + f + ", x=" + f2 + ", y=" + f3 + ", z=" + this.z + ")";
    }

    public Quat(float f, float f2, float f3, float f4) {
        this.w = f;
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    public final float getW() {
        return this.w;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public final void setW(float f) {
        this.w = f;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public final void setZ(float f) {
        this.z = f;
    }
}

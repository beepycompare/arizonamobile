package com.arizonagames.feature.minigames.blueprint;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Halloweeen.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/minigames/blueprint/HalloweenObject;", "", "id", "", "notPressedImg", "pressedImg", "isPressed", "", "<init>", "(IIIZ)V", "getId", "()I", "getNotPressedImg", "getPressedImg", "()Z", "setPressed", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "blueprint_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HalloweenObject {
    private final int id;
    private boolean isPressed;
    private final int notPressedImg;
    private final int pressedImg;

    public static /* synthetic */ HalloweenObject copy$default(HalloweenObject halloweenObject, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = halloweenObject.id;
        }
        if ((i4 & 2) != 0) {
            i2 = halloweenObject.notPressedImg;
        }
        if ((i4 & 4) != 0) {
            i3 = halloweenObject.pressedImg;
        }
        if ((i4 & 8) != 0) {
            z = halloweenObject.isPressed;
        }
        return halloweenObject.copy(i, i2, i3, z);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.notPressedImg;
    }

    public final int component3() {
        return this.pressedImg;
    }

    public final boolean component4() {
        return this.isPressed;
    }

    public final HalloweenObject copy(int i, int i2, int i3, boolean z) {
        return new HalloweenObject(i, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HalloweenObject) {
            HalloweenObject halloweenObject = (HalloweenObject) obj;
            return this.id == halloweenObject.id && this.notPressedImg == halloweenObject.notPressedImg && this.pressedImg == halloweenObject.pressedImg && this.isPressed == halloweenObject.isPressed;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.notPressedImg)) * 31) + Integer.hashCode(this.pressedImg)) * 31) + Boolean.hashCode(this.isPressed);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.notPressedImg;
        int i3 = this.pressedImg;
        return "HalloweenObject(id=" + i + ", notPressedImg=" + i2 + ", pressedImg=" + i3 + ", isPressed=" + this.isPressed + ")";
    }

    public HalloweenObject(int i, int i2, int i3, boolean z) {
        this.id = i;
        this.notPressedImg = i2;
        this.pressedImg = i3;
        this.isPressed = z;
    }

    public /* synthetic */ HalloweenObject(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final int getNotPressedImg() {
        return this.notPressedImg;
    }

    public final int getPressedImg() {
        return this.pressedImg;
    }

    public final boolean isPressed() {
        return this.isPressed;
    }

    public final void setPressed(boolean z) {
        this.isPressed = z;
    }
}

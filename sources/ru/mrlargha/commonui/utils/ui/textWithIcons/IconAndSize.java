package ru.mrlargha.commonui.utils.ui.textWithIcons;

import kotlin.Metadata;
/* compiled from: textWithIcons.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\b\u0001\u0010\u0002\u001a\u00020\u0003:\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\f\b\u0003\u0010\u0002\u001a\u00020\u0003:\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/utils/ui/textWithIcons/IconAndSize;", "", "icon", "", "Landroidx/annotation/DrawableRes;", "widthSdpRes", "heightSpdRes", "<init>", "(III)V", "getIcon", "()I", "getWidthSdpRes", "getHeightSpdRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IconAndSize {
    private final int heightSpdRes;
    private final int icon;
    private final int widthSdpRes;

    public static /* synthetic */ IconAndSize copy$default(IconAndSize iconAndSize, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = iconAndSize.icon;
        }
        if ((i4 & 2) != 0) {
            i2 = iconAndSize.widthSdpRes;
        }
        if ((i4 & 4) != 0) {
            i3 = iconAndSize.heightSpdRes;
        }
        return iconAndSize.copy(i, i2, i3);
    }

    public final int component1() {
        return this.icon;
    }

    public final int component2() {
        return this.widthSdpRes;
    }

    public final int component3() {
        return this.heightSpdRes;
    }

    public final IconAndSize copy(int i, int i2, int i3) {
        return new IconAndSize(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IconAndSize) {
            IconAndSize iconAndSize = (IconAndSize) obj;
            return this.icon == iconAndSize.icon && this.widthSdpRes == iconAndSize.widthSdpRes && this.heightSpdRes == iconAndSize.heightSpdRes;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.icon) * 31) + Integer.hashCode(this.widthSdpRes)) * 31) + Integer.hashCode(this.heightSpdRes);
    }

    public String toString() {
        int i = this.icon;
        int i2 = this.widthSdpRes;
        return "IconAndSize(icon=" + i + ", widthSdpRes=" + i2 + ", heightSpdRes=" + this.heightSpdRes + ")";
    }

    public IconAndSize(int i, int i2, int i3) {
        this.icon = i;
        this.widthSdpRes = i2;
        this.heightSpdRes = i3;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getWidthSdpRes() {
        return this.widthSdpRes;
    }

    public final int getHeightSpdRes() {
        return this.heightSpdRes;
    }
}

package ru.mrlargha.commonui.elements.craft.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/ItemColor;", "", "color", "", "name", "", "isLocked", "", "<init>", "(ILjava/lang/String;Z)V", "getColor", "()I", "getName", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemColor {
    private final int color;
    private final boolean isLocked;
    private final String name;

    public static /* synthetic */ ItemColor copy$default(ItemColor itemColor, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = itemColor.color;
        }
        if ((i2 & 2) != 0) {
            str = itemColor.name;
        }
        if ((i2 & 4) != 0) {
            z = itemColor.isLocked;
        }
        return itemColor.copy(i, str, z);
    }

    public final int component1() {
        return this.color;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isLocked;
    }

    public final ItemColor copy(int i, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ItemColor(i, name, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemColor) {
            ItemColor itemColor = (ItemColor) obj;
            return this.color == itemColor.color && Intrinsics.areEqual(this.name, itemColor.name) && this.isLocked == itemColor.isLocked;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.color) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isLocked);
    }

    public String toString() {
        int i = this.color;
        String str = this.name;
        return "ItemColor(color=" + i + ", name=" + str + ", isLocked=" + this.isLocked + ")";
    }

    public ItemColor(int i, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.color = i;
        this.name = name;
        this.isLocked = z;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }
}

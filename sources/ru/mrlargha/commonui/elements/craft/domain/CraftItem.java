package ru.mrlargha.commonui.elements.craft.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftItem;", "", "item", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getItem", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftItem {
    private final int item;
    private final String name;

    public static /* synthetic */ CraftItem copy$default(CraftItem craftItem, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = craftItem.item;
        }
        if ((i2 & 2) != 0) {
            str = craftItem.name;
        }
        return craftItem.copy(i, str);
    }

    public final int component1() {
        return this.item;
    }

    public final String component2() {
        return this.name;
    }

    public final CraftItem copy(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CraftItem(i, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CraftItem) {
            CraftItem craftItem = (CraftItem) obj;
            return this.item == craftItem.item && Intrinsics.areEqual(this.name, craftItem.name);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.item) * 31) + this.name.hashCode();
    }

    public String toString() {
        int i = this.item;
        return "CraftItem(item=" + i + ", name=" + this.name + ")";
    }

    public CraftItem(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.item = i;
        this.name = name;
    }

    public final int getItem() {
        return this.item;
    }

    public final String getName() {
        return this.name;
    }
}

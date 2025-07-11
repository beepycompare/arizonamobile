package ru.mrlargha.commonui.elements.easter.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EventData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/EasterItem;", "", "itemid", "", "name", "", "value", "color", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getItemid", "()I", "getName", "()Ljava/lang/String;", "getValue", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterItem {
    private final String color;
    private final int itemid;
    private final String name;
    private final int value;

    public static /* synthetic */ EasterItem copy$default(EasterItem easterItem, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = easterItem.itemid;
        }
        if ((i3 & 2) != 0) {
            str = easterItem.name;
        }
        if ((i3 & 4) != 0) {
            i2 = easterItem.value;
        }
        if ((i3 & 8) != 0) {
            str2 = easterItem.color;
        }
        return easterItem.copy(i, str, i2, str2);
    }

    public final int component1() {
        return this.itemid;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.value;
    }

    public final String component4() {
        return this.color;
    }

    public final EasterItem copy(int i, String name, int i2, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(color, "color");
        return new EasterItem(i, name, i2, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EasterItem) {
            EasterItem easterItem = (EasterItem) obj;
            return this.itemid == easterItem.itemid && Intrinsics.areEqual(this.name, easterItem.name) && this.value == easterItem.value && Intrinsics.areEqual(this.color, easterItem.color);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.itemid) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.value)) * 31) + this.color.hashCode();
    }

    public String toString() {
        int i = this.itemid;
        String str = this.name;
        int i2 = this.value;
        return "EasterItem(itemid=" + i + ", name=" + str + ", value=" + i2 + ", color=" + this.color + ")";
    }

    public EasterItem(int i, String name, int i2, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(color, "color");
        this.itemid = i;
        this.name = name;
        this.value = i2;
        this.color = color;
    }

    public final int getItemid() {
        return this.itemid;
    }

    public final String getName() {
        return this.name;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getColor() {
        return this.color;
    }
}

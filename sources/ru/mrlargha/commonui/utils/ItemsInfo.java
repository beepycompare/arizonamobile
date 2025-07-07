package ru.mrlargha.commonui.utils;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/utils/ItemsInfo;", "", "id", "", "name", "", "icon", "type", "acs_slot", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "<init>", "(ILjava/lang/String;Ljava/lang/String;III)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getIcon", "getType", "getAcs_slot", "getActive", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemsInfo {
    private final int acs_slot;
    private final int active;
    private final String icon;
    private final int id;
    private final String name;
    private final int type;

    public static /* synthetic */ ItemsInfo copy$default(ItemsInfo itemsInfo, int i, String str, String str2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = itemsInfo.id;
        }
        if ((i5 & 2) != 0) {
            str = itemsInfo.name;
        }
        if ((i5 & 4) != 0) {
            str2 = itemsInfo.icon;
        }
        if ((i5 & 8) != 0) {
            i2 = itemsInfo.type;
        }
        if ((i5 & 16) != 0) {
            i3 = itemsInfo.acs_slot;
        }
        if ((i5 & 32) != 0) {
            i4 = itemsInfo.active;
        }
        int i6 = i3;
        int i7 = i4;
        return itemsInfo.copy(i, str, str2, i2, i6, i7);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.type;
    }

    public final int component5() {
        return this.acs_slot;
    }

    public final int component6() {
        return this.active;
    }

    public final ItemsInfo copy(int i, String name, String icon, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ItemsInfo(i, name, icon, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemsInfo) {
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            return this.id == itemsInfo.id && Intrinsics.areEqual(this.name, itemsInfo.name) && Intrinsics.areEqual(this.icon, itemsInfo.icon) && this.type == itemsInfo.type && this.acs_slot == itemsInfo.acs_slot && this.active == itemsInfo.active;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.acs_slot)) * 31) + Integer.hashCode(this.active);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        String str2 = this.icon;
        int i2 = this.type;
        int i3 = this.acs_slot;
        return "ItemsInfo(id=" + i + ", name=" + str + ", icon=" + str2 + ", type=" + i2 + ", acs_slot=" + i3 + ", active=" + this.active + ")";
    }

    public ItemsInfo(int i, String name, String icon, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = i;
        this.name = name;
        this.icon = icon;
        this.type = i2;
        this.acs_slot = i3;
        this.active = i4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }

    public final int getAcs_slot() {
        return this.acs_slot;
    }

    public final int getActive() {
        return this.active;
    }
}

package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserInventoryBars.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/Skin;", "", "skin", "Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "warehouseType", "", "vehicle", "name", "", "buttons", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;IILjava/lang/String;I)V", "getSkin", "()Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "getWarehouseType", "()I", "getVehicle", "getName", "()Ljava/lang/String;", "getButtons", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Skin {
    private final int buttons;
    private final String name;
    private final SkinItem skin;
    private final int vehicle;
    @SerializedName("warehouse_type")
    private final int warehouseType;

    public static /* synthetic */ Skin copy$default(Skin skin, SkinItem skinItem, int i, int i2, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            skinItem = skin.skin;
        }
        if ((i4 & 2) != 0) {
            i = skin.warehouseType;
        }
        if ((i4 & 4) != 0) {
            i2 = skin.vehicle;
        }
        if ((i4 & 8) != 0) {
            str = skin.name;
        }
        if ((i4 & 16) != 0) {
            i3 = skin.buttons;
        }
        int i5 = i3;
        int i6 = i2;
        return skin.copy(skinItem, i, i6, str, i5);
    }

    public final SkinItem component1() {
        return this.skin;
    }

    public final int component2() {
        return this.warehouseType;
    }

    public final int component3() {
        return this.vehicle;
    }

    public final String component4() {
        return this.name;
    }

    public final int component5() {
        return this.buttons;
    }

    public final Skin copy(SkinItem skin, int i, int i2, String str, int i3) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        return new Skin(skin, i, i2, str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Skin) {
            Skin skin = (Skin) obj;
            return Intrinsics.areEqual(this.skin, skin.skin) && this.warehouseType == skin.warehouseType && this.vehicle == skin.vehicle && Intrinsics.areEqual(this.name, skin.name) && this.buttons == skin.buttons;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.skin.hashCode() * 31) + Integer.hashCode(this.warehouseType)) * 31) + Integer.hashCode(this.vehicle)) * 31;
        String str = this.name;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.buttons);
    }

    public String toString() {
        SkinItem skinItem = this.skin;
        int i = this.warehouseType;
        int i2 = this.vehicle;
        String str = this.name;
        return "Skin(skin=" + skinItem + ", warehouseType=" + i + ", vehicle=" + i2 + ", name=" + str + ", buttons=" + this.buttons + ")";
    }

    public Skin(SkinItem skin, int i, int i2, String str, int i3) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        this.skin = skin;
        this.warehouseType = i;
        this.vehicle = i2;
        this.name = str;
        this.buttons = i3;
    }

    public final SkinItem getSkin() {
        return this.skin;
    }

    public final int getWarehouseType() {
        return this.warehouseType;
    }

    public final int getVehicle() {
        return this.vehicle;
    }

    public final String getName() {
        return this.name;
    }

    public final int getButtons() {
        return this.buttons;
    }
}

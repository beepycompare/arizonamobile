package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ConstantsKt;
/* compiled from: UserInventoryBars.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JG\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010'\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R%\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/Skin;", "", "skin", "Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "warehouseType", "", "vehicle", "name", "", "buttons", "accessPages", "Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;IILjava/lang/String;ILru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;)V", "getSkin", "()Lru/mrlargha/commonui/elements/inventory/domain/models/SkinItem;", "getWarehouseType", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "warehouse_type", "getVehicle", "getName", "()Ljava/lang/String;", "getButtons", "getAccessPages", "()Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;", ConstantsKt.ACCESS_PAGES, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Skin {
    @SerializedName(ConstantsKt.ACCESS_PAGES)
    private final AccessPagesModel accessPages;
    private final int buttons;
    private final String name;
    private final SkinItem skin;
    private final int vehicle;
    @SerializedName("warehouse_type")
    private final int warehouseType;

    public static /* synthetic */ Skin copy$default(Skin skin, SkinItem skinItem, int i, int i2, String str, int i3, AccessPagesModel accessPagesModel, int i4, Object obj) {
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
        if ((i4 & 32) != 0) {
            accessPagesModel = skin.accessPages;
        }
        int i5 = i3;
        AccessPagesModel accessPagesModel2 = accessPagesModel;
        return skin.copy(skinItem, i, i2, str, i5, accessPagesModel2);
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

    public final AccessPagesModel component6() {
        return this.accessPages;
    }

    public final Skin copy(SkinItem skin, int i, int i2, String str, int i3, AccessPagesModel accessPages) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        Intrinsics.checkNotNullParameter(accessPages, "accessPages");
        return new Skin(skin, i, i2, str, i3, accessPages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Skin) {
            Skin skin = (Skin) obj;
            return Intrinsics.areEqual(this.skin, skin.skin) && this.warehouseType == skin.warehouseType && this.vehicle == skin.vehicle && Intrinsics.areEqual(this.name, skin.name) && this.buttons == skin.buttons && Intrinsics.areEqual(this.accessPages, skin.accessPages);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.skin.hashCode() * 31) + Integer.hashCode(this.warehouseType)) * 31) + Integer.hashCode(this.vehicle)) * 31;
        String str = this.name;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.buttons)) * 31) + this.accessPages.hashCode();
    }

    public String toString() {
        SkinItem skinItem = this.skin;
        int i = this.warehouseType;
        int i2 = this.vehicle;
        String str = this.name;
        int i3 = this.buttons;
        return "Skin(skin=" + skinItem + ", warehouseType=" + i + ", vehicle=" + i2 + ", name=" + str + ", buttons=" + i3 + ", accessPages=" + this.accessPages + ")";
    }

    public Skin(SkinItem skin, int i, int i2, String str, int i3, AccessPagesModel accessPages) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        Intrinsics.checkNotNullParameter(accessPages, "accessPages");
        this.skin = skin;
        this.warehouseType = i;
        this.vehicle = i2;
        this.name = str;
        this.buttons = i3;
        this.accessPages = accessPages;
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

    public final AccessPagesModel getAccessPages() {
        return this.accessPages;
    }
}

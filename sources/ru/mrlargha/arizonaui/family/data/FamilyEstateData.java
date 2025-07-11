package ru.mrlargha.arizonaui.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003J}\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lru/mrlargha/arizonaui/family/data/FamilyEstateData;", "", "doorOpened", "", "taxCurrent", "taxTotal", "medkit", "armor", "products", FirebaseAnalytics.Param.ITEMS, "flag", "medkitPrice", "armorPrice", "menuIds", "", "<init>", "(IIIIIIIIIILjava/util/List;)V", "getDoorOpened", "()I", "getTaxCurrent", "getTaxTotal", "getMedkit", "getArmor", "getProducts", "getItems", "getFlag", "getMedkitPrice", "getArmorPrice", "getMenuIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyEstateData {
    private final int armor;
    private final int armorPrice;
    private final int doorOpened;
    private final int flag;
    private final int items;
    private final int medkit;
    private final int medkitPrice;
    private final List<Integer> menuIds;
    private final int products;
    private final int taxCurrent;
    private final int taxTotal;

    public static /* synthetic */ FamilyEstateData copy$default(FamilyEstateData familyEstateData, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = familyEstateData.doorOpened;
        }
        if ((i11 & 2) != 0) {
            i2 = familyEstateData.taxCurrent;
        }
        if ((i11 & 4) != 0) {
            i3 = familyEstateData.taxTotal;
        }
        if ((i11 & 8) != 0) {
            i4 = familyEstateData.medkit;
        }
        if ((i11 & 16) != 0) {
            i5 = familyEstateData.armor;
        }
        if ((i11 & 32) != 0) {
            i6 = familyEstateData.products;
        }
        if ((i11 & 64) != 0) {
            i7 = familyEstateData.items;
        }
        if ((i11 & 128) != 0) {
            i8 = familyEstateData.flag;
        }
        if ((i11 & 256) != 0) {
            i9 = familyEstateData.medkitPrice;
        }
        if ((i11 & 512) != 0) {
            i10 = familyEstateData.armorPrice;
        }
        List<Integer> list2 = list;
        if ((i11 & 1024) != 0) {
            list2 = familyEstateData.menuIds;
        }
        int i12 = i10;
        List list3 = list2;
        int i13 = i8;
        int i14 = i9;
        int i15 = i6;
        int i16 = i7;
        int i17 = i5;
        int i18 = i3;
        return familyEstateData.copy(i, i2, i18, i4, i17, i15, i16, i13, i14, i12, list3);
    }

    public final int component1() {
        return this.doorOpened;
    }

    public final int component10() {
        return this.armorPrice;
    }

    public final List<Integer> component11() {
        return this.menuIds;
    }

    public final int component2() {
        return this.taxCurrent;
    }

    public final int component3() {
        return this.taxTotal;
    }

    public final int component4() {
        return this.medkit;
    }

    public final int component5() {
        return this.armor;
    }

    public final int component6() {
        return this.products;
    }

    public final int component7() {
        return this.items;
    }

    public final int component8() {
        return this.flag;
    }

    public final int component9() {
        return this.medkitPrice;
    }

    public final FamilyEstateData copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List<Integer> menuIds) {
        Intrinsics.checkNotNullParameter(menuIds, "menuIds");
        return new FamilyEstateData(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, menuIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyEstateData) {
            FamilyEstateData familyEstateData = (FamilyEstateData) obj;
            return this.doorOpened == familyEstateData.doorOpened && this.taxCurrent == familyEstateData.taxCurrent && this.taxTotal == familyEstateData.taxTotal && this.medkit == familyEstateData.medkit && this.armor == familyEstateData.armor && this.products == familyEstateData.products && this.items == familyEstateData.items && this.flag == familyEstateData.flag && this.medkitPrice == familyEstateData.medkitPrice && this.armorPrice == familyEstateData.armorPrice && Intrinsics.areEqual(this.menuIds, familyEstateData.menuIds);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.doorOpened) * 31) + Integer.hashCode(this.taxCurrent)) * 31) + Integer.hashCode(this.taxTotal)) * 31) + Integer.hashCode(this.medkit)) * 31) + Integer.hashCode(this.armor)) * 31) + Integer.hashCode(this.products)) * 31) + Integer.hashCode(this.items)) * 31) + Integer.hashCode(this.flag)) * 31) + Integer.hashCode(this.medkitPrice)) * 31) + Integer.hashCode(this.armorPrice)) * 31) + this.menuIds.hashCode();
    }

    public String toString() {
        int i = this.doorOpened;
        int i2 = this.taxCurrent;
        int i3 = this.taxTotal;
        int i4 = this.medkit;
        int i5 = this.armor;
        int i6 = this.products;
        int i7 = this.items;
        int i8 = this.flag;
        int i9 = this.medkitPrice;
        int i10 = this.armorPrice;
        return "FamilyEstateData(doorOpened=" + i + ", taxCurrent=" + i2 + ", taxTotal=" + i3 + ", medkit=" + i4 + ", armor=" + i5 + ", products=" + i6 + ", items=" + i7 + ", flag=" + i8 + ", medkitPrice=" + i9 + ", armorPrice=" + i10 + ", menuIds=" + this.menuIds + ")";
    }

    public FamilyEstateData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, List<Integer> menuIds) {
        Intrinsics.checkNotNullParameter(menuIds, "menuIds");
        this.doorOpened = i;
        this.taxCurrent = i2;
        this.taxTotal = i3;
        this.medkit = i4;
        this.armor = i5;
        this.products = i6;
        this.items = i7;
        this.flag = i8;
        this.medkitPrice = i9;
        this.armorPrice = i10;
        this.menuIds = menuIds;
    }

    public final int getDoorOpened() {
        return this.doorOpened;
    }

    public final int getTaxCurrent() {
        return this.taxCurrent;
    }

    public final int getTaxTotal() {
        return this.taxTotal;
    }

    public final int getMedkit() {
        return this.medkit;
    }

    public final int getArmor() {
        return this.armor;
    }

    public final int getProducts() {
        return this.products;
    }

    public final int getItems() {
        return this.items;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final int getMedkitPrice() {
        return this.medkitPrice;
    }

    public final int getArmorPrice() {
        return this.armorPrice;
    }

    public final List<Integer> getMenuIds() {
        return this.menuIds;
    }
}

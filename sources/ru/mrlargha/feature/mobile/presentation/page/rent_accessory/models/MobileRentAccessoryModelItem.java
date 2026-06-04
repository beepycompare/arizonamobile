package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import com.google.gson.annotations.SerializedName;
import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
/* compiled from: MobileRentAccessoryModelItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R%\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R%\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R%\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R%\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R%\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R%\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(!¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R%\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011¨\u00065"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModelItem;", "", "slotId", "", "colorId", "enchanted", "itemID", "quality", "strength", "transfer", "unicId", "unicId2", "unicId3", "wear", "<init>", "(IIIIIIIIIII)V", "getSlotId", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "slotID", "getColorId", M2.g, "getEnchanted", "getItemID", "getQuality", "getStrength", "getTransfer", "getUnicId", "unic_id", "getUnicId2", "unic_id2", "getUnicId3", "unic_id3", "getWear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryModelItem {
    @SerializedName(M2.g)
    private final int colorId;
    @SerializedName("enchanted")
    private final int enchanted;
    @SerializedName("itemID")
    private final int itemID;
    @SerializedName("quality")
    private final int quality;
    @SerializedName("slotID")
    private final int slotId;
    @SerializedName("strength")
    private final int strength;
    @SerializedName("transfer")
    private final int transfer;
    @SerializedName("unic_id")
    private final int unicId;
    @SerializedName("unic_id2")
    private final int unicId2;
    @SerializedName("unic_id3")
    private final int unicId3;
    @SerializedName("wear")
    private final int wear;

    public static /* synthetic */ MobileRentAccessoryModelItem copy$default(MobileRentAccessoryModelItem mobileRentAccessoryModelItem, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = mobileRentAccessoryModelItem.slotId;
        }
        if ((i12 & 2) != 0) {
            i2 = mobileRentAccessoryModelItem.colorId;
        }
        if ((i12 & 4) != 0) {
            i3 = mobileRentAccessoryModelItem.enchanted;
        }
        if ((i12 & 8) != 0) {
            i4 = mobileRentAccessoryModelItem.itemID;
        }
        if ((i12 & 16) != 0) {
            i5 = mobileRentAccessoryModelItem.quality;
        }
        if ((i12 & 32) != 0) {
            i6 = mobileRentAccessoryModelItem.strength;
        }
        if ((i12 & 64) != 0) {
            i7 = mobileRentAccessoryModelItem.transfer;
        }
        if ((i12 & 128) != 0) {
            i8 = mobileRentAccessoryModelItem.unicId;
        }
        if ((i12 & 256) != 0) {
            i9 = mobileRentAccessoryModelItem.unicId2;
        }
        if ((i12 & 512) != 0) {
            i10 = mobileRentAccessoryModelItem.unicId3;
        }
        if ((i12 & 1024) != 0) {
            i11 = mobileRentAccessoryModelItem.wear;
        }
        int i13 = i10;
        int i14 = i11;
        int i15 = i8;
        int i16 = i9;
        int i17 = i6;
        int i18 = i7;
        int i19 = i5;
        int i20 = i3;
        return mobileRentAccessoryModelItem.copy(i, i2, i20, i4, i19, i17, i18, i15, i16, i13, i14);
    }

    public final int component1() {
        return this.slotId;
    }

    public final int component10() {
        return this.unicId3;
    }

    public final int component11() {
        return this.wear;
    }

    public final int component2() {
        return this.colorId;
    }

    public final int component3() {
        return this.enchanted;
    }

    public final int component4() {
        return this.itemID;
    }

    public final int component5() {
        return this.quality;
    }

    public final int component6() {
        return this.strength;
    }

    public final int component7() {
        return this.transfer;
    }

    public final int component8() {
        return this.unicId;
    }

    public final int component9() {
        return this.unicId2;
    }

    public final MobileRentAccessoryModelItem copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return new MobileRentAccessoryModelItem(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryModelItem) {
            MobileRentAccessoryModelItem mobileRentAccessoryModelItem = (MobileRentAccessoryModelItem) obj;
            return this.slotId == mobileRentAccessoryModelItem.slotId && this.colorId == mobileRentAccessoryModelItem.colorId && this.enchanted == mobileRentAccessoryModelItem.enchanted && this.itemID == mobileRentAccessoryModelItem.itemID && this.quality == mobileRentAccessoryModelItem.quality && this.strength == mobileRentAccessoryModelItem.strength && this.transfer == mobileRentAccessoryModelItem.transfer && this.unicId == mobileRentAccessoryModelItem.unicId && this.unicId2 == mobileRentAccessoryModelItem.unicId2 && this.unicId3 == mobileRentAccessoryModelItem.unicId3 && this.wear == mobileRentAccessoryModelItem.wear;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.slotId) * 31) + Integer.hashCode(this.colorId)) * 31) + Integer.hashCode(this.enchanted)) * 31) + Integer.hashCode(this.itemID)) * 31) + Integer.hashCode(this.quality)) * 31) + Integer.hashCode(this.strength)) * 31) + Integer.hashCode(this.transfer)) * 31) + Integer.hashCode(this.unicId)) * 31) + Integer.hashCode(this.unicId2)) * 31) + Integer.hashCode(this.unicId3)) * 31) + Integer.hashCode(this.wear);
    }

    public String toString() {
        int i = this.slotId;
        int i2 = this.colorId;
        int i3 = this.enchanted;
        int i4 = this.itemID;
        int i5 = this.quality;
        int i6 = this.strength;
        int i7 = this.transfer;
        int i8 = this.unicId;
        int i9 = this.unicId2;
        int i10 = this.unicId3;
        return "MobileRentAccessoryModelItem(slotId=" + i + ", colorId=" + i2 + ", enchanted=" + i3 + ", itemID=" + i4 + ", quality=" + i5 + ", strength=" + i6 + ", transfer=" + i7 + ", unicId=" + i8 + ", unicId2=" + i9 + ", unicId3=" + i10 + ", wear=" + this.wear + ")";
    }

    public MobileRentAccessoryModelItem(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.slotId = i;
        this.colorId = i2;
        this.enchanted = i3;
        this.itemID = i4;
        this.quality = i5;
        this.strength = i6;
        this.transfer = i7;
        this.unicId = i8;
        this.unicId2 = i9;
        this.unicId3 = i10;
        this.wear = i11;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final int getEnchanted() {
        return this.enchanted;
    }

    public final int getItemID() {
        return this.itemID;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final int getStrength() {
        return this.strength;
    }

    public final int getTransfer() {
        return this.transfer;
    }

    public final int getUnicId() {
        return this.unicId;
    }

    public final int getUnicId2() {
        return this.unicId2;
    }

    public final int getUnicId3() {
        return this.unicId3;
    }

    public final int getWear() {
        return this.wear;
    }
}

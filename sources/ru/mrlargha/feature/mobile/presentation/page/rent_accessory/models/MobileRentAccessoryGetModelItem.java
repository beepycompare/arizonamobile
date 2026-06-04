package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import com.google.gson.annotations.SerializedName;
import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
/* compiled from: MobileRentAccessoryGetModelItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u001e"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryGetModelItem;", "", "slotId", "", "itemId", "enchanted", "colorId", "<init>", "(IIII)V", "getSlotId", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "slotID", "getItemId", "itemID", "getEnchanted", "getColorId", M2.g, "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryGetModelItem {
    @SerializedName(M2.g)
    private final int colorId;
    @SerializedName("enchanted")
    private final int enchanted;
    @SerializedName("itemID")
    private final int itemId;
    @SerializedName("slotID")
    private final int slotId;

    public static /* synthetic */ MobileRentAccessoryGetModelItem copy$default(MobileRentAccessoryGetModelItem mobileRentAccessoryGetModelItem, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mobileRentAccessoryGetModelItem.slotId;
        }
        if ((i5 & 2) != 0) {
            i2 = mobileRentAccessoryGetModelItem.itemId;
        }
        if ((i5 & 4) != 0) {
            i3 = mobileRentAccessoryGetModelItem.enchanted;
        }
        if ((i5 & 8) != 0) {
            i4 = mobileRentAccessoryGetModelItem.colorId;
        }
        return mobileRentAccessoryGetModelItem.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.slotId;
    }

    public final int component2() {
        return this.itemId;
    }

    public final int component3() {
        return this.enchanted;
    }

    public final int component4() {
        return this.colorId;
    }

    public final MobileRentAccessoryGetModelItem copy(int i, int i2, int i3, int i4) {
        return new MobileRentAccessoryGetModelItem(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryGetModelItem) {
            MobileRentAccessoryGetModelItem mobileRentAccessoryGetModelItem = (MobileRentAccessoryGetModelItem) obj;
            return this.slotId == mobileRentAccessoryGetModelItem.slotId && this.itemId == mobileRentAccessoryGetModelItem.itemId && this.enchanted == mobileRentAccessoryGetModelItem.enchanted && this.colorId == mobileRentAccessoryGetModelItem.colorId;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.slotId) * 31) + Integer.hashCode(this.itemId)) * 31) + Integer.hashCode(this.enchanted)) * 31) + Integer.hashCode(this.colorId);
    }

    public String toString() {
        int i = this.slotId;
        int i2 = this.itemId;
        int i3 = this.enchanted;
        return "MobileRentAccessoryGetModelItem(slotId=" + i + ", itemId=" + i2 + ", enchanted=" + i3 + ", colorId=" + this.colorId + ")";
    }

    public MobileRentAccessoryGetModelItem(int i, int i2, int i3, int i4) {
        this.slotId = i;
        this.itemId = i2;
        this.enchanted = i3;
        this.colorId = i4;
    }

    public final int getSlotId() {
        return this.slotId;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getEnchanted() {
        return this.enchanted;
    }

    public final int getColorId() {
        return this.colorId;
    }
}

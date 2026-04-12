package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import kotlin.Metadata;
/* compiled from: MobileRentAccessorySendItemModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessorySendItemModel;", "", "listUID", "", "listID", "bizID", "slotID", "<init>", "(IIII)V", "getListUID", "()I", "getListID", "getBizID", "getSlotID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessorySendItemModel {
    private final int bizID;
    private final int listID;
    private final int listUID;
    private final int slotID;

    public static /* synthetic */ MobileRentAccessorySendItemModel copy$default(MobileRentAccessorySendItemModel mobileRentAccessorySendItemModel, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mobileRentAccessorySendItemModel.listUID;
        }
        if ((i5 & 2) != 0) {
            i2 = mobileRentAccessorySendItemModel.listID;
        }
        if ((i5 & 4) != 0) {
            i3 = mobileRentAccessorySendItemModel.bizID;
        }
        if ((i5 & 8) != 0) {
            i4 = mobileRentAccessorySendItemModel.slotID;
        }
        return mobileRentAccessorySendItemModel.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.listUID;
    }

    public final int component2() {
        return this.listID;
    }

    public final int component3() {
        return this.bizID;
    }

    public final int component4() {
        return this.slotID;
    }

    public final MobileRentAccessorySendItemModel copy(int i, int i2, int i3, int i4) {
        return new MobileRentAccessorySendItemModel(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessorySendItemModel) {
            MobileRentAccessorySendItemModel mobileRentAccessorySendItemModel = (MobileRentAccessorySendItemModel) obj;
            return this.listUID == mobileRentAccessorySendItemModel.listUID && this.listID == mobileRentAccessorySendItemModel.listID && this.bizID == mobileRentAccessorySendItemModel.bizID && this.slotID == mobileRentAccessorySendItemModel.slotID;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.listUID) * 31) + Integer.hashCode(this.listID)) * 31) + Integer.hashCode(this.bizID)) * 31) + Integer.hashCode(this.slotID);
    }

    public String toString() {
        int i = this.listUID;
        int i2 = this.listID;
        int i3 = this.bizID;
        return "MobileRentAccessorySendItemModel(listUID=" + i + ", listID=" + i2 + ", bizID=" + i3 + ", slotID=" + this.slotID + ")";
    }

    public MobileRentAccessorySendItemModel(int i, int i2, int i3, int i4) {
        this.listUID = i;
        this.listID = i2;
        this.bizID = i3;
        this.slotID = i4;
    }

    public final int getListUID() {
        return this.listUID;
    }

    public final int getListID() {
        return this.listID;
    }

    public final int getBizID() {
        return this.bizID;
    }

    public final int getSlotID() {
        return this.slotID;
    }
}

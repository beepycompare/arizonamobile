package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import kotlin.Metadata;
/* compiled from: MobileRentAccessoryNavigateModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryNavigateModel;", "", "page", "", "tab", "listUID", "<init>", "(III)V", "getPage", "()I", "getTab", "getListUID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryNavigateModel {
    private final int listUID;
    private final int page;
    private final int tab;

    public static /* synthetic */ MobileRentAccessoryNavigateModel copy$default(MobileRentAccessoryNavigateModel mobileRentAccessoryNavigateModel, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mobileRentAccessoryNavigateModel.page;
        }
        if ((i4 & 2) != 0) {
            i2 = mobileRentAccessoryNavigateModel.tab;
        }
        if ((i4 & 4) != 0) {
            i3 = mobileRentAccessoryNavigateModel.listUID;
        }
        return mobileRentAccessoryNavigateModel.copy(i, i2, i3);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.tab;
    }

    public final int component3() {
        return this.listUID;
    }

    public final MobileRentAccessoryNavigateModel copy(int i, int i2, int i3) {
        return new MobileRentAccessoryNavigateModel(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryNavigateModel) {
            MobileRentAccessoryNavigateModel mobileRentAccessoryNavigateModel = (MobileRentAccessoryNavigateModel) obj;
            return this.page == mobileRentAccessoryNavigateModel.page && this.tab == mobileRentAccessoryNavigateModel.tab && this.listUID == mobileRentAccessoryNavigateModel.listUID;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.page) * 31) + Integer.hashCode(this.tab)) * 31) + Integer.hashCode(this.listUID);
    }

    public String toString() {
        int i = this.page;
        int i2 = this.tab;
        return "MobileRentAccessoryNavigateModel(page=" + i + ", tab=" + i2 + ", listUID=" + this.listUID + ")";
    }

    public MobileRentAccessoryNavigateModel(int i, int i2, int i3) {
        this.page = i;
        this.tab = i2;
        this.listUID = i3;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getTab() {
        return this.tab;
    }

    public final int getListUID() {
        return this.listUID;
    }
}

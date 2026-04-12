package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobileRentAccessoryCreateAddModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCreateAddModel;", "", "cost", "", "categoryId", "", "desc", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCost", "()Ljava/lang/String;", "getCategoryId", "()I", "getDesc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryCreateAddModel {
    @SerializedName("category")
    private final int categoryId;
    private final String cost;
    private final String desc;

    public static /* synthetic */ MobileRentAccessoryCreateAddModel copy$default(MobileRentAccessoryCreateAddModel mobileRentAccessoryCreateAddModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mobileRentAccessoryCreateAddModel.cost;
        }
        if ((i2 & 2) != 0) {
            i = mobileRentAccessoryCreateAddModel.categoryId;
        }
        if ((i2 & 4) != 0) {
            str2 = mobileRentAccessoryCreateAddModel.desc;
        }
        return mobileRentAccessoryCreateAddModel.copy(str, i, str2);
    }

    public final String component1() {
        return this.cost;
    }

    public final int component2() {
        return this.categoryId;
    }

    public final String component3() {
        return this.desc;
    }

    public final MobileRentAccessoryCreateAddModel copy(String cost, int i, String desc) {
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new MobileRentAccessoryCreateAddModel(cost, i, desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryCreateAddModel) {
            MobileRentAccessoryCreateAddModel mobileRentAccessoryCreateAddModel = (MobileRentAccessoryCreateAddModel) obj;
            return Intrinsics.areEqual(this.cost, mobileRentAccessoryCreateAddModel.cost) && this.categoryId == mobileRentAccessoryCreateAddModel.categoryId && Intrinsics.areEqual(this.desc, mobileRentAccessoryCreateAddModel.desc);
        }
        return false;
    }

    public int hashCode() {
        return (((this.cost.hashCode() * 31) + Integer.hashCode(this.categoryId)) * 31) + this.desc.hashCode();
    }

    public String toString() {
        String str = this.cost;
        int i = this.categoryId;
        return "MobileRentAccessoryCreateAddModel(cost=" + str + ", categoryId=" + i + ", desc=" + this.desc + ")";
    }

    public MobileRentAccessoryCreateAddModel(String cost, int i, String desc) {
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.cost = cost;
        this.categoryId = i;
        this.desc = desc;
    }

    public final String getCost() {
        return this.cost;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final String getDesc() {
        return this.desc;
    }
}

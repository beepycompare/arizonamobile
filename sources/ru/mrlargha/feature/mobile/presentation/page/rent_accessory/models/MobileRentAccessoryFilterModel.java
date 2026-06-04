package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobileRentAccessoryFilterModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003Jb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0005HÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u001b\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u00064"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterModel;", "", "name", "", "number", "", "isSortByPrice", "", "isSortByRating", "onlySet", "onlySharpingTenPlus", "categoryId", "bizId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ZZZZII)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getNumber", "()Ljava/lang/Integer;", "setNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setSortByPrice", "(Z)V", "setSortByRating", "getOnlySet", "setOnlySet", "getOnlySharpingTenPlus", "setOnlySharpingTenPlus", "getCategoryId", "()I", "setCategoryId", "(I)V", "getBizId", "setBizId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZZZZII)Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterModel;", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryFilterModel {
    private int bizId;
    private int categoryId;
    private boolean isSortByPrice;
    private boolean isSortByRating;
    private String name;
    private Integer number;
    private boolean onlySet;
    private boolean onlySharpingTenPlus;

    public MobileRentAccessoryFilterModel() {
        this(null, null, false, false, false, false, 0, 0, 255, null);
    }

    public static /* synthetic */ MobileRentAccessoryFilterModel copy$default(MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel, String str, Integer num, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mobileRentAccessoryFilterModel.name;
        }
        if ((i3 & 2) != 0) {
            num = mobileRentAccessoryFilterModel.number;
        }
        if ((i3 & 4) != 0) {
            z = mobileRentAccessoryFilterModel.isSortByPrice;
        }
        if ((i3 & 8) != 0) {
            z2 = mobileRentAccessoryFilterModel.isSortByRating;
        }
        if ((i3 & 16) != 0) {
            z3 = mobileRentAccessoryFilterModel.onlySet;
        }
        if ((i3 & 32) != 0) {
            z4 = mobileRentAccessoryFilterModel.onlySharpingTenPlus;
        }
        if ((i3 & 64) != 0) {
            i = mobileRentAccessoryFilterModel.categoryId;
        }
        if ((i3 & 128) != 0) {
            i2 = mobileRentAccessoryFilterModel.bizId;
        }
        int i4 = i;
        int i5 = i2;
        boolean z5 = z3;
        boolean z6 = z4;
        return mobileRentAccessoryFilterModel.copy(str, num, z, z2, z5, z6, i4, i5);
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.number;
    }

    public final boolean component3() {
        return this.isSortByPrice;
    }

    public final boolean component4() {
        return this.isSortByRating;
    }

    public final boolean component5() {
        return this.onlySet;
    }

    public final boolean component6() {
        return this.onlySharpingTenPlus;
    }

    public final int component7() {
        return this.categoryId;
    }

    public final int component8() {
        return this.bizId;
    }

    public final MobileRentAccessoryFilterModel copy(String str, Integer num, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2) {
        return new MobileRentAccessoryFilterModel(str, num, z, z2, z3, z4, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryFilterModel) {
            MobileRentAccessoryFilterModel mobileRentAccessoryFilterModel = (MobileRentAccessoryFilterModel) obj;
            return Intrinsics.areEqual(this.name, mobileRentAccessoryFilterModel.name) && Intrinsics.areEqual(this.number, mobileRentAccessoryFilterModel.number) && this.isSortByPrice == mobileRentAccessoryFilterModel.isSortByPrice && this.isSortByRating == mobileRentAccessoryFilterModel.isSortByRating && this.onlySet == mobileRentAccessoryFilterModel.onlySet && this.onlySharpingTenPlus == mobileRentAccessoryFilterModel.onlySharpingTenPlus && this.categoryId == mobileRentAccessoryFilterModel.categoryId && this.bizId == mobileRentAccessoryFilterModel.bizId;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.number;
        return ((((((((((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSortByPrice)) * 31) + Boolean.hashCode(this.isSortByRating)) * 31) + Boolean.hashCode(this.onlySet)) * 31) + Boolean.hashCode(this.onlySharpingTenPlus)) * 31) + Integer.hashCode(this.categoryId)) * 31) + Integer.hashCode(this.bizId);
    }

    public String toString() {
        String str = this.name;
        Integer num = this.number;
        boolean z = this.isSortByPrice;
        boolean z2 = this.isSortByRating;
        boolean z3 = this.onlySet;
        boolean z4 = this.onlySharpingTenPlus;
        int i = this.categoryId;
        return "MobileRentAccessoryFilterModel(name=" + str + ", number=" + num + ", isSortByPrice=" + z + ", isSortByRating=" + z2 + ", onlySet=" + z3 + ", onlySharpingTenPlus=" + z4 + ", categoryId=" + i + ", bizId=" + this.bizId + ")";
    }

    public MobileRentAccessoryFilterModel(String str, Integer num, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2) {
        this.name = str;
        this.number = num;
        this.isSortByPrice = z;
        this.isSortByRating = z2;
        this.onlySet = z3;
        this.onlySharpingTenPlus = z4;
        this.categoryId = i;
        this.bizId = i2;
    }

    public /* synthetic */ MobileRentAccessoryFilterModel(String str, Integer num, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? -1 : i, (i3 & 128) != 0 ? -1 : i2);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final void setNumber(Integer num) {
        this.number = num;
    }

    public final boolean isSortByPrice() {
        return this.isSortByPrice;
    }

    public final void setSortByPrice(boolean z) {
        this.isSortByPrice = z;
    }

    public final boolean isSortByRating() {
        return this.isSortByRating;
    }

    public final void setSortByRating(boolean z) {
        this.isSortByRating = z;
    }

    public final boolean getOnlySet() {
        return this.onlySet;
    }

    public final void setOnlySet(boolean z) {
        this.onlySet = z;
    }

    public final boolean getOnlySharpingTenPlus() {
        return this.onlySharpingTenPlus;
    }

    public final void setOnlySharpingTenPlus(boolean z) {
        this.onlySharpingTenPlus = z;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(int i) {
        this.categoryId = i;
    }

    public final int getBizId() {
        return this.bizId;
    }

    public final void setBizId(int i) {
        this.bizId = i;
    }
}

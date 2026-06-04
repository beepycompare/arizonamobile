package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaRentAdModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0005J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0007\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\b\u0010\u000e¨\u0006\u001d"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;", "", "searchId", "", "isHaveGarage", "", "isHaveBasement", "isCostSortUp", "isRatingSortUp", "<init>", "(IZZLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getSearchId", "()I", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isDefault", "component1", "component2", "component3", "component4", "component5", "copy", "(IZZLjava/lang/Boolean;Ljava/lang/Boolean;)Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;", "equals", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentFilterModel {
    private final Boolean isCostSortUp;
    private final boolean isHaveBasement;
    private final boolean isHaveGarage;
    private final Boolean isRatingSortUp;
    private final int searchId;

    public static /* synthetic */ ArizonaRentFilterModel copy$default(ArizonaRentFilterModel arizonaRentFilterModel, int i, boolean z, boolean z2, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = arizonaRentFilterModel.searchId;
        }
        if ((i2 & 2) != 0) {
            z = arizonaRentFilterModel.isHaveGarage;
        }
        if ((i2 & 4) != 0) {
            z2 = arizonaRentFilterModel.isHaveBasement;
        }
        if ((i2 & 8) != 0) {
            bool = arizonaRentFilterModel.isCostSortUp;
        }
        if ((i2 & 16) != 0) {
            bool2 = arizonaRentFilterModel.isRatingSortUp;
        }
        Boolean bool3 = bool2;
        boolean z3 = z2;
        return arizonaRentFilterModel.copy(i, z, z3, bool, bool3);
    }

    public final int component1() {
        return this.searchId;
    }

    public final boolean component2() {
        return this.isHaveGarage;
    }

    public final boolean component3() {
        return this.isHaveBasement;
    }

    public final Boolean component4() {
        return this.isCostSortUp;
    }

    public final Boolean component5() {
        return this.isRatingSortUp;
    }

    public final ArizonaRentFilterModel copy(int i, boolean z, boolean z2, Boolean bool, Boolean bool2) {
        return new ArizonaRentFilterModel(i, z, z2, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentFilterModel) {
            ArizonaRentFilterModel arizonaRentFilterModel = (ArizonaRentFilterModel) obj;
            return this.searchId == arizonaRentFilterModel.searchId && this.isHaveGarage == arizonaRentFilterModel.isHaveGarage && this.isHaveBasement == arizonaRentFilterModel.isHaveBasement && Intrinsics.areEqual(this.isCostSortUp, arizonaRentFilterModel.isCostSortUp) && Intrinsics.areEqual(this.isRatingSortUp, arizonaRentFilterModel.isRatingSortUp);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.searchId) * 31) + Boolean.hashCode(this.isHaveGarage)) * 31) + Boolean.hashCode(this.isHaveBasement)) * 31;
        Boolean bool = this.isCostSortUp;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isRatingSortUp;
        return hashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        int i = this.searchId;
        boolean z = this.isHaveGarage;
        boolean z2 = this.isHaveBasement;
        Boolean bool = this.isCostSortUp;
        return "ArizonaRentFilterModel(searchId=" + i + ", isHaveGarage=" + z + ", isHaveBasement=" + z2 + ", isCostSortUp=" + bool + ", isRatingSortUp=" + this.isRatingSortUp + ")";
    }

    public ArizonaRentFilterModel(int i, boolean z, boolean z2, Boolean bool, Boolean bool2) {
        this.searchId = i;
        this.isHaveGarage = z;
        this.isHaveBasement = z2;
        this.isCostSortUp = bool;
        this.isRatingSortUp = bool2;
    }

    public /* synthetic */ ArizonaRentFilterModel(int i, boolean z, boolean z2, Boolean bool, Boolean bool2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, z, z2, bool, bool2);
    }

    public final int getSearchId() {
        return this.searchId;
    }

    public final boolean isHaveGarage() {
        return this.isHaveGarage;
    }

    public final boolean isHaveBasement() {
        return this.isHaveBasement;
    }

    public final Boolean isCostSortUp() {
        return this.isCostSortUp;
    }

    public final Boolean isRatingSortUp() {
        return this.isRatingSortUp;
    }

    public final boolean isDefault() {
        return this.searchId == -1 && !this.isHaveGarage && !this.isHaveBasement && this.isCostSortUp == null && this.isRatingSortUp == null;
    }
}

package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: MobileRentAccessoryLimitsModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryLimitsModel;", "", "minDesc", "", "maxDesc", "minCost", "maxCost", "<init>", "(IIII)V", "getMinDesc", "()I", "getMaxDesc", "getMinCost", "getMaxCost", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryLimitsModel {
    private final int maxCost;
    private final int maxDesc;
    private final int minCost;
    private final int minDesc;

    public MobileRentAccessoryLimitsModel() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ MobileRentAccessoryLimitsModel copy$default(MobileRentAccessoryLimitsModel mobileRentAccessoryLimitsModel, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mobileRentAccessoryLimitsModel.minDesc;
        }
        if ((i5 & 2) != 0) {
            i2 = mobileRentAccessoryLimitsModel.maxDesc;
        }
        if ((i5 & 4) != 0) {
            i3 = mobileRentAccessoryLimitsModel.minCost;
        }
        if ((i5 & 8) != 0) {
            i4 = mobileRentAccessoryLimitsModel.maxCost;
        }
        return mobileRentAccessoryLimitsModel.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.minDesc;
    }

    public final int component2() {
        return this.maxDesc;
    }

    public final int component3() {
        return this.minCost;
    }

    public final int component4() {
        return this.maxCost;
    }

    public final MobileRentAccessoryLimitsModel copy(int i, int i2, int i3, int i4) {
        return new MobileRentAccessoryLimitsModel(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryLimitsModel) {
            MobileRentAccessoryLimitsModel mobileRentAccessoryLimitsModel = (MobileRentAccessoryLimitsModel) obj;
            return this.minDesc == mobileRentAccessoryLimitsModel.minDesc && this.maxDesc == mobileRentAccessoryLimitsModel.maxDesc && this.minCost == mobileRentAccessoryLimitsModel.minCost && this.maxCost == mobileRentAccessoryLimitsModel.maxCost;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.minDesc) * 31) + Integer.hashCode(this.maxDesc)) * 31) + Integer.hashCode(this.minCost)) * 31) + Integer.hashCode(this.maxCost);
    }

    public String toString() {
        int i = this.minDesc;
        int i2 = this.maxDesc;
        int i3 = this.minCost;
        return "MobileRentAccessoryLimitsModel(minDesc=" + i + ", maxDesc=" + i2 + ", minCost=" + i3 + ", maxCost=" + this.maxCost + ")";
    }

    public MobileRentAccessoryLimitsModel(int i, int i2, int i3, int i4) {
        this.minDesc = i;
        this.maxDesc = i2;
        this.minCost = i3;
        this.maxCost = i4;
    }

    public /* synthetic */ MobileRentAccessoryLimitsModel(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1 : i, (i5 & 2) != 0 ? 70 : i2, (i5 & 4) != 0 ? 2000 : i3, (i5 & 8) != 0 ? 50000000 : i4);
    }

    public final int getMinDesc() {
        return this.minDesc;
    }

    public final int getMaxDesc() {
        return this.maxDesc;
    }

    public final int getMinCost() {
        return this.minCost;
    }

    public final int getMaxCost() {
        return this.maxCost;
    }
}

package ru.mrlargha.commonui.elements.donate.domain.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateBoostModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "", "totalEarnings", "", "mainBoostPayment", "boostEndTime", "", "bonusList", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBonusModel;", "<init>", "(IIJLjava/util/List;)V", "getTotalEarnings", "()I", "getMainBoostPayment", "getBoostEndTime", "()J", "getBonusList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBoostModel {
    @SerializedName("bonusPayments")
    private final List<DonateBonusModel> bonusList;
    @SerializedName("boostEndTime")
    private final long boostEndTime;
    @SerializedName("mainBoostPayment")
    private final int mainBoostPayment;
    @SerializedName("totalEarnings")
    private final int totalEarnings;

    public static /* synthetic */ DonateBoostModel copy$default(DonateBoostModel donateBoostModel, int i, int i2, long j, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = donateBoostModel.totalEarnings;
        }
        if ((i3 & 2) != 0) {
            i2 = donateBoostModel.mainBoostPayment;
        }
        if ((i3 & 4) != 0) {
            j = donateBoostModel.boostEndTime;
        }
        List<DonateBonusModel> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = donateBoostModel.bonusList;
        }
        List list3 = list2;
        return donateBoostModel.copy(i, i2, j, list3);
    }

    public final int component1() {
        return this.totalEarnings;
    }

    public final int component2() {
        return this.mainBoostPayment;
    }

    public final long component3() {
        return this.boostEndTime;
    }

    public final List<DonateBonusModel> component4() {
        return this.bonusList;
    }

    public final DonateBoostModel copy(int i, int i2, long j, List<DonateBonusModel> bonusList) {
        Intrinsics.checkNotNullParameter(bonusList, "bonusList");
        return new DonateBoostModel(i, i2, j, bonusList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBoostModel) {
            DonateBoostModel donateBoostModel = (DonateBoostModel) obj;
            return this.totalEarnings == donateBoostModel.totalEarnings && this.mainBoostPayment == donateBoostModel.mainBoostPayment && this.boostEndTime == donateBoostModel.boostEndTime && Intrinsics.areEqual(this.bonusList, donateBoostModel.bonusList);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.totalEarnings) * 31) + Integer.hashCode(this.mainBoostPayment)) * 31) + Long.hashCode(this.boostEndTime)) * 31) + this.bonusList.hashCode();
    }

    public String toString() {
        int i = this.totalEarnings;
        int i2 = this.mainBoostPayment;
        long j = this.boostEndTime;
        return "DonateBoostModel(totalEarnings=" + i + ", mainBoostPayment=" + i2 + ", boostEndTime=" + j + ", bonusList=" + this.bonusList + ")";
    }

    public DonateBoostModel(int i, int i2, long j, List<DonateBonusModel> bonusList) {
        Intrinsics.checkNotNullParameter(bonusList, "bonusList");
        this.totalEarnings = i;
        this.mainBoostPayment = i2;
        this.boostEndTime = j;
        this.bonusList = bonusList;
    }

    public final int getTotalEarnings() {
        return this.totalEarnings;
    }

    public final int getMainBoostPayment() {
        return this.mainBoostPayment;
    }

    public final long getBoostEndTime() {
        return this.boostEndTime;
    }

    public final List<DonateBonusModel> getBonusList() {
        return this.bonusList;
    }
}

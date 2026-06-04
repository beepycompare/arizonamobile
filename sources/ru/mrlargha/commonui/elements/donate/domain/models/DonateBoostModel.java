package ru.mrlargha.commonui.elements.donate.domain.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateBoostModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonateBoostModel;", "", "totalEarnings", "", "mainBoostPayment", "boostEndTime", "bonusList", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBonusModel;", "<init>", "(JJJLjava/util/List;)V", "getTotalEarnings", "()J", "Lcom/google/gson/annotations/SerializedName;", "value", "getMainBoostPayment", "getBoostEndTime", "getBonusList", "()Ljava/util/List;", "bonusPayments", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateBoostModel {
    @SerializedName("bonusPayments")
    private final List<DonateBonusModel> bonusList;
    @SerializedName("boostEndTime")
    private final long boostEndTime;
    @SerializedName("mainBoostPayment")
    private final long mainBoostPayment;
    @SerializedName("totalEarnings")
    private final long totalEarnings;

    public static /* synthetic */ DonateBoostModel copy$default(DonateBoostModel donateBoostModel, long j, long j2, long j3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = donateBoostModel.totalEarnings;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = donateBoostModel.mainBoostPayment;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = donateBoostModel.boostEndTime;
        }
        long j6 = j3;
        List<DonateBonusModel> list2 = list;
        if ((i & 8) != 0) {
            list2 = donateBoostModel.bonusList;
        }
        return donateBoostModel.copy(j4, j5, j6, list2);
    }

    public final long component1() {
        return this.totalEarnings;
    }

    public final long component2() {
        return this.mainBoostPayment;
    }

    public final long component3() {
        return this.boostEndTime;
    }

    public final List<DonateBonusModel> component4() {
        return this.bonusList;
    }

    public final DonateBoostModel copy(long j, long j2, long j3, List<DonateBonusModel> bonusList) {
        Intrinsics.checkNotNullParameter(bonusList, "bonusList");
        return new DonateBoostModel(j, j2, j3, bonusList);
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
        return (((((Long.hashCode(this.totalEarnings) * 31) + Long.hashCode(this.mainBoostPayment)) * 31) + Long.hashCode(this.boostEndTime)) * 31) + this.bonusList.hashCode();
    }

    public String toString() {
        long j = this.totalEarnings;
        long j2 = this.mainBoostPayment;
        long j3 = this.boostEndTime;
        return "DonateBoostModel(totalEarnings=" + j + ", mainBoostPayment=" + j2 + ", boostEndTime=" + j3 + ", bonusList=" + this.bonusList + ")";
    }

    public DonateBoostModel(long j, long j2, long j3, List<DonateBonusModel> bonusList) {
        Intrinsics.checkNotNullParameter(bonusList, "bonusList");
        this.totalEarnings = j;
        this.mainBoostPayment = j2;
        this.boostEndTime = j3;
        this.bonusList = bonusList;
    }

    public final long getTotalEarnings() {
        return this.totalEarnings;
    }

    public final long getMainBoostPayment() {
        return this.mainBoostPayment;
    }

    public final long getBoostEndTime() {
        return this.boostEndTime;
    }

    public final List<DonateBonusModel> getBonusList() {
        return this.bonusList;
    }
}

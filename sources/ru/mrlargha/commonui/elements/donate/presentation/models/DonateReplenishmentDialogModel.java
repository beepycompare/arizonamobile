package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateReplenishmentDialogModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateReplenishmentDialogModel;", "", "badgesList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModel;", "rate", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "bonusPercentList", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModel;", "<init>", "(Ljava/util/List;Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;Ljava/util/List;)V", "getBadgesList", "()Ljava/util/List;", "getRate", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "getBonusPercentList", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogModel {
    private final List<DonateBadgesModel> badgesList;
    private final List<DonateBonusModel> bonusPercentList;
    private final DonateRateModel rate;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateReplenishmentDialogModel copy$default(DonateReplenishmentDialogModel donateReplenishmentDialogModel, List list, DonateRateModel donateRateModel, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = donateReplenishmentDialogModel.badgesList;
        }
        if ((i & 2) != 0) {
            donateRateModel = donateReplenishmentDialogModel.rate;
        }
        if ((i & 4) != 0) {
            list2 = donateReplenishmentDialogModel.bonusPercentList;
        }
        return donateReplenishmentDialogModel.copy(list, donateRateModel, list2);
    }

    public final List<DonateBadgesModel> component1() {
        return this.badgesList;
    }

    public final DonateRateModel component2() {
        return this.rate;
    }

    public final List<DonateBonusModel> component3() {
        return this.bonusPercentList;
    }

    public final DonateReplenishmentDialogModel copy(List<DonateBadgesModel> badgesList, DonateRateModel rate, List<DonateBonusModel> bonusPercentList) {
        Intrinsics.checkNotNullParameter(badgesList, "badgesList");
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        return new DonateReplenishmentDialogModel(badgesList, rate, bonusPercentList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateReplenishmentDialogModel) {
            DonateReplenishmentDialogModel donateReplenishmentDialogModel = (DonateReplenishmentDialogModel) obj;
            return Intrinsics.areEqual(this.badgesList, donateReplenishmentDialogModel.badgesList) && Intrinsics.areEqual(this.rate, donateReplenishmentDialogModel.rate) && Intrinsics.areEqual(this.bonusPercentList, donateReplenishmentDialogModel.bonusPercentList);
        }
        return false;
    }

    public int hashCode() {
        return (((this.badgesList.hashCode() * 31) + this.rate.hashCode()) * 31) + this.bonusPercentList.hashCode();
    }

    public String toString() {
        List<DonateBadgesModel> list = this.badgesList;
        DonateRateModel donateRateModel = this.rate;
        return "DonateReplenishmentDialogModel(badgesList=" + list + ", rate=" + donateRateModel + ", bonusPercentList=" + this.bonusPercentList + ")";
    }

    public DonateReplenishmentDialogModel(List<DonateBadgesModel> badgesList, DonateRateModel rate, List<DonateBonusModel> bonusPercentList) {
        Intrinsics.checkNotNullParameter(badgesList, "badgesList");
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        this.badgesList = badgesList;
        this.rate = rate;
        this.bonusPercentList = bonusPercentList;
    }

    public final List<DonateBadgesModel> getBadgesList() {
        return this.badgesList;
    }

    public final DonateRateModel getRate() {
        return this.rate;
    }

    public final List<DonateBonusModel> getBonusPercentList() {
        return this.bonusPercentList;
    }
}

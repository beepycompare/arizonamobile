package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateBoostModelUi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "", "rate", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "endLeftTime", "", "bonusPercentList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModelUi;", "reverse", "", "x", "", "boost", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;JLjava/util/List;ZII)V", "getRate", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "getEndLeftTime", "()J", "getBonusPercentList", "()Ljava/util/List;", "getReverse", "()Z", "getX", "()I", "getBoost", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBoostModelUi {
    private final List<DonateBonusModelUi> bonusPercentList;
    private final int boost;
    private final long endLeftTime;
    private final DonateRateModel rate;
    private final boolean reverse;
    private final int x;

    public static /* synthetic */ DonateBoostModelUi copy$default(DonateBoostModelUi donateBoostModelUi, DonateRateModel donateRateModel, long j, List list, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            donateRateModel = donateBoostModelUi.rate;
        }
        if ((i3 & 2) != 0) {
            j = donateBoostModelUi.endLeftTime;
        }
        List<DonateBonusModelUi> list2 = list;
        if ((i3 & 4) != 0) {
            list2 = donateBoostModelUi.bonusPercentList;
        }
        if ((i3 & 8) != 0) {
            z = donateBoostModelUi.reverse;
        }
        if ((i3 & 16) != 0) {
            i = donateBoostModelUi.x;
        }
        if ((i3 & 32) != 0) {
            i2 = donateBoostModelUi.boost;
        }
        return donateBoostModelUi.copy(donateRateModel, j, list2, z, i, i2);
    }

    public final DonateRateModel component1() {
        return this.rate;
    }

    public final long component2() {
        return this.endLeftTime;
    }

    public final List<DonateBonusModelUi> component3() {
        return this.bonusPercentList;
    }

    public final boolean component4() {
        return this.reverse;
    }

    public final int component5() {
        return this.x;
    }

    public final int component6() {
        return this.boost;
    }

    public final DonateBoostModelUi copy(DonateRateModel rate, long j, List<DonateBonusModelUi> bonusPercentList, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        return new DonateBoostModelUi(rate, j, bonusPercentList, z, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBoostModelUi) {
            DonateBoostModelUi donateBoostModelUi = (DonateBoostModelUi) obj;
            return Intrinsics.areEqual(this.rate, donateBoostModelUi.rate) && this.endLeftTime == donateBoostModelUi.endLeftTime && Intrinsics.areEqual(this.bonusPercentList, donateBoostModelUi.bonusPercentList) && this.reverse == donateBoostModelUi.reverse && this.x == donateBoostModelUi.x && this.boost == donateBoostModelUi.boost;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.rate.hashCode() * 31) + Long.hashCode(this.endLeftTime)) * 31) + this.bonusPercentList.hashCode()) * 31) + Boolean.hashCode(this.reverse)) * 31) + Integer.hashCode(this.x)) * 31) + Integer.hashCode(this.boost);
    }

    public String toString() {
        DonateRateModel donateRateModel = this.rate;
        long j = this.endLeftTime;
        List<DonateBonusModelUi> list = this.bonusPercentList;
        boolean z = this.reverse;
        int i = this.x;
        return "DonateBoostModelUi(rate=" + donateRateModel + ", endLeftTime=" + j + ", bonusPercentList=" + list + ", reverse=" + z + ", x=" + i + ", boost=" + this.boost + ")";
    }

    public DonateBoostModelUi(DonateRateModel rate, long j, List<DonateBonusModelUi> bonusPercentList, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        this.rate = rate;
        this.endLeftTime = j;
        this.bonusPercentList = bonusPercentList;
        this.reverse = z;
        this.x = i;
        this.boost = i2;
    }

    public final DonateRateModel getRate() {
        return this.rate;
    }

    public final long getEndLeftTime() {
        return this.endLeftTime;
    }

    public final List<DonateBonusModelUi> getBonusPercentList() {
        return this.bonusPercentList;
    }

    public final boolean getReverse() {
        return this.reverse;
    }

    public final int getX() {
        return this.x;
    }

    public final int getBoost() {
        return this.boost;
    }
}

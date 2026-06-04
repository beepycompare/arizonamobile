package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.arizona.launcher.UpdateActivity;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: DonateBoostModelUi.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Ja\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0014\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "", "rate", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "endLeftTime", "", "bonusPercentList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModelUi;", "reverse", "", "x", "boost", "itemType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemType;", UpdateActivity.UPDATE_MODE, "Lcom/google/gson/JsonElement;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;JLjava/util/List;ZJJLru/mrlargha/commonui/elements/donate/presentation/models/DonateItemType;Lcom/google/gson/JsonElement;)V", "getRate", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "getEndLeftTime", "()J", "getBonusPercentList", "()Ljava/util/List;", "getReverse", "()Z", "getX", "getBoost", "getItemType", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemType;", "getMode", "()Lcom/google/gson/JsonElement;", "getRateType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateBoostModelUi {
    private final List<DonateBonusModelUi> bonusPercentList;
    private final long boost;
    private final long endLeftTime;
    private final DonateItemType itemType;
    private final JsonElement mode;
    private final DonateRateModel rate;
    private final boolean reverse;
    private final long x;

    public static /* synthetic */ DonateBoostModelUi copy$default(DonateBoostModelUi donateBoostModelUi, DonateRateModel donateRateModel, long j, List list, boolean z, long j2, long j3, DonateItemType donateItemType, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            donateRateModel = donateBoostModelUi.rate;
        }
        if ((i & 2) != 0) {
            j = donateBoostModelUi.endLeftTime;
        }
        List<DonateBonusModelUi> list2 = list;
        if ((i & 4) != 0) {
            list2 = donateBoostModelUi.bonusPercentList;
        }
        if ((i & 8) != 0) {
            z = donateBoostModelUi.reverse;
        }
        if ((i & 16) != 0) {
            j2 = donateBoostModelUi.x;
        }
        if ((i & 32) != 0) {
            j3 = donateBoostModelUi.boost;
        }
        if ((i & 64) != 0) {
            donateItemType = donateBoostModelUi.itemType;
        }
        if ((i & 128) != 0) {
            jsonElement = donateBoostModelUi.mode;
        }
        long j4 = j3;
        long j5 = j2;
        List list3 = list2;
        return donateBoostModelUi.copy(donateRateModel, j, list3, z, j5, j4, donateItemType, jsonElement);
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

    public final long component5() {
        return this.x;
    }

    public final long component6() {
        return this.boost;
    }

    public final DonateItemType component7() {
        return this.itemType;
    }

    public final JsonElement component8() {
        return this.mode;
    }

    public final DonateBoostModelUi copy(DonateRateModel rate, long j, List<DonateBonusModelUi> bonusPercentList, boolean z, long j2, long j3, DonateItemType itemType, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new DonateBoostModelUi(rate, j, bonusPercentList, z, j2, j3, itemType, jsonElement);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateBoostModelUi) {
            DonateBoostModelUi donateBoostModelUi = (DonateBoostModelUi) obj;
            return Intrinsics.areEqual(this.rate, donateBoostModelUi.rate) && this.endLeftTime == donateBoostModelUi.endLeftTime && Intrinsics.areEqual(this.bonusPercentList, donateBoostModelUi.bonusPercentList) && this.reverse == donateBoostModelUi.reverse && this.x == donateBoostModelUi.x && this.boost == donateBoostModelUi.boost && this.itemType == donateBoostModelUi.itemType && Intrinsics.areEqual(this.mode, donateBoostModelUi.mode);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.rate.hashCode() * 31) + Long.hashCode(this.endLeftTime)) * 31) + this.bonusPercentList.hashCode()) * 31) + Boolean.hashCode(this.reverse)) * 31) + Long.hashCode(this.x)) * 31) + Long.hashCode(this.boost)) * 31) + this.itemType.hashCode()) * 31;
        JsonElement jsonElement = this.mode;
        return hashCode + (jsonElement == null ? 0 : jsonElement.hashCode());
    }

    public String toString() {
        DonateRateModel donateRateModel = this.rate;
        long j = this.endLeftTime;
        List<DonateBonusModelUi> list = this.bonusPercentList;
        boolean z = this.reverse;
        long j2 = this.x;
        long j3 = this.boost;
        DonateItemType donateItemType = this.itemType;
        return "DonateBoostModelUi(rate=" + donateRateModel + ", endLeftTime=" + j + ", bonusPercentList=" + list + ", reverse=" + z + ", x=" + j2 + ", boost=" + j3 + ", itemType=" + donateItemType + ", mode=" + this.mode + ")";
    }

    public DonateBoostModelUi(DonateRateModel rate, long j, List<DonateBonusModelUi> bonusPercentList, boolean z, long j2, long j3, DonateItemType itemType, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        Intrinsics.checkNotNullParameter(bonusPercentList, "bonusPercentList");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.rate = rate;
        this.endLeftTime = j;
        this.bonusPercentList = bonusPercentList;
        this.reverse = z;
        this.x = j2;
        this.boost = j3;
        this.itemType = itemType;
        this.mode = jsonElement;
    }

    public /* synthetic */ DonateBoostModelUi(DonateRateModel donateRateModel, long j, List list, boolean z, long j2, long j3, DonateItemType donateItemType, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(donateRateModel, j, list, z, j2, j3, donateItemType, (i & 128) != 0 ? null : jsonElement);
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

    public final long getX() {
        return this.x;
    }

    public final long getBoost() {
        return this.boost;
    }

    public final DonateItemType getItemType() {
        return this.itemType;
    }

    public final JsonElement getMode() {
        return this.mode;
    }

    public final DonateRateType getRateType() {
        if (this.itemType == DonateItemType.EXP) {
            if (UtilsKt.isArizonaType()) {
                return DonateRateType.EXCHANGER_GREEN_RUB;
            }
            return DonateRateType.EXCHANGER_EXP;
        } else if (this.reverse) {
            return DonateRateType.BUY_AZ;
        } else {
            return DonateRateType.EXCHANGER_RUB;
        }
    }
}

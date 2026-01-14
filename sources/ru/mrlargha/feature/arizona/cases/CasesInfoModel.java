package ru.mrlargha.feature.arizona.cases;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u0017\u001a\u00020\u001cJ\u0006\u0010\u0011\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001a\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010\u0018Jx\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u00061"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesInfoModel;", "", "caseId", "", "countLeft", "haveDiamond", "maxDiamond", "legendary", FirebaseAnalytics.Param.DISCOUNT, "discountCount", "cost", FirebaseAnalytics.Param.CURRENCY, "availableUntil", "<init>", "(IIIIIIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCaseId", "()I", "getCountLeft", "getHaveDiamond", "getMaxDiamond", "getLegendary", "getDiscount", "getDiscountCount", "getCost", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrency", "getAvailableUntil", "", "getProgress", "Lru/mrlargha/feature/arizona/cases/CasesCurrencyType;", "isSpecialCase", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(IIIIIIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/feature/arizona/cases/CasesInfoModel;", "equals", "other", "hashCode", "toString", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesInfoModel {
    private final Integer availableUntil;
    @SerializedName("caseId")
    private final int caseId;
    private final Integer cost;
    @SerializedName("count")
    private final int countLeft;
    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private final Integer currency;
    private final int discount;
    private final int discountCount;
    @SerializedName("current")
    private final int haveDiamond;
    @SerializedName("legendary")
    private final int legendary;
    @SerializedName("total")
    private final int maxDiamond;

    private final Integer component10() {
        return this.availableUntil;
    }

    public static /* synthetic */ CasesInfoModel copy$default(CasesInfoModel casesInfoModel, int i, int i2, int i3, int i4, int i5, int i6, int i7, Integer num, Integer num2, Integer num3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = casesInfoModel.caseId;
        }
        if ((i8 & 2) != 0) {
            i2 = casesInfoModel.countLeft;
        }
        if ((i8 & 4) != 0) {
            i3 = casesInfoModel.haveDiamond;
        }
        if ((i8 & 8) != 0) {
            i4 = casesInfoModel.maxDiamond;
        }
        if ((i8 & 16) != 0) {
            i5 = casesInfoModel.legendary;
        }
        if ((i8 & 32) != 0) {
            i6 = casesInfoModel.discount;
        }
        if ((i8 & 64) != 0) {
            i7 = casesInfoModel.discountCount;
        }
        if ((i8 & 128) != 0) {
            num = casesInfoModel.cost;
        }
        if ((i8 & 256) != 0) {
            num2 = casesInfoModel.currency;
        }
        if ((i8 & 512) != 0) {
            num3 = casesInfoModel.availableUntil;
        }
        Integer num4 = num2;
        Integer num5 = num3;
        int i9 = i7;
        Integer num6 = num;
        int i10 = i5;
        int i11 = i6;
        return casesInfoModel.copy(i, i2, i3, i4, i10, i11, i9, num6, num4, num5);
    }

    public final int component1() {
        return this.caseId;
    }

    public final int component2() {
        return this.countLeft;
    }

    public final int component3() {
        return this.haveDiamond;
    }

    public final int component4() {
        return this.maxDiamond;
    }

    public final int component5() {
        return this.legendary;
    }

    public final int component6() {
        return this.discount;
    }

    public final int component7() {
        return this.discountCount;
    }

    public final Integer component8() {
        return this.cost;
    }

    public final Integer component9() {
        return this.currency;
    }

    public final CasesInfoModel copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, Integer num, Integer num2, Integer num3) {
        return new CasesInfoModel(i, i2, i3, i4, i5, i6, i7, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesInfoModel) {
            CasesInfoModel casesInfoModel = (CasesInfoModel) obj;
            return this.caseId == casesInfoModel.caseId && this.countLeft == casesInfoModel.countLeft && this.haveDiamond == casesInfoModel.haveDiamond && this.maxDiamond == casesInfoModel.maxDiamond && this.legendary == casesInfoModel.legendary && this.discount == casesInfoModel.discount && this.discountCount == casesInfoModel.discountCount && Intrinsics.areEqual(this.cost, casesInfoModel.cost) && Intrinsics.areEqual(this.currency, casesInfoModel.currency) && Intrinsics.areEqual(this.availableUntil, casesInfoModel.availableUntil);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((Integer.hashCode(this.caseId) * 31) + Integer.hashCode(this.countLeft)) * 31) + Integer.hashCode(this.haveDiamond)) * 31) + Integer.hashCode(this.maxDiamond)) * 31) + Integer.hashCode(this.legendary)) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.discountCount)) * 31;
        Integer num = this.cost;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.currency;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.availableUntil;
        return hashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        int i = this.caseId;
        int i2 = this.countLeft;
        int i3 = this.haveDiamond;
        int i4 = this.maxDiamond;
        int i5 = this.legendary;
        int i6 = this.discount;
        int i7 = this.discountCount;
        Integer num = this.cost;
        Integer num2 = this.currency;
        return "CasesInfoModel(caseId=" + i + ", countLeft=" + i2 + ", haveDiamond=" + i3 + ", maxDiamond=" + i4 + ", legendary=" + i5 + ", discount=" + i6 + ", discountCount=" + i7 + ", cost=" + num + ", currency=" + num2 + ", availableUntil=" + this.availableUntil + ")";
    }

    public CasesInfoModel(int i, int i2, int i3, int i4, int i5, int i6, int i7, Integer num, Integer num2, Integer num3) {
        this.caseId = i;
        this.countLeft = i2;
        this.haveDiamond = i3;
        this.maxDiamond = i4;
        this.legendary = i5;
        this.discount = i6;
        this.discountCount = i7;
        this.cost = num;
        this.currency = num2;
        this.availableUntil = num3;
    }

    public final int getCaseId() {
        return this.caseId;
    }

    public final int getCountLeft() {
        return this.countLeft;
    }

    public final int getHaveDiamond() {
        return this.haveDiamond;
    }

    public final int getMaxDiamond() {
        return this.maxDiamond;
    }

    public final int getLegendary() {
        return this.legendary;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getDiscountCount() {
        return this.discountCount;
    }

    public final Integer getCost() {
        return this.cost;
    }

    public final Integer getCurrency() {
        return this.currency;
    }

    public final String getAvailableUntil() {
        Integer num = this.availableUntil;
        Long valueOf = num != null ? Long.valueOf(num.intValue()) : null;
        Intrinsics.checkNotNull(valueOf);
        return CasesResponseKt.caseTimeConverter(valueOf.longValue());
    }

    /* renamed from: getCost  reason: collision with other method in class */
    public final String m12420getCost() {
        int intValue;
        if (this.countLeft > 0) {
            return "Открыть";
        }
        if (isSpecialCase()) {
            return "Недоступно";
        }
        Integer num = this.cost;
        return (num == null || (intValue = num.intValue()) <= 0) ? "Открыть" : "Открыть за " + intValue;
    }

    /* renamed from: getCountLeft  reason: collision with other method in class */
    public final String m12421getCountLeft() {
        return "Осталось " + this.countLeft + " шт.";
    }

    public final String getProgress() {
        int i = this.haveDiamond;
        return i + "/" + this.maxDiamond;
    }

    /* renamed from: getCurrency  reason: collision with other method in class */
    public final CasesCurrencyType m12422getCurrency() {
        Object obj;
        Iterator<E> it = CasesCurrencyType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int type = ((CasesCurrencyType) obj).getType();
            Integer num = this.currency;
            if (num != null && type == num.intValue()) {
                break;
            }
        }
        CasesCurrencyType casesCurrencyType = (CasesCurrencyType) obj;
        return casesCurrencyType == null ? CasesCurrencyType.RUB : casesCurrencyType;
    }

    public final boolean isSpecialCase() {
        return this.caseId == 0;
    }
}

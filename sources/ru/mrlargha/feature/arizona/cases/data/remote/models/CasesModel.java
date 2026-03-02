package ru.mrlargha.feature.arizona.cases.data.remote.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.cases.CasesSameCasesModel;
/* compiled from: CasesModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u008a\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00106\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0011\u0010!¨\u00067"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesModel;", "", "id", "", "name", "", "image", "unix", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.CURRENCY, FirebaseAnalytics.Param.DISCOUNT, "discountCount", "prizes", "", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesPrizeModel;", "badges", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesBadgesModel;", "isVehicle", "<init>", "(ILjava/lang/String;IIIIIILjava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getImage", "getUnix", "getPrice", "getCurrency", "getDiscount", "getDiscountCount", "getPrizes", "()Ljava/util/List;", "getBadges", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toModel", "Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(ILjava/lang/String;IIIIIILjava/util/List;Ljava/util/List;Ljava/lang/Integer;)Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesModel;", "equals", "", "other", "hashCode", "toString", "cases"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesModel {
    @SerializedName("badges")
    private final List<CasesBadgesModel> badges;
    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private final int currency;
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    private final int discount;
    @SerializedName("discount_count")
    private final int discountCount;
    @SerializedName("id")
    private final int id;
    @SerializedName("image")
    private final int image;
    @SerializedName("isVehicle")
    private final Integer isVehicle;
    @SerializedName("name")
    private final String name;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int price;
    @SerializedName("prizes")
    private final List<CasesPrizeModel> prizes;
    @SerializedName("unix")
    private final int unix;

    public static /* synthetic */ CasesModel copy$default(CasesModel casesModel, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, List list, List list2, Integer num, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = casesModel.id;
        }
        if ((i8 & 2) != 0) {
            str = casesModel.name;
        }
        if ((i8 & 4) != 0) {
            i2 = casesModel.image;
        }
        if ((i8 & 8) != 0) {
            i3 = casesModel.unix;
        }
        if ((i8 & 16) != 0) {
            i4 = casesModel.price;
        }
        if ((i8 & 32) != 0) {
            i5 = casesModel.currency;
        }
        if ((i8 & 64) != 0) {
            i6 = casesModel.discount;
        }
        if ((i8 & 128) != 0) {
            i7 = casesModel.discountCount;
        }
        List<CasesPrizeModel> list3 = list;
        if ((i8 & 256) != 0) {
            list3 = casesModel.prizes;
        }
        List<CasesBadgesModel> list4 = list2;
        if ((i8 & 512) != 0) {
            list4 = casesModel.badges;
        }
        if ((i8 & 1024) != 0) {
            num = casesModel.isVehicle;
        }
        List list5 = list4;
        Integer num2 = num;
        int i9 = i7;
        List list6 = list3;
        int i10 = i5;
        int i11 = i6;
        int i12 = i4;
        int i13 = i2;
        return casesModel.copy(i, str, i13, i3, i12, i10, i11, i9, list6, list5, num2);
    }

    public final int component1() {
        return this.id;
    }

    public final List<CasesBadgesModel> component10() {
        return this.badges;
    }

    public final Integer component11() {
        return this.isVehicle;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.image;
    }

    public final int component4() {
        return this.unix;
    }

    public final int component5() {
        return this.price;
    }

    public final int component6() {
        return this.currency;
    }

    public final int component7() {
        return this.discount;
    }

    public final int component8() {
        return this.discountCount;
    }

    public final List<CasesPrizeModel> component9() {
        return this.prizes;
    }

    public final CasesModel copy(int i, String name, int i2, int i3, int i4, int i5, int i6, int i7, List<CasesPrizeModel> prizes, List<CasesBadgesModel> badges, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        Intrinsics.checkNotNullParameter(badges, "badges");
        return new CasesModel(i, name, i2, i3, i4, i5, i6, i7, prizes, badges, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesModel) {
            CasesModel casesModel = (CasesModel) obj;
            return this.id == casesModel.id && Intrinsics.areEqual(this.name, casesModel.name) && this.image == casesModel.image && this.unix == casesModel.unix && this.price == casesModel.price && this.currency == casesModel.currency && this.discount == casesModel.discount && this.discountCount == casesModel.discountCount && Intrinsics.areEqual(this.prizes, casesModel.prizes) && Intrinsics.areEqual(this.badges, casesModel.badges) && Intrinsics.areEqual(this.isVehicle, casesModel.isVehicle);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.unix)) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.currency)) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.discountCount)) * 31) + this.prizes.hashCode()) * 31) + this.badges.hashCode()) * 31;
        Integer num = this.isVehicle;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.image;
        int i3 = this.unix;
        int i4 = this.price;
        int i5 = this.currency;
        int i6 = this.discount;
        int i7 = this.discountCount;
        List<CasesPrizeModel> list = this.prizes;
        List<CasesBadgesModel> list2 = this.badges;
        return "CasesModel(id=" + i + ", name=" + str + ", image=" + i2 + ", unix=" + i3 + ", price=" + i4 + ", currency=" + i5 + ", discount=" + i6 + ", discountCount=" + i7 + ", prizes=" + list + ", badges=" + list2 + ", isVehicle=" + this.isVehicle + ")";
    }

    public CasesModel(int i, String name, int i2, int i3, int i4, int i5, int i6, int i7, List<CasesPrizeModel> prizes, List<CasesBadgesModel> badges, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        Intrinsics.checkNotNullParameter(badges, "badges");
        this.id = i;
        this.name = name;
        this.image = i2;
        this.unix = i3;
        this.price = i4;
        this.currency = i5;
        this.discount = i6;
        this.discountCount = i7;
        this.prizes = prizes;
        this.badges = badges;
        this.isVehicle = num;
    }

    public /* synthetic */ CasesModel(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, List list, List list2, Integer num, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, i5, i6, i7, list, list2, (i8 & 1024) != 0 ? null : num);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getUnix() {
        return this.unix;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getCurrency() {
        return this.currency;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getDiscountCount() {
        return this.discountCount;
    }

    public final List<CasesPrizeModel> getPrizes() {
        return this.prizes;
    }

    public final List<CasesBadgesModel> getBadges() {
        return this.badges;
    }

    public final Integer isVehicle() {
        return this.isVehicle;
    }

    public final CasesSameCasesModel toModel() {
        int i = this.id;
        String str = this.name;
        return new CasesSameCasesModel(i, String.valueOf(this.image), str, this.price, this.currency, this.badges);
    }
}

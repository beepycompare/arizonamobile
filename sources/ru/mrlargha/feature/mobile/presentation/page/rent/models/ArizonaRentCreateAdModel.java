package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaRentCreateAdModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJV\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0007HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR)\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001a\u0010\u000eR)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001c\u0010\u000eR)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001e\u0010\u000e¨\u0006/"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentCreateAdModel;", "", "houseId", "", "cost", "", "desc", "", "from", TypedValues.TransitionType.S_TO, "realEstate", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHouseId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "houseID", "getCost", "()Ljava/lang/Long;", "Ljava/lang/Long;", "rentPrice", "getDesc", "()Ljava/lang/String;", "rentDescription", "getFrom", "valueStart", "getTo", "valueEnd", "getRealEstate", "rentType", "checkAllIsReady", "", "allIsNull", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentCreateAdModel;", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentCreateAdModel {
    @SerializedName("rentPrice")
    private final Long cost;
    @SerializedName("rentDescription")
    private final String desc;
    @SerializedName("valueStart")
    private final Integer from;
    @SerializedName("houseID")
    private final Integer houseId;
    @SerializedName("rentType")
    private final Integer realEstate;
    @SerializedName("valueEnd")
    private final Integer to;

    public ArizonaRentCreateAdModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ArizonaRentCreateAdModel copy$default(ArizonaRentCreateAdModel arizonaRentCreateAdModel, Integer num, Long l, String str, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = arizonaRentCreateAdModel.houseId;
        }
        if ((i & 2) != 0) {
            l = arizonaRentCreateAdModel.cost;
        }
        if ((i & 4) != 0) {
            str = arizonaRentCreateAdModel.desc;
        }
        if ((i & 8) != 0) {
            num2 = arizonaRentCreateAdModel.from;
        }
        if ((i & 16) != 0) {
            num3 = arizonaRentCreateAdModel.to;
        }
        if ((i & 32) != 0) {
            num4 = arizonaRentCreateAdModel.realEstate;
        }
        Integer num5 = num3;
        Integer num6 = num4;
        return arizonaRentCreateAdModel.copy(num, l, str, num2, num5, num6);
    }

    public final Integer component1() {
        return this.houseId;
    }

    public final Long component2() {
        return this.cost;
    }

    public final String component3() {
        return this.desc;
    }

    public final Integer component4() {
        return this.from;
    }

    public final Integer component5() {
        return this.to;
    }

    public final Integer component6() {
        return this.realEstate;
    }

    public final ArizonaRentCreateAdModel copy(Integer num, Long l, String str, Integer num2, Integer num3, Integer num4) {
        return new ArizonaRentCreateAdModel(num, l, str, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentCreateAdModel) {
            ArizonaRentCreateAdModel arizonaRentCreateAdModel = (ArizonaRentCreateAdModel) obj;
            return Intrinsics.areEqual(this.houseId, arizonaRentCreateAdModel.houseId) && Intrinsics.areEqual(this.cost, arizonaRentCreateAdModel.cost) && Intrinsics.areEqual(this.desc, arizonaRentCreateAdModel.desc) && Intrinsics.areEqual(this.from, arizonaRentCreateAdModel.from) && Intrinsics.areEqual(this.to, arizonaRentCreateAdModel.to) && Intrinsics.areEqual(this.realEstate, arizonaRentCreateAdModel.realEstate);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.houseId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.cost;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.desc;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.from;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.to;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.realEstate;
        return hashCode5 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.houseId;
        Long l = this.cost;
        String str = this.desc;
        Integer num2 = this.from;
        Integer num3 = this.to;
        return "ArizonaRentCreateAdModel(houseId=" + num + ", cost=" + l + ", desc=" + str + ", from=" + num2 + ", to=" + num3 + ", realEstate=" + this.realEstate + ")";
    }

    public ArizonaRentCreateAdModel(Integer num, Long l, String str, Integer num2, Integer num3, Integer num4) {
        this.houseId = num;
        this.cost = l;
        this.desc = str;
        this.from = num2;
        this.to = num3;
        this.realEstate = num4;
    }

    public /* synthetic */ ArizonaRentCreateAdModel(Integer num, Long l, String str, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4);
    }

    public final Integer getHouseId() {
        return this.houseId;
    }

    public final Long getCost() {
        return this.cost;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getFrom() {
        return this.from;
    }

    public final Integer getTo() {
        return this.to;
    }

    public final Integer getRealEstate() {
        return this.realEstate;
    }

    public final boolean checkAllIsReady() {
        return (this.cost == null || this.desc == null || this.from == null || this.to == null || this.realEstate == null) ? false : true;
    }

    public final boolean allIsNull() {
        return this.cost == null && this.desc == null && this.from == null && this.to == null && this.realEstate == null;
    }
}

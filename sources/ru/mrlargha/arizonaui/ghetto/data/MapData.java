package ru.mrlargha.arizonaui.ghetto.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J \u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010B\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R'\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R'\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b(\u0012\b\b)\u0012\u0004\b\b(,¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001dR'\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b(\u0012\b\b)\u0012\u0004\b\b(/¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'¨\u0006C"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/MapData;", "", TtmlNode.ATTR_ID, "", "fraction_id", "money", "", "respects", "isUniq", "", "balance", "drugs", "respawn_fraction_id", "drugden", "businessName", "", "businessColor", "paydayMoney", "businessType", "<init>", "(IIJIZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()I", "getFraction_id", "getMoney", "()J", "getRespects", "()Z", "getBalance", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDrugs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRespawn_fraction_id", "getDrugden", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBusinessName", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "business_name", "getBusinessColor", "business_color", "getPaydayMoney", "getBusinessType", "type", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(IIJIZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lru/mrlargha/arizonaui/ghetto/data/MapData;", "equals", "other", "hashCode", "toString", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MapData {
    private final Long balance;
    @SerializedName("business_color")
    private final String businessColor;
    @SerializedName("business_name")
    private final String businessName;
    @SerializedName("type")
    private final String businessType;
    private final Boolean drugden;
    private final Integer drugs;
    private final int fraction_id;
    private final int id;
    private final boolean isUniq;
    private final long money;
    private final Long paydayMoney;
    private final Integer respawn_fraction_id;
    private final int respects;

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.businessName;
    }

    public final String component11() {
        return this.businessColor;
    }

    public final Long component12() {
        return this.paydayMoney;
    }

    public final String component13() {
        return this.businessType;
    }

    public final int component2() {
        return this.fraction_id;
    }

    public final long component3() {
        return this.money;
    }

    public final int component4() {
        return this.respects;
    }

    public final boolean component5() {
        return this.isUniq;
    }

    public final Long component6() {
        return this.balance;
    }

    public final Integer component7() {
        return this.drugs;
    }

    public final Integer component8() {
        return this.respawn_fraction_id;
    }

    public final Boolean component9() {
        return this.drugden;
    }

    public final MapData copy(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool, String str, String str2, Long l2, String str3) {
        return new MapData(i, i2, j, i3, z, l, num, num2, bool, str, str2, l2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapData) {
            MapData mapData = (MapData) obj;
            return this.id == mapData.id && this.fraction_id == mapData.fraction_id && this.money == mapData.money && this.respects == mapData.respects && this.isUniq == mapData.isUniq && Intrinsics.areEqual(this.balance, mapData.balance) && Intrinsics.areEqual(this.drugs, mapData.drugs) && Intrinsics.areEqual(this.respawn_fraction_id, mapData.respawn_fraction_id) && Intrinsics.areEqual(this.drugden, mapData.drugden) && Intrinsics.areEqual(this.businessName, mapData.businessName) && Intrinsics.areEqual(this.businessColor, mapData.businessColor) && Intrinsics.areEqual(this.paydayMoney, mapData.paydayMoney) && Intrinsics.areEqual(this.businessType, mapData.businessType);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.fraction_id)) * 31) + Long.hashCode(this.money)) * 31) + Integer.hashCode(this.respects)) * 31) + Boolean.hashCode(this.isUniq)) * 31;
        Long l = this.balance;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.drugs;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.respawn_fraction_id;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.drugden;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.businessName;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.businessColor;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.paydayMoney;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.businessType;
        return hashCode8 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.fraction_id;
        long j = this.money;
        int i3 = this.respects;
        boolean z = this.isUniq;
        Long l = this.balance;
        Integer num = this.drugs;
        Integer num2 = this.respawn_fraction_id;
        Boolean bool = this.drugden;
        String str = this.businessName;
        String str2 = this.businessColor;
        Long l2 = this.paydayMoney;
        return "MapData(id=" + i + ", fraction_id=" + i2 + ", money=" + j + ", respects=" + i3 + ", isUniq=" + z + ", balance=" + l + ", drugs=" + num + ", respawn_fraction_id=" + num2 + ", drugden=" + bool + ", businessName=" + str + ", businessColor=" + str2 + ", paydayMoney=" + l2 + ", businessType=" + this.businessType + ")";
    }

    public MapData(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool, String str, String str2, Long l2, String str3) {
        this.id = i;
        this.fraction_id = i2;
        this.money = j;
        this.respects = i3;
        this.isUniq = z;
        this.balance = l;
        this.drugs = num;
        this.respawn_fraction_id = num2;
        this.drugden = bool;
        this.businessName = str;
        this.businessColor = str2;
        this.paydayMoney = l2;
        this.businessType = str3;
    }

    public /* synthetic */ MapData(int i, int i2, long j, int i3, boolean z, Long l, Integer num, Integer num2, Boolean bool, String str, String str2, Long l2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        MapData mapData;
        int i5;
        int i6;
        long j2;
        int i7;
        Long l3;
        Integer num3;
        Integer num4;
        Boolean bool2;
        boolean z2 = (i4 & 16) != 0 ? false : z;
        String str5 = (i4 & 512) != 0 ? null : str;
        String str6 = (i4 & 1024) != 0 ? null : str2;
        Long l4 = (i4 & 2048) != 0 ? null : l2;
        if ((i4 & 4096) != 0) {
            str4 = null;
            i5 = i;
            i6 = i2;
            j2 = j;
            i7 = i3;
            l3 = l;
            num3 = num;
            num4 = num2;
            bool2 = bool;
            mapData = this;
        } else {
            str4 = str3;
            mapData = this;
            i5 = i;
            i6 = i2;
            j2 = j;
            i7 = i3;
            l3 = l;
            num3 = num;
            num4 = num2;
            bool2 = bool;
        }
        new MapData(i5, i6, j2, i7, z2, l3, num3, num4, bool2, str5, str6, l4, str4);
    }

    public final int getId() {
        return this.id;
    }

    public final int getFraction_id() {
        return this.fraction_id;
    }

    public final long getMoney() {
        return this.money;
    }

    public final int getRespects() {
        return this.respects;
    }

    public final boolean isUniq() {
        return this.isUniq;
    }

    public final Long getBalance() {
        return this.balance;
    }

    public final Integer getDrugs() {
        return this.drugs;
    }

    public final Integer getRespawn_fraction_id() {
        return this.respawn_fraction_id;
    }

    public final Boolean getDrugden() {
        return this.drugden;
    }

    public final String getBusinessName() {
        return this.businessName;
    }

    public final String getBusinessColor() {
        return this.businessColor;
    }

    public final Long getPaydayMoney() {
        return this.paydayMoney;
    }

    public final String getBusinessType() {
        return this.businessType;
    }
}

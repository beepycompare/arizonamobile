package ru.mrlargha.arizonaui.ghetto.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: frame.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ¦\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00105J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001d¨\u0006;"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "", "territoryId", "", TtmlNode.ATTR_ID, "owner", "", "logo", "money", "", "resp", "drugs", "plant", "balance", "uniq", "businessName", "businessColor", "paydayMoney", "<init>", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getTerritoryId", "()I", "getId", "getOwner", "()Ljava/lang/String;", "getLogo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMoney", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResp", "getDrugs", "getPlant", "getBalance", "getUniq", "getBusinessName", "getBusinessColor", "getPaydayMoney", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "equals", "", "other", "hashCode", "toString", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrameMapData {
    private final Long balance;
    private final String businessColor;
    private final String businessName;
    private final Integer drugs;
    private final int id;
    private final Integer logo;
    private final Long money;
    private final String owner;
    private final Long paydayMoney;
    private final Integer plant;
    private final Integer resp;
    private final int territoryId;
    private final String uniq;

    public static /* synthetic */ FrameMapData copy$default(FrameMapData frameMapData, int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Integer num4, Long l2, String str2, String str3, String str4, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frameMapData.territoryId;
        }
        return frameMapData.copy(i, (i3 & 2) != 0 ? frameMapData.id : i2, (i3 & 4) != 0 ? frameMapData.owner : str, (i3 & 8) != 0 ? frameMapData.logo : num, (i3 & 16) != 0 ? frameMapData.money : l, (i3 & 32) != 0 ? frameMapData.resp : num2, (i3 & 64) != 0 ? frameMapData.drugs : num3, (i3 & 128) != 0 ? frameMapData.plant : num4, (i3 & 256) != 0 ? frameMapData.balance : l2, (i3 & 512) != 0 ? frameMapData.uniq : str2, (i3 & 1024) != 0 ? frameMapData.businessName : str3, (i3 & 2048) != 0 ? frameMapData.businessColor : str4, (i3 & 4096) != 0 ? frameMapData.paydayMoney : l3);
    }

    public final int component1() {
        return this.territoryId;
    }

    public final String component10() {
        return this.uniq;
    }

    public final String component11() {
        return this.businessName;
    }

    public final String component12() {
        return this.businessColor;
    }

    public final Long component13() {
        return this.paydayMoney;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.owner;
    }

    public final Integer component4() {
        return this.logo;
    }

    public final Long component5() {
        return this.money;
    }

    public final Integer component6() {
        return this.resp;
    }

    public final Integer component7() {
        return this.drugs;
    }

    public final Integer component8() {
        return this.plant;
    }

    public final Long component9() {
        return this.balance;
    }

    public final FrameMapData copy(int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Integer num4, Long l2, String str2, String str3, String str4, Long l3) {
        return new FrameMapData(i, i2, str, num, l, num2, num3, num4, l2, str2, str3, str4, l3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FrameMapData) {
            FrameMapData frameMapData = (FrameMapData) obj;
            return this.territoryId == frameMapData.territoryId && this.id == frameMapData.id && Intrinsics.areEqual(this.owner, frameMapData.owner) && Intrinsics.areEqual(this.logo, frameMapData.logo) && Intrinsics.areEqual(this.money, frameMapData.money) && Intrinsics.areEqual(this.resp, frameMapData.resp) && Intrinsics.areEqual(this.drugs, frameMapData.drugs) && Intrinsics.areEqual(this.plant, frameMapData.plant) && Intrinsics.areEqual(this.balance, frameMapData.balance) && Intrinsics.areEqual(this.uniq, frameMapData.uniq) && Intrinsics.areEqual(this.businessName, frameMapData.businessName) && Intrinsics.areEqual(this.businessColor, frameMapData.businessColor) && Intrinsics.areEqual(this.paydayMoney, frameMapData.paydayMoney);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.territoryId) * 31) + Integer.hashCode(this.id)) * 31;
        String str = this.owner;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.logo;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.money;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.resp;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.drugs;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.plant;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l2 = this.balance;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.uniq;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.businessName;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.businessColor;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l3 = this.paydayMoney;
        return hashCode11 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        int i = this.territoryId;
        int i2 = this.id;
        String str = this.owner;
        Integer num = this.logo;
        Long l = this.money;
        Integer num2 = this.resp;
        Integer num3 = this.drugs;
        Integer num4 = this.plant;
        Long l2 = this.balance;
        String str2 = this.uniq;
        String str3 = this.businessName;
        String str4 = this.businessColor;
        return "FrameMapData(territoryId=" + i + ", id=" + i2 + ", owner=" + str + ", logo=" + num + ", money=" + l + ", resp=" + num2 + ", drugs=" + num3 + ", plant=" + num4 + ", balance=" + l2 + ", uniq=" + str2 + ", businessName=" + str3 + ", businessColor=" + str4 + ", paydayMoney=" + this.paydayMoney + ")";
    }

    public FrameMapData(int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Integer num4, Long l2, String str2, String str3, String str4, Long l3) {
        this.territoryId = i;
        this.id = i2;
        this.owner = str;
        this.logo = num;
        this.money = l;
        this.resp = num2;
        this.drugs = num3;
        this.plant = num4;
        this.balance = l2;
        this.uniq = str2;
        this.businessName = str3;
        this.businessColor = str4;
        this.paydayMoney = l3;
    }

    public /* synthetic */ FrameMapData(int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Integer num4, Long l2, String str2, String str3, String str4, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, num, l, num2, num3, num4, l2, str2, (i3 & 1024) != 0 ? null : str3, (i3 & 2048) != 0 ? null : str4, (i3 & 4096) != 0 ? null : l3);
    }

    public final int getTerritoryId() {
        return this.territoryId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final Integer getLogo() {
        return this.logo;
    }

    public final Long getMoney() {
        return this.money;
    }

    public final Integer getResp() {
        return this.resp;
    }

    public final Integer getDrugs() {
        return this.drugs;
    }

    public final Integer getPlant() {
        return this.plant;
    }

    public final Long getBalance() {
        return this.balance;
    }

    public final String getUniq() {
        return this.uniq;
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
}

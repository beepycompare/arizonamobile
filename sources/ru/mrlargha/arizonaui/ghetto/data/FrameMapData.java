package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: frame.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jv\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006/"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "", "territoryId", "", "id", "owner", "", "logo", "money", "", "resp", "plant", "balance", "uniq", "<init>", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "getTerritoryId", "()I", "getId", "getOwner", "()Ljava/lang/String;", "getLogo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMoney", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResp", "getPlant", "getBalance", "getUniq", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "equals", "", "other", "hashCode", "toString", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrameMapData {
    private final Long balance;
    private final int id;
    private final Integer logo;
    private final Long money;
    private final String owner;
    private final Integer plant;
    private final Integer resp;
    private final int territoryId;
    private final String uniq;

    public static /* synthetic */ FrameMapData copy$default(FrameMapData frameMapData, int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Long l2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frameMapData.territoryId;
        }
        if ((i3 & 2) != 0) {
            i2 = frameMapData.id;
        }
        if ((i3 & 4) != 0) {
            str = frameMapData.owner;
        }
        if ((i3 & 8) != 0) {
            num = frameMapData.logo;
        }
        if ((i3 & 16) != 0) {
            l = frameMapData.money;
        }
        if ((i3 & 32) != 0) {
            num2 = frameMapData.resp;
        }
        if ((i3 & 64) != 0) {
            num3 = frameMapData.plant;
        }
        if ((i3 & 128) != 0) {
            l2 = frameMapData.balance;
        }
        if ((i3 & 256) != 0) {
            str2 = frameMapData.uniq;
        }
        Long l3 = l2;
        String str3 = str2;
        Integer num4 = num2;
        Integer num5 = num3;
        Long l4 = l;
        String str4 = str;
        return frameMapData.copy(i, i2, str4, num, l4, num4, num5, l3, str3);
    }

    public final int component1() {
        return this.territoryId;
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
        return this.plant;
    }

    public final Long component8() {
        return this.balance;
    }

    public final String component9() {
        return this.uniq;
    }

    public final FrameMapData copy(int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Long l2, String str2) {
        return new FrameMapData(i, i2, str, num, l, num2, num3, l2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FrameMapData) {
            FrameMapData frameMapData = (FrameMapData) obj;
            return this.territoryId == frameMapData.territoryId && this.id == frameMapData.id && Intrinsics.areEqual(this.owner, frameMapData.owner) && Intrinsics.areEqual(this.logo, frameMapData.logo) && Intrinsics.areEqual(this.money, frameMapData.money) && Intrinsics.areEqual(this.resp, frameMapData.resp) && Intrinsics.areEqual(this.plant, frameMapData.plant) && Intrinsics.areEqual(this.balance, frameMapData.balance) && Intrinsics.areEqual(this.uniq, frameMapData.uniq);
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
        Integer num3 = this.plant;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l2 = this.balance;
        int hashCode7 = (hashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.uniq;
        return hashCode7 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        int i = this.territoryId;
        int i2 = this.id;
        String str = this.owner;
        Integer num = this.logo;
        Long l = this.money;
        Integer num2 = this.resp;
        Integer num3 = this.plant;
        Long l2 = this.balance;
        return "FrameMapData(territoryId=" + i + ", id=" + i2 + ", owner=" + str + ", logo=" + num + ", money=" + l + ", resp=" + num2 + ", plant=" + num3 + ", balance=" + l2 + ", uniq=" + this.uniq + ")";
    }

    public FrameMapData(int i, int i2, String str, Integer num, Long l, Integer num2, Integer num3, Long l2, String str2) {
        this.territoryId = i;
        this.id = i2;
        this.owner = str;
        this.logo = num;
        this.money = l;
        this.resp = num2;
        this.plant = num3;
        this.balance = l2;
        this.uniq = str2;
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

    public final Integer getPlant() {
        return this.plant;
    }

    public final Long getBalance() {
        return this.balance;
    }

    public final String getUniq() {
        return this.uniq;
    }
}

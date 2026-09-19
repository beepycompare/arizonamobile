package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003Jb\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\bHÖ\u0081\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R)\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R)\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR-\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStateDto;", "", "totalMoney", "", "maxMoney", "unixEndSeason", "", "currentLevel", "", "prizes", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStatusDto;", "rewards", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassRewardDto;", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getTotalMoney", "()Ljava/lang/Double;", "Ljava/lang/Double;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMaxMoney", "getUnixEndSeason", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrentLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrizes", "()Ljava/util/List;", "getRewards", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassStateDto;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class DonatePayPassStateDto {
    @SerializedName("currentLevel")
    private final Integer currentLevel;
    @SerializedName("maxMoney")
    private final Double maxMoney;
    @SerializedName("prizes")
    private final List<DonatePayPassStatusDto> prizes;
    @SerializedName("rewards")
    private final List<DonatePayPassRewardDto> rewards;
    @SerializedName("totalMoney")
    private final Double totalMoney;
    @SerializedName("unixEndSeason")
    private final Long unixEndSeason;

    public DonatePayPassStateDto() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DonatePayPassStateDto copy$default(DonatePayPassStateDto donatePayPassStateDto, Double d, Double d2, Long l, Integer num, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = donatePayPassStateDto.totalMoney;
        }
        if ((i & 2) != 0) {
            d2 = donatePayPassStateDto.maxMoney;
        }
        if ((i & 4) != 0) {
            l = donatePayPassStateDto.unixEndSeason;
        }
        if ((i & 8) != 0) {
            num = donatePayPassStateDto.currentLevel;
        }
        List<DonatePayPassStatusDto> list3 = list;
        if ((i & 16) != 0) {
            list3 = donatePayPassStateDto.prizes;
        }
        List<DonatePayPassRewardDto> list4 = list2;
        if ((i & 32) != 0) {
            list4 = donatePayPassStateDto.rewards;
        }
        List list5 = list3;
        List list6 = list4;
        return donatePayPassStateDto.copy(d, d2, l, num, list5, list6);
    }

    public final Double component1() {
        return this.totalMoney;
    }

    public final Double component2() {
        return this.maxMoney;
    }

    public final Long component3() {
        return this.unixEndSeason;
    }

    public final Integer component4() {
        return this.currentLevel;
    }

    public final List<DonatePayPassStatusDto> component5() {
        return this.prizes;
    }

    public final List<DonatePayPassRewardDto> component6() {
        return this.rewards;
    }

    public final DonatePayPassStateDto copy(Double d, Double d2, Long l, Integer num, List<DonatePayPassStatusDto> list, List<DonatePayPassRewardDto> list2) {
        return new DonatePayPassStateDto(d, d2, l, num, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassStateDto) {
            DonatePayPassStateDto donatePayPassStateDto = (DonatePayPassStateDto) obj;
            return Intrinsics.areEqual((Object) this.totalMoney, (Object) donatePayPassStateDto.totalMoney) && Intrinsics.areEqual((Object) this.maxMoney, (Object) donatePayPassStateDto.maxMoney) && Intrinsics.areEqual(this.unixEndSeason, donatePayPassStateDto.unixEndSeason) && Intrinsics.areEqual(this.currentLevel, donatePayPassStateDto.currentLevel) && Intrinsics.areEqual(this.prizes, donatePayPassStateDto.prizes) && Intrinsics.areEqual(this.rewards, donatePayPassStateDto.rewards);
        }
        return false;
    }

    public int hashCode() {
        Double d = this.totalMoney;
        int hashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.maxMoney;
        int hashCode2 = (hashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Long l = this.unixEndSeason;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.currentLevel;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        List<DonatePayPassStatusDto> list = this.prizes;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<DonatePayPassRewardDto> list2 = this.rewards;
        return hashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        Double d = this.totalMoney;
        Double d2 = this.maxMoney;
        Long l = this.unixEndSeason;
        Integer num = this.currentLevel;
        List<DonatePayPassStatusDto> list = this.prizes;
        return "DonatePayPassStateDto(totalMoney=" + d + ", maxMoney=" + d2 + ", unixEndSeason=" + l + ", currentLevel=" + num + ", prizes=" + list + ", rewards=" + this.rewards + ")";
    }

    public DonatePayPassStateDto(Double d, Double d2, Long l, Integer num, List<DonatePayPassStatusDto> list, List<DonatePayPassRewardDto> list2) {
        this.totalMoney = d;
        this.maxMoney = d2;
        this.unixEndSeason = l;
        this.currentLevel = num;
        this.prizes = list;
        this.rewards = list2;
    }

    public /* synthetic */ DonatePayPassStateDto(Double d, Double d2, Long l, Integer num, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2);
    }

    public final Double getTotalMoney() {
        return this.totalMoney;
    }

    public final Double getMaxMoney() {
        return this.maxMoney;
    }

    public final Long getUnixEndSeason() {
        return this.unixEndSeason;
    }

    public final Integer getCurrentLevel() {
        return this.currentLevel;
    }

    public final List<DonatePayPassStatusDto> getPrizes() {
        return this.prizes;
    }

    public final List<DonatePayPassRewardDto> getRewards() {
        return this.rewards;
    }
}

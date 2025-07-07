package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0015\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000fHÆ\u0003J\u0083\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000fHÆ\u0001J\u0013\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0016R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/MainBattlePassInfo;", "", "type", "", FirebaseAnalytics.Param.LEVEL, "exp", "maxExp", "premium", "passCoins", "azCoins", "timestampTaskTime", "", "timestampMissionTime", "passCoinCurseAzCoins", "availableToReceive", "", "<init>", "(IIIIIIIJJILjava/util/List;)V", "getType", "()I", "getLevel", "setLevel", "(I)V", "getExp", "setExp", "getMaxExp", "setMaxExp", "getPremium", "setPremium", "getPassCoins", "setPassCoins", "getAzCoins", "setAzCoins", "getTimestampTaskTime", "()J", "getTimestampMissionTime", "getPassCoinCurseAzCoins", "setPassCoinCurseAzCoins", "getAvailableToReceive", "()Ljava/util/List;", "isPremium", "", "isNewcomer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainBattlePassInfo {
    private final List<List<Integer>> availableToReceive;
    private int azCoins;
    private int exp;
    private int level;
    private int maxExp;
    private int passCoinCurseAzCoins;
    private int passCoins;
    private int premium;
    private final long timestampMissionTime;
    private final long timestampTaskTime;
    private final int type;

    public static /* synthetic */ MainBattlePassInfo copy$default(MainBattlePassInfo mainBattlePassInfo, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, int i8, List list, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = mainBattlePassInfo.type;
        }
        return mainBattlePassInfo.copy(i, (i9 & 2) != 0 ? mainBattlePassInfo.level : i2, (i9 & 4) != 0 ? mainBattlePassInfo.exp : i3, (i9 & 8) != 0 ? mainBattlePassInfo.maxExp : i4, (i9 & 16) != 0 ? mainBattlePassInfo.premium : i5, (i9 & 32) != 0 ? mainBattlePassInfo.passCoins : i6, (i9 & 64) != 0 ? mainBattlePassInfo.azCoins : i7, (i9 & 128) != 0 ? mainBattlePassInfo.timestampTaskTime : j, (i9 & 256) != 0 ? mainBattlePassInfo.timestampMissionTime : j2, (i9 & 512) != 0 ? mainBattlePassInfo.passCoinCurseAzCoins : i8, (i9 & 1024) != 0 ? mainBattlePassInfo.availableToReceive : list);
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.passCoinCurseAzCoins;
    }

    public final List<List<Integer>> component11() {
        return this.availableToReceive;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.exp;
    }

    public final int component4() {
        return this.maxExp;
    }

    public final int component5() {
        return this.premium;
    }

    public final int component6() {
        return this.passCoins;
    }

    public final int component7() {
        return this.azCoins;
    }

    public final long component8() {
        return this.timestampTaskTime;
    }

    public final long component9() {
        return this.timestampMissionTime;
    }

    public final MainBattlePassInfo copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, int i8, List<? extends List<Integer>> availableToReceive) {
        Intrinsics.checkNotNullParameter(availableToReceive, "availableToReceive");
        return new MainBattlePassInfo(i, i2, i3, i4, i5, i6, i7, j, j2, i8, availableToReceive);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainBattlePassInfo) {
            MainBattlePassInfo mainBattlePassInfo = (MainBattlePassInfo) obj;
            return this.type == mainBattlePassInfo.type && this.level == mainBattlePassInfo.level && this.exp == mainBattlePassInfo.exp && this.maxExp == mainBattlePassInfo.maxExp && this.premium == mainBattlePassInfo.premium && this.passCoins == mainBattlePassInfo.passCoins && this.azCoins == mainBattlePassInfo.azCoins && this.timestampTaskTime == mainBattlePassInfo.timestampTaskTime && this.timestampMissionTime == mainBattlePassInfo.timestampMissionTime && this.passCoinCurseAzCoins == mainBattlePassInfo.passCoinCurseAzCoins && Intrinsics.areEqual(this.availableToReceive, mainBattlePassInfo.availableToReceive);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.exp)) * 31) + Integer.hashCode(this.maxExp)) * 31) + Integer.hashCode(this.premium)) * 31) + Integer.hashCode(this.passCoins)) * 31) + Integer.hashCode(this.azCoins)) * 31) + Long.hashCode(this.timestampTaskTime)) * 31) + Long.hashCode(this.timestampMissionTime)) * 31) + Integer.hashCode(this.passCoinCurseAzCoins)) * 31) + this.availableToReceive.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.level;
        int i3 = this.exp;
        int i4 = this.maxExp;
        int i5 = this.premium;
        int i6 = this.passCoins;
        int i7 = this.azCoins;
        long j = this.timestampTaskTime;
        long j2 = this.timestampMissionTime;
        int i8 = this.passCoinCurseAzCoins;
        return "MainBattlePassInfo(type=" + i + ", level=" + i2 + ", exp=" + i3 + ", maxExp=" + i4 + ", premium=" + i5 + ", passCoins=" + i6 + ", azCoins=" + i7 + ", timestampTaskTime=" + j + ", timestampMissionTime=" + j2 + ", passCoinCurseAzCoins=" + i8 + ", availableToReceive=" + this.availableToReceive + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MainBattlePassInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, int i8, List<? extends List<Integer>> availableToReceive) {
        Intrinsics.checkNotNullParameter(availableToReceive, "availableToReceive");
        this.type = i;
        this.level = i2;
        this.exp = i3;
        this.maxExp = i4;
        this.premium = i5;
        this.passCoins = i6;
        this.azCoins = i7;
        this.timestampTaskTime = j;
        this.timestampMissionTime = j2;
        this.passCoinCurseAzCoins = i8;
        this.availableToReceive = availableToReceive;
    }

    public final int getType() {
        return this.type;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final int getExp() {
        return this.exp;
    }

    public final void setExp(int i) {
        this.exp = i;
    }

    public final int getMaxExp() {
        return this.maxExp;
    }

    public final void setMaxExp(int i) {
        this.maxExp = i;
    }

    public final int getPremium() {
        return this.premium;
    }

    public final void setPremium(int i) {
        this.premium = i;
    }

    public final int getPassCoins() {
        return this.passCoins;
    }

    public final void setPassCoins(int i) {
        this.passCoins = i;
    }

    public final int getAzCoins() {
        return this.azCoins;
    }

    public final void setAzCoins(int i) {
        this.azCoins = i;
    }

    public final long getTimestampTaskTime() {
        return this.timestampTaskTime;
    }

    public final long getTimestampMissionTime() {
        return this.timestampMissionTime;
    }

    public final int getPassCoinCurseAzCoins() {
        return this.passCoinCurseAzCoins;
    }

    public final void setPassCoinCurseAzCoins(int i) {
        this.passCoinCurseAzCoins = i;
    }

    public final List<List<Integer>> getAvailableToReceive() {
        return this.availableToReceive;
    }

    public final boolean isPremium() {
        return this.premium > 0;
    }

    public final boolean isNewcomer() {
        return this.type == 0;
    }
}

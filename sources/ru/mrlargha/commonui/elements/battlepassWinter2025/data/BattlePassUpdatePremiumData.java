package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: BattlePassUpdatePremiumData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassUpdatePremiumData;", "", "premium", "", "azCoins", "<init>", "(II)V", "getPremium", "()I", "getAzCoins", "isPremium", "", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BattlePassUpdatePremiumData {
    @SerializedName("az_coins")
    private final int azCoins;
    @SerializedName("premium")
    private final int premium;

    public static /* synthetic */ BattlePassUpdatePremiumData copy$default(BattlePassUpdatePremiumData battlePassUpdatePremiumData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = battlePassUpdatePremiumData.premium;
        }
        if ((i3 & 2) != 0) {
            i2 = battlePassUpdatePremiumData.azCoins;
        }
        return battlePassUpdatePremiumData.copy(i, i2);
    }

    public final int component1() {
        return this.premium;
    }

    public final int component2() {
        return this.azCoins;
    }

    public final BattlePassUpdatePremiumData copy(int i, int i2) {
        return new BattlePassUpdatePremiumData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassUpdatePremiumData) {
            BattlePassUpdatePremiumData battlePassUpdatePremiumData = (BattlePassUpdatePremiumData) obj;
            return this.premium == battlePassUpdatePremiumData.premium && this.azCoins == battlePassUpdatePremiumData.azCoins;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.premium) * 31) + Integer.hashCode(this.azCoins);
    }

    public String toString() {
        int i = this.premium;
        return "BattlePassUpdatePremiumData(premium=" + i + ", azCoins=" + this.azCoins + ")";
    }

    public BattlePassUpdatePremiumData(int i, int i2) {
        this.premium = i;
        this.azCoins = i2;
    }

    public final int getPremium() {
        return this.premium;
    }

    public final int getAzCoins() {
        return this.azCoins;
    }

    public final boolean isPremium() {
        return this.premium == 1;
    }
}

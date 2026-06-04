package ru.mrlargha.feature.battlepassWinter2025.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: BattlePassUpdateCoinsData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassUpdateCoinsData;", "", "passCoins", "", "azCoins", "<init>", "(II)V", "getPassCoins", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "pass_coins", "getAzCoins", "az_coins", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassUpdateCoinsData {
    @SerializedName("az_coins")
    private final int azCoins;
    @SerializedName("pass_coins")
    private final int passCoins;

    public static /* synthetic */ BattlePassUpdateCoinsData copy$default(BattlePassUpdateCoinsData battlePassUpdateCoinsData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = battlePassUpdateCoinsData.passCoins;
        }
        if ((i3 & 2) != 0) {
            i2 = battlePassUpdateCoinsData.azCoins;
        }
        return battlePassUpdateCoinsData.copy(i, i2);
    }

    public final int component1() {
        return this.passCoins;
    }

    public final int component2() {
        return this.azCoins;
    }

    public final BattlePassUpdateCoinsData copy(int i, int i2) {
        return new BattlePassUpdateCoinsData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassUpdateCoinsData) {
            BattlePassUpdateCoinsData battlePassUpdateCoinsData = (BattlePassUpdateCoinsData) obj;
            return this.passCoins == battlePassUpdateCoinsData.passCoins && this.azCoins == battlePassUpdateCoinsData.azCoins;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.passCoins) * 31) + Integer.hashCode(this.azCoins);
    }

    public String toString() {
        int i = this.passCoins;
        return "BattlePassUpdateCoinsData(passCoins=" + i + ", azCoins=" + this.azCoins + ")";
    }

    public BattlePassUpdateCoinsData(int i, int i2) {
        this.passCoins = i;
        this.azCoins = i2;
    }

    public final int getPassCoins() {
        return this.passCoins;
    }

    public final int getAzCoins() {
        return this.azCoins;
    }
}

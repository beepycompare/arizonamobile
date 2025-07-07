package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: BattlePassPremiumData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassPremiumData;", "", FirebaseAnalytics.Param.PRICE, "", FirebaseAnalytics.Param.DISCOUNT, "<init>", "(II)V", "getPrice", "()I", "getDiscount", "priceWithDiscount", "getPriceWithDiscount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BattlePassPremiumData {
    private final int discount;
    private final int price;

    public static /* synthetic */ BattlePassPremiumData copy$default(BattlePassPremiumData battlePassPremiumData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = battlePassPremiumData.price;
        }
        if ((i3 & 2) != 0) {
            i2 = battlePassPremiumData.discount;
        }
        return battlePassPremiumData.copy(i, i2);
    }

    public final int component1() {
        return this.price;
    }

    public final int component2() {
        return this.discount;
    }

    public final BattlePassPremiumData copy(int i, int i2) {
        return new BattlePassPremiumData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassPremiumData) {
            BattlePassPremiumData battlePassPremiumData = (BattlePassPremiumData) obj;
            return this.price == battlePassPremiumData.price && this.discount == battlePassPremiumData.discount;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.price) * 31) + Integer.hashCode(this.discount);
    }

    public String toString() {
        int i = this.price;
        return "BattlePassPremiumData(price=" + i + ", discount=" + this.discount + ")";
    }

    public BattlePassPremiumData(int i, int i2) {
        this.price = i;
        this.discount = i2;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getPriceWithDiscount() {
        int i = this.price;
        return i - ((this.discount * i) / 100);
    }
}

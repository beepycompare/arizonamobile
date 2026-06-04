package ru.mrlargha.feature.battlepassWinter2025.data;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: BattlePassPremiumData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassPremiumData;", "", FirebaseAnalytics.Param.PRICE, "", FirebaseAnalytics.Param.DISCOUNT, NotificationCompat.CATEGORY_STATUS, "<init>", "(III)V", "getPrice", "()I", "getDiscount", "getStatus", "priceWithDiscount", "getPriceWithDiscount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassPremiumData {
    private final int discount;
    private final int price;
    private final int status;

    public static /* synthetic */ BattlePassPremiumData copy$default(BattlePassPremiumData battlePassPremiumData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = battlePassPremiumData.price;
        }
        if ((i4 & 2) != 0) {
            i2 = battlePassPremiumData.discount;
        }
        if ((i4 & 4) != 0) {
            i3 = battlePassPremiumData.status;
        }
        return battlePassPremiumData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.price;
    }

    public final int component2() {
        return this.discount;
    }

    public final int component3() {
        return this.status;
    }

    public final BattlePassPremiumData copy(int i, int i2, int i3) {
        return new BattlePassPremiumData(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassPremiumData) {
            BattlePassPremiumData battlePassPremiumData = (BattlePassPremiumData) obj;
            return this.price == battlePassPremiumData.price && this.discount == battlePassPremiumData.discount && this.status == battlePassPremiumData.status;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.price) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        int i = this.price;
        int i2 = this.discount;
        return "BattlePassPremiumData(price=" + i + ", discount=" + i2 + ", status=" + this.status + ")";
    }

    public BattlePassPremiumData(int i, int i2, int i3) {
        this.price = i;
        this.discount = i2;
        this.status = i3;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getPriceWithDiscount() {
        int i = this.price;
        return i - ((this.discount * i) / 100);
    }
}

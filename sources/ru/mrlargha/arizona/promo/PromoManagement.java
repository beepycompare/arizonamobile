package ru.mrlargha.arizona.promo;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Data.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0002"}, d2 = {"Lru/mrlargha/arizona/promo/PromoManagement;", "", NotificationCompat.CATEGORY_PROMO, "", "currentLvl", "", "maxLvl", "position", "coins", "activations", "currentRewards", "", "Lru/mrlargha/arizona/promo/PromoReward;", "<init>", "(Ljava/lang/String;IIIIILjava/util/List;)V", "getPromo", "()Ljava/lang/String;", "getCurrentLvl", "()I", "getMaxLvl", "getPosition", "getCoins", "getActivations", "getCurrentRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoManagement {
    private final int activations;
    private final int coins;
    private final int currentLvl;
    private final List<PromoReward> currentRewards;
    private final int maxLvl;
    private final int position;
    private final String promo;

    public static /* synthetic */ PromoManagement copy$default(PromoManagement promoManagement, String str, int i, int i2, int i3, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = promoManagement.promo;
        }
        if ((i6 & 2) != 0) {
            i = promoManagement.currentLvl;
        }
        if ((i6 & 4) != 0) {
            i2 = promoManagement.maxLvl;
        }
        if ((i6 & 8) != 0) {
            i3 = promoManagement.position;
        }
        if ((i6 & 16) != 0) {
            i4 = promoManagement.coins;
        }
        if ((i6 & 32) != 0) {
            i5 = promoManagement.activations;
        }
        List<PromoReward> list2 = list;
        if ((i6 & 64) != 0) {
            list2 = promoManagement.currentRewards;
        }
        int i7 = i5;
        List list3 = list2;
        int i8 = i4;
        int i9 = i2;
        return promoManagement.copy(str, i, i9, i3, i8, i7, list3);
    }

    public final String component1() {
        return this.promo;
    }

    public final int component2() {
        return this.currentLvl;
    }

    public final int component3() {
        return this.maxLvl;
    }

    public final int component4() {
        return this.position;
    }

    public final int component5() {
        return this.coins;
    }

    public final int component6() {
        return this.activations;
    }

    public final List<PromoReward> component7() {
        return this.currentRewards;
    }

    public final PromoManagement copy(String promo, int i, int i2, int i3, int i4, int i5, List<PromoReward> currentRewards) {
        Intrinsics.checkNotNullParameter(promo, "promo");
        Intrinsics.checkNotNullParameter(currentRewards, "currentRewards");
        return new PromoManagement(promo, i, i2, i3, i4, i5, currentRewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoManagement) {
            PromoManagement promoManagement = (PromoManagement) obj;
            return Intrinsics.areEqual(this.promo, promoManagement.promo) && this.currentLvl == promoManagement.currentLvl && this.maxLvl == promoManagement.maxLvl && this.position == promoManagement.position && this.coins == promoManagement.coins && this.activations == promoManagement.activations && Intrinsics.areEqual(this.currentRewards, promoManagement.currentRewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.promo.hashCode() * 31) + Integer.hashCode(this.currentLvl)) * 31) + Integer.hashCode(this.maxLvl)) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.coins)) * 31) + Integer.hashCode(this.activations)) * 31) + this.currentRewards.hashCode();
    }

    public String toString() {
        String str = this.promo;
        int i = this.currentLvl;
        int i2 = this.maxLvl;
        int i3 = this.position;
        int i4 = this.coins;
        int i5 = this.activations;
        return "PromoManagement(promo=" + str + ", currentLvl=" + i + ", maxLvl=" + i2 + ", position=" + i3 + ", coins=" + i4 + ", activations=" + i5 + ", currentRewards=" + this.currentRewards + ")";
    }

    public PromoManagement(String promo, int i, int i2, int i3, int i4, int i5, List<PromoReward> currentRewards) {
        Intrinsics.checkNotNullParameter(promo, "promo");
        Intrinsics.checkNotNullParameter(currentRewards, "currentRewards");
        this.promo = promo;
        this.currentLvl = i;
        this.maxLvl = i2;
        this.position = i3;
        this.coins = i4;
        this.activations = i5;
        this.currentRewards = currentRewards;
    }

    public final String getPromo() {
        return this.promo;
    }

    public final int getCurrentLvl() {
        return this.currentLvl;
    }

    public final int getMaxLvl() {
        return this.maxLvl;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getCoins() {
        return this.coins;
    }

    public final int getActivations() {
        return this.activations;
    }

    public final List<PromoReward> getCurrentRewards() {
        return this.currentRewards;
    }
}

package ru.mrlargha.arizona.promo;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Data.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizona/promo/ReferralResponse;", "", "name", "", "referralsValue", "", "cashBack", "", "referralsRewards", "", "Lru/mrlargha/arizona/promo/PromoReward;", "<init>", "(Ljava/lang/String;IJLjava/util/List;)V", "getName", "()Ljava/lang/String;", "getReferralsValue", "()I", "getCashBack", "()J", "getReferralsRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReferralResponse {
    private final long cashBack;
    private final String name;
    private final List<PromoReward> referralsRewards;
    private final int referralsValue;

    public static /* synthetic */ ReferralResponse copy$default(ReferralResponse referralResponse, String str, int i, long j, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = referralResponse.name;
        }
        if ((i2 & 2) != 0) {
            i = referralResponse.referralsValue;
        }
        if ((i2 & 4) != 0) {
            j = referralResponse.cashBack;
        }
        List<PromoReward> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = referralResponse.referralsRewards;
        }
        List list3 = list2;
        return referralResponse.copy(str, i, j, list3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.referralsValue;
    }

    public final long component3() {
        return this.cashBack;
    }

    public final List<PromoReward> component4() {
        return this.referralsRewards;
    }

    public final ReferralResponse copy(String name, int i, long j, List<PromoReward> referralsRewards) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(referralsRewards, "referralsRewards");
        return new ReferralResponse(name, i, j, referralsRewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReferralResponse) {
            ReferralResponse referralResponse = (ReferralResponse) obj;
            return Intrinsics.areEqual(this.name, referralResponse.name) && this.referralsValue == referralResponse.referralsValue && this.cashBack == referralResponse.cashBack && Intrinsics.areEqual(this.referralsRewards, referralResponse.referralsRewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + Integer.hashCode(this.referralsValue)) * 31) + Long.hashCode(this.cashBack)) * 31) + this.referralsRewards.hashCode();
    }

    public String toString() {
        String str = this.name;
        int i = this.referralsValue;
        long j = this.cashBack;
        return "ReferralResponse(name=" + str + ", referralsValue=" + i + ", cashBack=" + j + ", referralsRewards=" + this.referralsRewards + ")";
    }

    public ReferralResponse(String name, int i, long j, List<PromoReward> referralsRewards) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(referralsRewards, "referralsRewards");
        this.name = name;
        this.referralsValue = i;
        this.cashBack = j;
        this.referralsRewards = referralsRewards;
    }

    public final String getName() {
        return this.name;
    }

    public final int getReferralsValue() {
        return this.referralsValue;
    }

    public final long getCashBack() {
        return this.cashBack;
    }

    public final List<PromoReward> getReferralsRewards() {
        return this.referralsRewards;
    }
}

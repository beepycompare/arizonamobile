package ru.mrlargha.commonui.elements.donate.presentation.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "", TtmlNode.ATTR_ID, "", FirebaseAnalytics.Param.LEVEL, "status", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;", "prizes", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrize;", FirebaseAnalytics.Param.PRICE, "<init>", "(IILru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;Ljava/util/List;Ljava/lang/Integer;)V", "getId", "()I", "getLevel", "getStatus", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;", "getPrizes", "()Ljava/util/List;", "getPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "canClaim", "", "getCanClaim", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(IILru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;Ljava/util/List;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "equals", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassReward {
    private final int id;
    private final int level;
    private final Integer price;
    private final List<DonatePayPassPrize> prizes;
    private final DonatePayPassTierStatus status;

    public static /* synthetic */ DonatePayPassReward copy$default(DonatePayPassReward donatePayPassReward, int i, int i2, DonatePayPassTierStatus donatePayPassTierStatus, List list, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = donatePayPassReward.id;
        }
        if ((i3 & 2) != 0) {
            i2 = donatePayPassReward.level;
        }
        if ((i3 & 4) != 0) {
            donatePayPassTierStatus = donatePayPassReward.status;
        }
        List<DonatePayPassPrize> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = donatePayPassReward.prizes;
        }
        if ((i3 & 16) != 0) {
            num = donatePayPassReward.price;
        }
        Integer num2 = num;
        DonatePayPassTierStatus donatePayPassTierStatus2 = donatePayPassTierStatus;
        return donatePayPassReward.copy(i, i2, donatePayPassTierStatus2, list2, num2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.level;
    }

    public final DonatePayPassTierStatus component3() {
        return this.status;
    }

    public final List<DonatePayPassPrize> component4() {
        return this.prizes;
    }

    public final Integer component5() {
        return this.price;
    }

    public final DonatePayPassReward copy(int i, int i2, DonatePayPassTierStatus donatePayPassTierStatus, List<DonatePayPassPrize> prizes, Integer num) {
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        return new DonatePayPassReward(i, i2, donatePayPassTierStatus, prizes, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassReward) {
            DonatePayPassReward donatePayPassReward = (DonatePayPassReward) obj;
            return this.id == donatePayPassReward.id && this.level == donatePayPassReward.level && this.status == donatePayPassReward.status && Intrinsics.areEqual(this.prizes, donatePayPassReward.prizes) && Intrinsics.areEqual(this.price, donatePayPassReward.price);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.level)) * 31;
        DonatePayPassTierStatus donatePayPassTierStatus = this.status;
        int hashCode2 = (((hashCode + (donatePayPassTierStatus == null ? 0 : donatePayPassTierStatus.hashCode())) * 31) + this.prizes.hashCode()) * 31;
        Integer num = this.price;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.level;
        DonatePayPassTierStatus donatePayPassTierStatus = this.status;
        List<DonatePayPassPrize> list = this.prizes;
        return "DonatePayPassReward(id=" + i + ", level=" + i2 + ", status=" + donatePayPassTierStatus + ", prizes=" + list + ", price=" + this.price + ")";
    }

    public DonatePayPassReward(int i, int i2, DonatePayPassTierStatus donatePayPassTierStatus, List<DonatePayPassPrize> prizes, Integer num) {
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        this.id = i;
        this.level = i2;
        this.status = donatePayPassTierStatus;
        this.prizes = prizes;
        this.price = num;
    }

    public /* synthetic */ DonatePayPassReward(int i, int i2, DonatePayPassTierStatus donatePayPassTierStatus, List list, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, donatePayPassTierStatus, list, (i3 & 16) != 0 ? null : num);
    }

    public final int getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final DonatePayPassTierStatus getStatus() {
        return this.status;
    }

    public final List<DonatePayPassPrize> getPrizes() {
        return this.prizes;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final boolean getCanClaim() {
        return this.status == DonatePayPassTierStatus.AVAILABLE;
    }
}

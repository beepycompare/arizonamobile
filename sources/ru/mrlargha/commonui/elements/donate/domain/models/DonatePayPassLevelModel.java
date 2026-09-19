package ru.mrlargha.commonui.elements.donate.domain.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassLevelModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR-\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelModel;", "", TtmlNode.ATTR_ID, "", FirebaseAnalytics.Param.PRICE, "rewards", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelRewardModel;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getPrice", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lru/mrlargha/commonui/elements/donate/domain/models/DonatePayPassLevelModel;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassLevelModel {
    @SerializedName(TtmlNode.ATTR_ID)
    private final Integer id;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final Integer price;
    @SerializedName("rewards")
    private final List<DonatePayPassLevelRewardModel> rewards;

    public DonatePayPassLevelModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonatePayPassLevelModel copy$default(DonatePayPassLevelModel donatePayPassLevelModel, Integer num, Integer num2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = donatePayPassLevelModel.id;
        }
        if ((i & 2) != 0) {
            num2 = donatePayPassLevelModel.price;
        }
        if ((i & 4) != 0) {
            list = donatePayPassLevelModel.rewards;
        }
        return donatePayPassLevelModel.copy(num, num2, list);
    }

    public final Integer component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.price;
    }

    public final List<DonatePayPassLevelRewardModel> component3() {
        return this.rewards;
    }

    public final DonatePayPassLevelModel copy(Integer num, Integer num2, List<DonatePayPassLevelRewardModel> list) {
        return new DonatePayPassLevelModel(num, num2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassLevelModel) {
            DonatePayPassLevelModel donatePayPassLevelModel = (DonatePayPassLevelModel) obj;
            return Intrinsics.areEqual(this.id, donatePayPassLevelModel.id) && Intrinsics.areEqual(this.price, donatePayPassLevelModel.price) && Intrinsics.areEqual(this.rewards, donatePayPassLevelModel.rewards);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.price;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<DonatePayPassLevelRewardModel> list = this.rewards;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        Integer num2 = this.price;
        return "DonatePayPassLevelModel(id=" + num + ", price=" + num2 + ", rewards=" + this.rewards + ")";
    }

    public DonatePayPassLevelModel(Integer num, Integer num2, List<DonatePayPassLevelRewardModel> list) {
        this.id = num;
        this.price = num2;
        this.rewards = list;
    }

    public /* synthetic */ DonatePayPassLevelModel(Integer num, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : list);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final List<DonatePayPassLevelRewardModel> getRewards() {
        return this.rewards;
    }
}

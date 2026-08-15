package ru.mrlargha.feature.starter_pack.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StarterPackModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lru/mrlargha/feature/starter_pack/models/StarterPackModel;", "", TtmlNode.ATTR_ID, "", "title", "", FirebaseAnalytics.Param.LEVEL, FirebaseAnalytics.Param.PRICE, "oldPrice", FirebaseAnalytics.Param.DISCOUNT, "time", "image", "rewards", "", "Lru/mrlargha/feature/starter_pack/models/StarterPackRewardsModel;", "<init>", "(ILjava/lang/String;IIIIILjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getLevel", "getPrice", "getOldPrice", "getDiscount", "getTime", "getImage", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "starter-pack"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StarterPackModel {
    private final int discount;
    private final int id;
    private final String image;
    private final int level;
    private final int oldPrice;
    private final int price;
    private final List<StarterPackRewardsModel> rewards;
    private final int time;
    private final String title;

    public static /* synthetic */ StarterPackModel copy$default(StarterPackModel starterPackModel, int i, String str, int i2, int i3, int i4, int i5, int i6, String str2, List list, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = starterPackModel.id;
        }
        if ((i7 & 2) != 0) {
            str = starterPackModel.title;
        }
        if ((i7 & 4) != 0) {
            i2 = starterPackModel.level;
        }
        if ((i7 & 8) != 0) {
            i3 = starterPackModel.price;
        }
        if ((i7 & 16) != 0) {
            i4 = starterPackModel.oldPrice;
        }
        if ((i7 & 32) != 0) {
            i5 = starterPackModel.discount;
        }
        if ((i7 & 64) != 0) {
            i6 = starterPackModel.time;
        }
        if ((i7 & 128) != 0) {
            str2 = starterPackModel.image;
        }
        List<StarterPackRewardsModel> list2 = list;
        if ((i7 & 256) != 0) {
            list2 = starterPackModel.rewards;
        }
        String str3 = str2;
        List list3 = list2;
        int i8 = i5;
        int i9 = i6;
        int i10 = i4;
        int i11 = i2;
        return starterPackModel.copy(i, str, i11, i3, i10, i8, i9, str3, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.level;
    }

    public final int component4() {
        return this.price;
    }

    public final int component5() {
        return this.oldPrice;
    }

    public final int component6() {
        return this.discount;
    }

    public final int component7() {
        return this.time;
    }

    public final String component8() {
        return this.image;
    }

    public final List<StarterPackRewardsModel> component9() {
        return this.rewards;
    }

    public final StarterPackModel copy(int i, String title, int i2, int i3, int i4, int i5, int i6, String image, List<StarterPackRewardsModel> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        return new StarterPackModel(i, title, i2, i3, i4, i5, i6, image, rewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StarterPackModel) {
            StarterPackModel starterPackModel = (StarterPackModel) obj;
            return this.id == starterPackModel.id && Intrinsics.areEqual(this.title, starterPackModel.title) && this.level == starterPackModel.level && this.price == starterPackModel.price && this.oldPrice == starterPackModel.oldPrice && this.discount == starterPackModel.discount && this.time == starterPackModel.time && Intrinsics.areEqual(this.image, starterPackModel.image) && Intrinsics.areEqual(this.rewards, starterPackModel.rewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.oldPrice)) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.time)) * 31) + this.image.hashCode()) * 31) + this.rewards.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.level;
        int i3 = this.price;
        int i4 = this.oldPrice;
        int i5 = this.discount;
        int i6 = this.time;
        String str2 = this.image;
        return "StarterPackModel(id=" + i + ", title=" + str + ", level=" + i2 + ", price=" + i3 + ", oldPrice=" + i4 + ", discount=" + i5 + ", time=" + i6 + ", image=" + str2 + ", rewards=" + this.rewards + ")";
    }

    public StarterPackModel(int i, String title, int i2, int i3, int i4, int i5, int i6, String image, List<StarterPackRewardsModel> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.id = i;
        this.title = title;
        this.level = i2;
        this.price = i3;
        this.oldPrice = i4;
        this.discount = i5;
        this.time = i6;
        this.image = image;
        this.rewards = rewards;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getOldPrice() {
        return this.oldPrice;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getTime() {
        return this.time;
    }

    public final String getImage() {
        return this.image;
    }

    public final List<StarterPackRewardsModel> getRewards() {
        return this.rewards;
    }
}

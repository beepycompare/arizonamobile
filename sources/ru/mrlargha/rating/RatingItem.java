package ru.mrlargha.rating;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003Ja\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lru/mrlargha/rating/RatingItem;", "", "id", "", "image", "vehicleId", "carName", "", "playerName", "rarity", "rarityLevel", "vehicleComponents", "", "<init>", "(IIILjava/lang/String;Ljava/lang/String;IILjava/util/List;)V", "getId", "()I", "getImage", "getVehicleId", "getCarName", "()Ljava/lang/String;", "getPlayerName", "getRarity", "getRarityLevel", "getVehicleComponents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RatingItem {
    private final String carName;
    private final int id;
    private final int image;
    private final String playerName;
    private final int rarity;
    private final int rarityLevel;
    private final List<Integer> vehicleComponents;
    private final int vehicleId;

    public static /* synthetic */ RatingItem copy$default(RatingItem ratingItem, int i, int i2, int i3, String str, String str2, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = ratingItem.id;
        }
        if ((i6 & 2) != 0) {
            i2 = ratingItem.image;
        }
        if ((i6 & 4) != 0) {
            i3 = ratingItem.vehicleId;
        }
        if ((i6 & 8) != 0) {
            str = ratingItem.carName;
        }
        if ((i6 & 16) != 0) {
            str2 = ratingItem.playerName;
        }
        if ((i6 & 32) != 0) {
            i4 = ratingItem.rarity;
        }
        if ((i6 & 64) != 0) {
            i5 = ratingItem.rarityLevel;
        }
        List<Integer> list2 = list;
        if ((i6 & 128) != 0) {
            list2 = ratingItem.vehicleComponents;
        }
        int i7 = i5;
        List list3 = list2;
        String str3 = str2;
        int i8 = i4;
        return ratingItem.copy(i, i2, i3, str, str3, i8, i7, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.image;
    }

    public final int component3() {
        return this.vehicleId;
    }

    public final String component4() {
        return this.carName;
    }

    public final String component5() {
        return this.playerName;
    }

    public final int component6() {
        return this.rarity;
    }

    public final int component7() {
        return this.rarityLevel;
    }

    public final List<Integer> component8() {
        return this.vehicleComponents;
    }

    public final RatingItem copy(int i, int i2, int i3, String carName, String playerName, int i4, int i5, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        return new RatingItem(i, i2, i3, carName, playerName, i4, i5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingItem) {
            RatingItem ratingItem = (RatingItem) obj;
            return this.id == ratingItem.id && this.image == ratingItem.image && this.vehicleId == ratingItem.vehicleId && Intrinsics.areEqual(this.carName, ratingItem.carName) && Intrinsics.areEqual(this.playerName, ratingItem.playerName) && this.rarity == ratingItem.rarity && this.rarityLevel == ratingItem.rarityLevel && Intrinsics.areEqual(this.vehicleComponents, ratingItem.vehicleComponents);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.vehicleId)) * 31) + this.carName.hashCode()) * 31) + this.playerName.hashCode()) * 31) + Integer.hashCode(this.rarity)) * 31) + Integer.hashCode(this.rarityLevel)) * 31;
        List<Integer> list = this.vehicleComponents;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        int i = this.id;
        int i2 = this.image;
        int i3 = this.vehicleId;
        String str = this.carName;
        String str2 = this.playerName;
        int i4 = this.rarity;
        int i5 = this.rarityLevel;
        return "RatingItem(id=" + i + ", image=" + i2 + ", vehicleId=" + i3 + ", carName=" + str + ", playerName=" + str2 + ", rarity=" + i4 + ", rarityLevel=" + i5 + ", vehicleComponents=" + this.vehicleComponents + ")";
    }

    public RatingItem(int i, int i2, int i3, String carName, String playerName, int i4, int i5, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        this.id = i;
        this.image = i2;
        this.vehicleId = i3;
        this.carName = carName;
        this.playerName = playerName;
        this.rarity = i4;
        this.rarityLevel = i5;
        this.vehicleComponents = list;
    }

    public final int getId() {
        return this.id;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getVehicleId() {
        return this.vehicleId;
    }

    public final String getCarName() {
        return this.carName;
    }

    public final String getPlayerName() {
        return this.playerName;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final int getRarityLevel() {
        return this.rarityLevel;
    }

    public final List<Integer> getVehicleComponents() {
        return this.vehicleComponents;
    }
}

package com.arizonagames.feature.arizona.cars;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/cars/VehicleItem;", "", "title", "", "rarity", "", "rarityLevel", "ratingPosition", "bonuses", "", "Lcom/arizonagames/feature/arizona/cars/Bonus;", "<init>", "(Ljava/lang/String;IIILjava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getRarity", "()I", "getRarityLevel", "getRatingPosition", "getBonuses", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VehicleItem {
    private final List<Bonus> bonuses;
    private final int rarity;
    private final int rarityLevel;
    private final int ratingPosition;
    private final String title;

    public static /* synthetic */ VehicleItem copy$default(VehicleItem vehicleItem, String str, int i, int i2, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = vehicleItem.title;
        }
        if ((i4 & 2) != 0) {
            i = vehicleItem.rarity;
        }
        if ((i4 & 4) != 0) {
            i2 = vehicleItem.rarityLevel;
        }
        if ((i4 & 8) != 0) {
            i3 = vehicleItem.ratingPosition;
        }
        List<Bonus> list2 = list;
        if ((i4 & 16) != 0) {
            list2 = vehicleItem.bonuses;
        }
        List list3 = list2;
        int i5 = i2;
        return vehicleItem.copy(str, i, i5, i3, list3);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.rarity;
    }

    public final int component3() {
        return this.rarityLevel;
    }

    public final int component4() {
        return this.ratingPosition;
    }

    public final List<Bonus> component5() {
        return this.bonuses;
    }

    public final VehicleItem copy(String title, int i, int i2, int i3, List<Bonus> bonuses) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        return new VehicleItem(title, i, i2, i3, bonuses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VehicleItem) {
            VehicleItem vehicleItem = (VehicleItem) obj;
            return Intrinsics.areEqual(this.title, vehicleItem.title) && this.rarity == vehicleItem.rarity && this.rarityLevel == vehicleItem.rarityLevel && this.ratingPosition == vehicleItem.ratingPosition && Intrinsics.areEqual(this.bonuses, vehicleItem.bonuses);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + Integer.hashCode(this.rarity)) * 31) + Integer.hashCode(this.rarityLevel)) * 31) + Integer.hashCode(this.ratingPosition)) * 31) + this.bonuses.hashCode();
    }

    public String toString() {
        String str = this.title;
        int i = this.rarity;
        int i2 = this.rarityLevel;
        int i3 = this.ratingPosition;
        return "VehicleItem(title=" + str + ", rarity=" + i + ", rarityLevel=" + i2 + ", ratingPosition=" + i3 + ", bonuses=" + this.bonuses + ")";
    }

    public VehicleItem(String title, int i, int i2, int i3, List<Bonus> bonuses) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bonuses, "bonuses");
        this.title = title;
        this.rarity = i;
        this.rarityLevel = i2;
        this.ratingPosition = i3;
        this.bonuses = bonuses;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final int getRarityLevel() {
        return this.rarityLevel;
    }

    public final int getRatingPosition() {
        return this.ratingPosition;
    }

    public final List<Bonus> getBonuses() {
        return this.bonuses;
    }
}

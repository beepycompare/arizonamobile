package com.arizonagames.feature.arizona.cars;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreen;", "", "title", "", "icon", "rarity", "Lcom/arizonagames/feature/arizona/cars/CarsRarity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/arizonagames/feature/arizona/cars/CarsRarity;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "getRarity", "()Lcom/arizonagames/feature/arizona/cars/CarsRarity;", "setRarity", "(Lcom/arizonagames/feature/arizona/cars/CarsRarity;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CarInfoSecondScreen {
    private String icon;
    private CarsRarity rarity;
    private final String title;

    public CarInfoSecondScreen() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CarInfoSecondScreen copy$default(CarInfoSecondScreen carInfoSecondScreen, String str, String str2, CarsRarity carsRarity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = carInfoSecondScreen.title;
        }
        if ((i & 2) != 0) {
            str2 = carInfoSecondScreen.icon;
        }
        if ((i & 4) != 0) {
            carsRarity = carInfoSecondScreen.rarity;
        }
        return carInfoSecondScreen.copy(str, str2, carsRarity);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final CarsRarity component3() {
        return this.rarity;
    }

    public final CarInfoSecondScreen copy(String title, String icon, CarsRarity carsRarity) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new CarInfoSecondScreen(title, icon, carsRarity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarInfoSecondScreen) {
            CarInfoSecondScreen carInfoSecondScreen = (CarInfoSecondScreen) obj;
            return Intrinsics.areEqual(this.title, carInfoSecondScreen.title) && Intrinsics.areEqual(this.icon, carInfoSecondScreen.icon) && Intrinsics.areEqual(this.rarity, carInfoSecondScreen.rarity);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.icon.hashCode()) * 31;
        CarsRarity carsRarity = this.rarity;
        return hashCode + (carsRarity == null ? 0 : carsRarity.hashCode());
    }

    public String toString() {
        String str = this.title;
        String str2 = this.icon;
        return "CarInfoSecondScreen(title=" + str + ", icon=" + str2 + ", rarity=" + this.rarity + ")";
    }

    public CarInfoSecondScreen(String title, String icon, CarsRarity carsRarity) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.icon = icon;
        this.rarity = carsRarity;
    }

    public /* synthetic */ CarInfoSecondScreen(String str, String str2, CarsRarity carsRarity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : carsRarity);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final CarsRarity getRarity() {
        return this.rarity;
    }

    public final void setRarity(CarsRarity carsRarity) {
        this.rarity = carsRarity;
    }
}

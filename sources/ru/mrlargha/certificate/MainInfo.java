package ru.mrlargha.certificate;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0092\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00069"}, d2 = {"Lru/mrlargha/certificate/MainInfo;", "", "carName", "", "image", "", "rarity", "maxSpeed", "", "hp", FirebaseAnalytics.Param.PRICE, "power", "powerBonus", "rarityLevel", "priceButton", "vehicleId", "vehicleComponents", "", "<init>", "(Ljava/lang/String;IIFIIILjava/lang/Integer;ILjava/lang/Integer;ILjava/util/List;)V", "getCarName", "()Ljava/lang/String;", "getImage", "()I", "getRarity", "getMaxSpeed", "()F", "getHp", "getPrice", "getPower", "getPowerBonus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRarityLevel", "getPriceButton", "getVehicleId", "getVehicleComponents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;IIFIIILjava/lang/Integer;ILjava/lang/Integer;ILjava/util/List;)Lru/mrlargha/certificate/MainInfo;", "equals", "", "other", "hashCode", "toString", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainInfo {
    private final String carName;
    private final int hp;
    private final int image;
    private final float maxSpeed;
    private final int power;
    private final Integer powerBonus;
    private final int price;
    private final Integer priceButton;
    private final int rarity;
    private final int rarityLevel;
    private final List<Integer> vehicleComponents;
    private final int vehicleId;

    public static /* synthetic */ MainInfo copy$default(MainInfo mainInfo, String str, int i, int i2, float f, int i3, int i4, int i5, Integer num, int i6, Integer num2, int i7, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = mainInfo.carName;
        }
        if ((i8 & 2) != 0) {
            i = mainInfo.image;
        }
        if ((i8 & 4) != 0) {
            i2 = mainInfo.rarity;
        }
        if ((i8 & 8) != 0) {
            f = mainInfo.maxSpeed;
        }
        if ((i8 & 16) != 0) {
            i3 = mainInfo.hp;
        }
        if ((i8 & 32) != 0) {
            i4 = mainInfo.price;
        }
        if ((i8 & 64) != 0) {
            i5 = mainInfo.power;
        }
        if ((i8 & 128) != 0) {
            num = mainInfo.powerBonus;
        }
        if ((i8 & 256) != 0) {
            i6 = mainInfo.rarityLevel;
        }
        if ((i8 & 512) != 0) {
            num2 = mainInfo.priceButton;
        }
        if ((i8 & 1024) != 0) {
            i7 = mainInfo.vehicleId;
        }
        List<Integer> list2 = list;
        if ((i8 & 2048) != 0) {
            list2 = mainInfo.vehicleComponents;
        }
        int i9 = i7;
        List list3 = list2;
        int i10 = i6;
        Integer num3 = num2;
        int i11 = i5;
        Integer num4 = num;
        int i12 = i3;
        int i13 = i4;
        return mainInfo.copy(str, i, i2, f, i12, i13, i11, num4, i10, num3, i9, list3);
    }

    public final String component1() {
        return this.carName;
    }

    public final Integer component10() {
        return this.priceButton;
    }

    public final int component11() {
        return this.vehicleId;
    }

    public final List<Integer> component12() {
        return this.vehicleComponents;
    }

    public final int component2() {
        return this.image;
    }

    public final int component3() {
        return this.rarity;
    }

    public final float component4() {
        return this.maxSpeed;
    }

    public final int component5() {
        return this.hp;
    }

    public final int component6() {
        return this.price;
    }

    public final int component7() {
        return this.power;
    }

    public final Integer component8() {
        return this.powerBonus;
    }

    public final int component9() {
        return this.rarityLevel;
    }

    public final MainInfo copy(String carName, int i, int i2, float f, int i3, int i4, int i5, Integer num, int i6, Integer num2, int i7, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        return new MainInfo(carName, i, i2, f, i3, i4, i5, num, i6, num2, i7, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainInfo) {
            MainInfo mainInfo = (MainInfo) obj;
            return Intrinsics.areEqual(this.carName, mainInfo.carName) && this.image == mainInfo.image && this.rarity == mainInfo.rarity && Float.compare(this.maxSpeed, mainInfo.maxSpeed) == 0 && this.hp == mainInfo.hp && this.price == mainInfo.price && this.power == mainInfo.power && Intrinsics.areEqual(this.powerBonus, mainInfo.powerBonus) && this.rarityLevel == mainInfo.rarityLevel && Intrinsics.areEqual(this.priceButton, mainInfo.priceButton) && this.vehicleId == mainInfo.vehicleId && Intrinsics.areEqual(this.vehicleComponents, mainInfo.vehicleComponents);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.carName.hashCode() * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.rarity)) * 31) + Float.hashCode(this.maxSpeed)) * 31) + Integer.hashCode(this.hp)) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.power)) * 31;
        Integer num = this.powerBonus;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.rarityLevel)) * 31;
        Integer num2 = this.priceButton;
        int hashCode3 = (((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.vehicleId)) * 31;
        List<Integer> list = this.vehicleComponents;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.carName;
        int i = this.image;
        int i2 = this.rarity;
        float f = this.maxSpeed;
        int i3 = this.hp;
        int i4 = this.price;
        int i5 = this.power;
        Integer num = this.powerBonus;
        int i6 = this.rarityLevel;
        Integer num2 = this.priceButton;
        int i7 = this.vehicleId;
        return "MainInfo(carName=" + str + ", image=" + i + ", rarity=" + i2 + ", maxSpeed=" + f + ", hp=" + i3 + ", price=" + i4 + ", power=" + i5 + ", powerBonus=" + num + ", rarityLevel=" + i6 + ", priceButton=" + num2 + ", vehicleId=" + i7 + ", vehicleComponents=" + this.vehicleComponents + ")";
    }

    public MainInfo(String carName, int i, int i2, float f, int i3, int i4, int i5, Integer num, int i6, Integer num2, int i7, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        this.carName = carName;
        this.image = i;
        this.rarity = i2;
        this.maxSpeed = f;
        this.hp = i3;
        this.price = i4;
        this.power = i5;
        this.powerBonus = num;
        this.rarityLevel = i6;
        this.priceButton = num2;
        this.vehicleId = i7;
        this.vehicleComponents = list;
    }

    public final String getCarName() {
        return this.carName;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final float getMaxSpeed() {
        return this.maxSpeed;
    }

    public final int getHp() {
        return this.hp;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getPower() {
        return this.power;
    }

    public final Integer getPowerBonus() {
        return this.powerBonus;
    }

    public final int getRarityLevel() {
        return this.rarityLevel;
    }

    public final Integer getPriceButton() {
        return this.priceButton;
    }

    public final int getVehicleId() {
        return this.vehicleId;
    }

    public final List<Integer> getVehicleComponents() {
        return this.vehicleComponents;
    }
}

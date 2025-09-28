package ru.mrlargha.certificate;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014HÆ\u0003J¶\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006D"}, d2 = {"Lru/mrlargha/certificate/MainInfo;", "", "carName", "", "image", "", "rarity", "maxSpeed", "", "maxSpeedBonus", "hp", "hpBonus", FirebaseAnalytics.Param.PRICE, "supportsColor", "power", "powerBonus", "rarityLevel", "priceButton", "vehicleId", "vehicleComponents", "", "<init>", "(Ljava/lang/String;IIFLjava/lang/Float;ILjava/lang/Float;ILjava/lang/String;ILjava/lang/Integer;ILjava/lang/Integer;ILjava/util/List;)V", "getCarName", "()Ljava/lang/String;", "getImage", "()I", "getRarity", "getMaxSpeed", "()F", "getMaxSpeedBonus", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHp", "getHpBonus", "getPrice", "getSupportsColor", "getPower", "getPowerBonus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRarityLevel", "getPriceButton", "getVehicleId", "getVehicleComponents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;IIFLjava/lang/Float;ILjava/lang/Float;ILjava/lang/String;ILjava/lang/Integer;ILjava/lang/Integer;ILjava/util/List;)Lru/mrlargha/certificate/MainInfo;", "equals", "", "other", "hashCode", "toString", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainInfo {
    private final String carName;
    private final int hp;
    private final Float hpBonus;
    private final int image;
    private final float maxSpeed;
    private final Float maxSpeedBonus;
    private final int power;
    private final Integer powerBonus;
    private final int price;
    private final Integer priceButton;
    private final int rarity;
    private final int rarityLevel;
    private final String supportsColor;
    private final List<Integer> vehicleComponents;
    private final int vehicleId;

    public final String component1() {
        return this.carName;
    }

    public final int component10() {
        return this.power;
    }

    public final Integer component11() {
        return this.powerBonus;
    }

    public final int component12() {
        return this.rarityLevel;
    }

    public final Integer component13() {
        return this.priceButton;
    }

    public final int component14() {
        return this.vehicleId;
    }

    public final List<Integer> component15() {
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

    public final Float component5() {
        return this.maxSpeedBonus;
    }

    public final int component6() {
        return this.hp;
    }

    public final Float component7() {
        return this.hpBonus;
    }

    public final int component8() {
        return this.price;
    }

    public final String component9() {
        return this.supportsColor;
    }

    public final MainInfo copy(String carName, int i, int i2, float f, Float f2, int i3, Float f3, int i4, String str, int i5, Integer num, int i6, Integer num2, int i7, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        return new MainInfo(carName, i, i2, f, f2, i3, f3, i4, str, i5, num, i6, num2, i7, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainInfo) {
            MainInfo mainInfo = (MainInfo) obj;
            return Intrinsics.areEqual(this.carName, mainInfo.carName) && this.image == mainInfo.image && this.rarity == mainInfo.rarity && Float.compare(this.maxSpeed, mainInfo.maxSpeed) == 0 && Intrinsics.areEqual((Object) this.maxSpeedBonus, (Object) mainInfo.maxSpeedBonus) && this.hp == mainInfo.hp && Intrinsics.areEqual((Object) this.hpBonus, (Object) mainInfo.hpBonus) && this.price == mainInfo.price && Intrinsics.areEqual(this.supportsColor, mainInfo.supportsColor) && this.power == mainInfo.power && Intrinsics.areEqual(this.powerBonus, mainInfo.powerBonus) && this.rarityLevel == mainInfo.rarityLevel && Intrinsics.areEqual(this.priceButton, mainInfo.priceButton) && this.vehicleId == mainInfo.vehicleId && Intrinsics.areEqual(this.vehicleComponents, mainInfo.vehicleComponents);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.carName.hashCode() * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.rarity)) * 31) + Float.hashCode(this.maxSpeed)) * 31;
        Float f = this.maxSpeedBonus;
        int hashCode2 = (((hashCode + (f == null ? 0 : f.hashCode())) * 31) + Integer.hashCode(this.hp)) * 31;
        Float f2 = this.hpBonus;
        int hashCode3 = (((hashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31) + Integer.hashCode(this.price)) * 31;
        String str = this.supportsColor;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.power)) * 31;
        Integer num = this.powerBonus;
        int hashCode5 = (((hashCode4 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.rarityLevel)) * 31;
        Integer num2 = this.priceButton;
        int hashCode6 = (((hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.vehicleId)) * 31;
        List<Integer> list = this.vehicleComponents;
        return hashCode6 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.carName;
        int i = this.image;
        int i2 = this.rarity;
        float f = this.maxSpeed;
        Float f2 = this.maxSpeedBonus;
        int i3 = this.hp;
        Float f3 = this.hpBonus;
        int i4 = this.price;
        String str2 = this.supportsColor;
        int i5 = this.power;
        Integer num = this.powerBonus;
        int i6 = this.rarityLevel;
        Integer num2 = this.priceButton;
        int i7 = this.vehicleId;
        return "MainInfo(carName=" + str + ", image=" + i + ", rarity=" + i2 + ", maxSpeed=" + f + ", maxSpeedBonus=" + f2 + ", hp=" + i3 + ", hpBonus=" + f3 + ", price=" + i4 + ", supportsColor=" + str2 + ", power=" + i5 + ", powerBonus=" + num + ", rarityLevel=" + i6 + ", priceButton=" + num2 + ", vehicleId=" + i7 + ", vehicleComponents=" + this.vehicleComponents + ")";
    }

    public MainInfo(String carName, int i, int i2, float f, Float f2, int i3, Float f3, int i4, String str, int i5, Integer num, int i6, Integer num2, int i7, List<Integer> list) {
        Intrinsics.checkNotNullParameter(carName, "carName");
        this.carName = carName;
        this.image = i;
        this.rarity = i2;
        this.maxSpeed = f;
        this.maxSpeedBonus = f2;
        this.hp = i3;
        this.hpBonus = f3;
        this.price = i4;
        this.supportsColor = str;
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

    public final Float getMaxSpeedBonus() {
        return this.maxSpeedBonus;
    }

    public final int getHp() {
        return this.hp;
    }

    public final Float getHpBonus() {
        return this.hpBonus;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getSupportsColor() {
        return this.supportsColor;
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

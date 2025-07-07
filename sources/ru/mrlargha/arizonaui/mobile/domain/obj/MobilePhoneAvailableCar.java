package ru.mrlargha.arizonaui.mobile.domain.obj;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneAvailableCar;", "", "id", "", "name", "", "number", "distance", "image", "fuelType", "fuelValue", FirebaseAnalytics.Param.PRICE, "<init>", "(ILjava/lang/String;IIILjava/lang/String;II)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getNumber", "getDistance", "getImage", "getFuelType", "getFuelValue", "getPrice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneAvailableCar {
    private final int distance;
    private final String fuelType;
    private final int fuelValue;
    private final int id;
    private final int image;
    private final String name;
    private final int number;
    private final int price;

    public static /* synthetic */ MobilePhoneAvailableCar copy$default(MobilePhoneAvailableCar mobilePhoneAvailableCar, int i, String str, int i2, int i3, int i4, String str2, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = mobilePhoneAvailableCar.id;
        }
        if ((i7 & 2) != 0) {
            str = mobilePhoneAvailableCar.name;
        }
        if ((i7 & 4) != 0) {
            i2 = mobilePhoneAvailableCar.number;
        }
        if ((i7 & 8) != 0) {
            i3 = mobilePhoneAvailableCar.distance;
        }
        if ((i7 & 16) != 0) {
            i4 = mobilePhoneAvailableCar.image;
        }
        if ((i7 & 32) != 0) {
            str2 = mobilePhoneAvailableCar.fuelType;
        }
        if ((i7 & 64) != 0) {
            i5 = mobilePhoneAvailableCar.fuelValue;
        }
        if ((i7 & 128) != 0) {
            i6 = mobilePhoneAvailableCar.price;
        }
        int i8 = i5;
        int i9 = i6;
        int i10 = i4;
        String str3 = str2;
        return mobilePhoneAvailableCar.copy(i, str, i2, i3, i10, str3, i8, i9);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.number;
    }

    public final int component4() {
        return this.distance;
    }

    public final int component5() {
        return this.image;
    }

    public final String component6() {
        return this.fuelType;
    }

    public final int component7() {
        return this.fuelValue;
    }

    public final int component8() {
        return this.price;
    }

    public final MobilePhoneAvailableCar copy(int i, String name, int i2, int i3, int i4, String fuelType, int i5, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fuelType, "fuelType");
        return new MobilePhoneAvailableCar(i, name, i2, i3, i4, fuelType, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneAvailableCar) {
            MobilePhoneAvailableCar mobilePhoneAvailableCar = (MobilePhoneAvailableCar) obj;
            return this.id == mobilePhoneAvailableCar.id && Intrinsics.areEqual(this.name, mobilePhoneAvailableCar.name) && this.number == mobilePhoneAvailableCar.number && this.distance == mobilePhoneAvailableCar.distance && this.image == mobilePhoneAvailableCar.image && Intrinsics.areEqual(this.fuelType, mobilePhoneAvailableCar.fuelType) && this.fuelValue == mobilePhoneAvailableCar.fuelValue && this.price == mobilePhoneAvailableCar.price;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.number)) * 31) + Integer.hashCode(this.distance)) * 31) + Integer.hashCode(this.image)) * 31) + this.fuelType.hashCode()) * 31) + Integer.hashCode(this.fuelValue)) * 31) + Integer.hashCode(this.price);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.number;
        int i3 = this.distance;
        int i4 = this.image;
        String str2 = this.fuelType;
        int i5 = this.fuelValue;
        return "MobilePhoneAvailableCar(id=" + i + ", name=" + str + ", number=" + i2 + ", distance=" + i3 + ", image=" + i4 + ", fuelType=" + str2 + ", fuelValue=" + i5 + ", price=" + this.price + ")";
    }

    public MobilePhoneAvailableCar(int i, String name, int i2, int i3, int i4, String fuelType, int i5, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fuelType, "fuelType");
        this.id = i;
        this.name = name;
        this.number = i2;
        this.distance = i3;
        this.image = i4;
        this.fuelType = fuelType;
        this.fuelValue = i5;
        this.price = i6;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getFuelType() {
        return this.fuelType;
    }

    public final int getFuelValue() {
        return this.fuelValue;
    }

    public final int getPrice() {
        return this.price;
    }
}

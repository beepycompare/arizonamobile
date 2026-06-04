package ru.mrlargha.feature.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lru/mrlargha/feature/mobile/domain/obj/MobilePhoneDriverWorkInfo;", "", "name", "", "rating", "", "ordersCount", "", "car", "tariff", "<init>", "(Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getRating", "()D", "getOrdersCount", "()I", "getCar", "getTariff", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneDriverWorkInfo {
    private final String car;
    private final String name;
    private final int ordersCount;
    private final double rating;
    private final String tariff;

    public static /* synthetic */ MobilePhoneDriverWorkInfo copy$default(MobilePhoneDriverWorkInfo mobilePhoneDriverWorkInfo, String str, double d, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mobilePhoneDriverWorkInfo.name;
        }
        if ((i2 & 2) != 0) {
            d = mobilePhoneDriverWorkInfo.rating;
        }
        if ((i2 & 4) != 0) {
            i = mobilePhoneDriverWorkInfo.ordersCount;
        }
        if ((i2 & 8) != 0) {
            str2 = mobilePhoneDriverWorkInfo.car;
        }
        if ((i2 & 16) != 0) {
            str3 = mobilePhoneDriverWorkInfo.tariff;
        }
        String str4 = str3;
        int i3 = i;
        return mobilePhoneDriverWorkInfo.copy(str, d, i3, str2, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final double component2() {
        return this.rating;
    }

    public final int component3() {
        return this.ordersCount;
    }

    public final String component4() {
        return this.car;
    }

    public final String component5() {
        return this.tariff;
    }

    public final MobilePhoneDriverWorkInfo copy(String name, double d, int i, String car, String tariff) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        Intrinsics.checkNotNullParameter(tariff, "tariff");
        return new MobilePhoneDriverWorkInfo(name, d, i, car, tariff);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneDriverWorkInfo) {
            MobilePhoneDriverWorkInfo mobilePhoneDriverWorkInfo = (MobilePhoneDriverWorkInfo) obj;
            return Intrinsics.areEqual(this.name, mobilePhoneDriverWorkInfo.name) && Double.compare(this.rating, mobilePhoneDriverWorkInfo.rating) == 0 && this.ordersCount == mobilePhoneDriverWorkInfo.ordersCount && Intrinsics.areEqual(this.car, mobilePhoneDriverWorkInfo.car) && Intrinsics.areEqual(this.tariff, mobilePhoneDriverWorkInfo.tariff);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + Double.hashCode(this.rating)) * 31) + Integer.hashCode(this.ordersCount)) * 31) + this.car.hashCode()) * 31) + this.tariff.hashCode();
    }

    public String toString() {
        String str = this.name;
        double d = this.rating;
        int i = this.ordersCount;
        String str2 = this.car;
        return "MobilePhoneDriverWorkInfo(name=" + str + ", rating=" + d + ", ordersCount=" + i + ", car=" + str2 + ", tariff=" + this.tariff + ")";
    }

    public MobilePhoneDriverWorkInfo(String name, double d, int i, String car, String tariff) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        Intrinsics.checkNotNullParameter(tariff, "tariff");
        this.name = name;
        this.rating = d;
        this.ordersCount = i;
        this.car = car;
        this.tariff = tariff;
    }

    public final String getName() {
        return this.name;
    }

    public final double getRating() {
        return this.rating;
    }

    public final int getOrdersCount() {
        return this.ordersCount;
    }

    public final String getCar() {
        return this.car;
    }

    public final String getTariff() {
        return this.tariff;
    }
}

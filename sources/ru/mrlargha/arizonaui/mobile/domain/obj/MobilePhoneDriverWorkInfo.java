package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverWorkInfo;", "", "name", "", "rating", "", "ordersCount", "car", "tariff", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getRating", "()I", "getOrdersCount", "getCar", "getTariff", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneDriverWorkInfo {
    private final String car;
    private final String name;
    private final int ordersCount;
    private final int rating;
    private final String tariff;

    public static /* synthetic */ MobilePhoneDriverWorkInfo copy$default(MobilePhoneDriverWorkInfo mobilePhoneDriverWorkInfo, String str, int i, int i2, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mobilePhoneDriverWorkInfo.name;
        }
        if ((i3 & 2) != 0) {
            i = mobilePhoneDriverWorkInfo.rating;
        }
        if ((i3 & 4) != 0) {
            i2 = mobilePhoneDriverWorkInfo.ordersCount;
        }
        if ((i3 & 8) != 0) {
            str2 = mobilePhoneDriverWorkInfo.car;
        }
        if ((i3 & 16) != 0) {
            str3 = mobilePhoneDriverWorkInfo.tariff;
        }
        String str4 = str3;
        int i4 = i2;
        return mobilePhoneDriverWorkInfo.copy(str, i, i4, str2, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
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

    public final MobilePhoneDriverWorkInfo copy(String name, int i, int i2, String car, String tariff) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        Intrinsics.checkNotNullParameter(tariff, "tariff");
        return new MobilePhoneDriverWorkInfo(name, i, i2, car, tariff);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneDriverWorkInfo) {
            MobilePhoneDriverWorkInfo mobilePhoneDriverWorkInfo = (MobilePhoneDriverWorkInfo) obj;
            return Intrinsics.areEqual(this.name, mobilePhoneDriverWorkInfo.name) && this.rating == mobilePhoneDriverWorkInfo.rating && this.ordersCount == mobilePhoneDriverWorkInfo.ordersCount && Intrinsics.areEqual(this.car, mobilePhoneDriverWorkInfo.car) && Intrinsics.areEqual(this.tariff, mobilePhoneDriverWorkInfo.tariff);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + Integer.hashCode(this.rating)) * 31) + Integer.hashCode(this.ordersCount)) * 31) + this.car.hashCode()) * 31) + this.tariff.hashCode();
    }

    public String toString() {
        String str = this.name;
        int i = this.rating;
        int i2 = this.ordersCount;
        String str2 = this.car;
        return "MobilePhoneDriverWorkInfo(name=" + str + ", rating=" + i + ", ordersCount=" + i2 + ", car=" + str2 + ", tariff=" + this.tariff + ")";
    }

    public MobilePhoneDriverWorkInfo(String name, int i, int i2, String car, String tariff) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        Intrinsics.checkNotNullParameter(tariff, "tariff");
        this.name = name;
        this.rating = i;
        this.ordersCount = i2;
        this.car = car;
        this.tariff = tariff;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRating() {
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

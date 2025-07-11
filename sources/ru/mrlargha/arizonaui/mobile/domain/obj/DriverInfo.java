package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/DriverInfo;", "", "name", "", "rating", "", "count", "car", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getRating", "()I", "getCount", "getCar", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DriverInfo {
    private final String car;
    private final int count;
    private final String name;
    private final int rating;

    public static /* synthetic */ DriverInfo copy$default(DriverInfo driverInfo, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = driverInfo.name;
        }
        if ((i3 & 2) != 0) {
            i = driverInfo.rating;
        }
        if ((i3 & 4) != 0) {
            i2 = driverInfo.count;
        }
        if ((i3 & 8) != 0) {
            str2 = driverInfo.car;
        }
        return driverInfo.copy(str, i, i2, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.rating;
    }

    public final int component3() {
        return this.count;
    }

    public final String component4() {
        return this.car;
    }

    public final DriverInfo copy(String name, int i, int i2, String car) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        return new DriverInfo(name, i, i2, car);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverInfo) {
            DriverInfo driverInfo = (DriverInfo) obj;
            return Intrinsics.areEqual(this.name, driverInfo.name) && this.rating == driverInfo.rating && this.count == driverInfo.count && Intrinsics.areEqual(this.car, driverInfo.car);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + Integer.hashCode(this.rating)) * 31) + Integer.hashCode(this.count)) * 31) + this.car.hashCode();
    }

    public String toString() {
        String str = this.name;
        int i = this.rating;
        int i2 = this.count;
        return "DriverInfo(name=" + str + ", rating=" + i + ", count=" + i2 + ", car=" + this.car + ")";
    }

    public DriverInfo(String name, int i, int i2, String car) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(car, "car");
        this.name = name;
        this.rating = i;
        this.count = i2;
        this.car = car;
    }

    public final String getCar() {
        return this.car;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRating() {
        return this.rating;
    }
}

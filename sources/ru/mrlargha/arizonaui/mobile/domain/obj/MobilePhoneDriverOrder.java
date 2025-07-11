package ru.mrlargha.arizonaui.mobile.domain.obj;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneDriverOrder;", "", "id", "", "name", "", "rating", "distance", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "driverName", "driverRating", "<init>", "(ILjava/lang/String;IIILjava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getRating", "getDistance", "getActive", "getDriverName", "getDriverRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneDriverOrder {
    private final int active;
    private final int distance;
    private final String driverName;
    private final int driverRating;
    private final int id;
    private final String name;
    private final int rating;

    public static /* synthetic */ MobilePhoneDriverOrder copy$default(MobilePhoneDriverOrder mobilePhoneDriverOrder, int i, String str, int i2, int i3, int i4, String str2, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mobilePhoneDriverOrder.id;
        }
        if ((i6 & 2) != 0) {
            str = mobilePhoneDriverOrder.name;
        }
        if ((i6 & 4) != 0) {
            i2 = mobilePhoneDriverOrder.rating;
        }
        if ((i6 & 8) != 0) {
            i3 = mobilePhoneDriverOrder.distance;
        }
        if ((i6 & 16) != 0) {
            i4 = mobilePhoneDriverOrder.active;
        }
        if ((i6 & 32) != 0) {
            str2 = mobilePhoneDriverOrder.driverName;
        }
        if ((i6 & 64) != 0) {
            i5 = mobilePhoneDriverOrder.driverRating;
        }
        String str3 = str2;
        int i7 = i5;
        int i8 = i4;
        int i9 = i2;
        return mobilePhoneDriverOrder.copy(i, str, i9, i3, i8, str3, i7);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.rating;
    }

    public final int component4() {
        return this.distance;
    }

    public final int component5() {
        return this.active;
    }

    public final String component6() {
        return this.driverName;
    }

    public final int component7() {
        return this.driverRating;
    }

    public final MobilePhoneDriverOrder copy(int i, String name, int i2, int i3, int i4, String driverName, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(driverName, "driverName");
        return new MobilePhoneDriverOrder(i, name, i2, i3, i4, driverName, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneDriverOrder) {
            MobilePhoneDriverOrder mobilePhoneDriverOrder = (MobilePhoneDriverOrder) obj;
            return this.id == mobilePhoneDriverOrder.id && Intrinsics.areEqual(this.name, mobilePhoneDriverOrder.name) && this.rating == mobilePhoneDriverOrder.rating && this.distance == mobilePhoneDriverOrder.distance && this.active == mobilePhoneDriverOrder.active && Intrinsics.areEqual(this.driverName, mobilePhoneDriverOrder.driverName) && this.driverRating == mobilePhoneDriverOrder.driverRating;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.rating)) * 31) + Integer.hashCode(this.distance)) * 31) + Integer.hashCode(this.active)) * 31) + this.driverName.hashCode()) * 31) + Integer.hashCode(this.driverRating);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.rating;
        int i3 = this.distance;
        int i4 = this.active;
        String str2 = this.driverName;
        return "MobilePhoneDriverOrder(id=" + i + ", name=" + str + ", rating=" + i2 + ", distance=" + i3 + ", active=" + i4 + ", driverName=" + str2 + ", driverRating=" + this.driverRating + ")";
    }

    public MobilePhoneDriverOrder(int i, String name, int i2, int i3, int i4, String driverName, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(driverName, "driverName");
        this.id = i;
        this.name = name;
        this.rating = i2;
        this.distance = i3;
        this.active = i4;
        this.driverName = driverName;
        this.driverRating = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRating() {
        return this.rating;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final int getActive() {
        return this.active;
    }

    public final String getDriverName() {
        return this.driverName;
    }

    public final int getDriverRating() {
        return this.driverRating;
    }
}

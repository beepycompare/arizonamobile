package ru.mrlargha.commonui.elements.gasstation.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GasStationFuel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/domain/GasStationFuel;", "", "id", "", "title", "", FirebaseAnalytics.Param.PRICE, "", "available", "<init>", "(ILjava/lang/String;JI)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPrice", "()J", "getAvailable", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GasStationFuel {
    private final int available;
    private final int id;
    private final long price;
    private final String title;

    public static /* synthetic */ GasStationFuel copy$default(GasStationFuel gasStationFuel, int i, String str, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gasStationFuel.id;
        }
        if ((i3 & 2) != 0) {
            str = gasStationFuel.title;
        }
        if ((i3 & 4) != 0) {
            j = gasStationFuel.price;
        }
        if ((i3 & 8) != 0) {
            i2 = gasStationFuel.available;
        }
        int i4 = i2;
        return gasStationFuel.copy(i, str, j, i4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final long component3() {
        return this.price;
    }

    public final int component4() {
        return this.available;
    }

    public final GasStationFuel copy(int i, String title, long j, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new GasStationFuel(i, title, j, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GasStationFuel) {
            GasStationFuel gasStationFuel = (GasStationFuel) obj;
            return this.id == gasStationFuel.id && Intrinsics.areEqual(this.title, gasStationFuel.title) && this.price == gasStationFuel.price && this.available == gasStationFuel.available;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.price)) * 31) + Integer.hashCode(this.available);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        long j = this.price;
        return "GasStationFuel(id=" + i + ", title=" + str + ", price=" + j + ", available=" + this.available + ")";
    }

    public GasStationFuel(int i, String title, long j, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.price = j;
        this.available = i2;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final int getId() {
        return this.id;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }
}

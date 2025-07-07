package ru.mrlargha.commonui.elements.gasstation.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GasStationFuel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/domain/GasStationFuel;", "", "id", "", "title", "", FirebaseAnalytics.Param.PRICE, "available", "<init>", "(ILjava/lang/String;II)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPrice", "getAvailable", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GasStationFuel {
    private final int available;
    private final int id;
    private final int price;
    private final String title;

    public static /* synthetic */ GasStationFuel copy$default(GasStationFuel gasStationFuel, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = gasStationFuel.id;
        }
        if ((i4 & 2) != 0) {
            str = gasStationFuel.title;
        }
        if ((i4 & 4) != 0) {
            i2 = gasStationFuel.price;
        }
        if ((i4 & 8) != 0) {
            i3 = gasStationFuel.available;
        }
        return gasStationFuel.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.price;
    }

    public final int component4() {
        return this.available;
    }

    public final GasStationFuel copy(int i, String title, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new GasStationFuel(i, title, i2, i3);
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
        return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.available);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.price;
        return "GasStationFuel(id=" + i + ", title=" + str + ", price=" + i2 + ", available=" + this.available + ")";
    }

    public GasStationFuel(int i, String title, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.price = i2;
        this.available = i3;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }
}

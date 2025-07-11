package ru.mrlargha.commonui.elements.gasstation.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GasStationShop.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/domain/GasStationShop;", "", "id", "", "title", "", "image", FirebaseAnalytics.Param.PRICE, "<init>", "(ILjava/lang/String;II)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getPrice", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GasStationShop {
    private final int id;
    private final int image;
    private final int price;
    private final String title;

    public static /* synthetic */ GasStationShop copy$default(GasStationShop gasStationShop, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = gasStationShop.id;
        }
        if ((i4 & 2) != 0) {
            str = gasStationShop.title;
        }
        if ((i4 & 4) != 0) {
            i2 = gasStationShop.image;
        }
        if ((i4 & 8) != 0) {
            i3 = gasStationShop.price;
        }
        return gasStationShop.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.image;
    }

    public final int component4() {
        return this.price;
    }

    public final GasStationShop copy(int i, String title, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new GasStationShop(i, title, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GasStationShop) {
            GasStationShop gasStationShop = (GasStationShop) obj;
            return this.id == gasStationShop.id && Intrinsics.areEqual(this.title, gasStationShop.title) && this.image == gasStationShop.image && this.price == gasStationShop.price;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.price);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.image;
        return "GasStationShop(id=" + i + ", title=" + str + ", image=" + i2 + ", price=" + this.price + ")";
    }

    public GasStationShop(int i, String title, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.image = i2;
        this.price = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }
}

package ru.mrlargha.commonui.elements.gasstation.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GasStationShop.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/domain/GasStationShop;", "", "id", "", "title", "", "image", FirebaseAnalytics.Param.PRICE, "", "<init>", "(ILjava/lang/String;IJ)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getPrice", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GasStationShop {
    private final int id;
    private final int image;
    private final long price;
    private final String title;

    public static /* synthetic */ GasStationShop copy$default(GasStationShop gasStationShop, int i, String str, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gasStationShop.id;
        }
        if ((i3 & 2) != 0) {
            str = gasStationShop.title;
        }
        if ((i3 & 4) != 0) {
            i2 = gasStationShop.image;
        }
        if ((i3 & 8) != 0) {
            j = gasStationShop.price;
        }
        int i4 = i2;
        return gasStationShop.copy(i, str, i4, j);
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

    public final long component4() {
        return this.price;
    }

    public final GasStationShop copy(int i, String title, int i2, long j) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new GasStationShop(i, title, i2, j);
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
        return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Long.hashCode(this.price);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.image;
        return "GasStationShop(id=" + i + ", title=" + str + ", image=" + i2 + ", price=" + this.price + ")";
    }

    public GasStationShop(int i, String title, int i2, long j) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.image = i2;
        this.price = j;
    }

    public final int getId() {
        return this.id;
    }

    public final int getImage() {
        return this.image;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }
}

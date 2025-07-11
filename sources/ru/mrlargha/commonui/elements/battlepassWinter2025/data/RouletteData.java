package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RouletteData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/RouletteData;", "", "total", "", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.DISCOUNT, "name", "", "description", "<init>", "(IIILjava/lang/String;Ljava/lang/String;)V", "getTotal", "()I", "getPrice", "getDiscount", "getName", "()Ljava/lang/String;", "getDescription", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteData {
    private final String description;
    private final int discount;
    private final String name;
    private final int price;
    private final int total;

    public static /* synthetic */ RouletteData copy$default(RouletteData rouletteData, int i, int i2, int i3, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rouletteData.total;
        }
        if ((i4 & 2) != 0) {
            i2 = rouletteData.price;
        }
        if ((i4 & 4) != 0) {
            i3 = rouletteData.discount;
        }
        if ((i4 & 8) != 0) {
            str = rouletteData.name;
        }
        if ((i4 & 16) != 0) {
            str2 = rouletteData.description;
        }
        String str3 = str2;
        int i5 = i3;
        return rouletteData.copy(i, i2, i5, str, str3);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.price;
    }

    public final int component3() {
        return this.discount;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.description;
    }

    public final RouletteData copy(int i, int i2, int i3, String str, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new RouletteData(i, i2, i3, str, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RouletteData) {
            RouletteData rouletteData = (RouletteData) obj;
            return this.total == rouletteData.total && this.price == rouletteData.price && this.discount == rouletteData.discount && Intrinsics.areEqual(this.name, rouletteData.name) && Intrinsics.areEqual(this.description, rouletteData.description);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.total) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.discount)) * 31;
        String str = this.name;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode();
    }

    public String toString() {
        int i = this.total;
        int i2 = this.price;
        int i3 = this.discount;
        String str = this.name;
        return "RouletteData(total=" + i + ", price=" + i2 + ", discount=" + i3 + ", name=" + str + ", description=" + this.description + ")";
    }

    public RouletteData(int i, int i2, int i3, String str, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.total = i;
        this.price = i2;
        this.discount = i3;
        this.name = str;
        this.description = description;
    }

    public /* synthetic */ RouletteData(int i, int i2, int i3, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? "" : str, (i4 & 16) != 0 ? "" : str2);
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }
}

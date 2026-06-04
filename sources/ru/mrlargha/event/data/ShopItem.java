package ru.mrlargha.event.data;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lru/mrlargha/event/data/ShopItem;", "", "id", "", "name", "", "recived", "image", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.CURRENCY, "<init>", "(ILjava/lang/String;IIILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getRecived", "getImage", "getPrice", "getCurrency", "isAzCoins", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopItem {
    private final String currency;
    private final int id;
    private final int image;
    private final String name;
    private final int price;
    private final int recived;

    public static /* synthetic */ ShopItem copy$default(ShopItem shopItem, int i, String str, int i2, int i3, int i4, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = shopItem.id;
        }
        if ((i5 & 2) != 0) {
            str = shopItem.name;
        }
        if ((i5 & 4) != 0) {
            i2 = shopItem.recived;
        }
        if ((i5 & 8) != 0) {
            i3 = shopItem.image;
        }
        if ((i5 & 16) != 0) {
            i4 = shopItem.price;
        }
        if ((i5 & 32) != 0) {
            str2 = shopItem.currency;
        }
        int i6 = i4;
        String str3 = str2;
        return shopItem.copy(i, str, i2, i3, i6, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.recived;
    }

    public final int component4() {
        return this.image;
    }

    public final int component5() {
        return this.price;
    }

    public final String component6() {
        return this.currency;
    }

    public final ShopItem copy(int i, String name, int i2, int i3, int i4, String currency) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new ShopItem(i, name, i2, i3, i4, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopItem) {
            ShopItem shopItem = (ShopItem) obj;
            return this.id == shopItem.id && Intrinsics.areEqual(this.name, shopItem.name) && this.recived == shopItem.recived && this.image == shopItem.image && this.price == shopItem.price && Intrinsics.areEqual(this.currency, shopItem.currency);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.recived)) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.price)) * 31) + this.currency.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.recived;
        int i3 = this.image;
        int i4 = this.price;
        return "ShopItem(id=" + i + ", name=" + str + ", recived=" + i2 + ", image=" + i3 + ", price=" + i4 + ", currency=" + this.currency + ")";
    }

    public ShopItem(int i, String name, int i2, int i3, int i4, String currency) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.id = i;
        this.name = name;
        this.recived = i2;
        this.image = i3;
        this.price = i4;
        this.currency = currency;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRecived() {
        return this.recived;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final boolean isAzCoins() {
        return !Intrinsics.areEqual(this.currency, "coin");
    }
}

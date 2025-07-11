package ru.mrlargha.commonui.elements.easter.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/ShopItem;", "", "id", "", "name", "", "recived", "image", FirebaseAnalytics.Param.PRICE, "<init>", "(ILjava/lang/String;III)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getRecived", "getImage", "getPrice", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopItem {
    private final int id;
    private final int image;
    private final String name;
    private final int price;
    private final int recived;

    public static /* synthetic */ ShopItem copy$default(ShopItem shopItem, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
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
        int i6 = i4;
        int i7 = i2;
        return shopItem.copy(i, str, i7, i3, i6);
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

    public final ShopItem copy(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ShopItem(i, name, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopItem) {
            ShopItem shopItem = (ShopItem) obj;
            return this.id == shopItem.id && Intrinsics.areEqual(this.name, shopItem.name) && this.recived == shopItem.recived && this.image == shopItem.image && this.price == shopItem.price;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.recived)) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.price);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.recived;
        int i3 = this.image;
        return "ShopItem(id=" + i + ", name=" + str + ", recived=" + i2 + ", image=" + i3 + ", price=" + this.price + ")";
    }

    public ShopItem(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.recived = i2;
        this.image = i3;
        this.price = i4;
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
}

package ru.mrlargha.commonui.elements.catalog.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CatalogItemModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010(J\u0090\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00107J\u0014\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010;\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R%\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010 \"\u0004\b!\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R)\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "", "id", "", "title", "", FirebaseAnalytics.Param.PRICE, "img", "color", FirebaseAnalytics.Param.CURRENCY, "isSelected", "", "custom_price_str", "empty", "dummy", "url", "brightness", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/Float;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPrice", "Lcom/google/gson/annotations/SerializedName;", "value", "getImg", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrency", "()Z", "setSelected", "(Z)V", "getCustom_price_str", "getEmpty", "getDummy", "getUrl", "getBrightness", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/Float;)Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogItemModel {
    @SerializedName("brightness")
    private final Float brightness;
    private final Integer color;
    private final String currency;
    private final String custom_price_str;
    private final boolean dummy;
    private final boolean empty;
    private final int id;
    @SerializedName("img")
    private final String img;
    private boolean isSelected;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int price;
    private final String title;
    private final String url;

    public static /* synthetic */ CatalogItemModel copy$default(CatalogItemModel catalogItemModel, int i, String str, int i2, String str2, Integer num, String str3, boolean z, String str4, boolean z2, boolean z3, String str5, Float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = catalogItemModel.id;
        }
        if ((i3 & 2) != 0) {
            str = catalogItemModel.title;
        }
        if ((i3 & 4) != 0) {
            i2 = catalogItemModel.price;
        }
        if ((i3 & 8) != 0) {
            str2 = catalogItemModel.img;
        }
        if ((i3 & 16) != 0) {
            num = catalogItemModel.color;
        }
        if ((i3 & 32) != 0) {
            str3 = catalogItemModel.currency;
        }
        if ((i3 & 64) != 0) {
            z = catalogItemModel.isSelected;
        }
        if ((i3 & 128) != 0) {
            str4 = catalogItemModel.custom_price_str;
        }
        if ((i3 & 256) != 0) {
            z2 = catalogItemModel.empty;
        }
        if ((i3 & 512) != 0) {
            z3 = catalogItemModel.dummy;
        }
        if ((i3 & 1024) != 0) {
            str5 = catalogItemModel.url;
        }
        if ((i3 & 2048) != 0) {
            f = catalogItemModel.brightness;
        }
        String str6 = str5;
        Float f2 = f;
        boolean z4 = z2;
        boolean z5 = z3;
        boolean z6 = z;
        String str7 = str4;
        Integer num2 = num;
        String str8 = str3;
        return catalogItemModel.copy(i, str, i2, str2, num2, str8, z6, str7, z4, z5, str6, f2);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.dummy;
    }

    public final String component11() {
        return this.url;
    }

    public final Float component12() {
        return this.brightness;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.price;
    }

    public final String component4() {
        return this.img;
    }

    public final Integer component5() {
        return this.color;
    }

    public final String component6() {
        return this.currency;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final String component8() {
        return this.custom_price_str;
    }

    public final boolean component9() {
        return this.empty;
    }

    public final CatalogItemModel copy(int i, String title, int i2, String img, Integer num, String str, boolean z, String str2, boolean z2, boolean z3, String str3, Float f) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(img, "img");
        return new CatalogItemModel(i, title, i2, img, num, str, z, str2, z2, z3, str3, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CatalogItemModel) {
            CatalogItemModel catalogItemModel = (CatalogItemModel) obj;
            return this.id == catalogItemModel.id && Intrinsics.areEqual(this.title, catalogItemModel.title) && this.price == catalogItemModel.price && Intrinsics.areEqual(this.img, catalogItemModel.img) && Intrinsics.areEqual(this.color, catalogItemModel.color) && Intrinsics.areEqual(this.currency, catalogItemModel.currency) && this.isSelected == catalogItemModel.isSelected && Intrinsics.areEqual(this.custom_price_str, catalogItemModel.custom_price_str) && this.empty == catalogItemModel.empty && this.dummy == catalogItemModel.dummy && Intrinsics.areEqual(this.url, catalogItemModel.url) && Intrinsics.areEqual((Object) this.brightness, (Object) catalogItemModel.brightness);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.img.hashCode()) * 31;
        Integer num = this.color;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.currency;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isSelected)) * 31;
        String str2 = this.custom_price_str;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.empty)) * 31) + Boolean.hashCode(this.dummy)) * 31;
        String str3 = this.url;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f = this.brightness;
        return hashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.price;
        String str2 = this.img;
        Integer num = this.color;
        String str3 = this.currency;
        boolean z = this.isSelected;
        String str4 = this.custom_price_str;
        boolean z2 = this.empty;
        boolean z3 = this.dummy;
        String str5 = this.url;
        return "CatalogItemModel(id=" + i + ", title=" + str + ", price=" + i2 + ", img=" + str2 + ", color=" + num + ", currency=" + str3 + ", isSelected=" + z + ", custom_price_str=" + str4 + ", empty=" + z2 + ", dummy=" + z3 + ", url=" + str5 + ", brightness=" + this.brightness + ")";
    }

    public CatalogItemModel(int i, String title, int i2, String img, Integer num, String str, boolean z, String str2, boolean z2, boolean z3, String str3, Float f) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(img, "img");
        this.id = i;
        this.title = title;
        this.price = i2;
        this.img = img;
        this.color = num;
        this.currency = str;
        this.isSelected = z;
        this.custom_price_str = str2;
        this.empty = z2;
        this.dummy = z3;
        this.url = str3;
        this.brightness = f;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getImg() {
        return this.img;
    }

    public /* synthetic */ CatalogItemModel(int i, String str, int i2, String str2, Integer num, String str3, boolean z, String str4, boolean z2, boolean z3, String str5, Float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Float f2;
        CatalogItemModel catalogItemModel;
        int i4;
        String str6;
        int i5;
        String str7;
        String str8;
        Integer num2 = (i3 & 16) != 0 ? -1 : num;
        String str9 = (i3 & 32) != 0 ? null : str3;
        boolean z4 = (i3 & 64) != 0 ? false : z;
        boolean z5 = (i3 & 256) != 0 ? false : z2;
        boolean z6 = (i3 & 512) != 0 ? false : z3;
        String str10 = (i3 & 1024) != 0 ? null : str5;
        if ((i3 & 2048) != 0) {
            f2 = null;
            i4 = i;
            str6 = str;
            i5 = i2;
            str7 = str2;
            str8 = str4;
            catalogItemModel = this;
        } else {
            f2 = f;
            catalogItemModel = this;
            i4 = i;
            str6 = str;
            i5 = i2;
            str7 = str2;
            str8 = str4;
        }
        new CatalogItemModel(i4, str6, i5, str7, num2, str9, z4, str8, z5, z6, str10, f2);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getCustom_price_str() {
        return this.custom_price_str;
    }

    public final boolean getEmpty() {
        return this.empty;
    }

    public final boolean getDummy() {
        return this.dummy;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Float getBrightness() {
        return this.brightness;
    }
}

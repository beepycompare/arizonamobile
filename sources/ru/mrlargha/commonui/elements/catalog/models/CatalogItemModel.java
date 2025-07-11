package ru.mrlargha.commonui.elements.catalog.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CatalogItemModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/models/CatalogItemModel;", "", "id", "", "title", "", FirebaseAnalytics.Param.PRICE, "img", "color", FirebaseAnalytics.Param.CURRENCY, "isSelected", "", "<init>", "(ILjava/lang/String;IIILjava/lang/String;Z)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPrice", "getImg", "getColor", "getCurrency", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatalogItemModel {
    private final int color;
    private final String currency;
    private final int id;
    private final int img;
    private boolean isSelected;
    private final int price;
    private final String title;

    public static /* synthetic */ CatalogItemModel copy$default(CatalogItemModel catalogItemModel, int i, String str, int i2, int i3, int i4, String str2, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = catalogItemModel.id;
        }
        if ((i5 & 2) != 0) {
            str = catalogItemModel.title;
        }
        if ((i5 & 4) != 0) {
            i2 = catalogItemModel.price;
        }
        if ((i5 & 8) != 0) {
            i3 = catalogItemModel.img;
        }
        if ((i5 & 16) != 0) {
            i4 = catalogItemModel.color;
        }
        if ((i5 & 32) != 0) {
            str2 = catalogItemModel.currency;
        }
        if ((i5 & 64) != 0) {
            z = catalogItemModel.isSelected;
        }
        String str3 = str2;
        boolean z2 = z;
        int i6 = i4;
        int i7 = i2;
        return catalogItemModel.copy(i, str, i7, i3, i6, str3, z2);
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
        return this.img;
    }

    public final int component5() {
        return this.color;
    }

    public final String component6() {
        return this.currency;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final CatalogItemModel copy(int i, String title, int i2, int i3, int i4, String str, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new CatalogItemModel(i, title, i2, i3, i4, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CatalogItemModel) {
            CatalogItemModel catalogItemModel = (CatalogItemModel) obj;
            return this.id == catalogItemModel.id && Intrinsics.areEqual(this.title, catalogItemModel.title) && this.price == catalogItemModel.price && this.img == catalogItemModel.img && this.color == catalogItemModel.color && Intrinsics.areEqual(this.currency, catalogItemModel.currency) && this.isSelected == catalogItemModel.isSelected;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.img)) * 31) + Integer.hashCode(this.color)) * 31;
        String str = this.currency;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.price;
        int i3 = this.img;
        int i4 = this.color;
        String str2 = this.currency;
        return "CatalogItemModel(id=" + i + ", title=" + str + ", price=" + i2 + ", img=" + i3 + ", color=" + i4 + ", currency=" + str2 + ", isSelected=" + this.isSelected + ")";
    }

    public CatalogItemModel(int i, String title, int i2, int i3, int i4, String str, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.price = i2;
        this.img = i3;
        this.color = i4;
        this.currency = str;
        this.isSelected = z;
    }

    public /* synthetic */ CatalogItemModel(int i, String str, int i2, int i3, int i4, String str2, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, (i5 & 16) != 0 ? -1 : i4, (i5 & 32) != 0 ? null : str2, (i5 & 64) != 0 ? false : z);
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

    public final int getImg() {
        return this.img;
    }

    public final int getColor() {
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
}

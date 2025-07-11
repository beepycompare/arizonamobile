package ru.mrlargha.commonui.elements.authorization.presentation.api.obj;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Packs.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Packs;", "", "title", "", "image", "cash", "", FirebaseAnalytics.Param.PRICE, "priceBeforeDiscount", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getImage", "setImage", "getCash", "()Ljava/lang/Integer;", "setCash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrice", "setPrice", "getPriceBeforeDiscount", "setPriceBeforeDiscount", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Packs;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Packs {
    @SerializedName("cash")
    private Integer cash;
    @SerializedName("image")
    private String image;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private Integer price;
    @SerializedName("priceBeforeDiscount")
    private Integer priceBeforeDiscount;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public Packs() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Packs copy$default(Packs packs, String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = packs.title;
        }
        if ((i & 2) != 0) {
            str2 = packs.image;
        }
        if ((i & 4) != 0) {
            num = packs.cash;
        }
        if ((i & 8) != 0) {
            num2 = packs.price;
        }
        if ((i & 16) != 0) {
            num3 = packs.priceBeforeDiscount;
        }
        if ((i & 32) != 0) {
            str3 = packs.url;
        }
        Integer num4 = num3;
        String str4 = str3;
        return packs.copy(str, str2, num, num2, num4, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.image;
    }

    public final Integer component3() {
        return this.cash;
    }

    public final Integer component4() {
        return this.price;
    }

    public final Integer component5() {
        return this.priceBeforeDiscount;
    }

    public final String component6() {
        return this.url;
    }

    public final Packs copy(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        return new Packs(str, str2, num, num2, num3, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Packs) {
            Packs packs = (Packs) obj;
            return Intrinsics.areEqual(this.title, packs.title) && Intrinsics.areEqual(this.image, packs.image) && Intrinsics.areEqual(this.cash, packs.cash) && Intrinsics.areEqual(this.price, packs.price) && Intrinsics.areEqual(this.priceBeforeDiscount, packs.priceBeforeDiscount) && Intrinsics.areEqual(this.url, packs.url);
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.cash;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.price;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.priceBeforeDiscount;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.url;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.image;
        Integer num = this.cash;
        Integer num2 = this.price;
        Integer num3 = this.priceBeforeDiscount;
        return "Packs(title=" + str + ", image=" + str2 + ", cash=" + num + ", price=" + num2 + ", priceBeforeDiscount=" + num3 + ", url=" + this.url + ")";
    }

    public Packs(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        this.title = str;
        this.image = str2;
        this.cash = num;
        this.price = num2;
        this.priceBeforeDiscount = num3;
        this.url = str3;
    }

    public /* synthetic */ Packs(String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final Integer getCash() {
        return this.cash;
    }

    public final void setCash(Integer num) {
        this.cash = num;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final void setPrice(Integer num) {
        this.price = num;
    }

    public final Integer getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public final void setPriceBeforeDiscount(Integer num) {
        this.priceBeforeDiscount = num;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}

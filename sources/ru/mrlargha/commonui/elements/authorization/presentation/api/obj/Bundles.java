package ru.mrlargha.commonui.elements.authorization.presentation.api.obj;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Bundles.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jp\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012¨\u00062"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Bundles;", "", "title", "", "image", "cash", "", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", FirebaseAnalytics.Param.PRICE, "priceBeforeDiscount", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getImage", "setImage", "getCash", "()Ljava/lang/Integer;", "setCash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getPrice", "setPrice", "getPriceBeforeDiscount", "setPriceBeforeDiscount", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Bundles;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Bundles {
    @SerializedName("cash")
    private Integer cash;
    @SerializedName("image")
    private String image;
    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    private ArrayList<String> items;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private Integer price;
    @SerializedName("priceBeforeDiscount")
    private Integer priceBeforeDiscount;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public Bundles() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Bundles copy$default(Bundles bundles, String str, String str2, Integer num, ArrayList arrayList, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bundles.title;
        }
        if ((i & 2) != 0) {
            str2 = bundles.image;
        }
        if ((i & 4) != 0) {
            num = bundles.cash;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i & 8) != 0) {
            arrayList2 = bundles.items;
        }
        if ((i & 16) != 0) {
            num2 = bundles.price;
        }
        if ((i & 32) != 0) {
            num3 = bundles.priceBeforeDiscount;
        }
        if ((i & 64) != 0) {
            str3 = bundles.url;
        }
        Integer num4 = num3;
        String str4 = str3;
        Integer num5 = num2;
        Integer num6 = num;
        return bundles.copy(str, str2, num6, arrayList2, num5, num4, str4);
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

    public final ArrayList<String> component4() {
        return this.items;
    }

    public final Integer component5() {
        return this.price;
    }

    public final Integer component6() {
        return this.priceBeforeDiscount;
    }

    public final String component7() {
        return this.url;
    }

    public final Bundles copy(String str, String str2, Integer num, ArrayList<String> items, Integer num2, Integer num3, String str3) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new Bundles(str, str2, num, items, num2, num3, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bundles) {
            Bundles bundles = (Bundles) obj;
            return Intrinsics.areEqual(this.title, bundles.title) && Intrinsics.areEqual(this.image, bundles.image) && Intrinsics.areEqual(this.cash, bundles.cash) && Intrinsics.areEqual(this.items, bundles.items) && Intrinsics.areEqual(this.price, bundles.price) && Intrinsics.areEqual(this.priceBeforeDiscount, bundles.priceBeforeDiscount) && Intrinsics.areEqual(this.url, bundles.url);
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.cash;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.items.hashCode()) * 31;
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
        ArrayList<String> arrayList = this.items;
        Integer num2 = this.price;
        Integer num3 = this.priceBeforeDiscount;
        return "Bundles(title=" + str + ", image=" + str2 + ", cash=" + num + ", items=" + arrayList + ", price=" + num2 + ", priceBeforeDiscount=" + num3 + ", url=" + this.url + ")";
    }

    public Bundles(String str, String str2, Integer num, ArrayList<String> items, Integer num2, Integer num3, String str3) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.title = str;
        this.image = str2;
        this.cash = num;
        this.items = items;
        this.price = num2;
        this.priceBeforeDiscount = num3;
        this.url = str3;
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

    public /* synthetic */ Bundles(String str, String str2, Integer num, ArrayList arrayList, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? new ArrayList() : arrayList, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str3);
    }

    public final ArrayList<String> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
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

package ru.mrlargha.commonui.elements.authorization.presentation.api.obj;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shop.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tHÆ\u0003JZ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Shop;", "", "donateHandlerUrl", "", "exchangeRate", "", "bundles", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Bundles;", "Lkotlin/collections/ArrayList;", "packs", "Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Packs;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getDonateHandlerUrl", "()Ljava/lang/String;", "setDonateHandlerUrl", "(Ljava/lang/String;)V", "getExchangeRate", "()Ljava/lang/Integer;", "setExchangeRate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBundles", "()Ljava/util/ArrayList;", "setBundles", "(Ljava/util/ArrayList;)V", "getPacks", "setPacks", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/Shop;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Shop {
    @SerializedName("bundles")
    private ArrayList<Bundles> bundles;
    @SerializedName("donateHandlerUrl")
    private String donateHandlerUrl;
    @SerializedName("exchangeRate")
    private Integer exchangeRate;
    @SerializedName("packs")
    private ArrayList<Packs> packs;

    public Shop() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Shop copy$default(Shop shop, String str, Integer num, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shop.donateHandlerUrl;
        }
        if ((i & 2) != 0) {
            num = shop.exchangeRate;
        }
        if ((i & 4) != 0) {
            arrayList = shop.bundles;
        }
        if ((i & 8) != 0) {
            arrayList2 = shop.packs;
        }
        return shop.copy(str, num, arrayList, arrayList2);
    }

    public final String component1() {
        return this.donateHandlerUrl;
    }

    public final Integer component2() {
        return this.exchangeRate;
    }

    public final ArrayList<Bundles> component3() {
        return this.bundles;
    }

    public final ArrayList<Packs> component4() {
        return this.packs;
    }

    public final Shop copy(String str, Integer num, ArrayList<Bundles> bundles, ArrayList<Packs> packs) {
        Intrinsics.checkNotNullParameter(bundles, "bundles");
        Intrinsics.checkNotNullParameter(packs, "packs");
        return new Shop(str, num, bundles, packs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Shop) {
            Shop shop = (Shop) obj;
            return Intrinsics.areEqual(this.donateHandlerUrl, shop.donateHandlerUrl) && Intrinsics.areEqual(this.exchangeRate, shop.exchangeRate) && Intrinsics.areEqual(this.bundles, shop.bundles) && Intrinsics.areEqual(this.packs, shop.packs);
        }
        return false;
    }

    public int hashCode() {
        String str = this.donateHandlerUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.exchangeRate;
        return ((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.bundles.hashCode()) * 31) + this.packs.hashCode();
    }

    public String toString() {
        String str = this.donateHandlerUrl;
        Integer num = this.exchangeRate;
        ArrayList<Bundles> arrayList = this.bundles;
        return "Shop(donateHandlerUrl=" + str + ", exchangeRate=" + num + ", bundles=" + arrayList + ", packs=" + this.packs + ")";
    }

    public Shop(String str, Integer num, ArrayList<Bundles> bundles, ArrayList<Packs> packs) {
        Intrinsics.checkNotNullParameter(bundles, "bundles");
        Intrinsics.checkNotNullParameter(packs, "packs");
        this.donateHandlerUrl = str;
        this.exchangeRate = num;
        this.bundles = bundles;
        this.packs = packs;
    }

    public final String getDonateHandlerUrl() {
        return this.donateHandlerUrl;
    }

    public final void setDonateHandlerUrl(String str) {
        this.donateHandlerUrl = str;
    }

    public final Integer getExchangeRate() {
        return this.exchangeRate;
    }

    public final void setExchangeRate(Integer num) {
        this.exchangeRate = num;
    }

    public /* synthetic */ Shop(String str, Integer num, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? new ArrayList() : arrayList2);
    }

    public final ArrayList<Bundles> getBundles() {
        return this.bundles;
    }

    public final void setBundles(ArrayList<Bundles> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bundles = arrayList;
    }

    public final ArrayList<Packs> getPacks() {
        return this.packs;
    }

    public final void setPacks(ArrayList<Packs> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.packs = arrayList;
    }
}

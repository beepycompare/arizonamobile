package ru.mrlargha.arizonaui.donate.domain.obj;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateItem.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00108J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u000bHÆ\u0003J¬\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u000b2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u001e\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010'\"\u0004\b>\u0010)¨\u0006T"}, d2 = {"Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "", "id", "", "title", "", "image", "category", "categoryId", FirebaseAnalytics.Param.PRICE, "specialOffer", "", FirebaseAnalytics.Param.DISCOUNT, "limit", "currencyType", NotificationCompat.CATEGORY_STATUS, "text", "unix", "", "onClicked", "isSeason", "<init>", "(ILjava/lang/String;ILjava/lang/String;IIZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZZ)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getImage", "setImage", "(I)V", "getCategory", "setCategory", "getCategoryId", "setCategoryId", "getPrice", "setPrice", "getSpecialOffer", "()Z", "setSpecialOffer", "(Z)V", "getDiscount", "setDiscount", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCurrencyType", "setCurrencyType", "getStatus", "setStatus", "getText", "setText", "getUnix", "()Ljava/lang/Long;", "setUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOnClicked", "setOnClicked", "setSeason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILjava/lang/String;ILjava/lang/String;IIZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZZ)Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItem {
    private String category;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("currency_type")
    private Integer currencyType;
    private int discount;
    private final int id;
    private int image;
    @SerializedName("isSeason")
    private boolean isSeason;
    private Integer limit;
    private boolean onClicked;
    private int price;
    private boolean specialOffer;
    private String status;
    private String text;
    private String title;
    private Long unix;

    public final int component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.currencyType;
    }

    public final String component11() {
        return this.status;
    }

    public final String component12() {
        return this.text;
    }

    public final Long component13() {
        return this.unix;
    }

    public final boolean component14() {
        return this.onClicked;
    }

    public final boolean component15() {
        return this.isSeason;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.image;
    }

    public final String component4() {
        return this.category;
    }

    public final int component5() {
        return this.categoryId;
    }

    public final int component6() {
        return this.price;
    }

    public final boolean component7() {
        return this.specialOffer;
    }

    public final int component8() {
        return this.discount;
    }

    public final Integer component9() {
        return this.limit;
    }

    public final DonateItem copy(int i, String title, int i2, String category, int i3, int i4, boolean z, int i5, Integer num, Integer num2, String status, String str, Long l, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(status, "status");
        return new DonateItem(i, title, i2, category, i3, i4, z, i5, num, num2, status, str, l, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateItem) {
            DonateItem donateItem = (DonateItem) obj;
            return this.id == donateItem.id && Intrinsics.areEqual(this.title, donateItem.title) && this.image == donateItem.image && Intrinsics.areEqual(this.category, donateItem.category) && this.categoryId == donateItem.categoryId && this.price == donateItem.price && this.specialOffer == donateItem.specialOffer && this.discount == donateItem.discount && Intrinsics.areEqual(this.limit, donateItem.limit) && Intrinsics.areEqual(this.currencyType, donateItem.currencyType) && Intrinsics.areEqual(this.status, donateItem.status) && Intrinsics.areEqual(this.text, donateItem.text) && Intrinsics.areEqual(this.unix, donateItem.unix) && this.onClicked == donateItem.onClicked && this.isSeason == donateItem.isSeason;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + this.category.hashCode()) * 31) + Integer.hashCode(this.categoryId)) * 31) + Integer.hashCode(this.price)) * 31) + Boolean.hashCode(this.specialOffer)) * 31) + Integer.hashCode(this.discount)) * 31;
        Integer num = this.limit;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.currencyType;
        int hashCode3 = (((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.status.hashCode()) * 31;
        String str = this.text;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.unix;
        return ((((hashCode4 + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.onClicked)) * 31) + Boolean.hashCode(this.isSeason);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.image;
        String str2 = this.category;
        int i3 = this.categoryId;
        int i4 = this.price;
        boolean z = this.specialOffer;
        int i5 = this.discount;
        Integer num = this.limit;
        Integer num2 = this.currencyType;
        String str3 = this.status;
        String str4 = this.text;
        Long l = this.unix;
        boolean z2 = this.onClicked;
        return "DonateItem(id=" + i + ", title=" + str + ", image=" + i2 + ", category=" + str2 + ", categoryId=" + i3 + ", price=" + i4 + ", specialOffer=" + z + ", discount=" + i5 + ", limit=" + num + ", currencyType=" + num2 + ", status=" + str3 + ", text=" + str4 + ", unix=" + l + ", onClicked=" + z2 + ", isSeason=" + this.isSeason + ")";
    }

    public DonateItem(int i, String title, int i2, String category, int i3, int i4, boolean z, int i5, Integer num, Integer num2, String status, String str, Long l, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = i;
        this.title = title;
        this.image = i2;
        this.category = category;
        this.categoryId = i3;
        this.price = i4;
        this.specialOffer = z;
        this.discount = i5;
        this.limit = num;
        this.currencyType = num2;
        this.status = status;
        this.text = str;
        this.unix = l;
        this.onClicked = z2;
        this.isSeason = z3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final int getImage() {
        return this.image;
    }

    public final void setImage(int i) {
        this.image = i;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(int i) {
        this.categoryId = i;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }

    public final boolean getSpecialOffer() {
        return this.specialOffer;
    }

    public final void setSpecialOffer(boolean z) {
        this.specialOffer = z;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final void setDiscount(int i) {
        this.discount = i;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final void setLimit(Integer num) {
        this.limit = num;
    }

    public final Integer getCurrencyType() {
        return this.currencyType;
    }

    public final void setCurrencyType(Integer num) {
        this.currencyType = num;
    }

    public /* synthetic */ DonateItem(int i, String str, int i2, String str2, int i3, int i4, boolean z, int i5, Integer num, Integer num2, String str3, String str4, Long l, boolean z2, boolean z3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, str2, i3, i4, z, i5, num, (i6 & 512) != 0 ? 0 : num2, str3, (i6 & 2048) != 0 ? "" : str4, (i6 & 4096) != 0 ? 0L : l, (i6 & 8192) != 0 ? false : z2, (i6 & 16384) != 0 ? false : z3);
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Long getUnix() {
        return this.unix;
    }

    public final void setUnix(Long l) {
        this.unix = l;
    }

    public final boolean getOnClicked() {
        return this.onClicked;
    }

    public final void setOnClicked(boolean z) {
        this.onClicked = z;
    }

    public final boolean isSeason() {
        return this.isSeason;
    }

    public final void setSeason(boolean z) {
        this.isSeason = z;
    }
}

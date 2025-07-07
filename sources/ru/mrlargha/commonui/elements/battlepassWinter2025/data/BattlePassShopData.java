package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import android.graphics.Bitmap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassShopData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassShopData;", "", "itemId", "", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.DISCOUNT, "priceWithDiscount", "isSelected", "", "savedName", "", "savedImage", "Landroid/graphics/Bitmap;", "<init>", "(IIIIZLjava/lang/String;Landroid/graphics/Bitmap;)V", "getItemId", "()I", "getPrice", "getDiscount", "getPriceWithDiscount", "()Z", "setSelected", "(Z)V", "getSavedName", "()Ljava/lang/String;", "setSavedName", "(Ljava/lang/String;)V", "getSavedImage", "()Landroid/graphics/Bitmap;", "setSavedImage", "(Landroid/graphics/Bitmap;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BattlePassShopData {
    private final int discount;
    private boolean isSelected;
    @SerializedName(FirebaseAnalytics.Param.ITEM_ID)
    private final int itemId;
    private final int price;
    private final int priceWithDiscount;
    private Bitmap savedImage;
    private String savedName;

    public static /* synthetic */ BattlePassShopData copy$default(BattlePassShopData battlePassShopData, int i, int i2, int i3, int i4, boolean z, String str, Bitmap bitmap, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = battlePassShopData.itemId;
        }
        if ((i5 & 2) != 0) {
            i2 = battlePassShopData.price;
        }
        if ((i5 & 4) != 0) {
            i3 = battlePassShopData.discount;
        }
        if ((i5 & 8) != 0) {
            i4 = battlePassShopData.priceWithDiscount;
        }
        if ((i5 & 16) != 0) {
            z = battlePassShopData.isSelected;
        }
        if ((i5 & 32) != 0) {
            str = battlePassShopData.savedName;
        }
        if ((i5 & 64) != 0) {
            bitmap = battlePassShopData.savedImage;
        }
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        boolean z2 = z;
        int i6 = i3;
        return battlePassShopData.copy(i, i2, i6, i4, z2, str2, bitmap2);
    }

    public final int component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.price;
    }

    public final int component3() {
        return this.discount;
    }

    public final int component4() {
        return this.priceWithDiscount;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final String component6() {
        return this.savedName;
    }

    public final Bitmap component7() {
        return this.savedImage;
    }

    public final BattlePassShopData copy(int i, int i2, int i3, int i4, boolean z, String savedName, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(savedName, "savedName");
        return new BattlePassShopData(i, i2, i3, i4, z, savedName, bitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassShopData) {
            BattlePassShopData battlePassShopData = (BattlePassShopData) obj;
            return this.itemId == battlePassShopData.itemId && this.price == battlePassShopData.price && this.discount == battlePassShopData.discount && this.priceWithDiscount == battlePassShopData.priceWithDiscount && this.isSelected == battlePassShopData.isSelected && Intrinsics.areEqual(this.savedName, battlePassShopData.savedName) && Intrinsics.areEqual(this.savedImage, battlePassShopData.savedImage);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((Integer.hashCode(this.itemId) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.priceWithDiscount)) * 31) + Boolean.hashCode(this.isSelected)) * 31) + this.savedName.hashCode()) * 31;
        Bitmap bitmap = this.savedImage;
        return hashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    public String toString() {
        int i = this.itemId;
        int i2 = this.price;
        int i3 = this.discount;
        int i4 = this.priceWithDiscount;
        boolean z = this.isSelected;
        String str = this.savedName;
        return "BattlePassShopData(itemId=" + i + ", price=" + i2 + ", discount=" + i3 + ", priceWithDiscount=" + i4 + ", isSelected=" + z + ", savedName=" + str + ", savedImage=" + this.savedImage + ")";
    }

    public BattlePassShopData(int i, int i2, int i3, int i4, boolean z, String savedName, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(savedName, "savedName");
        this.itemId = i;
        this.price = i2;
        this.discount = i3;
        this.priceWithDiscount = i4;
        this.isSelected = z;
        this.savedName = savedName;
        this.savedImage = bitmap;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getDiscount() {
        return this.discount;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BattlePassShopData(int i, int i2, int i3, int i4, boolean z, String str, Bitmap bitmap, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? (i2 * i3) / 100 : i4, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? "" : str, (i5 & 64) != 0 ? null : bitmap);
        i3 = (i5 & 4) != 0 ? 0 : i3;
    }

    public final int getPriceWithDiscount() {
        return this.priceWithDiscount;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getSavedName() {
        return this.savedName;
    }

    public final void setSavedName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.savedName = str;
    }

    public final Bitmap getSavedImage() {
        return this.savedImage;
    }

    public final void setSavedImage(Bitmap bitmap) {
        this.savedImage = bitmap;
    }
}

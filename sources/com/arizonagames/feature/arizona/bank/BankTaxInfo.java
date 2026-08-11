package com.arizonagames.feature.arizona.bank;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÂ\u0003J\t\u00102\u001a\u00020\tHÂ\u0003J[\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0014\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R%\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015Rc\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002J\b\u001d\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012<\b\u001e\u00128\b\fJ\u0004\b\b(\u001fJ\u0004\b\b( J\u0004\b\b(!J\u0004\b\b(\"J\u0004\b\b(#J\u0004\b\b($J\u0004\b\b(%J\u0004\b\b(&J\u0004\b\b('¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R.\u0010\f\u001a\u00020\t8\u0002X\u0083\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u0019\u0012\u0004\b\b((\u0092\u0002\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u0002\n\u0000R.\u0010\r\u001a\u00020\t8\u0002X\u0083\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u0019\u0012\u0004\b\b()\u0092\u0002\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b*\u0010\u0017¨\u00068"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankTaxInfo;", "", "id", "", FirebaseAnalytics.Param.TAX, "", "tag", "", "warning", "", "title", "imgPath", "disabledValue", "diasabledValue", "<init>", "(IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()I", "getTax", "()J", "getTag", "()Ljava/lang/String;", "getWarning", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getTitle", "getImgPath", "Lcom/google/gson/annotations/SerializedName;", "alternate", "img", "image", "icon", "imagePath", "imageUrl", "iconPath", "img_path", "image_path", "url", "disabled", "diasabled", "getDisabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankTaxInfo {
    @SerializedName("diasabled")
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean diasabledValue;
    @SerializedName("disabled")
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean disabledValue;
    private final int id;
    @SerializedName(alternate = {"img", "image", "icon", "imagePath", "imageUrl", "iconPath", "img_path", "image_path", "url"}, value = "imgPath")
    private final String imgPath;
    private final String tag;
    private final long tax;
    private final String title;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean warning;

    public BankTaxInfo() {
        this(0, 0L, null, false, null, null, false, false, 255, null);
    }

    private final boolean component7() {
        return this.disabledValue;
    }

    private final boolean component8() {
        return this.diasabledValue;
    }

    public static /* synthetic */ BankTaxInfo copy$default(BankTaxInfo bankTaxInfo, int i, long j, String str, boolean z, String str2, String str3, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankTaxInfo.id;
        }
        if ((i2 & 2) != 0) {
            j = bankTaxInfo.tax;
        }
        if ((i2 & 4) != 0) {
            str = bankTaxInfo.tag;
        }
        if ((i2 & 8) != 0) {
            z = bankTaxInfo.warning;
        }
        if ((i2 & 16) != 0) {
            str2 = bankTaxInfo.title;
        }
        if ((i2 & 32) != 0) {
            str3 = bankTaxInfo.imgPath;
        }
        if ((i2 & 64) != 0) {
            z2 = bankTaxInfo.disabledValue;
        }
        if ((i2 & 128) != 0) {
            z3 = bankTaxInfo.diasabledValue;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        return bankTaxInfo.copy(i, j, str, z, str2, str3, z4, z5);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.tax;
    }

    public final String component3() {
        return this.tag;
    }

    public final boolean component4() {
        return this.warning;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.imgPath;
    }

    public final BankTaxInfo copy(int i, long j, String str, boolean z, String title, String imgPath, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        return new BankTaxInfo(i, j, str, z, title, imgPath, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankTaxInfo) {
            BankTaxInfo bankTaxInfo = (BankTaxInfo) obj;
            return this.id == bankTaxInfo.id && this.tax == bankTaxInfo.tax && Intrinsics.areEqual(this.tag, bankTaxInfo.tag) && this.warning == bankTaxInfo.warning && Intrinsics.areEqual(this.title, bankTaxInfo.title) && Intrinsics.areEqual(this.imgPath, bankTaxInfo.imgPath) && this.disabledValue == bankTaxInfo.disabledValue && this.diasabledValue == bankTaxInfo.diasabledValue;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Long.hashCode(this.tax)) * 31;
        String str = this.tag;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.warning)) * 31) + this.title.hashCode()) * 31) + this.imgPath.hashCode()) * 31) + Boolean.hashCode(this.disabledValue)) * 31) + Boolean.hashCode(this.diasabledValue);
    }

    public String toString() {
        int i = this.id;
        long j = this.tax;
        String str = this.tag;
        boolean z = this.warning;
        String str2 = this.title;
        String str3 = this.imgPath;
        boolean z2 = this.disabledValue;
        return "BankTaxInfo(id=" + i + ", tax=" + j + ", tag=" + str + ", warning=" + z + ", title=" + str2 + ", imgPath=" + str3 + ", disabledValue=" + z2 + ", diasabledValue=" + this.diasabledValue + ")";
    }

    public BankTaxInfo(int i, long j, String str, boolean z, String title, String imgPath, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        this.id = i;
        this.tax = j;
        this.tag = str;
        this.warning = z;
        this.title = title;
        this.imgPath = imgPath;
        this.disabledValue = z2;
        this.diasabledValue = z3;
    }

    public /* synthetic */ BankTaxInfo(int i, long j, String str, boolean z, String str2, String str3, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? false : z3);
    }

    public final int getId() {
        return this.id;
    }

    public final long getTax() {
        return this.tax;
    }

    public final String getTag() {
        return this.tag;
    }

    public final boolean getWarning() {
        return this.warning;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final boolean getDisabled() {
        return this.disabledValue || this.diasabledValue;
    }
}

package ru.mrlargha.feature.arizona.cases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jd\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006+"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "", "item", "", "garante", "count", "bgColor", "", "shards", "isVehicle", "custom_image", "custom_name", "<init>", "(IIILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getItem", "()I", "getGarante", "getCount", "getBgColor", "()Ljava/lang/String;", "getShards", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustom_image", "getCustom_name", "getGaranteX", "getBgType", "Lru/mrlargha/feature/arizona/cases/CasesBgType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IIILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "equals", "", "other", "hashCode", "toString", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesGuaranteedPrizeModel {
    private final String bgColor;
    private final int count;
    private final Integer custom_image;
    private final String custom_name;
    private final int garante;
    private final Integer isVehicle;
    private final int item;
    private final int shards;

    public static /* synthetic */ CasesGuaranteedPrizeModel copy$default(CasesGuaranteedPrizeModel casesGuaranteedPrizeModel, int i, int i2, int i3, String str, int i4, Integer num, Integer num2, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = casesGuaranteedPrizeModel.item;
        }
        if ((i5 & 2) != 0) {
            i2 = casesGuaranteedPrizeModel.garante;
        }
        if ((i5 & 4) != 0) {
            i3 = casesGuaranteedPrizeModel.count;
        }
        if ((i5 & 8) != 0) {
            str = casesGuaranteedPrizeModel.bgColor;
        }
        if ((i5 & 16) != 0) {
            i4 = casesGuaranteedPrizeModel.shards;
        }
        if ((i5 & 32) != 0) {
            num = casesGuaranteedPrizeModel.isVehicle;
        }
        if ((i5 & 64) != 0) {
            num2 = casesGuaranteedPrizeModel.custom_image;
        }
        if ((i5 & 128) != 0) {
            str2 = casesGuaranteedPrizeModel.custom_name;
        }
        Integer num3 = num2;
        String str3 = str2;
        int i6 = i4;
        Integer num4 = num;
        return casesGuaranteedPrizeModel.copy(i, i2, i3, str, i6, num4, num3, str3);
    }

    public final int component1() {
        return this.item;
    }

    public final int component2() {
        return this.garante;
    }

    public final int component3() {
        return this.count;
    }

    public final String component4() {
        return this.bgColor;
    }

    public final int component5() {
        return this.shards;
    }

    public final Integer component6() {
        return this.isVehicle;
    }

    public final Integer component7() {
        return this.custom_image;
    }

    public final String component8() {
        return this.custom_name;
    }

    public final CasesGuaranteedPrizeModel copy(int i, int i2, int i3, String bgColor, int i4, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return new CasesGuaranteedPrizeModel(i, i2, i3, bgColor, i4, num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesGuaranteedPrizeModel) {
            CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = (CasesGuaranteedPrizeModel) obj;
            return this.item == casesGuaranteedPrizeModel.item && this.garante == casesGuaranteedPrizeModel.garante && this.count == casesGuaranteedPrizeModel.count && Intrinsics.areEqual(this.bgColor, casesGuaranteedPrizeModel.bgColor) && this.shards == casesGuaranteedPrizeModel.shards && Intrinsics.areEqual(this.isVehicle, casesGuaranteedPrizeModel.isVehicle) && Intrinsics.areEqual(this.custom_image, casesGuaranteedPrizeModel.custom_image) && Intrinsics.areEqual(this.custom_name, casesGuaranteedPrizeModel.custom_name);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.item) * 31) + Integer.hashCode(this.garante)) * 31) + Integer.hashCode(this.count)) * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.shards)) * 31;
        Integer num = this.isVehicle;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.custom_image;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.custom_name;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        int i = this.item;
        int i2 = this.garante;
        int i3 = this.count;
        String str = this.bgColor;
        int i4 = this.shards;
        Integer num = this.isVehicle;
        Integer num2 = this.custom_image;
        return "CasesGuaranteedPrizeModel(item=" + i + ", garante=" + i2 + ", count=" + i3 + ", bgColor=" + str + ", shards=" + i4 + ", isVehicle=" + num + ", custom_image=" + num2 + ", custom_name=" + this.custom_name + ")";
    }

    public CasesGuaranteedPrizeModel(int i, int i2, int i3, String bgColor, int i4, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.item = i;
        this.garante = i2;
        this.count = i3;
        this.bgColor = bgColor;
        this.shards = i4;
        this.isVehicle = num;
        this.custom_image = num2;
        this.custom_name = str;
    }

    public /* synthetic */ CasesGuaranteedPrizeModel(int i, int i2, int i3, String str, int i4, Integer num, Integer num2, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, i4, (i5 & 32) != 0 ? null : num, (i5 & 64) != 0 ? null : num2, (i5 & 128) != 0 ? null : str2);
    }

    public final int getItem() {
        return this.item;
    }

    public final int getGarante() {
        return this.garante;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getShards() {
        return this.shards;
    }

    public final Integer isVehicle() {
        return this.isVehicle;
    }

    public final Integer getCustom_image() {
        return this.custom_image;
    }

    public final String getCustom_name() {
        return this.custom_name;
    }

    public final String getGaranteX() {
        return "X" + this.garante;
    }

    /* renamed from: getCount  reason: collision with other method in class */
    public final String m11887getCount() {
        if (this.count > 1) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
            decimalFormatSymbols.setGroupingSeparator(' ');
            String string = CasesResponseKt.getAppContext().getString(R.string.cases_count_amount, new DecimalFormat("#,###", decimalFormatSymbols).format(Integer.valueOf(this.count)));
            Intrinsics.checkNotNull(string);
            return string;
        }
        return "";
    }

    public final CasesBgType getBgType() {
        Object obj;
        Iterator<E> it = CasesBgType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CasesBgType) obj).getBgName(), this.bgColor)) {
                break;
            }
        }
        CasesBgType casesBgType = (CasesBgType) obj;
        return casesBgType == null ? CasesBgType.NONE : casesBgType;
    }
}

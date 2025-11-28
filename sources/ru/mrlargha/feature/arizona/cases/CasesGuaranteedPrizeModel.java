package ru.mrlargha.feature.arizona.cases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014JX\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014¨\u0006("}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "", "item", "", "garante", "count", "bgColor", "", "shards", "isVehicle", "custom_image", "<init>", "(IIILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getItem", "()I", "getGarante", "getCount", "getBgColor", "()Ljava/lang/String;", "getShards", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustom_image", "getGaranteX", "getBgType", "Lru/mrlargha/feature/arizona/cases/CasesBgType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "equals", "", "other", "hashCode", "toString", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesGuaranteedPrizeModel {
    private final String bgColor;
    private final int count;
    private final Integer custom_image;
    private final int garante;
    private final Integer isVehicle;
    private final int item;
    private final int shards;

    public static /* synthetic */ CasesGuaranteedPrizeModel copy$default(CasesGuaranteedPrizeModel casesGuaranteedPrizeModel, int i, int i2, int i3, String str, int i4, Integer num, Integer num2, int i5, Object obj) {
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
        Integer num3 = num;
        Integer num4 = num2;
        int i6 = i4;
        int i7 = i3;
        return casesGuaranteedPrizeModel.copy(i, i2, i7, str, i6, num3, num4);
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

    public final CasesGuaranteedPrizeModel copy(int i, int i2, int i3, String bgColor, int i4, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return new CasesGuaranteedPrizeModel(i, i2, i3, bgColor, i4, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesGuaranteedPrizeModel) {
            CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = (CasesGuaranteedPrizeModel) obj;
            return this.item == casesGuaranteedPrizeModel.item && this.garante == casesGuaranteedPrizeModel.garante && this.count == casesGuaranteedPrizeModel.count && Intrinsics.areEqual(this.bgColor, casesGuaranteedPrizeModel.bgColor) && this.shards == casesGuaranteedPrizeModel.shards && Intrinsics.areEqual(this.isVehicle, casesGuaranteedPrizeModel.isVehicle) && Intrinsics.areEqual(this.custom_image, casesGuaranteedPrizeModel.custom_image);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.item) * 31) + Integer.hashCode(this.garante)) * 31) + Integer.hashCode(this.count)) * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.shards)) * 31;
        Integer num = this.isVehicle;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.custom_image;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        int i = this.item;
        int i2 = this.garante;
        int i3 = this.count;
        String str = this.bgColor;
        int i4 = this.shards;
        Integer num = this.isVehicle;
        return "CasesGuaranteedPrizeModel(item=" + i + ", garante=" + i2 + ", count=" + i3 + ", bgColor=" + str + ", shards=" + i4 + ", isVehicle=" + num + ", custom_image=" + this.custom_image + ")";
    }

    public CasesGuaranteedPrizeModel(int i, int i2, int i3, String bgColor, int i4, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.item = i;
        this.garante = i2;
        this.count = i3;
        this.bgColor = bgColor;
        this.shards = i4;
        this.isVehicle = num;
        this.custom_image = num2;
    }

    public /* synthetic */ CasesGuaranteedPrizeModel(int i, int i2, int i3, String str, int i4, Integer num, Integer num2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, i4, (i5 & 32) != 0 ? null : num, (i5 & 64) != 0 ? null : num2);
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

    public final String getGaranteX() {
        return "X" + this.garante;
    }

    /* renamed from: getCount  reason: collision with other method in class */
    public final String m12067getCount() {
        if (this.count > 1) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
            decimalFormatSymbols.setGroupingSeparator(' ');
            return new DecimalFormat("#,###", decimalFormatSymbols).format(Integer.valueOf(this.count)) + " шт.";
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

package ru.mrlargha.feature.arizona.cases.data.remote.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
/* compiled from: CasesModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jd\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR%\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR%\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\t\u0010\u0018R)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R'\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006-"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesPrizeModel;", "", "item", "", "bgColor", "", "shards", "garante", "count", "isVehicle", "custom_image", "custom_name", "<init>", "(ILjava/lang/String;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getItem", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getBgColor", "()Ljava/lang/String;", "rarity", "getShards", "getGarante", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustom_image", "getCustom_name", "toModel", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesPrizeModel;", "equals", "", "other", "hashCode", "toString", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesPrizeModel {
    @SerializedName("rarity")
    private final String bgColor;
    @SerializedName("count")
    private final int count;
    @SerializedName("custom_image")
    private final Integer custom_image;
    @SerializedName("custom_name")
    private final String custom_name;
    @SerializedName("garante")
    private final int garante;
    @SerializedName("isVehicle")
    private final Integer isVehicle;
    @SerializedName("item")
    private final int item;
    @SerializedName("shards")
    private final int shards;

    public static /* synthetic */ CasesPrizeModel copy$default(CasesPrizeModel casesPrizeModel, int i, String str, int i2, int i3, int i4, Integer num, Integer num2, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = casesPrizeModel.item;
        }
        if ((i5 & 2) != 0) {
            str = casesPrizeModel.bgColor;
        }
        if ((i5 & 4) != 0) {
            i2 = casesPrizeModel.shards;
        }
        if ((i5 & 8) != 0) {
            i3 = casesPrizeModel.garante;
        }
        if ((i5 & 16) != 0) {
            i4 = casesPrizeModel.count;
        }
        if ((i5 & 32) != 0) {
            num = casesPrizeModel.isVehicle;
        }
        if ((i5 & 64) != 0) {
            num2 = casesPrizeModel.custom_image;
        }
        if ((i5 & 128) != 0) {
            str2 = casesPrizeModel.custom_name;
        }
        Integer num3 = num2;
        String str3 = str2;
        int i6 = i4;
        Integer num4 = num;
        return casesPrizeModel.copy(i, str, i2, i3, i6, num4, num3, str3);
    }

    public final int component1() {
        return this.item;
    }

    public final String component2() {
        return this.bgColor;
    }

    public final int component3() {
        return this.shards;
    }

    public final int component4() {
        return this.garante;
    }

    public final int component5() {
        return this.count;
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

    public final CasesPrizeModel copy(int i, String bgColor, int i2, int i3, int i4, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return new CasesPrizeModel(i, bgColor, i2, i3, i4, num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesPrizeModel) {
            CasesPrizeModel casesPrizeModel = (CasesPrizeModel) obj;
            return this.item == casesPrizeModel.item && Intrinsics.areEqual(this.bgColor, casesPrizeModel.bgColor) && this.shards == casesPrizeModel.shards && this.garante == casesPrizeModel.garante && this.count == casesPrizeModel.count && Intrinsics.areEqual(this.isVehicle, casesPrizeModel.isVehicle) && Intrinsics.areEqual(this.custom_image, casesPrizeModel.custom_image) && Intrinsics.areEqual(this.custom_name, casesPrizeModel.custom_name);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.item) * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.shards)) * 31) + Integer.hashCode(this.garante)) * 31) + Integer.hashCode(this.count)) * 31;
        Integer num = this.isVehicle;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.custom_image;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.custom_name;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        int i = this.item;
        String str = this.bgColor;
        int i2 = this.shards;
        int i3 = this.garante;
        int i4 = this.count;
        Integer num = this.isVehicle;
        Integer num2 = this.custom_image;
        return "CasesPrizeModel(item=" + i + ", bgColor=" + str + ", shards=" + i2 + ", garante=" + i3 + ", count=" + i4 + ", isVehicle=" + num + ", custom_image=" + num2 + ", custom_name=" + this.custom_name + ")";
    }

    public CasesPrizeModel(int i, String bgColor, int i2, int i3, int i4, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.item = i;
        this.bgColor = bgColor;
        this.shards = i2;
        this.garante = i3;
        this.count = i4;
        this.isVehicle = num;
        this.custom_image = num2;
        this.custom_name = str;
    }

    public final int getItem() {
        return this.item;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getShards() {
        return this.shards;
    }

    public final int getGarante() {
        return this.garante;
    }

    public final int getCount() {
        return this.count;
    }

    public final Integer isVehicle() {
        return this.isVehicle;
    }

    public final Integer getCustom_image() {
        return this.custom_image;
    }

    public /* synthetic */ CasesPrizeModel(int i, String str, int i2, int i3, int i4, Integer num, Integer num2, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, (i5 & 32) != 0 ? null : num, (i5 & 64) != 0 ? null : num2, (i5 & 128) != 0 ? "" : str2);
    }

    public final String getCustom_name() {
        return this.custom_name;
    }

    public final CasesGuaranteedPrizeModel toModel() {
        return new CasesGuaranteedPrizeModel(this.item, this.garante, this.count, this.bgColor, this.shards, this.isVehicle, this.custom_image, this.custom_name);
    }
}

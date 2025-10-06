package ru.mrlargha.feature.arizona.cases.data.remote.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
/* compiled from: CasesModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\t\u0010\u0013¨\u0006$"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesPrizeModel;", "", "item", "", "bgColor", "", "shards", "garante", "count", "isVehicle", "<init>", "(ILjava/lang/String;IIILjava/lang/Integer;)V", "getItem", "()I", "getBgColor", "()Ljava/lang/String;", "getShards", "getGarante", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toModel", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;IIILjava/lang/Integer;)Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesPrizeModel;", "equals", "", "other", "hashCode", "toString", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesPrizeModel {
    @SerializedName("rarity")
    private final String bgColor;
    @SerializedName("count")
    private final int count;
    @SerializedName("garante")
    private final int garante;
    @SerializedName("isVehicle")
    private final Integer isVehicle;
    @SerializedName("item")
    private final int item;
    @SerializedName("shards")
    private final int shards;

    public static /* synthetic */ CasesPrizeModel copy$default(CasesPrizeModel casesPrizeModel, int i, String str, int i2, int i3, int i4, Integer num, int i5, Object obj) {
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
        int i6 = i4;
        Integer num2 = num;
        return casesPrizeModel.copy(i, str, i2, i3, i6, num2);
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

    public final CasesPrizeModel copy(int i, String bgColor, int i2, int i3, int i4, Integer num) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return new CasesPrizeModel(i, bgColor, i2, i3, i4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesPrizeModel) {
            CasesPrizeModel casesPrizeModel = (CasesPrizeModel) obj;
            return this.item == casesPrizeModel.item && Intrinsics.areEqual(this.bgColor, casesPrizeModel.bgColor) && this.shards == casesPrizeModel.shards && this.garante == casesPrizeModel.garante && this.count == casesPrizeModel.count && Intrinsics.areEqual(this.isVehicle, casesPrizeModel.isVehicle);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.item) * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.shards)) * 31) + Integer.hashCode(this.garante)) * 31) + Integer.hashCode(this.count)) * 31;
        Integer num = this.isVehicle;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i = this.item;
        String str = this.bgColor;
        int i2 = this.shards;
        int i3 = this.garante;
        int i4 = this.count;
        return "CasesPrizeModel(item=" + i + ", bgColor=" + str + ", shards=" + i2 + ", garante=" + i3 + ", count=" + i4 + ", isVehicle=" + this.isVehicle + ")";
    }

    public CasesPrizeModel(int i, String bgColor, int i2, int i3, int i4, Integer num) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.item = i;
        this.bgColor = bgColor;
        this.shards = i2;
        this.garante = i3;
        this.count = i4;
        this.isVehicle = num;
    }

    public /* synthetic */ CasesPrizeModel(int i, String str, int i2, int i3, int i4, Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, (i5 & 32) != 0 ? null : num);
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

    public final CasesGuaranteedPrizeModel toModel() {
        return new CasesGuaranteedPrizeModel(this.item, this.garante, this.count, this.bgColor, this.shards, this.isVehicle);
    }
}

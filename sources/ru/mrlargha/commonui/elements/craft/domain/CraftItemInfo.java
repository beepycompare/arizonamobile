package ru.mrlargha.commonui.elements.craft.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0090\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010?J\u0014\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010C\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010D\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR%\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R%\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R%\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(&¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R%\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b((¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R%\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(-¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R5\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u0092\u0002\u001a\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(0\u0012\f\b1\u0012\b\b\fJ\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006E"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "", "available", "", "chance", "", "cost", "", "totalCost", "exp", "hasColor", "needs", "", "Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "showInfo", "itemType", "amount", "maxCount", "description", "", "<init>", "(IFJJFILjava/util/List;IILjava/lang/Integer;ILjava/lang/String;)V", "getAvailable", "()I", "getChance", "()F", "getCost", "()J", "getTotalCost", "Lcom/google/gson/annotations/SerializedName;", "value", "total_cost", "getExp", "getHasColor", "has_color", "getNeeds", "()Ljava/util/List;", "getShowInfo", "show_info", "getItemType", "item_type", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxCount", "max_count", "getDescription", "()Ljava/lang/String;", "desc", "alternate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(IFJJFILjava/util/List;IILjava/lang/Integer;ILjava/lang/String;)Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CraftItemInfo {
    private final Integer amount;
    private final int available;
    private final float chance;
    private final long cost;
    @SerializedName(alternate = {"description"}, value = "desc")
    private final String description;
    private final float exp;
    @SerializedName("has_color")
    private final int hasColor;
    @SerializedName("item_type")
    private final int itemType;
    @SerializedName("max_count")
    private final int maxCount;
    @SerializedName("needs")
    private final List<NeedItems> needs;
    @SerializedName("show_info")
    private final int showInfo;
    @SerializedName("total_cost")
    private final long totalCost;

    public final int component1() {
        return this.available;
    }

    public final Integer component10() {
        return this.amount;
    }

    public final int component11() {
        return this.maxCount;
    }

    public final String component12() {
        return this.description;
    }

    public final float component2() {
        return this.chance;
    }

    public final long component3() {
        return this.cost;
    }

    public final long component4() {
        return this.totalCost;
    }

    public final float component5() {
        return this.exp;
    }

    public final int component6() {
        return this.hasColor;
    }

    public final List<NeedItems> component7() {
        return this.needs;
    }

    public final int component8() {
        return this.showInfo;
    }

    public final int component9() {
        return this.itemType;
    }

    public final CraftItemInfo copy(int i, float f, long j, long j2, float f2, int i2, List<NeedItems> needs, int i3, int i4, Integer num, int i5, String str) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        return new CraftItemInfo(i, f, j, j2, f2, i2, needs, i3, i4, num, i5, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CraftItemInfo) {
            CraftItemInfo craftItemInfo = (CraftItemInfo) obj;
            return this.available == craftItemInfo.available && Float.compare(this.chance, craftItemInfo.chance) == 0 && this.cost == craftItemInfo.cost && this.totalCost == craftItemInfo.totalCost && Float.compare(this.exp, craftItemInfo.exp) == 0 && this.hasColor == craftItemInfo.hasColor && Intrinsics.areEqual(this.needs, craftItemInfo.needs) && this.showInfo == craftItemInfo.showInfo && this.itemType == craftItemInfo.itemType && Intrinsics.areEqual(this.amount, craftItemInfo.amount) && this.maxCount == craftItemInfo.maxCount && Intrinsics.areEqual(this.description, craftItemInfo.description);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((Integer.hashCode(this.available) * 31) + Float.hashCode(this.chance)) * 31) + Long.hashCode(this.cost)) * 31) + Long.hashCode(this.totalCost)) * 31) + Float.hashCode(this.exp)) * 31) + Integer.hashCode(this.hasColor)) * 31) + this.needs.hashCode()) * 31) + Integer.hashCode(this.showInfo)) * 31) + Integer.hashCode(this.itemType)) * 31;
        Integer num = this.amount;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.maxCount)) * 31;
        String str = this.description;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        int i = this.available;
        float f = this.chance;
        long j = this.cost;
        long j2 = this.totalCost;
        float f2 = this.exp;
        int i2 = this.hasColor;
        List<NeedItems> list = this.needs;
        int i3 = this.showInfo;
        int i4 = this.itemType;
        Integer num = this.amount;
        int i5 = this.maxCount;
        return "CraftItemInfo(available=" + i + ", chance=" + f + ", cost=" + j + ", totalCost=" + j2 + ", exp=" + f2 + ", hasColor=" + i2 + ", needs=" + list + ", showInfo=" + i3 + ", itemType=" + i4 + ", amount=" + num + ", maxCount=" + i5 + ", description=" + this.description + ")";
    }

    public CraftItemInfo(int i, float f, long j, long j2, float f2, int i2, List<NeedItems> needs, int i3, int i4, Integer num, int i5, String str) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        this.available = i;
        this.chance = f;
        this.cost = j;
        this.totalCost = j2;
        this.exp = f2;
        this.hasColor = i2;
        this.needs = needs;
        this.showInfo = i3;
        this.itemType = i4;
        this.amount = num;
        this.maxCount = i5;
        this.description = str;
    }

    public /* synthetic */ CraftItemInfo(int i, float f, long j, long j2, float f2, int i2, List list, int i3, int i4, Integer num, int i5, String str, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, j, (i6 & 8) != 0 ? -1L : j2, f2, i2, list, i3, i4, num, i5, (i6 & 2048) != 0 ? null : str);
    }

    public final int getAvailable() {
        return this.available;
    }

    public final float getChance() {
        return this.chance;
    }

    public final long getCost() {
        return this.cost;
    }

    public final long getTotalCost() {
        return this.totalCost;
    }

    public final float getExp() {
        return this.exp;
    }

    public final int getHasColor() {
        return this.hasColor;
    }

    public final List<NeedItems> getNeeds() {
        return this.needs;
    }

    public final int getShowInfo() {
        return this.showInfo;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final String getDescription() {
        return this.description;
    }
}

package ru.mrlargha.commonui.elements.craft.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0084\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00106\u001a\u000207HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015¨\u00068"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "", "available", "", "chance", "", "cost", "", "totalCost", "exp", "hasColor", "needs", "", "Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "showInfo", "itemType", "amount", "maxCount", "<init>", "(IFJJFILjava/util/List;IILjava/lang/Integer;I)V", "getAvailable", "()I", "getChance", "()F", "getCost", "()J", "getTotalCost", "getExp", "getHasColor", "getNeeds", "()Ljava/util/List;", "getShowInfo", "getItemType", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IFJJFILjava/util/List;IILjava/lang/Integer;I)Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CraftItemInfo {
    private final Integer amount;
    private final int available;
    private final float chance;
    private final long cost;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CraftItemInfo copy$default(CraftItemInfo craftItemInfo, int i, float f, long j, long j2, float f2, int i2, List list, int i3, int i4, Integer num, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = craftItemInfo.available;
        }
        return craftItemInfo.copy(i, (i6 & 2) != 0 ? craftItemInfo.chance : f, (i6 & 4) != 0 ? craftItemInfo.cost : j, (i6 & 8) != 0 ? craftItemInfo.totalCost : j2, (i6 & 16) != 0 ? craftItemInfo.exp : f2, (i6 & 32) != 0 ? craftItemInfo.hasColor : i2, (i6 & 64) != 0 ? craftItemInfo.needs : list, (i6 & 128) != 0 ? craftItemInfo.showInfo : i3, (i6 & 256) != 0 ? craftItemInfo.itemType : i4, (i6 & 512) != 0 ? craftItemInfo.amount : num, (i6 & 1024) != 0 ? craftItemInfo.maxCount : i5);
    }

    public final int component1() {
        return this.available;
    }

    public final Integer component10() {
        return this.amount;
    }

    public final int component11() {
        return this.maxCount;
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

    public final CraftItemInfo copy(int i, float f, long j, long j2, float f2, int i2, List<NeedItems> needs, int i3, int i4, Integer num, int i5) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        return new CraftItemInfo(i, f, j, j2, f2, i2, needs, i3, i4, num, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CraftItemInfo) {
            CraftItemInfo craftItemInfo = (CraftItemInfo) obj;
            return this.available == craftItemInfo.available && Float.compare(this.chance, craftItemInfo.chance) == 0 && this.cost == craftItemInfo.cost && this.totalCost == craftItemInfo.totalCost && Float.compare(this.exp, craftItemInfo.exp) == 0 && this.hasColor == craftItemInfo.hasColor && Intrinsics.areEqual(this.needs, craftItemInfo.needs) && this.showInfo == craftItemInfo.showInfo && this.itemType == craftItemInfo.itemType && Intrinsics.areEqual(this.amount, craftItemInfo.amount) && this.maxCount == craftItemInfo.maxCount;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((Integer.hashCode(this.available) * 31) + Float.hashCode(this.chance)) * 31) + Long.hashCode(this.cost)) * 31) + Long.hashCode(this.totalCost)) * 31) + Float.hashCode(this.exp)) * 31) + Integer.hashCode(this.hasColor)) * 31) + this.needs.hashCode()) * 31) + Integer.hashCode(this.showInfo)) * 31) + Integer.hashCode(this.itemType)) * 31;
        Integer num = this.amount;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.maxCount);
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
        return "CraftItemInfo(available=" + i + ", chance=" + f + ", cost=" + j + ", totalCost=" + j2 + ", exp=" + f2 + ", hasColor=" + i2 + ", needs=" + list + ", showInfo=" + i3 + ", itemType=" + i4 + ", amount=" + num + ", maxCount=" + this.maxCount + ")";
    }

    public CraftItemInfo(int i, float f, long j, long j2, float f2, int i2, List<NeedItems> needs, int i3, int i4, Integer num, int i5) {
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
    }

    public /* synthetic */ CraftItemInfo(int i, float f, long j, long j2, float f2, int i2, List list, int i3, int i4, Integer num, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, j, (i6 & 8) != 0 ? -1L : j2, f2, i2, list, i3, i4, num, i5);
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
}

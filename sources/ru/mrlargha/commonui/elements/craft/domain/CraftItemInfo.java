package ru.mrlargha.commonui.elements.craft.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0084\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00066"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "", "available", "", "chance", "", "cost", "totalCost", "exp", "hasColor", "needs", "", "Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "showInfo", "itemType", "amount", "maxCount", "<init>", "(IFIIFILjava/util/List;IILjava/lang/Integer;I)V", "getAvailable", "()I", "getChance", "()F", "getCost", "getTotalCost", "getExp", "getHasColor", "getNeeds", "()Ljava/util/List;", "getShowInfo", "getItemType", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IFIIFILjava/util/List;IILjava/lang/Integer;I)Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CraftItemInfo {
    private final Integer amount;
    private final int available;
    private final float chance;
    private final int cost;
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
    private final int totalCost;

    public static /* synthetic */ CraftItemInfo copy$default(CraftItemInfo craftItemInfo, int i, float f, int i2, int i3, float f2, int i4, List list, int i5, int i6, Integer num, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = craftItemInfo.available;
        }
        if ((i8 & 2) != 0) {
            f = craftItemInfo.chance;
        }
        if ((i8 & 4) != 0) {
            i2 = craftItemInfo.cost;
        }
        if ((i8 & 8) != 0) {
            i3 = craftItemInfo.totalCost;
        }
        if ((i8 & 16) != 0) {
            f2 = craftItemInfo.exp;
        }
        if ((i8 & 32) != 0) {
            i4 = craftItemInfo.hasColor;
        }
        List<NeedItems> list2 = list;
        if ((i8 & 64) != 0) {
            list2 = craftItemInfo.needs;
        }
        if ((i8 & 128) != 0) {
            i5 = craftItemInfo.showInfo;
        }
        if ((i8 & 256) != 0) {
            i6 = craftItemInfo.itemType;
        }
        if ((i8 & 512) != 0) {
            num = craftItemInfo.amount;
        }
        if ((i8 & 1024) != 0) {
            i7 = craftItemInfo.maxCount;
        }
        Integer num2 = num;
        int i9 = i7;
        int i10 = i5;
        int i11 = i6;
        int i12 = i4;
        List list3 = list2;
        float f3 = f2;
        int i13 = i2;
        return craftItemInfo.copy(i, f, i13, i3, f3, i12, list3, i10, i11, num2, i9);
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

    public final int component3() {
        return this.cost;
    }

    public final int component4() {
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

    public final CraftItemInfo copy(int i, float f, int i2, int i3, float f2, int i4, List<NeedItems> needs, int i5, int i6, Integer num, int i7) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        return new CraftItemInfo(i, f, i2, i3, f2, i4, needs, i5, i6, num, i7);
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
        int hashCode = ((((((((((((((((Integer.hashCode(this.available) * 31) + Float.hashCode(this.chance)) * 31) + Integer.hashCode(this.cost)) * 31) + Integer.hashCode(this.totalCost)) * 31) + Float.hashCode(this.exp)) * 31) + Integer.hashCode(this.hasColor)) * 31) + this.needs.hashCode()) * 31) + Integer.hashCode(this.showInfo)) * 31) + Integer.hashCode(this.itemType)) * 31;
        Integer num = this.amount;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.maxCount);
    }

    public String toString() {
        int i = this.available;
        float f = this.chance;
        int i2 = this.cost;
        int i3 = this.totalCost;
        float f2 = this.exp;
        int i4 = this.hasColor;
        List<NeedItems> list = this.needs;
        int i5 = this.showInfo;
        int i6 = this.itemType;
        Integer num = this.amount;
        return "CraftItemInfo(available=" + i + ", chance=" + f + ", cost=" + i2 + ", totalCost=" + i3 + ", exp=" + f2 + ", hasColor=" + i4 + ", needs=" + list + ", showInfo=" + i5 + ", itemType=" + i6 + ", amount=" + num + ", maxCount=" + this.maxCount + ")";
    }

    public CraftItemInfo(int i, float f, int i2, int i3, float f2, int i4, List<NeedItems> needs, int i5, int i6, Integer num, int i7) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        this.available = i;
        this.chance = f;
        this.cost = i2;
        this.totalCost = i3;
        this.exp = f2;
        this.hasColor = i4;
        this.needs = needs;
        this.showInfo = i5;
        this.itemType = i6;
        this.amount = num;
        this.maxCount = i7;
    }

    public /* synthetic */ CraftItemInfo(int i, float f, int i2, int i3, float f2, int i4, List list, int i5, int i6, Integer num, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, i2, (i8 & 8) != 0 ? -1 : i3, f2, i4, list, i5, i6, num, i7);
    }

    public final int getAvailable() {
        return this.available;
    }

    public final float getChance() {
        return this.chance;
    }

    public final int getCost() {
        return this.cost;
    }

    public final int getTotalCost() {
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

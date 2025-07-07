package ru.mrlargha.commonui.elements.craft.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJp\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "", "available", "", "chance", "", "cost", "exp", "hasColor", "needs", "", "Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "showInfo", "itemType", "amount", "<init>", "(IFIFILjava/util/List;IILjava/lang/Integer;)V", "getAvailable", "()I", "getChance", "()F", "getCost", "getExp", "getHasColor", "getNeeds", "()Ljava/util/List;", "getShowInfo", "getItemType", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IFIFILjava/util/List;IILjava/lang/Integer;)Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    @SerializedName("needs")
    private final List<NeedItems> needs;
    @SerializedName("show_info")
    private final int showInfo;

    public static /* synthetic */ CraftItemInfo copy$default(CraftItemInfo craftItemInfo, int i, float f, int i2, float f2, int i3, List list, int i4, int i5, Integer num, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = craftItemInfo.available;
        }
        if ((i6 & 2) != 0) {
            f = craftItemInfo.chance;
        }
        if ((i6 & 4) != 0) {
            i2 = craftItemInfo.cost;
        }
        if ((i6 & 8) != 0) {
            f2 = craftItemInfo.exp;
        }
        if ((i6 & 16) != 0) {
            i3 = craftItemInfo.hasColor;
        }
        List<NeedItems> list2 = list;
        if ((i6 & 32) != 0) {
            list2 = craftItemInfo.needs;
        }
        if ((i6 & 64) != 0) {
            i4 = craftItemInfo.showInfo;
        }
        if ((i6 & 128) != 0) {
            i5 = craftItemInfo.itemType;
        }
        if ((i6 & 256) != 0) {
            num = craftItemInfo.amount;
        }
        int i7 = i5;
        Integer num2 = num;
        List list3 = list2;
        int i8 = i4;
        int i9 = i3;
        int i10 = i2;
        return craftItemInfo.copy(i, f, i10, f2, i9, list3, i8, i7, num2);
    }

    public final int component1() {
        return this.available;
    }

    public final float component2() {
        return this.chance;
    }

    public final int component3() {
        return this.cost;
    }

    public final float component4() {
        return this.exp;
    }

    public final int component5() {
        return this.hasColor;
    }

    public final List<NeedItems> component6() {
        return this.needs;
    }

    public final int component7() {
        return this.showInfo;
    }

    public final int component8() {
        return this.itemType;
    }

    public final Integer component9() {
        return this.amount;
    }

    public final CraftItemInfo copy(int i, float f, int i2, float f2, int i3, List<NeedItems> needs, int i4, int i5, Integer num) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        return new CraftItemInfo(i, f, i2, f2, i3, needs, i4, i5, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CraftItemInfo) {
            CraftItemInfo craftItemInfo = (CraftItemInfo) obj;
            return this.available == craftItemInfo.available && Float.compare(this.chance, craftItemInfo.chance) == 0 && this.cost == craftItemInfo.cost && Float.compare(this.exp, craftItemInfo.exp) == 0 && this.hasColor == craftItemInfo.hasColor && Intrinsics.areEqual(this.needs, craftItemInfo.needs) && this.showInfo == craftItemInfo.showInfo && this.itemType == craftItemInfo.itemType && Intrinsics.areEqual(this.amount, craftItemInfo.amount);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((Integer.hashCode(this.available) * 31) + Float.hashCode(this.chance)) * 31) + Integer.hashCode(this.cost)) * 31) + Float.hashCode(this.exp)) * 31) + Integer.hashCode(this.hasColor)) * 31) + this.needs.hashCode()) * 31) + Integer.hashCode(this.showInfo)) * 31) + Integer.hashCode(this.itemType)) * 31;
        Integer num = this.amount;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i = this.available;
        float f = this.chance;
        int i2 = this.cost;
        float f2 = this.exp;
        int i3 = this.hasColor;
        List<NeedItems> list = this.needs;
        int i4 = this.showInfo;
        int i5 = this.itemType;
        return "CraftItemInfo(available=" + i + ", chance=" + f + ", cost=" + i2 + ", exp=" + f2 + ", hasColor=" + i3 + ", needs=" + list + ", showInfo=" + i4 + ", itemType=" + i5 + ", amount=" + this.amount + ")";
    }

    public CraftItemInfo(int i, float f, int i2, float f2, int i3, List<NeedItems> needs, int i4, int i5, Integer num) {
        Intrinsics.checkNotNullParameter(needs, "needs");
        this.available = i;
        this.chance = f;
        this.cost = i2;
        this.exp = f2;
        this.hasColor = i3;
        this.needs = needs;
        this.showInfo = i4;
        this.itemType = i5;
        this.amount = num;
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
}

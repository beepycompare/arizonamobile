package ru.mrlargha.commonui.elements.craft.domain;

import kotlin.Metadata;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/NeedItemsUi;", "", "item", "", "amountNeed", "amountHave", "", "<init>", "(IIJ)V", "getItem", "()I", "getAmountNeed", "getAmountHave", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NeedItemsUi {
    private final long amountHave;
    private final int amountNeed;
    private final int item;

    public static /* synthetic */ NeedItemsUi copy$default(NeedItemsUi needItemsUi, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = needItemsUi.item;
        }
        if ((i3 & 2) != 0) {
            i2 = needItemsUi.amountNeed;
        }
        if ((i3 & 4) != 0) {
            j = needItemsUi.amountHave;
        }
        return needItemsUi.copy(i, i2, j);
    }

    public final int component1() {
        return this.item;
    }

    public final int component2() {
        return this.amountNeed;
    }

    public final long component3() {
        return this.amountHave;
    }

    public final NeedItemsUi copy(int i, int i2, long j) {
        return new NeedItemsUi(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NeedItemsUi) {
            NeedItemsUi needItemsUi = (NeedItemsUi) obj;
            return this.item == needItemsUi.item && this.amountNeed == needItemsUi.amountNeed && this.amountHave == needItemsUi.amountHave;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.item) * 31) + Integer.hashCode(this.amountNeed)) * 31) + Long.hashCode(this.amountHave);
    }

    public String toString() {
        int i = this.item;
        int i2 = this.amountNeed;
        return "NeedItemsUi(item=" + i + ", amountNeed=" + i2 + ", amountHave=" + this.amountHave + ")";
    }

    public NeedItemsUi(int i, int i2, long j) {
        this.item = i;
        this.amountNeed = i2;
        this.amountHave = j;
    }

    public final int getItem() {
        return this.item;
    }

    public final int getAmountNeed() {
        return this.amountNeed;
    }

    public final long getAmountHave() {
        return this.amountHave;
    }
}

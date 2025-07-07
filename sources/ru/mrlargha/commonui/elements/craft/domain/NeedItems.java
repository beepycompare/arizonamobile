package ru.mrlargha.commonui.elements.craft.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "", "item", "", "amount", "icon", "", "<init>", "(IILjava/lang/String;)V", "getItem", "()I", "getAmount", "getIcon", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NeedItems {
    private final int amount;
    private final String icon;
    private final int item;

    public static /* synthetic */ NeedItems copy$default(NeedItems needItems, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = needItems.item;
        }
        if ((i3 & 2) != 0) {
            i2 = needItems.amount;
        }
        if ((i3 & 4) != 0) {
            str = needItems.icon;
        }
        return needItems.copy(i, i2, str);
    }

    public final int component1() {
        return this.item;
    }

    public final int component2() {
        return this.amount;
    }

    public final String component3() {
        return this.icon;
    }

    public final NeedItems copy(int i, int i2, String str) {
        return new NeedItems(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NeedItems) {
            NeedItems needItems = (NeedItems) obj;
            return this.item == needItems.item && this.amount == needItems.amount && Intrinsics.areEqual(this.icon, needItems.icon);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.item) * 31) + Integer.hashCode(this.amount)) * 31;
        String str = this.icon;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.item;
        int i2 = this.amount;
        return "NeedItems(item=" + i + ", amount=" + i2 + ", icon=" + this.icon + ")";
    }

    public NeedItems(int i, int i2, String str) {
        this.item = i;
        this.amount = i2;
        this.icon = str;
    }

    public final int getItem() {
        return this.item;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getIcon() {
        return this.icon;
    }
}

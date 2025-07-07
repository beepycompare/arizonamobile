package ru.mrlargha.commonui.elements.craft.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: CraftItemRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/SendCreateItem;", "", "category", "", FirebaseAnalytics.Param.INDEX, "color", "count", "<init>", "(IIII)V", "getCategory", "()I", "getIndex", "getColor", "getCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendCreateItem {
    private final int category;
    private final int color;
    private final int count;
    private final int index;

    public static /* synthetic */ SendCreateItem copy$default(SendCreateItem sendCreateItem, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = sendCreateItem.category;
        }
        if ((i5 & 2) != 0) {
            i2 = sendCreateItem.index;
        }
        if ((i5 & 4) != 0) {
            i3 = sendCreateItem.color;
        }
        if ((i5 & 8) != 0) {
            i4 = sendCreateItem.count;
        }
        return sendCreateItem.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.category;
    }

    public final int component2() {
        return this.index;
    }

    public final int component3() {
        return this.color;
    }

    public final int component4() {
        return this.count;
    }

    public final SendCreateItem copy(int i, int i2, int i3, int i4) {
        return new SendCreateItem(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendCreateItem) {
            SendCreateItem sendCreateItem = (SendCreateItem) obj;
            return this.category == sendCreateItem.category && this.index == sendCreateItem.index && this.color == sendCreateItem.color && this.count == sendCreateItem.count;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.category) * 31) + Integer.hashCode(this.index)) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        int i = this.category;
        int i2 = this.index;
        int i3 = this.color;
        return "SendCreateItem(category=" + i + ", index=" + i2 + ", color=" + i3 + ", count=" + this.count + ")";
    }

    public SendCreateItem(int i, int i2, int i3, int i4) {
        this.category = i;
        this.index = i2;
        this.color = i3;
        this.count = i4;
    }

    public final int getCategory() {
        return this.category;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getCount() {
        return this.count;
    }
}

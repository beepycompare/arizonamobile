package ru.mrlargha.feature.mobile.presentation.adapter;

import kotlin.Metadata;
/* compiled from: MobilePhoneDriverOrdersAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/adapter/OrderInsertion;", "", "positionStart", "", "itemCount", "<init>", "(II)V", "getPositionStart", "()I", "getItemCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OrderInsertion {
    private final int itemCount;
    private final int positionStart;

    public static /* synthetic */ OrderInsertion copy$default(OrderInsertion orderInsertion, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = orderInsertion.positionStart;
        }
        if ((i3 & 2) != 0) {
            i2 = orderInsertion.itemCount;
        }
        return orderInsertion.copy(i, i2);
    }

    public final int component1() {
        return this.positionStart;
    }

    public final int component2() {
        return this.itemCount;
    }

    public final OrderInsertion copy(int i, int i2) {
        return new OrderInsertion(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderInsertion) {
            OrderInsertion orderInsertion = (OrderInsertion) obj;
            return this.positionStart == orderInsertion.positionStart && this.itemCount == orderInsertion.itemCount;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.positionStart) * 31) + Integer.hashCode(this.itemCount);
    }

    public String toString() {
        int i = this.positionStart;
        return "OrderInsertion(positionStart=" + i + ", itemCount=" + this.itemCount + ")";
    }

    public OrderInsertion(int i, int i2) {
        this.positionStart = i;
        this.itemCount = i2;
    }

    public final int getPositionStart() {
        return this.positionStart;
    }

    public final int getItemCount() {
        return this.itemCount;
    }
}

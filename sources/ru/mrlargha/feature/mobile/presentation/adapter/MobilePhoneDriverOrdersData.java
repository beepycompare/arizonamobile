package ru.mrlargha.feature.mobile.presentation.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.domain.obj.MobilePhoneDriverOrder;
/* compiled from: MobilePhoneDriverOrdersAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0086\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/adapter/MobilePhoneDriverOrdersData;", "", "<init>", "()V", "orders", "Ljava/util/ArrayList;", "Lru/mrlargha/feature/mobile/domain/obj/MobilePhoneDriverOrder;", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", "get", "position", "containsOrder", "", "orderId", "appendNew", "Lru/mrlargha/feature/mobile/presentation/adapter/OrderInsertion;", "ordersList", "", "clear", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneDriverOrdersData {
    private final ArrayList<MobilePhoneDriverOrder> orders = new ArrayList<>();

    public final int getSize() {
        return this.orders.size();
    }

    public final MobilePhoneDriverOrder get(int i) {
        MobilePhoneDriverOrder mobilePhoneDriverOrder = this.orders.get(i);
        Intrinsics.checkNotNullExpressionValue(mobilePhoneDriverOrder, "get(...)");
        return mobilePhoneDriverOrder;
    }

    public final boolean containsOrder(int i) {
        ArrayList<MobilePhoneDriverOrder> arrayList = this.orders;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (MobilePhoneDriverOrder mobilePhoneDriverOrder : arrayList) {
            if (mobilePhoneDriverOrder.getId() == i) {
                return true;
            }
        }
        return false;
    }

    public final OrderInsertion appendNew(List<MobilePhoneDriverOrder> ordersList) {
        Intrinsics.checkNotNullParameter(ordersList, "ordersList");
        ArrayList<MobilePhoneDriverOrder> arrayList = this.orders;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : ordersList) {
            if (!arrayList.contains((MobilePhoneDriverOrder) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return null;
        }
        int size = this.orders.size();
        this.orders.addAll(arrayList3);
        return new OrderInsertion(size, arrayList3.size());
    }

    public final void clear() {
        this.orders.clear();
    }
}

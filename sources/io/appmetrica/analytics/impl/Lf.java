package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Lf {

    /* renamed from: a  reason: collision with root package name */
    public final Y f518a;
    public final List b;

    public Lf(ECommercePrice eCommercePrice) {
        this(new Y(eCommercePrice.getFiat()), a(eCommercePrice.getInternalComponents()));
    }

    public static LinkedList a(List list) {
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ECommerceAmount eCommerceAmount = (ECommerceAmount) it.next();
                linkedList.add(new Y(eCommerceAmount.getAmount(), eCommerceAmount.getUnit()));
            }
            return linkedList;
        }
        return null;
    }

    public final String toString() {
        return "PriceWrapper{fiat=" + this.f518a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public Lf(Y y, LinkedList linkedList) {
        this.f518a = y;
        this.b = linkedList;
    }
}

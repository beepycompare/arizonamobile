package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0116ag {

    /* renamed from: a  reason: collision with root package name */
    public final C0126b0 f892a;
    public final List b;

    public C0116ag(ECommercePrice eCommercePrice) {
        this(new C0126b0(eCommercePrice.getFiat()), a(eCommercePrice.getInternalComponents()));
    }

    public static LinkedList a(List list) {
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ECommerceAmount eCommerceAmount = (ECommerceAmount) it.next();
                linkedList.add(new C0126b0(eCommerceAmount.getAmount(), eCommerceAmount.getUnit()));
            }
            return linkedList;
        }
        return null;
    }

    public final String toString() {
        return "PriceWrapper{fiat=" + this.f892a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0116ag(C0126b0 c0126b0, LinkedList linkedList) {
        this.f892a = c0126b0;
        this.b = linkedList;
    }
}

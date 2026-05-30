package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0123ag {

    /* renamed from: a  reason: collision with root package name */
    public final C0133b0 f887a;
    public final List b;

    public C0123ag(ECommercePrice eCommercePrice) {
        this(new C0133b0(eCommercePrice.getFiat()), a(eCommercePrice.getInternalComponents()));
    }

    public static LinkedList a(List list) {
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ECommerceAmount eCommerceAmount = (ECommerceAmount) it.next();
                linkedList.add(new C0133b0(eCommerceAmount.getAmount(), eCommerceAmount.getUnit()));
            }
            return linkedList;
        }
        return null;
    }

    public final String toString() {
        return "PriceWrapper{fiat=" + this.f887a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0123ag(C0133b0 c0133b0, LinkedList linkedList) {
        this.f887a = c0133b0;
        this.b = linkedList;
    }
}

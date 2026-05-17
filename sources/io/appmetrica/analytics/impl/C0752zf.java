package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import io.appmetrica.analytics.ecommerce.ECommercePrice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0752zf {

    /* renamed from: a  reason: collision with root package name */
    public final Z f1338a;
    public final List b;

    public C0752zf(ECommercePrice eCommercePrice) {
        this(new Z(eCommercePrice.getFiat()), a(eCommercePrice.getInternalComponents()));
    }

    public static LinkedList a(List list) {
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ECommerceAmount eCommerceAmount = (ECommerceAmount) it.next();
                linkedList.add(new Z(eCommerceAmount.getAmount(), eCommerceAmount.getUnit()));
            }
            return linkedList;
        }
        return null;
    }

    public final String toString() {
        return "PriceWrapper{fiat=" + this.f1338a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0752zf(Z z, LinkedList linkedList) {
        this.f1338a = z;
        this.b = linkedList;
    }
}

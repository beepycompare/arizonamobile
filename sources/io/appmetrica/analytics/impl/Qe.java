package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Qe {

    /* renamed from: a  reason: collision with root package name */
    public final String f731a;
    public final String b;
    public final List c;
    public final Map d;

    public Qe(ECommerceOrder eCommerceOrder) {
        this(UUID.randomUUID().toString(), eCommerceOrder.getIdentifier(), a(eCommerceOrder.getCartItems()), CollectionUtils.mapCopyOfNullableMap(eCommerceOrder.getPayload()));
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new B3((ECommerceCartItem) it.next()));
        }
        return arrayList;
    }

    public final String toString() {
        return "OrderWrapper{uuid='" + this.f731a + "', identifier='" + this.b + "', cartItems=" + this.c + ", payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Qe(String str, String str2, ArrayList arrayList, Map map) {
        this.f731a = str;
        this.b = str2;
        this.c = arrayList;
        this.d = map;
    }
}

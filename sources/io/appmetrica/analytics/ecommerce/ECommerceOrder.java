package io.appmetrica.analytics.ecommerce;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class ECommerceOrder {

    /* renamed from: a  reason: collision with root package name */
    private final String f301a;
    private final List b;
    private Map c;

    public ECommerceOrder(String str, List<ECommerceCartItem> list) {
        this.f301a = str;
        this.b = list;
    }

    public List<ECommerceCartItem> getCartItems() {
        return this.b;
    }

    public String getIdentifier() {
        return this.f301a;
    }

    public Map<String, String> getPayload() {
        return this.c;
    }

    public ECommerceOrder setPayload(Map<String, String> map) {
        this.c = map;
        return this;
    }

    public String toString() {
        return "ECommerceOrder{identifier='" + this.f301a + "', cartItems=" + this.b + ", payload=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}

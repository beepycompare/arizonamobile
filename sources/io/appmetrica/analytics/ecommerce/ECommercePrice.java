package io.appmetrica.analytics.ecommerce;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class ECommercePrice {

    /* renamed from: a  reason: collision with root package name */
    private final ECommerceAmount f389a;
    private List b;

    public ECommercePrice(ECommerceAmount eCommerceAmount) {
        this.f389a = eCommerceAmount;
    }

    public ECommerceAmount getFiat() {
        return this.f389a;
    }

    public List<ECommerceAmount> getInternalComponents() {
        return this.b;
    }

    public ECommercePrice setInternalComponents(List<ECommerceAmount> list) {
        this.b = list;
        return this;
    }

    public String toString() {
        return "ECommercePrice{fiat=" + this.f389a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

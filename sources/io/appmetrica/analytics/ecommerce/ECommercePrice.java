package io.appmetrica.analytics.ecommerce;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class ECommercePrice {

    /* renamed from: a  reason: collision with root package name */
    private final ECommerceAmount f312a;
    private List b;

    public ECommercePrice(ECommerceAmount eCommerceAmount) {
        this.f312a = eCommerceAmount;
    }

    public ECommerceAmount getFiat() {
        return this.f312a;
    }

    public List<ECommerceAmount> getInternalComponents() {
        return this.b;
    }

    public ECommercePrice setInternalComponents(List<ECommerceAmount> list) {
        this.b = list;
        return this;
    }

    public String toString() {
        return "ECommercePrice{fiat=" + this.f312a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.Oo;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class ECommerceCartItem {

    /* renamed from: a  reason: collision with root package name */
    private final ECommerceProduct f390a;
    private final BigDecimal b;
    private final ECommercePrice c;
    private ECommerceReferrer d;

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, long j) {
        this(eCommerceProduct, eCommercePrice, Oo.a(j));
    }

    public ECommerceProduct getProduct() {
        return this.f390a;
    }

    public BigDecimal getQuantity() {
        return this.b;
    }

    public ECommerceReferrer getReferrer() {
        return this.d;
    }

    public ECommercePrice getRevenue() {
        return this.c;
    }

    public ECommerceCartItem setReferrer(ECommerceReferrer eCommerceReferrer) {
        this.d = eCommerceReferrer;
        return this;
    }

    public String toString() {
        return "ECommerceCartItem{product=" + this.f390a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, double d) {
        this(eCommerceProduct, eCommercePrice, new BigDecimal(Oo.a(d)));
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, BigDecimal bigDecimal) {
        this.f390a = eCommerceProduct;
        this.b = bigDecimal;
        this.c = eCommercePrice;
    }
}

package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.mo;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public class ECommerceCartItem {

    /* renamed from: a  reason: collision with root package name */
    private final ECommerceProduct f431a;
    private final BigDecimal b;
    private final ECommercePrice c;
    private ECommerceReferrer d;

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, long j) {
        this(eCommerceProduct, eCommercePrice, mo.a(j));
    }

    public ECommerceProduct getProduct() {
        return this.f431a;
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
        return "ECommerceCartItem{product=" + this.f431a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, double d) {
        this(eCommerceProduct, eCommercePrice, new BigDecimal(mo.a(d)));
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, BigDecimal bigDecimal) {
        this.f431a = eCommerceProduct;
        this.b = bigDecimal;
        this.c = eCommercePrice;
    }
}

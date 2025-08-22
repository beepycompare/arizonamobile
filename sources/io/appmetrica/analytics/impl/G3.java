package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class G3 {

    /* renamed from: a  reason: collision with root package name */
    public final Zf f447a;
    public final BigDecimal b;
    public final Pf c;
    public final Pg d;

    public G3(ECommerceCartItem eCommerceCartItem) {
        this(new Zf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Pf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Pg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f447a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public G3(Zf zf, BigDecimal bigDecimal, Pf pf, Pg pg) {
        this.f447a = zf;
        this.b = bigDecimal;
        this.c = pf;
        this.d = pg;
    }
}

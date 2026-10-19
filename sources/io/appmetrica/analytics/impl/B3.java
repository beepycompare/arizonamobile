package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class B3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0322ig f471a;
    public final BigDecimal b;
    public final C0116ag c;
    public final Ng d;

    public B3(ECommerceCartItem eCommerceCartItem) {
        this(new C0322ig(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0116ag(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Ng(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f471a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public B3(C0322ig c0322ig, BigDecimal bigDecimal, C0116ag c0116ag, Ng ng) {
        this.f471a = c0322ig;
        this.b = bigDecimal;
        this.c = c0116ag;
        this.d = ng;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class B3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0327ig f468a;
    public final BigDecimal b;
    public final C0121ag c;
    public final Ng d;

    public B3(ECommerceCartItem eCommerceCartItem) {
        this(new C0327ig(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0121ag(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Ng(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f468a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public B3(C0327ig c0327ig, BigDecimal bigDecimal, C0121ag c0121ag, Ng ng) {
        this.f468a = c0327ig;
        this.b = bigDecimal;
        this.c = c0121ag;
        this.d = ng;
    }
}

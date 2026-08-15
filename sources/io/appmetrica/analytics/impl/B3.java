package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class B3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0328ig f468a;
    public final BigDecimal b;
    public final C0122ag c;
    public final Ng d;

    public B3(ECommerceCartItem eCommerceCartItem) {
        this(new C0328ig(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0122ag(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Ng(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f468a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public B3(C0328ig c0328ig, BigDecimal bigDecimal, C0122ag c0122ag, Ng ng) {
        this.f468a = c0328ig;
        this.b = bigDecimal;
        this.c = c0122ag;
        this.d = ng;
    }
}

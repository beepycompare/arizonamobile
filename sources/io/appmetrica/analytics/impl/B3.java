package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class B3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0329ig f465a;
    public final BigDecimal b;
    public final C0123ag c;
    public final Ng d;

    public B3(ECommerceCartItem eCommerceCartItem) {
        this(new C0329ig(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0123ag(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Ng(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f465a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public B3(C0329ig c0329ig, BigDecimal bigDecimal, C0123ag c0123ag, Ng ng) {
        this.f465a = c0329ig;
        this.b = bigDecimal;
        this.c = c0123ag;
        this.d = ng;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class J3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0204dg f509a;
    public final BigDecimal b;
    public final Tf c;
    public final Tg d;

    public J3(ECommerceCartItem eCommerceCartItem) {
        this(new C0204dg(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Tf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Tg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f509a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public J3(C0204dg c0204dg, BigDecimal bigDecimal, Tf tf, Tg tg) {
        this.f509a = c0204dg;
        this.b = bigDecimal;
        this.c = tf;
        this.d = tg;
    }
}

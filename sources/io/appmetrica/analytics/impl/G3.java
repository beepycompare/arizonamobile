package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class G3 {

    /* renamed from: a  reason: collision with root package name */
    public final Sf f436a;
    public final BigDecimal b;
    public final Lf c;
    public final Ig d;

    public G3(ECommerceCartItem eCommerceCartItem) {
        this(new Sf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Lf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Ig(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f436a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public G3(Sf sf, BigDecimal bigDecimal, Lf lf, Ig ig) {
        this.f436a = sf;
        this.b = bigDecimal;
        this.c = lf;
        this.d = ig;
    }
}

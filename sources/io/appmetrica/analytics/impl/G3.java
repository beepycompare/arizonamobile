package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class G3 {

    /* renamed from: a  reason: collision with root package name */
    public final Uf f445a;
    public final BigDecimal b;
    public final Nf c;
    public final Kg d;

    public G3(ECommerceCartItem eCommerceCartItem) {
        this(new Uf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Nf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Kg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f445a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public G3(Uf uf, BigDecimal bigDecimal, Nf nf, Kg kg) {
        this.f445a = uf;
        this.b = bigDecimal;
        this.c = nf;
        this.d = kg;
    }
}

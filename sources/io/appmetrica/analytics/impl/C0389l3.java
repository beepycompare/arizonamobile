package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.l3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0389l3 {

    /* renamed from: a  reason: collision with root package name */
    public final If f985a;
    public final BigDecimal b;
    public final Af c;
    public final C0726yg d;

    public C0389l3(ECommerceCartItem eCommerceCartItem) {
        this(new If(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Af(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new C0726yg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f985a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0389l3(If r1, BigDecimal bigDecimal, Af af, C0726yg c0726yg) {
        this.f985a = r1;
        this.b = bigDecimal;
        this.c = af;
        this.d = c0726yg;
    }
}

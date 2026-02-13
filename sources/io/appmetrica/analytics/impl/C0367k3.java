package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0367k3 {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f1073a;
    public final BigDecimal b;
    public final C0753zf c;
    public final C0704xg d;

    public C0367k3(ECommerceCartItem eCommerceCartItem) {
        this(new Hf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0753zf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new C0704xg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f1073a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0367k3(Hf hf, BigDecimal bigDecimal, C0753zf c0753zf, C0704xg c0704xg) {
        this.f1073a = hf;
        this.b = bigDecimal;
        this.c = c0753zf;
        this.d = c0704xg;
    }
}

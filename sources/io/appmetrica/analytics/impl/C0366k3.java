package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0366k3 {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f1078a;
    public final BigDecimal b;
    public final C0752zf c;
    public final C0703xg d;

    public C0366k3(ECommerceCartItem eCommerceCartItem) {
        this(new Hf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C0752zf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new C0703xg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f1078a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0366k3(Hf hf, BigDecimal bigDecimal, C0752zf c0752zf, C0703xg c0703xg) {
        this.f1078a = hf;
        this.b = bigDecimal;
        this.c = c0752zf;
        this.d = c0703xg;
    }
}

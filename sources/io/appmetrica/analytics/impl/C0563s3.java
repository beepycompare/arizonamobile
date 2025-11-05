package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0563s3 {

    /* renamed from: a  reason: collision with root package name */
    public final Mf f1104a;
    public final BigDecimal b;
    public final Ef c;
    public final Cg d;

    public C0563s3(ECommerceCartItem eCommerceCartItem) {
        this(new Mf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Ef(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Cg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f1104a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C0563s3(Mf mf, BigDecimal bigDecimal, Ef ef, Cg cg) {
        this.f1104a = mf;
        this.b = bigDecimal;
        this.c = ef;
        this.d = cg;
    }
}

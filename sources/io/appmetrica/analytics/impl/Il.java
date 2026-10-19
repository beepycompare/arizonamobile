package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Il extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0322ig f603a;
    public final Ng b;
    public final InterfaceC0625u8 c;

    public Il(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new C0322ig(eCommerceProduct), eCommerceReferrer == null ? null : new Ng(eCommerceReferrer), new Jl());
    }

    public final InterfaceC0625u8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0400lg
    public final List<Xi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f603a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Il(C0322ig c0322ig, Ng ng, InterfaceC0625u8 interfaceC0625u8) {
        this.f603a = c0322ig;
        this.b = ng;
        this.c = interfaceC0625u8;
    }
}

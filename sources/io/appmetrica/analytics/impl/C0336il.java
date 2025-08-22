package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.il  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0336il extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Zf f908a;
    public final Pg b;
    public final InterfaceC0700x8 c;

    public C0336il(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Zf(eCommerceProduct), eCommerceReferrer == null ? null : new Pg(eCommerceReferrer), new C0362jl());
    }

    public final InterfaceC0700x8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0177cg
    public final List<Vi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f908a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0336il(Zf zf, Pg pg, InterfaceC0700x8 interfaceC0700x8) {
        this.f908a = zf;
        this.b = pg;
        this.c = interfaceC0700x8;
    }
}

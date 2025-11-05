package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.hl  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0304hl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Mf f916a;
    public final Cg b;
    public final InterfaceC0291h8 c;

    public C0304hl(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Mf(eCommerceProduct), eCommerceReferrer == null ? null : new Cg(eCommerceReferrer), new C0329il());
    }

    public final InterfaceC0291h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Pf
    public final List<Ii> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f916a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0304hl(Mf mf, Cg cg, InterfaceC0291h8 interfaceC0291h8) {
        this.f916a = mf;
        this.b = cg;
        this.c = interfaceC0291h8;
    }
}

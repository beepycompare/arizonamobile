package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0226el extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final If f874a;
    public final C0726yg b;
    public final InterfaceC0162c8 c;

    public C0226el(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new If(eCommerceProduct), eCommerceReferrer == null ? null : new C0726yg(eCommerceReferrer), new C0252fl());
    }

    public final InterfaceC0162c8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Lf
    public final List<Ei> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f874a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0226el(If r1, C0726yg c0726yg, InterfaceC0162c8 interfaceC0162c8) {
        this.f874a = r1;
        this.b = c0726yg;
        this.c = interfaceC0162c8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.el  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0225el extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final If f972a;
    public final C0725yg b;
    public final InterfaceC0161c8 c;

    public C0225el(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new If(eCommerceProduct), eCommerceReferrer == null ? null : new C0725yg(eCommerceReferrer), new C0251fl());
    }

    public final InterfaceC0161c8 a() {
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
        return "ShownProductDetailInfoEvent{product=" + this.f972a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0225el(If r1, C0725yg c0725yg, InterfaceC0161c8 interfaceC0161c8) {
        this.f972a = r1;
        this.b = c0725yg;
        this.c = interfaceC0161c8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0145al extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Sf f756a;
    public final Ig b;
    public final InterfaceC0583s8 c;

    public C0145al(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Sf(eCommerceProduct), eCommerceReferrer == null ? null : new Ig(eCommerceReferrer), new C0171bl());
    }

    public final InterfaceC0583s8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Vf
    public final List<Ni> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f756a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0145al(Sf sf, Ig ig, InterfaceC0583s8 interfaceC0583s8) {
        this.f756a = sf;
        this.b = ig;
        this.c = interfaceC0583s8;
    }
}

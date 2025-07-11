package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0137al extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Sf f757a;
    public final Ig b;
    public final InterfaceC0575s8 c;

    public C0137al(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Sf(eCommerceProduct), eCommerceReferrer == null ? null : new Ig(eCommerceReferrer), new C0163bl());
    }

    public final InterfaceC0575s8 a() {
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
        return "ShownProductDetailInfoEvent{product=" + this.f757a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0137al(Sf sf, Ig ig, InterfaceC0575s8 interfaceC0575s8) {
        this.f757a = sf;
        this.b = ig;
        this.c = interfaceC0575s8;
    }
}

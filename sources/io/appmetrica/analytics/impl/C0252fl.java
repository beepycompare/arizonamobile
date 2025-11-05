package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0252fl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Mf f881a;
    public final C0302hj b;
    public final InterfaceC0291h8 c;

    public C0252fl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Mf(eCommerceProduct), new C0302hj(eCommerceScreen), new C0278gl());
    }

    public final InterfaceC0291h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Pf
    public final List<Ii> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f881a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0252fl(Mf mf, C0302hj c0302hj, InterfaceC0291h8 interfaceC0291h8) {
        this.f881a = mf;
        this.b = c0302hj;
        this.c = interfaceC0291h8;
    }
}

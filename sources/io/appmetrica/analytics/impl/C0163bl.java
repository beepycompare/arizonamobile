package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0163bl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Uf f788a;
    public final C0514pj b;
    public final InterfaceC0652v8 c;

    public C0163bl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Uf(eCommerceProduct), new C0514pj(eCommerceScreen), new C0189cl());
    }

    public final InterfaceC0652v8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Xf
    public final List<Qi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f788a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0163bl(Uf uf, C0514pj c0514pj, InterfaceC0652v8 interfaceC0652v8) {
        this.f788a = uf;
        this.b = c0514pj;
        this.c = interfaceC0652v8;
    }
}

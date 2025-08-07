package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0164bl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Uf f788a;
    public final C0515pj b;
    public final InterfaceC0653v8 c;

    public C0164bl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Uf(eCommerceProduct), new C0515pj(eCommerceScreen), new C0190cl());
    }

    public final InterfaceC0653v8 a() {
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

    public C0164bl(Uf uf, C0515pj c0515pj, InterfaceC0653v8 interfaceC0653v8) {
        this.f788a = uf;
        this.b = c0515pj;
        this.c = interfaceC0653v8;
    }
}

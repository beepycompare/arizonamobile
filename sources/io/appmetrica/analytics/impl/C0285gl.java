package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0285gl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Zf f876a;
    public final C0636uj b;
    public final InterfaceC0700x8 c;

    public C0285gl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Zf(eCommerceProduct), new C0636uj(eCommerceScreen), new C0311hl());
    }

    public final InterfaceC0700x8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0177cg
    public final List<Vi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f876a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0285gl(Zf zf, C0636uj c0636uj, InterfaceC0700x8 interfaceC0700x8) {
        this.f876a = zf;
        this.b = c0636uj;
        this.c = interfaceC0700x8;
    }
}

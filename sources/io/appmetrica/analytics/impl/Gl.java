package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Gl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0327ig f567a;
    public final Dj b;
    public final InterfaceC0630u8 c;

    public Gl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new C0327ig(eCommerceProduct), new Dj(eCommerceScreen), new Hl());
    }

    public final InterfaceC0630u8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0405lg
    public final List<Xi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f567a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Gl(C0327ig c0327ig, Dj dj, InterfaceC0630u8 interfaceC0630u8) {
        this.f567a = c0327ig;
        this.b = dj;
        this.c = interfaceC0630u8;
    }
}

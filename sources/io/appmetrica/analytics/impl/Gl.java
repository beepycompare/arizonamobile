package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Gl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0329ig f567a;
    public final Dj b;
    public final InterfaceC0632u8 c;

    public Gl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new C0329ig(eCommerceProduct), new Dj(eCommerceScreen), new Hl());
    }

    public final InterfaceC0632u8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0407lg
    public final List<Xi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f567a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Gl(C0329ig c0329ig, Dj dj, InterfaceC0632u8 interfaceC0632u8) {
        this.f567a = c0329ig;
        this.b = dj;
        this.c = interfaceC0632u8;
    }
}

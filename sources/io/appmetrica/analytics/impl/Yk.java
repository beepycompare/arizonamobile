package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Yk extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Sf f727a;
    public final C0437mj b;
    public final InterfaceC0575s8 c;

    public Yk(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Sf(eCommerceProduct), new C0437mj(eCommerceScreen), new Zk());
    }

    public final InterfaceC0575s8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Vf
    public final List<Ni> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f727a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Yk(Sf sf, C0437mj c0437mj, InterfaceC0575s8 interfaceC0575s8) {
        this.f727a = sf;
        this.b = c0437mj;
        this.c = interfaceC0575s8;
    }
}

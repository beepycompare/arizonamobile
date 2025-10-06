package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0389kl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0204dg f959a;
    public final C0741yj b;
    public final A8 c;

    public C0389kl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new C0204dg(eCommerceProduct), new C0741yj(eCommerceScreen), new C0415ll());
    }

    public final A8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0281gg
    public final List<Zi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f959a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0389kl(C0204dg c0204dg, C0741yj c0741yj, A8 a8) {
        this.f959a = c0204dg;
        this.b = c0741yj;
        this.c = a8;
    }
}

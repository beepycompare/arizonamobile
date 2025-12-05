package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0174cl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final If f920a;
    public final C0198dj b;
    public final InterfaceC0161c8 c;

    public C0174cl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new If(eCommerceProduct), new C0198dj(eCommerceScreen), new C0200dl());
    }

    public final InterfaceC0161c8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Lf
    public final List<Ei> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f920a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0174cl(If r1, C0198dj c0198dj, InterfaceC0161c8 interfaceC0161c8) {
        this.f920a = r1;
        this.b = c0198dj;
        this.c = interfaceC0161c8;
    }
}

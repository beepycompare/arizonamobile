package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0175cl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final If f837a;
    public final C0199dj b;
    public final InterfaceC0162c8 c;

    public C0175cl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new If(eCommerceProduct), new C0199dj(eCommerceScreen), new C0201dl());
    }

    public final InterfaceC0162c8 a() {
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
        return "ShownProductCardInfoEvent{product=" + this.f837a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0175cl(If r1, C0199dj c0199dj, InterfaceC0162c8 interfaceC0162c8) {
        this.f837a = r1;
        this.b = c0199dj;
        this.c = interfaceC0162c8;
    }
}

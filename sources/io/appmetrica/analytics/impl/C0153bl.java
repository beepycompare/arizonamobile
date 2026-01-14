package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0153bl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f926a;
    public final C0177cj b;
    public final InterfaceC0140b8 c;

    public C0153bl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Hf(eCommerceProduct), new C0177cj(eCommerceScreen), new C0179cl());
    }

    public final InterfaceC0140b8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f926a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0153bl(Hf hf, C0177cj c0177cj, InterfaceC0140b8 interfaceC0140b8) {
        this.f926a = hf;
        this.b = c0177cj;
        this.c = interfaceC0140b8;
    }
}

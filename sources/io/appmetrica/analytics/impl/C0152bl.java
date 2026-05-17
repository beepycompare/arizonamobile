package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0152bl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f930a;
    public final C0176cj b;
    public final InterfaceC0139b8 c;

    public C0152bl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Hf(eCommerceProduct), new C0176cj(eCommerceScreen), new C0178cl());
    }

    public final InterfaceC0139b8 a() {
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
        return "ShownProductCardInfoEvent{product=" + this.f930a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0152bl(Hf hf, C0176cj c0176cj, InterfaceC0139b8 interfaceC0139b8) {
        this.f930a = hf;
        this.b = c0176cj;
        this.c = interfaceC0139b8;
    }
}

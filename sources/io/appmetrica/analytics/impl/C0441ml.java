package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0441ml extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0204dg f995a;
    public final Tg b;
    public final A8 c;

    public C0441ml(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new C0204dg(eCommerceProduct), eCommerceReferrer == null ? null : new Tg(eCommerceReferrer), new C0467nl());
    }

    public final A8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0281gg
    public final List<Zi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f995a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0441ml(C0204dg c0204dg, Tg tg, A8 a8) {
        this.f995a = c0204dg;
        this.b = tg;
        this.c = a8;
    }
}

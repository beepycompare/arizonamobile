package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0205dl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f962a;
    public final C0704xg b;
    public final InterfaceC0140b8 c;

    public C0205dl(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Hf(eCommerceProduct), eCommerceReferrer == null ? null : new C0704xg(eCommerceReferrer), new C0230el());
    }

    public final InterfaceC0140b8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f962a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0205dl(Hf hf, C0704xg c0704xg, InterfaceC0140b8 interfaceC0140b8) {
        this.f962a = hf;
        this.b = c0704xg;
        this.c = interfaceC0140b8;
    }
}

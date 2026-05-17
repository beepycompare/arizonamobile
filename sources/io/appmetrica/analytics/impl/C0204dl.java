package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0204dl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f966a;
    public final C0703xg b;
    public final InterfaceC0139b8 c;

    public C0204dl(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Hf(eCommerceProduct), eCommerceReferrer == null ? null : new C0703xg(eCommerceReferrer), new C0229el());
    }

    public final InterfaceC0139b8 a() {
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
        return "ShownProductDetailInfoEvent{product=" + this.f966a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0204dl(Hf hf, C0703xg c0703xg, InterfaceC0139b8 interfaceC0139b8) {
        this.f966a = hf;
        this.b = c0703xg;
        this.c = interfaceC0139b8;
    }
}

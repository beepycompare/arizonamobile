package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.dl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0216dl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Uf f818a;
    public final Kg b;
    public final InterfaceC0653v8 c;

    public C0216dl(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Uf(eCommerceProduct), eCommerceReferrer == null ? null : new Kg(eCommerceReferrer), new C0241el());
    }

    public final InterfaceC0653v8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Xf
    public final List<Qi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f818a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0216dl(Uf uf, Kg kg, InterfaceC0653v8 interfaceC0653v8) {
        this.f818a = uf;
        this.b = kg;
        this.c = interfaceC0653v8;
    }
}

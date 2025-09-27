package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0388kl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0203dg f959a;
    public final C0740yj b;
    public final A8 c;

    public C0388kl(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new C0203dg(eCommerceProduct), new C0740yj(eCommerceScreen), new C0414ll());
    }

    public final A8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0280gg
    public final List<Zi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f959a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0388kl(C0203dg c0203dg, C0740yj c0740yj, A8 a8) {
        this.f959a = c0203dg;
        this.b = c0740yj;
        this.c = a8;
    }
}

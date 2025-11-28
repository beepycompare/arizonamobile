package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.jl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0355jl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0302hj f958a;
    public final InterfaceC0291h8 b;

    public C0355jl(ECommerceScreen eCommerceScreen) {
        this(new C0302hj(eCommerceScreen), new C0381kl());
    }

    public final InterfaceC0291h8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Pf
    public final List<Ii> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f958a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0355jl(C0302hj c0302hj, InterfaceC0291h8 interfaceC0291h8) {
        this.f958a = c0302hj;
        this.b = interfaceC0291h8;
    }
}

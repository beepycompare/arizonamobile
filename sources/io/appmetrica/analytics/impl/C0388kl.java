package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0388kl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0636uj f941a;
    public final InterfaceC0700x8 b;

    public C0388kl(ECommerceScreen eCommerceScreen) {
        this(new C0636uj(eCommerceScreen), new C0414ll());
    }

    public final InterfaceC0700x8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0177cg
    public final List<Vi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f941a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0388kl(C0636uj c0636uj, InterfaceC0700x8 interfaceC0700x8) {
        this.f941a = c0636uj;
        this.b = interfaceC0700x8;
    }
}

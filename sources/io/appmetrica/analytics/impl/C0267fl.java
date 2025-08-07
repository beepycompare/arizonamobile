package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0267fl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0515pj f850a;
    public final InterfaceC0653v8 b;

    public C0267fl(ECommerceScreen eCommerceScreen) {
        this(new C0515pj(eCommerceScreen), new C0293gl());
    }

    public final InterfaceC0653v8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Xf
    public final List<Qi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f850a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0267fl(C0515pj c0515pj, InterfaceC0653v8 interfaceC0653v8) {
        this.f850a = c0515pj;
        this.b = interfaceC0653v8;
    }
}

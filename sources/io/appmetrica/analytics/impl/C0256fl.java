package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0256fl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0177cj f999a;
    public final InterfaceC0140b8 b;

    public C0256fl(ECommerceScreen eCommerceScreen) {
        this(new C0177cj(eCommerceScreen), new C0282gl());
    }

    public final InterfaceC0140b8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f999a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0256fl(C0177cj c0177cj, InterfaceC0140b8 interfaceC0140b8) {
        this.f999a = c0177cj;
        this.b = interfaceC0140b8;
    }
}

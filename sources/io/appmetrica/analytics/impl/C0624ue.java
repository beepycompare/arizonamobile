package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0624ue extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f1151a;
    public final C0674we b;
    public final InterfaceC0291h8 c;

    public C0624ue(int i, ECommerceOrder eCommerceOrder) {
        this(i, new C0674we(eCommerceOrder), new C0649ve());
    }

    public final InterfaceC0291h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Pf
    public final List<Ii> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f1151a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0624ue(int i, C0674we c0674we, InterfaceC0291h8 interfaceC0291h8) {
        this.f1151a = i;
        this.b = c0674we;
        this.c = interfaceC0291h8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Ee extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f413a;
    public final Ge b;
    public final InterfaceC0700x8 c;

    public Ee(int i, ECommerceOrder eCommerceOrder) {
        this(i, new Ge(eCommerceOrder), new Fe());
    }

    public final InterfaceC0700x8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0177cg
    public final List<Vi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f413a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Ee(int i, Ge ge, InterfaceC0700x8 interfaceC0700x8) {
        this.f413a = i;
        this.b = ge;
        this.c = interfaceC0700x8;
    }
}

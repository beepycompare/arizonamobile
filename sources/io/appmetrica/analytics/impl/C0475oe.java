package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0475oe extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f1048a;
    public final C0525qe b;
    public final InterfaceC0162c8 c;

    public C0475oe(int i, ECommerceOrder eCommerceOrder) {
        this(i, new C0525qe(eCommerceOrder), new C0500pe());
    }

    public final InterfaceC0162c8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Lf
    public final List<Ei> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f1048a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0475oe(int i, C0525qe c0525qe, InterfaceC0162c8 interfaceC0162c8) {
        this.f1048a = i;
        this.b = c0525qe;
        this.c = interfaceC0162c8;
    }
}

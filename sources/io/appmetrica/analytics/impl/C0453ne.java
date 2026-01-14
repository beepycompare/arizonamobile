package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0453ne extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f1136a;
    public final C0503pe b;
    public final InterfaceC0140b8 c;

    public C0453ne(int i, ECommerceOrder eCommerceOrder) {
        this(i, new C0503pe(eCommerceOrder), new C0478oe());
    }

    public final InterfaceC0140b8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f1136a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0453ne(int i, C0503pe c0503pe, InterfaceC0140b8 interfaceC0140b8) {
        this.f1136a = i;
        this.b = c0503pe;
        this.c = interfaceC0140b8;
    }
}

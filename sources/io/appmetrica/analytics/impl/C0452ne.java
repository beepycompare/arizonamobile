package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0452ne extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f1140a;
    public final C0502pe b;
    public final InterfaceC0139b8 c;

    public C0452ne(int i, ECommerceOrder eCommerceOrder) {
        this(i, new C0502pe(eCommerceOrder), new C0477oe());
    }

    public final InterfaceC0139b8 a() {
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
        return "OrderInfoEvent{eventType=" + this.f1140a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0452ne(int i, C0502pe c0502pe, InterfaceC0139b8 interfaceC0139b8) {
        this.f1140a = i;
        this.b = c0502pe;
        this.c = interfaceC0139b8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Oe extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* renamed from: a  reason: collision with root package name */
    public final int f700a;
    public final Qe b;
    public final InterfaceC0632u8 c;

    public Oe(int i, ECommerceOrder eCommerceOrder) {
        this(i, new Qe(eCommerceOrder), new Pe());
    }

    public final InterfaceC0632u8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0407lg
    public final List<Xi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f700a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Oe(int i, Qe qe, InterfaceC0632u8 interfaceC0632u8) {
        this.f700a = i;
        this.b = qe;
        this.c = interfaceC0632u8;
    }
}

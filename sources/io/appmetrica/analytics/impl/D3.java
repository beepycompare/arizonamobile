package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class D3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* renamed from: a  reason: collision with root package name */
    public final int f383a;
    public final G3 b;
    public final InterfaceC0575s8 c;

    public D3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new G3(eCommerceCartItem), new E3());
    }

    public final InterfaceC0575s8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f383a;
        if (i != 4) {
            if (i != 5) {
                return "unknown cart action info";
            }
            return "remove cart item info";
        }
        return "add cart item info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Vf
    public final List<Ni> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "CartActionInfoEvent{eventType=" + this.f383a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public D3(int i, G3 g3, InterfaceC0575s8 interfaceC0575s8) {
        this.f383a = i;
        this.b = g3;
        this.c = interfaceC0575s8;
    }
}

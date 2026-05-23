package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0731y3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* renamed from: a  reason: collision with root package name */
    public final int f1285a;
    public final B3 b;
    public final InterfaceC0632u8 c;

    public C0731y3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new B3(eCommerceCartItem), new C0757z3());
    }

    public final InterfaceC0632u8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f1285a;
        if (i != 4) {
            if (i != 5) {
                return "unknown cart action info";
            }
            return "remove cart item info";
        }
        return "add cart item info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0407lg
    public final List<Xi> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "CartActionInfoEvent{eventType=" + this.f1285a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0731y3(int i, B3 b3, InterfaceC0632u8 interfaceC0632u8) {
        this.f1285a = i;
        this.b = b3;
        this.c = interfaceC0632u8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0311i3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* renamed from: a  reason: collision with root package name */
    public final int f1016a;
    public final C0388l3 b;
    public final InterfaceC0161c8 c;

    public C0311i3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new C0388l3(eCommerceCartItem), new C0336j3());
    }

    public final InterfaceC0161c8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f1016a;
        if (i != 4) {
            if (i != 5) {
                return "unknown cart action info";
            }
            return "remove cart item info";
        }
        return "add cart item info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Lf
    public final List<Ei> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "CartActionInfoEvent{eventType=" + this.f1016a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0311i3(int i, C0388l3 c0388l3, InterfaceC0161c8 interfaceC0161c8) {
        this.f1016a = i;
        this.b = c0388l3;
        this.c = interfaceC0161c8;
    }
}

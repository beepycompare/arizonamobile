package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0290h3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* renamed from: a  reason: collision with root package name */
    public final int f1022a;
    public final C0367k3 b;
    public final InterfaceC0140b8 c;

    public C0290h3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new C0367k3(eCommerceCartItem), new C0316i3());
    }

    public final InterfaceC0140b8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f1022a;
        if (i != 4) {
            if (i != 5) {
                return "unknown cart action info";
            }
            return "remove cart item info";
        }
        return "add cart item info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "CartActionInfoEvent{eventType=" + this.f1022a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0290h3(int i, C0367k3 c0367k3, InterfaceC0140b8 interfaceC0140b8) {
        this.f1022a = i;
        this.b = c0367k3;
        this.c = interfaceC0140b8;
    }
}

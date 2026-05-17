package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.h3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0289h3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* renamed from: a  reason: collision with root package name */
    public final int f1026a;
    public final C0366k3 b;
    public final InterfaceC0139b8 c;

    public C0289h3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new C0366k3(eCommerceCartItem), new C0315i3());
    }

    public final InterfaceC0139b8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f1026a;
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
        return "CartActionInfoEvent{eventType=" + this.f1026a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C0289h3(int i, C0366k3 c0366k3, InterfaceC0139b8 interfaceC0139b8) {
        this.f1026a = i;
        this.b = c0366k3;
        this.c = interfaceC0139b8;
    }
}

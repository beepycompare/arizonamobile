package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0197cl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0445mj f787a;
    public final InterfaceC0583s8 b;

    public C0197cl(ECommerceScreen eCommerceScreen) {
        this(new C0445mj(eCommerceScreen), new C0223dl());
    }

    public final InterfaceC0583s8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Vf
    public final List<Ni> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f787a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0197cl(C0445mj c0445mj, InterfaceC0583s8 interfaceC0583s8) {
        this.f787a = c0445mj;
        this.b = interfaceC0583s8;
    }
}

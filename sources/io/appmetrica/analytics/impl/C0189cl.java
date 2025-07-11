package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0189cl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0437mj f788a;
    public final InterfaceC0575s8 b;

    public C0189cl(ECommerceScreen eCommerceScreen) {
        this(new C0437mj(eCommerceScreen), new C0215dl());
    }

    public final InterfaceC0575s8 a() {
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
        return "ShownScreenInfoEvent{screen=" + this.f788a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0189cl(C0437mj c0437mj, InterfaceC0575s8 interfaceC0575s8) {
        this.f788a = c0437mj;
        this.b = interfaceC0575s8;
    }
}

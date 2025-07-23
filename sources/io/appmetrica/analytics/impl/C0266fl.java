package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0266fl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0514pj f850a;
    public final InterfaceC0652v8 b;

    public C0266fl(ECommerceScreen eCommerceScreen) {
        this(new C0514pj(eCommerceScreen), new C0292gl());
    }

    public final InterfaceC0652v8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Xf
    public final List<Qi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f850a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0266fl(C0514pj c0514pj, InterfaceC0652v8 interfaceC0652v8) {
        this.f850a = c0514pj;
        this.b = interfaceC0652v8;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0278gl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0199dj f910a;
    public final InterfaceC0162c8 b;

    public C0278gl(ECommerceScreen eCommerceScreen) {
        this(new C0199dj(eCommerceScreen), new C0304hl());
    }

    public final InterfaceC0162c8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Lf
    public final List<Ei> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f910a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0278gl(C0199dj c0199dj, InterfaceC0162c8 interfaceC0162c8) {
        this.f910a = c0199dj;
        this.b = interfaceC0162c8;
    }
}

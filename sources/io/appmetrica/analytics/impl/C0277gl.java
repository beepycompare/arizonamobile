package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0277gl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0198dj f1007a;
    public final InterfaceC0161c8 b;

    public C0277gl(ECommerceScreen eCommerceScreen) {
        this(new C0198dj(eCommerceScreen), new C0303hl());
    }

    public final InterfaceC0161c8 a() {
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
        return "ShownScreenInfoEvent{screen=" + this.f1007a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0277gl(C0198dj c0198dj, InterfaceC0161c8 interfaceC0161c8) {
        this.f1007a = c0198dj;
        this.b = interfaceC0161c8;
    }
}

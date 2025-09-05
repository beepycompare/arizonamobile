package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ol  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0492ol extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0740yj f1019a;
    public final A8 b;

    public C0492ol(ECommerceScreen eCommerceScreen) {
        this(new C0740yj(eCommerceScreen), new C0518pl());
    }

    public final A8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0280gg
    public final List<Zi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f1019a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0492ol(C0740yj c0740yj, A8 a8) {
        this.f1019a = c0740yj;
        this.b = a8;
    }
}

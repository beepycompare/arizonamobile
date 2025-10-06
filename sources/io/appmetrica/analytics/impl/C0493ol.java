package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.ol  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0493ol extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0741yj f1024a;
    public final A8 b;

    public C0493ol(ECommerceScreen eCommerceScreen) {
        this(new C0741yj(eCommerceScreen), new C0519pl());
    }

    public final A8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0281gg
    public final List<Zi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f1024a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0493ol(C0741yj c0741yj, A8 a8) {
        this.f1024a = c0741yj;
        this.b = a8;
    }
}

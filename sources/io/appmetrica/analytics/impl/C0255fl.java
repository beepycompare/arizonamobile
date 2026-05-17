package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0255fl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final C0176cj f1003a;
    public final InterfaceC0139b8 b;

    public C0255fl(ECommerceScreen eCommerceScreen) {
        this(new C0176cj(eCommerceScreen), new C0281gl());
    }

    public final InterfaceC0139b8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.Kf
    public final List<Di> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f1003a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public C0255fl(C0176cj c0176cj, InterfaceC0139b8 interfaceC0139b8) {
        this.f1003a = c0176cj;
        this.b = interfaceC0139b8;
    }
}

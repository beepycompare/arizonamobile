package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Kl extends ECommerceEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Dj f632a;
    public final InterfaceC0632u8 b;

    public Kl(ECommerceScreen eCommerceScreen) {
        this(new Dj(eCommerceScreen), new Ll());
    }

    public final InterfaceC0632u8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC0407lg
    public final List<Xi> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f632a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public Kl(Dj dj, InterfaceC0632u8 interfaceC0632u8) {
        this.f632a = dj;
        this.b = interfaceC0632u8;
    }
}

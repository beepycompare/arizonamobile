package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Oc extends AbstractC0235f {
    public Oc(Context context, Rg rg) {
        super(context, rg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0235f
    public final void b(C0242f6 c0242f6, G4 g4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(g4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0429mc m = Na.I.m();
        m.a(booleanValue);
        m.a(g4.b.c);
        Boolean bool = g4.b.n;
        if (bool != null) {
            Na.I.c().b(bool.booleanValue());
        }
        this.b.a(c0242f6, g4);
    }
}

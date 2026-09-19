package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Oc extends AbstractC0233f {
    public Oc(Context context, Rg rg) {
        super(context, rg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0233f
    public final void b(C0240f6 c0240f6, G4 g4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(g4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0427mc m = Na.I.m();
        m.a(booleanValue);
        m.a(g4.b.c);
        Boolean bool = g4.b.n;
        if (bool != null) {
            Na.I.c().b(bool.booleanValue());
        }
        this.b.a(c0240f6, g4);
    }
}

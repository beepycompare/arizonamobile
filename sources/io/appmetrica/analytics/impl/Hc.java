package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Hc extends AbstractC0244f {
    public Hc(Context context, Og og) {
        super(context, og);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0244f
    public final void b(C0401l6 c0401l6, K4 k4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(k4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0257fc l = Ia.F.l();
        l.a(booleanValue);
        l.a(k4.b.c);
        Boolean bool = k4.b.n;
        if (bool != null) {
            Ia.F.b().b(bool.booleanValue());
        }
        this.b.a(c0401l6, k4);
    }
}

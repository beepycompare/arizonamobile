package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Fc extends AbstractC0243f {
    public Fc(Context context, Mg mg) {
        super(context, mg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0243f
    public final void b(C0325i6 c0325i6, K4 k4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(k4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0206dc l = Ga.F.l();
        l.a(booleanValue);
        l.a(k4.b.c);
        Boolean bool = k4.b.n;
        if (bool != null) {
            Ga.F.b().b(bool.booleanValue());
        }
        this.b.a(c0325i6, k4);
    }
}

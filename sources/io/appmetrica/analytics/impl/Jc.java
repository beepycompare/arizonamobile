package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Jc extends AbstractC0237f {
    public Jc(Context context, Tg tg) {
        super(context, tg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237f
    public final void b(C0399l6 c0399l6, K4 k4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(k4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0302hc l = Ka.F.l();
        l.a(booleanValue);
        l.a(k4.b.c);
        Boolean bool = k4.b.n;
        if (bool != null) {
            Ka.F.b().b(bool.booleanValue());
        }
        this.b.a(c0399l6, k4);
    }
}

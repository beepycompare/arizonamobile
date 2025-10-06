package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Mc extends AbstractC0238f {
    public Mc(Context context, Xg xg) {
        super(context, xg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0238f
    public final void b(C0478o6 c0478o6, N4 n4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(n4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0380kc l = Na.F.l();
        l.a(booleanValue);
        l.a(n4.b.c);
        Boolean bool = n4.b.n;
        if (bool != null) {
            Na.F.b().b(bool.booleanValue());
        }
        this.b.a(c0478o6, n4);
    }
}

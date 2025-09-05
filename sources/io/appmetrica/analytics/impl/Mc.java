package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Mc extends AbstractC0237f {
    public Mc(Context context, Xg xg) {
        super(context, xg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237f
    public final void b(C0477o6 c0477o6, N4 n4) {
        boolean booleanValue = ((Boolean) WrapUtils.getOrDefault(n4.b.b, Boolean.FALSE)).booleanValue();
        InterfaceC0379kc l = Na.F.l();
        l.a(booleanValue);
        l.a(n4.b.c);
        Boolean bool = n4.b.n;
        if (bool != null) {
            Na.F.b().b(bool.booleanValue());
        }
        this.b.a(c0477o6, n4);
    }
}

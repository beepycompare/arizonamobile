package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Co extends AbstractC0298hh {
    public Co(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        String j = this.f1022a.c.j();
        String str = c0235f6.h;
        this.f1022a.a(str);
        if (StringUtils.equalsNullSafety(j, str)) {
            return false;
        }
        this.f1022a.a(C0182d4.o());
        return false;
    }
}

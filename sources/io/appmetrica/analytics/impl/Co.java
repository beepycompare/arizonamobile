package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Co extends AbstractC0303hh {
    public Co(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        String j = this.f1019a.c.j();
        String str = c0240f6.h;
        this.f1019a.a(str);
        if (StringUtils.equalsNullSafety(j, str)) {
            return false;
        }
        this.f1019a.a(C0187d4.o());
        return false;
    }
}

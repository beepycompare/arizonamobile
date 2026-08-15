package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Co extends AbstractC0304hh {
    public Co(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        String j = this.f1019a.c.j();
        String str = c0241f6.h;
        this.f1019a.a(str);
        if (StringUtils.equalsNullSafety(j, str)) {
            return false;
        }
        this.f1019a.a(C0188d4.o());
        return false;
    }
}

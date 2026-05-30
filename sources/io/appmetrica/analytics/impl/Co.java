package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Co extends AbstractC0305hh {
    public Co(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        String j = this.f1017a.c.j();
        String str = c0242f6.h;
        this.f1017a.a(str);
        if (StringUtils.equalsNullSafety(j, str)) {
            return false;
        }
        this.f1017a.a(C0189d4.o());
        return false;
    }
}

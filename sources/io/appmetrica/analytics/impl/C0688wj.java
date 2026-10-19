package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0688wj extends AbstractC0298hh {
    public C0688wj(C0441n5 c0441n5) {
        super(c0441n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        String str = c0235f6.h;
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        this.f1022a.a(str);
        return false;
    }
}

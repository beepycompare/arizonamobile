package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0693wj extends AbstractC0303hh {
    public C0693wj(C0446n5 c0446n5) {
        super(c0446n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        String str = c0240f6.h;
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        this.f1019a.a(str);
        return false;
    }
}

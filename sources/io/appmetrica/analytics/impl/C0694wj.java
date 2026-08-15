package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0694wj extends AbstractC0304hh {
    public C0694wj(C0447n5 c0447n5) {
        super(c0447n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        String str = c0241f6.h;
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        this.f1019a.a(str);
        return false;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.wj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0695wj extends AbstractC0305hh {
    public C0695wj(C0448n5 c0448n5) {
        super(c0448n5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        String str = c0242f6.h;
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        this.f1016a.a(str);
        return false;
    }
}

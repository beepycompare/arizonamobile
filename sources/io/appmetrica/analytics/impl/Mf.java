package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Mf extends La {
    public Mf(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.La
    /* renamed from: a */
    public final int b(Y y) {
        if (y == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(y.b) + 12;
    }
}

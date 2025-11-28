package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Df extends C0695xa {
    public Df(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C0695xa
    /* renamed from: a */
    public final int b(Z z) {
        if (z == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(z.b) + 12;
    }
}

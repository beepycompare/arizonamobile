package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Zf extends Ta {
    public Zf(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.Ta
    /* renamed from: a */
    public final int b(C0131b0 c0131b0) {
        if (c0131b0 == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(c0131b0.b) + 12;
    }
}

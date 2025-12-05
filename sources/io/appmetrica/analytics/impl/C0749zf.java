package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0749zf extends C0544ra {
    public C0749zf(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C0544ra
    /* renamed from: a */
    public final int b(Z z) {
        if (z == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(z.b) + 12;
    }
}

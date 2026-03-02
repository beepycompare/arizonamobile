package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.yf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0727yf extends C0523qa {
    public C0727yf(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C0523qa
    /* renamed from: a */
    public final int b(Z z) {
        if (z == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(z.b) + 12;
    }
}

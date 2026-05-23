package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Ua extends Ta {
    public Ua(int i, int i2) {
        this(i, new Va(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public Ua(int i, Va va) {
        super(i, va);
    }
}

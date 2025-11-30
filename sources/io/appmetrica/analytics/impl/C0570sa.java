package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0570sa extends C0545ra {
    public C0570sa(int i, int i2) {
        this(i, new C0595ta(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.C0545ra
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public C0570sa(int i, C0595ta c0595ta) {
        super(i, c0595ta);
    }
}

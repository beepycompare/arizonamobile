package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0569sa extends C0544ra {
    public C0569sa(int i, int i2) {
        this(i, new C0594ta(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.C0544ra
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public C0569sa(int i, C0594ta c0594ta) {
        super(i, c0594ta);
    }
}

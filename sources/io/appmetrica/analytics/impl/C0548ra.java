package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.ra  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0548ra extends C0524qa {
    public C0548ra(int i, int i2) {
        this(i, new C0573sa(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.C0524qa
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public C0548ra(int i, C0573sa c0573sa) {
        super(i, c0573sa);
    }
}

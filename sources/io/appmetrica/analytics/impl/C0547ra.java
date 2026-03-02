package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.ra  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0547ra extends C0523qa {
    public C0547ra(int i, int i2) {
        this(i, new C0572sa(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.C0523qa
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public C0547ra(int i, C0572sa c0572sa) {
        super(i, c0572sa);
    }
}

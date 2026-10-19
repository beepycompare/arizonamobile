package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0426mg implements Wo, R8 {
    @Override // io.appmetrica.analytics.impl.R8
    public final int a(EnumC0161c9 enumC0161c9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        if (StringUtils.isNullOrEmpty(c0290h9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0290h9.b, 0);
    }
}

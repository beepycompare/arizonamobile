package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0432mg implements Wo, R8 {
    @Override // io.appmetrica.analytics.impl.R8
    public final int a(EnumC0167c9 enumC0167c9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0296h9 c0296h9, Eh eh) {
        if (StringUtils.isNullOrEmpty(c0296h9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0296h9.b, 0);
    }
}

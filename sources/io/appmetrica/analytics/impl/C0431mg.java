package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0431mg implements Wo, R8 {
    @Override // io.appmetrica.analytics.impl.R8
    public final int a(EnumC0166c9 enumC0166c9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0295h9 c0295h9, Eh eh) {
        if (StringUtils.isNullOrEmpty(c0295h9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0295h9.b, 0);
    }
}

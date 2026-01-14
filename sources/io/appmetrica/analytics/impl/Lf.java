package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes5.dex */
public final class Lf implements to, InterfaceC0721y8 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0721y8
    public final int a(I8 i8) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0381kh c0381kh) {
        if (TextUtils.isEmpty(n8.b)) {
            return new byte[0];
        }
        return Base64.decode(n8.b, 0);
    }
}

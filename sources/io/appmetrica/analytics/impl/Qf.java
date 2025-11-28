package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes5.dex */
public final class Qf implements vo, D8 {
    @Override // io.appmetrica.analytics.impl.D8
    public final int a(N8 n8) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        if (TextUtils.isEmpty(s8.b)) {
            return new byte[0];
        }
        return Base64.decode(s8.b, 0);
    }
}

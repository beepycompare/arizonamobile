package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes4.dex */
public final class Yf implements qo, R8 {
    @Override // io.appmetrica.analytics.impl.R8
    public final int a(EnumC0152b9 enumC0152b9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        if (TextUtils.isEmpty(c0281g9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0281g9.b, 0);
    }
}

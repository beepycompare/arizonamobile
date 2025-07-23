package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes4.dex */
public final class Yf implements qo, R8 {
    @Override // io.appmetrica.analytics.impl.R8
    public final int a(EnumC0151b9 enumC0151b9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        if (TextUtils.isEmpty(c0280g9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0280g9.b, 0);
    }
}

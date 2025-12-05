package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes5.dex */
public final class Mf implements uo, InterfaceC0742z8 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0742z8
    public final int a(J8 j8) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0402lh c0402lh) {
        if (TextUtils.isEmpty(o8.b)) {
            return new byte[0];
        }
        return Base64.decode(o8.b, 0);
    }
}

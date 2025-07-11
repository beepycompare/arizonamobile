package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes4.dex */
public final class Wf implements no, O8 {
    @Override // io.appmetrica.analytics.impl.O8
    public final int a(Y8 y8) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0203d9 c0203d9, C0659vh c0659vh) {
        if (TextUtils.isEmpty(c0203d9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0203d9.b, 0);
    }
}

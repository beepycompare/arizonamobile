package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0203dg implements vo, T8 {
    @Override // io.appmetrica.analytics.impl.T8
    public final int a(EnumC0196d9 enumC0196d9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        if (TextUtils.isEmpty(c0325i9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0325i9.b, 0);
    }
}

package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.dn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0210dn implements vo {
    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        if (!TextUtils.isEmpty(c0325i9.b)) {
            return StringUtils.getUTF8Bytes(c0325i9.b);
        }
        return new byte[0];
    }
}

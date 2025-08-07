package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Ym implements qo {
    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        if (!TextUtils.isEmpty(c0281g9.b)) {
            return StringUtils.getUTF8Bytes(c0281g9.b);
        }
        return new byte[0];
    }
}

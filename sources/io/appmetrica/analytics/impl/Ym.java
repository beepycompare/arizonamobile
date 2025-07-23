package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Ym implements qo {
    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        if (!TextUtils.isEmpty(c0280g9.b)) {
            return StringUtils.getUTF8Bytes(c0280g9.b);
        }
        return new byte[0];
    }
}

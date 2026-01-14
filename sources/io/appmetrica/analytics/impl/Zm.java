package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Zm implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0381kh c0381kh) {
        if (!TextUtils.isEmpty(n8.b)) {
            return StringUtils.getUTF8Bytes(n8.b);
        }
        return new byte[0];
    }
}

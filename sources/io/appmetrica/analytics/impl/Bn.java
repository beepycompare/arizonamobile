package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Bn implements Wo {
    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        if (!TextUtils.isEmpty(c0297h9.b)) {
            return StringUtils.getUTF8Bytes(c0297h9.b);
        }
        return new byte[0];
    }
}

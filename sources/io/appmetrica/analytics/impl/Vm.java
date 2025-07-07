package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class Vm implements no {
    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0211d9 c0211d9, C0667vh c0667vh) {
        if (!TextUtils.isEmpty(c0211d9.b)) {
            return StringUtils.getUTF8Bytes(c0211d9.b);
        }
        return new byte[0];
    }
}

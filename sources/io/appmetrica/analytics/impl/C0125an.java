package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.an  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0125an implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0403lh c0403lh) {
        if (!TextUtils.isEmpty(o8.b)) {
            return StringUtils.getUTF8Bytes(o8.b);
        }
        return new byte[0];
    }
}

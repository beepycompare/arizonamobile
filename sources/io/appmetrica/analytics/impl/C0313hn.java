package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.hn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0313hn implements zo {
    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        if (!TextUtils.isEmpty(c0402l9.b)) {
            return StringUtils.getUTF8Bytes(c0402l9.b);
        }
        return new byte[0];
    }
}

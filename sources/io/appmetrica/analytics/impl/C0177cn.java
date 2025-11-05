package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0177cn implements vo {
    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        if (!TextUtils.isEmpty(s8.b)) {
            return StringUtils.getUTF8Bytes(s8.b);
        }
        return new byte[0];
    }
}

package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0306hg implements zo, W8 {
    @Override // io.appmetrica.analytics.impl.W8
    public final int a(EnumC0273g9 enumC0273g9) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        if (TextUtils.isEmpty(c0402l9.b)) {
            return new byte[0];
        }
        return Base64.decode(c0402l9.b, 0);
    }
}

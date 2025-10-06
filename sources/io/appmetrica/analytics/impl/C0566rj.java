package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0566rj extends AbstractC0463nh {
    public C0566rj(C0652v5 c0652v5) {
        super(c0652v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        String str = c0478o6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f1006a.c.j(str).b();
        return false;
    }
}

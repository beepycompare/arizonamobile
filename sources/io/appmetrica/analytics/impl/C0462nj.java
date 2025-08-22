package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.nj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0462nj extends AbstractC0358jh {
    public C0462nj(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        String str = c0399l6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f925a.c.j(str).b();
        return false;
    }
}

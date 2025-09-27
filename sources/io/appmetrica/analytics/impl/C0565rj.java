package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0565rj extends AbstractC0462nh {
    public C0565rj(C0651v5 c0651v5) {
        super(c0651v5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        String str = c0477o6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f1006a.c.j(str).b();
        return false;
    }
}

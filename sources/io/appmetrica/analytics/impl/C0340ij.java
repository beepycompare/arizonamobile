package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0340ij extends AbstractC0237eh {
    public C0340ij(C0575s5 c0575s5) {
        super(c0575s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        String str = c0402l6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f831a.c.j(str).b();
        return false;
    }
}

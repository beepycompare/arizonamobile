package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.aj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0121aj extends Wg {
    public C0121aj(C0210e5 c0210e5) {
        super(c0210e5);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        String str = w5.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f744a.c.j(str).b();
        return false;
    }
}

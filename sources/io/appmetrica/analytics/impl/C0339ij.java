package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0339ij extends AbstractC0236eh {
    public C0339ij(C0574s5 c0574s5) {
        super(c0574s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        String str = c0401l6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f831a.c.j(str).b();
        return false;
    }
}

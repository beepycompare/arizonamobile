package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.fj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0263fj extends AbstractC0185ch {
    public C0263fj(C0572s5 c0572s5) {
        super(c0572s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        String str = c0325i6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f786a.c.j(str).b();
        return false;
    }
}

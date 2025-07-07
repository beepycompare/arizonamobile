package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.fj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0271fj extends AbstractC0193ch {
    public C0271fj(C0580s5 c0580s5) {
        super(c0580s5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        String str = c0333i6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f785a.c.j(str).b();
        return false;
    }
}

package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0130ao extends Rg {
    public C0130ao(X4 x4) {
        super(x4);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        String j = this.f767a.c.j();
        String str = p5.h;
        this.f767a.c.j(str).b();
        if (TextUtils.equals(j, str)) {
            return false;
        }
        this.f767a.a(M3.o());
        return false;
    }
}

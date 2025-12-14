package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.bo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0151bo extends Sg {
    public C0151bo(Y4 y4) {
        super(y4);
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        String j = this.f776a.c.j();
        String str = q5.h;
        this.f776a.c.j(str).b();
        if (TextUtils.equals(j, str)) {
            return false;
        }
        this.f776a.a(N3.o());
        return false;
    }
}

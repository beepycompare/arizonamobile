package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0592t4 extends Ad {
    public final Object f;

    public AbstractC0592t4(int i, String str, Object obj, so soVar, J2 j2) {
        super(i, str, soVar, j2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Ad, io.appmetrica.analytics.impl.InterfaceC0233eo
    public final void a(Cdo cdo) {
        if (f()) {
            J2 j2 = this.d;
            int i = this.b;
            C0259fo a2 = j2.a(cdo, (C0259fo) ((HashMap) cdo.f964a.get(i)).get(this.f498a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0259fo c0259fo);

    public final Object g() {
        return this.f;
    }
}

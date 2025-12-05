package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0139bc implements InterfaceC0286h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0286h4
    /* renamed from: b */
    public final C0638v4 a(Context context, C0209e5 c0209e5, Q3 q3, C0514q4 c0514q4) {
        C0713y4 c0713y4;
        C0663w4 c0663w4 = new C0663w4(q3.b);
        C0738z4 c0738z4 = new C0738z4();
        synchronized (c0209e5) {
            c0713y4 = (C0713y4) c0209e5.a(c0663w4, c0514q4, c0738z4, c0209e5.b);
        }
        return new C0638v4(context, c0713y4, c0514q4);
    }
}

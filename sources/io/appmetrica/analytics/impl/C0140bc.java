package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.bc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0140bc implements InterfaceC0287h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0287h4
    /* renamed from: b */
    public final C0639v4 a(Context context, C0210e5 c0210e5, Q3 q3, C0515q4 c0515q4) {
        C0714y4 c0714y4;
        C0664w4 c0664w4 = new C0664w4(q3.b);
        C0739z4 c0739z4 = new C0739z4();
        synchronized (c0210e5) {
            c0714y4 = (C0714y4) c0210e5.a(c0664w4, c0515q4, c0739z4, c0210e5.b);
        }
        return new C0639v4(context, c0714y4, c0515q4);
    }
}

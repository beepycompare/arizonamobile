package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ac implements E4 {
    @Override // io.appmetrica.analytics.impl.E4
    /* renamed from: b */
    public final S4 a(Context context, B5 b5, C0475o4 c0475o4, N4 n4) {
        V4 v4;
        T4 t4 = new T4(c0475o4.b);
        W4 w4 = new W4();
        synchronized (b5) {
            v4 = (V4) b5.a(t4, n4, w4, b5.b);
        }
        return new S4(context, v4, n4);
    }
}

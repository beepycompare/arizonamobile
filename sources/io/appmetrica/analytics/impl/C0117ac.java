package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0117ac implements InterfaceC0264g4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0264g4
    /* renamed from: b */
    public final C0616u4 a(Context context, C0188d5 c0188d5, P3 p3, C0492p4 c0492p4) {
        C0691x4 c0691x4;
        C0641v4 c0641v4 = new C0641v4(p3.b);
        C0716y4 c0716y4 = new C0716y4();
        synchronized (c0188d5) {
            c0691x4 = (C0691x4) c0188d5.a(c0641v4, c0492p4, c0716y4, c0188d5.b);
        }
        return new C0616u4(context, c0691x4, c0492p4);
    }
}

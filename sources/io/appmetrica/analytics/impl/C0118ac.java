package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0118ac implements InterfaceC0265g4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0265g4
    /* renamed from: b */
    public final C0617u4 a(Context context, C0189d5 c0189d5, P3 p3, C0493p4 c0493p4) {
        C0692x4 c0692x4;
        C0642v4 c0642v4 = new C0642v4(p3.b);
        C0717y4 c0717y4 = new C0717y4();
        synchronized (c0189d5) {
            c0692x4 = (C0692x4) c0189d5.a(c0642v4, c0493p4, c0717y4, c0189d5.b);
        }
        return new C0617u4(context, c0692x4, c0493p4);
    }
}

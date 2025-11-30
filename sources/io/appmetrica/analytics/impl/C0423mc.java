package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0423mc implements InterfaceC0287h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0287h4
    /* renamed from: b */
    public final C0448nc a(Context context, C0210e5 c0210e5, Q3 q3, C0515q4 c0515q4) {
        Cg cg;
        C0473oc c0473oc = new C0473oc(q3.b, q3.f647a);
        Dg dg = new Dg(new C0547rc());
        synchronized (c0210e5) {
            cg = (Cg) c0210e5.a(c0473oc, c0515q4, dg, c0210e5.f865a);
        }
        return new C0448nc(context, cg);
    }
}

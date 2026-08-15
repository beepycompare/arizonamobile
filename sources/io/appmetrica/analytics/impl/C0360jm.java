package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0360jm {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f1057a = new Sa();
    public final HashMap b = new HashMap();
    public Hm c = null;
    public final C0309hm d = new C0309hm(this);

    public static final C0360jm a() {
        return AbstractC0334im.f1041a;
    }

    public final C0181cn a(Context context, C0266g5 c0266g5, Bm bm) {
        C0181cn c0181cn = (C0181cn) this.b.get(c0266g5.f995a);
        boolean z = true;
        if (c0181cn == null) {
            synchronized (this.b) {
                c0181cn = (C0181cn) this.b.get(c0266g5.f995a);
                if (c0181cn == null) {
                    c0181cn = new C0181cn(new C0207dn(context, c0266g5.f995a, bm, this.d));
                    c0181cn.f();
                    this.b.put(c0266g5.f995a, c0181cn);
                    z = false;
                }
            }
        }
        if (z) {
            c0181cn.a(bm);
        }
        return c0181cn;
    }

    public final void a(C0266g5 c0266g5, InterfaceC0593sm interfaceC0593sm) {
        synchronized (this.b) {
            this.f1057a.a(c0266g5.f995a, interfaceC0593sm);
            Hm hm = this.c;
            if (hm != null) {
                interfaceC0593sm.a(hm);
            }
        }
    }
}

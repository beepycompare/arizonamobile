package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0361jm {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f1055a = new Sa();
    public final HashMap b = new HashMap();
    public Hm c = null;
    public final C0310hm d = new C0310hm(this);

    public static final C0361jm a() {
        return AbstractC0335im.f1039a;
    }

    public final C0182cn a(Context context, C0267g5 c0267g5, Bm bm) {
        C0182cn c0182cn = (C0182cn) this.b.get(c0267g5.f993a);
        boolean z = true;
        if (c0182cn == null) {
            synchronized (this.b) {
                c0182cn = (C0182cn) this.b.get(c0267g5.f993a);
                if (c0182cn == null) {
                    c0182cn = new C0182cn(new C0208dn(context, c0267g5.f993a, bm, this.d));
                    c0182cn.f();
                    this.b.put(c0267g5.f993a, c0182cn);
                    z = false;
                }
            }
        }
        if (z) {
            c0182cn.a(bm);
        }
        return c0182cn;
    }

    public final void a(C0267g5 c0267g5, InterfaceC0594sm interfaceC0594sm) {
        synchronized (this.b) {
            this.f1055a.a(c0267g5.f993a, interfaceC0594sm);
            Hm hm = this.c;
            if (hm != null) {
                interfaceC0594sm.a(hm);
            }
        }
    }
}

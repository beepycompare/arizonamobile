package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0359jm {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f1057a = new Sa();
    public final HashMap b = new HashMap();
    public Hm c = null;
    public final C0308hm d = new C0308hm(this);

    public static final C0359jm a() {
        return AbstractC0333im.f1041a;
    }

    public final C0180cn a(Context context, C0265g5 c0265g5, Bm bm) {
        C0180cn c0180cn = (C0180cn) this.b.get(c0265g5.f995a);
        boolean z = true;
        if (c0180cn == null) {
            synchronized (this.b) {
                c0180cn = (C0180cn) this.b.get(c0265g5.f995a);
                if (c0180cn == null) {
                    c0180cn = new C0180cn(new C0206dn(context, c0265g5.f995a, bm, this.d));
                    c0180cn.f();
                    this.b.put(c0265g5.f995a, c0180cn);
                    z = false;
                }
            }
        }
        if (z) {
            c0180cn.a(bm);
        }
        return c0180cn;
    }

    public final void a(C0265g5 c0265g5, InterfaceC0592sm interfaceC0592sm) {
        synchronized (this.b) {
            this.f1057a.a(c0265g5.f995a, interfaceC0592sm);
            Hm hm = this.c;
            if (hm != null) {
                interfaceC0592sm.a(hm);
            }
        }
    }
}

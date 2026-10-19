package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0354jm {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f1060a = new Sa();
    public final HashMap b = new HashMap();
    public Hm c = null;
    public final C0303hm d = new C0303hm(this);

    public static final C0354jm a() {
        return AbstractC0328im.f1044a;
    }

    public final C0175cn a(Context context, C0260g5 c0260g5, Bm bm) {
        C0175cn c0175cn = (C0175cn) this.b.get(c0260g5.f998a);
        boolean z = true;
        if (c0175cn == null) {
            synchronized (this.b) {
                c0175cn = (C0175cn) this.b.get(c0260g5.f998a);
                if (c0175cn == null) {
                    c0175cn = new C0175cn(new C0201dn(context, c0260g5.f998a, bm, this.d));
                    c0175cn.f();
                    this.b.put(c0260g5.f998a, c0175cn);
                    z = false;
                }
            }
        }
        if (z) {
            c0175cn.a(bm);
        }
        return c0175cn;
    }

    public final void a(C0260g5 c0260g5, InterfaceC0587sm interfaceC0587sm) {
        synchronized (this.b) {
            this.f1060a.a(c0260g5.f998a, interfaceC0587sm);
            Hm hm = this.c;
            if (hm != null) {
                interfaceC0587sm.a(hm);
            }
        }
    }
}

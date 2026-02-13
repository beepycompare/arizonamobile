package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Hl {

    /* renamed from: a  reason: collision with root package name */
    public final C0499pa f618a = new C0499pa();
    public final HashMap b = new HashMap();
    public C0257fm c = null;
    public final Fl d = new Fl(this);

    public static final Hl a() {
        return Gl.f601a;
    }

    public final Am a(Context context, Q4 q4, Zl zl) {
        Am am = (Am) this.b.get(q4.f748a);
        boolean z = true;
        if (am == null) {
            synchronized (this.b) {
                am = (Am) this.b.get(q4.f748a);
                if (am == null) {
                    am = new Am(new Bm(context, q4.f748a, zl, this.d));
                    am.f();
                    this.b.put(q4.f748a, am);
                    z = false;
                }
            }
        }
        if (z) {
            am.a(zl);
        }
        return am;
    }

    public final void a(Q4 q4, Ql ql) {
        synchronized (this.b) {
            this.f618a.a(q4.f748a, ql);
            C0257fm c0257fm = this.c;
            if (c0257fm != null) {
                ql.a(c0257fm);
            }
        }
    }
}

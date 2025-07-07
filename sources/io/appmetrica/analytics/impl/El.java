package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class El {

    /* renamed from: a  reason: collision with root package name */
    public final Ia f414a = new Ia();
    public final HashMap b = new HashMap();
    public C0198cm c = null;
    public final Cl d = new Cl(this);

    public static final El a() {
        return Dl.f393a;
    }

    public final C0747ym a(Context context, C0406l5 c0406l5, Wl wl) {
        C0747ym c0747ym = (C0747ym) this.b.get(c0406l5.f917a);
        boolean z = true;
        if (c0747ym == null) {
            synchronized (this.b) {
                c0747ym = (C0747ym) this.b.get(c0406l5.f917a);
                if (c0747ym == null) {
                    c0747ym = new C0747ym(new C0772zm(context, c0406l5.f917a, wl, this.d));
                    c0747ym.f();
                    this.b.put(c0406l5.f917a, c0747ym);
                    z = false;
                }
            }
        }
        if (z) {
            c0747ym.a(wl);
        }
        return c0747ym;
    }

    public final void a(C0406l5 c0406l5, Nl nl) {
        synchronized (this.b) {
            this.f414a.a(c0406l5.f917a, nl);
            C0198cm c0198cm = this.c;
            if (c0198cm != null) {
                nl.a(c0198cm);
            }
        }
    }
}

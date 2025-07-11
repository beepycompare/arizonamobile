package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class El {

    /* renamed from: a  reason: collision with root package name */
    public final Ia f415a = new Ia();
    public final HashMap b = new HashMap();
    public C0190cm c = null;
    public final Cl d = new Cl(this);

    public static final El a() {
        return Dl.f394a;
    }

    public final C0739ym a(Context context, C0398l5 c0398l5, Wl wl) {
        C0739ym c0739ym = (C0739ym) this.b.get(c0398l5.f918a);
        boolean z = true;
        if (c0739ym == null) {
            synchronized (this.b) {
                c0739ym = (C0739ym) this.b.get(c0398l5.f918a);
                if (c0739ym == null) {
                    c0739ym = new C0739ym(new C0764zm(context, c0398l5.f918a, wl, this.d));
                    c0739ym.f();
                    this.b.put(c0398l5.f918a, c0739ym);
                    z = false;
                }
            }
        }
        if (z) {
            c0739ym.a(wl);
        }
        return c0739ym;
    }

    public final void a(C0398l5 c0398l5, Nl nl) {
        synchronized (this.b) {
            this.f415a.a(c0398l5.f918a, nl);
            C0190cm c0190cm = this.c;
            if (c0190cm != null) {
                nl.a(c0190cm);
            }
        }
    }
}

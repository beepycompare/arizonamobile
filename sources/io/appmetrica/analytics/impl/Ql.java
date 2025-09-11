package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ql {

    /* renamed from: a  reason: collision with root package name */
    public final Pa f644a = new Pa();
    public final HashMap b = new HashMap();
    public C0493om c = null;
    public final Ol d = new Ol(this);

    public static final Ql a() {
        return Pl.f629a;
    }

    public final Km a(Context context, C0476o5 c0476o5, C0337im c0337im) {
        Km km = (Km) this.b.get(c0476o5.f1016a);
        boolean z = true;
        if (km == null) {
            synchronized (this.b) {
                km = (Km) this.b.get(c0476o5.f1016a);
                if (km == null) {
                    km = new Km(new Lm(context, c0476o5.f1016a, c0337im, this.d));
                    km.f();
                    this.b.put(c0476o5.f1016a, km);
                    z = false;
                }
            }
        }
        if (z) {
            km.a(c0337im);
        }
        return km;
    }

    public final void a(C0476o5 c0476o5, Zl zl) {
        synchronized (this.b) {
            this.f644a.a(c0476o5.f1016a, zl);
            C0493om c0493om = this.c;
            if (c0493om != null) {
                zl.a(c0493om);
            }
        }
    }
}

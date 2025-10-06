package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ql {

    /* renamed from: a  reason: collision with root package name */
    public final Pa f645a = new Pa();
    public final HashMap b = new HashMap();
    public C0494om c = null;
    public final Ol d = new Ol(this);

    public static final Ql a() {
        return Pl.f630a;
    }

    public final Km a(Context context, C0477o5 c0477o5, C0338im c0338im) {
        Km km = (Km) this.b.get(c0477o5.f1017a);
        boolean z = true;
        if (km == null) {
            synchronized (this.b) {
                km = (Km) this.b.get(c0477o5.f1017a);
                if (km == null) {
                    km = new Km(new Lm(context, c0477o5.f1017a, c0338im, this.d));
                    km.f();
                    this.b.put(c0477o5.f1017a, km);
                    z = false;
                }
            }
        }
        if (z) {
            km.a(c0338im);
        }
        return km;
    }

    public final void a(C0477o5 c0477o5, Zl zl) {
        synchronized (this.b) {
            this.f645a.a(c0477o5.f1017a, zl);
            C0494om c0494om = this.c;
            if (c0494om != null) {
                zl.a(c0494om);
            }
        }
    }
}

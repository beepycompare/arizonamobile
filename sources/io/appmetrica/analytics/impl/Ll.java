package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class Ll {

    /* renamed from: a  reason: collision with root package name */
    public final C0670wa f580a = new C0670wa();
    public final HashMap b = new HashMap();
    public C0356jm c = null;
    public final Jl d = new Jl(this);

    public static final Ll a() {
        return Kl.f563a;
    }

    public final Em a(Context context, X4 x4, C0202dm c0202dm) {
        Em em = (Em) this.b.get(x4.f752a);
        boolean z = true;
        if (em == null) {
            synchronized (this.b) {
                em = (Em) this.b.get(x4.f752a);
                if (em == null) {
                    em = new Em(new Fm(context, x4.f752a, c0202dm, this.d));
                    em.f();
                    this.b.put(x4.f752a, em);
                    z = false;
                }
            }
        }
        if (z) {
            em.a(c0202dm);
        }
        return em;
    }

    public final void a(X4 x4, Ul ul) {
        synchronized (this.b) {
            this.f580a.a(x4.f752a, ul);
            C0356jm c0356jm = this.c;
            if (c0356jm != null) {
                ul.a(c0356jm);
            }
        }
    }
}

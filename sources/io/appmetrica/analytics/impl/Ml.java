package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ml {

    /* renamed from: a  reason: collision with root package name */
    public final Ma f565a = new Ma();
    public final HashMap b = new HashMap();
    public C0389km c = null;
    public final Kl d = new Kl(this);

    public static final Ml a() {
        return Ll.f548a;
    }

    public final Gm a(Context context, C0398l5 c0398l5, C0234em c0234em) {
        Gm gm = (Gm) this.b.get(c0398l5.f949a);
        boolean z = true;
        if (gm == null) {
            synchronized (this.b) {
                gm = (Gm) this.b.get(c0398l5.f949a);
                if (gm == null) {
                    gm = new Gm(new Hm(context, c0398l5.f949a, c0234em, this.d));
                    gm.f();
                    this.b.put(c0398l5.f949a, gm);
                    z = false;
                }
            }
        }
        if (z) {
            gm.a(c0234em);
        }
        return gm;
    }

    public final void a(C0398l5 c0398l5, Vl vl) {
        synchronized (this.b) {
            this.f565a.a(c0398l5.f949a, vl);
            C0389km c0389km = this.c;
            if (c0389km != null) {
                vl.a(c0389km);
            }
        }
    }
}

package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Il {

    /* renamed from: a  reason: collision with root package name */
    public final C0521qa f529a = new C0521qa();
    public final HashMap b = new HashMap();
    public C0279gm c = null;
    public final Gl d = new Gl(this);

    public static final Il a() {
        return Hl.f512a;
    }

    public final Bm a(Context context, R4 r4, C0124am c0124am) {
        Bm bm = (Bm) this.b.get(r4.f659a);
        boolean z = true;
        if (bm == null) {
            synchronized (this.b) {
                bm = (Bm) this.b.get(r4.f659a);
                if (bm == null) {
                    bm = new Bm(new Cm(context, r4.f659a, c0124am, this.d));
                    bm.f();
                    this.b.put(r4.f659a, bm);
                    z = false;
                }
            }
        }
        if (z) {
            bm.a(c0124am);
        }
        return bm;
    }

    public final void a(R4 r4, Rl rl) {
        synchronized (this.b) {
            this.f529a.a(r4.f659a, rl);
            C0279gm c0279gm = this.c;
            if (c0279gm != null) {
                rl.a(c0279gm);
            }
        }
    }
}

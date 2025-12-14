package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Il {

    /* renamed from: a  reason: collision with root package name */
    public final C0520qa f626a = new C0520qa();
    public final HashMap b = new HashMap();
    public C0278gm c = null;
    public final Gl d = new Gl(this);

    public static final Il a() {
        return Hl.f609a;
    }

    public final Bm a(Context context, R4 r4, C0123am c0123am) {
        Bm bm = (Bm) this.b.get(r4.f756a);
        boolean z = true;
        if (bm == null) {
            synchronized (this.b) {
                bm = (Bm) this.b.get(r4.f756a);
                if (bm == null) {
                    bm = new Bm(new Cm(context, r4.f756a, c0123am, this.d));
                    bm.f();
                    this.b.put(r4.f756a, bm);
                    z = false;
                }
            }
        }
        if (z) {
            bm.a(c0123am);
        }
        return bm;
    }

    public final void a(R4 r4, Rl rl) {
        synchronized (this.b) {
            this.f626a.a(r4.f756a, rl);
            C0278gm c0278gm = this.c;
            if (c0278gm != null) {
                rl.a(c0278gm);
            }
        }
    }
}

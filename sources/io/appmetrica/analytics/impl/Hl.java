package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Hl {

    /* renamed from: a  reason: collision with root package name */
    public final Ka f476a = new Ka();
    public final HashMap b = new HashMap();
    public C0268fm c = null;
    public final Fl d = new Fl(this);

    public static final Hl a() {
        return Gl.f458a;
    }

    public final Bm a(Context context, C0401l5 c0401l5, Zl zl) {
        Bm bm = (Bm) this.b.get(c0401l5.f934a);
        boolean z = true;
        if (bm == null) {
            synchronized (this.b) {
                bm = (Bm) this.b.get(c0401l5.f934a);
                if (bm == null) {
                    bm = new Bm(new Cm(context, c0401l5.f934a, zl, this.d));
                    bm.f();
                    this.b.put(c0401l5.f934a, bm);
                    z = false;
                }
            }
        }
        if (z) {
            bm.a(zl);
        }
        return bm;
    }

    public final void a(C0401l5 c0401l5, Ql ql) {
        synchronized (this.b) {
            this.f476a.a(c0401l5.f934a, ql);
            C0268fm c0268fm = this.c;
            if (c0268fm != null) {
                ql.a(c0268fm);
            }
        }
    }
}

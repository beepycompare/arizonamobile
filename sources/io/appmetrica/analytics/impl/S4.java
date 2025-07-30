package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class S4 implements Za, Ql, InterfaceC0153bb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f633a;
    public final C0400l5 b;
    public final Bm c;
    public final Mh d;
    public final Z4 e;
    public final C0368jn f;
    public ArrayList g;
    public final C0425m5 h;
    public final C0735yg i;
    public final C0499p4 j;
    public final Dg k;
    public final Object l;

    public S4(Context context, Hl hl, C0400l5 c0400l5, K4 k4, C0735yg c0735yg) {
        this(context, hl, c0400l5, k4, new Mh(k4.b), c0735yg, new C0425m5(), new U4(), new Dg());
    }

    public static void b(K4 k4) {
        Boolean bool = k4.b.n;
        Ia.F.b().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(J4 j4) {
        Mh mh = this.d;
        mh.f550a = mh.f550a.mergeFrom(j4);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final J4 d() {
        return this.d.f550a;
    }

    public final C0735yg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final Context getContext() {
        return this.f633a;
    }

    public S4(Context context, Hl hl, C0400l5 c0400l5, K4 k4, Mh mh, C0735yg c0735yg, C0425m5 c0425m5, U4 u4, Dg dg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f633a = applicationContext;
        this.b = c0400l5;
        this.d = mh;
        this.h = c0425m5;
        this.e = U4.a(this);
        b(k4);
        Bm a2 = hl.a(applicationContext, c0400l5, k4.f516a);
        this.c = a2;
        this.j = AbstractC0524q4.a(a2, Ia.j().b());
        this.f = u4.a(this, a2);
        this.i = c0735yg;
        this.k = dg;
        hl.a(c0400l5, this);
    }

    public final synchronized void a(P4 p4) {
        this.h.f950a.add(p4);
        W6.a(p4.c, this.j.a(Gm.a(this.c.e().l)));
    }

    public final synchronized void b(P4 p4) {
        this.h.f950a.remove(p4);
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final C0400l5 b() {
        return this.b;
    }

    public final void a(C0401l6 c0401l6, P4 p4) {
        Z4 z4 = this.e;
        z4.getClass();
        z4.a(c0401l6, new Y4(p4));
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0267fm c0267fm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0580sb c0580sb = (C0580sb) it.next();
                W6.a(c0580sb.f1052a, jl, this.j.a(c0580sb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(C0267fm c0267fm) {
        synchronized (this.l) {
            Iterator it = this.h.f950a.iterator();
            while (it.hasNext()) {
                W6.a(((P4) it.next()).c, this.j.a(Gm.a(c0267fm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0580sb c0580sb = (C0580sb) it2.next();
                if (AbstractC0190cm.a(c0267fm, c0580sb.b, c0580sb.c, new C0531qb())) {
                    W6.a(c0580sb.f1052a, this.j.a(c0580sb.c));
                } else {
                    arrayList.add(c0580sb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0580sb c0580sb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0580sb != null) {
            list = c0580sb.b;
            resultReceiver = c0580sb.f1052a;
            hashMap = c0580sb.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            W6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                W6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && c0580sb != null) {
                this.g.add(c0580sb);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new R4(resultReceiver));
    }

    public final C0499p4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0153bb
    public final void a(K4 k4) {
        this.c.a(k4.f516a);
        a(k4.b);
    }
}

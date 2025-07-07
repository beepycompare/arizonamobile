package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class S4 implements Xa, Nl, Za {

    /* renamed from: a  reason: collision with root package name */
    public final Context f620a;
    public final C0406l5 b;
    public final C0747ym c;
    public final Kh d;
    public final Z4 e;
    public final C0300gn f;
    public ArrayList g;
    public final C0431m5 h;
    public final C0691wg i;
    public final C0505p4 j;
    public final Bg k;
    public final Object l;

    public S4(Context context, El el, C0406l5 c0406l5, K4 k4, C0691wg c0691wg) {
        this(context, el, c0406l5, k4, new Kh(k4.b), c0691wg, new C0431m5(), new U4(), new Bg());
    }

    public static void b(K4 k4) {
        Boolean bool = k4.b.n;
        Ga.F.b().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(J4 j4) {
        Kh kh = this.d;
        kh.f506a = kh.f506a.mergeFrom(j4);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final J4 d() {
        return this.d.f506a;
    }

    public final C0691wg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final Context getContext() {
        return this.f620a;
    }

    public S4(Context context, El el, C0406l5 c0406l5, K4 k4, Kh kh, C0691wg c0691wg, C0431m5 c0431m5, U4 u4, Bg bg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f620a = applicationContext;
        this.b = c0406l5;
        this.d = kh;
        this.h = c0431m5;
        this.e = U4.a(this);
        b(k4);
        C0747ym a2 = el.a(applicationContext, c0406l5, k4.f500a);
        this.c = a2;
        this.j = AbstractC0530q4.a(a2, Ga.j().b());
        this.f = u4.a(this, a2);
        this.i = c0691wg;
        this.k = bg;
        el.a(c0406l5, this);
    }

    public final synchronized void a(P4 p4) {
        this.h.f933a.add(p4);
        T6.a(p4.c, this.j.a(Dm.a(this.c.e().l)));
    }

    public final synchronized void b(P4 p4) {
        this.h.f933a.remove(p4);
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final C0406l5 b() {
        return this.b;
    }

    public final void a(C0333i6 c0333i6, P4 p4) {
        Z4 z4 = this.e;
        z4.getClass();
        z4.a(c0333i6, new Y4(p4));
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(Gl gl, C0198cm c0198cm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0537qb c0537qb = (C0537qb) it.next();
                T6.a(c0537qb.f1004a, gl, this.j.a(c0537qb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(C0198cm c0198cm) {
        synchronized (this.l) {
            Iterator it = this.h.f933a.iterator();
            while (it.hasNext()) {
                T6.a(((P4) it.next()).c, this.j.a(Dm.a(c0198cm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0537qb c0537qb = (C0537qb) it2.next();
                if (Zl.a(c0198cm, c0537qb.b, c0537qb.c, new C0487ob())) {
                    T6.a(c0537qb.f1004a, this.j.a(c0537qb.c));
                } else {
                    arrayList.add(c0537qb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0537qb c0537qb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0537qb != null) {
            list = c0537qb.b;
            resultReceiver = c0537qb.f1004a;
            hashMap = c0537qb.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            T6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                T6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && c0537qb != null) {
                this.g.add(c0537qb);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new R4(resultReceiver));
    }

    public final C0505p4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(K4 k4) {
        this.c.a(k4.f500a);
        a(k4.b);
    }
}

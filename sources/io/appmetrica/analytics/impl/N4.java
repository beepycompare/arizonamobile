package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class N4 implements InterfaceC0273gb, InterfaceC0594sm, InterfaceC0325ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f679a;
    public final C0267g5 b;
    public final C0182cn c;
    public final Th d;
    public final U4 e;
    public final Mn f;
    public ArrayList g;
    public final C0293h5 h;
    public final C0369k4 i;
    public final Fg j;
    public final Object k;

    public N4(Context context, C0361jm c0361jm, C0267g5 c0267g5, G4 g4) {
        this(context, c0361jm, c0267g5, g4, new Th(g4.b), new C0293h5(), new P4());
    }

    public static void b(G4 g4) {
        Boolean bool = g4.b.n;
        Na.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gb
    public final void a(F4 f4) {
        Th th = this.d;
        th.f781a = th.f781a.mergeFrom(f4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gb
    public final void c() {
    }

    public final C0369k4 d() {
        return this.i;
    }

    public final F4 e() {
        return this.d.f781a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gb
    public final Context getContext() {
        return this.f679a;
    }

    public N4(Context context, C0361jm c0361jm, C0267g5 c0267g5, G4 g4, Th th, C0293h5 c0293h5, P4 p4) {
        this.g = new ArrayList();
        this.k = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f679a = applicationContext;
        this.b = c0267g5;
        this.d = th;
        this.h = c0293h5;
        this.e = P4.a(this);
        b(g4);
        C0182cn a2 = c0361jm.a(applicationContext, c0267g5, g4.f559a);
        this.c = a2;
        this.i = AbstractC0395l4.a(a2, Na.k().c());
        this.f = p4.a(this, a2);
        Fg u = Na.k().u();
        this.j = u;
        u.a();
        c0361jm.a(c0267g5, this);
    }

    public final synchronized void a(L4 l4) {
        this.h.f1009a.add(l4);
        T6.a(l4.c, this.i.a(AbstractC0311hn.a(this.c.e().l)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final synchronized void b(L4 l4) {
        this.h.f1009a.remove(l4);
    }

    public final void a(C0242f6 c0242f6, L4 l4) {
        U4 u4 = this.e;
        u4.getClass();
        u4.a(c0242f6, new T4(l4));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gb
    public final C0267g5 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0594sm
    public final void a(EnumC0413lm enumC0413lm, Hm hm) {
        synchronized (this.k) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0687wb c0687wb = (C0687wb) it.next();
                T6.a(c0687wb.f1265a, enumC0413lm, this.i.a(c0687wb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0594sm
    public final void a(Hm hm) {
        synchronized (this.k) {
            Iterator it = this.h.f1009a.iterator();
            while (it.hasNext()) {
                T6.a(((L4) it.next()).c, this.i.a(AbstractC0311hn.a(hm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0687wb c0687wb = (C0687wb) it2.next();
                if (Em.a(hm, c0687wb.b, c0687wb.c, new C0635ub())) {
                    T6.a(c0687wb.f1265a, this.i.a(c0687wb.c));
                } else {
                    arrayList.add(c0687wb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0687wb c0687wb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0687wb != null) {
            list = c0687wb.b;
            resultReceiver = c0687wb.f1265a;
            hashMap = c0687wb.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            T6.a(resultReceiver, this.i.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                T6.a(resultReceiver, this.i.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.k) {
            if (a2 && c0687wb != null) {
                this.g.add(c0687wb);
            }
        }
        this.f.c();
    }

    public final void a(final ResultReceiver resultReceiver) {
        Fg fg = this.j;
        Dg dg = new Dg() { // from class: io.appmetrica.analytics.impl.N4$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Dg
            public final void a(Lg lg) {
                Mg.a(resultReceiver, lg.a());
            }
        };
        fg.getClass();
        fg.f549a.a(new C0514pj(dg));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0325ib
    public final void a(G4 g4) {
        this.c.a(g4.f559a);
        a(g4.b);
    }
}

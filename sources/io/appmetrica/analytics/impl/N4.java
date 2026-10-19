package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class N4 implements InterfaceC0266gb, InterfaceC0587sm, InterfaceC0318ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f682a;
    public final C0260g5 b;
    public final C0175cn c;
    public final Th d;
    public final U4 e;
    public final Mn f;
    public ArrayList g;
    public final C0286h5 h;
    public final C0362k4 i;
    public final Fg j;
    public final Object k;

    public N4(Context context, C0354jm c0354jm, C0260g5 c0260g5, G4 g4) {
        this(context, c0354jm, c0260g5, g4, new Th(g4.b), new C0286h5(), new P4());
    }

    public static void b(G4 g4) {
        Boolean bool = g4.b.n;
        Na.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final void a(F4 f4) {
        Th th = this.d;
        th.f784a = th.f784a.mergeFrom(f4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final void c() {
    }

    public final C0362k4 d() {
        return this.i;
    }

    public final F4 e() {
        return this.d.f784a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final Context getContext() {
        return this.f682a;
    }

    public N4(Context context, C0354jm c0354jm, C0260g5 c0260g5, G4 g4, Th th, C0286h5 c0286h5, P4 p4) {
        this.g = new ArrayList();
        this.k = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f682a = applicationContext;
        this.b = c0260g5;
        this.d = th;
        this.h = c0286h5;
        this.e = P4.a(this);
        b(g4);
        C0175cn a2 = c0354jm.a(applicationContext, c0260g5, g4.f562a);
        this.c = a2;
        this.i = AbstractC0388l4.a(a2, Na.k().c());
        this.f = p4.a(this, a2);
        Fg u = Na.k().u();
        this.j = u;
        u.a();
        c0354jm.a(c0260g5, this);
    }

    public final synchronized void a(L4 l4) {
        this.h.f1012a.add(l4);
        T6.a(l4.c, this.i.a(AbstractC0304hn.a(this.c.e().l)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final synchronized void b(L4 l4) {
        this.h.f1012a.remove(l4);
    }

    public final void a(C0235f6 c0235f6, L4 l4) {
        U4 u4 = this.e;
        u4.getClass();
        u4.a(c0235f6, new T4(l4));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0266gb
    public final C0260g5 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sm
    public final void a(EnumC0406lm enumC0406lm, Hm hm) {
        synchronized (this.k) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0680wb c0680wb = (C0680wb) it.next();
                T6.a(c0680wb.f1268a, enumC0406lm, this.i.a(c0680wb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sm
    public final void a(Hm hm) {
        synchronized (this.k) {
            Iterator it = this.h.f1012a.iterator();
            while (it.hasNext()) {
                T6.a(((L4) it.next()).c, this.i.a(AbstractC0304hn.a(hm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0680wb c0680wb = (C0680wb) it2.next();
                if (Em.a(hm, c0680wb.b, c0680wb.c, new C0628ub())) {
                    T6.a(c0680wb.f1268a, this.i.a(c0680wb.c));
                } else {
                    arrayList.add(c0680wb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0680wb c0680wb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0680wb != null) {
            list = c0680wb.b;
            resultReceiver = c0680wb.f1268a;
            hashMap = c0680wb.c;
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
            if (a2 && c0680wb != null) {
                this.g.add(c0680wb);
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
        fg.f552a.a(new C0507pj(dg));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0318ib
    public final void a(G4 g4) {
        this.c.a(g4.f562a);
        a(g4.b);
    }
}

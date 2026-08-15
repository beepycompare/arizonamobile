package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class N4 implements InterfaceC0272gb, InterfaceC0593sm, InterfaceC0324ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f679a;
    public final C0266g5 b;
    public final C0181cn c;
    public final Th d;
    public final U4 e;
    public final Mn f;
    public ArrayList g;
    public final C0292h5 h;
    public final C0368k4 i;
    public final Fg j;
    public final Object k;

    public N4(Context context, C0360jm c0360jm, C0266g5 c0266g5, G4 g4) {
        this(context, c0360jm, c0266g5, g4, new Th(g4.b), new C0292h5(), new P4());
    }

    public static void b(G4 g4) {
        Boolean bool = g4.b.n;
        Na.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final void a(F4 f4) {
        Th th = this.d;
        th.f781a = th.f781a.mergeFrom(f4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final void c() {
    }

    public final C0368k4 d() {
        return this.i;
    }

    public final F4 e() {
        return this.d.f781a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final Context getContext() {
        return this.f679a;
    }

    public N4(Context context, C0360jm c0360jm, C0266g5 c0266g5, G4 g4, Th th, C0292h5 c0292h5, P4 p4) {
        this.g = new ArrayList();
        this.k = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f679a = applicationContext;
        this.b = c0266g5;
        this.d = th;
        this.h = c0292h5;
        this.e = P4.a(this);
        b(g4);
        C0181cn a2 = c0360jm.a(applicationContext, c0266g5, g4.f559a);
        this.c = a2;
        this.i = AbstractC0394l4.a(a2, Na.k().c());
        this.f = p4.a(this, a2);
        Fg u = Na.k().u();
        this.j = u;
        u.a();
        c0360jm.a(c0266g5, this);
    }

    public final synchronized void a(L4 l4) {
        this.h.f1009a.add(l4);
        T6.a(l4.c, this.i.a(AbstractC0310hn.a(this.c.e().l)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final synchronized void b(L4 l4) {
        this.h.f1009a.remove(l4);
    }

    public final void a(C0241f6 c0241f6, L4 l4) {
        U4 u4 = this.e;
        u4.getClass();
        u4.a(c0241f6, new T4(l4));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gb
    public final C0266g5 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0593sm
    public final void a(EnumC0412lm enumC0412lm, Hm hm) {
        synchronized (this.k) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0686wb c0686wb = (C0686wb) it.next();
                T6.a(c0686wb.f1265a, enumC0412lm, this.i.a(c0686wb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0593sm
    public final void a(Hm hm) {
        synchronized (this.k) {
            Iterator it = this.h.f1009a.iterator();
            while (it.hasNext()) {
                T6.a(((L4) it.next()).c, this.i.a(AbstractC0310hn.a(hm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0686wb c0686wb = (C0686wb) it2.next();
                if (Em.a(hm, c0686wb.b, c0686wb.c, new C0634ub())) {
                    T6.a(c0686wb.f1265a, this.i.a(c0686wb.c));
                } else {
                    arrayList.add(c0686wb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0686wb c0686wb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0686wb != null) {
            list = c0686wb.b;
            resultReceiver = c0686wb.f1265a;
            hashMap = c0686wb.c;
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
            if (a2 && c0686wb != null) {
                this.g.add(c0686wb);
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
        fg.f549a.a(new C0513pj(dg));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0324ib
    public final void a(G4 g4) {
        this.c.a(g4.f559a);
        a(g4.b);
    }
}

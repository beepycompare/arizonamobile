package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class S4 implements InterfaceC0146bb, Vl, InterfaceC0198db {

    /* renamed from: a  reason: collision with root package name */
    public final Context f646a;
    public final C0398l5 b;
    public final Gm c;
    public final Rh d;
    public final Z4 e;
    public final C0491on f;
    public ArrayList g;
    public final C0423m5 h;
    public final Dg i;
    public final C0497p4 j;
    public final Ig k;
    public final Object l;

    public S4(Context context, Ml ml, C0398l5 c0398l5, K4 k4, Dg dg) {
        this(context, ml, c0398l5, k4, new Rh(k4.b), dg, new C0423m5(), new U4(), new Ig());
    }

    public static void b(K4 k4) {
        Boolean bool = k4.b.n;
        Ka.F.b().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final void a(J4 j4) {
        Rh rh = this.d;
        rh.f637a = rh.f637a.mergeFrom(j4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final J4 d() {
        return this.d.f637a;
    }

    public final Dg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final Context getContext() {
        return this.f646a;
    }

    public S4(Context context, Ml ml, C0398l5 c0398l5, K4 k4, Rh rh, Dg dg, C0423m5 c0423m5, U4 u4, Ig ig) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f646a = applicationContext;
        this.b = c0398l5;
        this.d = rh;
        this.h = c0423m5;
        this.e = U4.a(this);
        b(k4);
        Gm a2 = ml.a(applicationContext, c0398l5, k4.f524a);
        this.c = a2;
        this.j = AbstractC0522q4.a(a2, Ka.j().b());
        this.f = u4.a(this, a2);
        this.i = dg;
        this.k = ig;
        ml.a(c0398l5, this);
    }

    public final synchronized void a(P4 p4) {
        this.h.f964a.add(p4);
        X6.a(p4.c, this.j.a(Lm.a(this.c.e().l)));
    }

    public final synchronized void b(P4 p4) {
        this.h.f964a.remove(p4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0146bb
    public final C0398l5 b() {
        return this.b;
    }

    public final void a(C0399l6 c0399l6, P4 p4) {
        Z4 z4 = this.e;
        z4.getClass();
        z4.a(c0399l6, new Y4(p4));
    }

    @Override // io.appmetrica.analytics.impl.Vl
    public final void a(Ol ol, C0389km c0389km) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0628ub c0628ub = (C0628ub) it.next();
                X6.a(c0628ub.f1086a, ol, this.j.a(c0628ub.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Vl
    public final void a(C0389km c0389km) {
        synchronized (this.l) {
            Iterator it = this.h.f964a.iterator();
            while (it.hasNext()) {
                X6.a(((P4) it.next()).c, this.j.a(Lm.a(c0389km.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0628ub c0628ub = (C0628ub) it2.next();
                if (AbstractC0312hm.a(c0389km, c0628ub.b, c0628ub.c, new C0578sb())) {
                    X6.a(c0628ub.f1086a, this.j.a(c0628ub.c));
                } else {
                    arrayList.add(c0628ub);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0628ub c0628ub) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0628ub != null) {
            list = c0628ub.b;
            resultReceiver = c0628ub.f1086a;
            hashMap = c0628ub.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            X6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                X6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && c0628ub != null) {
                this.g.add(c0628ub);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new R4(resultReceiver));
    }

    public final C0497p4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0198db
    public final void a(K4 k4) {
        this.c.a(k4.f524a);
        a(k4.b);
    }
}

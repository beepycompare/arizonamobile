package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.x4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0692x4 implements Ea, Ql, Ga {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1299a;
    public final Q4 b;
    public final Am c;
    public final C0755zh d;
    public final E4 e;
    public final C0412ln f;
    public ArrayList g;
    public final R4 h;
    public final C0405lg i;
    public final T3 j;
    public final C0530qg k;
    public final Object l;

    public C0692x4(Context context, Hl hl, Q4 q4, C0493p4 c0493p4, C0405lg c0405lg) {
        this(context, hl, q4, c0493p4, new C0755zh(c0493p4.b), c0405lg, new R4(), new C0742z4(), new C0530qg());
    }

    public static void b(C0493p4 c0493p4) {
        Boolean bool = c0493p4.b.n;
        C0449na.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final void a(C0468o4 c0468o4) {
        C0755zh c0755zh = this.d;
        c0755zh.f1336a = c0755zh.f1336a.mergeFrom(c0468o4);
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final C0468o4 d() {
        return this.d.f1336a;
    }

    public final C0405lg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final Context getContext() {
        return this.f1299a;
    }

    public C0692x4(Context context, Hl hl, Q4 q4, C0493p4 c0493p4, C0755zh c0755zh, C0405lg c0405lg, R4 r4, C0742z4 c0742z4, C0530qg c0530qg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f1299a = applicationContext;
        this.b = q4;
        this.d = c0755zh;
        this.h = r4;
        this.e = C0742z4.a(this);
        b(c0493p4);
        Am a2 = hl.a(applicationContext, q4, c0493p4.f1168a);
        this.c = a2;
        this.j = U3.a(a2, C0449na.k().c());
        this.f = c0742z4.a(this, a2);
        this.i = c0405lg;
        this.k = c0530qg;
        hl.a(q4, this);
    }

    public final synchronized void a(C0617u4 c0617u4) {
        this.h.f761a.add(c0617u4);
        B6.a(c0617u4.c, this.j.a(Fm.a(this.c.e().l)));
    }

    public final synchronized void b(C0617u4 c0617u4) {
        this.h.f761a.remove(c0617u4);
    }

    @Override // io.appmetrica.analytics.impl.Ea
    public final Q4 b() {
        return this.b;
    }

    public final void a(P5 p5, C0617u4 c0617u4) {
        E4 e4 = this.e;
        e4.getClass();
        e4.a(p5, new D4(c0617u4));
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0257fm c0257fm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Xa xa = (Xa) it.next();
                B6.a(xa.f852a, jl, this.j.a(xa.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(C0257fm c0257fm) {
        synchronized (this.l) {
            Iterator it = this.h.f761a.iterator();
            while (it.hasNext()) {
                B6.a(((C0617u4) it.next()).c, this.j.a(Fm.a(c0257fm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                Xa xa = (Xa) it2.next();
                if (AbstractC0180cm.a(c0257fm, xa.b, xa.c, new Va())) {
                    B6.a(xa.f852a, this.j.a(xa.c));
                } else {
                    arrayList.add(xa);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Xa xa) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (xa != null) {
            list = xa.b;
            resultReceiver = xa.f852a;
            hashMap = xa.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            B6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                B6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && xa != null) {
                this.g.add(xa);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new C0667w4(resultReceiver));
    }

    public final T3 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Ga
    public final void a(C0493p4 c0493p4) {
        this.c.a(c0493p4.f1168a);
        a(c0493p4.b);
    }
}

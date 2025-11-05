package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class E4 implements La, Ul, Na {

    /* renamed from: a  reason: collision with root package name */
    public final Context f451a;
    public final X4 b;
    public final Em c;
    public final Eh d;
    public final L4 e;
    public final C0484on f;
    public ArrayList g;
    public final Y4 h;
    public final C0527qg i;
    public final C0132b4 j;
    public final C0651vg k;
    public final Object l;

    public E4(Context context, Ll ll, X4 x4, C0664w4 c0664w4, C0527qg c0527qg) {
        this(context, ll, x4, c0664w4, new Eh(c0664w4.b), c0527qg, new Y4(), new G4(), new C0651vg());
    }

    public static void b(C0664w4 c0664w4) {
        Boolean bool = c0664w4.b.n;
        C0620ua.H.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.La
    public final void a(C0639v4 c0639v4) {
        Eh eh = this.d;
        eh.f461a = eh.f461a.mergeFrom(c0639v4);
    }

    @Override // io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final C0639v4 d() {
        return this.d.f461a;
    }

    public final C0527qg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.La
    public final Context getContext() {
        return this.f451a;
    }

    public E4(Context context, Ll ll, X4 x4, C0664w4 c0664w4, Eh eh, C0527qg c0527qg, Y4 y4, G4 g4, C0651vg c0651vg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f451a = applicationContext;
        this.b = x4;
        this.d = eh;
        this.h = y4;
        this.e = G4.a(this);
        b(c0664w4);
        Em a2 = ll.a(applicationContext, x4, c0664w4.f1178a);
        this.c = a2;
        this.j = AbstractC0158c4.a(a2, C0620ua.k().c());
        this.f = g4.a(this, a2);
        this.i = c0527qg;
        this.k = c0651vg;
        ll.a(x4, this);
    }

    public final synchronized void a(B4 b4) {
        this.h.f765a.add(b4);
        I6.a(b4.c, this.j.a(Jm.a(this.c.e().l)));
    }

    public final synchronized void b(B4 b4) {
        this.h.f765a.remove(b4);
    }

    @Override // io.appmetrica.analytics.impl.La
    public final X4 b() {
        return this.b;
    }

    public final void a(W5 w5, B4 b4) {
        L4 l4 = this.e;
        l4.getClass();
        l4.a(w5, new K4(b4));
    }

    @Override // io.appmetrica.analytics.impl.Ul
    public final void a(Nl nl, C0356jm c0356jm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0216eb c0216eb = (C0216eb) it.next();
                I6.a(c0216eb.f860a, nl, this.j.a(c0216eb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ul
    public final void a(C0356jm c0356jm) {
        synchronized (this.l) {
            Iterator it = this.h.f765a.iterator();
            while (it.hasNext()) {
                I6.a(((B4) it.next()).c, this.j.a(Jm.a(c0356jm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0216eb c0216eb = (C0216eb) it2.next();
                if (AbstractC0279gm.a(c0356jm, c0216eb.b, c0216eb.c, new C0165cb())) {
                    I6.a(c0216eb.f860a, this.j.a(c0216eb.c));
                } else {
                    arrayList.add(c0216eb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0216eb c0216eb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0216eb != null) {
            list = c0216eb.b;
            resultReceiver = c0216eb.f860a;
            hashMap = c0216eb.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            I6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                I6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && c0216eb != null) {
                this.g.add(c0216eb);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new D4(resultReceiver));
    }

    public final C0132b4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Na
    public final void a(C0664w4 c0664w4) {
        this.c.a(c0664w4.f1178a);
        a(c0664w4.b);
    }
}

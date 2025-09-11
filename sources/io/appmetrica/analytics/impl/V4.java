package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class V4 implements InterfaceC0223eb, Zl, InterfaceC0275gb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f709a;
    public final C0476o5 b;
    public final Km c;
    public final Vh d;
    public final C0166c5 e;
    public final C0594sn f;
    public ArrayList g;
    public final C0502p5 h;
    public final Hg i;
    public final C0575s4 j;
    public final Mg k;
    public final Object l;

    public V4(Context context, Ql ql, C0476o5 c0476o5, N4 n4, Hg hg) {
        this(context, ql, c0476o5, n4, new Vh(n4.b), hg, new C0502p5(), new X4(), new Mg());
    }

    public static void b(N4 n4) {
        Boolean bool = n4.b.n;
        Na.F.b().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0223eb
    public final void a(M4 m4) {
        Vh vh = this.d;
        vh.f714a = vh.f714a.mergeFrom(m4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0223eb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final M4 d() {
        return this.d.f714a;
    }

    public final Hg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0223eb
    public final Context getContext() {
        return this.f709a;
    }

    public V4(Context context, Ql ql, C0476o5 c0476o5, N4 n4, Vh vh, Hg hg, C0502p5 c0502p5, X4 x4, Mg mg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f709a = applicationContext;
        this.b = c0476o5;
        this.d = vh;
        this.h = c0502p5;
        this.e = X4.a(this);
        b(n4);
        Km a2 = ql.a(applicationContext, c0476o5, n4.f588a);
        this.c = a2;
        this.j = AbstractC0600t4.a(a2, Na.j().b());
        this.f = x4.a(this, a2);
        this.i = hg;
        this.k = mg;
        ql.a(c0476o5, this);
    }

    public final synchronized void a(S4 s4) {
        this.h.f1031a.add(s4);
        ResultReceiverC0116a7.a(s4.c, this.j.a(Pm.a(this.c.e().l)));
    }

    public final synchronized void b(S4 s4) {
        this.h.f1031a.remove(s4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0223eb
    public final C0476o5 b() {
        return this.b;
    }

    public final void a(C0477o6 c0477o6, S4 s4) {
        C0166c5 c0166c5 = this.e;
        c0166c5.getClass();
        c0166c5.a(c0477o6, new C0140b5(s4));
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(Sl sl, C0493om c0493om) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                C0707xb c0707xb = (C0707xb) it.next();
                ResultReceiverC0116a7.a(c0707xb.f1153a, sl, this.j.a(c0707xb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(C0493om c0493om) {
        synchronized (this.l) {
            Iterator it = this.h.f1031a.iterator();
            while (it.hasNext()) {
                ResultReceiverC0116a7.a(((S4) it.next()).c, this.j.a(Pm.a(c0493om.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                C0707xb c0707xb = (C0707xb) it2.next();
                if (AbstractC0415lm.a(c0493om, c0707xb.b, c0707xb.c, new C0657vb())) {
                    ResultReceiverC0116a7.a(c0707xb.f1153a, this.j.a(c0707xb.c));
                } else {
                    arrayList.add(c0707xb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0707xb c0707xb) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (c0707xb != null) {
            list = c0707xb.b;
            resultReceiver = c0707xb.f1153a;
            hashMap = c0707xb.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            ResultReceiverC0116a7.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                ResultReceiverC0116a7.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && c0707xb != null) {
                this.g.add(c0707xb);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new U4(resultReceiver));
    }

    public final C0575s4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0275gb
    public final void a(N4 n4) {
        this.c.a(n4.f588a);
        a(n4.b);
    }
}

package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.y4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0714y4 implements Fa, Rl, Ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1211a;
    public final R4 b;
    public final Bm c;
    public final Ah d;
    public final F4 e;
    public final C0434mn f;
    public ArrayList g;
    public final S4 h;
    public final C0427mg i;
    public final U3 j;
    public final C0551rg k;
    public final Object l;

    public C0714y4(Context context, Il il, R4 r4, C0515q4 c0515q4, C0427mg c0427mg) {
        this(context, il, r4, c0515q4, new Ah(c0515q4.b), c0427mg, new S4(), new A4(), new C0551rg());
    }

    public static void b(C0515q4 c0515q4) {
        Boolean bool = c0515q4.b.n;
        C0471oa.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a(C0490p4 c0490p4) {
        Ah ah = this.d;
        ah.f398a = ah.f398a.mergeFrom(c0490p4);
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final C0490p4 d() {
        return this.d.f398a;
    }

    public final C0427mg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final Context getContext() {
        return this.f1211a;
    }

    public C0714y4(Context context, Il il, R4 r4, C0515q4 c0515q4, Ah ah, C0427mg c0427mg, S4 s4, A4 a4, C0551rg c0551rg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f1211a = applicationContext;
        this.b = r4;
        this.d = ah;
        this.h = s4;
        this.e = A4.a(this);
        b(c0515q4);
        Bm a2 = il.a(applicationContext, r4, c0515q4.f1080a);
        this.c = a2;
        this.j = V3.a(a2, C0471oa.k().c());
        this.f = a4.a(this, a2);
        this.i = c0427mg;
        this.k = c0551rg;
        il.a(r4, this);
    }

    public final synchronized void a(C0639v4 c0639v4) {
        this.h.f672a.add(c0639v4);
        C6.a(c0639v4.c, this.j.a(Gm.a(this.c.e().l)));
    }

    public final synchronized void b(C0639v4 c0639v4) {
        this.h.f672a.remove(c0639v4);
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final R4 b() {
        return this.b;
    }

    public final void a(Q5 q5, C0639v4 c0639v4) {
        F4 f4 = this.e;
        f4.getClass();
        f4.a(q5, new E4(c0639v4));
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(Kl kl, C0279gm c0279gm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Ya ya = (Ya) it.next();
                C6.a(ya.f763a, kl, this.j.a(ya.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(C0279gm c0279gm) {
        synchronized (this.l) {
            Iterator it = this.h.f672a.iterator();
            while (it.hasNext()) {
                C6.a(((C0639v4) it.next()).c, this.j.a(Gm.a(c0279gm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                Ya ya = (Ya) it2.next();
                if (AbstractC0202dm.a(c0279gm, ya.b, ya.c, new Wa())) {
                    C6.a(ya.f763a, this.j.a(ya.c));
                } else {
                    arrayList.add(ya);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Ya ya) {
        ResultReceiver resultReceiver;
        HashMap hashMap;
        List list;
        HashMap hashMap2 = new HashMap();
        if (ya != null) {
            list = ya.b;
            resultReceiver = ya.f763a;
            hashMap = ya.c;
        } else {
            resultReceiver = null;
            hashMap = hashMap2;
            list = null;
        }
        boolean a2 = this.c.a(list, hashMap);
        if (!a2) {
            C6.a(resultReceiver, this.j.a(hashMap));
        }
        if (!this.c.g()) {
            if (a2) {
                C6.a(resultReceiver, this.j.a(hashMap));
                return;
            }
            return;
        }
        synchronized (this.l) {
            if (a2 && ya != null) {
                this.g.add(ya);
            }
        }
        this.f.c();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new C0689x4(resultReceiver));
    }

    public final U3 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final void a(C0515q4 c0515q4) {
        this.c.a(c0515q4.f1080a);
        a(c0515q4.b);
    }
}

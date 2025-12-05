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
public final class C0713y4 implements Fa, Rl, Ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1294a;
    public final R4 b;
    public final Bm c;
    public final Ah d;
    public final F4 e;
    public final C0433mn f;
    public ArrayList g;
    public final S4 h;
    public final C0426mg i;
    public final U3 j;
    public final C0550rg k;
    public final Object l;

    public C0713y4(Context context, Il il, R4 r4, C0514q4 c0514q4, C0426mg c0426mg) {
        this(context, il, r4, c0514q4, new Ah(c0514q4.b), c0426mg, new S4(), new A4(), new C0550rg());
    }

    public static void b(C0514q4 c0514q4) {
        Boolean bool = c0514q4.b.n;
        C0470oa.I.c().b(!Boolean.FALSE.equals(bool));
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a(C0489p4 c0489p4) {
        Ah ah = this.d;
        ah.f481a = ah.f481a.mergeFrom(c0489p4);
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final C0489p4 d() {
        return this.d.f481a;
    }

    public final C0426mg e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final Context getContext() {
        return this.f1294a;
    }

    public C0713y4(Context context, Il il, R4 r4, C0514q4 c0514q4, Ah ah, C0426mg c0426mg, S4 s4, A4 a4, C0550rg c0550rg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f1294a = applicationContext;
        this.b = r4;
        this.d = ah;
        this.h = s4;
        this.e = A4.a(this);
        b(c0514q4);
        Bm a2 = il.a(applicationContext, r4, c0514q4.f1163a);
        this.c = a2;
        this.j = V3.a(a2, C0470oa.k().c());
        this.f = a4.a(this, a2);
        this.i = c0426mg;
        this.k = c0550rg;
        il.a(r4, this);
    }

    public final synchronized void a(C0638v4 c0638v4) {
        this.h.f755a.add(c0638v4);
        C6.a(c0638v4.c, this.j.a(Gm.a(this.c.e().l)));
    }

    public final synchronized void b(C0638v4 c0638v4) {
        this.h.f755a.remove(c0638v4);
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final R4 b() {
        return this.b;
    }

    public final void a(Q5 q5, C0638v4 c0638v4) {
        F4 f4 = this.e;
        f4.getClass();
        f4.a(q5, new E4(c0638v4));
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(Kl kl, C0278gm c0278gm) {
        synchronized (this.l) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                Ya ya = (Ya) it.next();
                C6.a(ya.f846a, kl, this.j.a(ya.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(C0278gm c0278gm) {
        synchronized (this.l) {
            Iterator it = this.h.f755a.iterator();
            while (it.hasNext()) {
                C6.a(((C0638v4) it.next()).c, this.j.a(Gm.a(c0278gm.l)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                Ya ya = (Ya) it2.next();
                if (AbstractC0201dm.a(c0278gm, ya.b, ya.c, new Wa())) {
                    C6.a(ya.f846a, this.j.a(ya.c));
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
            resultReceiver = ya.f846a;
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
        this.k.a(new C0688x4(resultReceiver));
    }

    public final U3 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final void a(C0514q4 c0514q4) {
        this.c.a(c0514q4.f1163a);
        a(c0514q4.b);
    }
}

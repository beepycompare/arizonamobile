package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public class A5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0726y5 f340a;
    public final C0751z5 b;
    protected final Context c;
    public final C0476o5 d;
    public final M4 e;
    public final AbstractC0601t5 f;
    protected final C0493om g;
    public final Dh h;
    public final C0247f9 i;
    public final ICommonExecutor j;
    public final C0250fc k;
    public final S9 l;
    public final int m;

    public A5(Context context, C0476o5 c0476o5, M4 m4, AbstractC0601t5 abstractC0601t5, C0493om c0493om, Dh dh, ICommonExecutor iCommonExecutor, int i, C0250fc c0250fc, S9 s9) {
        this(context, c0476o5, m4, abstractC0601t5, c0493om, dh, iCommonExecutor, new C0247f9(), i, new C0726y5(m4.f566a), new C0751z5(context, c0476o5), c0250fc, s9);
    }

    public static C0705x9 c(C0651v5 c0651v5) {
        return new C0705x9(c0651v5);
    }

    public final C0376k9 a() {
        Context context = this.c;
        C0476o5 c0476o5 = this.d;
        return new C0376k9(new C0506p9(context, c0476o5), this.m);
    }

    public final C0374k7 b(C0651v5 c0651v5) {
        return new C0374k7(c0651v5, C0728y7.a(this.c).c(this.d), new C0271g7(c0651v5.c()), new F7());
    }

    public final C0726y5 d() {
        return this.f340a;
    }

    public final C0751z5 e() {
        return this.b;
    }

    public final Do f() {
        Do r4;
        Ho ba;
        Go B = Na.F.B();
        C0476o5 c0476o5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0476o5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0537qf c0537qf = new C0537qf(C0728y7.a(B.f461a).b(c0476o5));
                if (c0476o5.d()) {
                    String str = "appmetrica_vital_" + c0476o5.b + ".dat";
                    ba = new E5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new Ba(B.f461a, str)), TuplesKt.to("appmetrica_vital_main.dat", new Ba(B.f461a, "appmetrica_vital_main.dat"))}));
                } else {
                    ba = new Ba(B.f461a, "appmetrica_vital_" + c0476o5.b + ".dat");
                }
                obj = new Do(c0537qf, ba, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            r4 = (Do) obj;
        }
        return r4;
    }

    public A5(Context context, C0476o5 c0476o5, M4 m4, AbstractC0601t5 abstractC0601t5, C0493om c0493om, Dh dh, ICommonExecutor iCommonExecutor, C0247f9 c0247f9, int i, C0726y5 c0726y5, C0751z5 c0751z5, C0250fc c0250fc, S9 s9) {
        this.c = context;
        this.d = c0476o5;
        this.e = m4;
        this.f = abstractC0601t5;
        this.g = c0493om;
        this.h = dh;
        this.j = iCommonExecutor;
        this.i = c0247f9;
        this.m = i;
        this.f340a = c0726y5;
        this.b = c0751z5;
        this.k = c0250fc;
        this.l = s9;
    }

    public final Tk c() {
        return new Tk(this.c, this.d);
    }

    public final Ri d(C0651v5 c0651v5) {
        Ri ri = new Ri(c0651v5, this.f.a(), this.j);
        C0250fc c0250fc = this.k;
        synchronized (c0250fc) {
            c0250fc.c.add(ri);
        }
        return ri;
    }

    public final C0436mh a(C0651v5 c0651v5) {
        return new C0436mh(new Eh(c0651v5, this.h, new C0139b4()), this.g, new Bh(this.e));
    }

    public static C0156bl a(C0651v5 c0651v5, Do r8, C0626u5 c0626u5) {
        C0130al c0130al = new C0130al(r8);
        return new C0156bl(c0651v5, c0130al, c0626u5, new Ha(c0651v5, c0130al, new C0233el(c0651v5.h(), "foreground"), AbstractC0647v1.a(), new SystemTimeProvider()), new O2(c0651v5, c0130al, new C0233el(c0651v5.h(), O2.g), AbstractC0647v1.a(), new SystemTimeProvider()));
    }

    public static C0527q5 b() {
        return new C0527q5();
    }

    public final L3 b(C0537qf c0537qf) {
        Context context = this.c;
        return new L3(context, c0537qf, context.getPackageName(), new SafePackageManager());
    }

    public final K9 a(C0537qf c0537qf, Do r14, C0156bl c0156bl, C0374k7 c0374k7, C0316i0 c0316i0, Tk tk, Ri ri) {
        return new K9(c0537qf, r14, c0156bl, c0374k7, c0316i0, this.i, tk, this.m, new C0701x5(ri), new C0555r9(r14, new C0580s9(r14)), new SystemTimeProvider());
    }

    public static Pi a(C0651v5 c0651v5, C0705x9 c0705x9) {
        return new Pi(c0705x9, c0651v5);
    }

    public Q9 a(V9 v9, C0374k7 c0374k7, C0436mh c0436mh, M4 m4, C0476o5 c0476o5, C0537qf c0537qf) {
        return this.l.a(v9, c0374k7, c0436mh, m4, c0476o5, c0537qf).a();
    }

    public final C0673w2 a(C0537qf c0537qf) {
        return new C0673w2(this.d, c0537qf);
    }
}

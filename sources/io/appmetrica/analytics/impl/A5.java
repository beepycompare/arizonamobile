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
    public final C0727y5 f345a;
    public final C0752z5 b;
    protected final Context c;
    public final C0477o5 d;
    public final M4 e;
    public final AbstractC0602t5 f;
    protected final C0494om g;
    public final Dh h;
    public final C0248f9 i;
    public final ICommonExecutor j;
    public final C0251fc k;
    public final S9 l;
    public final int m;

    public A5(Context context, C0477o5 c0477o5, M4 m4, AbstractC0602t5 abstractC0602t5, C0494om c0494om, Dh dh, ICommonExecutor iCommonExecutor, int i, C0251fc c0251fc, S9 s9) {
        this(context, c0477o5, m4, abstractC0602t5, c0494om, dh, iCommonExecutor, new C0248f9(), i, new C0727y5(m4.f571a), new C0752z5(context, c0477o5), c0251fc, s9);
    }

    public static C0706x9 c(C0652v5 c0652v5) {
        return new C0706x9(c0652v5);
    }

    public final C0377k9 a() {
        Context context = this.c;
        C0477o5 c0477o5 = this.d;
        return new C0377k9(new C0507p9(context, c0477o5), this.m);
    }

    public final C0375k7 b(C0652v5 c0652v5) {
        return new C0375k7(c0652v5, C0729y7.a(this.c).c(this.d), new C0272g7(c0652v5.c()), new F7());
    }

    public final C0727y5 d() {
        return this.f345a;
    }

    public final C0752z5 e() {
        return this.b;
    }

    public final Do f() {
        Do r4;
        Ho ba;
        Go B = Na.F.B();
        C0477o5 c0477o5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0477o5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0538qf c0538qf = new C0538qf(C0729y7.a(B.f466a).b(c0477o5));
                if (c0477o5.d()) {
                    String str = "appmetrica_vital_" + c0477o5.b + ".dat";
                    ba = new E5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new Ba(B.f466a, str)), TuplesKt.to("appmetrica_vital_main.dat", new Ba(B.f466a, "appmetrica_vital_main.dat"))}));
                } else {
                    ba = new Ba(B.f466a, "appmetrica_vital_" + c0477o5.b + ".dat");
                }
                obj = new Do(c0538qf, ba, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            r4 = (Do) obj;
        }
        return r4;
    }

    public A5(Context context, C0477o5 c0477o5, M4 m4, AbstractC0602t5 abstractC0602t5, C0494om c0494om, Dh dh, ICommonExecutor iCommonExecutor, C0248f9 c0248f9, int i, C0727y5 c0727y5, C0752z5 c0752z5, C0251fc c0251fc, S9 s9) {
        this.c = context;
        this.d = c0477o5;
        this.e = m4;
        this.f = abstractC0602t5;
        this.g = c0494om;
        this.h = dh;
        this.j = iCommonExecutor;
        this.i = c0248f9;
        this.m = i;
        this.f345a = c0727y5;
        this.b = c0752z5;
        this.k = c0251fc;
        this.l = s9;
    }

    public final Tk c() {
        return new Tk(this.c, this.d);
    }

    public final Ri d(C0652v5 c0652v5) {
        Ri ri = new Ri(c0652v5, this.f.a(), this.j);
        C0251fc c0251fc = this.k;
        synchronized (c0251fc) {
            c0251fc.c.add(ri);
        }
        return ri;
    }

    public final C0437mh a(C0652v5 c0652v5) {
        return new C0437mh(new Eh(c0652v5, this.h, new C0140b4()), this.g, new Bh(this.e));
    }

    public static C0157bl a(C0652v5 c0652v5, Do r8, C0627u5 c0627u5) {
        C0131al c0131al = new C0131al(r8);
        return new C0157bl(c0652v5, c0131al, c0627u5, new Ha(c0652v5, c0131al, new C0234el(c0652v5.h(), "foreground"), AbstractC0648v1.a(), new SystemTimeProvider()), new O2(c0652v5, c0131al, new C0234el(c0652v5.h(), O2.g), AbstractC0648v1.a(), new SystemTimeProvider()));
    }

    public static C0528q5 b() {
        return new C0528q5();
    }

    public final L3 b(C0538qf c0538qf) {
        Context context = this.c;
        return new L3(context, c0538qf, context.getPackageName(), new SafePackageManager());
    }

    public final K9 a(C0538qf c0538qf, Do r14, C0157bl c0157bl, C0375k7 c0375k7, C0317i0 c0317i0, Tk tk, Ri ri) {
        return new K9(c0538qf, r14, c0157bl, c0375k7, c0317i0, this.i, tk, this.m, new C0702x5(ri), new C0556r9(r14, new C0581s9(r14)), new SystemTimeProvider());
    }

    public static Pi a(C0652v5 c0652v5, C0706x9 c0706x9) {
        return new Pi(c0706x9, c0652v5);
    }

    public Q9 a(V9 v9, C0375k7 c0375k7, C0437mh c0437mh, M4 m4, C0477o5 c0477o5, C0538qf c0538qf) {
        return this.l.a(v9, c0375k7, c0437mh, m4, c0477o5, c0538qf).a();
    }

    public final C0674w2 a(C0538qf c0538qf) {
        return new C0674w2(this.d, c0538qf);
    }
}

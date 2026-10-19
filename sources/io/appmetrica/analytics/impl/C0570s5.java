package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.s5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0570s5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0519q5 f1198a;
    public final C0544r5 b;
    protected final Context c;
    public final C0260g5 d;
    public final F4 e;
    public final AbstractC0389l5 f;
    protected final Hm g;
    public final Bh h;
    public final C0135b9 i;
    public final ICommonExecutor j;
    public final C0293hc k;
    public final M9 l;
    public final int m;

    public C0570s5(Context context, C0260g5 c0260g5, F4 f4, AbstractC0389l5 abstractC0389l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, int i, C0293hc c0293hc, M9 m9) {
        this(context, c0260g5, f4, abstractC0389l5, hm, bh, iCommonExecutor, new C0135b9(), i, new C0519q5(f4.f543a), new C0544r5(context, c0260g5), c0293hc, m9);
    }

    public static C0548r9 c(C0441n5 c0441n5) {
        return new C0548r9(c0441n5);
    }

    public final C0264g9 a() {
        Context context = this.c;
        C0260g5 c0260g5 = this.d;
        return new C0264g9(new C0393l9(context, c0260g5), this.m);
    }

    public final C0159c7 b(C0441n5 c0441n5) {
        return new C0159c7(c0441n5, Na.I.B().c(this.c, this.d), new Z6(c0441n5.b()), new C0676w7());
    }

    public final C0519q5 d() {
        return this.f1198a;
    }

    public final C0544r5 e() {
        return this.b;
    }

    public final ap f() {
        ap apVar;
        ep c0731ya;
        dp D = Na.I.D();
        C0260g5 c0260g5 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(c0260g5);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0684wf c0684wf = new C0684wf(Na.I.B().b(D.f956a, c0260g5));
                IHandlerExecutor e = Na.I.d.e();
                if (c0260g5.d()) {
                    String str = "appmetrica_vital_" + c0260g5.b + ".dat";
                    c0731ya = new C0674w5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0731ya(D.f956a, str, e, 0L, 8, null)), TuplesKt.to("appmetrica_vital_main.dat", new C0731ya(D.f956a, "appmetrica_vital_main.dat", e, 0L, 8, null))}));
                } else {
                    c0731ya = new C0731ya(D.f956a, "appmetrica_vital_" + c0260g5.b + ".dat", e, 0L, 8, null);
                }
                obj = new ap(c0684wf, c0731ya, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            apVar = (ap) obj;
        }
        return apVar;
    }

    public C0570s5(Context context, C0260g5 c0260g5, F4 f4, AbstractC0389l5 abstractC0389l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, C0135b9 c0135b9, int i, C0519q5 c0519q5, C0544r5 c0544r5, C0293hc c0293hc, M9 m9) {
        this.c = context;
        this.d = c0260g5;
        this.e = f4;
        this.f = abstractC0389l5;
        this.g = hm;
        this.h = bh;
        this.j = iCommonExecutor;
        this.i = c0135b9;
        this.m = i;
        this.f1198a = c0519q5;
        this.b = c0544r5;
        this.k = c0293hc;
        this.l = m9;
    }

    public final C0431ml c() {
        return new C0431ml(this.c, this.d);
    }

    public final Pi d(C0441n5 c0441n5) {
        Pi pi = new Pi(c0441n5, this.f.a(), this.j);
        C0293hc c0293hc = this.k;
        synchronized (c0293hc) {
            c0293hc.c.add(pi);
        }
        return pi;
    }

    public final C0272gh a(C0441n5 c0441n5) {
        return new C0272gh(new Ch(c0441n5, this.h, new T3()), this.g, new C0764zh(this.e));
    }

    public static C0664vl a(C0441n5 c0441n5, ap apVar, C0415m5 c0415m5) {
        C0638ul c0638ul = new C0638ul(apVar);
        return new C0664vl(c0441n5, c0415m5, new Ea(c0441n5, c0638ul, new C0768zl(c0441n5.h(), "foreground"), AbstractC0748z1.a(), new SystemTimeProvider()), new M2(c0441n5, c0638ul, new C0768zl(c0441n5.h(), M2.g), AbstractC0748z1.a(), new SystemTimeProvider()), new C0612tl(c0441n5, c0638ul));
    }

    public static C0312i5 b() {
        return new C0312i5();
    }

    public final D3 b(C0684wf c0684wf) {
        Context context = this.c;
        return new D3(context, c0684wf, context.getPackageName(), new SafePackageManager());
    }

    public final E9 a(C0684wf c0684wf, ap apVar, C0664vl c0664vl, C0159c7 c0159c7, C0384l0 c0384l0, C0431ml c0431ml, Pi pi) {
        return new E9(c0684wf, apVar, c0664vl, c0159c7, c0384l0, this.i, c0431ml, this.m, new C0493p5(pi), new SystemTimeProvider());
    }

    public static Ni a(C0441n5 c0441n5, C0548r9 c0548r9) {
        return new Ni(c0548r9, c0441n5);
    }

    public K9 a(P9 p9, C0159c7 c0159c7, C0272gh c0272gh, F4 f4, C0260g5 c0260g5, C0684wf c0684wf) {
        return this.l.a(p9, c0159c7, c0272gh, f4, c0260g5, c0684wf).a();
    }

    public final C2 a(C0684wf c0684wf) {
        return new C2(this.d, c0684wf);
    }
}

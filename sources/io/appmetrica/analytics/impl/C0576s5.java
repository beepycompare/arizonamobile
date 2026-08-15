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
public class C0576s5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0525q5 f1195a;
    public final C0550r5 b;
    protected final Context c;
    public final C0266g5 d;
    public final F4 e;
    public final AbstractC0395l5 f;
    protected final Hm g;
    public final Bh h;
    public final C0141b9 i;
    public final ICommonExecutor j;
    public final C0299hc k;
    public final M9 l;
    public final int m;

    public C0576s5(Context context, C0266g5 c0266g5, F4 f4, AbstractC0395l5 abstractC0395l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, int i, C0299hc c0299hc, M9 m9) {
        this(context, c0266g5, f4, abstractC0395l5, hm, bh, iCommonExecutor, new C0141b9(), i, new C0525q5(f4.f540a), new C0550r5(context, c0266g5), c0299hc, m9);
    }

    public static C0554r9 c(C0447n5 c0447n5) {
        return new C0554r9(c0447n5);
    }

    public final C0270g9 a() {
        Context context = this.c;
        C0266g5 c0266g5 = this.d;
        return new C0270g9(new C0399l9(context, c0266g5), this.m);
    }

    public final C0165c7 b(C0447n5 c0447n5) {
        return new C0165c7(c0447n5, Na.I.B().c(this.c, this.d), new Z6(c0447n5.b()), new C0682w7());
    }

    public final C0525q5 d() {
        return this.f1195a;
    }

    public final C0550r5 e() {
        return this.b;
    }

    public final ap f() {
        ap apVar;
        ep c0737ya;
        dp D = Na.I.D();
        C0266g5 c0266g5 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(c0266g5);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0690wf c0690wf = new C0690wf(Na.I.B().b(D.f953a, c0266g5));
                IHandlerExecutor e = Na.I.d.e();
                if (c0266g5.d()) {
                    String str = "appmetrica_vital_" + c0266g5.b + ".dat";
                    c0737ya = new C0680w5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0737ya(D.f953a, str, e, 0L, 8, null)), TuplesKt.to("appmetrica_vital_main.dat", new C0737ya(D.f953a, "appmetrica_vital_main.dat", e, 0L, 8, null))}));
                } else {
                    c0737ya = new C0737ya(D.f953a, "appmetrica_vital_" + c0266g5.b + ".dat", e, 0L, 8, null);
                }
                obj = new ap(c0690wf, c0737ya, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            apVar = (ap) obj;
        }
        return apVar;
    }

    public C0576s5(Context context, C0266g5 c0266g5, F4 f4, AbstractC0395l5 abstractC0395l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, C0141b9 c0141b9, int i, C0525q5 c0525q5, C0550r5 c0550r5, C0299hc c0299hc, M9 m9) {
        this.c = context;
        this.d = c0266g5;
        this.e = f4;
        this.f = abstractC0395l5;
        this.g = hm;
        this.h = bh;
        this.j = iCommonExecutor;
        this.i = c0141b9;
        this.m = i;
        this.f1195a = c0525q5;
        this.b = c0550r5;
        this.k = c0299hc;
        this.l = m9;
    }

    public final C0437ml c() {
        return new C0437ml(this.c, this.d);
    }

    public final Pi d(C0447n5 c0447n5) {
        Pi pi = new Pi(c0447n5, this.f.a(), this.j);
        C0299hc c0299hc = this.k;
        synchronized (c0299hc) {
            c0299hc.c.add(pi);
        }
        return pi;
    }

    public final C0278gh a(C0447n5 c0447n5) {
        return new C0278gh(new Ch(c0447n5, this.h, new T3()), this.g, new C0770zh(this.e));
    }

    public static C0670vl a(C0447n5 c0447n5, ap apVar, C0421m5 c0421m5) {
        C0644ul c0644ul = new C0644ul(apVar);
        return new C0670vl(c0447n5, c0421m5, new Ea(c0447n5, c0644ul, new C0774zl(c0447n5.h(), "foreground"), AbstractC0754z1.a(), new SystemTimeProvider()), new M2(c0447n5, c0644ul, new C0774zl(c0447n5.h(), M2.g), AbstractC0754z1.a(), new SystemTimeProvider()), new C0618tl(c0447n5, c0644ul));
    }

    public static C0318i5 b() {
        return new C0318i5();
    }

    public final D3 b(C0690wf c0690wf) {
        Context context = this.c;
        return new D3(context, c0690wf, context.getPackageName(), new SafePackageManager());
    }

    public final E9 a(C0690wf c0690wf, ap apVar, C0670vl c0670vl, C0165c7 c0165c7, C0390l0 c0390l0, C0437ml c0437ml, Pi pi) {
        return new E9(c0690wf, apVar, c0670vl, c0165c7, c0390l0, this.i, c0437ml, this.m, new C0499p5(pi), new SystemTimeProvider());
    }

    public static Ni a(C0447n5 c0447n5, C0554r9 c0554r9) {
        return new Ni(c0554r9, c0447n5);
    }

    public K9 a(P9 p9, C0165c7 c0165c7, C0278gh c0278gh, F4 f4, C0266g5 c0266g5, C0690wf c0690wf) {
        return this.l.a(p9, c0165c7, c0278gh, f4, c0266g5, c0690wf).a();
    }

    public final C2 a(C0690wf c0690wf) {
        return new C2(this.d, c0690wf);
    }
}

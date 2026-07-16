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
public class C0577s5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0526q5 f1195a;
    public final C0551r5 b;
    protected final Context c;
    public final C0267g5 d;
    public final F4 e;
    public final AbstractC0396l5 f;
    protected final Hm g;
    public final Bh h;
    public final C0142b9 i;
    public final ICommonExecutor j;
    public final C0300hc k;
    public final M9 l;
    public final int m;

    public C0577s5(Context context, C0267g5 c0267g5, F4 f4, AbstractC0396l5 abstractC0396l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, int i, C0300hc c0300hc, M9 m9) {
        this(context, c0267g5, f4, abstractC0396l5, hm, bh, iCommonExecutor, new C0142b9(), i, new C0526q5(f4.f540a), new C0551r5(context, c0267g5), c0300hc, m9);
    }

    public static C0555r9 c(C0448n5 c0448n5) {
        return new C0555r9(c0448n5);
    }

    public final C0271g9 a() {
        Context context = this.c;
        C0267g5 c0267g5 = this.d;
        return new C0271g9(new C0400l9(context, c0267g5), this.m);
    }

    public final C0166c7 b(C0448n5 c0448n5) {
        return new C0166c7(c0448n5, Na.I.B().c(this.c, this.d), new Z6(c0448n5.b()), new C0683w7());
    }

    public final C0526q5 d() {
        return this.f1195a;
    }

    public final C0551r5 e() {
        return this.b;
    }

    public final ap f() {
        ap apVar;
        ep c0738ya;
        dp D = Na.I.D();
        C0267g5 c0267g5 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(c0267g5);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0691wf c0691wf = new C0691wf(Na.I.B().b(D.f953a, c0267g5));
                IHandlerExecutor e = Na.I.d.e();
                if (c0267g5.d()) {
                    String str = "appmetrica_vital_" + c0267g5.b + ".dat";
                    c0738ya = new C0681w5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0738ya(D.f953a, str, e, 0L, 8, null)), TuplesKt.to("appmetrica_vital_main.dat", new C0738ya(D.f953a, "appmetrica_vital_main.dat", e, 0L, 8, null))}));
                } else {
                    c0738ya = new C0738ya(D.f953a, "appmetrica_vital_" + c0267g5.b + ".dat", e, 0L, 8, null);
                }
                obj = new ap(c0691wf, c0738ya, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            apVar = (ap) obj;
        }
        return apVar;
    }

    public C0577s5(Context context, C0267g5 c0267g5, F4 f4, AbstractC0396l5 abstractC0396l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, C0142b9 c0142b9, int i, C0526q5 c0526q5, C0551r5 c0551r5, C0300hc c0300hc, M9 m9) {
        this.c = context;
        this.d = c0267g5;
        this.e = f4;
        this.f = abstractC0396l5;
        this.g = hm;
        this.h = bh;
        this.j = iCommonExecutor;
        this.i = c0142b9;
        this.m = i;
        this.f1195a = c0526q5;
        this.b = c0551r5;
        this.k = c0300hc;
        this.l = m9;
    }

    public final C0438ml c() {
        return new C0438ml(this.c, this.d);
    }

    public final Pi d(C0448n5 c0448n5) {
        Pi pi = new Pi(c0448n5, this.f.a(), this.j);
        C0300hc c0300hc = this.k;
        synchronized (c0300hc) {
            c0300hc.c.add(pi);
        }
        return pi;
    }

    public final C0279gh a(C0448n5 c0448n5) {
        return new C0279gh(new Ch(c0448n5, this.h, new T3()), this.g, new C0771zh(this.e));
    }

    public static C0671vl a(C0448n5 c0448n5, ap apVar, C0422m5 c0422m5) {
        C0645ul c0645ul = new C0645ul(apVar);
        return new C0671vl(c0448n5, c0422m5, new Ea(c0448n5, c0645ul, new C0775zl(c0448n5.h(), "foreground"), AbstractC0755z1.a(), new SystemTimeProvider()), new M2(c0448n5, c0645ul, new C0775zl(c0448n5.h(), M2.g), AbstractC0755z1.a(), new SystemTimeProvider()), new C0619tl(c0448n5, c0645ul));
    }

    public static C0319i5 b() {
        return new C0319i5();
    }

    public final D3 b(C0691wf c0691wf) {
        Context context = this.c;
        return new D3(context, c0691wf, context.getPackageName(), new SafePackageManager());
    }

    public final E9 a(C0691wf c0691wf, ap apVar, C0671vl c0671vl, C0166c7 c0166c7, C0391l0 c0391l0, C0438ml c0438ml, Pi pi) {
        return new E9(c0691wf, apVar, c0671vl, c0166c7, c0391l0, this.i, c0438ml, this.m, new C0500p5(pi), new SystemTimeProvider());
    }

    public static Ni a(C0448n5 c0448n5, C0555r9 c0555r9) {
        return new Ni(c0555r9, c0448n5);
    }

    public K9 a(P9 p9, C0166c7 c0166c7, C0279gh c0279gh, F4 f4, C0267g5 c0267g5, C0691wf c0691wf) {
        return this.l.a(p9, c0166c7, c0279gh, f4, c0267g5, c0691wf).a();
    }

    public final C2 a(C0691wf c0691wf) {
        return new C2(this.d, c0691wf);
    }
}

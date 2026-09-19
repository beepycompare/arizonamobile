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
public class C0575s5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0524q5 f1195a;
    public final C0549r5 b;
    protected final Context c;
    public final C0265g5 d;
    public final F4 e;
    public final AbstractC0394l5 f;
    protected final Hm g;
    public final Bh h;
    public final C0140b9 i;
    public final ICommonExecutor j;
    public final C0298hc k;
    public final M9 l;
    public final int m;

    public C0575s5(Context context, C0265g5 c0265g5, F4 f4, AbstractC0394l5 abstractC0394l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, int i, C0298hc c0298hc, M9 m9) {
        this(context, c0265g5, f4, abstractC0394l5, hm, bh, iCommonExecutor, new C0140b9(), i, new C0524q5(f4.f540a), new C0549r5(context, c0265g5), c0298hc, m9);
    }

    public static C0553r9 c(C0446n5 c0446n5) {
        return new C0553r9(c0446n5);
    }

    public final C0269g9 a() {
        Context context = this.c;
        C0265g5 c0265g5 = this.d;
        return new C0269g9(new C0398l9(context, c0265g5), this.m);
    }

    public final C0164c7 b(C0446n5 c0446n5) {
        return new C0164c7(c0446n5, Na.I.B().c(this.c, this.d), new Z6(c0446n5.b()), new C0681w7());
    }

    public final C0524q5 d() {
        return this.f1195a;
    }

    public final C0549r5 e() {
        return this.b;
    }

    public final ap f() {
        ap apVar;
        ep c0736ya;
        dp D = Na.I.D();
        C0265g5 c0265g5 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(c0265g5);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0689wf c0689wf = new C0689wf(Na.I.B().b(D.f953a, c0265g5));
                IHandlerExecutor e = Na.I.d.e();
                if (c0265g5.d()) {
                    String str = "appmetrica_vital_" + c0265g5.b + ".dat";
                    c0736ya = new C0679w5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0736ya(D.f953a, str, e, 0L, 8, null)), TuplesKt.to("appmetrica_vital_main.dat", new C0736ya(D.f953a, "appmetrica_vital_main.dat", e, 0L, 8, null))}));
                } else {
                    c0736ya = new C0736ya(D.f953a, "appmetrica_vital_" + c0265g5.b + ".dat", e, 0L, 8, null);
                }
                obj = new ap(c0689wf, c0736ya, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            apVar = (ap) obj;
        }
        return apVar;
    }

    public C0575s5(Context context, C0265g5 c0265g5, F4 f4, AbstractC0394l5 abstractC0394l5, Hm hm, Bh bh, ICommonExecutor iCommonExecutor, C0140b9 c0140b9, int i, C0524q5 c0524q5, C0549r5 c0549r5, C0298hc c0298hc, M9 m9) {
        this.c = context;
        this.d = c0265g5;
        this.e = f4;
        this.f = abstractC0394l5;
        this.g = hm;
        this.h = bh;
        this.j = iCommonExecutor;
        this.i = c0140b9;
        this.m = i;
        this.f1195a = c0524q5;
        this.b = c0549r5;
        this.k = c0298hc;
        this.l = m9;
    }

    public final C0436ml c() {
        return new C0436ml(this.c, this.d);
    }

    public final Pi d(C0446n5 c0446n5) {
        Pi pi = new Pi(c0446n5, this.f.a(), this.j);
        C0298hc c0298hc = this.k;
        synchronized (c0298hc) {
            c0298hc.c.add(pi);
        }
        return pi;
    }

    public final C0277gh a(C0446n5 c0446n5) {
        return new C0277gh(new Ch(c0446n5, this.h, new T3()), this.g, new C0769zh(this.e));
    }

    public static C0669vl a(C0446n5 c0446n5, ap apVar, C0420m5 c0420m5) {
        C0643ul c0643ul = new C0643ul(apVar);
        return new C0669vl(c0446n5, c0420m5, new Ea(c0446n5, c0643ul, new C0773zl(c0446n5.h(), "foreground"), AbstractC0753z1.a(), new SystemTimeProvider()), new M2(c0446n5, c0643ul, new C0773zl(c0446n5.h(), M2.g), AbstractC0753z1.a(), new SystemTimeProvider()), new C0617tl(c0446n5, c0643ul));
    }

    public static C0317i5 b() {
        return new C0317i5();
    }

    public final D3 b(C0689wf c0689wf) {
        Context context = this.c;
        return new D3(context, c0689wf, context.getPackageName(), new SafePackageManager());
    }

    public final E9 a(C0689wf c0689wf, ap apVar, C0669vl c0669vl, C0164c7 c0164c7, C0389l0 c0389l0, C0436ml c0436ml, Pi pi) {
        return new E9(c0689wf, apVar, c0669vl, c0164c7, c0389l0, this.i, c0436ml, this.m, new C0498p5(pi), new SystemTimeProvider());
    }

    public static Ni a(C0446n5 c0446n5, C0553r9 c0553r9) {
        return new Ni(c0553r9, c0446n5);
    }

    public K9 a(P9 p9, C0164c7 c0164c7, C0277gh c0277gh, F4 f4, C0265g5 c0265g5, C0689wf c0689wf) {
        return this.l.a(p9, c0164c7, c0277gh, f4, c0265g5, c0689wf).a();
    }

    public final C2 a(C0689wf c0689wf) {
        return new C2(this.d, c0689wf);
    }
}

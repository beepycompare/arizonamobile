package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.x5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0697x5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0647v5 f1135a;
    public final C0672w5 b;
    protected final Context c;
    public final C0398l5 d;
    public final J4 e;
    public final AbstractC0523q5 f;
    protected final C0389km g;
    public final InterfaceC0759zh h;
    public final C0170c9 i;
    public final ICommonExecutor j;
    public final C0173cc k;
    public final P9 l;
    public final int m;

    public C0697x5(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0389km c0389km, InterfaceC0759zh interfaceC0759zh, ICommonExecutor iCommonExecutor, int i, C0173cc c0173cc, P9 p9) {
        this(context, c0398l5, j4, abstractC0523q5, c0389km, interfaceC0759zh, iCommonExecutor, new C0170c9(), i, new C0647v5(j4.f508a), new C0672w5(context, c0398l5), c0173cc, p9);
    }

    public static C0626u9 c(C0572s5 c0572s5) {
        return new C0626u9(c0572s5);
    }

    public final C0299h9 a() {
        Context context = this.c;
        C0398l5 c0398l5 = this.d;
        return new C0299h9(new C0427m9(context, c0398l5), this.m);
    }

    public final C0297h7 b(C0572s5 c0572s5) {
        return new C0297h7(c0572s5, C0649v7.a(this.c).c(this.d), new C0194d7(c0572s5.c()), new C7());
    }

    public final C0647v5 d() {
        return this.f1135a;
    }

    public final C0672w5 e() {
        return this.b;
    }

    public final zo f() {
        zo zoVar;
        Do c0727ya;
        Co B = Ka.F.B();
        C0398l5 c0398l5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0398l5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0433mf c0433mf = new C0433mf(C0649v7.a(B.f385a).b(c0398l5));
                if (c0398l5.d()) {
                    String str = "appmetrica_vital_" + c0398l5.b + ".dat";
                    c0727ya = new B5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0727ya(B.f385a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0727ya(B.f385a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0727ya = new C0727ya(B.f385a, "appmetrica_vital_" + c0398l5.b + ".dat");
                }
                obj = new zo(c0433mf, c0727ya, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            zoVar = (zo) obj;
        }
        return zoVar;
    }

    public C0697x5(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0389km c0389km, InterfaceC0759zh interfaceC0759zh, ICommonExecutor iCommonExecutor, C0170c9 c0170c9, int i, C0647v5 c0647v5, C0672w5 c0672w5, C0173cc c0173cc, P9 p9) {
        this.c = context;
        this.d = c0398l5;
        this.e = j4;
        this.f = abstractC0523q5;
        this.g = c0389km;
        this.h = interfaceC0759zh;
        this.j = iCommonExecutor;
        this.i = c0170c9;
        this.m = i;
        this.f1135a = c0647v5;
        this.b = c0672w5;
        this.k = c0173cc;
        this.l = p9;
    }

    public final Pk c() {
        return new Pk(this.c, this.d);
    }

    public final Ni d(C0572s5 c0572s5) {
        Ni ni = new Ni(c0572s5, this.f.a(), this.j);
        C0173cc c0173cc = this.k;
        synchronized (c0173cc) {
            c0173cc.c.add(ni);
        }
        return ni;
    }

    public final C0332ih a(C0572s5 c0572s5) {
        return new C0332ih(new Ah(c0572s5, this.h, new Y3()), this.g, new C0709xh(this.e));
    }

    public static Xk a(C0572s5 c0572s5, zo zoVar, C0547r5 c0547r5) {
        Wk wk = new Wk(zoVar);
        return new Xk(c0572s5, wk, c0547r5, new Ea(c0572s5, wk, new C0130al(c0572s5.g(), "foreground"), AbstractC0593t1.a(), new SystemTimeProvider()), new L2(c0572s5, wk, new C0130al(c0572s5.g(), L2.g), AbstractC0593t1.a(), new SystemTimeProvider()));
    }

    public static C0448n5 b() {
        return new C0448n5();
    }

    public final H9 a(C0433mf c0433mf, zo zoVar, Xk xk, C0297h7 c0297h7, C0290h0 c0290h0, Pk pk, Ni ni) {
        return new H9(c0433mf, zoVar, xk, c0297h7, c0290h0, this.i, pk, this.m, new C0622u5(ni), new C0477o9(zoVar, new C0502p9(zoVar)), new SystemTimeProvider());
    }

    public static Li a(C0572s5 c0572s5, C0626u9 c0626u9) {
        return new Li(c0626u9, c0572s5);
    }

    public N9 a(S9 s9, C0297h7 c0297h7, C0332ih c0332ih, J4 j4, C0398l5 c0398l5, C0433mf c0433mf) {
        return this.l.a(s9, c0297h7, c0332ih, j4, c0398l5, c0433mf).a();
    }

    public final I3 a(C0433mf c0433mf) {
        Context context = this.c;
        return new I3(context, c0433mf, context.getPackageName(), new SafePackageManager());
    }
}

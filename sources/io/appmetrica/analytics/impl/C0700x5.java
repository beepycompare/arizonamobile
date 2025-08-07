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
public class C0700x5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0650v5 f1130a;
    public final C0675w5 b;
    protected final Context c;
    public final C0401l5 d;
    public final J4 e;
    public final AbstractC0526q5 f;
    protected final C0268fm g;
    public final InterfaceC0637uh h;
    public final C0126a9 i;
    public final ICommonExecutor j;
    public final C0129ac k;
    public final N9 l;
    public final int m;

    public C0700x5(Context context, C0401l5 c0401l5, J4 j4, AbstractC0526q5 abstractC0526q5, C0268fm c0268fm, InterfaceC0637uh interfaceC0637uh, ICommonExecutor iCommonExecutor, int i, C0129ac c0129ac, N9 n9) {
        this(context, c0401l5, j4, abstractC0526q5, c0268fm, interfaceC0637uh, iCommonExecutor, new C0126a9(), i, new C0650v5(j4.f497a), new C0675w5(context, c0401l5), c0129ac, n9);
    }

    public static C0579s9 c(C0575s5 c0575s5) {
        return new C0579s9(c0575s5);
    }

    public final C0255f9 a() {
        Context context = this.c;
        C0401l5 c0401l5 = this.d;
        return new C0255f9(new C0380k9(context, c0401l5), this.m);
    }

    public final C0279g7 b(C0575s5 c0575s5) {
        return new C0279g7(c0575s5, C0627u7.a(this.c).c(this.d), new C0176c7(c0575s5.c()), new B7());
    }

    public final C0650v5 d() {
        return this.f1130a;
    }

    public final C0675w5 e() {
        return this.b;
    }

    public final uo f() {
        uo uoVar;
        yo c0680wa;
        xo B = Ia.F.B();
        C0401l5 c0401l5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0401l5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0386kf c0386kf = new C0386kf(C0627u7.a(B.f1142a).b(c0401l5));
                if (c0401l5.d()) {
                    String str = "appmetrica_vital_" + c0401l5.b + ".dat";
                    c0680wa = new B5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0680wa(B.f1142a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0680wa(B.f1142a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0680wa = new C0680wa(B.f1142a, "appmetrica_vital_" + c0401l5.b + ".dat");
                }
                obj = new uo(c0386kf, c0680wa, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            uoVar = (uo) obj;
        }
        return uoVar;
    }

    public C0700x5(Context context, C0401l5 c0401l5, J4 j4, AbstractC0526q5 abstractC0526q5, C0268fm c0268fm, InterfaceC0637uh interfaceC0637uh, ICommonExecutor iCommonExecutor, C0126a9 c0126a9, int i, C0650v5 c0650v5, C0675w5 c0675w5, C0129ac c0129ac, N9 n9) {
        this.c = context;
        this.d = c0401l5;
        this.e = j4;
        this.f = abstractC0526q5;
        this.g = c0268fm;
        this.h = interfaceC0637uh;
        this.j = iCommonExecutor;
        this.i = c0126a9;
        this.m = i;
        this.f1130a = c0650v5;
        this.b = c0675w5;
        this.k = c0129ac;
        this.l = n9;
    }

    public final Kk c() {
        return new Kk(this.c, this.d);
    }

    public final Ii d(C0575s5 c0575s5) {
        Ii ii = new Ii(c0575s5, this.f.a(), this.j);
        C0129ac c0129ac = this.k;
        synchronized (c0129ac) {
            c0129ac.c.add(ii);
        }
        return ii;
    }

    public final C0212dh a(C0575s5 c0575s5) {
        return new C0212dh(new C0662vh(c0575s5, this.h, new Y3()), this.g, new C0587sh(this.e));
    }

    public static Sk a(C0575s5 c0575s5, uo uoVar, C0550r5 c0550r5) {
        Rk rk = new Rk(uoVar);
        return new Sk(c0575s5, rk, c0550r5, new Ca(c0575s5, rk, new Vk(c0575s5.g(), "foreground"), AbstractC0596t1.a(), new SystemTimeProvider()), new L2(c0575s5, rk, new Vk(c0575s5.g(), L2.g), AbstractC0596t1.a(), new SystemTimeProvider()));
    }

    public static C0451n5 b() {
        return new C0451n5();
    }

    public final F9 a(C0386kf c0386kf, uo uoVar, Sk sk, C0279g7 c0279g7, C0297h0 c0297h0, Kk kk, Ii ii) {
        return new F9(c0386kf, uoVar, sk, c0279g7, c0297h0, this.i, kk, this.m, new C0625u5(ii), new C0430m9(uoVar, new C0455n9(uoVar)), new SystemTimeProvider());
    }

    public static Gi a(C0575s5 c0575s5, C0579s9 c0579s9) {
        return new Gi(c0579s9, c0575s5);
    }

    public L9 a(Q9 q9, C0279g7 c0279g7, C0212dh c0212dh, J4 j4, C0401l5 c0401l5, C0386kf c0386kf) {
        return this.l.a(q9, c0279g7, c0212dh, j4, c0401l5, c0386kf).a();
    }

    public final I3 a(C0386kf c0386kf) {
        Context context = this.c;
        return new I3(context, c0386kf, context.getPackageName(), new SafePackageManager());
    }
}

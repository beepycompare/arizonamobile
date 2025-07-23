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
public class C0699x5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0649v5 f1130a;
    public final C0674w5 b;
    protected final Context c;
    public final C0400l5 d;
    public final J4 e;
    public final AbstractC0525q5 f;
    protected final C0267fm g;
    public final InterfaceC0636uh h;
    public final C0125a9 i;
    public final ICommonExecutor j;
    public final C0128ac k;
    public final N9 l;
    public final int m;

    public C0699x5(Context context, C0400l5 c0400l5, J4 j4, AbstractC0525q5 abstractC0525q5, C0267fm c0267fm, InterfaceC0636uh interfaceC0636uh, ICommonExecutor iCommonExecutor, int i, C0128ac c0128ac, N9 n9) {
        this(context, c0400l5, j4, abstractC0525q5, c0267fm, interfaceC0636uh, iCommonExecutor, new C0125a9(), i, new C0649v5(j4.f497a), new C0674w5(context, c0400l5), c0128ac, n9);
    }

    public static C0578s9 c(C0574s5 c0574s5) {
        return new C0578s9(c0574s5);
    }

    public final C0254f9 a() {
        Context context = this.c;
        C0400l5 c0400l5 = this.d;
        return new C0254f9(new C0379k9(context, c0400l5), this.m);
    }

    public final C0278g7 b(C0574s5 c0574s5) {
        return new C0278g7(c0574s5, C0626u7.a(this.c).c(this.d), new C0175c7(c0574s5.c()), new B7());
    }

    public final C0649v5 d() {
        return this.f1130a;
    }

    public final C0674w5 e() {
        return this.b;
    }

    public final uo f() {
        uo uoVar;
        yo c0679wa;
        xo B = Ia.F.B();
        C0400l5 c0400l5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0400l5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0385kf c0385kf = new C0385kf(C0626u7.a(B.f1142a).b(c0400l5));
                if (c0400l5.d()) {
                    String str = "appmetrica_vital_" + c0400l5.b + ".dat";
                    c0679wa = new B5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0679wa(B.f1142a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0679wa(B.f1142a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0679wa = new C0679wa(B.f1142a, "appmetrica_vital_" + c0400l5.b + ".dat");
                }
                obj = new uo(c0385kf, c0679wa, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            uoVar = (uo) obj;
        }
        return uoVar;
    }

    public C0699x5(Context context, C0400l5 c0400l5, J4 j4, AbstractC0525q5 abstractC0525q5, C0267fm c0267fm, InterfaceC0636uh interfaceC0636uh, ICommonExecutor iCommonExecutor, C0125a9 c0125a9, int i, C0649v5 c0649v5, C0674w5 c0674w5, C0128ac c0128ac, N9 n9) {
        this.c = context;
        this.d = c0400l5;
        this.e = j4;
        this.f = abstractC0525q5;
        this.g = c0267fm;
        this.h = interfaceC0636uh;
        this.j = iCommonExecutor;
        this.i = c0125a9;
        this.m = i;
        this.f1130a = c0649v5;
        this.b = c0674w5;
        this.k = c0128ac;
        this.l = n9;
    }

    public final Kk c() {
        return new Kk(this.c, this.d);
    }

    public final Ii d(C0574s5 c0574s5) {
        Ii ii = new Ii(c0574s5, this.f.a(), this.j);
        C0128ac c0128ac = this.k;
        synchronized (c0128ac) {
            c0128ac.c.add(ii);
        }
        return ii;
    }

    public final C0211dh a(C0574s5 c0574s5) {
        return new C0211dh(new C0661vh(c0574s5, this.h, new Y3()), this.g, new C0586sh(this.e));
    }

    public static Sk a(C0574s5 c0574s5, uo uoVar, C0549r5 c0549r5) {
        Rk rk = new Rk(uoVar);
        return new Sk(c0574s5, rk, c0549r5, new Ca(c0574s5, rk, new Vk(c0574s5.g(), "foreground"), AbstractC0595t1.a(), new SystemTimeProvider()), new L2(c0574s5, rk, new Vk(c0574s5.g(), L2.g), AbstractC0595t1.a(), new SystemTimeProvider()));
    }

    public static C0450n5 b() {
        return new C0450n5();
    }

    public final F9 a(C0385kf c0385kf, uo uoVar, Sk sk, C0278g7 c0278g7, C0296h0 c0296h0, Kk kk, Ii ii) {
        return new F9(c0385kf, uoVar, sk, c0278g7, c0296h0, this.i, kk, this.m, new C0624u5(ii), new C0429m9(uoVar, new C0454n9(uoVar)), new SystemTimeProvider());
    }

    public static Gi a(C0574s5 c0574s5, C0578s9 c0578s9) {
        return new Gi(c0578s9, c0574s5);
    }

    public L9 a(Q9 q9, C0278g7 c0278g7, C0211dh c0211dh, J4 j4, C0400l5 c0400l5, C0385kf c0385kf) {
        return this.l.a(q9, c0278g7, c0211dh, j4, c0400l5, c0385kf).a();
    }

    public final I3 a(C0385kf c0385kf) {
        Context context = this.c;
        return new I3(context, c0385kf, context.getPackageName(), new SafePackageManager());
    }
}

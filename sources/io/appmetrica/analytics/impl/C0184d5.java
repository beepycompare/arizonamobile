package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0184d5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0132b5 f941a;
    public final C0158c5 b;
    protected final Context c;
    public final R4 d;
    public final C0489p4 e;
    public final W4 f;
    protected final C0278gm g;
    public final InterfaceC0324ih h;
    public final I8 i;
    public final ICommonExecutor j;
    public final Gb k;
    public final InterfaceC0593t9 l;
    public final int m;

    public C0184d5(Context context, R4 r4, C0489p4 c0489p4, W4 w4, C0278gm c0278gm, InterfaceC0324ih interfaceC0324ih, ICommonExecutor iCommonExecutor, int i, Gb gb, InterfaceC0593t9 interfaceC0593t9) {
        this(context, r4, c0489p4, w4, c0278gm, interfaceC0324ih, iCommonExecutor, new I8(), i, new C0132b5(c0489p4.f1157a), new C0158c5(context, r4), gb, interfaceC0593t9);
    }

    public static Y8 c(Y4 y4) {
        return new Y8(y4);
    }

    public final N8 a() {
        Context context = this.c;
        R4 r4 = this.d;
        return new N8(new S8(context, r4), this.m);
    }

    public final M6 b(Y4 y4) {
        return new M6(y4, C0470oa.I.B().c(this.c, this.d), new I6(y4.c()), new C0263g7());
    }

    public final C0132b5 d() {
        return this.f941a;
    }

    public final C0158c5 e() {
        return this.b;
    }

    public final yo f() {
        yo yoVar;
        Co c0163ca;
        Bo D = C0470oa.I.D();
        R4 r4 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(r4);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                Xe xe = new Xe(C0470oa.I.B().b(D.f514a, r4));
                if (r4.d()) {
                    String str = "appmetrica_vital_" + r4.b + ".dat";
                    c0163ca = new C0287h5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0163ca(D.f514a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0163ca(D.f514a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0163ca = new C0163ca(D.f514a, "appmetrica_vital_" + r4.b + ".dat");
                }
                obj = new yo(xe, c0163ca, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            yoVar = (yo) obj;
        }
        return yoVar;
    }

    public C0184d5(Context context, R4 r4, C0489p4 c0489p4, W4 w4, C0278gm c0278gm, InterfaceC0324ih interfaceC0324ih, ICommonExecutor iCommonExecutor, I8 i8, int i, C0132b5 c0132b5, C0158c5 c0158c5, Gb gb, InterfaceC0593t9 interfaceC0593t9) {
        this.c = context;
        this.d = r4;
        this.e = c0489p4;
        this.f = w4;
        this.g = c0278gm;
        this.h = interfaceC0324ih;
        this.j = iCommonExecutor;
        this.i = i8;
        this.m = i;
        this.f941a = c0132b5;
        this.b = c0158c5;
        this.k = gb;
        this.l = interfaceC0593t9;
    }

    public final Kk c() {
        return new Kk(this.c, this.d);
    }

    public final C0677wi d(Y4 y4) {
        C0677wi c0677wi = new C0677wi(y4, this.f.a(), this.j);
        Gb gb = this.k;
        synchronized (gb) {
            gb.c.add(c0677wi);
        }
        return c0677wi;
    }

    public final Rg a(Y4 y4) {
        return new Rg(new C0350jh(y4, this.h, new D3()), this.g, new C0273gh(this.e));
    }

    public static Sk a(Y4 y4, yo yoVar, X4 x4) {
        Rk rk = new Rk(yoVar);
        return new Sk(y4, rk, x4, new C0318ia(y4, rk, new Vk(y4.h(), "foreground"), AbstractC0710y1.a(), new SystemTimeProvider()), new A2(y4, rk, new Vk(y4.h(), A2.g), AbstractC0710y1.a(), new SystemTimeProvider()));
    }

    public static T4 b() {
        return new T4();
    }

    public final C0438n3 b(Xe xe) {
        Context context = this.c;
        return new C0438n3(context, xe, context.getPackageName(), new SafePackageManager());
    }

    public final C0394l9 a(Xe xe, yo yoVar, Sk sk, M6 m6, C0333j0 c0333j0, Kk kk, C0677wi c0677wi) {
        return new C0394l9(xe, yoVar, sk, m6, c0333j0, this.i, kk, this.m, new C0106a5(c0677wi), new SystemTimeProvider());
    }

    public static C0627ui a(Y4 y4, Y8 y8) {
        return new C0627ui(y8, y4);
    }

    public InterfaceC0543r9 a(InterfaceC0668w9 interfaceC0668w9, M6 m6, Rg rg, C0489p4 c0489p4, R4 r4, Xe xe) {
        return this.l.a(interfaceC0668w9, m6, rg, c0489p4, r4, xe).a();
    }

    public final C0512q2 a(Xe xe) {
        return new C0512q2(this.d, xe);
    }
}

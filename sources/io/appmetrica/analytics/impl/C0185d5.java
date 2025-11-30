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
public class C0185d5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0133b5 f843a;
    public final C0159c5 b;
    protected final Context c;
    public final R4 d;
    public final C0490p4 e;
    public final W4 f;
    protected final C0279gm g;
    public final InterfaceC0325ih h;
    public final I8 i;
    public final ICommonExecutor j;
    public final Gb k;
    public final InterfaceC0594t9 l;
    public final int m;

    public C0185d5(Context context, R4 r4, C0490p4 c0490p4, W4 w4, C0279gm c0279gm, InterfaceC0325ih interfaceC0325ih, ICommonExecutor iCommonExecutor, int i, Gb gb, InterfaceC0594t9 interfaceC0594t9) {
        this(context, r4, c0490p4, w4, c0279gm, interfaceC0325ih, iCommonExecutor, new I8(), i, new C0133b5(c0490p4.f1059a), new C0159c5(context, r4), gb, interfaceC0594t9);
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
        return new M6(y4, C0471oa.I.B().c(this.c, this.d), new I6(y4.c()), new C0264g7());
    }

    public final C0133b5 d() {
        return this.f843a;
    }

    public final C0159c5 e() {
        return this.b;
    }

    public final yo f() {
        yo yoVar;
        Co c0164ca;
        Bo D = C0471oa.I.D();
        R4 r4 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(r4);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                Xe xe = new Xe(C0471oa.I.B().b(D.f416a, r4));
                if (r4.d()) {
                    String str = "appmetrica_vital_" + r4.b + ".dat";
                    c0164ca = new C0288h5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0164ca(D.f416a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0164ca(D.f416a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0164ca = new C0164ca(D.f416a, "appmetrica_vital_" + r4.b + ".dat");
                }
                obj = new yo(xe, c0164ca, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            yoVar = (yo) obj;
        }
        return yoVar;
    }

    public C0185d5(Context context, R4 r4, C0490p4 c0490p4, W4 w4, C0279gm c0279gm, InterfaceC0325ih interfaceC0325ih, ICommonExecutor iCommonExecutor, I8 i8, int i, C0133b5 c0133b5, C0159c5 c0159c5, Gb gb, InterfaceC0594t9 interfaceC0594t9) {
        this.c = context;
        this.d = r4;
        this.e = c0490p4;
        this.f = w4;
        this.g = c0279gm;
        this.h = interfaceC0325ih;
        this.j = iCommonExecutor;
        this.i = i8;
        this.m = i;
        this.f843a = c0133b5;
        this.b = c0159c5;
        this.k = gb;
        this.l = interfaceC0594t9;
    }

    public final Kk c() {
        return new Kk(this.c, this.d);
    }

    public final C0678wi d(Y4 y4) {
        C0678wi c0678wi = new C0678wi(y4, this.f.a(), this.j);
        Gb gb = this.k;
        synchronized (gb) {
            gb.c.add(c0678wi);
        }
        return c0678wi;
    }

    public final Rg a(Y4 y4) {
        return new Rg(new C0351jh(y4, this.h, new D3()), this.g, new C0274gh(this.e));
    }

    public static Sk a(Y4 y4, yo yoVar, X4 x4) {
        Rk rk = new Rk(yoVar);
        return new Sk(y4, rk, x4, new C0319ia(y4, rk, new Vk(y4.h(), "foreground"), AbstractC0711y1.a(), new SystemTimeProvider()), new A2(y4, rk, new Vk(y4.h(), A2.g), AbstractC0711y1.a(), new SystemTimeProvider()));
    }

    public static T4 b() {
        return new T4();
    }

    public final C0439n3 b(Xe xe) {
        Context context = this.c;
        return new C0439n3(context, xe, context.getPackageName(), new SafePackageManager());
    }

    public final C0395l9 a(Xe xe, yo yoVar, Sk sk, M6 m6, C0334j0 c0334j0, Kk kk, C0678wi c0678wi) {
        return new C0395l9(xe, yoVar, sk, m6, c0334j0, this.i, kk, this.m, new C0107a5(c0678wi), new SystemTimeProvider());
    }

    public static C0628ui a(Y4 y4, Y8 y8) {
        return new C0628ui(y8, y4);
    }

    public InterfaceC0544r9 a(InterfaceC0669w9 interfaceC0669w9, M6 m6, Rg rg, C0490p4 c0490p4, R4 r4, Xe xe) {
        return this.l.a(interfaceC0669w9, m6, rg, c0490p4, r4, xe).a();
    }

    public final C0513q2 a(Xe xe) {
        return new C0513q2(this.d, xe);
    }
}

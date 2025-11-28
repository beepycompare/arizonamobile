package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.j5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0339j5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0288h5 f946a;
    public final C0314i5 b;
    protected final Context c;
    public final X4 d;
    public final C0639v4 e;
    public final AbstractC0159c5 f;
    protected final C0356jm g;
    public final InterfaceC0428mh h;
    public final M8 i;
    public final ICommonExecutor j;
    public final Mb k;
    public final InterfaceC0744z9 l;
    public final int m;

    public C0339j5(Context context, X4 x4, C0639v4 c0639v4, AbstractC0159c5 abstractC0159c5, C0356jm c0356jm, InterfaceC0428mh interfaceC0428mh, ICommonExecutor iCommonExecutor, int i, Mb mb, InterfaceC0744z9 interfaceC0744z9) {
        this(context, x4, c0639v4, abstractC0159c5, c0356jm, interfaceC0428mh, iCommonExecutor, new M8(), i, new C0288h5(c0639v4.f1162a), new C0314i5(context, x4), mb, interfaceC0744z9);
    }

    public static C0214e9 c(C0210e5 c0210e5) {
        return new C0214e9(c0210e5);
    }

    public final R8 a() {
        Context context = this.c;
        X4 x4 = this.d;
        return new R8(new W8(context, x4), this.m);
    }

    public final S6 b(C0210e5 c0210e5) {
        return new S6(c0210e5, C0264g7.a(this.c).c(this.d), new O6(c0210e5.c()), new C0443n7());
    }

    public final C0288h5 d() {
        return this.f946a;
    }

    public final C0314i5 e() {
        return this.b;
    }

    public final zo f() {
        zo zoVar;
        Do c0319ia;
        Co D = C0620ua.H.D();
        X4 x4 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(x4);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                C0143bf c0143bf = new C0143bf(C0264g7.a(D.f431a).b(x4));
                if (x4.d()) {
                    String str = "appmetrica_vital_" + x4.b + ".dat";
                    c0319ia = new C0441n5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0319ia(D.f431a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0319ia(D.f431a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0319ia = new C0319ia(D.f431a, "appmetrica_vital_" + x4.b + ".dat");
                }
                obj = new zo(c0143bf, c0319ia, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            zoVar = (zo) obj;
        }
        return zoVar;
    }

    public C0339j5(Context context, X4 x4, C0639v4 c0639v4, AbstractC0159c5 abstractC0159c5, C0356jm c0356jm, InterfaceC0428mh interfaceC0428mh, ICommonExecutor iCommonExecutor, M8 m8, int i, C0288h5 c0288h5, C0314i5 c0314i5, Mb mb, InterfaceC0744z9 interfaceC0744z9) {
        this.c = context;
        this.d = x4;
        this.e = c0639v4;
        this.f = abstractC0159c5;
        this.g = c0356jm;
        this.h = interfaceC0428mh;
        this.j = iCommonExecutor;
        this.i = m8;
        this.m = i;
        this.f946a = c0288h5;
        this.b = c0314i5;
        this.k = mb;
        this.l = interfaceC0744z9;
    }

    public final Ok c() {
        return new Ok(this.c, this.d);
    }

    public final Ai d(C0210e5 c0210e5) {
        Ai ai = new Ai(c0210e5, this.f.a(), this.j);
        Mb mb = this.k;
        synchronized (mb) {
            mb.c.add(ai);
        }
        return ai;
    }

    public final Vg a(C0210e5 c0210e5) {
        return new Vg(new C0453nh(c0210e5, this.h, new K3()), this.g, new C0377kh(this.e));
    }

    public static Wk a(C0210e5 c0210e5, zo zoVar, C0185d5 c0185d5) {
        Vk vk = new Vk(zoVar);
        return new Wk(c0210e5, vk, c0185d5, new C0471oa(c0210e5, vk, new Zk(c0210e5.h(), "foreground"), AbstractC0661w1.a(), new SystemTimeProvider()), new H2(c0210e5, vk, new Zk(c0210e5.h(), H2.g), AbstractC0661w1.a(), new SystemTimeProvider()));
    }

    public static Z4 b() {
        return new Z4();
    }

    public final C0613u3 b(C0143bf c0143bf) {
        Context context = this.c;
        return new C0613u3(context, c0143bf, context.getPackageName(), new SafePackageManager());
    }

    public final C0544r9 a(C0143bf c0143bf, zo zoVar, Wk wk, S6 s6, C0334j0 c0334j0, Ok ok, Ai ai) {
        return new C0544r9(c0143bf, zoVar, wk, s6, c0334j0, this.i, ok, this.m, new C0262g5(ai), new Y8(zoVar, new Z8(zoVar)), new SystemTimeProvider());
    }

    public static C0728yi a(C0210e5 c0210e5, C0214e9 c0214e9) {
        return new C0728yi(c0214e9, c0210e5);
    }

    public InterfaceC0694x9 a(C9 c9, S6 s6, Vg vg, C0639v4 c0639v4, X4 x4, C0143bf c0143bf) {
        return this.l.a(c9, s6, vg, c0639v4, x4, c0143bf).a();
    }

    public final C0687x2 a(C0143bf c0143bf) {
        return new C0687x2(this.d, c0143bf);
    }
}

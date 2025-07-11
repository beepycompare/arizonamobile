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
    public final C0647v5 f1118a;
    public final C0672w5 b;
    protected final Context c;
    public final C0398l5 d;
    public final J4 e;
    public final AbstractC0523q5 f;
    protected final C0190cm g;
    public final InterfaceC0584sh h;
    public final X8 i;
    public final ICommonExecutor j;
    public final Yb k;
    public final K9 l;
    public final int m;

    public C0697x5(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0190cm c0190cm, InterfaceC0584sh interfaceC0584sh, ICommonExecutor iCommonExecutor, int i, Yb yb, K9 k9) {
        this(context, c0398l5, j4, abstractC0523q5, c0190cm, interfaceC0584sh, iCommonExecutor, new X8(), i, new C0647v5(j4.f486a), new C0672w5(context, c0398l5), yb, k9);
    }

    public static C0502p9 c(C0572s5 c0572s5) {
        return new C0502p9(c0572s5);
    }

    public final C0177c9 a() {
        Context context = this.c;
        C0398l5 c0398l5 = this.d;
        return new C0177c9(new C0303h9(context, c0398l5), this.m);
    }

    public final C0201d7 b(C0572s5 c0572s5) {
        return new C0201d7(c0572s5, C0549r7.a(this.c).c(this.d), new Z6(c0572s5.c()), new C0724y7());
    }

    public final C0647v5 d() {
        return this.f1118a;
    }

    public final C0672w5 e() {
        return this.b;
    }

    public final ro f() {
        ro roVar;
        vo c0627ua;
        uo B = Ga.F.B();
        C0398l5 c0398l5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0398l5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                Cif cif = new Cif(C0549r7.a(B.f1082a).b(c0398l5));
                if (c0398l5.d()) {
                    String str = "appmetrica_vital_" + c0398l5.b + ".dat";
                    c0627ua = new C0747z5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0627ua(B.f1082a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0627ua(B.f1082a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0627ua = new C0627ua(B.f1082a, "appmetrica_vital_" + c0398l5.b + ".dat");
                }
                obj = new ro(cif, c0627ua, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            roVar = (ro) obj;
        }
        return roVar;
    }

    public C0697x5(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0190cm c0190cm, InterfaceC0584sh interfaceC0584sh, ICommonExecutor iCommonExecutor, X8 x8, int i, C0647v5 c0647v5, C0672w5 c0672w5, Yb yb, K9 k9) {
        this.c = context;
        this.d = c0398l5;
        this.e = j4;
        this.f = abstractC0523q5;
        this.g = c0190cm;
        this.h = interfaceC0584sh;
        this.j = iCommonExecutor;
        this.i = x8;
        this.m = i;
        this.f1118a = c0647v5;
        this.b = c0672w5;
        this.k = yb;
        this.l = k9;
    }

    public final Hk c() {
        return new Hk(this.c, this.d);
    }

    public final Fi d(C0572s5 c0572s5) {
        Fi fi = new Fi(c0572s5, this.f.a(), this.j);
        Yb yb = this.k;
        synchronized (yb) {
            yb.c.add(fi);
        }
        return fi;
    }

    public final C0159bh a(C0572s5 c0572s5) {
        return new C0159bh(new C0609th(c0572s5, this.h, new Y3()), this.g, new C0535qh(this.e));
    }

    public static Pk a(C0572s5 c0572s5, ro roVar, C0547r5 c0547r5) {
        Ok ok = new Ok(roVar);
        return new Pk(c0572s5, ok, c0547r5, new Aa(c0572s5, ok, new Sk(c0572s5.g(), "foreground"), AbstractC0593t1.a(), new SystemTimeProvider()), new L2(c0572s5, ok, new Sk(c0572s5.g(), L2.g), AbstractC0593t1.a(), new SystemTimeProvider()));
    }

    public static C0448n5 b() {
        return new C0448n5();
    }

    public final C9 a(Cif cif, ro roVar, Pk pk, C0201d7 c0201d7, C0294h0 c0294h0, Hk hk, Fi fi) {
        return new C9(cif, roVar, pk, c0201d7, c0294h0, this.i, hk, this.m, new C0622u5(fi), new C0352j9(roVar, new C0377k9(roVar)), new SystemTimeProvider());
    }

    public static Di a(C0572s5 c0572s5, C0502p9 c0502p9) {
        return new Di(c0502p9, c0572s5);
    }

    public I9 a(N9 n9, C0201d7 c0201d7, C0159bh c0159bh, J4 j4, C0398l5 c0398l5, Cif cif) {
        return this.l.a(n9, c0201d7, c0159bh, j4, c0398l5, cif).a();
    }

    public final I3 a(Cif cif) {
        Context context = this.c;
        return new I3(context, cif, context.getPackageName(), new SafePackageManager());
    }
}

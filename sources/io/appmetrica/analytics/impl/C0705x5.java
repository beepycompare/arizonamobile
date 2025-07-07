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
public class C0705x5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0655v5 f1117a;
    public final C0680w5 b;
    protected final Context c;
    public final C0406l5 d;
    public final J4 e;
    public final AbstractC0531q5 f;
    protected final C0198cm g;
    public final InterfaceC0592sh h;
    public final X8 i;
    public final ICommonExecutor j;
    public final Yb k;
    public final K9 l;
    public final int m;

    public C0705x5(Context context, C0406l5 c0406l5, J4 j4, AbstractC0531q5 abstractC0531q5, C0198cm c0198cm, InterfaceC0592sh interfaceC0592sh, ICommonExecutor iCommonExecutor, int i, Yb yb, K9 k9) {
        this(context, c0406l5, j4, abstractC0531q5, c0198cm, interfaceC0592sh, iCommonExecutor, new X8(), i, new C0655v5(j4.f485a), new C0680w5(context, c0406l5), yb, k9);
    }

    public static C0510p9 c(C0580s5 c0580s5) {
        return new C0510p9(c0580s5);
    }

    public final C0185c9 a() {
        Context context = this.c;
        C0406l5 c0406l5 = this.d;
        return new C0185c9(new C0311h9(context, c0406l5), this.m);
    }

    public final C0209d7 b(C0580s5 c0580s5) {
        return new C0209d7(c0580s5, C0557r7.a(this.c).c(this.d), new Z6(c0580s5.c()), new C0732y7());
    }

    public final C0655v5 d() {
        return this.f1117a;
    }

    public final C0680w5 e() {
        return this.b;
    }

    public final ro f() {
        ro roVar;
        vo c0635ua;
        uo B = Ga.F.B();
        C0406l5 c0406l5 = this.d;
        synchronized (B) {
            String valueOf = String.valueOf(c0406l5);
            LinkedHashMap linkedHashMap = B.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                Cif cif = new Cif(C0557r7.a(B.f1081a).b(c0406l5));
                if (c0406l5.d()) {
                    String str = "appmetrica_vital_" + c0406l5.b + ".dat";
                    c0635ua = new C0755z5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0635ua(B.f1081a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0635ua(B.f1081a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0635ua = new C0635ua(B.f1081a, "appmetrica_vital_" + c0406l5.b + ".dat");
                }
                obj = new ro(cif, c0635ua, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            roVar = (ro) obj;
        }
        return roVar;
    }

    public C0705x5(Context context, C0406l5 c0406l5, J4 j4, AbstractC0531q5 abstractC0531q5, C0198cm c0198cm, InterfaceC0592sh interfaceC0592sh, ICommonExecutor iCommonExecutor, X8 x8, int i, C0655v5 c0655v5, C0680w5 c0680w5, Yb yb, K9 k9) {
        this.c = context;
        this.d = c0406l5;
        this.e = j4;
        this.f = abstractC0531q5;
        this.g = c0198cm;
        this.h = interfaceC0592sh;
        this.j = iCommonExecutor;
        this.i = x8;
        this.m = i;
        this.f1117a = c0655v5;
        this.b = c0680w5;
        this.k = yb;
        this.l = k9;
    }

    public final Hk c() {
        return new Hk(this.c, this.d);
    }

    public final Fi d(C0580s5 c0580s5) {
        Fi fi = new Fi(c0580s5, this.f.a(), this.j);
        Yb yb = this.k;
        synchronized (yb) {
            yb.c.add(fi);
        }
        return fi;
    }

    public final C0167bh a(C0580s5 c0580s5) {
        return new C0167bh(new C0617th(c0580s5, this.h, new Y3()), this.g, new C0543qh(this.e));
    }

    public static Pk a(C0580s5 c0580s5, ro roVar, C0555r5 c0555r5) {
        Ok ok = new Ok(roVar);
        return new Pk(c0580s5, ok, c0555r5, new Aa(c0580s5, ok, new Sk(c0580s5.g(), "foreground"), AbstractC0601t1.a(), new SystemTimeProvider()), new L2(c0580s5, ok, new Sk(c0580s5.g(), L2.g), AbstractC0601t1.a(), new SystemTimeProvider()));
    }

    public static C0456n5 b() {
        return new C0456n5();
    }

    public final C9 a(Cif cif, ro roVar, Pk pk, C0209d7 c0209d7, C0302h0 c0302h0, Hk hk, Fi fi) {
        return new C9(cif, roVar, pk, c0209d7, c0302h0, this.i, hk, this.m, new C0630u5(fi), new C0360j9(roVar, new C0385k9(roVar)), new SystemTimeProvider());
    }

    public static Di a(C0580s5 c0580s5, C0510p9 c0510p9) {
        return new Di(c0510p9, c0580s5);
    }

    public I9 a(N9 n9, C0209d7 c0209d7, C0167bh c0167bh, J4 j4, C0406l5 c0406l5, Cif cif) {
        return this.l.a(n9, c0209d7, c0167bh, j4, c0406l5, cif).a();
    }

    public final I3 a(Cif cif) {
        Context context = this.c;
        return new I3(context, cif, context.getPackageName(), new SafePackageManager());
    }
}

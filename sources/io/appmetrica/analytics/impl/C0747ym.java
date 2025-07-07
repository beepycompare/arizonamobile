package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.executors.SynchronizedBlockingExecutor;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.FinalConfigProvider;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0747ym {

    /* renamed from: a  reason: collision with root package name */
    public final C0772zm f1150a;
    public volatile NetworkTask b;

    public C0747ym(C0772zm c0772zm) {
        this.f1150a = c0772zm;
    }

    public final Context b() {
        return this.f1150a.f1171a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    Yl d = d();
                    C0341ie c0341ie = C0341ie.f876a;
                    Ul ul = new Ul(new C0614te(), Ga.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new Q9(this.f1150a.f1171a), new AllHostsExponentialBackoffPolicy(C0341ie.f876a.a(EnumC0291ge.STARTUP)), new C0697wm(this, new Ol(), new FullUrlFormer(ul, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0341ie.c);
                        this.b = networkTask2;
                        networkTask = networkTask2;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    networkTask = null;
                }
                return networkTask;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final Yl d() {
        return (Yl) this.f1150a.l.a();
    }

    public final C0198cm e() {
        C0198cm c0198cm;
        Fl fl = this.f1150a.l;
        synchronized (fl) {
            c0198cm = fl.c.f816a;
        }
        return c0198cm;
    }

    public final void f() {
        C0198cm c0198cm;
        Fl fl = this.f1150a.l;
        synchronized (fl) {
            c0198cm = fl.c.f816a;
        }
        C0299gm c0299gm = c0198cm.c;
        C0274fm a2 = c0299gm.a(c0299gm.m);
        String str = c0198cm.f788a;
        String str2 = c0198cm.b;
        jo joVar = this.f1150a.n;
        String str3 = c0198cm.d;
        joVar.getClass();
        if (!jo.a(str3)) {
            a2.f843a = this.f1150a.m.a().id;
        }
        String str4 = c0198cm.f788a;
        if (str4 == null || str4.length() == 0) {
            str = this.f1150a.h.a();
            str2 = "";
        }
        List<String> list = this.f1150a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0198cm c0198cm2 = new C0198cm(str, str2, new C0299gm(a2));
        b(c0198cm2);
        a(c0198cm2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r0 == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[Catch: all -> 0x005d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000d, B:11:0x0025, B:13:0x002d, B:15:0x0035, B:18:0x003e), top: B:28:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean g() {
        boolean z;
        boolean z2;
        C0198cm e = e();
        Set set = Zl.f742a;
        boolean z3 = false;
        z = true;
        if (!e.w) {
            if (Zl.b.currentTimeSeconds() <= e.o + e.A.f341a) {
                z2 = false;
                if (!z2) {
                    if (Zl.a(e.d) && Zl.a(e.f788a) && Zl.a(e.b)) {
                        z3 = true;
                    }
                    z2 = !z3;
                    Y3 y3 = this.f1150a.k;
                    Map map = d().h;
                    V3 v3 = this.f1150a.j;
                    y3.getClass();
                    boolean a2 = Y3.a(map, e, v3);
                    if (z3) {
                    }
                }
                z = z2;
            }
        }
        z2 = true;
        if (!z2) {
        }
        z = z2;
        return z;
    }

    public final synchronized void h() {
        this.b = null;
    }

    public final C0406l5 a() {
        return this.f1150a.f;
    }

    public final synchronized void b(C0198cm c0198cm) {
        this.f1150a.l.a(c0198cm);
        C0172bm c0172bm = this.f1150a.g;
        c0172bm.b.a(c0198cm.f788a);
        c0172bm.b.b(c0198cm.b);
        c0172bm.f772a.save(c0198cm.c);
        this.f1150a.e.a(c0198cm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !Zl.a(e(), list, map, new C0722xm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0198cm a(C0146am c0146am, Yl yl, long j) {
        String str;
        boolean equals;
        String a2 = Dm.a(yl.h);
        Map map = yl.i.f547a;
        String str2 = c0146am.j;
        String str3 = e().k;
        if (!Dm.a(Dm.a(str2))) {
            str2 = Dm.a(Dm.a(str3)) ? str3 : null;
        }
        String str4 = e().f788a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0146am.h;
        C0274fm c0274fm = new C0274fm(c0146am.b);
        String str5 = c0146am.i;
        c0274fm.o = this.f1150a.i.currentTimeSeconds();
        c0274fm.f843a = e().d;
        c0274fm.c = c0146am.d;
        c0274fm.f = c0146am.c;
        c0274fm.g = yl.e;
        c0274fm.b = c0146am.e;
        c0274fm.d = c0146am.f;
        c0274fm.e = c0146am.g;
        c0274fm.h = c0146am.n;
        c0274fm.i = c0146am.o;
        c0274fm.j = str2;
        c0274fm.k = a2;
        this.f1150a.k.getClass();
        HashMap a3 = Dm.a(str2);
        if (fo.a(map)) {
            equals = fo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0274fm.q = equals;
        c0274fm.l = Dm.a(map);
        c0274fm.r = c0146am.m;
        c0274fm.n = c0146am.k;
        c0274fm.s = c0146am.p;
        c0274fm.p = true;
        c0274fm.t = j;
        Yl d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0274fm.u = d.n;
        c0274fm.v = false;
        c0274fm.w = c0146am.q;
        c0274fm.y = c0146am.s;
        c0274fm.x = c0146am.r;
        c0274fm.z = c0146am.t;
        c0274fm.A = c0146am.u;
        c0274fm.B = c0146am.v;
        c0274fm.C = c0146am.w;
        return new C0198cm(str, str5, new C0299gm(c0274fm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0146am c0146am, Yl yl, Map<String, ? extends List<String>> map) {
        Long l;
        C0198cm a2;
        synchronized (this) {
            if (!fo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!fo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0222dk.f808a.a(longValue, c0146am.l);
                    a2 = a(c0146am, yl, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0222dk.f808a.a(longValue, c0146am.l);
            a2 = a(c0146am, yl, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0198cm c0198cm) {
        ArrayList arrayList;
        C0772zm c0772zm = this.f1150a;
        Cl cl = c0772zm.d;
        String str = c0772zm.b;
        synchronized (cl.f377a.b) {
            El el = cl.f377a;
            el.c = c0198cm;
            Collection collection = (Collection) el.f414a.f473a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Nl) it.next()).a(c0198cm);
        }
    }

    public final void a(Gl gl) {
        synchronized (this) {
            this.b = null;
        }
        C0772zm c0772zm = this.f1150a;
        c0772zm.d.a(c0772zm.f.f917a, gl, e());
    }

    public final synchronized void a(Wl wl) {
        this.f1150a.l.a(wl);
        Yl d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!fo.a(list, d.e)) {
                    C0198cm e = e();
                    C0299gm c0299gm = e.c;
                    C0274fm a2 = c0299gm.a(c0299gm.m);
                    String str = e.f788a;
                    String str2 = e.b;
                    a2.g = list;
                    C0198cm c0198cm = new C0198cm(str, str2, new C0299gm(a2));
                    b(c0198cm);
                    a(c0198cm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0198cm e2 = e();
                C0299gm c0299gm2 = e2.c;
                C0274fm a3 = c0299gm2.a(c0299gm2.m);
                String str3 = e2.f788a;
                String str4 = e2.b;
                a3.g = null;
                C0198cm c0198cm2 = new C0198cm(str3, str4, new C0299gm(a3));
                b(c0198cm2);
                a(c0198cm2);
            }
        }
    }
}

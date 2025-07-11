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
public final class C0739ym {

    /* renamed from: a  reason: collision with root package name */
    public final C0764zm f1151a;
    public volatile NetworkTask b;

    public C0739ym(C0764zm c0764zm) {
        this.f1151a = c0764zm;
    }

    public final Context b() {
        return this.f1151a.f1172a;
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
                    C0333ie c0333ie = C0333ie.f877a;
                    Ul ul = new Ul(new C0606te(), Ga.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new Q9(this.f1151a.f1172a), new AllHostsExponentialBackoffPolicy(C0333ie.f877a.a(EnumC0283ge.STARTUP)), new C0689wm(this, new Ol(), new FullUrlFormer(ul, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0333ie.c);
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
        return (Yl) this.f1151a.l.a();
    }

    public final C0190cm e() {
        C0190cm c0190cm;
        Fl fl = this.f1151a.l;
        synchronized (fl) {
            c0190cm = fl.c.f817a;
        }
        return c0190cm;
    }

    public final void f() {
        C0190cm c0190cm;
        Fl fl = this.f1151a.l;
        synchronized (fl) {
            c0190cm = fl.c.f817a;
        }
        C0291gm c0291gm = c0190cm.c;
        C0266fm a2 = c0291gm.a(c0291gm.m);
        String str = c0190cm.f789a;
        String str2 = c0190cm.b;
        jo joVar = this.f1151a.n;
        String str3 = c0190cm.d;
        joVar.getClass();
        if (!jo.a(str3)) {
            a2.f844a = this.f1151a.m.a().id;
        }
        String str4 = c0190cm.f789a;
        if (str4 == null || str4.length() == 0) {
            str = this.f1151a.h.a();
            str2 = "";
        }
        List<String> list = this.f1151a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0190cm c0190cm2 = new C0190cm(str, str2, new C0291gm(a2));
        b(c0190cm2);
        a(c0190cm2);
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
        C0190cm e = e();
        Set set = Zl.f743a;
        boolean z3 = false;
        z = true;
        if (!e.w) {
            if (Zl.b.currentTimeSeconds() <= e.o + e.A.f342a) {
                z2 = false;
                if (!z2) {
                    if (Zl.a(e.d) && Zl.a(e.f789a) && Zl.a(e.b)) {
                        z3 = true;
                    }
                    z2 = !z3;
                    Y3 y3 = this.f1151a.k;
                    Map map = d().h;
                    V3 v3 = this.f1151a.j;
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

    public final C0398l5 a() {
        return this.f1151a.f;
    }

    public final synchronized void b(C0190cm c0190cm) {
        this.f1151a.l.a(c0190cm);
        C0164bm c0164bm = this.f1151a.g;
        c0164bm.b.a(c0190cm.f789a);
        c0164bm.b.b(c0190cm.b);
        c0164bm.f773a.save(c0190cm.c);
        this.f1151a.e.a(c0190cm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !Zl.a(e(), list, map, new C0714xm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0190cm a(C0138am c0138am, Yl yl, long j) {
        String str;
        boolean equals;
        String a2 = Dm.a(yl.h);
        Map map = yl.i.f548a;
        String str2 = c0138am.j;
        String str3 = e().k;
        if (!Dm.a(Dm.a(str2))) {
            str2 = Dm.a(Dm.a(str3)) ? str3 : null;
        }
        String str4 = e().f789a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0138am.h;
        C0266fm c0266fm = new C0266fm(c0138am.b);
        String str5 = c0138am.i;
        c0266fm.o = this.f1151a.i.currentTimeSeconds();
        c0266fm.f844a = e().d;
        c0266fm.c = c0138am.d;
        c0266fm.f = c0138am.c;
        c0266fm.g = yl.e;
        c0266fm.b = c0138am.e;
        c0266fm.d = c0138am.f;
        c0266fm.e = c0138am.g;
        c0266fm.h = c0138am.n;
        c0266fm.i = c0138am.o;
        c0266fm.j = str2;
        c0266fm.k = a2;
        this.f1151a.k.getClass();
        HashMap a3 = Dm.a(str2);
        if (fo.a(map)) {
            equals = fo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0266fm.q = equals;
        c0266fm.l = Dm.a(map);
        c0266fm.r = c0138am.m;
        c0266fm.n = c0138am.k;
        c0266fm.s = c0138am.p;
        c0266fm.p = true;
        c0266fm.t = j;
        Yl d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0266fm.u = d.n;
        c0266fm.v = false;
        c0266fm.w = c0138am.q;
        c0266fm.y = c0138am.s;
        c0266fm.x = c0138am.r;
        c0266fm.z = c0138am.t;
        c0266fm.A = c0138am.u;
        c0266fm.B = c0138am.v;
        c0266fm.C = c0138am.w;
        return new C0190cm(str, str5, new C0291gm(c0266fm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0138am c0138am, Yl yl, Map<String, ? extends List<String>> map) {
        Long l;
        C0190cm a2;
        synchronized (this) {
            if (!fo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!fo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0214dk.f809a.a(longValue, c0138am.l);
                    a2 = a(c0138am, yl, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0214dk.f809a.a(longValue, c0138am.l);
            a2 = a(c0138am, yl, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0190cm c0190cm) {
        ArrayList arrayList;
        C0764zm c0764zm = this.f1151a;
        Cl cl = c0764zm.d;
        String str = c0764zm.b;
        synchronized (cl.f378a.b) {
            El el = cl.f378a;
            el.c = c0190cm;
            Collection collection = (Collection) el.f415a.f474a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Nl) it.next()).a(c0190cm);
        }
    }

    public final void a(Gl gl) {
        synchronized (this) {
            this.b = null;
        }
        C0764zm c0764zm = this.f1151a;
        c0764zm.d.a(c0764zm.f.f918a, gl, e());
    }

    public final synchronized void a(Wl wl) {
        this.f1151a.l.a(wl);
        Yl d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!fo.a(list, d.e)) {
                    C0190cm e = e();
                    C0291gm c0291gm = e.c;
                    C0266fm a2 = c0291gm.a(c0291gm.m);
                    String str = e.f789a;
                    String str2 = e.b;
                    a2.g = list;
                    C0190cm c0190cm = new C0190cm(str, str2, new C0291gm(a2));
                    b(c0190cm);
                    a(c0190cm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0190cm e2 = e();
                C0291gm c0291gm2 = e2.c;
                C0266fm a3 = c0291gm2.a(c0291gm2.m);
                String str3 = e2.f789a;
                String str4 = e2.b;
                a3.g = null;
                C0190cm c0190cm2 = new C0190cm(str3, str4, new C0291gm(a3));
                b(c0190cm2);
                a(c0190cm2);
            }
        }
    }
}

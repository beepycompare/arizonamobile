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
/* loaded from: classes5.dex */
public final class Bm {

    /* renamed from: a  reason: collision with root package name */
    public final Cm f415a;
    public volatile NetworkTask b;

    public Bm(Cm cm) {
        this.f415a = cm;
    }

    public final Context b() {
        return this.f415a.f437a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0176cm d = d();
                    Wd wd = Wd.f739a;
                    Yl yl = new Yl(new C0297he(), C0471oa.I.p());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new C0516q5(this.f415a.f437a), new AllHostsExponentialBackoffPolicy(Wd.f739a.a(Ud.STARTUP)), new C0757zm(this, new Sl(), new FullUrlFormer(yl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), Wd.c);
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

    public final C0176cm d() {
        return (C0176cm) this.f415a.l.a();
    }

    public final C0279gm e() {
        C0279gm c0279gm;
        Jl jl = this.f415a.l;
        synchronized (jl) {
            c0279gm = jl.c.f583a;
        }
        return c0279gm;
    }

    public final void f() {
        C0279gm c0279gm;
        Jl jl = this.f415a.l;
        synchronized (jl) {
            c0279gm = jl.c.f583a;
        }
        C0382km c0382km = c0279gm.c;
        C0356jm a2 = c0382km.a(c0382km.m);
        String str = c0279gm.f911a;
        String str2 = c0279gm.b;
        qo qoVar = this.f415a.n;
        String str3 = c0279gm.d;
        qoVar.getClass();
        if (!qo.a(str3)) {
            a2.f961a = this.f415a.m.a().id;
        }
        String str4 = c0279gm.f911a;
        if (str4 == null || str4.length() == 0) {
            str = this.f415a.h.a();
            str2 = "";
        }
        List<String> list = this.f415a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0279gm c0279gm2 = new C0279gm(str, str2, new C0382km(a2));
        b(c0279gm2);
        a(c0279gm2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0010, B:10:0x001b, B:16:0x0033, B:18:0x003b, B:20:0x0043, B:23:0x004c), top: B:33:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean g() {
        boolean z;
        boolean z2 = false;
        if (C0471oa.I.h().isRestrictedForSdk()) {
            return false;
        }
        C0279gm e = e();
        Set set = AbstractC0202dm.f857a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0202dm.b.currentTimeSeconds() <= e.o + e.z.f450a) {
                z = false;
                if (!z) {
                    if (AbstractC0202dm.a(e.d) && AbstractC0202dm.a(e.f911a) && AbstractC0202dm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    D3 d3 = this.f415a.k;
                    Map map = d().h;
                    A3 a3 = this.f415a.j;
                    d3.getClass();
                    boolean a2 = D3.a(map, e, a3);
                    if (z2) {
                    }
                }
                z3 = z;
                return z3;
            }
        }
        z = true;
        if (!z) {
        }
        z3 = z;
        return z3;
    }

    public final synchronized void h() {
        this.b = null;
    }

    public final R4 a() {
        return this.f415a.f;
    }

    public final synchronized void b(C0279gm c0279gm) {
        this.f415a.l.a(c0279gm);
        C0253fm c0253fm = this.f415a.g;
        c0253fm.b.a(c0279gm.f911a);
        c0253fm.b.b(c0279gm.b);
        c0253fm.f896a.save(c0279gm.c);
        this.f415a.e.a(c0279gm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0202dm.a(e(), list, map, new Am(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0279gm a(C0227em c0227em, C0176cm c0176cm, long j) {
        String str;
        boolean equals;
        String a2 = Gm.a(c0176cm.h);
        Map map = c0176cm.i.f1111a;
        String str2 = c0227em.j;
        String str3 = e().k;
        if (!Gm.a(Gm.a(str2))) {
            str2 = Gm.a(Gm.a(str3)) ? str3 : null;
        }
        String str4 = e().f911a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0227em.h;
        C0356jm c0356jm = new C0356jm(c0227em.b);
        String str5 = c0227em.i;
        c0356jm.o = this.f415a.i.currentTimeSeconds();
        c0356jm.f961a = e().d;
        c0356jm.c = c0227em.d;
        c0356jm.f = c0227em.c;
        c0356jm.g = c0176cm.e;
        c0356jm.b = c0227em.e;
        c0356jm.d = c0227em.f;
        c0356jm.e = c0227em.g;
        c0356jm.h = c0227em.n;
        c0356jm.i = c0227em.o;
        c0356jm.j = str2;
        c0356jm.k = a2;
        this.f415a.k.getClass();
        HashMap a3 = Gm.a(str2);
        if (mo.a(map)) {
            equals = mo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0356jm.q = equals;
        c0356jm.l = Gm.a(map);
        c0356jm.r = c0227em.m;
        c0356jm.n = c0227em.k;
        c0356jm.s = c0227em.p;
        c0356jm.p = true;
        c0356jm.t = j;
        C0176cm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0356jm.u = d.n;
        c0356jm.v = false;
        c0356jm.w = c0227em.q;
        c0356jm.x = c0227em.r;
        c0356jm.y = c0227em.s;
        c0356jm.z = c0227em.t;
        c0356jm.A = c0227em.u;
        c0356jm.B = c0227em.v;
        return new C0279gm(str, str5, new C0382km(c0356jm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0227em c0227em, C0176cm c0176cm, Map<String, ? extends List<String>> map) {
        Long l;
        C0279gm a2;
        synchronized (this) {
            if (!mo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!mo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    Xj.f752a.a(longValue, c0227em.l);
                    a2 = a(c0227em, c0176cm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            Xj.f752a.a(longValue, c0227em.l);
            a2 = a(c0227em, c0176cm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0279gm c0279gm) {
        ArrayList arrayList;
        Cm cm = this.f415a;
        Gl gl = cm.d;
        String str = cm.b;
        synchronized (gl.f496a.b) {
            Il il = gl.f496a;
            il.c = c0279gm;
            Collection collection = (Collection) il.f529a.f1085a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Rl) it.next()).a(c0279gm);
        }
    }

    public final void a(Kl kl) {
        synchronized (this) {
            this.b = null;
        }
        Cm cm = this.f415a;
        cm.d.a(cm.f.f659a, kl, e());
    }

    public final synchronized void a(C0124am c0124am) {
        this.f415a.l.a(c0124am);
        C0176cm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!mo.a(list, d.e)) {
                    C0279gm e = e();
                    C0382km c0382km = e.c;
                    C0356jm a2 = c0382km.a(c0382km.m);
                    String str = e.f911a;
                    String str2 = e.b;
                    a2.g = list;
                    C0279gm c0279gm = new C0279gm(str, str2, new C0382km(a2));
                    b(c0279gm);
                    a(c0279gm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0279gm e2 = e();
                C0382km c0382km2 = e2.c;
                C0356jm a3 = c0382km2.a(c0382km2.m);
                String str3 = e2.f911a;
                String str4 = e2.b;
                a3.g = null;
                C0279gm c0279gm2 = new C0279gm(str3, str4, new C0382km(a3));
                b(c0279gm2);
                a(c0279gm2);
            }
        }
    }
}

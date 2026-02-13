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
public final class Am {

    /* renamed from: a  reason: collision with root package name */
    public final Bm f503a;
    public volatile NetworkTask b;

    public Am(Bm bm) {
        this.f503a = bm;
    }

    public final Context b() {
        return this.f503a.f525a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0154bm d = d();
                    Vd vd = Vd.f827a;
                    Xl xl = new Xl(new C0275ge(), C0449na.I.p());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new C0494p5(this.f503a.f525a), new AllHostsExponentialBackoffPolicy(Vd.f827a.a(Td.STARTUP)), new C0735ym(this, new Rl(), new FullUrlFormer(xl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), Vd.c);
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

    public final C0154bm d() {
        return (C0154bm) this.f503a.l.a();
    }

    public final C0257fm e() {
        C0257fm c0257fm;
        Il il = this.f503a.l;
        synchronized (il) {
            c0257fm = il.c.f671a;
        }
        return c0257fm;
    }

    public final void f() {
        C0257fm c0257fm;
        Il il = this.f503a.l;
        synchronized (il) {
            c0257fm = il.c.f671a;
        }
        C0360jm c0360jm = c0257fm.c;
        C0334im a2 = c0360jm.a(c0360jm.m);
        String str = c0257fm.f999a;
        String str2 = c0257fm.b;
        po poVar = this.f503a.n;
        String str3 = c0257fm.d;
        poVar.getClass();
        if (!po.a(str3)) {
            a2.f1049a = this.f503a.m.a().id;
        }
        String str4 = c0257fm.f999a;
        if (str4 == null || str4.length() == 0) {
            str = this.f503a.h.a();
            str2 = "";
        }
        List<String> list = this.f503a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0257fm c0257fm2 = new C0257fm(str, str2, new C0360jm(a2));
        b(c0257fm2);
        a(c0257fm2);
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
        if (C0449na.I.h().isRestrictedForSdk()) {
            return false;
        }
        C0257fm e = e();
        Set set = AbstractC0180cm.f944a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0180cm.b.currentTimeSeconds() <= e.o + e.z.f539a) {
                z = false;
                if (!z) {
                    if (AbstractC0180cm.a(e.d) && AbstractC0180cm.a(e.f999a) && AbstractC0180cm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    C3 c3 = this.f503a.k;
                    Map map = d().h;
                    C0741z3 c0741z3 = this.f503a.j;
                    c3.getClass();
                    boolean a2 = C3.a(map, e, c0741z3);
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

    public final Q4 a() {
        return this.f503a.f;
    }

    public final synchronized void b(C0257fm c0257fm) {
        this.f503a.l.a(c0257fm);
        C0231em c0231em = this.f503a.g;
        c0231em.b.a(c0257fm.f999a);
        c0231em.b.b(c0257fm.b);
        c0231em.f983a.save(c0257fm.c);
        this.f503a.e.a(c0257fm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0180cm.a(e(), list, map, new C0760zm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0257fm a(C0206dm c0206dm, C0154bm c0154bm, long j) {
        String str;
        boolean equals;
        String a2 = Fm.a(c0154bm.h);
        Map map = c0154bm.i.f1199a;
        String str2 = c0206dm.j;
        String str3 = e().k;
        if (!Fm.a(Fm.a(str2))) {
            str2 = Fm.a(Fm.a(str3)) ? str3 : null;
        }
        String str4 = e().f999a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0206dm.h;
        C0334im c0334im = new C0334im(c0206dm.b);
        String str5 = c0206dm.i;
        c0334im.o = this.f503a.i.currentTimeSeconds();
        c0334im.f1049a = e().d;
        c0334im.c = c0206dm.d;
        c0334im.f = c0206dm.c;
        c0334im.g = c0154bm.e;
        c0334im.b = c0206dm.e;
        c0334im.d = c0206dm.f;
        c0334im.e = c0206dm.g;
        c0334im.h = c0206dm.n;
        c0334im.i = c0206dm.o;
        c0334im.j = str2;
        c0334im.k = a2;
        this.f503a.k.getClass();
        HashMap a3 = Fm.a(str2);
        if (lo.a(map)) {
            equals = lo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0334im.q = equals;
        c0334im.l = Fm.a(map);
        c0334im.r = c0206dm.m;
        c0334im.n = c0206dm.k;
        c0334im.s = c0206dm.p;
        c0334im.p = true;
        c0334im.t = j;
        C0154bm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0334im.u = d.n;
        c0334im.v = false;
        c0334im.w = c0206dm.q;
        c0334im.x = c0206dm.r;
        c0334im.y = c0206dm.s;
        c0334im.z = c0206dm.t;
        c0334im.A = c0206dm.u;
        c0334im.B = c0206dm.v;
        return new C0257fm(str, str5, new C0360jm(c0334im));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0206dm c0206dm, C0154bm c0154bm, Map<String, ? extends List<String>> map) {
        Long l;
        C0257fm a2;
        synchronized (this) {
            if (!lo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!lo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    Wj.f841a.a(longValue, c0206dm.l);
                    a2 = a(c0206dm, c0154bm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            Wj.f841a.a(longValue, c0206dm.l);
            a2 = a(c0206dm, c0154bm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0257fm c0257fm) {
        ArrayList arrayList;
        Bm bm = this.f503a;
        Fl fl = bm.d;
        String str = bm.b;
        synchronized (fl.f584a.b) {
            Hl hl = fl.f584a;
            hl.c = c0257fm;
            Collection collection = (Collection) hl.f618a.f1172a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(c0257fm);
        }
    }

    public final void a(Jl jl) {
        synchronized (this) {
            this.b = null;
        }
        Bm bm = this.f503a;
        bm.d.a(bm.f.f748a, jl, e());
    }

    public final synchronized void a(Zl zl) {
        this.f503a.l.a(zl);
        C0154bm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!lo.a(list, d.e)) {
                    C0257fm e = e();
                    C0360jm c0360jm = e.c;
                    C0334im a2 = c0360jm.a(c0360jm.m);
                    String str = e.f999a;
                    String str2 = e.b;
                    a2.g = list;
                    C0257fm c0257fm = new C0257fm(str, str2, new C0360jm(a2));
                    b(c0257fm);
                    a(c0257fm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0257fm e2 = e();
                C0360jm c0360jm2 = e2.c;
                C0334im a3 = c0360jm2.a(c0360jm2.m);
                String str3 = e2.f999a;
                String str4 = e2.b;
                a3.g = null;
                C0257fm c0257fm2 = new C0257fm(str3, str4, new C0360jm(a3));
                b(c0257fm2);
                a(c0257fm2);
            }
        }
    }
}

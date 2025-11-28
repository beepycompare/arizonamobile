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
public final class Em {

    /* renamed from: a  reason: collision with root package name */
    public final Fm f465a;
    public volatile NetworkTask b;

    public Em(Fm fm) {
        this.f465a = fm;
    }

    public final Context b() {
        return this.f465a.f479a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0253fm d = d();
                    C0168ce c0168ce = C0168ce.f829a;
                    C0150bm c0150bm = new C0150bm(new C0450ne(), C0620ua.H.p());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new C0665w5(this.f465a.f479a), new AllHostsExponentialBackoffPolicy(C0168ce.f829a.a(EnumC0116ae.STARTUP)), new Cm(this, new Vl(), new FullUrlFormer(c0150bm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0168ce.c);
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

    public final C0253fm d() {
        return (C0253fm) this.f465a.l.a();
    }

    public final C0356jm e() {
        C0356jm c0356jm;
        Ml ml = this.f465a.l;
        synchronized (ml) {
            c0356jm = ml.c.f677a;
        }
        return c0356jm;
    }

    public final void f() {
        C0356jm c0356jm;
        Ml ml = this.f465a.l;
        synchronized (ml) {
            c0356jm = ml.c.f677a;
        }
        C0458nm c0458nm = c0356jm.c;
        C0433mm a2 = c0458nm.a(c0458nm.m);
        String str = c0356jm.f959a;
        String str2 = c0356jm.b;
        ro roVar = this.f465a.n;
        String str3 = c0356jm.d;
        roVar.getClass();
        if (!ro.a(str3)) {
            a2.f1014a = this.f465a.m.a().id;
        }
        String str4 = c0356jm.f959a;
        if (str4 == null || str4.length() == 0) {
            str = this.f465a.h.a();
            str2 = "";
        }
        List<String> list = this.f465a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0356jm c0356jm2 = new C0356jm(str, str2, new C0458nm(a2));
        b(c0356jm2);
        a(c0356jm2);
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
        if (C0620ua.H.h().isRestrictedForSdk()) {
            return false;
        }
        C0356jm e = e();
        Set set = AbstractC0279gm.f901a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0279gm.b.currentTimeSeconds() <= e.o + e.z.f496a) {
                z = false;
                if (!z) {
                    if (AbstractC0279gm.a(e.d) && AbstractC0279gm.a(e.f959a) && AbstractC0279gm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    K3 k3 = this.f465a.k;
                    Map map = d().h;
                    H3 h3 = this.f465a.j;
                    k3.getClass();
                    boolean a2 = K3.a(map, e, h3);
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

    public final X4 a() {
        return this.f465a.f;
    }

    public final synchronized void b(C0356jm c0356jm) {
        this.f465a.l.a(c0356jm);
        C0330im c0330im = this.f465a.g;
        c0330im.b.a(c0356jm.f959a);
        c0330im.b.b(c0356jm.b);
        c0330im.f939a.save(c0356jm.c);
        this.f465a.e.a(c0356jm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0279gm.a(e(), list, map, new Dm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0356jm a(C0305hm c0305hm, C0253fm c0253fm, long j) {
        String str;
        boolean equals;
        String a2 = Jm.a(c0253fm.h);
        Map map = c0253fm.i.f1224a;
        String str2 = c0305hm.j;
        String str3 = e().k;
        if (!Jm.a(Jm.a(str2))) {
            str2 = Jm.a(Jm.a(str3)) ? str3 : null;
        }
        String str4 = e().f959a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0305hm.h;
        C0433mm c0433mm = new C0433mm(c0305hm.b);
        String str5 = c0305hm.i;
        c0433mm.o = this.f465a.i.currentTimeSeconds();
        c0433mm.f1014a = e().d;
        c0433mm.c = c0305hm.d;
        c0433mm.f = c0305hm.c;
        c0433mm.g = c0253fm.e;
        c0433mm.b = c0305hm.e;
        c0433mm.d = c0305hm.f;
        c0433mm.e = c0305hm.g;
        c0433mm.h = c0305hm.n;
        c0433mm.i = c0305hm.o;
        c0433mm.j = str2;
        c0433mm.k = a2;
        this.f465a.k.getClass();
        HashMap a3 = Jm.a(str2);
        if (no.a(map)) {
            equals = no.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0433mm.q = equals;
        c0433mm.l = Jm.a(map);
        c0433mm.r = c0305hm.m;
        c0433mm.n = c0305hm.k;
        c0433mm.s = c0305hm.p;
        c0433mm.p = true;
        c0433mm.t = j;
        C0253fm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0433mm.u = d.n;
        c0433mm.v = false;
        c0433mm.w = c0305hm.q;
        c0433mm.x = c0305hm.r;
        c0433mm.y = c0305hm.s;
        c0433mm.z = c0305hm.t;
        c0433mm.A = c0305hm.u;
        c0433mm.B = c0305hm.v;
        return new C0356jm(str, str5, new C0458nm(c0433mm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0305hm c0305hm, C0253fm c0253fm, Map<String, ? extends List<String>> map) {
        Long l;
        C0356jm a2;
        synchronized (this) {
            if (!no.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!no.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0148bk.f818a.a(longValue, c0305hm.l);
                    a2 = a(c0305hm, c0253fm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0148bk.f818a.a(longValue, c0305hm.l);
            a2 = a(c0305hm, c0253fm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0356jm c0356jm) {
        ArrayList arrayList;
        Fm fm = this.f465a;
        Jl jl = fm.d;
        String str = fm.b;
        synchronized (jl.f550a.b) {
            Ll ll = jl.f550a;
            ll.c = c0356jm;
            Collection collection = (Collection) ll.f580a.f1183a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ul) it.next()).a(c0356jm);
        }
    }

    public final void a(Nl nl) {
        synchronized (this) {
            this.b = null;
        }
        Fm fm = this.f465a;
        fm.d.a(fm.f.f752a, nl, e());
    }

    public final synchronized void a(C0202dm c0202dm) {
        this.f465a.l.a(c0202dm);
        C0253fm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!no.a(list, d.e)) {
                    C0356jm e = e();
                    C0458nm c0458nm = e.c;
                    C0433mm a2 = c0458nm.a(c0458nm.m);
                    String str = e.f959a;
                    String str2 = e.b;
                    a2.g = list;
                    C0356jm c0356jm = new C0356jm(str, str2, new C0458nm(a2));
                    b(c0356jm);
                    a(c0356jm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0356jm e2 = e();
                C0458nm c0458nm2 = e2.c;
                C0433mm a3 = c0458nm2.a(c0458nm2.m);
                String str3 = e2.f959a;
                String str4 = e2.b;
                a3.g = null;
                C0356jm c0356jm2 = new C0356jm(str3, str4, new C0458nm(a3));
                b(c0356jm2);
                a(c0356jm2);
            }
        }
    }
}

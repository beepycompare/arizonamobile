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
    public final Cm f498a;
    public volatile NetworkTask b;

    public Bm(Cm cm) {
        this.f498a = cm;
    }

    public final Context b() {
        return this.f498a.f520a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0175cm d = d();
                    Wd wd = Wd.f822a;
                    Yl yl = new Yl(new C0296he(), C0470oa.I.p());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new C0515q5(this.f498a.f520a), new AllHostsExponentialBackoffPolicy(Wd.f822a.a(Ud.STARTUP)), new C0756zm(this, new Sl(), new FullUrlFormer(yl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), Wd.c);
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

    public final C0175cm d() {
        return (C0175cm) this.f498a.l.a();
    }

    public final C0278gm e() {
        C0278gm c0278gm;
        Jl jl = this.f498a.l;
        synchronized (jl) {
            c0278gm = jl.c.f666a;
        }
        return c0278gm;
    }

    public final void f() {
        C0278gm c0278gm;
        Jl jl = this.f498a.l;
        synchronized (jl) {
            c0278gm = jl.c.f666a;
        }
        C0381km c0381km = c0278gm.c;
        C0355jm a2 = c0381km.a(c0381km.m);
        String str = c0278gm.f994a;
        String str2 = c0278gm.b;
        qo qoVar = this.f498a.n;
        String str3 = c0278gm.d;
        qoVar.getClass();
        if (!qo.a(str3)) {
            a2.f1044a = this.f498a.m.a().id;
        }
        String str4 = c0278gm.f994a;
        if (str4 == null || str4.length() == 0) {
            str = this.f498a.h.a();
            str2 = "";
        }
        List<String> list = this.f498a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0278gm c0278gm2 = new C0278gm(str, str2, new C0381km(a2));
        b(c0278gm2);
        a(c0278gm2);
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
        if (C0470oa.I.h().isRestrictedForSdk()) {
            return false;
        }
        C0278gm e = e();
        Set set = AbstractC0201dm.f940a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0201dm.b.currentTimeSeconds() <= e.o + e.z.f533a) {
                z = false;
                if (!z) {
                    if (AbstractC0201dm.a(e.d) && AbstractC0201dm.a(e.f994a) && AbstractC0201dm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    D3 d3 = this.f498a.k;
                    Map map = d().h;
                    A3 a3 = this.f498a.j;
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
        return this.f498a.f;
    }

    public final synchronized void b(C0278gm c0278gm) {
        this.f498a.l.a(c0278gm);
        C0252fm c0252fm = this.f498a.g;
        c0252fm.b.a(c0278gm.f994a);
        c0252fm.b.b(c0278gm.b);
        c0252fm.f979a.save(c0278gm.c);
        this.f498a.e.a(c0278gm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0201dm.a(e(), list, map, new Am(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0278gm a(C0226em c0226em, C0175cm c0175cm, long j) {
        String str;
        boolean equals;
        String a2 = Gm.a(c0175cm.h);
        Map map = c0175cm.i.f1194a;
        String str2 = c0226em.j;
        String str3 = e().k;
        if (!Gm.a(Gm.a(str2))) {
            str2 = Gm.a(Gm.a(str3)) ? str3 : null;
        }
        String str4 = e().f994a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0226em.h;
        C0355jm c0355jm = new C0355jm(c0226em.b);
        String str5 = c0226em.i;
        c0355jm.o = this.f498a.i.currentTimeSeconds();
        c0355jm.f1044a = e().d;
        c0355jm.c = c0226em.d;
        c0355jm.f = c0226em.c;
        c0355jm.g = c0175cm.e;
        c0355jm.b = c0226em.e;
        c0355jm.d = c0226em.f;
        c0355jm.e = c0226em.g;
        c0355jm.h = c0226em.n;
        c0355jm.i = c0226em.o;
        c0355jm.j = str2;
        c0355jm.k = a2;
        this.f498a.k.getClass();
        HashMap a3 = Gm.a(str2);
        if (mo.a(map)) {
            equals = mo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0355jm.q = equals;
        c0355jm.l = Gm.a(map);
        c0355jm.r = c0226em.m;
        c0355jm.n = c0226em.k;
        c0355jm.s = c0226em.p;
        c0355jm.p = true;
        c0355jm.t = j;
        C0175cm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0355jm.u = d.n;
        c0355jm.v = false;
        c0355jm.w = c0226em.q;
        c0355jm.x = c0226em.r;
        c0355jm.y = c0226em.s;
        c0355jm.z = c0226em.t;
        c0355jm.A = c0226em.u;
        c0355jm.B = c0226em.v;
        return new C0278gm(str, str5, new C0381km(c0355jm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0226em c0226em, C0175cm c0175cm, Map<String, ? extends List<String>> map) {
        Long l;
        C0278gm a2;
        synchronized (this) {
            if (!mo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!mo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    Xj.f835a.a(longValue, c0226em.l);
                    a2 = a(c0226em, c0175cm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            Xj.f835a.a(longValue, c0226em.l);
            a2 = a(c0226em, c0175cm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0278gm c0278gm) {
        ArrayList arrayList;
        Cm cm = this.f498a;
        Gl gl = cm.d;
        String str = cm.b;
        synchronized (gl.f579a.b) {
            Il il = gl.f579a;
            il.c = c0278gm;
            Collection collection = (Collection) il.f612a.f1168a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Rl) it.next()).a(c0278gm);
        }
    }

    public final void a(Kl kl) {
        synchronized (this) {
            this.b = null;
        }
        Cm cm = this.f498a;
        cm.d.a(cm.f.f742a, kl, e());
    }

    public final synchronized void a(C0123am c0123am) {
        this.f498a.l.a(c0123am);
        C0175cm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!mo.a(list, d.e)) {
                    C0278gm e = e();
                    C0381km c0381km = e.c;
                    C0355jm a2 = c0381km.a(c0381km.m);
                    String str = e.f994a;
                    String str2 = e.b;
                    a2.g = list;
                    C0278gm c0278gm = new C0278gm(str, str2, new C0381km(a2));
                    b(c0278gm);
                    a(c0278gm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0278gm e2 = e();
                C0381km c0381km2 = e2.c;
                C0355jm a3 = c0381km2.a(c0381km2.m);
                String str3 = e2.f994a;
                String str4 = e2.b;
                a3.g = null;
                C0278gm c0278gm2 = new C0278gm(str3, str4, new C0381km(a3));
                b(c0278gm2);
                a(c0278gm2);
            }
        }
    }
}

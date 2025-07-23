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
/* loaded from: classes4.dex */
public final class Bm {

    /* renamed from: a  reason: collision with root package name */
    public final Cm f363a;
    public volatile NetworkTask b;

    public Bm(Cm cm) {
        this.f363a = cm;
    }

    public final Context b() {
        return this.f363a.f383a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0164bm d = d();
                    C0384ke c0384ke = C0384ke.f925a;
                    Xl xl = new Xl(new C0658ve(), Ia.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new K5(this.f363a.f383a), new AllHostsExponentialBackoffPolicy(C0384ke.f925a.a(EnumC0335ie.STARTUP)), new C0766zm(this, new Rl(), new FullUrlFormer(xl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0384ke.c);
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

    public final C0164bm d() {
        return (C0164bm) this.f363a.l.a();
    }

    public final C0267fm e() {
        C0267fm c0267fm;
        Il il = this.f363a.l;
        synchronized (il) {
            c0267fm = il.c.f878a;
        }
        return c0267fm;
    }

    public final void f() {
        C0267fm c0267fm;
        Il il = this.f363a.l;
        synchronized (il) {
            c0267fm = il.c.f878a;
        }
        C0367jm c0367jm = c0267fm.c;
        C0342im a2 = c0367jm.a(c0367jm.m);
        String str = c0267fm.f851a;
        String str2 = c0267fm.b;
        mo moVar = this.f363a.n;
        String str3 = c0267fm.d;
        moVar.getClass();
        if (!mo.a(str3)) {
            a2.f905a = this.f363a.m.a().id;
        }
        String str4 = c0267fm.f851a;
        if (str4 == null || str4.length() == 0) {
            str = this.f363a.h.a();
            str2 = "";
        }
        List<String> list = this.f363a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0267fm c0267fm2 = new C0267fm(str, str2, new C0367jm(a2));
        b(c0267fm2);
        a(c0267fm2);
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
        if (Ia.F.g().isRestrictedForSdk()) {
            return false;
        }
        C0267fm e = e();
        Set set = AbstractC0190cm.f803a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0190cm.b.currentTimeSeconds() <= e.o + e.A.f402a) {
                z = false;
                if (!z) {
                    if (AbstractC0190cm.a(e.d) && AbstractC0190cm.a(e.f851a) && AbstractC0190cm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    Y3 y3 = this.f363a.k;
                    Map map = d().h;
                    V3 v3 = this.f363a.j;
                    y3.getClass();
                    boolean a2 = Y3.a(map, e, v3);
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

    public final C0400l5 a() {
        return this.f363a.f;
    }

    public final synchronized void b(C0267fm c0267fm) {
        this.f363a.l.a(c0267fm);
        C0241em c0241em = this.f363a.g;
        c0241em.b.a(c0267fm.f851a);
        c0241em.b.b(c0267fm.b);
        c0241em.f834a.save(c0267fm.c);
        this.f363a.e.a(c0267fm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0190cm.a(e(), list, map, new Am(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0267fm a(C0216dm c0216dm, C0164bm c0164bm, long j) {
        String str;
        boolean equals;
        String a2 = Gm.a(c0164bm.h);
        Map map = c0164bm.i.f558a;
        String str2 = c0216dm.j;
        String str3 = e().k;
        if (!Gm.a(Gm.a(str2))) {
            str2 = Gm.a(Gm.a(str3)) ? str3 : null;
        }
        String str4 = e().f851a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0216dm.h;
        C0342im c0342im = new C0342im(c0216dm.b);
        String str5 = c0216dm.i;
        c0342im.o = this.f363a.i.currentTimeSeconds();
        c0342im.f905a = e().d;
        c0342im.c = c0216dm.d;
        c0342im.f = c0216dm.c;
        c0342im.g = c0164bm.e;
        c0342im.b = c0216dm.e;
        c0342im.d = c0216dm.f;
        c0342im.e = c0216dm.g;
        c0342im.h = c0216dm.n;
        c0342im.i = c0216dm.o;
        c0342im.j = str2;
        c0342im.k = a2;
        this.f363a.k.getClass();
        HashMap a3 = Gm.a(str2);
        if (io.a(map)) {
            equals = io.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0342im.q = equals;
        c0342im.l = Gm.a(map);
        c0342im.r = c0216dm.m;
        c0342im.n = c0216dm.k;
        c0342im.s = c0216dm.p;
        c0342im.p = true;
        c0342im.t = j;
        C0164bm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0342im.u = d.n;
        c0342im.v = false;
        c0342im.w = c0216dm.q;
        c0342im.y = c0216dm.s;
        c0342im.x = c0216dm.r;
        c0342im.z = c0216dm.t;
        c0342im.A = c0216dm.u;
        c0342im.B = c0216dm.v;
        c0342im.C = c0216dm.w;
        return new C0267fm(str, str5, new C0367jm(c0342im));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0216dm c0216dm, C0164bm c0164bm, Map<String, ? extends List<String>> map) {
        Long l;
        C0267fm a2;
        synchronized (this) {
            if (!io.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!io.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0291gk.f869a.a(longValue, c0216dm.l);
                    a2 = a(c0216dm, c0164bm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0291gk.f869a.a(longValue, c0216dm.l);
            a2 = a(c0216dm, c0164bm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0267fm c0267fm) {
        ArrayList arrayList;
        Cm cm = this.f363a;
        Fl fl = cm.d;
        String str = cm.b;
        synchronized (fl.f440a.b) {
            Hl hl = fl.f440a;
            hl.c = c0267fm;
            Collection collection = (Collection) hl.f476a.f519a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(c0267fm);
        }
    }

    public final void a(Jl jl) {
        synchronized (this) {
            this.b = null;
        }
        Cm cm = this.f363a;
        cm.d.a(cm.f.f934a, jl, e());
    }

    public final synchronized void a(Zl zl) {
        this.f363a.l.a(zl);
        C0164bm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!io.a(list, d.e)) {
                    C0267fm e = e();
                    C0367jm c0367jm = e.c;
                    C0342im a2 = c0367jm.a(c0367jm.m);
                    String str = e.f851a;
                    String str2 = e.b;
                    a2.g = list;
                    C0267fm c0267fm = new C0267fm(str, str2, new C0367jm(a2));
                    b(c0267fm);
                    a(c0267fm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0267fm e2 = e();
                C0367jm c0367jm2 = e2.c;
                C0342im a3 = c0367jm2.a(c0367jm2.m);
                String str3 = e2.f851a;
                String str4 = e2.b;
                a3.g = null;
                C0267fm c0267fm2 = new C0267fm(str3, str4, new C0367jm(a3));
                b(c0267fm2);
                a(c0267fm2);
            }
        }
    }
}

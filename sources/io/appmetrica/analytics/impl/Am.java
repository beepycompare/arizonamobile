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
    public final Bm f508a;
    public volatile NetworkTask b;

    public Am(Bm bm) {
        this.f508a = bm;
    }

    public final Context b() {
        return this.f508a.f530a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            if (g()) {
                networkTask = this.b;
                if (networkTask == null || networkTask.isRemoved()) {
                    C0153bm d = d();
                    Vd vd = Vd.f832a;
                    Xl xl = new Xl(new C0274ge(), C0448na.I.p());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    SynchronizedBlockingExecutor synchronizedBlockingExecutor = new SynchronizedBlockingExecutor();
                    C0493p5 c0493p5 = new C0493p5(this.f508a.f530a);
                    AllHostsExponentialBackoffPolicy allHostsExponentialBackoffPolicy = new AllHostsExponentialBackoffPolicy(Vd.f832a.a(Td.STARTUP));
                    try {
                        C0734ym c0734ym = new C0734ym(this, new Rl(), new FullUrlFormer(xl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider);
                        this = this;
                        NetworkTask networkTask2 = new NetworkTask(synchronizedBlockingExecutor, c0493p5, allHostsExponentialBackoffPolicy, c0734ym, CollectionsKt.emptyList(), Vd.c);
                        this.b = networkTask2;
                        networkTask = networkTask2;
                    } catch (Throwable th) {
                        th = th;
                        this = this;
                        throw th;
                    }
                }
            } else {
                networkTask = null;
            }
            return networkTask;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final C0153bm d() {
        return (C0153bm) this.f508a.l.a();
    }

    public final C0256fm e() {
        C0256fm c0256fm;
        Il il = this.f508a.l;
        synchronized (il) {
            c0256fm = il.c.f676a;
        }
        return c0256fm;
    }

    public final void f() {
        C0256fm c0256fm;
        Il il = this.f508a.l;
        synchronized (il) {
            c0256fm = il.c.f676a;
        }
        C0359jm c0359jm = c0256fm.c;
        C0333im a2 = c0359jm.a(c0359jm.m);
        String str = c0256fm.f1004a;
        String str2 = c0256fm.b;
        po poVar = this.f508a.n;
        String str3 = c0256fm.d;
        poVar.getClass();
        if (!po.a(str3)) {
            a2.f1054a = this.f508a.m.a().id;
        }
        String str4 = c0256fm.f1004a;
        if (str4 == null || str4.length() == 0) {
            str = this.f508a.h.a();
            str2 = "";
        }
        List<String> list = this.f508a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0256fm c0256fm2 = new C0256fm(str, str2, new C0359jm(a2));
        b(c0256fm2);
        a(c0256fm2);
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
        if (C0448na.I.h().isRestrictedForSdk()) {
            return false;
        }
        C0256fm e = e();
        Set set = AbstractC0179cm.f949a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0179cm.b.currentTimeSeconds() <= e.o + e.z.f544a) {
                z = false;
                if (!z) {
                    if (AbstractC0179cm.a(e.d) && AbstractC0179cm.a(e.f1004a) && AbstractC0179cm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    C3 c3 = this.f508a.k;
                    Map map = d().h;
                    C0740z3 c0740z3 = this.f508a.j;
                    c3.getClass();
                    boolean a2 = C3.a(map, e, c0740z3);
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
        return this.f508a.f;
    }

    public final synchronized void b(C0256fm c0256fm) {
        this.f508a.l.a(c0256fm);
        C0230em c0230em = this.f508a.g;
        c0230em.b.a(c0256fm.f1004a);
        c0230em.b.b(c0256fm.b);
        c0230em.f988a.save(c0256fm.c);
        this.f508a.e.a(c0256fm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0179cm.a(e(), list, map, new C0759zm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0256fm a(C0205dm c0205dm, C0153bm c0153bm, long j) {
        String str;
        boolean equals;
        String a2 = Fm.a(c0153bm.h);
        Map map = c0153bm.i.f1204a;
        String str2 = c0205dm.j;
        String str3 = e().k;
        if (!Fm.a(Fm.a(str2))) {
            str2 = Fm.a(Fm.a(str3)) ? str3 : null;
        }
        String str4 = e().f1004a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0205dm.h;
        C0333im c0333im = new C0333im(c0205dm.b);
        String str5 = c0205dm.i;
        c0333im.o = this.f508a.i.currentTimeSeconds();
        c0333im.f1054a = e().d;
        c0333im.c = c0205dm.d;
        c0333im.f = c0205dm.c;
        c0333im.g = c0153bm.e;
        c0333im.b = c0205dm.e;
        c0333im.d = c0205dm.f;
        c0333im.e = c0205dm.g;
        c0333im.h = c0205dm.n;
        c0333im.i = c0205dm.o;
        c0333im.j = str2;
        c0333im.k = a2;
        this.f508a.k.getClass();
        HashMap a3 = Fm.a(str2);
        if (lo.a(map)) {
            equals = lo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0333im.q = equals;
        c0333im.l = Fm.a(map);
        c0333im.r = c0205dm.m;
        c0333im.n = c0205dm.k;
        c0333im.s = c0205dm.p;
        c0333im.p = true;
        c0333im.t = j;
        C0153bm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0333im.u = d.n;
        c0333im.v = false;
        c0333im.w = c0205dm.q;
        c0333im.x = c0205dm.r;
        c0333im.y = c0205dm.s;
        c0333im.z = c0205dm.t;
        c0333im.A = c0205dm.u;
        c0333im.B = c0205dm.v;
        return new C0256fm(str, str5, new C0359jm(c0333im));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0205dm c0205dm, C0153bm c0153bm, Map<String, ? extends List<String>> map) {
        Long l;
        C0256fm a2;
        synchronized (this) {
            if (!lo.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!lo.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    Wj.f846a.a(longValue, c0205dm.l);
                    a2 = a(c0205dm, c0153bm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            Wj.f846a.a(longValue, c0205dm.l);
            a2 = a(c0205dm, c0153bm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0256fm c0256fm) {
        ArrayList arrayList;
        Bm bm = this.f508a;
        Fl fl = bm.d;
        String str = bm.b;
        synchronized (fl.f589a.b) {
            Hl hl = fl.f589a;
            hl.c = c0256fm;
            Collection collection = (Collection) hl.f623a.f1177a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(c0256fm);
        }
    }

    public final void a(Jl jl) {
        synchronized (this) {
            this.b = null;
        }
        Bm bm = this.f508a;
        bm.d.a(bm.f.f753a, jl, e());
    }

    public final synchronized void a(Zl zl) {
        this.f508a.l.a(zl);
        C0153bm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!lo.a(list, d.e)) {
                    C0256fm e = e();
                    C0359jm c0359jm = e.c;
                    C0333im a2 = c0359jm.a(c0359jm.m);
                    String str = e.f1004a;
                    String str2 = e.b;
                    a2.g = list;
                    C0256fm c0256fm = new C0256fm(str, str2, new C0359jm(a2));
                    b(c0256fm);
                    a(c0256fm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0256fm e2 = e();
                C0359jm c0359jm2 = e2.c;
                C0333im a3 = c0359jm2.a(c0359jm2.m);
                String str3 = e2.f1004a;
                String str4 = e2.b;
                a3.g = null;
                C0256fm c0256fm2 = new C0256fm(str3, str4, new C0359jm(a3));
                b(c0256fm2);
                a(c0256fm2);
            }
        }
    }
}

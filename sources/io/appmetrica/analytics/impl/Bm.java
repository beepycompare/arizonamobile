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
                    C0165bm d = d();
                    C0385ke c0385ke = C0385ke.f925a;
                    Xl xl = new Xl(new C0659ve(), Ia.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new K5(this.f363a.f383a), new AllHostsExponentialBackoffPolicy(C0385ke.f925a.a(EnumC0336ie.STARTUP)), new C0767zm(this, new Rl(), new FullUrlFormer(xl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0385ke.c);
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

    public final C0165bm d() {
        return (C0165bm) this.f363a.l.a();
    }

    public final C0268fm e() {
        C0268fm c0268fm;
        Il il = this.f363a.l;
        synchronized (il) {
            c0268fm = il.c.f878a;
        }
        return c0268fm;
    }

    public final void f() {
        C0268fm c0268fm;
        Il il = this.f363a.l;
        synchronized (il) {
            c0268fm = il.c.f878a;
        }
        C0368jm c0368jm = c0268fm.c;
        C0343im a2 = c0368jm.a(c0368jm.m);
        String str = c0268fm.f851a;
        String str2 = c0268fm.b;
        mo moVar = this.f363a.n;
        String str3 = c0268fm.d;
        moVar.getClass();
        if (!mo.a(str3)) {
            a2.f905a = this.f363a.m.a().id;
        }
        String str4 = c0268fm.f851a;
        if (str4 == null || str4.length() == 0) {
            str = this.f363a.h.a();
            str2 = "";
        }
        List<String> list = this.f363a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0268fm c0268fm2 = new C0268fm(str, str2, new C0368jm(a2));
        b(c0268fm2);
        a(c0268fm2);
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
        C0268fm e = e();
        Set set = AbstractC0191cm.f803a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0191cm.b.currentTimeSeconds() <= e.o + e.A.f402a) {
                z = false;
                if (!z) {
                    if (AbstractC0191cm.a(e.d) && AbstractC0191cm.a(e.f851a) && AbstractC0191cm.a(e.b)) {
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

    public final C0401l5 a() {
        return this.f363a.f;
    }

    public final synchronized void b(C0268fm c0268fm) {
        this.f363a.l.a(c0268fm);
        C0242em c0242em = this.f363a.g;
        c0242em.b.a(c0268fm.f851a);
        c0242em.b.b(c0268fm.b);
        c0242em.f834a.save(c0268fm.c);
        this.f363a.e.a(c0268fm);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0191cm.a(e(), list, map, new Am(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0268fm a(C0217dm c0217dm, C0165bm c0165bm, long j) {
        String str;
        boolean equals;
        String a2 = Gm.a(c0165bm.h);
        Map map = c0165bm.i.f558a;
        String str2 = c0217dm.j;
        String str3 = e().k;
        if (!Gm.a(Gm.a(str2))) {
            str2 = Gm.a(Gm.a(str3)) ? str3 : null;
        }
        String str4 = e().f851a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0217dm.h;
        C0343im c0343im = new C0343im(c0217dm.b);
        String str5 = c0217dm.i;
        c0343im.o = this.f363a.i.currentTimeSeconds();
        c0343im.f905a = e().d;
        c0343im.c = c0217dm.d;
        c0343im.f = c0217dm.c;
        c0343im.g = c0165bm.e;
        c0343im.b = c0217dm.e;
        c0343im.d = c0217dm.f;
        c0343im.e = c0217dm.g;
        c0343im.h = c0217dm.n;
        c0343im.i = c0217dm.o;
        c0343im.j = str2;
        c0343im.k = a2;
        this.f363a.k.getClass();
        HashMap a3 = Gm.a(str2);
        if (io.a(map)) {
            equals = io.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0343im.q = equals;
        c0343im.l = Gm.a(map);
        c0343im.r = c0217dm.m;
        c0343im.n = c0217dm.k;
        c0343im.s = c0217dm.p;
        c0343im.p = true;
        c0343im.t = j;
        C0165bm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0343im.u = d.n;
        c0343im.v = false;
        c0343im.w = c0217dm.q;
        c0343im.y = c0217dm.s;
        c0343im.x = c0217dm.r;
        c0343im.z = c0217dm.t;
        c0343im.A = c0217dm.u;
        c0343im.B = c0217dm.v;
        c0343im.C = c0217dm.w;
        return new C0268fm(str, str5, new C0368jm(c0343im));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0217dm c0217dm, C0165bm c0165bm, Map<String, ? extends List<String>> map) {
        Long l;
        C0268fm a2;
        synchronized (this) {
            if (!io.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!io.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0292gk.f869a.a(longValue, c0217dm.l);
                    a2 = a(c0217dm, c0165bm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0292gk.f869a.a(longValue, c0217dm.l);
            a2 = a(c0217dm, c0165bm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0268fm c0268fm) {
        ArrayList arrayList;
        Cm cm = this.f363a;
        Fl fl = cm.d;
        String str = cm.b;
        synchronized (fl.f440a.b) {
            Hl hl = fl.f440a;
            hl.c = c0268fm;
            Collection collection = (Collection) hl.f476a.f519a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(c0268fm);
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
        C0165bm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!io.a(list, d.e)) {
                    C0268fm e = e();
                    C0368jm c0368jm = e.c;
                    C0343im a2 = c0368jm.a(c0368jm.m);
                    String str = e.f851a;
                    String str2 = e.b;
                    a2.g = list;
                    C0268fm c0268fm = new C0268fm(str, str2, new C0368jm(a2));
                    b(c0268fm);
                    a(c0268fm);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0268fm e2 = e();
                C0368jm c0368jm2 = e2.c;
                C0343im a3 = c0368jm2.a(c0368jm2.m);
                String str3 = e2.f851a;
                String str4 = e2.b;
                a3.g = null;
                C0268fm c0268fm2 = new C0268fm(str3, str4, new C0368jm(a3));
                b(c0268fm2);
                a(c0268fm2);
            }
        }
    }
}

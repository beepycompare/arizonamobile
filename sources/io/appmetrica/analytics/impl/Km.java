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
public final class Km {

    /* renamed from: a  reason: collision with root package name */
    public final Lm f545a;
    public volatile NetworkTask b;

    public Km(Lm lm) {
        this.f545a = lm;
    }

    public final Context b() {
        return this.f545a.f565a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0390km d = d();
                    C0537qe c0537qe = C0537qe.f1050a;
                    C0287gm c0287gm = new C0287gm(new Be(), Na.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new N5(this.f545a.f565a), new AllHostsExponentialBackoffPolicy(C0537qe.f1050a.a(EnumC0486oe.STARTUP)), new Im(this, new C0132am(), new FullUrlFormer(c0287gm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0537qe.c);
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

    public final C0390km d() {
        return (C0390km) this.f545a.l.a();
    }

    public final C0494om e() {
        C0494om c0494om;
        Rl rl = this.f545a.l;
        synchronized (rl) {
            c0494om = rl.c.f950a;
        }
        return c0494om;
    }

    public final void f() {
        C0494om c0494om;
        Rl rl = this.f545a.l;
        synchronized (rl) {
            c0494om = rl.c.f950a;
        }
        C0594sm c0594sm = c0494om.c;
        C0569rm a2 = c0594sm.a(c0594sm.m);
        String str = c0494om.f1025a;
        String str2 = c0494om.b;
        vo voVar = this.f545a.n;
        String str3 = c0494om.d;
        voVar.getClass();
        if (!vo.a(str3)) {
            a2.f1072a = this.f545a.m.a().id;
        }
        String str4 = c0494om.f1025a;
        if (str4 == null || str4.length() == 0) {
            str = this.f545a.h.a();
            str2 = "";
        }
        List<String> list = this.f545a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0494om c0494om2 = new C0494om(str, str2, new C0594sm(a2));
        b(c0494om2);
        a(c0494om2);
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
        if (Na.F.g().isRestrictedForSdk()) {
            return false;
        }
        C0494om e = e();
        Set set = AbstractC0416lm.f979a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0416lm.b.currentTimeSeconds() <= e.o + e.A.f583a) {
                z = false;
                if (!z) {
                    if (AbstractC0416lm.a(e.d) && AbstractC0416lm.a(e.f1025a) && AbstractC0416lm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    C0140b4 c0140b4 = this.f545a.k;
                    Map map = d().h;
                    Y3 y3 = this.f545a.j;
                    c0140b4.getClass();
                    boolean a2 = C0140b4.a(map, e, y3);
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

    public final C0477o5 a() {
        return this.f545a.f;
    }

    public final synchronized void b(C0494om c0494om) {
        this.f545a.l.a(c0494om);
        C0468nm c0468nm = this.f545a.g;
        c0468nm.b.a(c0494om.f1025a);
        c0468nm.b.b(c0494om.b);
        c0468nm.f1009a.save(c0494om.c);
        this.f545a.e.a(c0494om);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0416lm.a(e(), list, map, new Jm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0494om a(C0442mm c0442mm, C0390km c0390km, long j) {
        String str;
        boolean equals;
        String a2 = Pm.a(c0390km.h);
        Map map = c0390km.i.f635a;
        String str2 = c0442mm.j;
        String str3 = e().k;
        if (!Pm.a(Pm.a(str2))) {
            str2 = Pm.a(Pm.a(str3)) ? str3 : null;
        }
        String str4 = e().f1025a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0442mm.h;
        C0569rm c0569rm = new C0569rm(c0442mm.b);
        String str5 = c0442mm.i;
        c0569rm.o = this.f545a.i.currentTimeSeconds();
        c0569rm.f1072a = e().d;
        c0569rm.c = c0442mm.d;
        c0569rm.f = c0442mm.c;
        c0569rm.g = c0390km.e;
        c0569rm.b = c0442mm.e;
        c0569rm.d = c0442mm.f;
        c0569rm.e = c0442mm.g;
        c0569rm.h = c0442mm.n;
        c0569rm.i = c0442mm.o;
        c0569rm.j = str2;
        c0569rm.k = a2;
        this.f545a.k.getClass();
        HashMap a3 = Pm.a(str2);
        if (ro.a(map)) {
            equals = ro.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0569rm.q = equals;
        c0569rm.l = Pm.a(map);
        c0569rm.r = c0442mm.m;
        c0569rm.n = c0442mm.k;
        c0569rm.s = c0442mm.p;
        c0569rm.p = true;
        c0569rm.t = j;
        C0390km d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0569rm.u = d.n;
        c0569rm.v = false;
        c0569rm.w = c0442mm.q;
        c0569rm.y = c0442mm.s;
        c0569rm.x = c0442mm.r;
        c0569rm.z = c0442mm.t;
        c0569rm.A = c0442mm.u;
        c0569rm.B = c0442mm.v;
        c0569rm.C = c0442mm.w;
        return new C0494om(str, str5, new C0594sm(c0569rm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0442mm c0442mm, C0390km c0390km, Map<String, ? extends List<String>> map) {
        Long l;
        C0494om a2;
        synchronized (this) {
            if (!ro.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!ro.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0518pk.f1038a.a(longValue, c0442mm.l);
                    a2 = a(c0442mm, c0390km, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0518pk.f1038a.a(longValue, c0442mm.l);
            a2 = a(c0442mm, c0390km, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0494om c0494om) {
        ArrayList arrayList;
        Lm lm = this.f545a;
        Ol ol = lm.d;
        String str = lm.b;
        synchronized (ol.f614a.b) {
            Ql ql = ol.f614a;
            ql.c = c0494om;
            Collection collection = (Collection) ql.f645a.f624a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Zl) it.next()).a(c0494om);
        }
    }

    public final void a(Sl sl) {
        synchronized (this) {
            this.b = null;
        }
        Lm lm = this.f545a;
        lm.d.a(lm.f.f1017a, sl, e());
    }

    public final synchronized void a(C0338im c0338im) {
        this.f545a.l.a(c0338im);
        C0390km d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!ro.a(list, d.e)) {
                    C0494om e = e();
                    C0594sm c0594sm = e.c;
                    C0569rm a2 = c0594sm.a(c0594sm.m);
                    String str = e.f1025a;
                    String str2 = e.b;
                    a2.g = list;
                    C0494om c0494om = new C0494om(str, str2, new C0594sm(a2));
                    b(c0494om);
                    a(c0494om);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0494om e2 = e();
                C0594sm c0594sm2 = e2.c;
                C0569rm a3 = c0594sm2.a(c0594sm2.m);
                String str3 = e2.f1025a;
                String str4 = e2.b;
                a3.g = null;
                C0494om c0494om2 = new C0494om(str3, str4, new C0594sm(a3));
                b(c0494om2);
                a(c0494om2);
            }
        }
    }
}

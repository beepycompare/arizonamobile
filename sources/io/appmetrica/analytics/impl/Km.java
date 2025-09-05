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
    public final Lm f540a;
    public volatile NetworkTask b;

    public Km(Lm lm) {
        this.f540a = lm;
    }

    public final Context b() {
        return this.f540a.f560a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0389km d = d();
                    C0536qe c0536qe = C0536qe.f1045a;
                    C0286gm c0286gm = new C0286gm(new Be(), Na.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new N5(this.f540a.f560a), new AllHostsExponentialBackoffPolicy(C0536qe.f1045a.a(EnumC0485oe.STARTUP)), new Im(this, new C0131am(), new FullUrlFormer(c0286gm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0536qe.c);
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

    public final C0389km d() {
        return (C0389km) this.f540a.l.a();
    }

    public final C0493om e() {
        C0493om c0493om;
        Rl rl = this.f540a.l;
        synchronized (rl) {
            c0493om = rl.c.f945a;
        }
        return c0493om;
    }

    public final void f() {
        C0493om c0493om;
        Rl rl = this.f540a.l;
        synchronized (rl) {
            c0493om = rl.c.f945a;
        }
        C0593sm c0593sm = c0493om.c;
        C0568rm a2 = c0593sm.a(c0593sm.m);
        String str = c0493om.f1020a;
        String str2 = c0493om.b;
        vo voVar = this.f540a.n;
        String str3 = c0493om.d;
        voVar.getClass();
        if (!vo.a(str3)) {
            a2.f1067a = this.f540a.m.a().id;
        }
        String str4 = c0493om.f1020a;
        if (str4 == null || str4.length() == 0) {
            str = this.f540a.h.a();
            str2 = "";
        }
        List<String> list = this.f540a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0493om c0493om2 = new C0493om(str, str2, new C0593sm(a2));
        b(c0493om2);
        a(c0493om2);
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
        C0493om e = e();
        Set set = AbstractC0415lm.f974a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0415lm.b.currentTimeSeconds() <= e.o + e.A.f578a) {
                z = false;
                if (!z) {
                    if (AbstractC0415lm.a(e.d) && AbstractC0415lm.a(e.f1020a) && AbstractC0415lm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    C0139b4 c0139b4 = this.f540a.k;
                    Map map = d().h;
                    Y3 y3 = this.f540a.j;
                    c0139b4.getClass();
                    boolean a2 = C0139b4.a(map, e, y3);
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

    public final C0476o5 a() {
        return this.f540a.f;
    }

    public final synchronized void b(C0493om c0493om) {
        this.f540a.l.a(c0493om);
        C0467nm c0467nm = this.f540a.g;
        c0467nm.b.a(c0493om.f1020a);
        c0467nm.b.b(c0493om.b);
        c0467nm.f1004a.save(c0493om.c);
        this.f540a.e.a(c0493om);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0415lm.a(e(), list, map, new Jm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0493om a(C0441mm c0441mm, C0389km c0389km, long j) {
        String str;
        boolean equals;
        String a2 = Pm.a(c0389km.h);
        Map map = c0389km.i.f630a;
        String str2 = c0441mm.j;
        String str3 = e().k;
        if (!Pm.a(Pm.a(str2))) {
            str2 = Pm.a(Pm.a(str3)) ? str3 : null;
        }
        String str4 = e().f1020a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0441mm.h;
        C0568rm c0568rm = new C0568rm(c0441mm.b);
        String str5 = c0441mm.i;
        c0568rm.o = this.f540a.i.currentTimeSeconds();
        c0568rm.f1067a = e().d;
        c0568rm.c = c0441mm.d;
        c0568rm.f = c0441mm.c;
        c0568rm.g = c0389km.e;
        c0568rm.b = c0441mm.e;
        c0568rm.d = c0441mm.f;
        c0568rm.e = c0441mm.g;
        c0568rm.h = c0441mm.n;
        c0568rm.i = c0441mm.o;
        c0568rm.j = str2;
        c0568rm.k = a2;
        this.f540a.k.getClass();
        HashMap a3 = Pm.a(str2);
        if (ro.a(map)) {
            equals = ro.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0568rm.q = equals;
        c0568rm.l = Pm.a(map);
        c0568rm.r = c0441mm.m;
        c0568rm.n = c0441mm.k;
        c0568rm.s = c0441mm.p;
        c0568rm.p = true;
        c0568rm.t = j;
        C0389km d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0568rm.u = d.n;
        c0568rm.v = false;
        c0568rm.w = c0441mm.q;
        c0568rm.y = c0441mm.s;
        c0568rm.x = c0441mm.r;
        c0568rm.z = c0441mm.t;
        c0568rm.A = c0441mm.u;
        c0568rm.B = c0441mm.v;
        c0568rm.C = c0441mm.w;
        return new C0493om(str, str5, new C0593sm(c0568rm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0441mm c0441mm, C0389km c0389km, Map<String, ? extends List<String>> map) {
        Long l;
        C0493om a2;
        synchronized (this) {
            if (!ro.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!ro.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0517pk.f1033a.a(longValue, c0441mm.l);
                    a2 = a(c0441mm, c0389km, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0517pk.f1033a.a(longValue, c0441mm.l);
            a2 = a(c0441mm, c0389km, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0493om c0493om) {
        ArrayList arrayList;
        Lm lm = this.f540a;
        Ol ol = lm.d;
        String str = lm.b;
        synchronized (ol.f609a.b) {
            Ql ql = ol.f609a;
            ql.c = c0493om;
            Collection collection = (Collection) ql.f640a.f619a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Zl) it.next()).a(c0493om);
        }
    }

    public final void a(Sl sl) {
        synchronized (this) {
            this.b = null;
        }
        Lm lm = this.f540a;
        lm.d.a(lm.f.f1012a, sl, e());
    }

    public final synchronized void a(C0337im c0337im) {
        this.f540a.l.a(c0337im);
        C0389km d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!ro.a(list, d.e)) {
                    C0493om e = e();
                    C0593sm c0593sm = e.c;
                    C0568rm a2 = c0593sm.a(c0593sm.m);
                    String str = e.f1020a;
                    String str2 = e.b;
                    a2.g = list;
                    C0493om c0493om = new C0493om(str, str2, new C0593sm(a2));
                    b(c0493om);
                    a(c0493om);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0493om e2 = e();
                C0593sm c0593sm2 = e2.c;
                C0568rm a3 = c0593sm2.a(c0593sm2.m);
                String str3 = e2.f1020a;
                String str4 = e2.b;
                a3.g = null;
                C0493om c0493om2 = new C0493om(str3, str4, new C0593sm(a3));
                b(c0493om2);
                a(c0493om2);
            }
        }
    }
}

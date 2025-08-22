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
public final class Gm {

    /* renamed from: a  reason: collision with root package name */
    public final Hm f462a;
    public volatile NetworkTask b;

    public Gm(Hm hm) {
        this.f462a = hm;
    }

    public final Context b() {
        return this.f462a.f482a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            try {
                if (g()) {
                    networkTask = this.b;
                    if (networkTask != null && !networkTask.isRemoved()) {
                    }
                    C0286gm d = d();
                    C0432me c0432me = C0432me.f967a;
                    C0183cm c0183cm = new C0183cm(new C0706xe(), Ka.F.o());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(d);
                    try {
                        NetworkTask networkTask2 = new NetworkTask(new SynchronizedBlockingExecutor(), new K5(this.f462a.f482a), new AllHostsExponentialBackoffPolicy(C0432me.f967a.a(EnumC0381ke.STARTUP)), new Em(this, new Wl(), new FullUrlFormer(c0183cm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), C0432me.c);
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

    public final C0286gm d() {
        return (C0286gm) this.f462a.l.a();
    }

    public final C0389km e() {
        C0389km c0389km;
        Nl nl = this.f462a.l;
        synchronized (nl) {
            c0389km = nl.c.f882a;
        }
        return c0389km;
    }

    public final void f() {
        C0389km c0389km;
        Nl nl = this.f462a.l;
        synchronized (nl) {
            c0389km = nl.c.f882a;
        }
        C0490om c0490om = c0389km.c;
        C0465nm a2 = c0490om.a(c0490om.m);
        String str = c0389km.f942a;
        String str2 = c0389km.b;
        ro roVar = this.f462a.n;
        String str3 = c0389km.d;
        roVar.getClass();
        if (!ro.a(str3)) {
            a2.f988a = this.f462a.m.a().id;
        }
        String str4 = c0389km.f942a;
        if (str4 == null || str4.length() == 0) {
            str = this.f462a.h.a();
            str2 = "";
        }
        List<String> list = this.f462a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        C0389km c0389km2 = new C0389km(str, str2, new C0490om(a2));
        b(c0389km2);
        a(c0389km2);
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
        if (Ka.F.g().isRestrictedForSdk()) {
            return false;
        }
        C0389km e = e();
        Set set = AbstractC0312hm.f894a;
        boolean z3 = true;
        if (!e.w) {
            if (AbstractC0312hm.b.currentTimeSeconds() <= e.o + e.A.f502a) {
                z = false;
                if (!z) {
                    if (AbstractC0312hm.a(e.d) && AbstractC0312hm.a(e.f942a) && AbstractC0312hm.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    Y3 y3 = this.f462a.k;
                    Map map = d().h;
                    V3 v3 = this.f462a.j;
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

    public final C0398l5 a() {
        return this.f462a.f;
    }

    public final synchronized void b(C0389km c0389km) {
        this.f462a.l.a(c0389km);
        C0363jm c0363jm = this.f462a.g;
        c0363jm.b.a(c0389km.f942a);
        c0363jm.b.b(c0389km.b);
        c0363jm.f928a.save(c0389km.c);
        this.f462a.e.a(c0389km);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC0312hm.a(e(), list, map, new Fm(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0389km a(C0337im c0337im, C0286gm c0286gm, long j) {
        String str;
        boolean equals;
        String a2 = Lm.a(c0286gm.h);
        Map map = c0286gm.i.f572a;
        String str2 = c0337im.j;
        String str3 = e().k;
        if (!Lm.a(Lm.a(str2))) {
            str2 = Lm.a(Lm.a(str3)) ? str3 : null;
        }
        String str4 = e().f942a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = c0337im.h;
        C0465nm c0465nm = new C0465nm(c0337im.b);
        String str5 = c0337im.i;
        c0465nm.o = this.f462a.i.currentTimeSeconds();
        c0465nm.f988a = e().d;
        c0465nm.c = c0337im.d;
        c0465nm.f = c0337im.c;
        c0465nm.g = c0286gm.e;
        c0465nm.b = c0337im.e;
        c0465nm.d = c0337im.f;
        c0465nm.e = c0337im.g;
        c0465nm.h = c0337im.n;
        c0465nm.i = c0337im.o;
        c0465nm.j = str2;
        c0465nm.k = a2;
        this.f462a.k.getClass();
        HashMap a3 = Lm.a(str2);
        if (no.a(map)) {
            equals = no.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        c0465nm.q = equals;
        c0465nm.l = Lm.a(map);
        c0465nm.r = c0337im.m;
        c0465nm.n = c0337im.k;
        c0465nm.s = c0337im.p;
        c0465nm.p = true;
        c0465nm.t = j;
        C0286gm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        c0465nm.u = d.n;
        c0465nm.v = false;
        c0465nm.w = c0337im.q;
        c0465nm.y = c0337im.s;
        c0465nm.x = c0337im.r;
        c0465nm.z = c0337im.t;
        c0465nm.A = c0337im.u;
        c0465nm.B = c0337im.v;
        c0465nm.C = c0337im.w;
        return new C0389km(str, str5, new C0490om(c0465nm));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:12:0x0035, B:14:0x003c), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0337im c0337im, C0286gm c0286gm, Map<String, ? extends List<String>> map) {
        Long l;
        C0389km a2;
        synchronized (this) {
            if (!no.a((Map) map)) {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
                if (!no.a((Collection) list)) {
                    try {
                        l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                    }
                    long longValue = l == null ? l.longValue() : 0L;
                    AbstractC0413lk.f955a.a(longValue, c0337im.l);
                    a2 = a(c0337im, c0286gm, longValue);
                    h();
                    b(a2);
                    Unit unit = Unit.INSTANCE;
                }
            }
            l = null;
            if (l == null) {
            }
            AbstractC0413lk.f955a.a(longValue, c0337im.l);
            a2 = a(c0337im, c0286gm, longValue);
            h();
            b(a2);
            Unit unit2 = Unit.INSTANCE;
        }
        a(a2);
    }

    public final void a(C0389km c0389km) {
        ArrayList arrayList;
        Hm hm = this.f462a;
        Kl kl = hm.d;
        String str = hm.b;
        synchronized (kl.f533a.b) {
            Ml ml = kl.f533a;
            ml.c = c0389km;
            Collection collection = (Collection) ml.f565a.f558a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Vl) it.next()).a(c0389km);
        }
    }

    public final void a(Ol ol) {
        synchronized (this) {
            this.b = null;
        }
        Hm hm = this.f462a;
        hm.d.a(hm.f.f949a, ol, e());
    }

    public final synchronized void a(C0234em c0234em) {
        this.f462a.l.a(c0234em);
        C0286gm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (!no.a(list, d.e)) {
                    C0389km e = e();
                    C0490om c0490om = e.c;
                    C0465nm a2 = c0490om.a(c0490om.m);
                    String str = e.f942a;
                    String str2 = e.b;
                    a2.g = list;
                    C0389km c0389km = new C0389km(str, str2, new C0490om(a2));
                    b(c0389km);
                    a(c0389km);
                }
            }
            List list2 = d.e;
            if (list2 != null && (!list2.isEmpty())) {
                C0389km e2 = e();
                C0490om c0490om2 = e2.c;
                C0465nm a3 = c0490om2.a(c0490om2.m);
                String str3 = e2.f942a;
                String str4 = e2.b;
                a3.g = null;
                C0389km c0389km2 = new C0389km(str3, str4, new C0490om(a3));
                b(c0389km2);
                a(c0389km2);
            }
        }
    }
}

package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0182cn {

    /* renamed from: a  reason: collision with root package name */
    public final C0208dn f932a;
    public final Object b = new Object();
    public volatile NetworkTask c;

    public C0182cn(C0208dn c0208dn) {
        this.f932a = c0208dn;
    }

    public final Context b() {
        return this.f932a.f949a;
    }

    public final NetworkTask c() {
        NetworkTask networkTask;
        synchronized (this.b) {
            if (g()) {
                networkTask = this.c;
                if (networkTask == null || networkTask.isRemoved()) {
                    networkTask = C0690we.a(this, d());
                    this.c = networkTask;
                }
            } else {
                networkTask = null;
            }
        }
        return networkTask;
    }

    public final Dm d() {
        return (Dm) this.f932a.l.a();
    }

    public final Hm e() {
        Hm hm;
        C0387km c0387km = this.f932a.l;
        synchronized (c0387km) {
            hm = c0387km.c.f901a;
        }
        return hm;
    }

    public final void f() {
        Hm hm;
        C0387km c0387km = this.f932a.l;
        synchronized (c0387km) {
            hm = c0387km.c.f901a;
        }
        Lm lm = hm.c;
        Km a2 = lm.a(lm.m);
        String str = hm.f581a;
        String str2 = hm.b;
        String str3 = this.f932a.m.a().id;
        if (str3 == null || (StringUtils.isNotNullOrEmpty(hm.d) && !Intrinsics.areEqual(str3, hm.d))) {
            Oj.f705a.reportError((str3 == null ? "null_uuid" : "wrong_uuid").concat("_on_service"), "The only true uuid: " + str3 + "; backup uuid: " + hm.d);
        }
        if (str3 == null) {
            str3 = hm.d;
        }
        a2.f632a = str3;
        String str4 = hm.f581a;
        if (str4 == null || str4.length() == 0) {
            str = this.f932a.h.a();
            str2 = "";
        }
        List<String> list = this.f932a.c.e;
        a2.g = (list == null || list.isEmpty()) ? null : null;
        Hm hm2 = new Hm(str, str2, new Lm(a2));
        b(hm2);
        a(hm2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g() {
        boolean z;
        boolean z2 = false;
        if (Na.I.h().isRestrictedForSdk()) {
            return false;
        }
        Hm e = e();
        Set set = Em.f531a;
        if (!e.w) {
            if (Em.b.currentTimeSeconds() <= e.o + e.z.f968a) {
                z = false;
                if (!z) {
                    if (Em.a(e.d) && Em.a(e.f581a) && Em.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    T3 t3 = this.f932a.k;
                    Map map = d().h;
                    Q3 q3 = this.f932a.j;
                    t3.getClass();
                    boolean a2 = T3.a(map, e, q3);
                    if (z2 && !a2) {
                        return true;
                    }
                }
                return z;
            }
        }
        z = true;
        if (!z) {
        }
        return z;
    }

    public final C0267g5 a() {
        return this.f932a.f;
    }

    public final void b(Hm hm) {
        this.f932a.l.a(hm);
        Gm gm = this.f932a.g;
        gm.b.a(hm.f581a);
        gm.b.b(hm.b);
        bp bpVar = gm.b.f875a;
        bp.a(bpVar.f913a);
        bp.a(bpVar.b);
        gm.f565a.save(hm.c);
        this.f932a.e.a(hm);
    }

    public final boolean a(List<String> list, Map<String, String> map) {
        return !Em.a(e(), list, map, new C0156bn(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Hm a(Fm fm, Dm dm, long j) {
        String str;
        boolean equals;
        String a2 = AbstractC0311hn.a(dm.h);
        Map map = dm.i.f586a;
        String str2 = fm.j;
        String str3 = e().k;
        if (!AbstractC0311hn.a(AbstractC0311hn.a(str2))) {
            str2 = AbstractC0311hn.a(AbstractC0311hn.a(str3)) ? str3 : null;
        }
        String str4 = e().f581a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = fm.h;
        Km km = new Km(fm.b);
        String str5 = fm.i;
        km.o = this.f932a.i.currentTimeSeconds();
        km.f632a = e().d;
        km.c = fm.d;
        km.f = fm.c;
        km.g = dm.e;
        km.b = fm.e;
        km.d = fm.f;
        km.e = fm.g;
        km.h = fm.n;
        km.i = fm.o;
        km.j = str2;
        km.k = a2;
        this.f932a.k.getClass();
        HashMap a3 = AbstractC0311hn.a(str2);
        if (Oo.a(map)) {
            equals = Oo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        km.q = equals;
        km.l = AbstractC0311hn.a(map);
        km.r = fm.m;
        km.n = fm.k;
        km.s = fm.p;
        km.p = true;
        km.t = j;
        Dm d = d();
        if (d.n == 0) {
            d.n = j;
        }
        km.u = d.n;
        km.v = false;
        km.w = fm.q;
        km.x = fm.r;
        km.y = fm.s;
        km.z = fm.t;
        km.A = fm.u;
        km.B = fm.v;
        return new Hm(str, str5, new Lm(km));
    }

    public final void a(Hm hm) {
        ArrayList arrayList;
        C0208dn c0208dn = this.f932a;
        C0310hm c0310hm = c0208dn.d;
        String str = c0208dn.b;
        synchronized (c0310hm.f1021a.b) {
            C0361jm c0361jm = c0310hm.f1021a;
            c0361jm.c = hm;
            Collection collection = (Collection) c0361jm.f1054a.f762a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0594sm) it.next()).a(hm);
        }
    }

    public final void a(EnumC0413lm enumC0413lm) {
        ArrayList arrayList;
        this.c = null;
        C0208dn c0208dn = this.f932a;
        C0310hm c0310hm = c0208dn.d;
        String str = c0208dn.f.f992a;
        Hm e = e();
        synchronized (c0310hm.f1021a.b) {
            Collection collection = (Collection) c0310hm.f1021a.f1054a.f762a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0594sm) it.next()).a(enumC0413lm, e);
        }
    }

    public final void a(Bm bm) {
        this.f932a.l.a(bm);
        Dm d = d();
        if (d.k) {
            List list = d.j;
            if (list != null && !list.isEmpty()) {
                if (Oo.a(list, d.e)) {
                    return;
                }
                Hm e = e();
                Lm lm = e.c;
                Km a2 = lm.a(lm.m);
                String str = e.f581a;
                String str2 = e.b;
                a2.g = list;
                Hm hm = new Hm(str, str2, new Lm(a2));
                b(hm);
                a(hm);
                return;
            }
            List list2 = d.e;
            if (list2 == null || !(!list2.isEmpty())) {
                return;
            }
            Hm e2 = e();
            Lm lm2 = e2.c;
            Km a3 = lm2.a(lm2.m);
            String str3 = e2.f581a;
            String str4 = e2.b;
            a3.g = null;
            Hm hm2 = new Hm(str3, str4, new Lm(a3));
            b(hm2);
            a(hm2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Fm fm, Dm dm, Map<String, ? extends List<String>> map) {
        Long l;
        if (!Oo.a((Map) map)) {
            List list = (List) CollectionUtils.getFromMapIgnoreCase(map, HttpHeaders.DATE);
            if (!Oo.a((Collection) list)) {
                try {
                    l = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                } catch (Throwable unused) {
                }
                long longValue = l == null ? l.longValue() : 0L;
                AbstractC0748yk.f1298a.a(longValue, fm.l);
                Hm a2 = a(fm, dm, longValue);
                this.c = null;
                b(a2);
                a(a2);
            }
        }
        l = null;
        if (l == null) {
        }
        AbstractC0748yk.f1298a.a(longValue, fm.l);
        Hm a22 = a(fm, dm, longValue);
        this.c = null;
        b(a22);
        a(a22);
    }
}

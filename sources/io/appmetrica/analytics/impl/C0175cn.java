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
public final class C0175cn {

    /* renamed from: a  reason: collision with root package name */
    public final C0201dn f938a;
    public final Object b = new Object();
    public volatile NetworkTask c;

    public C0175cn(C0201dn c0201dn) {
        this.f938a = c0201dn;
    }

    public final Context b() {
        return this.f938a.f955a;
    }

    public final NetworkTask c() {
        NetworkTask networkTask;
        synchronized (this.b) {
            if (g()) {
                networkTask = this.c;
                if (networkTask == null || networkTask.isRemoved()) {
                    networkTask = C0683we.a(this, d());
                    this.c = networkTask;
                }
            } else {
                networkTask = null;
            }
        }
        return networkTask;
    }

    public final Dm d() {
        return (Dm) this.f938a.l.a();
    }

    public final Hm e() {
        Hm hm;
        C0380km c0380km = this.f938a.l;
        synchronized (c0380km) {
            hm = c0380km.c.f907a;
        }
        return hm;
    }

    public final void f() {
        Hm hm;
        C0380km c0380km = this.f938a.l;
        synchronized (c0380km) {
            hm = c0380km.c.f907a;
        }
        Lm lm = hm.c;
        Km a2 = lm.a(lm.m);
        String str = hm.f587a;
        String str2 = hm.b;
        String str3 = this.f938a.m.a().id;
        if (str3 == null || (StringUtils.isNotNullOrEmpty(hm.d) && !Intrinsics.areEqual(str3, hm.d))) {
            Oj.f711a.reportError((str3 == null ? "null_uuid" : "wrong_uuid").concat("_on_service"), "The only true uuid: " + str3 + "; backup uuid: " + hm.d);
        }
        if (str3 == null) {
            str3 = hm.d;
        }
        a2.f638a = str3;
        String str4 = hm.f587a;
        if (str4 == null || str4.length() == 0) {
            str = this.f938a.h.a();
            str2 = "";
        }
        List<String> list = this.f938a.c.e;
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
        Set set = Em.f537a;
        if (!e.w) {
            if (Em.b.currentTimeSeconds() <= e.o + e.z.f974a) {
                z = false;
                if (!z) {
                    if (Em.a(e.d) && Em.a(e.f587a) && Em.a(e.b)) {
                        z2 = true;
                    }
                    z = !z2;
                    T3 t3 = this.f938a.k;
                    Map map = d().h;
                    Q3 q3 = this.f938a.j;
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

    public final C0260g5 a() {
        return this.f938a.f;
    }

    public final void b(Hm hm) {
        this.f938a.l.a(hm);
        Gm gm = this.f938a.g;
        gm.b.a(hm.f587a);
        gm.b.b(hm.b);
        bp bpVar = gm.b.f881a;
        bp.a(bpVar.f919a);
        bp.a(bpVar.b);
        gm.f571a.save(hm.c);
        this.f938a.e.a(hm);
    }

    public final boolean a(List<String> list, Map<String, String> map) {
        return !Em.a(e(), list, map, new C0149bn(this));
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
        String a2 = AbstractC0304hn.a(dm.h);
        Map map = dm.i.f592a;
        String str2 = fm.j;
        String str3 = e().k;
        if (!AbstractC0304hn.a(AbstractC0304hn.a(str2))) {
            str2 = AbstractC0304hn.a(AbstractC0304hn.a(str3)) ? str3 : null;
        }
        String str4 = e().f587a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
        }
        str = fm.h;
        Km km = new Km(fm.b);
        String str5 = fm.i;
        km.o = this.f938a.i.currentTimeSeconds();
        km.f638a = e().d;
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
        this.f938a.k.getClass();
        HashMap a3 = AbstractC0304hn.a(str2);
        if (Oo.a(map)) {
            equals = Oo.a((Map) a3);
        } else {
            equals = a3.equals(map);
        }
        km.q = equals;
        km.l = AbstractC0304hn.a(map);
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
        C0201dn c0201dn = this.f938a;
        C0303hm c0303hm = c0201dn.d;
        String str = c0201dn.b;
        synchronized (c0303hm.f1027a.b) {
            C0354jm c0354jm = c0303hm.f1027a;
            c0354jm.c = hm;
            Collection collection = (Collection) c0354jm.f1060a.f768a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0587sm) it.next()).a(hm);
        }
    }

    public final void a(EnumC0406lm enumC0406lm) {
        ArrayList arrayList;
        this.c = null;
        C0201dn c0201dn = this.f938a;
        C0303hm c0303hm = c0201dn.d;
        String str = c0201dn.f.f998a;
        Hm e = e();
        synchronized (c0303hm.f1027a.b) {
            Collection collection = (Collection) c0303hm.f1027a.f1060a.f768a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0587sm) it.next()).a(enumC0406lm, e);
        }
    }

    public final void a(Bm bm) {
        this.f938a.l.a(bm);
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
                String str = e.f587a;
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
            String str3 = e2.f587a;
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
                AbstractC0741yk.f1304a.a(longValue, fm.l);
                Hm a2 = a(fm, dm, longValue);
                this.c = null;
                b(a2);
                a(a2);
            }
        }
        l = null;
        if (l == null) {
        }
        AbstractC0741yk.f1304a.a(longValue, fm.l);
        Hm a22 = a(fm, dm, longValue);
        this.c = null;
        b(a22);
        a(a22);
    }
}

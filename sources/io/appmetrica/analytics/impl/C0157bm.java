package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0157bm {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f800a;
    public final HashMap b;
    public final Yl c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0408lf i;
    public final O j;
    public final Y3 k;
    public final T6 l;
    public final C0528qa m;
    public final C0503pa n;
    public final ro o;

    public C0157bm(Context context, C0408lf c0408lf) {
        this(c0408lf, new O(), new Y3(), C0696x4.l().a(context), new T6(), new C0528qa(), new C0503pa(), new ro());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, AbstractC0312hm.f894a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f800a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = AbstractC0312hm.b.currentTimeSeconds() > this.h;
        if (a2 && !z2 && !z3) {
            if (!this.g) {
                z = false;
            }
        }
        return z;
    }

    public final void b(IdentifiersResult identifiersResult) {
        if (a(identifiersResult)) {
            return;
        }
        this.b.put("appmetrica_clids", identifiersResult);
    }

    public final void c(IdentifiersResult identifiersResult) {
        if (identifiersResult != null) {
            ro roVar = this.o;
            String str = identifiersResult.id;
            roVar.getClass();
            if (ro.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        C0577sa c0577sa;
        C0408lf d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(Lm.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0528qa c0528qa = this.m;
        synchronized (c0528qa) {
            c0577sa = c0528qa.b;
        }
        d.a(c0577sa).b();
    }

    public C0157bm(C0408lf c0408lf, O o, Y3 y3, Md md, T6 t6, C0528qa c0528qa, C0503pa c0503pa, ro roVar) {
        HashSet hashSet = new HashSet();
        this.f800a = hashSet;
        this.b = new HashMap();
        this.c = new Yl();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0408lf;
        this.j = o;
        this.k = y3;
        this.l = t6;
        this.m = c0528qa;
        this.n = c0503pa;
        this.o = roVar;
        c(md.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0408lf.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0408lf.i());
        a("appmetrica_get_ad_url", c0408lf.d());
        a("appmetrica_report_ad_url", c0408lf.e());
        b(c0408lf.o());
        a("appmetrica_google_adv_id", c0408lf.l());
        a("appmetrica_huawei_oaid", c0408lf.m());
        a("appmetrica_yandex_adv_id", c0408lf.r());
        t6.a(c0408lf.h());
        c0528qa.a(c0408lf.k());
        this.d = c0408lf.g();
        String i = c0408lf.i((String) null);
        this.e = i != null ? Lm.a(i) : null;
        this.g = c0408lf.a(true);
        this.f = c0408lf.b(0L);
        this.h = c0408lf.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return no.a((Map) this.e);
        }
        return true;
    }

    public static boolean a(IdentifiersResult identifiersResult) {
        return identifiersResult == null || identifiersResult.id == null;
    }

    public final void a(String str, IdentifiersResult identifiersResult) {
        if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
            return;
        }
        this.b.put(str, identifiersResult);
    }

    public final synchronized boolean a(Collection collection) {
        Boolean bool;
        String str;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get(str2);
            if (identifiersResult == null) {
                identifiersResult = (IdentifiersResult) this.l.c.get(str2);
            }
            if (identifiersResult == null) {
                C0577sa c0577sa = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0577sa.f1058a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0577sa.b;
                    String str3 = c0577sa.c;
                    if (booleanValue) {
                        str = "true";
                    } else if (!booleanValue) {
                        str = "false";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    identifiersResult = new IdentifiersResult(str, identifierStatus, str3);
                }
            }
            if ("appmetrica_clids".equals(str2)) {
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !no.a((Map) this.e))) {
                    return false;
                }
            } else if ("appmetrica_lib_ssl_enabled".equals(str2)) {
                if (identifiersResult == null) {
                    return false;
                }
            } else if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
                return false;
            }
        }
        return true;
    }
}

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
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0124am {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f806a;
    public final HashMap b;
    public final Xl c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0117af i;
    public final P j;
    public final K3 k;
    public final E6 l;
    public final C0112aa m;
    public final Z9 n;
    public final ro o;

    public C0124am(Context context, C0117af c0117af) {
        this(c0117af, new P(), new K3(), C0338j4.l().a(context), new E6(), new C0112aa(), new Z9(), new ro());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, AbstractC0279gm.f901a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f806a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = AbstractC0279gm.b.currentTimeSeconds() > this.h;
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
        C0164ca c0164ca;
        C0117af d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(Jm.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0112aa c0112aa = this.m;
        synchronized (c0112aa) {
            c0164ca = c0112aa.b;
        }
        d.a(c0164ca).b();
    }

    public C0124am(C0117af c0117af, P p, K3 k3, Cd cd, E6 e6, C0112aa c0112aa, Z9 z9, ro roVar) {
        HashSet hashSet = new HashSet();
        this.f806a = hashSet;
        this.b = new HashMap();
        this.c = new Xl();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0117af;
        this.j = p;
        this.k = k3;
        this.l = e6;
        this.m = c0112aa;
        this.n = z9;
        this.o = roVar;
        c(cd.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0117af.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0117af.i());
        a("appmetrica_get_ad_url", c0117af.d());
        a("appmetrica_report_ad_url", c0117af.e());
        b(c0117af.o());
        a("appmetrica_google_adv_id", c0117af.l());
        a("appmetrica_huawei_oaid", c0117af.m());
        a("appmetrica_yandex_adv_id", c0117af.r());
        e6.a(c0117af.h());
        c0112aa.a(c0117af.k());
        this.d = c0117af.g();
        String i = c0117af.i((String) null);
        this.e = i != null ? Jm.a(i) : null;
        this.g = c0117af.a(true);
        this.f = c0117af.b(0L);
        this.h = c0117af.n();
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
                C0164ca c0164ca = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0164ca.f827a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0164ca.b;
                    String str3 = c0164ca.c;
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

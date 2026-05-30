package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
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
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0750ym {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1301a;
    public final HashMap b;
    public final C0672vm c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0665vf i;
    public final Q j;
    public final T3 k;
    public final P6 l;
    public final C0479oa m;
    public final C0453na n;
    public final So o;

    public C0750ym(Context context, C0665vf c0665vf) {
        this(c0665vf, new Q(), new T3(), C0576s4.l().a(context), new P6(), new C0479oa(), new C0453na(), new So());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, Em.f532a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f1301a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = Em.b.currentTimeSeconds() > this.h;
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

    public final void c() {
        C0531qa c0531qa;
        C0665vf d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(AbstractC0311hn.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0479oa c0479oa = this.m;
        synchronized (c0479oa) {
            c0531qa = c0479oa.b;
        }
        d.a(c0531qa);
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public C0750ym(C0665vf c0665vf, Q q, T3 t3, Vd vd, P6 p6, C0479oa c0479oa, C0453na c0453na, So so) {
        HashSet hashSet = new HashSet();
        this.f1301a = hashSet;
        this.b = new HashMap();
        this.c = new C0672vm();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0665vf;
        this.j = q;
        this.k = t3;
        this.l = p6;
        this.m = c0479oa;
        this.n = c0453na;
        this.o = so;
        a(vd.a(), c0665vf.q());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0665vf.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0665vf.i());
        a("appmetrica_get_ad_url", c0665vf.d());
        a("appmetrica_report_ad_url", c0665vf.e());
        b(c0665vf.o());
        a("appmetrica_google_adv_id", c0665vf.l());
        a("appmetrica_huawei_oaid", c0665vf.m());
        a("appmetrica_yandex_adv_id", c0665vf.r());
        p6.a(c0665vf.h());
        c0479oa.a(c0665vf.k());
        this.d = c0665vf.g();
        String i = c0665vf.i((String) null);
        this.e = i != null ? AbstractC0311hn.a(i) : null;
        this.g = c0665vf.a(true);
        this.f = c0665vf.b(0L);
        this.h = c0665vf.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return Oo.a((Map) this.e);
        }
        return true;
    }

    public final void a(IdentifiersResult identifiersResult, IdentifiersResult identifiersResult2) {
        if (identifiersResult != null) {
            So so = this.o;
            String str = identifiersResult.id;
            so.getClass();
            if (So.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
        String str2 = identifiersResult == null ? null : identifiersResult.id;
        String str3 = identifiersResult2.id;
        if (str2 == null || !(str3 == null || str2.equals(str3))) {
            Oj.f706a.reportError((str2 == null ? "null_uuid" : "wrong_uuid").concat("_on_client"), "The only true uuid: " + str2 + "; backup uuid: " + str3);
        }
    }

    public static boolean a(IdentifiersResult identifiersResult) {
        return identifiersResult == null || identifiersResult.id == null;
    }

    public final void a(String str, IdentifiersResult identifiersResult) {
        if (identifiersResult == null || StringUtils.isNullOrEmpty(identifiersResult.id)) {
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
                C0531qa c0531qa = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0531qa.f1163a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0531qa.b;
                    String str3 = c0531qa.c;
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
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !Oo.a((Map) this.e))) {
                    return false;
                }
            } else if ("appmetrica_lib_ssl_enabled".equals(str2)) {
                if (identifiersResult == null) {
                    return false;
                }
            } else if (identifiersResult == null || StringUtils.isNullOrEmpty(identifiersResult.id)) {
                return false;
            }
        }
        return true;
    }
}

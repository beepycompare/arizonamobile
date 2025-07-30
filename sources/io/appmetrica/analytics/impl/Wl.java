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
/* loaded from: classes4.dex */
public final class Wl {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f708a;
    public final HashMap b;
    public final Tl c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0360jf i;
    public final O j;
    public final Y3 k;
    public final S6 l;
    public final C0480oa m;
    public final C0455na n;
    public final mo o;

    public Wl(Context context, C0360jf c0360jf) {
        this(c0360jf, new O(), new Y3(), C0698x4.l().a(context), new S6(), new C0480oa(), new C0455na(), new mo());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, AbstractC0190cm.f804a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f708a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = AbstractC0190cm.b.currentTimeSeconds() > this.h;
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
            mo moVar = this.o;
            String str = identifiersResult.id;
            moVar.getClass();
            if (mo.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        C0530qa c0530qa;
        C0360jf d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(Gm.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0480oa c0480oa = this.m;
        synchronized (c0480oa) {
            c0530qa = c0480oa.b;
        }
        d.a(c0530qa).b();
    }

    public Wl(C0360jf c0360jf, O o, Y3 y3, Kd kd, S6 s6, C0480oa c0480oa, C0455na c0455na, mo moVar) {
        HashSet hashSet = new HashSet();
        this.f708a = hashSet;
        this.b = new HashMap();
        this.c = new Tl();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0360jf;
        this.j = o;
        this.k = y3;
        this.l = s6;
        this.m = c0480oa;
        this.n = c0455na;
        this.o = moVar;
        c(kd.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0360jf.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0360jf.i());
        a("appmetrica_get_ad_url", c0360jf.d());
        a("appmetrica_report_ad_url", c0360jf.e());
        b(c0360jf.o());
        a("appmetrica_google_adv_id", c0360jf.l());
        a("appmetrica_huawei_oaid", c0360jf.m());
        a("appmetrica_yandex_adv_id", c0360jf.r());
        s6.a(c0360jf.h());
        c0480oa.a(c0360jf.k());
        this.d = c0360jf.g();
        String i = c0360jf.i((String) null);
        this.e = i != null ? Gm.a(i) : null;
        this.g = c0360jf.a(true);
        this.f = c0360jf.b(0L);
        this.h = c0360jf.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return io.a((Map) this.e);
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
                C0530qa c0530qa = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0530qa.f1017a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0530qa.b;
                    String str3 = c0530qa.c;
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
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !io.a((Map) this.e))) {
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

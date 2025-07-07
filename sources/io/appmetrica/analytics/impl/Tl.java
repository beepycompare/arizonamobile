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
public final class Tl {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f647a;
    public final HashMap b;
    public final Ql c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0317hf i;
    public final O j;
    public final Y3 k;
    public final P6 l;
    public final C0436ma m;
    public final C0411la n;
    public final jo o;

    public Tl(Context context, C0317hf c0317hf) {
        this(c0317hf, new O(), new Y3(), C0704x4.l().a(context), new P6(), new C0436ma(), new C0411la(), new jo());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, Zl.f742a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f647a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = Zl.b.currentTimeSeconds() > this.h;
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
            jo joVar = this.o;
            String str = identifiersResult.id;
            joVar.getClass();
            if (jo.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        C0486oa c0486oa;
        C0317hf d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(Dm.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0436ma c0436ma = this.m;
        synchronized (c0436ma) {
            c0486oa = c0436ma.b;
        }
        d.a(c0486oa).b();
    }

    public Tl(C0317hf c0317hf, O o, Y3 y3, Id id, P6 p6, C0436ma c0436ma, C0411la c0411la, jo joVar) {
        HashSet hashSet = new HashSet();
        this.f647a = hashSet;
        this.b = new HashMap();
        this.c = new Ql();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0317hf;
        this.j = o;
        this.k = y3;
        this.l = p6;
        this.m = c0436ma;
        this.n = c0411la;
        this.o = joVar;
        c(id.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0317hf.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0317hf.i());
        a("appmetrica_get_ad_url", c0317hf.d());
        a("appmetrica_report_ad_url", c0317hf.e());
        b(c0317hf.o());
        a("appmetrica_google_adv_id", c0317hf.l());
        a("appmetrica_huawei_oaid", c0317hf.m());
        a("appmetrica_yandex_adv_id", c0317hf.r());
        p6.a(c0317hf.h());
        c0436ma.a(c0317hf.k());
        this.d = c0317hf.g();
        String i = c0317hf.i((String) null);
        this.e = i != null ? Dm.a(i) : null;
        this.g = c0317hf.a(true);
        this.f = c0317hf.b(0L);
        this.h = c0317hf.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return fo.a((Map) this.e);
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
                C0486oa c0486oa = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0486oa.f970a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0486oa.b;
                    String str3 = c0486oa.c;
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
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !fo.a((Map) this.e))) {
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

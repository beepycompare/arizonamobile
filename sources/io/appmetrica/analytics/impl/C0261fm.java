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
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0261fm {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f885a;
    public final HashMap b;
    public final C0184cm c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C0513pf i;
    public final O j;
    public final C0140b4 k;
    public final W6 l;
    public final C0607ta m;
    public final C0582sa n;
    public final vo o;

    public C0261fm(Context context, C0513pf c0513pf) {
        this(c0513pf, new O(), new C0140b4(), A4.l().a(context), new W6(), new C0607ta(), new C0582sa(), new vo());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean a2 = a(CollectionsKt.intersect(list, AbstractC0416lm.f979a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f885a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = AbstractC0416lm.b.currentTimeSeconds() > this.h;
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
            vo voVar = this.o;
            String str = identifiersResult.id;
            voVar.getClass();
            if (vo.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        C0657va c0657va;
        C0513pf d = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(Pm.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C0607ta c0607ta = this.m;
        synchronized (c0607ta) {
            c0657va = c0607ta.b;
        }
        d.a(c0657va).b();
    }

    public C0261fm(C0513pf c0513pf, O o, C0140b4 c0140b4, Qd qd, W6 w6, C0607ta c0607ta, C0582sa c0582sa, vo voVar) {
        HashSet hashSet = new HashSet();
        this.f885a = hashSet;
        this.b = new HashMap();
        this.c = new C0184cm();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c0513pf;
        this.j = o;
        this.k = c0140b4;
        this.l = w6;
        this.m = c0607ta;
        this.n = c0582sa;
        this.o = voVar;
        c(qd.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c0513pf.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c0513pf.i());
        a("appmetrica_get_ad_url", c0513pf.d());
        a("appmetrica_report_ad_url", c0513pf.e());
        b(c0513pf.o());
        a("appmetrica_google_adv_id", c0513pf.l());
        a("appmetrica_huawei_oaid", c0513pf.m());
        a("appmetrica_yandex_adv_id", c0513pf.r());
        w6.a(c0513pf.h());
        c0607ta.a(c0513pf.k());
        this.d = c0513pf.g();
        String i = c0513pf.i((String) null);
        this.e = i != null ? Pm.a(i) : null;
        this.g = c0513pf.a(true);
        this.f = c0513pf.b(0L);
        this.h = c0513pf.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return ro.a((Map) this.e);
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
                C0657va c0657va = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c0657va.f1124a) == null) {
                    identifiersResult = null;
                } else {
                    boolean booleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c0657va.b;
                    String str3 = c0657va.c;
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
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !ro.a((Map) this.e))) {
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

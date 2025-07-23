package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class Ol implements Pl {
    public static final Map k = Collections.unmodifiableMap(new Ll());

    /* renamed from: a  reason: collision with root package name */
    public final List f583a;
    public final Ji b;
    public final Wl c;
    public final Handler d;
    public PublicLogger e;
    public final Ml f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Ol(Context context, Ji ji, C0360jf c0360jf, Handler handler) {
        this(ji, new Wl(context, c0360jf), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            Wl wl = this.c;
            wl.getClass();
            if (!io.a((Map) map) && !io.a(map, wl.e)) {
                wl.e = new HashMap(map);
                wl.g = true;
                wl.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Nl(this, startupParamsCallback), map, true);
            } else {
                a(new Bundle(), startupParamsCallback);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b1 A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00be A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00da A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00df A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5 A[Catch: all -> 0x0115, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:10:0x0082, B:12:0x00b1, B:13:0x00b8, B:15:0x00be, B:16:0x00c5, B:18:0x00da, B:21:0x00e5, B:22:0x00f1, B:19:0x00df, B:9:0x007f), top: B:29:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Bundle bundle) {
        HashMap hashMap;
        boolean equals;
        IdentifiersResult a2 = C0474o4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0474o4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0474o4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0474o4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0474o4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0474o4.a(bundle, "Clids");
        IdentifiersResult a8 = C0474o4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0474o4.a(bundle, "GAID");
        IdentifiersResult a10 = C0474o4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0474o4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0474o4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0530qa a13 = C0474o4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        Wl wl = this.c;
        synchronized (wl) {
            IdentifiersResult identifiersResult = (IdentifiersResult) wl.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                mo moVar = wl.o;
                String str = identifiersResult.id;
                moVar.getClass();
                if (mo.a(str)) {
                    wl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    wl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    wl.b.put("appmetrica_google_adv_id", a9);
                    wl.b.put("appmetrica_huawei_oaid", a10);
                    wl.b.put("appmetrica_yandex_adv_id", a11);
                    wl.l.a(a12);
                    wl.m.a(a13);
                    if (!Wl.a(a6)) {
                        wl.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!Wl.a(a5)) {
                        wl.b.put("appmetrica_report_ad_url", a5);
                    }
                    wl.f = j;
                    Y3 y3 = wl.k;
                    hashMap = wl.e;
                    HashMap a14 = Bb.a(a8.id);
                    y3.getClass();
                    if (!io.a((Map) hashMap)) {
                        equals = io.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        wl.b.put("appmetrica_clids", a7);
                        wl.g = false;
                    }
                    wl.h = j2;
                    wl.c();
                }
            }
            wl.c(a2);
            wl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            wl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            wl.b.put("appmetrica_google_adv_id", a9);
            wl.b.put("appmetrica_huawei_oaid", a10);
            wl.b.put("appmetrica_yandex_adv_id", a11);
            wl.l.a(a12);
            wl.m.a(a13);
            if (!Wl.a(a6)) {
            }
            if (!Wl.a(a5)) {
            }
            wl.f = j;
            Y3 y32 = wl.k;
            hashMap = wl.e;
            HashMap a142 = Bb.a(a8.id);
            y32.getClass();
            if (!io.a((Map) hashMap)) {
            }
            if (equals) {
            }
            wl.h = j2;
            wl.c();
        }
        C0698x4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final V6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C0579sa e() {
        C0530qa c0530qa;
        Wl wl = this.c;
        C0455na c0455na = wl.n;
        C0480oa c0480oa = wl.m;
        synchronized (c0480oa) {
            c0530qa = c0480oa.b;
        }
        c0455na.getClass();
        Boolean bool = c0530qa.f1016a;
        return new C0579sa();
    }

    public final long f() {
        return this.c.f;
    }

    public final String g() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_UUID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final void h() {
        WeakHashMap weakHashMap = new WeakHashMap();
        for (Map.Entry entry : this.h.entrySet()) {
            List list = (List) entry.getValue();
            if (this.c.a((Collection) list)) {
                weakHashMap.put((StartupParamsCallback) entry.getKey(), list);
            }
        }
        for (Map.Entry entry2 : weakHashMap.entrySet()) {
            StartupParamsCallback startupParamsCallback = (StartupParamsCallback) entry2.getKey();
            if (startupParamsCallback != null) {
                a(new Bundle(), startupParamsCallback);
            }
        }
        weakHashMap.clear();
    }

    public final void i() {
        synchronized (this.g) {
            if (!this.j || this.c.b()) {
                this.j = true;
                a(this.f583a, this.f, this.i, false);
            }
        }
    }

    public Ol(Ji ji, Wl wl, Handler handler) {
        this.f583a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = ji;
        this.c = wl;
        this.d = handler;
        this.f = new Ml(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, V6 v6, Map map, boolean z) {
        W6 w6 = new W6(this.d, v6);
        Ji ji = this.b;
        ji.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0580sb(w6, list, map, z));
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = R9.f620a;
        C0325i4 c0325i4 = new C0325i4("", "", 1536, 0, anonymousInstance);
        c0325i4.m = bundle;
        C0121a5 c0121a5 = ji.f508a;
        ji.a(Ji.a(c0325i4, c0121a5), c0121a5, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (io.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Gm.b(map);
            this.i = b;
            this.b.a(b);
            Wl wl = this.c;
            wl.getClass();
            if (!io.a((Map) b) && !io.a(b, wl.e)) {
                wl.e = new HashMap(b);
                wl.g = true;
                wl.c();
            }
        }
    }

    public final void b(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        synchronized (this.g) {
            b(bundle);
            h();
            if (startupParamsCallback != null) {
                a(bundle, startupParamsCallback);
            }
        }
    }

    public final void a(String str) {
        synchronized (this.g) {
            this.b.a(str);
        }
    }

    public final void b(List<String> list) {
        synchronized (this.g) {
            List list2 = this.c.d;
            if (io.a((Collection) list)) {
                if (!io.a((Collection) list2)) {
                    Wl wl = this.c;
                    wl.d = null;
                    wl.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!io.a(list, list2)) {
                Wl wl2 = this.c;
                wl2.d = list;
                wl2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Jl jl;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    jl = Jl.UNKNOWN;
                    if (i == 1) {
                        jl = Jl.NETWORK;
                    } else if (i == 2) {
                        jl = Jl.PARSE;
                    }
                } else {
                    jl = null;
                }
                if (jl == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        jl = Jl.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, jl, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0420m0 c0420m0 = this.b.d;
                synchronized (c0420m0.f) {
                    c0420m0.c = false;
                    c0420m0.c();
                }
            }
        }
    }

    public final void b(String str) {
        synchronized (this.g) {
            this.b.b(str);
        }
    }

    public final Map<String, String> b() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get("appmetrica_clids");
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (!TextUtils.isEmpty(str)) {
            return Bb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        Wl wl = this.c;
        synchronized (wl) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) wl.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, wl.c.a(identifiersResult));
                }
            }
            wl.l.a(list, hashMap);
            wl.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0420m0 c0420m0 = this.b.d;
            synchronized (c0420m0.f) {
                c0420m0.c = true;
                c0420m0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        Wl wl = this.c;
        wl.j.getClass();
        return new AdvIdentifiersResult(O.a((IdentifiersResult) wl.b.get("appmetrica_google_adv_id")), O.a((IdentifiersResult) wl.b.get("appmetrica_huawei_oaid")), O.a((IdentifiersResult) wl.b.get("appmetrica_yandex_adv_id")));
    }
}

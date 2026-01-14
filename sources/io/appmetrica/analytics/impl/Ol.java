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
/* loaded from: classes5.dex */
public final class Ol implements Pl {
    public static final Map k = Collections.unmodifiableMap(new Ll());

    /* renamed from: a  reason: collision with root package name */
    public final List f730a;
    public final C0681wi b;
    public final Wl c;
    public final Handler d;
    public PublicLogger e;
    public final Ml f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Ol(Context context, C0681wi c0681wi, Ve ve, Handler handler) {
        this(c0681wi, new Wl(context, ve), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            Wl wl = this.c;
            wl.getClass();
            if (!lo.a((Map) map) && !lo.a(map, wl.e)) {
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
        IdentifiersResult a2 = S3.a(bundle, "Uuid");
        IdentifiersResult a3 = S3.a(bundle, "DeviceId");
        IdentifiersResult a4 = S3.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = S3.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = S3.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = S3.a(bundle, "Clids");
        IdentifiersResult a8 = S3.a(bundle, "RequestClids");
        IdentifiersResult a9 = S3.a(bundle, "GAID");
        IdentifiersResult a10 = S3.a(bundle, "HOAID");
        IdentifiersResult a11 = S3.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = S3.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        V9 a13 = S3.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        Wl wl = this.c;
        synchronized (wl) {
            IdentifiersResult identifiersResult = (IdentifiersResult) wl.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                po poVar = wl.o;
                String str = identifiersResult.id;
                poVar.getClass();
                if (po.a(str)) {
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
                    C3 c3 = wl.k;
                    hashMap = wl.e;
                    HashMap a14 = AbstractC0272gb.a(a8.id);
                    c3.getClass();
                    if (!lo.a((Map) hashMap)) {
                        equals = lo.a((Map) a14);
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
            C3 c32 = wl.k;
            hashMap = wl.e;
            HashMap a142 = AbstractC0272gb.a(a8.id);
            c32.getClass();
            if (!lo.a((Map) hashMap)) {
            }
            if (equals) {
            }
            wl.h = j2;
            wl.c();
        }
        C0136b4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final A6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final X9 e() {
        V9 v9;
        Wl wl = this.c;
        S9 s9 = wl.n;
        T9 t9 = wl.m;
        synchronized (t9) {
            v9 = t9.b;
        }
        s9.getClass();
        Boolean bool = v9.f826a;
        return new X9();
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
                a(this.f730a, this.f, this.i, false);
            }
        }
    }

    public Ol(C0681wi c0681wi, Wl wl, Handler handler) {
        this.f730a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = c0681wi;
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

    public final void a(List list, A6 a6, Map map, boolean z) {
        B6 b6 = new B6(this.d, a6);
        C0681wi c0681wi = this.b;
        c0681wi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new Xa(b6, list, map, z));
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0672w9.f1285a;
        M3 m3 = new M3("", "", 1536, 0, anonymousInstance);
        m3.m = bundle;
        F4 f4 = c0681wi.f1289a;
        c0681wi.a(C0681wi.a(m3, f4), f4, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (lo.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Fm.b(map);
            this.i = b;
            this.b.a(b);
            Wl wl = this.c;
            wl.getClass();
            if (!lo.a((Map) b) && !lo.a(b, wl.e)) {
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
            if (lo.a((Collection) list)) {
                if (!lo.a((Collection) list2)) {
                    Wl wl = this.c;
                    wl.d = null;
                    wl.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!lo.a(list, list2)) {
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
                C0489p0 c0489p0 = this.b.d;
                synchronized (c0489p0.f) {
                    c0489p0.c = false;
                    c0489p0.c();
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
            return AbstractC0272gb.a(str);
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
            C0489p0 c0489p0 = this.b.d;
            synchronized (c0489p0.f) {
                c0489p0.c = true;
                c0489p0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        Wl wl = this.c;
        wl.j.getClass();
        return new AdvIdentifiersResult(P.a((IdentifiersResult) wl.b.get("appmetrica_google_adv_id")), P.a((IdentifiersResult) wl.b.get("appmetrica_huawei_oaid")), P.a((IdentifiersResult) wl.b.get("appmetrica_yandex_adv_id")));
    }
}

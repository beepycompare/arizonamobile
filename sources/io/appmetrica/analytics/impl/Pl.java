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
public final class Pl implements Ql {
    public static final Map k = Collections.unmodifiableMap(new Ml());

    /* renamed from: a  reason: collision with root package name */
    public final List f640a;
    public final C0703xi b;
    public final Xl c;
    public final Handler d;
    public PublicLogger e;
    public final Nl f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Pl(Context context, C0703xi c0703xi, We we, Handler handler) {
        this(c0703xi, new Xl(context, we), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            Xl xl = this.c;
            xl.getClass();
            if (!mo.a((Map) map) && !mo.a(map, xl.e)) {
                xl.e = new HashMap(map);
                xl.g = true;
                xl.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Ol(this, startupParamsCallback), map, true);
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
        IdentifiersResult a2 = T3.a(bundle, "Uuid");
        IdentifiersResult a3 = T3.a(bundle, "DeviceId");
        IdentifiersResult a4 = T3.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = T3.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = T3.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = T3.a(bundle, "Clids");
        IdentifiersResult a8 = T3.a(bundle, "RequestClids");
        IdentifiersResult a9 = T3.a(bundle, "GAID");
        IdentifiersResult a10 = T3.a(bundle, "HOAID");
        IdentifiersResult a11 = T3.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = T3.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        W9 a13 = T3.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        Xl xl = this.c;
        synchronized (xl) {
            IdentifiersResult identifiersResult = (IdentifiersResult) xl.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                qo qoVar = xl.o;
                String str = identifiersResult.id;
                qoVar.getClass();
                if (qo.a(str)) {
                    xl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    xl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    xl.b.put("appmetrica_google_adv_id", a9);
                    xl.b.put("appmetrica_huawei_oaid", a10);
                    xl.b.put("appmetrica_yandex_adv_id", a11);
                    xl.l.a(a12);
                    xl.m.a(a13);
                    if (!Xl.a(a6)) {
                        xl.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!Xl.a(a5)) {
                        xl.b.put("appmetrica_report_ad_url", a5);
                    }
                    xl.f = j;
                    D3 d3 = xl.k;
                    hashMap = xl.e;
                    HashMap a14 = AbstractC0294hb.a(a8.id);
                    d3.getClass();
                    if (!mo.a((Map) hashMap)) {
                        equals = mo.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        xl.b.put("appmetrica_clids", a7);
                        xl.g = false;
                    }
                    xl.h = j2;
                    xl.c();
                }
            }
            xl.c(a2);
            xl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            xl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            xl.b.put("appmetrica_google_adv_id", a9);
            xl.b.put("appmetrica_huawei_oaid", a10);
            xl.b.put("appmetrica_yandex_adv_id", a11);
            xl.l.a(a12);
            xl.m.a(a13);
            if (!Xl.a(a6)) {
            }
            if (!Xl.a(a5)) {
            }
            xl.f = j;
            D3 d32 = xl.k;
            hashMap = xl.e;
            HashMap a142 = AbstractC0294hb.a(a8.id);
            d32.getClass();
            if (!mo.a((Map) hashMap)) {
            }
            if (equals) {
            }
            xl.h = j2;
            xl.c();
        }
        C0158c4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final B6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final Y9 e() {
        W9 w9;
        Xl xl = this.c;
        T9 t9 = xl.n;
        U9 u9 = xl.m;
        synchronized (u9) {
            w9 = u9.b;
        }
        t9.getClass();
        Boolean bool = w9.f737a;
        return new Y9();
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
                a(this.f640a, this.f, this.i, false);
            }
        }
    }

    public Pl(C0703xi c0703xi, Xl xl, Handler handler) {
        this.f640a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = c0703xi;
        this.c = xl;
        this.d = handler;
        this.f = new Nl(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, B6 b6, Map map, boolean z) {
        C6 c6 = new C6(this.d, b6);
        C0703xi c0703xi = this.b;
        c0703xi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new Ya(c6, list, map, z));
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0694x9.f1197a;
        N3 n3 = new N3("", "", 1536, 0, anonymousInstance);
        n3.m = bundle;
        G4 g4 = c0703xi.f1201a;
        c0703xi.a(C0703xi.a(n3, g4), g4, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (mo.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Gm.b(map);
            this.i = b;
            this.b.a(b);
            Xl xl = this.c;
            xl.getClass();
            if (!mo.a((Map) b) && !mo.a(b, xl.e)) {
                xl.e = new HashMap(b);
                xl.g = true;
                xl.c();
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
            if (mo.a((Collection) list)) {
                if (!mo.a((Collection) list2)) {
                    Xl xl = this.c;
                    xl.d = null;
                    xl.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!mo.a(list, list2)) {
                Xl xl2 = this.c;
                xl2.d = list;
                xl2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Kl kl;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    kl = Kl.UNKNOWN;
                    if (i == 1) {
                        kl = Kl.NETWORK;
                    } else if (i == 2) {
                        kl = Kl.PARSE;
                    }
                } else {
                    kl = null;
                }
                if (kl == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        kl = Kl.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, kl, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0486p0 c0486p0 = this.b.d;
                synchronized (c0486p0.f) {
                    c0486p0.c = false;
                    c0486p0.c();
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
            return AbstractC0294hb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        Xl xl = this.c;
        synchronized (xl) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) xl.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, xl.c.a(identifiersResult));
                }
            }
            xl.l.a(list, hashMap);
            xl.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0486p0 c0486p0 = this.b.d;
            synchronized (c0486p0.f) {
                c0486p0.c = true;
                c0486p0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        Xl xl = this.c;
        xl.j.getClass();
        return new AdvIdentifiersResult(P.a((IdentifiersResult) xl.b.get("appmetrica_google_adv_id")), P.a((IdentifiersResult) xl.b.get("appmetrica_huawei_oaid")), P.a((IdentifiersResult) xl.b.get("appmetrica_yandex_adv_id")));
    }
}

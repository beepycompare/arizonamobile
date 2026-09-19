package io.appmetrica.analytics.impl;

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
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0541qm implements InterfaceC0566rm {
    public static final Map k = Collections.unmodifiableMap(new C0463nm());
    public final Qi b;
    public final C0748ym c;
    public final Handler d;
    public PublicLogger e;
    public HashMap i;

    /* renamed from: a  reason: collision with root package name */
    public final List f1172a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
    public final Object g = new Object();
    public final WeakHashMap h = new WeakHashMap();
    public boolean j = false;
    public final C0489om f = new C0489om(this);

    public C0541qm(Qi qi, C0748ym c0748ym, Handler handler) {
        this.b = qi;
        this.c = c0748ym;
        this.d = handler;
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            C0748ym c0748ym = this.c;
            c0748ym.getClass();
            if (!Oo.a((Map) map) && !Oo.a(map, c0748ym.e)) {
                c0748ym.e = new HashMap(map);
                c0748ym.g = true;
                c0748ym.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new C0515pm(this, startupParamsCallback), map, true);
            } else {
                a(new Bundle(), startupParamsCallback);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c2 A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:12:0x0093, B:14:0x00c2, B:15:0x00c9, B:17:0x00cf, B:18:0x00d6, B:20:0x00eb, B:23:0x00f6, B:24:0x0102, B:21:0x00f0, B:9:0x007f, B:11:0x008c), top: B:31:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:12:0x0093, B:14:0x00c2, B:15:0x00c9, B:17:0x00cf, B:18:0x00d6, B:20:0x00eb, B:23:0x00f6, B:24:0x0102, B:21:0x00f0, B:9:0x007f, B:11:0x008c), top: B:31:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:12:0x0093, B:14:0x00c2, B:15:0x00c9, B:17:0x00cf, B:18:0x00d6, B:20:0x00eb, B:23:0x00f6, B:24:0x0102, B:21:0x00f0, B:9:0x007f, B:11:0x008c), top: B:31:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f0 A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:12:0x0093, B:14:0x00c2, B:15:0x00c9, B:17:0x00cf, B:18:0x00d6, B:20:0x00eb, B:23:0x00f6, B:24:0x0102, B:21:0x00f0, B:9:0x007f, B:11:0x008c), top: B:31:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f6 A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0063, B:6:0x0071, B:12:0x0093, B:14:0x00c2, B:15:0x00c9, B:17:0x00cf, B:18:0x00d6, B:20:0x00eb, B:23:0x00f6, B:24:0x0102, B:21:0x00f0, B:9:0x007f, B:11:0x008c), top: B:31:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Bundle bundle) {
        HashMap hashMap;
        boolean equals;
        IdentifiersResult a2 = C0341j4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0341j4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0341j4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0341j4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0341j4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0341j4.a(bundle, "Clids");
        IdentifiersResult a8 = C0341j4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0341j4.a(bundle, "GAID");
        IdentifiersResult a10 = C0341j4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0341j4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0341j4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0529qa a13 = C0341j4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        C0748ym c0748ym = this.c;
        synchronized (c0748ym) {
            IdentifiersResult identifiersResult = (IdentifiersResult) c0748ym.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                So so = c0748ym.o;
                String str = identifiersResult.id;
                so.getClass();
                if (So.a(str)) {
                    c0748ym.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    c0748ym.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    c0748ym.b.put("appmetrica_google_adv_id", a9);
                    c0748ym.b.put("appmetrica_huawei_oaid", a10);
                    c0748ym.b.put("appmetrica_yandex_adv_id", a11);
                    c0748ym.l.a(a12);
                    c0748ym.m.a(a13);
                    if (!C0748ym.a(a6)) {
                        c0748ym.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!C0748ym.a(a5)) {
                        c0748ym.b.put("appmetrica_report_ad_url", a5);
                    }
                    c0748ym.f = j;
                    T3 t3 = c0748ym.k;
                    hashMap = c0748ym.e;
                    HashMap a14 = Ib.a(a8.id);
                    t3.getClass();
                    if (!Oo.a((Map) hashMap)) {
                        equals = Oo.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        c0748ym.b.put("appmetrica_clids", a7);
                        c0748ym.g = false;
                    }
                    c0748ym.h = j2;
                    c0748ym.c();
                }
            }
            So so2 = c0748ym.o;
            String str2 = a2.id;
            so2.getClass();
            if (So.a(str2)) {
                c0748ym.b.put(StartupParamsCallback.APPMETRICA_UUID, a2);
            }
            c0748ym.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            c0748ym.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            c0748ym.b.put("appmetrica_google_adv_id", a9);
            c0748ym.b.put("appmetrica_huawei_oaid", a10);
            c0748ym.b.put("appmetrica_yandex_adv_id", a11);
            c0748ym.l.a(a12);
            c0748ym.m.a(a13);
            if (!C0748ym.a(a6)) {
            }
            if (!C0748ym.a(a5)) {
            }
            c0748ym.f = j;
            T3 t32 = c0748ym.k;
            hashMap = c0748ym.e;
            HashMap a142 = Ib.a(a8.id);
            t32.getClass();
            if (!Oo.a((Map) hashMap)) {
            }
            if (equals) {
            }
            c0748ym.h = j2;
            c0748ym.c();
        }
        C0574s4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final S6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C0580sa e() {
        C0529qa c0529qa;
        C0748ym c0748ym = this.c;
        C0451na c0451na = c0748ym.n;
        C0477oa c0477oa = c0748ym.m;
        synchronized (c0477oa) {
            c0529qa = c0477oa.b;
        }
        c0451na.getClass();
        Boolean bool = c0529qa.f1165a;
        return new C0580sa();
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
                a(this.f1172a, this.f, this.i, false);
            }
        }
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, S6 s6, Map map, boolean z) {
        T6 t6 = new T6(this.d, s6);
        Qi qi = this.b;
        qi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0685wb(t6, list, map, z));
        Db db = Db.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = Q9.f730a;
        C0187d4 c0187d4 = new C0187d4("", "", 1536, 0, anonymousInstance);
        c0187d4.m = bundle;
        V4 v4 = qi.f736a;
        qi.a(Qi.a(c0187d4, v4), v4, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (Oo.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = AbstractC0309hn.b(map);
            this.i = b;
            this.b.a(b);
            C0748ym c0748ym = this.c;
            c0748ym.getClass();
            if (!Oo.a((Map) b) && !Oo.a(b, c0748ym.e)) {
                c0748ym.e = new HashMap(b);
                c0748ym.g = true;
                c0748ym.c();
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
            if (Oo.a((Collection) list)) {
                if (!Oo.a((Collection) list2)) {
                    C0748ym c0748ym = this.c;
                    c0748ym.d = null;
                    c0748ym.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!Oo.a(list, list2)) {
                C0748ym c0748ym2 = this.c;
                c0748ym2.d = list;
                c0748ym2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        EnumC0411lm enumC0411lm;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    enumC0411lm = EnumC0411lm.UNKNOWN;
                    if (i == 1) {
                        enumC0411lm = EnumC0411lm.NETWORK;
                    } else if (i == 2) {
                        enumC0411lm = EnumC0411lm.PARSE;
                    }
                } else {
                    enumC0411lm = null;
                }
                if (enumC0411lm == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        enumC0411lm = EnumC0411lm.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, enumC0411lm, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0544r0 c0544r0 = this.b.d;
                synchronized (c0544r0.f) {
                    c0544r0.c = false;
                    c0544r0.c();
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
            return Ib.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        C0748ym c0748ym = this.c;
        synchronized (c0748ym) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) c0748ym.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, c0748ym.c.a(identifiersResult));
                }
            }
            c0748ym.l.a(list, hashMap);
            c0748ym.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0544r0 c0544r0 = this.b.d;
            synchronized (c0544r0.f) {
                c0544r0.c = true;
                c0544r0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        C0748ym c0748ym = this.c;
        c0748ym.j.getClass();
        return new AdvIdentifiersResult(Q.a((IdentifiersResult) c0748ym.b.get("appmetrica_google_adv_id")), Q.a((IdentifiersResult) c0748ym.b.get("appmetrica_huawei_oaid")), Q.a((IdentifiersResult) c0748ym.b.get("appmetrica_yandex_adv_id")));
    }
}

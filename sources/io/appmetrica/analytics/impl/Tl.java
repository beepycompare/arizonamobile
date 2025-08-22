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
public final class Tl implements Ul {
    public static final Map k = Collections.unmodifiableMap(new Ql());

    /* renamed from: a  reason: collision with root package name */
    public final List f666a;
    public final Oi b;
    public final C0157bm c;
    public final Handler d;
    public PublicLogger e;
    public final Rl f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Tl(Context context, Oi oi, C0408lf c0408lf, Handler handler) {
        this(oi, new C0157bm(context, c0408lf), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            C0157bm c0157bm = this.c;
            c0157bm.getClass();
            if (!no.a((Map) map) && !no.a(map, c0157bm.e)) {
                c0157bm.e = new HashMap(map);
                c0157bm.g = true;
                c0157bm.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Sl(this, startupParamsCallback), map, true);
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
        IdentifiersResult a2 = C0472o4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0472o4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0472o4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0472o4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0472o4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0472o4.a(bundle, "Clids");
        IdentifiersResult a8 = C0472o4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0472o4.a(bundle, "GAID");
        IdentifiersResult a10 = C0472o4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0472o4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0472o4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0577sa a13 = C0472o4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        C0157bm c0157bm = this.c;
        synchronized (c0157bm) {
            IdentifiersResult identifiersResult = (IdentifiersResult) c0157bm.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                ro roVar = c0157bm.o;
                String str = identifiersResult.id;
                roVar.getClass();
                if (ro.a(str)) {
                    c0157bm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    c0157bm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    c0157bm.b.put("appmetrica_google_adv_id", a9);
                    c0157bm.b.put("appmetrica_huawei_oaid", a10);
                    c0157bm.b.put("appmetrica_yandex_adv_id", a11);
                    c0157bm.l.a(a12);
                    c0157bm.m.a(a13);
                    if (!C0157bm.a(a6)) {
                        c0157bm.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!C0157bm.a(a5)) {
                        c0157bm.b.put("appmetrica_report_ad_url", a5);
                    }
                    c0157bm.f = j;
                    Y3 y3 = c0157bm.k;
                    hashMap = c0157bm.e;
                    HashMap a14 = Db.a(a8.id);
                    y3.getClass();
                    if (!no.a((Map) hashMap)) {
                        equals = no.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        c0157bm.b.put("appmetrica_clids", a7);
                        c0157bm.g = false;
                    }
                    c0157bm.h = j2;
                    c0157bm.c();
                }
            }
            c0157bm.c(a2);
            c0157bm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            c0157bm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            c0157bm.b.put("appmetrica_google_adv_id", a9);
            c0157bm.b.put("appmetrica_huawei_oaid", a10);
            c0157bm.b.put("appmetrica_yandex_adv_id", a11);
            c0157bm.l.a(a12);
            c0157bm.m.a(a13);
            if (!C0157bm.a(a6)) {
            }
            if (!C0157bm.a(a5)) {
            }
            c0157bm.f = j;
            Y3 y32 = c0157bm.k;
            hashMap = c0157bm.e;
            HashMap a142 = Db.a(a8.id);
            y32.getClass();
            if (!no.a((Map) hashMap)) {
            }
            if (equals) {
            }
            c0157bm.h = j2;
            c0157bm.c();
        }
        C0696x4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final W6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C0627ua e() {
        C0577sa c0577sa;
        C0157bm c0157bm = this.c;
        C0503pa c0503pa = c0157bm.n;
        C0528qa c0528qa = c0157bm.m;
        synchronized (c0528qa) {
            c0577sa = c0528qa.b;
        }
        c0503pa.getClass();
        Boolean bool = c0577sa.f1058a;
        return new C0627ua();
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
                a(this.f666a, this.f, this.i, false);
            }
        }
    }

    public Tl(Oi oi, C0157bm c0157bm, Handler handler) {
        this.f666a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = oi;
        this.c = c0157bm;
        this.d = handler;
        this.f = new Rl(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, W6 w6, Map map, boolean z) {
        X6 x6 = new X6(this.d, w6);
        Oi oi = this.b;
        oi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0628ub(x6, list, map, z));
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = T9.f659a;
        C0320i4 c0320i4 = new C0320i4("", "", 1536, 0, anonymousInstance);
        c0320i4.m = bundle;
        C0114a5 c0114a5 = oi.f591a;
        oi.a(Oi.a(c0320i4, c0114a5), c0114a5, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (no.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Lm.b(map);
            this.i = b;
            this.b.a(b);
            C0157bm c0157bm = this.c;
            c0157bm.getClass();
            if (!no.a((Map) b) && !no.a(b, c0157bm.e)) {
                c0157bm.e = new HashMap(b);
                c0157bm.g = true;
                c0157bm.c();
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
            if (no.a((Collection) list)) {
                if (!no.a((Collection) list2)) {
                    C0157bm c0157bm = this.c;
                    c0157bm.d = null;
                    c0157bm.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!no.a(list, list2)) {
                C0157bm c0157bm2 = this.c;
                c0157bm2.d = list;
                c0157bm2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Ol ol;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    ol = Ol.UNKNOWN;
                    if (i == 1) {
                        ol = Ol.NETWORK;
                    } else if (i == 2) {
                        ol = Ol.PARSE;
                    }
                } else {
                    ol = null;
                }
                if (ol == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        ol = Ol.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, ol, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0418m0 c0418m0 = this.b.d;
                synchronized (c0418m0.f) {
                    c0418m0.c = false;
                    c0418m0.c();
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
            return Db.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        C0157bm c0157bm = this.c;
        synchronized (c0157bm) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) c0157bm.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, c0157bm.c.a(identifiersResult));
                }
            }
            c0157bm.l.a(list, hashMap);
            c0157bm.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0418m0 c0418m0 = this.b.d;
            synchronized (c0418m0.f) {
                c0418m0.c = true;
                c0418m0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        C0157bm c0157bm = this.c;
        c0157bm.j.getClass();
        return new AdvIdentifiersResult(O.a((IdentifiersResult) c0157bm.b.get("appmetrica_google_adv_id")), O.a((IdentifiersResult) c0157bm.b.get("appmetrica_huawei_oaid")), O.a((IdentifiersResult) c0157bm.b.get("appmetrica_yandex_adv_id")));
    }
}

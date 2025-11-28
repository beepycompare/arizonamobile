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
public final class Sl implements Tl {
    public static final Map k = Collections.unmodifiableMap(new Pl());

    /* renamed from: a  reason: collision with root package name */
    public final List f689a;
    public final Bi b;
    public final C0124am c;
    public final Handler d;
    public PublicLogger e;
    public final Ql f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Sl(Context context, Bi bi, C0117af c0117af, Handler handler) {
        this(bi, new C0124am(context, c0117af), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            C0124am c0124am = this.c;
            c0124am.getClass();
            if (!no.a((Map) map) && !no.a(map, c0124am.e)) {
                c0124am.e = new HashMap(map);
                c0124am.g = true;
                c0124am.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Rl(this, startupParamsCallback), map, true);
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
        IdentifiersResult a2 = C0106a4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0106a4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0106a4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0106a4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0106a4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0106a4.a(bundle, "Clids");
        IdentifiersResult a8 = C0106a4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0106a4.a(bundle, "GAID");
        IdentifiersResult a10 = C0106a4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0106a4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0106a4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0164ca a13 = C0106a4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        C0124am c0124am = this.c;
        synchronized (c0124am) {
            IdentifiersResult identifiersResult = (IdentifiersResult) c0124am.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                ro roVar = c0124am.o;
                String str = identifiersResult.id;
                roVar.getClass();
                if (ro.a(str)) {
                    c0124am.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    c0124am.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    c0124am.b.put("appmetrica_google_adv_id", a9);
                    c0124am.b.put("appmetrica_huawei_oaid", a10);
                    c0124am.b.put("appmetrica_yandex_adv_id", a11);
                    c0124am.l.a(a12);
                    c0124am.m.a(a13);
                    if (!C0124am.a(a6)) {
                        c0124am.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!C0124am.a(a5)) {
                        c0124am.b.put("appmetrica_report_ad_url", a5);
                    }
                    c0124am.f = j;
                    K3 k3 = c0124am.k;
                    hashMap = c0124am.e;
                    HashMap a14 = AbstractC0447nb.a(a8.id);
                    k3.getClass();
                    if (!no.a((Map) hashMap)) {
                        equals = no.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        c0124am.b.put("appmetrica_clids", a7);
                        c0124am.g = false;
                    }
                    c0124am.h = j2;
                    c0124am.c();
                }
            }
            c0124am.c(a2);
            c0124am.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            c0124am.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            c0124am.b.put("appmetrica_google_adv_id", a9);
            c0124am.b.put("appmetrica_huawei_oaid", a10);
            c0124am.b.put("appmetrica_yandex_adv_id", a11);
            c0124am.l.a(a12);
            c0124am.m.a(a13);
            if (!C0124am.a(a6)) {
            }
            if (!C0124am.a(a5)) {
            }
            c0124am.f = j;
            K3 k32 = c0124am.k;
            hashMap = c0124am.e;
            HashMap a142 = AbstractC0447nb.a(a8.id);
            k32.getClass();
            if (!no.a((Map) hashMap)) {
            }
            if (equals) {
            }
            c0124am.h = j2;
            c0124am.c();
        }
        C0338j4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final H6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C0215ea e() {
        C0164ca c0164ca;
        C0124am c0124am = this.c;
        Z9 z9 = c0124am.n;
        C0112aa c0112aa = c0124am.m;
        synchronized (c0112aa) {
            c0164ca = c0112aa.b;
        }
        z9.getClass();
        Boolean bool = c0164ca.f827a;
        return new C0215ea();
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
                a(this.f689a, this.f, this.i, false);
            }
        }
    }

    public Sl(Bi bi, C0124am c0124am, Handler handler) {
        this.f689a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = bi;
        this.c = c0124am;
        this.d = handler;
        this.f = new Ql(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, H6 h6, Map map, boolean z) {
        I6 i6 = new I6(this.d, h6);
        Bi bi = this.b;
        bi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0216eb(i6, list, map, z));
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = D9.f438a;
        U3 u3 = new U3("", "", 1536, 0, anonymousInstance);
        u3.m = bundle;
        M4 m4 = bi.f414a;
        bi.a(Bi.a(u3, m4), m4, 1, (Map) null);
    }

    public final void a(Map<String, String> map) {
        if (no.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Jm.b(map);
            this.i = b;
            this.b.a(b);
            C0124am c0124am = this.c;
            c0124am.getClass();
            if (!no.a((Map) b) && !no.a(b, c0124am.e)) {
                c0124am.e = new HashMap(b);
                c0124am.g = true;
                c0124am.c();
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
                    C0124am c0124am = this.c;
                    c0124am.d = null;
                    c0124am.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!no.a(list, list2)) {
                C0124am c0124am2 = this.c;
                c0124am2.d = list;
                c0124am2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Nl nl;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    nl = Nl.UNKNOWN;
                    if (i == 1) {
                        nl = Nl.NETWORK;
                    } else if (i == 2) {
                        nl = Nl.PARSE;
                    }
                } else {
                    nl = null;
                }
                if (nl == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        nl = Nl.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, nl, StartupParamsCallback.Reason.UNKNOWN);
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
            return AbstractC0447nb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        C0124am c0124am = this.c;
        synchronized (c0124am) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) c0124am.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, c0124am.c.a(identifiersResult));
                }
            }
            c0124am.l.a(list, hashMap);
            c0124am.m.a(list, hashMap);
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
        C0124am c0124am = this.c;
        c0124am.j.getClass();
        return new AdvIdentifiersResult(P.a((IdentifiersResult) c0124am.b.get("appmetrica_google_adv_id")), P.a((IdentifiersResult) c0124am.b.get("appmetrica_huawei_oaid")), P.a((IdentifiersResult) c0124am.b.get("appmetrica_yandex_adv_id")));
    }
}

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
public final class Ll implements Ml {
    public static final Map k = Collections.unmodifiableMap(new Il());

    /* renamed from: a  reason: collision with root package name */
    public final List f522a;
    public final Gi b;
    public final Tl c;
    public final Handler d;
    public PublicLogger e;
    public final Jl f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Ll(Context context, Gi gi, C0317hf c0317hf, Handler handler) {
        this(gi, new Tl(context, c0317hf), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            Tl tl = this.c;
            tl.getClass();
            if (!fo.a((Map) map) && !fo.a(map, tl.e)) {
                tl.e = new HashMap(map);
                tl.g = true;
                tl.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Kl(this, startupParamsCallback), map);
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
        IdentifiersResult a2 = C0480o4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0480o4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0480o4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0480o4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0480o4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0480o4.a(bundle, "Clids");
        IdentifiersResult a8 = C0480o4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0480o4.a(bundle, "GAID");
        IdentifiersResult a10 = C0480o4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0480o4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0480o4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0486oa a13 = C0480o4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        Tl tl = this.c;
        synchronized (tl) {
            IdentifiersResult identifiersResult = (IdentifiersResult) tl.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                jo joVar = tl.o;
                String str = identifiersResult.id;
                joVar.getClass();
                if (jo.a(str)) {
                    tl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    tl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    tl.b.put("appmetrica_google_adv_id", a9);
                    tl.b.put("appmetrica_huawei_oaid", a10);
                    tl.b.put("appmetrica_yandex_adv_id", a11);
                    tl.l.a(a12);
                    tl.m.a(a13);
                    if (!Tl.a(a6)) {
                        tl.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!Tl.a(a5)) {
                        tl.b.put("appmetrica_report_ad_url", a5);
                    }
                    tl.f = j;
                    Y3 y3 = tl.k;
                    hashMap = tl.e;
                    HashMap a14 = AbstractC0761zb.a(a8.id);
                    y3.getClass();
                    if (!fo.a((Map) hashMap)) {
                        equals = fo.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        tl.b.put("appmetrica_clids", a7);
                        tl.g = false;
                    }
                    tl.h = j2;
                    tl.c();
                }
            }
            tl.c(a2);
            tl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            tl.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            tl.b.put("appmetrica_google_adv_id", a9);
            tl.b.put("appmetrica_huawei_oaid", a10);
            tl.b.put("appmetrica_yandex_adv_id", a11);
            tl.l.a(a12);
            tl.m.a(a13);
            if (!Tl.a(a6)) {
            }
            if (!Tl.a(a5)) {
            }
            tl.f = j;
            Y3 y32 = tl.k;
            hashMap = tl.e;
            HashMap a142 = AbstractC0761zb.a(a8.id);
            y32.getClass();
            if (!fo.a((Map) hashMap)) {
            }
            if (equals) {
            }
            tl.h = j2;
            tl.c();
        }
        C0704x4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
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

    public final C0536qa e() {
        C0486oa c0486oa;
        Tl tl = this.c;
        C0411la c0411la = tl.n;
        C0436ma c0436ma = tl.m;
        synchronized (c0436ma) {
            c0486oa = c0436ma.b;
        }
        c0411la.getClass();
        Boolean bool = c0486oa.f970a;
        return new C0536qa();
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
                a(this.f522a, this.f, this.i);
            }
        }
    }

    public Ll(Gi gi, Tl tl, Handler handler) {
        this.f522a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = gi;
        this.c = tl;
        this.d = handler;
        this.f = new Jl(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, S6 s6, Map map) {
        T6 t6 = new T6(this.d, s6);
        Gi gi = this.b;
        gi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0537qb(t6, list, map));
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = O9.f564a;
        C0331i4 c0331i4 = new C0331i4("", "", 1536, 0, anonymousInstance);
        c0331i4.m = bundle;
        C0129a5 c0129a5 = gi.f446a;
        gi.a(Gi.a(c0331i4, c0129a5), c0129a5, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (fo.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Dm.b(map);
            this.i = b;
            this.b.a(b);
            Tl tl = this.c;
            tl.getClass();
            if (!fo.a((Map) b) && !fo.a(b, tl.e)) {
                tl.e = new HashMap(b);
                tl.g = true;
                tl.c();
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
            if (fo.a((Collection) list)) {
                if (!fo.a((Collection) list2)) {
                    Tl tl = this.c;
                    tl.d = null;
                    tl.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!fo.a(list, list2)) {
                Tl tl2 = this.c;
                tl2.d = list;
                tl2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Gl gl;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    gl = Gl.UNKNOWN;
                    if (i == 1) {
                        gl = Gl.NETWORK;
                    } else if (i == 2) {
                        gl = Gl.PARSE;
                    }
                } else {
                    gl = null;
                }
                if (gl == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        gl = Gl.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, gl, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0426m0 c0426m0 = this.b.d;
                synchronized (c0426m0.f) {
                    c0426m0.c = false;
                    c0426m0.c();
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
            return AbstractC0761zb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        Tl tl = this.c;
        synchronized (tl) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) tl.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, tl.c.a(identifiersResult));
                }
            }
            tl.l.a(list, hashMap);
            tl.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0426m0 c0426m0 = this.b.d;
            synchronized (c0426m0.f) {
                c0426m0.c = true;
                c0426m0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        Tl tl = this.c;
        tl.j.getClass();
        return new AdvIdentifiersResult(O.a((IdentifiersResult) tl.b.get("appmetrica_google_adv_id")), O.a((IdentifiersResult) tl.b.get("appmetrica_huawei_oaid")), O.a((IdentifiersResult) tl.b.get("appmetrica_yandex_adv_id")));
    }
}

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
public final class Xl implements Yl {
    public static final Map k = Collections.unmodifiableMap(new Ul());

    /* renamed from: a  reason: collision with root package name */
    public final List f747a;
    public final Si b;
    public final C0260fm c;
    public final Handler d;
    public PublicLogger e;
    public final Vl f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;
    public boolean j;

    public Xl(Context context, Si si, C0512pf c0512pf, Handler handler) {
        this(si, new C0260fm(context, c0512pf), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            C0260fm c0260fm = this.c;
            c0260fm.getClass();
            if (!ro.a((Map) map) && !ro.a(map, c0260fm.e)) {
                c0260fm.e = new HashMap(map);
                c0260fm.g = true;
                c0260fm.c();
            }
            a(startupParamsCallback, list);
            if (this.c.a((List) list)) {
                a(list, new Wl(this, startupParamsCallback), map, true);
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
        IdentifiersResult a2 = C0550r4.a(bundle, "Uuid");
        IdentifiersResult a3 = C0550r4.a(bundle, "DeviceId");
        IdentifiersResult a4 = C0550r4.a(bundle, "DeviceIdHash");
        IdentifiersResult a5 = C0550r4.a(bundle, "AdUrlReport");
        IdentifiersResult a6 = C0550r4.a(bundle, "AdUrlGet");
        IdentifiersResult a7 = C0550r4.a(bundle, "Clids");
        IdentifiersResult a8 = C0550r4.a(bundle, "RequestClids");
        IdentifiersResult a9 = C0550r4.a(bundle, "GAID");
        IdentifiersResult a10 = C0550r4.a(bundle, "HOAID");
        IdentifiersResult a11 = C0550r4.a(bundle, "YANDEX_ADV_ID");
        IdentifiersResult a12 = C0550r4.a(bundle, "CUSTOM_SDK_HOSTS");
        long j = bundle.getLong("ServerTimeOffset");
        long j2 = bundle.getLong("NextStartupTime");
        C0656va a13 = C0550r4.a(bundle);
        Bundle bundle2 = bundle.getBundle("module_configs");
        C0260fm c0260fm = this.c;
        synchronized (c0260fm) {
            IdentifiersResult identifiersResult = (IdentifiersResult) c0260fm.b.get(StartupParamsCallback.APPMETRICA_UUID);
            if (identifiersResult != null) {
                vo voVar = c0260fm.o;
                String str = identifiersResult.id;
                voVar.getClass();
                if (vo.a(str)) {
                    c0260fm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
                    c0260fm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
                    c0260fm.b.put("appmetrica_google_adv_id", a9);
                    c0260fm.b.put("appmetrica_huawei_oaid", a10);
                    c0260fm.b.put("appmetrica_yandex_adv_id", a11);
                    c0260fm.l.a(a12);
                    c0260fm.m.a(a13);
                    if (!C0260fm.a(a6)) {
                        c0260fm.b.put("appmetrica_get_ad_url", a6);
                    }
                    if (!C0260fm.a(a5)) {
                        c0260fm.b.put("appmetrica_report_ad_url", a5);
                    }
                    c0260fm.f = j;
                    C0139b4 c0139b4 = c0260fm.k;
                    hashMap = c0260fm.e;
                    HashMap a14 = Gb.a(a8.id);
                    c0139b4.getClass();
                    if (!ro.a((Map) hashMap)) {
                        equals = ro.a((Map) a14);
                    } else {
                        equals = hashMap.equals(a14);
                    }
                    if (equals) {
                        c0260fm.b.put("appmetrica_clids", a7);
                        c0260fm.g = false;
                    }
                    c0260fm.h = j2;
                    c0260fm.c();
                }
            }
            c0260fm.c(a2);
            c0260fm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID, a3);
            c0260fm.a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, a4);
            c0260fm.b.put("appmetrica_google_adv_id", a9);
            c0260fm.b.put("appmetrica_huawei_oaid", a10);
            c0260fm.b.put("appmetrica_yandex_adv_id", a11);
            c0260fm.l.a(a12);
            c0260fm.m.a(a13);
            if (!C0260fm.a(a6)) {
            }
            if (!C0260fm.a(a5)) {
            }
            c0260fm.f = j;
            C0139b4 c0139b42 = c0260fm.k;
            hashMap = c0260fm.e;
            HashMap a142 = Gb.a(a8.id);
            c0139b42.getClass();
            if (!ro.a((Map) hashMap)) {
            }
            if (equals) {
            }
            c0260fm.h = j2;
            c0260fm.c();
        }
        A4.l().m().a(bundle2, new SdkIdentifiers(a2.id, a3.id, a4.id));
        h();
    }

    public final Z6 c() {
        return this.f;
    }

    public final String d() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final C0706xa e() {
        C0656va c0656va;
        C0260fm c0260fm = this.c;
        C0581sa c0581sa = c0260fm.n;
        C0606ta c0606ta = c0260fm.m;
        synchronized (c0606ta) {
            c0656va = c0606ta.b;
        }
        c0581sa.getClass();
        Boolean bool = c0656va.f1123a;
        return new C0706xa();
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
                a(this.f747a, this.f, this.i, false);
            }
        }
    }

    public Xl(Si si, C0260fm c0260fm, Handler handler) {
        this.f747a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.j = false;
        this.b = si;
        this.c = c0260fm;
        this.d = handler;
        this.f = new Vl(this);
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, Z6 z6, Map map, boolean z) {
        ResultReceiverC0116a7 resultReceiverC0116a7 = new ResultReceiverC0116a7(this.d, z6);
        Si si = this.b;
        si.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new C0707xb(resultReceiverC0116a7, list, map, z));
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = W9.f725a;
        C0397l4 c0397l4 = new C0397l4("", "", 1536, 0, anonymousInstance);
        c0397l4.m = bundle;
        C0192d5 c0192d5 = si.f672a;
        si.a(Si.a(c0397l4, c0192d5), c0192d5, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (ro.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            HashMap b = Pm.b(map);
            this.i = b;
            this.b.a(b);
            C0260fm c0260fm = this.c;
            c0260fm.getClass();
            if (!ro.a((Map) b) && !ro.a(b, c0260fm.e)) {
                c0260fm.e = new HashMap(b);
                c0260fm.g = true;
                c0260fm.c();
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
            if (ro.a((Collection) list)) {
                if (!ro.a((Collection) list2)) {
                    C0260fm c0260fm = this.c;
                    c0260fm.d = null;
                    c0260fm.i.a((List<String>) null);
                    this.b.a((List) null);
                }
            } else if (!ro.a(list, list2)) {
                C0260fm c0260fm2 = this.c;
                c0260fm2.d = list;
                c0260fm2.i.a(list);
                this.b.a(list);
            } else {
                this.b.a(list2);
            }
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Sl sl;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    sl = Sl.UNKNOWN;
                    if (i == 1) {
                        sl = Sl.NETWORK;
                    } else if (i == 2) {
                        sl = Sl.PARSE;
                    }
                } else {
                    sl = null;
                }
                if (sl == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        sl = Sl.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(k, sl, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C0471o0 c0471o0 = this.b.d;
                synchronized (c0471o0.f) {
                    c0471o0.c = false;
                    c0471o0.c();
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
            return Gb.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap hashMap = new HashMap();
        C0260fm c0260fm = this.c;
        synchronized (c0260fm) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) c0260fm.b.get(str);
                if (identifiersResult != null) {
                    hashMap.put(str, c0260fm.c.a(identifiersResult));
                }
            }
            c0260fm.l.a(list, hashMap);
            c0260fm.m.a(list, hashMap);
        }
        return new StartupParamsCallback.Result(hashMap);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C0471o0 c0471o0 = this.b.d;
            synchronized (c0471o0.f) {
                c0471o0.c = true;
                c0471o0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        C0260fm c0260fm = this.c;
        c0260fm.j.getClass();
        return new AdvIdentifiersResult(O.a((IdentifiersResult) c0260fm.b.get("appmetrica_google_adv_id")), O.a((IdentifiersResult) c0260fm.b.get("appmetrica_huawei_oaid")), O.a((IdentifiersResult) c0260fm.b.get("appmetrica_yandex_adv_id")));
    }
}

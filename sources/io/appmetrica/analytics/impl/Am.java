package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Am {

    /* renamed from: a  reason: collision with root package name */
    public final C0118ab f464a;
    public final C0556ra b;
    public final C0126aj c;
    public final C0122af d;
    public final C0362jn e;
    public final C0679w3 f;
    public final B2 g;
    public final Jb h;
    public final C0285gn i;
    public final Rd j;
    public final Y9 k;

    public Am() {
        this(new Jb(), new C0118ab(), new C0556ra(), new C0126aj(), new C0122af(), new C0362jn(), new C0679w3(), new B2(), new C0285gn(), new Rd(), new Y9());
    }

    public final void a(Fm fm, Hb hb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = hb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            fm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = hb.get("distribution_customization");
        } catch (Throwable unused) {
        }
        JSONObject optJSONObject5 = ((JSONObject) jSONObject).optJSONObject("clids");
        if (optJSONObject5 != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = optJSONObject5.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject(next);
                if (optJSONObject6 != null && optJSONObject6.has("value")) {
                    hashMap.put(next, optJSONObject6.getString("value"));
                }
            }
            fm.j = AbstractC0311hn.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = hb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        fm.m = str;
        JSONObject optJSONObject8 = hb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                fm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        Xm xm = new Xm();
        JSONObject optJSONObject9 = hb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            xm.f843a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", xm.f843a);
        }
        this.e.getClass();
        fm.p = new C0336in(xm.f843a);
        this.b.getClass();
        Tm tm = new Tm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = hb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                A4 a4 = new A4();
                a4.f450a = C0556ra.a(optJSONObject10, "permissions_collecting", tm.f781a);
                a4.b = C0556ra.a(optJSONObject10, "features_collecting", tm.b);
                a4.c = C0556ra.a(optJSONObject10, "google_aid", tm.c);
                a4.d = C0556ra.a(optJSONObject10, "sim_info", tm.d);
                a4.e = C0556ra.a(optJSONObject10, "huawei_oaid", tm.e);
                a4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                fm.b = new C4(a4);
            }
        } catch (Throwable unused4) {
        }
        this.f464a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = hb.get("query_hosts");
            } catch (Throwable unused5) {
            }
            JSONObject optJSONObject11 = ((JSONObject) jSONObject3).optJSONObject("list");
            if (optJSONObject11 != null) {
                try {
                    str2 = optJSONObject11.getJSONObject("get_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused6) {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(str2)) {
                    fm.d = str2;
                }
                ArrayList a3 = C0118ab.a(optJSONObject11, "report");
                if (!Oo.a((Collection) a3)) {
                    fm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    fm.f = str3;
                }
                ArrayList a5 = C0118ab.a(optJSONObject11, "startup");
                if (!Oo.a((Collection) a5)) {
                    fm.c = a5;
                }
                ArrayList a6 = C0118ab.a(optJSONObject11, "diagnostic");
                if (!Oo.a((Collection) a6)) {
                    fm.n = a6;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!C0118ab.f884a.contains(next2) && (a2 = C0118ab.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                fm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        Ym ym = new Ym();
        JSONObject optJSONObject12 = hb.optJSONObject("retry_policy");
        int i = ym.w;
        int i2 = ym.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", ym.x);
        }
        fm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (fm.b.f487a) {
            JSONObject optJSONObject13 = hb.optJSONObject("permissions_collecting");
            Vm vm = new Vm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", vm.f813a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", vm.b);
            } else {
                j = vm.f813a;
                j2 = vm.b;
            }
            fm.k = new Ye(j, j2);
        }
        C0679w3 c0679w3 = this.f;
        c0679w3.getClass();
        Qm qm = new Qm();
        JSONObject optJSONObject14 = hb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            qm.f737a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", qm.f737a);
        }
        c0679w3.f1257a.getClass();
        fm.r = new C0601t3(qm.f737a);
        this.g.getClass();
        B2.a(fm, hb);
        C0285gn c0285gn = this.i;
        c0285gn.getClass();
        JSONObject optJSONObject15 = hb.optJSONObject("startup_update");
        Wm wm = new Wm();
        Integer a7 = Ib.a(optJSONObject15, "interval_seconds", null);
        if (a7 != null) {
            wm.f831a = a7.intValue();
        }
        c0285gn.f1002a.getClass();
        fm.t = new C0233en(wm.f831a);
        Map<String, C0741yd> b = this.j.f745a.b();
        Qd qd = new Qd(hb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0741yd> entry : b.entrySet()) {
            Object invoke = qd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        fm.u = linkedHashMap;
        X9 x9 = this.k.f855a;
        Sm sm = new Sm();
        JSONObject optJSONObject16 = hb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            sm.f767a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", sm.f767a);
        }
        x9.getClass();
        fm.v = new W9(sm.f767a);
    }

    public Am(Jb jb, C0118ab c0118ab, C0556ra c0556ra, C0126aj c0126aj, C0122af c0122af, C0362jn c0362jn, C0679w3 c0679w3, B2 b2, C0285gn c0285gn, Rd rd, Y9 y9) {
        this.f464a = c0118ab;
        this.b = c0556ra;
        this.c = c0126aj;
        this.d = c0122af;
        this.e = c0362jn;
        this.f = c0679w3;
        this.g = b2;
        this.h = jb;
        this.i = c0285gn;
        this.j = rd;
        this.k = y9;
    }
}

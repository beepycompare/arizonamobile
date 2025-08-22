package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
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
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0209dm {

    /* renamed from: a  reason: collision with root package name */
    public final Ua f834a;
    public final C0602ta b;
    public final Xi c;
    public final Pe d;
    public final Nm e;
    public final C0644v2 f;
    public final C3 g;
    public final C0594t2 h;
    public final Eb i;
    public final Km j;
    public final Jd k;
    public final C0119aa l;

    public C0209dm() {
        this(new Eb(), new Ua(), new C0602ta(), new Xi(), new Pe(), new Nm(), new C3(), new C0644v2(), new C0594t2(), new Km(), new Jd(), new C0119aa());
    }

    public final void a(C0337im c0337im, Cb cb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = cb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0337im.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = cb.get("distribution_customization");
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
            c0337im.j = Lm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = cb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0337im.m = str;
        JSONObject optJSONObject8 = cb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0337im.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        Bm bm = new Bm();
        JSONObject optJSONObject9 = cb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            bm.f368a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", bm.f368a);
        }
        this.e.getClass();
        c0337im.p = new Mm(bm.f368a);
        this.b.getClass();
        C0714xm c0714xm = new C0714xm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = cb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                E4 e4 = new E4();
                e4.f407a = C0602ta.a(optJSONObject10, "permissions_collecting", c0714xm.f1145a);
                e4.b = C0602ta.a(optJSONObject10, "features_collecting", c0714xm.b);
                e4.c = C0602ta.a(optJSONObject10, "google_aid", c0714xm.c);
                e4.d = C0602ta.a(optJSONObject10, "sim_info", c0714xm.d);
                e4.e = C0602ta.a(optJSONObject10, "huawei_oaid", c0714xm.e);
                e4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0337im.b = new G4(e4);
            }
        } catch (Throwable unused4) {
        }
        this.f834a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = cb.get("query_hosts");
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
                    c0337im.d = str2;
                }
                ArrayList a3 = Ua.a(optJSONObject11, "report");
                if (!no.a((Collection) a3)) {
                    c0337im.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0337im.f = str3;
                }
                ArrayList a4 = Ua.a(optJSONObject11, "startup");
                if (!no.a((Collection) a4)) {
                    c0337im.c = a4;
                }
                ArrayList a5 = Ua.a(optJSONObject11, "diagnostic");
                if (!no.a((Collection) a5)) {
                    c0337im.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Ua.f676a.contains(next2) && (a2 = Ua.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0337im.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        Cm cm = new Cm();
        JSONObject optJSONObject12 = cb.optJSONObject("retry_policy");
        int i = cm.w;
        int i2 = cm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", cm.x);
        }
        c0337im.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0337im.b.f448a) {
            JSONObject optJSONObject13 = cb.optJSONObject("permissions_collecting");
            C0764zm c0764zm = new C0764zm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0764zm.f1185a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0764zm.b);
            } else {
                j = c0764zm.f1185a;
                j2 = c0764zm.b;
            }
            c0337im.k = new Ne(j, j2);
        }
        C0619u2 c0619u2 = this.f.f1096a;
        C0614tm c0614tm = new C0614tm();
        JSONObject optJSONObject14 = cb.optJSONObject("auto_inapp_collecting");
        if (optJSONObject14 != null) {
            c0614tm.f1078a = optJSONObject14.optInt("send_frequency_seconds", c0614tm.f1078a);
            c0614tm.b = optJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c0614tm.b);
        }
        c0619u2.getClass();
        c0337im.r = new BillingConfig(c0614tm.f1078a, c0614tm.b);
        C3 c3 = this.g;
        c3.getClass();
        C0639um c0639um = new C0639um();
        JSONObject optJSONObject15 = cb.optJSONObject("cache_control");
        if (optJSONObject15 != null) {
            c0639um.f1093a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject15, "last_known_location_ttl", c0639um.f1093a);
        }
        c3.f372a.getClass();
        c0337im.s = new C0745z3(c0639um.f1093a);
        this.h.getClass();
        C0594t2.a(c0337im, cb);
        Km km = this.j;
        km.getClass();
        JSONObject optJSONObject16 = cb.optJSONObject("startup_update");
        Am am = new Am();
        Integer a6 = Db.a(optJSONObject16, "interval_seconds", null);
        if (a6 != null) {
            am.f350a = a6.intValue();
        }
        km.f534a.getClass();
        c0337im.u = new Im(am.f350a);
        Map<String, C0655vd> c = this.k.f514a.c();
        Id id = new Id(cb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0655vd> entry : c.entrySet()) {
            Object invoke = id.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0337im.v = linkedHashMap;
        Z9 z9 = this.l.f774a;
        C0689wm c0689wm = new C0689wm();
        JSONObject optJSONObject17 = cb.optJSONObject("external_attribution");
        if (optJSONObject17 != null) {
            c0689wm.f1128a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject17, "collecting_interval_seconds", c0689wm.f1128a);
        }
        z9.getClass();
        c0337im.w = new Y9(c0689wm.f1128a);
    }

    public C0209dm(Eb eb, Ua ua, C0602ta c0602ta, Xi xi, Pe pe, Nm nm, C3 c3, C0644v2 c0644v2, C0594t2 c0594t2, Km km, Jd jd, C0119aa c0119aa) {
        this.f834a = ua;
        this.b = c0602ta;
        this.c = xi;
        this.d = pe;
        this.e = nm;
        this.g = c3;
        this.f = c0644v2;
        this.h = c0594t2;
        this.i = eb;
        this.j = km;
        this.k = jd;
        this.l = c0119aa;
    }
}

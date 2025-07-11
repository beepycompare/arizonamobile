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
/* loaded from: classes4.dex */
public final class Vl {

    /* renamed from: a  reason: collision with root package name */
    public final Qa f678a;
    public final C0503pa b;
    public final Pi c;
    public final Le d;
    public final Fm e;
    public final C0644v2 f;
    public final C3 g;
    public final C0594t2 h;
    public final Ab i;
    public final Cm j;
    public final Fd k;
    public final W9 l;

    public Vl() {
        this(new Ab(), new Qa(), new C0503pa(), new Pi(), new Le(), new Fm(), new C3(), new C0644v2(), new C0594t2(), new Cm(), new Fd(), new W9());
    }

    public final void a(C0138am c0138am, C0728yb c0728yb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0728yb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0138am.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0728yb.get("distribution_customization");
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
            c0138am.j = Dm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0728yb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0138am.m = str;
        JSONObject optJSONObject8 = c0728yb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0138am.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0614tm c0614tm = new C0614tm();
        JSONObject optJSONObject9 = c0728yb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0614tm.f1064a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0614tm.f1064a);
        }
        this.e.getClass();
        c0138am.p = new Em(c0614tm.f1064a);
        this.b.getClass();
        C0515pm c0515pm = new C0515pm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0728yb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                E4 e4 = new E4();
                e4.f401a = C0503pa.a(optJSONObject10, "permissions_collecting", c0515pm.f995a);
                e4.b = C0503pa.a(optJSONObject10, "features_collecting", c0515pm.b);
                e4.c = C0503pa.a(optJSONObject10, "google_aid", c0515pm.c);
                e4.d = C0503pa.a(optJSONObject10, "sim_info", c0515pm.d);
                e4.e = C0503pa.a(optJSONObject10, "huawei_oaid", c0515pm.e);
                e4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0138am.b = new G4(e4);
            }
        } catch (Throwable unused4) {
        }
        this.f678a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0728yb.get("query_hosts");
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
                    c0138am.d = str2;
                }
                ArrayList a3 = Qa.a(optJSONObject11, "report");
                if (!fo.a((Collection) a3)) {
                    c0138am.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0138am.f = str3;
                }
                ArrayList a4 = Qa.a(optJSONObject11, "startup");
                if (!fo.a((Collection) a4)) {
                    c0138am.c = a4;
                }
                ArrayList a5 = Qa.a(optJSONObject11, "diagnostic");
                if (!fo.a((Collection) a5)) {
                    c0138am.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Qa.f594a.contains(next2) && (a2 = Qa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0138am.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0639um c0639um = new C0639um();
        JSONObject optJSONObject12 = c0728yb.optJSONObject("retry_policy");
        int i = c0639um.w;
        int i2 = c0639um.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0639um.x);
        }
        c0138am.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0138am.b.f438a) {
            JSONObject optJSONObject13 = c0728yb.optJSONObject("permissions_collecting");
            C0564rm c0564rm = new C0564rm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0564rm.f1032a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0564rm.b);
            } else {
                j = c0564rm.f1032a;
                j2 = c0564rm.b;
            }
            c0138am.k = new Je(j, j2);
        }
        C0619u2 c0619u2 = this.f.f1084a;
        C0415lm c0415lm = new C0415lm();
        JSONObject optJSONObject14 = c0728yb.optJSONObject("auto_inapp_collecting");
        if (optJSONObject14 != null) {
            c0415lm.f928a = optJSONObject14.optInt("send_frequency_seconds", c0415lm.f928a);
            c0415lm.b = optJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c0415lm.b);
        }
        c0619u2.getClass();
        c0138am.r = new BillingConfig(c0415lm.f928a, c0415lm.b);
        C3 c3 = this.g;
        c3.getClass();
        C0440mm c0440mm = new C0440mm();
        JSONObject optJSONObject15 = c0728yb.optJSONObject("cache_control");
        if (optJSONObject15 != null) {
            c0440mm.f946a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject15, "last_known_location_ttl", c0440mm.f946a);
        }
        c3.f365a.getClass();
        c0138am.s = new C0745z3(c0440mm.f946a);
        this.h.getClass();
        C0594t2.a(c0138am, c0728yb);
        Cm cm = this.j;
        cm.getClass();
        JSONObject optJSONObject16 = c0728yb.optJSONObject("startup_update");
        C0589sm c0589sm = new C0589sm();
        Integer a6 = AbstractC0753zb.a(optJSONObject16, "interval_seconds", null);
        if (a6 != null) {
            c0589sm.f1049a = a6.intValue();
        }
        cm.f379a.getClass();
        c0138am.u = new Am(c0589sm.f1049a);
        Map<String, C0555rd> c = this.k.f429a.c();
        Ed ed = new Ed(c0728yb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0555rd> entry : c.entrySet()) {
            Object invoke = ed.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0138am.v = linkedHashMap;
        V9 v9 = this.l.f685a;
        C0490om c0490om = new C0490om();
        JSONObject optJSONObject17 = c0728yb.optJSONObject("external_attribution");
        if (optJSONObject17 != null) {
            c0490om.f980a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject17, "collecting_interval_seconds", c0490om.f980a);
        }
        v9.getClass();
        c0138am.w = new U9(c0490om.f980a);
    }

    public Vl(Ab ab, Qa qa, C0503pa c0503pa, Pi pi, Le le, Fm fm, C3 c3, C0644v2 c0644v2, C0594t2 c0594t2, Cm cm, Fd fd, W9 w9) {
        this.f678a = qa;
        this.b = c0503pa;
        this.c = pi;
        this.d = le;
        this.e = fm;
        this.g = c3;
        this.f = c0644v2;
        this.h = c0594t2;
        this.i = ab;
        this.j = cm;
        this.k = fd;
        this.l = w9;
    }
}

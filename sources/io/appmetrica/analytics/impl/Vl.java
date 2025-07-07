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
    public final Qa f677a;
    public final C0511pa b;
    public final Pi c;
    public final Le d;
    public final Fm e;
    public final C0652v2 f;
    public final C3 g;
    public final C0602t2 h;
    public final Ab i;
    public final Cm j;
    public final Fd k;
    public final W9 l;

    public Vl() {
        this(new Ab(), new Qa(), new C0511pa(), new Pi(), new Le(), new Fm(), new C3(), new C0652v2(), new C0602t2(), new Cm(), new Fd(), new W9());
    }

    public final void a(C0146am c0146am, C0736yb c0736yb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0736yb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0146am.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0736yb.get("distribution_customization");
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
            c0146am.j = Dm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0736yb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0146am.m = str;
        JSONObject optJSONObject8 = c0736yb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0146am.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0622tm c0622tm = new C0622tm();
        JSONObject optJSONObject9 = c0736yb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0622tm.f1063a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0622tm.f1063a);
        }
        this.e.getClass();
        c0146am.p = new Em(c0622tm.f1063a);
        this.b.getClass();
        C0523pm c0523pm = new C0523pm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0736yb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                E4 e4 = new E4();
                e4.f400a = C0511pa.a(optJSONObject10, "permissions_collecting", c0523pm.f994a);
                e4.b = C0511pa.a(optJSONObject10, "features_collecting", c0523pm.b);
                e4.c = C0511pa.a(optJSONObject10, "google_aid", c0523pm.c);
                e4.d = C0511pa.a(optJSONObject10, "sim_info", c0523pm.d);
                e4.e = C0511pa.a(optJSONObject10, "huawei_oaid", c0523pm.e);
                e4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0146am.b = new G4(e4);
            }
        } catch (Throwable unused4) {
        }
        this.f677a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0736yb.get("query_hosts");
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
                    c0146am.d = str2;
                }
                ArrayList a3 = Qa.a(optJSONObject11, "report");
                if (!fo.a((Collection) a3)) {
                    c0146am.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0146am.f = str3;
                }
                ArrayList a4 = Qa.a(optJSONObject11, "startup");
                if (!fo.a((Collection) a4)) {
                    c0146am.c = a4;
                }
                ArrayList a5 = Qa.a(optJSONObject11, "diagnostic");
                if (!fo.a((Collection) a5)) {
                    c0146am.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Qa.f593a.contains(next2) && (a2 = Qa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0146am.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0647um c0647um = new C0647um();
        JSONObject optJSONObject12 = c0736yb.optJSONObject("retry_policy");
        int i = c0647um.w;
        int i2 = c0647um.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0647um.x);
        }
        c0146am.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0146am.b.f437a) {
            JSONObject optJSONObject13 = c0736yb.optJSONObject("permissions_collecting");
            C0572rm c0572rm = new C0572rm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0572rm.f1031a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0572rm.b);
            } else {
                j = c0572rm.f1031a;
                j2 = c0572rm.b;
            }
            c0146am.k = new Je(j, j2);
        }
        C0627u2 c0627u2 = this.f.f1083a;
        C0423lm c0423lm = new C0423lm();
        JSONObject optJSONObject14 = c0736yb.optJSONObject("auto_inapp_collecting");
        if (optJSONObject14 != null) {
            c0423lm.f927a = optJSONObject14.optInt("send_frequency_seconds", c0423lm.f927a);
            c0423lm.b = optJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c0423lm.b);
        }
        c0627u2.getClass();
        c0146am.r = new BillingConfig(c0423lm.f927a, c0423lm.b);
        C3 c3 = this.g;
        c3.getClass();
        C0448mm c0448mm = new C0448mm();
        JSONObject optJSONObject15 = c0736yb.optJSONObject("cache_control");
        if (optJSONObject15 != null) {
            c0448mm.f945a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject15, "last_known_location_ttl", c0448mm.f945a);
        }
        c3.f364a.getClass();
        c0146am.s = new C0753z3(c0448mm.f945a);
        this.h.getClass();
        C0602t2.a(c0146am, c0736yb);
        Cm cm = this.j;
        cm.getClass();
        JSONObject optJSONObject16 = c0736yb.optJSONObject("startup_update");
        C0597sm c0597sm = new C0597sm();
        Integer a6 = AbstractC0761zb.a(optJSONObject16, "interval_seconds", null);
        if (a6 != null) {
            c0597sm.f1048a = a6.intValue();
        }
        cm.f378a.getClass();
        c0146am.u = new Am(c0597sm.f1048a);
        Map<String, C0563rd> c = this.k.f428a.c();
        Ed ed = new Ed(c0736yb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0563rd> entry : c.entrySet()) {
            Object invoke = ed.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0146am.v = linkedHashMap;
        V9 v9 = this.l.f684a;
        C0498om c0498om = new C0498om();
        JSONObject optJSONObject17 = c0736yb.optJSONObject("external_attribution");
        if (optJSONObject17 != null) {
            c0498om.f979a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject17, "collecting_interval_seconds", c0498om.f979a);
        }
        v9.getClass();
        c0146am.w = new U9(c0498om.f979a);
    }

    public Vl(Ab ab, Qa qa, C0511pa c0511pa, Pi pi, Le le, Fm fm, C3 c3, C0652v2 c0652v2, C0602t2 c0602t2, Cm cm, Fd fd, W9 w9) {
        this.f677a = qa;
        this.b = c0511pa;
        this.c = pi;
        this.d = le;
        this.e = fm;
        this.g = c3;
        this.f = c0652v2;
        this.h = c0602t2;
        this.i = ab;
        this.j = cm;
        this.k = fd;
        this.l = w9;
    }
}

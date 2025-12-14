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
public final class Zl {

    /* renamed from: a  reason: collision with root package name */
    public final C0719ya f882a;
    public final X9 b;
    public final Gi c;
    public final Ae d;
    public final Im e;
    public final C0285h3 f;
    public final C0487p2 g;
    public final C0319ib h;
    public final Fm i;
    public final C0572sd j;
    public final E9 k;

    public Zl() {
        this(new C0319ib(), new C0719ya(), new X9(), new Gi(), new Ae(), new Im(), new C0285h3(), new C0487p2(), new Fm(), new C0572sd(), new E9());
    }

    public final void a(C0226em c0226em, C0267gb c0267gb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0267gb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0226em.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0267gb.get("distribution_customization");
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
            c0226em.j = Gm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0267gb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0226em.m = str;
        JSONObject optJSONObject8 = c0267gb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0226em.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0681wm c0681wm = new C0681wm();
        JSONObject optJSONObject9 = c0267gb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0681wm.f1284a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0681wm.f1284a);
        }
        this.e.getClass();
        c0226em.p = new Hm(c0681wm.f1284a);
        this.b.getClass();
        C0581sm c0581sm = new C0581sm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0267gb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                C0363k4 c0363k4 = new C0363k4();
                c0363k4.f1065a = X9.a(optJSONObject10, "permissions_collecting", c0581sm.f1221a);
                c0363k4.b = X9.a(optJSONObject10, "features_collecting", c0581sm.b);
                c0363k4.c = X9.a(optJSONObject10, "google_aid", c0581sm.c);
                c0363k4.d = X9.a(optJSONObject10, "sim_info", c0581sm.d);
                c0363k4.e = X9.a(optJSONObject10, "huawei_oaid", c0581sm.e);
                c0363k4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0226em.b = new C0414m4(c0363k4);
            }
        } catch (Throwable unused4) {
        }
        this.f882a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0267gb.get("query_hosts");
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
                    c0226em.d = str2;
                }
                ArrayList a3 = C0719ya.a(optJSONObject11, "report");
                if (!mo.a((Collection) a3)) {
                    c0226em.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0226em.f = str3;
                }
                ArrayList a4 = C0719ya.a(optJSONObject11, "startup");
                if (!mo.a((Collection) a4)) {
                    c0226em.c = a4;
                }
                ArrayList a5 = C0719ya.a(optJSONObject11, "diagnostic");
                if (!mo.a((Collection) a5)) {
                    c0226em.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!C0719ya.f1313a.contains(next2) && (a2 = C0719ya.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0226em.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0706xm c0706xm = new C0706xm();
        JSONObject optJSONObject12 = c0267gb.optJSONObject("retry_policy");
        int i = c0706xm.w;
        int i2 = c0706xm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0706xm.x);
        }
        c0226em.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0226em.b.f1100a) {
            JSONObject optJSONObject13 = c0267gb.optJSONObject("permissions_collecting");
            C0631um c0631um = new C0631um();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0631um.f1251a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0631um.b);
            } else {
                j = c0631um.f1251a;
                j2 = c0631um.b;
            }
            c0226em.k = new C0723ye(j, j2);
        }
        C0285h3 c0285h3 = this.f;
        c0285h3.getClass();
        C0507pm c0507pm = new C0507pm();
        JSONObject optJSONObject14 = c0267gb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            c0507pm.f1171a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", c0507pm.f1171a);
        }
        c0285h3.f1013a.getClass();
        c0226em.r = new C0207e3(c0507pm.f1171a);
        this.g.getClass();
        C0487p2.a(c0226em, c0267gb);
        Fm fm = this.i;
        fm.getClass();
        JSONObject optJSONObject15 = c0267gb.optJSONObject("startup_update");
        C0656vm c0656vm = new C0656vm();
        Integer a6 = AbstractC0293hb.a(optJSONObject15, "interval_seconds", null);
        if (a6 != null) {
            c0656vm.f1271a = a6.intValue();
        }
        fm.f580a.getClass();
        c0226em.t = new Dm(c0656vm.f1271a);
        Map<String, Zc> c = this.j.f1215a.c();
        C0547rd c0547rd = new C0547rd(c0267gb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Zc> entry : c.entrySet()) {
            Object invoke = c0547rd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0226em.u = linkedHashMap;
        D9 d9 = this.k.f555a;
        C0556rm c0556rm = new C0556rm();
        JSONObject optJSONObject16 = c0267gb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            c0556rm.f1203a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", c0556rm.f1203a);
        }
        d9.getClass();
        c0226em.v = new C9(c0556rm.f1203a);
    }

    public Zl(C0319ib c0319ib, C0719ya c0719ya, X9 x9, Gi gi, Ae ae, Im im, C0285h3 c0285h3, C0487p2 c0487p2, Fm fm, C0572sd c0572sd, E9 e9) {
        this.f882a = c0719ya;
        this.b = x9;
        this.c = gi;
        this.d = ae;
        this.e = im;
        this.f = c0285h3;
        this.g = c0487p2;
        this.h = c0319ib;
        this.i = fm;
        this.j = c0572sd;
        this.k = e9;
    }
}

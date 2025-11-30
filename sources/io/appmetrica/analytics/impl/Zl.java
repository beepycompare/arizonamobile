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
    public final C0720ya f785a;
    public final X9 b;
    public final Gi c;
    public final Ae d;
    public final Im e;
    public final C0286h3 f;
    public final C0488p2 g;
    public final C0320ib h;
    public final Fm i;
    public final C0573sd j;
    public final E9 k;

    public Zl() {
        this(new C0320ib(), new C0720ya(), new X9(), new Gi(), new Ae(), new Im(), new C0286h3(), new C0488p2(), new Fm(), new C0573sd(), new E9());
    }

    public final void a(C0227em c0227em, C0268gb c0268gb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0268gb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0227em.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0268gb.get("distribution_customization");
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
            c0227em.j = Gm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0268gb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0227em.m = str;
        JSONObject optJSONObject8 = c0268gb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0227em.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0682wm c0682wm = new C0682wm();
        JSONObject optJSONObject9 = c0268gb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0682wm.f1187a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0682wm.f1187a);
        }
        this.e.getClass();
        c0227em.p = new Hm(c0682wm.f1187a);
        this.b.getClass();
        C0582sm c0582sm = new C0582sm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0268gb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                C0364k4 c0364k4 = new C0364k4();
                c0364k4.f968a = X9.a(optJSONObject10, "permissions_collecting", c0582sm.f1124a);
                c0364k4.b = X9.a(optJSONObject10, "features_collecting", c0582sm.b);
                c0364k4.c = X9.a(optJSONObject10, "google_aid", c0582sm.c);
                c0364k4.d = X9.a(optJSONObject10, "sim_info", c0582sm.d);
                c0364k4.e = X9.a(optJSONObject10, "huawei_oaid", c0582sm.e);
                c0364k4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0227em.b = new C0415m4(c0364k4);
            }
        } catch (Throwable unused4) {
        }
        this.f785a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0268gb.get("query_hosts");
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
                    c0227em.d = str2;
                }
                ArrayList a3 = C0720ya.a(optJSONObject11, "report");
                if (!mo.a((Collection) a3)) {
                    c0227em.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0227em.f = str3;
                }
                ArrayList a4 = C0720ya.a(optJSONObject11, "startup");
                if (!mo.a((Collection) a4)) {
                    c0227em.c = a4;
                }
                ArrayList a5 = C0720ya.a(optJSONObject11, "diagnostic");
                if (!mo.a((Collection) a5)) {
                    c0227em.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!C0720ya.f1216a.contains(next2) && (a2 = C0720ya.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0227em.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0707xm c0707xm = new C0707xm();
        JSONObject optJSONObject12 = c0268gb.optJSONObject("retry_policy");
        int i = c0707xm.w;
        int i2 = c0707xm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0707xm.x);
        }
        c0227em.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0227em.b.f1003a) {
            JSONObject optJSONObject13 = c0268gb.optJSONObject("permissions_collecting");
            C0632um c0632um = new C0632um();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0632um.f1154a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0632um.b);
            } else {
                j = c0632um.f1154a;
                j2 = c0632um.b;
            }
            c0227em.k = new C0724ye(j, j2);
        }
        C0286h3 c0286h3 = this.f;
        c0286h3.getClass();
        C0508pm c0508pm = new C0508pm();
        JSONObject optJSONObject14 = c0268gb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            c0508pm.f1074a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", c0508pm.f1074a);
        }
        c0286h3.f916a.getClass();
        c0227em.r = new C0208e3(c0508pm.f1074a);
        this.g.getClass();
        C0488p2.a(c0227em, c0268gb);
        Fm fm = this.i;
        fm.getClass();
        JSONObject optJSONObject15 = c0268gb.optJSONObject("startup_update");
        C0657vm c0657vm = new C0657vm();
        Integer a6 = AbstractC0294hb.a(optJSONObject15, "interval_seconds", null);
        if (a6 != null) {
            c0657vm.f1174a = a6.intValue();
        }
        fm.f483a.getClass();
        c0227em.t = new Dm(c0657vm.f1174a);
        Map<String, Zc> c = this.j.f1118a.c();
        C0548rd c0548rd = new C0548rd(c0268gb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Zc> entry : c.entrySet()) {
            Object invoke = c0548rd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0227em.u = linkedHashMap;
        D9 d9 = this.k.f458a;
        C0557rm c0557rm = new C0557rm();
        JSONObject optJSONObject16 = c0268gb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            c0557rm.f1106a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", c0557rm.f1106a);
        }
        d9.getClass();
        c0227em.v = new C9(c0557rm.f1106a);
    }

    public Zl(C0320ib c0320ib, C0720ya c0720ya, X9 x9, Gi gi, Ae ae, Im im, C0286h3 c0286h3, C0488p2 c0488p2, Fm fm, C0573sd c0573sd, E9 e9) {
        this.f785a = c0720ya;
        this.b = x9;
        this.c = gi;
        this.d = ae;
        this.e = im;
        this.f = c0286h3;
        this.g = c0488p2;
        this.h = c0320ib;
        this.i = fm;
        this.j = c0573sd;
        this.k = e9;
    }
}

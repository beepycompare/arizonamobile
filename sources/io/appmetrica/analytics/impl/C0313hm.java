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
/* renamed from: io.appmetrica.analytics.impl.hm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0313hm {

    /* renamed from: a  reason: collision with root package name */
    public final Xa f914a;
    public final C0682wa b;
    public final C0155bj c;
    public final Te d;
    public final Rm e;
    public final C0724y2 f;
    public final F3 g;
    public final C0649v2 h;
    public final Hb i;
    public final Om j;
    public final Nd k;
    public final C0198da l;

    public C0313hm() {
        this(new Hb(), new Xa(), new C0682wa(), new C0155bj(), new Te(), new Rm(), new F3(), new C0724y2(), new C0649v2(), new Om(), new Nd(), new C0198da());
    }

    public final void a(C0442mm c0442mm, Fb fb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = fb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0442mm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = fb.get("distribution_customization");
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
            c0442mm.j = Pm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = fb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0442mm.m = str;
        JSONObject optJSONObject8 = fb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0442mm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        Fm fm = new Fm();
        JSONObject optJSONObject9 = fb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            fm.f451a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", fm.f451a);
        }
        this.e.getClass();
        c0442mm.p = new Qm(fm.f451a);
        this.b.getClass();
        Bm bm = new Bm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = fb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                H4 h4 = new H4();
                h4.f472a = C0682wa.a(optJSONObject10, "permissions_collecting", bm.f376a);
                h4.b = C0682wa.a(optJSONObject10, "features_collecting", bm.b);
                h4.c = C0682wa.a(optJSONObject10, "google_aid", bm.c);
                h4.d = C0682wa.a(optJSONObject10, "sim_info", bm.d);
                h4.e = C0682wa.a(optJSONObject10, "huawei_oaid", bm.e);
                h4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0442mm.b = new J4(h4);
            }
        } catch (Throwable unused4) {
        }
        this.f914a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = fb.get("query_hosts");
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
                    c0442mm.d = str2;
                }
                ArrayList a3 = Xa.a(optJSONObject11, "report");
                if (!ro.a((Collection) a3)) {
                    c0442mm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0442mm.f = str3;
                }
                ArrayList a4 = Xa.a(optJSONObject11, "startup");
                if (!ro.a((Collection) a4)) {
                    c0442mm.c = a4;
                }
                ArrayList a5 = Xa.a(optJSONObject11, "diagnostic");
                if (!ro.a((Collection) a5)) {
                    c0442mm.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Xa.f741a.contains(next2) && (a2 = Xa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0442mm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        Gm gm = new Gm();
        JSONObject optJSONObject12 = fb.optJSONObject("retry_policy");
        int i = gm.w;
        int i2 = gm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", gm.x);
        }
        c0442mm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0442mm.b.f510a) {
            JSONObject optJSONObject13 = fb.optJSONObject("permissions_collecting");
            Dm dm = new Dm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", dm.f416a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", dm.b);
            } else {
                j = dm.f416a;
                j2 = dm.b;
            }
            c0442mm.k = new Re(j, j2);
        }
        C0699x2 c0699x2 = this.f.f1164a;
        C0719xm c0719xm = new C0719xm();
        JSONObject optJSONObject14 = fb.optJSONObject("auto_inapp_collecting");
        if (optJSONObject14 != null) {
            c0719xm.f1161a = optJSONObject14.optInt("send_frequency_seconds", c0719xm.f1161a);
            c0719xm.b = optJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c0719xm.b);
        }
        c0699x2.getClass();
        c0442mm.r = new BillingConfig(c0719xm.f1161a, c0719xm.b);
        F3 f3 = this.g;
        f3.getClass();
        C0744ym c0744ym = new C0744ym();
        JSONObject optJSONObject15 = fb.optJSONObject("cache_control");
        if (optJSONObject15 != null) {
            c0744ym.f1177a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject15, "last_known_location_ttl", c0744ym.f1177a);
        }
        f3.f437a.getClass();
        c0442mm.s = new C3(c0744ym.f1177a);
        this.h.getClass();
        C0649v2.a(c0442mm, fb);
        Om om = this.j;
        om.getClass();
        JSONObject optJSONObject16 = fb.optJSONObject("startup_update");
        Em em = new Em();
        Integer a6 = Gb.a(optJSONObject16, "interval_seconds", null);
        if (a6 != null) {
            em.f432a = a6.intValue();
        }
        om.f615a.getClass();
        c0442mm.u = new Mm(em.f432a);
        Map<String, C0735yd> c = this.k.f595a.c();
        Md md = new Md(fb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0735yd> entry : c.entrySet()) {
            Object invoke = md.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0442mm.v = linkedHashMap;
        C0172ca c0172ca = this.l.f841a;
        Am am = new Am();
        JSONObject optJSONObject17 = fb.optJSONObject("external_attribution");
        if (optJSONObject17 != null) {
            am.f356a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject17, "collecting_interval_seconds", am.f356a);
        }
        c0172ca.getClass();
        c0442mm.w = new C0146ba(am.f356a);
    }

    public C0313hm(Hb hb, Xa xa, C0682wa c0682wa, C0155bj c0155bj, Te te, Rm rm, F3 f3, C0724y2 c0724y2, C0649v2 c0649v2, Om om, Nd nd, C0198da c0198da) {
        this.f914a = xa;
        this.b = c0682wa;
        this.c = c0155bj;
        this.d = te;
        this.e = rm;
        this.g = f3;
        this.f = c0724y2;
        this.h = c0649v2;
        this.i = hb;
        this.j = om;
        this.k = nd;
        this.l = c0198da;
    }
}

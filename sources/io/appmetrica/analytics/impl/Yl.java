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
public final class Yl {

    /* renamed from: a  reason: collision with root package name */
    public final Sa f739a;
    public final C0554ra b;
    public final Si c;
    public final Ne d;
    public final Im e;
    public final C0646v2 f;
    public final C3 g;
    public final C0596t2 h;
    public final Cb i;
    public final Fm j;
    public final Hd k;
    public final Y9 l;

    public Yl() {
        this(new Cb(), new Sa(), new C0554ra(), new Si(), new Ne(), new Im(), new C3(), new C0646v2(), new C0596t2(), new Fm(), new Hd(), new Y9());
    }

    public final void a(C0216dm c0216dm, Ab ab) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = ab.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0216dm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = ab.get("distribution_customization");
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
            c0216dm.j = Gm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = ab.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0216dm.m = str;
        JSONObject optJSONObject8 = ab.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0216dm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0691wm c0691wm = new C0691wm();
        JSONObject optJSONObject9 = ab.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0691wm.f1126a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0691wm.f1126a);
        }
        this.e.getClass();
        c0216dm.p = new Hm(c0691wm.f1126a);
        this.b.getClass();
        C0591sm c0591sm = new C0591sm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = ab.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                E4 e4 = new E4();
                e4.f411a = C0554ra.a(optJSONObject10, "permissions_collecting", c0591sm.f1057a);
                e4.b = C0554ra.a(optJSONObject10, "features_collecting", c0591sm.b);
                e4.c = C0554ra.a(optJSONObject10, "google_aid", c0591sm.c);
                e4.d = C0554ra.a(optJSONObject10, "sim_info", c0591sm.d);
                e4.e = C0554ra.a(optJSONObject10, "huawei_oaid", c0591sm.e);
                e4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0216dm.b = new G4(e4);
            }
        } catch (Throwable unused4) {
        }
        this.f739a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = ab.get("query_hosts");
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
                    c0216dm.d = str2;
                }
                ArrayList a3 = Sa.a(optJSONObject11, "report");
                if (!io.a((Collection) a3)) {
                    c0216dm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0216dm.f = str3;
                }
                ArrayList a4 = Sa.a(optJSONObject11, "startup");
                if (!io.a((Collection) a4)) {
                    c0216dm.c = a4;
                }
                ArrayList a5 = Sa.a(optJSONObject11, "diagnostic");
                if (!io.a((Collection) a5)) {
                    c0216dm.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Sa.f639a.contains(next2) && (a2 = Sa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0216dm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0716xm c0716xm = new C0716xm();
        JSONObject optJSONObject12 = ab.optJSONObject("retry_policy");
        int i = c0716xm.w;
        int i2 = c0716xm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0716xm.x);
        }
        c0216dm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0216dm.b.f447a) {
            JSONObject optJSONObject13 = ab.optJSONObject("permissions_collecting");
            C0641um c0641um = new C0641um();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0641um.f1090a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0641um.b);
            } else {
                j = c0641um.f1090a;
                j2 = c0641um.b;
            }
            c0216dm.k = new Le(j, j2);
        }
        C0621u2 c0621u2 = this.f.f1094a;
        C0492om c0492om = new C0492om();
        JSONObject optJSONObject14 = ab.optJSONObject("auto_inapp_collecting");
        if (optJSONObject14 != null) {
            c0492om.f993a = optJSONObject14.optInt("send_frequency_seconds", c0492om.f993a);
            c0492om.b = optJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c0492om.b);
        }
        c0621u2.getClass();
        c0216dm.r = new BillingConfig(c0492om.f993a, c0492om.b);
        C3 c3 = this.g;
        c3.getClass();
        C0517pm c0517pm = new C0517pm();
        JSONObject optJSONObject15 = ab.optJSONObject("cache_control");
        if (optJSONObject15 != null) {
            c0517pm.f1008a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject15, "last_known_location_ttl", c0517pm.f1008a);
        }
        c3.f370a.getClass();
        c0216dm.s = new C0747z3(c0517pm.f1008a);
        this.h.getClass();
        C0596t2.a(c0216dm, ab);
        Fm fm = this.j;
        fm.getClass();
        JSONObject optJSONObject16 = ab.optJSONObject("startup_update");
        C0666vm c0666vm = new C0666vm();
        Integer a6 = Bb.a(optJSONObject16, "interval_seconds", null);
        if (a6 != null) {
            c0666vm.f1106a = a6.intValue();
        }
        fm.f442a.getClass();
        c0216dm.u = new Dm(c0666vm.f1106a);
        Map<String, C0607td> c = this.k.f471a.c();
        Gd gd = new Gd(ab);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0607td> entry : c.entrySet()) {
            Object invoke = gd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0216dm.v = linkedHashMap;
        X9 x9 = this.l.f732a;
        C0566rm c0566rm = new C0566rm();
        JSONObject optJSONObject17 = ab.optJSONObject("external_attribution");
        if (optJSONObject17 != null) {
            c0566rm.f1043a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject17, "collecting_interval_seconds", c0566rm.f1043a);
        }
        x9.getClass();
        c0216dm.w = new W9(c0566rm.f1043a);
    }

    public Yl(Cb cb, Sa sa, C0554ra c0554ra, Si si, Ne ne, Im im, C3 c3, C0646v2 c0646v2, C0596t2 c0596t2, Fm fm, Hd hd, Y9 y9) {
        this.f739a = sa;
        this.b = c0554ra;
        this.c = si;
        this.d = ne;
        this.e = im;
        this.g = c3;
        this.f = c0646v2;
        this.h = c0596t2;
        this.i = cb;
        this.j = fm;
        this.k = hd;
        this.l = y9;
    }
}

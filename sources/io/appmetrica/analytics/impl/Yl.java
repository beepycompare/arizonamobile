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
public final class Yl {

    /* renamed from: a  reason: collision with root package name */
    public final C0697xa f878a;
    public final W9 b;
    public final Fi c;
    public final C0751ze d;
    public final Hm e;
    public final C0263g3 f;
    public final C0465o2 g;
    public final C0297hb h;
    public final Em i;
    public final C0550rd j;
    public final D9 k;

    public Yl() {
        this(new C0297hb(), new C0697xa(), new W9(), new Fi(), new C0751ze(), new Hm(), new C0263g3(), new C0465o2(), new Em(), new C0550rd(), new D9());
    }

    public final void a(C0205dm c0205dm, C0245fb c0245fb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0245fb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0205dm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0245fb.get("distribution_customization");
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
            c0205dm.j = Fm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0245fb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0205dm.m = str;
        JSONObject optJSONObject8 = c0245fb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0205dm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0659vm c0659vm = new C0659vm();
        JSONObject optJSONObject9 = c0245fb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0659vm.f1280a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0659vm.f1280a);
        }
        this.e.getClass();
        c0205dm.p = new Gm(c0659vm.f1280a);
        this.b.getClass();
        C0559rm c0559rm = new C0559rm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0245fb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                C0341j4 c0341j4 = new C0341j4();
                c0341j4.f1060a = W9.a(optJSONObject10, "permissions_collecting", c0559rm.f1217a);
                c0341j4.b = W9.a(optJSONObject10, "features_collecting", c0559rm.b);
                c0341j4.c = W9.a(optJSONObject10, "google_aid", c0559rm.c);
                c0341j4.d = W9.a(optJSONObject10, "sim_info", c0559rm.d);
                c0341j4.e = W9.a(optJSONObject10, "huawei_oaid", c0559rm.e);
                c0341j4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0205dm.b = new C0392l4(c0341j4);
            }
        } catch (Throwable unused4) {
        }
        this.f878a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0245fb.get("query_hosts");
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
                    c0205dm.d = str2;
                }
                ArrayList a3 = C0697xa.a(optJSONObject11, "report");
                if (!lo.a((Collection) a3)) {
                    c0205dm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0205dm.f = str3;
                }
                ArrayList a4 = C0697xa.a(optJSONObject11, "startup");
                if (!lo.a((Collection) a4)) {
                    c0205dm.c = a4;
                }
                ArrayList a5 = C0697xa.a(optJSONObject11, "diagnostic");
                if (!lo.a((Collection) a5)) {
                    c0205dm.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!C0697xa.f1308a.contains(next2) && (a2 = C0697xa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0205dm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0684wm c0684wm = new C0684wm();
        JSONObject optJSONObject12 = c0245fb.optJSONObject("retry_policy");
        int i = c0684wm.w;
        int i2 = c0684wm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0684wm.x);
        }
        c0205dm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0205dm.b.f1095a) {
            JSONObject optJSONObject13 = c0245fb.optJSONObject("permissions_collecting");
            C0609tm c0609tm = new C0609tm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0609tm.f1246a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0609tm.b);
            } else {
                j = c0609tm.f1246a;
                j2 = c0609tm.b;
            }
            c0205dm.k = new C0701xe(j, j2);
        }
        C0263g3 c0263g3 = this.f;
        c0263g3.getClass();
        C0485om c0485om = new C0485om();
        JSONObject optJSONObject14 = c0245fb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            c0485om.f1166a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", c0485om.f1166a);
        }
        c0263g3.f1010a.getClass();
        c0205dm.r = new C0186d3(c0485om.f1166a);
        this.g.getClass();
        C0465o2.a(c0205dm, c0245fb);
        Em em = this.i;
        em.getClass();
        JSONObject optJSONObject15 = c0245fb.optJSONObject("startup_update");
        C0634um c0634um = new C0634um();
        Integer a6 = AbstractC0271gb.a(optJSONObject15, "interval_seconds", null);
        if (a6 != null) {
            c0634um.f1266a = a6.intValue();
        }
        em.f576a.getClass();
        c0205dm.t = new Cm(c0634um.f1266a);
        Map<String, Yc> c = this.j.f1211a.c();
        C0526qd c0526qd = new C0526qd(c0245fb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Yc> entry : c.entrySet()) {
            Object invoke = c0526qd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0205dm.u = linkedHashMap;
        C9 c9 = this.k.f552a;
        C0535qm c0535qm = new C0535qm();
        JSONObject optJSONObject16 = c0245fb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            c0535qm.f1198a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", c0535qm.f1198a);
        }
        c9.getClass();
        c0205dm.v = new B9(c0535qm.f1198a);
    }

    public Yl(C0297hb c0297hb, C0697xa c0697xa, W9 w9, Fi fi, C0751ze c0751ze, Hm hm, C0263g3 c0263g3, C0465o2 c0465o2, Em em, C0550rd c0550rd, D9 d9) {
        this.f878a = c0697xa;
        this.b = w9;
        this.c = fi;
        this.d = c0751ze;
        this.e = hm;
        this.f = c0263g3;
        this.g = c0465o2;
        this.h = c0297hb;
        this.i = em;
        this.j = c0550rd;
        this.k = d9;
    }
}

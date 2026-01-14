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
    public final C0698xa f874a;
    public final W9 b;
    public final Fi c;
    public final C0752ze d;
    public final Hm e;
    public final C0264g3 f;
    public final C0466o2 g;
    public final C0298hb h;
    public final Em i;
    public final C0551rd j;
    public final D9 k;

    public Yl() {
        this(new C0298hb(), new C0698xa(), new W9(), new Fi(), new C0752ze(), new Hm(), new C0264g3(), new C0466o2(), new Em(), new C0551rd(), new D9());
    }

    public final void a(C0206dm c0206dm, C0246fb c0246fb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0246fb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0206dm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0246fb.get("distribution_customization");
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
            c0206dm.j = Fm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0246fb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0206dm.m = str;
        JSONObject optJSONObject8 = c0246fb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0206dm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0660vm c0660vm = new C0660vm();
        JSONObject optJSONObject9 = c0246fb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0660vm.f1276a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0660vm.f1276a);
        }
        this.e.getClass();
        c0206dm.p = new Gm(c0660vm.f1276a);
        this.b.getClass();
        C0560rm c0560rm = new C0560rm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0246fb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                C0342j4 c0342j4 = new C0342j4();
                c0342j4.f1056a = W9.a(optJSONObject10, "permissions_collecting", c0560rm.f1213a);
                c0342j4.b = W9.a(optJSONObject10, "features_collecting", c0560rm.b);
                c0342j4.c = W9.a(optJSONObject10, "google_aid", c0560rm.c);
                c0342j4.d = W9.a(optJSONObject10, "sim_info", c0560rm.d);
                c0342j4.e = W9.a(optJSONObject10, "huawei_oaid", c0560rm.e);
                c0342j4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0206dm.b = new C0393l4(c0342j4);
            }
        } catch (Throwable unused4) {
        }
        this.f874a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0246fb.get("query_hosts");
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
                    c0206dm.d = str2;
                }
                ArrayList a3 = C0698xa.a(optJSONObject11, "report");
                if (!lo.a((Collection) a3)) {
                    c0206dm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0206dm.f = str3;
                }
                ArrayList a4 = C0698xa.a(optJSONObject11, "startup");
                if (!lo.a((Collection) a4)) {
                    c0206dm.c = a4;
                }
                ArrayList a5 = C0698xa.a(optJSONObject11, "diagnostic");
                if (!lo.a((Collection) a5)) {
                    c0206dm.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!C0698xa.f1304a.contains(next2) && (a2 = C0698xa.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0206dm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C0685wm c0685wm = new C0685wm();
        JSONObject optJSONObject12 = c0246fb.optJSONObject("retry_policy");
        int i = c0685wm.w;
        int i2 = c0685wm.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", c0685wm.x);
        }
        c0206dm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0206dm.b.f1091a) {
            JSONObject optJSONObject13 = c0246fb.optJSONObject("permissions_collecting");
            C0610tm c0610tm = new C0610tm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0610tm.f1242a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0610tm.b);
            } else {
                j = c0610tm.f1242a;
                j2 = c0610tm.b;
            }
            c0206dm.k = new C0702xe(j, j2);
        }
        C0264g3 c0264g3 = this.f;
        c0264g3.getClass();
        C0486om c0486om = new C0486om();
        JSONObject optJSONObject14 = c0246fb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            c0486om.f1162a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", c0486om.f1162a);
        }
        c0264g3.f1006a.getClass();
        c0206dm.r = new C0187d3(c0486om.f1162a);
        this.g.getClass();
        C0466o2.a(c0206dm, c0246fb);
        Em em = this.i;
        em.getClass();
        JSONObject optJSONObject15 = c0246fb.optJSONObject("startup_update");
        C0635um c0635um = new C0635um();
        Integer a6 = AbstractC0272gb.a(optJSONObject15, "interval_seconds", null);
        if (a6 != null) {
            c0635um.f1262a = a6.intValue();
        }
        em.f572a.getClass();
        c0206dm.t = new Cm(c0635um.f1262a);
        Map<String, Yc> c = this.j.f1207a.c();
        C0527qd c0527qd = new C0527qd(c0246fb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Yc> entry : c.entrySet()) {
            Object invoke = c0527qd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0206dm.u = linkedHashMap;
        C9 c9 = this.k.f548a;
        C0536qm c0536qm = new C0536qm();
        JSONObject optJSONObject16 = c0246fb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            c0536qm.f1194a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", c0536qm.f1194a);
        }
        c9.getClass();
        c0206dm.v = new B9(c0536qm.f1194a);
    }

    public Yl(C0298hb c0298hb, C0698xa c0698xa, W9 w9, Fi fi, C0752ze c0752ze, Hm hm, C0264g3 c0264g3, C0466o2 c0466o2, Em em, C0551rd c0551rd, D9 d9) {
        this.f874a = c0698xa;
        this.b = w9;
        this.c = fi;
        this.d = c0752ze;
        this.e = hm;
        this.f = c0264g3;
        this.g = c0466o2;
        this.h = c0298hb;
        this.i = em;
        this.j = c0551rd;
        this.k = d9;
    }
}

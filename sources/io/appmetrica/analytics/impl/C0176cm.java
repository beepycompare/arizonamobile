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
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0176cm {

    /* renamed from: a  reason: collision with root package name */
    public final Ea f834a;
    public final C0190da b;
    public final Ki c;
    public final Fe d;
    public final Lm e;
    public final C0464o3 f;
    public final C0662w2 g;
    public final C0472ob h;
    public final Im i;
    public final C0723yd j;
    public final K9 k;

    public C0176cm() {
        this(new C0472ob(), new Ea(), new C0190da(), new Ki(), new Fe(), new Lm(), new C0464o3(), new C0662w2(), new Im(), new C0723yd(), new K9());
    }

    public final void a(C0305hm c0305hm, C0422mb c0422mb) {
        String str;
        long j;
        long j2;
        String str2;
        ArrayList a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4 = c0422mb.optJSONObject("queries");
        if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("list")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("host")) != null) {
            c0305hm.g = optJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c0422mb.get("distribution_customization");
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
            c0305hm.j = Jm.a((Map) hashMap);
        }
        JSONObject optJSONObject7 = c0422mb.optJSONObject(CommonUrlParts.LOCALE);
        String str3 = "";
        if (optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false)) {
            str = "";
        } else {
            str = optJSONObject.optString("value", "");
        }
        c0305hm.m = str;
        JSONObject optJSONObject8 = c0422mb.optJSONObject("time");
        if (optJSONObject8 != null) {
            try {
                c0305hm.l = Long.valueOf(optJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C0757zm c0757zm = new C0757zm();
        JSONObject optJSONObject9 = c0422mb.optJSONObject("stat_sending");
        if (optJSONObject9 != null) {
            c0757zm.f1236a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject9, "disabled_reporting_interval_seconds", c0757zm.f1236a);
        }
        this.e.getClass();
        c0305hm.p = new Km(c0757zm.f1236a);
        this.b.getClass();
        C0657vm c0657vm = new C0657vm();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c0422mb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject optJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (optJSONObject10 != null) {
                C0515q4 c0515q4 = new C0515q4();
                c0515q4.f1065a = C0190da.a(optJSONObject10, "permissions_collecting", c0657vm.f1175a);
                c0515q4.b = C0190da.a(optJSONObject10, "features_collecting", c0657vm.b);
                c0515q4.c = C0190da.a(optJSONObject10, "google_aid", c0657vm.c);
                c0515q4.d = C0190da.a(optJSONObject10, "sim_info", c0657vm.d);
                c0515q4.e = C0190da.a(optJSONObject10, "huawei_oaid", c0657vm.e);
                c0515q4.f = optJSONObject10.has("ssl_pinning") ? Boolean.valueOf(optJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c0305hm.b = new C0564s4(c0515q4);
            }
        } catch (Throwable unused4) {
        }
        this.f834a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c0422mb.get("query_hosts");
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
                    c0305hm.d = str2;
                }
                ArrayList a3 = Ea.a(optJSONObject11, "report");
                if (!no.a((Collection) a3)) {
                    c0305hm.e = a3;
                }
                try {
                    str3 = optJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(str3)) {
                    c0305hm.f = str3;
                }
                ArrayList a4 = Ea.a(optJSONObject11, "startup");
                if (!no.a((Collection) a4)) {
                    c0305hm.c = a4;
                }
                ArrayList a5 = Ea.a(optJSONObject11, "diagnostic");
                if (!no.a((Collection) a5)) {
                    c0305hm.n = a5;
                }
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = optJSONObject11.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!Ea.f457a.contains(next2) && (a2 = Ea.a(optJSONObject11, next2)) != null) {
                        hashMap2.put(next2, a2);
                    }
                }
                c0305hm.o = hashMap2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        Am am = new Am();
        JSONObject optJSONObject12 = c0422mb.optJSONObject("retry_policy");
        int i = am.w;
        int i2 = am.x;
        if (optJSONObject12 != null) {
            i = optJSONObject12.optInt("max_interval_seconds", i);
            i2 = optJSONObject12.optInt("exponential_multiplier", am.x);
        }
        c0305hm.q = new RetryPolicyConfig(i, i2);
        this.d.getClass();
        if (c0305hm.b.f1105a) {
            JSONObject optJSONObject13 = c0422mb.optJSONObject("permissions_collecting");
            C0707xm c0707xm = new C0707xm();
            if (optJSONObject13 != null) {
                j = optJSONObject13.optLong("check_interval_seconds", c0707xm.f1204a);
                j2 = optJSONObject13.optLong("force_send_interval_seconds", c0707xm.b);
            } else {
                j = c0707xm.f1204a;
                j2 = c0707xm.b;
            }
            c0305hm.k = new De(j, j2);
        }
        C0464o3 c0464o3 = this.f;
        c0464o3.getClass();
        C0582sm c0582sm = new C0582sm();
        JSONObject optJSONObject14 = c0422mb.optJSONObject("cache_control");
        if (optJSONObject14 != null) {
            c0582sm.f1119a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject14, "last_known_location_ttl", c0582sm.f1119a);
        }
        c0464o3.f1033a.getClass();
        c0305hm.r = new C0389l3(c0582sm.f1119a);
        this.g.getClass();
        C0662w2.a(c0305hm, c0422mb);
        Im im = this.i;
        im.getClass();
        JSONObject optJSONObject15 = c0422mb.optJSONObject("startup_update");
        C0732ym c0732ym = new C0732ym();
        Integer a6 = AbstractC0447nb.a(optJSONObject15, "interval_seconds", null);
        if (a6 != null) {
            c0732ym.f1218a = a6.intValue();
        }
        im.f533a.getClass();
        c0305hm.t = new Gm(c0732ym.f1218a);
        Map<String, C0244fd> c = this.j.f1214a.c();
        C0698xd c0698xd = new C0698xd(c0422mb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C0244fd> entry : c.entrySet()) {
            Object invoke = c0698xd.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        c0305hm.u = linkedHashMap;
        J9 j9 = this.k.f558a;
        C0632um c0632um = new C0632um();
        JSONObject optJSONObject16 = c0422mb.optJSONObject("external_attribution");
        if (optJSONObject16 != null) {
            c0632um.f1157a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(optJSONObject16, "collecting_interval_seconds", c0632um.f1157a);
        }
        j9.getClass();
        c0305hm.v = new I9(c0632um.f1157a);
    }

    public C0176cm(C0472ob c0472ob, Ea ea, C0190da c0190da, Ki ki, Fe fe, Lm lm, C0464o3 c0464o3, C0662w2 c0662w2, Im im, C0723yd c0723yd, K9 k9) {
        this.f834a = ea;
        this.b = c0190da;
        this.c = ki;
        this.d = fe;
        this.e = lm;
        this.f = c0464o3;
        this.g = c0662w2;
        this.h = c0472ob;
        this.i = im;
        this.j = c0723yd;
        this.k = k9;
    }
}

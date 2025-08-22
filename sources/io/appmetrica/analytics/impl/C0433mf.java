package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0433mf extends Pd implements Do {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String q = "SESSION_";
    public static final C0483of h = new C0483of("PERMISSIONS_CHECK_TIME", null);
    public static final C0483of i = new C0483of("PROFILE_ID", null);
    public static final C0483of j = new C0483of("APP_ENVIRONMENT", null);
    public static final C0483of k = new C0483of("APP_ENVIRONMENT_REVISION", null);
    public static final C0483of l = new C0483of("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0483of m = new C0483of("APPLICATION_FEATURES", null);
    public static final C0483of n = new C0483of("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0483of o = new C0483of("VITAL_DATA", null);
    public static final C0483of p = new C0483of("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0483of r = new C0483of("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public C0433mf(InterfaceC0223eb interfaceC0223eb) {
        super(interfaceC0223eb);
    }

    public final C0433mf a(C0264g0 c0264g0) {
        synchronized (this) {
            b(j.b, c0264g0.f862a);
            b(k.b, c0264g0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0458nf
    public final Set<String> c() {
        return this.f983a.a();
    }

    public final C0264g0 d() {
        C0264g0 c0264g0;
        synchronized (this) {
            c0264g0 = new C0264g0(this.f983a.getString(j.b, "{}"), this.f983a.getLong(k.b, 0L));
        }
        return c0264g0;
    }

    public final String e() {
        return this.f983a.getString(m.b, "");
    }

    public final List<String> f() {
        String str = n.b;
        List emptyList = Collections.emptyList();
        String[] strArr = emptyList == null ? null : (String[]) emptyList.toArray(new String[emptyList.size()]);
        String string = this.f983a.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = jSONArray.optString(i2);
                }
            } catch (Throwable unused) {
            }
        }
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    public final int g() {
        return this.f983a.getInt(l.b, -1);
    }

    public final long h() {
        return this.f983a.getLong(h.b, 0L);
    }

    public final C0433mf i(String str) {
        return (C0433mf) b(m.b, str);
    }

    public final C0433mf j(String str) {
        return (C0433mf) b(i.b, str);
    }

    public final String h(String str) {
        return this.f983a.getString(new C0483of(q, str).b, "");
    }

    public final String i() {
        return this.f983a.getString(i.b, null);
    }

    public final Map<Integer, String> j() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f983a.getString(p.b, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(Integer.valueOf(Integer.parseInt(next)), jSONObject.getString(next));
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public final C0433mf e(String str, String str2) {
        return (C0433mf) b(new C0483of(q, str).b, str2);
    }

    public final C0433mf a(long j2) {
        return (C0433mf) b(h.b, j2);
    }

    public final C0433mf a(int i2) {
        return (C0433mf) b(l.b, i2);
    }

    @Override // io.appmetrica.analytics.impl.Pd
    public final String f(String str) {
        return new C0483of(str, null).b;
    }

    public final C0433mf a(List<String> list) {
        return (C0433mf) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f983a.getBoolean(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        return this.f983a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        b(o.b, str);
    }

    public final void a(Map<Integer, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        b(p.b, jSONObject.toString());
    }
}

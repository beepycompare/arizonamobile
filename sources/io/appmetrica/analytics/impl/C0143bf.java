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
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0143bf extends Fd implements Do {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String r = "SESSION_";
    public static final C0195df h = new C0195df("PERMISSIONS_CHECK_TIME", null);
    public static final C0195df i = new C0195df("PROFILE_ID", null);
    public static final C0195df j = new C0195df("APP_ENVIRONMENT", null);
    public static final C0195df k = new C0195df("APP_ENVIRONMENT_REVISION", null);
    public static final C0195df l = new C0195df("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0195df m = new C0195df("APPLICATION_FEATURES", null);
    public static final C0195df n = new C0195df("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0195df o = new C0195df("VITAL_DATA", null);
    public static final C0195df p = new C0195df("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0195df q = new C0195df("AUTO_COLLECTED_DATA_SUBSCRIBERS", null);
    public static final C0195df s = new C0195df("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public C0143bf(Oa oa) {
        super(oa);
    }

    public final C0143bf a(C0309i0 c0309i0) {
        synchronized (this) {
            b(j.b, c0309i0.f920a);
            b(k.b, c0309i0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0169cf
    public final Set<String> c() {
        return this.f830a.a();
    }

    public final C0309i0 d() {
        C0309i0 c0309i0;
        synchronized (this) {
            c0309i0 = new C0309i0(this.f830a.getString(j.b, "{}"), this.f830a.getLong(k.b, 0L));
        }
        return c0309i0;
    }

    public final String e() {
        return this.f830a.getString(m.b, "");
    }

    public final Map<String, Long> f() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f830a.getString(q.b, null);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Long.valueOf(jSONObject.getLong(next)));
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public final List<String> g() {
        String str = n.b;
        List emptyList = Collections.emptyList();
        String[] strArr = emptyList == null ? null : (String[]) emptyList.toArray(new String[emptyList.size()]);
        String string = this.f830a.getString(str, null);
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

    public final int h() {
        return this.f830a.getInt(l.b, -1);
    }

    public final long i() {
        return this.f830a.getLong(h.b, 0L);
    }

    public final String j() {
        return this.f830a.getString(i.b, null);
    }

    public final Map<Integer, String> k() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f830a.getString(p.b, null);
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

    public final void b(Map<Integer, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        b(p.b, jSONObject.toString());
    }

    public final String h(String str) {
        return this.f830a.getString(new C0195df(r, str).b, "");
    }

    public final C0143bf i(String str) {
        return (C0143bf) b(m.b, str);
    }

    public final C0143bf j(String str) {
        return (C0143bf) b(i.b, str);
    }

    public final C0143bf e(String str, String str2) {
        return (C0143bf) b(new C0195df(r, str).b, str2);
    }

    public final C0143bf a(long j2) {
        return (C0143bf) b(h.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.Fd
    public final String f(String str) {
        return new C0195df(str, null).b;
    }

    public final C0143bf a(int i2) {
        return (C0143bf) b(l.b, i2);
    }

    public final C0143bf a(List<String> list) {
        return (C0143bf) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f830a.getBoolean(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final String a() {
        return this.f830a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Do
    public final void a(String str) {
        b(o.b, str);
    }

    public final void a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        b(q.b, jSONObject.toString());
    }
}

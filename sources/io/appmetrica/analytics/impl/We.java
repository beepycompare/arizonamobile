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
/* loaded from: classes5.dex */
public final class We extends AbstractC0725yd implements Bo {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String r = "SESSION_";
    public static final Ye h = new Ye("PERMISSIONS_CHECK_TIME", null);
    public static final Ye i = new Ye("PROFILE_ID", null);
    public static final Ye j = new Ye("APP_ENVIRONMENT", null);
    public static final Ye k = new Ye("APP_ENVIRONMENT_REVISION", null);
    public static final Ye l = new Ye("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final Ye m = new Ye("APPLICATION_FEATURES", null);
    public static final Ye n = new Ye("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final Ye o = new Ye("VITAL_DATA", null);
    public static final Ye p = new Ye("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final Ye q = new Ye("AUTO_COLLECTED_DATA_SUBSCRIBERS", null);
    public static final Ye s = new Ye("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public We(Ha ha) {
        super(ha);
    }

    public final We a(C0312i0 c0312i0) {
        synchronized (this) {
            b(j.b, c0312i0.f1040a);
            b(k.b, c0312i0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Xe
    public final Set<String> c() {
        return this.f858a.a();
    }

    public final C0312i0 d() {
        C0312i0 c0312i0;
        synchronized (this) {
            c0312i0 = new C0312i0(this.f858a.getString(j.b, "{}"), this.f858a.getLong(k.b, 0L));
        }
        return c0312i0;
    }

    public final String e() {
        return this.f858a.getString(m.b, "");
    }

    public final Map<String, Long> f() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f858a.getString(q.b, null);
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
        String string = this.f858a.getString(str, null);
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
        return this.f858a.getInt(l.b, -1);
    }

    public final long i() {
        return this.f858a.getLong(h.b, 0L);
    }

    public final String j() {
        return this.f858a.getString(i.b, null);
    }

    public final Map<Integer, String> k() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f858a.getString(p.b, null);
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
        return this.f858a.getString(new Ye(r, str).b, "");
    }

    public final We i(String str) {
        return (We) b(m.b, str);
    }

    public final We j(String str) {
        return (We) b(i.b, str);
    }

    public final We e(String str, String str2) {
        return (We) b(new Ye(r, str).b, str2);
    }

    public final We a(long j2) {
        return (We) b(h.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0725yd
    public final String f(String str) {
        return new Ye(str, null).b;
    }

    public final We a(int i2) {
        return (We) b(l.b, i2);
    }

    public final We a(List<String> list) {
        return (We) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f858a.getBoolean(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Bo
    public final String a() {
        return this.f858a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Bo
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

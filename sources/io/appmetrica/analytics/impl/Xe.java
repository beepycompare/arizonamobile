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
public final class Xe extends AbstractC0747zd implements Co {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String r = "SESSION_";
    public static final Ze h = new Ze("PERMISSIONS_CHECK_TIME", null);
    public static final Ze i = new Ze("PROFILE_ID", null);
    public static final Ze j = new Ze("APP_ENVIRONMENT", null);
    public static final Ze k = new Ze("APP_ENVIRONMENT_REVISION", null);
    public static final Ze l = new Ze("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final Ze m = new Ze("APPLICATION_FEATURES", null);
    public static final Ze n = new Ze("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final Ze o = new Ze("VITAL_DATA", null);
    public static final Ze p = new Ze("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final Ze q = new Ze("AUTO_COLLECTED_DATA_SUBSCRIBERS", null);
    public static final Ze s = new Ze("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public Xe(Ia ia) {
        super(ia);
    }

    public final Xe a(C0308i0 c0308i0) {
        synchronized (this) {
            b(j.b, c0308i0.f1014a);
            b(k.b, c0308i0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Ye
    public final Set<String> c() {
        return this.f848a.a();
    }

    public final C0308i0 d() {
        C0308i0 c0308i0;
        synchronized (this) {
            c0308i0 = new C0308i0(this.f848a.getString(j.b, "{}"), this.f848a.getLong(k.b, 0L));
        }
        return c0308i0;
    }

    public final String e() {
        return this.f848a.getString(m.b, "");
    }

    public final Map<String, Long> f() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f848a.getString(q.b, null);
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
        String string = this.f848a.getString(str, null);
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
        return this.f848a.getInt(l.b, -1);
    }

    public final long i() {
        return this.f848a.getLong(h.b, 0L);
    }

    public final String j() {
        return this.f848a.getString(i.b, null);
    }

    public final Map<Integer, String> k() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f848a.getString(p.b, null);
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
        return this.f848a.getString(new Ze(r, str).b, "");
    }

    public final Xe i(String str) {
        return (Xe) b(m.b, str);
    }

    public final Xe j(String str) {
        return (Xe) b(i.b, str);
    }

    public final Xe e(String str, String str2) {
        return (Xe) b(new Ze(r, str).b, str2);
    }

    public final Xe a(long j2) {
        return (Xe) b(h.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0747zd
    public final String f(String str) {
        return new Ze(str, null).b;
    }

    public final Xe a(int i2) {
        return (Xe) b(l.b, i2);
    }

    public final Xe a(List<String> list) {
        return (Xe) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f848a.getBoolean(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Co
    public final String a() {
        return this.f848a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Co
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

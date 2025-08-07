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
/* renamed from: io.appmetrica.analytics.impl.kf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0386kf extends Nd implements yo {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String q = "SESSION_";
    public static final C0436mf h = new C0436mf("PERMISSIONS_CHECK_TIME", null);
    public static final C0436mf i = new C0436mf("PROFILE_ID", null);
    public static final C0436mf j = new C0436mf("APP_ENVIRONMENT", null);
    public static final C0436mf k = new C0436mf("APP_ENVIRONMENT_REVISION", null);
    public static final C0436mf l = new C0436mf("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0436mf m = new C0436mf("APPLICATION_FEATURES", null);
    public static final C0436mf n = new C0436mf("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0436mf o = new C0436mf("VITAL_DATA", null);
    public static final C0436mf p = new C0436mf("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0436mf r = new C0436mf("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public C0386kf(InterfaceC0180cb interfaceC0180cb) {
        super(interfaceC0180cb);
    }

    public final C0386kf a(C0272g0 c0272g0) {
        synchronized (this) {
            b(j.b, c0272g0.f855a);
            b(k.b, c0272g0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0411lf
    public final Set<String> c() {
        return this.f938a.a();
    }

    public final C0272g0 d() {
        C0272g0 c0272g0;
        synchronized (this) {
            c0272g0 = new C0272g0(this.f938a.getString(j.b, "{}"), this.f938a.getLong(k.b, 0L));
        }
        return c0272g0;
    }

    public final String e() {
        return this.f938a.getString(m.b, "");
    }

    public final List<String> f() {
        String str = n.b;
        List emptyList = Collections.emptyList();
        String[] strArr = emptyList == null ? null : (String[]) emptyList.toArray(new String[emptyList.size()]);
        String string = this.f938a.getString(str, null);
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
        return this.f938a.getInt(l.b, -1);
    }

    public final long h() {
        return this.f938a.getLong(h.b, 0L);
    }

    public final C0386kf i(String str) {
        return (C0386kf) b(m.b, str);
    }

    public final C0386kf j(String str) {
        return (C0386kf) b(i.b, str);
    }

    public final String h(String str) {
        return this.f938a.getString(new C0436mf(q, str).b, "");
    }

    public final String i() {
        return this.f938a.getString(i.b, null);
    }

    public final Map<Integer, String> j() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f938a.getString(p.b, null);
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

    public final C0386kf e(String str, String str2) {
        return (C0386kf) b(new C0436mf(q, str).b, str2);
    }

    public final C0386kf a(long j2) {
        return (C0386kf) b(h.b, j2);
    }

    public final C0386kf a(int i2) {
        return (C0386kf) b(l.b, i2);
    }

    @Override // io.appmetrica.analytics.impl.Nd
    public final String f(String str) {
        return new C0436mf(str, null).b;
    }

    public final C0386kf a(List<String> list) {
        return (C0386kf) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f938a.getBoolean(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final String a() {
        return this.f938a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.yo
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

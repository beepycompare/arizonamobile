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
/* renamed from: io.appmetrica.analytics.impl.wf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0684wf extends Yd implements ep {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String r = "SESSION_";
    public static final C0736yf h = new C0736yf("PERMISSIONS_CHECK_TIME", null);
    public static final C0736yf i = new C0736yf("PROFILE_ID", null);
    public static final C0736yf j = new C0736yf("APP_ENVIRONMENT", null);
    public static final C0736yf k = new C0736yf("APP_ENVIRONMENT_REVISION", null);
    public static final C0736yf l = new C0736yf("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0736yf m = new C0736yf("APPLICATION_FEATURES", null);
    public static final C0736yf n = new C0736yf("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0736yf o = new C0736yf("VITAL_DATA", null);
    public static final C0736yf p = new C0736yf("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0736yf q = new C0736yf("AUTO_COLLECTED_DATA_SUBSCRIBERS", null);
    public static final C0736yf s = new C0736yf("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public C0684wf(InterfaceC0343jb interfaceC0343jb) {
        super(interfaceC0343jb);
    }

    public final C0684wf a(C0358k0 c0358k0) {
        synchronized (this) {
            d(j.b, c0358k0.f1064a);
            d(k.b, c0358k0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        d(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf
    public final Set<String> c() {
        return this.f1284a.b();
    }

    public final C0358k0 d() {
        C0358k0 c0358k0;
        synchronized (this) {
            c0358k0 = new C0358k0(this.f1284a.getString(j.b, "{}"), this.f1284a.getLong(k.b, 0L));
        }
        return c0358k0;
    }

    public final String e() {
        return this.f1284a.getString(m.b, "");
    }

    public final Map<String, Long> f() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f1284a.getString(q.b, null);
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

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf, io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
    public final void flushAsync() {
        this.f1284a.flushAsync();
    }

    public final List<String> g() {
        String str = n.b;
        List emptyList = Collections.emptyList();
        String[] strArr = emptyList == null ? null : (String[]) emptyList.toArray(new String[emptyList.size()]);
        String string = this.f1284a.getString(str, null);
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
        return this.f1284a.getInt(l.b, -1);
    }

    public final long i() {
        return this.f1284a.getLong(h.b, 0L);
    }

    public final String j() {
        return this.f1284a.getString(i.b, null);
    }

    public final Map<Integer, String> k() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f1284a.getString(p.b, null);
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

    @Override // io.appmetrica.analytics.impl.ep
    public final String b() {
        return this.f1284a.getString(o.b, null);
    }

    public final String h(String str) {
        return this.f1284a.getString(new C0736yf(r, str).b, "");
    }

    public final C0684wf i(String str) {
        return (C0684wf) d(m.b, str);
    }

    public final C0684wf j(String str) {
        return (C0684wf) d(i.b, str);
    }

    public final C0684wf e(String str, String str2) {
        return (C0684wf) d(new C0736yf(r, str).b, str2);
    }

    public final void b(Map<Integer, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        d(p.b, jSONObject.toString());
    }

    public final C0684wf a(long j2) {
        return (C0684wf) d(h.b, j2);
    }

    public final C0684wf a(int i2) {
        return (C0684wf) d(l.b, i2);
    }

    @Override // io.appmetrica.analytics.impl.Yd
    public final String g(String str) {
        return new C0736yf(str, null).b;
    }

    public final C0684wf a(List<String> list) {
        return (C0684wf) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f1284a.getBoolean(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.ep
    public final void a(String str) {
        d(o.b, str);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0710xf, io.appmetrica.analytics.impl.ep
    public final void a() {
        super.a();
    }

    public final void a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        d(q.b, jSONObject.toString());
    }
}

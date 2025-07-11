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
/* renamed from: io.appmetrica.analytics.impl.if  reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cif extends Ld implements vo {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String q = "SESSION_";
    public static final C0383kf h = new C0383kf("PERMISSIONS_CHECK_TIME", null);
    public static final C0383kf i = new C0383kf("PROFILE_ID", null);
    public static final C0383kf j = new C0383kf("APP_ENVIRONMENT", null);
    public static final C0383kf k = new C0383kf("APP_ENVIRONMENT_REVISION", null);
    public static final C0383kf l = new C0383kf("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0383kf m = new C0383kf("APPLICATION_FEATURES", null);
    public static final C0383kf n = new C0383kf("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0383kf o = new C0383kf("VITAL_DATA", null);
    public static final C0383kf p = new C0383kf("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0383kf r = new C0383kf("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public Cif(InterfaceC0127ab interfaceC0127ab) {
        super(interfaceC0127ab);
    }

    public final Cif a(C0269g0 c0269g0) {
        synchronized (this) {
            b(j.b, c0269g0.f847a);
            b(k.b, c0269g0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jf
    public final Set<String> c() {
        return this.f892a.a();
    }

    public final C0269g0 d() {
        C0269g0 c0269g0;
        synchronized (this) {
            c0269g0 = new C0269g0(this.f892a.getString(j.b, "{}"), this.f892a.getLong(k.b, 0L));
        }
        return c0269g0;
    }

    public final String e() {
        return this.f892a.getString(m.b, "");
    }

    public final List<String> f() {
        String str = n.b;
        List emptyList = Collections.emptyList();
        String[] strArr = emptyList == null ? null : (String[]) emptyList.toArray(new String[emptyList.size()]);
        String string = this.f892a.getString(str, null);
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
        return this.f892a.getInt(l.b, -1);
    }

    public final long h() {
        return this.f892a.getLong(h.b, 0L);
    }

    public final Cif i(String str) {
        return (Cif) b(m.b, str);
    }

    public final Cif j(String str) {
        return (Cif) b(i.b, str);
    }

    public final String h(String str) {
        return this.f892a.getString(new C0383kf(q, str).b, "");
    }

    public final String i() {
        return this.f892a.getString(i.b, null);
    }

    public final Map<Integer, String> j() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f892a.getString(p.b, null);
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

    public final Cif e(String str, String str2) {
        return (Cif) b(new C0383kf(q, str).b, str2);
    }

    public final Cif a(long j2) {
        return (Cif) b(h.b, j2);
    }

    public final Cif a(int i2) {
        return (Cif) b(l.b, i2);
    }

    @Override // io.appmetrica.analytics.impl.Ld
    public final String f(String str) {
        return new C0383kf(str, null).b;
    }

    public final Cif a(List<String> list) {
        return (Cif) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f892a.getBoolean(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final String a() {
        return this.f892a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.vo
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

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
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0538qf extends Td implements Ho {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String r = "SESSION_";
    public static final C0587sf h = new C0587sf("PERMISSIONS_CHECK_TIME", null);
    public static final C0587sf i = new C0587sf("PROFILE_ID", null);
    public static final C0587sf j = new C0587sf("APP_ENVIRONMENT", null);
    public static final C0587sf k = new C0587sf("APP_ENVIRONMENT_REVISION", null);
    public static final C0587sf l = new C0587sf("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final C0587sf m = new C0587sf("APPLICATION_FEATURES", null);
    public static final C0587sf n = new C0587sf("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final C0587sf o = new C0587sf("VITAL_DATA", null);
    public static final C0587sf p = new C0587sf("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final C0587sf q = new C0587sf("AUTO_COLLECTED_DATA_SUBSCRIBERS", null);
    public static final C0587sf s = new C0587sf("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public C0538qf(InterfaceC0302hb interfaceC0302hb) {
        super(interfaceC0302hb);
    }

    public final C0538qf a(C0291h0 c0291h0) {
        synchronized (this) {
            b(j.b, c0291h0.f903a);
            b(k.b, c0291h0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0562rf
    public final Set<String> c() {
        return this.f1067a.a();
    }

    public final C0291h0 d() {
        C0291h0 c0291h0;
        synchronized (this) {
            c0291h0 = new C0291h0(this.f1067a.getString(j.b, "{}"), this.f1067a.getLong(k.b, 0L));
        }
        return c0291h0;
    }

    public final String e() {
        return this.f1067a.getString(m.b, "");
    }

    public final Map<String, Long> f() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f1067a.getString(q.b, null);
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
        String string = this.f1067a.getString(str, null);
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
        return this.f1067a.getInt(l.b, -1);
    }

    public final long i() {
        return this.f1067a.getLong(h.b, 0L);
    }

    public final String j() {
        return this.f1067a.getString(i.b, null);
    }

    public final Map<Integer, String> k() {
        HashMap hashMap = new HashMap();
        try {
            String string = this.f1067a.getString(p.b, null);
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
        return this.f1067a.getString(new C0587sf(r, str).b, "");
    }

    public final C0538qf i(String str) {
        return (C0538qf) b(m.b, str);
    }

    public final C0538qf j(String str) {
        return (C0538qf) b(i.b, str);
    }

    public final C0538qf e(String str, String str2) {
        return (C0538qf) b(new C0587sf(r, str).b, str2);
    }

    public final C0538qf a(long j2) {
        return (C0538qf) b(h.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.Td
    public final String f(String str) {
        return new C0587sf(str, null).b;
    }

    public final C0538qf a(int i2) {
        return (C0538qf) b(l.b, i2);
    }

    public final C0538qf a(List<String> list) {
        return (C0538qf) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f1067a.getBoolean(s.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final String a() {
        return this.f1067a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Ho
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

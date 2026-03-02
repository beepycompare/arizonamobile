package io.appmetrica.analytics.impl;

import android.util.Base64;
import androidx.core.app.NotificationCompat;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.jb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0348jb {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f1061a;
    public final String b;
    public final int c;
    public final HashMap d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final CounterConfigurationReporterType i;
    public final String j;

    public C0348jb(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject(NotificationCompat.CATEGORY_EVENT);
        this.f1061a = Base64.decode(jSONObject2.getString("jvm_crash"), 0);
        this.b = jSONObject2.getString("name");
        this.c = jSONObject2.getInt("bytes_truncated");
        this.j = JsonUtils.optStringOrNull(jSONObject2, "environment");
        String optString = jSONObject2.optString("trimmed_fields");
        this.d = new HashMap();
        if (optString != null) {
            try {
                HashMap c = AbstractC0271gb.c(optString);
                if (c != null) {
                    for (Map.Entry entry : c.entrySet()) {
                        this.d.put(L3.valueOf((String) entry.getKey()), Integer.valueOf(Integer.parseInt((String) entry.getValue())));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("process_configuration");
        this.e = jSONObject3.getString("package_name");
        this.f = Integer.valueOf(jSONObject3.getInt("pid"));
        this.g = jSONObject3.getString("psid");
        JSONObject jSONObject4 = jSONObject.getJSONObject("reporter_configuration");
        this.h = jSONObject4.getString("api_key");
        this.i = a(jSONObject4);
    }

    public final String a() {
        return this.h;
    }

    public final int b() {
        return this.c;
    }

    public final byte[] c() {
        return this.f1061a;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.e;
    }

    public final Integer g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final CounterConfigurationReporterType i() {
        return this.i;
    }

    public final HashMap<L3, Integer> j() {
        return this.d;
    }

    public final String k() throws JSONException {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.d.entrySet()) {
            hashMap.put(((L3) entry.getKey()).name(), (Integer) entry.getValue());
        }
        return new JSONObject().put("process_configuration", new JSONObject().put("pid", this.f).put("psid", this.g).put("package_name", this.e)).put("reporter_configuration", new JSONObject().put("api_key", this.h).put("reporter_type", this.i.getStringValue())).put(NotificationCompat.CATEGORY_EVENT, new JSONObject().put("jvm_crash", Base64.encodeToString(this.f1061a, 0)).put("name", this.b).put("bytes_truncated", this.c).put("trimmed_fields", AbstractC0271gb.b(hashMap)).putOpt("environment", this.j)).toString();
    }

    public static CounterConfigurationReporterType a(JSONObject jSONObject) {
        if (jSONObject.has("reporter_type")) {
            return CounterConfigurationReporterType.fromStringValue(jSONObject.getString("reporter_type"));
        }
        return CounterConfigurationReporterType.MAIN;
    }

    public C0348jb(P5 p5, H3 h3, HashMap<L3, Integer> hashMap) {
        this.f1061a = p5.getValueBytes();
        this.b = p5.getName();
        this.c = p5.getBytesTruncated();
        if (hashMap != null) {
            this.d = hashMap;
        } else {
            this.d = new HashMap();
        }
        Bf a2 = h3.a();
        this.e = a2.e();
        this.f = a2.f();
        this.g = a2.g();
        CounterConfiguration b = h3.b();
        this.h = b.getApiKey();
        this.i = b.getReporterType();
        this.j = p5.f();
    }
}

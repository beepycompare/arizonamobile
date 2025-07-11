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
/* loaded from: classes4.dex */
public final class Cb {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f372a;
    public final String b;
    public final int c;
    public final HashMap d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final CounterConfigurationReporterType i;
    public final String j;

    public Cb(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject(NotificationCompat.CATEGORY_EVENT);
        this.f372a = Base64.decode(jSONObject2.getString("jvm_crash"), 0);
        this.b = jSONObject2.getString("name");
        this.c = jSONObject2.getInt("bytes_truncated");
        this.j = JsonUtils.optStringOrNull(jSONObject2, "environment");
        String optString = jSONObject2.optString("trimmed_fields");
        this.d = new HashMap();
        if (optString != null) {
            try {
                HashMap c = AbstractC0753zb.c(optString);
                if (c != null) {
                    for (Map.Entry entry : c.entrySet()) {
                        this.d.put(EnumC0298h4.valueOf((String) entry.getKey()), Integer.valueOf(Integer.parseInt((String) entry.getValue())));
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
        return this.f372a;
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

    public final HashMap<EnumC0298h4, Integer> j() {
        return this.d;
    }

    public final String k() throws JSONException {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.d.entrySet()) {
            hashMap.put(((EnumC0298h4) entry.getKey()).name(), (Integer) entry.getValue());
        }
        return new JSONObject().put("process_configuration", new JSONObject().put("pid", this.f).put("psid", this.g).put("package_name", this.e)).put("reporter_configuration", new JSONObject().put("api_key", this.h).put("reporter_type", this.i.getStringValue())).put(NotificationCompat.CATEGORY_EVENT, new JSONObject().put("jvm_crash", Base64.encodeToString(this.f372a, 0)).put("name", this.b).put("bytes_truncated", this.c).put("trimmed_fields", AbstractC0753zb.b(hashMap)).putOpt("environment", this.j)).toString();
    }

    public static CounterConfigurationReporterType a(JSONObject jSONObject) {
        if (jSONObject.has("reporter_type")) {
            return CounterConfigurationReporterType.fromStringValue(jSONObject.getString("reporter_type"));
        }
        return CounterConfigurationReporterType.MAIN;
    }

    public Cb(C0325i6 c0325i6, C0198d4 c0198d4, HashMap<EnumC0298h4, Integer> hashMap) {
        this.f372a = c0325i6.getValueBytes();
        this.b = c0325i6.getName();
        this.c = c0325i6.getBytesTruncated();
        if (hashMap != null) {
            this.d = hashMap;
        } else {
            this.d = new HashMap();
        }
        Nf a2 = c0198d4.a();
        this.e = a2.e();
        this.f = a2.f();
        this.g = a2.g();
        CounterConfiguration b = c0198d4.b();
        this.h = b.getApiKey();
        this.i = b.getReporterType();
        this.j = c0325i6.f();
    }
}

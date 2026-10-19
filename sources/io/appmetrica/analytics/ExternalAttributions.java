package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0139bd;
import io.appmetrica.analytics.impl.EnumC0213ea;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.Ge;
import io.appmetrica.analytics.impl.Ke;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new Ge(EnumC0213ea.b);
        }
        return new Ke(EnumC0213ea.b, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0213ea.e);
        }
        return new C0139bd(EnumC0213ea.e, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0213ea.f966a);
        }
        return new C0139bd(EnumC0213ea.f966a, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Ge(EnumC0213ea.c);
        }
        return new Gb(EnumC0213ea.c, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0213ea.f);
        }
        return new C0139bd(EnumC0213ea.f, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0213ea.d);
        }
        return new C0139bd(EnumC0213ea.d, map);
    }
}

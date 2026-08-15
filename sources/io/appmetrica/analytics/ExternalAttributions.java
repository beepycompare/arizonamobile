package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0145bd;
import io.appmetrica.analytics.impl.EnumC0219ea;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.Ge;
import io.appmetrica.analytics.impl.Ke;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new Ge(EnumC0219ea.b);
        }
        return new Ke(EnumC0219ea.b, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0219ea.e);
        }
        return new C0145bd(EnumC0219ea.e, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0219ea.f963a);
        }
        return new C0145bd(EnumC0219ea.f963a, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Ge(EnumC0219ea.c);
        }
        return new Gb(EnumC0219ea.c, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0219ea.f);
        }
        return new C0145bd(EnumC0219ea.f, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0219ea.d);
        }
        return new C0145bd(EnumC0219ea.d, map);
    }
}

package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0146bd;
import io.appmetrica.analytics.impl.EnumC0220ea;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.Ge;
import io.appmetrica.analytics.impl.Ke;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new Ge(EnumC0220ea.b);
        }
        return new Ke(EnumC0220ea.b, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0220ea.e);
        }
        return new C0146bd(EnumC0220ea.e, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0220ea.f963a);
        }
        return new C0146bd(EnumC0220ea.f963a, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Ge(EnumC0220ea.c);
        }
        return new Gb(EnumC0220ea.c, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0220ea.f);
        }
        return new C0146bd(EnumC0220ea.f, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0220ea.d);
        }
        return new C0146bd(EnumC0220ea.d, map);
    }
}

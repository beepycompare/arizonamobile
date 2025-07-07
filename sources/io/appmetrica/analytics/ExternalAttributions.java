package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0564re;
import io.appmetrica.analytics.impl.C0664ve;
import io.appmetrica.analytics.impl.C0711xb;
import io.appmetrica.analytics.impl.EnumC0186ca;
import io.appmetrica.analytics.impl.Tc;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0564re(EnumC0186ca.ADJUST);
        }
        return new C0664ve(EnumC0186ca.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0564re(EnumC0186ca.AIRBRIDGE);
        }
        return new Tc(EnumC0186ca.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0564re(EnumC0186ca.APPSFLYER);
        }
        return new Tc(EnumC0186ca.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0564re(EnumC0186ca.KOCHAVA);
        }
        return new C0711xb(EnumC0186ca.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0564re(EnumC0186ca.SINGULAR);
        }
        return new Tc(EnumC0186ca.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0564re(EnumC0186ca.TENJIN);
        }
        return new Tc(EnumC0186ca.TENJIN, map);
    }
}

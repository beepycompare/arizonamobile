package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0556re;
import io.appmetrica.analytics.impl.C0656ve;
import io.appmetrica.analytics.impl.C0703xb;
import io.appmetrica.analytics.impl.EnumC0178ca;
import io.appmetrica.analytics.impl.Tc;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0556re(EnumC0178ca.ADJUST);
        }
        return new C0656ve(EnumC0178ca.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0556re(EnumC0178ca.AIRBRIDGE);
        }
        return new Tc(EnumC0178ca.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0556re(EnumC0178ca.APPSFLYER);
        }
        return new Tc(EnumC0178ca.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0556re(EnumC0178ca.KOCHAVA);
        }
        return new C0703xb(EnumC0178ca.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0556re(EnumC0178ca.SINGULAR);
        }
        return new Tc(EnumC0178ca.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0556re(EnumC0178ca.TENJIN);
        }
        return new Tc(EnumC0178ca.TENJIN, map);
    }
}

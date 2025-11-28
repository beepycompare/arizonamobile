package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0397lb;
import io.appmetrica.analytics.impl.C0400le;
import io.appmetrica.analytics.impl.C0500pe;
import io.appmetrica.analytics.impl.Hc;
import io.appmetrica.analytics.impl.Q9;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0400le(Q9.ADJUST);
        }
        return new C0500pe(Q9.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0400le(Q9.AIRBRIDGE);
        }
        return new Hc(Q9.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0400le(Q9.APPSFLYER);
        }
        return new Hc(Q9.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0400le(Q9.KOCHAVA);
        }
        return new C0397lb(Q9.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0400le(Q9.SINGULAR);
        }
        return new Hc(Q9.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0400le(Q9.TENJIN);
        }
        return new Hc(Q9.TENJIN, map);
    }
}

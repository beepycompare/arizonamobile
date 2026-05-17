package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.Ac;
import io.appmetrica.analytics.impl.C0219eb;
import io.appmetrica.analytics.impl.C0222ee;
import io.appmetrica.analytics.impl.C0326ie;
import io.appmetrica.analytics.impl.J9;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0222ee(J9.ADJUST);
        }
        return new C0326ie(J9.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0222ee(J9.AIRBRIDGE);
        }
        return new Ac(J9.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0222ee(J9.APPSFLYER);
        }
        return new Ac(J9.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0222ee(J9.KOCHAVA);
        }
        return new C0219eb(J9.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0222ee(J9.SINGULAR);
        }
        return new Ac(J9.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0222ee(J9.TENJIN);
        }
        return new Ac(J9.TENJIN, map);
    }
}

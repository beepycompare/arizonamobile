package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.Bc;
import io.appmetrica.analytics.impl.C0242fb;
import io.appmetrica.analytics.impl.C0245fe;
import io.appmetrica.analytics.impl.C0348je;
import io.appmetrica.analytics.impl.K9;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0245fe(K9.ADJUST);
        }
        return new C0348je(K9.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0245fe(K9.AIRBRIDGE);
        }
        return new Bc(K9.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0245fe(K9.APPSFLYER);
        }
        return new Bc(K9.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0245fe(K9.KOCHAVA);
        }
        return new C0242fb(K9.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0245fe(K9.SINGULAR);
        }
        return new Bc(K9.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0245fe(K9.TENJIN);
        }
        return new Bc(K9.TENJIN, map);
    }
}

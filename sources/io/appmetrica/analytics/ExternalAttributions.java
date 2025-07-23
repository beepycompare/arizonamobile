package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0608te;
import io.appmetrica.analytics.impl.C0708xe;
import io.appmetrica.analytics.impl.C0755zb;
import io.appmetrica.analytics.impl.EnumC0229ea;
import io.appmetrica.analytics.impl.Vc;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0608te(EnumC0229ea.ADJUST);
        }
        return new C0708xe(EnumC0229ea.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0608te(EnumC0229ea.AIRBRIDGE);
        }
        return new Vc(EnumC0229ea.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0608te(EnumC0229ea.APPSFLYER);
        }
        return new Vc(EnumC0229ea.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0608te(EnumC0229ea.KOCHAVA);
        }
        return new C0755zb(EnumC0229ea.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0608te(EnumC0229ea.SINGULAR);
        }
        return new Vc(EnumC0229ea.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0608te(EnumC0229ea.TENJIN);
        }
        return new Vc(EnumC0229ea.TENJIN, map);
    }
}

package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.Bb;
import io.appmetrica.analytics.impl.C0656ve;
import io.appmetrica.analytics.impl.C0756ze;
import io.appmetrica.analytics.impl.EnumC0274ga;
import io.appmetrica.analytics.impl.Xc;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0656ve(EnumC0274ga.ADJUST);
        }
        return new C0756ze(EnumC0274ga.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0656ve(EnumC0274ga.AIRBRIDGE);
        }
        return new Xc(EnumC0274ga.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0656ve(EnumC0274ga.APPSFLYER);
        }
        return new Xc(EnumC0274ga.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0656ve(EnumC0274ga.KOCHAVA);
        }
        return new Bb(EnumC0274ga.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0656ve(EnumC0274ga.SINGULAR);
        }
        return new Xc(EnumC0274ga.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0656ve(EnumC0274ga.TENJIN);
        }
        return new Xc(EnumC0274ga.TENJIN, map);
    }
}

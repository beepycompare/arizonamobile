package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0609te;
import io.appmetrica.analytics.impl.C0709xe;
import io.appmetrica.analytics.impl.C0756zb;
import io.appmetrica.analytics.impl.EnumC0230ea;
import io.appmetrica.analytics.impl.Vc;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0609te(EnumC0230ea.ADJUST);
        }
        return new C0709xe(EnumC0230ea.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0609te(EnumC0230ea.AIRBRIDGE);
        }
        return new Vc(EnumC0230ea.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0609te(EnumC0230ea.APPSFLYER);
        }
        return new Vc(EnumC0230ea.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0609te(EnumC0230ea.KOCHAVA);
        }
        return new C0756zb(EnumC0230ea.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0609te(EnumC0230ea.SINGULAR);
        }
        return new Vc(EnumC0230ea.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0609te(EnumC0230ea.TENJIN);
        }
        return new Vc(EnumC0230ea.TENJIN, map);
    }
}

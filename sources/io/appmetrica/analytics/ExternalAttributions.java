package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0122ad;
import io.appmetrica.analytics.impl.C0760ze;
import io.appmetrica.analytics.impl.De;
import io.appmetrica.analytics.impl.Eb;
import io.appmetrica.analytics.impl.EnumC0351ja;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0760ze(EnumC0351ja.ADJUST);
        }
        return new De(EnumC0351ja.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0760ze(EnumC0351ja.AIRBRIDGE);
        }
        return new C0122ad(EnumC0351ja.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0760ze(EnumC0351ja.APPSFLYER);
        }
        return new C0122ad(EnumC0351ja.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0760ze(EnumC0351ja.KOCHAVA);
        }
        return new Eb(EnumC0351ja.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0760ze(EnumC0351ja.SINGULAR);
        }
        return new C0122ad(EnumC0351ja.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0760ze(EnumC0351ja.TENJIN);
        }
        return new C0122ad(EnumC0351ja.TENJIN, map);
    }
}

package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0123ad;
import io.appmetrica.analytics.impl.C0761ze;
import io.appmetrica.analytics.impl.De;
import io.appmetrica.analytics.impl.Eb;
import io.appmetrica.analytics.impl.EnumC0352ja;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new C0761ze(EnumC0352ja.ADJUST);
        }
        return new De(EnumC0352ja.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new C0761ze(EnumC0352ja.AIRBRIDGE);
        }
        return new C0123ad(EnumC0352ja.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new C0761ze(EnumC0352ja.APPSFLYER);
        }
        return new C0123ad(EnumC0352ja.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new C0761ze(EnumC0352ja.KOCHAVA);
        }
        return new Eb(EnumC0352ja.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new C0761ze(EnumC0352ja.SINGULAR);
        }
        return new C0123ad(EnumC0352ja.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new C0761ze(EnumC0352ja.TENJIN);
        }
        return new C0123ad(EnumC0352ja.TENJIN, map);
    }
}

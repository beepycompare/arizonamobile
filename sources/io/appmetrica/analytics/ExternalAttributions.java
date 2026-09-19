package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C0144bd;
import io.appmetrica.analytics.impl.EnumC0218ea;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.Ge;
import io.appmetrica.analytics.impl.Ke;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        if (obj == null) {
            return new Ge(EnumC0218ea.b);
        }
        return new Ke(EnumC0218ea.b, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0218ea.e);
        }
        return new C0144bd(EnumC0218ea.e, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0218ea.f963a);
        }
        return new C0144bd(EnumC0218ea.f963a, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Ge(EnumC0218ea.c);
        }
        return new Gb(EnumC0218ea.c, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        if (map == null) {
            return new Ge(EnumC0218ea.f);
        }
        return new C0144bd(EnumC0218ea.f, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        if (map == null) {
            return new Ge(EnumC0218ea.d);
        }
        return new C0144bd(EnumC0218ea.d, map);
    }
}

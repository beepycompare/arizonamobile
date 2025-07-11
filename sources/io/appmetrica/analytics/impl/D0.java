package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class D0 {
    public static String a(C0 c0) {
        try {
            return Base64.encodeToString(new JSONObject().put("apiKey", c0.f363a).put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, c0.b).put("reporterType", c0.c.getStringValue()).put("processID", c0.d).put("processSessionID", c0.e).put("errorEnvironment", c0.f).toString().getBytes(Charsets.UTF_8), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static C0 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), Charsets.UTF_8));
            return new C0(jSONObject.getString("apiKey"), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME), CounterConfigurationReporterType.Companion.fromStringValue(jSONObject.getString("reporterType")), jSONObject.getInt("processID"), jSONObject.getString("processSessionID"), JsonUtils.optStringOrNull(jSONObject, "errorEnvironment"));
        } catch (Throwable unused) {
            return null;
        }
    }
}

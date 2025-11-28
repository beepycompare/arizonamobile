package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class G0 {
    public static String a(F0 f0) {
        try {
            return Base64.encodeToString(new JSONObject().put("apiKey", f0.f468a).put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, f0.b).put("reporterType", f0.c.getStringValue()).put("processID", f0.d).put("processSessionID", f0.e).put("errorEnvironment", f0.f).toString().getBytes(Charsets.UTF_8), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static F0 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), Charsets.UTF_8));
            return new F0(jSONObject.getString("apiKey"), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME), CounterConfigurationReporterType.Companion.fromStringValue(jSONObject.getString("reporterType")), jSONObject.getInt("processID"), jSONObject.getString("processSessionID"), JsonUtils.optStringOrNull(jSONObject, "errorEnvironment"));
        } catch (Throwable unused) {
            return null;
        }
    }
}

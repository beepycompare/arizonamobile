package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class L7 {
    public static final String a(Eh eh) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject().put("dId", eh.getDeviceId()).put("uId", eh.getUuid()).put("appVer", eh.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, eh.getAppBuildNumber()).put("kitBuildType", eh.getAnalyticsSdkBuildType()).put("osVer", eh.getOsVersion()).put("osApiLev", eh.getOsApiLevel()).put("lang", eh.getLocale()).put("root", eh.getDeviceRootStatus()).put("app_debuggable", ((C0191d6) eh).f941a).put(CommonUrlParts.APP_FRAMEWORK, eh.getAppFramework()).put("attribution_id", eh.r).put("analyticsSdkVersionName", eh.getAnalyticsSdkVersionName()).put("kitBuildNumber", eh.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        return jSONObject.toString();
    }
}

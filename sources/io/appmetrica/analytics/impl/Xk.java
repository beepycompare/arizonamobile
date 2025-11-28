package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final String f759a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;

    public Xk(JSONObject jSONObject) {
        this.f759a = jSONObject.optString("analyticsSdkVersionName", "");
        this.b = jSONObject.optString("kitBuildNumber", "");
        this.c = jSONObject.optString("appVer", "");
        this.d = jSONObject.optString(RemoteConfigConstants.RequestFieldKey.APP_BUILD, "");
        this.e = jSONObject.optString("osVer", "");
        this.f = jSONObject.optInt("osApiLev", -1);
        this.g = jSONObject.optInt("attribution_id", 0);
    }

    public final String toString() {
        return "SessionRequestParams(kitVersionName='" + this.f759a + "', kitBuildNumber='" + this.b + "', appVersion='" + this.c + "', appBuild='" + this.d + "', osVersion='" + this.e + "', apiLevel=" + this.f + ", attributionId=" + this.g + ')';
    }
}

package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0697wl {

    /* renamed from: a  reason: collision with root package name */
    public final String f1269a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final int m;
    public final String n;
    public final String o;

    public C0697wl(JSONObject jSONObject) {
        this.f1269a = jSONObject.toString();
        this.b = jSONObject.optString("dId", "");
        this.c = jSONObject.optString("uId", "");
        this.d = jSONObject.optString("appVer", "");
        this.e = jSONObject.optString(RemoteConfigConstants.RequestFieldKey.APP_BUILD, "");
        this.f = jSONObject.optString("kitBuildType", "");
        this.g = jSONObject.optString("osVer", "");
        this.h = jSONObject.optInt("osApiLev", -1);
        this.i = jSONObject.optString("lang", "");
        this.j = jSONObject.optString("root", "");
        this.k = jSONObject.optString("app_debuggable", "");
        this.l = jSONObject.optString(CommonUrlParts.APP_FRAMEWORK, "");
        this.m = jSONObject.optInt("attribution_id", 0);
        this.n = jSONObject.optString("analyticsSdkVersionName", "");
        this.o = jSONObject.optString("kitBuildNumber", "");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionRequestParams(deviceId='");
        sb.append(this.b).append("', uuid='").append(this.c).append("', appVersion='").append(this.d).append("', appBuild='").append(this.e).append("', kitBuildType='").append(this.f).append("', osVersion='").append(this.g).append("', apiLevel=").append(this.h).append(", locale='").append(this.i).append("', deviceRootStatus='").append(this.j).append("', appDebuggable='").append(this.k).append("', appFramework='").append(this.l).append("', attributionId=");
        sb.append(this.m).append(", kitVersionName='").append(this.n).append("', kitBuildNumber='").append(this.o).append("')");
        return sb.toString();
    }
}

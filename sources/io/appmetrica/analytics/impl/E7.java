package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* loaded from: classes4.dex */
public final class E7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f403a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public E7(C0736yb c0736yb) {
        this.f403a = c0736yb.b("dId");
        this.b = c0736yb.b("uId");
        this.c = c0736yb.b("analyticsSdkVersionName");
        this.d = c0736yb.b("kitBuildNumber");
        this.e = c0736yb.b("kitBuildType");
        this.f = c0736yb.b("appVer");
        this.g = c0736yb.optString("app_debuggable", "0");
        this.h = c0736yb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0736yb.b("osVer");
        this.k = c0736yb.b("lang");
        this.l = c0736yb.b("root");
        this.m = c0736yb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0736yb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0736yb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f403a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public E7() {
        this.f403a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }
}

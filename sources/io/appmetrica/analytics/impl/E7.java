package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* loaded from: classes4.dex */
public final class E7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f404a;
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

    public E7(C0728yb c0728yb) {
        this.f404a = c0728yb.b("dId");
        this.b = c0728yb.b("uId");
        this.c = c0728yb.b("analyticsSdkVersionName");
        this.d = c0728yb.b("kitBuildNumber");
        this.e = c0728yb.b("kitBuildType");
        this.f = c0728yb.b("appVer");
        this.g = c0728yb.optString("app_debuggable", "0");
        this.h = c0728yb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0728yb.b("osVer");
        this.k = c0728yb.b("lang");
        this.l = c0728yb.b("root");
        this.m = c0728yb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0728yb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0728yb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f404a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public E7() {
        this.f404a = null;
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

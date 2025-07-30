package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* loaded from: classes4.dex */
public final class H7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f468a;
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

    public H7(Ab ab) {
        this.f468a = ab.b("dId");
        this.b = ab.b("uId");
        this.c = ab.b("analyticsSdkVersionName");
        this.d = ab.b("kitBuildNumber");
        this.e = ab.b("kitBuildType");
        this.f = ab.b("appVer");
        this.g = ab.optString("app_debuggable", "0");
        this.h = ab.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = ab.b("osVer");
        this.k = ab.b("lang");
        this.l = ab.b("root");
        this.m = ab.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = ab.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = ab.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f468a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public H7() {
        this.f468a = null;
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

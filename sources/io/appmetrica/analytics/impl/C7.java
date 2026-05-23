package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* loaded from: classes5.dex */
public final class C7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f489a;
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

    public C7(Hb hb) {
        this.f489a = hb.c("dId");
        this.b = hb.c("uId");
        this.c = hb.c("analyticsSdkVersionName");
        this.d = hb.c("kitBuildNumber");
        this.e = hb.c("kitBuildType");
        this.f = hb.c("appVer");
        this.g = hb.optString("app_debuggable", "0");
        this.h = hb.c(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = hb.c("osVer");
        this.k = hb.c("lang");
        this.l = hb.c("root");
        this.m = hb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = hb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = hb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f489a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C7() {
        this.f489a = null;
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

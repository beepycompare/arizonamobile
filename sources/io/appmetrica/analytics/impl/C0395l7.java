package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* renamed from: io.appmetrica.analytics.impl.l7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0395l7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1093a;
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

    public C0395l7(C0245fb c0245fb) {
        this.f1093a = c0245fb.b("dId");
        this.b = c0245fb.b("uId");
        this.c = c0245fb.b("analyticsSdkVersionName");
        this.d = c0245fb.b("kitBuildNumber");
        this.e = c0245fb.b("kitBuildType");
        this.f = c0245fb.b("appVer");
        this.g = c0245fb.optString("app_debuggable", "0");
        this.h = c0245fb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0245fb.b("osVer");
        this.k = c0245fb.b("lang");
        this.l = c0245fb.b("root");
        this.m = c0245fb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0245fb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0245fb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f1093a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C0395l7() {
        this.f1093a = null;
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

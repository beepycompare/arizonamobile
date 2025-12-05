package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* renamed from: io.appmetrica.analytics.impl.m7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0417m7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1089a;
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

    public C0417m7(C0267gb c0267gb) {
        this.f1089a = c0267gb.b("dId");
        this.b = c0267gb.b("uId");
        this.c = c0267gb.b("analyticsSdkVersionName");
        this.d = c0267gb.b("kitBuildNumber");
        this.e = c0267gb.b("kitBuildType");
        this.f = c0267gb.b("appVer");
        this.g = c0267gb.optString("app_debuggable", "0");
        this.h = c0267gb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0267gb.b("osVer");
        this.k = c0267gb.b("lang");
        this.l = c0267gb.b("root");
        this.m = c0267gb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0267gb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0267gb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f1089a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C0417m7() {
        this.f1089a = null;
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

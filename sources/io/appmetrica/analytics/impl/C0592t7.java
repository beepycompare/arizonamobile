package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* renamed from: io.appmetrica.analytics.impl.t7  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0592t7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1128a;
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

    public C0592t7(C0422mb c0422mb) {
        this.f1128a = c0422mb.b("dId");
        this.b = c0422mb.b("uId");
        this.c = c0422mb.b("analyticsSdkVersionName");
        this.d = c0422mb.b("kitBuildNumber");
        this.e = c0422mb.b("kitBuildType");
        this.f = c0422mb.b("appVer");
        this.g = c0422mb.optString("app_debuggable", "0");
        this.h = c0422mb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0422mb.b("osVer");
        this.k = c0422mb.b("lang");
        this.l = c0422mb.b("root");
        this.m = c0422mb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0422mb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0422mb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f1128a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C0592t7() {
        this.f1128a = null;
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

package io.appmetrica.analytics.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
/* renamed from: io.appmetrica.analytics.impl.m7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0418m7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1006a;
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

    public C0418m7(C0268gb c0268gb) {
        this.f1006a = c0268gb.b("dId");
        this.b = c0268gb.b("uId");
        this.c = c0268gb.b("analyticsSdkVersionName");
        this.d = c0268gb.b("kitBuildNumber");
        this.e = c0268gb.b("kitBuildType");
        this.f = c0268gb.b("appVer");
        this.g = c0268gb.optString("app_debuggable", "0");
        this.h = c0268gb.b(RemoteConfigConstants.RequestFieldKey.APP_BUILD);
        this.i = c0268gb.b("osVer");
        this.k = c0268gb.b("lang");
        this.l = c0268gb.b("root");
        this.m = c0268gb.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int optInt = c0268gb.optInt("osApiLev", -1);
        this.j = optInt == -1 ? null : String.valueOf(optInt);
        int optInt2 = c0268gb.optInt("attribution_id", 0);
        this.n = optInt2 > 0 ? String.valueOf(optInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.f1006a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C0418m7() {
        this.f1006a = null;
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

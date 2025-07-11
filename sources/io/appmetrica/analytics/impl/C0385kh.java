package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.AdvIdWithLimitedAppender;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.IParamsAppender;
import io.appmetrica.analytics.networktasks.internal.NetworkTaskForSendingDataParamsAppender;
import io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0385kh implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final AdvIdWithLimitedAppender f908a;
    public final NetworkTaskForSendingDataParamsAppender b;
    public E7 c;
    public final C0128ac d;
    public long e;

    public C0385kh(RequestBodyEncrypter requestBodyEncrypter) {
        this(new AdvIdWithLimitedAppender(), new NetworkTaskForSendingDataParamsAppender(requestBodyEncrypter), new C0128ac());
    }

    public final void a(E7 e7) {
        this.c = e7;
    }

    public C0385kh(AdvIdWithLimitedAppender advIdWithLimitedAppender, NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender, C0128ac c0128ac) {
        this.f908a = advIdWithLimitedAppender;
        this.b = networkTaskForSendingDataParamsAppender;
        this.d = c0128ac;
    }

    public final void a(long j) {
        this.e = j;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0659vh c0659vh) {
        builder.path("report");
        this.b.appendEncryptedData(builder);
        E7 e7 = this.c;
        if (e7 != null) {
            builder.appendQueryParameter(CommonUrlParts.DEVICE_ID, StringUtils.ifIsEmptyToDef(e7.f404a, c0659vh.getDeviceId()));
            builder.appendQueryParameter(CommonUrlParts.UUID, StringUtils.ifIsEmptyToDef(this.c.b, c0659vh.getUuid()));
            a(builder, CommonUrlParts.ANALYTICS_SDK_VERSION_NAME, this.c.c);
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION, StringUtils.ifIsEmptyToDef(this.c.f, c0659vh.getAppVersion()));
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION_CODE, StringUtils.ifIsEmptyToDef(this.c.h, c0659vh.getAppBuildNumber()));
            builder.appendQueryParameter(CommonUrlParts.OS_VERSION, StringUtils.ifIsEmptyToDef(this.c.i, c0659vh.getOsVersion()));
            a(builder, CommonUrlParts.OS_API_LEVEL, this.c.j);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_NUMBER, this.c.d);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_TYPE, this.c.e);
            a(builder, "app_debuggable", this.c.g);
            builder.appendQueryParameter(CommonUrlParts.LOCALE, StringUtils.ifIsEmptyToDef(this.c.k, c0659vh.getLocale()));
            builder.appendQueryParameter(CommonUrlParts.ROOT_STATUS, StringUtils.ifIsEmptyToDef(this.c.l, c0659vh.getDeviceRootStatus()));
            builder.appendQueryParameter(CommonUrlParts.APP_FRAMEWORK, StringUtils.ifIsEmptyToDef(this.c.m, c0659vh.getAppFramework()));
            a(builder, "attribution_id", this.c.n);
        }
        builder.appendQueryParameter("api_key_128", c0659vh.m);
        builder.appendQueryParameter("app_id", c0659vh.getPackageName());
        builder.appendQueryParameter(CommonUrlParts.APP_PLATFORM, c0659vh.getAppPlatform());
        builder.appendQueryParameter(CommonUrlParts.MODEL, c0659vh.getModel());
        builder.appendQueryParameter(CommonUrlParts.MANUFACTURER, c0659vh.getManufacturer());
        builder.appendQueryParameter(CommonUrlParts.SCREEN_WIDTH, String.valueOf(c0659vh.getScreenWidth()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_HEIGHT, String.valueOf(c0659vh.getScreenHeight()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_DPI, String.valueOf(c0659vh.getScreenDpi()));
        builder.appendQueryParameter(CommonUrlParts.SCALE_FACTOR, String.valueOf(c0659vh.getScaleFactor()));
        builder.appendQueryParameter(CommonUrlParts.DEVICE_TYPE, c0659vh.getDeviceType());
        a(builder, "clids_set", (String) WrapUtils.getOrDefault(c0659vh.p, ""));
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID, c0659vh.getAppSetId());
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID_SCOPE, c0659vh.getAppSetIdScope());
        AdvIdWithLimitedAppender advIdWithLimitedAppender = this.f908a;
        this.d.getClass();
        advIdWithLimitedAppender.appendParams(builder, Ga.F.b().getIdentifiers());
        builder.appendQueryParameter(CommonUrlParts.REQUEST_ID, String.valueOf(this.e));
    }

    public static void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }
}

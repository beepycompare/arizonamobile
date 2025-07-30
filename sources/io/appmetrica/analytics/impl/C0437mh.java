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
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0437mh implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final AdvIdWithLimitedAppender f956a;
    public final NetworkTaskForSendingDataParamsAppender b;
    public H7 c;
    public final C0180cc d;
    public long e;

    public C0437mh(RequestBodyEncrypter requestBodyEncrypter) {
        this(new AdvIdWithLimitedAppender(), new NetworkTaskForSendingDataParamsAppender(requestBodyEncrypter), new C0180cc());
    }

    public final void a(H7 h7) {
        this.c = h7;
    }

    public C0437mh(AdvIdWithLimitedAppender advIdWithLimitedAppender, NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender, C0180cc c0180cc) {
        this.f956a = advIdWithLimitedAppender;
        this.b = networkTaskForSendingDataParamsAppender;
        this.d = c0180cc;
    }

    public final void a(long j) {
        this.e = j;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0711xh c0711xh) {
        builder.path("report");
        this.b.appendEncryptedData(builder);
        H7 h7 = this.c;
        if (h7 != null) {
            builder.appendQueryParameter(CommonUrlParts.DEVICE_ID, StringUtils.ifIsEmptyToDef(h7.f468a, c0711xh.getDeviceId()));
            builder.appendQueryParameter(CommonUrlParts.UUID, StringUtils.ifIsEmptyToDef(this.c.b, c0711xh.getUuid()));
            a(builder, CommonUrlParts.ANALYTICS_SDK_VERSION_NAME, this.c.c);
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION, StringUtils.ifIsEmptyToDef(this.c.f, c0711xh.getAppVersion()));
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION_CODE, StringUtils.ifIsEmptyToDef(this.c.h, c0711xh.getAppBuildNumber()));
            builder.appendQueryParameter(CommonUrlParts.OS_VERSION, StringUtils.ifIsEmptyToDef(this.c.i, c0711xh.getOsVersion()));
            a(builder, CommonUrlParts.OS_API_LEVEL, this.c.j);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_NUMBER, this.c.d);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_TYPE, this.c.e);
            a(builder, "app_debuggable", this.c.g);
            builder.appendQueryParameter(CommonUrlParts.LOCALE, StringUtils.ifIsEmptyToDef(this.c.k, c0711xh.getLocale()));
            builder.appendQueryParameter(CommonUrlParts.ROOT_STATUS, StringUtils.ifIsEmptyToDef(this.c.l, c0711xh.getDeviceRootStatus()));
            builder.appendQueryParameter(CommonUrlParts.APP_FRAMEWORK, StringUtils.ifIsEmptyToDef(this.c.m, c0711xh.getAppFramework()));
            a(builder, "attribution_id", this.c.n);
        }
        builder.appendQueryParameter("api_key_128", c0711xh.m);
        builder.appendQueryParameter("app_id", c0711xh.getPackageName());
        builder.appendQueryParameter(CommonUrlParts.APP_PLATFORM, c0711xh.getAppPlatform());
        builder.appendQueryParameter(CommonUrlParts.MODEL, c0711xh.getModel());
        builder.appendQueryParameter(CommonUrlParts.MANUFACTURER, c0711xh.getManufacturer());
        builder.appendQueryParameter(CommonUrlParts.SCREEN_WIDTH, String.valueOf(c0711xh.getScreenWidth()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_HEIGHT, String.valueOf(c0711xh.getScreenHeight()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_DPI, String.valueOf(c0711xh.getScreenDpi()));
        builder.appendQueryParameter(CommonUrlParts.SCALE_FACTOR, String.valueOf(c0711xh.getScaleFactor()));
        builder.appendQueryParameter(CommonUrlParts.DEVICE_TYPE, c0711xh.getDeviceType());
        a(builder, "clids_set", (String) WrapUtils.getOrDefault(c0711xh.p, ""));
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID, c0711xh.getAppSetId());
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID_SCOPE, c0711xh.getAppSetIdScope());
        AdvIdWithLimitedAppender advIdWithLimitedAppender = this.f956a;
        this.d.getClass();
        advIdWithLimitedAppender.appendParams(builder, Ia.F.b().getIdentifiers());
        builder.appendQueryParameter(CommonUrlParts.REQUEST_ID, String.valueOf(this.e));
    }

    public static void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }
}

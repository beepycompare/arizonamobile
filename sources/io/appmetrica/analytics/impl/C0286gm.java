package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.IParamsAppender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0286gm implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final Be f897a;
    public final Kd b;
    public final C0302hc c = new C0302hc();

    public C0286gm(Be be, Kd kd) {
        this.f897a = be;
        this.b = kd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0389km c0389km) {
        String str;
        Jg jg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.DEVICE_ID), c0389km.getDeviceId());
        a(builder, Na.F.g(), this.c);
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.APP_SET_ID), c0389km.getAppSetId());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0389km.getAppSetIdScope());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.APP_PLATFORM), c0389km.getAppPlatform());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.PROTOCOL_VERSION), c0389km.getProtocolVersion());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0389km.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.MODEL), c0389km.getModel());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.MANUFACTURER), c0389km.getManufacturer());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.OS_VERSION), c0389km.getOsVersion());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0389km.getScreenWidth()));
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0389km.getScreenHeight()));
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0389km.getScreenDpi()));
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0389km.getScaleFactor()));
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.LOCALE), c0389km.getLocale());
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.DEVICE_TYPE), c0389km.getDeviceType());
        builder.appendQueryParameter(this.f897a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f897a.a("features");
        List<String> h = ((Hk) this.b).h();
        String[] strArr = {this.f897a.a("permissions_collecting"), this.f897a.a("features_collecting"), this.f897a.a("google_aid"), this.f897a.a("huawei_oaid"), this.f897a.a("sim_info"), this.f897a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f897a.a("app_id"), c0389km.getPackageName());
        builder.appendQueryParameter(this.f897a.a("app_debuggable"), ((C0425m6) c0389km).f984a);
        if (c0389km.l) {
            String str2 = c0389km.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f897a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f897a.a("detect_locale"), String.valueOf(1));
        }
        Q3 q3 = c0389km.i;
        if (!ro.a(q3.f630a)) {
            builder.appendQueryParameter(this.f897a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f897a.a("clids_set"), Pm.a(q3.f630a));
            int ordinal = q3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f897a.a("clids_set_source"), str);
            String str3 = c0389km.f;
            String str4 = c0389km.g;
            if (TextUtils.isEmpty(str3) && (jg = c0389km.o.b) != null) {
                str3 = jg.f515a;
                str4 = jg.d.f495a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f897a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f897a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0389km.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f897a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f897a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("app_system_flag"), ((C0425m6) c0389km).b);
        builder.appendQueryParameter(this.f897a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f897a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((Hk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0302hc c0302hc) {
        c0302hc.getClass();
        AdvertisingIdsHolder identifiers = Na.F.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f897a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f897a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

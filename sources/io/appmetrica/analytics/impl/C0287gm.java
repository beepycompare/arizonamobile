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
public final class C0287gm implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final Be f902a;
    public final Kd b;
    public final C0303hc c = new C0303hc();

    public C0287gm(Be be, Kd kd) {
        this.f902a = be;
        this.b = kd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0390km c0390km) {
        String str;
        Jg jg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.DEVICE_ID), c0390km.getDeviceId());
        a(builder, Na.F.g(), this.c);
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.APP_SET_ID), c0390km.getAppSetId());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0390km.getAppSetIdScope());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.APP_PLATFORM), c0390km.getAppPlatform());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.PROTOCOL_VERSION), c0390km.getProtocolVersion());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0390km.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.MODEL), c0390km.getModel());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.MANUFACTURER), c0390km.getManufacturer());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.OS_VERSION), c0390km.getOsVersion());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0390km.getScreenWidth()));
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0390km.getScreenHeight()));
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0390km.getScreenDpi()));
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0390km.getScaleFactor()));
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.LOCALE), c0390km.getLocale());
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.DEVICE_TYPE), c0390km.getDeviceType());
        builder.appendQueryParameter(this.f902a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f902a.a("features");
        List<String> h = ((Hk) this.b).h();
        String[] strArr = {this.f902a.a("permissions_collecting"), this.f902a.a("features_collecting"), this.f902a.a("google_aid"), this.f902a.a("huawei_oaid"), this.f902a.a("sim_info"), this.f902a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f902a.a("app_id"), c0390km.getPackageName());
        builder.appendQueryParameter(this.f902a.a("app_debuggable"), ((C0426m6) c0390km).f989a);
        if (c0390km.l) {
            String str2 = c0390km.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f902a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f902a.a("detect_locale"), String.valueOf(1));
        }
        Q3 q3 = c0390km.i;
        if (!ro.a(q3.f635a)) {
            builder.appendQueryParameter(this.f902a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f902a.a("clids_set"), Pm.a(q3.f635a));
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
            builder.appendQueryParameter(this.f902a.a("clids_set_source"), str);
            String str3 = c0390km.f;
            String str4 = c0390km.g;
            if (TextUtils.isEmpty(str3) && (jg = c0390km.o.b) != null) {
                str3 = jg.f520a;
                str4 = jg.d.f500a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f902a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f902a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0390km.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f902a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f902a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("app_system_flag"), ((C0426m6) c0390km).b);
        builder.appendQueryParameter(this.f902a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f902a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((Hk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0303hc c0303hc) {
        c0303hc.getClass();
        AdvertisingIdsHolder identifiers = Na.F.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f902a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f902a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

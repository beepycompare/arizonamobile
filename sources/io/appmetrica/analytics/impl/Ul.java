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
/* loaded from: classes4.dex */
public final class Ul implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0606te f664a;
    public final Cd b;
    public final C0128ac c = new C0128ac();

    public Ul(C0606te c0606te, Cd cd) {
        this.f664a = c0606te;
        this.b = cd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, Yl yl) {
        String str;
        C0733yg c0733yg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.DEVICE_ID), yl.getDeviceId());
        a(builder, Ga.F.g(), this.c);
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.APP_SET_ID), yl.getAppSetId());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.APP_SET_ID_SCOPE), yl.getAppSetIdScope());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.APP_PLATFORM), yl.getAppPlatform());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.PROTOCOL_VERSION), yl.getProtocolVersion());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), yl.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.MODEL), yl.getModel());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.MANUFACTURER), yl.getManufacturer());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.OS_VERSION), yl.getOsVersion());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(yl.getScreenWidth()));
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(yl.getScreenHeight()));
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(yl.getScreenDpi()));
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(yl.getScaleFactor()));
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.LOCALE), yl.getLocale());
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.DEVICE_TYPE), yl.getDeviceType());
        builder.appendQueryParameter(this.f664a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f664a.a("features");
        List<String> h = ((C0662vk) this.b).h();
        String[] strArr = {this.f664a.a("permissions_collecting"), this.f664a.a("features_collecting"), this.f664a.a("google_aid"), this.f664a.a("huawei_oaid"), this.f664a.a("sim_info"), this.f664a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f664a.a("app_id"), yl.getPackageName());
        builder.appendQueryParameter(this.f664a.a("app_debuggable"), ((C0275g6) yl).f852a);
        if (yl.l) {
            String str2 = yl.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f664a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f664a.a("detect_locale"), String.valueOf(1));
        }
        N3 n3 = yl.i;
        if (!fo.a(n3.f548a)) {
            builder.appendQueryParameter(this.f664a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f664a.a("clids_set"), Dm.a(n3.f548a));
            int ordinal = n3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f664a.a("clids_set_source"), str);
            String str3 = yl.f;
            String str4 = yl.g;
            if (TextUtils.isEmpty(str3) && (c0733yg = yl.o.b) != null) {
                str3 = c0733yg.f1147a;
                str4 = c0733yg.d.f1127a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f664a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f664a.a("install_referrer_source"), str4);
            }
        }
        String uuid = yl.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f664a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f664a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("app_system_flag"), ((C0275g6) yl).b);
        builder.appendQueryParameter(this.f664a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f664a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((C0662vk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0128ac c0128ac) {
        c0128ac.getClass();
        AdvertisingIdsHolder identifiers = Ga.F.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForReporter()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f664a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f664a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

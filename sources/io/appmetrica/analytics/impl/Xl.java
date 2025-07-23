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
public final class Xl implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0658ve f723a;
    public final Ed b;
    public final C0180cc c = new C0180cc();

    public Xl(C0658ve c0658ve, Ed ed) {
        this.f723a = c0658ve;
        this.b = ed;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0164bm c0164bm) {
        String str;
        Ag ag;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.DEVICE_ID), c0164bm.getDeviceId());
        a(builder, Ia.F.g(), this.c);
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.APP_SET_ID), c0164bm.getAppSetId());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0164bm.getAppSetIdScope());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.APP_PLATFORM), c0164bm.getAppPlatform());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.PROTOCOL_VERSION), c0164bm.getProtocolVersion());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0164bm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.MODEL), c0164bm.getModel());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.MANUFACTURER), c0164bm.getManufacturer());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.OS_VERSION), c0164bm.getOsVersion());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0164bm.getScreenWidth()));
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0164bm.getScreenHeight()));
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0164bm.getScreenDpi()));
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0164bm.getScaleFactor()));
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.LOCALE), c0164bm.getLocale());
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.DEVICE_TYPE), c0164bm.getDeviceType());
        builder.appendQueryParameter(this.f723a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f723a.a("features");
        List<String> h = ((C0739yk) this.b).h();
        String[] strArr = {this.f723a.a("permissions_collecting"), this.f723a.a("features_collecting"), this.f723a.a("google_aid"), this.f723a.a("huawei_oaid"), this.f723a.a("sim_info"), this.f723a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f723a.a("app_id"), c0164bm.getPackageName());
        builder.appendQueryParameter(this.f723a.a("app_debuggable"), ((C0351j6) c0164bm).f914a);
        if (c0164bm.l) {
            String str2 = c0164bm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f723a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f723a.a("detect_locale"), String.valueOf(1));
        }
        N3 n3 = c0164bm.i;
        if (!io.a(n3.f558a)) {
            builder.appendQueryParameter(this.f723a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f723a.a("clids_set"), Gm.a(n3.f558a));
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
            builder.appendQueryParameter(this.f723a.a("clids_set_source"), str);
            String str3 = c0164bm.f;
            String str4 = c0164bm.g;
            if (TextUtils.isEmpty(str3) && (ag = c0164bm.o.b) != null) {
                str3 = ag.f339a;
                str4 = ag.d.f1172a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f723a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f723a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0164bm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f723a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f723a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("app_system_flag"), ((C0351j6) c0164bm).b);
        builder.appendQueryParameter(this.f723a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f723a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((C0739yk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0180cc c0180cc) {
        c0180cc.getClass();
        AdvertisingIdsHolder identifiers = Ia.F.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f723a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f723a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

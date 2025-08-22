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
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0183cm implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0706xe f817a;
    public final Gd b;
    public final C0224ec c = new C0224ec();

    public C0183cm(C0706xe c0706xe, Gd gd) {
        this.f817a = c0706xe;
        this.b = gd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0286gm c0286gm) {
        String str;
        Fg fg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.DEVICE_ID), c0286gm.getDeviceId());
        a(builder, Ka.F.g(), this.c);
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.APP_SET_ID), c0286gm.getAppSetId());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0286gm.getAppSetIdScope());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.APP_PLATFORM), c0286gm.getAppPlatform());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.PROTOCOL_VERSION), c0286gm.getProtocolVersion());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0286gm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.MODEL), c0286gm.getModel());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.MANUFACTURER), c0286gm.getManufacturer());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.OS_VERSION), c0286gm.getOsVersion());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0286gm.getScreenWidth()));
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0286gm.getScreenHeight()));
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0286gm.getScreenDpi()));
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0286gm.getScaleFactor()));
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.LOCALE), c0286gm.getLocale());
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.DEVICE_TYPE), c0286gm.getDeviceType());
        builder.appendQueryParameter(this.f817a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f817a.a("features");
        List<String> h = ((Dk) this.b).h();
        String[] strArr = {this.f817a.a("permissions_collecting"), this.f817a.a("features_collecting"), this.f817a.a("google_aid"), this.f817a.a("huawei_oaid"), this.f817a.a("sim_info"), this.f817a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f817a.a("app_id"), c0286gm.getPackageName());
        builder.appendQueryParameter(this.f817a.a("app_debuggable"), ((C0347j6) c0286gm).f919a);
        if (c0286gm.l) {
            String str2 = c0286gm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f817a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f817a.a("detect_locale"), String.valueOf(1));
        }
        N3 n3 = c0286gm.i;
        if (!no.a(n3.f572a)) {
            builder.appendQueryParameter(this.f817a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f817a.a("clids_set"), Lm.a(n3.f572a));
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
            builder.appendQueryParameter(this.f817a.a("clids_set_source"), str);
            String str3 = c0286gm.f;
            String str4 = c0286gm.g;
            if (TextUtils.isEmpty(str3) && (fg = c0286gm.o.b) != null) {
                str3 = fg.f436a;
                str4 = fg.d.f415a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f817a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f817a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0286gm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f817a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f817a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("app_system_flag"), ((C0347j6) c0286gm).b);
        builder.appendQueryParameter(this.f817a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f817a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((Dk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0224ec c0224ec) {
        c0224ec.getClass();
        AdvertisingIdsHolder identifiers = Ka.F.b().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f817a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f817a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

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
/* loaded from: classes5.dex */
public final class Xl implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0274ge f862a;
    public final InterfaceC0476od b;
    public final Hb c = new Hb();

    public Xl(C0274ge c0274ge, InterfaceC0476od interfaceC0476od) {
        this.f862a = c0274ge;
        this.b = interfaceC0476od;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0153bm c0153bm) {
        String str;
        C0454ng c0454ng;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.DEVICE_ID), c0153bm.getDeviceId());
        a(builder, C0448na.I.h(), this.c);
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.APP_SET_ID), c0153bm.getAppSetId());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0153bm.getAppSetIdScope());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.APP_PLATFORM), c0153bm.getAppPlatform());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.PROTOCOL_VERSION), c0153bm.getProtocolVersion());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0153bm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.MODEL), c0153bm.getModel());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.MANUFACTURER), c0153bm.getManufacturer());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.OS_VERSION), c0153bm.getOsVersion());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0153bm.getScreenWidth()));
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0153bm.getScreenHeight()));
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0153bm.getScreenDpi()));
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0153bm.getScaleFactor()));
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.LOCALE), c0153bm.getLocale());
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.DEVICE_TYPE), c0153bm.getDeviceType());
        builder.appendQueryParameter(this.f862a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f862a.a("features");
        List<String> h = ((C0707xk) this.b).h();
        String[] strArr = {this.f862a.a("permissions_collecting"), this.f862a.a("features_collecting"), this.f862a.a("google_aid"), this.f862a.a("huawei_oaid"), this.f862a.a("sim_info"), this.f862a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f862a.a("app_id"), c0153bm.getPackageName());
        builder.appendQueryParameter(this.f862a.a("app_debuggable"), ((N5) c0153bm).f710a);
        if (c0153bm.l) {
            String str2 = c0153bm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f862a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f862a.a("detect_locale"), String.valueOf(1));
        }
        C0540r3 c0540r3 = c0153bm.i;
        if (!lo.a(c0540r3.f1204a)) {
            builder.appendQueryParameter(this.f862a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f862a.a("clids_set"), Fm.a(c0540r3.f1204a));
            int ordinal = c0540r3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f862a.a("clids_set_source"), str);
            String str3 = c0153bm.f;
            String str4 = c0153bm.g;
            if (TextUtils.isEmpty(str3) && (c0454ng = c0153bm.o.b) != null) {
                str3 = c0454ng.f1142a;
                str4 = c0454ng.d.f1123a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f862a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f862a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0153bm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f862a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f862a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("app_system_flag"), ((N5) c0153bm).b);
        builder.appendQueryParameter(this.f862a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f862a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((C0707xk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, Hb hb) {
        hb.getClass();
        AdvertisingIdsHolder identifiers = C0448na.I.c().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            boolean isValid = google.isValid();
            C0274ge c0274ge = this.f862a;
            if (!isValid) {
                builder.appendQueryParameter(c0274ge.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(c0274ge.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            boolean isValid2 = huawei.isValid();
            C0274ge c0274ge2 = this.f862a;
            if (!isValid2) {
                builder.appendQueryParameter(c0274ge2.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(c0274ge2.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            boolean isValid3 = yandex.isValid();
            C0274ge c0274ge3 = this.f862a;
            if (!isValid3) {
                builder.appendQueryParameter(c0274ge3.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(c0274ge3.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f862a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

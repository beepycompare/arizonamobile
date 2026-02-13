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
    public final C0275ge f857a;
    public final InterfaceC0477od b;
    public final Hb c = new Hb();

    public Xl(C0275ge c0275ge, InterfaceC0477od interfaceC0477od) {
        this.f857a = c0275ge;
        this.b = interfaceC0477od;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0154bm c0154bm) {
        String str;
        C0455ng c0455ng;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.DEVICE_ID), c0154bm.getDeviceId());
        a(builder, C0449na.I.h(), this.c);
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.APP_SET_ID), c0154bm.getAppSetId());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0154bm.getAppSetIdScope());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.APP_PLATFORM), c0154bm.getAppPlatform());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.PROTOCOL_VERSION), c0154bm.getProtocolVersion());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0154bm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.MODEL), c0154bm.getModel());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.MANUFACTURER), c0154bm.getManufacturer());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.OS_VERSION), c0154bm.getOsVersion());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0154bm.getScreenWidth()));
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0154bm.getScreenHeight()));
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0154bm.getScreenDpi()));
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0154bm.getScaleFactor()));
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.LOCALE), c0154bm.getLocale());
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.DEVICE_TYPE), c0154bm.getDeviceType());
        builder.appendQueryParameter(this.f857a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f857a.a("features");
        List<String> h = ((C0708xk) this.b).h();
        String[] strArr = {this.f857a.a("permissions_collecting"), this.f857a.a("features_collecting"), this.f857a.a("google_aid"), this.f857a.a("huawei_oaid"), this.f857a.a("sim_info"), this.f857a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f857a.a("app_id"), c0154bm.getPackageName());
        builder.appendQueryParameter(this.f857a.a("app_debuggable"), ((N5) c0154bm).f705a);
        if (c0154bm.l) {
            String str2 = c0154bm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f857a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f857a.a("detect_locale"), String.valueOf(1));
        }
        C0541r3 c0541r3 = c0154bm.i;
        if (!lo.a(c0541r3.f1199a)) {
            builder.appendQueryParameter(this.f857a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f857a.a("clids_set"), Fm.a(c0541r3.f1199a));
            int ordinal = c0541r3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f857a.a("clids_set_source"), str);
            String str3 = c0154bm.f;
            String str4 = c0154bm.g;
            if (TextUtils.isEmpty(str3) && (c0455ng = c0154bm.o.b) != null) {
                str3 = c0455ng.f1137a;
                str4 = c0455ng.d.f1118a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f857a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f857a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0154bm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f857a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f857a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("app_system_flag"), ((N5) c0154bm).b);
        builder.appendQueryParameter(this.f857a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f857a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((C0708xk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, Hb hb) {
        hb.getClass();
        AdvertisingIdsHolder identifiers = C0449na.I.c().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f857a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f857a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

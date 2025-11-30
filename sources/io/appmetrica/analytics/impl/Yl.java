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
public final class Yl implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0297he f769a;
    public final InterfaceC0499pd b;
    public final Ib c = new Ib();

    public Yl(C0297he c0297he, InterfaceC0499pd interfaceC0499pd) {
        this.f769a = c0297he;
        this.b = interfaceC0499pd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0176cm c0176cm) {
        String str;
        C0477og c0477og;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.DEVICE_ID), c0176cm.getDeviceId());
        a(builder, C0471oa.I.h(), this.c);
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.APP_SET_ID), c0176cm.getAppSetId());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0176cm.getAppSetIdScope());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.APP_PLATFORM), c0176cm.getAppPlatform());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.PROTOCOL_VERSION), c0176cm.getProtocolVersion());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0176cm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.MODEL), c0176cm.getModel());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.MANUFACTURER), c0176cm.getManufacturer());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.OS_VERSION), c0176cm.getOsVersion());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0176cm.getScreenWidth()));
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0176cm.getScreenHeight()));
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0176cm.getScreenDpi()));
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0176cm.getScaleFactor()));
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.LOCALE), c0176cm.getLocale());
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.DEVICE_TYPE), c0176cm.getDeviceType());
        builder.appendQueryParameter(this.f769a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f769a.a("features");
        List<String> h = ((C0730yk) this.b).h();
        String[] strArr = {this.f769a.a("permissions_collecting"), this.f769a.a("features_collecting"), this.f769a.a("google_aid"), this.f769a.a("huawei_oaid"), this.f769a.a("sim_info"), this.f769a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f769a.a("app_id"), c0176cm.getPackageName());
        builder.appendQueryParameter(this.f769a.a("app_debuggable"), ((O5) c0176cm).f617a);
        if (c0176cm.l) {
            String str2 = c0176cm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f769a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f769a.a("detect_locale"), String.valueOf(1));
        }
        C0563s3 c0563s3 = c0176cm.i;
        if (!mo.a(c0563s3.f1111a)) {
            builder.appendQueryParameter(this.f769a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f769a.a("clids_set"), Gm.a(c0563s3.f1111a));
            int ordinal = c0563s3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f769a.a("clids_set_source"), str);
            String str3 = c0176cm.f;
            String str4 = c0176cm.g;
            if (TextUtils.isEmpty(str3) && (c0477og = c0176cm.o.b) != null) {
                str3 = c0477og.f1050a;
                str4 = c0477og.d.f1031a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f769a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f769a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0176cm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f769a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f769a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("app_system_flag"), ((O5) c0176cm).b);
        builder.appendQueryParameter(this.f769a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f769a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((C0730yk) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, Ib ib) {
        ib.getClass();
        AdvertisingIdsHolder identifiers = C0471oa.I.c().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f769a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f769a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

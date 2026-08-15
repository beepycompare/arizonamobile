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
/* renamed from: io.appmetrica.analytics.impl.zm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0775zm implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final Ie f1324a;
    public final Od b;
    public final C0350jc c = new C0350jc();

    public C0775zm(Ie ie, Od od) {
        this.f1324a = ie;
        this.b = od;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, Dm dm) {
        String str;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.DEVICE_ID), dm.getDeviceId());
        a(builder, Na.I.h(), this.c);
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.APP_SET_ID), dm.getAppSetId());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.APP_SET_ID_SCOPE), dm.getAppSetIdScope());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.APP_PLATFORM), dm.getAppPlatform());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.PROTOCOL_VERSION), dm.getProtocolVersion());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), dm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.MODEL), dm.getModel());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.MANUFACTURER), dm.getManufacturer());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.OS_VERSION), dm.getOsVersion());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(dm.getScreenWidth()));
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(dm.getScreenHeight()));
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(dm.getScreenDpi()));
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(dm.getScaleFactor()));
        builder.appendQueryParameter(this.f1324a.a("locale"), dm.getLocale());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.DEVICE_TYPE), dm.getDeviceType());
        builder.appendQueryParameter(this.f1324a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f1324a.a("features");
        List<String> g = ((Zk) this.b).g();
        String[] strArr = {this.f1324a.a("permissions_collecting"), this.f1324a.a("features_collecting"), this.f1324a.a("google_aid"), this.f1324a.a("huawei_oaid"), this.f1324a.a("sim_info"), this.f1324a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(g);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f1324a.a("app_id"), dm.getPackageName());
        builder.appendQueryParameter(this.f1324a.a("app_debuggable"), ((C0190d6) dm).f941a);
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.APP_VERSION), dm.getAppVersion());
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.APP_VERSION_CODE), dm.getAppBuildNumber());
        if (dm.l) {
            String str2 = dm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f1324a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f1324a.a("detect_locale"), String.valueOf(1));
        }
        I3 i3 = dm.i;
        if (!Oo.a(i3.f589a)) {
            builder.appendQueryParameter(this.f1324a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f1324a.a("clids_set"), AbstractC0310hn.a(i3.f589a));
            int ordinal = i3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f1324a.a("clids_set_source"), str);
            String str3 = dm.f;
            String str4 = dm.g;
            if (TextUtils.isEmpty(str3)) {
                Lg lg = dm.o.b;
                Bg a3 = lg == null ? null : lg.a();
                if (a3 != null) {
                    str3 = a3.f480a;
                    str4 = Ag.a(a3.d);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f1324a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f1324a.a("install_referrer_source"), str4);
            }
        }
        String uuid = dm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f1324a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("app_system_flag"), ((C0190d6) dm).b);
        builder.appendQueryParameter(this.f1324a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f1324a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> c = ((Zk) this.b).c();
        for (String str5 : c.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(c.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C0350jc c0350jc) {
        c0350jc.getClass();
        AdvertisingIdsHolder identifiers = Na.I.c().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            boolean isValid = google.isValid();
            Ie ie = this.f1324a;
            if (!isValid) {
                builder.appendQueryParameter(ie.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(ie.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            boolean isValid2 = huawei.isValid();
            Ie ie2 = this.f1324a;
            if (!isValid2) {
                builder.appendQueryParameter(ie2.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(ie2.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            boolean isValid3 = yandex.isValid();
            Ie ie3 = this.f1324a;
            if (!isValid3) {
                builder.appendQueryParameter(ie3.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(ie3.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f1324a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

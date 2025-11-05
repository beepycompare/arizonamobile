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
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0150bm implements IParamsAppender {

    /* renamed from: a  reason: collision with root package name */
    public final C0450ne f820a;
    public final InterfaceC0648vd b;
    public final Ob c = new Ob();

    public C0150bm(C0450ne c0450ne, InterfaceC0648vd interfaceC0648vd) {
        this.f820a = c0450ne;
        this.b = interfaceC0648vd;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a */
    public final void appendParams(Uri.Builder builder, C0253fm c0253fm) {
        String str;
        C0576sg c0576sg;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.DEVICE_ID), c0253fm.getDeviceId());
        a(builder, C0620ua.H.h(), this.c);
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.APP_SET_ID), c0253fm.getAppSetId());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.APP_SET_ID_SCOPE), c0253fm.getAppSetIdScope());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.APP_PLATFORM), c0253fm.getAppPlatform());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.PROTOCOL_VERSION), c0253fm.getProtocolVersion());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c0253fm.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.MODEL), c0253fm.getModel());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.MANUFACTURER), c0253fm.getManufacturer());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.OS_VERSION), c0253fm.getOsVersion());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c0253fm.getScreenWidth()));
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c0253fm.getScreenHeight()));
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c0253fm.getScreenDpi()));
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c0253fm.getScaleFactor()));
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.LOCALE), c0253fm.getLocale());
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.DEVICE_TYPE), c0253fm.getDeviceType());
        builder.appendQueryParameter(this.f820a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("query_hosts"), String.valueOf(2));
        String a2 = this.f820a.a("features");
        List<String> h = ((Ck) this.b).h();
        String[] strArr = {this.f820a.a("permissions_collecting"), this.f820a.a("features_collecting"), this.f820a.a("google_aid"), this.f820a.a("huawei_oaid"), this.f820a.a("sim_info"), this.f820a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(h);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(a2, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.f820a.a("app_id"), c0253fm.getPackageName());
        builder.appendQueryParameter(this.f820a.a("app_debuggable"), ((U5) c0253fm).f717a);
        if (c0253fm.l) {
            String str2 = c0253fm.m;
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.f820a.a("country_init"), str2);
            }
        } else {
            builder.appendQueryParameter(this.f820a.a("detect_locale"), String.valueOf(1));
        }
        C0738z3 c0738z3 = c0253fm.i;
        if (!no.a(c0738z3.f1224a)) {
            builder.appendQueryParameter(this.f820a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.f820a.a("clids_set"), Jm.a(c0738z3.f1224a));
            int ordinal = c0738z3.b.ordinal();
            if (ordinal == 1) {
                str = "api";
            } else if (ordinal == 2) {
                str = "satellite";
            } else if (ordinal != 3) {
                str = "";
            } else {
                str = "retail";
            }
            builder.appendQueryParameter(this.f820a.a("clids_set_source"), str);
            String str3 = c0253fm.f;
            String str4 = c0253fm.g;
            if (TextUtils.isEmpty(str3) && (c0576sg = c0253fm.o.b) != null) {
                str3 = c0576sg.f1114a;
                str4 = c0576sg.d.f1096a;
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter(this.f820a.a(Constants.INSTALL_REFERRER), str3);
                if (str4 == null) {
                    str4 = AbstractJsonLexerKt.NULL;
                }
                builder.appendQueryParameter(this.f820a.a("install_referrer_source"), str4);
            }
        }
        String uuid = c0253fm.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.f820a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.f820a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("app_system_flag"), ((U5) c0253fm).b);
        builder.appendQueryParameter(this.f820a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.f820a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> d = ((Ck) this.b).d();
        for (String str5 : d.keySet()) {
            builder.appendQueryParameter(str5, String.valueOf(d.get(str5)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, Ob ob) {
        ob.getClass();
        AdvertisingIdsHolder identifiers = C0620ua.H.c().getIdentifiers();
        if (identifiers != null && !dataSendingRestrictionController.isRestrictedForSdk()) {
            AdTrackingInfoResult google = identifiers.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = identifiers.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = identifiers.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.f820a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.f820a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}

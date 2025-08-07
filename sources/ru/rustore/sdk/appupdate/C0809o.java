package ru.rustore.sdk.appupdate;

import android.os.Bundle;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.core.util.PrimitivesExtensionKt;
/* renamed from: ru.rustore.sdk.appupdate.o  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0809o {

    /* renamed from: a  reason: collision with root package name */
    public final AppUpdateInfo.Factory f1387a;
    public final i0 b;

    public C0809o(AppUpdateInfo.Factory appUpdateInfoFactory, i0 timeProvider) {
        Intrinsics.checkNotNullParameter(appUpdateInfoFactory, "appUpdateInfoFactory");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f1387a = appUpdateInfoFactory;
        this.b = timeProvider;
    }

    public final AppUpdateInfo a(Bundle bundle) {
        String str;
        long j;
        String str2;
        String str3;
        long j2;
        int i;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AppUpdateInfo.Factory factory = this.f1387a;
        long j3 = bundle.getLong("APPLICATION_ID", 0L);
        String string = bundle.getString("APP_NAME");
        if (string == null) {
            string = "";
        }
        String string2 = bundle.getString("ICON_URL");
        if (string2 == null) {
            string2 = "";
        }
        long j4 = bundle.getLong("FILE_SIZE", 0L);
        String string3 = bundle.getString("PACKAGE_NAME");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = bundle.getString("AVAILABLE_VERSION_NAME");
        if (string4 == null) {
            string4 = "";
        }
        long j5 = bundle.getLong("AVAILABLE_VERSION_CODE_LONG", bundle.getInt("AVAILABLE_VERSION_CODE"));
        int i2 = bundle.getInt("INSTALL_STATUS", 0);
        String str4 = string;
        int i3 = bundle.getInt("UPDATE_AVAILABILITY", 0);
        int coerceIn = RangesKt.coerceIn(bundle.getInt("UPDATE_PRIORITY", 0), (ClosedRange<Integer>) new IntRange(0, 5));
        Date time = this.b.f1380a.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        String string5 = bundle.getString("UPDATED_AT", time.toString());
        Intrinsics.checkNotNullExpressionValue(string5, "bundle.getString(\n      …w().toString(),\n        )");
        String string6 = bundle.getString("whatsNew");
        if (string6 == null) {
            str = "";
            j = j3;
            str2 = string2;
            str3 = str4;
            i = coerceIn;
            j2 = j4;
        } else {
            str = string6;
            j = j3;
            str2 = string2;
            str3 = str4;
            j2 = j4;
            i = coerceIn;
        }
        return factory.create$sdk_public_appupdate_release(j, str3, str2, j2, string3, string4, j5, i2, i3, i, string5, str);
    }

    public static Bundle a(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
        Bundle bundle = new Bundle();
        bundle.putLong("APPLICATION_ID", appUpdateInfo.getAppId$sdk_public_appupdate_release());
        bundle.putString("PACKAGE_NAME", appUpdateInfo.getPackageName());
        bundle.putString("APP_NAME", appUpdateInfo.getAppName$sdk_public_appupdate_release());
        bundle.putString("ICON_URL", appUpdateInfo.getIconUrl$sdk_public_appupdate_release());
        bundle.putLong("FILE_SIZE", appUpdateInfo.getFileSize());
        bundle.putString("AVAILABLE_VERSION_NAME", appUpdateInfo.getAvailableVersionName());
        bundle.putInt("AVAILABLE_VERSION_CODE", PrimitivesExtensionKt.safeToInt(appUpdateInfo.getAvailableVersionCode()));
        bundle.putLong("AVAILABLE_VERSION_CODE_LONG", appUpdateInfo.getAvailableVersionCode());
        bundle.putString("whatsNew", appUpdateInfo.getWhatsNew());
        return bundle;
    }
}

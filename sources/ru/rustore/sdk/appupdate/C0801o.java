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
/* loaded from: classes6.dex */
public final class C0801o {

    /* renamed from: a  reason: collision with root package name */
    public final AppUpdateInfo.Factory f1558a;
    public final i0 b;

    public C0801o(AppUpdateInfo.Factory appUpdateInfoFactory, i0 timeProvider) {
        Intrinsics.checkNotNullParameter(appUpdateInfoFactory, "appUpdateInfoFactory");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f1558a = appUpdateInfoFactory;
        this.b = timeProvider;
    }

    public final AppUpdateInfo a(Bundle bundle) {
        String str;
        long j;
        String str2;
        String str3;
        int i;
        long j2;
        String str4;
        int i2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AppUpdateInfo.Factory factory = this.f1558a;
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
        int i3 = bundle.getInt("INSTALL_STATUS", 0);
        String str5 = string;
        int i4 = bundle.getInt("UPDATE_AVAILABILITY", 0);
        int coerceIn = RangesKt.coerceIn(bundle.getInt("UPDATE_PRIORITY", 0), (ClosedRange<Integer>) new IntRange(0, 5));
        Date time = this.b.f1551a.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        String string5 = bundle.getString("UPDATED_AT", time.toString());
        Intrinsics.checkNotNullExpressionValue(string5, "bundle.getString(\n      …w().toString(),\n        )");
        String string6 = bundle.getString("whatsNew");
        if (string6 == null) {
            str = "";
            j = j3;
            str2 = string2;
            str3 = str5;
            i = i4;
            str4 = string5;
            i2 = coerceIn;
            j2 = j4;
        } else {
            str = string6;
            j = j3;
            str2 = string2;
            str3 = str5;
            i = i4;
            j2 = j4;
            str4 = string5;
            i2 = coerceIn;
        }
        return factory.create$sdk_public_appupdate_release(j, str3, str2, j2, string3, string4, j5, i3, i, i2, str4, str);
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

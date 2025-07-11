package ru.rustore.sdk.appupdate;

import android.os.Bundle;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.core.util.PrimitivesExtensionKt;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final AppUpdateInfo.Factory f1327a;
    public final f0 b;

    public a(AppUpdateInfo.Factory appUpdateInfoFactory, f0 timeProvider) {
        Intrinsics.checkNotNullParameter(appUpdateInfoFactory, "appUpdateInfoFactory");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f1327a = appUpdateInfoFactory;
        this.b = timeProvider;
    }

    public final AppUpdateInfo a(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AppUpdateInfo.Factory factory = this.f1327a;
        long j = bundle.getLong("APPLICATION_ID", 0L);
        String string = bundle.getString("APP_NAME");
        if (string == null) {
            string = "";
        }
        String string2 = bundle.getString("ICON_URL");
        if (string2 == null) {
            string2 = "";
        }
        long j2 = bundle.getLong("FILE_SIZE", 0L);
        String string3 = bundle.getString("PACKAGE_NAME");
        if (string3 == null) {
            string3 = "";
        }
        long j3 = bundle.getLong("AVAILABLE_VERSION_CODE_LONG", bundle.getInt("AVAILABLE_VERSION_CODE"));
        int i = bundle.getInt("INSTALL_STATUS", 0);
        int i2 = bundle.getInt("UPDATE_AVAILABILITY", 0);
        String str = string;
        int coerceIn = RangesKt.coerceIn(bundle.getInt("UPDATE_PRIORITY", 0), (ClosedRange<Integer>) new IntRange(0, 5));
        Date time = this.b.f1348a.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        String string4 = bundle.getString("UPDATED_AT", time.toString());
        Intrinsics.checkNotNullExpressionValue(string4, "bundle.getString(\n      …w().toString(),\n        )");
        return factory.create$sdk_public_appupdate_release(j, str, string2, j2, string3, j3, i, i2, coerceIn, string4);
    }

    public static Bundle a(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "appUpdateInfo");
        Bundle bundle = new Bundle();
        bundle.putLong("APPLICATION_ID", appUpdateInfo.getAppId$sdk_public_appupdate_release());
        bundle.putString("PACKAGE_NAME", appUpdateInfo.getPackageName());
        bundle.putString("APP_NAME", appUpdateInfo.getAppName$sdk_public_appupdate_release());
        bundle.putString("ICON_URL", appUpdateInfo.getIconUrl$sdk_public_appupdate_release());
        bundle.putLong("FILE_SIZE", appUpdateInfo.getFileSize$sdk_public_appupdate_release());
        bundle.putInt("AVAILABLE_VERSION_CODE", PrimitivesExtensionKt.safeToInt(appUpdateInfo.getAvailableVersionCode()));
        bundle.putLong("AVAILABLE_VERSION_CODE_LONG", appUpdateInfo.getAvailableVersionCode());
        return bundle;
    }
}

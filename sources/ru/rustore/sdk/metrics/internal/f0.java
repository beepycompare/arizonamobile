package ru.rustore.sdk.metrics.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class f0 {
    public static final PackageInfo a(PackageManager packageManager, String str) {
        PackageInfo packageInfo;
        String str2;
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
            str2 = "{\n        getPackageInfo…ageInfoFlags.of(0))\n    }";
        } else {
            packageInfo = packageManager.getPackageInfo(str, 0);
            str2 = "getPackageInfo";
        }
        Intrinsics.checkNotNullExpressionValue(packageInfo, str2);
        return packageInfo;
    }
}

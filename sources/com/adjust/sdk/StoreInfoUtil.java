package com.adjust.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes3.dex */
public class StoreInfoUtil {
    public static String getStoreIdFromSystem(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                return packageManager.getInstallSourceInfo(packageName).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(packageName);
        } catch (Exception unused) {
            return null;
        }
    }

    public static AdjustStoreInfo getStoreInfoFromClient(AdjustConfig adjustConfig, Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return adjustConfig.storeInfo;
            }
            String string = bundle.getString("ADJUST_STORE_NAME");
            if (string != null && !string.isEmpty()) {
                String string2 = bundle.getString("ADJUST_STORE_APP_ID");
                AdjustStoreInfo adjustStoreInfo = new AdjustStoreInfo(string);
                adjustStoreInfo.setStoreAppId(string2);
                return adjustStoreInfo;
            }
            return adjustConfig.storeInfo;
        } catch (Exception unused) {
            return adjustConfig.storeInfo;
        }
    }
}

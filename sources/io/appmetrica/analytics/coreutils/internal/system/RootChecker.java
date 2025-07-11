package io.appmetrica.analytics.coreutils.internal.system;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.io.File;
/* loaded from: classes4.dex */
public final class RootChecker {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f294a = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

    /* loaded from: classes4.dex */
    public static final class RootStatus {
        public static final int NOT_ROOT = 0;
        public static final int ROOT = 1;
    }

    public static int isRootedPhone() {
        return (isSuperuserApkExists() || isSuperuserNativeLibExists()) ? 1 : 0;
    }

    public static boolean isSuperuserApkExists() {
        try {
            return new File("/system/app/Superuser/Superuser.apk").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isSuperuserNativeLibExists() {
        String[] strArr = f294a;
        for (int i = 0; i < 8; i++) {
            String str = strArr[i];
            try {
                if (!AndroidUtils.isApiAchieved(31) && new File(str + CmcdConfiguration.KEY_STARTUP).exists()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}

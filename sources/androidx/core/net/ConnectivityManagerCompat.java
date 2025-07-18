package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RestrictBackgroundStatus {
    }

    @ReplaceWith(expression = "cm.isActiveNetworkMetered()")
    @Deprecated
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
        return Api24Impl.getRestrictBackgroundStatus(connectivityManager);
    }

    private ConnectivityManagerCompat() {
    }

    /* loaded from: classes2.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
    }
}

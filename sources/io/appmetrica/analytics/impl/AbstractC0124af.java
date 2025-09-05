package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.Locale;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0124af {

    /* renamed from: a  reason: collision with root package name */
    public static final Ve f789a = new Ve();
    public static final We b = new We();
    public static final Xe c = new Xe(2);

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        String script = locale.getScript();
        if (!TextUtils.isEmpty(script)) {
            sb.append('-').append(script);
        }
        if (!TextUtils.isEmpty(country)) {
            sb.append('_').append(country);
        }
        return sb.toString();
    }

    public static Ze a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        Ze ze = Ze.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!AndroidUtils.isApiAchieved(29) ? !(activeNetwork != null && ((networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || networkInfo.isConnected())) : activeNetwork == null) {
            return Ze.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities != null) {
            for (Integer num : b.f838a.keySet()) {
                if (networkCapabilities.hasTransport(num.intValue())) {
                    return (Ze) b.a(num);
                }
            }
        }
        return ze;
    }
}

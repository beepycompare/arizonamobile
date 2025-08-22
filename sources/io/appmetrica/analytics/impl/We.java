package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.Locale;
/* loaded from: classes4.dex */
public abstract class We {

    /* renamed from: a  reason: collision with root package name */
    public static final Re f709a = new Re();
    public static final Se b = new Se();
    public static final Te c = new Te(2);

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

    public static Ve a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        Ve ve = Ve.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!AndroidUtils.isApiAchieved(29) ? !(activeNetwork != null && ((networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || networkInfo.isConnected())) : activeNetwork == null) {
            return Ve.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities != null) {
            for (Integer num : b.f776a.keySet()) {
                if (networkCapabilities.hasTransport(num.intValue())) {
                    return (Ve) b.a(num);
                }
            }
        }
        return ve;
    }
}

package io.appmetrica.analytics.impl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
/* renamed from: io.appmetrica.analytics.impl.hf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0302hf {

    /* renamed from: a  reason: collision with root package name */
    public static final C0199df f1017a;
    public static final C0224ef b;
    public static final C0250ff c;

    static {
        NetworkType networkType = NetworkType.UNDEFINED;
        f1017a = new C0199df(networkType);
        b = new C0224ef(networkType);
        c = new C0250ff(2);
    }

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        String script = locale.getScript();
        if (!StringUtils.isNullOrEmpty(script)) {
            sb.append('-').append(script);
        }
        if (!StringUtils.isNullOrEmpty(country)) {
            sb.append('_').append(country);
        }
        return sb.toString();
    }

    public static NetworkType a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        NetworkType networkType = NetworkType.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!AndroidUtils.isApiAchieved(29) ? !(activeNetwork != null && ((networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || networkInfo.isConnected())) : activeNetwork == null) {
            return NetworkType.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities != null) {
            for (Integer num : b.f964a.keySet()) {
                if (networkCapabilities.hasTransport(num.intValue())) {
                    return (NetworkType) b.a(num);
                }
            }
        }
        return networkType;
    }
}

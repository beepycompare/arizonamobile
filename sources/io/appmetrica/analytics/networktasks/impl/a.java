package io.appmetrica.analytics.networktasks.impl;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.network.internal.NetworkClientBuilder;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import io.appmetrica.analytics.networkapi.Response;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class a {
    public static Response a(String str, String str2, SSLSocketFactory sSLSocketFactory) {
        Request.Builder withMethod = new Request.Builder(str2).withMethod(Request.Method.GET);
        if (!TextUtils.isEmpty(str)) {
            withMethod.addHeader(HttpHeaders.IF_NONE_MATCH, str);
        }
        NetworkClientBuilder networkClientBuilder = new NetworkClientBuilder();
        NetworkClientSettings.Builder withSslSocketFactory = new NetworkClientSettings.Builder().withInstanceFollowRedirects(true).withSslSocketFactory(sSLSocketFactory);
        int i = b.f1382a;
        return networkClientBuilder.withSettings(withSslSocketFactory.withConnectTimeout(i).withReadTimeout(i).build()).build().newCall(withMethod.build()).execute();
    }
}

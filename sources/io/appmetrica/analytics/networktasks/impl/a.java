package io.appmetrica.analytics.networktasks.impl;

import android.text.TextUtils;
import coil3.network.internal.UtilsKt;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class a {
    public static Response a(String str, String str2, SSLSocketFactory sSLSocketFactory) {
        Request.Builder withMethod = new Request.Builder(str2).withMethod(UtilsKt.HTTP_METHOD_GET);
        if (!TextUtils.isEmpty(str)) {
            withMethod.addHeader(HttpHeaders.IF_NONE_MATCH, str);
        }
        NetworkClient.Builder withSslSocketFactory = new NetworkClient.Builder().withInstanceFollowRedirects(true).withSslSocketFactory(sSLSocketFactory);
        int i = b.f1226a;
        return withSslSocketFactory.withConnectTimeout(i).withReadTimeout(i).build().newCall(withMethod.build()).execute();
    }
}

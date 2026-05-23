package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemPropertiesHelper;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkokhttp.internal.InterceptorSupplier;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
/* loaded from: classes5.dex */
public abstract class e {
    public static OkHttpClient a(NetworkClientSettings networkClientSettings) {
        Integer readTimeout;
        Integer connectTimeout;
        Interceptor interceptor;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.protocols(CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1}));
        if (networkClientSettings.getReadTimeout() != null) {
            builder.readTimeout(readTimeout.intValue(), TimeUnit.MILLISECONDS);
        }
        if (networkClientSettings.getConnectTimeout() != null) {
            builder.connectTimeout(connectTimeout.intValue(), TimeUnit.MILLISECONDS);
        }
        Long callTimeout = networkClientSettings.getCallTimeout();
        if (callTimeout != null) {
            builder.callTimeout(callTimeout.longValue(), TimeUnit.MILLISECONDS);
        }
        Boolean instanceFollowRedirects = networkClientSettings.getInstanceFollowRedirects();
        if (instanceFollowRedirects != null) {
            builder.followRedirects(instanceFollowRedirects.booleanValue());
        }
        try {
            String readSystemProperty = SystemPropertiesHelper.readSystemProperty("debug.yndx.iaa.okhttp.mock");
            InterceptorSupplier interceptorSupplier = StringsKt.isBlank(readSystemProperty) ? null : (InterceptorSupplier) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(readSystemProperty, InterceptorSupplier.class);
            if (interceptorSupplier != null && (interceptor = interceptorSupplier.get()) != null) {
                builder.addInterceptor(interceptor);
            }
        } catch (Throwable unused) {
        }
        SSLSocketFactory sslSocketFactory = networkClientSettings.getSslSocketFactory();
        if (sslSocketFactory != null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                ArrayList arrayList = new ArrayList();
                for (TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof X509TrustManager) {
                        arrayList.add(trustManager);
                    }
                }
                X509TrustManager x509TrustManager = (X509TrustManager) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                if (x509TrustManager != null) {
                    builder.sslSocketFactory(sslSocketFactory, x509TrustManager);
                }
            } catch (Throwable unused2) {
            }
        }
        Boolean useCaches = networkClientSettings.getUseCaches();
        if (useCaches != null && !useCaches.booleanValue()) {
            builder.cache(null);
        }
        return builder.build();
    }
}

package io.appmetrica.analytics.networkokhttp.internal;

import io.appmetrica.analytics.networkapi.NetworkClient;
import io.appmetrica.analytics.networkokhttp.impl.f;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/networkokhttp/internal/OkHttpNetworkClientBuilder;", "Lio/appmetrica/analytics/networkapi/NetworkClient$Builder;", "()V", "build", "Lio/appmetrica/analytics/networkapi/NetworkClient;", "toString", "", "network-okhttp_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OkHttpNetworkClientBuilder extends NetworkClient.Builder {
    @Override // io.appmetrica.analytics.networkapi.NetworkClient.Builder
    public NetworkClient build() {
        return new f(getSettings(), null, 2, null);
    }

    public String toString() {
        return "OkHttp Network Client Builder";
    }
}

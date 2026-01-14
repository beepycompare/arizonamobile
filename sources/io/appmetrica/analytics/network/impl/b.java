package io.appmetrica.analytics.network.impl;

import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.NetworkClient;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
/* loaded from: classes5.dex */
public final class b extends NetworkClient {
    public b(NetworkClientSettings networkClientSettings) {
        super(networkClientSettings);
    }

    @Override // io.appmetrica.analytics.networkapi.NetworkClient
    public final Call newCall(Request request) {
        return new a();
    }
}

package io.appmetrica.analytics.network.impl;

import io.appmetrica.analytics.networkapi.NetworkClient;
/* loaded from: classes5.dex */
public final class c extends NetworkClient.Builder {
    public final b a() {
        return new b(getSettings());
    }

    @Override // io.appmetrica.analytics.networkapi.NetworkClient.Builder
    public final NetworkClient build() {
        return new b(getSettings());
    }

    public final String toString() {
        return "Dummy Network Client Builder";
    }
}

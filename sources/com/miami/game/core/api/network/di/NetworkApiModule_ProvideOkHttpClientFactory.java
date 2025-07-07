package com.miami.game.core.api.network.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
/* loaded from: classes4.dex */
public final class NetworkApiModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OkHttpClient get() {
        return provideOkHttpClient();
    }

    public static NetworkApiModule_ProvideOkHttpClientFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OkHttpClient provideOkHttpClient() {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(NetworkApiModule.INSTANCE.provideOkHttpClient());
    }

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final NetworkApiModule_ProvideOkHttpClientFactory INSTANCE = new NetworkApiModule_ProvideOkHttpClientFactory();

        private InstanceHolder() {
        }
    }
}

package com.miami.game.core.api.network.di;

import com.google.gson.Gson;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;
/* loaded from: classes4.dex */
public final class NetworkApiModule_ProvideAppNetworkDataSourceFactory implements Factory<NetworkDataSource> {
    private final Provider<ConnectionResolver> connectionResolverProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkApiModule_ProvideAppNetworkDataSourceFactory(Provider<ConnectionResolver> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        this.connectionResolverProvider = provider;
        this.okHttpClientProvider = provider2;
        this.gsonProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NetworkDataSource get() {
        return provideAppNetworkDataSource(this.connectionResolverProvider.get(), this.okHttpClientProvider.get(), this.gsonProvider.get());
    }

    public static NetworkApiModule_ProvideAppNetworkDataSourceFactory create(Provider<ConnectionResolver> provider, Provider<OkHttpClient> provider2, Provider<Gson> provider3) {
        return new NetworkApiModule_ProvideAppNetworkDataSourceFactory(provider, provider2, provider3);
    }

    public static NetworkDataSource provideAppNetworkDataSource(ConnectionResolver connectionResolver, OkHttpClient okHttpClient, Gson gson) {
        return (NetworkDataSource) Preconditions.checkNotNullFromProvides(NetworkApiModule.INSTANCE.provideAppNetworkDataSource(connectionResolver, okHttpClient, gson));
    }
}

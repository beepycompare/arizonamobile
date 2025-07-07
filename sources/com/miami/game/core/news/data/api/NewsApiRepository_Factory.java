package com.miami.game.core.news.data.api;

import com.miami.game.core.api.network.NetworkDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class NewsApiRepository_Factory implements Factory<NewsApiRepository> {
    private final Provider<NetworkDataSource> networkDataSourceProvider;

    public NewsApiRepository_Factory(Provider<NetworkDataSource> provider) {
        this.networkDataSourceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewsApiRepository get() {
        return newInstance(this.networkDataSourceProvider.get());
    }

    public static NewsApiRepository_Factory create(Provider<NetworkDataSource> provider) {
        return new NewsApiRepository_Factory(provider);
    }

    public static NewsApiRepository newInstance(NetworkDataSource networkDataSource) {
        return new NewsApiRepository(networkDataSource);
    }
}

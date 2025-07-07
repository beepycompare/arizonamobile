package com.miami.game.core.news.data;

import com.miami.game.core.news.data.api.NewsApiRepository;
import com.miami.game.core.news.data.store.NewsPrefRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class NewsRepository_Factory implements Factory<NewsRepository> {
    private final Provider<NewsApiRepository> apiRepositoryProvider;
    private final Provider<NewsPrefRepository> prefRepositoryProvider;

    public NewsRepository_Factory(Provider<NewsApiRepository> provider, Provider<NewsPrefRepository> provider2) {
        this.apiRepositoryProvider = provider;
        this.prefRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewsRepository get() {
        return newInstance(this.apiRepositoryProvider.get(), this.prefRepositoryProvider.get());
    }

    public static NewsRepository_Factory create(Provider<NewsApiRepository> provider, Provider<NewsPrefRepository> provider2) {
        return new NewsRepository_Factory(provider, provider2);
    }

    public static NewsRepository newInstance(NewsApiRepository newsApiRepository, NewsPrefRepository newsPrefRepository) {
        return new NewsRepository(newsApiRepository, newsPrefRepository);
    }
}

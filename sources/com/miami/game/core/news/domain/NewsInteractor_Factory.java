package com.miami.game.core.news.domain;

import com.miami.game.core.news.data.NewsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class NewsInteractor_Factory implements Factory<NewsInteractor> {
    private final Provider<NewsRepository> repositoryProvider;

    public NewsInteractor_Factory(Provider<NewsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewsInteractor get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static NewsInteractor_Factory create(Provider<NewsRepository> provider) {
        return new NewsInteractor_Factory(provider);
    }

    public static NewsInteractor newInstance(NewsRepository newsRepository) {
        return new NewsInteractor(newsRepository);
    }
}

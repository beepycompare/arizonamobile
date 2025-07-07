package com.miami.game.core.news.data.store;

import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class NewsPrefRepository_Factory implements Factory<NewsPrefRepository> {
    private final Provider<LocalRepository> localRepositoryProvider;

    public NewsPrefRepository_Factory(Provider<LocalRepository> provider) {
        this.localRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewsPrefRepository get() {
        return newInstance(this.localRepositoryProvider.get());
    }

    public static NewsPrefRepository_Factory create(Provider<LocalRepository> provider) {
        return new NewsPrefRepository_Factory(provider);
    }

    public static NewsPrefRepository newInstance(LocalRepository localRepository) {
        return new NewsPrefRepository(localRepository);
    }
}

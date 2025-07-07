package com.miami.game.core.gamefiles.info.data.store;

import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class GameInfoPrefRepository_Factory implements Factory<GameInfoPrefRepository> {
    private final Provider<LocalRepository> localRepositoryProvider;

    public GameInfoPrefRepository_Factory(Provider<LocalRepository> provider) {
        this.localRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GameInfoPrefRepository get() {
        return newInstance(this.localRepositoryProvider.get());
    }

    public static GameInfoPrefRepository_Factory create(Provider<LocalRepository> provider) {
        return new GameInfoPrefRepository_Factory(provider);
    }

    public static GameInfoPrefRepository newInstance(LocalRepository localRepository) {
        return new GameInfoPrefRepository(localRepository);
    }
}

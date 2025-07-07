package com.miami.game.core.gamefiles.info.data;

import com.miami.game.core.gamefiles.info.data.api.GamefilesInfoApiRepository;
import com.miami.game.core.gamefiles.info.data.store.GameInfoPrefRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class GamefilesInfoRepository_Factory implements Factory<GamefilesInfoRepository> {
    private final Provider<GameInfoPrefRepository> gameInfoPrefRepositoryProvider;
    private final Provider<GamefilesInfoApiRepository> gamefilesInfoApiRepositoryProvider;

    public GamefilesInfoRepository_Factory(Provider<GamefilesInfoApiRepository> provider, Provider<GameInfoPrefRepository> provider2) {
        this.gamefilesInfoApiRepositoryProvider = provider;
        this.gameInfoPrefRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GamefilesInfoRepository get() {
        return newInstance(this.gamefilesInfoApiRepositoryProvider.get(), this.gameInfoPrefRepositoryProvider.get());
    }

    public static GamefilesInfoRepository_Factory create(Provider<GamefilesInfoApiRepository> provider, Provider<GameInfoPrefRepository> provider2) {
        return new GamefilesInfoRepository_Factory(provider, provider2);
    }

    public static GamefilesInfoRepository newInstance(GamefilesInfoApiRepository gamefilesInfoApiRepository, GameInfoPrefRepository gameInfoPrefRepository) {
        return new GamefilesInfoRepository(gamefilesInfoApiRepository, gameInfoPrefRepository);
    }
}

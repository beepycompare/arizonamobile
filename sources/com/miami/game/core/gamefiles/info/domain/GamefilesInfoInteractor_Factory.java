package com.miami.game.core.gamefiles.info.domain;

import com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class GamefilesInfoInteractor_Factory implements Factory<GamefilesInfoInteractor> {
    private final Provider<GamefilesInfoRepository> repositoryProvider;

    public GamefilesInfoInteractor_Factory(Provider<GamefilesInfoRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GamefilesInfoInteractor get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GamefilesInfoInteractor_Factory create(Provider<GamefilesInfoRepository> provider) {
        return new GamefilesInfoInteractor_Factory(provider);
    }

    public static GamefilesInfoInteractor newInstance(GamefilesInfoRepository gamefilesInfoRepository) {
        return new GamefilesInfoInteractor(gamefilesInfoRepository);
    }
}

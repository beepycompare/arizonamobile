package com.miami.game.core.gamefiles.info.data.api;

import com.miami.game.core.api.network.NetworkDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class GamefilesInfoApiRepository_Factory implements Factory<GamefilesInfoApiRepository> {
    private final Provider<NetworkDataSource> networkDataSourceProvider;

    public GamefilesInfoApiRepository_Factory(Provider<NetworkDataSource> provider) {
        this.networkDataSourceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GamefilesInfoApiRepository get() {
        return newInstance(this.networkDataSourceProvider.get());
    }

    public static GamefilesInfoApiRepository_Factory create(Provider<NetworkDataSource> provider) {
        return new GamefilesInfoApiRepository_Factory(provider);
    }

    public static GamefilesInfoApiRepository newInstance(NetworkDataSource networkDataSource) {
        return new GamefilesInfoApiRepository(networkDataSource);
    }
}

package com.miami.game.core.server;

import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.server.data.FavoriteServerDatabase;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class ServersInteractor_Factory implements Factory<ServersInteractor> {
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<NetworkDataSource> dataSourceProvider;
    private final Provider<FavoriteServerDatabase> favoriteServerDatabaseProvider;
    private final Provider<LocalRepository> localRepositoryProvider;

    public ServersInteractor_Factory(Provider<BuildConfigRepository> buildConfigProvider, Provider<NetworkDataSource> dataSourceProvider, Provider<LocalRepository> localRepositoryProvider, Provider<FavoriteServerDatabase> favoriteServerDatabaseProvider) {
        this.buildConfigProvider = buildConfigProvider;
        this.dataSourceProvider = dataSourceProvider;
        this.localRepositoryProvider = localRepositoryProvider;
        this.favoriteServerDatabaseProvider = favoriteServerDatabaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ServersInteractor get() {
        return newInstance(this.buildConfigProvider.get(), this.dataSourceProvider.get(), this.localRepositoryProvider.get(), this.favoriteServerDatabaseProvider.get());
    }

    public static ServersInteractor_Factory create(Provider<BuildConfigRepository> buildConfigProvider, Provider<NetworkDataSource> dataSourceProvider, Provider<LocalRepository> localRepositoryProvider, Provider<FavoriteServerDatabase> favoriteServerDatabaseProvider) {
        return new ServersInteractor_Factory(buildConfigProvider, dataSourceProvider, localRepositoryProvider, favoriteServerDatabaseProvider);
    }

    public static ServersInteractor newInstance(BuildConfigRepository buildConfig, NetworkDataSource dataSource, LocalRepository localRepository, FavoriteServerDatabase favoriteServerDatabase) {
        return new ServersInteractor(buildConfig, dataSource, localRepository, favoriteServerDatabase);
    }
}

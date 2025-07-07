package com.miami.game.core.downloader.sync.data;

import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DownloaderSyncRepository_Factory implements Factory<DownloaderSyncRepository> {
    private final Provider<DownloaderSyncApiRepository> apiRepositoryProvider;
    private final Provider<DownloaderSyncDbRepository> dbRepositoryProvider;

    public DownloaderSyncRepository_Factory(Provider<DownloaderSyncApiRepository> apiRepositoryProvider, Provider<DownloaderSyncDbRepository> dbRepositoryProvider) {
        this.apiRepositoryProvider = apiRepositoryProvider;
        this.dbRepositoryProvider = dbRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloaderSyncRepository get() {
        return newInstance(this.apiRepositoryProvider.get(), this.dbRepositoryProvider.get());
    }

    public static DownloaderSyncRepository_Factory create(Provider<DownloaderSyncApiRepository> apiRepositoryProvider, Provider<DownloaderSyncDbRepository> dbRepositoryProvider) {
        return new DownloaderSyncRepository_Factory(apiRepositoryProvider, dbRepositoryProvider);
    }

    public static DownloaderSyncRepository newInstance(DownloaderSyncApiRepository apiRepository, DownloaderSyncDbRepository dbRepository) {
        return new DownloaderSyncRepository(apiRepository, dbRepository);
    }
}

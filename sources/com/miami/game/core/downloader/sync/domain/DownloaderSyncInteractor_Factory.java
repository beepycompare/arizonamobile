package com.miami.game.core.downloader.sync.domain;

import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DownloaderSyncInteractor_Factory implements Factory<DownloaderSyncInteractor> {
    private final Provider<DownloaderSyncRepository> repositoryProvider;

    public DownloaderSyncInteractor_Factory(Provider<DownloaderSyncRepository> repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloaderSyncInteractor get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static DownloaderSyncInteractor_Factory create(Provider<DownloaderSyncRepository> repositoryProvider) {
        return new DownloaderSyncInteractor_Factory(repositoryProvider);
    }

    public static DownloaderSyncInteractor newInstance(DownloaderSyncRepository repository) {
        return new DownloaderSyncInteractor(repository);
    }
}

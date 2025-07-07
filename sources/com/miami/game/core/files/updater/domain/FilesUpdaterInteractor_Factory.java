package com.miami.game.core.files.updater.domain;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import com.miami.game.core.gamefiles.info.domain.GamefilesInfoInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor_Factory implements Factory<FilesUpdaterInteractor> {
    private final Provider<ConnectionResolver> connectionResolverProvider;
    private final Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider;
    private final Provider<GamefilesInfoInteractor> gamefilesInfoInteractorProvider;

    public FilesUpdaterInteractor_Factory(Provider<ConnectionResolver> connectionResolverProvider, Provider<GamefilesInfoInteractor> gamefilesInfoInteractorProvider, Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider) {
        this.connectionResolverProvider = connectionResolverProvider;
        this.gamefilesInfoInteractorProvider = gamefilesInfoInteractorProvider;
        this.downloaderSyncInteractorProvider = downloaderSyncInteractorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesUpdaterInteractor get() {
        return newInstance(this.connectionResolverProvider.get(), this.gamefilesInfoInteractorProvider.get(), this.downloaderSyncInteractorProvider.get());
    }

    public static FilesUpdaterInteractor_Factory create(Provider<ConnectionResolver> connectionResolverProvider, Provider<GamefilesInfoInteractor> gamefilesInfoInteractorProvider, Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider) {
        return new FilesUpdaterInteractor_Factory(connectionResolverProvider, gamefilesInfoInteractorProvider, downloaderSyncInteractorProvider);
    }

    public static FilesUpdaterInteractor newInstance(ConnectionResolver connectionResolver, GamefilesInfoInteractor gamefilesInfoInteractor, DownloaderSyncInteractor downloaderSyncInteractor) {
        return new FilesUpdaterInteractor(connectionResolver, gamefilesInfoInteractor, downloaderSyncInteractor);
    }
}

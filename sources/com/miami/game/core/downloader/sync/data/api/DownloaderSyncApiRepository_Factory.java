package com.miami.game.core.downloader.sync.data.api;

import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.downloader.Downloader;
import com.miami.game.core.files.Files;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DownloaderSyncApiRepository_Factory implements Factory<DownloaderSyncApiRepository> {
    private final Provider<ConnectionResolver> connectionResolverProvider;
    private final Provider<Downloader> downloaderProvider;
    private final Provider<Files> filesProvider;

    public DownloaderSyncApiRepository_Factory(Provider<Downloader> downloaderProvider, Provider<ConnectionResolver> connectionResolverProvider, Provider<Files> filesProvider) {
        this.downloaderProvider = downloaderProvider;
        this.connectionResolverProvider = connectionResolverProvider;
        this.filesProvider = filesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloaderSyncApiRepository get() {
        return newInstance(this.downloaderProvider.get(), this.connectionResolverProvider.get(), this.filesProvider.get());
    }

    public static DownloaderSyncApiRepository_Factory create(Provider<Downloader> downloaderProvider, Provider<ConnectionResolver> connectionResolverProvider, Provider<Files> filesProvider) {
        return new DownloaderSyncApiRepository_Factory(downloaderProvider, connectionResolverProvider, filesProvider);
    }

    public static DownloaderSyncApiRepository newInstance(Downloader downloader, ConnectionResolver connectionResolver, Files files) {
        return new DownloaderSyncApiRepository(downloader, connectionResolver, files);
    }
}

package com.miami.game.core.files.updater.domain;

import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor_Factory implements Factory<FilesUpdaterInteractor> {
    private final Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider;

    public FilesUpdaterInteractor_Factory(Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider) {
        this.downloaderSyncInteractorProvider = downloaderSyncInteractorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesUpdaterInteractor get() {
        return newInstance(this.downloaderSyncInteractorProvider.get());
    }

    public static FilesUpdaterInteractor_Factory create(Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider) {
        return new FilesUpdaterInteractor_Factory(downloaderSyncInteractorProvider);
    }

    public static FilesUpdaterInteractor newInstance(DownloaderSyncInteractor downloaderSyncInteractor) {
        return new FilesUpdaterInteractor(downloaderSyncInteractor);
    }
}

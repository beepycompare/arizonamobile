package com.miami.game.core.foreground.service;

import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import dagger.MembersInjector;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DownloadService_MembersInjector implements MembersInjector<DownloadService> {
    private final Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider;

    public DownloadService_MembersInjector(Provider<FilesUpdaterInteractor> provider) {
        this.filesUpdaterInteractorProvider = provider;
    }

    public static MembersInjector<DownloadService> create(Provider<FilesUpdaterInteractor> provider) {
        return new DownloadService_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DownloadService downloadService) {
        injectFilesUpdaterInteractor(downloadService, this.filesUpdaterInteractorProvider.get());
    }

    public static void injectFilesUpdaterInteractor(DownloadService downloadService, FilesUpdaterInteractor filesUpdaterInteractor) {
        downloadService.filesUpdaterInteractor = filesUpdaterInteractor;
    }
}

package com.miami.game.feature.download.screen.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.download.screen.ui.DownloadScreenComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0110DownloadScreenComponent_Factory {
    private final Provider<BuildConfigRepository> buildConfigRepositoryProvider;
    private final Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider;
    private final Provider<LocalRepository> localRepositoryProvider;

    public C0110DownloadScreenComponent_Factory(Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider, Provider<BuildConfigRepository> buildConfigRepositoryProvider, Provider<LocalRepository> localRepositoryProvider) {
        this.filesUpdaterInteractorProvider = filesUpdaterInteractorProvider;
        this.buildConfigRepositoryProvider = buildConfigRepositoryProvider;
        this.localRepositoryProvider = localRepositoryProvider;
    }

    public DownloadScreenComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.filesUpdaterInteractorProvider.get(), this.buildConfigRepositoryProvider.get(), this.localRepositoryProvider.get());
    }

    public static C0110DownloadScreenComponent_Factory create(Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider, Provider<BuildConfigRepository> buildConfigRepositoryProvider, Provider<LocalRepository> localRepositoryProvider) {
        return new C0110DownloadScreenComponent_Factory(filesUpdaterInteractorProvider, buildConfigRepositoryProvider, localRepositoryProvider);
    }

    public static DownloadScreenComponent newInstance(ComponentContext componentContext, FilesUpdaterInteractor filesUpdaterInteractor, BuildConfigRepository buildConfigRepository, LocalRepository localRepository) {
        return new DownloadScreenComponent(componentContext, filesUpdaterInteractor, buildConfigRepository, localRepository);
    }
}

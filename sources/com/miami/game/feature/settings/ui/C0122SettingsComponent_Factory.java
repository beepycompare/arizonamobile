package com.miami.game.feature.settings.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import com.miami.game.core.settings.SettingsInteractor;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.settings.ui.SettingsComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0122SettingsComponent_Factory {
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider;
    private final Provider<SettingsInteractor> settingsInteractorProvider;

    public C0122SettingsComponent_Factory(Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<SettingsInteractor> settingsInteractorProvider) {
        this.filesUpdaterInteractorProvider = filesUpdaterInteractorProvider;
        this.buildConfigProvider = buildConfigProvider;
        this.settingsInteractorProvider = settingsInteractorProvider;
    }

    public SettingsComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.filesUpdaterInteractorProvider.get(), this.buildConfigProvider.get(), this.settingsInteractorProvider.get());
    }

    public static C0122SettingsComponent_Factory create(Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<SettingsInteractor> settingsInteractorProvider) {
        return new C0122SettingsComponent_Factory(filesUpdaterInteractorProvider, buildConfigProvider, settingsInteractorProvider);
    }

    public static SettingsComponent newInstance(ComponentContext componentContext, FilesUpdaterInteractor filesUpdaterInteractor, BuildConfigRepository buildConfig, SettingsInteractor settingsInteractor) {
        return new SettingsComponent(componentContext, filesUpdaterInteractor, buildConfig, settingsInteractor);
    }
}

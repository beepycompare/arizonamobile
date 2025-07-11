package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.settings.ui.SettingsComponent;
import dagger.internal.Provider;
/* renamed from: com.miami.game.core.app.root.nav.main.MainComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0107MainComponent_Factory {
    private final Provider<CommonDialogComponent.Factory> commonDialogFactoryProvider;
    private final Provider<DownloadScreenComponent.Factory> downloadScreenFactoryProvider;
    private final Provider<ErrorDialogComponent.Factory> errorDialogFactoryProvider;
    private final Provider<HomeComponent.Factory> homeFactoryProvider;
    private final Provider<NotificationsComponent.Factory> notificationsFactoryProvider;
    private final Provider<SelectServerComponent.Factory> selectServerFactoryProvider;
    private final Provider<SettingsComponent.Factory> settingsFactoryProvider;

    public C0107MainComponent_Factory(Provider<HomeComponent.Factory> provider, Provider<SelectServerComponent.Factory> provider2, Provider<SettingsComponent.Factory> provider3, Provider<CommonDialogComponent.Factory> provider4, Provider<ErrorDialogComponent.Factory> provider5, Provider<DownloadScreenComponent.Factory> provider6, Provider<NotificationsComponent.Factory> provider7) {
        this.homeFactoryProvider = provider;
        this.selectServerFactoryProvider = provider2;
        this.settingsFactoryProvider = provider3;
        this.commonDialogFactoryProvider = provider4;
        this.errorDialogFactoryProvider = provider5;
        this.downloadScreenFactoryProvider = provider6;
        this.notificationsFactoryProvider = provider7;
    }

    public MainComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.homeFactoryProvider.get(), this.selectServerFactoryProvider.get(), this.settingsFactoryProvider.get(), this.commonDialogFactoryProvider.get(), this.errorDialogFactoryProvider.get(), this.downloadScreenFactoryProvider.get(), this.notificationsFactoryProvider.get());
    }

    public static C0107MainComponent_Factory create(Provider<HomeComponent.Factory> provider, Provider<SelectServerComponent.Factory> provider2, Provider<SettingsComponent.Factory> provider3, Provider<CommonDialogComponent.Factory> provider4, Provider<ErrorDialogComponent.Factory> provider5, Provider<DownloadScreenComponent.Factory> provider6, Provider<NotificationsComponent.Factory> provider7) {
        return new C0107MainComponent_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static MainComponent newInstance(ComponentContext componentContext, HomeComponent.Factory factory, SelectServerComponent.Factory factory2, SettingsComponent.Factory factory3, CommonDialogComponent.Factory factory4, ErrorDialogComponent.Factory factory5, DownloadScreenComponent.Factory factory6, NotificationsComponent.Factory factory7) {
        return new MainComponent(componentContext, factory, factory2, factory3, factory4, factory5, factory6, factory7);
    }
}

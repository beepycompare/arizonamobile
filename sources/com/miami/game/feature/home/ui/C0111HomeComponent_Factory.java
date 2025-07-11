package com.miami.game.feature.home.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.news.domain.NewsInteractor;
import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.core.server.ServersInteractor;
import com.miami.game.core.settings.SettingsInteractor;
import com.miami.game.feature.notifications.NotificationStateHolder;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.home.ui.HomeComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0111HomeComponent_Factory {
    private final Provider<NetworkDataSource> apiProvider;
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<NewsInteractor> newsInteractorProvider;
    private final Provider<NotificationStateHolder> notificationStateHolderProvider;
    private final Provider<privacyInteractor> privacyInteractorProvider;
    private final Provider<ServersInteractor> serversInteractorProvider;
    private final Provider<SettingsInteractor> settingsInteractorProvider;

    public C0111HomeComponent_Factory(Provider<privacyInteractor> privacyInteractorProvider, Provider<NewsInteractor> newsInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<NetworkDataSource> apiProvider, Provider<ServersInteractor> serversInteractorProvider, Provider<SettingsInteractor> settingsInteractorProvider, Provider<NotificationStateHolder> notificationStateHolderProvider) {
        this.privacyInteractorProvider = privacyInteractorProvider;
        this.newsInteractorProvider = newsInteractorProvider;
        this.buildConfigProvider = buildConfigProvider;
        this.apiProvider = apiProvider;
        this.serversInteractorProvider = serversInteractorProvider;
        this.settingsInteractorProvider = settingsInteractorProvider;
        this.notificationStateHolderProvider = notificationStateHolderProvider;
    }

    public HomeComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.privacyInteractorProvider.get(), this.newsInteractorProvider.get(), this.buildConfigProvider.get(), this.apiProvider.get(), this.serversInteractorProvider.get(), this.settingsInteractorProvider.get(), this.notificationStateHolderProvider.get());
    }

    public static C0111HomeComponent_Factory create(Provider<privacyInteractor> privacyInteractorProvider, Provider<NewsInteractor> newsInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<NetworkDataSource> apiProvider, Provider<ServersInteractor> serversInteractorProvider, Provider<SettingsInteractor> settingsInteractorProvider, Provider<NotificationStateHolder> notificationStateHolderProvider) {
        return new C0111HomeComponent_Factory(privacyInteractorProvider, newsInteractorProvider, buildConfigProvider, apiProvider, serversInteractorProvider, settingsInteractorProvider, notificationStateHolderProvider);
    }

    public static HomeComponent newInstance(ComponentContext componentContext, privacyInteractor privacyInteractor, NewsInteractor newsInteractor, BuildConfigRepository buildConfig, NetworkDataSource api, ServersInteractor serversInteractor, SettingsInteractor settingsInteractor, NotificationStateHolder notificationStateHolder) {
        return new HomeComponent(componentContext, privacyInteractor, newsInteractor, buildConfig, api, serversInteractor, settingsInteractor, notificationStateHolder);
    }
}

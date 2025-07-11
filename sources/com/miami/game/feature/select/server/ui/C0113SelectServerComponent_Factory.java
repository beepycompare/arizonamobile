package com.miami.game.feature.select.server.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.server.ServersInteractor;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.select.server.ui.SelectServerComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0113SelectServerComponent_Factory {
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<ServersInteractor> serversInteractorProvider;

    public C0113SelectServerComponent_Factory(Provider<ServersInteractor> serversInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider) {
        this.serversInteractorProvider = serversInteractorProvider;
        this.buildConfigProvider = buildConfigProvider;
    }

    public SelectServerComponent get(ComponentContext componentContext) {
        return newInstance(componentContext, this.serversInteractorProvider.get(), this.buildConfigProvider.get());
    }

    public static C0113SelectServerComponent_Factory create(Provider<ServersInteractor> serversInteractorProvider, Provider<BuildConfigRepository> buildConfigProvider) {
        return new C0113SelectServerComponent_Factory(serversInteractorProvider, buildConfigProvider);
    }

    public static SelectServerComponent newInstance(ComponentContext componentContext, ServersInteractor serversInteractor, BuildConfigRepository buildConfig) {
        return new SelectServerComponent(componentContext, serversInteractor, buildConfig);
    }
}

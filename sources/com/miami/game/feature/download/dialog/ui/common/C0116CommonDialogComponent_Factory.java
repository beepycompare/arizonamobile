package com.miami.game.feature.download.dialog.ui.common;

import android.content.res.Resources;
import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.privacy.privacyInteractor;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0116CommonDialogComponent_Factory {
    private final Provider<BuildConfigRepository> buildConfigProvider;
    private final Provider<privacyInteractor> privacyInteractorProvider;
    private final Provider<Resources> resourcesProvider;

    public C0116CommonDialogComponent_Factory(Provider<Resources> resourcesProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<privacyInteractor> privacyInteractorProvider) {
        this.resourcesProvider = resourcesProvider;
        this.buildConfigProvider = buildConfigProvider;
        this.privacyInteractorProvider = privacyInteractorProvider;
    }

    public CommonDialogComponent get(ComponentContext componentContext, String description) {
        return newInstance(componentContext, description, this.resourcesProvider.get(), this.buildConfigProvider.get(), this.privacyInteractorProvider.get());
    }

    public static C0116CommonDialogComponent_Factory create(Provider<Resources> resourcesProvider, Provider<BuildConfigRepository> buildConfigProvider, Provider<privacyInteractor> privacyInteractorProvider) {
        return new C0116CommonDialogComponent_Factory(resourcesProvider, buildConfigProvider, privacyInteractorProvider);
    }

    public static CommonDialogComponent newInstance(ComponentContext componentContext, String description, Resources resources, BuildConfigRepository buildConfig, privacyInteractor privacyInteractor) {
        return new CommonDialogComponent(componentContext, description, resources, buildConfig, privacyInteractor);
    }
}

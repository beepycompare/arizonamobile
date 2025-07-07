package com.miami.game.feature.download.dialog.ui.error;

import android.content.res.Resources;
import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.dialog.ui.error.map.ErrorDialogUiAssembler;
import dagger.internal.Provider;
/* renamed from: com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent_Factory  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0117ErrorDialogComponent_Factory {
    private final Provider<Resources> resourcesProvider;
    private final Provider<ErrorDialogUiAssembler> uiAssemblerProvider;

    public C0117ErrorDialogComponent_Factory(Provider<ErrorDialogUiAssembler> uiAssemblerProvider, Provider<Resources> resourcesProvider) {
        this.uiAssemblerProvider = uiAssemblerProvider;
        this.resourcesProvider = resourcesProvider;
    }

    public ErrorDialogComponent get(String errorMessage, ComponentContext componentContext) {
        return newInstance(errorMessage, componentContext, this.uiAssemblerProvider.get(), this.resourcesProvider.get());
    }

    public static C0117ErrorDialogComponent_Factory create(Provider<ErrorDialogUiAssembler> uiAssemblerProvider, Provider<Resources> resourcesProvider) {
        return new C0117ErrorDialogComponent_Factory(uiAssemblerProvider, resourcesProvider);
    }

    public static ErrorDialogComponent newInstance(String errorMessage, ComponentContext componentContext, ErrorDialogUiAssembler uiAssembler, Resources resources) {
        return new ErrorDialogComponent(errorMessage, componentContext, uiAssembler, resources);
    }
}

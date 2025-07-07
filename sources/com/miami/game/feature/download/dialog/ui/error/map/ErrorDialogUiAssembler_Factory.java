package com.miami.game.feature.download.dialog.ui.error.map;

import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class ErrorDialogUiAssembler_Factory implements Factory<ErrorDialogUiAssembler> {
    private final Provider<Resources> resourcesProvider;

    public ErrorDialogUiAssembler_Factory(Provider<Resources> resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ErrorDialogUiAssembler get() {
        return newInstance(this.resourcesProvider.get());
    }

    public static ErrorDialogUiAssembler_Factory create(Provider<Resources> resourcesProvider) {
        return new ErrorDialogUiAssembler_Factory(resourcesProvider);
    }

    public static ErrorDialogUiAssembler newInstance(Resources resources) {
        return new ErrorDialogUiAssembler(resources);
    }
}

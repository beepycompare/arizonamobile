package com.miami.game.feature.download.dialog.ui.error;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class ErrorDialogComponent_Factory_Impl implements ErrorDialogComponent.Factory {
    private final C0109ErrorDialogComponent_Factory delegateFactory;

    ErrorDialogComponent_Factory_Impl(C0109ErrorDialogComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent.Factory
    public ErrorDialogComponent invoke(ComponentContext componentContext, String errorMessage) {
        return this.delegateFactory.get(errorMessage, componentContext);
    }

    public static Provider<ErrorDialogComponent.Factory> create(C0109ErrorDialogComponent_Factory delegateFactory) {
        return InstanceFactory.create(new ErrorDialogComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<ErrorDialogComponent.Factory> createFactoryProvider(C0109ErrorDialogComponent_Factory delegateFactory) {
        return InstanceFactory.create(new ErrorDialogComponent_Factory_Impl(delegateFactory));
    }
}

package com.miami.game.feature.download.dialog.ui.common;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class CommonDialogComponent_Factory_Impl implements CommonDialogComponent.Factory {
    private final C0108CommonDialogComponent_Factory delegateFactory;

    CommonDialogComponent_Factory_Impl(C0108CommonDialogComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent.Factory
    public CommonDialogComponent invoke(ComponentContext componentContext, String description) {
        return this.delegateFactory.get(componentContext, description);
    }

    public static Provider<CommonDialogComponent.Factory> create(C0108CommonDialogComponent_Factory delegateFactory) {
        return InstanceFactory.create(new CommonDialogComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<CommonDialogComponent.Factory> createFactoryProvider(C0108CommonDialogComponent_Factory delegateFactory) {
        return InstanceFactory.create(new CommonDialogComponent_Factory_Impl(delegateFactory));
    }
}

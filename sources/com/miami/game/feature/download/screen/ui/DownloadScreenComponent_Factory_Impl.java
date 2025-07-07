package com.miami.game.feature.download.screen.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class DownloadScreenComponent_Factory_Impl implements DownloadScreenComponent.Factory {
    private final C0118DownloadScreenComponent_Factory delegateFactory;

    DownloadScreenComponent_Factory_Impl(C0118DownloadScreenComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.download.screen.ui.DownloadScreenComponent.Factory
    public DownloadScreenComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<DownloadScreenComponent.Factory> create(C0118DownloadScreenComponent_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadScreenComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<DownloadScreenComponent.Factory> createFactoryProvider(C0118DownloadScreenComponent_Factory delegateFactory) {
        return InstanceFactory.create(new DownloadScreenComponent_Factory_Impl(delegateFactory));
    }
}

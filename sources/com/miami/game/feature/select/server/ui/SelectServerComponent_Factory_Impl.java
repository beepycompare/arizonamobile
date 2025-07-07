package com.miami.game.feature.select.server.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class SelectServerComponent_Factory_Impl implements SelectServerComponent.Factory {
    private final C0121SelectServerComponent_Factory delegateFactory;

    SelectServerComponent_Factory_Impl(C0121SelectServerComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.select.server.ui.SelectServerComponent.Factory
    public SelectServerComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<SelectServerComponent.Factory> create(C0121SelectServerComponent_Factory delegateFactory) {
        return InstanceFactory.create(new SelectServerComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<SelectServerComponent.Factory> createFactoryProvider(C0121SelectServerComponent_Factory delegateFactory) {
        return InstanceFactory.create(new SelectServerComponent_Factory_Impl(delegateFactory));
    }
}

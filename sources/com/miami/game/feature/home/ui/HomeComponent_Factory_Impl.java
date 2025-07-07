package com.miami.game.feature.home.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.home.ui.HomeComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class HomeComponent_Factory_Impl implements HomeComponent.Factory {
    private final C0119HomeComponent_Factory delegateFactory;

    HomeComponent_Factory_Impl(C0119HomeComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.home.ui.HomeComponent.Factory
    public HomeComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<HomeComponent.Factory> create(C0119HomeComponent_Factory delegateFactory) {
        return InstanceFactory.create(new HomeComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<HomeComponent.Factory> createFactoryProvider(C0119HomeComponent_Factory delegateFactory) {
        return InstanceFactory.create(new HomeComponent_Factory_Impl(delegateFactory));
    }
}

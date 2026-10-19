package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.app.root.nav.main.MainComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes5.dex */
public final class MainComponent_Factory_Impl implements MainComponent.Factory {
    private final C0082MainComponent_Factory delegateFactory;

    MainComponent_Factory_Impl(C0082MainComponent_Factory c0082MainComponent_Factory) {
        this.delegateFactory = c0082MainComponent_Factory;
    }

    @Override // com.miami.game.core.app.root.nav.main.MainComponent.Factory
    public MainComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<MainComponent.Factory> create(C0082MainComponent_Factory c0082MainComponent_Factory) {
        return InstanceFactory.create(new MainComponent_Factory_Impl(c0082MainComponent_Factory));
    }

    public static dagger.internal.Provider<MainComponent.Factory> createFactoryProvider(C0082MainComponent_Factory c0082MainComponent_Factory) {
        return InstanceFactory.create(new MainComponent_Factory_Impl(c0082MainComponent_Factory));
    }
}

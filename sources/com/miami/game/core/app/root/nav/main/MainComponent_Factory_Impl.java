package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.core.app.root.nav.main.MainComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class MainComponent_Factory_Impl implements MainComponent.Factory {
    private final C0115MainComponent_Factory delegateFactory;

    MainComponent_Factory_Impl(C0115MainComponent_Factory c0115MainComponent_Factory) {
        this.delegateFactory = c0115MainComponent_Factory;
    }

    @Override // com.miami.game.core.app.root.nav.main.MainComponent.Factory
    public MainComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<MainComponent.Factory> create(C0115MainComponent_Factory c0115MainComponent_Factory) {
        return InstanceFactory.create(new MainComponent_Factory_Impl(c0115MainComponent_Factory));
    }

    public static dagger.internal.Provider<MainComponent.Factory> createFactoryProvider(C0115MainComponent_Factory c0115MainComponent_Factory) {
        return InstanceFactory.create(new MainComponent_Factory_Impl(c0115MainComponent_Factory));
    }
}

package com.miami.game.feature.settings.ui;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.settings.ui.SettingsComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class SettingsComponent_Factory_Impl implements SettingsComponent.Factory {
    private final C0114SettingsComponent_Factory delegateFactory;

    SettingsComponent_Factory_Impl(C0114SettingsComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.settings.ui.SettingsComponent.Factory
    public SettingsComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<SettingsComponent.Factory> create(C0114SettingsComponent_Factory delegateFactory) {
        return InstanceFactory.create(new SettingsComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<SettingsComponent.Factory> createFactoryProvider(C0114SettingsComponent_Factory delegateFactory) {
        return InstanceFactory.create(new SettingsComponent_Factory_Impl(delegateFactory));
    }
}

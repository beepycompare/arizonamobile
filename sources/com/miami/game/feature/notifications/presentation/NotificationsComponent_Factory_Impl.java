package com.miami.game.feature.notifications.presentation;

import com.arkivanov.decompose.ComponentContext;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
/* loaded from: classes4.dex */
public final class NotificationsComponent_Factory_Impl implements NotificationsComponent.Factory {
    private final C0120NotificationsComponent_Factory delegateFactory;

    NotificationsComponent_Factory_Impl(C0120NotificationsComponent_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.miami.game.feature.notifications.presentation.NotificationsComponent.Factory
    public NotificationsComponent invoke(ComponentContext componentContext) {
        return this.delegateFactory.get(componentContext);
    }

    public static Provider<NotificationsComponent.Factory> create(C0120NotificationsComponent_Factory delegateFactory) {
        return InstanceFactory.create(new NotificationsComponent_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<NotificationsComponent.Factory> createFactoryProvider(C0120NotificationsComponent_Factory delegateFactory) {
        return InstanceFactory.create(new NotificationsComponent_Factory_Impl(delegateFactory));
    }
}

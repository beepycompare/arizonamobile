package com.arizona.launcher;

import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.feature.notifications.NotificationStateHolder;
import dagger.MembersInjector;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class MainEntrench_MembersInjector implements MembersInjector<MainEntrench> {
    private final Provider<NotificationStateHolder> notificationStateHolderProvider;
    private final Provider<MainComponent.Factory> rootFactoryProvider;

    public MainEntrench_MembersInjector(Provider<MainComponent.Factory> rootFactoryProvider, Provider<NotificationStateHolder> notificationStateHolderProvider) {
        this.rootFactoryProvider = rootFactoryProvider;
        this.notificationStateHolderProvider = notificationStateHolderProvider;
    }

    public static MembersInjector<MainEntrench> create(Provider<MainComponent.Factory> rootFactoryProvider, Provider<NotificationStateHolder> notificationStateHolderProvider) {
        return new MainEntrench_MembersInjector(rootFactoryProvider, notificationStateHolderProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainEntrench instance) {
        injectRootFactory(instance, this.rootFactoryProvider.get());
        injectNotificationStateHolder(instance, this.notificationStateHolderProvider.get());
    }

    public static void injectRootFactory(MainEntrench instance, MainComponent.Factory rootFactory) {
        instance.rootFactory = rootFactory;
    }

    public static void injectNotificationStateHolder(MainEntrench instance, NotificationStateHolder notificationStateHolder) {
        instance.notificationStateHolder = notificationStateHolder;
    }
}

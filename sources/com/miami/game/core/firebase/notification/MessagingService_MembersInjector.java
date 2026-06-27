package com.miami.game.core.firebase.notification;

import com.miami.game.core.firebase.notification.data.MessagingRepository;
import dagger.MembersInjector;
import dagger.internal.Provider;
/* loaded from: classes5.dex */
public final class MessagingService_MembersInjector implements MembersInjector<MessagingService> {
    private final Provider<MessagingRepository> messagingRepositoryProvider;

    private MessagingService_MembersInjector(Provider<MessagingRepository> messagingRepositoryProvider) {
        this.messagingRepositoryProvider = messagingRepositoryProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MessagingService instance) {
        injectMessagingRepository(instance, this.messagingRepositoryProvider.get());
    }

    public static MembersInjector<MessagingService> create(Provider<MessagingRepository> messagingRepositoryProvider) {
        return new MessagingService_MembersInjector(messagingRepositoryProvider);
    }

    public static void injectMessagingRepository(MessagingService instance, MessagingRepository messagingRepository) {
        instance.messagingRepository = messagingRepository;
    }
}

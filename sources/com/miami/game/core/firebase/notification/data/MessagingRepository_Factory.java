package com.miami.game.core.firebase.notification.data;

import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes5.dex */
public final class MessagingRepository_Factory implements Factory<MessagingRepository> {
    private final Provider<LocalRepository> localRepositoryProvider;

    private MessagingRepository_Factory(Provider<LocalRepository> localRepositoryProvider) {
        this.localRepositoryProvider = localRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MessagingRepository get() {
        return newInstance(this.localRepositoryProvider.get());
    }

    public static MessagingRepository_Factory create(Provider<LocalRepository> localRepositoryProvider) {
        return new MessagingRepository_Factory(localRepositoryProvider);
    }

    public static MessagingRepository newInstance(LocalRepository localRepository) {
        return new MessagingRepository(localRepository);
    }
}

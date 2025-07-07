package com.arizona.launcher.ui.notifications;

import com.arizona.launcher.data.repository.notifications.NotificationsRepository;
import com.arizona.launcher.data.rx.SchedulersFacade;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class NotificationsViewModel_Factory implements Factory<NotificationsViewModel> {
    private final Provider<NotificationsRepository> notificationsRepositoryProvider;
    private final Provider<SchedulersFacade> schedulersProvider;

    public NotificationsViewModel_Factory(Provider<NotificationsRepository> notificationsRepositoryProvider, Provider<SchedulersFacade> schedulersProvider) {
        this.notificationsRepositoryProvider = notificationsRepositoryProvider;
        this.schedulersProvider = schedulersProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationsViewModel get() {
        return newInstance(this.notificationsRepositoryProvider.get(), this.schedulersProvider.get());
    }

    public static NotificationsViewModel_Factory create(Provider<NotificationsRepository> notificationsRepositoryProvider, Provider<SchedulersFacade> schedulersProvider) {
        return new NotificationsViewModel_Factory(notificationsRepositoryProvider, schedulersProvider);
    }

    public static NotificationsViewModel newInstance(NotificationsRepository notificationsRepository, SchedulersFacade schedulers) {
        return new NotificationsViewModel(notificationsRepository, schedulers);
    }
}

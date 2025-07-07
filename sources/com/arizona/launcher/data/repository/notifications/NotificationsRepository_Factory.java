package com.arizona.launcher.data.repository.notifications;

import com.arizona.launcher.data.database.NotificationHistoryDAO;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class NotificationsRepository_Factory implements Factory<NotificationsRepository> {
    private final Provider<NotificationHistoryDAO> notificationHistoryDAOProvider;
    private final Provider<NotificationsAPI> notificationsAPIProvider;

    public NotificationsRepository_Factory(Provider<NotificationsAPI> notificationsAPIProvider, Provider<NotificationHistoryDAO> notificationHistoryDAOProvider) {
        this.notificationsAPIProvider = notificationsAPIProvider;
        this.notificationHistoryDAOProvider = notificationHistoryDAOProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationsRepository get() {
        return newInstance(this.notificationsAPIProvider.get(), this.notificationHistoryDAOProvider.get());
    }

    public static NotificationsRepository_Factory create(Provider<NotificationsAPI> notificationsAPIProvider, Provider<NotificationHistoryDAO> notificationHistoryDAOProvider) {
        return new NotificationsRepository_Factory(notificationsAPIProvider, notificationHistoryDAOProvider);
    }

    public static NotificationsRepository newInstance(NotificationsAPI notificationsAPI, NotificationHistoryDAO notificationHistoryDAO) {
        return new NotificationsRepository(notificationsAPI, notificationHistoryDAO);
    }
}

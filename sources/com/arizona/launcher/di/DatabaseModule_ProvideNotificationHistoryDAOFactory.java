package com.arizona.launcher.di;

import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.NotificationHistoryDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class DatabaseModule_ProvideNotificationHistoryDAOFactory implements Factory<NotificationHistoryDAO> {
    private final Provider<ArizonaDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideNotificationHistoryDAOFactory(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        this.module = module;
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationHistoryDAO get() {
        return provideNotificationHistoryDAO(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvideNotificationHistoryDAOFactory create(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        return new DatabaseModule_ProvideNotificationHistoryDAOFactory(module, databaseProvider);
    }

    public static NotificationHistoryDAO provideNotificationHistoryDAO(DatabaseModule instance, ArizonaDatabase database) {
        return (NotificationHistoryDAO) Preconditions.checkNotNullFromProvides(instance.provideNotificationHistoryDAO(database));
    }
}

package com.arizona.launcher.di;

import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.LastPlayedDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class DatabaseModule_ProvideLastPlayedDAOFactory implements Factory<LastPlayedDAO> {
    private final Provider<ArizonaDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideLastPlayedDAOFactory(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        this.module = module;
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LastPlayedDAO get() {
        return provideLastPlayedDAO(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvideLastPlayedDAOFactory create(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        return new DatabaseModule_ProvideLastPlayedDAOFactory(module, databaseProvider);
    }

    public static LastPlayedDAO provideLastPlayedDAO(DatabaseModule instance, ArizonaDatabase database) {
        return (LastPlayedDAO) Preconditions.checkNotNullFromProvides(instance.provideLastPlayedDAO(database));
    }
}

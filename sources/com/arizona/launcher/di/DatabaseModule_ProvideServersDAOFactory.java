package com.arizona.launcher.di;

import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.ServersDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class DatabaseModule_ProvideServersDAOFactory implements Factory<ServersDAO> {
    private final Provider<ArizonaDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideServersDAOFactory(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        this.module = module;
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ServersDAO get() {
        return provideServersDAO(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvideServersDAOFactory create(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        return new DatabaseModule_ProvideServersDAOFactory(module, databaseProvider);
    }

    public static ServersDAO provideServersDAO(DatabaseModule instance, ArizonaDatabase database) {
        return (ServersDAO) Preconditions.checkNotNullFromProvides(instance.provideServersDAO(database));
    }
}

package com.arizona.launcher.di;

import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.FavoriteDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class DatabaseModule_ProvideFavoriteDAOFactory implements Factory<FavoriteDAO> {
    private final Provider<ArizonaDatabase> databaseProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideFavoriteDAOFactory(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        this.module = module;
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FavoriteDAO get() {
        return provideFavoriteDAO(this.module, this.databaseProvider.get());
    }

    public static DatabaseModule_ProvideFavoriteDAOFactory create(DatabaseModule module, Provider<ArizonaDatabase> databaseProvider) {
        return new DatabaseModule_ProvideFavoriteDAOFactory(module, databaseProvider);
    }

    public static FavoriteDAO provideFavoriteDAO(DatabaseModule instance, ArizonaDatabase database) {
        return (FavoriteDAO) Preconditions.checkNotNullFromProvides(instance.provideFavoriteDAO(database));
    }
}

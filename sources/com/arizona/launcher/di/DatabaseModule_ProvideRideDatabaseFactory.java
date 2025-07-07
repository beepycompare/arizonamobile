package com.arizona.launcher.di;

import android.content.Context;
import com.arizona.launcher.data.database.ArizonaDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class DatabaseModule_ProvideRideDatabaseFactory implements Factory<ArizonaDatabase> {
    private final Provider<Context> appContextProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideRideDatabaseFactory(DatabaseModule module, Provider<Context> appContextProvider) {
        this.module = module;
        this.appContextProvider = appContextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ArizonaDatabase get() {
        return provideRideDatabase(this.module, this.appContextProvider.get());
    }

    public static DatabaseModule_ProvideRideDatabaseFactory create(DatabaseModule module, Provider<Context> appContextProvider) {
        return new DatabaseModule_ProvideRideDatabaseFactory(module, appContextProvider);
    }

    public static ArizonaDatabase provideRideDatabase(DatabaseModule instance, Context appContext) {
        return (ArizonaDatabase) Preconditions.checkNotNullFromProvides(instance.provideRideDatabase(appContext));
    }
}

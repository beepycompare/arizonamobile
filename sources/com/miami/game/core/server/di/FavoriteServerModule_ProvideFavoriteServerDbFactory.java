package com.miami.game.core.server.di;

import android.content.Context;
import com.miami.game.core.server.data.FavoriteServerDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class FavoriteServerModule_ProvideFavoriteServerDbFactory implements Factory<FavoriteServerDatabase> {
    private final Provider<Context> contextProvider;
    private final FavoriteServerModule module;

    public FavoriteServerModule_ProvideFavoriteServerDbFactory(FavoriteServerModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FavoriteServerDatabase get() {
        return provideFavoriteServerDb(this.module, this.contextProvider.get());
    }

    public static FavoriteServerModule_ProvideFavoriteServerDbFactory create(FavoriteServerModule module, Provider<Context> contextProvider) {
        return new FavoriteServerModule_ProvideFavoriteServerDbFactory(module, contextProvider);
    }

    public static FavoriteServerDatabase provideFavoriteServerDb(FavoriteServerModule instance, Context context) {
        return (FavoriteServerDatabase) Preconditions.checkNotNullFromProvides(instance.provideFavoriteServerDb(context));
    }
}

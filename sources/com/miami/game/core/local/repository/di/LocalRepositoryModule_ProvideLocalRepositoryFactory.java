package com.miami.game.core.local.repository.di;

import android.content.Context;
import com.google.gson.Gson;
import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class LocalRepositoryModule_ProvideLocalRepositoryFactory implements Factory<LocalRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;

    public LocalRepositoryModule_ProvideLocalRepositoryFactory(Provider<Context> provider, Provider<Gson> provider2) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalRepository get() {
        return provideLocalRepository(this.contextProvider.get(), this.gsonProvider.get());
    }

    public static LocalRepositoryModule_ProvideLocalRepositoryFactory create(Provider<Context> provider, Provider<Gson> provider2) {
        return new LocalRepositoryModule_ProvideLocalRepositoryFactory(provider, provider2);
    }

    public static LocalRepository provideLocalRepository(Context context, Gson gson) {
        return (LocalRepository) Preconditions.checkNotNullFromProvides(LocalRepositoryModule.INSTANCE.provideLocalRepository(context, gson));
    }
}

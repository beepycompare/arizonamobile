package com.miami.game.core.local.repository.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes4.dex */
public final class LocalRepositoryModule_ProvideGsonFactory implements Factory<Gson> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gson get() {
        return provideGson();
    }

    public static LocalRepositoryModule_ProvideGsonFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Gson provideGson() {
        return (Gson) Preconditions.checkNotNullFromProvides(LocalRepositoryModule.INSTANCE.provideGson());
    }

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final LocalRepositoryModule_ProvideGsonFactory INSTANCE = new LocalRepositoryModule_ProvideGsonFactory();

        private InstanceHolder() {
        }
    }
}

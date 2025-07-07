package com.miami.game.core.api.network.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes4.dex */
public final class NetworkApiModule_ProvideGsonFactory implements Factory<Gson> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gson get() {
        return provideGson();
    }

    public static NetworkApiModule_ProvideGsonFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Gson provideGson() {
        return (Gson) Preconditions.checkNotNullFromProvides(NetworkApiModule.INSTANCE.provideGson());
    }

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final NetworkApiModule_ProvideGsonFactory INSTANCE = new NetworkApiModule_ProvideGsonFactory();

        private InstanceHolder() {
        }
    }
}

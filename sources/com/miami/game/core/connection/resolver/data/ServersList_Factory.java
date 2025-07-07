package com.miami.game.core.connection.resolver.data;

import com.miami.game.core.build.config.BuildConfigRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class ServersList_Factory implements Factory<ServersList> {
    private final Provider<BuildConfigRepository> buildConfigProvider;

    public ServersList_Factory(Provider<BuildConfigRepository> provider) {
        this.buildConfigProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ServersList get() {
        return newInstance(this.buildConfigProvider.get());
    }

    public static ServersList_Factory create(Provider<BuildConfigRepository> provider) {
        return new ServersList_Factory(provider);
    }

    public static ServersList newInstance(BuildConfigRepository buildConfigRepository) {
        return new ServersList(buildConfigRepository);
    }
}

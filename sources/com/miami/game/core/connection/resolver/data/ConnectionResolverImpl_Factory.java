package com.miami.game.core.connection.resolver.data;

import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class ConnectionResolverImpl_Factory implements Factory<ConnectionResolverImpl> {
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<ServersList> serversListProvider;

    public ConnectionResolverImpl_Factory(Provider<AvailabilityService> provider, Provider<ServersList> provider2) {
        this.availabilityServiceProvider = provider;
        this.serversListProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ConnectionResolverImpl get() {
        return newInstance(this.availabilityServiceProvider.get(), this.serversListProvider.get());
    }

    public static ConnectionResolverImpl_Factory create(Provider<AvailabilityService> provider, Provider<ServersList> provider2) {
        return new ConnectionResolverImpl_Factory(provider, provider2);
    }

    public static ConnectionResolverImpl newInstance(AvailabilityService availabilityService, ServersList serversList) {
        return new ConnectionResolverImpl(availabilityService, serversList);
    }
}

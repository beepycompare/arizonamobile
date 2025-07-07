package com.miami.game.core.connection.resolver.data;

import dagger.internal.Factory;
/* loaded from: classes4.dex */
public final class AvailabilityService_Factory implements Factory<AvailabilityService> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AvailabilityService get() {
        return newInstance();
    }

    public static AvailabilityService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AvailabilityService newInstance() {
        return new AvailabilityService();
    }

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final AvailabilityService_Factory INSTANCE = new AvailabilityService_Factory();

        private InstanceHolder() {
        }
    }
}

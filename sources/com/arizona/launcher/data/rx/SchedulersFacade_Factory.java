package com.arizona.launcher.data.rx;

import dagger.internal.Factory;
/* loaded from: classes3.dex */
public final class SchedulersFacade_Factory implements Factory<SchedulersFacade> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SchedulersFacade get() {
        return newInstance();
    }

    public static SchedulersFacade_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SchedulersFacade newInstance() {
        return new SchedulersFacade();
    }

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {
        static final SchedulersFacade_Factory INSTANCE = new SchedulersFacade_Factory();

        private InstanceHolder() {
        }
    }
}

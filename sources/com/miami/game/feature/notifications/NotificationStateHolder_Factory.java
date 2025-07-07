package com.miami.game.feature.notifications;

import dagger.internal.Factory;
/* loaded from: classes4.dex */
public final class NotificationStateHolder_Factory implements Factory<NotificationStateHolder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationStateHolder get() {
        return newInstance();
    }

    public static NotificationStateHolder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NotificationStateHolder newInstance() {
        return new NotificationStateHolder();
    }

    /* loaded from: classes4.dex */
    private static final class InstanceHolder {
        static final NotificationStateHolder_Factory INSTANCE = new NotificationStateHolder_Factory();

        private InstanceHolder() {
        }
    }
}

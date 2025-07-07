package com.arizona.launcher.ui.notifications;

import com.arizona.launcher.ui.notifications.NotificationsViewModel_HiltModules;
import dagger.internal.Factory;
/* loaded from: classes3.dex */
public final class NotificationsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static NotificationsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NotificationsViewModel_HiltModules.KeyModule.provide();
    }

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {
        static final NotificationsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NotificationsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}

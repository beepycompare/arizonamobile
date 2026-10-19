package com.arizona.launcher.data.repository.settings;

import dagger.internal.Factory;
/* loaded from: classes3.dex */
public final class SettingsRepository_Factory implements Factory<SettingsRepository> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SettingsRepository get() {
        return newInstance();
    }

    public static SettingsRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SettingsRepository newInstance() {
        return new SettingsRepository();
    }

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {
        static final SettingsRepository_Factory INSTANCE = new SettingsRepository_Factory();

        private InstanceHolder() {
        }
    }
}

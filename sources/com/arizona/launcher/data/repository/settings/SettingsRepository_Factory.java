package com.arizona.launcher.data.repository.settings;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class SettingsRepository_Factory implements Factory<SettingsRepository> {
    private final Provider<SharedPreferences> preferencesProvider;

    public SettingsRepository_Factory(Provider<SharedPreferences> preferencesProvider) {
        this.preferencesProvider = preferencesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SettingsRepository get() {
        return newInstance(this.preferencesProvider.get());
    }

    public static SettingsRepository_Factory create(Provider<SharedPreferences> preferencesProvider) {
        return new SettingsRepository_Factory(preferencesProvider);
    }

    public static SettingsRepository newInstance(SharedPreferences preferences) {
        return new SettingsRepository(preferences);
    }
}

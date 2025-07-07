package com.arizona.launcher.data.repository;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class PreferencesRepository_Factory implements Factory<PreferencesRepository> {
    private final Provider<SharedPreferences> preferencesProvider;

    public PreferencesRepository_Factory(Provider<SharedPreferences> preferencesProvider) {
        this.preferencesProvider = preferencesProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreferencesRepository get() {
        return newInstance(this.preferencesProvider.get());
    }

    public static PreferencesRepository_Factory create(Provider<SharedPreferences> preferencesProvider) {
        return new PreferencesRepository_Factory(preferencesProvider);
    }

    public static PreferencesRepository newInstance(SharedPreferences preferences) {
        return new PreferencesRepository(preferences);
    }
}

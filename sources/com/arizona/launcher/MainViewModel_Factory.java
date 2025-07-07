package com.arizona.launcher;

import com.arizona.launcher.data.repository.PreferencesRepository;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class MainViewModel_Factory implements Factory<MainViewModel> {
    private final Provider<PreferencesRepository> preferencesRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    public MainViewModel_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<PreferencesRepository> preferencesRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainViewModel get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.preferencesRepositoryProvider.get());
    }

    public static MainViewModel_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<PreferencesRepository> preferencesRepositoryProvider) {
        return new MainViewModel_Factory(settingsRepositoryProvider, preferencesRepositoryProvider);
    }

    public static MainViewModel newInstance(SettingsRepository settingsRepository, PreferencesRepository preferencesRepository) {
        return new MainViewModel(settingsRepository, preferencesRepository);
    }
}

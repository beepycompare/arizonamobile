package com.miami.game.core.settings;

import com.miami.game.core.local.repository.common.LocalRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class SettingsInteractor_Factory implements Factory<SettingsInteractor> {
    private final Provider<LocalRepository> localRepositoryProvider;

    public SettingsInteractor_Factory(Provider<LocalRepository> provider) {
        this.localRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SettingsInteractor get() {
        return newInstance(this.localRepositoryProvider.get());
    }

    public static SettingsInteractor_Factory create(Provider<LocalRepository> provider) {
        return new SettingsInteractor_Factory(provider);
    }

    public static SettingsInteractor newInstance(LocalRepository localRepository) {
        return new SettingsInteractor(localRepository);
    }
}

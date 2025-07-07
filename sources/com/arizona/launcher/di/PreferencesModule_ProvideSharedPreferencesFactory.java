package com.arizona.launcher.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class PreferencesModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> applicationContextProvider;
    private final PreferencesModule module;

    public PreferencesModule_ProvideSharedPreferencesFactory(PreferencesModule module, Provider<Context> applicationContextProvider) {
        this.module = module;
        this.applicationContextProvider = applicationContextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedPreferences get() {
        return provideSharedPreferences(this.module, this.applicationContextProvider.get());
    }

    public static PreferencesModule_ProvideSharedPreferencesFactory create(PreferencesModule module, Provider<Context> applicationContextProvider) {
        return new PreferencesModule_ProvideSharedPreferencesFactory(module, applicationContextProvider);
    }

    public static SharedPreferences provideSharedPreferences(PreferencesModule instance, Context applicationContext) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(instance.provideSharedPreferences(applicationContext));
    }
}

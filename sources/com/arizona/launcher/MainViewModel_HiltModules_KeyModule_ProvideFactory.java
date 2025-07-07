package com.arizona.launcher;

import com.arizona.launcher.MainViewModel_HiltModules;
import dagger.internal.Factory;
/* loaded from: classes3.dex */
public final class MainViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static MainViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return MainViewModel_HiltModules.KeyModule.provide();
    }

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {
        static final MainViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MainViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}

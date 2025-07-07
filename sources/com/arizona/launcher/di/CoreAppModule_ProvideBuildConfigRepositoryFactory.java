package com.arizona.launcher.di;

import com.miami.game.core.build.config.BuildConfigRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes3.dex */
public final class CoreAppModule_ProvideBuildConfigRepositoryFactory implements Factory<BuildConfigRepository> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BuildConfigRepository get() {
        return provideBuildConfigRepository();
    }

    public static CoreAppModule_ProvideBuildConfigRepositoryFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BuildConfigRepository provideBuildConfigRepository() {
        return (BuildConfigRepository) Preconditions.checkNotNullFromProvides(CoreAppModule.INSTANCE.provideBuildConfigRepository());
    }

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {
        static final CoreAppModule_ProvideBuildConfigRepositoryFactory INSTANCE = new CoreAppModule_ProvideBuildConfigRepositoryFactory();

        private InstanceHolder() {
        }
    }
}

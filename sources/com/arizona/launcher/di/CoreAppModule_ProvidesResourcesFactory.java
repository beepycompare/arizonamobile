package com.arizona.launcher.di;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class CoreAppModule_ProvidesResourcesFactory implements Factory<Resources> {
    private final Provider<Context> contextProvider;

    public CoreAppModule_ProvidesResourcesFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Resources get() {
        return providesResources(this.contextProvider.get());
    }

    public static CoreAppModule_ProvidesResourcesFactory create(Provider<Context> contextProvider) {
        return new CoreAppModule_ProvidesResourcesFactory(contextProvider);
    }

    public static Resources providesResources(Context context) {
        return (Resources) Preconditions.checkNotNullFromProvides(CoreAppModule.INSTANCE.providesResources(context));
    }
}

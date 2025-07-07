package com.arizona.launcher.di;

import com.arizona.launcher.data.repository.UpdateApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes3.dex */
public final class UpdateApiModule_ProvideApiFactory implements Factory<UpdateApi> {
    private final UpdateApiModule module;

    public UpdateApiModule_ProvideApiFactory(UpdateApiModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateApi get() {
        return provideApi(this.module);
    }

    public static UpdateApiModule_ProvideApiFactory create(UpdateApiModule module) {
        return new UpdateApiModule_ProvideApiFactory(module);
    }

    public static UpdateApi provideApi(UpdateApiModule instance) {
        return (UpdateApi) Preconditions.checkNotNullFromProvides(instance.provideApi());
    }
}

package com.arizona.launcher.di;

import com.arizona.launcher.data.repository.SecondaryUpdateApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* loaded from: classes3.dex */
public final class UpdateApiModule_ProvideSecondaryApiFactory implements Factory<SecondaryUpdateApi> {
    private final UpdateApiModule module;

    public UpdateApiModule_ProvideSecondaryApiFactory(UpdateApiModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SecondaryUpdateApi get() {
        return provideSecondaryApi(this.module);
    }

    public static UpdateApiModule_ProvideSecondaryApiFactory create(UpdateApiModule module) {
        return new UpdateApiModule_ProvideSecondaryApiFactory(module);
    }

    public static SecondaryUpdateApi provideSecondaryApi(UpdateApiModule instance) {
        return (SecondaryUpdateApi) Preconditions.checkNotNullFromProvides(instance.provideSecondaryApi());
    }
}

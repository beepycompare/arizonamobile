package com.arizona.launcher.data.repository;

import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class UpdateRepository_Factory implements Factory<UpdateRepository> {
    private final Provider<SecondaryUpdateApi> secondaryUpdateApiProvider;
    private final Provider<UpdateApi> updateApiProvider;

    public UpdateRepository_Factory(Provider<UpdateApi> updateApiProvider, Provider<SecondaryUpdateApi> secondaryUpdateApiProvider) {
        this.updateApiProvider = updateApiProvider;
        this.secondaryUpdateApiProvider = secondaryUpdateApiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateRepository get() {
        return newInstance(this.updateApiProvider.get(), this.secondaryUpdateApiProvider.get());
    }

    public static UpdateRepository_Factory create(Provider<UpdateApi> updateApiProvider, Provider<SecondaryUpdateApi> secondaryUpdateApiProvider) {
        return new UpdateRepository_Factory(updateApiProvider, secondaryUpdateApiProvider);
    }

    public static UpdateRepository newInstance(UpdateApi updateApi, SecondaryUpdateApi secondaryUpdateApi) {
        return new UpdateRepository(updateApi, secondaryUpdateApi);
    }
}

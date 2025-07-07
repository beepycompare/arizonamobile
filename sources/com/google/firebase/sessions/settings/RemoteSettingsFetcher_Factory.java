package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
/* loaded from: classes4.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {
    private final Provider<ApplicationInfo> appInfoProvider;
    private final Provider<CoroutineContext> blockingDispatcherProvider;

    public RemoteSettingsFetcher_Factory(Provider<ApplicationInfo> provider, Provider<CoroutineContext> provider2) {
        this.appInfoProvider = provider;
        this.blockingDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RemoteSettingsFetcher get() {
        return newInstance(this.appInfoProvider.get(), this.blockingDispatcherProvider.get());
    }

    public static RemoteSettingsFetcher_Factory create(Provider<ApplicationInfo> provider, Provider<CoroutineContext> provider2) {
        return new RemoteSettingsFetcher_Factory(provider, provider2);
    }

    public static RemoteSettingsFetcher newInstance(ApplicationInfo applicationInfo, CoroutineContext coroutineContext) {
        return new RemoteSettingsFetcher(applicationInfo, coroutineContext);
    }
}

package com.miami.game.core.downloader.database;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class LauncherDBModule_ProvideDownloaderInfoDatabaseFactory implements Factory<DownloaderInfoDatabase> {
    private final Provider<Context> contextProvider;
    private final LauncherDBModule module;

    public LauncherDBModule_ProvideDownloaderInfoDatabaseFactory(LauncherDBModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloaderInfoDatabase get() {
        return provideDownloaderInfoDatabase(this.module, this.contextProvider.get());
    }

    public static LauncherDBModule_ProvideDownloaderInfoDatabaseFactory create(LauncherDBModule module, Provider<Context> contextProvider) {
        return new LauncherDBModule_ProvideDownloaderInfoDatabaseFactory(module, contextProvider);
    }

    public static DownloaderInfoDatabase provideDownloaderInfoDatabase(LauncherDBModule instance, Context context) {
        return (DownloaderInfoDatabase) Preconditions.checkNotNullFromProvides(instance.provideDownloaderInfoDatabase(context));
    }
}

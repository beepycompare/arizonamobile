package com.miami.game.core.downloader.sync;

import android.content.Context;
import com.miami.game.core.files.Files;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DowndloaderSyncModule_ProvideDownloaderFactory implements Factory<Files> {
    private final Provider<Context> contextProvider;
    private final DowndloaderSyncModule module;

    public DowndloaderSyncModule_ProvideDownloaderFactory(DowndloaderSyncModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Files get() {
        return provideDownloader(this.module, this.contextProvider.get());
    }

    public static DowndloaderSyncModule_ProvideDownloaderFactory create(DowndloaderSyncModule module, Provider<Context> contextProvider) {
        return new DowndloaderSyncModule_ProvideDownloaderFactory(module, contextProvider);
    }

    public static Files provideDownloader(DowndloaderSyncModule instance, Context context) {
        return (Files) Preconditions.checkNotNullFromProvides(instance.provideDownloader(context));
    }
}

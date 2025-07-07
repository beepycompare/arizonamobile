package com.miami.game.core.downloader;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DowndloaderModule_ProvideDownloaderFactory implements Factory<Downloader> {
    private final Provider<Context> contextProvider;
    private final DowndloaderModule module;

    public DowndloaderModule_ProvideDownloaderFactory(DowndloaderModule downdloaderModule, Provider<Context> provider) {
        this.module = downdloaderModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Downloader get() {
        return provideDownloader(this.module, this.contextProvider.get());
    }

    public static DowndloaderModule_ProvideDownloaderFactory create(DowndloaderModule downdloaderModule, Provider<Context> provider) {
        return new DowndloaderModule_ProvideDownloaderFactory(downdloaderModule, provider);
    }

    public static Downloader provideDownloader(DowndloaderModule downdloaderModule, Context context) {
        return (Downloader) Preconditions.checkNotNullFromProvides(downdloaderModule.provideDownloader(context));
    }
}

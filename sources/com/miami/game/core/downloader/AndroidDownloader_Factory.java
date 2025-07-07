package com.miami.game.core.downloader;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class AndroidDownloader_Factory implements Factory<AndroidDownloader> {
    private final Provider<Context> applicationContextProvider;

    public AndroidDownloader_Factory(Provider<Context> provider) {
        this.applicationContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidDownloader get() {
        return newInstance(this.applicationContextProvider.get());
    }

    public static AndroidDownloader_Factory create(Provider<Context> provider) {
        return new AndroidDownloader_Factory(provider);
    }

    public static AndroidDownloader newInstance(Context context) {
        return new AndroidDownloader(context);
    }
}

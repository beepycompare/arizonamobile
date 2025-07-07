package com.miami.game.core.files.updater.data;

import android.content.ContentResolver;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class FilesUpdaterRepository_Factory implements Factory<FilesUpdaterRepository> {
    private final Provider<ContentResolver> contentResolverProvider;

    public FilesUpdaterRepository_Factory(Provider<ContentResolver> contentResolverProvider) {
        this.contentResolverProvider = contentResolverProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesUpdaterRepository get() {
        return newInstance(this.contentResolverProvider.get());
    }

    public static FilesUpdaterRepository_Factory create(Provider<ContentResolver> contentResolverProvider) {
        return new FilesUpdaterRepository_Factory(contentResolverProvider);
    }

    public static FilesUpdaterRepository newInstance(ContentResolver contentResolver) {
        return new FilesUpdaterRepository(contentResolver);
    }
}

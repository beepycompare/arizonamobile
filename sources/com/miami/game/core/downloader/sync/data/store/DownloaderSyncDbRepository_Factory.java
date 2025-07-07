package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.downloader.database.DownloaderInfoDatabase;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes4.dex */
public final class DownloaderSyncDbRepository_Factory implements Factory<DownloaderSyncDbRepository> {
    private final Provider<DownloaderInfoDatabase> databaseProvider;

    public DownloaderSyncDbRepository_Factory(Provider<DownloaderInfoDatabase> databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloaderSyncDbRepository get() {
        return newInstance(this.databaseProvider.get());
    }

    public static DownloaderSyncDbRepository_Factory create(Provider<DownloaderInfoDatabase> databaseProvider) {
        return new DownloaderSyncDbRepository_Factory(databaseProvider);
    }

    public static DownloaderSyncDbRepository newInstance(DownloaderInfoDatabase database) {
        return new DownloaderSyncDbRepository(database);
    }
}

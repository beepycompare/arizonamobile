package com.miami.game.core.downloader.database;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: di.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/miami/game/core/downloader/database/LauncherDBModule;", "", "<init>", "()V", "DATABASE_APP_NAME", "", "provideDownloaderInfoDatabase", "Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;", "context", "Landroid/content/Context;", "downloader-database_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class LauncherDBModule {
    private final String DATABASE_APP_NAME = "client_database_miami";

    @Provides
    @Singleton
    public final DownloaderInfoDatabase provideDownloaderInfoDatabase(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DownloaderInfoProvider().provide(context, this.DATABASE_APP_NAME);
    }
}

package com.miami.game.core.downloader.sync;

import android.content.Context;
import com.miami.game.core.files.AndroidFiles;
import com.miami.game.core.files.Files;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: di.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\f\b\u0001\u0010\u0006\u001a\u00020\u0007:\u0002\b\bH\u0007b\u0002\b\tÊ\u0001\u0002\b\u000bÊ\u0001\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e¨\u0006\n"}, d2 = {"Lcom/miami/game/core/downloader/sync/DowndloaderSyncModule;", "", "<init>", "()V", "provideDownloader", "Lcom/miami/game/core/files/Files;", "context", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "Ldagger/Provides;", "downloader-sync", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class DowndloaderSyncModule {
    @Provides
    public final Files provideDownloader(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AndroidFiles(context);
    }
}

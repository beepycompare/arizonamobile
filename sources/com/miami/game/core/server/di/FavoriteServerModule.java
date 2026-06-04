package com.miami.game.core.server.di;

import android.content.Context;
import com.miami.game.core.server.data.FavoriteServerDatabase;
import com.miami.game.core.server.data.FavotireDbProvider;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FavoriteServerModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\b\u0001\u0010\u0006\u001a\u00020\u0007:\u0002\b\bH\u0007b\u0002\b\tb\u0002\b\nÊ\u0001\u0002\b\fÊ\u0001\u0010\b\r\u0012\f\b\u000e\u0012\b\b\fJ\u0004\b\t0\u000f¨\u0006\u000b"}, d2 = {"Lcom/miami/game/core/server/di/FavoriteServerModule;", "", "<init>", "()V", "provideFavoriteServerDb", "Lcom/miami/game/core/server/data/FavoriteServerDatabase;", "context", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "Ljavax/inject/Singleton;", "Ldagger/Provides;", "server", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class FavoriteServerModule {
    @Provides
    @Singleton
    public final FavoriteServerDatabase provideFavoriteServerDb(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FavotireDbProvider().provide(context, "favorite_server_db");
    }
}

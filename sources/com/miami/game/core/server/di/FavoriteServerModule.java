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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/server/di/FavoriteServerModule;", "", "<init>", "()V", "provideFavoriteServerDb", "Lcom/miami/game/core/server/data/FavoriteServerDatabase;", "context", "Landroid/content/Context;", "server_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class FavoriteServerModule {
    @Provides
    @Singleton
    public final FavoriteServerDatabase provideFavoriteServerDb(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FavotireDbProvider().provide(context, "favorite_server_db");
    }
}

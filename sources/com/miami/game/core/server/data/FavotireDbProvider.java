package com.miami.game.core.server.data;

import android.content.Context;
import androidx.room.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FavotireDbProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/miami/game/core/server/data/FavotireDbProvider;", "", "<init>", "()V", "provide", "Lcom/miami/game/core/server/data/FavoriteServerDatabase;", "applicationContext", "Landroid/content/Context;", "dbName", "", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FavotireDbProvider {
    public final FavoriteServerDatabase provide(Context applicationContext, String dbName) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(dbName, "dbName");
        return (FavoriteServerDatabase) Room.databaseBuilder(applicationContext, FavoriteServerDatabase.class, dbName).fallbackToDestructiveMigration().build();
    }
}

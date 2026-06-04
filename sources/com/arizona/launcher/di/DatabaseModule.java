package com.arizona.launcher.di;

import android.content.Context;
import androidx.room.Room;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.FavoriteDAO;
import com.arizona.launcher.data.database.LastPlayedDAO;
import com.arizona.launcher.data.database.NotificationHistoryDAO;
import com.arizona.launcher.data.database.ServersDAO;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DatabaseModule.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\bb\u0002\b\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\bb\u0002\b\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\bb\u0002\b\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\bb\u0002\b\tJ\u001e\u0010\u0010\u001a\u00020\u00072\f\b\u0001\u0010\u0011\u001a\u00020\u0012:\u0002\b\u0013H\u0007b\u0002\b\bb\u0002\b\tÊ\u0001\u0002\b\u0015Ê\u0001\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/di/DatabaseModule;", "", "<init>", "()V", "provideLastPlayedDAO", "Lcom/arizona/launcher/data/database/LastPlayedDAO;", "database", "Lcom/arizona/launcher/data/database/ArizonaDatabase;", "Ljavax/inject/Singleton;", "Ldagger/Provides;", "provideFavoriteDAO", "Lcom/arizona/launcher/data/database/FavoriteDAO;", "provideNotificationHistoryDAO", "Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "provideServersDAO", "Lcom/arizona/launcher/data/database/ServersDAO;", "provideRideDatabase", "appContext", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "app", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class DatabaseModule {
    public static final int $stable = 0;

    @Provides
    @Singleton
    public final LastPlayedDAO provideLastPlayedDAO(ArizonaDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        return database.lastPlayedDAO();
    }

    @Provides
    @Singleton
    public final FavoriteDAO provideFavoriteDAO(ArizonaDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        return database.favoriteDAO();
    }

    @Provides
    @Singleton
    public final NotificationHistoryDAO provideNotificationHistoryDAO(ArizonaDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        return database.notificationHistoryDAO();
    }

    @Provides
    @Singleton
    public final ServersDAO provideServersDAO(ArizonaDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        return database.serversDAO();
    }

    @Provides
    @Singleton
    public final ArizonaDatabase provideRideDatabase(@ApplicationContext Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return (ArizonaDatabase) Room.databaseBuilder(appContext, ArizonaDatabase.class, "ArizonaDatabase").createFromAsset("database/ArizonaDatabase.db").fallbackToDestructiveMigration().build();
    }
}

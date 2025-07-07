package com.arizona.launcher.data.database;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.arizona.launcher.di.DatabaseModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaDatabase.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/data/database/ArizonaDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "favoriteDAO", "Lcom/arizona/launcher/data/database/FavoriteDAO;", "lastPlayedDAO", "Lcom/arizona/launcher/data/database/LastPlayedDAO;", "notificationHistoryDAO", "Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "serversDAO", "Lcom/arizona/launcher/data/database/ServersDAO;", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ArizonaDatabase extends RoomDatabase {
    private static volatile ArizonaDatabase instance;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public abstract FavoriteDAO favoriteDAO();

    public abstract LastPlayedDAO lastPlayedDAO();

    public abstract NotificationHistoryDAO notificationHistoryDAO();

    public abstract ServersDAO serversDAO();

    /* compiled from: ArizonaDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/data/database/ArizonaDatabase$Companion;", "", "<init>", "()V", "instance", "Lcom/arizona/launcher/data/database/ArizonaDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArizonaDatabase getInstance(Context context) {
            ArizonaDatabase arizonaDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            ArizonaDatabase arizonaDatabase2 = ArizonaDatabase.instance;
            if (arizonaDatabase2 == null) {
                synchronized (this) {
                    arizonaDatabase = ArizonaDatabase.instance;
                    if (arizonaDatabase == null) {
                        arizonaDatabase = new DatabaseModule().provideRideDatabase(context);
                        Companion companion = ArizonaDatabase.Companion;
                        ArizonaDatabase.instance = arizonaDatabase;
                    }
                }
                return arizonaDatabase;
            }
            return arizonaDatabase2;
        }
    }
}

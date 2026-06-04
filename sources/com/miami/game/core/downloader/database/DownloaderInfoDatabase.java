package com.miami.game.core.downloader.database;

import androidx.room.RoomDatabase;
import com.facebook.internal.NativeProtocol;
import com.miami.game.core.downloader.database.dao.DownloaderInfoDao;
import kotlin.Metadata;
/* compiled from: DownloaderInfoDatabase.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&Ê\u0001\u001a\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "downloaderInfoDao", "Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao;", "downloader-database", "Landroidx/room/Database;", "entities", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DownloaderInfoDatabase extends RoomDatabase {
    public abstract DownloaderInfoDao downloaderInfoDao();
}

package com.arizona.launcher.data.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
/* compiled from: ArizonaDatabase_Impl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00160\u0014H\u0014J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00150\u0018H\u0016J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u001a\u0010\u001c\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0015\u0012\u0004\u0012\u00020\u00190\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/arizona/launcher/data/database/ArizonaDatabase_Impl;", "Lcom/arizona/launcher/data/database/ArizonaDatabase;", "<init>", "()V", "_favoriteDAO", "Lkotlin/Lazy;", "Lcom/arizona/launcher/data/database/FavoriteDAO;", "_lastPlayedDAO", "Lcom/arizona/launcher/data/database/LastPlayedDAO;", "_notificationHistoryDAO", "Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "_serversDAO", "Lcom/arizona/launcher/data/database/ServersDAO;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "favoriteDAO", "lastPlayedDAO", "notificationHistoryDAO", "serversDAO", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArizonaDatabase_Impl extends ArizonaDatabase {
    public static final int $stable = 8;
    private final Lazy<FavoriteDAO> _favoriteDAO = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.data.database.ArizonaDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FavoriteDAO_Impl _favoriteDAO$lambda$0;
            _favoriteDAO$lambda$0 = ArizonaDatabase_Impl._favoriteDAO$lambda$0(ArizonaDatabase_Impl.this);
            return _favoriteDAO$lambda$0;
        }
    });
    private final Lazy<LastPlayedDAO> _lastPlayedDAO = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.data.database.ArizonaDatabase_Impl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LastPlayedDAO_Impl _lastPlayedDAO$lambda$1;
            _lastPlayedDAO$lambda$1 = ArizonaDatabase_Impl._lastPlayedDAO$lambda$1(ArizonaDatabase_Impl.this);
            return _lastPlayedDAO$lambda$1;
        }
    });
    private final Lazy<NotificationHistoryDAO> _notificationHistoryDAO = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.data.database.ArizonaDatabase_Impl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            NotificationHistoryDAO_Impl _notificationHistoryDAO$lambda$2;
            _notificationHistoryDAO$lambda$2 = ArizonaDatabase_Impl._notificationHistoryDAO$lambda$2(ArizonaDatabase_Impl.this);
            return _notificationHistoryDAO$lambda$2;
        }
    });
    private final Lazy<ServersDAO> _serversDAO = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.data.database.ArizonaDatabase_Impl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ServersDAO_Impl _serversDAO$lambda$3;
            _serversDAO$lambda$3 = ArizonaDatabase_Impl._serversDAO$lambda$3(ArizonaDatabase_Impl.this);
            return _serversDAO$lambda$3;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavoriteDAO_Impl _favoriteDAO$lambda$0(ArizonaDatabase_Impl arizonaDatabase_Impl) {
        return new FavoriteDAO_Impl(arizonaDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LastPlayedDAO_Impl _lastPlayedDAO$lambda$1(ArizonaDatabase_Impl arizonaDatabase_Impl) {
        return new LastPlayedDAO_Impl(arizonaDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationHistoryDAO_Impl _notificationHistoryDAO$lambda$2(ArizonaDatabase_Impl arizonaDatabase_Impl) {
        return new NotificationHistoryDAO_Impl(arizonaDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServersDAO_Impl _serversDAO$lambda$3(ArizonaDatabase_Impl arizonaDatabase_Impl) {
        return new ServersDAO_Impl(arizonaDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.arizona.launcher.data.database.ArizonaDatabase_Impl$createOpenDelegate$_openDelegate$1
            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(10, "1757368143a23aadc9fcae2a4d30d393", "745f98671a899f63a47d492150e1a90b");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `FavoriteServer` (`serverId` INTEGER NOT NULL, `serverType` TEXT NOT NULL, PRIMARY KEY(`serverId`, `serverType`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `lastplayed` (`serverId` INTEGER NOT NULL, `serverType` TEXT NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`serverId`, `serverType`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `notifications` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `isViewed` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `allservers` (`id` INTEGER NOT NULL, `address` TEXT NOT NULL, `port` INTEGER NOT NULL, `hasPassword` INTEGER NOT NULL, `currentPlayerCount` INTEGER NOT NULL, `maxPlayerCount` INTEGER NOT NULL, `serverName` TEXT NOT NULL, `tg` TEXT NOT NULL, `vk` TEXT NOT NULL, `inst` TEXT NOT NULL, `favorite` INTEGER NOT NULL, `serverType` TEXT NOT NULL, `ping` INTEGER NOT NULL, `plotPoints` TEXT NOT NULL, `serverIcon` TEXT NOT NULL, PRIMARY KEY(`address`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1757368143a23aadc9fcae2a4d30d393')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `FavoriteServer`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `lastplayed`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `notifications`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `allservers`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                ArizonaDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("serverId", new TableInfo.Column("serverId", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("serverType", new TableInfo.Column("serverType", "TEXT", true, 2, null, 1));
                TableInfo tableInfo = new TableInfo("FavoriteServer", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read = TableInfo.Companion.read(connection, "FavoriteServer");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(false, "FavoriteServer(com.arizona.launcher.model.servers.FavoriteServer).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("serverId", new TableInfo.Column("serverId", "INTEGER", true, 1, null, 1));
                linkedHashMap2.put("serverType", new TableInfo.Column("serverType", "TEXT", true, 2, null, 1));
                linkedHashMap2.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("lastplayed", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read2 = TableInfo.Companion.read(connection, "lastplayed");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "lastplayed(com.arizona.launcher.model.servers.LastPlayedServer).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap3.put("date", new TableInfo.Column("date", "INTEGER", false, 0, null, 1));
                linkedHashMap3.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, 1));
                linkedHashMap3.put("isViewed", new TableInfo.Column("isViewed", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("notifications", linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read3 = TableInfo.Companion.read(connection, "notifications");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenDelegate.ValidationResult(false, "notifications(com.arizona.launcher.model.servers.NotificationHistoryData).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("address", new TableInfo.Column("address", "TEXT", true, 1, null, 1));
                linkedHashMap4.put("port", new TableInfo.Column("port", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("hasPassword", new TableInfo.Column("hasPassword", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("currentPlayerCount", new TableInfo.Column("currentPlayerCount", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("maxPlayerCount", new TableInfo.Column("maxPlayerCount", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("serverName", new TableInfo.Column("serverName", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("tg", new TableInfo.Column("tg", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("vk", new TableInfo.Column("vk", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("inst", new TableInfo.Column("inst", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("serverType", new TableInfo.Column("serverType", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("ping", new TableInfo.Column("ping", "INTEGER", true, 0, null, 1));
                linkedHashMap4.put("plotPoints", new TableInfo.Column("plotPoints", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("serverIcon", new TableInfo.Column("serverIcon", "TEXT", true, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo("allservers", linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read4 = TableInfo.Companion.read(connection, "allservers");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "allservers(com.arizona.launcher.model.servers.ServerEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "FavoriteServer", "lastplayed", "notifications", "allservers");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "FavoriteServer", "lastplayed", "notifications", "allservers");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(FavoriteDAO.class), FavoriteDAO_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(LastPlayedDAO.class), LastPlayedDAO_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(NotificationHistoryDAO.class), NotificationHistoryDAO_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(ServersDAO.class), ServersDAO_Impl.Companion.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // com.arizona.launcher.data.database.ArizonaDatabase
    public FavoriteDAO favoriteDAO() {
        return this._favoriteDAO.getValue();
    }

    @Override // com.arizona.launcher.data.database.ArizonaDatabase
    public LastPlayedDAO lastPlayedDAO() {
        return this._lastPlayedDAO.getValue();
    }

    @Override // com.arizona.launcher.data.database.ArizonaDatabase
    public NotificationHistoryDAO notificationHistoryDAO() {
        return this._notificationHistoryDAO.getValue();
    }

    @Override // com.arizona.launcher.data.database.ArizonaDatabase
    public ServersDAO serversDAO() {
        return this._serversDAO.getValue();
    }
}

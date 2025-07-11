package com.miami.game.core.downloader.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.miami.game.core.downloader.database.dao.DownloaderInfoDao;
import com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl;
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
/* compiled from: DownloaderInfoDatabase_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase_Impl;", "Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;", "<init>", "()V", "_downloaderInfoDao", "Lkotlin/Lazy;", "Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "downloaderInfoDao", "downloader-database_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderInfoDatabase_Impl extends DownloaderInfoDatabase {
    private final Lazy<DownloaderInfoDao> _downloaderInfoDao = LazyKt.lazy(new Function0() { // from class: com.miami.game.core.downloader.database.DownloaderInfoDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloaderInfoDao_Impl _downloaderInfoDao$lambda$0;
            _downloaderInfoDao$lambda$0 = DownloaderInfoDatabase_Impl._downloaderInfoDao$lambda$0(DownloaderInfoDatabase_Impl.this);
            return _downloaderInfoDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloaderInfoDao_Impl _downloaderInfoDao$lambda$0(DownloaderInfoDatabase_Impl downloaderInfoDatabase_Impl) {
        return new DownloaderInfoDao_Impl(downloaderInfoDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.miami.game.core.downloader.database.DownloaderInfoDatabase_Impl$createOpenDelegate$_openDelegate$1
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
                super(1, "4f6a9bc76334610b30ebb0d0353fa698", "9a3016aab461b6e706003eee9e346241");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `downloader_info_table` (`id` INTEGER NOT NULL, `path` TEXT, `name_from_game_info_file` TEXT, `size_from_game_info_file` INTEGER, `hash_from_game_info_file` TEXT, `date_change_from_game_info_file` INTEGER, `gpu_type_from_game_info_file` TEXT, `is_completed_download` INTEGER NOT NULL, `download_start_at` INTEGER, `download_finish_at` INTEGER, `created_at` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4f6a9bc76334610b30ebb0d0353fa698')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `downloader_info_table`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DownloaderInfoDatabase_Impl.this.internalInitInvalidationTracker(connection);
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
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("path", new TableInfo.Column("path", "TEXT", false, 0, null, 1));
                linkedHashMap.put("name_from_game_info_file", new TableInfo.Column("name_from_game_info_file", "TEXT", false, 0, null, 1));
                linkedHashMap.put("size_from_game_info_file", new TableInfo.Column("size_from_game_info_file", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("hash_from_game_info_file", new TableInfo.Column("hash_from_game_info_file", "TEXT", false, 0, null, 1));
                linkedHashMap.put("date_change_from_game_info_file", new TableInfo.Column("date_change_from_game_info_file", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("gpu_type_from_game_info_file", new TableInfo.Column("gpu_type_from_game_info_file", "TEXT", false, 0, null, 1));
                linkedHashMap.put("is_completed_download", new TableInfo.Column("is_completed_download", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("download_start_at", new TableInfo.Column("download_start_at", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("download_finish_at", new TableInfo.Column("download_finish_at", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("downloader_info_table", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read = TableInfo.Companion.read(connection, "downloader_info_table");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(false, "downloader_info_table(com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "downloader_info_table");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "downloader_info_table");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(DownloaderInfoDao.class), DownloaderInfoDao_Impl.Companion.getRequiredConverters());
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

    @Override // com.miami.game.core.downloader.database.DownloaderInfoDatabase
    public DownloaderInfoDao downloaderInfoDao() {
        return this._downloaderInfoDao.getValue();
    }
}

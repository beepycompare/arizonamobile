package ru.mrlargha.commonui.domain.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import io.appmetrica.analytics.impl.L2;
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
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl;
/* compiled from: AppDatabase_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/domain/db/AppDatabase_Impl;", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "<init>", "()V", "_inventoryItemDao", "Lkotlin/Lazy;", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "inventoryItemDao", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private final Lazy<InventoryItemDao> _inventoryItemDao = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.domain.db.AppDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            InventoryItemDao_Impl _inventoryItemDao$lambda$0;
            _inventoryItemDao$lambda$0 = AppDatabase_Impl._inventoryItemDao$lambda$0(AppDatabase_Impl.this);
            return _inventoryItemDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final InventoryItemDao_Impl _inventoryItemDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new InventoryItemDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: ru.mrlargha.commonui.domain.db.AppDatabase_Impl$createOpenDelegate$_openDelegate$1
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
                super(6, "06906dd4fa91f0e3453da37e4ab2918b", "db9fb19d3b8fe7a1d5d1cfb24857aed6");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `InventoryItemEntity` (`slot` INTEGER NOT NULL, `item` INTEGER, `id` INTEGER NOT NULL, `text` TEXT, `item_type` INTEGER, `amount` INTEGER, `background` INTEGER, `color` INTEGER, `bits` INTEGER, `available` INTEGER, `enchant` INTEGER, `breaks` INTEGER, `isActive` INTEGER, `itemStrength` INTEGER, `blackout` INTEGER, `time` INTEGER, `acsSlot` INTEGER, `inventoryType` INTEGER NOT NULL, `isColored` INTEGER NOT NULL, `isLocked` INTEGER NOT NULL, PRIMARY KEY(`slot`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '06906dd4fa91f0e3453da37e4ab2918b')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `InventoryItemEntity`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
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
                linkedHashMap.put("slot", new TableInfo.Column("slot", "INTEGER", true, 1, null, 1));
                linkedHashMap.put("item", new TableInfo.Column("item", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("text", new TableInfo.Column("text", "TEXT", false, 0, null, 1));
                linkedHashMap.put("item_type", new TableInfo.Column("item_type", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("amount", new TableInfo.Column("amount", "INTEGER", false, 0, null, 1));
                linkedHashMap.put(L2.g, new TableInfo.Column(L2.g, "INTEGER", false, 0, null, 1));
                linkedHashMap.put("color", new TableInfo.Column("color", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("bits", new TableInfo.Column("bits", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("available", new TableInfo.Column("available", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("enchant", new TableInfo.Column("enchant", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("breaks", new TableInfo.Column("breaks", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("isActive", new TableInfo.Column("isActive", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("itemStrength", new TableInfo.Column("itemStrength", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("blackout", new TableInfo.Column("blackout", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("time", new TableInfo.Column("time", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("acsSlot", new TableInfo.Column("acsSlot", "INTEGER", false, 0, null, 1));
                linkedHashMap.put("inventoryType", new TableInfo.Column("inventoryType", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("isColored", new TableInfo.Column("isColored", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("isLocked", new TableInfo.Column("isLocked", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("InventoryItemEntity", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read = TableInfo.Companion.read(connection, "InventoryItemEntity");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(false, "InventoryItemEntity(ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "InventoryItemEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "InventoryItemEntity");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(InventoryItemDao.class), InventoryItemDao_Impl.Companion.getRequiredConverters());
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

    @Override // ru.mrlargha.commonui.domain.db.AppDatabase
    public InventoryItemDao inventoryItemDao() {
        return this._inventoryItemDao.getValue();
    }
}

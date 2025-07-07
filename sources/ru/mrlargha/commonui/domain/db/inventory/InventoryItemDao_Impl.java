package ru.mrlargha.commonui.domain.db.inventory;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import io.appmetrica.analytics.impl.L2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
/* compiled from: InventoryItemDao_Impl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0011H\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao_Impl;", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfInventoryItemEntity", "Landroidx/room/EntityInsertAdapter;", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "__updateAdapterOfInventoryItemEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertAll", "", "info", "(Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInfo", "getCollectInventoryList", "Lkotlinx/coroutines/flow/Flow;", "", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByItem", "item", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByItem", "deleteAllItems", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItemDao_Impl implements InventoryItemDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<InventoryItemEntity> __insertAdapterOfInventoryItemEntity;
    private final EntityDeleteOrUpdateAdapter<InventoryItemEntity> __updateAdapterOfInventoryItemEntity;

    public InventoryItemDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfInventoryItemEntity = new EntityInsertAdapter<InventoryItemEntity>() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `InventoryItemEntity` (`slot`,`item`,`id`,`text`,`item_type`,`amount`,`background`,`color`,`bits`,`available`,`enchant`,`breaks`,`isActive`,`itemStrength`,`blackout`,`time`,`acsSlot`,`inventoryType`,`isColored`,`isLocked`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, InventoryItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getSlot());
                Integer item = entity.getItem();
                if (item == null) {
                    statement.mo7568bindNull(2);
                } else {
                    statement.mo7567bindLong(2, item.intValue());
                }
                statement.mo7567bindLong(3, entity.getId());
                String text = entity.getText();
                if (text == null) {
                    statement.mo7568bindNull(4);
                } else {
                    statement.mo7569bindText(4, text);
                }
                Integer item_type = entity.getItem_type();
                if (item_type == null) {
                    statement.mo7568bindNull(5);
                } else {
                    statement.mo7567bindLong(5, item_type.intValue());
                }
                Integer amount = entity.getAmount();
                if (amount == null) {
                    statement.mo7568bindNull(6);
                } else {
                    statement.mo7567bindLong(6, amount.intValue());
                }
                Integer background = entity.getBackground();
                if (background == null) {
                    statement.mo7568bindNull(7);
                } else {
                    statement.mo7567bindLong(7, background.intValue());
                }
                Integer color = entity.getColor();
                if (color == null) {
                    statement.mo7568bindNull(8);
                } else {
                    statement.mo7567bindLong(8, color.intValue());
                }
                Integer bits = entity.getBits();
                if (bits == null) {
                    statement.mo7568bindNull(9);
                } else {
                    statement.mo7567bindLong(9, bits.intValue());
                }
                Integer available = entity.getAvailable();
                if (available == null) {
                    statement.mo7568bindNull(10);
                } else {
                    statement.mo7567bindLong(10, available.intValue());
                }
                Integer enchant = entity.getEnchant();
                if (enchant == null) {
                    statement.mo7568bindNull(11);
                } else {
                    statement.mo7567bindLong(11, enchant.intValue());
                }
                Integer breaks = entity.getBreaks();
                if (breaks == null) {
                    statement.mo7568bindNull(12);
                } else {
                    statement.mo7567bindLong(12, breaks.intValue());
                }
                Integer isActive = entity.isActive();
                if (isActive == null) {
                    statement.mo7568bindNull(13);
                } else {
                    statement.mo7567bindLong(13, isActive.intValue());
                }
                Integer itemStrength = entity.getItemStrength();
                if (itemStrength == null) {
                    statement.mo7568bindNull(14);
                } else {
                    statement.mo7567bindLong(14, itemStrength.intValue());
                }
                Integer blackout = entity.getBlackout();
                if (blackout == null) {
                    statement.mo7568bindNull(15);
                } else {
                    statement.mo7567bindLong(15, blackout.intValue());
                }
                Long time = entity.getTime();
                if (time == null) {
                    statement.mo7568bindNull(16);
                } else {
                    statement.mo7567bindLong(16, time.longValue());
                }
                Integer acsSlot = entity.getAcsSlot();
                if (acsSlot == null) {
                    statement.mo7568bindNull(17);
                } else {
                    statement.mo7567bindLong(17, acsSlot.intValue());
                }
                statement.mo7567bindLong(18, entity.getInventoryType());
                statement.mo7567bindLong(19, entity.isColored() ? 1L : 0L);
                statement.mo7567bindLong(20, entity.isLocked() ? 1L : 0L);
            }
        };
        this.__updateAdapterOfInventoryItemEntity = new EntityDeleteOrUpdateAdapter<InventoryItemEntity>() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `InventoryItemEntity` SET `slot` = ?,`item` = ?,`id` = ?,`text` = ?,`item_type` = ?,`amount` = ?,`background` = ?,`color` = ?,`bits` = ?,`available` = ?,`enchant` = ?,`breaks` = ?,`isActive` = ?,`itemStrength` = ?,`blackout` = ?,`time` = ?,`acsSlot` = ?,`inventoryType` = ?,`isColored` = ?,`isLocked` = ? WHERE `slot` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, InventoryItemEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getSlot());
                Integer item = entity.getItem();
                if (item == null) {
                    statement.mo7568bindNull(2);
                } else {
                    statement.mo7567bindLong(2, item.intValue());
                }
                statement.mo7567bindLong(3, entity.getId());
                String text = entity.getText();
                if (text == null) {
                    statement.mo7568bindNull(4);
                } else {
                    statement.mo7569bindText(4, text);
                }
                Integer item_type = entity.getItem_type();
                if (item_type == null) {
                    statement.mo7568bindNull(5);
                } else {
                    statement.mo7567bindLong(5, item_type.intValue());
                }
                Integer amount = entity.getAmount();
                if (amount == null) {
                    statement.mo7568bindNull(6);
                } else {
                    statement.mo7567bindLong(6, amount.intValue());
                }
                Integer background = entity.getBackground();
                if (background == null) {
                    statement.mo7568bindNull(7);
                } else {
                    statement.mo7567bindLong(7, background.intValue());
                }
                Integer color = entity.getColor();
                if (color == null) {
                    statement.mo7568bindNull(8);
                } else {
                    statement.mo7567bindLong(8, color.intValue());
                }
                Integer bits = entity.getBits();
                if (bits == null) {
                    statement.mo7568bindNull(9);
                } else {
                    statement.mo7567bindLong(9, bits.intValue());
                }
                Integer available = entity.getAvailable();
                if (available == null) {
                    statement.mo7568bindNull(10);
                } else {
                    statement.mo7567bindLong(10, available.intValue());
                }
                Integer enchant = entity.getEnchant();
                if (enchant == null) {
                    statement.mo7568bindNull(11);
                } else {
                    statement.mo7567bindLong(11, enchant.intValue());
                }
                Integer breaks = entity.getBreaks();
                if (breaks == null) {
                    statement.mo7568bindNull(12);
                } else {
                    statement.mo7567bindLong(12, breaks.intValue());
                }
                Integer isActive = entity.isActive();
                if (isActive == null) {
                    statement.mo7568bindNull(13);
                } else {
                    statement.mo7567bindLong(13, isActive.intValue());
                }
                Integer itemStrength = entity.getItemStrength();
                if (itemStrength == null) {
                    statement.mo7568bindNull(14);
                } else {
                    statement.mo7567bindLong(14, itemStrength.intValue());
                }
                Integer blackout = entity.getBlackout();
                if (blackout == null) {
                    statement.mo7568bindNull(15);
                } else {
                    statement.mo7567bindLong(15, blackout.intValue());
                }
                Long time = entity.getTime();
                if (time == null) {
                    statement.mo7568bindNull(16);
                } else {
                    statement.mo7567bindLong(16, time.longValue());
                }
                Integer acsSlot = entity.getAcsSlot();
                if (acsSlot == null) {
                    statement.mo7568bindNull(17);
                } else {
                    statement.mo7567bindLong(17, acsSlot.intValue());
                }
                statement.mo7567bindLong(18, entity.getInventoryType());
                statement.mo7567bindLong(19, entity.isColored() ? 1L : 0L);
                statement.mo7567bindLong(20, entity.isLocked() ? 1L : 0L);
                statement.mo7567bindLong(21, entity.getSlot());
            }
        };
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public Object insertAll(final InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit insertAll$lambda$0;
                insertAll$lambda$0 = InventoryItemDao_Impl.insertAll$lambda$0(InventoryItemDao_Impl.this, inventoryItemEntity, (SQLiteConnection) obj);
                return insertAll$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertAll$lambda$0(InventoryItemDao_Impl inventoryItemDao_Impl, InventoryItemEntity inventoryItemEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        inventoryItemDao_Impl.__insertAdapterOfInventoryItemEntity.insert(_connection, (SQLiteConnection) inventoryItemEntity);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public Object updateInfo(final InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit updateInfo$lambda$1;
                updateInfo$lambda$1 = InventoryItemDao_Impl.updateInfo$lambda$1(InventoryItemDao_Impl.this, inventoryItemEntity, (SQLiteConnection) obj);
                return updateInfo$lambda$1;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateInfo$lambda$1(InventoryItemDao_Impl inventoryItemDao_Impl, InventoryItemEntity inventoryItemEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        inventoryItemDao_Impl.__updateAdapterOfInventoryItemEntity.handle(_connection, inventoryItemEntity);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public Flow<List<InventoryItemEntity>> getCollectInventoryList() {
        return FlowUtil.createFlow(this.__db, false, new String[]{"inventoryitementity"}, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List collectInventoryList$lambda$2;
                collectInventoryList$lambda$2 = InventoryItemDao_Impl.getCollectInventoryList$lambda$2(r1, (SQLiteConnection) obj);
                return collectInventoryList$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getCollectInventoryList$lambda$2(String str, SQLiteConnection _connection) {
        int i;
        Integer valueOf;
        int i2;
        int i3;
        Integer valueOf2;
        int i4;
        Integer valueOf3;
        int i5;
        Integer valueOf4;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "slot");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "text");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item_type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "amount");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, L2.g);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "color");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "bits");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "available");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "enchant");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "breaks");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isActive");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "itemStrength");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "blackout");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "acsSlot");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "inventoryType");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isColored");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLocked");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i8 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i9 = (int) prepare.getLong(columnIndexOrThrow);
                Integer num = null;
                if (prepare.isNull(columnIndexOrThrow2)) {
                    i = i9;
                    valueOf = null;
                } else {
                    i = i9;
                    valueOf = Integer.valueOf((int) prepare.getLong(columnIndexOrThrow2));
                }
                int i10 = (int) prepare.getLong(columnIndexOrThrow3);
                String text = prepare.isNull(columnIndexOrThrow4) ? null : prepare.getText(columnIndexOrThrow4);
                if (prepare.isNull(columnIndexOrThrow5)) {
                    i2 = columnIndexOrThrow2;
                    i3 = columnIndexOrThrow3;
                    valueOf2 = null;
                } else {
                    i2 = columnIndexOrThrow2;
                    i3 = columnIndexOrThrow3;
                    valueOf2 = Integer.valueOf((int) prepare.getLong(columnIndexOrThrow5));
                }
                Integer valueOf5 = prepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow6));
                Integer valueOf6 = prepare.isNull(columnIndexOrThrow7) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow7));
                Integer valueOf7 = prepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow8));
                Integer valueOf8 = prepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow9));
                Integer valueOf9 = prepare.isNull(columnIndexOrThrow10) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow10));
                Integer valueOf10 = prepare.isNull(columnIndexOrThrow11) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow11));
                Integer valueOf11 = prepare.isNull(columnIndexOrThrow12) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow12));
                Integer valueOf12 = prepare.isNull(columnIndexOrThrow13) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow13));
                if (prepare.isNull(i8)) {
                    i4 = columnIndexOrThrow4;
                    valueOf3 = null;
                } else {
                    i4 = columnIndexOrThrow4;
                    valueOf3 = Integer.valueOf((int) prepare.getLong(i8));
                }
                int i11 = columnIndexOrThrow15;
                if (prepare.isNull(i11)) {
                    i5 = columnIndexOrThrow5;
                    valueOf4 = null;
                } else {
                    i5 = columnIndexOrThrow5;
                    valueOf4 = Integer.valueOf((int) prepare.getLong(i11));
                }
                int i12 = columnIndexOrThrow16;
                Long valueOf13 = prepare.isNull(i12) ? null : Long.valueOf(prepare.getLong(i12));
                int i13 = columnIndexOrThrow17;
                if (prepare.isNull(i13)) {
                    i6 = i8;
                    i7 = i11;
                } else {
                    i6 = i8;
                    i7 = i11;
                    num = Integer.valueOf((int) prepare.getLong(i13));
                }
                int i14 = columnIndexOrThrow18;
                Integer num2 = num;
                int i15 = (int) prepare.getLong(i14);
                int i16 = columnIndexOrThrow19;
                int i17 = columnIndexOrThrow20;
                arrayList2.add(new InventoryItemEntity(i, valueOf, i10, text, valueOf2, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, valueOf3, valueOf4, valueOf13, num2, i15, ((int) prepare.getLong(i16)) != 0, ((int) prepare.getLong(i17)) != 0));
                columnIndexOrThrow14 = i6;
                columnIndexOrThrow3 = i3;
                columnIndexOrThrow17 = i13;
                columnIndexOrThrow5 = i5;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i12;
                columnIndexOrThrow18 = i14;
                columnIndexOrThrow19 = i16;
                columnIndexOrThrow20 = i17;
                columnIndexOrThrow2 = i2;
                arrayList = arrayList2;
                columnIndexOrThrow4 = i4;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public Object getAll(Continuation<? super List<InventoryItemEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List all$lambda$3;
                all$lambda$3 = InventoryItemDao_Impl.getAll$lambda$3(r1, (SQLiteConnection) obj);
                return all$lambda$3;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAll$lambda$3(String str, SQLiteConnection _connection) {
        int i;
        Integer valueOf;
        int i2;
        int i3;
        Integer valueOf2;
        int i4;
        Integer valueOf3;
        int i5;
        Integer valueOf4;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "slot");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "text");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item_type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "amount");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, L2.g);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "color");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "bits");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "available");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "enchant");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "breaks");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isActive");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "itemStrength");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "blackout");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "acsSlot");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "inventoryType");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isColored");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLocked");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i8 = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i9 = (int) prepare.getLong(columnIndexOrThrow);
                Integer num = null;
                if (prepare.isNull(columnIndexOrThrow2)) {
                    i = i9;
                    valueOf = null;
                } else {
                    i = i9;
                    valueOf = Integer.valueOf((int) prepare.getLong(columnIndexOrThrow2));
                }
                int i10 = (int) prepare.getLong(columnIndexOrThrow3);
                String text = prepare.isNull(columnIndexOrThrow4) ? null : prepare.getText(columnIndexOrThrow4);
                if (prepare.isNull(columnIndexOrThrow5)) {
                    i2 = columnIndexOrThrow2;
                    i3 = columnIndexOrThrow3;
                    valueOf2 = null;
                } else {
                    i2 = columnIndexOrThrow2;
                    i3 = columnIndexOrThrow3;
                    valueOf2 = Integer.valueOf((int) prepare.getLong(columnIndexOrThrow5));
                }
                Integer valueOf5 = prepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow6));
                Integer valueOf6 = prepare.isNull(columnIndexOrThrow7) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow7));
                Integer valueOf7 = prepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow8));
                Integer valueOf8 = prepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow9));
                Integer valueOf9 = prepare.isNull(columnIndexOrThrow10) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow10));
                Integer valueOf10 = prepare.isNull(columnIndexOrThrow11) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow11));
                Integer valueOf11 = prepare.isNull(columnIndexOrThrow12) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow12));
                Integer valueOf12 = prepare.isNull(columnIndexOrThrow13) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow13));
                if (prepare.isNull(i8)) {
                    i4 = columnIndexOrThrow4;
                    valueOf3 = null;
                } else {
                    i4 = columnIndexOrThrow4;
                    valueOf3 = Integer.valueOf((int) prepare.getLong(i8));
                }
                int i11 = columnIndexOrThrow15;
                if (prepare.isNull(i11)) {
                    i5 = columnIndexOrThrow5;
                    valueOf4 = null;
                } else {
                    i5 = columnIndexOrThrow5;
                    valueOf4 = Integer.valueOf((int) prepare.getLong(i11));
                }
                int i12 = columnIndexOrThrow16;
                Long valueOf13 = prepare.isNull(i12) ? null : Long.valueOf(prepare.getLong(i12));
                int i13 = columnIndexOrThrow17;
                if (prepare.isNull(i13)) {
                    i6 = i8;
                    i7 = i11;
                } else {
                    i6 = i8;
                    i7 = i11;
                    num = Integer.valueOf((int) prepare.getLong(i13));
                }
                int i14 = columnIndexOrThrow18;
                Integer num2 = num;
                int i15 = (int) prepare.getLong(i14);
                int i16 = columnIndexOrThrow19;
                int i17 = columnIndexOrThrow20;
                arrayList2.add(new InventoryItemEntity(i, valueOf, i10, text, valueOf2, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, valueOf3, valueOf4, valueOf13, num2, i15, ((int) prepare.getLong(i16)) != 0, ((int) prepare.getLong(i17)) != 0));
                columnIndexOrThrow14 = i6;
                columnIndexOrThrow3 = i3;
                columnIndexOrThrow17 = i13;
                columnIndexOrThrow5 = i5;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i12;
                columnIndexOrThrow18 = i14;
                columnIndexOrThrow19 = i16;
                columnIndexOrThrow20 = i17;
                columnIndexOrThrow2 = i2;
                arrayList = arrayList2;
                columnIndexOrThrow4 = i4;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public Object findByItem(final int i, Continuation<? super InventoryItemEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                InventoryItemEntity findByItem$lambda$4;
                findByItem$lambda$4 = InventoryItemDao_Impl.findByItem$lambda$4(r1, i, (SQLiteConnection) obj);
                return findByItem$lambda$4;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InventoryItemEntity findByItem$lambda$4(String str, int i, SQLiteConnection _connection) {
        int i2;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo7567bindLong(1, i);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "slot");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "text");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "item_type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "amount");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, L2.g);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "color");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "bits");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "available");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "enchant");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "breaks");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isActive");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "itemStrength");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "blackout");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "acsSlot");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "inventoryType");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isColored");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isLocked");
            if (prepare.step()) {
                int i3 = (int) prepare.getLong(columnIndexOrThrow);
                if (prepare.isNull(columnIndexOrThrow2)) {
                    i2 = i3;
                    valueOf = null;
                } else {
                    i2 = i3;
                    valueOf = Integer.valueOf((int) prepare.getLong(columnIndexOrThrow2));
                }
                return new InventoryItemEntity(i2, valueOf, (int) prepare.getLong(columnIndexOrThrow3), prepare.isNull(columnIndexOrThrow4) ? null : prepare.getText(columnIndexOrThrow4), prepare.isNull(columnIndexOrThrow5) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow5)), prepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow6)), prepare.isNull(columnIndexOrThrow7) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow7)), prepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow8)), prepare.isNull(columnIndexOrThrow9) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow9)), prepare.isNull(columnIndexOrThrow10) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow10)), prepare.isNull(columnIndexOrThrow11) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow11)), prepare.isNull(columnIndexOrThrow12) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow12)), prepare.isNull(columnIndexOrThrow13) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow13)), prepare.isNull(columnIndexOrThrow14) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow14)), prepare.isNull(columnIndexOrThrow15) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow15)), prepare.isNull(columnIndexOrThrow16) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow16)), prepare.isNull(columnIndexOrThrow17) ? null : Integer.valueOf((int) prepare.getLong(columnIndexOrThrow17)), (int) prepare.getLong(columnIndexOrThrow18), ((int) prepare.getLong(columnIndexOrThrow19)) != 0, ((int) prepare.getLong(columnIndexOrThrow20)) != 0);
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity>.".toString());
        } finally {
            prepare.close();
        }
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public void deleteByItem(final int i) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit deleteByItem$lambda$5;
                deleteByItem$lambda$5 = InventoryItemDao_Impl.deleteByItem$lambda$5(r1, i, (SQLiteConnection) obj);
                return deleteByItem$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteByItem$lambda$5(String str, int i, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo7567bindLong(1, i);
            prepare.step();
            prepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    @Override // ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao
    public void deleteAllItems() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit deleteAllItems$lambda$6;
                deleteAllItems$lambda$6 = InventoryItemDao_Impl.deleteAllItems$lambda$6(r1, (SQLiteConnection) obj);
                return deleteAllItems$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllItems$lambda$6(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* compiled from: InventoryItemDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}

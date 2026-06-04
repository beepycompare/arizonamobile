package ru.mrlargha.commonui.domain.db.inventory;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: InventoryItemDao.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bJ\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u000eJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H§@b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH'b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0017J\u0016\u0010\u0018\u001a\u00020\u0011H'b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0019J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H§@b\u0002\b\u001b¢\u0006\u0002\u0010\u0013Ê\u0001\u0002\b\u001d¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao;", "", "getCollectInventoryList", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "Landroidx/room/Query;", "value", "SELECT * FROM inventoryitementity", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByItem", "item", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SELECT * FROM inventoryitementity WHERE item LIKE :item", "insertAll", "", "info", "(Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Insert;", "onConflict", "deleteByItem", "DELETE FROM inventoryitementity WHERE item = :item", "deleteAllItems", "DELETE FROM inventoryitementity", "updateInfo", "Landroidx/room/Update;", "CommonUI", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface InventoryItemDao {
    void deleteAllItems();

    void deleteByItem(int i);

    Object findByItem(int i, Continuation<? super InventoryItemEntity> continuation);

    Object getAll(Continuation<? super List<InventoryItemEntity>> continuation);

    Flow<List<InventoryItemEntity>> getCollectInventoryList();

    Object insertAll(InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation);

    Object updateInfo(InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation);
}

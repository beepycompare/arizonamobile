package ru.mrlargha.commonui.domain.db.inventory;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: InventoryItemDao.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH'J\b\u0010\u0011\u001a\u00020\rH'J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000f¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao;", "", "getCollectInventoryList", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByItem", "item", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "", "info", "(Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByItem", "deleteAllItems", "updateInfo", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InventoryItemDao {
    void deleteAllItems();

    void deleteByItem(int i);

    Object findByItem(int i, Continuation<? super InventoryItemEntity> continuation);

    Object getAll(Continuation<? super List<InventoryItemEntity>> continuation);

    Flow<List<InventoryItemEntity>> getCollectInventoryList();

    Object insertAll(InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation);

    Object updateInfo(InventoryItemEntity inventoryItemEntity, Continuation<? super Unit> continuation);
}

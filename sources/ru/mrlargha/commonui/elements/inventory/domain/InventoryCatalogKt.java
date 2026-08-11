package ru.mrlargha.commonui.elements.inventory.domain;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ItemsInfo;
/* compiled from: InventoryCatalog.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DEFAULT_INVENTORY_CATALOG", "", "ARIZONA_INVENTORY_CATALOG", "EMPTY_INVENTORY_CATALOG_ITEM", "Lru/mrlargha/commonui/utils/ItemsInfo;", "inventoryCatalogKey", "isArizona", "", "normalizeInventoryCatalog", "", "items", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryCatalogKt {
    private static final String ARIZONA_INVENTORY_CATALOG = "inventory_items_bb26";
    private static final String DEFAULT_INVENTORY_CATALOG = "inventory_items";
    private static final ItemsInfo EMPTY_INVENTORY_CATALOG_ITEM = new ItemsInfo(-1, "", "", -1, -1, 0, null, null, null, null, 512, null);

    public static final String inventoryCatalogKey(boolean z) {
        return z ? ARIZONA_INVENTORY_CATALOG : DEFAULT_INVENTORY_CATALOG;
    }

    public static final List<ItemsInfo> normalizeInventoryCatalog(List<ItemsInfo> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        List<ItemsInfo> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ItemsInfo itemsInfo : list) {
            if (itemsInfo == null) {
                itemsInfo = EMPTY_INVENTORY_CATALOG_ITEM;
            }
            arrayList.add(itemsInfo);
        }
        return arrayList;
    }
}

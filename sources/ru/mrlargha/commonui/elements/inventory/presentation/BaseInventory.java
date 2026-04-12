package ru.mrlargha.commonui.elements.inventory.presentation;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.AccessPagesModel;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.SubInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.UpgradesInventoryAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: BaseInventory.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b&\u0018\u0000 @2\u00020\u0001:\u0001@B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0016J*\u0010\u001f\u001a\u0002052\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001092\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000109J\b\u0010;\u001a\u000205H\u0004J$\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001092\u0006\u0010=\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001209J*\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001209092\u0006\u0010=\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001209H\u0002R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0012\u0010,\u001a\u00020-X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u000201X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006A"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "subAccessoriesList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getSubAccessoriesList", "()Ljava/util/List;", "setSubAccessoriesList", "(Ljava/util/List;)V", "subUpgradesList", "getSubUpgradesList", "setSubUpgradesList", "walletInventoryList", "getWalletInventoryList", "setWalletInventoryList", "subCaseArmorSkinList", "getSubCaseArmorSkinList", "setSubCaseArmorSkinList", "subSkinList", "getSubSkinList", "setSubSkinList", "subCaseArmorList", "getSubCaseArmorList", "setSubCaseArmorList", "accessoriesInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "getAccessoriesInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "upgradesInventoryAdapter", "getUpgradesInventoryAdapter", "walletInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "getWalletInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "subInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "getSubInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "sendData", "", "fromItem", "toItem", "caseArmorList", "", "skinList", "setCurrentCaseArmorSkinListArizona", "getCurrentSectionList", "itemCount", "list", "sectionSeparation", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BaseInventory extends SAMPUIElement {
    private static AccessPagesModel accessPages;
    private final Context context;
    private List<InventoryItem> subAccessoriesList;
    private List<InventoryItem> subCaseArmorList;
    private List<InventoryItem> subCaseArmorSkinList;
    private List<InventoryItem> subSkinList;
    private List<InventoryItem> subUpgradesList;
    private List<InventoryItem> walletInventoryList;
    public static final Companion Companion = new Companion(null);
    private static int currentBackendId = UIElementID.INVENTORY.getId();

    public abstract UpgradesInventoryAdapter getAccessoriesInventoryAdapter();

    public abstract SubInventoryAdapter getSubInventoryAdapter();

    public abstract UpgradesInventoryAdapter getUpgradesInventoryAdapter();

    public abstract MainInventoryAdapter getWalletInventoryAdapter();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInventory(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Context applicationContext = targetActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        this.subAccessoriesList = new ArrayList();
        this.subUpgradesList = new ArrayList();
        this.walletInventoryList = new ArrayList();
        this.subCaseArmorSkinList = new ArrayList();
        this.subSkinList = new ArrayList();
        this.subCaseArmorList = new ArrayList();
    }

    /* compiled from: BaseInventory.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory$Companion;", "", "<init>", "()V", "currentBackendId", "", "getCurrentBackendId", "()I", "setCurrentBackendId", "(I)V", "accessPages", "Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;", "getAccessPages", "()Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;", "setAccessPages", "(Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;)V", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCurrentBackendId() {
            return BaseInventory.currentBackendId;
        }

        public final void setCurrentBackendId(int i) {
            BaseInventory.currentBackendId = i;
        }

        public final AccessPagesModel getAccessPages() {
            return BaseInventory.accessPages;
        }

        public final void setAccessPages(AccessPagesModel accessPagesModel) {
            BaseInventory.accessPages = accessPagesModel;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public IBackendNotifier getNotifier() {
        return super.getNotifier();
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<InventoryItem> getSubAccessoriesList() {
        return this.subAccessoriesList;
    }

    public final void setSubAccessoriesList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subAccessoriesList = list;
    }

    public final List<InventoryItem> getSubUpgradesList() {
        return this.subUpgradesList;
    }

    public final void setSubUpgradesList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subUpgradesList = list;
    }

    public final List<InventoryItem> getWalletInventoryList() {
        return this.walletInventoryList;
    }

    public final void setWalletInventoryList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.walletInventoryList = list;
    }

    public final List<InventoryItem> getSubCaseArmorSkinList() {
        return this.subCaseArmorSkinList;
    }

    public final void setSubCaseArmorSkinList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subCaseArmorSkinList = list;
    }

    public final List<InventoryItem> getSubSkinList() {
        return this.subSkinList;
    }

    public final void setSubSkinList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subSkinList = list;
    }

    public final List<InventoryItem> getSubCaseArmorList() {
        return this.subCaseArmorList;
    }

    public final void setSubCaseArmorList(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subCaseArmorList = list;
    }

    public void sendData(InventoryItem fromItem, InventoryItem toItem) {
        long j;
        int slot;
        int slot2;
        int page;
        Intrinsics.checkNotNullParameter(fromItem, "fromItem");
        Intrinsics.checkNotNullParameter(toItem, "toItem");
        if (fromItem.getAmount() != null) {
            Long amount = fromItem.getAmount();
            j = amount != null ? amount.longValue() : 0L;
        } else {
            j = 1;
        }
        long j2 = j;
        if (fromItem.getSlot() == toItem.getSlot() && fromItem.getInventoryType() == toItem.getInventoryType()) {
            Log.d("TAG_SEND", "EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "backendID: " + currentBackendId + " ====== from : " + fromItem + " ===== toItem : " + toItem);
        if (toItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ATTACH.getId()) {
            AccessPagesModel accessPagesModel = accessPages;
            if (accessPagesModel == null) {
                accessPagesModel = new AccessPagesModel(3, 1);
            }
            slot2 = toItem.getSlot();
            page = (accessPagesModel.getPage() - 1) * 6;
        } else if (toItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_IMPROV.getId()) {
            AccessPagesModel accessPagesModel2 = accessPages;
            if (accessPagesModel2 == null) {
                accessPagesModel2 = new AccessPagesModel(3, 1);
            }
            slot2 = toItem.getSlot();
            page = (accessPagesModel2.getPage() - 1) * 2;
        } else if (toItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_SKIN.getId()) {
            AccessPagesModel accessPagesModel3 = accessPages;
            if (accessPagesModel3 == null) {
                accessPagesModel3 = new AccessPagesModel(3, 1);
            }
            slot2 = toItem.getSlot();
            page = accessPagesModel3.getPage() - 1;
        } else {
            slot = toItem.getSlot();
            IBackendNotifier notifier = getNotifier();
            int i = currentBackendId;
            byte[] bytes = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(fromItem.getSlot(), fromItem.getInventoryType(), j2, fromItem.getId()), new ChangeToSlot(slot, toItem.getInventoryType()))).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            notifier.clickedWrapper(i, -1, 1, bytes);
        }
        slot = slot2 + page;
        IBackendNotifier notifier2 = getNotifier();
        int i2 = currentBackendId;
        byte[] bytes2 = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(fromItem.getSlot(), fromItem.getInventoryType(), j2, fromItem.getId()), new ChangeToSlot(slot, toItem.getInventoryType()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        notifier2.clickedWrapper(i2, -1, 1, bytes2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setSubCaseArmorSkinList$default(BaseInventory baseInventory, List list, List list2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSubCaseArmorSkinList");
        }
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            list2 = null;
        }
        baseInventory.setSubCaseArmorSkinList(list, list2);
    }

    public final void setSubCaseArmorSkinList(List<InventoryItem> list, List<InventoryItem> list2) {
        Log.e("person_section", "initSub: " + list + ", " + list2);
        if (list != null) {
            this.subCaseArmorList = CollectionsKt.toMutableList((Collection) list);
        }
        if (list2 != null) {
            this.subSkinList = CollectionsKt.toMutableList((Collection) list2);
        }
        setCurrentCaseArmorSkinListArizona();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setCurrentCaseArmorSkinListArizona() {
        List<InventoryItem> currentSectionList = getCurrentSectionList(2, this.subCaseArmorList);
        List<InventoryItem> currentSectionList2 = getCurrentSectionList(1, this.subSkinList);
        if (currentSectionList == null || currentSectionList2 == null) {
            return;
        }
        int size = currentSectionList.size();
        Log.i("person_section", "initSub: " + size + ", " + currentSectionList2.size());
        this.subCaseArmorSkinList.clear();
        this.subCaseArmorSkinList.add(CollectionsKt.first((List<? extends Object>) currentSectionList));
        this.subCaseArmorSkinList.add(CollectionsKt.first((List<? extends Object>) currentSectionList2));
        this.subCaseArmorSkinList.add(CollectionsKt.last((List<? extends Object>) currentSectionList));
    }

    public final List<InventoryItem> getCurrentSectionList(int i, List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<List<InventoryItem>> sectionSeparation = sectionSeparation(i, list);
        AccessPagesModel accessPagesModel = accessPages;
        return (List) CollectionsKt.getOrNull(sectionSeparation, (accessPagesModel != null ? accessPagesModel.getPage() : 1) - 1);
    }

    private final List<List<InventoryItem>> sectionSeparation(int i, List<InventoryItem> list) {
        if (i <= 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(((list.size() + i) - 1) / i);
        int i2 = 0;
        while (i2 < list.size()) {
            int min = Math.min(i2 + i, list.size());
            arrayList.add(list.subList(i2, min));
            i2 = min;
        }
        return arrayList;
    }
}

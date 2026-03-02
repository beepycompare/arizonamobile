package ru.mrlargha.commonui.elements.inventory.presentation.section.person_section;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.InventoryPersonSectionBinding;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryEditResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.AccessPagesModel;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.BaseInventory;
import ru.mrlargha.commonui.elements.inventory.presentation.BlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: InventoryPersonSection.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0006\u0010)\u001a\u00020\u0011J\b\u0010*\u001a\u00020\u0011H\u0002J\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/section/person_section/InventoryPersonSection;", "", "inventory", "Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory;", "binding", "Lru/mrlargha/commonui/databinding/InventoryPersonSectionBinding;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory;Lru/mrlargha/commonui/databinding/InventoryPersonSectionBinding;)V", "getInventory", "()Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory;", "getBinding", "()Lru/mrlargha/commonui/databinding/InventoryPersonSectionBinding;", "currentPersonType", "Lru/mrlargha/commonui/elements/inventory/presentation/section/person_section/InventoryPersonType;", "currentPage", "", "setupListeners", "", "initAdapters", "initSub", "list", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "accessoriesNotVisible", "accessoriesVisible", "btnAccessoriesPressed", "setPageNumber", "updateSet", "updateAccessories", "newResponse", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryEditResponse;", "changeAccessoriesItem", "item", "isColorItem", "", "upgradesNotVisible", "upgradesVisible", "btnUpgradesPressed", "walletNotVisible", "walletVisible", "btnWalletPressed", "openFishing", "setPersonTypeVisible", "defaultPersonSection", "refresh", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryPersonSection {
    private final InventoryPersonSectionBinding binding;
    private int currentPage;
    private InventoryPersonType currentPersonType;
    private final BaseInventory inventory;

    private final void initAdapters() {
    }

    public InventoryPersonSection(BaseInventory inventory, InventoryPersonSectionBinding binding) {
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.inventory = inventory;
        this.binding = binding;
        this.currentPersonType = InventoryPersonType.NONE;
        AccessPagesModel accessPages = BaseInventory.Companion.getAccessPages();
        this.currentPage = accessPages != null ? accessPages.getPage() : 1;
        setupListeners();
        initAdapters();
    }

    public final BaseInventory getInventory() {
        return this.inventory;
    }

    public final InventoryPersonSectionBinding getBinding() {
        return this.binding;
    }

    private final void setupListeners() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        inventoryPersonSectionBinding.btnAccessories.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryPersonSection.setupListeners$lambda$0$0(InventoryPersonSection.this, view);
            }
        });
        inventoryPersonSectionBinding.btnUpgrades.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryPersonSection.setupListeners$lambda$0$1(InventoryPersonSection.this, view);
            }
        });
        inventoryPersonSectionBinding.btnWallet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryPersonSection.setupListeners$lambda$0$2(InventoryPersonSection.this, view);
            }
        });
        inventoryPersonSectionBinding.btnSetLeft.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryPersonSection.setupListeners$lambda$0$3(InventoryPersonSection.this, view);
            }
        });
        inventoryPersonSectionBinding.btnSetRight.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryPersonSection.setupListeners$lambda$0$4(InventoryPersonSection.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(InventoryPersonSection inventoryPersonSection, View view) {
        if (inventoryPersonSection.currentPersonType == InventoryPersonType.ACCESSORIES) {
            inventoryPersonSection.accessoriesNotVisible();
        } else {
            inventoryPersonSection.accessoriesVisible();
        }
        inventoryPersonSection.setPersonTypeVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(InventoryPersonSection inventoryPersonSection, View view) {
        if (inventoryPersonSection.currentPersonType == InventoryPersonType.UPGRADES) {
            inventoryPersonSection.upgradesNotVisible();
        } else {
            inventoryPersonSection.upgradesVisible();
        }
        inventoryPersonSection.setPersonTypeVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(InventoryPersonSection inventoryPersonSection, View view) {
        if (inventoryPersonSection.currentPersonType == InventoryPersonType.WALLET) {
            inventoryPersonSection.walletNotVisible();
        } else {
            inventoryPersonSection.walletVisible();
        }
        inventoryPersonSection.setPersonTypeVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(InventoryPersonSection inventoryPersonSection, View view) {
        int i = inventoryPersonSection.currentPage;
        if (i > 1) {
            inventoryPersonSection.inventory.notifyClick(0, 8, String.valueOf(i - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(InventoryPersonSection inventoryPersonSection, View view) {
        AccessPagesModel accessPages = BaseInventory.Companion.getAccessPages();
        if (accessPages == null || inventoryPersonSection.currentPage >= accessPages.getTotal()) {
            return;
        }
        inventoryPersonSection.inventory.notifyClick(0, 8, String.valueOf(inventoryPersonSection.currentPage + 1));
    }

    public final void initSub(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Log.d("person_section", "setAdapterList: " + this.inventory.getSubCaseArmorSkinList().size());
        this.inventory.getSubInventoryAdapter().submitList(CollectionsKt.toList(this.inventory.getSubCaseArmorSkinList()));
    }

    private final void accessoriesNotVisible() {
        this.binding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        this.currentPersonType = InventoryPersonType.NONE;
    }

    private final void accessoriesVisible() {
        if (this.currentPersonType == InventoryPersonType.WALLET) {
            this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
            this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY.getId(), true);
        }
        this.currentPersonType = InventoryPersonType.ACCESSORIES;
        btnAccessoriesPressed();
    }

    private final void btnAccessoriesPressed() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY.getId());
        inventoryPersonSectionBinding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_white);
        inventoryPersonSectionBinding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        inventoryPersonSectionBinding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        if (BaseInventory.Companion.getAccessPages() != null) {
            updateSet();
            return;
        }
        this.inventory.getAccessoriesInventoryAdapter().submitList(CollectionsKt.toList(this.inventory.getSubAccessoriesList()));
        inventoryPersonSectionBinding.rvAccessoriesInventory.scheduleLayoutAnimation();
    }

    private final void setPageNumber() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        inventoryPersonSectionBinding.tvSetNumber.setText(inventoryPersonSectionBinding.getRoot().getContext().getString(R.string.set_i, Integer.valueOf(this.currentPage)));
    }

    public final void updateSet() {
        AccessPagesModel accessPages = BaseInventory.Companion.getAccessPages();
        this.currentPage = accessPages != null ? accessPages.getPage() : 1;
        this.inventory.getAccessoriesInventoryAdapter().submitList(this.inventory.getCurrentSectionList(UtilsKt.isArizonaType() ? 6 : 9, CollectionsKt.toList(this.inventory.getSubAccessoriesList())));
        setPageNumber();
    }

    public final void updateAccessories(InventoryEditResponse newResponse) {
        Object obj;
        Intrinsics.checkNotNullParameter(newResponse, "newResponse");
        if (this.inventory.getSubAccessoriesList().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<InventoryItem> items = newResponse.getItems();
        if (items != null) {
            for (InventoryItem inventoryItem : items) {
                Iterator<InventoryItem> it = this.inventory.getSubAccessoriesList().iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (it.next().getSlot() == inventoryItem.getSlot()) {
                        break;
                    } else {
                        i++;
                    }
                }
                Iterator<T> it2 = this.inventory.getSubAccessoriesList().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (((InventoryItem) obj).getSlot() == inventoryItem.getSlot()) {
                        break;
                    }
                }
                InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem);
                if (i >= 0) {
                    arrayList.add(Integer.valueOf(i));
                    Integer item = inventoryItem.getItem();
                    BaseInventory baseInventory = this.inventory;
                    if (item != null) {
                        List<InventoryItem> subAccessoriesList = baseInventory.getSubAccessoriesList();
                        if (updateInventoryItem == null) {
                            updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                        }
                        subAccessoriesList.set(i, updateInventoryItem);
                    } else {
                        baseInventory.getSubAccessoriesList().set(i, inventoryItem);
                    }
                }
            }
        }
        AccessPagesModel accessPages = BaseInventory.Companion.getAccessPages();
        BaseInventory baseInventory2 = this.inventory;
        if (accessPages != null) {
            this.inventory.getAccessoriesInventoryAdapter().submitList(baseInventory2.getCurrentSectionList(UtilsKt.isArizonaType() ? 6 : 9, CollectionsKt.toList(this.inventory.getSubAccessoriesList())));
        } else {
            baseInventory2.getAccessoriesInventoryAdapter().submitList(CollectionsKt.toList(this.inventory.getSubAccessoriesList()));
        }
    }

    public final void changeAccessoriesItem(InventoryItem item, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        BaseInventory baseInventory = this.inventory;
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((ItemsInfo) obj).getId();
            Integer item2 = item.getItem();
            if (item2 != null && id == item2.intValue()) {
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        int acs_slot = itemsInfo != null ? itemsInfo.getAcs_slot() : -1;
        List<InventoryItem> subAccessoriesList = baseInventory.getSubAccessoriesList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subAccessoriesList, 10));
        Iterator<T> it2 = subAccessoriesList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            InventoryItem inventoryItem = (InventoryItem) it2.next();
            AccessPagesModel accessPages = BaseInventory.Companion.getAccessPages();
            if (accessPages == null) {
                accessPages = new AccessPagesModel(3, 1);
            }
            if (inventoryItem.getSlot() == ((accessPages.getPage() - 1) * 6) + acs_slot) {
                inventoryItem = InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, null, 16252927, null);
            }
            arrayList.add(inventoryItem);
        }
        baseInventory.setSubAccessoriesList(CollectionsKt.toMutableList((Collection) arrayList));
        AccessPagesModel accessPages2 = BaseInventory.Companion.getAccessPages();
        BaseInventory baseInventory2 = this.inventory;
        if (accessPages2 != null) {
            this.inventory.getAccessoriesInventoryAdapter().submitList(baseInventory2.getCurrentSectionList(UtilsKt.isArizonaType() ? 6 : 9, CollectionsKt.toList(this.inventory.getSubAccessoriesList())));
        } else {
            baseInventory2.getAccessoriesInventoryAdapter().submitList(CollectionsKt.toList(this.inventory.getSubAccessoriesList()));
        }
    }

    private final void upgradesNotVisible() {
        this.binding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        this.currentPersonType = InventoryPersonType.NONE;
    }

    private final void upgradesVisible() {
        InventoryPersonType inventoryPersonType = InventoryPersonType.UPGRADES;
        this.currentPersonType = inventoryPersonType;
        if (inventoryPersonType == InventoryPersonType.WALLET) {
            this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
            this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY.getId(), true);
        }
        btnUpgradesPressed();
    }

    private final void btnUpgradesPressed() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY.getId());
        inventoryPersonSectionBinding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades_white);
        inventoryPersonSectionBinding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        inventoryPersonSectionBinding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        this.inventory.getUpgradesInventoryAdapter().submitList(CollectionsKt.toList(this.inventory.getSubUpgradesList()));
        inventoryPersonSectionBinding.rvUpgradesInventory.scheduleLayoutAnimation();
    }

    private final void walletNotVisible() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        this.currentPersonType = InventoryPersonType.NONE;
        inventoryPersonSectionBinding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
        this.inventory.getNotifier().setUIElementVisible(UIElementID.INVENTORY.getId(), true);
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY.getId());
    }

    private final void walletVisible() {
        this.currentPersonType = InventoryPersonType.WALLET;
        if (UtilsKt.isArizonaType()) {
            IBackendNotifier notifier = this.inventory.getNotifier();
            int id = UIElementID.INVENTORY_WALLET_SCREEN.getId();
            byte[] bytes = StringKt.toStringJson(new BlockType(24)).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            notifier.clickedWrapper(id, -1, 0, bytes);
        } else {
            btnWalletPressed();
            IBackendNotifier notifier2 = this.inventory.getNotifier();
            int id2 = UIElementID.INVENTORY_WALLET_SCREEN.getId();
            byte[] bytes2 = StringKt.toStringJson("").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            notifier2.clickedWrapper(id2, -1, 0, bytes2);
        }
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_WALLET_SCREEN.getId());
    }

    private final void btnWalletPressed() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        inventoryPersonSectionBinding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_white);
        inventoryPersonSectionBinding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        inventoryPersonSectionBinding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        inventoryPersonSectionBinding.rvWalletInventory.scheduleLayoutAnimation();
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_WALLET_SCREEN.getId());
    }

    public final void openFishing() {
        this.currentPersonType = InventoryPersonType.WALLET;
        setPersonTypeVisible();
    }

    private final void setPersonTypeVisible() {
        InventoryPersonSectionBinding inventoryPersonSectionBinding = this.binding;
        Log.d(ConstantsKt.INVENTORY_TAG, "setPersonTypeVisible: " + this.currentPersonType);
        RecyclerView rvWalletInventory = inventoryPersonSectionBinding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(this.currentPersonType == InventoryPersonType.WALLET ? 0 : 8);
        RecyclerView rvSubInventory = inventoryPersonSectionBinding.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(this.currentPersonType != InventoryPersonType.WALLET ? 0 : 8);
        FrameLayout layoutAcsUpg = inventoryPersonSectionBinding.layoutAcsUpg;
        Intrinsics.checkNotNullExpressionValue(layoutAcsUpg, "layoutAcsUpg");
        layoutAcsUpg.setVisibility(this.currentPersonType == InventoryPersonType.WALLET || this.currentPersonType == InventoryPersonType.NONE ? 8 : 0);
        RecyclerView rvAccessoriesInventory = inventoryPersonSectionBinding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(this.currentPersonType == InventoryPersonType.ACCESSORIES ? 0 : 8);
        RecyclerView rvUpgradesInventory = inventoryPersonSectionBinding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(this.currentPersonType == InventoryPersonType.UPGRADES ? 0 : 8);
        ImageView btnWallet = inventoryPersonSectionBinding.btnWallet;
        Intrinsics.checkNotNullExpressionValue(btnWallet, "btnWallet");
        btnWallet.setVisibility(this.currentPersonType != InventoryPersonType.ACCESSORIES ? 0 : 8);
        LinearLayout setContainer = inventoryPersonSectionBinding.setContainer;
        Intrinsics.checkNotNullExpressionValue(setContainer, "setContainer");
        setContainer.setVisibility(this.currentPersonType == InventoryPersonType.ACCESSORIES ? 0 : 8);
    }

    public final void defaultPersonSection() {
        if (this.currentPersonType == InventoryPersonType.ACCESSORIES) {
            accessoriesNotVisible();
        }
        if (this.currentPersonType == InventoryPersonType.UPGRADES) {
            upgradesNotVisible();
        }
        this.currentPersonType = InventoryPersonType.NONE;
        setPersonTypeVisible();
    }

    public final void refresh() {
        this.currentPersonType = InventoryPersonType.NONE;
        setPersonTypeVisible();
    }
}

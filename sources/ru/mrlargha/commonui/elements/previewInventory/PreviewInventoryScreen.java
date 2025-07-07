package ru.mrlargha.commonui.elements.previewInventory;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.PreviewInventoryScreenBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.domain.models.Skin;
import ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.SubInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.UpgradesInventoryAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: PreviewInventoryScreen.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0018\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020$H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\b\u00101\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/previewInventory/PreviewInventoryScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "previewScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/PreviewInventoryScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "subCaseArmorSkinList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "subAccessoriesList", "subUpgradesList", "selectedInventoryItem", "subInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "accessoriesInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "upgradesInventoryAdapter", "setVisible", "", "visible", "onBackendMessage", "data", "", "subId", "observeUserSkin", "view", "Landroid/widget/ImageView;", "url", "editResponseInfo", "", "inventoryList", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "showSelectorDialog", "item", "sendRequestTo", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreviewInventoryScreen extends SAMPUIElement implements InterfaceController {
    private final UpgradesInventoryAdapter accessoriesInventoryAdapter;
    private final PreviewInventoryScreenBinding binding;
    private final IBackendNotifier frontendNotifier;
    private final boolean isArizonaType;
    private final ConstraintLayout previewScreen;
    private InventoryItem selectedInventoryItem;
    private final SharedPreferences sharedPref;
    private List<InventoryItem> subAccessoriesList;
    private List<InventoryItem> subCaseArmorSkinList;
    private final SubInventoryAdapter subInventoryAdapter;
    private List<InventoryItem> subUpgradesList;
    private final UpgradesInventoryAdapter upgradesInventoryAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewInventoryScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.preview_inventory_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.previewScreen = constraintLayout;
        PreviewInventoryScreenBinding bind = PreviewInventoryScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.subCaseArmorSkinList = new ArrayList();
        this.subAccessoriesList = new ArrayList();
        this.subUpgradesList = new ArrayList();
        Activity activity = targetActivity;
        SubInventoryAdapter subInventoryAdapter = new SubInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$0;
                subInventoryAdapter$lambda$0 = PreviewInventoryScreen.subInventoryAdapter$lambda$0((DraggedItem) obj);
                return subInventoryAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$1;
                subInventoryAdapter$lambda$1 = PreviewInventoryScreen.subInventoryAdapter$lambda$1((InventoryItem) obj);
                return subInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$2;
                subInventoryAdapter$lambda$2 = PreviewInventoryScreen.subInventoryAdapter$lambda$2(PreviewInventoryScreen.this, (InventoryItem) obj);
                return subInventoryAdapter$lambda$2;
            }
        });
        this.subInventoryAdapter = subInventoryAdapter;
        UpgradesInventoryAdapter upgradesInventoryAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$3;
                accessoriesInventoryAdapter$lambda$3 = PreviewInventoryScreen.accessoriesInventoryAdapter$lambda$3((DraggedItem) obj);
                return accessoriesInventoryAdapter$lambda$3;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$4;
                accessoriesInventoryAdapter$lambda$4 = PreviewInventoryScreen.accessoriesInventoryAdapter$lambda$4((InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$4;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$5;
                accessoriesInventoryAdapter$lambda$5 = PreviewInventoryScreen.accessoriesInventoryAdapter$lambda$5(PreviewInventoryScreen.this, (InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$5;
            }
        });
        this.accessoriesInventoryAdapter = upgradesInventoryAdapter;
        UpgradesInventoryAdapter upgradesInventoryAdapter2 = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$6;
                upgradesInventoryAdapter$lambda$6 = PreviewInventoryScreen.upgradesInventoryAdapter$lambda$6((DraggedItem) obj);
                return upgradesInventoryAdapter$lambda$6;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$7;
                upgradesInventoryAdapter$lambda$7 = PreviewInventoryScreen.upgradesInventoryAdapter$lambda$7((InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$7;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$8;
                upgradesInventoryAdapter$lambda$8 = PreviewInventoryScreen.upgradesInventoryAdapter$lambda$8(PreviewInventoryScreen.this, (InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$8;
            }
        });
        this.upgradesInventoryAdapter = upgradesInventoryAdapter2;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        setVisible(false);
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.previewInventory.PreviewInventoryScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewInventoryScreen.this.closeScreen();
            }
        });
        bind.rvUserImprovements.setAdapter(subInventoryAdapter);
        bind.rvUserInventory.setAdapter(upgradesInventoryAdapter);
        bind.rvUserUpgrades.setAdapter(upgradesInventoryAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$0(DraggedItem draggedItem) {
        Intrinsics.checkNotNullParameter(draggedItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$2(PreviewInventoryScreen previewInventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            previewInventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
            previewInventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$3(DraggedItem draggedItem) {
        Intrinsics.checkNotNullParameter(draggedItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$4(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$5(PreviewInventoryScreen previewInventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            previewInventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
            previewInventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$6(DraggedItem draggedItem) {
        Intrinsics.checkNotNullParameter(draggedItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$7(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$8(PreviewInventoryScreen previewInventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            previewInventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
            previewInventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_PREVIEW", "subID: " + i + " ==== data: " + data);
        if (i != 0) {
            if (i != 1) {
                return;
            }
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) Skin.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            Skin skin = (Skin) fromJson;
            this.binding.tvScreenTitle.setText("обзор — " + skin.getName());
            if (this.isArizonaType) {
                str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
            } else {
                str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
            }
            AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
            Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
            observeUserSkin(ivCharacterImage, str);
            return;
        }
        Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
        Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
        InventoryResponse inventoryResponse = (InventoryResponse) fromJson2;
        int type = inventoryResponse.getType();
        if (type == ArizonaBlockType.BLOCK_TYPE_USER_PREVIEW_ATTACH.getId()) {
            if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                this.subAccessoriesList.clear();
            }
            List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
            this.subAccessoriesList = mutableList;
            this.accessoriesInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
        } else if (type == ArizonaBlockType.BLOCK_TYPE_USER_PREVIEW_GUN_IMPROV.getId()) {
            if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                this.subUpgradesList.clear();
            }
            List<InventoryItem> mutableList2 = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
            this.subUpgradesList = mutableList2;
            this.upgradesInventoryAdapter.submitList(CollectionsKt.toList(mutableList2));
        } else if (type == ArizonaBlockType.BLOCK_TYPE_USER_PREVIEW_IMPROV.getId()) {
            CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
            this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
            this.subInventoryAdapter.notifyDataSetChanged();
        } else if (type == ArizonaBlockType.BLOCK_TYPE_USER_PREVIEW_SKIN.getId()) {
            CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
            if (this.subCaseArmorSkinList.size() >= 3) {
                List<InventoryItem> list = this.subCaseArmorSkinList;
                list.set(1, list.get(2));
                this.subCaseArmorSkinList.set(2, this.subCaseArmorSkinList.get(1));
            }
            this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
            this.subInventoryAdapter.notifyDataSetChanged();
        }
    }

    private final void observeUserSkin(ImageView imageView, String str) {
        Activity targetActivity = getTargetActivity();
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        Glide.with((FragmentActivity) targetActivity).load(str).fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.default_char_skin_cropped).into(imageView);
    }

    private final List<InventoryItem> editResponseInfo(InventoryResponse inventoryResponse) {
        List<InventoryItem> items = inventoryResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (InventoryItem inventoryItem : items) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), null, null, false, false, 2031615, null));
        }
        return arrayList;
    }

    private final void showSelectorDialog(InventoryItem inventoryItem) {
        InventoryScreen.Companion.setDialogVisible(true);
        this.selectedInventoryItem = inventoryItem;
    }

    private final void sendRequestTo(String str) {
        Log.d("TAG_PREVIEWINV", "data: " + str);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.PREVIEW_USER_INVENTORY.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 2, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.PREVIEW_USER_INVENTORY.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: PreviewInventoryScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/previewInventory/PreviewInventoryScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new PreviewInventoryScreen(targetActivity, i);
        }
    }
}

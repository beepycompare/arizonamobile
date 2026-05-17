package ru.mrlargha.commonui.elements.shop;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.ShopScreenBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.shop.adapter.ShopAdapter;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ShopScreen.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0016\u0010!\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/shop/ShopScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "shopScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/ShopScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "shopAdapter", "Lru/mrlargha/commonui/elements/shop/adapter/ShopAdapter;", "currentItemsType", "pagingList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "setVisible", "", "visible", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "onBackendMessageHandled", "data", "", "subId", "initObservers", "newItems", "", "sendData", "closeScreen", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopScreen extends SAMPUIElement implements InterfaceController {
    private final ShopScreenBinding binding;
    private int currentItemsType;
    private final IBackendNotifier frontendNotifier;
    private final Handler handler;
    private List<InventoryItem> pagingList;
    private final ShopAdapter shopAdapter;
    private final ConstraintLayout shopScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.shop_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.shopScreen = constraintLayout;
        ShopScreenBinding bind = ShopScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        ShopAdapter shopAdapter = new ShopAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.shop.ShopScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShopScreen.shopAdapter$lambda$0(ShopScreen.this, (InventoryItem) obj);
            }
        }, targetActivity);
        this.shopAdapter = shopAdapter;
        this.currentItemsType = -1;
        this.pagingList = new ArrayList();
        this.handler = new Handler();
        constraintLayout.isClickable();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.ShopScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShopScreen.this.closeScreen();
            }
        });
        bind.rvShopInventory.setAdapter(shopAdapter);
        bind.rvShopInventory.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.commonui.elements.shop.ShopScreen.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                if (gridLayoutManager.findLastVisibleItemPosition() != gridLayoutManager.getItemCount() - 1 || ShopScreen.this.pagingList.size() <= 24) {
                    return;
                }
                ShopScreen.this.sendData(3, StringKt.toStringJson(new RequestItems(ShopScreen.this.pagingList.size())));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit shopAdapter$lambda$0(ShopScreen shopScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        shopScreen.sendData(2, StringKt.toStringJson(new SendSlot(it.getInventoryType(), it.getSlot())));
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        int i;
        ConstraintLayout constraintLayout = this.binding.parentLayout;
        if (z) {
            i = 0;
        } else {
            this.pagingList.clear();
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson;
            this.currentItemsType = inventoryResponse.getType();
            if (!inventoryResponse.getItems().isEmpty() && inventoryResponse.getItems().get(0).getSlot() == 0) {
                this.pagingList.clear();
            }
            initObservers(inventoryResponse.getItems());
        } else if (i == 1) {
            Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) SellerInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
            this.binding.tvScreenTitle.setText(((SellerInfo) fromJson2).getName());
        } else if (i == 2) {
            Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
            List<InventoryItem> items = ((InventoryResponse) fromJson3).getItems();
            List<InventoryItem> currentList = this.shopAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            List mutableList = CollectionsKt.toMutableList((Collection) currentList);
            for (InventoryItem inventoryItem : items) {
                Iterator it = mutableList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (((InventoryItem) it.next()).getSlot() == inventoryItem.getSlot()) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    mutableList.set(i2, inventoryItem);
                }
                this.shopAdapter.submitList(mutableList);
            }
        }
    }

    private final void initObservers(List<InventoryItem> list) {
        List<InventoryItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (InventoryItem inventoryItem : list2) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, this.currentItemsType, null, null, false, false, null, null, null, null, 33488895, null));
        }
        this.pagingList.addAll(arrayList);
        this.shopAdapter.submitList(this.pagingList);
        this.shopAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendData(int i, String str) {
        Log.d("TAG_SHOP", "sendITEM: " + str + " === subID: " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_LAVKA.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.pagingList.clear();
        this.frontendNotifier.setUIElementVisible(UIElementID.ARIZONA_LAVKA.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: ShopScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/shop/ShopScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_LAVKA);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ShopScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}

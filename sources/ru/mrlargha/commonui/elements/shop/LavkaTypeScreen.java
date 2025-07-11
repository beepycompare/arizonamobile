package ru.mrlargha.commonui.elements.shop;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.LavkaTypeScreenBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.BlockType;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.elements.shop.adapter.LavkaTypeAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: LavkaTypeScreen.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0017H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00104\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\u0018\u00108\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/H\u0002J\b\u00109\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lru/mrlargha/commonui/elements/shop/LavkaTypeScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "lavkaTypeScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/LavkaTypeScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "inventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "lavkaAdapter", "Lru/mrlargha/commonui/elements/shop/adapter/LavkaTypeAdapter;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "setVisible", "", "visible", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getInventoryList", "()Ljava/util/List;", "inventoryItemsList", "buyItemsList", "sellItemsList", "pawnShopList", "lavkaItems", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "screenType", "currentPage", "onBackendMessage", "data", "", "subId", "editUiVisibility", "isBuy", "arzInitObservers", "inventoryResponse", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "rodInitObservers", "addLockedItems", "sendData", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LavkaTypeScreen extends SAMPUIElement implements InterfaceController {
    private final LavkaTypeScreenBinding binding;
    private List<InventoryItem> buyItemsList;
    private int currentPage;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final Handler handler;
    private final MainInventoryAdapter inventoryAdapter;
    private List<InventoryItem> inventoryItemsList;
    private final boolean isArizonaType;
    private final LavkaTypeAdapter lavkaAdapter;
    private List<InventoryItem> lavkaItems;
    private final ConstraintLayout lavkaTypeScreen;
    private List<InventoryItem> pawnShopList;
    private int screenType;
    private List<InventoryItem> sellItemsList;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LavkaTypeScreen(final Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.lavka_type_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.lavkaTypeScreen = constraintLayout;
        LavkaTypeScreenBinding bind = LavkaTypeScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        Function1 function1 = new Function1() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryAdapter$lambda$0;
                inventoryAdapter$lambda$0 = LavkaTypeScreen.inventoryAdapter$lambda$0((DraggedItem) obj);
                return inventoryAdapter$lambda$0;
            }
        };
        RecyclerView rvInventory = bind.rvInventory;
        Intrinsics.checkNotNullExpressionValue(rvInventory, "rvInventory");
        Activity activity = targetActivity;
        MainInventoryAdapter mainInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function1, rvInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryAdapter$lambda$1;
                inventoryAdapter$lambda$1 = LavkaTypeScreen.inventoryAdapter$lambda$1((InventoryItem) obj);
                return inventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryAdapter$lambda$2;
                inventoryAdapter$lambda$2 = LavkaTypeScreen.inventoryAdapter$lambda$2(LavkaTypeScreen.this, (InventoryItem) obj);
                return inventoryAdapter$lambda$2;
            }
        }));
        this.inventoryAdapter = mainInventoryAdapter;
        LavkaTypeAdapter lavkaTypeAdapter = new LavkaTypeAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lavkaAdapter$lambda$3;
                lavkaAdapter$lambda$3 = LavkaTypeScreen.lavkaAdapter$lambda$3(LavkaTypeScreen.this, (InventoryItem) obj);
                return lavkaAdapter$lambda$3;
            }
        }, new Function0() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lavkaAdapter$lambda$4;
                lavkaAdapter$lambda$4 = LavkaTypeScreen.lavkaAdapter$lambda$4(targetActivity, i, this);
                return lavkaAdapter$lambda$4;
            }
        }, activity);
        this.lavkaAdapter = lavkaTypeAdapter;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        this.db = AppDatabase.Companion.invoke(activity);
        this.inventoryItemsList = new ArrayList();
        this.buyItemsList = new ArrayList();
        this.sellItemsList = new ArrayList();
        this.pawnShopList = new ArrayList();
        this.lavkaItems = new ArrayList();
        this.handler = new Handler();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LavkaTypeScreen.this.closeScreen();
            }
        });
        bind.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LavkaTypeScreen._init_$lambda$6(LavkaTypeScreen.this, view);
            }
        });
        bind.btnSell.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LavkaTypeScreen._init_$lambda$7(LavkaTypeScreen.this, view);
            }
        });
        bind.tvScreenTitle.setText(targetActivity.getString(R.string.trade_shop) + " —");
        bind.rvShopInventory.setAdapter(lavkaTypeAdapter);
        bind.rvInventory.setAdapter(mainInventoryAdapter);
        addLockedItems();
        this.currentPage = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inventoryAdapter$lambda$0(DraggedItem draggedItem) {
        Intrinsics.checkNotNullParameter(draggedItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inventoryAdapter$lambda$2(LavkaTypeScreen lavkaTypeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer available = it.getAvailable();
        if (available == null || available.intValue() != 0) {
            int slot = it.getSlot();
            int inventoryType = it.getInventoryType();
            Integer amount = it.getAmount();
            int intValue = amount != null ? amount.intValue() : 1;
            Integer item = it.getItem();
            lavkaTypeScreen.sendData(2, StringKt.toStringJson(new ChangeFromSlot(slot, inventoryType, intValue, item != null ? item.intValue() : -1)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lavkaAdapter$lambda$3(LavkaTypeScreen lavkaTypeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int slot = it.getSlot();
        int inventoryType = it.getInventoryType();
        Integer amount = it.getAmount();
        int intValue = amount != null ? amount.intValue() : 1;
        Integer item = it.getItem();
        lavkaTypeScreen.sendData(2, StringKt.toStringJson(new ChangeFromSlot(slot, inventoryType, intValue, item != null ? item.intValue() : -1)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lavkaAdapter$lambda$4(Activity activity, int i, LavkaTypeScreen lavkaTypeScreen) {
        Toast.makeText(activity, "Ошибка в интерфейсе : " + i, 1).show();
        lavkaTypeScreen.getNotifier().setUIElementVisible(i, false);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    private final List<InventoryItem> getInventoryList() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new LavkaTypeScreen$inventoryList$1(this, null), 1, null);
        return (List) runBlocking$default;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(LavkaTypeScreen lavkaTypeScreen, View view) {
        lavkaTypeScreen.sendData(3, StringKt.toStringJson(new BlockType(0)));
        lavkaTypeScreen.currentPage = 0;
        if (lavkaTypeScreen.isArizonaType) {
            lavkaTypeScreen.lavkaAdapter.submitList(lavkaTypeScreen.buyItemsList);
            lavkaTypeScreen.lavkaAdapter.notifyDataSetChanged();
            lavkaTypeScreen.editUiVisibility(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(LavkaTypeScreen lavkaTypeScreen, View view) {
        lavkaTypeScreen.sendData(3, StringKt.toStringJson(new BlockType(1)));
        lavkaTypeScreen.currentPage = 1;
        if (lavkaTypeScreen.isArizonaType) {
            lavkaTypeScreen.lavkaAdapter.submitList(lavkaTypeScreen.sellItemsList);
            lavkaTypeScreen.lavkaAdapter.notifyDataSetChanged();
            lavkaTypeScreen.editUiVisibility(false);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_LAVKA", "subID: " + i + " ====== data: " + data);
        if (i == 0) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson;
            if (this.screenType != inventoryResponse.getType()) {
                this.lavkaItems.clear();
                this.screenType = inventoryResponse.getType();
            }
            if (this.isArizonaType) {
                int i2 = this.screenType;
                if (i2 == ArizonaBlockType.BLOCK_TYPE_SHOP_BUY.getId()) {
                    CollectionsKt.addAll(this.buyItemsList, arzInitObservers(inventoryResponse));
                    return;
                } else if (i2 == ArizonaBlockType.BLOCK_TYPE_SHOP_SELL.getId()) {
                    CollectionsKt.addAll(this.sellItemsList, arzInitObservers(inventoryResponse));
                    return;
                } else if (i2 == ArizonaBlockType.BLOCK_TYPE_STORE.getId()) {
                    CollectionsKt.addAll(this.pawnShopList, arzInitObservers(inventoryResponse));
                    this.lavkaAdapter.submitList(this.pawnShopList);
                    return;
                } else {
                    return;
                }
            }
            rodInitObservers(inventoryResponse);
        } else if (i == 1) {
            Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) SellerInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
            SellerInfo sellerInfo = (SellerInfo) fromJson2;
            this.binding.tvScreenTitle.setText(sellerInfo.getName());
            ImageButton btnBuy = this.binding.btnBuy;
            Intrinsics.checkNotNullExpressionValue(btnBuy, "btnBuy");
            btnBuy.setVisibility(sellerInfo.getButtons() != 0 ? 0 : 8);
            TextView tvBuy = this.binding.tvBuy;
            Intrinsics.checkNotNullExpressionValue(tvBuy, "tvBuy");
            tvBuy.setVisibility(sellerInfo.getButtons() != 0 ? 0 : 8);
            ImageButton btnSell = this.binding.btnSell;
            Intrinsics.checkNotNullExpressionValue(btnSell, "btnSell");
            btnSell.setVisibility(sellerInfo.getButtons() != 0 ? 0 : 8);
            TextView tvSell = this.binding.tvSell;
            Intrinsics.checkNotNullExpressionValue(tvSell, "tvSell");
            tvSell.setVisibility(sellerInfo.getButtons() != 0 ? 0 : 8);
            this.currentPage = sellerInfo.getType();
            int type = sellerInfo.getType();
            if (type == 0) {
                editUiVisibility(true);
                if (this.isArizonaType) {
                    this.lavkaAdapter.submitList(this.buyItemsList);
                }
            } else if (type == 1) {
                editUiVisibility(false);
                if (this.isArizonaType) {
                    this.lavkaAdapter.submitList(this.sellItemsList);
                }
            }
            this.lavkaAdapter.notifyDataSetChanged();
        } else if (i == 2) {
            Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
            InventoryResponse inventoryResponse2 = (InventoryResponse) fromJson3;
            int type2 = inventoryResponse2.getType();
            List<InventoryItem> items = inventoryResponse2.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InventoryItem inventoryItem : items) {
                arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse2.getType(), null, null, false, false, 2031615, null));
            }
            InventoryResponse inventoryResponse3 = new InventoryResponse(type2, arrayList);
            if (this.isArizonaType) {
                int type3 = inventoryResponse2.getType();
                if (type3 != ArizonaBlockType.BLOCK_TYPE_SHOP_BUY.getId()) {
                    if (type3 != ArizonaBlockType.BLOCK_TYPE_SHOP_SELL.getId()) {
                        if (type3 == ArizonaBlockType.BLOCK_TYPE_STORE.getId()) {
                            for (InventoryItem inventoryItem2 : inventoryResponse3.getItems()) {
                                if (!this.pawnShopList.isEmpty()) {
                                    Iterator<InventoryItem> it = this.pawnShopList.iterator();
                                    int i3 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            i3 = -1;
                                            break;
                                        } else if (it.next().getSlot() == inventoryItem2.getSlot()) {
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (((InventoryItem) CollectionsKt.getOrNull(this.pawnShopList, i3)) != null) {
                                        this.pawnShopList.set(i3, inventoryItem2);
                                    }
                                    this.lavkaAdapter.submitList(this.pawnShopList);
                                    this.lavkaAdapter.notifyItemChanged(i3);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    for (InventoryItem inventoryItem3 : inventoryResponse3.getItems()) {
                        if (!this.sellItemsList.isEmpty()) {
                            Iterator<InventoryItem> it2 = this.sellItemsList.iterator();
                            int i4 = 0;
                            while (true) {
                                if (!it2.hasNext()) {
                                    i4 = -1;
                                    break;
                                } else if (it2.next().getSlot() == inventoryItem3.getSlot()) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (((InventoryItem) CollectionsKt.getOrNull(this.sellItemsList, i4)) != null) {
                                this.sellItemsList.set(i4, inventoryItem3);
                            }
                            if (this.currentPage == 1) {
                                this.lavkaAdapter.submitList(this.sellItemsList);
                                this.lavkaAdapter.notifyItemChanged(i4);
                            }
                        }
                    }
                    return;
                }
                for (InventoryItem inventoryItem4 : inventoryResponse3.getItems()) {
                    if (!this.buyItemsList.isEmpty()) {
                        Iterator<InventoryItem> it3 = this.buyItemsList.iterator();
                        int i5 = 0;
                        while (true) {
                            if (!it3.hasNext()) {
                                i5 = -1;
                                break;
                            } else if (it3.next().getSlot() == inventoryItem4.getSlot()) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                        if (((InventoryItem) CollectionsKt.getOrNull(this.buyItemsList, i5)) != null) {
                            this.buyItemsList.set(i5, inventoryItem4);
                        }
                        if (this.currentPage == 0) {
                            this.lavkaAdapter.submitList(this.buyItemsList);
                            this.lavkaAdapter.notifyItemChanged(i5);
                        }
                    }
                }
                return;
            }
            for (InventoryItem inventoryItem5 : inventoryResponse3.getItems()) {
                Iterator<InventoryItem> it4 = this.lavkaItems.iterator();
                int i6 = 0;
                while (true) {
                    if (!it4.hasNext()) {
                        i6 = -1;
                        break;
                    } else if (it4.next().getSlot() == inventoryItem5.getSlot()) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (this.lavkaItems.size() >= i6 && i6 != -1) {
                    this.lavkaItems.set(i6, inventoryItem5);
                }
                this.lavkaAdapter.submitList(this.lavkaItems);
                this.lavkaAdapter.notifyItemChanged(i6);
            }
        } else if (i == 3) {
            this.handler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.shop.LavkaTypeScreen$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LavkaTypeScreen.this.addLockedItems();
                }
            }, 300L);
        } else if (i == UIElementID.INVENTORY.getId()) {
            Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
            InventoryResponse inventoryResponse4 = (InventoryResponse) fromJson4;
            int type4 = inventoryResponse4.getType();
            List<InventoryItem> items2 = inventoryResponse4.getItems();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
            Iterator<T> it5 = items2.iterator();
            while (true) {
                Integer num = null;
                if (!it5.hasNext()) {
                    break;
                }
                InventoryItem inventoryItem6 = (InventoryItem) it5.next();
                int type5 = inventoryResponse4.getType();
                Iterator<T> it6 = UtilsKt.getItemsName().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it6.next();
                    int id = ((ItemsInfo) obj2).getId();
                    Integer item = inventoryItem6.getItem();
                    if (item != null && id == item.intValue()) {
                        break;
                    }
                }
                ItemsInfo itemsInfo = (ItemsInfo) obj2;
                Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
                Iterator<T> it7 = UtilsKt.getItemsName().iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it7.next();
                    int id2 = ((ItemsInfo) obj3).getId();
                    Integer item2 = inventoryItem6.getItem();
                    if (item2 != null && id2 == item2.intValue()) {
                        break;
                    }
                }
                ItemsInfo itemsInfo2 = (ItemsInfo) obj3;
                if (itemsInfo2 != null) {
                    num = Integer.valueOf(itemsInfo2.getAcs_slot());
                }
                arrayList2.add(InventoryItem.copy$default(inventoryItem6, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type5, num, null, false, false, 1900527, null));
            }
            for (InventoryItem inventoryItem7 : new InventoryResponse(type4, arrayList2).getItems()) {
                Iterator<InventoryItem> it8 = this.inventoryItemsList.iterator();
                int i7 = 0;
                while (true) {
                    if (!it8.hasNext()) {
                        i7 = -1;
                        break;
                    } else if (it8.next().getSlot() == inventoryItem7.getSlot()) {
                        break;
                    } else {
                        i7++;
                    }
                }
                Iterator<T> it9 = this.inventoryItemsList.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it9.next();
                    if (((InventoryItem) obj).getSlot() == inventoryItem7.getSlot()) {
                        break;
                    }
                }
                InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem7);
                if (this.inventoryItemsList.size() >= i7 && i7 != -1) {
                    if (inventoryItem7.getItem() != null) {
                        List<InventoryItem> list = this.inventoryItemsList;
                        if (updateInventoryItem == null) {
                            updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                        }
                        list.set(i7, updateInventoryItem);
                    } else {
                        this.inventoryItemsList.set(i7, inventoryItem7);
                    }
                }
            }
            this.inventoryAdapter.submitList(this.inventoryItemsList);
            this.inventoryAdapter.notifyDataSetChanged();
        }
    }

    private final void editUiVisibility(boolean z) {
        if (z) {
            this.binding.btnBuy.setBackgroundResource(R.drawable.ic_btn_buy_green);
            this.binding.btnSell.setBackgroundResource(R.drawable.ic_btn_sell_grey);
            this.binding.ivBackgroundStatus.setImageResource(R.drawable.bg_tradeshop_test_green);
            return;
        }
        this.binding.btnBuy.setBackgroundResource(R.drawable.ic_btn_buy_grey);
        this.binding.btnSell.setBackgroundResource(R.drawable.ic_btn_sell_red);
        this.binding.ivBackgroundStatus.setImageResource(R.drawable.bg_tradeshop_test_red);
    }

    private final List<InventoryItem> arzInitObservers(InventoryResponse inventoryResponse) {
        int type = inventoryResponse.getType();
        List<InventoryItem> items = inventoryResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (InventoryItem inventoryItem : items) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), null, null, false, false, 2031615, null));
        }
        return CollectionsKt.toMutableList((Collection) new InventoryResponse(type, arrayList).getItems());
    }

    private final void rodInitObservers(InventoryResponse inventoryResponse) {
        int type = inventoryResponse.getType();
        List<InventoryItem> items = inventoryResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (InventoryItem inventoryItem : items) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), null, null, false, false, 2031615, null));
        }
        CollectionsKt.addAll(this.lavkaItems, CollectionsKt.toMutableList((Collection) new InventoryResponse(type, arrayList).getItems()));
        this.lavkaAdapter.submitList(this.lavkaItems);
        this.lavkaAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addLockedItems() {
        List<InventoryItem> inventoryList = getInventoryList();
        this.inventoryItemsList = inventoryList;
        int nextMultipleOfFive = UtilsKt.nextMultipleOfFive(inventoryList.size()) - this.inventoryItemsList.size();
        if (1 <= nextMultipleOfFive) {
            int i = 1;
            while (true) {
                this.inventoryItemsList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), ((InventoryItem) CollectionsKt.last((List<? extends Object>) this.inventoryItemsList)).getSlot() + 1, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
                if (i == nextMultipleOfFive) {
                    break;
                }
                i++;
            }
        }
        List<InventoryItem> list = this.inventoryItemsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.inventoryItemsList = mutableList;
        this.inventoryAdapter.submitList(mutableList);
        this.inventoryAdapter.notifyDataSetChanged();
    }

    private final void sendData(int i, String str) {
        Log.d("TAG_LAVKASEND", "sendITEM: " + str + " === subID: " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.ARIZONA_GLOVO.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.ARIZONA_GLOVO.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: LavkaTypeScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/shop/LavkaTypeScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new LavkaTypeScreen(targetActivity, i);
        }
    }
}

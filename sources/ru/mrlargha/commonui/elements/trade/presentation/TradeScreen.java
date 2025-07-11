package ru.mrlargha.commonui.elements.trade.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.TradeScreenBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.ShowDialogInfo;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog;
import ru.mrlargha.commonui.elements.trade.domain.TradeInfo;
import ru.mrlargha.commonui.elements.trade.domain.TradeResponse;
import ru.mrlargha.commonui.elements.trade.domain.TradeValueResponse;
import ru.mrlargha.commonui.elements.trade.domain.ValueStatus;
import ru.mrlargha.commonui.elements.trade.presentation.adapter.SendItemsAdapter;
import ru.mrlargha.commonui.elements.trade.presentation.adapter.TradeInventoryAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.RodinaBlockType;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: TradeScreen.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001BB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\u0018\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002J\u0018\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0006H\u0016J\u0018\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020&2\u0006\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "tradeScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/TradeScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "tradeInventoryAdapter", "Lru/mrlargha/commonui/elements/trade/presentation/adapter/TradeInventoryAdapter;", "sendItemsAdapter", "Lru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter;", "getItemsAdapter", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getInventoryList", "()Ljava/util/List;", "sendItemsList", "getItemsList", "isConfirmedClicked", "", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "inventoryItemList", "selectedInventoryItem", "setVisible", "", "visible", "defaultScreenState", "initAdapters", "initObservers", "createEmptyLists", "trade", "forTrade", "onBackendMessage", "data", "", "subId", "sendDataFromDrop", "curItem", "toItem", "editValueCostUi", "response", "Lru/mrlargha/commonui/elements/trade/domain/TradeValueResponse;", "selectDrawableType", "type", "view", "Landroid/widget/EditText;", "editUi", "tradeResp", "Lru/mrlargha/commonui/elements/trade/domain/TradeResponse;", "sendData", "addLockedItems", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TradeScreen extends SAMPUIElement implements InterfaceController {
    private final TradeScreenBinding binding;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final SendItemsAdapter getItemsAdapter;
    private List<InventoryItem> getItemsList;
    private List<InventoryItem> inventoryItemList;
    private final boolean isArizonaType;
    private boolean isConfirmedClicked;
    private InventoryItem selectedInventoryItem;
    private final SendItemsAdapter sendItemsAdapter;
    private List<InventoryItem> sendItemsList;
    private final SharedPreferences sharedPref;
    private final TradeInventoryAdapter tradeInventoryAdapter;
    private final ConstraintLayout tradeScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TradeScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.trade_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.tradeScreen = constraintLayout;
        TradeScreenBinding bind = TradeScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        RecyclerView rvInventory = bind.rvInventory;
        Intrinsics.checkNotNullExpressionValue(rvInventory, "rvInventory");
        Activity activity = targetActivity;
        this.tradeInventoryAdapter = new TradeInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit tradeInventoryAdapter$lambda$0;
                tradeInventoryAdapter$lambda$0 = TradeScreen.tradeInventoryAdapter$lambda$0(TradeScreen.this, (DraggedItem) obj);
                return tradeInventoryAdapter$lambda$0;
            }
        }, rvInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit tradeInventoryAdapter$lambda$1;
                tradeInventoryAdapter$lambda$1 = TradeScreen.tradeInventoryAdapter$lambda$1(TradeScreen.this, (InventoryItem) obj);
                return tradeInventoryAdapter$lambda$1;
            }
        });
        RecyclerView rvSendItems = bind.rvSendItems;
        Intrinsics.checkNotNullExpressionValue(rvSendItems, "rvSendItems");
        this.sendItemsAdapter = new SendItemsAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit sendItemsAdapter$lambda$2;
                sendItemsAdapter$lambda$2 = TradeScreen.sendItemsAdapter$lambda$2(TradeScreen.this, (DraggedItem) obj);
                return sendItemsAdapter$lambda$2;
            }
        }, rvSendItems, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit sendItemsAdapter$lambda$3;
                sendItemsAdapter$lambda$3 = TradeScreen.sendItemsAdapter$lambda$3(TradeScreen.this, (InventoryItem) obj);
                return sendItemsAdapter$lambda$3;
            }
        });
        RecyclerView rvReceiveItems = bind.rvReceiveItems;
        Intrinsics.checkNotNullExpressionValue(rvReceiveItems, "rvReceiveItems");
        this.getItemsAdapter = new SendItemsAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemsAdapter$lambda$4;
                itemsAdapter$lambda$4 = TradeScreen.getItemsAdapter$lambda$4((DraggedItem) obj);
                return itemsAdapter$lambda$4;
            }
        }, rvReceiveItems, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemsAdapter$lambda$5;
                itemsAdapter$lambda$5 = TradeScreen.getItemsAdapter$lambda$5(TradeScreen.this, (InventoryItem) obj);
                return itemsAdapter$lambda$5;
            }
        });
        this.sendItemsList = new ArrayList();
        this.getItemsList = new ArrayList();
        this.db = AppDatabase.Companion.invoke(activity);
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.inventoryItemList = new ArrayList();
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        initAdapters();
        bind.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen._init_$lambda$6(TradeScreen.this, view);
            }
        });
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen.this.closeScreen();
            }
        });
        bind.etSendItems.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen._init_$lambda$8(TradeScreen.this, view);
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen.this.closeScreen();
            }
        });
        if (z) {
            EditText etSendItems = bind.etSendItems;
            Intrinsics.checkNotNullExpressionValue(etSendItems, "etSendItems");
            UtilsKt.setDrawableEnd(etSendItems, R.drawable.ic_dollar, targetActivity);
            EditText etReceiveItems = bind.etReceiveItems;
            Intrinsics.checkNotNullExpressionValue(etReceiveItems, "etReceiveItems");
            UtilsKt.setDrawableEnd(etReceiveItems, R.drawable.ic_dollar, targetActivity);
        } else {
            EditText etSendItems2 = bind.etSendItems;
            Intrinsics.checkNotNullExpressionValue(etSendItems2, "etSendItems");
            UtilsKt.setDrawableEnd(etSendItems2, R.drawable.ic_rubble, targetActivity);
            EditText etReceiveItems2 = bind.etReceiveItems;
            Intrinsics.checkNotNullExpressionValue(etReceiveItems2, "etReceiveItems");
            UtilsKt.setDrawableEnd(etReceiveItems2, R.drawable.ic_rubble, targetActivity);
        }
        initObservers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tradeInventoryAdapter$lambda$1(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!tradeScreen.isConfirmedClicked) {
            tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
            tradeScreen.selectedInventoryItem = it;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tradeInventoryAdapter$lambda$0(TradeScreen tradeScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        tradeScreen.sendDataFromDrop(currentItem.getItemInfo(), tradeScreen.inventoryItemList.get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendItemsAdapter$lambda$3(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!tradeScreen.isConfirmedClicked) {
            tradeScreen.selectedInventoryItem = it;
            tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendItemsAdapter$lambda$2(TradeScreen tradeScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        tradeScreen.sendDataFromDrop(currentItem.getItemInfo(), tradeScreen.sendItemsList.get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getItemsAdapter$lambda$5(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        tradeScreen.selectedInventoryItem = it;
        tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getItemsAdapter$lambda$4(DraggedItem draggedItem) {
        Intrinsics.checkNotNullParameter(draggedItem, "<unused var>");
        return Unit.INSTANCE;
    }

    private final List<InventoryItem> getInventoryList() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new TradeScreen$inventoryList$1(this, null), 1, null);
        return (List) runBlocking$default;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(TradeScreen tradeScreen, View view) {
        tradeScreen.isConfirmedClicked = true;
        IBackendNotifier iBackendNotifier = tradeScreen.frontendNotifier;
        int id = UIElementID.TRADE.getId();
        byte[] bytes = StringKt.toStringJson("0").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 3, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8(TradeScreen tradeScreen, View view) {
        tradeScreen.sendData(4, StringKt.toStringJson(0));
    }

    private final void defaultScreenState() {
        this.sendItemsList.clear();
        this.getItemsList.clear();
        Group groupProgressBar = this.binding.groupProgressBar;
        Intrinsics.checkNotNullExpressionValue(groupProgressBar, "groupProgressBar");
        groupProgressBar.setVisibility(8);
        ImageView ivReceiveStatus = this.binding.ivReceiveStatus;
        Intrinsics.checkNotNullExpressionValue(ivReceiveStatus, "ivReceiveStatus");
        ivReceiveStatus.setVisibility(8);
        ImageView ivSendStatus = this.binding.ivSendStatus;
        Intrinsics.checkNotNullExpressionValue(ivSendStatus, "ivSendStatus");
        ivSendStatus.setVisibility(8);
        this.binding.btnAccept.setBackgroundResource(R.drawable.bttn_ready_trade);
        initObservers();
        editValueCostUi(new TradeValueResponse(new ValueStatus(0, 0), new ValueStatus(0, 0)));
        this.isConfirmedClicked = false;
    }

    private final void initAdapters() {
        this.binding.rvInventory.setAdapter(this.tradeInventoryAdapter);
        this.binding.rvSendItems.setAdapter(this.sendItemsAdapter);
        this.binding.rvReceiveItems.setAdapter(this.getItemsAdapter);
    }

    private final void initObservers() {
        if (this.isArizonaType) {
            this.sendItemsAdapter.setDragDropEnabled(true);
            this.getItemsAdapter.setDragDropEnabled(false);
            createEmptyLists(ArizonaBlockType.BLOCK_TYPE_TRADE.getId(), ArizonaBlockType.BLOCK_TYPE_FOR_TRADE.getId());
        } else {
            this.sendItemsAdapter.setDragDropEnabled(false);
            this.getItemsAdapter.setDragDropEnabled(false);
            createEmptyLists(RodinaBlockType.BLOCK_TYPE_TRADE.getId(), RodinaBlockType.BLOCK_TYPE_FOR_TRADE.getId());
        }
        addLockedItems();
        this.sendItemsAdapter.submitList(this.sendItemsList);
        this.sendItemsAdapter.notifyDataSetChanged();
        this.getItemsAdapter.submitList(this.getItemsList);
        this.getItemsAdapter.notifyDataSetChanged();
    }

    private final void createEmptyLists(int i, int i2) {
        for (int i3 = 0; i3 < 10; i3++) {
            this.sendItemsList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), i3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, i, null, null, false, false, 2031614, null));
        }
        for (int i4 = 0; i4 < 10; i4++) {
            this.getItemsList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), i4, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, i2, null, null, false, false, 2031614, null));
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Object fromJson;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_TRADE", "data: " + data + " ======= subID: " + i);
        if (i == 0) {
            Intrinsics.checkNotNullExpressionValue(GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) TradeInfo.class), "fromJson(...)");
            this.binding.tvTitle.setText("Обмен с игроком  " + ((TradeInfo) fromJson).getName());
            defaultScreenState();
        } else if (i == 2) {
            Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson2;
            int type = inventoryResponse.getType();
            List<InventoryItem> items = inventoryResponse.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InventoryItem inventoryItem : items) {
                arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), null, null, false, false, 2031615, null));
            }
            InventoryResponse inventoryResponse2 = new InventoryResponse(type, arrayList);
            int type2 = inventoryResponse2.getType();
            if (type2 != RodinaBlockType.BLOCK_TYPE_TRADE.getId() && type2 != ArizonaBlockType.BLOCK_TYPE_TRADE.getId()) {
                if (type2 == RodinaBlockType.BLOCK_TYPE_FOR_TRADE.getId() || type2 == ArizonaBlockType.BLOCK_TYPE_FOR_TRADE.getId()) {
                    for (InventoryItem inventoryItem2 : inventoryResponse2.getItems()) {
                        Iterator<InventoryItem> it = this.getItemsList.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            } else if (it.next().getSlot() == inventoryItem2.getSlot()) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 >= 0) {
                            this.getItemsList.set(i2, inventoryItem2);
                        }
                    }
                    this.getItemsAdapter.submitList(this.getItemsList);
                    this.getItemsAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            for (InventoryItem inventoryItem3 : inventoryResponse2.getItems()) {
                Iterator<InventoryItem> it2 = this.sendItemsList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    } else if (it2.next().getSlot() == inventoryItem3.getSlot()) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    this.sendItemsList.set(i3, inventoryItem3);
                }
            }
            this.sendItemsAdapter.submitList(this.sendItemsList);
            this.sendItemsAdapter.notifyDataSetChanged();
        } else if (i == 3) {
            Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) ShowDialogInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
            ShowDialogInfo showDialogInfo = (ShowDialogInfo) fromJson3;
            InventoryItem inventoryItem4 = this.selectedInventoryItem;
            if (inventoryItem4 != null) {
                new SelectorDialog(getTargetActivity(), 52, InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, 2096895, null), 0);
            }
        } else if (i == 4) {
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"self\"", false, 2, (Object) null)) {
                Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) TradeResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
                editUi((TradeResponse) fromJson4);
            }
        } else if (i != 6) {
            if (i == UIElementID.INVENTORY.getId()) {
                Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
                InventoryResponse inventoryResponse3 = (InventoryResponse) fromJson5;
                if (inventoryResponse3.getType() == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    for (InventoryItem inventoryItem5 : inventoryResponse3.getItems()) {
                        List<InventoryItem> list = this.inventoryItemList;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (InventoryItem inventoryItem6 : list) {
                            if (inventoryItem6.getSlot() == inventoryItem5.getSlot()) {
                                inventoryItem6 = InventoryItem.copy$default(inventoryItem6, 0, null, 0, null, null, null, null, null, null, inventoryItem5.getAvailable(), null, null, null, null, null, null, 0, null, null, false, false, 2096639, null);
                            }
                            arrayList2.add(inventoryItem6);
                        }
                        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
                        this.inventoryItemList = mutableList;
                        this.tradeInventoryAdapter.submitList(mutableList);
                        this.tradeInventoryAdapter.notifyItemChanged(inventoryItem5.getSlot());
                    }
                }
            }
        } else {
            Object fromJson6 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) TradeValueResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson6, "fromJson(...)");
            editValueCostUi((TradeValueResponse) fromJson6);
        }
    }

    private final void sendDataFromDrop(InventoryItem inventoryItem, InventoryItem inventoryItem2) {
        if (inventoryItem.getSlot() == inventoryItem2.getSlot() && inventoryItem.getInventoryType() == inventoryItem2.getInventoryType()) {
            Log.d("TAG_SEND", "GUARD EQUAL ITEMS");
            return;
        }
        int slot = inventoryItem.getSlot();
        int inventoryType = inventoryItem.getInventoryType();
        Integer amount = inventoryItem.getAmount();
        int intValue = amount != null ? amount.intValue() : 1;
        Integer item = inventoryItem.getItem();
        sendData(1, StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(slot, inventoryType, intValue, item != null ? item.intValue() : -1), new ChangeToSlot(inventoryItem2.getSlot(), inventoryItem2.getInventoryType()))));
    }

    private final void editValueCostUi(TradeValueResponse tradeValueResponse) {
        this.binding.etSendItems.setText(String.valueOf(tradeValueResponse.getSelf().getValue()));
        int type = tradeValueResponse.getSelf().getType();
        EditText etSendItems = this.binding.etSendItems;
        Intrinsics.checkNotNullExpressionValue(etSendItems, "etSendItems");
        selectDrawableType(type, etSendItems);
        this.binding.etReceiveItems.setText(String.valueOf(tradeValueResponse.getTarget().getValue()));
        int type2 = tradeValueResponse.getTarget().getType();
        EditText etReceiveItems = this.binding.etReceiveItems;
        Intrinsics.checkNotNullExpressionValue(etReceiveItems, "etReceiveItems");
        selectDrawableType(type2, etReceiveItems);
    }

    private final void selectDrawableType(int i, EditText editText) {
        if (i == 0) {
            if (this.isArizonaType) {
                UtilsKt.setDrawableEnd(editText, R.drawable.ic_dollar, getTargetActivity());
            } else {
                UtilsKt.setDrawableEnd(editText, R.drawable.ic_rubble, getTargetActivity());
            }
        } else if (i == 1) {
            UtilsKt.setDrawableEnd(editText, R.drawable.ic_euro, getTargetActivity());
        } else if (i == 2) {
            UtilsKt.setDrawableEnd(editText, R.drawable.ic_bitcoin, getTargetActivity());
        } else if (i != 3) {
        } else {
            UtilsKt.setDrawableEnd(editText, R.drawable.ic_az_coin, getTargetActivity());
        }
    }

    private final void editUi(TradeResponse tradeResponse) {
        ImageView ivSendStatus = this.binding.ivSendStatus;
        Intrinsics.checkNotNullExpressionValue(ivSendStatus, "ivSendStatus");
        ivSendStatus.setVisibility(tradeResponse.getSelf().getConfirm() == 1 ? 0 : 8);
        ImageView ivReceiveStatus = this.binding.ivReceiveStatus;
        Intrinsics.checkNotNullExpressionValue(ivReceiveStatus, "ivReceiveStatus");
        ivReceiveStatus.setVisibility(tradeResponse.getTarget().getConfirm() == 1 ? 0 : 8);
        if (tradeResponse.getSelf().getConfirm() == 1 && tradeResponse.getTarget().getConfirm() == 0) {
            this.binding.btnAccept.setBackgroundResource(R.drawable.btn_accept_trade_grey);
        } else if (tradeResponse.getSelf().getConfirm() == 1 && tradeResponse.getTarget().getConfirm() == 1 && tradeResponse.getSelf().getAccept() == 0 && tradeResponse.getTarget().getAccept() == 0) {
            this.binding.btnAccept.setBackgroundResource(R.drawable.ic_btn_confirmtrade_green);
        } else if (tradeResponse.getSelf().getAccept() == 1 && tradeResponse.getTarget().getAccept() == 0 && tradeResponse.getTarget().getConfirm() == 1) {
            Group groupProgressBar = this.binding.groupProgressBar;
            Intrinsics.checkNotNullExpressionValue(groupProgressBar, "groupProgressBar");
            groupProgressBar.setVisibility(0);
        }
    }

    private final void sendData(int i, String str) {
        Log.d("TAG_SEND", "sendITEM: " + str + " === subID: " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.TRADE.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void addLockedItems() {
        this.inventoryItemList = getInventoryList();
        int nextMultipleOfFive = UtilsKt.nextMultipleOfFive(getInventoryList().size()) - getInventoryList().size();
        if (1 <= nextMultipleOfFive) {
            int i = 1;
            while (true) {
                InventoryItem inventoryItem = (InventoryItem) CollectionsKt.lastOrNull((List<? extends Object>) getInventoryList());
                this.inventoryItemList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), inventoryItem != null ? inventoryItem.getSlot() + 1 : 1, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
                if (i == nextMultipleOfFive) {
                    break;
                }
                i++;
            }
        }
        List<InventoryItem> list = this.inventoryItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.inventoryItemList = mutableList;
        this.tradeInventoryAdapter.submitList(mutableList);
        this.tradeInventoryAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.TRADE.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }

    /* compiled from: TradeScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new TradeScreen(targetActivity, i);
        }
    }
}

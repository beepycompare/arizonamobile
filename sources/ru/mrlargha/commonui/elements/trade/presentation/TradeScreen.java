package ru.mrlargha.commonui.elements.trade.presentation;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
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
import ru.mrlargha.commonui.databinding.ViewUniversalMoneyInputBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
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
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.RodinaBlockType;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.textWithIcons.IconAndSize;
import ru.mrlargha.commonui.utils.ui.textWithIcons.TextWithIconsKt;
/* compiled from: TradeScreen.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002EFB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020%H\u0002J\u001a\u0010(\u001a\u00020%*\u00020)2\f\b\u0001\u0010*\u001a\u00020\u0006:\u0002\b+H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0002J\u0018\u00105\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0016J\u0018\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020%2\u0006\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u000207H\u0002J\b\u0010C\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020%H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "tradeScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/TradeScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "topMoneyController", "Lru/mrlargha/commonui/elements/trade/presentation/TradeEditText;", "bottomMoneyController", "tradeInventoryAdapter", "Lru/mrlargha/commonui/elements/trade/presentation/adapter/TradeInventoryAdapter;", "sendItemsAdapter", "Lru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter;", "getItemsAdapter", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getInventoryList", "()Ljava/util/List;", "sendItemsList", "getItemsList", "isConfirmedClicked", "", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "inventoryItemList", "selectedInventoryItem", "setVisible", "", "visible", "initCurrencyOptionIcons", "setCurrencyIcon", "Landroid/widget/TextView;", "iconResId", "Landroidx/annotation/DrawableRes;", "setButtonText", "", "type", "defaultScreenState", "initAdapters", "initObservers", "createEmptyLists", "trade", "forTrade", "onBackendMessageHandled", "data", "", "subId", "sendDataFromDrop", "curItem", "toItem", "editValueCostUi", "response", "Lru/mrlargha/commonui/elements/trade/domain/TradeValueResponse;", "editUi", "tradeResp", "Lru/mrlargha/commonui/elements/trade/domain/TradeResponse;", "sendData", "addLockedItems", "closeScreen", "Spawner", "ShowDialogInfo", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TradeScreen extends SAMPUIElement implements InterfaceController {
    private final TradeScreenBinding binding;
    private final TradeEditText bottomMoneyController;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final SendItemsAdapter getItemsAdapter;
    private List<InventoryItem> getItemsList;
    private List<InventoryItem> inventoryItemList;
    private boolean isConfirmedClicked;
    private InventoryItem selectedInventoryItem;
    private final SendItemsAdapter sendItemsAdapter;
    private List<InventoryItem> sendItemsList;
    private final TradeEditText topMoneyController;
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
        ViewUniversalMoneyInputBinding etSendItems = bind.etSendItems;
        Intrinsics.checkNotNullExpressionValue(etSendItems, "etSendItems");
        TradeEditText tradeEditText = new TradeEditText(etSendItems);
        this.topMoneyController = tradeEditText;
        ViewUniversalMoneyInputBinding etReceiveItems = bind.etReceiveItems;
        Intrinsics.checkNotNullExpressionValue(etReceiveItems, "etReceiveItems");
        TradeEditText tradeEditText2 = new TradeEditText(etReceiveItems);
        this.bottomMoneyController = tradeEditText2;
        RecyclerView rvInventory = bind.rvInventory;
        Intrinsics.checkNotNullExpressionValue(rvInventory, "rvInventory");
        Activity activity = targetActivity;
        this.tradeInventoryAdapter = new TradeInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.tradeInventoryAdapter$lambda$0(TradeScreen.this, (DraggedItem) obj);
            }
        }, rvInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.tradeInventoryAdapter$lambda$1(TradeScreen.this, (InventoryItem) obj);
            }
        });
        RecyclerView rvSendItems = bind.rvSendItems;
        Intrinsics.checkNotNullExpressionValue(rvSendItems, "rvSendItems");
        this.sendItemsAdapter = new SendItemsAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.sendItemsAdapter$lambda$0(TradeScreen.this, (DraggedItem) obj);
            }
        }, rvSendItems, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.sendItemsAdapter$lambda$1(TradeScreen.this, (InventoryItem) obj);
            }
        });
        RecyclerView rvReceiveItems = bind.rvReceiveItems;
        Intrinsics.checkNotNullExpressionValue(rvReceiveItems, "rvReceiveItems");
        this.getItemsAdapter = new SendItemsAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.getItemsAdapter$lambda$0((DraggedItem) obj);
            }
        }, rvReceiveItems, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen.getItemsAdapter$lambda$1(TradeScreen.this, (InventoryItem) obj);
            }
        });
        this.sendItemsList = new ArrayList();
        this.getItemsList = new ArrayList();
        this.db = AppDatabase.Companion.invoke(activity);
        this.inventoryItemList = new ArrayList();
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName$default(activity, UtilsKt.isArizonaType(), null, 4, null);
        initAdapters();
        bind.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen._init_$lambda$0(TradeScreen.this, view);
            }
        });
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen.this.closeScreen();
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeScreen.this.closeScreen();
            }
        });
        bind.btnSendItemText.setText(TextWithIconsKt.toTextWithIcons("<ic>1<ic> " + targetActivity.getString(R.string.trade_money) + " <ic>2<ic>", activity, new IconAndSize(R.drawable.arizona_dollar, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp)));
        tradeEditText.setType(0);
        tradeEditText2.setType(0);
        if (UtilsKt.isArizonaType()) {
            initCurrencyOptionIcons();
            bind.btnReceiveItemText.setText(targetActivity.getString(R.string.trade_currencies));
            tradeEditText2.setEnabled(false);
            bind.btnSendItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen.this.binding.currencyChoice.setVisibility(0);
                }
            });
            bind.currencyChoice.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen.this.binding.currencyChoice.setVisibility(8);
                }
            });
            bind.buttonCurrency1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen._init_$lambda$5(TradeScreen.this, view);
                }
            });
            bind.buttonCurrency2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen._init_$lambda$6(TradeScreen.this, view);
                }
            });
            bind.buttonCurrency3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen._init_$lambda$7(TradeScreen.this, view);
                }
            });
            bind.buttonCurrency4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen._init_$lambda$8(TradeScreen.this, view);
                }
            });
            bind.buttonCurrency5.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TradeScreen._init_$lambda$9(TradeScreen.this, view);
                }
            });
        } else {
            bind.btnSendItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SAMPUIElement.notifyClick$default(TradeScreen.this, 0, 4, null, 4, null);
                }
            });
            bind.btnReceiveItem.setVisibility(8);
            bind.sendItemContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SAMPUIElement.notifyClick$default(TradeScreen.this, 0, 4, null, 4, null);
                }
            });
        }
        bind.btnArizonaReceiveItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(TradeScreen.this, 0, 9, null, 4, null);
            }
        });
        initObservers();
        tradeEditText.setOnValueChanged(new Function1() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TradeScreen._init_$lambda$13(TradeScreen.this, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tradeInventoryAdapter$lambda$1(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!tradeScreen.isConfirmedClicked) {
            tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
            tradeScreen.selectedInventoryItem = it;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit tradeInventoryAdapter$lambda$0(TradeScreen tradeScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        tradeScreen.sendDataFromDrop(currentItem.getItemInfo(), tradeScreen.inventoryItemList.get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit sendItemsAdapter$lambda$1(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!tradeScreen.isConfirmedClicked) {
            tradeScreen.selectedInventoryItem = it;
            tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit sendItemsAdapter$lambda$0(TradeScreen tradeScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        tradeScreen.sendDataFromDrop(currentItem.getItemInfo(), tradeScreen.sendItemsList.get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getItemsAdapter$lambda$1(TradeScreen tradeScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        tradeScreen.selectedInventoryItem = it;
        tradeScreen.sendData(2, StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getItemsAdapter$lambda$0(DraggedItem draggedItem) {
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
        int i;
        ConstraintLayout constraintLayout = this.binding.parentLayout;
        if (z) {
            i = 0;
            sendData(4, StringKt.toStringJson(0));
        } else {
            i = 8;
        }
        constraintLayout.setVisibility(i);
        this.topMoneyController.setValidation(true);
        this.topMoneyController.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(TradeScreen tradeScreen, View view) {
        tradeScreen.isConfirmedClicked = true;
        IBackendNotifier iBackendNotifier = tradeScreen.frontendNotifier;
        int id = UIElementID.TRADE.getId();
        byte[] bytes = StringKt.toStringJson("0").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 3, bytes);
        tradeScreen.topMoneyController.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$5(TradeScreen tradeScreen, View view) {
        tradeScreen.binding.currencyChoice.setVisibility(8);
        tradeScreen.topMoneyController.setType(0);
        tradeScreen.binding.btnSendItemText.setText(tradeScreen.setButtonText(0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$6(TradeScreen tradeScreen, View view) {
        tradeScreen.binding.currencyChoice.setVisibility(8);
        tradeScreen.topMoneyController.setType(2);
        tradeScreen.binding.btnSendItemText.setText(tradeScreen.setButtonText(2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$7(TradeScreen tradeScreen, View view) {
        tradeScreen.binding.currencyChoice.setVisibility(8);
        tradeScreen.topMoneyController.setType(3);
        tradeScreen.binding.btnSendItemText.setText(tradeScreen.setButtonText(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$8(TradeScreen tradeScreen, View view) {
        tradeScreen.binding.currencyChoice.setVisibility(8);
        tradeScreen.topMoneyController.setType(1);
        tradeScreen.binding.btnSendItemText.setText(tradeScreen.setButtonText(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$9(TradeScreen tradeScreen, View view) {
        tradeScreen.binding.currencyChoice.setVisibility(8);
        tradeScreen.topMoneyController.setType(4);
        tradeScreen.binding.btnSendItemText.setText(tradeScreen.setButtonText(4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$13(TradeScreen tradeScreen, Long l) {
        Long value = tradeScreen.topMoneyController.getValue();
        if (value == null) {
            tradeScreen.topMoneyController.setValidation(false);
            return Unit.INSTANCE;
        }
        tradeScreen.topMoneyController.setValidation(true);
        tradeScreen.notifyClick(10, 10, "{\"type\":" + tradeScreen.topMoneyController.getEditTextType() + ",\"money\":\"" + value + "\"}");
        return Unit.INSTANCE;
    }

    private final void initCurrencyOptionIcons() {
        TextView currencyOptionCash = this.binding.currencyOptionCash;
        Intrinsics.checkNotNullExpressionValue(currencyOptionCash, "currencyOptionCash");
        setCurrencyIcon(currencyOptionCash, R.drawable.arizona_dollar);
        TextView currencyOptionBitcoin = this.binding.currencyOptionBitcoin;
        Intrinsics.checkNotNullExpressionValue(currencyOptionBitcoin, "currencyOptionBitcoin");
        setCurrencyIcon(currencyOptionBitcoin, R.drawable.trade_bitcoin_ic);
        TextView currencyOptionAsc = this.binding.currencyOptionAsc;
        Intrinsics.checkNotNullExpressionValue(currencyOptionAsc, "currencyOptionAsc");
        setCurrencyIcon(currencyOptionAsc, R.drawable.trade_asc_ic);
        TextView currencyOptionArizona = this.binding.currencyOptionArizona;
        Intrinsics.checkNotNullExpressionValue(currencyOptionArizona, "currencyOptionArizona");
        setCurrencyIcon(currencyOptionArizona, R.drawable.currency_ic_arizona);
        TextView currencyOptionSp500 = this.binding.currencyOptionSp500;
        Intrinsics.checkNotNullExpressionValue(currencyOptionSp500, "currencyOptionSp500");
        setCurrencyIcon(currencyOptionSp500, R.drawable.bank_currency_ic_sp_500);
    }

    private final void setCurrencyIcon(TextView textView, int i) {
        Drawable drawable = AppCompatResources.getDrawable(textView.getContext(), i);
        if (drawable == null) {
            return;
        }
        int dimensionPixelSize = textView.getResources().getDimensionPixelSize(R.dimen._10sdp);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    private final CharSequence setButtonText(int i) {
        if (i == 0) {
            return TextWithIconsKt.toTextWithIcons("<ic>1<ic> " + getTargetActivity().getString(R.string.trade_money) + " <ic>2<ic>", getTargetActivity(), new IconAndSize(R.drawable.arizona_dollar, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp));
        } else if (i == 1) {
            return TextWithIconsKt.toTextWithIcons("<ic>2<ic> " + getTargetActivity().getString(R.string.arizona_currency) + " <ic>1<ic>", getTargetActivity(), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.currency_ic_arizona, R.dimen._8sdp, R.dimen._8sdp));
        } else if (i == 2) {
            return TextWithIconsKt.toTextWithIcons("<ic>2<ic> " + getTargetActivity().getString(R.string.bitcoin) + " <ic>1<ic>", getTargetActivity(), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.trade_bitcoin_ic, R.dimen._8sdp, R.dimen._8sdp));
        } else if (i == 3) {
            return TextWithIconsKt.toTextWithIcons("<ic>2<ic> " + getTargetActivity().getString(R.string.asc) + " <ic>1<ic>", getTargetActivity(), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.trade_asc_ic, R.dimen._8sdp, R.dimen._8sdp));
        } else if (i == 4) {
            return TextWithIconsKt.toTextWithIcons("<ic>2<ic> " + getTargetActivity().getString(R.string.sp_500) + " <ic>1<ic>", getTargetActivity(), new IconAndSize(R.drawable.hud_capt_arrow_down_ic, R.dimen._8sdp, R.dimen._8sdp), new IconAndSize(R.drawable.bank_currency_ic_sp_500, R.dimen._8sdp, R.dimen._8sdp));
        } else {
            return "";
        }
    }

    private final void defaultScreenState() {
        this.binding.btnSendItem.setEnabled(true);
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
        editValueCostUi(new TradeValueResponse(new ValueStatus(0L, 0), new ValueStatus(0L, 0)));
        this.isConfirmedClicked = false;
        this.topMoneyController.setEnabled(true);
    }

    private final void initAdapters() {
        this.binding.rvInventory.setAdapter(this.tradeInventoryAdapter);
        this.binding.rvSendItems.setAdapter(this.sendItemsAdapter);
        this.binding.rvReceiveItems.setAdapter(this.getItemsAdapter);
    }

    private final void initObservers() {
        boolean isArizonaType = UtilsKt.isArizonaType();
        SendItemsAdapter sendItemsAdapter = this.sendItemsAdapter;
        if (isArizonaType) {
            sendItemsAdapter.setDragDropEnabled(true);
            this.getItemsAdapter.setDragDropEnabled(false);
            createEmptyLists(ArizonaBlockType.BLOCK_TYPE_TRADE.getId(), ArizonaBlockType.BLOCK_TYPE_FOR_TRADE.getId());
        } else {
            sendItemsAdapter.setDragDropEnabled(false);
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
            this.sendItemsList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), i3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, i, null, null, false, false, null, null, null, null, null, null, 134152190, null));
        }
        for (int i4 = 0; i4 < 10; i4++) {
            this.getItemsList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), i4, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, i2, null, null, false, false, null, null, null, null, null, null, 134152190, null));
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            if (MapperKt.isJsonValid(data)) {
                TradeInfo tradeInfo = (TradeInfo) MapperKt.getGson().fromJson(data, (Class<Object>) TradeInfo.class);
                this.binding.tvTitle.setText("Обмен с игроком  " + tradeInfo.getName());
                TradeEditText tradeEditText = this.topMoneyController;
                Map<String, List<Long>> limits = tradeInfo.getLimits();
                if (limits == null) {
                    limits = MapsKt.emptyMap();
                }
                tradeEditText.setLimits(limits);
                defaultScreenState();
                return;
            }
            throw new JsonParseException("Json is not valid");
        } else if (i == 2) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson;
            int type = inventoryResponse.getType();
            List<InventoryItem> items = inventoryResponse.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InventoryItem inventoryItem : items) {
                arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), null, null, false, false, null, null, null, null, null, null, 134152191, null));
            }
            InventoryResponse inventoryResponse2 = new InventoryResponse(type, arrayList, 0, 4, null);
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
            if (MapperKt.isJsonValid(data)) {
                ShowDialogInfo showDialogInfo = (ShowDialogInfo) MapperKt.getGson().fromJson(data, (Class<Object>) ShowDialogInfo.class);
                InventoryItem inventoryItem4 = this.selectedInventoryItem;
                if (inventoryItem4 != null) {
                    new SelectorDialog(getTargetActivity(), 52, InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 134217471, null), 0);
                    return;
                }
                return;
            }
            throw new JsonParseException("Json is not valid");
        } else if (i == 4) {
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"self\"", false, 2, (Object) null)) {
                if (MapperKt.isJsonValid(data)) {
                    editUi((TradeResponse) MapperKt.getGson().fromJson(data, (Class<Object>) TradeResponse.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            }
        } else if (i != 6) {
            if (i == UIElementID.INVENTORY.getId()) {
                if (MapperKt.isJsonValid(data)) {
                    InventoryResponse inventoryResponse3 = (InventoryResponse) MapperKt.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
                    if (inventoryResponse3.getType() == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                        for (InventoryItem inventoryItem5 : inventoryResponse3.getItems()) {
                            List<InventoryItem> list = this.inventoryItemList;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (InventoryItem inventoryItem6 : list) {
                                if (inventoryItem6.getSlot() == inventoryItem5.getSlot()) {
                                    inventoryItem6 = InventoryItem.copy$default(inventoryItem6, 0, null, 0, null, null, null, null, null, null, inventoryItem5.getAvailable(), null, null, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 134217215, null);
                                }
                                arrayList2.add(inventoryItem6);
                            }
                            List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
                            this.inventoryItemList = mutableList;
                            this.tradeInventoryAdapter.submitList(mutableList);
                            this.tradeInventoryAdapter.notifyItemChanged(inventoryItem5.getSlot());
                        }
                        return;
                    }
                    return;
                }
                throw new JsonParseException("Json is not valid");
            }
        } else if (MapperKt.isJsonValid(data)) {
            editValueCostUi((TradeValueResponse) MapperKt.getGson().fromJson(data, (Class<Object>) TradeValueResponse.class));
        } else {
            throw new JsonParseException("Json is not valid");
        }
    }

    private final void sendDataFromDrop(InventoryItem inventoryItem, InventoryItem inventoryItem2) {
        if (inventoryItem.getSlot() == inventoryItem2.getSlot() && inventoryItem.getInventoryType() == inventoryItem2.getInventoryType()) {
            Log.d("TAG_SEND", "GUARD EQUAL ITEMS");
            return;
        }
        int slot = inventoryItem.getSlot();
        int inventoryType = inventoryItem.getInventoryType();
        Long amount = inventoryItem.getAmount();
        long longValue = amount != null ? amount.longValue() : 1L;
        Integer item = inventoryItem.getItem();
        sendData(1, StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(slot, inventoryType, longValue, item != null ? item.intValue() : -1), new ChangeToSlot(inventoryItem2.getSlot(), inventoryItem2.getInventoryType()))));
    }

    private final void editValueCostUi(TradeValueResponse tradeValueResponse) {
        this.binding.btnReceiveItemText.setText(setButtonText(tradeValueResponse.getTarget().getType()));
        this.bottomMoneyController.setType(tradeValueResponse.getTarget().getType());
        if (!UtilsKt.isArizonaType()) {
            this.topMoneyController.setType(tradeValueResponse.getSelf().getType());
        }
        if (!this.topMoneyController.hasFocus() || this.isConfirmedClicked) {
            this.topMoneyController.setValue(tradeValueResponse.getSelf().getValue());
        }
        this.bottomMoneyController.setValue(tradeValueResponse.getTarget().getValue());
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
        this.topMoneyController.setEnabled(tradeResponse.getSelf().getConfirm() == 0);
        this.binding.btnSendItem.setEnabled(tradeResponse.getSelf().getConfirm() == 0);
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
                this.inventoryItemList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), inventoryItem != null ? inventoryItem.getSlot() + 1 : 1, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, null, null, null, null, null, null, 133169150, null));
                if (i == nextMultipleOfFive) {
                    break;
                }
                i++;
            }
        }
        List<InventoryItem> list = this.inventoryItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 134215167, null));
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.TRADE);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new TradeScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    /* compiled from: TradeScreen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeScreen$ShowDialogInfo;", "", "type", "", "slot", "bits", "<init>", "(III)V", "getType", "()I", "getSlot", "getBits", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ShowDialogInfo {
        private final int bits;
        private final int slot;
        private final int type;

        public static /* synthetic */ ShowDialogInfo copy$default(ShowDialogInfo showDialogInfo, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = showDialogInfo.type;
            }
            if ((i4 & 2) != 0) {
                i2 = showDialogInfo.slot;
            }
            if ((i4 & 4) != 0) {
                i3 = showDialogInfo.bits;
            }
            return showDialogInfo.copy(i, i2, i3);
        }

        public final int component1() {
            return this.type;
        }

        public final int component2() {
            return this.slot;
        }

        public final int component3() {
            return this.bits;
        }

        public final ShowDialogInfo copy(int i, int i2, int i3) {
            return new ShowDialogInfo(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowDialogInfo) {
                ShowDialogInfo showDialogInfo = (ShowDialogInfo) obj;
                return this.type == showDialogInfo.type && this.slot == showDialogInfo.slot && this.bits == showDialogInfo.bits;
            }
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.slot)) * 31) + Integer.hashCode(this.bits);
        }

        public String toString() {
            int i = this.type;
            int i2 = this.slot;
            return "ShowDialogInfo(type=" + i + ", slot=" + i2 + ", bits=" + this.bits + ")";
        }

        public ShowDialogInfo(int i, int i2, int i3) {
            this.type = i;
            this.slot = i2;
            this.bits = i3;
        }

        public final int getType() {
            return this.type;
        }

        public final int getSlot() {
            return this.slot;
        }

        public final int getBits() {
            return this.bits;
        }
    }
}

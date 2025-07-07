package ru.mrlargha.commonui.elements.workshop;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.PotionsScreenBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.craft.domain.CraftItemInfo;
import ru.mrlargha.commonui.elements.craft.domain.CraftStart;
import ru.mrlargha.commonui.elements.craft.domain.CraftSuccess;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.workshop.domain.FixingRequest;
import ru.mrlargha.commonui.elements.workshop.domain.PaintingRequest;
import ru.mrlargha.commonui.elements.workshop.domain.SharpenRequest;
import ru.mrlargha.commonui.elements.workshop.domain.WorkshopResponse;
import ru.mrlargha.commonui.elements.workshop.presentation.SelectColorAdapter;
import ru.mrlargha.commonui.elements.workshop.presentation.WorkshopAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: PotionsScreen.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001hB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\u0010\u00108\u001a\u0002052\u0006\u00109\u001a\u00020.H\u0002J\u0010\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020.H\u0002J\u0010\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020.H\u0002J\u0010\u0010@\u001a\u0002052\u0006\u0010?\u001a\u00020.H\u0002J\b\u0010A\u001a\u000205H\u0002J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\u0010\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020.H\u0002J\u0010\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020.H\u0002J\u0010\u0010H\u001a\u0002052\u0006\u0010G\u001a\u00020.H\u0002J\b\u0010I\u001a\u000205H\u0002J\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010L\u001a\u0002052\u0006\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010M\u001a\u0002052\u0006\u0010K\u001a\u00020\u0013H\u0002J(\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020RH\u0002J\b\u0010V\u001a\u000205H\u0002J\u0018\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u0006H\u0016J\u0010\u0010Z\u001a\u0002052\u0006\u0010?\u001a\u00020.H\u0002J\b\u0010[\u001a\u000205H\u0002J\u0018\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020.H\u0002J\u0018\u0010`\u001a\u0002052\u0006\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\u0010\u0010a\u001a\u0002052\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u000205H\u0002J\u0010\u0010e\u001a\u0002052\u0006\u0010;\u001a\u00020.H\u0016J\u0010\u0010f\u001a\u0002052\u0006\u0010;\u001a\u00020.H\u0016J\b\u0010g\u001a\u000205H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n ,*\u0004\u0018\u00010+0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/PotionsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "potionScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/PotionsScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "inventoryItemList", "availableList", "", "inventoryAdapter", "Lru/mrlargha/commonui/elements/workshop/presentation/WorkshopAdapter;", "colorsAdapter", "Lru/mrlargha/commonui/elements/workshop/presentation/SelectColorAdapter;", "selectedColor", "progress", "progressIncrement", "progressHandler", "Landroid/os/Handler;", "incrementHandler", "handler", "getHandler", "()Landroid/os/Handler;", "leftItemIndex", "centerItemIndex", "rightItemIndex", "currentItem", "currentStoneBench", "currentPaintItem", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "currentScreenType", "isDisableAll", "runnable", "Ljava/lang/Runnable;", "btnIsClicked", "clearFields", "", "initViewSize", "clearAllField", "clearItemsMainFieldClicked", "sendRequest", "setCountsVisibility", "visible", "leftItemUi", "isLocked", "btnSharpenEnableStatus", "isEnabled", "btnPaintEnableStatus", "sendRightItemData", "paintingScreenType", "fixingScreenType", "changeInventoryType", "isFixingScreen", "visibilityLeftRightViews", "isVisible", "paintingScreen", "initColors", "updateMainField", "item", "updateRightField", "updateLeftField", "clearViewFromItem", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "message", "", "view", "addLockedItems", "onBackendMessage", "data", "subId", "enableStatusButtons", "refreshData", "startProgressBarAnimation", "time", "", "stop", "sendData", "initItemInfo", "response", "Lru/mrlargha/commonui/elements/workshop/domain/WorkshopResponse;", "getInventoryList", "setVisibility", "setVisible", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PotionsScreen extends SAMPUIElement implements InterfaceController {
    private List<Integer> availableList;
    private final PotionsScreenBinding binding;
    private boolean btnIsClicked;
    private int centerItemIndex;
    private SelectColorAdapter colorsAdapter;
    private InventoryItem currentItem;
    private InventoryItem currentPaintItem;
    private int currentScreenType;
    private InventoryItem currentStoneBench;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final Handler handler;
    private Handler incrementHandler;
    private final WorkshopAdapter inventoryAdapter;
    private List<InventoryItem> inventoryItemList;
    private List<InventoryItem> inventoryList;
    private final boolean isArizonaType;
    private boolean isDisableAll;
    private int leftItemIndex;
    private final ConstraintLayout potionScreen;
    private int progress;
    private Handler progressHandler;
    private final int progressIncrement;
    private int rightItemIndex;
    private Runnable runnable;
    private int selectedColor;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PotionsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.potions_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.potionScreen = constraintLayout;
        PotionsScreenBinding bind = PotionsScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        Activity activity = targetActivity;
        this.db = AppDatabase.Companion.invoke(activity);
        this.inventoryItemList = new ArrayList();
        this.availableList = CollectionsKt.listOf((Object[]) new Integer[]{6366, 7798, 8291});
        WorkshopAdapter workshopAdapter = new WorkshopAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryAdapter$lambda$0;
                inventoryAdapter$lambda$0 = PotionsScreen.inventoryAdapter$lambda$0(PotionsScreen.this, (InventoryItem) obj);
                return inventoryAdapter$lambda$0;
            }
        }, activity);
        this.inventoryAdapter = workshopAdapter;
        this.selectedColor = -1;
        this.progressIncrement = 2;
        this.progressHandler = new Handler();
        this.incrementHandler = new Handler();
        this.handler = new Handler();
        this.leftItemIndex = -1;
        this.centerItemIndex = -1;
        this.rightItemIndex = -1;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 5);
        gridLayoutManager.setItemPrefetchEnabled(false);
        bind.rvMainInventory.setLayoutManager(gridLayoutManager);
        bind.rvMainInventory.setAdapter(workshopAdapter);
        getInventoryList();
        initColors();
        bind.btnSharpenItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen._init_$lambda$1(PotionsScreen.this, view);
            }
        });
        bind.btnPaintItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen._init_$lambda$2(PotionsScreen.this, view);
            }
        });
        bind.mainItemField.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen._init_$lambda$3(PotionsScreen.this, view);
            }
        });
        bind.rightItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen._init_$lambda$4(PotionsScreen.this, view);
            }
        });
        bind.leftItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen._init_$lambda$5(PotionsScreen.this, view);
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PotionsScreen.this.closeScreen();
            }
        });
        bind.successChanceField.nameTextView.setText(targetActivity.getString(R.string.success_chance));
        bind.costField.nameTextView.setText(targetActivity.getString(R.string.cost));
        bind.costFieldPainting.nameTextView.setText(targetActivity.getString(R.string.cost));
        bind.successChanceField.ivValueIcon.setImageResource(R.drawable.ic_percent_16);
        bind.costFieldPainting.ivValueIcon.setImageResource(R.drawable.ic_dollar_16);
        bind.costField.ivValueIcon.setImageResource(R.drawable.ic_dollar_16);
        leftItemUi(true);
        setCountsVisibility(false);
        bind.mainItemField.ivItemImage.setImageResource(R.drawable.ic_empty_item);
        bind.rightItemField.ivItemImage.setImageResource(R.drawable.ic_empty_item);
        initViewSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inventoryAdapter$lambda$0(PotionsScreen potionsScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (CollectionsKt.contains(potionsScreen.availableList, it.getItem())) {
            if (potionsScreen.centerItemIndex == -1) {
                potionsScreen.updateMainField(it);
            } else if (potionsScreen.rightItemIndex == -1) {
                potionsScreen.updateRightField(it);
            }
            potionsScreen.sendData(StringKt.toStringJson(new SharpenRequest(potionsScreen.centerItemIndex, potionsScreen.leftItemIndex, potionsScreen.rightItemIndex)), 1);
        }
        return Unit.INSTANCE;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(PotionsScreen potionsScreen, View view) {
        if (potionsScreen.btnIsClicked) {
            return;
        }
        potionsScreen.sendData(StringKt.toStringJson(0), 2);
        potionsScreen.btnIsClicked = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(PotionsScreen potionsScreen, View view) {
        if (potionsScreen.isArizonaType && potionsScreen.currentScreenType == 1) {
            potionsScreen.sendData(StringKt.toStringJson(0), 4);
        } else {
            potionsScreen.sendData(StringKt.toStringJson(0), 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(PotionsScreen potionsScreen, View view) {
        if (potionsScreen.centerItemIndex == -1) {
            return;
        }
        potionsScreen.clearFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(PotionsScreen potionsScreen, View view) {
        if (potionsScreen.rightItemIndex == -1) {
            return;
        }
        potionsScreen.rightItemIndex = -1;
        potionsScreen.sendRightItemData();
        ImageView ivItemImage = potionsScreen.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvRightItemDescription = potionsScreen.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        TextView tvTitleText = potionsScreen.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        potionsScreen.clearViewFromItem(ivItemImage, tvRightItemDescription, "заточка", tvTitleText);
        potionsScreen.btnSharpenEnableStatus(false);
        potionsScreen.btnPaintEnableStatus(false);
        potionsScreen.currentStoneBench = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(PotionsScreen potionsScreen, View view) {
        if (potionsScreen.leftItemIndex == -1) {
            return;
        }
        potionsScreen.leftItemIndex = -1;
        if (potionsScreen.currentScreenType == 1) {
            potionsScreen.sendData(StringKt.toStringJson(new PaintingRequest(potionsScreen.centerItemIndex, potionsScreen.leftItemIndex, potionsScreen.rightItemIndex, potionsScreen.selectedColor)), 3);
        }
        ImageView ivItemImage = potionsScreen.binding.leftItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvLeftItemDescription = potionsScreen.binding.tvLeftItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
        TextView tvTitleText = potionsScreen.binding.leftItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        potionsScreen.clearViewFromItem(ivItemImage, tvLeftItemDescription, "краска", tvTitleText);
        TextView tvNeedRes = potionsScreen.binding.leftItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
        tvNeedRes.setVisibility(8);
        potionsScreen.btnSharpenEnableStatus(false);
        potionsScreen.btnPaintEnableStatus(false);
        potionsScreen.currentPaintItem = null;
    }

    private final void clearFields() {
        clearItemsMainFieldClicked(true);
        btnSharpenEnableStatus(false);
        btnPaintEnableStatus(false);
        setCountsVisibility(false);
        this.currentStoneBench = null;
        this.currentPaintItem = null;
    }

    private final void initViewSize() {
        double d = getTargetActivity().getResources().getDisplayMetrics().widthPixels;
        int roundToInt = MathKt.roundToInt(0.09d * d);
        ViewGroup.LayoutParams layoutParams = this.binding.leftItemField.item.getLayoutParams();
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt;
        this.binding.leftItemField.item.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.binding.rightItemField.item.getLayoutParams();
        layoutParams2.width = roundToInt;
        layoutParams2.height = roundToInt;
        this.binding.rightItemField.item.setLayoutParams(layoutParams2);
        int roundToInt2 = MathKt.roundToInt(d * 0.15d);
        ViewGroup.LayoutParams layoutParams3 = this.binding.mainItemField.parentLayout.getLayoutParams();
        layoutParams3.width = roundToInt2;
        layoutParams3.height = roundToInt2;
        this.binding.mainItemField.parentLayout.setLayoutParams(layoutParams3);
    }

    private final void clearAllField() {
        ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvMainItemDescription = this.binding.tvMainItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvMainItemDescription, "tvMainItemDescription");
        TextView tvTitleText = this.binding.mainItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage, tvMainItemDescription, "предмет ", tvTitleText);
        ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        TextView tvTitleText2 = this.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
        clearViewFromItem(ivItemImage2, tvRightItemDescription, "заточка ", tvTitleText2);
    }

    private final void clearItemsMainFieldClicked(boolean z) {
        int i = this.currentScreenType;
        if (i == 0) {
            ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            TextView tvMainItemDescription = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription, "tvMainItemDescription");
            TextView tvTitleText = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            clearViewFromItem(ivItemImage, tvMainItemDescription, "предмет ", tvTitleText);
            ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
            TextView tvRightItemDescription = this.binding.tvRightItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
            TextView tvTitleText2 = this.binding.rightItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
            clearViewFromItem(ivItemImage2, tvRightItemDescription, "заточка ", tvTitleText2);
            if (z && this.centerItemIndex != -1) {
                this.centerItemIndex = -1;
                this.rightItemIndex = -1;
                sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
            }
        } else if (i != 1) {
            if (i == 2) {
                ImageView ivItemImage3 = this.binding.mainItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage3, "ivItemImage");
                TextView tvMainItemDescription2 = this.binding.tvMainItemDescription;
                Intrinsics.checkNotNullExpressionValue(tvMainItemDescription2, "tvMainItemDescription");
                TextView tvTitleText3 = this.binding.mainItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText3, "tvTitleText");
                clearViewFromItem(ivItemImage3, tvMainItemDescription2, "предмет ", tvTitleText3);
                if (z && this.centerItemIndex != -1) {
                    this.centerItemIndex = -1;
                    sendData(StringKt.toStringJson(new FixingRequest(this.centerItemIndex)), 5);
                }
                this.inventoryAdapter.setFixingScreen(true);
            }
        } else if (this.isArizonaType) {
            ImageView ivItemImage4 = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage4, "ivItemImage");
            TextView tvMainItemDescription3 = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription3, "tvMainItemDescription");
            TextView tvTitleText4 = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText4, "tvTitleText");
            clearViewFromItem(ivItemImage4, tvMainItemDescription3, "предмет ", tvTitleText4);
            ImageView ivItemImage5 = this.binding.rightItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage5, "ivItemImage");
            TextView tvRightItemDescription2 = this.binding.tvRightItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvRightItemDescription2, "tvRightItemDescription");
            TextView tvTitleText5 = this.binding.rightItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText5, "tvTitleText");
            clearViewFromItem(ivItemImage5, tvRightItemDescription2, "заточка ", tvTitleText5);
            ImageView ivItemImage6 = this.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage6, "ivItemImage");
            TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
            TextView tvTitleText6 = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText6, "tvTitleText");
            clearViewFromItem(ivItemImage6, tvLeftItemDescription, "краска ", tvTitleText6);
            TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
            tvNeedRes.setVisibility(8);
            if (z && this.centerItemIndex != -1) {
                this.centerItemIndex = -1;
                this.rightItemIndex = -1;
                this.leftItemIndex = -1;
                sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
            }
        } else {
            ImageView ivItemImage7 = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage7, "ivItemImage");
            TextView tvMainItemDescription4 = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription4, "tvMainItemDescription");
            TextView tvTitleText7 = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText7, "tvTitleText");
            clearViewFromItem(ivItemImage7, tvMainItemDescription4, "предмет ", tvTitleText7);
            if (z && this.centerItemIndex != -1) {
                this.centerItemIndex = -1;
                sendData(StringKt.toStringJson(new FixingRequest(this.centerItemIndex)), 5);
            }
            this.inventoryAdapter.setFixingScreen(true);
        }
        this.binding.successChanceField.valueTextView.setText("0 ");
        this.binding.costField.valueTextView.setText("0 ");
        this.binding.costFieldPainting.valueTextView.setText("0 ");
        this.currentStoneBench = null;
        this.currentPaintItem = null;
    }

    private final void setCountsVisibility(boolean z) {
        TextView tvStartCount = this.binding.tvStartCount;
        Intrinsics.checkNotNullExpressionValue(tvStartCount, "tvStartCount");
        tvStartCount.setVisibility(z ? 0 : 8);
        TextView tvEndCount = this.binding.tvEndCount;
        Intrinsics.checkNotNullExpressionValue(tvEndCount, "tvEndCount");
        tvEndCount.setVisibility(z ? 0 : 8);
    }

    private final void leftItemUi(boolean z) {
        if (z) {
            this.binding.leftItemField.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            this.binding.tvLeftItemDescription.setText("недоступно ");
            this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.grey_type3));
            TextView tvTitleText = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            tvTitleText.setVisibility(8);
            TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
            tvNeedRes.setVisibility(8);
            this.binding.leftItemField.item.setClickable(false);
            return;
        }
        this.binding.leftItemField.ivItemImage.setImageResource(R.drawable.ic_empty_item);
        this.binding.tvLeftItemDescription.setText("краска ");
        this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.grey_type2));
        this.binding.leftItemField.item.setClickable(true);
    }

    private final void btnSharpenEnableStatus(boolean z) {
        if (z) {
            this.binding.btnSharpenItem.setEnabled(true);
            this.binding.btnSharpenItem.setBackgroundResource(R.drawable.bg_create_item_craft);
            this.binding.btnSharpenItem.setTextColor(getTargetActivity().getResources().getColor(R.color.black));
            return;
        }
        this.binding.btnSharpenItem.setEnabled(false);
        this.binding.btnSharpenItem.setBackgroundResource(R.drawable.bg_success_chance_test);
        this.binding.btnSharpenItem.setTextColor(getTargetActivity().getResources().getColor(R.color.white));
        this.btnIsClicked = false;
    }

    private final void btnPaintEnableStatus(boolean z) {
        if (z) {
            this.binding.btnPaintItem.setEnabled(true);
            this.binding.btnPaintItem.setBackgroundResource(R.drawable.bg_create_item_craft);
            this.binding.btnPaintItem.setTextColor(getTargetActivity().getResources().getColor(R.color.black));
            return;
        }
        this.binding.btnPaintItem.setEnabled(false);
        this.binding.btnPaintItem.setBackgroundResource(R.drawable.bg_success_chance_test);
        this.binding.btnPaintItem.setTextColor(getTargetActivity().getResources().getColor(R.color.white));
    }

    private final void sendRightItemData() {
        int i = this.currentScreenType;
        if (i == 0) {
            sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
        } else if (i == 1) {
            sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
        }
    }

    private final void paintingScreenType() {
        visibilityLeftRightViews(true);
        Group groupWorkbench = this.binding.groupWorkbench;
        Intrinsics.checkNotNullExpressionValue(groupWorkbench, "groupWorkbench");
        groupWorkbench.setVisibility(8);
        paintingScreen(true);
        this.binding.tvTitle.setText("покраска");
        this.binding.btnPaintItem.setText("покрасить");
        leftItemUi(false);
        changeInventoryType(false);
    }

    private final void fixingScreenType() {
        visibilityLeftRightViews(false);
        Group groupWorkbench = this.binding.groupWorkbench;
        Intrinsics.checkNotNullExpressionValue(groupWorkbench, "groupWorkbench");
        groupWorkbench.setVisibility(8);
        paintingScreen(true);
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(this.isArizonaType ? 8 : 0);
        RecyclerView rvColors = this.binding.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(8);
        TextView tvStartCount = this.binding.tvStartCount;
        Intrinsics.checkNotNullExpressionValue(tvStartCount, "tvStartCount");
        tvStartCount.setVisibility(8);
        TextView tvEndCount = this.binding.tvEndCount;
        Intrinsics.checkNotNullExpressionValue(tvEndCount, "tvEndCount");
        tvEndCount.setVisibility(8);
        this.binding.tvTitle.setText("починка");
        this.binding.btnPaintItem.setText("починить");
        changeInventoryType(true);
    }

    private final void changeInventoryType(boolean z) {
        this.inventoryAdapter.setFixingScreen(z);
    }

    private final void visibilityLeftRightViews(boolean z) {
        CardView item = this.binding.leftItemField.item;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        item.setVisibility(z ? 0 : 8);
        TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
        tvLeftItemDescription.setVisibility(z ? 0 : 8);
        CardView item2 = this.binding.rightItemField.item;
        Intrinsics.checkNotNullExpressionValue(item2, "item");
        item2.setVisibility(z ? 0 : 8);
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        tvRightItemDescription.setVisibility(z ? 0 : 8);
    }

    private final void paintingScreen(boolean z) {
        RecyclerView rvColors = this.binding.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout = this.binding.costFieldPainting.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(z ? 0 : 8);
        Button btnPaintItem = this.binding.btnPaintItem;
        Intrinsics.checkNotNullExpressionValue(btnPaintItem, "btnPaintItem");
        btnPaintItem.setVisibility(z ? 0 : 8);
    }

    private final void initColors() {
        List mutableList = CollectionsKt.toMutableList((Collection) ConstantsKt.getColorList());
        this.colorsAdapter = new SelectColorAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initColors$lambda$7;
                initColors$lambda$7 = PotionsScreen.initColors$lambda$7(PotionsScreen.this, ((Integer) obj).intValue(), (ItemColor) obj2);
                return initColors$lambda$7;
            }
        }, getTargetActivity());
        RecyclerView recyclerView = this.binding.rvColors;
        SelectColorAdapter selectColorAdapter = this.colorsAdapter;
        SelectColorAdapter selectColorAdapter2 = null;
        if (selectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter = null;
        }
        recyclerView.setAdapter(selectColorAdapter);
        this.binding.rvColors.setHasFixedSize(true);
        SelectColorAdapter selectColorAdapter3 = this.colorsAdapter;
        if (selectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter3 = null;
        }
        selectColorAdapter3.submitList(mutableList);
        SelectColorAdapter selectColorAdapter4 = this.colorsAdapter;
        if (selectColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
        } else {
            selectColorAdapter2 = selectColorAdapter4;
        }
        selectColorAdapter2.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initColors$lambda$7(PotionsScreen potionsScreen, int i, ItemColor itemColor) {
        Intrinsics.checkNotNullParameter(itemColor, "<unused var>");
        if (potionsScreen.isDisableAll) {
            return Unit.INSTANCE;
        }
        SelectColorAdapter selectColorAdapter = potionsScreen.colorsAdapter;
        SelectColorAdapter selectColorAdapter2 = null;
        if (selectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter = null;
        }
        int selectedItemPosition = selectColorAdapter.getSelectedItemPosition();
        SelectColorAdapter selectColorAdapter3 = potionsScreen.colorsAdapter;
        if (selectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter3 = null;
        }
        selectColorAdapter3.setSelectedItemPosition(i);
        SelectColorAdapter selectColorAdapter4 = potionsScreen.colorsAdapter;
        if (selectColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter4 = null;
        }
        selectColorAdapter4.notifyItemChanged(selectedItemPosition);
        SelectColorAdapter selectColorAdapter5 = potionsScreen.colorsAdapter;
        if (selectColorAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
        } else {
            selectColorAdapter2 = selectColorAdapter5;
        }
        selectColorAdapter2.notifyItemChanged(i);
        potionsScreen.selectedColor = i;
        potionsScreen.sendData(StringKt.toStringJson(new PaintingRequest(potionsScreen.centerItemIndex, potionsScreen.leftItemIndex, potionsScreen.rightItemIndex, potionsScreen.selectedColor)), 3);
        return Unit.INSTANCE;
    }

    private final void updateMainField(InventoryItem inventoryItem) {
        Integer item;
        Ref.IntRef intRef = new Ref.IntRef();
        Integer enchant = inventoryItem.getEnchant();
        intRef.element = enchant != null ? enchant.intValue() : 1;
        String text = inventoryItem.getText();
        if (text != null) {
            String str = text;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "lvl", false, 2, (Object) null)) {
                StringBuilder sb = new StringBuilder();
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                intRef.element = Integer.parseInt(sb.toString());
            }
        }
        this.centerItemIndex = inventoryItem.getSlot();
        if (this.currentScreenType == 0) {
            setCountsVisibility(true);
        } else {
            setCountsVisibility(false);
        }
        TextView textView = this.binding.tvMainItemDescription;
        List<ItemsInfo> itemsName = UtilsKt.getItemsName();
        textView.setText(itemsName.get(inventoryItem.getItem() != null ? item.intValue() : 0).getName() + " ");
        if (this.currentScreenType == 0) {
            this.binding.mainItemField.tvTitleText.setText("+" + intRef.element);
        } else {
            this.binding.mainItemField.tvTitleText.setText(inventoryItem.getText());
        }
        Integer item2 = inventoryItem.getItem();
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, item2 != null ? item2.intValue() : 0, null, 4, null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, iconFromArchive$default);
        }
        this.binding.tvStartCount.setText("+" + intRef.element + " ");
        this.binding.tvEndCount.setText("+" + (intRef.element + 1) + " ");
    }

    private final void updateRightField(InventoryItem inventoryItem) {
        if (inventoryItem.getItem() != null) {
            this.rightItemIndex = inventoryItem.getSlot();
            Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, inventoryItem.getItem().intValue(), null, 4, null);
            if (iconFromArchive$default != null) {
                ImageView ivItemImage = this.binding.rightItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                UtilsKt.setImage(ivItemImage, iconFromArchive$default);
            }
            this.binding.tvRightItemDescription.setText(UtilsKt.getItemsName().get(inventoryItem.getItem().intValue()).getName() + " ");
            btnSharpenEnableStatus(true);
            this.binding.rightItemField.tvTitleText.setText(inventoryItem.getText());
            return;
        }
        this.rightItemIndex = -1;
        ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        TextView tvTitleText = this.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage2, tvRightItemDescription, "заточка ", tvTitleText);
        sendRightItemData();
    }

    private final void updateLeftField(InventoryItem inventoryItem) {
        if (inventoryItem.getItem() != null) {
            this.leftItemIndex = inventoryItem.getSlot();
            Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, inventoryItem.getItem().intValue(), null, 4, null);
            if (iconFromArchive$default != null) {
                ImageView ivItemImage = this.binding.leftItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                UtilsKt.setImage(ivItemImage, iconFromArchive$default);
            }
            this.binding.tvLeftItemDescription.setText(UtilsKt.getItemsName().get(inventoryItem.getItem().intValue()).getName() + " ");
            btnSharpenEnableStatus(true);
            if (inventoryItem.getAmount() == null) {
                this.binding.leftItemField.tvTitleText.setText("1");
                return;
            } else {
                this.binding.leftItemField.tvTitleText.setText(inventoryItem.getText());
                return;
            }
        }
        ImageView ivItemImage2 = this.binding.leftItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
        TextView tvTitleText = this.binding.leftItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage2, tvLeftItemDescription, "покраска ", tvTitleText);
        TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
        tvNeedRes.setVisibility(8);
    }

    private final void clearViewFromItem(ImageView imageView, TextView textView, String str, TextView textView2) {
        imageView.setImageResource(R.drawable.ic_empty_item);
        textView.setText(str);
        textView2.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addLockedItems() {
        List mutableListOf = CollectionsKt.mutableListOf(0);
        this.inventoryItemList.clear();
        List<InventoryItem> list = this.inventoryList;
        if (list != null) {
            List<InventoryItem> list2 = list;
            for (InventoryItem inventoryItem : list2) {
                Log.i("potion_test", String.valueOf(inventoryItem));
                Integer item = inventoryItem.getItem();
                mutableListOf.add(Integer.valueOf(item != null ? item.intValue() : 0));
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (InventoryItem inventoryItem2 : list2) {
                arrayList.add(InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, Integer.valueOf(!CollectionsKt.contains(this.availableList, inventoryItem2.getItem()) ? 1 : 0), null, null, null, null, 0, null, null, false, false, 2095103, null));
            }
            this.inventoryItemList = CollectionsKt.toMutableList((Collection) arrayList);
        }
        this.inventoryAdapter.setArizona(this.isArizonaType);
        this.inventoryAdapter.submitList(CollectionsKt.toList(this.inventoryItemList));
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Object obj;
        Integer itemStrength;
        Object obj2;
        Object obj3;
        Integer amount;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftStart.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            enableStatusButtons(false);
            this.isDisableAll = true;
            startProgressBarAnimation(((CraftStart) fromJson).getTime() - (System.currentTimeMillis() / 1000), false);
            return;
        }
        Runnable runnable = null;
        if (i == 1) {
            clearFields();
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"success\":", false, 2, (Object) null)) {
                Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftSuccess.class);
                Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
                CraftSuccess craftSuccess = (CraftSuccess) fromJson2;
                ImageView ivBgSharpResult = this.binding.ivBgSharpResult;
                Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
                ivBgSharpResult.setVisibility(0);
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PotionsScreen.onBackendMessage$lambda$16(PotionsScreen.this);
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                SelectColorAdapter selectColorAdapter = this.colorsAdapter;
                if (selectColorAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
                    selectColorAdapter = null;
                }
                selectColorAdapter.setSelectedItemPosition(-1);
                SelectColorAdapter selectColorAdapter2 = this.colorsAdapter;
                if (selectColorAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
                    selectColorAdapter2 = null;
                }
                selectColorAdapter2.notifyDataSetChanged();
                this.progress = 0;
                Runnable runnable2 = this.runnable;
                if (runnable2 != null) {
                    Handler handler = this.progressHandler;
                    if (runnable2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("runnable");
                    } else {
                        runnable = runnable2;
                    }
                    handler.removeCallbacks(runnable);
                }
                this.binding.progressBar.clearAnimation();
                this.binding.progressBar.setIndeterminate(false);
                this.binding.progressBar.setProgress(0);
                int success = craftSuccess.getSuccess();
                if (success == 0) {
                    this.binding.ivBgSharpResult.setBackgroundResource(R.drawable.bg_tradeshop_test_red);
                } else if (success == 1) {
                    this.binding.ivBgSharpResult.setBackgroundResource(R.drawable.bg_tradeshop_test_green);
                }
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PotionsScreen.onBackendMessage$lambda$17(PotionsScreen.this);
                    }
                }, 500L);
                enableStatusButtons(true);
                this.isDisableAll = false;
            }
        } else if (i == 2) {
            Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftItemInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
            CraftItemInfo craftItemInfo = (CraftItemInfo) fromJson3;
            int i2 = this.currentScreenType;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    if (craftItemInfo.getAvailable() == 1) {
                        btnPaintEnableStatus(true);
                    } else {
                        btnPaintEnableStatus(false);
                    }
                }
            } else if (craftItemInfo.getAvailable() == 1) {
                btnSharpenEnableStatus(true);
            } else {
                btnSharpenEnableStatus(false);
            }
            this.binding.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
            this.binding.costField.valueTextView.setText(craftItemInfo.getCost() + " ");
            this.binding.costFieldPainting.valueTextView.setText(craftItemInfo.getCost() + " ");
            InventoryItem inventoryItem = this.currentPaintItem;
            int intValue = (inventoryItem == null || (amount = inventoryItem.getAmount()) == null) ? 0 : amount.intValue();
            Integer amount2 = craftItemInfo.getAmount();
            int intValue2 = amount2 != null ? amount2.intValue() : 0;
            if (this.isArizonaType && this.currentScreenType == 1 && this.currentPaintItem != null) {
                TextView tvTitleText = this.binding.leftItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
                tvTitleText.setVisibility(0);
                TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
                Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
                tvNeedRes.setVisibility(0);
                TextView textView = this.binding.leftItemField.tvTitleText;
                InventoryItem inventoryItem2 = this.currentPaintItem;
                textView.setText(String.valueOf(inventoryItem2 != null ? inventoryItem2.getText() : null));
                this.binding.leftItemField.tvNeedRes.setText(RemoteSettings.FORWARD_SLASH_STRING + craftItemInfo.getAmount());
                if (intValue2 > intValue) {
                    this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.red));
                } else {
                    this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.white));
                }
            }
        } else if (i != 3) {
            if (i == UIElementID.INVENTORY.getId()) {
                Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
                InventoryResponse inventoryResponse = (InventoryResponse) fromJson4;
                int type = inventoryResponse.getType();
                List<InventoryItem> items = inventoryResponse.getItems();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                for (InventoryItem inventoryItem3 : items) {
                    int type2 = inventoryResponse.getType();
                    Iterator<T> it = UtilsKt.getItemsName().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        int id = ((ItemsInfo) obj2).getId();
                        Integer item = inventoryItem3.getItem();
                        if (item != null && id == item.intValue()) {
                            break;
                        }
                    }
                    ItemsInfo itemsInfo = (ItemsInfo) obj2;
                    Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
                    Iterator<T> it2 = UtilsKt.getItemsName().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it2.next();
                        int id2 = ((ItemsInfo) obj3).getId();
                        Integer item2 = inventoryItem3.getItem();
                        if (item2 != null && id2 == item2.intValue()) {
                            break;
                        }
                    }
                    ItemsInfo itemsInfo2 = (ItemsInfo) obj3;
                    arrayList.add(InventoryItem.copy$default(inventoryItem3, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type2, itemsInfo2 != null ? Integer.valueOf(itemsInfo2.getAcs_slot()) : null, null, false, false, 1900527, null));
                }
                InventoryResponse inventoryResponse2 = new InventoryResponse(type, arrayList);
                if (inventoryResponse2.getType() == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    for (InventoryItem inventoryItem4 : inventoryResponse2.getItems()) {
                        Iterator<InventoryItem> it3 = this.inventoryItemList.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it3.hasNext()) {
                                i3 = -1;
                                break;
                            } else if (it3.next().getSlot() == inventoryItem4.getSlot()) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        Iterator<T> it4 = this.inventoryItemList.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it4.next();
                            if (((InventoryItem) obj).getSlot() == inventoryItem4.getSlot()) {
                                break;
                            }
                        }
                        InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem4);
                        if (i3 >= 0) {
                            if (inventoryItem4.getItem() != null) {
                                List<InventoryItem> list = this.inventoryItemList;
                                if (updateInventoryItem == null) {
                                    updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                                }
                                list.set(i3, updateInventoryItem);
                            } else {
                                this.inventoryItemList.set(i3, inventoryItem4);
                            }
                        }
                        if (this.isArizonaType && this.currentScreenType == 2 && (itemStrength = inventoryItem4.getItemStrength()) != null && itemStrength.intValue() == 100) {
                            this.binding.mainItemField.parentLayout.performClick();
                        }
                        this.inventoryAdapter.submitList(this.inventoryItemList);
                    }
                }
            }
        } else {
            Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) WorkshopResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
            initItemInfo((WorkshopResponse) fromJson5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$16(PotionsScreen potionsScreen) {
        ImageView ivBgSharpResult = potionsScreen.binding.ivBgSharpResult;
        Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
        ivBgSharpResult.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$17(PotionsScreen potionsScreen) {
        potionsScreen.refreshData();
        potionsScreen.addLockedItems();
    }

    private final void enableStatusButtons(boolean z) {
        this.binding.mainItemField.parentLayout.setEnabled(z);
        this.binding.leftItemField.item.setEnabled(z);
        this.binding.rightItemField.item.setEnabled(z);
        btnSharpenEnableStatus(z);
        btnPaintEnableStatus(z);
    }

    private final void refreshData() {
        InventoryItem inventoryItem;
        Object obj;
        Object obj2;
        Object obj3;
        List<InventoryItem> list = this.inventoryList;
        if (list != null) {
            List<InventoryItem> list2 = list;
            Iterator<T> it = list2.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                InventoryItem inventoryItem2 = (InventoryItem) obj2;
                InventoryItem inventoryItem3 = this.currentItem;
                if (inventoryItem3 != null && inventoryItem2.getSlot() == inventoryItem3.getSlot()) {
                    break;
                }
            }
            this.currentItem = (InventoryItem) obj2;
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                InventoryItem inventoryItem4 = (InventoryItem) obj3;
                InventoryItem inventoryItem5 = this.currentStoneBench;
                if (inventoryItem5 != null && inventoryItem4.getSlot() == inventoryItem5.getSlot()) {
                    break;
                }
            }
            this.currentStoneBench = (InventoryItem) obj3;
            Iterator<T> it3 = list2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                InventoryItem inventoryItem6 = (InventoryItem) next;
                InventoryItem inventoryItem7 = this.currentPaintItem;
                if (inventoryItem7 != null && inventoryItem6.getSlot() == inventoryItem7.getSlot()) {
                    obj = next;
                    break;
                }
            }
            this.currentPaintItem = (InventoryItem) obj;
        }
        InventoryItem inventoryItem8 = this.currentItem;
        if (inventoryItem8 != null) {
            updateMainField(inventoryItem8);
        }
        InventoryItem inventoryItem9 = this.currentStoneBench;
        if (inventoryItem9 != null) {
            updateRightField(inventoryItem9);
        }
        if (this.isArizonaType && this.currentScreenType == 1 && (inventoryItem = this.currentPaintItem) != null) {
            updateLeftField(inventoryItem);
        }
    }

    private final void startProgressBarAnimation(final long j, boolean z) {
        this.progress = 0;
        this.binding.progressBar.setMax(100);
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.PotionsScreen$startProgressBarAnimation$1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                PotionsScreenBinding potionsScreenBinding;
                int i2;
                int i3;
                int i4;
                Handler handler;
                i = PotionsScreen.this.progress;
                if (i <= 100) {
                    potionsScreenBinding = PotionsScreen.this.binding;
                    ProgressBar progressBar = potionsScreenBinding.progressBar;
                    i2 = PotionsScreen.this.progress;
                    progressBar.setProgress(i2);
                    PotionsScreen potionsScreen = PotionsScreen.this;
                    i3 = potionsScreen.progress;
                    i4 = PotionsScreen.this.progressIncrement;
                    potionsScreen.progress = i3 + i4;
                    handler = PotionsScreen.this.progressHandler;
                    handler.postDelayed(this, j / 50);
                }
            }
        };
        this.runnable = runnable;
        this.progressHandler.postDelayed(runnable, 0L);
    }

    private final void sendData(String str, int i) {
        Log.d("TAG_WORKSHOP", "data: " + str + " ===  subId : " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.POTIONS.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void initItemInfo(WorkshopResponse workshopResponse) {
        this.binding.successChanceField.valueTextView.setText(String.valueOf(workshopResponse.getChance()));
        this.binding.costField.valueTextView.setText(String.valueOf(workshopResponse.getCost()));
    }

    private final void getInventoryList() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PotionsScreen$getInventoryList$1(this, null), 3, null);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
    }

    /* compiled from: PotionsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/PotionsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new PotionsScreen(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.POTIONS.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }
}

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
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.WorkshopScreenBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.craft.domain.CraftItemInfo;
import ru.mrlargha.commonui.elements.craft.domain.CraftStart;
import ru.mrlargha.commonui.elements.craft.domain.CraftSuccess;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.BlockType;
import ru.mrlargha.commonui.elements.workshop.domain.CategoryRequest;
import ru.mrlargha.commonui.elements.workshop.domain.FixingRequest;
import ru.mrlargha.commonui.elements.workshop.domain.PaintingRequest;
import ru.mrlargha.commonui.elements.workshop.domain.SharpenRequest;
import ru.mrlargha.commonui.elements.workshop.domain.WorkshopResourceAmount;
import ru.mrlargha.commonui.elements.workshop.domain.WorkshopResponse;
import ru.mrlargha.commonui.elements.workshop.presentation.SelectColorAdapter;
import ru.mrlargha.commonui.elements.workshop.presentation.WorkshopAdapter;
import ru.mrlargha.commonui.elements.workshop.presentation.WorkshopMenuAdapter;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.RodinaItemTypes;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: WorkshopScreen.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001lB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u001eH\u0002J\u0010\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u001eH\u0002J\u0010\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u001eH\u0002J\u0010\u0010A\u001a\u0002082\u0006\u0010@\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u000208H\u0002J\u0010\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u0006H\u0002J\b\u0010E\u001a\u000208H\u0002J\b\u0010F\u001a\u000208H\u0002J\b\u0010G\u001a\u000208H\u0002J\b\u0010H\u001a\u000208H\u0002J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0010\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020\u001eH\u0002J\u0010\u0010M\u001a\u0002082\u0006\u0010L\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u000208H\u0002J\u0010\u0010O\u001a\u0002082\u0006\u0010P\u001a\u00020\u0013H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010P\u001a\u00020\u0013H\u0002J\u0010\u0010R\u001a\u0002082\u0006\u0010P\u001a\u00020\u0013H\u0002J\u0012\u0010S\u001a\u0002082\b\u0010P\u001a\u0004\u0018\u00010\u0013H\u0002J(\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020XH\u0002J\b\u0010\\\u001a\u000208H\u0002J\u0018\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020\u0006H\u0016J\u0010\u0010`\u001a\u0002082\u0006\u0010@\u001a\u00020\u001eH\u0002J\b\u0010a\u001a\u000208H\u0002J\u0018\u0010b\u001a\u0002082\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001eH\u0002J\u0018\u0010f\u001a\u0002082\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020\u0006H\u0002J\u0010\u0010g\u001a\u0002082\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u0002082\u0006\u0010<\u001a\u00020\u001eH\u0016J\b\u0010k\u001a\u000208H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n 0*\u0004\u0018\u00010/0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/WorkshopScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "workshopScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/WorkshopScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getInventoryList", "()Ljava/util/List;", "inventoryItemList", "inventoryAdapter", "Lru/mrlargha/commonui/elements/workshop/presentation/WorkshopAdapter;", "workShopMenuAdapter", "Lru/mrlargha/commonui/elements/workshop/presentation/WorkshopMenuAdapter;", "colorsAdapter", "Lru/mrlargha/commonui/elements/workshop/presentation/SelectColorAdapter;", "isFix", "", "selectedColor", "progress", "progressIncrement", "progressHandler", "Landroid/os/Handler;", "incrementHandler", "handler", "getHandler", "()Landroid/os/Handler;", "leftItemIndex", "centerItemIndex", "rightItemIndex", "currentMainItem", "currentRightItem", "currentLeftItem", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "currentScreenType", "isDisableAll", "runnable", "Ljava/lang/Runnable;", "btnIsClicked", "initViewSize", "", "clearItemsMainFieldClicked", "sendRequest", "setCountsVisibility", "visible", "leftItemUi", "isLocked", "btnSharpenEnableStatus", "isEnabled", "btnPaintEnableStatus", "initMenu", "setScreenVisibility", "menuPosition", "sendItemData", "undevelopedScreenType", "paintingScreenType", "fixingScreenType", "changeInventoryType", "isFixingScreen", "visibilityLeftRightViews", "isVisible", "paintingScreen", "initColors", "clickedItem", "item", "updateMainField", "updateRightField", "updateLeftField", "clearViewFromItem", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "message", "", "view", "addLockedItems", "onBackendMessage", "data", "subId", "enableStatusButtons", "refreshData", "startProgressBarAnimation", "time", "", "stop", "sendData", "initItemInfo", "response", "Lru/mrlargha/commonui/elements/workshop/domain/WorkshopResponse;", "setVisible", "closeScreen", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkshopScreen extends SAMPUIElement implements InterfaceController {
    private final WorkshopScreenBinding binding;
    private boolean btnIsClicked;
    private int centerItemIndex;
    private SelectColorAdapter colorsAdapter;
    private InventoryItem currentLeftItem;
    private InventoryItem currentMainItem;
    private InventoryItem currentRightItem;
    private int currentScreenType;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final Handler handler;
    private Handler incrementHandler;
    private final WorkshopAdapter inventoryAdapter;
    private List<InventoryItem> inventoryItemList;
    private final boolean isArizonaType;
    private boolean isDisableAll;
    private boolean isFix;
    private int leftItemIndex;
    private int progress;
    private Handler progressHandler;
    private final int progressIncrement;
    private int rightItemIndex;
    private Runnable runnable;
    private int selectedColor;
    private final SharedPreferences sharedPref;
    private WorkshopMenuAdapter workShopMenuAdapter;
    private final ConstraintLayout workshopScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkshopScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        WorkshopMenuAdapter workshopMenuAdapter = null;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.workshop_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.workshopScreen = constraintLayout;
        WorkshopScreenBinding bind = WorkshopScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        Activity activity = targetActivity;
        this.db = AppDatabase.Companion.invoke(activity);
        this.inventoryItemList = new ArrayList();
        this.inventoryAdapter = new WorkshopAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryAdapter$lambda$0;
                inventoryAdapter$lambda$0 = WorkshopScreen.inventoryAdapter$lambda$0(WorkshopScreen.this, (InventoryItem) obj);
                return inventoryAdapter$lambda$0;
            }
        }, activity);
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
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        addLockedItems();
        initMenu();
        initColors();
        bind.btnSharpenItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$1(WorkshopScreen.this, view);
            }
        });
        bind.btnPaintItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$2(WorkshopScreen.this, view);
            }
        });
        bind.mainItemField.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$3(WorkshopScreen.this, view);
            }
        });
        bind.rightItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$4(WorkshopScreen.this, view);
            }
        });
        bind.leftItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$5(WorkshopScreen.this, view);
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen.this.closeScreen();
            }
        });
        WorkshopMenuAdapter workshopMenuAdapter2 = this.workShopMenuAdapter;
        if (workshopMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
        } else {
            workshopMenuAdapter = workshopMenuAdapter2;
        }
        if (workshopMenuAdapter.getItemCount() > 0) {
            bind.rvMenu.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    WorkshopScreen._init_$lambda$7(WorkshopScreen.this);
                }
            });
        }
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

    private final List<InventoryItem> getInventoryList() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new WorkshopScreen$inventoryList$1(this, null), 1, null);
        return (List) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r0 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit inventoryAdapter$lambda$0(WorkshopScreen workshopScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (workshopScreen.isDisableAll) {
            return Unit.INSTANCE;
        }
        Log.e("workshop", String.valueOf(workshopScreen.currentScreenType));
        int i = workshopScreen.currentScreenType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    workshopScreen.sendData(StringKt.toStringJson(new FixingRequest(it.getSlot())), 5);
                    workshopScreen.updateMainField(it);
                }
            } else if (workshopScreen.isArizonaType) {
                workshopScreen.clickedItem(it);
                workshopScreen.sendData(StringKt.toStringJson(new PaintingRequest(workshopScreen.centerItemIndex, workshopScreen.leftItemIndex, workshopScreen.rightItemIndex, workshopScreen.selectedColor)), 3);
            } else {
                workshopScreen.sendData(StringKt.toStringJson(new FixingRequest(it.getSlot())), 5);
                workshopScreen.updateMainField(it);
            }
            return Unit.INSTANCE;
        }
        workshopScreen.clickedItem(it);
        workshopScreen.sendData(StringKt.toStringJson(new SharpenRequest(workshopScreen.centerItemIndex, workshopScreen.leftItemIndex, workshopScreen.rightItemIndex)), 1);
        return Unit.INSTANCE;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(WorkshopScreen workshopScreen, View view) {
        workshopScreen.sendData(StringKt.toStringJson(0), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.isArizonaType && workshopScreen.currentScreenType == 1) {
            workshopScreen.sendData(StringKt.toStringJson(0), 4);
        } else {
            workshopScreen.sendData(StringKt.toStringJson(0), 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.centerItemIndex == -1) {
            return;
        }
        workshopScreen.currentMainItem = null;
        workshopScreen.currentRightItem = null;
        workshopScreen.currentLeftItem = null;
        workshopScreen.clearItemsMainFieldClicked(true);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.setCountsVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.rightItemIndex == -1) {
            return;
        }
        workshopScreen.rightItemIndex = -1;
        workshopScreen.sendItemData();
        ImageView ivItemImage = workshopScreen.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvRightItemDescription = workshopScreen.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        TextView tvTitleText = workshopScreen.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        workshopScreen.clearViewFromItem(ivItemImage, tvRightItemDescription, "заточка", tvTitleText);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.currentRightItem = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.leftItemIndex == -1) {
            return;
        }
        workshopScreen.leftItemIndex = -1;
        workshopScreen.sendItemData();
        workshopScreen.updateLeftField(null);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.currentLeftItem = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(WorkshopScreen workshopScreen) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = workshopScreen.binding.rvMenu.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
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
            updateLeftField(null);
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
            } else if (i == 3) {
                ImageView ivItemImage4 = this.binding.mainItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage4, "ivItemImage");
                TextView tvMainItemDescription3 = this.binding.tvMainItemDescription;
                Intrinsics.checkNotNullExpressionValue(tvMainItemDescription3, "tvMainItemDescription");
                TextView tvTitleText4 = this.binding.mainItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText4, "tvTitleText");
                clearViewFromItem(ivItemImage4, tvMainItemDescription3, "предмет", tvTitleText4);
                ImageView ivItemImage5 = this.binding.rightItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage5, "ivItemImage");
                TextView tvRightItemDescription2 = this.binding.tvRightItemDescription;
                Intrinsics.checkNotNullExpressionValue(tvRightItemDescription2, "tvRightItemDescription");
                TextView tvTitleText5 = this.binding.rightItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText5, "tvTitleText");
                clearViewFromItem(ivItemImage5, tvRightItemDescription2, "инструкция", tvTitleText5);
                if (z && this.centerItemIndex != -1) {
                    this.centerItemIndex = -1;
                    this.rightItemIndex = -1;
                    sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
                }
            }
        } else if (this.isArizonaType) {
            ImageView ivItemImage6 = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage6, "ivItemImage");
            TextView tvMainItemDescription4 = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription4, "tvMainItemDescription");
            TextView tvTitleText6 = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText6, "tvTitleText");
            clearViewFromItem(ivItemImage6, tvMainItemDescription4, "предмет ", tvTitleText6);
            ImageView ivItemImage7 = this.binding.rightItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage7, "ivItemImage");
            TextView tvRightItemDescription3 = this.binding.tvRightItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvRightItemDescription3, "tvRightItemDescription");
            TextView tvTitleText7 = this.binding.rightItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText7, "tvTitleText");
            clearViewFromItem(ivItemImage7, tvRightItemDescription3, "заточка ", tvTitleText7);
            updateLeftField(null);
            if (z && this.centerItemIndex != -1) {
                this.centerItemIndex = -1;
                this.rightItemIndex = -1;
                this.leftItemIndex = -1;
                sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
            }
        } else {
            ImageView ivItemImage8 = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage8, "ivItemImage");
            TextView tvMainItemDescription5 = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription5, "tvMainItemDescription");
            TextView tvTitleText8 = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText8, "tvTitleText");
            clearViewFromItem(ivItemImage8, tvMainItemDescription5, "предмет ", tvTitleText8);
            if (z && this.centerItemIndex != -1) {
                this.centerItemIndex = -1;
                sendData(StringKt.toStringJson(new FixingRequest(this.centerItemIndex)), 5);
            }
            this.inventoryAdapter.setFixingScreen(true);
        }
        this.binding.successChanceField.valueTextView.setText("0.0 ");
        this.binding.costField.valueTextView.setText("0 ");
        this.binding.costFieldPainting.valueTextView.setText("0 ");
        this.currentRightItem = null;
        this.currentLeftItem = null;
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
        if (this.currentScreenType == 0) {
            this.binding.tvLeftItemDescription.setText("супер-заточка ");
        } else {
            this.binding.tvLeftItemDescription.setText("краска ");
        }
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

    private final void initMenu() {
        this.workShopMenuAdapter = new WorkshopMenuAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initMenu$lambda$8;
                initMenu$lambda$8 = WorkshopScreen.initMenu$lambda$8(WorkshopScreen.this, ((Integer) obj).intValue());
                return initMenu$lambda$8;
            }
        });
        RecyclerView recyclerView = this.binding.rvMenu;
        WorkshopMenuAdapter workshopMenuAdapter = this.workShopMenuAdapter;
        WorkshopMenuAdapter workshopMenuAdapter2 = null;
        if (workshopMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter = null;
        }
        recyclerView.setAdapter(workshopMenuAdapter);
        this.binding.rvMenu.setHasFixedSize(true);
        if (this.isArizonaType) {
            WorkshopMenuAdapter workshopMenuAdapter3 = this.workShopMenuAdapter;
            if (workshopMenuAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            } else {
                workshopMenuAdapter2 = workshopMenuAdapter3;
            }
            workshopMenuAdapter2.submitList(CollectionsKt.listOf((Object[]) new String[]{"заточка", "покраска", "починка", "разбор"}));
            return;
        }
        WorkshopMenuAdapter workshopMenuAdapter4 = this.workShopMenuAdapter;
        if (workshopMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
        } else {
            workshopMenuAdapter2 = workshopMenuAdapter4;
        }
        workshopMenuAdapter2.submitList(CollectionsKt.listOf((Object[]) new String[]{"заточка", "починка"}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMenu$lambda$8(WorkshopScreen workshopScreen, int i) {
        boolean z = i == 1;
        workshopScreen.isFix = z;
        Log.e("workshop", "initMenu:  " + z);
        if (workshopScreen.isDisableAll) {
            return Unit.INSTANCE;
        }
        WorkshopMenuAdapter workshopMenuAdapter = workshopScreen.workShopMenuAdapter;
        WorkshopMenuAdapter workshopMenuAdapter2 = null;
        if (workshopMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter = null;
        }
        int selectedItemPosition = workshopMenuAdapter.getSelectedItemPosition();
        WorkshopMenuAdapter workshopMenuAdapter3 = workshopScreen.workShopMenuAdapter;
        if (workshopMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter3 = null;
        }
        workshopMenuAdapter3.setSelectedItemPosition(i);
        WorkshopMenuAdapter workshopMenuAdapter4 = workshopScreen.workShopMenuAdapter;
        if (workshopMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter4 = null;
        }
        workshopMenuAdapter4.notifyItemChanged(selectedItemPosition);
        WorkshopMenuAdapter workshopMenuAdapter5 = workshopScreen.workShopMenuAdapter;
        if (workshopMenuAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
        } else {
            workshopMenuAdapter2 = workshopMenuAdapter5;
        }
        workshopMenuAdapter2.notifyItemChanged(i);
        workshopScreen.setScreenVisibility(i);
        workshopScreen.clearItemsMainFieldClicked(true);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.sendData(StringKt.toStringJson(new CategoryRequest(workshopScreen.currentScreenType)), 7);
        return Unit.INSTANCE;
    }

    private final void setScreenVisibility(int i) {
        this.currentScreenType = i;
        if (i == 0) {
            Group groupWorkbench = this.binding.groupWorkbench;
            Intrinsics.checkNotNullExpressionValue(groupWorkbench, "groupWorkbench");
            groupWorkbench.setVisibility(0);
            paintingScreen(false);
            visibilityLeftRightViews(true);
            this.binding.tvTitle.setText("заточка");
            leftItemUi(true);
            changeInventoryType(false);
            sendData(StringKt.toStringJson(new BlockType(0)), 7);
            this.binding.btnSharpenItem.setText("Заточить предмет");
            this.binding.tvTitleDescription.setText("Перенесите предмет и камень заточки в необходимые ячейки");
        } else if (i == 1) {
            if (this.isArizonaType) {
                paintingScreenType();
                sendData(StringKt.toStringJson(new BlockType(2)), 7);
                return;
            }
            fixingScreenType();
            sendData(StringKt.toStringJson(new BlockType(1)), 7);
        } else if (i == 2) {
            fixingScreenType();
            sendData(StringKt.toStringJson(new BlockType(1)), 7);
        } else if (i != 3) {
        } else {
            undevelopedScreenType();
        }
    }

    private final void sendItemData() {
        int i = this.currentScreenType;
        if (i == 0 || i == 3) {
            sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
        } else if (i == 1) {
            sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
        }
    }

    private final void undevelopedScreenType() {
        visibilityLeftRightViews(true);
        Group groupWorkbench = this.binding.groupWorkbench;
        Intrinsics.checkNotNullExpressionValue(groupWorkbench, "groupWorkbench");
        groupWorkbench.setVisibility(0);
        paintingScreen(false);
        this.binding.tvTitle.setText("Разбор предмета");
        leftItemUi(true);
        changeInventoryType(false);
        ImageView ivItemImage = this.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        TextView tvTitleText = this.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage, tvRightItemDescription, "инструкция", tvTitleText);
        this.binding.tvTitleDescription.setText("Перенесите инструкцию для разбора и предмет в необходимые ячейки");
        this.binding.btnSharpenItem.setText("Разобрать предмет");
    }

    private final void paintingScreenType() {
        visibilityLeftRightViews(true);
        Group groupWorkbench = this.binding.groupWorkbench;
        Intrinsics.checkNotNullExpressionValue(groupWorkbench, "groupWorkbench");
        groupWorkbench.setVisibility(8);
        paintingScreen(true);
        this.binding.tvTitle.setText("покраска");
        this.binding.btnPaintItem.setText("покрасить");
        this.binding.tvTitleDescription.setText("");
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
        this.binding.tvTitleDescription.setText("");
        changeInventoryType(true);
    }

    private final void changeInventoryType(boolean z) {
        this.inventoryAdapter.setFixingScreen(z);
        this.inventoryAdapter.notifyDataSetChanged();
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
        this.colorsAdapter = new SelectColorAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initColors$lambda$9;
                initColors$lambda$9 = WorkshopScreen.initColors$lambda$9(WorkshopScreen.this, ((Integer) obj).intValue(), (ItemColor) obj2);
                return initColors$lambda$9;
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
    public static final Unit initColors$lambda$9(WorkshopScreen workshopScreen, int i, ItemColor itemColor) {
        Intrinsics.checkNotNullParameter(itemColor, "<unused var>");
        if (workshopScreen.isDisableAll) {
            return Unit.INSTANCE;
        }
        SelectColorAdapter selectColorAdapter = workshopScreen.colorsAdapter;
        SelectColorAdapter selectColorAdapter2 = null;
        if (selectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter = null;
        }
        int selectedItemPosition = selectColorAdapter.getSelectedItemPosition();
        SelectColorAdapter selectColorAdapter3 = workshopScreen.colorsAdapter;
        if (selectColorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter3 = null;
        }
        selectColorAdapter3.setSelectedItemPosition(i);
        SelectColorAdapter selectColorAdapter4 = workshopScreen.colorsAdapter;
        if (selectColorAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter4 = null;
        }
        selectColorAdapter4.notifyItemChanged(selectedItemPosition);
        SelectColorAdapter selectColorAdapter5 = workshopScreen.colorsAdapter;
        if (selectColorAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
        } else {
            selectColorAdapter2 = selectColorAdapter5;
        }
        selectColorAdapter2.notifyItemChanged(i);
        workshopScreen.selectedColor = i;
        workshopScreen.sendData(StringKt.toStringJson(new PaintingRequest(workshopScreen.centerItemIndex, workshopScreen.leftItemIndex, workshopScreen.rightItemIndex, workshopScreen.selectedColor)), 3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r0.intValue() != r1) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void clickedItem(InventoryItem inventoryItem) {
        Integer item_type;
        int i;
        InventoryItem inventoryItem2;
        Integer enchant;
        Log.d("TAG_WORKSHOP", "clicked item " + StringKt.toStringJson(inventoryItem));
        Integer item = inventoryItem.getItem();
        int id = ItemTypes.ITEM_DISASSEMBLY_INSTRUCTION.getId();
        if (item == null || item.intValue() != id) {
            int id2 = ItemTypes.ITEM_DISASSEMBLY_YELLOW_INSTRUCTION.getId();
            if (item == null || item.intValue() != id2) {
                int id3 = ItemTypes.ITEM_DISASSEMBLY_SKIN_INSTRUCTION.getId();
                if (item != null) {
                }
                item_type = inventoryItem.getItem_type();
                int id4 = RodinaItemTypes.ITEM_TYPE_ATTACH.getId();
                if (item_type != null || item_type.intValue() != id4) {
                    int id5 = RodinaItemTypes.ITEM_TYPE_SKIN.getId();
                    if (item_type != null || item_type.intValue() != id5) {
                        int id6 = ItemTypes.ITEM_TYPE_ACCESSORIES.getId();
                        if (item_type != null || item_type.intValue() != id6) {
                            int id7 = ItemTypes.ITEM_TYPE_IMPROV.getId();
                            if (item_type != null || item_type.intValue() != id7) {
                                int id8 = ItemTypes.ITEM_TYPE_SKIN.getId();
                                if (item_type != null || item_type.intValue() != id8) {
                                    int id9 = ItemTypes.ITEM_TYPE_STRIPE.getId();
                                    if (item_type != null || item_type.intValue() != id9) {
                                        int id10 = ItemTypes.ITEM_TYPE_COLORANT.getId();
                                        if (item_type != null && item_type.intValue() == id10) {
                                            if (this.currentScreenType != 1) {
                                                updateLeftField(inventoryItem);
                                                this.leftItemIndex = inventoryItem.getSlot();
                                                this.currentLeftItem = inventoryItem;
                                                Integer item2 = inventoryItem.getItem();
                                                Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, item2 != null ? item2.intValue() : 0, null, 4, null);
                                                if (iconFromArchive$default != null) {
                                                    ImageView ivItemImage = this.binding.leftItemField.ivItemImage;
                                                    Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                                                    UtilsKt.setImage(ivItemImage, iconFromArchive$default);
                                                }
                                                TextView textView = this.binding.tvLeftItemDescription;
                                                List<ItemsInfo> itemsName = UtilsKt.getItemsName();
                                                Integer item3 = inventoryItem.getItem();
                                                textView.setText(itemsName.get(item3 != null ? item3.intValue() : 0).getName() + " ");
                                                btnPaintEnableStatus(true);
                                                return;
                                            }
                                            return;
                                        }
                                        int id11 = RodinaItemTypes.ITEM_TYPE_ENCHANT.getId();
                                        if (item_type != null || item_type.intValue() != id11) {
                                            int id12 = ItemTypes.ITEM_TYPE_ENCHANT.getId();
                                            if (item_type != null || item_type.intValue() != id12) {
                                                int id13 = ItemTypes.ITEM_TYPE_ARMOUR_SHARPENING.getId();
                                                if (item_type != null || item_type.intValue() != id13) {
                                                    int id14 = ItemTypes.ITEM_TYPE_SUPER_ENCHANTED.getId();
                                                    if (item_type == null && item_type.intValue() == id14 && this.currentScreenType == 0) {
                                                        inventoryItem2 = this.currentMainItem;
                                                        if (inventoryItem2 != null && (enchant = inventoryItem2.getEnchant()) != null) {
                                                            i = enchant.intValue();
                                                        }
                                                        if (i < 12) {
                                                            updateLeftField(inventoryItem);
                                                            this.currentLeftItem = inventoryItem;
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                        updateRightField(inventoryItem);
                                        this.currentRightItem = inventoryItem;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                updateMainField(inventoryItem);
                this.currentMainItem = inventoryItem;
                updateLeftField(this.currentLeftItem);
                return;
            }
        }
        updateRightField(inventoryItem);
        this.currentRightItem = inventoryItem;
        item_type = inventoryItem.getItem_type();
        int id42 = RodinaItemTypes.ITEM_TYPE_ATTACH.getId();
        if (item_type != null) {
        }
        int id52 = RodinaItemTypes.ITEM_TYPE_SKIN.getId();
        if (item_type != null) {
        }
        int id62 = ItemTypes.ITEM_TYPE_ACCESSORIES.getId();
        if (item_type != null) {
        }
        int id72 = ItemTypes.ITEM_TYPE_IMPROV.getId();
        if (item_type != null) {
        }
        int id82 = ItemTypes.ITEM_TYPE_SKIN.getId();
        if (item_type != null) {
        }
        int id92 = ItemTypes.ITEM_TYPE_STRIPE.getId();
        if (item_type != null) {
        }
        int id102 = ItemTypes.ITEM_TYPE_COLORANT.getId();
        if (item_type != null) {
            if (this.currentScreenType != 1) {
            }
        }
        int id112 = RodinaItemTypes.ITEM_TYPE_ENCHANT.getId();
        if (item_type != null) {
        }
        int id122 = ItemTypes.ITEM_TYPE_ENCHANT.getId();
        if (item_type != null) {
        }
        int id132 = ItemTypes.ITEM_TYPE_ARMOUR_SHARPENING.getId();
        if (item_type != null) {
        }
        int id142 = ItemTypes.ITEM_TYPE_SUPER_ENCHANTED.getId();
        if (item_type == null) {
            return;
        }
        inventoryItem2 = this.currentMainItem;
        if (inventoryItem2 != null) {
            i = enchant.intValue();
        }
        if (i < 12) {
        }
    }

    private final void updateMainField(InventoryItem inventoryItem) {
        Integer enchant = inventoryItem.getEnchant();
        int intValue = enchant != null ? enchant.intValue() : 0;
        this.centerItemIndex = inventoryItem.getSlot();
        int i = this.currentScreenType;
        if (i == 0 || i == 3) {
            setCountsVisibility(true);
        } else {
            setCountsVisibility(false);
        }
        int size = UtilsKt.getItemsName().size();
        Integer item = inventoryItem.getItem();
        if (size > (item != null ? item.intValue() : 0)) {
            TextView textView = this.binding.tvMainItemDescription;
            List<ItemsInfo> itemsName = UtilsKt.getItemsName();
            Integer item2 = inventoryItem.getItem();
            textView.setText(itemsName.get(item2 != null ? item2.intValue() : 0).getName() + " ");
        }
        if (this.currentScreenType == 0) {
            this.binding.mainItemField.tvTitleText.setText("+" + intValue);
        } else {
            this.binding.mainItemField.tvTitleText.setText(inventoryItem.getText());
        }
        Integer item3 = inventoryItem.getItem();
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, item3 != null ? item3.intValue() : 0, null, 4, null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, iconFromArchive$default);
        }
        this.binding.tvStartCount.setText("+" + intValue + " ");
        this.binding.tvEndCount.setText("+" + (intValue + 1) + " ");
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
        sendItemData();
    }

    private final void updateLeftField(InventoryItem inventoryItem) {
        Integer enchant;
        if ((inventoryItem != null ? inventoryItem.getItem() : null) == null) {
            this.leftItemIndex = -1;
            int i = this.currentScreenType;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                leftItemUi(false);
                return;
            }
            InventoryItem inventoryItem2 = this.currentMainItem;
            if (((inventoryItem2 == null || (enchant = inventoryItem2.getEnchant()) == null) ? 0 : enchant.intValue()) >= 12) {
                leftItemUi(false);
                return;
            } else {
                leftItemUi(true);
                return;
            }
        }
        this.leftItemIndex = inventoryItem.getSlot();
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, inventoryItem.getItem().intValue(), null, 4, null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage = this.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, iconFromArchive$default);
        }
        this.binding.tvLeftItemDescription.setText(UtilsKt.getItemsName().get(inventoryItem.getItem().intValue()).getName() + " ");
        this.binding.leftItemField.tvTitleText.setText(inventoryItem.getText());
    }

    private final void clearViewFromItem(ImageView imageView, TextView textView, String str, TextView textView2) {
        imageView.setImageResource(R.drawable.ic_empty_item);
        textView.setText(str);
        textView2.setText("");
    }

    private final void addLockedItems() {
        this.binding.rvMainInventory.setAdapter(this.inventoryAdapter);
        this.inventoryItemList.clear();
        int nextMultipleOfFive = UtilsKt.nextMultipleOfFive(getInventoryList().size()) - getInventoryList().size();
        this.inventoryItemList = getInventoryList();
        if (1 <= nextMultipleOfFive) {
            int i = 1;
            while (true) {
                this.inventoryItemList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), ((InventoryItem) CollectionsKt.last((List<? extends Object>) this.inventoryItemList)).getSlot() + 1, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
                if (i == nextMultipleOfFive) {
                    break;
                }
                i++;
            }
        }
        List<InventoryItem> list = this.inventoryItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        this.inventoryItemList = CollectionsKt.toMutableList((Collection) arrayList);
        this.inventoryAdapter.setArizona(this.isArizonaType);
        this.inventoryAdapter.submitList(this.inventoryItemList);
        this.inventoryAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x011e, code lost:
        if (r2 != 3) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b9  */
    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBackendMessage(String data, int i) {
        Object obj;
        Integer itemStrength;
        Object obj2;
        Object obj3;
        Integer amount;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_WORKSHOP", "data: " + data + " ======= subID: " + i);
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
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"success\":", false, 2, (Object) null)) {
                Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftSuccess.class);
                Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
                CraftSuccess craftSuccess = (CraftSuccess) fromJson2;
                ImageView ivBgSharpResult = this.binding.ivBgSharpResult;
                Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
                ivBgSharpResult.setVisibility(0);
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkshopScreen.onBackendMessage$lambda$15(WorkshopScreen.this);
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
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkshopScreen.this.refreshData();
                    }
                }, 500L);
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
                this.binding.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
                this.binding.costField.valueTextView.setText(craftItemInfo.getCost() + " ");
                this.binding.costFieldPainting.valueTextView.setText(craftItemInfo.getCost() + " ");
                InventoryItem inventoryItem = this.currentLeftItem;
                int intValue = (inventoryItem != null || (amount = inventoryItem.getAmount()) == null) ? 0 : amount.intValue();
                Integer amount2 = craftItemInfo.getAmount();
                int intValue2 = amount2 == null ? amount2.intValue() : 0;
                if (this.isArizonaType || this.currentScreenType != 1 || this.currentLeftItem == null) {
                    return;
                }
                TextView tvTitleText = this.binding.leftItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
                tvTitleText.setVisibility(0);
                TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
                Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
                tvNeedRes.setVisibility(0);
                TextView textView = this.binding.leftItemField.tvTitleText;
                InventoryItem inventoryItem2 = this.currentLeftItem;
                textView.setText(String.valueOf(inventoryItem2 != null ? inventoryItem2.getText() : null));
                this.binding.leftItemField.tvNeedRes.setText(RemoteSettings.FORWARD_SLASH_STRING + craftItemInfo.getAmount());
                if (intValue2 > intValue) {
                    this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.red));
                    return;
                } else {
                    this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(R.color.white));
                    return;
                }
            }
            if (craftItemInfo.getAvailable() == 1) {
                btnSharpenEnableStatus(true);
            } else {
                btnSharpenEnableStatus(false);
            }
            this.binding.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
            this.binding.costField.valueTextView.setText(craftItemInfo.getCost() + " ");
            this.binding.costFieldPainting.valueTextView.setText(craftItemInfo.getCost() + " ");
            InventoryItem inventoryItem3 = this.currentLeftItem;
            if (inventoryItem3 != null) {
            }
            Integer amount22 = craftItemInfo.getAmount();
            if (amount22 == null) {
            }
            if (this.isArizonaType) {
            }
        } else if (i == 3) {
            Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) WorkshopResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
            initItemInfo((WorkshopResponse) fromJson4);
        } else if (i == 4) {
            WorkshopResourceAmount workshopResourceAmount = (WorkshopResourceAmount) MapperKt.toModel(data, WorkshopResourceAmount.class);
            WorkshopScreenBinding workshopScreenBinding = this.binding;
            TextView tvNeedRes2 = workshopScreenBinding.leftItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes2, "tvNeedRes");
            tvNeedRes2.setVisibility((workshopResourceAmount.getLeftResourceAmount() > 0 ? 1 : null) != null ? 0 : 8);
            workshopScreenBinding.leftItemField.tvNeedRes.setText(RemoteSettings.FORWARD_SLASH_STRING + workshopResourceAmount.getLeftResourceAmount());
            TextView tvNeedRes3 = workshopScreenBinding.rightItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes3, "tvNeedRes");
            tvNeedRes3.setVisibility(workshopResourceAmount.getRightResourceAmount() > 0 ? 0 : 8);
            workshopScreenBinding.rightItemField.tvNeedRes.setText(RemoteSettings.FORWARD_SLASH_STRING + workshopResourceAmount.getRightResourceAmount());
        } else if (i == UIElementID.INVENTORY.getId()) {
            Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson5;
            int type = inventoryResponse.getType();
            List<InventoryItem> items = inventoryResponse.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InventoryItem inventoryItem4 : items) {
                int type2 = inventoryResponse.getType();
                Iterator<T> it = UtilsKt.getItemsName().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    int id = ((ItemsInfo) obj2).getId();
                    Integer item = inventoryItem4.getItem();
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
                    Integer item2 = inventoryItem4.getItem();
                    if (item2 != null && id2 == item2.intValue()) {
                        break;
                    }
                }
                ItemsInfo itemsInfo2 = (ItemsInfo) obj3;
                arrayList.add(InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type2, itemsInfo2 != null ? Integer.valueOf(itemsInfo2.getAcs_slot()) : null, null, false, false, 1900527, null));
            }
            InventoryResponse inventoryResponse2 = new InventoryResponse(type, arrayList);
            if (inventoryResponse2.getType() == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                for (InventoryItem inventoryItem5 : inventoryResponse2.getItems()) {
                    Iterator<InventoryItem> it3 = this.inventoryItemList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            i3 = -1;
                            break;
                        } else if (it3.next().getSlot() == inventoryItem5.getSlot()) {
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
                        if (((InventoryItem) obj).getSlot() == inventoryItem5.getSlot()) {
                            break;
                        }
                    }
                    InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem5);
                    if (i3 >= 0) {
                        if (inventoryItem5.getItem() != null) {
                            List<InventoryItem> list = this.inventoryItemList;
                            if (updateInventoryItem == null) {
                                updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                            }
                            list.set(i3, updateInventoryItem);
                        } else {
                            this.inventoryItemList.set(i3, inventoryItem5);
                        }
                    }
                    if (this.isArizonaType && this.currentScreenType == 2 && (itemStrength = inventoryItem5.getItemStrength()) != null && itemStrength.intValue() == 100) {
                        this.binding.mainItemField.parentLayout.performClick();
                    }
                    this.inventoryAdapter.submitList(this.inventoryItemList);
                    this.inventoryAdapter.notifyItemChanged(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$15(WorkshopScreen workshopScreen) {
        ImageView ivBgSharpResult = workshopScreen.binding.ivBgSharpResult;
        Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
        ivBgSharpResult.setVisibility(8);
    }

    private final void enableStatusButtons(boolean z) {
        this.binding.mainItemField.parentLayout.setEnabled(z);
        this.binding.leftItemField.item.setEnabled(z);
        this.binding.rightItemField.item.setEnabled(z);
        btnSharpenEnableStatus(z);
        btnPaintEnableStatus(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshData() {
        Object obj;
        Object obj2;
        Object obj3;
        Iterator<T> it = getInventoryList().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            InventoryItem inventoryItem = (InventoryItem) obj2;
            InventoryItem inventoryItem2 = this.currentMainItem;
            if (inventoryItem2 != null && inventoryItem.getSlot() == inventoryItem2.getSlot()) {
                break;
            }
        }
        InventoryItem inventoryItem3 = (InventoryItem) obj2;
        this.currentMainItem = inventoryItem3;
        if (inventoryItem3 != null) {
            updateMainField(inventoryItem3);
        }
        Iterator<T> it2 = getInventoryList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            InventoryItem inventoryItem4 = (InventoryItem) obj3;
            InventoryItem inventoryItem5 = this.currentRightItem;
            if (inventoryItem5 != null && inventoryItem4.getSlot() == inventoryItem5.getSlot()) {
                break;
            }
        }
        InventoryItem inventoryItem6 = (InventoryItem) obj3;
        this.currentRightItem = inventoryItem6;
        if (inventoryItem6 != null) {
            updateRightField(inventoryItem6);
        }
        Iterator<T> it3 = getInventoryList().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            InventoryItem inventoryItem7 = (InventoryItem) next;
            InventoryItem inventoryItem8 = this.currentLeftItem;
            if (inventoryItem8 != null && inventoryItem7.getSlot() == inventoryItem8.getSlot()) {
                obj = next;
                break;
            }
        }
        InventoryItem inventoryItem9 = (InventoryItem) obj;
        this.currentLeftItem = inventoryItem9;
        if (this.isArizonaType) {
            if (inventoryItem9 != null) {
                updateLeftField(inventoryItem9);
            }
        } else if (this.isFix) {
            clearItemsMainFieldClicked(true);
            btnPaintEnableStatus(false);
        } else {
            enableStatusButtons(true);
        }
    }

    private final void startProgressBarAnimation(final long j, boolean z) {
        this.progress = 0;
        this.binding.progressBar.setMax(100);
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.workshop.WorkshopScreen$startProgressBarAnimation$1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                WorkshopScreenBinding workshopScreenBinding;
                int i2;
                int i3;
                int i4;
                Handler handler;
                i = WorkshopScreen.this.progress;
                if (i <= 100) {
                    workshopScreenBinding = WorkshopScreen.this.binding;
                    ProgressBar progressBar = workshopScreenBinding.progressBar;
                    i2 = WorkshopScreen.this.progress;
                    progressBar.setProgress(i2);
                    WorkshopScreen workshopScreen = WorkshopScreen.this;
                    i3 = workshopScreen.progress;
                    i4 = WorkshopScreen.this.progressIncrement;
                    workshopScreen.progress = i3 + i4;
                    handler = WorkshopScreen.this.progressHandler;
                    handler.postDelayed(this, j / 50);
                }
            }
        };
        this.runnable = runnable;
        this.progressHandler.postDelayed(runnable, 0L);
    }

    private final void sendData(String str, int i) {
        Log.d("TAG_WORKSHOP", "sended: data: " + str + " ===  subId : " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.WORKSHOP.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void initItemInfo(WorkshopResponse workshopResponse) {
        this.binding.successChanceField.valueTextView.setText(String.valueOf(workshopResponse.getChance()));
        this.binding.costField.valueTextView.setText(String.valueOf(workshopResponse.getCost()));
    }

    /* compiled from: WorkshopScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/WorkshopScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new WorkshopScreen(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeScreen() {
        this.frontendNotifier.setUIElementVisible(UIElementID.WORKSHOP.getId(), false);
        getNotifier().requestRemoveUIElement(this);
    }
}

package ru.mrlargha.feature.workshop.presentation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.craft.domain.CraftItemInfo;
import ru.mrlargha.commonui.elements.craft.domain.CraftStart;
import ru.mrlargha.commonui.elements.craft.domain.CraftSuccess;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.RodinaItemTypes;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.feature.workshop.R;
import ru.mrlargha.feature.workshop.databinding.WorkshopButtonsContainerBinding;
import ru.mrlargha.feature.workshop.databinding.WorkshopInfoContainerBinding;
import ru.mrlargha.feature.workshop.databinding.WorkshopScreenBinding;
import ru.mrlargha.feature.workshop.domain.CategoryRequest;
import ru.mrlargha.feature.workshop.domain.FixingRequest;
import ru.mrlargha.feature.workshop.domain.GunWorkshopAvailabilityRefreshDecision;
import ru.mrlargha.feature.workshop.domain.GunWorkshopMode;
import ru.mrlargha.feature.workshop.domain.GunWorkshopRequirement;
import ru.mrlargha.feature.workshop.domain.GunWorkshopRules;
import ru.mrlargha.feature.workshop.domain.GunWorkshopSlotRole;
import ru.mrlargha.feature.workshop.domain.PaintingRequest;
import ru.mrlargha.feature.workshop.domain.SharpenRequest;
import ru.mrlargha.feature.workshop.domain.WorkshopItemUtilsKt;
import ru.mrlargha.feature.workshop.domain.WorkshopResourceAmount;
import ru.mrlargha.feature.workshop.domain.WorkshopResponse;
import ru.mrlargha.feature.workshop.presentation.WorkshopMenus;
import ru.mrlargha.feature.workshop.presentation.adapters.SelectColorAdapter;
import ru.mrlargha.feature.workshop.presentation.adapters.WorkshopAdapter;
import ru.mrlargha.feature.workshop.presentation.adapters.WorkshopMenuAdapter;
/* compiled from: WorkshopScreen.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0004\u0094\u0001\u0095\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0006H\u0002J\u0010\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0006H\u0002J\b\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u001eH\u0002J\u0010\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020\u001eH\u0002J\u0010\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\u001eH\u0002J\u0010\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020\u001eH\u0002J\u0010\u0010N\u001a\u00020E2\u0006\u0010M\u001a\u00020\u001eH\u0002J\b\u0010O\u001a\u00020EH\u0002J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020:0QH\u0002J\u0010\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020\u001eH\u0002J\u0010\u0010T\u001a\u00020E2\u0006\u0010S\u001a\u00020\u001eH\u0002J\"\u0010U\u001a\u00020E2\u0006\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020\u00062\b\b\u0002\u0010X\u001a\u00020\u001eH\u0002J\u0010\u0010Y\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\b\u0010[\u001a\u00020EH\u0002J\u001a\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020\u00062\b\b\u0002\u0010X\u001a\u00020\u001eH\u0002J\u0010\u0010^\u001a\u00020E2\u0006\u0010_\u001a\u00020*H\u0002J\b\u0010`\u001a\u00020EH\u0002J\u0010\u0010a\u001a\u00020E2\u0006\u0010b\u001a\u00020:H\u0002J\b\u0010c\u001a\u00020EH\u0002J\b\u0010d\u001a\u00020EH\u0002J\u0010\u0010e\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010f\u001a\u00020E2\u0006\u0010g\u001a\u00020\u0006H\u0002J\b\u0010h\u001a\u00020EH\u0002J\u001a\u0010i\u001a\u00020E2\u0006\u0010G\u001a\u00020\u001e2\b\b\u0002\u0010j\u001a\u00020\u001eH\u0002J\u0010\u0010k\u001a\u00020E2\u0006\u0010l\u001a\u00020\u001eH\u0002J\u0010\u0010m\u001a\u00020E2\u0006\u0010n\u001a\u00020\u001eH\u0002J\u0010\u0010o\u001a\u00020E2\u0006\u0010n\u001a\u00020\u001eH\u0002J\b\u0010p\u001a\u00020EH\u0002J\u0010\u0010q\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010r\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010s\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\u0012\u0010t\u001a\u00020E2\b\u0010Z\u001a\u0004\u0018\u00010\u0013H\u0002J(\u0010u\u001a\u00020E2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020A2\u0006\u0010{\u001a\u00020yH\u0002J\b\u0010|\u001a\u00020EH\u0002J\u0018\u0010}\u001a\u00020E2\u0006\u0010~\u001a\u00020A2\u0006\u0010\u007f\u001a\u00020\u0006H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020E2\u0006\u0010_\u001a\u00020*H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020E2\u0006\u0010M\u001a\u00020\u001eH\u0002J\t\u0010\u0082\u0001\u001a\u00020EH\u0002J\t\u0010\u0083\u0001\u001a\u00020EH\u0002J\t\u0010\u0084\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u0013H\u0002J\t\u0010\u0086\u0001\u001a\u00020EH\u0002J\u0015\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0006H\u0002J\u001c\u0010\u008a\u0001\u001a\u00020E2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u001eH\u0002J\u0019\u0010\u008e\u0001\u001a\u00020E2\u0006\u0010~\u001a\u00020A2\u0006\u0010\u007f\u001a\u00020\u0006H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020E2\u0007\u0010_\u001a\u00030\u0090\u0001H\u0002J\u0011\u0010\u0091\u0001\u001a\u00020E2\u0006\u0010I\u001a\u00020\u001eH\u0016J\u0011\u0010\u0092\u0001\u001a\u00020E2\u0006\u0010I\u001a\u00020\u001eH\u0016J\t\u0010\u0093\u0001\u001a\u00020EH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "workshopScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/feature/workshop/databinding/WorkshopScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "inventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getInventoryList", "()Ljava/util/List;", "inventoryItemList", "inventoryAdapter", "Lru/mrlargha/feature/workshop/presentation/adapters/WorkshopAdapter;", "workShopMenuAdapter", "Lru/mrlargha/feature/workshop/presentation/adapters/WorkshopMenuAdapter;", "colorsAdapter", "Lru/mrlargha/feature/workshop/presentation/adapters/SelectColorAdapter;", "isFix", "", "selectedColor", "progress", "progressIncrement", "progressHandler", "Landroid/os/Handler;", "incrementHandler", "handler", "getHandler", "()Landroid/os/Handler;", "contextFallbackHandler", "pendingContextlessInventoryResponses", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "standardContextFallbackRunnable", "Ljava/lang/Runnable;", "leftItemIndex", "centerItemIndex", "rightItemIndex", "currentMainItem", "currentRightItem", "currentLeftItem", "currentScreenType", "isGunWorkshopContext", "workshopContextType", "Ljava/lang/Integer;", "activeGunWorkshopMode", "Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;", "currentWorkshopMenu", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "hasServerGunWorkshopRequirements", "pendingGunWorkshopAvailabilityRefresh", "isDisableAll", "runnable", "btnIsClicked", "text", "", "resId", "paddedText", "initViewSize", "", "clearItemsMainFieldClicked", "sendRequest", "setCountsVisibility", "visible", "leftItemUi", "isLocked", "btnSharpenEnableStatus", "isEnabled", "btnPaintEnableStatus", "initMenu", "standardWorkshopMenus", "", "prepareWorkshopContext", "isGunContext", "configureSlotDescriptionLayout", "selectWorkshopMenu", CommonUrlParts.MODEL, "clickedPosition", "notifyBackend", "isItemEligibleForCurrentMenu", "item", "activateGunWorkshopContext", "activateStandardWorkshopContext", "inventoryType", "deferContextlessInventoryResponse", "response", "cancelStandardContextFallback", "initializeInfoBlock", "workshopMenus", "sendItemData", "sendSharpenSelection", "handleGunWorkshopItem", "updateGunWorkshopRequirementLabels", "currentEnchant", "resetGunWorkshopRequirementLabels", "clearGunWorkshopSelection", "reinitialize", "changeInventoryType", "isFixingScreen", "visibilityLeftRightViews", "isVisible", "paintingScreen", "initColors", "clickedItem", "updateMainField", "updateRightField", "updateLeftField", "clearViewFromItem", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "message", "view", "addLockedItems", "onBackendMessageHandled", "data", "subId", "applyInventoryResponseItems", "enableStatusButtons", "refreshData", "refreshGunWorkshopData", "hasValidGunWorkshopSelection", "workshopAmountText", "refreshInventoryCatalogMetadata", "catalogItem", "Lru/mrlargha/commonui/utils/ItemsInfo;", "itemId", "startProgressBarAnimation", "time", "", "stop", "sendData", "initItemInfo", "Lru/mrlargha/feature/workshop/domain/WorkshopResponse;", "setVisibility", "setVisible", "closeScreen", "Spawner", "Companion", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopScreen extends SAMPUIElement implements InterfaceController {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long STANDARD_CONTEXT_FALLBACK_DELAY_MS = 750;
    private GunWorkshopMode activeGunWorkshopMode;
    private final WorkshopScreenBinding binding;
    private boolean btnIsClicked;
    private int centerItemIndex;
    private SelectColorAdapter colorsAdapter;
    private final Handler contextFallbackHandler;
    private InventoryItem currentLeftItem;
    private InventoryItem currentMainItem;
    private InventoryItem currentRightItem;
    private int currentScreenType;
    private WorkshopMenus currentWorkshopMenu;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private final Handler handler;
    private boolean hasServerGunWorkshopRequirements;
    private Handler incrementHandler;
    private final WorkshopAdapter inventoryAdapter;
    private List<InventoryItem> inventoryItemList;
    private boolean isDisableAll;
    private boolean isFix;
    private boolean isGunWorkshopContext;
    private int leftItemIndex;
    private final List<InventoryResponse> pendingContextlessInventoryResponses;
    private boolean pendingGunWorkshopAvailabilityRefresh;
    private int progress;
    private Handler progressHandler;
    private final int progressIncrement;
    private int rightItemIndex;
    private Runnable runnable;
    private int selectedColor;
    private final Runnable standardContextFallbackRunnable;
    private WorkshopMenuAdapter workShopMenuAdapter;
    private Integer workshopContextType;
    private final ConstraintLayout workshopScreen;

    /* compiled from: WorkshopScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GunWorkshopSlotRole.values().length];
            try {
                iArr[GunWorkshopSlotRole.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GunWorkshopSlotRole.SHARPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GunWorkshopSlotRole.RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkshopScreen(final Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
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
        this.inventoryAdapter = new WorkshopAdapter(new Function1() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkshopScreen.inventoryAdapter$lambda$0(WorkshopScreen.this, (InventoryItem) obj);
            }
        }, activity);
        this.selectedColor = -1;
        this.progressIncrement = 2;
        this.progressHandler = new Handler();
        this.incrementHandler = new Handler();
        this.handler = new Handler();
        this.contextFallbackHandler = new Handler(Looper.getMainLooper());
        this.pendingContextlessInventoryResponses = new ArrayList();
        this.standardContextFallbackRunnable = new Runnable() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                WorkshopScreen.standardContextFallbackRunnable$lambda$0(WorkshopScreen.this);
            }
        };
        this.leftItemIndex = -1;
        this.centerItemIndex = -1;
        this.rightItemIndex = -1;
        this.currentWorkshopMenu = WorkshopMenus.SHARPING.INSTANCE;
        this.isDisableAll = true;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        addLockedItems();
        UtilsKt.checkItemsName(activity, UtilsKt.isArizonaType(), new Function1() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkshopScreen._init_$lambda$0(WorkshopScreen.this, ((Boolean) obj).booleanValue());
            }
        });
        initMenu();
        initColors();
        bind.buttonsContainer.btnSharpenItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$1(WorkshopScreen.this, view);
            }
        });
        bind.buttonsContainer.paintButtons.btnPaintItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$2(WorkshopScreen.this, view);
            }
        });
        bind.infoContainers.info.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$3(WorkshopScreen.this, view);
            }
        });
        bind.mainItemField.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$4(WorkshopScreen.this, view);
            }
        });
        bind.rightItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$5(WorkshopScreen.this, targetActivity, view);
            }
        });
        bind.leftItemField.item.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen._init_$lambda$6(WorkshopScreen.this, targetActivity, view);
            }
        });
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopScreen.this.closeScreen();
            }
        });
        bind.infoContainers.sharpingInfoContainer.successChanceField.nameTextView.setText(targetActivity.getString(ru.mrlargha.commonui.R.string.success_chance));
        bind.infoContainers.sharpingInfoContainer.costField.nameTextView.setText(targetActivity.getString(ru.mrlargha.commonui.R.string.cost));
        bind.buttonsContainer.paintButtons.costFieldPainting.nameTextView.setText(targetActivity.getString(ru.mrlargha.commonui.R.string.cost));
        bind.infoContainers.sharpingInfoContainer.successChanceField.ivValueIcon.setImageResource(ru.mrlargha.commonui.R.drawable.ic_percent_16);
        if (UtilsKt.isArizonaType()) {
            bind.buttonsContainer.paintButtons.costFieldPainting.ivValueIcon.setImageDrawable(null);
            bind.infoContainers.sharpingInfoContainer.costField.ivValueIcon.setImageDrawable(null);
        } else {
            bind.buttonsContainer.paintButtons.costFieldPainting.ivValueIcon.setImageResource(ru.mrlargha.commonui.R.drawable.ic_dollar_16);
            bind.infoContainers.sharpingInfoContainer.costField.ivValueIcon.setImageResource(ru.mrlargha.commonui.R.drawable.ic_dollar_16);
        }
        leftItemUi(true);
        setCountsVisibility(false);
        bind.mainItemField.ivItemImage.setImageResource(ru.mrlargha.commonui.R.drawable.ic_empty_item);
        bind.rightItemField.ivItemImage.setImageResource(ru.mrlargha.commonui.R.drawable.ic_empty_item);
        initViewSize();
    }

    private final List<InventoryItem> getInventoryList() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new WorkshopScreen$inventoryList$1(this, null), 1, null);
        return (List) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r0 != 4) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit inventoryAdapter$lambda$0(WorkshopScreen workshopScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (workshopScreen.isDisableAll || workshopScreen.workshopContextType == null) {
            return Unit.INSTANCE;
        }
        if (workshopScreen.isGunWorkshopContext) {
            if (workshopScreen.handleGunWorkshopItem(it)) {
                workshopScreen.sendSharpenSelection();
            }
            return Unit.INSTANCE;
        } else if (!workshopScreen.isItemEligibleForCurrentMenu(it)) {
            return Unit.INSTANCE;
        } else {
            Log.e("workshop", String.valueOf(workshopScreen.currentScreenType));
            int i = workshopScreen.currentScreenType;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        workshopScreen.sendData(StringKt.toStringJson(new FixingRequest(it.getSlot())), 5);
                        workshopScreen.updateMainField(it);
                    } else if (i != 3) {
                    }
                } else if (UtilsKt.isArizonaType()) {
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
    }

    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void standardContextFallbackRunnable$lambda$0(WorkshopScreen workshopScreen) {
        if (workshopScreen.workshopContextType != null || workshopScreen.isGunWorkshopContext) {
            workshopScreen.pendingContextlessInventoryResponses.clear();
            return;
        }
        List<InventoryResponse> list = CollectionsKt.toList(workshopScreen.pendingContextlessInventoryResponses);
        workshopScreen.pendingContextlessInventoryResponses.clear();
        Log.w("TAG_WORKSHOP", "Context packet is missing; using standard workshop fallback");
        workshopScreen.activateStandardWorkshopContext(5, false);
        for (InventoryResponse inventoryResponse : list) {
            workshopScreen.applyInventoryResponseItems(inventoryResponse);
        }
    }

    private final String text(int i) {
        String string = getTargetActivity().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String paddedText(int i) {
        return text(i) + " ";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(WorkshopScreen workshopScreen, boolean z) {
        if (z) {
            workshopScreen.refreshInventoryCatalogMetadata();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.workshopContextType == null || workshopScreen.isDisableAll) {
            return;
        }
        workshopScreen.sendData(StringKt.toStringJson(0), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$2(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.workshopContextType == null || workshopScreen.isDisableAll) {
            return;
        }
        int i = workshopScreen.currentScreenType;
        if (i == 1) {
            workshopScreen.sendData(StringKt.toStringJson(0), UtilsKt.isArizonaType() ? 4 : 6);
        } else if (i == 2) {
            workshopScreen.sendData(StringKt.toStringJson(0), 6);
        } else if (i != 4) {
        } else {
            workshopScreen.sendData(StringKt.toStringJson(0), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$3(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.workshopContextType == null || workshopScreen.isDisableAll) {
            return;
        }
        workshopScreen.sendData(StringKt.toStringJson(0), 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$4(WorkshopScreen workshopScreen, View view) {
        if (workshopScreen.centerItemIndex == -1) {
            return;
        }
        if (workshopScreen.isGunWorkshopContext) {
            clearGunWorkshopSelection$default(workshopScreen, true, false, 2, null);
            return;
        }
        workshopScreen.currentMainItem = null;
        workshopScreen.currentRightItem = null;
        workshopScreen.currentLeftItem = null;
        workshopScreen.clearItemsMainFieldClicked(true);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.setCountsVisibility(false);
        workshopScreen.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(-1);
        workshopScreen.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$5(WorkshopScreen workshopScreen, Activity activity, View view) {
        String text;
        if (workshopScreen.rightItemIndex == -1) {
            return;
        }
        workshopScreen.rightItemIndex = -1;
        workshopScreen.currentRightItem = null;
        workshopScreen.sendItemData();
        ImageView ivItemImage = workshopScreen.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvRightItemDescription = workshopScreen.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        if (workshopScreen.isGunWorkshopContext) {
            text = workshopScreen.currentWorkshopMenu.rightFieldName(activity);
        } else {
            text = workshopScreen.text(ru.mrlargha.commonui.R.string.sharpening);
        }
        TextView tvTitleText = workshopScreen.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        workshopScreen.clearViewFromItem(ivItemImage, tvRightItemDescription, text, tvTitleText);
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
        workshopScreen.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(-1);
        workshopScreen.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$6(WorkshopScreen workshopScreen, Activity activity, View view) {
        if (workshopScreen.leftItemIndex == -1) {
            return;
        }
        workshopScreen.leftItemIndex = -1;
        workshopScreen.currentLeftItem = null;
        workshopScreen.sendItemData();
        if (workshopScreen.isGunWorkshopContext) {
            ImageView ivItemImage = workshopScreen.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            TextView tvLeftItemDescription = workshopScreen.binding.tvLeftItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
            String leftFieldName = workshopScreen.currentWorkshopMenu.leftFieldName(activity);
            TextView tvTitleText = workshopScreen.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            workshopScreen.clearViewFromItem(ivItemImage, tvLeftItemDescription, leftFieldName, tvTitleText);
        } else {
            workshopScreen.updateLeftField(null);
        }
        workshopScreen.btnSharpenEnableStatus(false);
        workshopScreen.btnPaintEnableStatus(false);
    }

    private final void initViewSize() {
        DisplayMetrics displayMetrics = getTargetActivity().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        double d = i;
        int roundToInt = MathKt.roundToInt(0.09d * d);
        ViewGroup.LayoutParams layoutParams = this.binding.leftItemField.item.getLayoutParams();
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt;
        this.binding.leftItemField.item.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.binding.rightItemField.item.getLayoutParams();
        layoutParams2.width = roundToInt;
        layoutParams2.height = roundToInt;
        this.binding.rightItemField.item.setLayoutParams(layoutParams2);
        int min = Math.min(MathKt.roundToInt(d * 0.15d), MathKt.roundToInt(i2 * 0.3d));
        ViewGroup.LayoutParams layoutParams3 = this.binding.mainItemField.parentLayout.getLayoutParams();
        layoutParams3.width = min;
        layoutParams3.height = min;
        this.binding.mainItemField.parentLayout.setLayoutParams(layoutParams3);
    }

    private final void clearItemsMainFieldClicked(boolean z) {
        int i = this.currentScreenType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
                    Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                    TextView tvMainItemDescription = this.binding.tvMainItemDescription;
                    Intrinsics.checkNotNullExpressionValue(tvMainItemDescription, "tvMainItemDescription");
                    String paddedText = paddedText(ru.mrlargha.commonui.R.string.item);
                    TextView tvTitleText = this.binding.mainItemField.tvTitleText;
                    Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
                    clearViewFromItem(ivItemImage, tvMainItemDescription, paddedText, tvTitleText);
                    if (z && this.centerItemIndex != -1) {
                        this.centerItemIndex = -1;
                        sendData(StringKt.toStringJson(new FixingRequest(this.centerItemIndex)), 5);
                    }
                    this.inventoryAdapter.setFixingScreen(true);
                } else if (i != 3) {
                    if (i == 4) {
                        ImageView ivItemImage2 = this.binding.mainItemField.ivItemImage;
                        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
                        TextView tvMainItemDescription2 = this.binding.tvMainItemDescription;
                        Intrinsics.checkNotNullExpressionValue(tvMainItemDescription2, "tvMainItemDescription");
                        String paddedText2 = paddedText(ru.mrlargha.commonui.R.string.item);
                        TextView tvTitleText2 = this.binding.mainItemField.tvTitleText;
                        Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
                        clearViewFromItem(ivItemImage2, tvMainItemDescription2, paddedText2, tvTitleText2);
                    }
                } else if (z && this.centerItemIndex != -1) {
                    this.centerItemIndex = -1;
                    this.rightItemIndex = -1;
                    sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
                }
            } else if (UtilsKt.isArizonaType()) {
                if (z && this.centerItemIndex != -1) {
                    this.centerItemIndex = -1;
                    this.rightItemIndex = -1;
                    this.leftItemIndex = -1;
                    sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
                }
            } else {
                if (z && this.centerItemIndex != -1) {
                    this.centerItemIndex = -1;
                    sendData(StringKt.toStringJson(new FixingRequest(this.centerItemIndex)), 5);
                }
                this.inventoryAdapter.setFixingScreen(true);
            }
        } else if (z && this.centerItemIndex != -1) {
            this.centerItemIndex = -1;
            this.rightItemIndex = -1;
            sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
        }
        this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText("0.0 ");
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText("0 ");
        this.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setText("0 ");
        this.currentRightItem = null;
        this.currentLeftItem = null;
    }

    private final void setCountsVisibility(boolean z) {
        TextView tvStartCount = this.binding.infoContainers.sharpingInfoContainer.tvStartCount;
        Intrinsics.checkNotNullExpressionValue(tvStartCount, "tvStartCount");
        tvStartCount.setVisibility(z ? 0 : 8);
        TextView tvEndCount = this.binding.infoContainers.sharpingInfoContainer.tvEndCount;
        Intrinsics.checkNotNullExpressionValue(tvEndCount, "tvEndCount");
        tvEndCount.setVisibility(z ? 0 : 8);
    }

    private final void leftItemUi(boolean z) {
        WorkshopScreenBinding workshopScreenBinding = this.binding;
        if (z) {
            workshopScreenBinding.leftItemField.ivItemImage.setImageResource(ru.mrlargha.commonui.R.drawable.ic_locked_item);
            this.binding.tvLeftItemDescription.setText(paddedText(ru.mrlargha.commonui.R.string.unavailable));
            this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.grey_type3));
            TextView tvTitleText = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            tvTitleText.setVisibility(8);
            TextView tvNeedRes = this.binding.leftItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
            tvNeedRes.setVisibility(8);
            this.binding.leftItemField.item.setClickable(false);
            return;
        }
        workshopScreenBinding.leftItemField.ivItemImage.setImageResource(ru.mrlargha.commonui.R.drawable.ic_empty_item);
        int i = this.currentScreenType;
        WorkshopScreenBinding workshopScreenBinding2 = this.binding;
        if (i == 0) {
            workshopScreenBinding2.tvLeftItemDescription.setText(paddedText(ru.mrlargha.commonui.R.string.workshop_super_sharpening));
        } else {
            workshopScreenBinding2.tvLeftItemDescription.setText(paddedText(ru.mrlargha.commonui.R.string.workshop_paint_material));
        }
        this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.grey_type2));
        this.binding.leftItemField.item.setClickable(true);
    }

    private final void btnSharpenEnableStatus(boolean z) {
        WorkshopScreenBinding workshopScreenBinding = this.binding;
        if (z) {
            workshopScreenBinding.buttonsContainer.btnSharpenItem.setEnabled(true);
            this.binding.buttonsContainer.btnSharpenItem.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_create_item_craft);
            this.binding.buttonsContainer.btnSharpenItem.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.black));
            return;
        }
        workshopScreenBinding.buttonsContainer.btnSharpenItem.setEnabled(false);
        this.binding.buttonsContainer.btnSharpenItem.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_success_chance_test);
        this.binding.buttonsContainer.btnSharpenItem.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.white));
        this.btnIsClicked = false;
    }

    private final void btnPaintEnableStatus(boolean z) {
        WorkshopScreenBinding workshopScreenBinding = this.binding;
        if (z) {
            workshopScreenBinding.buttonsContainer.paintButtons.btnPaintItem.setEnabled(true);
            this.binding.buttonsContainer.paintButtons.btnPaintItem.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_create_item_craft);
            this.binding.buttonsContainer.paintButtons.btnPaintItem.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.black));
            return;
        }
        workshopScreenBinding.buttonsContainer.paintButtons.btnPaintItem.setEnabled(false);
        this.binding.buttonsContainer.paintButtons.btnPaintItem.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_success_chance_test);
        this.binding.buttonsContainer.paintButtons.btnPaintItem.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.white));
    }

    private final void initMenu() {
        this.workShopMenuAdapter = new WorkshopMenuAdapter(new Function2() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WorkshopScreen.initMenu$lambda$0(WorkshopScreen.this, (WorkshopMenus) obj, ((Integer) obj2).intValue());
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
        this.binding.rvMenu.setItemAnimator(null);
        this.binding.rvMenu.setHasFixedSize(true);
        WorkshopMenuAdapter workshopMenuAdapter3 = this.workShopMenuAdapter;
        if (workshopMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
        } else {
            workshopMenuAdapter2 = workshopMenuAdapter3;
        }
        workshopMenuAdapter2.submitMenus(standardWorkshopMenus(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit initMenu$lambda$0(WorkshopScreen workshopScreen, WorkshopMenus model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        selectWorkshopMenu$default(workshopScreen, model, i, false, 4, null);
        return Unit.INSTANCE;
    }

    private final List<WorkshopMenus> standardWorkshopMenus() {
        if (UtilsKt.isArizonaType()) {
            return WorkshopMenus.Companion.valuesArizona();
        }
        return WorkshopMenus.Companion.valuesRodina();
    }

    private final void prepareWorkshopContext(boolean z) {
        this.isDisableAll = false;
        this.isGunWorkshopContext = false;
        WorkshopMenuAdapter workshopMenuAdapter = null;
        this.activeGunWorkshopMode = null;
        this.isFix = false;
        this.centerItemIndex = -1;
        this.leftItemIndex = -1;
        this.rightItemIndex = -1;
        this.currentMainItem = null;
        this.currentLeftItem = null;
        this.currentRightItem = null;
        this.inventoryAdapter.setFixingScreen(false);
        this.inventoryAdapter.setItemEligibilityPredicate(null);
        WorkshopMenuAdapter workshopMenuAdapter2 = this.workShopMenuAdapter;
        if (workshopMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
        } else {
            workshopMenuAdapter = workshopMenuAdapter2;
        }
        workshopMenuAdapter.clearSelection();
        configureSlotDescriptionLayout(z);
        setCountsVisibility(false);
        resetGunWorkshopRequirementLabels();
        this.hasServerGunWorkshopRequirements = false;
        this.pendingGunWorkshopAvailabilityRefresh = false;
        btnSharpenEnableStatus(false);
        btnPaintEnableStatus(false);
        this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText("0.0 ");
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText("0 ");
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(-1);
    }

    private final void configureSlotDescriptionLayout(boolean z) {
        for (TextView textView : CollectionsKt.listOf((Object[]) new TextView[]{this.binding.tvLeftItemDescription, this.binding.tvMainItemDescription, this.binding.tvRightItemDescription})) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = z ? getTargetActivity().getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._90sdp) : 0;
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(z ? 2 : Integer.MAX_VALUE);
            textView.setTextSize(0, getTargetActivity().getResources().getDimension(z ? ru.mrlargha.commonui.R.dimen._7sdp : ru.mrlargha.commonui.R.dimen._8sdp));
        }
    }

    static /* synthetic */ void selectWorkshopMenu$default(WorkshopScreen workshopScreen, WorkshopMenus workshopMenus, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        workshopScreen.selectWorkshopMenu(workshopMenus, i, z);
    }

    private final void selectWorkshopMenu(WorkshopMenus workshopMenus, int i, boolean z) {
        if (this.isDisableAll || this.workshopContextType == null) {
            return;
        }
        final GunWorkshopMode gunWorkshopMode = workshopMenus.getGunWorkshopMode();
        boolean z2 = this.isGunWorkshopContext;
        if (z2 != (gunWorkshopMode != null)) {
            return;
        }
        if (z2) {
            clearGunWorkshopSelection(true, false);
        }
        WorkshopMenuAdapter workshopMenuAdapter = this.workShopMenuAdapter;
        if (workshopMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter = null;
        }
        int selectedItemPosition = workshopMenuAdapter.getSelectedItemPosition();
        WorkshopMenuAdapter workshopMenuAdapter2 = this.workShopMenuAdapter;
        if (workshopMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter2 = null;
        }
        workshopMenuAdapter2.setSelectedItemPosition(i);
        if (selectedItemPosition != -1) {
            WorkshopMenuAdapter workshopMenuAdapter3 = this.workShopMenuAdapter;
            if (workshopMenuAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
                workshopMenuAdapter3 = null;
            }
            workshopMenuAdapter3.notifyItemChanged(selectedItemPosition);
        }
        WorkshopMenuAdapter workshopMenuAdapter4 = this.workShopMenuAdapter;
        if (workshopMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter4 = null;
        }
        workshopMenuAdapter4.notifyItemChanged(i);
        this.isFix = workshopMenus.getId() == 1;
        this.currentMainItem = null;
        this.currentRightItem = null;
        this.activeGunWorkshopMode = gunWorkshopMode;
        initializeInfoBlock(workshopMenus);
        btnSharpenEnableStatus(false);
        btnPaintEnableStatus(false);
        if (gunWorkshopMode != null) {
            this.binding.leftItemField.item.setClickable(true);
            this.binding.leftItemField.item.setEnabled(true);
            TextView tvTitleText = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            tvTitleText.setVisibility(0);
            this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.grey_type2));
            this.inventoryAdapter.setItemEligibilityPredicate(new Function1() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(WorkshopScreen.selectWorkshopMenu$lambda$0(GunWorkshopMode.this, (InventoryItem) obj));
                }
            });
            resetGunWorkshopRequirementLabels();
            return;
        }
        this.inventoryAdapter.setItemEligibilityPredicate(new WorkshopScreen$selectWorkshopMenu$2(this));
        clearItemsMainFieldClicked(true);
        if (z) {
            sendData(StringKt.toStringJson(new CategoryRequest(this.currentScreenType)), 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean selectWorkshopMenu$lambda$0(GunWorkshopMode gunWorkshopMode, InventoryItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Integer item2 = item.getItem();
        if (item2 != null) {
            if (GunWorkshopRules.INSTANCE.slotRole(gunWorkshopMode, item2.intValue(), item.getItem_type()) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isItemEligibleForCurrentMenu(InventoryItem inventoryItem) {
        if (!UtilsKt.isArizonaType() && this.currentScreenType == 4) {
            Integer item_type = inventoryItem.getItem_type();
            int id = RodinaItemTypes.ITEM_TYPE_ATTACH.getId();
            if (item_type == null || item_type.intValue() != id) {
                Integer item_type2 = inventoryItem.getItem_type();
                int id2 = RodinaItemTypes.ITEM_TYPE_IMPROV.getId();
                if (item_type2 == null || item_type2.intValue() != id2) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void activateGunWorkshopContext() {
        Integer num = this.workshopContextType;
        if (num != null && num.intValue() == 28 && this.isGunWorkshopContext) {
            return;
        }
        this.workshopContextType = 28;
        prepareWorkshopContext(true);
        this.isGunWorkshopContext = true;
        List<WorkshopMenus> valuesGunWorkshop = WorkshopMenus.Companion.valuesGunWorkshop();
        WorkshopMenuAdapter workshopMenuAdapter = this.workShopMenuAdapter;
        if (workshopMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
            workshopMenuAdapter = null;
        }
        workshopMenuAdapter.submitMenus(valuesGunWorkshop, true);
        selectWorkshopMenu$default(this, (WorkshopMenus) CollectionsKt.first((List<? extends Object>) valuesGunWorkshop), 0, false, 4, null);
    }

    static /* synthetic */ void activateStandardWorkshopContext$default(WorkshopScreen workshopScreen, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        workshopScreen.activateStandardWorkshopContext(i, z);
    }

    private final void activateStandardWorkshopContext(int i, boolean z) {
        Integer num = this.workshopContextType;
        if (num == null || num.intValue() != i || this.isGunWorkshopContext) {
            this.workshopContextType = Integer.valueOf(i);
            prepareWorkshopContext(false);
            List<WorkshopMenus> standardWorkshopMenus = standardWorkshopMenus();
            WorkshopMenuAdapter workshopMenuAdapter = this.workShopMenuAdapter;
            if (workshopMenuAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
                workshopMenuAdapter = null;
            }
            workshopMenuAdapter.submitMenus(standardWorkshopMenus, false);
            selectWorkshopMenu((WorkshopMenus) CollectionsKt.first((List<? extends Object>) standardWorkshopMenus), 0, z);
        }
    }

    private final void deferContextlessInventoryResponse(InventoryResponse inventoryResponse) {
        this.pendingContextlessInventoryResponses.add(inventoryResponse);
        this.contextFallbackHandler.removeCallbacks(this.standardContextFallbackRunnable);
        this.contextFallbackHandler.postDelayed(this.standardContextFallbackRunnable, 750L);
    }

    private final void cancelStandardContextFallback() {
        this.contextFallbackHandler.removeCallbacks(this.standardContextFallbackRunnable);
        this.pendingContextlessInventoryResponses.clear();
    }

    private final void initializeInfoBlock(WorkshopMenus workshopMenus) {
        WorkshopScreenBinding workshopScreenBinding = this.binding;
        this.currentWorkshopMenu = workshopMenus;
        CardView root = workshopScreenBinding.leftItemField.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(workshopMenus.leftFieldName(getTargetActivity()).length() > 0 ? 0 : 8);
        CardView root2 = workshopScreenBinding.rightItemField.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(workshopMenus.rightFieldName(getTargetActivity()).length() > 0 ? 0 : 8);
        ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
        TextView tvMainItemDescription = this.binding.tvMainItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvMainItemDescription, "tvMainItemDescription");
        String mainFieldName = workshopMenus.mainFieldName(getTargetActivity());
        TextView tvTitleText = this.binding.mainItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage, tvMainItemDescription, mainFieldName, tvTitleText);
        ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        String rightFieldName = workshopMenus.rightFieldName(getTargetActivity());
        TextView tvTitleText2 = this.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
        clearViewFromItem(ivItemImage2, tvRightItemDescription, rightFieldName, tvTitleText2);
        if (Intrinsics.areEqual(workshopMenus.leftFieldName(getTargetActivity()), text(ru.mrlargha.commonui.R.string.unavailable))) {
            leftItemUi(true);
        } else {
            ImageView ivItemImage3 = this.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage3, "ivItemImage");
            TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
            String leftFieldName = workshopMenus.leftFieldName(getTargetActivity());
            TextView tvTitleText3 = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText3, "tvTitleText");
            clearViewFromItem(ivItemImage3, tvLeftItemDescription, leftFieldName, tvTitleText3);
        }
        WorkshopInfoContainerBinding infoContainers = workshopScreenBinding.infoContainers;
        Intrinsics.checkNotNullExpressionValue(infoContainers, "infoContainers");
        WorkshopButtonsContainerBinding buttonsContainer = workshopScreenBinding.buttonsContainer;
        Intrinsics.checkNotNullExpressionValue(buttonsContainer, "buttonsContainer");
        workshopMenus.setVisible(infoContainers, buttonsContainer);
        this.currentScreenType = workshopMenus.getId();
        this.binding.tvTitle.setText(workshopMenus.menuName(getTargetActivity()));
        this.binding.buttonsContainer.btnSharpenItem.setText(workshopMenus.buttonName(getTargetActivity()));
        this.binding.buttonsContainer.paintButtons.btnPaintItem.setText(workshopMenus.buttonName(getTargetActivity()));
        this.binding.tvTitleDescription.setText(workshopMenus.desc(getTargetActivity()));
        this.binding.tvRightItemDescription.setText(workshopMenus.rightFieldName(getTargetActivity()));
        this.binding.tvLeftItemDescription.setText(workshopMenus.leftFieldName(getTargetActivity()));
    }

    private final void sendItemData() {
        int i = this.currentScreenType;
        if (i == 0 || i == 3) {
            sendSharpenSelection();
        } else if (i == 1) {
            sendData(StringKt.toStringJson(new PaintingRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex, this.selectedColor)), 3);
        }
    }

    private final void sendSharpenSelection() {
        this.pendingGunWorkshopAvailabilityRefresh = false;
        sendData(StringKt.toStringJson(new SharpenRequest(this.centerItemIndex, this.leftItemIndex, this.rightItemIndex)), 1);
    }

    private final boolean handleGunWorkshopItem(InventoryItem inventoryItem) {
        Integer item;
        GunWorkshopMode gunWorkshopMode = this.activeGunWorkshopMode;
        if (gunWorkshopMode != null && (item = inventoryItem.getItem()) != null) {
            GunWorkshopSlotRole slotRole = GunWorkshopRules.INSTANCE.slotRole(gunWorkshopMode, item.intValue(), inventoryItem.getItem_type());
            int i = slotRole == null ? -1 : WhenMappings.$EnumSwitchMapping$0[slotRole.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    this.hasServerGunWorkshopRequirements = false;
                    this.currentMainItem = inventoryItem;
                    updateMainField(inventoryItem);
                    return true;
                } else if (i == 2) {
                    this.currentRightItem = inventoryItem;
                    updateRightField(inventoryItem);
                    return true;
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    this.currentLeftItem = inventoryItem;
                    updateLeftField(inventoryItem);
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateGunWorkshopRequirementLabels(int i) {
        GunWorkshopMode gunWorkshopMode = this.activeGunWorkshopMode;
        if (gunWorkshopMode == null) {
            return;
        }
        GunWorkshopRequirement requirement = GunWorkshopRules.INSTANCE.requirement(gunWorkshopMode, i);
        if (requirement == null) {
            resetGunWorkshopRequirementLabels();
            return;
        }
        TextView tvNeedRes = this.binding.rightItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
        tvNeedRes.setVisibility(0);
        this.binding.rightItemField.tvNeedRes.setText("/" + requirement.getSharpeningAmount());
        TextView tvNeedRes2 = this.binding.leftItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes2, "tvNeedRes");
        tvNeedRes2.setVisibility(0);
        this.binding.leftItemField.tvNeedRes.setText("/" + requirement.getResourceAmount());
    }

    private final void resetGunWorkshopRequirementLabels() {
        TextView tvNeedRes = this.binding.rightItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes, "tvNeedRes");
        tvNeedRes.setVisibility(8);
        this.binding.rightItemField.tvNeedRes.setText("");
        TextView tvNeedRes2 = this.binding.leftItemField.tvNeedRes;
        Intrinsics.checkNotNullExpressionValue(tvNeedRes2, "tvNeedRes");
        tvNeedRes2.setVisibility(8);
        this.binding.leftItemField.tvNeedRes.setText("");
    }

    static /* synthetic */ void clearGunWorkshopSelection$default(WorkshopScreen workshopScreen, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        workshopScreen.clearGunWorkshopSelection(z, z2);
    }

    private final void clearGunWorkshopSelection(boolean z, boolean z2) {
        boolean z3 = (this.centerItemIndex == -1 && this.leftItemIndex == -1 && this.rightItemIndex == -1) ? false : true;
        this.centerItemIndex = -1;
        this.leftItemIndex = -1;
        this.rightItemIndex = -1;
        this.currentMainItem = null;
        this.currentLeftItem = null;
        this.currentRightItem = null;
        if (z2) {
            initializeInfoBlock(this.currentWorkshopMenu);
            this.binding.leftItemField.item.setClickable(true);
            this.binding.leftItemField.item.setEnabled(true);
            TextView tvTitleText = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            tvTitleText.setVisibility(0);
            this.binding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.grey_type2));
        }
        setCountsVisibility(false);
        resetGunWorkshopRequirementLabels();
        this.hasServerGunWorkshopRequirements = false;
        this.pendingGunWorkshopAvailabilityRefresh = false;
        btnSharpenEnableStatus(false);
        btnPaintEnableStatus(false);
        this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText("0.0 ");
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText("0 ");
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(-1);
        if (z && z3) {
            sendSharpenSelection();
        }
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
        RecyclerView rvColors = this.binding.infoContainers.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(z ? 0 : 8);
        ConstraintLayout parentLayout = this.binding.buttonsContainer.paintButtons.costFieldPainting.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(z ? 0 : 8);
        Button btnPaintItem = this.binding.buttonsContainer.paintButtons.btnPaintItem;
        Intrinsics.checkNotNullExpressionValue(btnPaintItem, "btnPaintItem");
        btnPaintItem.setVisibility(z ? 0 : 8);
    }

    private final void initColors() {
        List mutableList = CollectionsKt.toMutableList((Collection) ConstantsKt.getColorList());
        this.colorsAdapter = new SelectColorAdapter(new Function2() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WorkshopScreen.initColors$lambda$0(WorkshopScreen.this, ((Integer) obj).intValue(), (ItemColor) obj2);
            }
        }, getTargetActivity());
        RecyclerView recyclerView = this.binding.infoContainers.rvColors;
        SelectColorAdapter selectColorAdapter = this.colorsAdapter;
        SelectColorAdapter selectColorAdapter2 = null;
        if (selectColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorsAdapter");
            selectColorAdapter = null;
        }
        recyclerView.setAdapter(selectColorAdapter);
        this.binding.infoContainers.rvColors.setHasFixedSize(true);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit initColors$lambda$0(WorkshopScreen workshopScreen, int i, ItemColor itemColor) {
        Intrinsics.checkNotNullParameter(itemColor, "<unused var>");
        if (workshopScreen.isDisableAll || workshopScreen.workshopContextType == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009d, code lost:
        if (r0.intValue() != r4) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void clickedItem(InventoryItem inventoryItem) {
        Integer item_type;
        int i;
        InventoryItem inventoryItem2;
        Integer enchant;
        Log.d("TAG_WORKSHOP", "clicked item " + StringKt.toStringJson(inventoryItem));
        if (this.currentScreenType == 4) {
            if (!UtilsKt.isArizonaType()) {
                Integer quality = inventoryItem.getQuality();
                if (quality != null) {
                    if (quality.intValue() > 0) {
                        updateMainField(inventoryItem);
                        this.currentMainItem = inventoryItem;
                    } else {
                        updateRightField(inventoryItem);
                        this.currentRightItem = inventoryItem;
                    }
                }
            } else {
                InventoryItem inventoryItem3 = this.currentMainItem;
                if (inventoryItem3 == null) {
                    updateMainField(inventoryItem);
                    this.currentMainItem = inventoryItem;
                } else if (this.currentRightItem == null) {
                    if (!Intrinsics.areEqual(inventoryItem3 != null ? inventoryItem3.getItem() : null, inventoryItem.getItem())) {
                        updateRightField(inventoryItem);
                        this.currentRightItem = inventoryItem;
                    }
                }
            }
            if (this.currentMainItem == null || this.currentRightItem == null) {
                return;
            }
            btnSharpenEnableStatus(true);
            return;
        }
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
                                        int id10 = RodinaItemTypes.ITEM_TYPE_IMPROV_GUN.getId();
                                        if (item_type != null && item_type.intValue() == id10) {
                                            updateMainField(inventoryItem);
                                            this.currentMainItem = inventoryItem;
                                            return;
                                        }
                                        int id11 = ItemTypes.ITEM_TYPE_COLORANT.getId();
                                        if (item_type != null && item_type.intValue() == id11) {
                                            if (this.currentScreenType != 1) {
                                                updateLeftField(inventoryItem);
                                                this.leftItemIndex = inventoryItem.getSlot();
                                                this.currentLeftItem = inventoryItem;
                                                Integer item2 = inventoryItem.getItem();
                                                Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default("items", item2 != null ? item2.intValue() : 0, (String) null, 4, (Object) null);
                                                if (iconFromArchive$default != null) {
                                                    ImageView ivItemImage = this.binding.leftItemField.ivItemImage;
                                                    Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                                                    UtilsKt.setImage(ivItemImage, iconFromArchive$default);
                                                }
                                                TextView textView = this.binding.tvLeftItemDescription;
                                                List<ItemsInfo> itemsName = UtilsKt.getItemsName();
                                                Integer item3 = inventoryItem.getItem();
                                                ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(itemsName, item3 != null ? item3.intValue() : -1);
                                                textView.setText(((itemsInfo == null || (r8 = itemsInfo.getName()) == null) ? "" : "") + " ");
                                                btnPaintEnableStatus(true);
                                                return;
                                            }
                                            return;
                                        }
                                        int id12 = RodinaItemTypes.ITEM_TYPE_ENCHANT.getId();
                                        if (item_type != null || item_type.intValue() != id12) {
                                            int id13 = ItemTypes.ITEM_TYPE_ENCHANT.getId();
                                            if (item_type != null || item_type.intValue() != id13) {
                                                int id14 = ItemTypes.ITEM_TYPE_ARMOUR_SHARPENING.getId();
                                                if (item_type != null || item_type.intValue() != id14) {
                                                    int id15 = ItemTypes.ITEM_TYPE_SUPER_ENCHANTED.getId();
                                                    if (item_type == null && item_type.intValue() == id15 && this.currentScreenType == 0) {
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
        int id102 = RodinaItemTypes.ITEM_TYPE_IMPROV_GUN.getId();
        if (item_type != null) {
            updateMainField(inventoryItem);
            this.currentMainItem = inventoryItem;
            return;
        }
        int id112 = ItemTypes.ITEM_TYPE_COLORANT.getId();
        if (item_type != null) {
            if (this.currentScreenType != 1) {
            }
        }
        int id122 = RodinaItemTypes.ITEM_TYPE_ENCHANT.getId();
        if (item_type != null) {
        }
        int id132 = ItemTypes.ITEM_TYPE_ENCHANT.getId();
        if (item_type != null) {
        }
        int id142 = ItemTypes.ITEM_TYPE_ARMOUR_SHARPENING.getId();
        if (item_type != null) {
        }
        int id152 = ItemTypes.ITEM_TYPE_SUPER_ENCHANTED.getId();
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
        GunWorkshopMode gunWorkshopMode;
        Integer enchant = inventoryItem.getEnchant();
        int intValue = enchant != null ? enchant.intValue() : 0;
        boolean z = (this.isGunWorkshopContext && ((gunWorkshopMode = this.activeGunWorkshopMode) == null || GunWorkshopRules.INSTANCE.requirement(gunWorkshopMode, intValue) == null)) ? false : true;
        this.centerItemIndex = inventoryItem.getSlot();
        int i = this.currentScreenType;
        if ((i == 0 || i == 3) && z) {
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
            ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(itemsName, item2 != null ? item2.intValue() : -1);
            textView.setText(((itemsInfo == null || (r4 = itemsInfo.getName()) == null) ? "" : "") + " ");
        }
        int i2 = this.currentScreenType;
        WorkshopScreenBinding workshopScreenBinding = this.binding;
        if (i2 == 0) {
            workshopScreenBinding.mainItemField.tvTitleText.setText("+" + intValue);
        } else {
            workshopScreenBinding.mainItemField.tvTitleText.setText(inventoryItem.getText());
        }
        Integer item3 = inventoryItem.getItem();
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default("items", item3 != null ? item3.intValue() : 0, (String) null, 4, (Object) null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, iconFromArchive$default);
        }
        this.binding.infoContainers.sharpingInfoContainer.tvStartCount.setText("+" + intValue + " ");
        this.binding.infoContainers.sharpingInfoContainer.tvEndCount.setText("+" + (this.isGunWorkshopContext ? RangesKt.coerceAtMost(intValue + 1, 12) : intValue + 1) + " ");
        if (this.isGunWorkshopContext && !this.hasServerGunWorkshopRequirements) {
            updateGunWorkshopRequirementLabels(intValue);
        }
        if (z) {
            return;
        }
        btnSharpenEnableStatus(false);
    }

    private final void updateRightField(InventoryItem inventoryItem) {
        String paddedText;
        if (inventoryItem.getItem() != null) {
            this.rightItemIndex = inventoryItem.getSlot();
            Integer item = inventoryItem.getItem();
            Intrinsics.checkNotNull(item);
            Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default("items", item.intValue(), (String) null, 4, (Object) null);
            if (iconFromArchive$default != null) {
                ImageView ivItemImage = this.binding.rightItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                UtilsKt.setImage(ivItemImage, iconFromArchive$default);
            }
            TextView textView = this.binding.tvRightItemDescription;
            List<ItemsInfo> itemsName = UtilsKt.getItemsName();
            Integer item2 = inventoryItem.getItem();
            Intrinsics.checkNotNull(item2);
            ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(itemsName, item2.intValue());
            textView.setText(((itemsInfo == null || (r1 = itemsInfo.getName()) == null) ? "" : "") + " ");
            this.binding.rightItemField.tvTitleText.setText(workshopAmountText(inventoryItem));
            return;
        }
        this.rightItemIndex = -1;
        ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        TextView tvRightItemDescription = this.binding.tvRightItemDescription;
        Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
        if (this.isGunWorkshopContext) {
            paddedText = this.currentWorkshopMenu.rightFieldName(getTargetActivity());
        } else {
            paddedText = paddedText(ru.mrlargha.commonui.R.string.sharpening);
        }
        TextView tvTitleText = this.binding.rightItemField.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        clearViewFromItem(ivItemImage2, tvRightItemDescription, paddedText, tvTitleText);
        sendItemData();
    }

    private final void updateLeftField(InventoryItem inventoryItem) {
        Integer enchant;
        if ((inventoryItem != null ? inventoryItem.getItem() : null) == null) {
            this.leftItemIndex = -1;
            if (this.isGunWorkshopContext) {
                ImageView ivItemImage = this.binding.leftItemField.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
                Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
                String leftFieldName = this.currentWorkshopMenu.leftFieldName(getTargetActivity());
                TextView tvTitleText = this.binding.leftItemField.tvTitleText;
                Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
                clearViewFromItem(ivItemImage, tvLeftItemDescription, leftFieldName, tvTitleText);
                this.binding.leftItemField.item.setClickable(true);
                return;
            }
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
        Integer item = inventoryItem.getItem();
        Intrinsics.checkNotNull(item);
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default("items", item.intValue(), (String) null, 4, (Object) null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage2 = this.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
            UtilsKt.setImage(ivItemImage2, iconFromArchive$default);
        }
        TextView textView = this.binding.tvLeftItemDescription;
        List<ItemsInfo> itemsName = UtilsKt.getItemsName();
        Integer item2 = inventoryItem.getItem();
        Intrinsics.checkNotNull(item2);
        ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(itemsName, item2.intValue());
        textView.setText(((itemsInfo == null || (r1 = itemsInfo.getName()) == null) ? "" : "") + " ");
        this.binding.leftItemField.tvTitleText.setText(workshopAmountText(inventoryItem));
    }

    private final void clearViewFromItem(ImageView imageView, TextView textView, String str, TextView textView2) {
        imageView.setImageResource(ru.mrlargha.commonui.R.drawable.ic_empty_item);
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
                this.inventoryItemList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), ((InventoryItem) CollectionsKt.last((List<? extends Object>) this.inventoryItemList)).getSlot() + 1, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, null, null, null, null, null, null, 133169150, null));
                if (i == nextMultipleOfFive) {
                    break;
                }
                i++;
            }
        }
        List<InventoryItem> list = this.inventoryItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 134215167, null));
        }
        this.inventoryItemList = CollectionsKt.toMutableList((Collection) arrayList);
        this.inventoryAdapter.setArizona(UtilsKt.isArizonaType());
        this.inventoryAdapter.submitList(this.inventoryItemList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0145, code lost:
        if (r3 != 4) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025c  */
    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBackendMessageHandled(String data, int i) {
        Long amount;
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
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"success\":", false, 2, (Object) null)) {
                enableStatusButtons(true);
                if (this.isGunWorkshopContext) {
                    btnSharpenEnableStatus(false);
                    this.pendingGunWorkshopAvailabilityRefresh = true;
                }
                int i2 = this.currentScreenType;
                if (i2 == 4 || i2 == 2) {
                    this.currentMainItem = null;
                    this.currentRightItem = null;
                    WorkshopMenuAdapter workshopMenuAdapter = this.workShopMenuAdapter;
                    if (workshopMenuAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("workShopMenuAdapter");
                        workshopMenuAdapter = null;
                    }
                    workshopMenuAdapter.setSelectedItemPosition(0);
                    initializeInfoBlock(WorkshopMenus.SHARPING.INSTANCE);
                    clearItemsMainFieldClicked(true);
                    btnSharpenEnableStatus(false);
                    btnPaintEnableStatus(false);
                    initMenu();
                }
                Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftSuccess.class);
                Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
                CraftSuccess craftSuccess = (CraftSuccess) fromJson2;
                ImageView ivBgSharpResult = this.binding.ivBgSharpResult;
                Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
                ivBgSharpResult.setVisibility(0);
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkshopScreen.onBackendMessageHandled$lambda$0(WorkshopScreen.this);
                    }
                }, 2000L);
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
                this.binding.infoContainers.sharpingInfoContainer.progressBar.clearAnimation();
                this.binding.infoContainers.sharpingInfoContainer.progressBar.setIndeterminate(false);
                this.binding.infoContainers.sharpingInfoContainer.progressBar.setProgress(0);
                int success = craftSuccess.getSuccess();
                if (success == 0) {
                    this.binding.ivBgSharpResult.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_tradeshop_test_red);
                } else if (success == 1) {
                    this.binding.ivBgSharpResult.setBackgroundResource(ru.mrlargha.commonui.R.drawable.bg_tradeshop_test_green);
                }
                this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$$ExternalSyntheticLambda6
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
            int i3 = this.currentScreenType;
            if (i3 != 0) {
                if (i3 != 1 && i3 != 2) {
                    if (i3 != 3) {
                    }
                }
                if (craftItemInfo.getAvailable() == 1) {
                    btnPaintEnableStatus(true);
                } else {
                    if (this.currentRightItem != null && this.currentMainItem != null) {
                        Log.d("W_TAG", "onBackendMessage: " + i + ", data:" + data);
                        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(SupportMenu.CATEGORY_MASK);
                        this.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setTextColor(SupportMenu.CATEGORY_MASK);
                    } else {
                        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setTextColor(-1);
                        this.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setTextColor(-1);
                    }
                    btnPaintEnableStatus(false);
                }
                this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
                this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText(MoneyElementKt.toMoneyFormattedSpannable$default(craftItemInfo.getCost(), false, null, " ", null, 11, null));
                this.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setText(MoneyElementKt.toMoneyFormattedSpannable$default(craftItemInfo.getCost(), false, null, " ", null, 11, null));
                InventoryItem inventoryItem = this.currentLeftItem;
                long longValue = (inventoryItem != null || (amount = inventoryItem.getAmount()) == null) ? 0L : amount.longValue();
                Integer amount2 = craftItemInfo.getAmount();
                int intValue = amount2 == null ? amount2.intValue() : 0;
                if (UtilsKt.isArizonaType() || this.currentScreenType != 1 || this.currentLeftItem == null) {
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
                this.binding.leftItemField.tvNeedRes.setText("/" + craftItemInfo.getAmount());
                int i4 = (intValue > longValue ? 1 : (intValue == longValue ? 0 : -1));
                WorkshopScreenBinding workshopScreenBinding = this.binding;
                if (i4 > 0) {
                    workshopScreenBinding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.red));
                    return;
                } else {
                    workshopScreenBinding.leftItemField.tvTitleText.setTextColor(getTargetActivity().getResources().getColor(ru.mrlargha.commonui.R.color.white));
                    return;
                }
            }
            boolean canApplyAvailabilityResponse = GunWorkshopRules.INSTANCE.canApplyAvailabilityResponse(this.isGunWorkshopContext, this.isDisableAll, this.pendingGunWorkshopAvailabilityRefresh, !this.isGunWorkshopContext || hasValidGunWorkshopSelection());
            if (craftItemInfo.getAvailable() == 1 && canApplyAvailabilityResponse) {
                btnSharpenEnableStatus(true);
            } else {
                btnSharpenEnableStatus(false);
            }
            this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
            this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText(MoneyElementKt.toMoneyFormattedSpannable$default(craftItemInfo.getCost(), false, null, " ", null, 11, null));
            this.binding.buttonsContainer.paintButtons.costFieldPainting.valueTextView.setText(MoneyElementKt.toMoneyFormattedSpannable$default(craftItemInfo.getCost(), false, null, " ", null, 11, null));
            InventoryItem inventoryItem3 = this.currentLeftItem;
            if (inventoryItem3 != null) {
            }
            Integer amount22 = craftItemInfo.getAmount();
            if (amount22 == null) {
            }
            if (UtilsKt.isArizonaType()) {
            }
        } else if (i == 3) {
            Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) WorkshopResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
            initItemInfo((WorkshopResponse) fromJson4);
        } else if (i == 4) {
            WorkshopResourceAmount workshopResourceAmount = (WorkshopResourceAmount) MapperKt.toModel(data, WorkshopResourceAmount.class);
            boolean z = this.isGunWorkshopContext;
            if (z && this.currentMainItem == null) {
                return;
            }
            if (z) {
                this.hasServerGunWorkshopRequirements = true;
            }
            WorkshopScreenBinding workshopScreenBinding2 = this.binding;
            TextView tvNeedRes2 = workshopScreenBinding2.leftItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes2, "tvNeedRes");
            tvNeedRes2.setVisibility((workshopResourceAmount.getLeftResourceAmount() > 0 ? 1 : null) != null ? 0 : 8);
            workshopScreenBinding2.leftItemField.tvNeedRes.setText("/" + workshopResourceAmount.getLeftResourceAmount());
            TextView tvNeedRes3 = workshopScreenBinding2.rightItemField.tvNeedRes;
            Intrinsics.checkNotNullExpressionValue(tvNeedRes3, "tvNeedRes");
            tvNeedRes3.setVisibility(workshopResourceAmount.getRightResourceAmount() > 0 ? 0 : 8);
            workshopScreenBinding2.rightItemField.tvNeedRes.setText("/" + workshopResourceAmount.getRightResourceAmount());
        } else if (i == UIElementID.INVENTORY.getId()) {
            Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
            InventoryResponse inventoryResponse = (InventoryResponse) fromJson5;
            int type = inventoryResponse.getType();
            List<InventoryItem> items = inventoryResponse.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InventoryItem inventoryItem4 : items) {
                Integer item = inventoryItem4.getItem();
                ItemsInfo catalogItem = item != null ? catalogItem(item.intValue()) : null;
                arrayList.add(InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, catalogItem != null ? Integer.valueOf(catalogItem.getType()) : inventoryItem4.getItem_type(), null, null, null, null, null, null, null, null, null, null, null, inventoryResponse.getType(), catalogItem != null ? Integer.valueOf(catalogItem.getAcs_slot()) : inventoryItem4.getAcsSlot(), null, false, false, null, null, null, null, null, null, 134021103, null));
            }
            InventoryResponse inventoryResponse2 = new InventoryResponse(type, arrayList, 0, 4, null);
            if (GunWorkshopRules.INSTANCE.fallbackContextType(this.workshopContextType, this.isGunWorkshopContext, inventoryResponse2.getType()) != null) {
                deferContextlessInventoryResponse(inventoryResponse2);
                return;
            }
            cancelStandardContextFallback();
            if (GunWorkshopRules.INSTANCE.acceptsInventoryResponse(this.workshopContextType, this.isGunWorkshopContext, inventoryResponse2.getType())) {
                int type2 = inventoryResponse2.getType();
                if (type2 == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    applyInventoryResponseItems(inventoryResponse2);
                } else if (type2 == 28) {
                    activateGunWorkshopContext();
                    applyInventoryResponseItems(inventoryResponse2);
                } else if (type2 == 5) {
                    activateStandardWorkshopContext$default(this, inventoryResponse2.getType(), false, 2, null);
                    applyInventoryResponseItems(inventoryResponse2);
                } else {
                    if (this.workshopContextType == null) {
                        activateStandardWorkshopContext$default(this, inventoryResponse2.getType(), false, 2, null);
                    }
                    applyInventoryResponseItems(inventoryResponse2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onBackendMessageHandled$lambda$0(WorkshopScreen workshopScreen) {
        ImageView ivBgSharpResult = workshopScreen.binding.ivBgSharpResult;
        Intrinsics.checkNotNullExpressionValue(ivBgSharpResult, "ivBgSharpResult");
        ivBgSharpResult.setVisibility(8);
    }

    private final void applyInventoryResponseItems(InventoryResponse inventoryResponse) {
        Integer itemStrength;
        List mutableList = CollectionsKt.toMutableList((Collection) this.inventoryItemList);
        for (InventoryItem inventoryItem : inventoryResponse.getItems()) {
            Iterator it = mutableList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((InventoryItem) it.next()).getSlot() == inventoryItem.getSlot()) {
                    break;
                } else {
                    i++;
                }
            }
            int i2 = i;
            if (i2 < 0) {
                mutableList.add(inventoryItem);
            } else {
                InventoryItem inventoryItem2 = (InventoryItem) mutableList.get(i2);
                if (inventoryItem.getItem() == null) {
                    inventoryItem2 = inventoryItem;
                } else if (inventoryItem2.isLocked() && inventoryItem2.getItem() == null) {
                    inventoryItem2 = InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, false, null, null, null, null, null, null, 133169151, null);
                } else {
                    InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem(inventoryItem2, inventoryItem);
                    if (updateInventoryItem != null) {
                        inventoryItem2 = updateInventoryItem;
                    }
                }
                mutableList.set(i2, inventoryItem2);
                if (UtilsKt.isArizonaType() && this.currentScreenType == 2 && (itemStrength = inventoryItem.getItemStrength()) != null && itemStrength.intValue() == 100) {
                    this.binding.mainItemField.parentLayout.performClick();
                }
            }
        }
        List<InventoryItem> mutableList2 = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(mutableList, new Comparator() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$applyInventoryResponseItems$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((InventoryItem) t).getSlot()), Integer.valueOf(((InventoryItem) t2).getSlot()));
            }
        }));
        this.inventoryItemList = mutableList2;
        this.inventoryAdapter.submitList(CollectionsKt.toList(mutableList2));
        if (this.isGunWorkshopContext) {
            refreshGunWorkshopData();
        }
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
        boolean z = this.isGunWorkshopContext;
        if (z) {
            refreshGunWorkshopData();
            return;
        }
        List<InventoryItem> inventoryList = z ? this.inventoryItemList : getInventoryList();
        Iterator<T> it = inventoryList.iterator();
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
        Iterator<T> it2 = inventoryList.iterator();
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
        Iterator<T> it3 = inventoryList.iterator();
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
        this.currentLeftItem = (InventoryItem) obj;
        if (UtilsKt.isArizonaType() || this.isGunWorkshopContext) {
            InventoryItem inventoryItem9 = this.currentLeftItem;
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (ru.mrlargha.feature.workshop.domain.GunWorkshopRules.INSTANCE.slotRole(r8, r7, r1.getItem_type()) == ru.mrlargha.feature.workshop.domain.GunWorkshopSlotRole.SHARPENING) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (ru.mrlargha.feature.workshop.domain.GunWorkshopRules.INSTANCE.slotRole(r5, r4, r2.getItem_type()) == ru.mrlargha.feature.workshop.domain.GunWorkshopSlotRole.MAIN) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshGunWorkshopData() {
        boolean z;
        GunWorkshopAvailabilityRefreshDecision availabilityRefreshDecision;
        Integer enchant;
        Integer item;
        Integer item2;
        Integer item3;
        List<InventoryItem> list = this.inventoryItemList;
        InventoryItem inventoryItem = this.currentMainItem;
        InventoryItem inventoryItem2 = (InventoryItem) WorkshopItemUtilsKt.findUpdatedWorkshopSelection(inventoryItem, list, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((InventoryItem) obj).getSlot());
            }
        }, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InventoryItem) obj).getItem();
            }
        });
        InventoryItem inventoryItem3 = null;
        if (inventoryItem2 != null && (item3 = inventoryItem2.getItem()) != null) {
            int intValue = item3.intValue();
            GunWorkshopMode gunWorkshopMode = this.activeGunWorkshopMode;
            if (gunWorkshopMode != null) {
            }
        }
        inventoryItem2 = null;
        this.currentMainItem = inventoryItem2;
        Integer enchant2 = inventoryItem != null ? inventoryItem.getEnchant() : null;
        InventoryItem inventoryItem4 = this.currentMainItem;
        if (!Intrinsics.areEqual(enchant2, inventoryItem4 != null ? inventoryItem4.getEnchant() : null)) {
            this.hasServerGunWorkshopRequirements = false;
        }
        InventoryItem inventoryItem5 = this.currentMainItem;
        if (inventoryItem5 != null) {
            updateMainField(inventoryItem5);
        } else {
            this.centerItemIndex = -1;
            ImageView ivItemImage = this.binding.mainItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            TextView tvMainItemDescription = this.binding.tvMainItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvMainItemDescription, "tvMainItemDescription");
            String mainFieldName = this.currentWorkshopMenu.mainFieldName(getTargetActivity());
            TextView tvTitleText = this.binding.mainItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            clearViewFromItem(ivItemImage, tvMainItemDescription, mainFieldName, tvTitleText);
            setCountsVisibility(false);
            resetGunWorkshopRequirementLabels();
            this.hasServerGunWorkshopRequirements = false;
        }
        InventoryItem inventoryItem6 = (InventoryItem) WorkshopItemUtilsKt.findUpdatedWorkshopSelection(this.currentRightItem, list, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((InventoryItem) obj).getSlot());
            }
        }, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$7
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InventoryItem) obj).getItem();
            }
        });
        if (inventoryItem6 != null && (item2 = inventoryItem6.getItem()) != null) {
            int intValue2 = item2.intValue();
            GunWorkshopMode gunWorkshopMode2 = this.activeGunWorkshopMode;
            if (gunWorkshopMode2 != null) {
            }
        }
        inventoryItem6 = null;
        this.currentRightItem = inventoryItem6;
        if (inventoryItem6 != null) {
            updateRightField(inventoryItem6);
        } else {
            this.rightItemIndex = -1;
            ImageView ivItemImage2 = this.binding.rightItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
            TextView tvRightItemDescription = this.binding.tvRightItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvRightItemDescription, "tvRightItemDescription");
            String rightFieldName = this.currentWorkshopMenu.rightFieldName(getTargetActivity());
            TextView tvTitleText2 = this.binding.rightItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
            clearViewFromItem(ivItemImage2, tvRightItemDescription, rightFieldName, tvTitleText2);
        }
        InventoryItem inventoryItem7 = (InventoryItem) WorkshopItemUtilsKt.findUpdatedWorkshopSelection(this.currentLeftItem, list, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((InventoryItem) obj).getSlot());
            }
        }, new PropertyReference1Impl() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$refreshGunWorkshopData$12
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InventoryItem) obj).getItem();
            }
        });
        if (inventoryItem7 != null && (item = inventoryItem7.getItem()) != null) {
            int intValue3 = item.intValue();
            GunWorkshopMode gunWorkshopMode3 = this.activeGunWorkshopMode;
            if (gunWorkshopMode3 != null && GunWorkshopRules.INSTANCE.slotRole(gunWorkshopMode3, intValue3, inventoryItem7.getItem_type()) == GunWorkshopSlotRole.RESOURCE) {
                inventoryItem3 = inventoryItem7;
            }
        }
        this.currentLeftItem = inventoryItem3;
        if (inventoryItem3 != null) {
            updateLeftField(inventoryItem3);
        } else {
            this.leftItemIndex = -1;
            ImageView ivItemImage3 = this.binding.leftItemField.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage3, "ivItemImage");
            TextView tvLeftItemDescription = this.binding.tvLeftItemDescription;
            Intrinsics.checkNotNullExpressionValue(tvLeftItemDescription, "tvLeftItemDescription");
            String leftFieldName = this.currentWorkshopMenu.leftFieldName(getTargetActivity());
            TextView tvTitleText3 = this.binding.leftItemField.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText3, "tvTitleText");
            clearViewFromItem(ivItemImage3, tvLeftItemDescription, leftFieldName, tvTitleText3);
        }
        GunWorkshopMode gunWorkshopMode4 = this.activeGunWorkshopMode;
        boolean z2 = true;
        if (gunWorkshopMode4 != null) {
            GunWorkshopRules gunWorkshopRules = GunWorkshopRules.INSTANCE;
            InventoryItem inventoryItem8 = this.currentMainItem;
            if (gunWorkshopRules.requirement(gunWorkshopMode4, (inventoryItem8 == null || (enchant = inventoryItem8.getEnchant()) == null) ? 0 : enchant.intValue()) != null) {
                z = true;
                if (this.currentMainItem != null || this.currentRightItem == null || this.currentLeftItem == null || this.centerItemIndex < 0 || this.leftItemIndex < 0 || this.rightItemIndex < 0 || !z) {
                    z2 = false;
                }
                if (!z2) {
                    btnSharpenEnableStatus(false);
                }
                availabilityRefreshDecision = GunWorkshopRules.INSTANCE.availabilityRefreshDecision(this.pendingGunWorkshopAvailabilityRefresh, this.isDisableAll, z2);
                this.pendingGunWorkshopAvailabilityRefresh = availabilityRefreshDecision.getKeepPending();
                if (availabilityRefreshDecision.getRequestServerAvailability()) {
                    return;
                }
                Log.d("TAG_WORKSHOP", "Revalidating gun workshop availability after craft completion");
                sendSharpenSelection();
                return;
            }
        }
        z = false;
        if (this.currentMainItem != null) {
        }
        z2 = false;
        if (!z2) {
        }
        availabilityRefreshDecision = GunWorkshopRules.INSTANCE.availabilityRefreshDecision(this.pendingGunWorkshopAvailabilityRefresh, this.isDisableAll, z2);
        this.pendingGunWorkshopAvailabilityRefresh = availabilityRefreshDecision.getKeepPending();
        if (availabilityRefreshDecision.getRequestServerAvailability()) {
        }
    }

    private final boolean hasValidGunWorkshopSelection() {
        Integer enchant;
        GunWorkshopRules gunWorkshopRules = GunWorkshopRules.INSTANCE;
        GunWorkshopMode gunWorkshopMode = this.activeGunWorkshopMode;
        InventoryItem inventoryItem = this.currentMainItem;
        return gunWorkshopRules.canRequestAvailability(gunWorkshopMode, (inventoryItem == null || (enchant = inventoryItem.getEnchant()) == null) ? 0 : enchant.intValue(), this.centerItemIndex, this.leftItemIndex, this.rightItemIndex);
    }

    private final String workshopAmountText(InventoryItem inventoryItem) {
        Long amount = inventoryItem.getAmount();
        if (amount != null) {
            long longValue = amount.longValue();
            String string = getTargetActivity().getString(R.string.workshop_amount_thousand_suffix);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getTargetActivity().getString(R.string.workshop_amount_million_suffix);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String formatWorkshopAmount = WorkshopItemUtilsKt.formatWorkshopAmount(longValue, string, string2);
            if (formatWorkshopAmount != null) {
                return formatWorkshopAmount;
            }
        }
        String text = inventoryItem.getText();
        return text == null ? "" : text;
    }

    private final void refreshInventoryCatalogMetadata() {
        if (this.inventoryItemList.isEmpty()) {
            return;
        }
        List<InventoryItem> list = this.inventoryItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            Integer item = inventoryItem.getItem();
            ItemsInfo catalogItem = item != null ? catalogItem(item.intValue()) : null;
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, catalogItem != null ? Integer.valueOf(catalogItem.getType()) : inventoryItem.getItem_type(), null, null, null, null, null, null, null, null, null, null, null, 0, catalogItem != null ? Integer.valueOf(catalogItem.getAcs_slot()) : inventoryItem.getAcsSlot(), null, false, false, null, null, null, null, null, null, 134086639, null));
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.inventoryItemList = mutableList;
        this.inventoryAdapter.submitList(CollectionsKt.toList(mutableList));
        if (this.isGunWorkshopContext) {
            refreshGunWorkshopData();
        }
    }

    private final ItemsInfo catalogItem(int i) {
        ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(UtilsKt.getItemsName(), i);
        Object obj = null;
        if (itemsInfo != null) {
            if (itemsInfo.getId() != i) {
                itemsInfo = null;
            }
            if (itemsInfo != null) {
                return itemsInfo;
            }
        }
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ItemsInfo) next).getId() == i) {
                obj = next;
                break;
            }
        }
        return (ItemsInfo) obj;
    }

    private final void startProgressBarAnimation(final long j, boolean z) {
        this.progress = 0;
        this.binding.infoContainers.sharpingInfoContainer.progressBar.setMax(100);
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.feature.workshop.presentation.WorkshopScreen$startProgressBarAnimation$1
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
                    ProgressBar progressBar = workshopScreenBinding.infoContainers.sharpingInfoContainer.progressBar;
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
        this.binding.infoContainers.sharpingInfoContainer.successChanceField.valueTextView.setText(String.valueOf(workshopResponse.getChance()));
        this.binding.infoContainers.sharpingInfoContainer.costField.valueTextView.setText(String.valueOf(workshopResponse.getCost()));
    }

    /* compiled from: WorkshopScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.WORKSHOP);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new WorkshopScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            cancelStandardContextFallback();
            this.workshopContextType = null;
            this.isGunWorkshopContext = false;
            this.activeGunWorkshopMode = null;
            this.isDisableAll = true;
            this.centerItemIndex = -1;
            this.leftItemIndex = -1;
            this.rightItemIndex = -1;
            this.currentMainItem = null;
            this.currentLeftItem = null;
            this.currentRightItem = null;
            this.hasServerGunWorkshopRequirements = false;
            this.pendingGunWorkshopAvailabilityRefresh = false;
            this.inventoryAdapter.setItemEligibilityPredicate(null);
            btnSharpenEnableStatus(false);
            btnPaintEnableStatus(false);
        }
        super.setVisibility(z);
    }

    /* compiled from: WorkshopScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopScreen$Companion;", "", "<init>", "()V", "STANDARD_CONTEXT_FALLBACK_DELAY_MS", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
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

package ru.mrlargha.commonui.elements.craft.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
import ru.mrlargha.commonui.databinding.CraftScreenBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.craft.domain.CategoryItem;
import ru.mrlargha.commonui.elements.craft.domain.CraftItem;
import ru.mrlargha.commonui.elements.craft.domain.CraftItemInfo;
import ru.mrlargha.commonui.elements.craft.domain.CraftResponse;
import ru.mrlargha.commonui.elements.craft.domain.CraftStart;
import ru.mrlargha.commonui.elements.craft.domain.CraftSuccess;
import ru.mrlargha.commonui.elements.craft.domain.CraftTuningItems;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.elements.craft.domain.NeedItems;
import ru.mrlargha.commonui.elements.craft.domain.NeedItemsUi;
import ru.mrlargha.commonui.elements.craft.domain.SendCategory;
import ru.mrlargha.commonui.elements.craft.domain.SendColorInfo;
import ru.mrlargha.commonui.elements.craft.domain.SendCreateItem;
import ru.mrlargha.commonui.elements.craft.domain.SendDataInfo;
import ru.mrlargha.commonui.elements.craft.domain.UpdateCount;
import ru.mrlargha.commonui.elements.craft.presentation.adapter.ColorsTypeAdapter;
import ru.mrlargha.commonui.elements.craft.presentation.adapter.CraftItemsAdapter;
import ru.mrlargha.commonui.elements.craft.presentation.adapter.CraftMenuAdapter;
import ru.mrlargha.commonui.elements.craft.presentation.adapter.NeedResourcesAdapter;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: CraftScreen.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0002lmB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020.H\u0002J\u0018\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020DH\u0002J\u0010\u0010K\u001a\u00020D2\u0006\u0010E\u001a\u00020.H\u0002J\u0010\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020.H\u0002J\u0010\u0010N\u001a\u00020D2\u0006\u0010M\u001a\u00020.H\u0002J\b\u0010O\u001a\u00020DH\u0002J\b\u0010P\u001a\u00020DH\u0002J\u0010\u00104\u001a\u00020D2\u0006\u0010Q\u001a\u000205H\u0002J\u0010\u00107\u001a\u00020D2\u0006\u0010Q\u001a\u000205H\u0002J\b\u0010R\u001a\u00020DH\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u000202H\u0002J\u0010\u0010W\u001a\u00020D2\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0010\u0010X\u001a\u00020D2\u0006\u0010T\u001a\u00020#H\u0002J\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z01*\b\u0012\u0004\u0012\u00020B01H\u0002J\u0010\u0010[\u001a\u00020D2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020D2\u0006\u0010E\u001a\u00020.H\u0002J\u0018\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u0006H\u0002J\u0010\u0010b\u001a\u00020D2\u0006\u0010c\u001a\u00020\u0006H\u0002J\b\u0010d\u001a\u00020DH\u0002J\u0010\u0010e\u001a\u00020D2\u0006\u0010T\u001a\u00020#H\u0002J\u0010\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006H\u0002J\u0018\u0010h\u001a\u00020D2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020.H\u0016J\b\u0010k\u001a\u00020DH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n 6*\u0004\u0018\u00010505X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n 6*\u0004\u0018\u00010505X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u000601X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n 6*\u0004\u0018\u00010;0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/CraftScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "craftScreen", "Landroid/widget/FrameLayout;", "binding", "Lru/mrlargha/commonui/databinding/CraftScreenBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "craftResponse", "Lru/mrlargha/commonui/elements/craft/domain/CraftResponse;", "categoryMenu", "", "colorsList", "Lru/mrlargha/commonui/elements/craft/domain/ItemColor;", "craftItemsAdapter", "Lru/mrlargha/commonui/elements/craft/presentation/adapter/CraftItemsAdapter;", "craftMenuAdapter", "Lru/mrlargha/commonui/elements/craft/presentation/adapter/CraftMenuAdapter;", "needResourcesAdapter", "Lru/mrlargha/commonui/elements/craft/presentation/adapter/NeedResourcesAdapter;", "craftItemsSelectedPosition", "craftMenuSelectedId", "colorsTypeAdapter", "Lru/mrlargha/commonui/elements/craft/presentation/adapter/ColorsTypeAdapter;", "selectedColor", "selectedColorPosition", "currentNumber", "currentCraftedItem", "Lru/mrlargha/commonui/elements/craft/domain/CraftItemInfo;", "currentItem", "currentItemIndex", "incrementHandler", "Landroid/os/Handler;", "newHandler", "progress", "progressIncrement", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "isEnabledCraft", "", "isCancelClicked", "pagingCraftList", "", "Lru/mrlargha/commonui/elements/craft/domain/CraftItem;", "showingList", "fadeUpAnimation", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeDownAnimation", "currentPage", "tuningItems", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "isDisableAll", "inventoryList", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "isCraftProcess", "needList", "Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "setEnableEtResourcesCount", "", "isEnable", "onBackendMessage", "data", "", "subId", "getInventoryList", "isEnabledCraftItem", "editNumber", "isPlus", "incrementFaster", "updateItemCounts", "resetCraftAttempts", "animation", "defaultScreen", "fillColorsList", "response", "editCraftItemUi", "craftItem", "initMenuCategories", "initItemUi", "toUi", "Lru/mrlargha/commonui/elements/craft/domain/NeedItemsUi;", "startProgressBarAnimation", "time", "", "isEnableButtons", "getItemFromInventory", "item", "successAmount", "initCraftItems", "clickedPos", "clearColor", "refreshData", "getTuningItem", "itemId", "sendRequest", "setVisible", "visible", "closeScreen", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftScreen extends SAMPUIElement implements InterfaceController {
    private static final String CRAFT_SCREEN_TAG = "CRAFT_SCREEN_TAG";
    public static final Companion Companion = new Companion(null);
    private static final int MAX_CRAFT_COUNT_ARIZONA = 10;
    private static final int MAX_CRAFT_COUNT_RODINA = 1000;
    private final CraftScreenBinding binding;
    private List<Integer> categoryMenu;
    private List<ItemColor> colorsList;
    private final ColorsTypeAdapter colorsTypeAdapter;
    private CraftItemsAdapter craftItemsAdapter;
    private int craftItemsSelectedPosition;
    private CraftMenuAdapter craftMenuAdapter;
    private int craftMenuSelectedId;
    private CraftResponse craftResponse;
    private final FrameLayout craftScreen;
    private CraftItemInfo currentCraftedItem;
    private int currentItem;
    private int currentItemIndex;
    private int currentNumber;
    private int currentPage;
    private final AppDatabase db;
    private final Animation fadeDownAnimation;
    private final Animation fadeUpAnimation;
    private final IBackendNotifier frontendNotifier;
    private Handler incrementHandler;
    private List<InventoryItem> inventoryList;
    private final boolean isArizonaType;
    private boolean isCancelClicked;
    private boolean isCraftProcess;
    private boolean isDisableAll;
    private boolean isEnabledCraft;
    private List<NeedItems> needList;
    private NeedResourcesAdapter needResourcesAdapter;
    private Handler newHandler;
    private List<CraftItem> pagingCraftList;
    private int progress;
    private final int progressIncrement;
    private int selectedColor;
    private int selectedColorPosition;
    private final SharedPreferences sharedPref;
    private List<CraftItem> showingList;
    private List<Integer> tuningItems;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CraftScreen(final Activity targetActivity, int i) {
        super(targetActivity, i);
        String jsonFromAssets;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.craft_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.craftScreen = frameLayout;
        CraftScreenBinding bind = CraftScreenBinding.bind(frameLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        this.categoryMenu = new ArrayList();
        this.colorsList = new ArrayList();
        Activity activity = targetActivity;
        this.needResourcesAdapter = new NeedResourcesAdapter(activity, new Function1() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit needResourcesAdapter$lambda$0;
                needResourcesAdapter$lambda$0 = CraftScreen.needResourcesAdapter$lambda$0(CraftScreen.this, ((Integer) obj).intValue());
                return needResourcesAdapter$lambda$0;
            }
        });
        this.colorsTypeAdapter = new ColorsTypeAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit colorsTypeAdapter$lambda$1;
                colorsTypeAdapter$lambda$1 = CraftScreen.colorsTypeAdapter$lambda$1(CraftScreen.this, targetActivity, (ItemColor) obj, ((Integer) obj2).intValue());
                return colorsTypeAdapter$lambda$1;
            }
        });
        this.selectedColorPosition = -1;
        this.currentNumber = 1;
        this.currentItemIndex = -1;
        this.incrementHandler = new Handler();
        this.newHandler = new Handler();
        this.progressIncrement = 1;
        this.db = AppDatabase.Companion.invoke(activity);
        this.pagingCraftList = CollectionsKt.emptyList();
        this.showingList = CollectionsKt.emptyList();
        this.fadeUpAnimation = AnimationUtils.loadAnimation(activity, R.anim.fade_up);
        this.fadeDownAnimation = AnimationUtils.loadAnimation(activity, R.anim.fade_down);
        this.currentPage = 1;
        this.tuningItems = CollectionsKt.emptyList();
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        frameLayout.setClickable(true);
        addViewToConstraintLayout(frameLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        updateItemCounts();
        bind.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$2(CraftScreen.this, targetActivity, view);
            }
        });
        bind.btnEnableCreateItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$3(CraftScreen.this, view);
            }
        });
        bind.successLayout.btnAcceptCraft.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$5(CraftScreen.this, view);
            }
        });
        bind.successLayout.ivBgCraftResult.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$6(view);
            }
        });
        bind.btnCancelCraft.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$7(CraftScreen.this, view);
            }
        });
        bind.cvColor.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$8(CraftScreen.this, targetActivity, view);
            }
        });
        bind.ivPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen.this.editNumber(true);
            }
        });
        bind.ivPlus.setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean _init_$lambda$10;
                _init_$lambda$10 = CraftScreen._init_$lambda$10(CraftScreen.this, view);
                return _init_$lambda$10;
            }
        });
        bind.ivPlus.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$11;
                _init_$lambda$11 = CraftScreen._init_$lambda$11(CraftScreen.this, view, motionEvent);
                return _init_$lambda$11;
            }
        });
        bind.ivMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$12(CraftScreen.this, view);
            }
        });
        bind.ivMinus.setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean _init_$lambda$13;
                _init_$lambda$13 = CraftScreen._init_$lambda$13(CraftScreen.this, view);
                return _init_$lambda$13;
            }
        });
        bind.ivMinus.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$14;
                _init_$lambda$14 = CraftScreen._init_$lambda$14(CraftScreen.this, view, motionEvent);
                return _init_$lambda$14;
            }
        });
        bind.successChanceField.nameTextView.setText(targetActivity.getString(R.string.success_chance));
        bind.costField.nameTextView.setText(targetActivity.getString(R.string.cost));
        bind.experienceField.nameTextView.setText(targetActivity.getString(R.string.experience));
        ConstraintLayout parentLayout = bind.experienceField.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(!z ? 0 : 8);
        ImageView ivValueIcon = bind.experienceField.ivValueIcon;
        Intrinsics.checkNotNullExpressionValue(ivValueIcon, "ivValueIcon");
        ivValueIcon.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = bind.cvColor.getLayoutParams();
        int roundToInt = MathKt.roundToInt(targetActivity.getResources().getDisplayMetrics().widthPixels * 0.09d);
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt;
        bind.cvColor.setLayoutParams(layoutParams);
        if (z) {
            jsonFromAssets = UtilsKt.getJsonFromAssets(activity, "arzCraftTuningItems.json");
        } else {
            jsonFromAssets = UtilsKt.getJsonFromAssets(activity, "craftTuningItems.json");
        }
        if (jsonFromAssets != null) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(jsonFromAssets, (Class<Object>) CraftTuningItems.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            this.tuningItems = ((CraftTuningItems) fromJson).getItems();
        }
        sendRequest(1, StringKt.toStringJson(new SendCategory(this.craftMenuSelectedId, 0)));
        ConstraintLayout craftContainer = bind.craftContainer;
        Intrinsics.checkNotNullExpressionValue(craftContainer, "craftContainer");
        craftContainer.setVisibility(4);
        ProgressBar containerProgress = bind.containerProgress;
        Intrinsics.checkNotNullExpressionValue(containerProgress, "containerProgress");
        containerProgress.setVisibility(0);
        getInventoryList();
        bind.ivItemIcon.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftScreen._init_$lambda$15(CraftScreen.this, view);
            }
        });
        if (!z) {
            bind.etResourcesCount.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda19
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    boolean _init_$lambda$16;
                    _init_$lambda$16 = CraftScreen._init_$lambda$16(CraftScreen.this, textView, i2, keyEvent);
                    return _init_$lambda$16;
                }
            });
        } else {
            setEnableEtResourcesCount(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit needResourcesAdapter$lambda$0(CraftScreen craftScreen, int i) {
        craftScreen.sendRequest(4, StringKt.toStringJson(new SendDataInfo(i)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit colorsTypeAdapter$lambda$1(CraftScreen craftScreen, Activity activity, ItemColor item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        Group groupCharacter = craftScreen.binding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(0);
        RecyclerView rvColors = craftScreen.binding.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(8);
        craftScreen.binding.tvTitle.setText(activity.getString(R.string.workshop));
        craftScreen.binding.cvColorIcon.setCardBackgroundColor(UtilsKt.getColorTint(item.getColor()));
        craftScreen.binding.tvColorName.setText(item.getName());
        craftScreen.selectedColor = item.getColor();
        craftScreen.selectedColorPosition = i;
        craftScreen.isEnabledCraftItem(craftScreen.isEnabledCraft);
        craftScreen.sendRequest(5, StringKt.toStringJson(new SendColorInfo(craftScreen.craftItemsSelectedPosition, craftScreen.selectedColorPosition, craftScreen.craftMenuSelectedId)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(CraftScreen craftScreen, Activity activity, View view) {
        craftScreen.isCancelClicked = true;
        Group groupCharacter = craftScreen.binding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        if (groupCharacter.getVisibility() == 0) {
            craftScreen.closeScreen();
            return;
        }
        Group groupCharacter2 = craftScreen.binding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter2, "groupCharacter");
        groupCharacter2.setVisibility(0);
        RecyclerView rvColors = craftScreen.binding.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(8);
        craftScreen.binding.tvTitle.setText(activity.getString(R.string.workshop));
        craftScreen.isEnabledCraftItem(craftScreen.isEnabledCraft);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(CraftScreen craftScreen, View view) {
        Log.d(CRAFT_SCREEN_TAG, "click on enableCreate item  ");
        craftScreen.isCraftProcess = true;
        CraftItemsAdapter craftItemsAdapter = craftScreen.craftItemsAdapter;
        if (craftItemsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
            craftItemsAdapter = null;
        }
        craftScreen.craftItemsSelectedPosition = craftItemsAdapter.getSelectedItemPosition();
        craftScreen.sendRequest(2, StringKt.toStringJson(new SendCreateItem(craftScreen.craftMenuSelectedId, craftScreen.craftItemsSelectedPosition, craftScreen.selectedColorPosition, craftScreen.currentNumber)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(CraftScreen craftScreen, View view) {
        ConstraintLayout parentLayout = craftScreen.binding.successLayout.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        CraftItemInfo craftItemInfo = craftScreen.currentCraftedItem;
        if (craftItemInfo != null) {
            craftScreen.initItemUi(craftItemInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(CraftScreen craftScreen, View view) {
        craftScreen.isCancelClicked = true;
        craftScreen.progress = 0;
        Button btnCancelCraft = craftScreen.binding.btnCancelCraft;
        Intrinsics.checkNotNullExpressionValue(btnCancelCraft, "btnCancelCraft");
        btnCancelCraft.setVisibility(8);
        ProgressBar progressBar = craftScreen.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        craftScreen.sendRequest(3, StringKt.toStringJson("0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8(CraftScreen craftScreen, Activity activity, View view) {
        Group groupCharacter = craftScreen.binding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(8);
        TextView btnEnableCreateItem = craftScreen.binding.btnEnableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnEnableCreateItem, "btnEnableCreateItem");
        btnEnableCreateItem.setVisibility(8);
        Button btnDisableCreateItem = craftScreen.binding.btnDisableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnDisableCreateItem, "btnDisableCreateItem");
        btnDisableCreateItem.setVisibility(8);
        RecyclerView rvColors = craftScreen.binding.rvColors;
        Intrinsics.checkNotNullExpressionValue(rvColors, "rvColors");
        rvColors.setVisibility(0);
        craftScreen.binding.tvTitle.setText(activity.getString(R.string.choose_color));
        craftScreen.colorsTypeAdapter.submitList(craftScreen.colorsList);
        craftScreen.colorsTypeAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$10(CraftScreen craftScreen, View view) {
        craftScreen.incrementFaster(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$11(CraftScreen craftScreen, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            craftScreen.newHandler.removeCallbacksAndMessages(null);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$12(CraftScreen craftScreen, View view) {
        if (craftScreen.currentNumber > 1) {
            craftScreen.editNumber(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$13(CraftScreen craftScreen, View view) {
        if (craftScreen.currentNumber > 1) {
            craftScreen.incrementFaster(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$14(CraftScreen craftScreen, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            craftScreen.newHandler.removeCallbacksAndMessages(null);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$15(CraftScreen craftScreen, View view) {
        craftScreen.sendRequest(4, StringKt.toStringJson(new SendDataInfo(craftScreen.currentItem)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$16(CraftScreen craftScreen, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            Integer intOrNull = StringsKt.toIntOrNull(textView.getText().toString());
            if (intOrNull != null) {
                Log.e("EditText", intOrNull.toString());
                if (intOrNull.intValue() < 1000) {
                    craftScreen.currentNumber = intOrNull.intValue() > 1 ? intOrNull.intValue() : 1;
                } else {
                    craftScreen.currentNumber = 1000;
                }
            }
            Object systemService = textView.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            textView.clearFocus();
            craftScreen.updateItemCounts();
            return true;
        }
        return false;
    }

    private final void setEnableEtResourcesCount(boolean z) {
        EditText editText = this.binding.etResourcesCount;
        editText.setFocusable(z);
        editText.setFocusableInTouchMode(z);
        editText.setClickable(z);
        editText.setLongClickable(z);
        editText.setInputType(z ? 2 : 0);
        editText.setTextIsSelectable(z);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        CraftStart craftStart;
        boolean z;
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_CRAFT", "data: " + data + " ======= subID: " + i);
        if (i == 0) {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftResponse.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            CraftResponse craftResponse = (CraftResponse) fromJson;
            initMenuCategories(craftResponse);
            this.craftResponse = craftResponse;
            fillColorsList(craftResponse);
            ConstraintLayout craftContainer = this.binding.craftContainer;
            Intrinsics.checkNotNullExpressionValue(craftContainer, "craftContainer");
            craftContainer.setVisibility(0);
            ProgressBar containerProgress = this.binding.containerProgress;
            Intrinsics.checkNotNullExpressionValue(containerProgress, "containerProgress");
            containerProgress.setVisibility(4);
        } else if (i == 1) {
            Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftItemInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
            CraftItemInfo craftItemInfo = (CraftItemInfo) fromJson2;
            this.currentCraftedItem = craftItemInfo;
            if (this.isCraftProcess) {
                initItemUi(craftItemInfo);
                return;
            }
            defaultScreen();
            initItemUi(craftItemInfo);
        } else if (i == 2) {
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"time\":", false, 2, (Object) null)) {
                setEnableEtResourcesCount(false);
                Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftStart.class);
                Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                this.isDisableAll = true;
                isEnableButtons(false);
                Log.e("craft", "leftTime: " + CraftScreenKt.craftTimeConvert(craftStart.getTime() - currentTimeMillis));
                startProgressBarAnimation(((CraftStart) fromJson3).getTime() - currentTimeMillis);
            }
        } else if (i == 3) {
            if (!this.isArizonaType) {
                setEnableEtResourcesCount(true);
            }
            this.isCraftProcess = false;
            List<NeedItems> list = this.needList;
            if (list != null) {
                List<NeedItemsUi> ui = toUi(list);
                if (!(ui instanceof Collection) || !ui.isEmpty()) {
                    for (NeedItemsUi needItemsUi : ui) {
                        if (needItemsUi.getAmountHave() < needItemsUi.getAmountNeed()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                isEnabledCraftItem(z);
                Log.i(CRAFT_SCREEN_TAG, "onBackendMessage: " + z);
            }
            if (this.isCancelClicked) {
                this.isCancelClicked = false;
                this.isDisableAll = false;
                isEnableButtons(true);
                CraftItemInfo craftItemInfo2 = this.currentCraftedItem;
                if (craftItemInfo2 != null) {
                    initItemUi(craftItemInfo2);
                }
                this.progress = 0;
                this.binding.progressBar.setProgress(0);
                this.incrementHandler.removeCallbacksAndMessages(null);
            }
        } else if (i == 4) {
            int i2 = this.currentNumber;
            if (i2 > 1) {
                this.currentNumber = i2 - 1;
            }
            Log.e(CRAFT_SCREEN_TAG, "current number after 4-th update: " + this.currentNumber);
            sendRequest(6, StringKt.toStringJson(new UpdateCount(this.currentPage, this.currentItemIndex, this.currentNumber)));
            if (StringsKt.contains$default((CharSequence) data, (CharSequence) FirebaseAnalytics.Param.SUCCESS, false, 2, (Object) null)) {
                isEnableButtons(true);
                Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) CraftSuccess.class);
                Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
                CraftSuccess craftSuccess = (CraftSuccess) fromJson4;
                CraftItemInfo craftItemInfo3 = this.currentCraftedItem;
                if (craftItemInfo3 != null) {
                    refreshData(craftItemInfo3);
                }
                this.incrementHandler.removeCallbacksAndMessages(null);
                int success = craftSuccess.getSuccess();
                if (success == 0) {
                    Animation fadeUpAnimation = this.fadeUpAnimation;
                    Intrinsics.checkNotNullExpressionValue(fadeUpAnimation, "fadeUpAnimation");
                    fadeUpAnimation(fadeUpAnimation);
                    this.binding.ivBgFlashLight.startAnimation(this.fadeUpAnimation);
                    ImageView ivBgFlashLight = this.binding.ivBgFlashLight;
                    Intrinsics.checkNotNullExpressionValue(ivBgFlashLight, "ivBgFlashLight");
                    ivBgFlashLight.setVisibility(0);
                    this.isDisableAll = false;
                    this.binding.ivBgFlashLight.setBackgroundResource(R.drawable.bg_failure_red);
                    this.newHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            CraftScreen.onBackendMessage$lambda$22(CraftScreen.this);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                } else if (success == 1) {
                    if (craftSuccess.getCount() == 0) {
                        this.isDisableAll = false;
                        resetCraftAttempts();
                    } else {
                        this.binding.etResourcesCount.setText(String.valueOf(craftSuccess.getCount()));
                    }
                    CraftItemInfo craftItemInfo4 = this.currentCraftedItem;
                    if (craftItemInfo4 != null && craftItemInfo4.getShowInfo() == 1) {
                        TextView btnEnableCreateItem = this.binding.btnEnableCreateItem;
                        Intrinsics.checkNotNullExpressionValue(btnEnableCreateItem, "btnEnableCreateItem");
                        btnEnableCreateItem.setVisibility(8);
                        Button btnCancelCraft = this.binding.btnCancelCraft;
                        Intrinsics.checkNotNullExpressionValue(btnCancelCraft, "btnCancelCraft");
                        btnCancelCraft.setVisibility(8);
                        MaterialCardView cvColor = this.binding.cvColor;
                        Intrinsics.checkNotNullExpressionValue(cvColor, "cvColor");
                        cvColor.setVisibility(8);
                        ConstraintLayout parentLayout = this.binding.successLayout.parentLayout;
                        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
                        parentLayout.setVisibility(0);
                        this.binding.successLayout.ivBgCraftResult.setImageResource(R.drawable.bg_success_green);
                        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, this.currentItem, null, 4, null);
                        if (iconFromArchive$default != null) {
                            ImageView ivItemIcon = this.binding.ivItemIcon;
                            Intrinsics.checkNotNullExpressionValue(ivItemIcon, "ivItemIcon");
                            UtilsKt.setImage(ivItemIcon, iconFromArchive$default);
                        }
                        Iterator<T> it = ConstantsKt.getColorList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((ItemColor) obj).getColor() == this.selectedColor) {
                                break;
                            }
                        }
                        ItemColor itemColor = (ItemColor) obj;
                        ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(UtilsKt.getItemsName(), this.currentItem);
                        String name = itemsInfo != null ? itemsInfo.getName() : null;
                        this.binding.successLayout.tvCraftItemName.setText(name != null ? name : "");
                        CraftItemInfo craftItemInfo5 = this.currentCraftedItem;
                        if (craftItemInfo5 != null && craftItemInfo5.getHasColor() == 1) {
                            CardView viewTopRight = this.binding.successLayout.viewTopRight;
                            Intrinsics.checkNotNullExpressionValue(viewTopRight, "viewTopRight");
                            viewTopRight.setVisibility(0);
                            this.binding.successLayout.viewTopRight.setCardBackgroundColor(UtilsKt.getColorTint(this.selectedColor));
                            TextView textView = this.binding.successLayout.tvCraftItemName;
                            if (name == null) {
                                name = "(" + (itemColor != null ? itemColor.getName() : null) + ")";
                            }
                            textView.setText(name);
                            return;
                        }
                        CardView viewTopRight2 = this.binding.successLayout.viewTopRight;
                        Intrinsics.checkNotNullExpressionValue(viewTopRight2, "viewTopRight");
                        viewTopRight2.setVisibility(8);
                        return;
                    }
                    CraftItemInfo craftItemInfo6 = this.currentCraftedItem;
                    if (craftItemInfo6 != null) {
                        initItemUi(craftItemInfo6);
                    }
                    Animation fadeUpAnimation2 = this.fadeUpAnimation;
                    Intrinsics.checkNotNullExpressionValue(fadeUpAnimation2, "fadeUpAnimation");
                    fadeUpAnimation(fadeUpAnimation2);
                    this.binding.ivBgFlashLight.startAnimation(this.fadeUpAnimation);
                    ImageView ivBgFlashLight2 = this.binding.ivBgFlashLight;
                    Intrinsics.checkNotNullExpressionValue(ivBgFlashLight2, "ivBgFlashLight");
                    ivBgFlashLight2.setVisibility(0);
                    this.binding.ivBgFlashLight.setBackgroundResource(R.drawable.bg_success_green);
                    this.newHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            CraftScreen.onBackendMessage$lambda$26(CraftScreen.this);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$22(CraftScreen craftScreen) {
        Animation fadeDownAnimation = craftScreen.fadeDownAnimation;
        Intrinsics.checkNotNullExpressionValue(fadeDownAnimation, "fadeDownAnimation");
        craftScreen.fadeDownAnimation(fadeDownAnimation);
        craftScreen.binding.ivBgFlashLight.startAnimation(craftScreen.fadeDownAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$26(CraftScreen craftScreen) {
        Animation fadeDownAnimation = craftScreen.fadeDownAnimation;
        Intrinsics.checkNotNullExpressionValue(fadeDownAnimation, "fadeDownAnimation");
        craftScreen.fadeDownAnimation(fadeDownAnimation);
        craftScreen.binding.ivBgFlashLight.startAnimation(craftScreen.fadeDownAnimation);
    }

    private final void getInventoryList() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CraftScreen$getInventoryList$1(this, null), 3, null);
    }

    private final void isEnabledCraftItem(boolean z) {
        if (this.isCraftProcess) {
            return;
        }
        if (z) {
            Button btnDisableCreateItem = this.binding.btnDisableCreateItem;
            Intrinsics.checkNotNullExpressionValue(btnDisableCreateItem, "btnDisableCreateItem");
            btnDisableCreateItem.setVisibility(8);
            TextView btnEnableCreateItem = this.binding.btnEnableCreateItem;
            Intrinsics.checkNotNullExpressionValue(btnEnableCreateItem, "btnEnableCreateItem");
            btnEnableCreateItem.setVisibility(0);
            this.isEnabledCraft = true;
            return;
        }
        TextView btnEnableCreateItem2 = this.binding.btnEnableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnEnableCreateItem2, "btnEnableCreateItem");
        btnEnableCreateItem2.setVisibility(8);
        Button btnDisableCreateItem2 = this.binding.btnDisableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnDisableCreateItem2, "btnDisableCreateItem");
        btnDisableCreateItem2.setVisibility(0);
        this.isEnabledCraft = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void editNumber(boolean z) {
        if (z) {
            this.currentNumber++;
        } else {
            this.currentNumber--;
        }
        if (this.currentNumber >= (this.isArizonaType ? 10 : 1000)) {
            this.binding.ivPlus.setEnabled(false);
        } else {
            this.binding.ivPlus.setEnabled(true);
        }
        updateItemCounts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementFaster(final boolean z) {
        if (this.currentNumber > 1) {
            editNumber(z);
            this.newHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    CraftScreen.this.incrementFaster(z);
                }
            }, 100L);
        }
    }

    private final void updateItemCounts() {
        this.binding.etResourcesCount.setText(String.valueOf(this.currentNumber));
        sendRequest(6, StringKt.toStringJson(new UpdateCount(this.currentPage, this.currentItemIndex, this.currentNumber)));
    }

    private final void resetCraftAttempts() {
        this.binding.etResourcesCount.setText(String.valueOf(this.currentNumber));
    }

    private final void fadeUpAnimation(Animation animation) {
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$fadeUpAnimation$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                CraftScreenBinding craftScreenBinding;
                craftScreenBinding = CraftScreen.this.binding;
                ImageView ivBgFlashLight = craftScreenBinding.ivBgFlashLight;
                Intrinsics.checkNotNullExpressionValue(ivBgFlashLight, "ivBgFlashLight");
                ivBgFlashLight.setVisibility(0);
            }
        });
    }

    private final void fadeDownAnimation(Animation animation) {
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$fadeDownAnimation$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                CraftScreenBinding craftScreenBinding;
                craftScreenBinding = CraftScreen.this.binding;
                ImageView ivBgFlashLight = craftScreenBinding.ivBgFlashLight;
                Intrinsics.checkNotNullExpressionValue(ivBgFlashLight, "ivBgFlashLight");
                ivBgFlashLight.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                CraftScreenBinding craftScreenBinding;
                craftScreenBinding = CraftScreen.this.binding;
                ImageView ivBgFlashLight = craftScreenBinding.ivBgFlashLight;
                Intrinsics.checkNotNullExpressionValue(ivBgFlashLight, "ivBgFlashLight");
                ivBgFlashLight.setVisibility(8);
            }
        });
    }

    private final void defaultScreen() {
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        Button btnCancelCraft = this.binding.btnCancelCraft;
        Intrinsics.checkNotNullExpressionValue(btnCancelCraft, "btnCancelCraft");
        btnCancelCraft.setVisibility(8);
    }

    private final void fillColorsList(CraftResponse craftResponse) {
        this.selectedColor = craftResponse.getColors().get(0).getColor();
        this.selectedColorPosition = 0;
        this.binding.rvColors.setAdapter(this.colorsTypeAdapter);
        this.binding.rvColors.setHasFixedSize(true);
        this.colorsList = CollectionsKt.toMutableList((Collection) craftResponse.getColors());
        for (int i = 0; i < 2; i++) {
            this.colorsList.add(new ItemColor(0, "", true));
        }
    }

    private final void editCraftItemUi(CraftItem craftItem) {
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, craftItem.getItem(), null, 4, null);
        if (iconFromArchive$default != null) {
            ImageView ivItemIcon = this.binding.ivItemIcon;
            Intrinsics.checkNotNullExpressionValue(ivItemIcon, "ivItemIcon");
            UtilsKt.setImage(ivItemIcon, iconFromArchive$default);
        }
        this.binding.tvItemName.setText(craftItem.getName());
    }

    private final void initMenuCategories(CraftResponse craftResponse) {
        this.craftMenuAdapter = new CraftMenuAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initMenuCategories$lambda$29;
                initMenuCategories$lambda$29 = CraftScreen.initMenuCategories$lambda$29(CraftScreen.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initMenuCategories$lambda$29;
            }
        });
        RecyclerView recyclerView = this.binding.rvMenu;
        CraftMenuAdapter craftMenuAdapter = this.craftMenuAdapter;
        CraftMenuAdapter craftMenuAdapter2 = null;
        if (craftMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
            craftMenuAdapter = null;
        }
        recyclerView.setAdapter(craftMenuAdapter);
        for (CategoryItem categoryItem : craftResponse.getCategories()) {
            this.categoryMenu.add(Integer.valueOf(categoryItem.getCategory()));
        }
        CraftMenuAdapter craftMenuAdapter3 = this.craftMenuAdapter;
        if (craftMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
            craftMenuAdapter3 = null;
        }
        craftMenuAdapter3.submitList(this.categoryMenu);
        CraftMenuAdapter craftMenuAdapter4 = this.craftMenuAdapter;
        if (craftMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
        } else {
            craftMenuAdapter2 = craftMenuAdapter4;
        }
        if (craftMenuAdapter2.getItemCount() > 0) {
            this.binding.rvMenu.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    CraftScreen.initMenuCategories$lambda$31(CraftScreen.this);
                }
            });
        }
        if (this.craftResponse != null) {
            initCraftItems(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMenuCategories$lambda$29(CraftScreen craftScreen, int i, int i2) {
        if (craftScreen.isDisableAll) {
            return Unit.INSTANCE;
        }
        CraftMenuAdapter craftMenuAdapter = craftScreen.craftMenuAdapter;
        CraftMenuAdapter craftMenuAdapter2 = null;
        if (craftMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
            craftMenuAdapter = null;
        }
        int selectedItemPosition = craftMenuAdapter.getSelectedItemPosition();
        CraftMenuAdapter craftMenuAdapter3 = craftScreen.craftMenuAdapter;
        if (craftMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
            craftMenuAdapter3 = null;
        }
        craftMenuAdapter3.setSelectedItemPosition(i2);
        craftScreen.craftMenuSelectedId = i;
        CraftMenuAdapter craftMenuAdapter4 = craftScreen.craftMenuAdapter;
        if (craftMenuAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
            craftMenuAdapter4 = null;
        }
        craftMenuAdapter4.notifyItemChanged(selectedItemPosition);
        CraftMenuAdapter craftMenuAdapter5 = craftScreen.craftMenuAdapter;
        if (craftMenuAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftMenuAdapter");
        } else {
            craftMenuAdapter2 = craftMenuAdapter5;
        }
        craftMenuAdapter2.notifyItemChanged(i2);
        craftScreen.showingList = CollectionsKt.emptyList();
        craftScreen.currentPage = i2;
        craftScreen.initCraftItems(i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenuCategories$lambda$31(CraftScreen craftScreen) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = craftScreen.binding.rvMenu.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    private final void initItemUi(CraftItemInfo craftItemInfo) {
        boolean z;
        this.binding.rvNeedResources.setAdapter(this.needResourcesAdapter);
        this.binding.successChanceField.nameTextView.setText(getTargetActivity().getString(R.string.success_chance));
        this.binding.successChanceField.valueTextView.setText(craftItemInfo.getChance() + " ");
        this.binding.successChanceField.ivValueIcon.setImageResource(R.drawable.ic_percent_16);
        this.binding.costField.valueTextView.setText(craftItemInfo.getCost() + " ");
        this.binding.experienceField.valueTextView.setText("+" + craftItemInfo.getExp() + " ");
        if (this.isArizonaType) {
            this.binding.costField.ivValueIcon.setImageResource(R.drawable.ic_dollar_16);
        } else {
            this.binding.costField.ivValueIcon.setImageResource(R.drawable.ic_rubble);
        }
        this.needList = craftItemInfo.getNeeds();
        List<NeedItemsUi> ui = toUi(craftItemInfo.getNeeds());
        List<NeedItemsUi> list = ui;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (NeedItemsUi needItemsUi : list) {
                if (needItemsUi.getAmountHave() < needItemsUi.getAmountNeed()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        isEnabledCraftItem(z);
        this.needResourcesAdapter.submitList(ui);
        this.needResourcesAdapter.notifyDataSetChanged();
        if (craftItemInfo.getHasColor() == 1) {
            MaterialCardView cvColor = this.binding.cvColor;
            Intrinsics.checkNotNullExpressionValue(cvColor, "cvColor");
            cvColor.setVisibility(0);
            TextView tvColorTitle = this.binding.tvColorTitle;
            Intrinsics.checkNotNullExpressionValue(tvColorTitle, "tvColorTitle");
            tvColorTitle.setVisibility(0);
        } else if (craftItemInfo.getHasColor() == 0) {
            MaterialCardView cvColor2 = this.binding.cvColor;
            Intrinsics.checkNotNullExpressionValue(cvColor2, "cvColor");
            cvColor2.setVisibility(8);
            TextView tvColorTitle2 = this.binding.tvColorTitle;
            Intrinsics.checkNotNullExpressionValue(tvColorTitle2, "tvColorTitle");
            tvColorTitle2.setVisibility(8);
        }
    }

    private final List<NeedItemsUi> toUi(List<NeedItems> list) {
        List<NeedItems> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NeedItems needItems : list2) {
            arrayList.add(new NeedItemsUi(needItems.getItem(), needItems.getAmount(), getItemFromInventory(needItems.getItem(), 0)));
        }
        return arrayList;
    }

    private final void startProgressBarAnimation(final long j) {
        Log.e("craft", "leftTime: " + j);
        TextView btnEnableCreateItem = this.binding.btnEnableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnEnableCreateItem, "btnEnableCreateItem");
        btnEnableCreateItem.setVisibility(8);
        Button btnDisableCreateItem = this.binding.btnDisableCreateItem;
        Intrinsics.checkNotNullExpressionValue(btnDisableCreateItem, "btnDisableCreateItem");
        btnDisableCreateItem.setVisibility(8);
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        Button btnCancelCraft = this.binding.btnCancelCraft;
        Intrinsics.checkNotNullExpressionValue(btnCancelCraft, "btnCancelCraft");
        btnCancelCraft.setVisibility(0);
        this.progress = 0;
        this.incrementHandler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$startProgressBarAnimation$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                CraftScreenBinding craftScreenBinding;
                int i2;
                int i3;
                int i4;
                Handler handler;
                i = CraftScreen.this.progress;
                if (i <= 100) {
                    craftScreenBinding = CraftScreen.this.binding;
                    ProgressBar progressBar2 = craftScreenBinding.progressBar;
                    i2 = CraftScreen.this.progress;
                    progressBar2.setProgress(i2);
                    CraftScreen craftScreen = CraftScreen.this;
                    i3 = craftScreen.progress;
                    i4 = CraftScreen.this.progressIncrement;
                    craftScreen.progress = i3 + i4;
                    handler = CraftScreen.this.incrementHandler;
                    handler.postDelayed(this, j / 100);
                }
            }
        }, 0L);
    }

    private final void isEnableButtons(boolean z) {
        this.binding.ivPlus.setEnabled(z);
        this.binding.ivMinus.setEnabled(z);
        this.binding.cvColor.setEnabled(z);
    }

    private final int getItemFromInventory(int i, int i2) {
        List<InventoryItem> list = this.inventoryList;
        if (list != null) {
            int i3 = 0;
            for (InventoryItem inventoryItem : list) {
                Integer item = inventoryItem.getItem();
                if (item != null && item.intValue() == i) {
                    Integer amount = inventoryItem.getAmount();
                    i3 += amount != null ? amount.intValue() : 0;
                }
            }
            return i3;
        }
        return 0;
    }

    private final void initCraftItems(int i) {
        ArrayList arrayList;
        List<CategoryItem> categories;
        CategoryItem categoryItem;
        List<Integer> items;
        this.craftItemsAdapter = new CraftItemsAdapter(new Function2() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit initCraftItems$lambda$37;
                initCraftItems$lambda$37 = CraftScreen.initCraftItems$lambda$37(CraftScreen.this, (CraftItem) obj, ((Integer) obj2).intValue());
                return initCraftItems$lambda$37;
            }
        }, getTargetActivity());
        RecyclerView recyclerView = this.binding.rvCraft;
        CraftItemsAdapter craftItemsAdapter = this.craftItemsAdapter;
        CraftItemsAdapter craftItemsAdapter2 = null;
        if (craftItemsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
            craftItemsAdapter = null;
        }
        recyclerView.setAdapter(craftItemsAdapter);
        CraftResponse craftResponse = this.craftResponse;
        if (craftResponse == null || (categories = craftResponse.getCategories()) == null || (categoryItem = categories.get(i)) == null || (items = categoryItem.getItems()) == null) {
            arrayList = new ArrayList();
        } else {
            List<Integer> list = items;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Number number : list) {
                int intValue = number.intValue();
                ItemsInfo itemsInfo = (ItemsInfo) CollectionsKt.getOrNull(UtilsKt.getItemsName(), intValue);
                String name = itemsInfo != null ? itemsInfo.getName() : null;
                if (name == null) {
                    name = "";
                }
                arrayList2.add(new CraftItem(intValue, name));
            }
            arrayList = arrayList2;
        }
        this.pagingCraftList = arrayList;
        CraftItemsAdapter craftItemsAdapter3 = this.craftItemsAdapter;
        if (craftItemsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
            craftItemsAdapter3 = null;
        }
        craftItemsAdapter3.submitList(this.pagingCraftList);
        CraftItemsAdapter craftItemsAdapter4 = this.craftItemsAdapter;
        if (craftItemsAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
            craftItemsAdapter4 = null;
        }
        craftItemsAdapter4.notifyDataSetChanged();
        CraftItemsAdapter craftItemsAdapter5 = this.craftItemsAdapter;
        if (craftItemsAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
        } else {
            craftItemsAdapter2 = craftItemsAdapter5;
        }
        if (craftItemsAdapter2.getItemCount() > 0) {
            this.binding.rvCraft.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.craft.presentation.CraftScreen$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    CraftScreen.initCraftItems$lambda$39(CraftScreen.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initCraftItems$lambda$37(CraftScreen craftScreen, CraftItem item, int i) {
        CraftItemsAdapter craftItemsAdapter;
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        if (!craftScreen.isCraftProcess) {
            Iterator<T> it = UtilsKt.getItemsName().iterator();
            while (true) {
                craftItemsAdapter = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ItemsInfo) obj).getId() == item.getItem()) {
                    break;
                }
            }
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
            craftScreen.binding.tvItemDescription.setText(valueOf != null ? UtilsKt.getItemsDescription(craftScreen.getTargetActivity()).get(valueOf.intValue()) : null);
            craftScreen.currentItemIndex = i;
            if (craftScreen.isDisableAll) {
                return Unit.INSTANCE;
            }
            CraftItemsAdapter craftItemsAdapter2 = craftScreen.craftItemsAdapter;
            if (craftItemsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
                craftItemsAdapter2 = null;
            }
            int selectedItemPosition = craftItemsAdapter2.getSelectedItemPosition();
            CraftItemsAdapter craftItemsAdapter3 = craftScreen.craftItemsAdapter;
            if (craftItemsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
                craftItemsAdapter3 = null;
            }
            craftItemsAdapter3.setSelectedItemPosition(i);
            craftScreen.craftItemsSelectedPosition = i;
            CraftItemsAdapter craftItemsAdapter4 = craftScreen.craftItemsAdapter;
            if (craftItemsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
                craftItemsAdapter4 = null;
            }
            craftItemsAdapter4.notifyItemChanged(selectedItemPosition);
            CraftItemsAdapter craftItemsAdapter5 = craftScreen.craftItemsAdapter;
            if (craftItemsAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("craftItemsAdapter");
            } else {
                craftItemsAdapter = craftItemsAdapter5;
            }
            craftItemsAdapter.notifyItemChanged(i);
            craftScreen.currentItem = item.getItem();
            craftScreen.binding.etResourcesCount.setText(String.valueOf(craftScreen.currentNumber));
            craftScreen.clearColor();
            craftScreen.sendRequest(1, StringKt.toStringJson(new SendCategory(craftScreen.craftMenuSelectedId, i)));
            craftScreen.editCraftItemUi(item);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCraftItems$lambda$39(CraftScreen craftScreen) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = craftScreen.binding.rvCraft.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    private final void clearColor() {
        if (this.colorsTypeAdapter.getCurrentList().isEmpty()) {
            return;
        }
        this.selectedColor = this.colorsTypeAdapter.getCurrentList().get(0).getColor();
        this.selectedColorPosition = 0;
        this.binding.cvColorIcon.setCardBackgroundColor(UtilsKt.getColorTint(this.selectedColor));
        this.binding.tvColorName.setText("Без цвета");
        sendRequest(5, StringKt.toStringJson(new SendColorInfo(this.craftItemsSelectedPosition, this.selectedColorPosition, this.craftMenuSelectedId)));
    }

    private final void refreshData(CraftItemInfo craftItemInfo) {
        List<NeedItems> needs = craftItemInfo.getNeeds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(needs, 10));
        for (NeedItems needItems : needs) {
            arrayList.add(new NeedItemsUi(needItems.getItem(), needItems.getAmount(), getItemFromInventory(needItems.getItem(), needItems.getAmount())));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        boolean z = true;
        if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NeedItemsUi needItemsUi = (NeedItemsUi) it.next();
                if (needItemsUi.getAmountHave() < needItemsUi.getAmountNeed()) {
                    z = false;
                    break;
                }
            }
        }
        isEnabledCraftItem(z);
        defaultScreen();
        this.needResourcesAdapter.submitList(arrayList2);
        this.needResourcesAdapter.notifyDataSetChanged();
    }

    private final int getTuningItem(int i) {
        return this.tuningItems.get(i).intValue() != 0 ? this.tuningItems.get(i).intValue() : i;
    }

    private final void sendRequest(int i, String str) {
        Log.d("TAG_SEND", "data: " + str + " ====== subId: " + i);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.CRAFT.getId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.parentLayout.setVisibility(z ? 0 : 8);
    }

    private final void closeScreen() {
        defaultScreen();
        ConstraintLayout craftContainer = this.binding.craftContainer;
        Intrinsics.checkNotNullExpressionValue(craftContainer, "craftContainer");
        craftContainer.setVisibility(4);
        ProgressBar containerProgress = this.binding.containerProgress;
        Intrinsics.checkNotNullExpressionValue(containerProgress, "containerProgress");
        containerProgress.setVisibility(0);
        this.craftResponse = null;
        this.categoryMenu = new ArrayList();
        this.colorsList = new ArrayList();
        this.selectedColor = 0;
        this.isDisableAll = false;
        this.selectedColorPosition = -1;
        this.currentNumber = 1;
        this.currentCraftedItem = null;
        this.currentItem = 0;
        this.progress = 0;
        this.isEnabledCraft = false;
        this.currentPage = 1;
        this.isCraftProcess = false;
        this.pagingCraftList = CollectionsKt.emptyList();
        this.frontendNotifier.setUIElementVisible(UIElementID.CRAFT.getId(), false);
    }

    /* compiled from: CraftScreen.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/CraftScreen$Companion;", "", "<init>", "()V", CraftScreen.CRAFT_SCREEN_TAG, "", "MAX_CRAFT_COUNT_RODINA", "", "MAX_CRAFT_COUNT_ARIZONA", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CraftScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/CraftScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CraftScreen(targetActivity, i);
        }
    }
}

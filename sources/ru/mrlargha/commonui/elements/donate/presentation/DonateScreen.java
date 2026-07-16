package ru.mrlargha.commonui.elements.donate.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.DonateMainPageBinding;
import ru.mrlargha.commonui.databinding.DonateOrdinaryPageBinding;
import ru.mrlargha.commonui.databinding.DonatePurchasePageBinding;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.databinding.DonateTopBarBinding;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateScreenModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.GridTemplateType;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePurchasePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.elements.donate.utils.ImageFader;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0003STUB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020&H\u0016J\u0018\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u0006H\u0016J\u0010\u00109\u001a\u0002042\u0006\u00107\u001a\u00020\u001fH\u0002J\u0017\u0010:\u001a\u0002042\b\u0010;\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u000204H\u0002J\u0017\u0010>\u001a\u0004\u0018\u0001042\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u000204H\u0002J\u0010\u0010F\u001a\u0002042\u0006\u0010?\u001a\u00020)H\u0002J\u0010\u0010G\u001a\u0002042\u0006\u0010?\u001a\u00020,H\u0002J\u0018\u0010H\u001a\u0002042\u0006\u0010?\u001a\u00020,2\u0006\u0010I\u001a\u00020&H\u0002J\u0010\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0010\u0010L\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0010\u0010M\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0014\u0010N\u001a\u0002042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010OH\u0002J\u0010\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020\u0014H\u0002J\b\u0010R\u001a\u000204H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\u001c0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0012\u0010/\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u00100\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DonateScreenBinding;", "fader", "Lru/mrlargha/commonui/elements/donate/utils/ImageFader;", "getFader", "()Lru/mrlargha/commonui/elements/donate/utils/ImageFader;", "pages", "", "Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "currentPage", "categoryAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sharedPref", "Landroid/content/SharedPreferences;", "serverId", "_token", "", "token", "getToken", "()Ljava/lang/String;", "states", "Lru/mrlargha/commonui/elements/donate/presentation/DonateStates;", "isHasUpdate", "", "isChangeCategory", "dialogModel", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "categories", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "selectedCategoryId", "Ljava/lang/Integer;", "pendingOpenCategoryId", "hasInitializedCategory", "x", "", "setVisibility", "", "visible", "onBackendMessageHandled", "data", "subId", "openBackendDialog", "openCategory", "id", "(Ljava/lang/Integer;)V", "checkArizonaType", "initDopInfo", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;)Lkotlin/Unit;", "initAdapters", "setupCollectors", "Lkotlinx/coroutines/Job;", "setupListeners", "sendDialogData", "onCategoryClick", "selectCategory", "notifyBackend", "openPurchaseCategory", "categoryId", "isCurrentPurchaseCategory", "isTopBarPurchaseCategory", "openReverseDialog", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "setPage", "page", "itemReadyToShow", "Pages", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateScreen extends SAMPUIElement implements DonateOnItemCompleteListeners {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int DONATE_AZ_COINS_CATEGORY_ID = 10;
    @Deprecated
    public static final int DONATE_RUB_CATEGORY_ID = 11;
    private final String _token;
    private final DonateScreenBinding binding;
    private List<DonateCategoryModelUi> categories;
    private final DonateCategoryAdapter categoryAdapter;
    private Pages currentPage;
    private DonateBoostModelUi dialogModel;
    private final ImageFader fader;
    private boolean hasInitializedCategory;
    private boolean isChangeCategory;
    private boolean isHasUpdate;
    private final Map<Pages, DonatePage> pages;
    private Integer pendingOpenCategoryId;
    private final CoroutineScope scope;
    private final View screen;
    private Integer selectedCategoryId;
    private final int serverId;
    private final SharedPreferences sharedPref;
    private DonateStates states;
    private long x;

    /* compiled from: DonateScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GridTemplateType.values().length];
            try {
                iArr[GridTemplateType.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GridTemplateType.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GridTemplateType.ROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean isTopBarPurchaseCategory(int i) {
        return i == 10 || i == 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.donate_screen, (ViewGroup) null);
        this.screen = screen;
        DonateScreenBinding bind = DonateScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        ImageView btnAddAzCoins = bind.topBar.btnAddAzCoins;
        Intrinsics.checkNotNullExpressionValue(btnAddAzCoins, "btnAddAzCoins");
        this.fader = new ImageFader(btnAddAzCoins, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.donate_add_az_coins_button), Integer.valueOf(R.drawable.donate_add_az_coins_button_spin)}), 500L, 1500L);
        Pages pages = Pages.MAIN;
        DonateScreen donateScreen = this;
        DonateMainPageBinding mainPage = bind.mainPage;
        Intrinsics.checkNotNullExpressionValue(mainPage, "mainPage");
        Pages pages2 = Pages.ORDINARY;
        DonateOrdinaryPageBinding ordinaryPage = bind.ordinaryPage;
        Intrinsics.checkNotNullExpressionValue(ordinaryPage, "ordinaryPage");
        Pages pages3 = Pages.PURCHASE;
        DonatePurchasePageBinding purchasePage = bind.purchasePage;
        Intrinsics.checkNotNullExpressionValue(purchasePage, "purchasePage");
        Pages pages4 = Pages.DIALOG;
        DonateReplenishmentDialogBinding replenishmentDialogPage = bind.replenishmentDialogPage;
        Intrinsics.checkNotNullExpressionValue(replenishmentDialogPage, "replenishmentDialogPage");
        this.pages = MapsKt.mapOf(TuplesKt.to(pages, new DonateMainPage(i, targetActivity, donateScreen, mainPage, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DonateScreen.pages$lambda$0(DonateScreen.this, (DonateItemModelUi) obj);
            }
        })), TuplesKt.to(pages2, new DonateOrdinaryPage(i, targetActivity, donateScreen, ordinaryPage, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DonateScreen.pages$lambda$1(DonateScreen.this, (DonateItemModelUi) obj);
            }
        })), TuplesKt.to(pages3, new DonatePurchasePage(i, targetActivity, donateScreen, purchasePage, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DonateScreen.pages$lambda$2(DonateScreen.this, (DonateBoostModelUi) obj);
            }
        })), TuplesKt.to(pages4, new DonateReplenishmentDialogPage(i, targetActivity, donateScreen, replenishmentDialogPage, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DonateScreen.pages$lambda$3(DonateScreen.this);
            }
        })));
        this.currentPage = Pages.NONE;
        this.categoryAdapter = new DonateCategoryAdapter(new DonateScreen$categoryAdapter$1(this));
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.serverId = sharedPreferences.getInt("server_id", 0);
        this._token = sharedPreferences.getString("api_token", "");
        this.categories = CollectionsKt.emptyList();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        checkArizonaType();
    }

    public final ImageFader getFader() {
        return this.fader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pages$lambda$0(DonateScreen donateScreen, DonateItemModelUi donateItemModelUi) {
        donateScreen.openReverseDialog(donateItemModelUi);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pages$lambda$1(DonateScreen donateScreen, DonateItemModelUi donateItemModelUi) {
        donateScreen.openReverseDialog(donateItemModelUi);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pages$lambda$2(DonateScreen donateScreen, DonateBoostModelUi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        donateScreen.setPage(Pages.DIALOG);
        donateScreen.sendDialogData(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit pages$lambda$3(DonateScreen donateScreen) {
        donateScreen.setPage(donateScreen.currentPage);
        return Unit.INSTANCE;
    }

    private final String getToken() {
        return String.valueOf(this._token);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            this.states = new DonateStates(getTargetActivity(), getBackendID());
            this.isHasUpdate = false;
            this.categories = CollectionsKt.emptyList();
            this.selectedCategoryId = null;
            this.pendingOpenCategoryId = null;
            this.hasInitializedCategory = false;
            this.categoryAdapter.refreshSelectItem();
            initAdapters();
            setupCollectors();
            setupListeners();
        } else {
            DonateStates donateStates = this.states;
            if (donateStates != null) {
                donateStates.clearJobs();
            }
            this.states = null;
        }
        this.fader.stop();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        DonateStates donateStates;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.UPDATE_CATEGORY_LIST.getSubIds()) {
            DonateStates donateStates2 = this.states;
            if (donateStates2 != null) {
                donateStates2.updateCategories((DonateCategoryModel) MapperKt.toModel(data, DonateCategoryModel.class));
            }
        } else if (i == DonateSubIds.UPDATE_ITEM_LIST.getSubIds()) {
            if (data.length() <= 0 || (donateStates = this.states) == null) {
                return;
            }
            donateStates.updateItems((DonateItemModel) MapperKt.toModel(data, DonateItemModel.class), this.isHasUpdate);
        } else if (i == DonateSubIds.GET_DOP_INFO.getSubIds()) {
            initDopInfo((DonateScreenModel) MapperKt.toModel(data, DonateScreenModel.class));
        } else if (i == DonateSubIds.OPEN_CATEGORY.getSubIds()) {
            String str = data;
            openCategory(StringsKt.toIntOrNull(StringsKt.trim((CharSequence) str).toString()));
            Log.d(DonateUtilsKt.DONATE_TAG, "data: open category: " + data);
            Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) str).toString());
            if (intOrNull != null) {
                getNotifier().clickedWrapper(getBackendID(), intOrNull.intValue(), 4);
            }
        } else if (i == DonateSubIds.DIALOG_INIT.getSubIds()) {
            openBackendDialog(data);
        }
    }

    private final void openBackendDialog(String str) {
        setPage(Pages.DIALOG);
        DonatePage donatePage = this.pages.get(Pages.DIALOG);
        if (donatePage != null) {
            donatePage.onBackendMessage(DonateSubIds.DIALOG_INIT.getSubIds(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCategory(Integer num) {
        Object obj;
        Integer num2;
        if (num != null) {
            int intValue = num.intValue();
            if (this.hasInitializedCategory && (num2 = this.selectedCategoryId) != null && num2.intValue() == intValue) {
                this.pendingOpenCategoryId = null;
                return;
            }
            Iterator<T> it = this.categories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((DonateCategoryModelUi) obj).getId() == intValue) {
                    break;
                }
            }
            DonateCategoryModelUi donateCategoryModelUi = (DonateCategoryModelUi) obj;
            if (donateCategoryModelUi == null) {
                if (UtilsKt.isArizonaType() && isTopBarPurchaseCategory(intValue)) {
                    openPurchaseCategory(intValue);
                    return;
                } else {
                    this.pendingOpenCategoryId = Integer.valueOf(intValue);
                    return;
                }
            }
            this.pendingOpenCategoryId = null;
            this.hasInitializedCategory = true;
            this.categoryAdapter.selectItemById(intValue);
            this.binding.rvCategories.scrollToPosition(this.categories.indexOf(donateCategoryModelUi));
            selectCategory(donateCategoryModelUi, true);
        }
    }

    private final void checkArizonaType() {
        DonateTopBarBinding donateTopBarBinding = this.binding.topBar;
        if (UtilsKt.isArizonaType()) {
            donateTopBarBinding.ivMoneyIc.setImageResource(R.drawable.donate_ic_rub);
        } else {
            donateTopBarBinding.ivMoneyIc.setImageResource(R.drawable.blueprint_ic_rub);
        }
    }

    private final Unit initDopInfo(DonateScreenModel donateScreenModel) {
        DonateScreenBinding donateScreenBinding = this.binding;
        this.x = donateScreenModel.getGetBoostPayment();
        LinearLayout btnEvent = donateScreenBinding.topBar.btnEvent;
        Intrinsics.checkNotNullExpressionValue(btnEvent, "btnEvent");
        btnEvent.setVisibility(donateScreenModel.isShowButtonEventStatus() ? 0 : 8);
        donateScreenBinding.topBar.tvEvent.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, donateScreenModel.getButtonEventName(), 0.0f, null, 3, null));
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "assets/images/donate_icons/mobile/event.webp").into(donateScreenBinding.topBar.ivEvent);
        donateScreenBinding.topBar.tvMoneyCount.setText(String.valueOf(donateScreenModel.getCountMoney()));
        donateScreenBinding.topBar.tvAzCoin.setText(DonateUtilsKt.formatWithSpaces(donateScreenModel.getCountAzCoins()));
        CardView boostContainer = donateScreenBinding.topBar.boostContainer;
        Intrinsics.checkNotNullExpressionValue(boostContainer, "boostContainer");
        boostContainer.setVisibility((donateScreenModel.getGetBoostPayment() > 4L ? 1 : (donateScreenModel.getGetBoostPayment() == 4L ? 0 : -1)) >= 0 ? 0 : 8);
        donateScreenBinding.topBar.tvBoostPayment.setText("x" + donateScreenModel.getGetBoostPayment());
        Integer freeSpinAvailable = donateScreenModel.getFreeSpinAvailable();
        if (freeSpinAvailable != null) {
            int intValue = freeSpinAvailable.intValue();
            ImageFader imageFader = this.fader;
            if (intValue == 1) {
                imageFader.start();
            } else {
                imageFader.stop();
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void initAdapters() {
        DonateScreenBinding donateScreenBinding = this.binding;
        setPage(Pages.MAIN);
        donateScreenBinding.rvCategories.setAdapter(this.categoryAdapter);
        donateScreenBinding.rvCategories.setVerticalScrollBarEnabled(true);
    }

    private final Job setupCollectors() {
        Job launch$default;
        DonateScreenBinding donateScreenBinding = this.binding;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$setupCollectors$1$1(this, donateScreenBinding, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$setupCollectors$1$2(this, donateScreenBinding, null), 3, null);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$setupCollectors$1$3(this, null), 3, null);
        return launch$default;
    }

    private final void setupListeners() {
        final DonateScreenBinding donateScreenBinding = this.binding;
        donateScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$0$0(view);
            }
        });
        donateScreenBinding.topBar.btnEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$0$1(DonateScreen.this, view);
            }
        });
        donateScreenBinding.topBar.btnAddMoney.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$0$2(DonateScreenBinding.this, this, view);
            }
        });
        donateScreenBinding.topBar.btnAddAzCoins.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$0$3(DonateScreenBinding.this, this, view);
            }
        });
        donateScreenBinding.topBar.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$0$4(DonateScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 0, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(DonateScreenBinding donateScreenBinding, DonateScreen donateScreen, View view) {
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        if (pagesContainer.getVisibility() == 0) {
            if (UtilsKt.isArizonaType()) {
                if (donateScreen.isCurrentPurchaseCategory(11)) {
                    return;
                }
                donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 0, 8);
                donateScreen.openPurchaseCategory(11);
                return;
            }
            donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 1, 2);
            donateScreen.openReverseDialog(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(DonateScreenBinding donateScreenBinding, DonateScreen donateScreen, View view) {
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        if (pagesContainer.getVisibility() == 0) {
            int size = UtilsKt.isArizonaType() ? 10 : donateScreen.categoryAdapter.getCurrentList().size();
            if (UtilsKt.isArizonaType() && donateScreen.isCurrentPurchaseCategory(size)) {
                return;
            }
            donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 2, 2);
            Log.d(donateScreen.getCLASS_TAG(), "setupListeners: " + size);
            donateScreen.categoryAdapter.rateCategory();
            donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), size, 4);
            donateScreen.openPurchaseCategory(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 3, 2);
        if (UtilsKt.isArizonaType()) {
            donateScreen.setVisibility(false);
            donateScreen.getNotifier().requestRemoveUIElement(donateScreen);
        }
    }

    private final void sendDialogData(DonateBoostModelUi donateBoostModelUi) {
        DonatePage donatePage;
        if (UtilsKt.isArizonaType()) {
            DonatePage donatePage2 = this.pages.get(Pages.DIALOG);
            if (donatePage2 != null) {
                donatePage2.onBackendMessage(DonateSubIds.DIALOG_INIT.getSubIds(), StringKt.toStringJson(donateBoostModelUi));
                return;
            }
            return;
        }
        DonateBoostModelUi donateBoostModelUi2 = this.dialogModel;
        if (donateBoostModelUi2 == null || (donatePage = this.pages.get(Pages.DIALOG)) == null) {
            return;
        }
        donatePage.onBackendMessage(DonateSubIds.DIALOG_INIT.getSubIds(), StringKt.toStringJson(DonateBoostModelUi.copy$default(donateBoostModelUi2, new DonateRateModel(1, this.x), 0L, null, true, this.x, 0L, null, null, 230, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCategoryClick(DonateCategoryModelUi donateCategoryModelUi) {
        this.hasInitializedCategory = true;
        selectCategory(donateCategoryModelUi, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectCategory(DonateCategoryModelUi donateCategoryModelUi, boolean z) {
        DonateScreenBinding donateScreenBinding = this.binding;
        this.selectedCategoryId = Integer.valueOf(donateCategoryModelUi.getId());
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        pagesContainer.setVisibility(4);
        ProgressBar pageProgressBar = donateScreenBinding.pageProgressBar;
        Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
        pageProgressBar.setVisibility(0);
        LinearLayout errorPlaceholderItems = donateScreenBinding.errorPlaceholderItems;
        Intrinsics.checkNotNullExpressionValue(errorPlaceholderItems, "errorPlaceholderItems");
        errorPlaceholderItems.setVisibility(8);
        this.isChangeCategory = true;
        getNotifier().clickedWrapper(getBackendID(), donateCategoryModelUi.getId(), 4);
        Log.d("TAG", "selectCategory: " + donateCategoryModelUi.getId());
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$selectCategory$1$1(this, donateCategoryModelUi, null), 3, null);
        int i = WhenMappings.$EnumSwitchMapping$0[donateCategoryModelUi.m11843getGridTemplateType().ordinal()];
        if (i == 1) {
            setPage(Pages.MAIN);
        } else if (i == 2) {
            setPage(Pages.ORDINARY);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            setPage(Pages.PURCHASE);
        }
    }

    private final void openPurchaseCategory(int i) {
        DonateScreenBinding donateScreenBinding = this.binding;
        if (isCurrentPurchaseCategory(i)) {
            this.pendingOpenCategoryId = null;
            return;
        }
        this.pendingOpenCategoryId = null;
        this.hasInitializedCategory = true;
        this.selectedCategoryId = Integer.valueOf(i);
        this.categoryAdapter.selectItemById(i);
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        pagesContainer.setVisibility(4);
        ProgressBar pageProgressBar = donateScreenBinding.pageProgressBar;
        Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
        pageProgressBar.setVisibility(0);
        LinearLayout errorPlaceholderItems = donateScreenBinding.errorPlaceholderItems;
        Intrinsics.checkNotNullExpressionValue(errorPlaceholderItems, "errorPlaceholderItems");
        errorPlaceholderItems.setVisibility(8);
        this.isChangeCategory = true;
        setPage(Pages.PURCHASE);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$openPurchaseCategory$1$1(this, i, null), 3, null);
    }

    private final boolean isCurrentPurchaseCategory(int i) {
        Integer num;
        if (this.hasInitializedCategory && this.currentPage == Pages.PURCHASE && (num = this.selectedCategoryId) != null && num.intValue() == i) {
            FrameLayout pagesContainer = this.binding.pagesContainer;
            Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
            return pagesContainer.getVisibility() == 0;
        }
        return false;
    }

    static /* synthetic */ void openReverseDialog$default(DonateScreen donateScreen, DonateItemModelUi donateItemModelUi, int i, Object obj) {
        if ((i & 1) != 0) {
            donateItemModelUi = null;
        }
        donateScreen.openReverseDialog(donateItemModelUi);
    }

    private final void openReverseDialog(DonateItemModelUi donateItemModelUi) {
        DonatePage donatePage;
        DonateRateModel donateRateModel;
        setPage(Pages.DIALOG);
        if (donateItemModelUi == null) {
            DonateBoostModelUi donateBoostModelUi = this.dialogModel;
            if (donateBoostModelUi == null || (donatePage = this.pages.get(Pages.DIALOG)) == null) {
                return;
            }
            int subIds = DonateSubIds.DIALOG_INIT.getSubIds();
            DonateBoostModelUi donateBoostModelUi2 = this.dialogModel;
            long boost = donateBoostModelUi2 != null ? donateBoostModelUi2.getBoost() : 0L;
            DonateItemType donateItemType = DonateItemType.RATE;
            DonateBoostModelUi donateBoostModelUi3 = this.dialogModel;
            if (donateBoostModelUi3 == null || (donateRateModel = donateBoostModelUi3.getRate()) == null) {
                donateRateModel = new DonateRateModel(1, 1L);
            }
            donatePage.onBackendMessage(subIds, StringKt.toStringJson(DonateBoostModelUi.copy$default(donateBoostModelUi, donateRateModel, 0L, null, false, boost, 0L, donateItemType, null, 166, null)));
            return;
        }
        DonatePage donatePage2 = this.pages.get(Pages.DIALOG);
        if (donatePage2 != null) {
            donatePage2.onBackendMessage(DonateSubIds.DIALOG_INIT.getSubIds(), StringKt.toStringJson(new DonateBoostModelUi(new DonateRateModel(1, donateItemModelUi.getTotalEarnings() >= 1 ? donateItemModelUi.getTotalEarnings() : 1L), 0L, CollectionsKt.emptyList(), false, 0L, 0L, donateItemModelUi.getItemType(), null, 128, null)));
        }
    }

    private final void setPage(Pages pages) {
        DonateScreenBinding donateScreenBinding = this.binding;
        Log.i(DonateUtilsKt.DONATE_TAG, "setPage: " + pages + " ");
        if (pages != Pages.DIALOG) {
            this.currentPage = pages;
            LinearLayout root = donateScreenBinding.mainPage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(Pages.MAIN != pages ? 8 : 0);
            RecyclerView root2 = donateScreenBinding.ordinaryPage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            root2.setVisibility(Pages.ORDINARY != pages ? 4 : 0);
            LinearLayout root3 = donateScreenBinding.purchasePage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            root3.setVisibility(Pages.PURCHASE != pages ? 8 : 0);
        }
        FrameLayout root4 = donateScreenBinding.replenishmentDialogPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(Pages.DIALOG != pages ? 8 : 0);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MAIN", "ORDINARY", "PURCHASE", "DIALOG", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Pages {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Pages[] $VALUES;
        public static final Pages NONE = new Pages("NONE", 0);
        public static final Pages MAIN = new Pages("MAIN", 1);
        public static final Pages ORDINARY = new Pages("ORDINARY", 2);
        public static final Pages PURCHASE = new Pages("PURCHASE", 3);
        public static final Pages DIALOG = new Pages("DIALOG", 4);

        private static final /* synthetic */ Pages[] $values() {
            return new Pages[]{NONE, MAIN, ORDINARY, PURCHASE, DIALOG};
        }

        public static EnumEntries<Pages> getEntries() {
            return $ENTRIES;
        }

        public static Pages valueOf(String str) {
            return (Pages) Enum.valueOf(Pages.class, str);
        }

        public static Pages[] values() {
            return (Pages[]) $VALUES.clone();
        }

        private Pages(String str, int i) {
        }

        static {
            Pages[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Companion;", "", "<init>", "()V", "DONATE_AZ_COINS_CATEGORY_ID", "", "DONATE_RUB_CATEGORY_ID", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_DONATE_SHOP);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DonateScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners
    public void itemReadyToShow() {
        DonateScreenBinding donateScreenBinding = this.binding;
        this.isChangeCategory = false;
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        pagesContainer.setVisibility(0);
        donateScreenBinding.pagesContainer.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                DonateScreen.itemReadyToShow$lambda$0$0(DonateScreen.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void itemReadyToShow$lambda$0$0(DonateScreen donateScreen) {
        ProgressBar pageProgressBar = donateScreen.binding.pageProgressBar;
        Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
        pageProgressBar.setVisibility(8);
    }
}

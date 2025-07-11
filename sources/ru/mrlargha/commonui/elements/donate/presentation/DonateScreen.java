package ru.mrlargha.commonui.elements.donate.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.DonateMainPageBinding;
import ru.mrlargha.commonui.databinding.DonateOrdinaryPageBinding;
import ru.mrlargha.commonui.databinding.DonatePurchasePageBinding;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateScreenModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.GridTemplateType;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePurchasePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002;<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0016J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020(H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u0010.\u001a\u00020%H\u0002J\u0010\u00105\u001a\u00020(2\u0006\u0010.\u001a\u000206H\u0002J\b\u00107\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u00020(H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DonateScreenBinding;", "pages", "", "Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "currentPage", "categoryAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sharedPref", "Landroid/content/SharedPreferences;", "serverId", "_token", "", "token", "getToken", "()Ljava/lang/String;", "states", "Lru/mrlargha/commonui/elements/donate/presentation/DonateStates;", "isHasUpdate", "", "isChangeCategory", "dialogModel", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "x", "setVisibility", "", "visible", "onBackendMessage", "data", "subId", "initDopInfo", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateScreenModel;", "initAdapters", "setupCollectors", "Lkotlinx/coroutines/Job;", "setupListeners", "sendDialogData", "onCategoryClick", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;", "openReverseDialog", "setPage", "page", "itemReadyToShow", "Pages", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateScreen extends SAMPUIElement implements DonateOnItemCompleteListeners {
    private final String _token;
    private final DonateScreenBinding binding;
    private final DonateCategoryAdapter categoryAdapter;
    private Pages currentPage;
    private DonateBoostModelUi dialogModel;
    private boolean isChangeCategory;
    private boolean isHasUpdate;
    private final Map<Pages, DonatePage> pages;
    private final CoroutineScope scope;
    private final View screen;
    private final int serverId;
    private final SharedPreferences sharedPref;
    private final DonateStates states;
    private int x;

    /* compiled from: DonateScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12$lambda$7(View view) {
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
        this.pages = MapsKt.mapOf(TuplesKt.to(pages, new DonateMainPage(i, targetActivity, donateScreen, mainPage, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pages$lambda$0;
                pages$lambda$0 = DonateScreen.pages$lambda$0(DonateScreen.this);
                return pages$lambda$0;
            }
        })), TuplesKt.to(pages2, new DonateOrdinaryPage(i, targetActivity, donateScreen, ordinaryPage, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pages$lambda$1;
                pages$lambda$1 = DonateScreen.pages$lambda$1(DonateScreen.this);
                return pages$lambda$1;
            }
        })), TuplesKt.to(pages3, new DonatePurchasePage(i, targetActivity, donateScreen, purchasePage, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit pages$lambda$2;
                pages$lambda$2 = DonateScreen.pages$lambda$2(DonateScreen.this, (DonateBoostModelUi) obj);
                return pages$lambda$2;
            }
        })), TuplesKt.to(pages4, new DonateReplenishmentDialogPage(i, targetActivity, donateScreen, replenishmentDialogPage, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pages$lambda$3;
                pages$lambda$3 = DonateScreen.pages$lambda$3(DonateScreen.this);
                return pages$lambda$3;
            }
        })));
        this.currentPage = Pages.MAIN;
        this.categoryAdapter = new DonateCategoryAdapter(new DonateScreen$categoryAdapter$1(this));
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        int i2 = sharedPreferences.getInt("server_id", 0);
        this.serverId = i2;
        this._token = sharedPreferences.getString("api_token", "");
        this.states = new DonateStates(getToken(), i2);
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pages$lambda$0(DonateScreen donateScreen) {
        donateScreen.openReverseDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pages$lambda$1(DonateScreen donateScreen) {
        donateScreen.openReverseDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pages$lambda$2(DonateScreen donateScreen, DonateBoostModelUi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        donateScreen.setPage(Pages.DIALOG);
        donateScreen.sendDialogData(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            this.isHasUpdate = false;
            initAdapters();
            setupCollectors();
            setupListeners();
            return;
        }
        this.states.clearJobs();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.UPDATE_CATEGORY_LIST.getSubIds()) {
            this.states.updateCategories((DonateCategoryModel) MapperKt.toModel(data, DonateCategoryModel.class));
        } else if (i == DonateSubIds.UPDATE_ITEM_LIST.getSubIds()) {
            if (data.length() > 0) {
                this.states.updateItems((DonateItemModel) MapperKt.toModel(data, DonateItemModel.class), this.isHasUpdate);
            }
        } else if (i == DonateSubIds.GET_DOP_INFO.getSubIds()) {
            initDopInfo((DonateScreenModel) MapperKt.toModel(data, DonateScreenModel.class));
        }
    }

    private final void initDopInfo(DonateScreenModel donateScreenModel) {
        DonateScreenBinding donateScreenBinding = this.binding;
        this.x = donateScreenModel.getGetBoostPayment();
        LinearLayout btnEvent = donateScreenBinding.topBar.btnEvent;
        Intrinsics.checkNotNullExpressionValue(btnEvent, "btnEvent");
        btnEvent.setVisibility(donateScreenModel.isShowButtonEventStatus() ? 0 : 8);
        donateScreenBinding.topBar.tvEvent.setText(donateScreenModel.getButtonEventName());
        Picasso.get().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_icons/mobile/event.webp").into(donateScreenBinding.topBar.ivEvent);
        donateScreenBinding.topBar.tvMoneyCount.setText(DonateUtilsKt.formatWithSpaces(donateScreenModel.getCountMoney()));
        donateScreenBinding.topBar.tvAzCoin.setText(DonateUtilsKt.formatWithSpaces(donateScreenModel.getCountAzCoins()));
        CardView boostContainer = donateScreenBinding.topBar.boostContainer;
        Intrinsics.checkNotNullExpressionValue(boostContainer, "boostContainer");
        boostContainer.setVisibility(donateScreenModel.getGetBoostPayment() >= 4 ? 0 : 8);
        donateScreenBinding.topBar.tvBoostPayment.setText("x" + donateScreenModel.getGetBoostPayment());
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
        DonateScreenBinding donateScreenBinding = this.binding;
        donateScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$12$lambda$7(view);
            }
        });
        donateScreenBinding.topBar.btnEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$12$lambda$8(DonateScreen.this, view);
            }
        });
        donateScreenBinding.topBar.btnAddMoney.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$12$lambda$9(DonateScreen.this, view);
            }
        });
        donateScreenBinding.topBar.btnAddAzCoins.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$12$lambda$10(DonateScreen.this, view);
            }
        });
        donateScreenBinding.topBar.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateScreen.setupListeners$lambda$12$lambda$11(DonateScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12$lambda$8(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 0, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12$lambda$9(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 1, 2);
        donateScreen.openReverseDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12$lambda$10(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 2, 2);
        donateScreen.setPage(Pages.PURCHASE);
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 10, 4);
        donateScreen.states.setItems(10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12$lambda$11(DonateScreen donateScreen, View view) {
        donateScreen.getNotifier().clickedWrapper(donateScreen.getBackendID(), 3, 2);
        donateScreen.setVisibility(false);
        donateScreen.getNotifier().requestRemoveUIElement(donateScreen);
    }

    private final void sendDialogData(DonateBoostModelUi donateBoostModelUi) {
        DonatePage donatePage;
        DonateBoostModelUi donateBoostModelUi2 = this.dialogModel;
        if (donateBoostModelUi2 == null || (donatePage = this.pages.get(Pages.DIALOG)) == null) {
            return;
        }
        donatePage.onBackendMessage(DonateSubIds.DIALOG_INIT.getSubIds(), StringKt.toStringJson(DonateBoostModelUi.copy$default(donateBoostModelUi2, new DonateRateModel(1, this.x), 0L, null, true, this.x, 0, 38, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCategoryClick(DonateCategoryModelUi donateCategoryModelUi) {
        DonateScreenBinding donateScreenBinding = this.binding;
        FrameLayout pagesContainer = donateScreenBinding.pagesContainer;
        Intrinsics.checkNotNullExpressionValue(pagesContainer, "pagesContainer");
        pagesContainer.setVisibility(4);
        ProgressBar pageProgressBar = donateScreenBinding.pageProgressBar;
        Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
        pageProgressBar.setVisibility(0);
        this.isChangeCategory = true;
        getNotifier().clickedWrapper(getBackendID(), donateCategoryModelUi.getId(), 4);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateScreen$onCategoryClick$1$1(this, donateCategoryModelUi, null), 3, null);
        int i = WhenMappings.$EnumSwitchMapping$0[donateCategoryModelUi.m10602getGridTemplateType().ordinal()];
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

    private final void openReverseDialog() {
        DonateRateModel donateRateModel;
        DonateBoostModelUi donateBoostModelUi = this.dialogModel;
        if (donateBoostModelUi != null) {
            setPage(Pages.DIALOG);
            DonatePage donatePage = this.pages.get(Pages.DIALOG);
            if (donatePage != null) {
                int subIds = DonateSubIds.DIALOG_INIT.getSubIds();
                DonateBoostModelUi donateBoostModelUi2 = this.dialogModel;
                int boost = donateBoostModelUi2 != null ? donateBoostModelUi2.getBoost() : 0;
                DonateBoostModelUi donateBoostModelUi3 = this.dialogModel;
                if (donateBoostModelUi3 == null || (donateRateModel = donateBoostModelUi3.getRate()) == null) {
                    donateRateModel = new DonateRateModel(1, 1);
                }
                donatePage.onBackendMessage(subIds, StringKt.toStringJson(DonateBoostModelUi.copy$default(donateBoostModelUi, donateRateModel, 0L, null, false, boost, 0, 38, null)));
            }
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MAIN", "ORDINARY", "PURCHASE", "DIALOG", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DonateScreen(targetActivity, i);
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
                DonateScreen.itemReadyToShow$lambda$18$lambda$17(DonateScreen.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void itemReadyToShow$lambda$18$lambda$17(DonateScreen donateScreen) {
        ProgressBar pageProgressBar = donateScreen.binding.pageProgressBar;
        Intrinsics.checkNotNullExpressionValue(pageProgressBar, "pageProgressBar");
        pageProgressBar.setVisibility(8);
    }
}

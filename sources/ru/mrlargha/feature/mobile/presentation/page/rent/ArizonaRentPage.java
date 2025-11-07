package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentFilterBinding;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentPageBinding;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.feature.mobile.presentation.HistoryManager;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.MobilePage;
import ru.mrlargha.feature.mobile.presentation.MobilePhoneGetSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdClickEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdIds;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterContainerModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterModel;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentRealEstateModel;
/* compiled from: ArizonaRentPage.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020\"2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u00010\u0018H\u0002J \u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u000f2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020;2\u0006\u00105\u001a\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u001cH\u0016J\b\u0010=\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentPage;", "Lru/mrlargha/feature/mobile/presentation/MobilePage;", "<init>", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "binding", "Lru/mrlargha/feature/mobile/databinding/MpArizonaRentPageBinding;", "adAdapter", "Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter;", "currentToolbar", "Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentToolbarType;", "isOpenFilter", "", "retrofitClient", "Lru/mrlargha/feature/mobile/data/remote/MobileRetrofitClient;", "adList", "", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "adState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/commonui/elements/donate/presentation/UiState;", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterContainerModel;", "isHasHoses", "isUpdate", "sendEvent", "", "subId", "Lru/mrlargha/feature/mobile/presentation/MobilePhoneGetSubIds;", "data", "", "setAdList", "", "notAd", "notMyAd", "filterNotFound", "isNotFound", "setupListeners", "setDefaultScreen", "initialize", "selectToolbarAll", "selectToolbarMy", "closeFilter", "openFilter", "setUpCollectors", "Lkotlinx/coroutines/Job;", "getAds", "checkUpdate", "hasUpdate", "update", "setFilterData", CommonUrlParts.MODEL, "setList", "isHasFilter", "filterAdList", "onAdClick", NotificationCompat.CATEGORY_EVENT, "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdClickEvent;", "hidePage", "renderPage", "Companion", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentPage extends MobilePage {
    public static final Companion Companion = new Companion(null);
    public static final long FIVE_SECONDS = 5000;
    private final ArizonaRentAdAdapter adAdapter;
    private List<ArizonaRentAdModel> adList;
    private final MutableStateFlow<UiState<ArizonaRentFilterContainerModel>> adState;
    private final MpArizonaRentPageBinding binding;
    private ArizonaRentToolbarType currentToolbar;
    private boolean isHasHoses;
    private boolean isOpenFilter;
    private boolean isUpdate;
    private final MobileRetrofitClient retrofitClient;
    private final View view;

    /* compiled from: ArizonaRentPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MobilePhoneGetSubIds.values().length];
            try {
                iArr[MobilePhoneGetSubIds.RENT_REAL_ESTATE_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArizonaRentAdClickEvent.values().length];
            try {
                iArr2[ArizonaRentAdClickEvent.RENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ArizonaRentAdClickEvent.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ArizonaRentAdClickEvent.RAISE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ArizonaRentPage() {
        super(MobilePhonePage.ARIZONA_RENT.getId());
        this.adAdapter = new ArizonaRentAdAdapter(new ArizonaRentPage$adAdapter$1(this));
        this.currentToolbar = ArizonaRentToolbarType.ALL;
        this.retrofitClient = new MobileRetrofitClient(getContext(), UIElementID.ARIZONA_MOBILE_PHONE.getId());
        this.adState = StateFlowKt.MutableStateFlow(UiState.Loading.INSTANCE);
        this.isHasHoses = true;
        HistoryManager.Companion.push(MobilePhonePage.ARIZONA_RENT.getId());
        View inflate = getContext().getLayoutInflater().inflate(R.layout.mp_arizona_rent_page, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.view = inflate;
        MpArizonaRentPageBinding bind = MpArizonaRentPageBinding.bind(getView());
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        bind.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        setupListeners();
        setUpCollectors();
        getAds();
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public View getView() {
        return this.view;
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void sendEvent(MobilePhoneGetSubIds subId, String data) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(data, "data");
        int i = WhenMappings.$EnumSwitchMapping$0[subId.ordinal()];
        if (i == 1) {
            Log.d("arizona_rent", "sendEvent: " + data);
            this.isHasHoses = !MapperKt.toListModel(data, ArizonaRentRealEstateModel.class).isEmpty();
        } else if (i != 2) {
        } else {
            this.isUpdate = true;
            getAds();
            int parseInt = Integer.parseInt(data);
            if (parseInt == 1) {
                this.binding.rvAd.smoothScrollToPosition(0);
            } else if (parseInt != 2) {
            } else {
                selectToolbarMy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setAdList(List<ArizonaRentAdModel> list) {
        Job launch$default;
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        if (this.currentToolbar == ArizonaRentToolbarType.ALL && list.isEmpty()) {
            notAd();
            return Unit.INSTANCE;
        } else if (this.currentToolbar == ArizonaRentToolbarType.MY && list.isEmpty()) {
            notMyAd();
            return Unit.INSTANCE;
        } else {
            RecyclerView rvAd = mpArizonaRentPageBinding.rvAd;
            Intrinsics.checkNotNullExpressionValue(rvAd, "rvAd");
            rvAd.setVisibility(0);
            FrameLayout nothingNotContainer = mpArizonaRentPageBinding.nothingNotContainer;
            Intrinsics.checkNotNullExpressionValue(nothingNotContainer, "nothingNotContainer");
            nothingNotContainer.setVisibility(8);
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getIO(), null, new ArizonaRentPage$setAdList$1$1(this, new ArizonaRentFilterContainerModel(null, list), null), 2, null);
            return launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notAd() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        LinearLayout adContainer = mpArizonaRentPageBinding.adContainer;
        Intrinsics.checkNotNullExpressionValue(adContainer, "adContainer");
        adContainer.setVisibility(8);
        FrameLayout nothingNotContainer = mpArizonaRentPageBinding.nothingNotContainer;
        Intrinsics.checkNotNullExpressionValue(nothingNotContainer, "nothingNotContainer");
        nothingNotContainer.setVisibility(0);
        CustomCardView btnCreateAd = mpArizonaRentPageBinding.btnCreateAd;
        Intrinsics.checkNotNullExpressionValue(btnCreateAd, "btnCreateAd");
        btnCreateAd.setVisibility(0);
        ProgressBar progressBar = mpArizonaRentPageBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        mpArizonaRentPageBinding.tvNotContentDesc.setText(mpArizonaRentPageBinding.getRoot().getContext().getString(R.string.not_ads_desc));
    }

    private final void notMyAd() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        LinearLayout adContainer = mpArizonaRentPageBinding.adContainer;
        Intrinsics.checkNotNullExpressionValue(adContainer, "adContainer");
        adContainer.setVisibility(0);
        RecyclerView rvAd = mpArizonaRentPageBinding.rvAd;
        Intrinsics.checkNotNullExpressionValue(rvAd, "rvAd");
        rvAd.setVisibility(8);
        FrameLayout nothingNotContainer = mpArizonaRentPageBinding.nothingNotContainer;
        Intrinsics.checkNotNullExpressionValue(nothingNotContainer, "nothingNotContainer");
        nothingNotContainer.setVisibility(0);
        CustomCardView btnCreateAd = mpArizonaRentPageBinding.btnCreateAd;
        Intrinsics.checkNotNullExpressionValue(btnCreateAd, "btnCreateAd");
        btnCreateAd.setVisibility(0);
        ProgressBar progressBar = mpArizonaRentPageBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        mpArizonaRentPageBinding.tvNotContentDesc.setText(mpArizonaRentPageBinding.getRoot().getContext().getString(R.string.not_my_ads_desc));
    }

    private final void filterNotFound(boolean z) {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        if (z) {
            LinearLayout adContainer = mpArizonaRentPageBinding.adContainer;
            Intrinsics.checkNotNullExpressionValue(adContainer, "adContainer");
            adContainer.setVisibility(0);
            RecyclerView rvAd = mpArizonaRentPageBinding.rvAd;
            Intrinsics.checkNotNullExpressionValue(rvAd, "rvAd");
            rvAd.setVisibility(8);
            FrameLayout nothingNotContainer = mpArizonaRentPageBinding.nothingNotContainer;
            Intrinsics.checkNotNullExpressionValue(nothingNotContainer, "nothingNotContainer");
            nothingNotContainer.setVisibility(0);
            CustomCardView btnCreateAd = mpArizonaRentPageBinding.btnCreateAd;
            Intrinsics.checkNotNullExpressionValue(btnCreateAd, "btnCreateAd");
            btnCreateAd.setVisibility(8);
            mpArizonaRentPageBinding.tvNotContentDesc.setText(mpArizonaRentPageBinding.getRoot().getContext().getString(R.string.not_ads_filter));
            return;
        }
        LinearLayout adContainer2 = mpArizonaRentPageBinding.adContainer;
        Intrinsics.checkNotNullExpressionValue(adContainer2, "adContainer");
        adContainer2.setVisibility(0);
        RecyclerView rvAd2 = mpArizonaRentPageBinding.rvAd;
        Intrinsics.checkNotNullExpressionValue(rvAd2, "rvAd");
        rvAd2.setVisibility(0);
        FrameLayout nothingNotContainer2 = mpArizonaRentPageBinding.nothingNotContainer;
        Intrinsics.checkNotNullExpressionValue(nothingNotContainer2, "nothingNotContainer");
        nothingNotContainer2.setVisibility(8);
        CustomCardView btnCreateAd2 = mpArizonaRentPageBinding.btnCreateAd;
        Intrinsics.checkNotNullExpressionValue(btnCreateAd2, "btnCreateAd");
        btnCreateAd2.setVisibility(8);
    }

    private final void setupListeners() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        CustomCardView toolbarAll = mpArizonaRentPageBinding.toolbarAll;
        Intrinsics.checkNotNullExpressionValue(toolbarAll, "toolbarAll");
        EasyAnimation.animateClick$default(easyAnimation, toolbarAll, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$0(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        CustomCardView toolbarMy = mpArizonaRentPageBinding.toolbarMy;
        Intrinsics.checkNotNullExpressionValue(toolbarMy, "toolbarMy");
        EasyAnimation.animateClick$default(easyAnimation2, toolbarMy, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$1(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        CustomCardView btnFilter = mpArizonaRentPageBinding.btnFilter;
        Intrinsics.checkNotNullExpressionValue(btnFilter, "btnFilter");
        EasyAnimation.animateClick$default(easyAnimation3, btnFilter, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$2(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation4 = EasyAnimation.INSTANCE;
        ImageView btnBack = mpArizonaRentPageBinding.topBar.btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack, "btnBack");
        EasyAnimation.animateClick$default(easyAnimation4, btnBack, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$3(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation5 = EasyAnimation.INSTANCE;
        ImageView btnAdd = mpArizonaRentPageBinding.topBar.btnAdd;
        Intrinsics.checkNotNullExpressionValue(btnAdd, "btnAdd");
        EasyAnimation.animateClick$default(easyAnimation5, btnAdd, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$4(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation6 = EasyAnimation.INSTANCE;
        CustomCardView btnCreateAd = mpArizonaRentPageBinding.btnCreateAd;
        Intrinsics.checkNotNullExpressionValue(btnCreateAd, "btnCreateAd");
        EasyAnimation.animateClick$default(easyAnimation6, btnCreateAd, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$5(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
        EasyAnimation easyAnimation7 = EasyAnimation.INSTANCE;
        CustomCardView btnUpdate = mpArizonaRentPageBinding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        EasyAnimation.animateClick$default(easyAnimation7, btnUpdate, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = ArizonaRentPage.setupListeners$lambda$0$6(ArizonaRentPage.this);
                return unit;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$0(ArizonaRentPage arizonaRentPage) {
        if (arizonaRentPage.currentToolbar == ArizonaRentToolbarType.MY) {
            arizonaRentPage.selectToolbarAll();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$1(ArizonaRentPage arizonaRentPage) {
        if (arizonaRentPage.currentToolbar == ArizonaRentToolbarType.ALL) {
            arizonaRentPage.selectToolbarMy();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$2(ArizonaRentPage arizonaRentPage) {
        if (arizonaRentPage.isOpenFilter) {
            arizonaRentPage.closeFilter();
        } else {
            arizonaRentPage.openFilter();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$3(ArizonaRentPage arizonaRentPage) {
        arizonaRentPage.closeApp();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$4(ArizonaRentPage arizonaRentPage) {
        if (arizonaRentPage.isHasHoses) {
            arizonaRentPage.navigateTo(MobilePhonePage.ARIZONA_RENT_ADD.getId());
        } else {
            Toast.makeText(arizonaRentPage.getContext(), arizonaRentPage.getContext().getString(R.string.have_not_houses), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$5(ArizonaRentPage arizonaRentPage) {
        if (arizonaRentPage.isHasHoses) {
            arizonaRentPage.navigateTo(MobilePhonePage.ARIZONA_RENT_ADD.getId());
        } else {
            Toast.makeText(arizonaRentPage.getContext(), arizonaRentPage.getContext().getString(R.string.have_not_houses), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$6(ArizonaRentPage arizonaRentPage) {
        arizonaRentPage.update();
        return Unit.INSTANCE;
    }

    private final void setDefaultScreen() {
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$setDefaultScreen$1(this, null), 2, null);
        getMobilePhone().getBinding().phoneBackground.setBackgroundColor(Color.parseColor("#131516"));
        ArizonaRentFilterPage.INSTANCE.setDefault();
        initialize();
        selectToolbarAll();
        closeFilter();
    }

    private final void initialize() {
        this.binding.rvAd.setAdapter(this.adAdapter);
        checkUpdate();
    }

    private final void selectToolbarAll() {
        List<ArizonaRentAdModel> list;
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        this.currentToolbar = ArizonaRentToolbarType.ALL;
        mpArizonaRentPageBinding.toolbarAll.setBackground(-1);
        mpArizonaRentPageBinding.toolbarMy.setBackground(Color.parseColor("#252525"));
        mpArizonaRentPageBinding.tvAll.setTextColor(Color.parseColor("#E5000000"));
        mpArizonaRentPageBinding.tvMy.setTextColor(Color.parseColor("#B2FFFFFF"));
        UiState<ArizonaRentFilterContainerModel> value = this.adState.getValue();
        if (!(value instanceof UiState.Successful) || (list = this.adList) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$selectToolbarAll$1$1$1(this, value, list, mpArizonaRentPageBinding, null), 2, null);
    }

    private final void selectToolbarMy() {
        List<ArizonaRentAdModel> list;
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        this.currentToolbar = ArizonaRentToolbarType.MY;
        mpArizonaRentPageBinding.toolbarAll.setBackground(Color.parseColor("#252525"));
        mpArizonaRentPageBinding.toolbarMy.setBackground(-1);
        mpArizonaRentPageBinding.tvAll.setTextColor(Color.parseColor("#B2FFFFFF"));
        mpArizonaRentPageBinding.tvMy.setTextColor(Color.parseColor("#E5000000"));
        UiState<ArizonaRentFilterContainerModel> value = this.adState.getValue();
        if (!(value instanceof UiState.Successful) || (list = this.adList) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ArizonaRentAdModel) obj).getIsMy(getContext())) {
                arrayList.add(obj);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$selectToolbarMy$1$1$1(this, value, arrayList, mpArizonaRentPageBinding, null), 2, null);
    }

    private final void closeFilter() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        mpArizonaRentPageBinding.foreground.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_down));
        View foreground = mpArizonaRentPageBinding.foreground;
        Intrinsics.checkNotNullExpressionValue(foreground, "foreground");
        foreground.setVisibility(8);
        this.isOpenFilter = false;
        mpArizonaRentPageBinding.btnFilter.setBackground(Color.parseColor("#0DFFFFFF"));
        mpArizonaRentPageBinding.ivFilter.setAlpha(0.5f);
        mpArizonaRentPageBinding.ivFilter.setImageTintList(null);
        ArizonaRentFilterPage arizonaRentFilterPage = ArizonaRentFilterPage.INSTANCE;
        MpArizonaRentFilterBinding filterContainer = mpArizonaRentPageBinding.filterContainer;
        Intrinsics.checkNotNullExpressionValue(filterContainer, "filterContainer");
        ArizonaRentFilterPage.setVisibleFilter$default(arizonaRentFilterPage, false, filterContainer, null, null, 12, null);
    }

    private final void openFilter() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        CustomCardView btnUpdate = mpArizonaRentPageBinding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        if (btnUpdate.getVisibility() == 0) {
            update();
        }
        View foreground = mpArizonaRentPageBinding.foreground;
        Intrinsics.checkNotNullExpressionValue(foreground, "foreground");
        foreground.setVisibility(0);
        mpArizonaRentPageBinding.foreground.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_up));
        this.isOpenFilter = true;
        mpArizonaRentPageBinding.btnFilter.setBackground(-1);
        mpArizonaRentPageBinding.ivFilter.setAlpha(1.0f);
        mpArizonaRentPageBinding.ivFilter.setImageTintList(ColorStateList.valueOf(Color.parseColor("#E5000000")));
        final UiState<ArizonaRentFilterContainerModel> value = this.adState.getValue();
        if (value instanceof UiState.Successful) {
            ArizonaRentFilterPage arizonaRentFilterPage = ArizonaRentFilterPage.INSTANCE;
            MpArizonaRentFilterBinding filterContainer = mpArizonaRentPageBinding.filterContainer;
            Intrinsics.checkNotNullExpressionValue(filterContainer, "filterContainer");
            ArizonaRentFilterContainerModel arizonaRentFilterContainerModel = (ArizonaRentFilterContainerModel) ((UiState.Successful) value).getData();
            arizonaRentFilterPage.setVisibleFilter(true, filterContainer, arizonaRentFilterContainerModel != null ? arizonaRentFilterContainerModel.getFilter() : null, new Function2() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit openFilter$lambda$0$0;
                    openFilter$lambda$0$0 = ArizonaRentPage.openFilter$lambda$0$0(ArizonaRentPage.this, value, ((Boolean) obj).booleanValue(), (ArizonaRentFilterModel) obj2);
                    return openFilter$lambda$0$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openFilter$lambda$0$0(ArizonaRentPage arizonaRentPage, UiState uiState, boolean z, ArizonaRentFilterModel arizonaRentFilterModel) {
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(arizonaRentPage.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$openFilter$1$1$1(uiState, arizonaRentFilterModel, arizonaRentPage, null), 2, null);
        }
        arizonaRentPage.closeFilter();
        return Unit.INSTANCE;
    }

    private final Job setUpCollectors() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$setUpCollectors$1$1(this, this.binding, null), 2, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAds() {
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), null, null, new ArizonaRentPage$getAds$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUpdate() {
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), null, null, new ArizonaRentPage$checkUpdate$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hasUpdate() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        if (!this.isUpdate) {
            CustomCardView btnUpdate = mpArizonaRentPageBinding.btnUpdate;
            Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
            btnUpdate.setVisibility(0);
            mpArizonaRentPageBinding.btnUpdate.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.progress_down));
            return;
        }
        this.isUpdate = false;
    }

    private final void update() {
        MpArizonaRentPageBinding mpArizonaRentPageBinding = this.binding;
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), Dispatchers.getMain(), null, new ArizonaRentPage$update$1$1(this, null), 2, null);
        CustomCardView btnUpdate = mpArizonaRentPageBinding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        btnUpdate.setVisibility(8);
        getAds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFilterData(ArizonaRentFilterContainerModel arizonaRentFilterContainerModel) {
        if ((arizonaRentFilterContainerModel != null ? arizonaRentFilterContainerModel.getFilter() : null) != null) {
            CustomCardView btnFilter = this.binding.btnFilter;
            Intrinsics.checkNotNullExpressionValue(btnFilter, "btnFilter");
            CustomCardView.setBackground$default(btnFilter, Color.parseColor("#2857F4"), Color.parseColor("#6CD0FA"), null, null, 12, null);
            this.binding.ivFilter.setAlpha(1.0f);
            ArizonaRentFilterModel filter = arizonaRentFilterContainerModel.getFilter();
            ArrayList data = arizonaRentFilterContainerModel.getData();
            if (filter.getSearchId() > 0) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (((ArizonaRentAdModel) obj).getHouseNumber() == filter.getSearchId()) {
                        arrayList.add(obj);
                    }
                }
                data = arrayList;
            }
            if (filter.isHaveGarage()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : data) {
                    if (((ArizonaRentAdModel) obj2).isHaveGarage()) {
                        arrayList2.add(obj2);
                    }
                }
                data = arrayList2;
            }
            if (filter.isHaveBasement()) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : data) {
                    if (((ArizonaRentAdModel) obj3).isHaveBasement()) {
                        arrayList3.add(obj3);
                    }
                }
                data = arrayList3;
            }
            if (filter.isCostSortUp() != null) {
                if (filter.isCostSortUp().booleanValue()) {
                    data = CollectionsKt.sortedWith(data, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setFilterData$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((ArizonaRentAdModel) t).getCost()), Integer.valueOf(((ArizonaRentAdModel) t2).getCost()));
                        }
                    });
                } else {
                    data = CollectionsKt.sortedWith(data, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setFilterData$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((ArizonaRentAdModel) t2).getCost()), Integer.valueOf(((ArizonaRentAdModel) t).getCost()));
                        }
                    });
                }
            }
            if (filter.isRatingSortUp() != null) {
                if (filter.isRatingSortUp().booleanValue()) {
                    data = CollectionsKt.sortedWith(data, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setFilterData$$inlined$sortedBy$2
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((ArizonaRentAdModel) t).getNumber()), Integer.valueOf(((ArizonaRentAdModel) t2).getNumber()));
                        }
                    });
                } else {
                    data = CollectionsKt.sortedWith(data, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentPage$setFilterData$$inlined$sortedByDescending$2
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((ArizonaRentAdModel) t2).getNumber()), Integer.valueOf(((ArizonaRentAdModel) t).getNumber()));
                        }
                    });
                }
            }
            setList(true, data);
            return;
        }
        closeFilter();
        setList(false, arizonaRentFilterContainerModel != null ? arizonaRentFilterContainerModel.getData() : null);
    }

    private final void setList(boolean z, List<ArizonaRentAdModel> list) {
        filterNotFound(false);
        if (list != null) {
            if (z && list.isEmpty()) {
                filterNotFound(true);
            } else if (this.currentToolbar != ArizonaRentToolbarType.MY) {
                this.adAdapter.submitList(list);
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((ArizonaRentAdModel) obj).getIsMy(getContext())) {
                        arrayList.add(obj);
                    }
                }
                this.adAdapter.submitList(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdClick(ArizonaRentAdClickEvent arizonaRentAdClickEvent, ArizonaRentAdModel arizonaRentAdModel) {
        ArizonaRentAdIds arizonaRentAdIds = new ArizonaRentAdIds(arizonaRentAdModel.getId(), arizonaRentAdModel.getListId(), arizonaRentAdModel.getHouseNumber());
        int i = WhenMappings.$EnumSwitchMapping$1[arizonaRentAdClickEvent.ordinal()];
        if (i == 1) {
            MobilePage.sendFrontendMessage$default(this, MobilePHoneSendSubIds.RENT.getSubIds(), 0, StringKt.toStringJson(arizonaRentAdIds), 2, null);
        } else if (i == 2) {
            MobilePage.sendFrontendMessage$default(this, MobilePHoneSendSubIds.RENT_DELETE.getSubIds(), 0, StringKt.toStringJson(arizonaRentAdIds), 2, null);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            MobilePage.sendFrontendMessage$default(this, MobilePHoneSendSubIds.RENT_RISE.getSubIds(), 0, StringKt.toStringJson(arizonaRentAdIds), 2, null);
        }
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void hidePage() {
        super.hidePage();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage, ru.mrlargha.feature.mobile.presentation.MobileController
    public void renderPage() {
        super.renderPage();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        setDefaultScreen();
    }

    /* compiled from: ArizonaRentPage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentPage$Companion;", "", "<init>", "()V", "FIVE_SECONDS", "", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

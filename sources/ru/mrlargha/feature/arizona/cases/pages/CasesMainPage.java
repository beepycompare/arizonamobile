package ru.mrlargha.feature.arizona.cases.pages;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.vending.expansion.downloader.Constants;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.feature.arizona.cases.CasesCurrencyType;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
import ru.mrlargha.feature.arizona.cases.CasesId;
import ru.mrlargha.feature.arizona.cases.CasesInfoModel;
import ru.mrlargha.feature.arizona.cases.CasesResponseKt;
import ru.mrlargha.feature.arizona.cases.CasesSameCasesModel;
import ru.mrlargha.feature.arizona.cases.databinding.CasesMainPageBinding;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesCanWinAdapter;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesGuaranteedAdapter;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
/* compiled from: CasesMainPage.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001FB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010%\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eH\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020#H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u001cH\u0002J\u0010\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020#H\u0002J\b\u00102\u001a\u00020\nH\u0002J\u0012\u00103\u001a\u00020\u001c2\b\b\u0002\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\nH\u0002J\u0017\u00106\u001a\u0004\u0018\u00010\n2\u0006\u00107\u001a\u00020\u001cH\u0002¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\u0016\u0010=\u001a\u00020\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0;H\u0002J\u0016\u0010@\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020?0;H\u0002J\u0010\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u001eH\u0002J\b\u0010D\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/CasesMainPage;", "Lru/mrlargha/feature/arizona/cases/pages/CasesBasePage;", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/CasesMainPageBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "onQuality", "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Activity;Lru/mrlargha/feature/arizona/cases/databinding/CasesMainPageBinding;Lru/mrlargha/commonui/core/IBackendNotifier;Lkotlin/jvm/functions/Function0;)V", "getTargetActivity", "()Landroid/app/Activity;", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/CasesMainPageBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "getOnQuality", "()Lkotlin/jvm/functions/Function0;", "sameCasesAdapter", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter;", "guaranteedAdapter", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter;", "canWinAdapter", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter;", "isShowPrizePage", "", "x", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "modelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/feature/arizona/cases/CasesInfoModel;", "baseModel", "createPage", "sendEvent", "data", "", "subId", "initialize", "Lkotlinx/coroutines/Job;", CommonUrlParts.MODEL, "setupCollectors", "checkIsHavaCase", "setXVisible", "invisible", "checkDiscount", "setupListeners", "hidePrizePage", "animate", "showPrizePage", "setSelectXType", "isXOneType", "(Z)Lkotlin/Unit;", "setPrizeList", "prizeList", "", "Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "setGuaranteedList", "guaranteedList", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "setCanWinList", "canWinList", "onSameCaseClick", "caseId", "onGuaranteedClick", "destroyPage", "Companion", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesMainPage implements CasesBasePage {
    private static final long ANIMATION_DURATION = 500;
    public static final Companion Companion = new Companion(null);
    private static final int X_ONE = 1;
    private static final int X_TEN = 10;
    private CasesInfoModel baseModel;
    private final CasesMainPageBinding binding;
    private final CasesCanWinAdapter canWinAdapter;
    private final CasesGuaranteedAdapter guaranteedAdapter;
    private boolean isShowPrizePage;
    private final MutableStateFlow<CasesInfoModel> modelState;
    private final IBackendNotifier notifier;
    private final Function0<Unit> onQuality;
    private final CasesSameCasesAdapter sameCasesAdapter;
    private CoroutineScope scope;
    private final Activity targetActivity;
    private int x;

    /* compiled from: CasesMainPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CasesCurrencyType.values().length];
            try {
                iArr[CasesCurrencyType.RUB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CasesCurrencyType.AZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CasesMainPage(Activity targetActivity, CasesMainPageBinding binding, IBackendNotifier notifier, Function0<Unit> onQuality) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        Intrinsics.checkNotNullParameter(onQuality, "onQuality");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.notifier = notifier;
        this.onQuality = onQuality;
        this.sameCasesAdapter = new CasesSameCasesAdapter(new CasesMainPage$sameCasesAdapter$1(this));
        CasesGuaranteedAdapter casesGuaranteedAdapter = new CasesGuaranteedAdapter();
        this.guaranteedAdapter = casesGuaranteedAdapter;
        this.canWinAdapter = new CasesCanWinAdapter(new Function1() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit canWinAdapter$lambda$0;
                canWinAdapter$lambda$0 = CasesMainPage.canWinAdapter$lambda$0(CasesMainPage.this, ((Integer) obj).intValue());
                return canWinAdapter$lambda$0;
            }
        }, new Function0() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit canWinAdapter$lambda$1;
                canWinAdapter$lambda$1 = CasesMainPage.canWinAdapter$lambda$1(CasesMainPage.this);
                return canWinAdapter$lambda$1;
            }
        });
        this.x = 1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.modelState = StateFlowKt.MutableStateFlow(null);
        binding.rvGuaranteed.setAdapter(casesGuaranteedAdapter);
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public final CasesMainPageBinding getBinding() {
        return this.binding;
    }

    public final IBackendNotifier getNotifier() {
        return this.notifier;
    }

    public final Function0<Unit> getOnQuality() {
        return this.onQuality;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit canWinAdapter$lambda$0(CasesMainPage casesMainPage, int i) {
        casesMainPage.notifier.clickedWrapper(UIElementID.CASES.getId(), i, 8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit canWinAdapter$lambda$1(CasesMainPage casesMainPage) {
        casesMainPage.onQuality.invoke();
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void createPage() {
        Log.i(CasesResponseKt.CASES_TAG, "createPage: " + getClass().getName());
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void sendEvent(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == CasesId.MAIN_PAGE_INIT.getSubId()) {
            initialize((CasesInfoModel) MapperKt.toModel(data, CasesInfoModel.class));
            setupListeners();
            setupCollectors();
        } else if (i == CasesId.SET_SAME_CASES.getSubId()) {
            setPrizeList(MapperKt.toListModel(data, CasesSameCasesModel.class));
        } else if (i == CasesId.SET_GUARANTEED_LIST.getSubId()) {
            setGuaranteedList(MapperKt.toListModel(data, CasesGuaranteedPrizeModel.class));
        } else if (i == CasesId.SET_CAN_WIN_LIST.getSubId()) {
            setCanWinList(MapperKt.toListModel(data, CasesGuaranteedPrizeModel.class));
        } else if (i == CasesId.SET_PRIZE_PROGRESS.getSubId()) {
            CasesGuaranteedAdapter casesGuaranteedAdapter = this.guaranteedAdapter;
            Integer intOrNull = StringsKt.toIntOrNull(data);
            casesGuaranteedAdapter.setProgress(intOrNull != null ? intOrNull.intValue() : 0);
        }
    }

    private final Job initialize(CasesInfoModel casesInfoModel) {
        Job launch$default;
        CasesMainPageBinding casesMainPageBinding = this.binding;
        this.baseModel = casesInfoModel;
        setSelectXType(true);
        hidePrizePage$default(this, false, 1, null);
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/rodina-rp/systems/cases/" + casesInfoModel.getCaseId() + ".webp").into(casesMainPageBinding.ivCase);
        Picasso picasso2 = Picasso.get();
        String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso2.load(resourceUrl2 + "projects/rodina-rp/systems/cases/logo_" + casesInfoModel.getCaseId() + ".webp").into(casesMainPageBinding.ivCaseLogo);
        int i = WhenMappings.$EnumSwitchMapping$0[casesInfoModel.m11349getCurrency().ordinal()];
        if (i == 1) {
            casesMainPageBinding.ivMoneyIc.setImageResource(R.drawable.blueprint_ic_rub);
            casesMainPageBinding.ivMoneyIc.setImageTintList(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            casesMainPageBinding.ivMoneyIc.setImageResource(R.drawable.ic_az_coins);
            casesMainPageBinding.ivMoneyIc.setImageTintList(null);
        }
        CardView discountContainer = casesMainPageBinding.discountContainer;
        Intrinsics.checkNotNullExpressionValue(discountContainer, "discountContainer");
        discountContainer.setVisibility(8);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CasesMainPage$initialize$1$1(this, casesInfoModel, null), 3, null);
        return launch$default;
    }

    private final Job setupCollectors() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CasesMainPage$setupCollectors$1$1(this, this.binding, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIsHavaCase(CasesInfoModel casesInfoModel) {
        this.binding.tvOpenCase.setText(casesInfoModel.m11347getCost());
        if (casesInfoModel.isSpecialCase()) {
            setXVisible(true);
        } else if (casesInfoModel.getCountLeft() > 0) {
            setXVisible(true);
        } else {
            setXVisible(false);
        }
    }

    private final void setXVisible(boolean z) {
        CasesMainPageBinding casesMainPageBinding = this.binding;
        TextView tvTenX = casesMainPageBinding.tvTenX;
        Intrinsics.checkNotNullExpressionValue(tvTenX, "tvTenX");
        tvTenX.setVisibility(z ? 4 : 0);
        TextView tvOneX = casesMainPageBinding.tvOneX;
        Intrinsics.checkNotNullExpressionValue(tvOneX, "tvOneX");
        tvOneX.setVisibility(z ? 4 : 0);
        ImageView ivMoneyIc = casesMainPageBinding.ivMoneyIc;
        Intrinsics.checkNotNullExpressionValue(ivMoneyIc, "ivMoneyIc");
        ivMoneyIc.setVisibility(z ? 8 : 0);
    }

    private final void checkDiscount(CasesInfoModel casesInfoModel) {
        CasesMainPageBinding casesMainPageBinding = this.binding;
        if ((this.x == 1 && casesInfoModel.getDiscountCount() == 1) || (this.x == 10 && casesInfoModel.getDiscountCount() == 10)) {
            Log.i(CasesResponseKt.CASES_TAG, "checkDiscount: " + casesInfoModel);
            CardView discountContainer = casesMainPageBinding.discountContainer;
            Intrinsics.checkNotNullExpressionValue(discountContainer, "discountContainer");
            discountContainer.setVisibility(0);
            casesMainPageBinding.tvDiscount.setText(Constants.FILENAME_SEQUENCE_SEPARATOR + casesInfoModel.getDiscount() + "%");
            Integer cost = casesInfoModel.getCost();
            double intValue = (cost != null ? cost.intValue() : 0) * (casesInfoModel.getDiscount() / 100);
            Integer cost2 = casesInfoModel.getCost();
            casesMainPageBinding.tvOpenCase.setText("Открыть за " + ((int) ((cost2 != null ? cost2.intValue() : 0) - intValue)));
        } else {
            TextView textView = casesMainPageBinding.tvOpenCase;
            Integer cost3 = casesInfoModel.getCost();
            textView.setText("Открыть за " + (cost3 != null ? Integer.valueOf(cost3.intValue()) : null));
            CardView discountContainer2 = casesMainPageBinding.discountContainer;
            Intrinsics.checkNotNullExpressionValue(discountContainer2, "discountContainer");
            discountContainer2.setVisibility(8);
        }
        ImageView ivMoneyIc = casesMainPageBinding.ivMoneyIc;
        Intrinsics.checkNotNullExpressionValue(ivMoneyIc, "ivMoneyIc");
        ImageView imageView = ivMoneyIc;
        Integer cost4 = casesInfoModel.getCost();
        imageView.setVisibility((cost4 != null ? cost4.intValue() : 0) > 0 ? 0 : 8);
    }

    private final void setupListeners() {
        CasesMainPageBinding casesMainPageBinding = this.binding;
        casesMainPageBinding.prizePage.btnShowPrizes.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesMainPage.setupListeners$lambda$0$0(CasesMainPage.this, view);
            }
        });
        casesMainPageBinding.tvOneX.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesMainPage.setupListeners$lambda$0$1(CasesMainPage.this, view);
            }
        });
        casesMainPageBinding.tvTenX.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesMainPage.setupListeners$lambda$0$2(CasesMainPage.this, view);
            }
        });
        casesMainPageBinding.btnOpen.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesMainPage.setupListeners$lambda$0$3(CasesMainPage.this, view);
            }
        });
        casesMainPageBinding.guaranteedBlock.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesMainPage.this.onGuaranteedClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(CasesMainPage casesMainPage, View view) {
        if (casesMainPage.isShowPrizePage) {
            casesMainPage.hidePrizePage(true);
        } else {
            casesMainPage.showPrizePage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(CasesMainPage casesMainPage, View view) {
        if (casesMainPage.x == 10) {
            casesMainPage.setSelectXType(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(CasesMainPage casesMainPage, View view) {
        if (casesMainPage.x == 1) {
            casesMainPage.setSelectXType(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(CasesMainPage casesMainPage, View view) {
        casesMainPage.notifier.clickedWrapper(UIElementID.CASES.getId(), casesMainPage.x, 0);
    }

    private final boolean hidePrizePage(final boolean z) {
        final CasesMainPageBinding casesMainPageBinding = this.binding;
        return casesMainPageBinding.getRoot().post(new Runnable() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CasesMainPage.hidePrizePage$lambda$0$0(CasesMainPageBinding.this, this, z);
            }
        });
    }

    static /* synthetic */ boolean hidePrizePage$default(CasesMainPage casesMainPage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return casesMainPage.hidePrizePage(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hidePrizePage$lambda$0$0(CasesMainPageBinding casesMainPageBinding, CasesMainPage casesMainPage, boolean z) {
        int height = casesMainPageBinding.getRoot().getHeight() - ConverterKt.dpToPx(50, casesMainPage.targetActivity);
        if (z) {
            casesMainPageBinding.prizePage.getRoot().animate().translationY(height).setDuration(500L).setInterpolator(new DecelerateInterpolator()).start();
        } else {
            casesMainPageBinding.prizePage.getRoot().setTranslationY(height);
            LinearLayout root = casesMainPageBinding.prizePage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
        }
        casesMainPageBinding.prizePage.btnShowPrizes.setScaleY(-1.0f);
        casesMainPage.isShowPrizePage = false;
        LinearLayout mainPageContainer = casesMainPageBinding.mainPageContainer;
        Intrinsics.checkNotNullExpressionValue(mainPageContainer, "mainPageContainer");
        mainPageContainer.setVisibility(0);
        RecyclerView rvPrizes = casesMainPageBinding.prizePage.rvPrizes;
        Intrinsics.checkNotNullExpressionValue(rvPrizes, "rvPrizes");
        rvPrizes.setVisibility(8);
    }

    private final void showPrizePage() {
        final CasesMainPageBinding casesMainPageBinding = this.binding;
        casesMainPageBinding.prizePage.getRoot().animate().translationY(1.0f).setDuration(500L).withEndAction(new Runnable() { // from class: ru.mrlargha.feature.arizona.cases.pages.CasesMainPage$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                CasesMainPage.showPrizePage$lambda$0$0(CasesMainPageBinding.this);
            }
        }).start();
        casesMainPageBinding.prizePage.btnShowPrizes.setScaleY(1.0f);
        this.isShowPrizePage = true;
        RecyclerView rvPrizes = casesMainPageBinding.prizePage.rvPrizes;
        Intrinsics.checkNotNullExpressionValue(rvPrizes, "rvPrizes");
        rvPrizes.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrizePage$lambda$0$0(CasesMainPageBinding casesMainPageBinding) {
        LinearLayout mainPageContainer = casesMainPageBinding.mainPageContainer;
        Intrinsics.checkNotNullExpressionValue(mainPageContainer, "mainPageContainer");
        mainPageContainer.setVisibility(8);
    }

    private final Unit setSelectXType(boolean z) {
        String str;
        CasesMainPageBinding casesMainPageBinding = this.binding;
        int i = ru.mrlargha.feature.arizona.cases.R.drawable.cases_select_x;
        int i2 = ru.mrlargha.feature.arizona.cases.R.drawable.cases_unselect_x;
        casesMainPageBinding.tvOneX.setBackgroundResource(z ? i : i2);
        TextView textView = casesMainPageBinding.tvTenX;
        if (z) {
            i = i2;
        }
        textView.setBackgroundResource(i);
        this.x = z ? 1 : 10;
        CasesInfoModel casesInfoModel = this.baseModel;
        if (casesInfoModel != null) {
            Log.i(CasesResponseKt.CASES_TAG, "setSelectXType: base " + casesInfoModel);
            if (z) {
                str = CasesResponseKt.CASES_TAG;
            } else {
                Integer cost = casesInfoModel.getCost();
                Integer valueOf = Integer.valueOf((cost != null ? cost.intValue() : 0) * 10);
                str = CasesResponseKt.CASES_TAG;
                casesInfoModel = CasesInfoModel.copy$default(casesInfoModel, 0, 0, 0, 0, 0, 0, 0, valueOf, null, null, 895, null);
            }
            Log.i(str, "setSelectXType: update " + casesInfoModel);
            checkDiscount(casesInfoModel);
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void setPrizeList(List<CasesSameCasesModel> list) {
        this.binding.rvSameCases.setAdapter(this.sameCasesAdapter);
        this.sameCasesAdapter.submitList(list);
    }

    private final void setGuaranteedList(List<CasesGuaranteedPrizeModel> list) {
        this.guaranteedAdapter.submitList(list);
    }

    private final void setCanWinList(List<CasesGuaranteedPrizeModel> list) {
        this.binding.prizePage.rvPrizes.setAdapter(this.canWinAdapter);
        this.canWinAdapter.submitList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSameCaseClick(int i) {
        this.notifier.clickedWrapper(UIElementID.CASES.getId(), i, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGuaranteedClick() {
        this.notifier.clickedWrapper(UIElementID.CASES.getId(), 0, 7);
    }

    @Override // ru.mrlargha.feature.arizona.cases.pages.CasesBasePage
    public void destroyPage() {
        Log.i(CasesResponseKt.CASES_TAG, "destroyPage: " + getClass().getName());
    }

    /* compiled from: CasesMainPage.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/CasesMainPage$Companion;", "", "<init>", "()V", "ANIMATION_DURATION", "", "X_TEN", "", "X_ONE", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

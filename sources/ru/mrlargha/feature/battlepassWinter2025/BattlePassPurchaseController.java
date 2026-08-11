package ru.mrlargha.feature.battlepassWinter2025;

import android.app.Activity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassLevelSetData;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassPremiumData;
import ru.mrlargha.feature.battlepassWinter2025.data.MainBattlePassInfo;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassBuyPremiumLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassConvertBattlecoinsLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLevelSetsLayoutBinding;
/* compiled from: BattlePassPurchaseController.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u0000 U2\u00020\u0001:\u0001UB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0010\u00126\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010$\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'J\b\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0014J\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0014J\u0014\u0010.\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u0014\u00102\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020400J\u000e\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u000207J0\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u000201H\u0002J*\u0010@\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010:2\u0006\u0010>\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010B\u001a\u000204H\u0002J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u000207H\u0002J\u0010\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u000207H\u0002J\u0012\u0010G\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010I\u001a\u00020\u0012H\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\u000bH\u0002J$\u0010L\u001a\u00020\u0012*\u00020:2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000bH\u0002J\u0014\u0010Q\u001a\u00020\u0012*\u00020:2\u0006\u0010R\u001a\u00020\u000bH\u0002J\u0010\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassPurchaseController;", "", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "premiumAction", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassPremiumActionViews;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isArizona", "", "levelSetBuyText", "", "levelSetUnavailableText", "loadArizonaPremiumImage", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "", "notifyClick", "", "Lkotlin/ParameterName;", "name", "id", "subId", "<init>", "(Landroid/app/Activity;Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;Lru/mrlargha/feature/battlepassWinter2025/BattlePassPremiumActionViews;Lkotlinx/coroutines/CoroutineScope;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "value", "isLevelPageLocked", "()Z", "isPremiumPageLocked", "blockTimerJob", "Lkotlinx/coroutines/Job;", "currentBattlePassLevel", "Ljava/lang/Integer;", "blockTimerText", "setupLevelBuyPage", "setupBuyPremiumPage", "info", "Lru/mrlargha/feature/battlepassWinter2025/data/MainBattlePassInfo;", "buildRodinaPremiumRewardsText", "", "updatePremiumButtonsVisibility", "premium", "updateLevelSetButtonsAvailability", FirebaseAnalytics.Param.LEVEL, "updateBattlePassPremium", "premiumList", "", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassPremiumData;", "updateLevelSetsInfo", "levelSets", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassLevelSetData;", "checkAvailableBp", "targetUnixTime", "", "bindPremiumPrice", "discountText", "Landroid/widget/TextView;", "discountPercentBox", "Landroid/view/View;", "discountPercentText", "priceText", "premiumData", "setupLevelSetText", "lvlText", "levelData", "startLeftTimer", "remainingMillis", "setLeftTime", "leftTime", "updateBlockTime", "time", "refreshLevelSetButtonStates", "updateMinimumLevelLockVisuals", "isLocked", "setLevelSetButtonState", "text", "visualAlpha", "", "enabled", "setLevelSetButtonAvailability", "isAvailable", "formatRubPrice", FirebaseAnalytics.Param.PRICE, "Companion", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassPurchaseController {
    @Deprecated
    public static final String BUY_TEXT = "Купить";
    @Deprecated
    public static final int FRONTEND_LEVEL_SETS_MINIMUM_SIZE = 4;
    @Deprecated
    public static final int FRONTEND_PREMIUM_MINIMUM_SIZE = 2;
    @Deprecated
    public static final String LEVEL_COUNT_MISMATCH_MESSAGE = "Количество уровней не соответствует серверу, обратитесь в поддержку!";
    @Deprecated
    public static final float LOCKED_ICON_ALPHA = 0.35f;
    @Deprecated
    public static final int MIN_LEVEL_TO_BUY_LEVELS = 10;
    @Deprecated
    public static final String PREMIUM_BOUGHT_TEXT = "КУПЛЕНО";
    @Deprecated
    public static final String PREMIUM_COUNT_MISMATCH_MESSAGE = "Количество премиумов не соответствует серверу, обратитесь в поддержку!";
    @Deprecated
    public static final String PREMIUM_NAV_BUY_TEXT = "КУПИТЬ PREMIUM";
    @Deprecated
    public static final String PREMIUM_PAGE_BUY_TEXT = "КУПИТЬ";
    @Deprecated
    public static final String PREMIUM_PLUS_BUY_TEXT = "КУПИТЬ PREMIUM PLUS";
    @Deprecated
    public static final String RODINA_PASS_TEXT = "Rodina Pass";
    @Deprecated
    public static final String UNAVAILABLE_TEXT = "Недоступно";
    private final WinterBattlepassLayoutBinding binding;
    private Job blockTimerJob;
    private String blockTimerText;
    private Integer currentBattlePassLevel;
    private final boolean isArizona;
    private boolean isLevelPageLocked;
    private boolean isPremiumPageLocked;
    private final String levelSetBuyText;
    private final String levelSetUnavailableText;
    private final Function2<ImageView, String, Unit> loadArizonaPremiumImage;
    private final Function2<Integer, Integer, Unit> notifyClick;
    private final BattlePassPremiumActionViews premiumAction;
    private final CoroutineScope scope;
    private final Activity targetActivity;
    private static final Companion Companion = new Companion(null);
    private static final List<String> ARIZONA_PREMIUM_IMAGE_IDS = CollectionsKt.listOf((Object[]) new String[]{"1001", "1002", "1003"});

    /* JADX WARN: Multi-variable type inference failed */
    public BattlePassPurchaseController(Activity targetActivity, WinterBattlepassLayoutBinding binding, BattlePassPremiumActionViews premiumAction, CoroutineScope scope, boolean z, String levelSetBuyText, String levelSetUnavailableText, Function2<? super ImageView, ? super String, Unit> loadArizonaPremiumImage, Function2<? super Integer, ? super Integer, Unit> notifyClick) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(premiumAction, "premiumAction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(levelSetBuyText, "levelSetBuyText");
        Intrinsics.checkNotNullParameter(levelSetUnavailableText, "levelSetUnavailableText");
        Intrinsics.checkNotNullParameter(loadArizonaPremiumImage, "loadArizonaPremiumImage");
        Intrinsics.checkNotNullParameter(notifyClick, "notifyClick");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.premiumAction = premiumAction;
        this.scope = scope;
        this.isArizona = z;
        this.levelSetBuyText = levelSetBuyText;
        this.levelSetUnavailableText = levelSetUnavailableText;
        this.loadArizonaPremiumImage = loadArizonaPremiumImage;
        this.notifyClick = notifyClick;
        this.currentBattlePassLevel = z ? 0 : null;
    }

    public final boolean isLevelPageLocked() {
        return this.isLevelPageLocked;
    }

    public final boolean isPremiumPageLocked() {
        return this.isPremiumPageLocked;
    }

    public final void setupLevelBuyPage() {
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.binding.battlepassLevelSetsPage;
        winterBattlepassLevelSetsLayoutBinding.silverPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassPurchaseController.setupLevelBuyPage$lambda$0$0(BattlePassPurchaseController.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.goldPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassPurchaseController.setupLevelBuyPage$lambda$0$1(BattlePassPurchaseController.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.epicPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassPurchaseController.setupLevelBuyPage$lambda$0$2(BattlePassPurchaseController.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassPurchaseController.setupLevelBuyPage$lambda$0$3(BattlePassPurchaseController.this, view);
            }
        });
        if (!this.isArizona) {
            winterBattlepassLevelSetsLayoutBinding.passName1.setText(RODINA_PASS_TEXT);
            winterBattlepassLevelSetsLayoutBinding.passName2.setText(RODINA_PASS_TEXT);
            winterBattlepassLevelSetsLayoutBinding.passName3.setText(RODINA_PASS_TEXT);
            winterBattlepassLevelSetsLayoutBinding.passName4.setText(RODINA_PASS_TEXT);
            return;
        }
        updateMinimumLevelLockVisuals(true);
        refreshLevelSetButtonStates();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$0(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(0, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$1(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(1, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$2(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(2, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$3(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(3, 7);
    }

    public final void setupBuyPremiumPage(MainBattlePassInfo mainBattlePassInfo) {
        WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding = this.binding.battlepassLevelPremiumPage;
        LinearLayout rodinaPremiumPlusExtraBenefits = winterBattlepassBuyPremiumLayoutBinding.rodinaPremiumPlusExtraBenefits;
        Intrinsics.checkNotNullExpressionValue(rodinaPremiumPlusExtraBenefits, "rodinaPremiumPlusExtraBenefits");
        final int i = 0;
        rodinaPremiumPlusExtraBenefits.setVisibility(!this.isArizona ? 0 : 8);
        LinearLayout arizonaPremiumExtraBenefit = winterBattlepassBuyPremiumLayoutBinding.arizonaPremiumExtraBenefit;
        Intrinsics.checkNotNullExpressionValue(arizonaPremiumExtraBenefit, "arizonaPremiumExtraBenefit");
        arizonaPremiumExtraBenefit.setVisibility(this.isArizona ? 0 : 8);
        LinearLayout arizonaPremiumPlusExtraBenefits = winterBattlepassBuyPremiumLayoutBinding.arizonaPremiumPlusExtraBenefits;
        Intrinsics.checkNotNullExpressionValue(arizonaPremiumPlusExtraBenefits, "arizonaPremiumPlusExtraBenefits");
        arizonaPremiumPlusExtraBenefits.setVisibility(this.isArizona ? 0 : 8);
        LinearLayout premiumPlusImages = winterBattlepassBuyPremiumLayoutBinding.premiumPlusImages;
        Intrinsics.checkNotNullExpressionValue(premiumPlusImages, "premiumPlusImages");
        premiumPlusImages.setVisibility(this.isArizona ? 0 : 8);
        if (this.isArizona) {
            winterBattlepassBuyPremiumLayoutBinding.premiumBenefitRewardsText.setText(R.string.battlepass_arizona_premium_benefit_rewards);
            winterBattlepassBuyPremiumLayoutBinding.premiumBenefitProgressText.setText(R.string.battlepass_arizona_premium_benefit_progress);
            winterBattlepassBuyPremiumLayoutBinding.premiumBenefitTasksText.setText(R.string.battlepass_arizona_premium_benefit_tasks);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitAllText.setText(R.string.battlepass_arizona_premium_plus_benefit_all);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitLevelsText.setText(R.string.battlepass_arizona_premium_plus_benefit_levels);
            winterBattlepassBuyPremiumLayoutBinding.vipText.setText(R.string.battlepass_arizona_premium_plus_benefit_vip);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitC5Text.setText(R.string.battlepass_arizona_premium_plus_benefit_c5);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitCeoText.setText(R.string.battlepass_arizona_premium_plus_benefit_ceo);
        } else {
            winterBattlepassBuyPremiumLayoutBinding.premiumBenefitRewardsText.setText(buildRodinaPremiumRewardsText());
            winterBattlepassBuyPremiumLayoutBinding.premiumBenefitProgressText.setText(R.string.battlepass_rodina_premium_benefit_progress);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitAllText.setText(R.string.battlepass_rodina_premium_plus_benefit_all);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusBenefitLevelsText.setText(R.string.battlepass_rodina_premium_plus_benefit_levels);
            winterBattlepassBuyPremiumLayoutBinding.vipText.setText(R.string.battlepass_rodina_premium_plus_benefit_bandit_case);
        }
        winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText.setPaintFlags(16);
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText.setPaintFlags(16);
        if (mainBattlePassInfo != null) {
            int premium = mainBattlePassInfo.getPremium();
            if (premium == 0) {
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BattlePassPurchaseController.setupBuyPremiumPage$lambda$0$0$0(BattlePassPurchaseController.this, view);
                    }
                });
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText(PREMIUM_PAGE_BUY_TEXT);
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setAlpha(1.0f);
            } else if (premium == 1) {
                CustomCardView customCardView = winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton;
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText(PREMIUM_BOUGHT_TEXT);
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setAlpha(0.5f);
            }
        }
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BattlePassPurchaseController.setupBuyPremiumPage$lambda$0$1(BattlePassPurchaseController.this, view);
            }
        });
        if (!this.isArizona) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new BattlePassPurchaseController$setupBuyPremiumPage$1$4(winterBattlepassBuyPremiumLayoutBinding, this, null), 3, null);
            return;
        }
        for (Object obj : CollectionsKt.zip(CollectionsKt.listOf((Object[]) new ImageView[]{winterBattlepassBuyPremiumLayoutBinding.premiumImage1, winterBattlepassBuyPremiumLayoutBinding.premiumImage2, winterBattlepassBuyPremiumLayoutBinding.premiumImage3}), ARIZONA_PREMIUM_IMAGE_IDS)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            Object component1 = pair.component1();
            Intrinsics.checkNotNullExpressionValue(component1, "component1(...)");
            ImageView imageView = (ImageView) component1;
            this.loadArizonaPremiumImage.invoke(imageView, (String) pair.component2());
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BattlePassPurchaseController.setupBuyPremiumPage$lambda$0$2$0(BattlePassPurchaseController.this, i, view);
                }
            });
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBuyPremiumPage$lambda$0$0$0(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(0, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBuyPremiumPage$lambda$0$1(BattlePassPurchaseController battlePassPurchaseController, View view) {
        battlePassPurchaseController.notifyClick.invoke(1, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBuyPremiumPage$lambda$0$2$0(BattlePassPurchaseController battlePassPurchaseController, int i, View view) {
        battlePassPurchaseController.notifyClick.invoke(Integer.valueOf(i + 1), 32);
    }

    private final CharSequence buildRodinaPremiumRewardsText() {
        String string = this.targetActivity.getString(R.string.battlepass_rodina_premium_benefit_rewards);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.targetActivity.getString(R.string.battlepass_rodina_premium_benefit_rewards_accent);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = string;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.targetActivity, R.color.winter_bp_pink_accent_orange)), indexOf$default, string2.length() + indexOf$default, 33);
        return spannableString;
    }

    public final void updatePremiumButtonsVisibility(int i) {
        BattlePassPremiumActionViews battlePassPremiumActionViews = this.premiumAction;
        if (i == 0) {
            battlePassPremiumActionViews.getContainer().setVisibility(0);
            battlePassPremiumActionViews.getText().setText(PREMIUM_NAV_BUY_TEXT);
        } else if (i == 1) {
            battlePassPremiumActionViews.getContainer().setVisibility(0);
            battlePassPremiumActionViews.getText().setText(PREMIUM_PLUS_BUY_TEXT);
        } else {
            battlePassPremiumActionViews.getContainer().setVisibility(8);
        }
        WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.binding.battlepassConvertBattlecoinsPage;
    }

    public final void updateLevelSetButtonsAvailability(int i) {
        this.currentBattlePassLevel = Integer.valueOf(i);
        updateMinimumLevelLockVisuals(this.isArizona && i < 10);
        refreshLevelSetButtonStates();
    }

    public final void updateBattlePassPremium(List<BattlePassPremiumData> premiumList) {
        Intrinsics.checkNotNullParameter(premiumList, "premiumList");
        if (premiumList.size() != 2) {
            this.isPremiumPageLocked = true;
            Toast.makeText(this.targetActivity.getApplicationContext(), PREMIUM_COUNT_MISMATCH_MESSAGE, 1).show();
            return;
        }
        WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding = this.binding.battlepassLevelPremiumPage;
        BattlePassPremiumData battlePassPremiumData = premiumList.get(0);
        BattlePassPremiumData battlePassPremiumData2 = premiumList.get(1);
        TextView premiumDiscountText = winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText;
        Intrinsics.checkNotNullExpressionValue(premiumDiscountText, "premiumDiscountText");
        RelativeLayout premiumDiscountPercentBox = winterBattlepassBuyPremiumLayoutBinding.premiumDiscountPercentBox;
        Intrinsics.checkNotNullExpressionValue(premiumDiscountPercentBox, "premiumDiscountPercentBox");
        TextView premiumDiscountPercentText = winterBattlepassBuyPremiumLayoutBinding.premiumDiscountPercentText;
        Intrinsics.checkNotNullExpressionValue(premiumDiscountPercentText, "premiumDiscountPercentText");
        TextView premiumPriceText = winterBattlepassBuyPremiumLayoutBinding.premiumPriceText;
        Intrinsics.checkNotNullExpressionValue(premiumPriceText, "premiumPriceText");
        bindPremiumPrice(premiumDiscountText, premiumDiscountPercentBox, premiumDiscountPercentText, premiumPriceText, battlePassPremiumData);
        TextView premiumPlusDiscountText = winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText;
        Intrinsics.checkNotNullExpressionValue(premiumPlusDiscountText, "premiumPlusDiscountText");
        RelativeLayout premiumPlusDiscountPercentBox = winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountPercentBox;
        Intrinsics.checkNotNullExpressionValue(premiumPlusDiscountPercentBox, "premiumPlusDiscountPercentBox");
        TextView premiumPlusDiscountPercentText = winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountPercentText;
        Intrinsics.checkNotNullExpressionValue(premiumPlusDiscountPercentText, "premiumPlusDiscountPercentText");
        TextView premiumPlusPriceText = winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceText;
        Intrinsics.checkNotNullExpressionValue(premiumPlusPriceText, "premiumPlusPriceText");
        bindPremiumPrice(premiumPlusDiscountText, premiumPlusDiscountPercentBox, premiumPlusDiscountPercentText, premiumPlusPriceText, battlePassPremiumData2);
        if (battlePassPremiumData.getStatus() == 1) {
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText(UNAVAILABLE_TEXT);
        } else {
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setForeground(null);
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText(BUY_TEXT);
        }
        if (battlePassPremiumData2.getStatus() == 1) {
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setForeground(ContextCompat.getDrawable(this.targetActivity, R.drawable.bp_unselect_btn));
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButtonText.setText(UNAVAILABLE_TEXT);
            return;
        }
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setForeground(null);
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButtonText.setText(BUY_TEXT);
    }

    public final void updateLevelSetsInfo(List<BattlePassLevelSetData> levelSets) {
        Intrinsics.checkNotNullParameter(levelSets, "levelSets");
        if (levelSets.size() != 4) {
            this.isLevelPageLocked = true;
            Toast.makeText(this.targetActivity.getApplicationContext(), LEVEL_COUNT_MISMATCH_MESSAGE, 1).show();
            return;
        }
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.binding.battlepassLevelSetsPage;
        TextView textView = winterBattlepassLevelSetsLayoutBinding.silverLvlText;
        TextView silverPriceText = winterBattlepassLevelSetsLayoutBinding.silverPriceText;
        Intrinsics.checkNotNullExpressionValue(silverPriceText, "silverPriceText");
        TextView silverDiscountText = winterBattlepassLevelSetsLayoutBinding.silverDiscountText;
        Intrinsics.checkNotNullExpressionValue(silverDiscountText, "silverDiscountText");
        setupLevelSetText(textView, silverPriceText, silverDiscountText, levelSets.get(0));
        TextView textView2 = winterBattlepassLevelSetsLayoutBinding.goldLvlText;
        TextView goldPriceText = winterBattlepassLevelSetsLayoutBinding.goldPriceText;
        Intrinsics.checkNotNullExpressionValue(goldPriceText, "goldPriceText");
        TextView goldDiscountText = winterBattlepassLevelSetsLayoutBinding.goldDiscountText;
        Intrinsics.checkNotNullExpressionValue(goldDiscountText, "goldDiscountText");
        setupLevelSetText(textView2, goldPriceText, goldDiscountText, levelSets.get(1));
        TextView textView3 = winterBattlepassLevelSetsLayoutBinding.epicLvlText;
        TextView epicPriceText = winterBattlepassLevelSetsLayoutBinding.epicPriceText;
        Intrinsics.checkNotNullExpressionValue(epicPriceText, "epicPriceText");
        TextView epicDiscountText = winterBattlepassLevelSetsLayoutBinding.epicDiscountText;
        Intrinsics.checkNotNullExpressionValue(epicDiscountText, "epicDiscountText");
        setupLevelSetText(textView3, epicPriceText, epicDiscountText, levelSets.get(2));
        TextView legendaryPriceText = winterBattlepassLevelSetsLayoutBinding.legendaryPriceText;
        Intrinsics.checkNotNullExpressionValue(legendaryPriceText, "legendaryPriceText");
        TextView legendaryDiscountText = winterBattlepassLevelSetsLayoutBinding.legendaryDiscountText;
        Intrinsics.checkNotNullExpressionValue(legendaryDiscountText, "legendaryDiscountText");
        setupLevelSetText(null, legendaryPriceText, legendaryDiscountText, levelSets.get(3));
    }

    public final void checkAvailableBp(long j) {
        long currentTimeMillis = (j * 1000) - System.currentTimeMillis();
        if (currentTimeMillis <= 0) {
            updateBlockTime(null);
        } else {
            startLeftTimer(currentTimeMillis);
        }
    }

    private final void bindPremiumPrice(TextView textView, View view, TextView textView2, TextView textView3, BattlePassPremiumData battlePassPremiumData) {
        if (battlePassPremiumData.getDiscount() > 0) {
            textView.setVisibility(0);
            view.setVisibility(0);
            textView2.setText(battlePassPremiumData.getDiscount() + " %");
            textView.setText(formatRubPrice(battlePassPremiumData.getPrice()));
            textView3.setText(formatRubPrice(battlePassPremiumData.getPriceWithDiscount()));
            return;
        }
        view.setVisibility(4);
        textView.setVisibility(8);
        textView3.setText(formatRubPrice(battlePassPremiumData.getPrice()));
    }

    private final void setupLevelSetText(TextView textView, TextView textView2, TextView textView3, BattlePassLevelSetData battlePassLevelSetData) {
        if (textView != null) {
            textView.setText(battlePassLevelSetData.getCount() + " lvl");
        }
        textView3.setPaintFlags(16);
        if (battlePassLevelSetData.getDiscount() > 0) {
            textView3.setVisibility(0);
            textView3.setText(formatRubPrice(battlePassLevelSetData.getPrice()));
            textView2.setText(formatRubPrice(battlePassLevelSetData.getPriceWithDiscount()));
            return;
        }
        textView3.setVisibility(4);
        textView2.setText(formatRubPrice(battlePassLevelSetData.getPrice()));
    }

    private final void startLeftTimer(long j) {
        Job launch$default;
        updateBlockTime(setLeftTime(j));
        Job job = this.blockTimerJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BattlePassPurchaseController$startLeftTimer$1(j, this, null), 3, null);
        this.blockTimerJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String setLeftTime(long j) {
        return ((j / DurationKt.MILLIS_IN_HOUR) % 24) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((j / 60000) % 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((j / 1000) % 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBlockTime(String str) {
        this.blockTimerText = str;
        refreshLevelSetButtonStates();
    }

    private final void refreshLevelSetButtonStates() {
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.binding.battlepassLevelSetsPage;
        List<TextView> listOf = CollectionsKt.listOf((Object[]) new TextView[]{winterBattlepassLevelSetsLayoutBinding.silverPriceButton, winterBattlepassLevelSetsLayoutBinding.goldPriceButton, winterBattlepassLevelSetsLayoutBinding.epicPriceButton, winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton});
        Integer num = this.currentBattlePassLevel;
        if (!this.isArizona || num == null || num.intValue() >= 10) {
            if (this.blockTimerText != null) {
                for (TextView textView : listOf) {
                    Intrinsics.checkNotNull(textView);
                    String str = this.blockTimerText;
                    if (str == null) {
                        str = "";
                    }
                    setLevelSetButtonState(textView, str, 0.5f, false);
                }
                return;
            } else if (num != null) {
                TextView silverPriceButton = winterBattlepassLevelSetsLayoutBinding.silverPriceButton;
                Intrinsics.checkNotNullExpressionValue(silverPriceButton, "silverPriceButton");
                setLevelSetButtonAvailability(silverPriceButton, num.intValue() + 10 <= 100);
                TextView goldPriceButton = winterBattlepassLevelSetsLayoutBinding.goldPriceButton;
                Intrinsics.checkNotNullExpressionValue(goldPriceButton, "goldPriceButton");
                setLevelSetButtonAvailability(goldPriceButton, num.intValue() + 10 <= 100);
                TextView epicPriceButton = winterBattlepassLevelSetsLayoutBinding.epicPriceButton;
                Intrinsics.checkNotNullExpressionValue(epicPriceButton, "epicPriceButton");
                setLevelSetButtonAvailability(epicPriceButton, num.intValue() + 20 <= 100);
                TextView legendaryPriceButton = winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton;
                Intrinsics.checkNotNullExpressionValue(legendaryPriceButton, "legendaryPriceButton");
                setLevelSetButtonAvailability(legendaryPriceButton, num.intValue() <= 100);
                return;
            } else {
                return;
            }
        }
        for (TextView textView2 : listOf) {
            Intrinsics.checkNotNull(textView2);
            setLevelSetButtonState(textView2, this.levelSetUnavailableText, 0.6f, false);
        }
    }

    private final void updateMinimumLevelLockVisuals(boolean z) {
        int i;
        int paintFlags;
        if (this.isArizona) {
            WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.binding.battlepassLevelSetsPage;
            for (TextView textView : CollectionsKt.listOf((Object[]) new TextView[]{winterBattlepassLevelSetsLayoutBinding.silverPriceText, winterBattlepassLevelSetsLayoutBinding.goldPriceText, winterBattlepassLevelSetsLayoutBinding.epicPriceText, winterBattlepassLevelSetsLayoutBinding.legendaryPriceText})) {
                if (z) {
                    paintFlags = textView.getPaintFlags() | 16;
                } else {
                    paintFlags = textView.getPaintFlags() & (-17);
                }
                textView.setPaintFlags(paintFlags);
            }
            for (ImageView imageView : CollectionsKt.listOf((Object[]) new ImageView[]{winterBattlepassLevelSetsLayoutBinding.silverSetIcon, winterBattlepassLevelSetsLayoutBinding.goldSetIcon, winterBattlepassLevelSetsLayoutBinding.epicSetIcon, winterBattlepassLevelSetsLayoutBinding.legendarySetIcon})) {
                imageView.setAlpha(z ? 0.35f : 1.0f);
            }
            Activity activity = this.targetActivity;
            if (z) {
                i = R.color.winter_bp_level_set_text_muted;
            } else {
                i = R.color.winter_bp_white;
            }
            int color = ContextCompat.getColor(activity, i);
            for (TextView textView2 : CollectionsKt.listOf((Object[]) new TextView[]{winterBattlepassLevelSetsLayoutBinding.silverLvlText, winterBattlepassLevelSetsLayoutBinding.goldLvlText, winterBattlepassLevelSetsLayoutBinding.epicLvlText, winterBattlepassLevelSetsLayoutBinding.legendaryLvlText})) {
                textView2.setTextColor(color);
            }
        }
    }

    private final void setLevelSetButtonState(TextView textView, String str, float f, boolean z) {
        textView.setText(str);
        textView.setAlpha(1.0f);
        textView.setEnabled(z);
        ViewParent parent = textView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setAlpha(f);
            view.setEnabled(z);
            return;
        }
        textView.setAlpha(f);
    }

    private final void setLevelSetButtonAvailability(TextView textView, boolean z) {
        setLevelSetButtonState(textView, z ? this.levelSetBuyText : this.levelSetUnavailableText, z ? 1.0f : 0.6f, z);
    }

    private final String formatRubPrice(int i) {
        return i + " RUB";
    }

    /* compiled from: BattlePassPurchaseController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassPurchaseController$Companion;", "", "<init>", "()V", "FRONTEND_LEVEL_SETS_MINIMUM_SIZE", "", "FRONTEND_PREMIUM_MINIMUM_SIZE", "MIN_LEVEL_TO_BUY_LEVELS", "LOCKED_ICON_ALPHA", "", "ARIZONA_PREMIUM_IMAGE_IDS", "", "", "getARIZONA_PREMIUM_IMAGE_IDS", "()Ljava/util/List;", "RODINA_PASS_TEXT", "PREMIUM_PAGE_BUY_TEXT", "PREMIUM_NAV_BUY_TEXT", "PREMIUM_PLUS_BUY_TEXT", "PREMIUM_BOUGHT_TEXT", "BUY_TEXT", "UNAVAILABLE_TEXT", "PREMIUM_COUNT_MISMATCH_MESSAGE", "LEVEL_COUNT_MISMATCH_MESSAGE", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getARIZONA_PREMIUM_IMAGE_IDS() {
            return BattlePassPurchaseController.ARIZONA_PREMIUM_IMAGE_IDS;
        }
    }
}

package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassPinkCodexHostBinding;
/* compiled from: PinkCodexBattlePassUi.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0018\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0016J \u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016J@\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/PinkCodexBattlePassUi;", "Lru/mrlargha/feature/battlepassWinter2025/BindingBattlePassUi;", "context", "Landroid/content/Context;", "hostBinding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassPinkCodexHostBinding;", "<init>", "(Landroid/content/Context;Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassPinkCodexHostBinding;)V", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/LayoutInflater;Landroid/content/Context;)V", "keepInactiveNavigationOpaque", "", "getKeepInactiveNavigationOpaque", "()Z", "keepMainNavigationSelectedOnSecondaryPages", "getKeepMainNavigationSelectedOnSecondaryPages", "actionEdgeColor", "", "actionHighlightColor", "actionBorderColor", "inactiveNavigationColor", "taskSelectedSurfaceColor", "taskUnselectedSurfaceColor", "taskTextColor", "currencyFormatter", "Ljava/text/DecimalFormat;", "prepare", "", "setChromeVisible", "visible", "setMainPageControlsVisible", "bindCompletedLevel", "completedLevel", "formatAzCoins", "", "amount", "formatExperience", "current", "maximum", "applyTaskCategoryState", "selectedCategory", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "activeTextColor", "inactiveTextColor", "applyNavigationState", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "text", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "selected", "selectedBackgroundColor", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PinkCodexBattlePassUi extends BindingBattlePassUi {
    private final int actionBorderColor;
    private final int actionEdgeColor;
    private final int actionHighlightColor;
    private final DecimalFormat currencyFormatter;
    private final WinterBattlepassPinkCodexHostBinding hostBinding;
    private final int inactiveNavigationColor;
    private final boolean keepInactiveNavigationOpaque;
    private final boolean keepMainNavigationSelectedOnSecondaryPages;
    private final int taskSelectedSurfaceColor;
    private final int taskTextColor;
    private final int taskUnselectedSurfaceColor;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PinkCodexBattlePassUi(Context context, WinterBattlepassPinkCodexHostBinding winterBattlepassPinkCodexHostBinding) {
        super(context, r2, battlepass, r4, r5, r6, new BattlePassTasksPageViews(r18, r19, rodinaTasksList, r21, r22, rodinaTasksResetTimeText, rodinaTasksRemainingTimeText, levelText, experienceText, r27, r28, rodinaTasksInfoTitle, rodinaTasksInfoDescription, rodinaTasksInfoCount, rodinaTasksInfoPercent, r33, rodinaTasksInfoProgress, rodinaTasksRewardsList, r36, rodinaTasksPremiumLockContainer, rodinaTasksBuyPremiumLockButton));
        FrameLayout root = winterBattlepassPinkCodexHostBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        FrameLayout frameLayout = root;
        WinterBattlepassLayoutBinding battlepass = winterBattlepassPinkCodexHostBinding.battlepass;
        Intrinsics.checkNotNullExpressionValue(battlepass, "battlepass");
        BattlePassItemLayouts battlePassItemLayouts = new BattlePassItemLayouts(R.layout.winter_battlepass_level_item, R.layout.winter_battlepass_pink_common_task_item, R.layout.winter_battlepass_pink_task_reward_item);
        ImageView rodinaBackButton = winterBattlepassPinkCodexHostBinding.rodinaBackButton;
        Intrinsics.checkNotNullExpressionValue(rodinaBackButton, "rodinaBackButton");
        ImageView imageView = rodinaBackButton;
        CustomCardView rodinaMainNavButton = winterBattlepassPinkCodexHostBinding.rodinaMainNavButton;
        Intrinsics.checkNotNullExpressionValue(rodinaMainNavButton, "rodinaMainNavButton");
        TextView rodinaMainNavText = winterBattlepassPinkCodexHostBinding.rodinaMainNavText;
        Intrinsics.checkNotNullExpressionValue(rodinaMainNavText, "rodinaMainNavText");
        ImageView rodinaMainNavIcon = winterBattlepassPinkCodexHostBinding.rodinaMainNavIcon;
        Intrinsics.checkNotNullExpressionValue(rodinaMainNavIcon, "rodinaMainNavIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews = new BattlePassNavigationItemViews(rodinaMainNavButton, rodinaMainNavText, rodinaMainNavIcon);
        CustomCardView rodinaTasksNavButton = winterBattlepassPinkCodexHostBinding.rodinaTasksNavButton;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksNavButton, "rodinaTasksNavButton");
        TextView rodinaTasksNavText = winterBattlepassPinkCodexHostBinding.rodinaTasksNavText;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksNavText, "rodinaTasksNavText");
        ImageView rodinaTasksNavIcon = winterBattlepassPinkCodexHostBinding.rodinaTasksNavIcon;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksNavIcon, "rodinaTasksNavIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews2 = new BattlePassNavigationItemViews(rodinaTasksNavButton, rodinaTasksNavText, rodinaTasksNavIcon);
        CustomCardView rodinaCasesNavButton = winterBattlepassPinkCodexHostBinding.rodinaCasesNavButton;
        Intrinsics.checkNotNullExpressionValue(rodinaCasesNavButton, "rodinaCasesNavButton");
        TextView rodinaCasesNavText = winterBattlepassPinkCodexHostBinding.rodinaCasesNavText;
        Intrinsics.checkNotNullExpressionValue(rodinaCasesNavText, "rodinaCasesNavText");
        ImageView rodinaCasesNavIcon = winterBattlepassPinkCodexHostBinding.rodinaCasesNavIcon;
        Intrinsics.checkNotNullExpressionValue(rodinaCasesNavIcon, "rodinaCasesNavIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews3 = new BattlePassNavigationItemViews(rodinaCasesNavButton, rodinaCasesNavText, rodinaCasesNavIcon);
        CustomCardView rodinaCurrencyContainer = winterBattlepassPinkCodexHostBinding.rodinaCurrencyContainer;
        Intrinsics.checkNotNullExpressionValue(rodinaCurrencyContainer, "rodinaCurrencyContainer");
        TextView rodinaCurrencyText = winterBattlepassPinkCodexHostBinding.rodinaCurrencyText;
        Intrinsics.checkNotNullExpressionValue(rodinaCurrencyText, "rodinaCurrencyText");
        BattlePassNavigationViews battlePassNavigationViews = new BattlePassNavigationViews(imageView, battlePassNavigationItemViews, battlePassNavigationItemViews2, battlePassNavigationItemViews3, rodinaCurrencyContainer, rodinaCurrencyText, winterBattlepassPinkCodexHostBinding.rodinaCurrencyAddButton);
        CustomCardView rodinaBuyPremiumButton = winterBattlepassPinkCodexHostBinding.rodinaBuyPremiumButton;
        Intrinsics.checkNotNullExpressionValue(rodinaBuyPremiumButton, "rodinaBuyPremiumButton");
        TextView rodinaBuyPremiumText = winterBattlepassPinkCodexHostBinding.rodinaBuyPremiumText;
        Intrinsics.checkNotNullExpressionValue(rodinaBuyPremiumText, "rodinaBuyPremiumText");
        BattlePassPremiumActionViews battlePassPremiumActionViews = new BattlePassPremiumActionViews(rodinaBuyPremiumButton, rodinaBuyPremiumText);
        TextView rodinaRemainingTimeText = winterBattlepassPinkCodexHostBinding.rodinaRemainingTimeText;
        Intrinsics.checkNotNullExpressionValue(rodinaRemainingTimeText, "rodinaRemainingTimeText");
        TextView levelText = winterBattlepassPinkCodexHostBinding.rodinaMainLevelSummary.levelText;
        Intrinsics.checkNotNullExpressionValue(levelText, "levelText");
        TextView experienceText = winterBattlepassPinkCodexHostBinding.rodinaMainLevelSummary.experienceText;
        Intrinsics.checkNotNullExpressionValue(experienceText, "experienceText");
        LinearProgressIndicator experienceProgress = winterBattlepassPinkCodexHostBinding.rodinaMainLevelSummary.experienceProgress;
        Intrinsics.checkNotNullExpressionValue(experienceProgress, "experienceProgress");
        CustomCardView buyLevelsButton = winterBattlepassPinkCodexHostBinding.rodinaMainLevelSummary.buyLevelsButton;
        Intrinsics.checkNotNullExpressionValue(buyLevelsButton, "buyLevelsButton");
        BattlePassMainPageViews battlePassMainPageViews = new BattlePassMainPageViews(battlePassPremiumActionViews, rodinaRemainingTimeText, levelText, experienceText, experienceProgress, buyLevelsButton);
        LinearLayout root2 = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        LinearLayout linearLayout = root2;
        CategoryType categoryType = CategoryType.DAILY;
        CustomCardView rodinaTasksDailyButton = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksDailyButton;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksDailyButton, "rodinaTasksDailyButton");
        TextView rodinaTasksDailyText = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksDailyText;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksDailyText, "rodinaTasksDailyText");
        CategoryType categoryType2 = CategoryType.PREMIUM;
        CustomCardView rodinaTasksPremiumButton = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksPremiumButton;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksPremiumButton, "rodinaTasksPremiumButton");
        TextView rodinaTasksPremiumText = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksPremiumText;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksPremiumText, "rodinaTasksPremiumText");
        Map mapOf = MapsKt.mapOf(TuplesKt.to(categoryType, new BattlePassTaskCategoryViews(rodinaTasksDailyButton, rodinaTasksDailyText)), TuplesKt.to(categoryType2, new BattlePassTaskCategoryViews(rodinaTasksPremiumButton, rodinaTasksPremiumText)));
        RecyclerView rodinaTasksList = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksList;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksList, "rodinaTasksList");
        LinearLayout rodinaTasksEmptyState = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksEmptyState;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksEmptyState, "rodinaTasksEmptyState");
        LinearLayout linearLayout2 = rodinaTasksEmptyState;
        FrameLayout rodinaTasksCurrentTaskContainer = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksCurrentTaskContainer;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksCurrentTaskContainer, "rodinaTasksCurrentTaskContainer");
        FrameLayout frameLayout2 = rodinaTasksCurrentTaskContainer;
        TextView rodinaTasksResetTimeText = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksResetTimeText;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksResetTimeText, "rodinaTasksResetTimeText");
        TextView rodinaTasksRemainingTimeText = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksRemainingTimeText;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksRemainingTimeText, "rodinaTasksRemainingTimeText");
        TextView levelText2 = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.tasksLevelSummary.levelText;
        Intrinsics.checkNotNullExpressionValue(levelText2, "levelText");
        TextView experienceText2 = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.tasksLevelSummary.experienceText;
        Intrinsics.checkNotNullExpressionValue(experienceText2, "experienceText");
        LinearProgressIndicator experienceProgress2 = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.tasksLevelSummary.experienceProgress;
        Intrinsics.checkNotNullExpressionValue(experienceProgress2, "experienceProgress");
        LinearProgressIndicator linearProgressIndicator = experienceProgress2;
        CustomCardView buyLevelsButton2 = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.tasksLevelSummary.buyLevelsButton;
        Intrinsics.checkNotNullExpressionValue(buyLevelsButton2, "buyLevelsButton");
        CustomCardView customCardView = buyLevelsButton2;
        TextView rodinaTasksInfoTitle = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoTitle;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoTitle, "rodinaTasksInfoTitle");
        TextView rodinaTasksInfoDescription = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoDescription;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoDescription, "rodinaTasksInfoDescription");
        TextView rodinaTasksInfoCount = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoCount;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoCount, "rodinaTasksInfoCount");
        TextView rodinaTasksInfoPercent = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoPercent;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoPercent, "rodinaTasksInfoPercent");
        LinearLayout rodinaTasksInfoDoneContainer = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoDoneContainer;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoDoneContainer, "rodinaTasksInfoDoneContainer");
        LinearLayout linearLayout3 = rodinaTasksInfoDoneContainer;
        ProgressBar rodinaTasksInfoProgress = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksInfoProgress;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksInfoProgress, "rodinaTasksInfoProgress");
        RecyclerView rodinaTasksRewardsList = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksRewardsList;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksRewardsList, "rodinaTasksRewardsList");
        CustomCardView rodinaTasksClaimButton = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksClaimButton;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksClaimButton, "rodinaTasksClaimButton");
        CustomCardView customCardView2 = rodinaTasksClaimButton;
        CustomCardView rodinaTasksPremiumLockContainer = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksPremiumLockContainer;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksPremiumLockContainer, "rodinaTasksPremiumLockContainer");
        CustomCardView rodinaTasksBuyPremiumLockButton = winterBattlepassPinkCodexHostBinding.rodinaTasksPage.rodinaTasksBuyPremiumLockButton;
        Intrinsics.checkNotNullExpressionValue(rodinaTasksBuyPremiumLockButton, "rodinaTasksBuyPremiumLockButton");
        this.hostBinding = winterBattlepassPinkCodexHostBinding;
        this.keepInactiveNavigationOpaque = true;
        this.keepMainNavigationSelectedOnSecondaryPages = true;
        this.actionEdgeColor = ContextCompat.getColor(context, R.color.winter_bp_pink_action_edge);
        this.actionHighlightColor = ContextCompat.getColor(context, R.color.winter_bp_pink_action_highlight);
        this.actionBorderColor = ContextCompat.getColor(context, R.color.winter_bp_pink_action_border);
        this.inactiveNavigationColor = ContextCompat.getColor(context, R.color.winter_bp_pink_header_surface);
        this.taskSelectedSurfaceColor = ContextCompat.getColor(context, R.color.winter_bp_pink_info_surface_opaque);
        this.taskUnselectedSurfaceColor = ContextCompat.getColor(context, R.color.winter_bp_pink_info_surface);
        this.taskTextColor = ContextCompat.getColor(context, R.color.winter_bp_pink_text_dark);
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
        decimalFormatSymbols.setGroupingSeparator('.');
        Unit unit = Unit.INSTANCE;
        this.currencyFormatter = new DecimalFormat("#,###", decimalFormatSymbols);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PinkCodexBattlePassUi(LayoutInflater inflater, Context context) {
        this(context, r2);
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        WinterBattlepassPinkCodexHostBinding inflate = WinterBattlepassPinkCodexHostBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi
    protected boolean getKeepInactiveNavigationOpaque() {
        return this.keepInactiveNavigationOpaque;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public boolean getKeepMainNavigationSelectedOnSecondaryPages() {
        return this.keepMainNavigationSelectedOnSecondaryPages;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void prepare() {
        WinterBattlepassLayoutBinding binding = getBinding();
        ImageView backButton = binding.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        backButton.setVisibility(4);
        LinearLayout mainNavMenuHeadersContainer = binding.mainNavMenuHeadersContainer;
        Intrinsics.checkNotNullExpressionValue(mainNavMenuHeadersContainer, "mainNavMenuHeadersContainer");
        mainNavMenuHeadersContainer.setVisibility(4);
        LinearLayout buyContainer = binding.buyContainer;
        Intrinsics.checkNotNullExpressionValue(buyContainer, "buyContainer");
        buyContainer.setVisibility(4);
        CustomCardView buyPremiumBtn = binding.buyPremiumBtn;
        Intrinsics.checkNotNullExpressionValue(buyPremiumBtn, "buyPremiumBtn");
        buyPremiumBtn.setVisibility(4);
        LinearLayout remainingTime = binding.remainingTime;
        Intrinsics.checkNotNullExpressionValue(remainingTime, "remainingTime");
        remainingTime.setVisibility(4);
        LinearLayout bpLevel = binding.bpLevel;
        Intrinsics.checkNotNullExpressionValue(bpLevel, "bpLevel");
        bpLevel.setVisibility(4);
        LinearLayout levelContainer = binding.levelContainer;
        Intrinsics.checkNotNullExpressionValue(levelContainer, "levelContainer");
        levelContainer.setVisibility(4);
        LinearLayout root = binding.battlepassTasksPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        this.hostBinding.rodinaCurrentPassLevelContainer.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void setChromeVisible(boolean z) {
        FrameLayout rodinaChrome = this.hostBinding.rodinaChrome;
        Intrinsics.checkNotNullExpressionValue(rodinaChrome, "rodinaChrome");
        rodinaChrome.setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void setMainPageControlsVisible(boolean z) {
        FrameLayout rodinaMainPageControls = this.hostBinding.rodinaMainPageControls;
        Intrinsics.checkNotNullExpressionValue(rodinaMainPageControls, "rodinaMainPageControls");
        rodinaMainPageControls.setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void bindCompletedLevel(int i) {
        this.hostBinding.rodinaCurrentPassLevelContainer.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public String formatAzCoins(int i) {
        String format = this.currencyFormatter.format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public String formatExperience(int i, int i2) {
        return i + " / " + i2;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void applyTaskCategoryState(CategoryType selectedCategory, int i, int i2) {
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        for (Map.Entry<CategoryType, BattlePassTaskCategoryViews> entry : getTasksPage().getCategories().entrySet()) {
            CategoryType key = entry.getKey();
            BattlePassTaskCategoryViews value = entry.getValue();
            View container = value.getContainer();
            Intrinsics.checkNotNull(container, "null cannot be cast to non-null type ru.mrlargha.commonui.utils.ui.CustomCardView");
            CustomCardView customCardView = (CustomCardView) container;
            if (key == selectedCategory) {
                customCardView.setBackground(this.taskSelectedSurfaceColor);
                customCardView.setBorder(0);
            } else if (key == CategoryType.PREMIUM) {
                int i3 = this.actionEdgeColor;
                CustomCardView.setBackground$default(customCardView, new int[]{i3, this.actionHighlightColor, i3}, 0, null, 4, null);
                customCardView.setBorder(this.actionBorderColor);
            } else {
                customCardView.setBackground(this.taskUnselectedSurfaceColor);
                customCardView.setBorder(0);
            }
            value.getText().setTextColor(this.taskTextColor);
        }
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi, ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void applyNavigationState(View container, TextView text, ImageView icon, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        CustomCardView customCardView = container instanceof CustomCardView ? (CustomCardView) container : null;
        if (customCardView == null) {
            super.applyNavigationState(container, text, icon, z, i, i2, i3);
            return;
        }
        customCardView.setAlpha(1.0f);
        if (z) {
            int i4 = this.actionEdgeColor;
            CustomCardView.setBackground$default(customCardView, new int[]{i4, this.actionHighlightColor, i4}, 0, null, 4, null);
            customCardView.setBorder(this.actionBorderColor);
        } else {
            customCardView.setBackground(this.inactiveNavigationColor);
            customCardView.setBorder(0);
        }
        int i5 = z ? i : i2;
        text.setTextColor(i5);
        icon.setImageTintList(ColorStateList.valueOf(i5));
    }
}

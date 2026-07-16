package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
/* compiled from: PurpleWavesBattlePassUi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/PurpleWavesBattlePassUi;", "Lru/mrlargha/feature/battlepassWinter2025/BindingBattlePassUi;", "context", "Landroid/content/Context;", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "<init>", "(Landroid/content/Context;Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;)V", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/LayoutInflater;Landroid/content/Context;)V", "keepInactiveNavigationOpaque", "", "getKeepInactiveNavigationOpaque", "()Z", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PurpleWavesBattlePassUi extends BindingBattlePassUi {
    private final boolean keepInactiveNavigationOpaque;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PurpleWavesBattlePassUi(Context context, WinterBattlepassLayoutBinding winterBattlepassLayoutBinding) {
        super(context, r2, winterBattlepassLayoutBinding, r4, r5, r6, new BattlePassTasksPageViews(r16, r17, commonTaskRecycleView, r19, r20, tasksTimeText, remainingTimeText, levelPassText, mainExperienceText, r25, r26, taskInfoTitle, taskInfoDesc, itemCount, progressInPercentText, r31, taskInfoProgressBar, taskItemsRewardsList, r34, taskInfoPremiumLockContainer, btnBuyPremiumLock));
        ConstraintLayout root = winterBattlepassLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ConstraintLayout constraintLayout = root;
        BattlePassItemLayouts battlePassItemLayouts = new BattlePassItemLayouts(R.layout.winter_battlepass_level_item, R.layout.winter_battlepass_common_task_item, R.layout.winter_battlepass_task_reward_item);
        ImageView backButton = winterBattlepassLayoutBinding.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        ImageView imageView = backButton;
        LinearLayout mainNavMenuButton = winterBattlepassLayoutBinding.mainNavMenuButton;
        Intrinsics.checkNotNullExpressionValue(mainNavMenuButton, "mainNavMenuButton");
        TextView mainNavMenuButtonText = winterBattlepassLayoutBinding.mainNavMenuButtonText;
        Intrinsics.checkNotNullExpressionValue(mainNavMenuButtonText, "mainNavMenuButtonText");
        ImageView mainNavMenuButtonIcon = winterBattlepassLayoutBinding.mainNavMenuButtonIcon;
        Intrinsics.checkNotNullExpressionValue(mainNavMenuButtonIcon, "mainNavMenuButtonIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews = new BattlePassNavigationItemViews(mainNavMenuButton, mainNavMenuButtonText, mainNavMenuButtonIcon);
        LinearLayout tasksNavMenuButton = winterBattlepassLayoutBinding.tasksNavMenuButton;
        Intrinsics.checkNotNullExpressionValue(tasksNavMenuButton, "tasksNavMenuButton");
        TextView tasksNavMenuButtonText = winterBattlepassLayoutBinding.tasksNavMenuButtonText;
        Intrinsics.checkNotNullExpressionValue(tasksNavMenuButtonText, "tasksNavMenuButtonText");
        ImageView tasksNavMenuButtonIcon = winterBattlepassLayoutBinding.tasksNavMenuButtonIcon;
        Intrinsics.checkNotNullExpressionValue(tasksNavMenuButtonIcon, "tasksNavMenuButtonIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews2 = new BattlePassNavigationItemViews(tasksNavMenuButton, tasksNavMenuButtonText, tasksNavMenuButtonIcon);
        LinearLayout casesNavMenuButton = winterBattlepassLayoutBinding.casesNavMenuButton;
        Intrinsics.checkNotNullExpressionValue(casesNavMenuButton, "casesNavMenuButton");
        TextView casesNavMenuButtonText = winterBattlepassLayoutBinding.casesNavMenuButtonText;
        Intrinsics.checkNotNullExpressionValue(casesNavMenuButtonText, "casesNavMenuButtonText");
        ImageView casesNavMenuButtonIcon = winterBattlepassLayoutBinding.casesNavMenuButtonIcon;
        Intrinsics.checkNotNullExpressionValue(casesNavMenuButtonIcon, "casesNavMenuButtonIcon");
        BattlePassNavigationItemViews battlePassNavigationItemViews3 = new BattlePassNavigationItemViews(casesNavMenuButton, casesNavMenuButtonText, casesNavMenuButtonIcon);
        LinearLayout buttonBuyAzCoins = winterBattlepassLayoutBinding.buttonBuyAzCoins;
        Intrinsics.checkNotNullExpressionValue(buttonBuyAzCoins, "buttonBuyAzCoins");
        TextView textBuyAzCoins = winterBattlepassLayoutBinding.textBuyAzCoins;
        Intrinsics.checkNotNullExpressionValue(textBuyAzCoins, "textBuyAzCoins");
        BattlePassNavigationViews battlePassNavigationViews = new BattlePassNavigationViews(imageView, battlePassNavigationItemViews, battlePassNavigationItemViews2, battlePassNavigationItemViews3, buttonBuyAzCoins, textBuyAzCoins, null, 64, null);
        CustomCardView buyPremiumBtn = winterBattlepassLayoutBinding.buyPremiumBtn;
        Intrinsics.checkNotNullExpressionValue(buyPremiumBtn, "buyPremiumBtn");
        TextView buyPremiumText = winterBattlepassLayoutBinding.buyPremiumText;
        Intrinsics.checkNotNullExpressionValue(buyPremiumText, "buyPremiumText");
        BattlePassPremiumActionViews battlePassPremiumActionViews = new BattlePassPremiumActionViews(buyPremiumBtn, buyPremiumText);
        TextView remainingTimeTextMain = winterBattlepassLayoutBinding.remainingTimeTextMain;
        Intrinsics.checkNotNullExpressionValue(remainingTimeTextMain, "remainingTimeTextMain");
        TextView levelPassText = winterBattlepassLayoutBinding.levelPassText;
        Intrinsics.checkNotNullExpressionValue(levelPassText, "levelPassText");
        TextView mainExperienceText = winterBattlepassLayoutBinding.mainExperienceText;
        Intrinsics.checkNotNullExpressionValue(mainExperienceText, "mainExperienceText");
        LinearProgressIndicator progressExperience = winterBattlepassLayoutBinding.progressExperience;
        Intrinsics.checkNotNullExpressionValue(progressExperience, "progressExperience");
        ImageView buyLevelsBtn = winterBattlepassLayoutBinding.buyLevelsBtn;
        Intrinsics.checkNotNullExpressionValue(buyLevelsBtn, "buyLevelsBtn");
        BattlePassMainPageViews battlePassMainPageViews = new BattlePassMainPageViews(battlePassPremiumActionViews, remainingTimeTextMain, levelPassText, mainExperienceText, progressExperience, buyLevelsBtn);
        LinearLayout root2 = winterBattlepassLayoutBinding.battlepassTasksPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        LinearLayout linearLayout = root2;
        CategoryType categoryType = CategoryType.DAILY;
        RelativeLayout buttonDailyTasks = winterBattlepassLayoutBinding.battlepassTasksPage.buttonDailyTasks;
        Intrinsics.checkNotNullExpressionValue(buttonDailyTasks, "buttonDailyTasks");
        TextView buttonDailyTasksText = winterBattlepassLayoutBinding.battlepassTasksPage.buttonDailyTasksText;
        Intrinsics.checkNotNullExpressionValue(buttonDailyTasksText, "buttonDailyTasksText");
        CategoryType categoryType2 = CategoryType.SHOP;
        RelativeLayout buttonShopTasks = winterBattlepassLayoutBinding.battlepassTasksPage.buttonShopTasks;
        Intrinsics.checkNotNullExpressionValue(buttonShopTasks, "buttonShopTasks");
        TextView buttonShopTasksText = winterBattlepassLayoutBinding.battlepassTasksPage.buttonShopTasksText;
        Intrinsics.checkNotNullExpressionValue(buttonShopTasksText, "buttonShopTasksText");
        CategoryType categoryType3 = CategoryType.LONG;
        RelativeLayout buttonLongTasks = winterBattlepassLayoutBinding.battlepassTasksPage.buttonLongTasks;
        Intrinsics.checkNotNullExpressionValue(buttonLongTasks, "buttonLongTasks");
        TextView buttonLongTasksText = winterBattlepassLayoutBinding.battlepassTasksPage.buttonLongTasksText;
        Intrinsics.checkNotNullExpressionValue(buttonLongTasksText, "buttonLongTasksText");
        CategoryType categoryType4 = CategoryType.PREMIUM;
        RelativeLayout buttonPremiumTasks = winterBattlepassLayoutBinding.battlepassTasksPage.buttonPremiumTasks;
        Intrinsics.checkNotNullExpressionValue(buttonPremiumTasks, "buttonPremiumTasks");
        TextView buttonPremiumTasksText = winterBattlepassLayoutBinding.battlepassTasksPage.buttonPremiumTasksText;
        Intrinsics.checkNotNullExpressionValue(buttonPremiumTasksText, "buttonPremiumTasksText");
        Map mapOf = MapsKt.mapOf(TuplesKt.to(categoryType, new BattlePassTaskCategoryViews(buttonDailyTasks, buttonDailyTasksText)), TuplesKt.to(categoryType2, new BattlePassTaskCategoryViews(buttonShopTasks, buttonShopTasksText)), TuplesKt.to(categoryType3, new BattlePassTaskCategoryViews(buttonLongTasks, buttonLongTasksText)), TuplesKt.to(categoryType4, new BattlePassTaskCategoryViews(buttonPremiumTasks, buttonPremiumTasksText)));
        RecyclerView commonTaskRecycleView = winterBattlepassLayoutBinding.battlepassTasksPage.commonTaskRecycleView;
        Intrinsics.checkNotNullExpressionValue(commonTaskRecycleView, "commonTaskRecycleView");
        LinearLayout taskContainerListIsEmpty = winterBattlepassLayoutBinding.battlepassTasksPage.taskContainerListIsEmpty;
        Intrinsics.checkNotNullExpressionValue(taskContainerListIsEmpty, "taskContainerListIsEmpty");
        LinearLayout linearLayout2 = taskContainerListIsEmpty;
        RelativeLayout currTaskInfoContainer = winterBattlepassLayoutBinding.battlepassTasksPage.currTaskInfoContainer;
        Intrinsics.checkNotNullExpressionValue(currTaskInfoContainer, "currTaskInfoContainer");
        RelativeLayout relativeLayout = currTaskInfoContainer;
        TextView tasksTimeText = winterBattlepassLayoutBinding.battlepassTasksPage.tasksTimeText;
        Intrinsics.checkNotNullExpressionValue(tasksTimeText, "tasksTimeText");
        TextView remainingTimeText = winterBattlepassLayoutBinding.battlepassTasksPage.remainingTimeText;
        Intrinsics.checkNotNullExpressionValue(remainingTimeText, "remainingTimeText");
        TextView levelPassText2 = winterBattlepassLayoutBinding.battlepassTasksPage.levelPassText;
        Intrinsics.checkNotNullExpressionValue(levelPassText2, "levelPassText");
        TextView mainExperienceText2 = winterBattlepassLayoutBinding.battlepassTasksPage.mainExperienceText;
        Intrinsics.checkNotNullExpressionValue(mainExperienceText2, "mainExperienceText");
        LinearProgressIndicator progressExperience2 = winterBattlepassLayoutBinding.battlepassTasksPage.progressExperience;
        Intrinsics.checkNotNullExpressionValue(progressExperience2, "progressExperience");
        LinearProgressIndicator linearProgressIndicator = progressExperience2;
        ImageView buyLevelsBtnSd = winterBattlepassLayoutBinding.battlepassTasksPage.buyLevelsBtnSd;
        Intrinsics.checkNotNullExpressionValue(buyLevelsBtnSd, "buyLevelsBtnSd");
        ImageView imageView2 = buyLevelsBtnSd;
        TextView taskInfoTitle = winterBattlepassLayoutBinding.battlepassTasksPage.taskInfoTitle;
        Intrinsics.checkNotNullExpressionValue(taskInfoTitle, "taskInfoTitle");
        TextView taskInfoDesc = winterBattlepassLayoutBinding.battlepassTasksPage.taskInfoDesc;
        Intrinsics.checkNotNullExpressionValue(taskInfoDesc, "taskInfoDesc");
        TextView itemCount = winterBattlepassLayoutBinding.battlepassTasksPage.itemCount;
        Intrinsics.checkNotNullExpressionValue(itemCount, "itemCount");
        TextView progressInPercentText = winterBattlepassLayoutBinding.battlepassTasksPage.progressInPercentText;
        Intrinsics.checkNotNullExpressionValue(progressInPercentText, "progressInPercentText");
        LinearLayout progressDoneContainer = winterBattlepassLayoutBinding.battlepassTasksPage.progressDoneContainer;
        Intrinsics.checkNotNullExpressionValue(progressDoneContainer, "progressDoneContainer");
        LinearLayout linearLayout3 = progressDoneContainer;
        ProgressBar taskInfoProgressBar = winterBattlepassLayoutBinding.battlepassTasksPage.taskInfoProgressBar;
        Intrinsics.checkNotNullExpressionValue(taskInfoProgressBar, "taskInfoProgressBar");
        RecyclerView taskItemsRewardsList = winterBattlepassLayoutBinding.battlepassTasksPage.taskItemsRewardsList;
        Intrinsics.checkNotNullExpressionValue(taskItemsRewardsList, "taskItemsRewardsList");
        RelativeLayout buttonTaskInfoGetReward = winterBattlepassLayoutBinding.battlepassTasksPage.buttonTaskInfoGetReward;
        Intrinsics.checkNotNullExpressionValue(buttonTaskInfoGetReward, "buttonTaskInfoGetReward");
        RelativeLayout relativeLayout2 = buttonTaskInfoGetReward;
        CustomCardView taskInfoPremiumLockContainer = winterBattlepassLayoutBinding.battlepassTasksPage.taskInfoPremiumLockContainer;
        Intrinsics.checkNotNullExpressionValue(taskInfoPremiumLockContainer, "taskInfoPremiumLockContainer");
        TextView btnBuyPremiumLock = winterBattlepassLayoutBinding.battlepassTasksPage.btnBuyPremiumLock;
        Intrinsics.checkNotNullExpressionValue(btnBuyPremiumLock, "btnBuyPremiumLock");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PurpleWavesBattlePassUi(LayoutInflater inflater, Context context) {
        this(context, r2);
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        WinterBattlepassLayoutBinding inflate = WinterBattlepassLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BindingBattlePassUi
    protected boolean getKeepInactiveNavigationOpaque() {
        return this.keepInactiveNavigationOpaque;
    }
}

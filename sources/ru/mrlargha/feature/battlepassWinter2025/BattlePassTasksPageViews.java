package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u0015\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003J\t\u0010G\u001a\u00020\u000eHÆ\u0003J\t\u0010H\u001a\u00020\u000eHÆ\u0003J\t\u0010I\u001a\u00020\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u0013HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000eHÆ\u0003J\t\u0010M\u001a\u00020\u000eHÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\t\u0010O\u001a\u00020\u000eHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0013HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\t\u0010U\u001a\u00020\u001fHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0003HÆ\u0001J\u0014\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010[\u001a\u00020\\HÖ\u0081\u0004J\n\u0010]\u001a\u00020^HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\u0017\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0011\u0010\u0018\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\u001d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$¨\u0006_"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;", "", "root", "Landroid/view/View;", "categories", "", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassTaskCategoryViews;", "commonTaskList", "Landroidx/recyclerview/widget/RecyclerView;", "emptyState", "loadingState", "currentTaskContainer", "resetTimeText", "Landroid/widget/TextView;", "remainingTimeText", "levelText", "experienceText", "experienceProgress", "Landroid/widget/ProgressBar;", "buyLevelsButton", "titleText", "descriptionText", "progressCountText", "progressPercentText", "progressDoneContainer", "progressBar", "rewardsList", "claimButton", "claimButtonText", "premiumLockContainer", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "buyPremiumButton", "<init>", "(Landroid/view/View;Ljava/util/Map;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ProgressBar;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/ProgressBar;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/widget/TextView;Lru/mrlargha/commonui/utils/ui/CustomCardView;Landroid/view/View;)V", "getRoot", "()Landroid/view/View;", "getCategories", "()Ljava/util/Map;", "getCommonTaskList", "()Landroidx/recyclerview/widget/RecyclerView;", "getEmptyState", "getLoadingState", "getCurrentTaskContainer", "getResetTimeText", "()Landroid/widget/TextView;", "getRemainingTimeText", "getLevelText", "getExperienceText", "getExperienceProgress", "()Landroid/widget/ProgressBar;", "getBuyLevelsButton", "getTitleText", "getDescriptionText", "getProgressCountText", "getProgressPercentText", "getProgressDoneContainer", "getProgressBar", "getRewardsList", "getClaimButton", "getClaimButtonText", "getPremiumLockContainer", "()Lru/mrlargha/commonui/utils/ui/CustomCardView;", "getBuyPremiumButton", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassTasksPageViews {
    private final View buyLevelsButton;
    private final View buyPremiumButton;
    private final Map<CategoryType, BattlePassTaskCategoryViews> categories;
    private final View claimButton;
    private final TextView claimButtonText;
    private final RecyclerView commonTaskList;
    private final View currentTaskContainer;
    private final TextView descriptionText;
    private final View emptyState;
    private final ProgressBar experienceProgress;
    private final TextView experienceText;
    private final TextView levelText;
    private final View loadingState;
    private final CustomCardView premiumLockContainer;
    private final ProgressBar progressBar;
    private final TextView progressCountText;
    private final View progressDoneContainer;
    private final TextView progressPercentText;
    private final TextView remainingTimeText;
    private final TextView resetTimeText;
    private final RecyclerView rewardsList;
    private final View root;
    private final TextView titleText;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BattlePassTasksPageViews copy$default(BattlePassTasksPageViews battlePassTasksPageViews, View view, Map map, RecyclerView recyclerView, View view2, View view3, View view4, TextView textView, TextView textView2, TextView textView3, TextView textView4, ProgressBar progressBar, View view5, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view6, ProgressBar progressBar2, RecyclerView recyclerView2, View view7, TextView textView9, CustomCardView customCardView, View view8, int i, Object obj) {
        View view9;
        CustomCardView customCardView2;
        View view10 = (i & 1) != 0 ? battlePassTasksPageViews.root : view;
        Map<CategoryType, BattlePassTaskCategoryViews> map2 = (i & 2) != 0 ? battlePassTasksPageViews.categories : map;
        RecyclerView recyclerView3 = (i & 4) != 0 ? battlePassTasksPageViews.commonTaskList : recyclerView;
        View view11 = (i & 8) != 0 ? battlePassTasksPageViews.emptyState : view2;
        View view12 = (i & 16) != 0 ? battlePassTasksPageViews.loadingState : view3;
        View view13 = (i & 32) != 0 ? battlePassTasksPageViews.currentTaskContainer : view4;
        TextView textView10 = (i & 64) != 0 ? battlePassTasksPageViews.resetTimeText : textView;
        TextView textView11 = (i & 128) != 0 ? battlePassTasksPageViews.remainingTimeText : textView2;
        TextView textView12 = (i & 256) != 0 ? battlePassTasksPageViews.levelText : textView3;
        TextView textView13 = (i & 512) != 0 ? battlePassTasksPageViews.experienceText : textView4;
        ProgressBar progressBar3 = (i & 1024) != 0 ? battlePassTasksPageViews.experienceProgress : progressBar;
        View view14 = (i & 2048) != 0 ? battlePassTasksPageViews.buyLevelsButton : view5;
        TextView textView14 = (i & 4096) != 0 ? battlePassTasksPageViews.titleText : textView5;
        TextView textView15 = (i & 8192) != 0 ? battlePassTasksPageViews.descriptionText : textView6;
        View view15 = view10;
        TextView textView16 = (i & 16384) != 0 ? battlePassTasksPageViews.progressCountText : textView7;
        TextView textView17 = (i & 32768) != 0 ? battlePassTasksPageViews.progressPercentText : textView8;
        View view16 = (i & 65536) != 0 ? battlePassTasksPageViews.progressDoneContainer : view6;
        ProgressBar progressBar4 = (i & 131072) != 0 ? battlePassTasksPageViews.progressBar : progressBar2;
        RecyclerView recyclerView4 = (i & 262144) != 0 ? battlePassTasksPageViews.rewardsList : recyclerView2;
        View view17 = (i & 524288) != 0 ? battlePassTasksPageViews.claimButton : view7;
        TextView textView18 = (i & 1048576) != 0 ? battlePassTasksPageViews.claimButtonText : textView9;
        CustomCardView customCardView3 = (i & 2097152) != 0 ? battlePassTasksPageViews.premiumLockContainer : customCardView;
        if ((i & 4194304) != 0) {
            customCardView2 = customCardView3;
            view9 = battlePassTasksPageViews.buyPremiumButton;
        } else {
            view9 = view8;
            customCardView2 = customCardView3;
        }
        return battlePassTasksPageViews.copy(view15, map2, recyclerView3, view11, view12, view13, textView10, textView11, textView12, textView13, progressBar3, view14, textView14, textView15, textView16, textView17, view16, progressBar4, recyclerView4, view17, textView18, customCardView2, view9);
    }

    public final View component1() {
        return this.root;
    }

    public final TextView component10() {
        return this.experienceText;
    }

    public final ProgressBar component11() {
        return this.experienceProgress;
    }

    public final View component12() {
        return this.buyLevelsButton;
    }

    public final TextView component13() {
        return this.titleText;
    }

    public final TextView component14() {
        return this.descriptionText;
    }

    public final TextView component15() {
        return this.progressCountText;
    }

    public final TextView component16() {
        return this.progressPercentText;
    }

    public final View component17() {
        return this.progressDoneContainer;
    }

    public final ProgressBar component18() {
        return this.progressBar;
    }

    public final RecyclerView component19() {
        return this.rewardsList;
    }

    public final Map<CategoryType, BattlePassTaskCategoryViews> component2() {
        return this.categories;
    }

    public final View component20() {
        return this.claimButton;
    }

    public final TextView component21() {
        return this.claimButtonText;
    }

    public final CustomCardView component22() {
        return this.premiumLockContainer;
    }

    public final View component23() {
        return this.buyPremiumButton;
    }

    public final RecyclerView component3() {
        return this.commonTaskList;
    }

    public final View component4() {
        return this.emptyState;
    }

    public final View component5() {
        return this.loadingState;
    }

    public final View component6() {
        return this.currentTaskContainer;
    }

    public final TextView component7() {
        return this.resetTimeText;
    }

    public final TextView component8() {
        return this.remainingTimeText;
    }

    public final TextView component9() {
        return this.levelText;
    }

    public final BattlePassTasksPageViews copy(View root, Map<CategoryType, BattlePassTaskCategoryViews> categories, RecyclerView commonTaskList, View emptyState, View loadingState, View currentTaskContainer, TextView resetTimeText, TextView remainingTimeText, TextView levelText, TextView experienceText, ProgressBar experienceProgress, View buyLevelsButton, TextView titleText, TextView descriptionText, TextView progressCountText, TextView progressPercentText, View progressDoneContainer, ProgressBar progressBar, RecyclerView rewardsList, View claimButton, TextView claimButtonText, CustomCardView premiumLockContainer, View buyPremiumButton) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(commonTaskList, "commonTaskList");
        Intrinsics.checkNotNullParameter(emptyState, "emptyState");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(currentTaskContainer, "currentTaskContainer");
        Intrinsics.checkNotNullParameter(resetTimeText, "resetTimeText");
        Intrinsics.checkNotNullParameter(remainingTimeText, "remainingTimeText");
        Intrinsics.checkNotNullParameter(levelText, "levelText");
        Intrinsics.checkNotNullParameter(experienceText, "experienceText");
        Intrinsics.checkNotNullParameter(experienceProgress, "experienceProgress");
        Intrinsics.checkNotNullParameter(buyLevelsButton, "buyLevelsButton");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        Intrinsics.checkNotNullParameter(progressCountText, "progressCountText");
        Intrinsics.checkNotNullParameter(progressPercentText, "progressPercentText");
        Intrinsics.checkNotNullParameter(progressDoneContainer, "progressDoneContainer");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(rewardsList, "rewardsList");
        Intrinsics.checkNotNullParameter(claimButton, "claimButton");
        Intrinsics.checkNotNullParameter(claimButtonText, "claimButtonText");
        Intrinsics.checkNotNullParameter(premiumLockContainer, "premiumLockContainer");
        Intrinsics.checkNotNullParameter(buyPremiumButton, "buyPremiumButton");
        return new BattlePassTasksPageViews(root, categories, commonTaskList, emptyState, loadingState, currentTaskContainer, resetTimeText, remainingTimeText, levelText, experienceText, experienceProgress, buyLevelsButton, titleText, descriptionText, progressCountText, progressPercentText, progressDoneContainer, progressBar, rewardsList, claimButton, claimButtonText, premiumLockContainer, buyPremiumButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassTasksPageViews) {
            BattlePassTasksPageViews battlePassTasksPageViews = (BattlePassTasksPageViews) obj;
            return Intrinsics.areEqual(this.root, battlePassTasksPageViews.root) && Intrinsics.areEqual(this.categories, battlePassTasksPageViews.categories) && Intrinsics.areEqual(this.commonTaskList, battlePassTasksPageViews.commonTaskList) && Intrinsics.areEqual(this.emptyState, battlePassTasksPageViews.emptyState) && Intrinsics.areEqual(this.loadingState, battlePassTasksPageViews.loadingState) && Intrinsics.areEqual(this.currentTaskContainer, battlePassTasksPageViews.currentTaskContainer) && Intrinsics.areEqual(this.resetTimeText, battlePassTasksPageViews.resetTimeText) && Intrinsics.areEqual(this.remainingTimeText, battlePassTasksPageViews.remainingTimeText) && Intrinsics.areEqual(this.levelText, battlePassTasksPageViews.levelText) && Intrinsics.areEqual(this.experienceText, battlePassTasksPageViews.experienceText) && Intrinsics.areEqual(this.experienceProgress, battlePassTasksPageViews.experienceProgress) && Intrinsics.areEqual(this.buyLevelsButton, battlePassTasksPageViews.buyLevelsButton) && Intrinsics.areEqual(this.titleText, battlePassTasksPageViews.titleText) && Intrinsics.areEqual(this.descriptionText, battlePassTasksPageViews.descriptionText) && Intrinsics.areEqual(this.progressCountText, battlePassTasksPageViews.progressCountText) && Intrinsics.areEqual(this.progressPercentText, battlePassTasksPageViews.progressPercentText) && Intrinsics.areEqual(this.progressDoneContainer, battlePassTasksPageViews.progressDoneContainer) && Intrinsics.areEqual(this.progressBar, battlePassTasksPageViews.progressBar) && Intrinsics.areEqual(this.rewardsList, battlePassTasksPageViews.rewardsList) && Intrinsics.areEqual(this.claimButton, battlePassTasksPageViews.claimButton) && Intrinsics.areEqual(this.claimButtonText, battlePassTasksPageViews.claimButtonText) && Intrinsics.areEqual(this.premiumLockContainer, battlePassTasksPageViews.premiumLockContainer) && Intrinsics.areEqual(this.buyPremiumButton, battlePassTasksPageViews.buyPremiumButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.root.hashCode() * 31) + this.categories.hashCode()) * 31) + this.commonTaskList.hashCode()) * 31) + this.emptyState.hashCode()) * 31) + this.loadingState.hashCode()) * 31) + this.currentTaskContainer.hashCode()) * 31) + this.resetTimeText.hashCode()) * 31) + this.remainingTimeText.hashCode()) * 31) + this.levelText.hashCode()) * 31) + this.experienceText.hashCode()) * 31) + this.experienceProgress.hashCode()) * 31) + this.buyLevelsButton.hashCode()) * 31) + this.titleText.hashCode()) * 31) + this.descriptionText.hashCode()) * 31) + this.progressCountText.hashCode()) * 31) + this.progressPercentText.hashCode()) * 31) + this.progressDoneContainer.hashCode()) * 31) + this.progressBar.hashCode()) * 31) + this.rewardsList.hashCode()) * 31) + this.claimButton.hashCode()) * 31) + this.claimButtonText.hashCode()) * 31) + this.premiumLockContainer.hashCode()) * 31) + this.buyPremiumButton.hashCode();
    }

    public String toString() {
        View view = this.root;
        Map<CategoryType, BattlePassTaskCategoryViews> map = this.categories;
        RecyclerView recyclerView = this.commonTaskList;
        View view2 = this.emptyState;
        View view3 = this.loadingState;
        View view4 = this.currentTaskContainer;
        TextView textView = this.resetTimeText;
        TextView textView2 = this.remainingTimeText;
        TextView textView3 = this.levelText;
        TextView textView4 = this.experienceText;
        ProgressBar progressBar = this.experienceProgress;
        View view5 = this.buyLevelsButton;
        TextView textView5 = this.titleText;
        TextView textView6 = this.descriptionText;
        TextView textView7 = this.progressCountText;
        TextView textView8 = this.progressPercentText;
        View view6 = this.progressDoneContainer;
        ProgressBar progressBar2 = this.progressBar;
        RecyclerView recyclerView2 = this.rewardsList;
        View view7 = this.claimButton;
        TextView textView9 = this.claimButtonText;
        CustomCardView customCardView = this.premiumLockContainer;
        return "BattlePassTasksPageViews(root=" + view + ", categories=" + map + ", commonTaskList=" + recyclerView + ", emptyState=" + view2 + ", loadingState=" + view3 + ", currentTaskContainer=" + view4 + ", resetTimeText=" + textView + ", remainingTimeText=" + textView2 + ", levelText=" + textView3 + ", experienceText=" + textView4 + ", experienceProgress=" + progressBar + ", buyLevelsButton=" + view5 + ", titleText=" + textView5 + ", descriptionText=" + textView6 + ", progressCountText=" + textView7 + ", progressPercentText=" + textView8 + ", progressDoneContainer=" + view6 + ", progressBar=" + progressBar2 + ", rewardsList=" + recyclerView2 + ", claimButton=" + view7 + ", claimButtonText=" + textView9 + ", premiumLockContainer=" + customCardView + ", buyPremiumButton=" + this.buyPremiumButton + ")";
    }

    public BattlePassTasksPageViews(View root, Map<CategoryType, BattlePassTaskCategoryViews> categories, RecyclerView commonTaskList, View emptyState, View loadingState, View currentTaskContainer, TextView resetTimeText, TextView remainingTimeText, TextView levelText, TextView experienceText, ProgressBar experienceProgress, View buyLevelsButton, TextView titleText, TextView descriptionText, TextView progressCountText, TextView progressPercentText, View progressDoneContainer, ProgressBar progressBar, RecyclerView rewardsList, View claimButton, TextView claimButtonText, CustomCardView premiumLockContainer, View buyPremiumButton) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(commonTaskList, "commonTaskList");
        Intrinsics.checkNotNullParameter(emptyState, "emptyState");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(currentTaskContainer, "currentTaskContainer");
        Intrinsics.checkNotNullParameter(resetTimeText, "resetTimeText");
        Intrinsics.checkNotNullParameter(remainingTimeText, "remainingTimeText");
        Intrinsics.checkNotNullParameter(levelText, "levelText");
        Intrinsics.checkNotNullParameter(experienceText, "experienceText");
        Intrinsics.checkNotNullParameter(experienceProgress, "experienceProgress");
        Intrinsics.checkNotNullParameter(buyLevelsButton, "buyLevelsButton");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        Intrinsics.checkNotNullParameter(progressCountText, "progressCountText");
        Intrinsics.checkNotNullParameter(progressPercentText, "progressPercentText");
        Intrinsics.checkNotNullParameter(progressDoneContainer, "progressDoneContainer");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(rewardsList, "rewardsList");
        Intrinsics.checkNotNullParameter(claimButton, "claimButton");
        Intrinsics.checkNotNullParameter(claimButtonText, "claimButtonText");
        Intrinsics.checkNotNullParameter(premiumLockContainer, "premiumLockContainer");
        Intrinsics.checkNotNullParameter(buyPremiumButton, "buyPremiumButton");
        this.root = root;
        this.categories = categories;
        this.commonTaskList = commonTaskList;
        this.emptyState = emptyState;
        this.loadingState = loadingState;
        this.currentTaskContainer = currentTaskContainer;
        this.resetTimeText = resetTimeText;
        this.remainingTimeText = remainingTimeText;
        this.levelText = levelText;
        this.experienceText = experienceText;
        this.experienceProgress = experienceProgress;
        this.buyLevelsButton = buyLevelsButton;
        this.titleText = titleText;
        this.descriptionText = descriptionText;
        this.progressCountText = progressCountText;
        this.progressPercentText = progressPercentText;
        this.progressDoneContainer = progressDoneContainer;
        this.progressBar = progressBar;
        this.rewardsList = rewardsList;
        this.claimButton = claimButton;
        this.claimButtonText = claimButtonText;
        this.premiumLockContainer = premiumLockContainer;
        this.buyPremiumButton = buyPremiumButton;
    }

    public final View getRoot() {
        return this.root;
    }

    public final Map<CategoryType, BattlePassTaskCategoryViews> getCategories() {
        return this.categories;
    }

    public final RecyclerView getCommonTaskList() {
        return this.commonTaskList;
    }

    public final View getEmptyState() {
        return this.emptyState;
    }

    public final View getLoadingState() {
        return this.loadingState;
    }

    public final View getCurrentTaskContainer() {
        return this.currentTaskContainer;
    }

    public final TextView getResetTimeText() {
        return this.resetTimeText;
    }

    public final TextView getRemainingTimeText() {
        return this.remainingTimeText;
    }

    public final TextView getLevelText() {
        return this.levelText;
    }

    public final TextView getExperienceText() {
        return this.experienceText;
    }

    public final ProgressBar getExperienceProgress() {
        return this.experienceProgress;
    }

    public final View getBuyLevelsButton() {
        return this.buyLevelsButton;
    }

    public final TextView getTitleText() {
        return this.titleText;
    }

    public final TextView getDescriptionText() {
        return this.descriptionText;
    }

    public final TextView getProgressCountText() {
        return this.progressCountText;
    }

    public final TextView getProgressPercentText() {
        return this.progressPercentText;
    }

    public final View getProgressDoneContainer() {
        return this.progressDoneContainer;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final RecyclerView getRewardsList() {
        return this.rewardsList;
    }

    public final View getClaimButton() {
        return this.claimButton;
    }

    public final TextView getClaimButtonText() {
        return this.claimButtonText;
    }

    public final CustomCardView getPremiumLockContainer() {
        return this.premiumLockContainer;
    }

    public final View getBuyPremiumButton() {
        return this.buyPremiumButton;
    }
}

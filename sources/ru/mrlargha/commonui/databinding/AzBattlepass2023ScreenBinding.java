package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzBattlepass2023ScreenBinding implements ViewBinding {
    public final ConstraintLayout adviceContainer;
    public final ConstraintLayout adviceMainContainer;
    public final TextView adviceText;
    public final TextView adviceTitle;
    public final ImageView arzLogo;
    public final TextView arzLogoText;
    public final TextView arzLogoTextLimited;
    public final TextView awardTitle;
    public final RecyclerView awardsRc;
    public final ImageView backButton;
    public final ConstraintLayout battlepass;
    public final ConstraintLayout battlepass2023Container;
    public final TextView battlepassPrice;
    public final TextView battlepassPriceType;
    public final ConstraintLayout buyBattlePassButton;
    public final ConstraintLayout buyBattlePassButtonContainer;
    public final TextView buyBattlePassButtonText;
    public final ConstraintLayout buyBattlePassContainer;
    public final ConstraintLayout buyBattlePassMainContainer;
    public final ConstraintLayout buyBattlePassMainImageContainer;
    public final TextView buyBattlePassMainText;
    public final ConstraintLayout buyBattlePassMiniImageContainer;
    public final TextView buyTypeBattlePass;
    public final ConstraintLayout buyTypeBattlePassContainer;
    public final Guideline centerLine;
    public final Button claimAwardToInventoryButton;
    public final ImageView clockIc;
    public final TextView clockTitle;
    public final ConstraintLayout commonBar;
    public final Guideline commonBarBottomLine;
    public final Guideline commonBarTopLine;
    public final ConstraintLayout commonTaskPage;
    public final ConstraintLayout commonTasksNavMenuButton;
    public final TextView commonTasksNavMenuButtonText;
    public final RecyclerView commonTasksRc;
    public final Guideline commonTopLine;
    public final TextView completeAll;
    public final ConstraintLayout completeAllContainer;
    public final TextView completeAllText;
    public final TextView dayTaskDescription;
    public final ConstraintLayout dayTaskErrorPage;
    public final ImageView dayTaskImage;
    public final ConstraintLayout dayTaskNavMenuButton;
    public final TextView dayTaskNavMenuButtonText;
    public final ConstraintLayout dayTaskPage;
    public final ConstraintLayout dayTaskPageMainInfo;
    public final ProgressBar dayTaskProgressBar;
    public final TextView dayTaskProgressBarCounter;
    public final TextView dayTaskProgressBarPercent;
    public final TextView dayTaskProgressBarTask;
    public final TextView dayTaskTime;
    public final TextView dayTaskTitle;
    public final TextView endOfStageText;
    public final ConstraintLayout firstPrizeContainer;
    public final ImageView firstPrizeContainerIc;
    public final TextView firstPrizeContainerText;
    public final ConstraintLayout firstReward;
    public final ImageView firstRewardIc;
    public final ConstraintLayout firstRewardIcContainer;
    public final TextView firstRewardText;
    public final Flow flow;
    public final ConstraintLayout fourthReward;
    public final ImageView fourthRewardIc;
    public final ConstraintLayout fourthRewardIcContainer;
    public final TextView fourthRewardText;
    public final ConstraintLayout getRewardButton;
    public final TextView level;
    public final ConstraintLayout levelContainer;
    public final TextView levelText;
    public final ConstraintLayout limitButton;
    public final ConstraintLayout mainNavMenuButton;
    public final TextView mainNavMenuButtonText;
    public final ConstraintLayout mainNavMenuContainer;
    public final ConstraintLayout mainNavMenuHeadersContainer;
    public final ConstraintLayout mainPage;
    public final ConstraintLayout middleBar;
    public final TextView nextTaskAvailableText;
    public final TextView notAvailableText;
    public final AppCompatImageView receivedAward;
    public final TextView rewardsTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout secondPrizeContainer;
    public final ImageView secondPrizeContainerIc;
    public final TextView secondPrizeContainerText;
    public final ConstraintLayout secondReward;
    public final ImageView secondRewardIc;
    public final ConstraintLayout secondRewardIcContainer;
    public final TextView secondRewardText;
    public final Button sellAwardButton;
    public final ConstraintLayout showAward;
    public final TextView textView14;
    public final ConstraintLayout thirdPrizeContainer;
    public final ImageView thirdPrizeContainerIc;
    public final TextView thirdPrizeContainerText;
    public final ConstraintLayout thirdReward;
    public final ImageView thirdRewardIc;
    public final ConstraintLayout thirdRewardIcContainer;
    public final TextView thirdRewardText;
    public final TextView todayComplete;
    public final ConstraintLayout todayCompleteContainer;
    public final TextView todayCompleteText;
    public final ConstraintLayout upgBar;
    public final Guideline upgBarBottomLine;
    public final Guideline upgBarCommonBottomLine;
    public final Guideline upgBarTopLine;

    private AzBattlepass2023ScreenBinding(ConstraintLayout rootView, ConstraintLayout adviceContainer, ConstraintLayout adviceMainContainer, TextView adviceText, TextView adviceTitle, ImageView arzLogo, TextView arzLogoText, TextView arzLogoTextLimited, TextView awardTitle, RecyclerView awardsRc, ImageView backButton, ConstraintLayout battlepass, ConstraintLayout battlepass2023Container, TextView battlepassPrice, TextView battlepassPriceType, ConstraintLayout buyBattlePassButton, ConstraintLayout buyBattlePassButtonContainer, TextView buyBattlePassButtonText, ConstraintLayout buyBattlePassContainer, ConstraintLayout buyBattlePassMainContainer, ConstraintLayout buyBattlePassMainImageContainer, TextView buyBattlePassMainText, ConstraintLayout buyBattlePassMiniImageContainer, TextView buyTypeBattlePass, ConstraintLayout buyTypeBattlePassContainer, Guideline centerLine, Button claimAwardToInventoryButton, ImageView clockIc, TextView clockTitle, ConstraintLayout commonBar, Guideline commonBarBottomLine, Guideline commonBarTopLine, ConstraintLayout commonTaskPage, ConstraintLayout commonTasksNavMenuButton, TextView commonTasksNavMenuButtonText, RecyclerView commonTasksRc, Guideline commonTopLine, TextView completeAll, ConstraintLayout completeAllContainer, TextView completeAllText, TextView dayTaskDescription, ConstraintLayout dayTaskErrorPage, ImageView dayTaskImage, ConstraintLayout dayTaskNavMenuButton, TextView dayTaskNavMenuButtonText, ConstraintLayout dayTaskPage, ConstraintLayout dayTaskPageMainInfo, ProgressBar dayTaskProgressBar, TextView dayTaskProgressBarCounter, TextView dayTaskProgressBarPercent, TextView dayTaskProgressBarTask, TextView dayTaskTime, TextView dayTaskTitle, TextView endOfStageText, ConstraintLayout firstPrizeContainer, ImageView firstPrizeContainerIc, TextView firstPrizeContainerText, ConstraintLayout firstReward, ImageView firstRewardIc, ConstraintLayout firstRewardIcContainer, TextView firstRewardText, Flow flow, ConstraintLayout fourthReward, ImageView fourthRewardIc, ConstraintLayout fourthRewardIcContainer, TextView fourthRewardText, ConstraintLayout getRewardButton, TextView level, ConstraintLayout levelContainer, TextView levelText, ConstraintLayout limitButton, ConstraintLayout mainNavMenuButton, TextView mainNavMenuButtonText, ConstraintLayout mainNavMenuContainer, ConstraintLayout mainNavMenuHeadersContainer, ConstraintLayout mainPage, ConstraintLayout middleBar, TextView nextTaskAvailableText, TextView notAvailableText, AppCompatImageView receivedAward, TextView rewardsTitle, ConstraintLayout secondPrizeContainer, ImageView secondPrizeContainerIc, TextView secondPrizeContainerText, ConstraintLayout secondReward, ImageView secondRewardIc, ConstraintLayout secondRewardIcContainer, TextView secondRewardText, Button sellAwardButton, ConstraintLayout showAward, TextView textView14, ConstraintLayout thirdPrizeContainer, ImageView thirdPrizeContainerIc, TextView thirdPrizeContainerText, ConstraintLayout thirdReward, ImageView thirdRewardIc, ConstraintLayout thirdRewardIcContainer, TextView thirdRewardText, TextView todayComplete, ConstraintLayout todayCompleteContainer, TextView todayCompleteText, ConstraintLayout upgBar, Guideline upgBarBottomLine, Guideline upgBarCommonBottomLine, Guideline upgBarTopLine) {
        this.rootView = rootView;
        this.adviceContainer = adviceContainer;
        this.adviceMainContainer = adviceMainContainer;
        this.adviceText = adviceText;
        this.adviceTitle = adviceTitle;
        this.arzLogo = arzLogo;
        this.arzLogoText = arzLogoText;
        this.arzLogoTextLimited = arzLogoTextLimited;
        this.awardTitle = awardTitle;
        this.awardsRc = awardsRc;
        this.backButton = backButton;
        this.battlepass = battlepass;
        this.battlepass2023Container = battlepass2023Container;
        this.battlepassPrice = battlepassPrice;
        this.battlepassPriceType = battlepassPriceType;
        this.buyBattlePassButton = buyBattlePassButton;
        this.buyBattlePassButtonContainer = buyBattlePassButtonContainer;
        this.buyBattlePassButtonText = buyBattlePassButtonText;
        this.buyBattlePassContainer = buyBattlePassContainer;
        this.buyBattlePassMainContainer = buyBattlePassMainContainer;
        this.buyBattlePassMainImageContainer = buyBattlePassMainImageContainer;
        this.buyBattlePassMainText = buyBattlePassMainText;
        this.buyBattlePassMiniImageContainer = buyBattlePassMiniImageContainer;
        this.buyTypeBattlePass = buyTypeBattlePass;
        this.buyTypeBattlePassContainer = buyTypeBattlePassContainer;
        this.centerLine = centerLine;
        this.claimAwardToInventoryButton = claimAwardToInventoryButton;
        this.clockIc = clockIc;
        this.clockTitle = clockTitle;
        this.commonBar = commonBar;
        this.commonBarBottomLine = commonBarBottomLine;
        this.commonBarTopLine = commonBarTopLine;
        this.commonTaskPage = commonTaskPage;
        this.commonTasksNavMenuButton = commonTasksNavMenuButton;
        this.commonTasksNavMenuButtonText = commonTasksNavMenuButtonText;
        this.commonTasksRc = commonTasksRc;
        this.commonTopLine = commonTopLine;
        this.completeAll = completeAll;
        this.completeAllContainer = completeAllContainer;
        this.completeAllText = completeAllText;
        this.dayTaskDescription = dayTaskDescription;
        this.dayTaskErrorPage = dayTaskErrorPage;
        this.dayTaskImage = dayTaskImage;
        this.dayTaskNavMenuButton = dayTaskNavMenuButton;
        this.dayTaskNavMenuButtonText = dayTaskNavMenuButtonText;
        this.dayTaskPage = dayTaskPage;
        this.dayTaskPageMainInfo = dayTaskPageMainInfo;
        this.dayTaskProgressBar = dayTaskProgressBar;
        this.dayTaskProgressBarCounter = dayTaskProgressBarCounter;
        this.dayTaskProgressBarPercent = dayTaskProgressBarPercent;
        this.dayTaskProgressBarTask = dayTaskProgressBarTask;
        this.dayTaskTime = dayTaskTime;
        this.dayTaskTitle = dayTaskTitle;
        this.endOfStageText = endOfStageText;
        this.firstPrizeContainer = firstPrizeContainer;
        this.firstPrizeContainerIc = firstPrizeContainerIc;
        this.firstPrizeContainerText = firstPrizeContainerText;
        this.firstReward = firstReward;
        this.firstRewardIc = firstRewardIc;
        this.firstRewardIcContainer = firstRewardIcContainer;
        this.firstRewardText = firstRewardText;
        this.flow = flow;
        this.fourthReward = fourthReward;
        this.fourthRewardIc = fourthRewardIc;
        this.fourthRewardIcContainer = fourthRewardIcContainer;
        this.fourthRewardText = fourthRewardText;
        this.getRewardButton = getRewardButton;
        this.level = level;
        this.levelContainer = levelContainer;
        this.levelText = levelText;
        this.limitButton = limitButton;
        this.mainNavMenuButton = mainNavMenuButton;
        this.mainNavMenuButtonText = mainNavMenuButtonText;
        this.mainNavMenuContainer = mainNavMenuContainer;
        this.mainNavMenuHeadersContainer = mainNavMenuHeadersContainer;
        this.mainPage = mainPage;
        this.middleBar = middleBar;
        this.nextTaskAvailableText = nextTaskAvailableText;
        this.notAvailableText = notAvailableText;
        this.receivedAward = receivedAward;
        this.rewardsTitle = rewardsTitle;
        this.secondPrizeContainer = secondPrizeContainer;
        this.secondPrizeContainerIc = secondPrizeContainerIc;
        this.secondPrizeContainerText = secondPrizeContainerText;
        this.secondReward = secondReward;
        this.secondRewardIc = secondRewardIc;
        this.secondRewardIcContainer = secondRewardIcContainer;
        this.secondRewardText = secondRewardText;
        this.sellAwardButton = sellAwardButton;
        this.showAward = showAward;
        this.textView14 = textView14;
        this.thirdPrizeContainer = thirdPrizeContainer;
        this.thirdPrizeContainerIc = thirdPrizeContainerIc;
        this.thirdPrizeContainerText = thirdPrizeContainerText;
        this.thirdReward = thirdReward;
        this.thirdRewardIc = thirdRewardIc;
        this.thirdRewardIcContainer = thirdRewardIcContainer;
        this.thirdRewardText = thirdRewardText;
        this.todayComplete = todayComplete;
        this.todayCompleteContainer = todayCompleteContainer;
        this.todayCompleteText = todayCompleteText;
        this.upgBar = upgBar;
        this.upgBarBottomLine = upgBarBottomLine;
        this.upgBarCommonBottomLine = upgBarCommonBottomLine;
        this.upgBarTopLine = upgBarTopLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzBattlepass2023ScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzBattlepass2023ScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_battlepass_2023_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzBattlepass2023ScreenBinding bind(View rootView) {
        int i = R.id.advice_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.advice_main_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.advice_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.advice_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.arz_logo;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.arz_logo_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.arz_logo_text_limited;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.award_title;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.awards_rc;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.back_button;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView2 != null) {
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                                i = R.id.battlepass_2023_container;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.battlepass_price;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null) {
                                                        i = R.id.battlepass_price_type;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView7 != null) {
                                                            i = R.id.buy_battle_pass_button;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.buy_battle_pass_button_container;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.buy_battle_pass_button_text;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.buy_battle_pass_container;
                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (constraintLayout7 != null) {
                                                                            i = R.id.buy_battle_pass_main_container;
                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (constraintLayout8 != null) {
                                                                                i = R.id.buy_battle_pass_main_image_container;
                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout9 != null) {
                                                                                    i = R.id.buy_battle_pass_main_text;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.buy_battle_pass_mini_image_container;
                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (constraintLayout10 != null) {
                                                                                            i = R.id.buy_type_battle_pass;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.buy_type_battle_pass_container;
                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (constraintLayout11 != null) {
                                                                                                    i = R.id.center_line;
                                                                                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (guideline != null) {
                                                                                                        i = R.id.claim_award_to_inventory_button;
                                                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (button != null) {
                                                                                                            i = R.id.clock_ic;
                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (imageView3 != null) {
                                                                                                                i = R.id.clock_title;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (textView11 != null) {
                                                                                                                    i = R.id.common_bar;
                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                        i = R.id.common_bar_bottom_line;
                                                                                                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (guideline2 != null) {
                                                                                                                            i = R.id.common_bar_top_line;
                                                                                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (guideline3 != null) {
                                                                                                                                i = R.id.common_task_page;
                                                                                                                                ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (constraintLayout13 != null) {
                                                                                                                                    i = R.id.common_tasks_nav_menu_button;
                                                                                                                                    ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (constraintLayout14 != null) {
                                                                                                                                        i = R.id.common_tasks_nav_menu_button_text;
                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i = R.id.common_tasks_rc;
                                                                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                i = R.id.common_top_line;
                                                                                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (guideline4 != null) {
                                                                                                                                                    i = R.id.complete_all;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i = R.id.complete_all_container;
                                                                                                                                                        ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (constraintLayout15 != null) {
                                                                                                                                                            i = R.id.complete_all_text;
                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                i = R.id.day_task_description;
                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                    i = R.id.day_task_error_page;
                                                                                                                                                                    ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (constraintLayout16 != null) {
                                                                                                                                                                        i = R.id.day_task_image;
                                                                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (imageView4 != null) {
                                                                                                                                                                            i = R.id.day_task_nav_menu_button;
                                                                                                                                                                            ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (constraintLayout17 != null) {
                                                                                                                                                                                i = R.id.day_task_nav_menu_button_text;
                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                    i = R.id.day_task_page;
                                                                                                                                                                                    ConstraintLayout constraintLayout18 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                    if (constraintLayout18 != null) {
                                                                                                                                                                                        i = R.id.day_task_page_main_info;
                                                                                                                                                                                        ConstraintLayout constraintLayout19 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                        if (constraintLayout19 != null) {
                                                                                                                                                                                            i = R.id.day_task_progress_bar;
                                                                                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                            if (progressBar != null) {
                                                                                                                                                                                                i = R.id.day_task_progress_bar_counter;
                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                    i = R.id.day_task_progress_bar_percent;
                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                        i = R.id.day_task_progress_bar_task;
                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                            i = R.id.day_task_time;
                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                i = R.id.day_task_title;
                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                    i = R.id.end_of_stage_text;
                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                        i = R.id.first_prize_container;
                                                                                                                                                                                                                        ConstraintLayout constraintLayout20 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                        if (constraintLayout20 != null) {
                                                                                                                                                                                                                            i = R.id.first_prize_container_ic;
                                                                                                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                                                                                i = R.id.first_prize_container_text;
                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                    i = R.id.first_reward;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayout21 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                    if (constraintLayout21 != null) {
                                                                                                                                                                                                                                        i = R.id.first_reward_ic;
                                                                                                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                                                                                                            i = R.id.first_reward_ic_container;
                                                                                                                                                                                                                                            ConstraintLayout constraintLayout22 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                            if (constraintLayout22 != null) {
                                                                                                                                                                                                                                                i = R.id.first_reward_text;
                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                    i = R.id.flow;
                                                                                                                                                                                                                                                    Flow flow = (Flow) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                    if (flow != null) {
                                                                                                                                                                                                                                                        i = R.id.fourth_reward;
                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout23 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                        if (constraintLayout23 != null) {
                                                                                                                                                                                                                                                            i = R.id.fourth_reward_ic;
                                                                                                                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                                                                                                                i = R.id.fourth_reward_ic_container;
                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout24 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                if (constraintLayout24 != null) {
                                                                                                                                                                                                                                                                    i = R.id.fourth_reward_text;
                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                        i = R.id.get_reward_button;
                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout25 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                        if (constraintLayout25 != null) {
                                                                                                                                                                                                                                                                            i = R.id.level;
                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                i = R.id.level_container;
                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout26 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                if (constraintLayout26 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.level_text;
                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.limit_button;
                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout27 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                        if (constraintLayout27 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.main_nav_menu_button;
                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout28 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                            if (constraintLayout28 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.main_nav_menu_button_text;
                                                                                                                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.main_nav_menu_container;
                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout29 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                    if (constraintLayout29 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.main_nav_menu_headers_container;
                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout30 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                        if (constraintLayout30 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.main_page;
                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout31 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                            if (constraintLayout31 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.middle_bar;
                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout32 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                if (constraintLayout32 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.next_task_available_text;
                                                                                                                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.not_available_text;
                                                                                                                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.receivedAward;
                                                                                                                                                                                                                                                                                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                            if (appCompatImageView != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.rewards_title;
                                                                                                                                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.second_prize_container;
                                                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout33 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                    if (constraintLayout33 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.second_prize_container_ic;
                                                                                                                                                                                                                                                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                        if (imageView8 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.second_prize_container_text;
                                                                                                                                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.second_reward;
                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout34 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                if (constraintLayout34 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.second_reward_ic;
                                                                                                                                                                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.second_reward_ic_container;
                                                                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout35 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                        if (constraintLayout35 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.second_reward_text;
                                                                                                                                                                                                                                                                                                                                                            TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                            if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.sell_award_button;
                                                                                                                                                                                                                                                                                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                if (button2 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.show_award;
                                                                                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout36 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                    if (constraintLayout36 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.textView14;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                        if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.third_prize_container;
                                                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout37 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                            if (constraintLayout37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.third_prize_container_ic;
                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.third_prize_container_text;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.third_reward;
                                                                                                                                                                                                                                                                                                                                                                                        ConstraintLayout constraintLayout38 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                        if (constraintLayout38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.third_reward_ic;
                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                            if (imageView11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.third_reward_ic_container;
                                                                                                                                                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout39 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                if (constraintLayout39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.third_reward_text;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.today_complete;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.today_complete_container;
                                                                                                                                                                                                                                                                                                                                                                                                            ConstraintLayout constraintLayout40 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                            if (constraintLayout40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.today_complete_text;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.upg_bar;
                                                                                                                                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout41 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (constraintLayout41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.upg_bar_bottom_line;
                                                                                                                                                                                                                                                                                                                                                                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (guideline5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.upg_bar_common_bottom_line;
                                                                                                                                                                                                                                                                                                                                                                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (guideline6 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.upg_bar_top_line;
                                                                                                                                                                                                                                                                                                                                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (guideline7 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    return new AzBattlepass2023ScreenBinding(constraintLayout3, constraintLayout, constraintLayout2, textView, textView2, imageView, textView3, textView4, textView5, recyclerView, imageView2, constraintLayout3, constraintLayout4, textView6, textView7, constraintLayout5, constraintLayout6, textView8, constraintLayout7, constraintLayout8, constraintLayout9, textView9, constraintLayout10, textView10, constraintLayout11, guideline, button, imageView3, textView11, constraintLayout12, guideline2, guideline3, constraintLayout13, constraintLayout14, textView12, recyclerView2, guideline4, textView13, constraintLayout15, textView14, textView15, constraintLayout16, imageView4, constraintLayout17, textView16, constraintLayout18, constraintLayout19, progressBar, textView17, textView18, textView19, textView20, textView21, textView22, constraintLayout20, imageView5, textView23, constraintLayout21, imageView6, constraintLayout22, textView24, flow, constraintLayout23, imageView7, constraintLayout24, textView25, constraintLayout25, textView26, constraintLayout26, textView27, constraintLayout27, constraintLayout28, textView28, constraintLayout29, constraintLayout30, constraintLayout31, constraintLayout32, textView29, textView30, appCompatImageView, textView31, constraintLayout33, imageView8, textView32, constraintLayout34, imageView9, constraintLayout35, textView33, button2, constraintLayout36, textView34, constraintLayout37, imageView10, textView35, constraintLayout38, imageView11, constraintLayout39, textView36, textView37, constraintLayout40, textView38, constraintLayout41, guideline5, guideline6, guideline7);
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}

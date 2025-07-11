package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassLayoutBinding implements ViewBinding {
    public final ImageView backButton;
    public final ImageView backWelcomeButton;
    public final ConstraintLayout battlePassMainPageContainer;
    public final ConstraintLayout battlepass;
    public final ConstraintLayout battlepass2023Container;
    public final ImageView battlepassContainerBg;
    public final WinterBattlepassConvertBattlecoinsLayoutBinding battlepassConvertBattlecoinsPage;
    public final WinterBattlepassBuyPremiumLayoutBinding battlepassLevelPremiumPage;
    public final WinterBattlepassLevelSetsLayoutBinding battlepassLevelSetsPage;
    public final WinterBattlepassLevelSetsLayoutMaximumBinding battlepassLevelSetsPageMaximum;
    public final WinterBattlepassRouletteLayoutBinding battlepassRoulettePage;
    public final WinterBattlepassRouletteMainScreenBinding battlepassRouletteView;
    public final WinterBattlepassShopLayoutBinding battlepassShopPage;
    public final WinterBattlepassTasksLayoutBinding battlepassTasksPage;
    public final ImageView battlepassWelcomeContainerBg;
    public final Button btnGetInfoWinterWelcome;
    public final ImageView btnPremium;
    public final ImageView btnUsually;
    public final LinearLayout buttonBuyAzCoins;
    public final LinearLayout buttonBuyBattlePoints;
    public final LinearLayout buyContainer;
    public final ImageView buyLevelsBtn;
    public final LinearLayout buyPremiumBtn;
    public final TextView buyPremiumText;
    public final View clickBlocker;
    public final TextView daysCount;
    public final LinearLayout donateNavMenuButton;
    public final ImageView donateNavMenuButtonIcon;
    public final TextView donateNavMenuButtonText;
    public final LinearLayout infoNavMenuButton;
    public final ImageView infoNavMenuButtonIcon;
    public final TextView infoNavMenuButtonText;
    public final LinearLayout levelContainer;
    public final RecyclerView levelItemsRc;
    public final TextView levelPassText;
    public final ImageView logo;
    public final ImageView logoWelcome;
    public final TextView mainExperienceText;
    public final LinearLayout mainNavMenuButton;
    public final ImageView mainNavMenuButtonIcon;
    public final TextView mainNavMenuButtonText;
    public final LinearLayout mainNavMenuContainer;
    public final LinearLayout mainNavMenuHeadersContainer;
    public final TextView mainPageTitle;
    public final LinearProgressIndicator progressExperience;
    public final LinearLayout remainingTime;
    public final TextView remainingTimeTextMain;
    private final ConstraintLayout rootView;
    public final LinearLayout rouletteNavMenuButton;
    public final ImageView rouletteNavMenuButtonIcon;
    public final TextView rouletteNavMenuButtonText;
    public final LinearLayout shopNavMenuButton;
    public final ImageView shopNavMenuButtonIcon;
    public final TextView shopNavMenuButtonText;
    public final LinearLayout tasksNavMenuButton;
    public final ImageView tasksNavMenuButtonIcon;
    public final TextView tasksNavMenuButtonText;
    public final TextView textBuyAzCoins;
    public final TextView textBuyBattlePoints;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice1;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice2;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice3;
    public final ConstraintLayout winterBattlepassWelcome;

    private WinterBattlepassLayoutBinding(ConstraintLayout rootView, ImageView backButton, ImageView backWelcomeButton, ConstraintLayout battlePassMainPageContainer, ConstraintLayout battlepass, ConstraintLayout battlepass2023Container, ImageView battlepassContainerBg, WinterBattlepassConvertBattlecoinsLayoutBinding battlepassConvertBattlecoinsPage, WinterBattlepassBuyPremiumLayoutBinding battlepassLevelPremiumPage, WinterBattlepassLevelSetsLayoutBinding battlepassLevelSetsPage, WinterBattlepassLevelSetsLayoutMaximumBinding battlepassLevelSetsPageMaximum, WinterBattlepassRouletteLayoutBinding battlepassRoulettePage, WinterBattlepassRouletteMainScreenBinding battlepassRouletteView, WinterBattlepassShopLayoutBinding battlepassShopPage, WinterBattlepassTasksLayoutBinding battlepassTasksPage, ImageView battlepassWelcomeContainerBg, Button btnGetInfoWinterWelcome, ImageView btnPremium, ImageView btnUsually, LinearLayout buttonBuyAzCoins, LinearLayout buttonBuyBattlePoints, LinearLayout buyContainer, ImageView buyLevelsBtn, LinearLayout buyPremiumBtn, TextView buyPremiumText, View clickBlocker, TextView daysCount, LinearLayout donateNavMenuButton, ImageView donateNavMenuButtonIcon, TextView donateNavMenuButtonText, LinearLayout infoNavMenuButton, ImageView infoNavMenuButtonIcon, TextView infoNavMenuButtonText, LinearLayout levelContainer, RecyclerView levelItemsRc, TextView levelPassText, ImageView logo, ImageView logoWelcome, TextView mainExperienceText, LinearLayout mainNavMenuButton, ImageView mainNavMenuButtonIcon, TextView mainNavMenuButtonText, LinearLayout mainNavMenuContainer, LinearLayout mainNavMenuHeadersContainer, TextView mainPageTitle, LinearProgressIndicator progressExperience, LinearLayout remainingTime, TextView remainingTimeTextMain, LinearLayout rouletteNavMenuButton, ImageView rouletteNavMenuButtonIcon, TextView rouletteNavMenuButtonText, LinearLayout shopNavMenuButton, ImageView shopNavMenuButtonIcon, TextView shopNavMenuButtonText, LinearLayout tasksNavMenuButton, ImageView tasksNavMenuButtonIcon, TextView tasksNavMenuButtonText, TextView textBuyAzCoins, TextView textBuyBattlePoints, WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice1, WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice2, WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice3, ConstraintLayout winterBattlepassWelcome) {
        this.rootView = rootView;
        this.backButton = backButton;
        this.backWelcomeButton = backWelcomeButton;
        this.battlePassMainPageContainer = battlePassMainPageContainer;
        this.battlepass = battlepass;
        this.battlepass2023Container = battlepass2023Container;
        this.battlepassContainerBg = battlepassContainerBg;
        this.battlepassConvertBattlecoinsPage = battlepassConvertBattlecoinsPage;
        this.battlepassLevelPremiumPage = battlepassLevelPremiumPage;
        this.battlepassLevelSetsPage = battlepassLevelSetsPage;
        this.battlepassLevelSetsPageMaximum = battlepassLevelSetsPageMaximum;
        this.battlepassRoulettePage = battlepassRoulettePage;
        this.battlepassRouletteView = battlepassRouletteView;
        this.battlepassShopPage = battlepassShopPage;
        this.battlepassTasksPage = battlepassTasksPage;
        this.battlepassWelcomeContainerBg = battlepassWelcomeContainerBg;
        this.btnGetInfoWinterWelcome = btnGetInfoWinterWelcome;
        this.btnPremium = btnPremium;
        this.btnUsually = btnUsually;
        this.buttonBuyAzCoins = buttonBuyAzCoins;
        this.buttonBuyBattlePoints = buttonBuyBattlePoints;
        this.buyContainer = buyContainer;
        this.buyLevelsBtn = buyLevelsBtn;
        this.buyPremiumBtn = buyPremiumBtn;
        this.buyPremiumText = buyPremiumText;
        this.clickBlocker = clickBlocker;
        this.daysCount = daysCount;
        this.donateNavMenuButton = donateNavMenuButton;
        this.donateNavMenuButtonIcon = donateNavMenuButtonIcon;
        this.donateNavMenuButtonText = donateNavMenuButtonText;
        this.infoNavMenuButton = infoNavMenuButton;
        this.infoNavMenuButtonIcon = infoNavMenuButtonIcon;
        this.infoNavMenuButtonText = infoNavMenuButtonText;
        this.levelContainer = levelContainer;
        this.levelItemsRc = levelItemsRc;
        this.levelPassText = levelPassText;
        this.logo = logo;
        this.logoWelcome = logoWelcome;
        this.mainExperienceText = mainExperienceText;
        this.mainNavMenuButton = mainNavMenuButton;
        this.mainNavMenuButtonIcon = mainNavMenuButtonIcon;
        this.mainNavMenuButtonText = mainNavMenuButtonText;
        this.mainNavMenuContainer = mainNavMenuContainer;
        this.mainNavMenuHeadersContainer = mainNavMenuHeadersContainer;
        this.mainPageTitle = mainPageTitle;
        this.progressExperience = progressExperience;
        this.remainingTime = remainingTime;
        this.remainingTimeTextMain = remainingTimeTextMain;
        this.rouletteNavMenuButton = rouletteNavMenuButton;
        this.rouletteNavMenuButtonIcon = rouletteNavMenuButtonIcon;
        this.rouletteNavMenuButtonText = rouletteNavMenuButtonText;
        this.shopNavMenuButton = shopNavMenuButton;
        this.shopNavMenuButtonIcon = shopNavMenuButtonIcon;
        this.shopNavMenuButtonText = shopNavMenuButtonText;
        this.tasksNavMenuButton = tasksNavMenuButton;
        this.tasksNavMenuButtonIcon = tasksNavMenuButtonIcon;
        this.tasksNavMenuButtonText = tasksNavMenuButtonText;
        this.textBuyAzCoins = textBuyAzCoins;
        this.textBuyBattlePoints = textBuyBattlePoints;
        this.welcomePrice1 = welcomePrice1;
        this.welcomePrice2 = welcomePrice2;
        this.welcomePrice3 = welcomePrice3;
        this.winterBattlepassWelcome = winterBattlepassWelcome;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLayoutBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.back_welcome_button;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.battle_pass_main_page_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                    i = R.id.battlepass_2023_container;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.battlepass_container_bg;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.battlepass_convert_battlecoins_page))) != null) {
                            WinterBattlepassConvertBattlecoinsLayoutBinding bind = WinterBattlepassConvertBattlecoinsLayoutBinding.bind(findChildViewById);
                            i = R.id.battlepass_level_premium_page;
                            View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById4 != null) {
                                WinterBattlepassBuyPremiumLayoutBinding bind2 = WinterBattlepassBuyPremiumLayoutBinding.bind(findChildViewById4);
                                i = R.id.battlepass_level_sets_page;
                                View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById5 != null) {
                                    WinterBattlepassLevelSetsLayoutBinding bind3 = WinterBattlepassLevelSetsLayoutBinding.bind(findChildViewById5);
                                    i = R.id.battlepass_level_sets_page_maximum;
                                    View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById6 != null) {
                                        WinterBattlepassLevelSetsLayoutMaximumBinding bind4 = WinterBattlepassLevelSetsLayoutMaximumBinding.bind(findChildViewById6);
                                        i = R.id.battlepass_roulette_page;
                                        View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById7 != null) {
                                            WinterBattlepassRouletteLayoutBinding bind5 = WinterBattlepassRouletteLayoutBinding.bind(findChildViewById7);
                                            i = R.id.battlepass_roulette_view;
                                            View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                            if (findChildViewById8 != null) {
                                                WinterBattlepassRouletteMainScreenBinding bind6 = WinterBattlepassRouletteMainScreenBinding.bind(findChildViewById8);
                                                i = R.id.battlepass_shop_page;
                                                View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                                if (findChildViewById9 != null) {
                                                    WinterBattlepassShopLayoutBinding bind7 = WinterBattlepassShopLayoutBinding.bind(findChildViewById9);
                                                    i = R.id.battlepass_tasks_page;
                                                    View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById10 != null) {
                                                        WinterBattlepassTasksLayoutBinding bind8 = WinterBattlepassTasksLayoutBinding.bind(findChildViewById10);
                                                        i = R.id.battlepass_welcome_container_bg;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.btnGetInfo_winter_welcome;
                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                                                            if (button != null) {
                                                                i = R.id.btn_premium;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView5 != null) {
                                                                    i = R.id.btn_usually;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.button_buy_az_coins;
                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout != null) {
                                                                            i = R.id.button_buy_battle_points;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.buy_container;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (linearLayout3 != null) {
                                                                                    i = R.id.buy_levels_btn;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView7 != null) {
                                                                                        i = R.id.buy_premium_btn;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (linearLayout4 != null) {
                                                                                            i = R.id.buy_premium_text;
                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.clickBlocker))) != null) {
                                                                                                i = R.id.daysCount;
                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView2 != null) {
                                                                                                    i = R.id.donate_nav_menu_button;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        i = R.id.donate_nav_menu_button_icon;
                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (imageView8 != null) {
                                                                                                            i = R.id.donate_nav_menu_button_text;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.info_nav_menu_button;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (linearLayout6 != null) {
                                                                                                                    i = R.id.info_nav_menu_button_icon;
                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (imageView9 != null) {
                                                                                                                        i = R.id.info_nav_menu_button_text;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (textView4 != null) {
                                                                                                                            i = R.id.level_container;
                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                i = R.id.level_items_rc;
                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (recyclerView != null) {
                                                                                                                                    i = R.id.level_pass_text;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.logo;
                                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (imageView10 != null) {
                                                                                                                                            i = R.id.logo_welcome;
                                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (imageView11 != null) {
                                                                                                                                                i = R.id.main_experience_text;
                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    i = R.id.main_nav_menu_button;
                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                        i = R.id.main_nav_menu_button_icon;
                                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (imageView12 != null) {
                                                                                                                                                            i = R.id.main_nav_menu_button_text;
                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                i = R.id.main_nav_menu_container;
                                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                                    i = R.id.main_nav_menu_headers_container;
                                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                                        i = R.id.main_page_title;
                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                            i = R.id.progress_experience;
                                                                                                                                                                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (linearProgressIndicator != null) {
                                                                                                                                                                                i = R.id.remaining_time;
                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                    i = R.id.remaining_time_text_main;
                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                        i = R.id.roulette_nav_menu_button;
                                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                                            i = R.id.roulette_nav_menu_button_icon;
                                                                                                                                                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                            if (imageView13 != null) {
                                                                                                                                                                                                i = R.id.roulette_nav_menu_button_text;
                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                    i = R.id.shop_nav_menu_button;
                                                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                                                                        i = R.id.shop_nav_menu_button_icon;
                                                                                                                                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (imageView14 != null) {
                                                                                                                                                                                                            i = R.id.shop_nav_menu_button_text;
                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                i = R.id.tasks_nav_menu_button;
                                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                                    i = R.id.tasks_nav_menu_button_icon;
                                                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                                                        i = R.id.tasks_nav_menu_button_text;
                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                            i = R.id.text_buy_az_coins;
                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                i = R.id.text_buy_battle_points;
                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                if (textView14 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.welcome_price_1))) != null) {
                                                                                                                                                                                                                                    WinterBattlepassRouletteOldPriseItemWelcomeBinding bind9 = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById3);
                                                                                                                                                                                                                                    i = R.id.welcome_price_2;
                                                                                                                                                                                                                                    View findChildViewById11 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                    if (findChildViewById11 != null) {
                                                                                                                                                                                                                                        WinterBattlepassRouletteOldPriseItemWelcomeBinding bind10 = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById11);
                                                                                                                                                                                                                                        i = R.id.welcome_price_3;
                                                                                                                                                                                                                                        View findChildViewById12 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                        if (findChildViewById12 != null) {
                                                                                                                                                                                                                                            WinterBattlepassRouletteOldPriseItemWelcomeBinding bind11 = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById12);
                                                                                                                                                                                                                                            i = R.id.winter_battlepass_welcome;
                                                                                                                                                                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                                                            if (constraintLayout4 != null) {
                                                                                                                                                                                                                                                return new WinterBattlepassLayoutBinding(constraintLayout2, imageView, imageView2, constraintLayout, constraintLayout2, constraintLayout3, imageView3, bind, bind2, bind3, bind4, bind5, bind6, bind7, bind8, imageView4, button, imageView5, imageView6, linearLayout, linearLayout2, linearLayout3, imageView7, linearLayout4, textView, findChildViewById2, textView2, linearLayout5, imageView8, textView3, linearLayout6, imageView9, textView4, linearLayout7, recyclerView, textView5, imageView10, imageView11, textView6, linearLayout8, imageView12, textView7, linearLayout9, linearLayout10, textView8, linearProgressIndicator, linearLayout11, textView9, linearLayout12, imageView13, textView10, linearLayout13, imageView14, textView11, linearLayout14, imageView15, textView12, textView13, textView14, bind9, bind10, bind11, constraintLayout4);
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
